package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl extends AbstractHibernateDAO<Product> implements ProductDAO {

	public ProductDAOImpl() {
		setClazz(Product.class);
	}

	@Override
	public void addProduct(Product product) {
		super.save(product);
	}

	@Override
	public Product findProductById(int id) {
		return super.findOne(id);
	}

	@Override
	public List<Product> findAllProduct() {
		return super.findAll();
	}

	@Override
	public void deleteProduct(Product product) {
		super.delete(product);
	}

	@Override
	public void updateProduct(Product product) {
		super.update(product);
	}

	@Override
	public Double getPriceByProductId(int id) {
		return findProductById(id).getPrice();
	}

	@Override
	public Double getPriceByProduct(Product product) {
		return findProductById(product.getIdProduct()).getPrice();
	}

}
