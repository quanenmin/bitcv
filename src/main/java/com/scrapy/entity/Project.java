package com.scrapy.entity;

import java.util.Date;

public class Project {
    private Integer id;

    private String nameCn;

    private String nameEn;

    private String shortDesc;

    private String logoUrl;

    private String bannerUrl;

    private String abstractInfo;

    private String whitePaperUrl;

    private String homeUrl;

    private Integer viewTimes;

    private Integer tokenId;

    private String planAmount;

    private String nodeAmount;

    private String curAmount;

    private Byte status;

    private Date foundDate;

    private Integer adminId;

    private Integer region;

    private Byte buzType;

    private Byte stage;

    private Byte fundStage;

    private Date fundStartTime;

    private Date fundEndTime;

    private String companyEmail;

    private String companyAddr;

    private Date createdAt;

    private Date updatedAt;

    private String walletAddr;

    private Integer walletId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc == null ? null : shortDesc.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public String getWhitePaperUrl() {
        return whitePaperUrl;
    }

    public void setWhitePaperUrl(String whitePaperUrl) {
        this.whitePaperUrl = whitePaperUrl == null ? null : whitePaperUrl.trim();
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl == null ? null : homeUrl.trim();
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(String planAmount) {
        this.planAmount = planAmount == null ? null : planAmount.trim();
    }

    public String getNodeAmount() {
        return nodeAmount;
    }

    public void setNodeAmount(String nodeAmount) {
        this.nodeAmount = nodeAmount == null ? null : nodeAmount.trim();
    }

    public String getCurAmount() {
        return curAmount;
    }

    public void setCurAmount(String curAmount) {
        this.curAmount = curAmount == null ? null : curAmount.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Date foundDate) {
        this.foundDate = foundDate;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Byte getBuzType() {
        return buzType;
    }

    public void setBuzType(Byte buzType) {
        this.buzType = buzType;
    }

    public Byte getStage() {
        return stage;
    }

    public void setStage(Byte stage) {
        this.stage = stage;
    }

    public Byte getFundStage() {
        return fundStage;
    }

    public void setFundStage(Byte fundStage) {
        this.fundStage = fundStage;
    }

    public Date getFundStartTime() {
        return fundStartTime;
    }

    public void setFundStartTime(Date fundStartTime) {
        this.fundStartTime = fundStartTime;
    }

    public Date getFundEndTime() {
        return fundEndTime;
    }

    public void setFundEndTime(Date fundEndTime) {
        this.fundEndTime = fundEndTime;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail == null ? null : companyEmail.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWalletAddr() {
        return walletAddr;
    }

    public void setWalletAddr(String walletAddr) {
        this.walletAddr = walletAddr == null ? null : walletAddr.trim();
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }
}