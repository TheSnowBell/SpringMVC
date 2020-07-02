package loja.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Preco {

	@Column(scale = 2)
	private BigDecimal valor;
	private BookType bookType;
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BookType getBookType() {
		return bookType;
	}
	
	public void setBookType(BookType bookeType) {
		this.bookType = bookeType;
	}
	
	
}
