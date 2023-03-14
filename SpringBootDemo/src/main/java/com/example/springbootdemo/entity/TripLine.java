package com.example.springbootdemo.entity;

import java.io.Serializable;

public class TripLine extends BaseEntity implements Serializable {

    private Long id;
    private String xianlubianhao;
    private String xianlumingcheng;
    private String tupian;
    private String chufadi;
    private String tujingdi;
    private String zhongdian;
    private Double jiage;
    private Integer liulanliang;
    private String xianlutese;
    private String xianlujianjie;
    private String addtime;
    private String image1;
    private String image2;
    

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXianlubianhao() {
        return xianlubianhao;
    }

    public void setXianlubianhao(String xianlubianhao) {
        this.xianlubianhao = xianlubianhao;
    }

    public String getXianlumingcheng() {
        return xianlumingcheng;
    }

    public void setXianlumingcheng(String xianlumingcheng) {
        this.xianlumingcheng = xianlumingcheng;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getChufadi() {
        return chufadi;
    }

    public void setChufadi(String chufadi) {
        this.chufadi = chufadi;
    }

    public String getTujingdi() {
        return tujingdi;
    }

    public void setTujingdi(String tujingdi) {
        this.tujingdi = tujingdi;
    }

    public String getZhongdian() {
        return zhongdian;
    }

    public void setZhongdian(String zhongdian) {
        this.zhongdian = zhongdian;
    }

    public Double getJiage() {
        return jiage;
    }

    public void setJiage(Double jiage) {
        this.jiage = jiage;
    }

    public Integer getLiulanliang() {
        return liulanliang;
    }

    public void setLiulanliang(Integer liulanliang) {
        this.liulanliang = liulanliang;
    }

    public String getXianlutese() {
        return xianlutese;
    }

    public void setXianlutese(String xianlutese) {
        this.xianlutese = xianlutese;
    }

    public String getXianlujianjie() {
        return xianlujianjie;
    }

    public void setXianlujianjie(String xianlujianjie) {
        this.xianlujianjie = xianlujianjie;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

}
