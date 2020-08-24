package book;

import java.util.Date;

public class BookVO {
 private String code;
 private String title;
 private String price;
 private String writer;

 // ... setter()/getter()/toString() 추가

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getCode() {
	return code;
}
public void setCode(String string) {
	this.code = string;
}
public String getPrice() {
	return price;
}
public void setPrice(String string) {
	this.price = string;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
@Override
public String toString() {
	return "BookVO [code=" + code + ", title=" + title + ", price=" + price + ", writer=" + writer + "]";
}


 
 
}
