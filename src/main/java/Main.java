import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Project name(项目名称)：模仿斗地主洗牌发牌小游戏
 * Package(包名): PACKAGE_NAME
 * Class(类名): Main
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/11
 * Time(创建时间)： 20:03
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Main
{
    public static void main(String[] args)
    {
        // 1. 准备牌
        String[] arr1 = {"黑桃", "红桃", "方片", "梅花"};
        String[] arr2 = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<String> arrayBox = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
        {
            for (int j = 0; j < arr2.length; j++)
            {
                arrayBox.add(arr1[i] + arr2[j]);
            }
        }
        arrayBox.add("大王");
        arrayBox.add("小王");
        // 3个人斗地主，分别为 zhangsan、lisi、wangwu
        List<String> zhangsan = new ArrayList<>();
        List<String> lisi = new ArrayList<>();
        List<String> wangwu = new ArrayList<>();
        // 2. 洗牌
        Collections.shuffle(arrayBox);
        //使用默认随机源随机排列指定列表。 所有排列都以大致相等的可能性发生。
        //在前面的描述中使用了“大约”对冲，因为默认随机源只是大约独立选择位的无偏源。 如果它是随机选择的比特的完美来源，那么该算法将选择具有完美一致性的排列。
        //此实现从最后一个元素到第二个元素向后遍历列表，反复将随机选择的元素交换到“当前位置”。 元素是从列表中从第一个元素到当前位置（含）的部分中随机选择的。
        //此方法以线性时间运行。 如果指定列表没有实现RandomAccess接口并且很大，则此实现在打乱之前将指定列表转储到数组中，
        // 并将打乱后的数组转储回列表中。 这避免了因将“顺序访问”列表改组而导致的二次行为。

        // 3. 发牌
        for (int i = 0; i < arrayBox.size() - 3; i++)
        {
            if (i % 3 == 0)
            {
                zhangsan.add(arrayBox.get(i));
            }
            else if (i % 3 == 1)
            {
                lisi.add(arrayBox.get(i));
            }
            else if (i % 3 == 2)
            {
                wangwu.add(arrayBox.get(i));
            }
        }
        // 4. 看牌
        pushBoss();
        System.out.println("张三：" + zhangsan);
        System.out.println("李四：" + lisi);
        System.out.println("王五：" + wangwu);
        System.out.print("底牌：[");
        for (int i = 1; i < 4; i++)
        {
            System.out.print(arrayBox.get(arrayBox.size() - i));
            if (i < 3)
            {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    /**
     * 随机地主
     */
    public static void pushBoss()
    {
        List<String> players = new ArrayList<String>();
        players.add("张三");
        players.add("李四");
        players.add("王五");
        Random r = new Random();
        int bossIndex = r.nextInt(3);
        String boss = players.get(bossIndex);
        System.out.println("此局地主是：" + boss);
    }
}
