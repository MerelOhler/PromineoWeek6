package PromineoWeek6.src;

public class Card {
    private int value;
    private String name;

    public Card(int value, String cardName) {
        this.value = value;
        this.name = cardName;
    }

    public String describe(){
        return name;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   
}
