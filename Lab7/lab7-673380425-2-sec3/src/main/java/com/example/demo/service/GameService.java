package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.GameRepository;
import com.example.demo.strategy.DiscountContext;
import com.example.demo.model.Game;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final DiscountContext discountContext;

    public GameService(GameRepository gameRepository, DiscountContext discountContext) {
        this.gameRepository = gameRepository;
        this.discountContext = discountContext;
    }

    public Iterable<Game> getAllGames() {
        Iterable<Game> games = gameRepository.findAll();
        for (Game game : games) {
            double finalPrice = discountContext.applyDiscount(
                    game.getPrice(),
                    game.getDiscountType());
            String discountName = discountContext.getDisplayName(
                    game.getDiscountType());
            game.setFinalPrice(finalPrice);
            game.setDiscountName(discountName);
        }
        return games;
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public double getFinalPrice(Game game) {
        return discountContext.applyDiscount(game.getPrice(), game.getDiscountType());
    }
}
