package com.colinsystem.listener;

import com.alibaba.druid.pool.DruidDataSource;
import com.colinsystem.util.DruidUtil;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Druid关闭
 * 在JavaWEB项目中，使用了Druid数据库连接池会导致在项目关闭的时候报错。
 * 即便这个报错可以忽略，但是有必要对于产生错误的问题进行正确的处理。
 * 遂编写此监听器以实现在Servlet容器关闭前卸载驱动，来避免错误问题的发生。
 * @author FrancisGaozhu
 */
@WebListener("cancelDruidListener")
public class CancelDruid implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        final DruidDataSource dataSource = (DruidDataSource) DruidUtil.getDataSource();
        dataSource.close();
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
