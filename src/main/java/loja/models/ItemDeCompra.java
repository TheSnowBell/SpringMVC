package loja.models;

import java.math.BigDecimal;

public class ItemDeCompra {

	private Produto produto;
	private BookType bookType;
	private Integer produtoId;

	public ItemDeCompra(Produto produto, BookType bookType) {
		this.produto = produto;
		this.bookType = bookType;
		this.produtoId = produto.getId();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public BookType getBookType() {
		return bookType;
	}
	
	public BigDecimal getPreco(){
		return produto.precoDe(bookType);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookType == null) ? 0 : bookType.hashCode());
		result = prime * result
				+ ((produtoId == null) ? 0 : produtoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDeCompra other = (ItemDeCompra) obj;
		if (bookType != other.bookType)
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

	public BigDecimal getValorTotal(Integer quantidade) {
		return getPreco().multiply(new BigDecimal(quantidade));
	}

}
