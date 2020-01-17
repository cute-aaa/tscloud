package com.tscloud.container;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Mapper
@Component
@Transactional
public interface ContainerMapper {

    @Select("select * from containers where owner=#{id}")
    public List<Container> getContainersByUserID(Integer id);

    @Insert("insert into containers(owner, name, creationtime, lastruntime) values(#{owner}, #{name}, #{creationtime}, #{lastruntime})")
    public void createContainer(Container container);

    @Delete("delete from containers where id = #{id}")
    public void deleteContainer(Integer id);

    @Update("update containers set owner=#{owner}, name=#{name}, creationtime=#{creationtime}, lastruntime=#{lastruntime} where id=#{id}")
    public void updateContainerInfo(Container container);

    @Update("update containers set name=#{name} where id=#{id}")
    public void updateContainerName(Integer id, String name);

    @Update("update containers set lastruntime=#{date} where id=#{id}")
    public void touchContainer(Integer id, Date date);
}
