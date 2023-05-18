public class Test {
    public static void main(String[] args) {
      PokerGame pokerGame = new PokerGame();
      pokerGame.startPlayingCards();
      pokerGame.showPlayer();

      Player winner = pokerGame.getWinner();
        System.out.println("获胜者为:"+ winner.getName());
    }
}
