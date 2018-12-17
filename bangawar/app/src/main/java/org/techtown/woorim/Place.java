package org.techtown.woorim;

public class Place {
    String placeName = ""; // 이름
    String placeAddr = ""; // 주소
    String placeTime = ""; // 시간
    String placeNumber = ""; // 전화번호
    String placeUrl = ""; // 이미지
    String placeIntro = ""; // 소개
    String placeRegion = ""; // 지역별
    String placeCategory = ""; // 장소별
    String placeMenu = ""; // 메뉴

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddr() {
        return placeAddr;
    }

    public void setPlaceAddr(String placeAddr) {
        this.placeAddr = placeAddr;
    }

    public String getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(String placeTime) {
        this.placeTime = placeTime;
    }

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getPlaceUrl() {
        return placeUrl;
    }

    public void setPlaceUrl(String placeUrl) {
        this.placeUrl = placeUrl;
    }

    public String getPlaceIntro() {
        return placeIntro;
    }

    public void setPlaceIntro(String placeIntro) {
        this.placeIntro = placeIntro;
    }

    public String getPlaceRegion() {
        return placeRegion;
    }

    public void setPlaceRegion(String placeRegion) {
        this.placeRegion = placeRegion;
    }

    public String getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(String placeCategory) {
        this.placeCategory = placeCategory;
    }

    public String getPlaceMenu() {
        return placeMenu;
    }

    public void setPlaceMenu(String placeMenu) {
        this.placeMenu = placeMenu;
    }

    public Place(String placeName, String placeAddr, String placeTime, String placeNumber, String placeUrl, String placeIntro, String placeRegion, String placeCategory, String placeMenu) {
        this.placeName = placeName;
        this.placeAddr = placeAddr;
        this.placeTime = placeTime;
        this.placeNumber = placeNumber;
        this.placeUrl = placeUrl;
        this.placeIntro = placeIntro;
        this.placeRegion = placeRegion;
        this.placeCategory = placeCategory;
        this.placeMenu = placeMenu;
    }
}