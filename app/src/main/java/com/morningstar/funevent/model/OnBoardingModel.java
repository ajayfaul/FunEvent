package com.morningstar.funevent.model;

public class OnBoardingModel  {
    String Title,Description;
    int OnBoardingImg;

    public OnBoardingModel(String title, String description, int screenImg) {
        Title = title;
        Description = description;
        OnBoardingImg = screenImg;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getOnBoardingImg() {
        return OnBoardingImg;
    }

    public void setOnBoardingImg(int onBoardingImg) {
        OnBoardingImg = onBoardingImg;
    }
}
