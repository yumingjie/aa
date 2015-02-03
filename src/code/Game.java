package code;

import java.util.Scanner;

/**
 * Created by yumingjie on 15-2-3.
 * 游戏启动类
 */
public class Game {

    /**
     * 启动游戏
     */
    public void startGame(){
        Scanner input = new Scanner(System.in);
        CompareNumber compareNumber = new CompareNumber();
        int gameCount = 6; //当前游戏次数为６次
        System.out.println("Welcome");
        while((gameCount--)>0){//当前游戏循环运行６次
            System.out.print("Please input your number(" + (gameCount+1) + "):");
            int inputNumber = input.nextInt();//用户输入的４位码
            String result = compareNumber.backPosition(AnswerGenerator.randomNumber(),inputNumber);
            if(result.equals("4A0B")){
                System.out.println("Congratulations");
                break;
            }
            System.out.println(result);
            if(gameCount==0){
                System.out.println("Game Over");
            }
        }
        input.close();//关闭输入　释放内存
        input = null;
    }
}