package product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import product.model.ProductVO;

@Repository("productDAO")
public interface ProductDAO {
	ProductVO getProduct(String pcode);
	List<ProductVO> getProductList();
	int addProduct(ProductVO product);
	int modifyProduct(ProductVO product);
	int removeProduct(String pcode);
}
