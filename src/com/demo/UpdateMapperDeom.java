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
	
	//��̬����飬���౻��ʼ����ʱ��ִ�У�����˵��һ��������ľ�̬������
	//���ߴ�����ĵ�һ��ʵ����ʱ��
	static{
		String resource = "mybatis-config.xml";
		try {
			//��ȡ�������ļ�
			Reader reader = Resources.getResourceAsReader(resource);
			//����SqlSessionFactory����
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
				student.setName("�ɹ�");
				student.setGrade("2011");
				count = studentMapper.update(student);
				
				//�ύ����,���򲻻��޸����ݿ��е�����
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
//	��֤������û�з����쳣��SqlSessionʵ�����ܱ��رգ����ͷ���ռ�õ���Դ			
			session.close();
			}
			System.out.println("�޸���"+count+"�С�");
	}
}


