package product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.dao.ProductDAO;
import product.model.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductVO getProduct(String pcode) {
		return productDAO.getProduct(pcode);
	}

	@Override
	public List<ProductVO> getProductList() {
		return productDAO.getProductList();
	}

	@Override
	public int modifyProduct(ProductVO product) {
		return productDAO.modifyProduct(product);
	}

	@Override
	public int removeProcuct(String pcode) {
		return productDAO.removeProduct(pcode);
	}

	@Override
	public int addProduct(ProductVO product) {
		return productDAO.addProduct(product);
	}

}
