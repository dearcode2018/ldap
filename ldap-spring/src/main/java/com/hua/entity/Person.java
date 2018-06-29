/**
  * @filename Person.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;


import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.odm.annotations.Transient;

 /**
 * @type Person
 * @description 
 * @author qianye.zheng
 */
/*
 * 指定基目录，其下一级都是此对象
 * 实体指定的base只对序列化有效，
 * 变更到ldap中则需要明确指定基目录
 */
@Entry(base = "ou=Tianhe", objectClasses = {"person"})
/* 要声明为final */
public final class Person
{
	@Id
	private Name dn;
	
	@Attribute(name = "cn" )
	/*  */
	//@DnAttribute(value = "cn", index = 0)
	private String fullName;
	
	@Attribute(name = "sn")
	private String surname;
	
	/* 不加注解，表示直接根据名称自动映射 */
	private String description;
	
	/* 索引不同，ou的值不同 0-就是上级，1就是当前级 */
	//@DnAttribute(value = "ou", index = 0)
	/* 不映射该字段 */
	@Transient
	private String company;
	
	/* 不映射该字段 */
	@Transient
	private String someUnmappedField;

	/**
	 * @return the dn
	 */
	public final Name getDn()
	{
		return dn;
	}

	/**
	 * @param dn the dn to set
	 */
	public final void setDn(Name dn)
	{
		this.dn = dn;
	}

	/**
	 * @return the fullName
	 */
	public final String getFullName()
	{
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public final void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

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
	 * @return the description
	 */
	public final String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the company
	 */
	public final String getCompany()
	{
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public final void setCompany(String company)
	{
		this.company = company;
	}

	/**
	 * @return the someUnmappedField
	 */
	public final String getSomeUnmappedField()
	{
		return someUnmappedField;
	}

	/**
	 * @param someUnmappedField the someUnmappedField to set
	 */
	public final void setSomeUnmappedField(String someUnmappedField)
	{
		this.someUnmappedField = someUnmappedField;
	}
	
}
