package project.ua.autobot.interfaces;

import project.ua.autobot.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepos extends JpaRepository<History, Long> {}