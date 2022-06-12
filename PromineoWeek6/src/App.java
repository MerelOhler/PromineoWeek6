package PromineoWeek6.src;

import java.util.*;

public class App {
	static Player player1;
	static Player player2;
	static boolean afterWar;
	
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();
        player1 = new Player("Menno");
        player2 = new Player("Otto");
        boolean keepPlaying = true;
        List<Card> cardsOnTable = new ArrayList<>();

        deck.shuffle();

        //deal the deck to the players
        for (int i = 0; i < 54; i++){
            if (i%2 == 0){
                player1.draw(deck);
            }else{
                player2.draw(deck);
            }
        }

        player1.describe();
        player2.describe();

        //play the game
        while (keepPlaying == true){
            int cards = play(cardsOnTable);
            keepPlaying = (cards != 0 || afterWar == true);
        }
        
        //decide who the winner is
        System.out.println(player1.getName() + ": " + player1.getHandSize());
        System.out.println(player2.getName() + ": " + player2.getHandSize());
        System.out.println("Cards on the table: " + cardsOnTable.size());
        if (player1.getHandSize() > player2.getHandSize()) {
        	System.out.println(player1.getName() + " WINS!!!!");
        }else {
        	System.out.println(player2.getName() + " WINS!!!!");
        }
    }//end main

    private static void addCardsToHand (Player player, List<Card> cardsOnTable){
        for (Card card : cardsOnTable){
            player.addCardToHand(card);
        }
    }

    private static int play (List<Card> cardsOnTable){
    	Card player1Card;
    	Card player2Card;
    	
        if (player1.getHandSize() == 0 || player2.getHandSize() == 0){
        	cardsOnTable.clear();
            return cardsOnTable.size();
        }

        if (cardsOnTable.size() <= 2) {
        	afterWar = false;
        	cardsOnTable.clear();
            player1Card = player1.flip();
            player2Card = player2.flip();
            cardsOnTable.add(player1Card);
            cardsOnTable.add(player2Card);
        } else {
        	afterWar = true;
        	player1Card = cardsOnTable.get(cardsOnTable.size()-2);
        	player2Card = cardsOnTable.get(cardsOnTable.size()-1);
        }


        System.out.println(player1.getName() + " played " + player1Card.getName());
        System.out.println(player2.getName() + " played " + player2Card.getName());

        if(player1Card.getValue() > player2Card.getValue()){
            player1.incrementScore();
            addCardsToHand(player1, cardsOnTable);
            getScore();
            if (afterWar) {
            	cardsOnTable.clear();
            }
        } else if (player1Card.getValue() < player2Card.getValue()){
            player2.incrementScore();
            addCardsToHand(player2, cardsOnTable);
            getScore();
            if (afterWar) {
            	cardsOnTable.clear();
            }
        } else { //we go to war!
        	System.out.println("THIS IS WAR!!!!");
        	//check if each player has enough cards for war
            if (player1.getHandSize() < 3 || player2.getHandSize() < 3) {
            	System.out.println("Cannot finnish the war.");
            	afterWar = false;
            	return 0;
            }
        	
            for (int i = 1; i <3; i++){
                player1Card = player1.flip();
                player2Card = player2.flip();
                cardsOnTable.add(player1Card);
                cardsOnTable.add(player2Card);
                
                System.out.println(player1.getName() + " played " + player1Card.getName());
                System.out.println(player2.getName() + " played " + player2Card.getName());
                System.out.println();
            }
            return cardsOnTable.size();
        }

        return cardsOnTable.size();
    }
    
    private static void getScore() {
    	System.out.println(player1.getName() + " has " + player1.getHandSize() + " cards in their hand.");
    	System.out.println(player2.getName() + " has " + player2.getHandSize() + " cards in their hand.");
        System.out.println();
    }
}
