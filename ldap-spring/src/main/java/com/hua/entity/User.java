/**
  * @filename User.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

 /**
 * @type User
 * @description 
 * @author qianye.zheng
 */
public class User
{
	
	private String uid;
	
	private String name;
	
	/* surname 姓 */
	//private String lastname;
	
	/* 姓 */
	private String surname;
	
	private String mobile;
	
	private String email;

	/**
	 * @return the surname
	 */
	public final String getSurname()
	{
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public final void setSurname(String surname)
	{
		this.surname = surname;
	}

	/**
	 * @return the uid
	 */
	public final String getUid()
	{
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public final void setUid(String uid)
	{
		this.uid = uid;
	}

	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public final String getMobile()
	{
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public final void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public final String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String toString()
	{
		return new ReflectionToStringBuilder(this).toString();
	}
	
}
