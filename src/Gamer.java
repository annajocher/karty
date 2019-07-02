import java.util.LinkedList;
import java.util.List;

public class Gamer {
    List<Card> deck = new LinkedList<>();

    public void addCard(Card card){
        deck.add(card);
    }

    public int countValues(){
        int val=0;
        for(Card card: deck){
            val+=card.getValue();
        }
        return val;
    }

    public boolean doubleA() {
        return deck.size()==2;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Karty: ");
        for(Card card: deck){
            stringBuilder.append(card.toString()+", ");
        }
        stringBuilder.append(" o wartości "+countValues());
        return stringBuilder.toString();
    }

    public int numberCards() {
        return  deck.size();
    }
}
