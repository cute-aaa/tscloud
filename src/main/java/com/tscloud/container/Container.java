package com.tscloud.container;

import java.util.Date;

public class Container {

    private Integer id;
    private Integer owner;
    private String name;
    private Date creationtime;
    private Date lastruntime;

    public Container(Integer owner, String name, Date creationTime, Date lastRunTime) {
        this.owner = owner;
        this.name = name;
        this.creationtime = creationTime;
        this.lastruntime = lastRunTime;
    }

    public Container(Integer id, Integer owner, String name, Date creationtime, Date lastruntime) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.creationtime = creationtime;
        this.lastruntime = lastruntime;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", creationTime=" + creationtime +
                ", lastRunTime=" + lastruntime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationTime) {
        this.creationtime = creationTime;
    }

    public Date getLastruntime() {
        return lastruntime;
    }

    public void setLastruntime(Date lastRunTime) {
        this.lastruntime = lastRunTime;
    }
}
