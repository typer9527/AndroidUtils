package com.yl.androidutils.utils.entity;

/**
 * Banner Pojo
 */
public class BannerInfoEntity {

    private int mId;            //id
    private String mImgUrl;     //图片的url
    private String mLinkType;   //链接的类型
    private String mLinkUrl;    //链接的web地址
    private String mTitle;      //标题

    public BannerInfoEntity(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public BannerInfoEntity(int mId) {
        this.mId = mId;
    }

    public BannerInfoEntity(String mImgUrl, String mLinkUrl) {
        this.mImgUrl = mImgUrl;
        this.mLinkUrl = mLinkUrl;
    }

    public BannerInfoEntity(String mImgUrl, String mLinkType, String mLinkUrl) {
        this.mImgUrl = mImgUrl;
        this.mLinkType = mLinkType;
        this.mLinkUrl = mLinkUrl;
    }

    public BannerInfoEntity(int mId, String mImgUrl, String mLinkType, String mLinkUrl, String mTitle) {
        this.mId = mId;
        this.mImgUrl = mImgUrl;
        this.mLinkType = mLinkType;
        this.mLinkUrl = mLinkUrl;
        this.mTitle = mTitle;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public String getmLinkType() {
        return mLinkType;
    }

    public void setmLinkType(String mLinkType) {
        this.mLinkType = mLinkType;
    }

    public String getmLinkUrl() {
        return mLinkUrl;
    }

    public void setmLinkUrl(String mLinkUrl) {
        this.mLinkUrl = mLinkUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
