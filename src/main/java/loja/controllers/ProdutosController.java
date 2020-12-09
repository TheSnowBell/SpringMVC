package loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping("/formulario")
	public ModelAndView formulario(Produto produto) {
		ModelAndView modelView = new ModelAndView("produtos/formulario");
		modelView.addObject("types", BookType.values());
		return modelView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cadastrar(
							@Valid Produto produto, 
							BindingResult bindingResult ,
							RedirectAttributes redirectAttributes
							) {
		
		if(bindingResult.hasErrors()) {
			return formulario(produto);
		}
		
		produtoDAO.save(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelView = new ModelAndView("produtos/lista");
		modelView.addObject("produtos", produtoDAO.lista());
		return modelView;
	}
	
}
