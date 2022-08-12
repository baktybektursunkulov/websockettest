package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "websocket")
public class WebSocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    public String getContent() {return content;}

    public void setContent(String content) {  this.content = content;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
