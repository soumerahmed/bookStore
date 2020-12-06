package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.ProductDAO;
import org.polytec.vermeg.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAllProductService() {
		return productDAO.findAllProduct();
	}

	@Override
	public Product findProductByIdService(int id) {
		return productDAO.findProductById(id);
	}

	@Override
	public void addProductService(Product product) {
		productDAO.addProduct(product);
	}

	@Override
	public void updateProductService(Product product) {
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProductService(Product product) {
		productDAO.deleteProduct(product);
	}

	@Override
	public Double getPriceByProductIdService(int id) {
		return productDAO.findProductById(id).getPrice();
	}

	@Override
	public Double getPriceByProductService(Product product) {
		return productDAO.getPriceByProduct(product);
	}

}
