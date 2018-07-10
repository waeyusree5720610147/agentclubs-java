package com.cupcodeteam.agentclubs.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    private Integer id;
    private String nameLastNamme;
    private String tel;
    private String lineId;
    private String expertZone;
    private String aboutYou;
    private String video;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_lastname")
    public String getNameLastNamme() {
        return nameLastNamme;
    }

    public void setNameLastNamme(String nameLastNamme) {
        this.nameLastNamme = nameLastNamme;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "line_id")
    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    @Basic
    @Column(name = "expert_zone")
    public String getExpertZone() {
        return expertZone;
    }

    public void setExpertZone(String expertZone) {
        this.expertZone = expertZone;
    }

    @Basic
    @Column(name = "about_you")
    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    @Basic
    @Column(name = "video")
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}

