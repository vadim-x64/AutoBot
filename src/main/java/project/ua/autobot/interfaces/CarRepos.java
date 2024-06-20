package project.ua.autobot.interfaces;

import java.util.List;
import project.ua.autobot.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepos extends JpaRepository<Car, Long> {
    List<Car> findByCategoryName(String category);
}