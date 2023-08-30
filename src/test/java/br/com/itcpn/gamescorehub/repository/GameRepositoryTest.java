package br.com.itcpn.gamescorehub.repository;

import br.com.itcpn.gamescorehub.domain.categorie.Categorie;
import br.com.itcpn.gamescorehub.domain.game.Game;
import br.com.itcpn.gamescorehub.domain.platform.Platform;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private CategorieRepository categorieRepository;


    @BeforeEach
    void setUp() {
        List<Platform> platforms = persistPlatform();
        List<Categorie> categories = persistCategories();
        persistGames(platforms, categories);
    }

    @Test
    @DisplayName("Find all games with like the name")
    public void testFindAllLikeName() {
        List<Game> games = gameRepository.findAllLikeName("Co");

        assertEquals(1, games.size());
    }

    @Test
    @DisplayName("Find all games by year")
    public void testFindGamesByYear() {
        List<Game> games = gameRepository.findGamesByYear(2007);

        assertEquals(2, games.size());
    }

    @Test
    @DisplayName("Find all games by age classification")
    public void testFindGamesByAge() {

        List<Game> games = gameRepository.findGamesByAge("18");

        assertEquals(3, games.size());
    }

    @Test
    @DisplayName("Find all games ordered by critics note")
    public void testFindAllGamesOrderByCriticsNote() {
        List<Game> games = gameRepository.findAllGamesOrderByCriticsNote();

        assertEquals(4, games.size());
        assertEquals(99, games.get(0).getCriticsNote());
        assertEquals(99, games.get(1).getCriticsNote());
        assertEquals(98, games.get(2).getCriticsNote());
        assertEquals(98, games.get(3).getCriticsNote());
    }

    @Test
    @DisplayName("Find all games ordered by release year desc")
    public void testFindAllGamesOrderByYear() {
        List<Game> games = gameRepository.findAllGamesOrderByYear();

        assertEquals(4, games.size());
        assertEquals(2015, games.get(0).getReleaseYear().getYear());
        assertEquals(2009, games.get(1).getReleaseYear().getYear());
        assertEquals(2007, games.get(2).getReleaseYear().getYear());
        assertEquals(2007, games.get(3).getReleaseYear().getYear());
    }

    @Test
    @DisplayName("Find game by determined name")
    public void testFindByName() {
        Game foundGame = gameRepository.findByName("Minecraft");

        assertEquals("Minecraft", foundGame.getName());
    }

    List<Platform> persistPlatform() {
        List<Platform> platforms = new ArrayList<>(
                Arrays.asList(
                        new Platform(null, "PC", null),
                        new Platform(null, "Playstation", null),
                        new Platform(null, "Xbox", null)
        ));

        return platformRepository.saveAll(platforms);
    }

    List<Categorie> persistCategories() {
        List<Categorie> categories = new ArrayList<>(
                Arrays.asList(
                        new Categorie(null, "FPS", null),
                        new Categorie(null, "Indie", null),
                        new Categorie(null, "RPG", null)
        ));

        return categorieRepository.saveAll(categories);
    }

    void persistGames(List<Platform> platforms, List<Categorie> categories) {
        Set<Categorie> categorieSet = new HashSet<>();
        Set<Platform> platformSet = new HashSet<>();

        categorieSet.add(categories.get(0));
        categorieSet.add(categories.get(1));
        categorieSet.add(categories.get(2));

        platformSet.add(platforms.get(0));
        platformSet.add(platforms.get(1));
        platformSet.add(platforms.get(2));

        List<Game> games = new ArrayList<>(
                Arrays.asList(
                        new Game(null, "Counter Strike","A FPS game" ,
                                LocalDate.of(2007, 11,8),
                                "18",
                                "https://i.ytimg.com/vi/W4rYbl1zAj4/maxresdefault.jpg",
                                98,
                                "Jess Cliffee",
                                platformSet,
                                categorieSet,
                                null,
                                null),
                        new Game(null, "Minecraft", "A Indie game",
                                LocalDate.of(2009, 5,17),
                                "10",
                                "https://i.ytimg.com/vi/W4rYbl1zAj4/maxresdefault.jpg",
                                99,
                                "Mojang",
                                platformSet,
                                categorieSet,
                                null,
                                null),
                        new Game(null, "The Witcher 3", "A RPG game",
                                LocalDate.of(2015, 5,19),
                                "18",
                                "https://i.ytimg.com/vi/W4rYbl1zAj4/maxresdefault.jpg",
                                99,
                                "CD Projekt Red",
                                platformSet,
                                categorieSet,
                                null,
                                null),
                        new Game(null, "CS:GO","A FPS game" ,
                                LocalDate.of(2007, 11,8),
                                "18",
                                "https://i.ytimg.com/vi/W4rYbl1zAj4/maxresdefault.jpg",
                                98,
                                "Jess Cliffee",
                                platformSet,
                                categorieSet,
                                null,
                                null)
        ));

        gameRepository.saveAll(games);
    }
}