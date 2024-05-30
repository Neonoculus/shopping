package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtil {

    private static DataSource ds ;

    static {

        try {
            //1.加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
            System.out.println(ds);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection()
    {
        Connection con = null;

        try {
            con = ds.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return con;

    }
    /**
     * * 释放JDBC相关资源
     * @param rs
     * @param st
     * @param conn
     */
    public static void release(ResultSet rs, Statement st, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection();
        //获取数据
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from category");// 执行SQL查询
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("编号：" + id + ", 类别：" + name);
        }

        //释放连接资源
        DBUtil.release(rs, st, conn);
    }

}
