package com.bie.lesson02.crud.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/** 
* @author  Author:别先生 
* @date Date:2017年10月15日 下午4:04:26 
*
* 代码自动建表
*/
public class EmployeeDDL {

	@Test
	public void DDL(){
		//创建配置管理类对象
		Configuration config = new Configuration();
		//加载主配置文件
		config.configure();
		
		//创建工具类对象
		SchemaExport export = new SchemaExport(config);
		//自动建表,第一个参数是否在控制台打印脚本，第二个参数是否执行脚本
		export.create(true, true);
	}
	
	
}
