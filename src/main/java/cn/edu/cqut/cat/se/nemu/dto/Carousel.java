package cn.edu.cqut.cat.se.nemu.dto;

public class Carousel {
    private String image;
    private String color;

    public Carousel() {
    }

    public Carousel(String image, String color) {
        this.image = image;
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
