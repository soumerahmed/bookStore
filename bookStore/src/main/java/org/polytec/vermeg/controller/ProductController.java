package org.polytec.vermeg.controller;

import java.util.List;

import org.polytec.vermeg.model.Product;
import org.polytec.vermeg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> findAllProduct() {
		return productService.findAllProductService();
	}

	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product findProductById(@PathVariable int id) {
		return productService.findProductByIdService(id);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addProduct(@RequestBody Product product) {
		if (product == null) {
			productService.addProductService(product);
		} else {
			productService.updateProductService(product);
		}

		return "add with success";
	}

	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		if (productService.findProductByIdService(id) == null) {
			return " Product Not exist ";
		} else {

			productService.updateProductService(productService.findProductByIdService(id));
			return " Update product with succes";
		}
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProductService(productService.findProductByIdService(id));
		return "deleted with succes";

	}

}
