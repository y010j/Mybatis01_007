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

public class DelMapperDeom {
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
		int count = 0;
	
			try {
				StudentMapper studentMapper = session.getMapper(StudentMapper.class);
				count = studentMapper.delById(10);
				
				//�ύ����,���򲻻��޸����ݿ��е�����
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
//	��֤������û�з����쳣��SqlSessionʵ�����ܱ��رգ����ͷ���ռ�õ���Դ			
			session.close();
			}
			System.out.println("ɾ����"+count+"�С�");
	}
}


