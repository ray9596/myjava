package com.ray.test3;

public class monk extends Thread {
    private String mname;
    bun bun;
    int count = 0;

    public monk(String mname, bun bun) {
        this.mname = mname;
        this.bun = bun;
    }

    @Override
    public void run() {

        try {
            while(true){

            if (count < 4) {
                bun.eat(mname);
                count++;
            } else {
                this.finalize();
                break;
            }
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
