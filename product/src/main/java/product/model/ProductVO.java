package product.model;

public class ProductVO {
	private String pcode; //  varchar2(10) constraint products_pk primary key,
	private String pname; //  varchar2(30),
	private String price; //  number(8),
	private String quant; //  number(5),
	private String pdesc; // varchar2(200)
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	@Override
	public String toString() {
		return "ProductVO [pcode=" + pcode + ", pname=" + pname + ", price="
				+ price + ", quant=" + quant + ", pdesc=" + pdesc + "]";
	}
}
