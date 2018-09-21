package com.ray.test4.sellticket;

public class seller extends Thread {
    private String name;
    private picket picket;
    private picket2 picket2;
    public seller(String name , picket2 picket2){
        this.name = name;
        this.picket2 = picket2;
    }
    public seller(String name , picket picket){
        this.name = name;
        this.picket = picket;
    }

    @Override
    public void run() {
        while(true){
            //picket.reduce(name);
            if(picket2.count == 0 ) {
                return;
            }
            picket2.reduce(name);
        }

    }
}
