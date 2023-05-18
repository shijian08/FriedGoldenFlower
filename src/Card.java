//扑克牌
public class Card {
    private int color;
    private int number;

    public Card() {
    }

    public Card(int color, int number) {
        this.color = color;
        this.number = number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.colorToString(this.color) +
                this.numberToString(this.number);
    }

    private String colorToString(int i){
        String flower = null;
        switch (i){
            case 1:
                flower = "方块";
                break;
            case 2:
                flower = "梅花";
                break;
            case 3:
                flower = "红心";
                break;
            case 4:
                flower = "黑桃";
                break;
        }
        return flower;
    }

    private String numberToString(int i){
        String num = null;
        switch (i){
            case 11:
                num = "J";
                break;
            case 12:
                num = "Q";
                break;
            case 13:
                num = "K";
                break;
            case 14:
                num = "A";
                break;
            default:
                if (i >= 2 && i <= 10) {
                    num = new Integer(i).toString();
                }else
                    num = "3";
        }
        return num;
    }
}
