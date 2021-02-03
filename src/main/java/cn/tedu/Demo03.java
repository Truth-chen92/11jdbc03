package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;

public class Demo03 {
    public static void main(String[] args) throws Exception{
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        ds.setUsername("root");
        ds.setPassword("truth");
//        设置初始连接数量
        ds.setInitialSize(3);
//        设置最大链接数量
        ds.setMaxActive(5);
        Connection conn =ds.getConnection();
        System.out.println(conn);

    }
}
