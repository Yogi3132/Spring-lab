package org.cap.dao;

import java.util.List;

import org.cap.entities.Product;

public interface IProductDao {
	
	List<Product> fetchAll();
	Product addProduct(Product product);
	Product fetch(int productId);
}
