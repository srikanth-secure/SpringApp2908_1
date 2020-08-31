package com.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CSVDataReader dataReader;

	@Autowired
	private ProductsDataFilter dataFilter;

	@Autowired
	private CSVDataWriter dataWriter;

	@Override
	public String doProcess(String fileName) throws Exception {
		List<Product> products = dataReader.readProductsData(fileName);

		/*
		 * System.out.println("*****All Products******"); products.forEach(p -> {
		 * System.out.println(p); });
		 */

		List<Product> filteredProducts = dataFilter.filterData(products);

		/*
		 * System.out.println("*****Filtered Products******");
		 * filteredProducts.forEach(p -> { System.out.println(p); });
		 */
		String status = dataWriter.writeProductsData(filteredProducts);

		return status;
	}
}
