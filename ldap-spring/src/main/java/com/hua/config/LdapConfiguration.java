/**
  * @filename LdapConfiguration.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

 /**
 * @type LdapConfiguration
 * @description 
 * @author qianye.zheng
 */
@Configuration
public class LdapConfiguration
{
	@Value("${ldap.url}")
	private String url;
	
	@Value("${ldap.base.dc}")
	private String baseDc;
	
	@Value("${ldap.username}")
	private String username;
	
	@Value("${ldap.password}")
	private String password;
	
	private LdapTemplate ldapTemplate;

	/*
	 * LdapContextSource上下文源，类似ORM的SessionFactory
	 * 
	 * LdapTemplate 类似ORM的JdbcTemplate
	 * 
	 * 伪事务支持
	 * 
	 * 注解: @Entry @Attribute @Id
	 * 
	 */
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Bean
	public LdapContextSource getContextSource()
	{
		final LdapContextSource contextSource = new LdapContextSource();
		final Map<String, Object> config = new HashMap<String, Object>();
		// 解决乱码
		config.put("java.naming.ldap.attributes.binary", "objectGUID");
		contextSource.setUrl(url);
		contextSource.setBase(baseDc);
		contextSource.setUserDn(username);
		contextSource.setPassword(password);
		contextSource.setPooled(true);
		contextSource.setBaseEnvironmentProperties(config);
		
		return contextSource;
	}
	
	/**
	 * @return the ldapTemplate
	 */
	@Bean
	public LdapTemplate getLdapTemplate()
	{
		if (null == ldapTemplate)
		{
			ldapTemplate = new LdapTemplate(getContextSource());
		}
		
		return ldapTemplate;
	}
	
	
}
