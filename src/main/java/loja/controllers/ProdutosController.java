package loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import loja.daos.ProdutoDAO;
import loja.models.Produto;

@Controller
@Transactional
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/produtos")
	public String cadastrar(Produto produto) {
		System.out.println(produto);
		produtoDAO.save(produto);
		return "produtos/ok";
	}
	
	@RequestMapping("/produtos/formulario")
	public String formulario() {
		return "produtos/formulario";
	}
	
}
