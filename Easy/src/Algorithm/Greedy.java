package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Sep. 02 2023
 */
public class Greedy {
  public static void main(String[] args) {
    //创建广播电台,放入到Map
    HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
    //将各个电台放入到broadcasts
    HashSet<String> hashSet1 = new HashSet<String>();
    hashSet1.add("北京");
    hashSet1.add("上海");
    hashSet1.add("天津");

    HashSet<String> hashSet2 = new HashSet<String>();
    hashSet2.add("广州");
    hashSet2.add("北京");
    hashSet2.add("深圳");

    HashSet<String> hashSet3 = new HashSet<String>();
    hashSet3.add("成都");
    hashSet3.add("上海");
    hashSet3.add("杭州");


    HashSet<String> hashSet4 = new HashSet<String>();
    hashSet4.add("上海");
    hashSet4.add("天津");

    HashSet<String> hashSet5 = new HashSet<String>();
    hashSet5.add("杭州");
    hashSet5.add("大连");

    //加入到map
    broadcasts.put("K1", hashSet1);
    broadcasts.put("K2", hashSet2);
    broadcasts.put("K3", hashSet3);
    broadcasts.put("K4", hashSet4);
    broadcasts.put("K5", hashSet5);

    //allAreas 存放所有的地区
    HashSet<String> allAreas = new HashSet<String>();
    allAreas.add("北京");
    allAreas.add("上海");
    allAreas.add("天津");
    allAreas.add("广州");
    allAreas.add("深圳");
    allAreas.add("成都");
    allAreas.add("杭州");
    allAreas.add("大连");

    ArrayList<String> selected = new ArrayList<>();
    HashSet<String> tempSet = new HashSet<>();

    String maxKey = null;
    while (!allAreas.isEmpty()) {
      maxKey = null;
      for (String key : broadcasts.keySet()) {

        tempSet.clear();
        tempSet.addAll(broadcasts.get(key));
        tempSet.retainAll(allAreas);

        if (!tempSet.isEmpty() &&
            (maxKey ==null || tempSet.size() > broadcasts.get(maxKey).size())) {
          maxKey = key;
        }
      }

      if (maxKey != null) {
        selected.add(maxKey);
        allAreas.removeAll(broadcasts.get(maxKey));
      }

    }
    System.out.println(selected);
  }
}

