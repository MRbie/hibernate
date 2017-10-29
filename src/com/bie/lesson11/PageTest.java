package com.bie.lesson11;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
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
public class PageTest {

	
	@Test
	public void HQL_other(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		Query q = session.createQuery("from Dept");
		
		//获取到总计路数
		//获取到一个滚动的结果集
		ScrollableResults scroll = q.scroll();
		//滚动到最后一行。
		scroll.last();
		//得到滚动的总记录数,即总记录数。
		int rowNumber = scroll.getRowNumber() + 1;
		
		//设置分页参数
		q.setFirstResult(0);
		q.setMaxResults(3);
		
		//查询操作
		System.out.println(q.list());
		System.out.println(rowNumber);
		
		tx.commit();
		session.close();
	}
		
}
