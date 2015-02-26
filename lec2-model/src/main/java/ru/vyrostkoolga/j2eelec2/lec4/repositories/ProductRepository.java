package ru.vyrostkoolga.j2eelec2.lec4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	// lecture 5	
	@Query( "select r from Product r where r.name = :name " )
	public List< Product > getProductByName( @Param( "name" ) String name );
}
