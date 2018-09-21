package com.ray.test6.jdbcpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyDataSourceApp {
    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        final MyDataSource ds = new MyDataSource();
        for(i = 0 ; i < 4;i++){
            new Thread(){
                public void run() {
                    try {
                        int ii = i;
                        Connection conn = ds.getConnection();
                        String sql = "insert into user(name , age) values(?,?)";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1,"tom"+ii);
                        statement.setInt(2,23+ii);
                        statement.executeUpdate();
                        statement.close();
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
            //Thread.sleep(10);
            Thread.sleep(5);
        }

    }
}
