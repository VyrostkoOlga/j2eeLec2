package ru.vyrostkoolga.j2eelec2.lec4.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface OrderRepository extends JpaRepository<Order, Integer>
{
	
}