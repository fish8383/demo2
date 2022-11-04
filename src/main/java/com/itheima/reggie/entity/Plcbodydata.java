package com.itheima.reggie.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Plcbodydata {

    private int id;
    private String tag;
    private String type;
    private String source;
    private String userrights;
    private String quality;
    private String rb;
    private String plc;
    private String bodytype;
    private String platform;
    private String color;
    private String codea;
    private String codeb;
    private String codef;
    private String ordertype;
    private String vin;
    private String value;
    private String purpose;
    private String discription;
    private String username;
    private Date usedtime;
    private Date ts;

    public Plcbodydata() {
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserRights() {
        return userrights;
    }

    public void setUserRights(String userRights) {
        this.userrights = userRights;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getRb() {
        return rb;
    }

    public void setRb(String rb) {
        this.rb = rb;
    }

    public String getPlc() {
        return plc;
    }

    public void setPlc(String plc) {
        this.plc = plc;
    }

    public String getBodytype() {
        return bodytype;
    }

    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodea() {
        return codea;
    }

    public void setCodea(String codea) {
        this.codea = codea;
    }

    public String getCodeb() {
        return codeb;
    }

    public void setCodeb(String codeb) {
        this.codeb = codeb;
    }

    public String getCodef() {
        return codef;
    }

    public void setCodef(String codef) {
        this.codef = codef;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUsedTime() {
        return usedtime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedtime = usedTime;
    }

    @Override
    public String toString() {
        return "Plcbodydata{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", userRights='" + userrights + '\'' +
                ", quality='" + quality + '\'' +
                ", rb='" + rb + '\'' +
                ", plc='" + plc + '\'' +
                ", bodytype='" + bodytype + '\'' +
                ", platform='" + platform + '\'' +
                ", color='" + color + '\'' +
                ", codea='" + codea + '\'' +
                ", codeb='" + codeb + '\'' +
                ", codef='" + codef + '\'' +
                ", ordertype='" + ordertype + '\'' +
                ", vin='" + vin + '\'' +
                ", value='" + value + '\'' +
                ", purpose='" + purpose + '\'' +
                ", discription='" + discription + '\'' +
                ", username='" + username + '\'' +
                ", usedTime=" + usedtime +
                ", ts=" + ts +
                '}';
    }
}
