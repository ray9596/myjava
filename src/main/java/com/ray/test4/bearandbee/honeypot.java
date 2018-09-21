package com.ray.test4.bearandbee;

public class honeypot {
    private final int MAX = 30;
    private int count = 0;


    public synchronized void  addhoney(int honeynum , String beename){
        while( (count < 30 && honeynum >0) ){
            if( (count+honeynum) <= 30){
                count = count + honeynum;
                System.out.println(beename + ".addhoney" + count);
                honeynum = 0;
            }else {
                honeynum = count+honeynum - 30;
                count = 30;
                System.out.println(beename + ".addhoney" + count);
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
    public synchronized void removehoney(String bname){
        if(count >= 20){
           count = 0;
            System.out.println(bname + ".removehoney" + count);
           this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
