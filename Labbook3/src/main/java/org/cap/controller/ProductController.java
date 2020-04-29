package org.cap.controller;

import java.util.List;

import org.cap.entities.Product;
import org.cap.exceptions.ProductExistException;
import org.cap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/")
	public ModelAndView home(){
	    return new ModelAndView("mainpage");
	}
	@GetMapping("home")
	public ModelAndView homepage(){
	    return new ModelAndView("mainpage");
	}
	
	@GetMapping("fetchall")
	public ModelAndView retrieveAllProduct() {
		List<Product> fetchall=productService.fetchAll();
		return new ModelAndView("fetchAll","productlist",fetchall);
	}
	
	@GetMapping("addproduct")
	public ModelAndView production(){
	    return new ModelAndView("AddProduct");
	}
	@GetMapping("saveproduct")
	public ModelAndView addproducts(@RequestParam("pid") int productId,@RequestParam("pname") String productName,@RequestParam("pprice") double productPrice) {
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		productService.addProduct(product);
		return new ModelAndView("saved","product",product);
	}
	
	@ExceptionHandler
	public ModelAndView handleException(ProductExistException exception) {
		String msg = exception.getMessage();
		return new ModelAndView("error","message",msg);
	}
}
