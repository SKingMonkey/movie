package com.sun.movie.dal.model;

import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Service
public class MahoutModel {
    @Autowired
    private DataSource dataSource;

    public JDBCDataModel getMahoutModel() {
        JDBCDataModel dataModel = null;
        try {
            ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(dataSource);
            dataModel = new MySQLJDBCDataModel(connectionPool, "movie_preference", "user_id", "movie_id", "preference", "timestamp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataModel;
    }
}
