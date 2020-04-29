package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.cap.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements IProductDao{
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> fetchAll() {
		 String jql = "from Product";
	     TypedQuery<Product> query = entityManager.createQuery(jql, Product.class);
	     List<Product> list = query.getResultList();
	     return list;
	}

	@Override
	public Product addProduct(Product product) {
		 entityManager.persist(product);
		return product;
	}
	@Override
	public Product fetch(int productId) {
		Product product = entityManager.find(Product.class, productId);
		return product;
	}
	
}
