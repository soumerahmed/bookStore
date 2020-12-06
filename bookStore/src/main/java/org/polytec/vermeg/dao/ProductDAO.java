package org.polytec.vermeg.dao;

import java.util.List;
import org.polytec.vermeg.model.Product;

public interface ProductDAO {

	void addProduct(Product product);

	Product findProductById(int id);

	List<Product> findAllProduct();

	void deleteProduct(Product product);

	void updateProduct(Product product);

	Double getPriceByProductId(int id);

	Double getPriceByProduct(Product product);

}
