package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo02 {
    public static void main(String[] args) throws IOException {
//        创建读取配置文件的对象
        Properties p=new Properties();
//        得到文件输入流
//        会自动查找resources目录下的资源文件并返回输入流
        InputStream ips=Demo02.class.getClassLoader().getResourceAsStream("my.properties");
//        让文件和读取配置文件的对象建立关系
        p.load(ips);
//        开始读取配置文件中的数据
        String name=p.getProperty("name");
        String age=p.getProperty("age");
        System.out.println(name+age);
    }
}
