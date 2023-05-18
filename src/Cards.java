import java.util.*;

//扑克牌
public class Cards {
    public List<Card> initCards(){                      //将52张牌创建并加入List集合中
        List<Card> list = new ArrayList<>();            //创建List集合
        for (int i = 1; i < 5; i++) {                   //i对应为花色
            for (int j = 2; j < 15; j++) {              //j对应为数字
                Card card = new Card();                 //在循环中创建扑克牌对象，该代码执行4*13=52次
                card.setColor(i);                       //设置扑克牌花色
                card.setNumber(j);                      //设置扑克牌数字
                list.add(card);                         //将扑克牌加入List集合
            }
        }
        return list;
    }

    //洗牌
    public List<Card> shuffle(List<Card> list){
        List<Card> slist = new ArrayList<>();            //创建List集合,保存洗牌后的扑克
        Random random = new Random();
        while (list.size() > 0){
            int r = random.nextInt(list.size());        //生成正整型的随机数
            Card card = list.remove(r);                 //返回list中，随机数位置的元素并且移除对应位置的元素
            slist.add(card);
        }
        return slist;
    }

    //判断牌型是否为豹子（三张牌的数字都是一致的）
    public boolean isTheSameNumber(List<Card> playList){
        if (playList != null && playList.size() == 3){
            if (playList.get(0).getNumber() == playList.get(1).getNumber()
            && playList.get(1).getNumber() == playList.get(2).getNumber()){
                return true;
            }else{
                return false;
            }
        }else {
            System.err.println("手牌不符合规则");
            throw new RuntimeException("手牌不符合规则");
        }
    }

    //判断牌型是否为同花（三张牌的牌色都是一致的）
    public boolean isFlushColor(List<Card> playList) {
        if (playList != null && playList.size() == 3){
            if (playList.get(0).getColor() == playList.get(1).getColor()
                    && playList.get(1).getColor() == playList.get(2).getColor()){
                return true;
            }else{
                return false;
            }
        }else {
            System.err.println("手牌不符合规则");
            throw new RuntimeException("手牌不符合规则");
        }
    }

    //对手牌进行排序
    public List<Card> playListSort(List<Card> playList){
        playList.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getNumber() - c2.getNumber();
            }
        });
        return playList;
    }

    //判断牌型是否为顺子（三张牌的数字是连续的） （2 3 A）也为顺子
    public boolean isStraight(List<Card> playList) {
        if (playList != null && playList.size() == 3){
            if ((playList.get(0).getNumber() + 1 == playList.get(1).getNumber()
                    && playList.get(1).getNumber() + 1 == playList.get(2).getNumber())
            || (playList.get(2).getNumber() == 14 && playList.get(0).getNumber() == 2 && playList.get(1).getNumber() == 3)){
                return true;
            }else{
                return false;
            }
        }else {
            System.err.println("手牌不符合规则");
            throw new RuntimeException("手牌不符合规则");
        }
    }

    //判断牌型是否为对子（三张牌中有两张牌为相同）
    public boolean isPair(List<Card> playList){
        if (playList != null && playList.size() == 3){
            if (playList.get(0).getNumber() == playList.get(1).getNumber()
                    && playList.get(1).getNumber() == playList.get(2).getNumber()){
                return false;
            }else {
                if (playList.get(0).getNumber() == playList.get(1).getNumber()
                || playList.get(1).getNumber() == playList.get(2).getNumber()){
                    return true;
                }
                return false;
            }
        }
        else {
            System.err.println("手牌不符合规则");
            throw new RuntimeException("手牌不符合规则");
        }
    }

}
