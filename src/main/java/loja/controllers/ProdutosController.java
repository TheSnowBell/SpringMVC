package loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import loja.daos.ProdutoDAO;
import loja.models.BookType;
import loja.models.Produto;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public String cadastrar(Produto produto, RedirectAttributes redirectAttributes) {
		produtoDAO.save(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return "redirect:produtos";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelView = new ModelAndView("produtos/lista");
		modelView.addObject("produtos", produtoDAO.lista());
		return modelView;
	}
	
	@RequestMapping("/formulario")
	public ModelAndView formulario() {
		ModelAndView modelView = new ModelAndView("produtos/formulario");
		modelView.addObject("types", BookType.values());
		return modelView;
	}
	
}
