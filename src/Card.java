public class Card {
    final private String number;
    final private char color;
    final private int value;

    public Card(String number, char color, int value){
        this.number=number;
        this.color=color;
        this.value=value;
    }

    @Override
    public String toString(){
        return number+" "+color;
    }

    public int getValue(){
        return value;
    }
}
