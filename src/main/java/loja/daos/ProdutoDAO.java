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
		/*A "fetch" join allows associations or collections of values to be initialized along with their parent objects using a single select.*/
		return entityManager.createQuery("SELECT DISTINCT(p) FROM Produto p JOIN FETCH p.precos", Produto.class ).getResultList();
	}
	
	public Produto find(Integer id) {
		/*A "fetch" join allows associations or collections of values to be initialized along with their parent objects using a single select.*/
		return entityManager.createQuery("SELECT p FROM Produto p JOIN FETCH p.precos WHERE p.id = :id", Produto.class)
									.setParameter("id", id).getSingleResult();
	}
	
}
