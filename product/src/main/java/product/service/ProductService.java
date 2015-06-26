package product.service;

import java.util.List;

import product.model.ProductVO;

public interface ProductService {
	ProductVO getProduct(String pcode);
	List<ProductVO> getProductList();
	int addProduct(ProductVO product);
	int modifyProduct(ProductVO product);
	int removeProcuct(String pcode);
}
