package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Produto;

import java.util.Scanner;

public class TestaInsereProduto {
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("lojavirtualdb");
		EntityManager em = factory.createEntityManager();
			
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 2; i++){
			Produto p = new Produto();
			
			System.out.println("Digite o nome do produto: ");
			p.setNome(sc.next());
			System.out.println("Digite o preco: ");
			p.setPreco(sc.nextDouble());			
			
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}
		
		System.out.println("Terminado");
		
	}
}