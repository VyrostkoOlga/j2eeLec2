package ru.vyrostkoolga.j2eelec2.lec4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	// lecture 5	
	@Query( "select r from Customer r where r.name = :name " )
	public List< Customer > getCustomerByName( @Param( "name" ) String name );
}
