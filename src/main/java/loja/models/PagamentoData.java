package loja.models;

import java.math.BigDecimal;

public class PagamentoData {
	
	private BigDecimal value;
	
	public PagamentoData(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
