package com.itheima.pojo;

import java.util.List;

public class EventData {
    private User user;
    private List<Event> events;

    // setUser 方法用于设置用户信息
    public void setUser(User user) {
        this.user = user;
    }

    // setEvent 方法用于设置事件信息
    public void setEvent(Event event) {
        this.events.add(event);
    }

    public void setEvent(List<Event> event) {
        this.events=event;
    }





    // 可选：如果需要获取用户信息或事件信息，可以添加相应的 getter 方法
    public User getUser() {
        return user;
    }

    public List<Event> getEvent() {
        return events;
    }
}
