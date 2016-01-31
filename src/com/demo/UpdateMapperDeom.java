package com.demo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yjj.domain.Student;
import com.yjj.mapper.StudentMapper;

public class UpdateMapperDeom {
private static SqlSessionFactory factory = null;
	
	//静态代码块，在类被初始化的时候执行，比如说第一次引用类的静态变量，
	//或者创建类的第一个实例的时候
	static{
		String resource = "mybatis-config.xml";
		try {
			//读取主配置文件
			Reader reader = Resources.getResourceAsReader(resource);
			//创建SqlSessionFactory对象
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SqlSession session = factory.openSession();
		Student student = null;
		int count = 0;
	
			try {
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				student = studentMapper.getById(8);
				student.setName("成功");
				student.setGrade("2011");
				count = studentMapper.update(student);
				
				//提交事务,否则不会修改数据库中的数据
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
//	保证不管有没有发生异常，SqlSession实例都能被关闭，以释放它占用的资源			
			session.close();
			}
			System.out.println("修改了"+count+"行。");
	}
}


