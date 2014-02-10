package br.com.desafiojava.action;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ActionDefault {

	protected EntityManager getEntityManager() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		EntityManager entityManager = (EntityManager)request.getAttribute("EntityManager");
		return entityManager;
	}
	
}
