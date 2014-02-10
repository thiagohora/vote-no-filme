package br.com.desafiojava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.persistence.*;

public class JPAFilter implements Filter {

	private EntityManagerFactory factory;
	
	//static {
	//	Persistence.
	//	createEntityManagerFactory("DesafioJava");
	//}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		this.factory = Persistence.createEntityManagerFactory("DesafioJava");
	}
	
	@Override
	public void destroy () {
		this.factory.close();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException , ServletException {
		//CHEGADA
		EntityManager manager = this.factory.createEntityManager();
		request.setAttribute("EntityManager", manager);
		manager.getTransaction().begin();
		//CHEGADA
		
		//FILTRO DO STRUTS
		chain.doFilter(request, response);
		//FILTRO DO STRUTS
		
		// SAÍDA
		try {
			manager.getTransaction().commit();
		} catch ( Exception e ) {
			manager.getTransaction ().rollback();
		} finally {
			manager.close();
		}
		// SAÍDA		
	}	
}
