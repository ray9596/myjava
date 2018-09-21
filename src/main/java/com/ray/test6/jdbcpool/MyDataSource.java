package com.ray.test6.jdbcpool;

import java.sql.Connection;
import java.sql.SQLException;
/*
    自定义数据源
 */
public class MyDataSource extends MyDataSourceAdaptor{
    private ConnectionPool pool;
    public MyDataSource(){
        pool = ConnectionPool.getInstance();
    }
    @Override
    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }
}
