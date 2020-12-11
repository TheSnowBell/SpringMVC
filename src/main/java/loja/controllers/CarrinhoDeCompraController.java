package loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import loja.daos.ProdutoDAO;
import loja.models.BookType;
import loja.models.CarrinhoDeCompra;
import loja.models.ItemDeCompra;
import loja.models.Produto;

@Controller
@RequestMapping("/shopping")
@Scope(value =  WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoDeCompraController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private CarrinhoDeCompra carrinhoDeCompra;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionar(Integer produtoId, BookType bookType) {
		ItemDeCompra itemDeCompra = criarItem(produtoId, bookType);
		carrinhoDeCompra.adicionar(itemDeCompra);
		return new ModelAndView("redirect:/produtos");
	}
	
	private ItemDeCompra criarItem(Integer produtoId, BookType bookType) {
		Produto produto = produtoDAO.find(produtoId);
		ItemDeCompra itemDeCompra = new ItemDeCompra(produto, bookType);
		return itemDeCompra;
	}

}
