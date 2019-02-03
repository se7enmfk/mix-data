/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.se7en.biz.common.model.BaseObject;

import java.io.Serializable;

/**
 * null
 *
 * @author se7en zhou
 * @since 2019-01-21 09:36:51
 */
@TableName("PRO_AREA")
public class ProArea extends BaseObject<ProArea> implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** area_id */
	@TableId(type = IdType.INPUT)
	private int area_id;

	/** name */
	private String name;

	/** show_order */
	private Long show_order;


	public int getArea_id() {
		return this.area_id;
	}

	public ProArea setArea_id(int area_id) {
		this.area_id = area_id;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public ProArea setName(String name) {
		this.name = name;
		return this;
	}

	public Long getShow_order() {
		return this.show_order;
	}

	public ProArea setShow_order(Long show_order) {
		this.show_order = show_order;
		return this;
	}
	@Override
	public String toString() {
		return "ProArea {" +
				"area_id='" + area_id + '\'' +
				", name='" + name + '\'' +
				", show_order='" + show_order + '\'' +
				'}';
	}
}
