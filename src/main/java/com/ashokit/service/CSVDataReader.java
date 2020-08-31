package com.ashokit.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ashokit.model.Product;

@Component
public class CSVDataReader {
	public List<Product> readProductsData(String fileName) throws Exception {
		List<Product> productList = new ArrayList<>();
		FileReader fr = new FileReader(new File(fileName));
		BufferedReader br = new BufferedReader(fr);
		String readData = br.readLine();
		while (readData != null) {
			String[] splitData = readData.split(",");
			String pId = splitData[0];
			String pName = splitData[1];
			String pPrice = splitData[2];

			Product p = new Product();
			p.setProductId(Integer.parseInt(pId));
			p.setProductName(pName);
			p.setProductPrice(Double.parseDouble(pPrice));
			productList.add(p);
			readData = br.readLine();

		}
		br.close();
		return productList;

	}
}
