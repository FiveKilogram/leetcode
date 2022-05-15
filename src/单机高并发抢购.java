import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class 单机高并发抢购 {
    private static final Integer GOODS_NUM = 1000;
    private static AtomicInteger num = new AtomicInteger(GOODS_NUM);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static int buyNum = 3;
    private static HashMap<String,Integer> map = new HashMap();


    public static void main(String[] args) {
        单机高并发抢购 userBuy = new 单机高并发抢购();
        while (true){
            new Thread(()-> userBuy.buy((int)(Math.random()*500)+"用户")).start();
        }
    }

    private  void buy(String userName){
        //重置数量
        if((System.currentTimeMillis()%86400000)==0){
            num.getAndSet(GOODS_NUM);
        }

        //日期加名字
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String userKey = dateString+userName;

        if(num.get()<=0){
            System.out.println("抢购失败"+"--"+num);
            return;
        }
        if(map.containsKey(userKey)&&map.get(userKey)>=buyNum){
            System.out.println("抢购失败"+"--"+num);
            return;
        }

        synchronized (this){
            if(map.containsKey(userKey)){
                //模拟用户购买数量
                int goodsNum =  (int)(Math.random()*2) +1 + map.get(userKey);
                if(goodsNum>3){
                    System.out.println("抢购失败");
                    System.out.println(userKey+"--"+goodsNum+"--"+num+"--"+"用户已抢购数量"+map.get(userKey));
                    return;
                }else {
                    map.put(userKey,goodsNum);
                    System.out.println(userKey+"--"+goodsNum+"--"+num+"--"+"用户已抢购数量"+map.get(userKey));
                }
            }else {
                int goodsNum =  (int)(Math.random()*2) +1;
                if(goodsNum>=3){
                    System.out.println("抢购失败");
                    return;
                }else {
                    map.put(userKey,goodsNum);
                    System.out.println(userKey+"--"+goodsNum+"--"+num+"--"+"用户已抢购数量"+map.get(userKey));
                }


            }
        }
        num.getAndDecrement();
    }

}
