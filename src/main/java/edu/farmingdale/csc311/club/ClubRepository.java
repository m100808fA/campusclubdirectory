package edu.farmingdale.csc311.club;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> findByCategoryIgnoreCase(String category);
}
