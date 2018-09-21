package com.ray.test6.jdbcpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class ConnectionPool {
    private static ConnectionPool instance;
    private LinkedList<Connection> idles = new LinkedList<>();
    private LinkedList<Connection> busies = new LinkedList<>();

    private static int MAX = 3;
    private static int MIN = 2;

    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/big11";

    private ConnectionPool() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            initPool();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    初始化连接池,最少为MIN
     */
    private void initPool() {
        for(int i = 0 ; i < MIN ; i++) {
            Connection conn = openNewConnection();
            idles.add(conn);
        }
    }
    /*
        建立自己重写的连接
     */
    private Connection openNewConnection() {
        try {
            Connection conn = DriverManager.getConnection(url,user, pass);
            return new MyConnection(conn , this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        单例对象
     */
    public static ConnectionPool getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (ConnectionPool.class) {
            if (instance == null) {
                instance = new ConnectionPool();
            }
        }
        return instance;
    }
    /*
        用完返回连接池
     */
    public synchronized void backToPool(MyConnection myConnection) {
        busies.remove(myConnection);
        idles.add(myConnection);
        this.notifyAll();
    }
    /*
       重池子中获取连接
     */
    public synchronized Connection getConnection() {
        //有可用连接
        if(!idles.isEmpty()){
            Connection conn = idles.remove(0);
            busies.add(conn);
            return  conn;
        }
        //忙的池子没满
        if(busies.size() < MAX){
            Connection conn = openNewConnection();
            busies.add(conn);
            return conn;
        }
        while(idles.isEmpty()){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Connection conn = idles.remove(0);
        busies.add(conn);
        return conn;
    }
}
