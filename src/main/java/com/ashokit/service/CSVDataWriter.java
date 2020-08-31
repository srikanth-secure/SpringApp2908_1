package com.ashokit.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ashokit.model.Product;

@Component
public class CSVDataWriter {
	public String writeProductsData(List<Product> products) throws IOException {
		/*
		 * BufferedWriter writer = new BufferedWriter(new FileWriter(new
		 * File("filteredproducts.csv"))); for (Object str : products.toArray()) {
		 * writer.write(str + System.lineSeparator()); writer.close(); }
		 */
		FileWriter fw = new FileWriter("filteredproducts.csv");
		products.forEach(p -> {
			try {
				fw.write(p.getProductId() + "," + p.getProductName() + "," + p.getProductPrice());
				fw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		fw.close();
		return "Success";
	}
}
