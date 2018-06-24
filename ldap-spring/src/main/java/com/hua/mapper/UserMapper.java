/**
  * @filename UserMapper.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mapper;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.hua.entity.User;

 /**
 * @type UserMapper
 * @description 
 * @author qianye.zheng
 */
public class UserMapper implements AttributesMapper<User>
{

	/**
	 * @description 
	 * @param attributes
	 * @return
	 * @throws NamingException
	 * @author qianye.zheng
	 */
	@Override
	public User mapFromAttributes(Attributes attributes) throws NamingException
	{
		final User user = new User();
		Attribute attribute = null;
		
		attribute = attributes.get("uid");
		if (null != attribute)
		{
			user.setUid(attribute.get().toString());
		}
		
		// 姓名
		attribute = attributes.get("cn");
		if (null != attribute)
		{
			user.setName(attribute.get().toString());
		}
		
		attribute = attributes.get("sn");
		if (null != attribute)
		{
			user.setSurname(attribute.get().toString());
		}
		
		attribute = attributes.get("mobile");
		if (null != attribute)
		{
			user.setMobile(attribute.get().toString());
		}
		
		attribute = attributes.get("mail");
		if (null != attribute)
		{
			user.setEmail(attribute.get().toString());
		}
		
		return user;
	}

}
