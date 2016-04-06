package com.shop.service;

import java.util.List;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.model.TableData;
import com.shop.data.model.TableParameter;

public abstract class AbstractService<T> extends InterfaceService {

	protected Class<T> entity;

	public AbstractService(Class<T> entity) {
		this.entity = entity;
	}

	public abstract AbstractMapper getAbstractMapper();

	/**
	 * 创建实体
	 * 
	 * @param entity
	 */
	public int insert(T entity) {
		return getAbstractMapper().insert(entity);
	}

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public int update(T entity) {
		return getAbstractMapper().update(entity);
	}

	/**
	 * 删除实体
	 * 
	 * @param ids
	 */
	public void deleteById(Object id) {
		getAbstractMapper().deleteById(id);
	}

	/**
	 * 批量删除实体
	 * 
	 * @param entity
	 * @return
	 */
	public void deleteByIds(Object ids) {
		getAbstractMapper().deleteByIds(ids);
	}

	public T selectById(Object id) {
		return getAbstractMapper().selectById(id);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> listAll() {
		return getAbstractMapper().listAll();
	}

	/**
	 * 分页
	 * 
	 * @return
	 */
	public TableData listPaged(TableParameter parameter, T eneity) {
		TableData tableData = new TableData();
		tableData.data = this.getAbstractMapper().listPaged(parameter, eneity);
		tableData.recordsFiltered = this.getAbstractMapper().count();
		tableData.recordsTotal = tableData.recordsFiltered;
		return tableData;
	}

}
