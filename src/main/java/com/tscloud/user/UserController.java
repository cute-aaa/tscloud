package com.tscloud.user;

import com.tscloud.container.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContainerService containerService;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "login";
    }

    @ResponseBody
    @PostMapping("/checkUser")
    public short checkUser(String username, String password, HttpSession session) {
        User user = userService.checkUser(username, password);
        if (user == null) {
            return 0;   //0表示用户不存在
        } else if (!user.getPassword().equals(password)) {
            return -1;  //-1表示密码错误
        } else {
            session.setAttribute("uid", user.getId());
            return 1;   //1表示成功
        }
    }

    @GetMapping("/mainPage")
    public String mainPage(HttpSession session, Model model) {
        if (session.getAttribute("uid") == null) {
            return "login";
        }
        Integer uid = (Integer) session.getAttribute("uid");
        model.addAttribute("containerList", containerService.getContainerByUserID(uid));
        return "mainPage";
    }

    @ResponseBody
    @PostMapping("/createContainer")
    public boolean createContainer(HttpSession session, String containerName) {
        try {
            //TODO 在这里创建容器，如果ID可以从k8s那里获取就使用带ID的容器的构造函数
            //TODO 如何通过ID获取noVNC链接？
            containerService.createContainer((Integer) session.getAttribute("uid"), containerName);
            return true;
        }catch (Exception e){
            System.out.println(containerName + "创建失败");
            e.printStackTrace();
            return false;
        }
    }

    @ResponseBody
    @PostMapping("/runContainer")
    public boolean runContainer(Integer containerId) {
        System.out.println(containerId);
        try {
            //TODO 如果使用noVNC，就把链接放在一个数组内，在前端使用thymeleaf获取链接
            containerService.runContainer(containerId);
            return true;
        }catch (Exception e){
            System.out.println(containerId + "启动失败");
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/runPage")
    public String runPage() {
        return "runPage";
    }
}
