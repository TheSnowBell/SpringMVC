package loja.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.async.DeferredResult;

import loja.models.CarrinhoDeCompra;
import loja.service.IntegrandoComPagamento;

@Controller
@RequestMapping("/pagamento")
@Scope(value =  WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

	@Autowired
	private CarrinhoDeCompra carrinhoDeCompra;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public DeferredResult<String> checkout() {
		
		BigDecimal total = carrinhoDeCompra.getTotal();
		DeferredResult<String> result = new DeferredResult<String>();
		
		IntegrandoComPagamento integrandoComPagamento = new IntegrandoComPagamento(result, total, restTemplate);

		Thread thread = new Thread(integrandoComPagamento);
		thread.start();
		
		return result;
	
	}
}
