package br.com.desafiojava.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.desafiojava.repository.MovieRepository;

public class MovieRepositoryTest {

	@Test
	public void test() {
		EntityManagerFactory factory;
		factory = Persistence.createEntityManagerFactory("DesafioJava");
		MovieRepository movieRepository = new MovieRepository(factory.createEntityManager());
		assertEquals(5, movieRepository.listMovie().size()); 
	}

}
