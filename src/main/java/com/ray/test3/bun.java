package com.ray.test3;

import java.util.HashSet;
import java.util.Set;

public class bun {
    private int num = 100;
    Set m = new HashSet<String>();


    public synchronized void eat(String mname) {
        m.add(mname);
        if (num > 0 && ( num > (30 - m.size())) ) {
            System.out.println(mname + ".eat()"+num);
            num--;
        }else {
            try {
                this.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
