package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

public class Demo06 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()) {
            String sql1 = "insert into user values(null,'aaa','aaa')";
            String sql2 = "insert into user values(null,'bbb','bbb')";
            String sql3 = "insert into user values(null,'ccc','ccc')";
            Statement s=conn.createStatement();
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            s.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
