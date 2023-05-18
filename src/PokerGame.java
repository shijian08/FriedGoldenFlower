import java.util.*;

public class PokerGame {
    private Player p1;                                  //玩家1
    private Player p2;                                  //玩家2

    public void startPlayingCards(){                    //开始游戏

        p1 = new Player();                              //创建玩家
        p1.setName("Liu");

        p2 = new Player();                              //创建玩家
        p2.setName("Li");

        Cards cards = new Cards();                      //创建扑克牌
        List<Card> list = cards.initCards();

        List<Card> slist = cards.shuffle(list);         //洗牌

        List<Card> playlist1 = new ArrayList<>();        //发牌
        for (int i = 0; i < 3; i++) {
            Card card = slist.remove(0);
            playlist1.add(card);
            p1.setHandCards(playlist1);
        }

        List<Card> playlist2 = new ArrayList<>();        //发牌
        for (int i = 0; i < 3; i++) {
            Card card = slist.remove(0);
            playlist2.add(card);
            p2.setHandCards(playlist2);
        }

        List<Card> card1 = cards.playListSort(p1.getHandCards());       //手牌排序
        p1.setHandCards(card1);

        List<Card> card2 = cards.playListSort(p2.getHandCards());       //手牌排序
        p2.setHandCards(card2);
    }

    //查看玩家手中的牌
    public void showPlayer(){
        String cardType1 = this.getCardType(p1);
        String cardType2 = this.getCardType(p2);

        System.out.println(p1.toString() + " 牌型为:" + cardType1);
        System.out.println(p2.toString() + " 牌型为:" + cardType2);
    }

    //判断手中牌型
    private String getCardType(Player p){
        List<Card> cardList = p .getHandCards();
        Cards cards = new Cards();
        String cardType = "单张";

        if (cards.isTheSameNumber(cardList)){
            cardType = "豹子";
            p.setGrade(6);
            return cardType;
        }

        if (cards.isFlushColor(cardList)){
            if (cards.isStraight(cardList)){
                cardType = "同花顺";
                p.setGrade(5);
                return cardType;
            }else {
                cardType = "同花";
                p.setGrade(4);
                return cardType;
            }
        }else {
            if (cards.isStraight(cardList)){
                cardType = "顺子";
                p.setGrade(3);
                return cardType;
            }
        }

        if (cards.isPair(cardList)){
            cardType = "对子";
            p.setGrade(2);
            return cardType;
        }

        p.setGrade(1);
        return cardType;
    }

    //判断手牌大小
    public Player getWinner(){
        int grade1 = p1.getGrade();
        int grade2 = p2.getGrade();

        Player winner = grade1 > grade2 ? p1 : p2;
        if (grade1 != grade2){
            return grade1 > grade2 ? p1 : p2;
        }
        switch (grade1){
            case 6:                     //豹子
                winner =  p1.getHandCards().get(0).getNumber() > p2.getHandCards().get(0).getNumber() ? p1 : p2;
                break;
            case 5:                    //同花顺
            case 3:                    //顺子
                winner =  p1.getHandCards().get(0).getNumber() > p2.getHandCards().get(0).getNumber() ? p1 : p2;
                break;
            case 4:                    //同花
            case 1:                    //单张
             if (p1.getHandCards().get(2).getNumber() > p2.getHandCards().get(2).getNumber()){
                 winner = p1;
             }else if (p1.getHandCards().get(2).getNumber() == p2.getHandCards().get(2).getNumber()){
                 if (p1.getHandCards().get(1).getNumber() > p2.getHandCards().get(1).getNumber()){
                     winner = p1;
                 }else if (p1.getHandCards().get(1).getNumber() == p2.getHandCards().get(1).getNumber()){
                     if (p1.getHandCards().get(0).getNumber() > p2.getHandCards().get(0).getNumber()){
                         winner = p1;
                     }else if (p1.getHandCards().get(0).getNumber() == p2.getHandCards().get(0).getNumber()){
                         winner = p2;
                     }else {winner = p2;}
                 }else {winner = p2;}
             }else {winner = p2;}
             break;
            case 2:                 //对子
                winner =  p1.getHandCards().get(1).getNumber() > p2.getHandCards().get(1).getNumber() ? p1 : p2;
                break;
        }

        return winner;
    }
}
