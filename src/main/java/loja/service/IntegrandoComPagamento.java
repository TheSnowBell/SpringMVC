package loja.service;

import java.math.BigDecimal;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import loja.models.PagamentoData;

public class IntegrandoComPagamento implements Runnable {

	private DeferredResult<String> result;
	private BigDecimal value;
	private RestTemplate restTemplate;
	
	public IntegrandoComPagamento(DeferredResult<String> result, BigDecimal value, RestTemplate restTemplate) {
		super();
		this.result = result;
		this.value = value;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public void run() {
		
		String uriToPay = "http://book-payment.herokuapp.com/payment";

		try {
			restTemplate.postForObject(uriToPay, new PagamentoData(value), String.class);
			result.setResult("redirect:/pagamento/sucesso");
		} catch (HttpClientErrorException e) {
			result.setResult("redirect:/pagamento/erro");
		}
		
	}

}
