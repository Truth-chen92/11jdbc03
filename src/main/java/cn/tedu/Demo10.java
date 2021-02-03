package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名称");
        String teamname = sc.nextLine();
        System.out.println("请输入球员名称");
        String playername = sc.nextLine();
        try (Connection conn = DBUtils.getConn()) {
            String sql="insert into team values(null,?)";
            PreparedStatement ps1=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1,teamname);
            ps1.executeUpdate();
            ResultSet rs=ps1.getGeneratedKeys();
            rs.next();
            int id=rs.getInt(1);
            String sql1="insert into player values(null,?,?)";
            PreparedStatement ps2 = conn.prepareStatement(sql1);
            ps2.setString(1,playername);
            ps2.setInt(2,id);
            ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
