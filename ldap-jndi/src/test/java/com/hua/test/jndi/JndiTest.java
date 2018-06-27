/**
 * 描述: 
 * JndiTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jndi;

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

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.LdapContext;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JndiTest
 */
public final class JndiTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testJndi() {
		try {
			
			
		} catch (Exception e) {
			log.error("testJndi =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 查找jndi
	 * @author qianye.zheng
	 */
	@Test
	public void testAdd()
	{
		String root = "dc=maxcrc,dc=com";
		
		// 环境参数
		Hashtable<String, String> envTable = new Hashtable<String, String>();
		envTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		envTable.put(Context.PROVIDER_URL, "ldap://127.0.0.1:389/" + root);
		envTable.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 设置进入的目录识别名dn
		envTable.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
		// 进入目录的密码
		envTable.put(Context.SECURITY_CREDENTIALS, "secret");
		//envTable.put("filter", routFilter);
		try
		{
			// 目录上下文
			DirContext dirContext = new InitialDirContext(envTable);
			String name = null;
		} catch (Exception e)
		{
			log.error("testAdd =====> ", e);
		}
		
	}
	
	/**
	 * 
	 * @description 查找jndi
	 * @author qianye.zheng
	 */
	@Test
	public void testDelete()
	{
		String routFilter = "";
		
		// 环境参数
		Hashtable<String, String> envTable = new Hashtable<String, String>();
		envTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		envTable.put(Context.PROVIDER_URL, "ldap://127.0.0.1:389");
		envTable.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 设置进入的目录识别名dn
		envTable.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
		// 进入目录的密码
		envTable.put(Context.SECURITY_CREDENTIALS, "secret");
		//envTable.put("filter", routFilter);
		try
		{
			// 目录上下文
			DirContext dirContext = new InitialDirContext(envTable);
			String name = null;
			name = "ou=People,dc=maxcrc,dc=com";
			name = "dc=maxcrc,dc=com";
			NamingEnumeration<Binding> bindings = dirContext.listBindings(name);
			Binding binding = null;
			LdapContext ldapCtx = null;
			Attributes attributes = null;
			while (bindings.hasMore())
			{
				binding = bindings.next();
				System.out.println(binding.getName() + ": " + binding.getObject());
				ldapCtx = (LdapContext)  binding.getObject();
/*				attributes = ldapCtx.getAttributes("cn");
				NamingEnumeration<Attribute> attributeEnums = (NamingEnumeration<Attribute>) attributes.getAll();
				Attribute attribute = null;
				while (attributeEnums.hasMore())
				{
					attribute = attributeEnums.next();
					System.out.println(attribute.getID() + ": " + attribute.get());
				}*/
			}
			
			
		} catch (Exception e)
		{
			log.error("testDelete =====> ", e);
		}
		
	}
	
	/**
	 * 
	 * @description 查找jndi
	 * @author qianye.zheng
	 */
	@Test
	public void testUpdate()
	{
		String routFilter = "";
		
		// 环境参数
		Hashtable<String, String> envTable = new Hashtable<String, String>();
		envTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		envTable.put(Context.PROVIDER_URL, "ldap://127.0.0.1:389");
		envTable.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 设置进入的目录识别名dn
		envTable.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
		// 进入目录的密码
		envTable.put(Context.SECURITY_CREDENTIALS, "secret");
		//envTable.put("filter", routFilter);
		try
		{
			// 目录上下文
			DirContext dirContext = new InitialDirContext(envTable);
			String name = null;
			name = "ou=People,dc=maxcrc,dc=com";
			name = "dc=maxcrc,dc=com";
			NamingEnumeration<Binding> bindings = dirContext.listBindings(name);
			Binding binding = null;
			LdapContext ldapCtx = null;
			Attributes attributes = null;
			while (bindings.hasMore())
			{
				binding = bindings.next();
				System.out.println(binding.getName() + ": " + binding.getObject());
				ldapCtx = (LdapContext)  binding.getObject();
/*				attributes = ldapCtx.getAttributes("cn");
				NamingEnumeration<Attribute> attributeEnums = (NamingEnumeration<Attribute>) attributes.getAll();
				Attribute attribute = null;
				while (attributeEnums.hasMore())
				{
					attribute = attributeEnums.next();
					System.out.println(attribute.getID() + ": " + attribute.get());
				}*/
			}
			
			
		} catch (Exception e)
		{
			log.error("testUpdate =====> ", e);
		}
		
	}
	
	/**
	 * 
	 * @description 查找jndi
	 * @author qianye.zheng
	 */
	@Test
	public void testQuery()
	{
		final String root = "dc=maxcrc,dc=com";
		// 环境参数
		Hashtable<String, String> envTable = new Hashtable<String, String>();
		envTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		envTable.put(Context.PROVIDER_URL, "ldap://127.0.0.1:389/" + root);
		envTable.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 设置进入的目录识别名dn
		envTable.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
		// 进入目录的密码
		envTable.put(Context.SECURITY_CREDENTIALS, "secret");
		//envTable.put("filter", routFilter);
		try
		{
			// 目录上下文
			DirContext dirContext = new InitialDirContext(envTable);
			String name = null;
			name = "ou=TianHe";
			NamingEnumeration<Binding> bindings = dirContext.listBindings(name);
			Binding binding = null;
			LdapContext ldapContext = null;
			Attributes attributes = null;
			Attribute attribute = null;
			while (bindings.hasMore())
			{
				binding = bindings.next();
				ldapContext = (LdapContext) binding.getObject();
				System.out.println(binding.getName() + ": " + ldapContext);
				attributes = ldapContext.getAttributes("cn");
				NamingEnumeration<String> ids = attributes.getIDs();
				while (ids.hasMore())
				{
					System.out.println(attributes.get(ids.next()));
				}
			}
		} catch (Exception e)
		{
			log.error("testQuery =====> ", e);
		}
		
	}
	
	/**
	 * 
	 * @description 查找jndi
	 * @author qianye.zheng
	 */
	@Test
	public void jndiLookup()
	{
		String routFilter = "";
		
		// 环境参数
		Hashtable<String, String> envTable = new Hashtable<String, String>();
		envTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		envTable.put(Context.PROVIDER_URL, "ldap://127.0.0.1:389");
		envTable.put(Context.SECURITY_AUTHENTICATION, "simple");
		// 设置进入的目录识别名dn
		envTable.put(Context.SECURITY_PRINCIPAL, "cn=Manager,dc=maxcrc,dc=com");
		// 进入目录的密码
		envTable.put(Context.SECURITY_CREDENTIALS, "secret");
		//envTable.put("filter", routFilter);
		try
		{
			// 目录上下文
			DirContext dirContext = new InitialDirContext(envTable);
			String name = null;
			name = "ou=People,dc=maxcrc,dc=com";
			name = "dc=maxcrc,dc=com";
			NamingEnumeration<Binding> bindings = dirContext.listBindings(name);
			Binding binding = null;
			LdapContext ldapCtx = null;
			Attributes attributes = null;
			while (bindings.hasMore())
			{
				binding = bindings.next();
				System.out.println(binding.getName() + ": " + binding.getObject());
				ldapCtx = (LdapContext)  binding.getObject();
/*				attributes = ldapCtx.getAttributes("cn");
				NamingEnumeration<Attribute> attributeEnums = (NamingEnumeration<Attribute>) attributes.getAll();
				Attribute attribute = null;
				while (attributeEnums.hasMore())
				{
					attribute = attributeEnums.next();
					System.out.println(attribute.getID() + ": " + attribute.get());
				}*/
			}
			
			
		} catch (Exception e)
		{
			log.error("jndiLookup =====> ", e);
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
