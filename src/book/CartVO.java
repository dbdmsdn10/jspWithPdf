package book;

public class CartVO {
	private int number;
	 private String code;
	 private String title;
	 private String price;
	 private String writer;
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "CartVO [number=" + number + ", code=" + code + ", title=" + title + ", price=" + price + ", writer="
				+ writer + "]";
	}

	
	
}
