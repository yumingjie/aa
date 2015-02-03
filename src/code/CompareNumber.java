package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yumingjie on 15-2-3.
 * 判断用户输入的参数是否等价于系统的随机数，返回 0A2B | 4A0B 等参数
 */
public class CompareNumber {
    /**
     * 验证用户参数是否正确
     * @param numArg 传入用户输入参数
     */
    private void checkArgs(int numArg) throws Exception{
        Object numObj = numArg;
        if(numObj.toString().length()>4||numObj.toString().length()<4){
            throw new Exception("请输入长度等于4的参数");
        }
    }

    /**
     * 根据用户输入的随机数与系统产生的随机数进行比较
     * @param sysNum 系统产生的随机数
     * @param inputNum 用户输入的随机数
     * @return 返回 0A4B | 4A0B
     */
    public String backPosition(int[] sysNum,int inputNum){
        try{
            checkArgs(inputNum); //检查用户输入的参数是否正确，如果不正确，那么就给出提示
        }catch (Exception e){
            e.printStackTrace();
        }
        int successNum = 0; //数字正确，位置正确的位数
        int errorNum = 0; //数字正确，位置错误的位数
        int[] tempInputNum = splitNum(inputNum);//获取当前用户输入的文字，进行分割为数组
        /*
         * 判断用户的位置和数字是否正确
         */
        for(int i = 0 ; i < sysNum.length;i++){
            int tempSysNumber = sysNum[i];//获取当前系统的数字
            int tempInputNumber = tempInputNum[i];//获取当前用户的数字
            if(tempSysNumber==tempInputNumber){//表示用户的位置正确，并且数字也正确
                successNum++;
            }else{ //否则到话，那么就表示位置不正确，验证数字是否正确
                for(int j = 0 ; j < sysNum.length ; j++){
                    int jNum = sysNum[j];//遍历当前位置不正确到数字
                    if(jNum==tempInputNumber){
                        errorNum++;
                        break;//因为当前随机出来的数字不是重复数字，所以只要有相同的，那么就直接跳出
                    }
                }
            }
        }
        return compare(successNum,errorNum);
    }

    private String compare(int successNum,int errorNum){
        StringBuffer backStr = new StringBuffer();//用户告诉用户当前的结果
        backStr.append(successNum+"A"+errorNum+"B");
        return backStr.toString();
    }

    /**
     * 根据用户输入的数字来进行拆分成数组
     * @param inputNum 传入用户输入的数字
     * @return
     */
    private int[] splitNum(int inputNum){
        Object tempNum = inputNum;
        String numStr = tempNum.toString();
        //返回一个解析好的数组
        int[] returnNum = new int[numStr.length()];
        for(int i = 0 ; i < numStr.length();i++){
            returnNum[i]=Integer.valueOf(numStr.substring(i,(i+1)));
        }
        return returnNum;
    }
}