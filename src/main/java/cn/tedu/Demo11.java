package cn.tedu;

import java.sql.*;

public class Demo11 {
    public static void main(String[] args) {
        try (Connection conn=DBUtils.getConn()){
//            得到数据库元数据对象
            DatabaseMetaData dmd=conn.getMetaData();
            System.out.println("数据库名称"+dmd.getDatabaseProductName());
            System.out.println("数据库连接地址"+dmd.getURL());
            System.out.println("数据库驱动名"+dmd.getDriverName());
            System.out.println("数据库驱动版本"+dmd.getDatabaseProductName());

            String sql="select * from emp" ;
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            ResultSetMetaData rsmd=rs.getMetaData();
            int count =rsmd.getColumnCount();
            for (int i=0;i<count;i++){
                String name=rsmd.getColumnName(i+1);
                String type=rsmd.getColumnTypeName(i+1);
                System.out.println(name+":"+type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
