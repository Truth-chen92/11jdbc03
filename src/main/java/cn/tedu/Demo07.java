package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo07 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()) {
            String sql="insert into user values(null,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            for (int i=1;i<=100;i++){
                ps.setString(1,"名字"+i);
                ps.setString(2,"密码"+i);
                ps.addBatch();
//                为了避免内存溢出 每20次批量执行一次
                if(i%20==0) ps.executeBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
