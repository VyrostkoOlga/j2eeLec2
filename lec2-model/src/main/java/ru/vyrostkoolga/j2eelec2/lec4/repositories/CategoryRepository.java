package ru.vyrostkoolga.j2eelec2.lec4.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vyrostkoolga.j2eelec2.lec4.entities.*;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
