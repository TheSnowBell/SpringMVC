package loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import loja.daos.ProdutoDAO;
import loja.infra.FileSaver;
import loja.models.BookType;
import loja.models.Produto;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@Autowired
	private FileSaver fileSaver;

	@RequestMapping("/formulario")
	public ModelAndView formulario(Produto produto) {
		ModelAndView modelView = new ModelAndView("produtos/formulario");
		modelView.addObject("types", BookType.values());
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cadastrar(MultipartFile summary, 
			@Valid Produto produto, 
			BindingResult bindingResult ,
			RedirectAttributes redirectAttributes
			) {

		if(bindingResult.hasErrors()) {
			return formulario(produto);
		}

		String webPath = fileSaver.write(summary);
		produto.setSummaryPath(webPath);
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
	
	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Integer id) {
		ModelAndView modelView = new ModelAndView("produtos/show");
		Produto produto = produtoDAO.find(id);
		modelView.addObject("produto", produto);
		return modelView;
	}

}
