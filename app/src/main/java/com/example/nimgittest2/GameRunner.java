package com.example.nimgittest2;

public class GameRunner {
    private int[] piles;

    public void GameLogic(int dif) {
        // Initialize the game state (number of piles and initial number of items in each pile)
        switch(dif){
            case 1:
                piles = new int[]{1,3,5};
                break;
            case 2:
                piles = new int[]{1,3,5,7};
                break;
            case 3:
                piles = new int[]{3,5,7,9};
                break;
        }
    }

    public boolean makeMove(int pileIndex, int itemCount) {
        // Validate the move
        if (pileIndex < 0 || pileIndex >= piles.length || itemCount <= 0 || itemCount > piles[pileIndex]) {
            return false;
        }

        // Update the game state
        piles[pileIndex] -= itemCount;
        return true;
    }

    public int[] getPiles() {
        return piles;
    }

    public boolean isGameOver() {
        // Check if all piles are empty
        for (int pile : piles) {
            if (pile > 0) {
                return false;
            }
        }
        return true;
    }
}
