package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的页数");
        int page = sc.nextInt();
        System.out.println("请输入查询的条数");
        int count = sc.nextInt();
        try (Connection conn = DBUtils.getConn()) {
            if (page <= 0 || count <= 0) {
                System.out.println("输入错误！");
                return;
            }
            String sql = "select * from user limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * count);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
