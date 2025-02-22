package org.vaadin.example;

public class CaracterSW {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String eye_color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setSkin_color(String skin_color) {
        this.eye_color = skin_color;
    }

    public CaracterSW(String name, String height, String mass, String hair_color, String skin_color) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.eye_color = skin_color;
    }
}
