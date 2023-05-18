import java.util.*;

//玩家
public class Player {
    private String name;                    //玩家姓名
    private List<Card> handCards;           //玩家手牌
    private int grade;                      //牌型等级

    public Player() {
    }

    public Player(String name, List<Card> handCards, int grade) {
        this.name = name;
        this.handCards = handCards;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        String h = "";
        for (int i = 0; i < this.handCards.size(); i++) {
            h += this.handCards.get(i).toString();
        }
        return this.name + ":" + h;
    }
}
