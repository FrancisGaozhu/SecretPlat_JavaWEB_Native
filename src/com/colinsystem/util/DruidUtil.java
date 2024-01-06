package com.colinsystem.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid数据库连接池工具类
 * @author FrancisGaozhu
 */
public class DruidUtil {

    /**
     * Druid数据源
     */
    private static final DataSource dataSource;
    static {
        Properties druidProperties = new Properties();
        try (InputStream inputStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties")) {
            druidProperties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(druidProperties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     * @return 数据库连接对象
     * @throws SQLException 数据库连接异常
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 获取数据源
     * @return Druid数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 使用一个新的连接直接完成数据更新操作，并且自动关闭连接
     * @param SQL       SQL
     * @param PARAMS    参数
     * @return          数据库中受影响数据行数
     */
    public static int doUpdate(final String SQL, final Object...PARAMS) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            for (int i = 0; i < PARAMS.length; i++) {
                preparedStatement.setObject(i + 1, PARAMS[i]);
            }
            return preparedStatement.executeUpdate();
        }
    }

    /**
     * 使用一个指定的连接完成数据库更新操作，操作完成之后不关闭连接
     * @param CONN      数据库连接对象
     * @param SQL       需要执行的SQL指令
     * @param PARAMS    SQL中动态参数
     * @return          受影响数据行数
     */
    public static int doUpdate(final Connection CONN, final String SQL, final Object...PARAMS) throws SQLException {
        try (PreparedStatement preparedStatement = CONN.prepareStatement(SQL)) {
            for (int i = 0; i < PARAMS.length; i++) {
                preparedStatement.setObject(i + 1, PARAMS[i]);
            }
            return preparedStatement.executeUpdate();
        }
    }

}
