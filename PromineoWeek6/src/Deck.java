package PromineoWeek6.src;

import java.util.*;

public class Deck {
    
    private List <Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

        //Add 52 cards 
        for (String suit : suits){
            for (int value = 2; value < 15; value++){
                cards.add(new Card(value,values[value-2] + " of " + suit));
            }
        }

        //Add Jokers
        cards.add(new Card (100, "Joker"));
        cards.add(new Card (100, "Joker"));
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card draw(){
        Card currentCard = cards.get(0);
        cards.remove(cards.get(0));
        return currentCard;
    }

    public int getDeckSize(){
        return cards.size();
    }

}
