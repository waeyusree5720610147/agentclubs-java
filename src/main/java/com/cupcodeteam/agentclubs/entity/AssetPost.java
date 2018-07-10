package com.cupcodeteam.agentclubs.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset_post")
public class AssetPost {
    private Integer id;
    private String selectetWebSite;
    private String assetType;
    private String assetName;
    private String assetPrice;
    private String areaOfAsset;
    private String assetImage;
    private String detailsOfAsset;
    private String assetArea;
    private String tel;

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
    @Column(name = "selectet_website")
    public String getSelectetWebSite() {
        return selectetWebSite;
    }

    public void setSelectetWebSite(String selectetWebSite) {
        this.selectetWebSite = selectetWebSite;
    }

    @Basic
    @Column(name = "asset_type")
    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
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
    @Column(name = "asset_price")
    public String getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(String assetPrice) {
        this.assetPrice = assetPrice;
    }

    @Basic
    @Column(name = "area_of_asset")
    public String getAreaOfAsset() {
        return areaOfAsset;
    }

    public void setAreaOfAsset(String areaOfAsset) {
        this.areaOfAsset = areaOfAsset;
    }

    @Basic
    @Column(name = "asset_image")
    public String getAssetImage() {
        return assetImage;
    }

    public void setAssetImage(String assetImage) {
        this.assetImage = assetImage;
    }

    @Basic
    @Column(name = "details_of_asset")
    public String getDetailsOfAsset() {
        return detailsOfAsset;
    }

    public void setDetailsOfAsset(String detailsOfAsset) {
        this.detailsOfAsset = detailsOfAsset;
    }

    @Basic
    @Column(name = "asset_area")
    public String getAssetArea() {
        return assetArea;
    }

    public void setAssetArea(String assetArea) {
        this.assetArea = assetArea;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
