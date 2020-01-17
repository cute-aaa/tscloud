package com.tscloud.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContainerService {

    @Autowired
    ContainerMapper mapper;

    public List<Container> getContainerByUserID(Integer id) {
        return mapper.getContainersByUserID(id);
    }

    public void createContainer(Integer owner, String containerName) {
        Container container = new Container(owner, containerName, new Date(), new Date());
        //TODO 创建容器，失败抛出异常
        mapper.createContainer(container);
        System.out.println(owner + "创建了容器" + containerName);
    }

    public void deleteContainer(Integer id) {
        mapper.deleteContainer(id);
    }

    public void updateContainerInfo(Container container) {
        mapper.updateContainerInfo(container);
    }

    public void updateContainerName(Integer id, String newName) {
        mapper.updateContainerName(id, newName);
    }

    public void runContainer(Integer cid) {
        mapper.touchContainer(cid, new Date());
        //TODO 运行容器，失败抛出异常
        System.out.println("运行了" + cid);
    }
}

