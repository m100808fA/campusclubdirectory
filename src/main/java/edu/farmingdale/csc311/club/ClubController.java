package edu.farmingdale.csc311.club;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @GetMapping
    public List<Club> getClubs(@RequestParam(required = false) String category) {
        if (category != null && !category.isEmpty()) {
            return clubRepository.findByCategoryIgnoreCase(category);
        } else {
            return clubRepository.findAll();
        }
    }

    @GetMapping ("/{id}")
    public Club getClub(@PathVariable Long id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No club with id " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Club createClub(@Valid @RequestBody Club clubDto) {
        Club newClub = new Club(
                clubDto.getName(),
                clubDto.getCategory(),
                clubDto.getMeetingDay(),
                clubDto.getRoom()
        );
        return clubRepository.save(newClub);
    }
}

