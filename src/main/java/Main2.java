import java.util.*;

/**
 * Project name(项目名称)：模仿斗地主洗牌发牌小游戏
 * Package(包名): PACKAGE_NAME
 * Class(类名): Main2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/11
 * Time(创建时间)： 20:04
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Main2
{
    public static void main(String[] args)
    {
        // 1.准备牌
        String[] arr1 = {"黑桃", "红桃", "方片", "梅花"};
        String[] arr2 = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // 定义Map集合用来存放索引和牌
        HashMap<Integer, String> pokerMap = new HashMap<>();
        // 定义List集合存储索引（索引为0-53）
        List<Integer> indexList = new ArrayList<>();
        // 定义索引值变量
        int index = 0;
        // 将扑克牌与索引建立对应关系放入Map和List集合中
        for (String num : arr2)
        {
            for (String color : arr1)
            {
                pokerMap.put(index, color + num);
                indexList.add(index);
                index++;
            }
        }
        pokerMap.put(index, "小王");
        indexList.add(index++);
        pokerMap.put(index, "大王");
        indexList.add(index);
        // 定义玩家
        TreeSet<Integer> zhangsan = new TreeSet<>();
        TreeSet<Integer> lisi = new TreeSet<>();
        TreeSet<Integer> wangwu = new TreeSet<>();
        TreeSet<Integer> buttoms = new TreeSet<>();
        // 2. 洗牌
        Collections.shuffle(indexList);
        // 3. 发牌
        for (int i = 0; i < indexList.size(); i++)
        {
            if (i >= indexList.size() - 3)
            {
                buttoms.add(indexList.get(i));
            }
            else if (i % 3 == 0)
            {
                zhangsan.add(indexList.get(i));
            }
            else if (i % 3 == 1)
            {
                lisi.add(indexList.get(i));
            }
            else
            {
                wangwu.add(indexList.get(i));
            }
        }
        // 4. 看牌
        pushBoss();
        check(pokerMap, zhangsan, "张三");
        check(pokerMap, lisi, "李四");
        check(pokerMap, wangwu, "王五");
        check(pokerMap, buttoms, "底牌");
    }

    /**
     * 看牌
     *
     * @param pokerMap
     * @param player   玩家扑克牌对应索引集合
     * @param name     玩家昵称
     */
    public static void check(HashMap<Integer, String> pokerMap, TreeSet<Integer> player, String name)
    {
        // 查看手中的牌
        System.out.print(name + "：[");
        for (Integer i : player)
        {
            System.out.print(pokerMap.get(i) + " ");
        }
        System.out.println("]");
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
