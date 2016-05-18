package ch00.se00;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ThreeDoorProblem {

    /**
     * 验证经典的三门问题
     */
    @Test
    public void threeDoorSelect() {
        int n = 10000;// 尝试的次数
        int winCount = 0;// 嘉宾选择不换，赢的次数
        int[] doors = new int[3];
        int[] count = new int[3];
        Random r = new Random();

        for (int time=0; time < n; time++) {
            int originChoose;// 嘉宾第一次的选择
            int chairmanChoose;// 主持人打开的门

            // 初始化每个门后面是否有奖品，0表示无，1表示有
            int has = r.nextInt(3);
            doors[has] = 1;
            count[has]++;
            for (int i=0; i<doors.length; i++) {
                if (i != has) {
                    doors[i] = 0;
                }
            }
            System.out.println("初始化数据情况：" + Arrays.toString(doors));

            // 嘉宾开始选择其中一个门
            originChoose = r.nextInt(3);
            System.out.println("嘉宾选择了 " + (originChoose+1) + " 号门");
            // 主持人选择一个没有奖品的门打开，问嘉宾换不换
            for (int i = 0; i<doors.length; i++) {
                if (i != has && i != originChoose) {
                    chairmanChoose = i;
                    System.out.println("主持人选择了 " + (chairmanChoose+1) + " 号门打开，无奖品");
                    break;
                }
            }
            // 嘉宾表示不换。现在让我们来开奖
            if (doors[originChoose] == 1) {
                System.out.println("第"+(time+1)+"次实验，嘉宾赢了");
                winCount++;
            } else {
                System.out.println("第"+(time+1)+"次实验，嘉宾输了");
            }
        }

        System.out.println("总共 "+ n + " 次实验，嘉宾赢了 " +winCount+ " 次，概率为：" + winCount + "/" + n);
        System.out.println(Arrays.toString(count));
    }

}
