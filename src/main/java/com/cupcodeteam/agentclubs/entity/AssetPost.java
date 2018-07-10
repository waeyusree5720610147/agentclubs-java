package com.cupcodeteam.agentclubs.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset_post")
public class AssetPost {
    private Integer id;
    private String assetName;
    private String annouceTo;
    private String assetTye;
    private String assetPrice;
    private String rai;
    private String ngan;
    private String taranwa;
    private String road;
    private String alley;
    private String park;
    private String cangwat;
    private String ampor;
    private String tambun;
    private String mLat;
    private String mLng;
    private String description;

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
    @Column(name = "asset_name")
    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @Basic
    @Column(name = "announce_to")
    public String getAnnouceTo() {
        return annouceTo;
    }

    public void setAnnouceTo(String annouceTo) {
        this.annouceTo = annouceTo;
    }

    @Basic
    @Column(name = "asset_tye")
    public String getAssetTye() {
        return assetTye;
    }

    public void setAssetTye(String assetTye) {
        this.assetTye = assetTye;
    }

    @Basic
    @Column(name = "asset_price")
    public String getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(String assetPrice) {
        this.assetPrice = assetPrice;
    }

    @Basic
    @Column(name = "rai")
    public String getRai() {
        return rai;
    }

    public void setRai(String rai) {
        this.rai = rai;
    }

    @Basic
    @Column(name = "ngan")
    public String getNgan() {
        return ngan;
    }

    public void setNgan(String ngan) {
        this.ngan = ngan;
    }

    @Basic
    @Column(name = "taranwa")
    public String getTaranwa() {
        return taranwa;
    }

    public void setTaranwa(String taranwa) {
        this.taranwa = taranwa;
    }

    @Basic
    @Column(name ="road")
    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    @Basic
    @Column(name = "alley")
    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    @Basic
    @Column(name = "park")
    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    @Basic
    @Column(name = "cangwat")
    public String getCangwat() {
        return cangwat;
    }

    public void setCangwat(String cangwat) {
        this.cangwat = cangwat;
    }

    @Basic
    @Column(name = "ampor")
    public String getAmpor() {
        return ampor;
    }

    public void setAmpor(String ampor) {
        this.ampor = ampor;
    }

    @Basic
    @Column(name = "tambun")
    public String getTambun() {
        return tambun;
    }

    public void setTambun(String tambun) {
        this.tambun = tambun;
    }

    @Basic
    @Column(name = "m_lat")
    public String getmLat() {
        return mLat;
    }

    public void setmLat(String mLat) {
        this.mLat = mLat;
    }

    @Basic
    @Column(name = "m_lng")
    public String getmLng() {
        return mLng;
    }

    public void setmLng(String mLng) {
        this.mLng = mLng;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
