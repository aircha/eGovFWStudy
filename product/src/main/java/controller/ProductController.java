package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductVO;
import product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/list.do")
	public ModelAndView getProductList(ModelAndView mav) {
		List<ProductVO> productList = productService.getProductList();
		mav.addObject("products", productList);
		mav.setViewName("/product_list");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product/view.do")
	public ModelAndView getProduct(ModelAndView mav, String pcode) {
		ProductVO product = productService.getProduct(pcode);
		mav.addObject("product", product);
		mav.setViewName("/product_view");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/product/modify.do")
	public ModelAndView modifyProduct(ModelAndView mav, String pcode) {
		ProductVO product = productService.getProduct(pcode);
		mav.addObject("product", product);
		mav.setViewName("/product_modify");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product/add.do")
	public ModelAndView addProduct(ModelAndView mav, ProductVO product) {
		mav.setViewName("/product_form");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/product/add.do")
	public String insertProduct(ProductVO product) {
		productService.addProduct(product);
		return "redirect:/product/list.do";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/product/update.do")
	public String updateProduct(ProductVO product) {
		productService.modifyProduct(product);
		return "redirect:/product/view.do?pcode="+product.getPcode();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/product/delete.do")
	public String removeProduct(String pcode) {
		productService.removeProcuct(pcode);
		return "redirect:/product/list.do";
	}
}
