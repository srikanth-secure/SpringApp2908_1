package com.ashokit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ashokit.model.Product;

@Component
public class ProductsDataFilter {
	public List<Product> filterData(List<Product> products) {

		/*
		 * List<Product> filteredProducts = new ArrayList();
		 * 
		 * for (Product p : products) { if (p.getProductPrice() >= 3000.00) {
		 * filteredProducts.add(p); } }
		 */

		List<Product> filteredProducts = products.stream().filter(p -> p.getProductPrice() >= 3000)
				.collect(Collectors.toList());
		return filteredProducts;
	}
}
