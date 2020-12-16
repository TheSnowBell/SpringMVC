package loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8219109518987767400L;
	
	@Id
	String name;
	
	@Override
	public String getAuthority() {
		return name;
	}

}
