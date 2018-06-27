/**
 * 描述: 
 * LdapString3Test.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.ldap;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hua.entity.Person;
import com.hua.entity.User;
import com.hua.mapper.UserMapper;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * LdapString3Test
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/spring-config.xml", "classpath:conf/xml/spring-ldap3.xml"})
public final class LdapString3Test extends BaseTest {

	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	@Resource
	private LdapTemplate ldapTemplate;
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQuery() {
		try {
			LdapQuery query = null;
			Person entity = null;
			
			query = LdapQueryBuilder.query().where("ou").is("ZhengQianYe");
			entity = ldapTemplate.findOne(query, Person.class);
			System.out.println(JacksonUtil.writeAsString(entity));
			
			query = LdapQueryBuilder.query().where("ou").is("ZhengQianYe2");
			entity = ldapTemplate.findOne(query, Person.class);
			System.out.println(JacksonUtil.writeAsString(entity));
			
		} catch (Exception e) {
			log.error("testQuery =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查找单个人
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLookup() {
		try {
			String dn = null;
			//dn = "uid=20180624123456,ou=SuJia";
			//dn = "uid=2012586412314,ou=ZhengQianYe,ou=TianHe";
			//
			dn = "ou=ZhengQianYe,ou=TianHe";
			DirContextAdapter adaptor = (DirContextAdapter) ldapTemplate.lookup(dn);
			
			System.out.println(adaptor.toString());
			
		} catch (Exception e) {
			log.error("testLookup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查找组织
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLookupOrganization() {
		try {
			String dn = null;
			//dn = "uid=20180624123456,ou=SuJia";
			//dn = "uid=2012586412314,ou=ZhengQianYe,ou=TianHe";
			//
			dn = "o=GuangMingPhoto";
			DirContextAdapter adaptor = (DirContextAdapter) ldapTemplate.lookup(dn);
			
			System.out.println(adaptor.toString());
			
		} catch (Exception e) {
			log.error("testLookupOrganization =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 搜索多个人
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testList() {
		try {
			AndFilter filter = new AndFilter();
			/*
			 * 属性值查询
			 */
			filter.and(new EqualsFilter("objectClass", "person"));
			//filter.and(new EqualsFilter("objectClass", "groupOfNames"));
			
			// 前缀部分
			String base = null;
			base = "ou=SuJia";
			base = "cn=FuQinJia,ou=SuJia";
			List<User> users = ldapTemplate.search(base, filter.encode(), new UserMapper());
			
			for (User user : users)
			{
				System.out.println(user.toString());
			}
			
		} catch (Exception e) {
			log.error("testList =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testList_() {
		try {
			AndFilter filter = new AndFilter();
			filter.and(new EqualsFilter("objectClass", "person"));
			
			List<User> users = ldapTemplate.search("ou=People2", filter.encode(), new UserMapper());
			
			for (User user : users)
			{
				System.out.println(user.toString());
			}
			
		} catch (Exception e) {
			log.error("testList_ =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSpringJunit() {
		try {
			System.out.println(ldapTemplate.toString());
		} catch (Exception e) {
			log.error("testSpringJunit =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
