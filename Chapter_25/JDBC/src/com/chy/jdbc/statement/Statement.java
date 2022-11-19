package com.chy.jdbc.statement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings({"all"})
//演示statement 的注入问题
public class Statement {
    public static void main(String[] args) throws Exception {

        //创建一个Scanner对象
        Scanner scanner = new Scanner(System.in);
        //提示用户输入用户名
        System.out.print("请输入管理员名：");
        //让用户输入管理员名和密码
        String admin_name = scanner.nextLine();
        //提示用户输入密码
        System.out.print("请输入管理员密码：");
        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1、注册驱动
        Class.forName(driver);
        //2、得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3、得到Statement
        java.sql.Statement statement = connection.createStatement();
        //4、组织SQL语句
        String sql = "select name, pwd from admin where name = '"+admin_name+"' and pwd = '"+admin_pwd+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("恭喜！登录成功");
        }else{
            System.out.println("对不起，登录失败");
        }

        //用户名
        //1' or
        //万能密码
        //or '1' = '1

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
