package com.keven.shiro.model;

import java.io.Serializable;

public class Permission implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.id
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.available
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Boolean available;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.name
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.parent_id
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Long parentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.parent_ids
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String parentIds;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.permission
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String permission;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.resource_type
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String resourceType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_permission.url
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_permission
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.id
	 * @return  the value of sys_permission.id
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.id
	 * @param id  the value for sys_permission.id
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.available
	 * @return  the value of sys_permission.available
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Boolean getAvailable() {
		return available;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.available
	 * @param available  the value for sys_permission.available
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.name
	 * @return  the value of sys_permission.name
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.name
	 * @param name  the value for sys_permission.name
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.parent_id
	 * @return  the value of sys_permission.parent_id
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.parent_id
	 * @param parentId  the value for sys_permission.parent_id
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.parent_ids
	 * @return  the value of sys_permission.parent_ids
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getParentIds() {
		return parentIds;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.parent_ids
	 * @param parentIds  the value for sys_permission.parent_ids
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds == null ? null : parentIds.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.permission
	 * @return  the value of sys_permission.permission
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.permission
	 * @param permission  the value for sys_permission.permission
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setPermission(String permission) {
		this.permission = permission == null ? null : permission.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.resource_type
	 * @return  the value of sys_permission.resource_type
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.resource_type
	 * @param resourceType  the value for sys_permission.resource_type
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType == null ? null : resourceType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_permission.url
	 * @return  the value of sys_permission.url
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_permission.url
	 * @param url  the value for sys_permission.url
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
}