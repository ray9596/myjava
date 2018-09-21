package com.ray.test2;

public class zPerson extends Person{
    private int height = 0;
    private int weight = 0;
    private int age = 0;
    private int blood  = 0;

    public zPerson(){

    }
    public zPerson(int height, int weight, int age, int blood) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.blood = blood;
    }

    @Override
    public boolean equals(Object o) {

        return true;
    }
    //编写hashcode
    @Override
    public int hashCode() {
/*        byte h = (byte) (height );
        byte w = (byte) (weight );
        byte a = (byte) (age  );
        byte b = (byte) (blood );*/
        int hash = ((height & 0xff ) <<24) |( (weight & 0xff ) << 16)|(( age & 0xff ) << 8)|(blood & 0xff);
        return hash;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "zPerson{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", blood=" + blood +
                '}';
    }
}
