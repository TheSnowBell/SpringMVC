package loja.daos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import loja.builders.ProdutoBuilder;
import loja.conf.AmazonConfiguration;
import loja.conf.AppWebConfiguration;
import loja.conf.DataSourceConfigurationTest;
import loja.conf.JPAConfiguration;
import loja.conf.SecurityConfiguration;
import loja.models.BookType;
import loja.models.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes ={AppWebConfiguration.class, JPAConfiguration.class, SecurityConfiguration.class, DataSourceConfigurationTest.class, AmazonConfiguration.class })
@ActiveProfiles("test")
public class ProdutoDAOTest {

	@Autowired
	ProdutoDAO produtoDAO;

	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private Filter springSecurityFilterChain;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilters(springSecurityFilterChain).build();
	}

	@Test
	@Transactional
	public void shouldListAllBooksInTheHome() throws Exception {
		this.mockMvc.perform(get("/produtos"))
		.andExpect(MockMvcResultMatchers
				.forwardedUrl("/WEB-INF/views/produtos/lista.jsp"));
	}


	@Test
	@Transactional
	public void shouldSumAllPricesOfEachBookPerType(){

		List<Produto> printedBooks = ProdutoBuilder.novoProduto(BookType.PRINTED, BigDecimal.TEN).more(4).buildAll();
		printedBooks.stream().forEach(produtoDAO::save);
		List<Produto> ebooks = ProdutoBuilder.novoProduto(BookType.EBOOK, BigDecimal.TEN).more(4).buildAll();
		ebooks.stream().forEach(produtoDAO::save);
		BigDecimal value =	produtoDAO.sumPricesPerType(BookType.PRINTED);
		Assert.assertTrue(new BigDecimal(50).setScale(2).compareTo(value) == 0);

	}

	@Test
	public void onlyAdminShoudAccessProductsForm() throws Exception {
		RequestPostProcessor processor = SecurityMockMvcRequestPostProcessors
										.user("compra@teste.com")
										.password("123456")
										.roles("COMPRADOR");
		this.mockMvc.perform(get("/produtos/formulario")
				.with(processor))
				.andExpect(MockMvcResultMatchers.status().is(403));
	}
}


