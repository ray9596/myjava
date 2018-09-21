package com.ray.test3.monkeatbun;

public class App {
    public static void main(String[] args) {
        bun bun = new bun();
        for(int i = 1; i<=30;i++){
            new monk("monk"+i,bun).start();
        }
    }
}
