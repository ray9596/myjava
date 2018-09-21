package com.ray.test2;

public class zPerson2 {
    private int height = 0;
    private int weight = 0;
    private String age = "moren";
    private boolean blood = true;
    private String name ;
    static {
        System.out.println("loading zperson2!!!!!!!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public zPerson2(){

    }

    public zPerson2(int height, int weight, String age, boolean blood) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "zPerson2{" +
                "height=" + height +
                ", weight=" + weight +
                ", age='" + age + '\'' +
                ", blood=" + blood +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        return true;
    }
    //编写hashcode
/*
    @Override
    public int hashCode() {
*/
/*        byte h = (byte) (height );
        byte w = (byte) (weight );
        byte a = (byte) (age  );
        byte b = (byte) (blood );*//*

        int hash = ((height & 0xff ) <<24) |( (weight & 0xff ) << 16)|(( age & 0xff ) << 8)|(blood & 0xff);
        return hash;
    }
*/

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isBlood() {
        return blood;
    }

    public void setBlood(boolean blood) {
        this.blood = blood;
    }
}
