package PromineoWeek6.src;

import java.util.*;

public class Player {
    private List<Card> hand;
    private int score;
    private String name;


    public Player(String name) {
        this.hand = new ArrayList<>();
        this.score = 0;
        this.name = name;
    }

    //prints out information about the player and calls the describe method for each card in the Hand List
    public void describe(){
        System.out.println("Player " + name + " has the following cards in their hand: ");
        System.out.println(hand.size());
        for (int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).describe() + " " + i);
            //System.out.println(i);
        }
        // for (Card card : hand){
        //     card.describe();
        //     System.out.println(card.getName());
        // }
    }

    //removes and returns the top card of the Hand
    public Card flip(){
        Card currentCard = hand.get(0);
        hand.remove(0);
        return currentCard;
    }

    //takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field
    public void draw(Deck deck){
        hand.add(deck.draw());
    }

    //adds 1 to the Player’s score field
    public void incrementScore(){
        score++;
    }

    public void addCardToHand (Card card){
        hand.add(card);
    }

    public int getHandSize(){
        return hand.size();
    }
    
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
       
}
