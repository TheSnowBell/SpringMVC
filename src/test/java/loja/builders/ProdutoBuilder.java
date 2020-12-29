package loja.builders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import loja.models.BookType;
import loja.models.Preco;
import loja.models.Produto;

public class ProdutoBuilder {

	private Produto produto;
	private int more;
	
	private ProdutoBuilder(Produto produto) {
		this.produto = produto;
	}
	
	public static ProdutoBuilder novoProduto(BookType bookType, BigDecimal valor) {
		Produto produto = criar("Livro 1", bookType, valor);
		return new ProdutoBuilder(produto);
	}
	
	public static ProdutoBuilder novoProduto() {
		Produto produto = criar("Livro 1", BookType.COMBO, BigDecimal.TEN);
		return new ProdutoBuilder(produto);
	}
	
	private static Produto criar(String nome, BookType bookType, BigDecimal valor) {
		Produto produto = new Produto();
		produto.setTitulo(nome);
		produto.setDataLancamento(Calendar.getInstance());
		produto.setPaginas(150);
		produto.setDescricao("Livro para teste");
		
		Preco preco = new Preco();
		preco.setBookType(bookType);
		preco.setValor(valor);
		
		produto.getPrecos().add(preco);
		
		return produto;
	}
	
	public ProdutoBuilder more(int numero) {
		this.more = numero;
		return this;
	}
	
	public Produto build() {
		return this.produto;
	}
	
	public List<Produto> buildAll(){
		Produto base = produto;
		Preco preco = base.getPrecos().get(0);
		List<Produto> produtos = new ArrayList<>();
		produtos.add(base);
		for (int i = 0; i < more; i++) {
			produtos.add(criar("Book "+i, preco.getBookType(), preco.getValor()));
		}
		return produtos;
	}
}
