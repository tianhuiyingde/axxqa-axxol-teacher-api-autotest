package com.axxqa.axxol.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {//读取数据库

    //读取测试用例数据库配置
    public static SqlSession getTestCaseSqlSession()throws IOException{
        //获取配置的资源文件
        Reader reader=Resources.getResourceAsReader("DBConfigTestCase.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession=factory.openSession();
        return sqlSession;
    }
    //读取业务数据库配置
    public static SqlSession getBusinessSqlSession()throws IOException{
        Reader reader=Resources.getResourceAsReader("DBConfigBusiness.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession=factory.openSession();
        return sqlSession;
    }

}
