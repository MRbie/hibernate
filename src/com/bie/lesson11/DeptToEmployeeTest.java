package com.bie.lesson11;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月21日 下午3:49:38 
* 
* 1：总结：在一对多与多对一的关联关系中，保存数据最好的是通过多的一方来维护关系，这样可以减少
* uodate语句的生成，从而提交hibernate的执行效率。
* 
* 2：配置一对多与多对一，这种叫做双向关联，或者叫做双向多对一或者一对多。
* 如果只配置一对多，这种叫做单向一对多。如果只配置多对一，这种叫做单向多对一。
* 注意：配置那一方，那一方才拥有维护关联关系的权限。
*/
public class DeptToEmployeeTest {

	//保存，部门方，一的一方维护
	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//HQL查询
		//注意：使用hql查询的时候auto-import="true"，要设置true.
		//如果是false，写hql的时候，要指定类的全名。
		/*Query query = session.createQuery("from Dept");
		List<Dept> list = query.list();
		for(Dept d : list){
			System.out.println(d.getDeptName());
		}*/
		
		//1:查询全部列
		//Query query2 = session.createQuery("from Dept");
		//Query query3 = session.createQuery("select d from Dept d ");
		
		
		//2:查询指定的列
		//Query query4 = session.createQuery("select d.deptName from Dept d ");
		
		
		//3:查询指定的列封装为对象。
		//查询指定的列，自动封装为对象，必须要提供带参数的构造器。
		//Query query5 = session.createQuery("select new Dept(deptId,deptName) from Dept d ");
		
		//4:条件查询操作，一个条件，多个条件。
		//条件查询，占位符查询
		/*Query query6 = session.createQuery("select d.deptName from Dept d where d.deptId=? ");
		query6.setParameter(0, 1);
		System.out.println(query6.list());*/
		
		//模糊查询
		/*Query query61 = session.createQuery("from Dept d where d.deptName like ? ");
		query61.setParameter(0, "开%");
		System.out.println(query61.list());*/
		
		//条件查询，命名参数,不要带构造参数。
		/*Query query7 = session.createQuery("from Dept d where d.deptId=:id ");
		query7.setParameter("id", 1);
		System.out.println(query7.list());*/
		
		//5:聚合函数
		/*Query query8 = session.createQuery("select count(*) from Dept ");
		//System.out.println(query8.list());
		Long number = (Long) query8.uniqueResult();
		System.out.println(number);*/
		
		//6:分组查询
		/*Query query9 = session.createQuery("select e.empId,count(*) from Employee e group by e.dept");
		//System.out.println(query9.list());
		List<Employee> list = query9.list();
		System.out.println(list);*/
		
		//7:连接查询
		//内连接
		/*Query query10 = session.createQuery("from Employee e inner join e.dept");
		System.out.println(query10.list());*/
		
		//左外连接
		/*Query query11 = session.createQuery("from Employee e left join e.dept");
		System.out.println(query11.list());*/
		
		//右外连接
		/*Query query12 = session.createQuery("from Employee e right join e.dept");
		System.out.println(query12.list());*/
		
		//迫切内连接
		//迫切内链接会将右表的数据，填充到左表对象中。
		Query query13 = session.createQuery("from Employee e inner join fetch e.dept");
		System.out.println(query13.list());
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	@Test
	public void HQL_other(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//HQL语句写到配置文件中去
		Query query = session.getNamedQuery("dept_hql");
		query.setParameter(0, 10);
		System.out.println(query.list());
		
		
		tx.commit();
		session.close();
	}
		
}
