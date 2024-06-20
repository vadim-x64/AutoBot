package project.ua.autobot.interfaces;

import java.util.List;
import project.ua.autobot.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesRepos extends JpaRepository<Types, Long> {
    List<Types> findByName(String typesName);
}