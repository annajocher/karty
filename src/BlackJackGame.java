import java.util.*;

public class BlackJackGame {
    public static char[] colors={'h','d','c','s'};
    //heart kier, diamon karo, club trefl, spade pik
    public static char[] figures={'A','J','Q','K'};
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        for(int i=2; i<11; i++){
            for(char c: colors){
                cards.add(new Card(String.valueOf(i), c, i));
            }
        }
        for(char figure: figures){
            for(char c: colors){
                if(figure !='A') {
                    cards.add(new Card(String.valueOf(figure), c, 10));
                }else{
                    cards.add(new Card(String.valueOf(figure), c, 11));

                }
            }
        }
        Collections.shuffle(cards);

        //uzyjemy stosu dla kart zeby pobierac u isuwac od razu

        Stack<Card> stack= new Stack<>();
        stack.addAll(cards);
        Gamer player=new Gamer();
        Gamer croupier=new Gamer();
        Arbiter arbiter=new Arbiter();

        player.addCard(stack.pop());
        player.addCard(stack.pop());

        char answer =' ';

        Scanner scanner=new Scanner(System.in);

        System.out.println(player.toString());

        do{
            System.out.print("Wpisz N jesli nastepna karte, "+
                    "w przeciwnym wypadku dowolny klawisz");
            answer=scanner.next().trim().charAt(0);
            if(answer=='n'||answer=='N') {
                player.addCard(stack.pop());
                System.out.println(player.toString());

            }
            if(arbiter.exceed(player)){
                System.out.print("Przegrales!");
                System.exit(0);
            }
        }while(answer=='n'||answer=='N');

        croupier.addCard(stack.pop());
        croupier.addCard(stack.pop());

        while(croupier.countValues()<17){
            croupier.addCard(stack.pop());
        }

        System.out.println("Krupier");
        System.out.println(croupier.toString());

        if(arbiter.exceed(croupier)){
            System.out.print("Wygrales Krupier przekroczyl limit!");
        }else{
            int wynik=arbiter.whoWins(player,croupier);
            if(wynik==1){
                System.out.println("Wygrales!");
            }else{
                System.out.print("Przegrales!");
            }
        }
    }
}
