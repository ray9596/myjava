package com.ray.test3.monkeatbun;

public class monk extends Thread {
    private String mname ;
    private bun b ;

    public static int MIN = 1;
    public static int MAX = 4;

    public int count = 0;
    public monk(String mname , bun b ){
        this.mname = mname;
        this.b = b;
    }

    @Override
    public void run() {
        while (true){
            //返回吃的是第几个馒头
            int no = b.reduce(this);
            if(no == -1){
                break;
            }else {
                count++;
                //System.out.println(this.mname+".eat"+no);
            }
        }
        System.out.println(mname + ".eat" + count);

    }
}
