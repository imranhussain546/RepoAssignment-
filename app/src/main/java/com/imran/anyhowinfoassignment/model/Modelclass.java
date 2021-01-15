package com.imran.anyhowinfoassignment.model;

public class Modelclass
{
    private int image;
    private String productname;
    private String getProductprice;

    public Modelclass(int image, String productname, String getProductprice) {
        this.image = image;
        this.productname = productname;
        this.getProductprice = getProductprice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getGetProductprice() {
        return getProductprice;
    }

    public void setGetProductprice(String getProductprice) {
        this.getProductprice = getProductprice;
    }
}
