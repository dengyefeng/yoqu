package com.supplier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.dao.SupplierMapper;
import com.supplier.model.SupplierInfo;
import com.supplier.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper mapper;

	public int insertSupplier(SupplierInfo supplierInfo) {
		return mapper.insertSupplierInfo(supplierInfo);
	}

}
