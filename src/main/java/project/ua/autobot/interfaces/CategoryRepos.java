package project.ua.autobot.interfaces;

import project.ua.autobot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepos extends JpaRepository<Category, Long> {}