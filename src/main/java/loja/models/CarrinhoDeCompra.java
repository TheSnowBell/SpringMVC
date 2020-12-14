package loja.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoDeCompra {

	private Map<ItemDeCompra, Integer> itens = new LinkedHashMap<ItemDeCompra, Integer>();

	public void adicionar(ItemDeCompra item) {
		itens.put(item, getQuantidadeDoItem(item) + 1);
	}

	public void remover(ItemDeCompra ItemDeCompra) {
		itens.remove(ItemDeCompra);
	}

	public boolean isEmpty() {
		return itens.isEmpty();
	}

	public Collection<ItemDeCompra> getList() {
		return itens.keySet();
	}
	
	public Integer getQuantidadeDoItem(ItemDeCompra item) {
		if (!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		return itens.get(item);
	}

	public Integer getQuantidadeTotalDeItensNoCarrinho() {
		return itens.values().stream()
				.reduce(0, (subTotal, valor) -> subTotal + valor);
	}

	public BigDecimal getValorTotalDoItem(ItemDeCompra item) {
		return item.getValorTotal(getQuantidadeDoItem(item));
	}

	public BigDecimal getTotal(){
		BigDecimal total = BigDecimal.ZERO;
		for(ItemDeCompra item : itens.keySet()){
			total = total.add(getValorTotalDoItem(item));
		}
		return total;
	}

}
