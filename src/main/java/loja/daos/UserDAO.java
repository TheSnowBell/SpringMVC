package loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import loja.models.User;

@Repository
public class UserDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<User> users = entityManager
							.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
							.setParameter("login", username)
							.getResultList();
		
		if(users.isEmpty()) {
			throw new UsernameNotFoundException("O usuario " + username + "nao existe");
		}
		return users.get(0);
	}

}
