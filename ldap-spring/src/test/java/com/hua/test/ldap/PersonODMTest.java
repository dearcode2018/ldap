/**
 * 描述: 
 * PersonODMTest.java
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

import javax.annotation.Resource;
import javax.naming.Name;
import javax.naming.ldap.LdapName;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hua.entity.Person;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * PersonODMTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/spring-config.xml", "classpath:conf/xml/spring-ldap.xml"})
public final class PersonODMTest extends BaseTest {

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
	 * @description 
	 * @param uid
	 * @return
	 * @author qianye.zheng
	 */
	private Name buildDn(final String base, final String fullName)
	{
		return LdapNameBuilder.newInstance(base)
				.add("cn", fullName)
				.build();
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCreate() {
		try {
			Person entity = null;
			entity = new Person();
			//entity.setCompany("TianHe");
			entity.setDescription("十分优秀的人");
			entity.setFullName("郑乾业");
			entity.setSurname("郑");
			entity.setSomeUnmappedField("哈哈打发");
			String base = "ou=Tianhe";
			//entity.setDn(buildDn(base, entity.getFullName()));
			entity.setDn(buildDn(base, "zhengqianye3"));
			
			ldapTemplate.create(entity);
			
		} catch (Exception e) {
			log.error("testCreate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDelete() {
		try {
			Person entity = null;
			entity = new Person();
			String base = "ou=Tianhe";
			entity.setDn(buildDn(base, "zhengqianye3"));
			
			ldapTemplate.delete(entity);
			
		} catch (Exception e) {
			log.error("testDelete =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdate() {
		try {
			/*
			 * cn=zhengqianye3,ou=TianHe,dc=maxcrc,dc=com
			 */
			Person entity = null;
			entity = new Person();
			entity.setDescription("十分优秀的人2000");
			/*
			 * 必须要设置 cn的值为 cn的值，否则抛异常:
			 * : [LDAP: error code 64 - naming attribute 'cn' is not present in entry]
			 */
			entity.setFullName("zhengqianye3");
			entity.setSurname("郑000");
			entity.setSomeUnmappedField("哈哈打发3");
			String base = "ou=Tianhe";
			entity.setDn(buildDn(base, "zhengqianye3"));
			
			ldapTemplate.update(entity);
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
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
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGet() {
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
			log.error("testGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearch() {
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
			log.error("testSearch =====> ", e);
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
