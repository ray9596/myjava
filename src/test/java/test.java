import com.ray.test07.zuoye.A;

public class test {
    public static void main(String[] args) {
        Class<?>[] it = A.class.getInterfaces();
        for(int i = 0 ;i < it.length ;i++){
            System.out.println(it[i].getName());
        }
        int[] a = {};


    }

    }
