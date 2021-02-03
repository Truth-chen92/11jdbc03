package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String usame = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try(Connection conn=DBUtils.getConn()){
//            Statement s =conn.createStatement();
//            String sql="select id from user where username='"+username+"' and password='"+password+"'";
//            System.out.println(sql);
//            ResultSet rs= s.executeQuery(sql);
//            预编译解决SQL注入
            String sql="select id from user where username=? and password=?";
//            创建预编译的SQL执行对象
//            创建QLA执行对象时就对SQL语句进行了编译，此时将SQL语句锁死，这样就不会被用户输入的内容影响
            PreparedStatement ps=conn.prepareStatement(sql);
//            替换SQL语句中的？内容
            ps.setString(1,usame);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
