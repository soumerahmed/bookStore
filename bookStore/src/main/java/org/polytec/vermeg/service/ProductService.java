package org.polytec.vermeg.service;

import java.util.List;
import org.polytec.vermeg.model.Product;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {

	@Transactional
	public List<Product> findAllProductService();

	@Transactional
	public Product findProductByIdService(int id);

	@Transactional
	public void addProductService(Product product);

	@Transactional
	public void updateProductService(Product product);

	@Transactional
	void deleteProductService(Product product);

	@Transactional
	Double getPriceByProductIdService(int id);

	@Transactional
	Double getPriceByProductService(Product product);

}
