package loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import loja.models.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Produto produto) {
		entityManager.persist(produto);
	}
	
	public List<Produto> lista(){
		return entityManager.createQuery("SELECT DISTINCT(p) FROM Produto p JOIN FETCH p.precos", Produto.class ).getResultList();
	}
}
