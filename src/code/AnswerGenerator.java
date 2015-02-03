package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yumingjie on 15-2-3.
 * 用于生成4位随机数
 */
public class AnswerGenerator {
    private final static int RANDOM_BIT = 4;//生成多少位随机数

    //存储当前数组的随机数是否相同
    private static List<Integer> numLists = new ArrayList<Integer>();

    /**
     * 生成随机4位数
     * @return 返回一个生成好的四位随机数数组
     */
    public final static int[] randomNumber(){
        int[] randomNums = new int[RANDOM_BIT];//存储当前随机出的数字
        StringBuffer numStr = new StringBuffer();//存储当前产生到随机数
        for(int i =0 ; i < RANDOM_BIT ;i++){
            boolean isRepeat = false;//判断是否有重复数据~~~
            int tempRandomNum = (int)(Math.random()*9);
            for(int j = 0 ; j < randomNums.length;j++) {
                if (randomNums[j] == tempRandomNum) { //如果当前随机出的数字相同,那么就重新循环
                    isRepeat = true;
                    break;
                }
            }
            if(isRepeat){//如果有重复的数据，那么就继续下一次循环
                i--;
                continue;
            }
            randomNums[i] = tempRandomNum;//添加当前到随机数到数组
            numStr.append(tempRandomNum);
        }
        /**
         * 如果随机数相同，那么就重新调用当前方法，直到不同为止
         */
        if(checkRandom(Integer.valueOf(numStr.toString()))){
            return randomNumber();
        }
        return randomNums;//返回一个生成好的四位随机数数组
    }

    /**
     * 检查当前是否连续产生3次的随机数相同
     * @param ranNumber 当前系统产生的随机数
     * @return true表示当前有相同到随机数，false表示没有
     */
    private final static boolean checkRandom(int ranNumber){
        for(int tempNum : numLists){
            if(tempNum==ranNumber){ //检查连续3次到随机数是否相同
                return true;
            }
        }
        if(numLists.size()>3){//如果当前数组有3条数据以上，那么就表示存储了3条不同的数据
            numLists.clear();
        }
        numLists.add(ranNumber);
        return false;
    }

}
