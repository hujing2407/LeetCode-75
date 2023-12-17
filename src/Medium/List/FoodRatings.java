package Medium.List;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Jing Hu
 * @date Dec. 17 2023
 */
public class FoodRatings {
    public class Info {
        String food;
        String cuisine;
        int rating;

        public Info(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    HashMap<String, Info> foodMap = null;
    HashMap<String, PriorityQueue<Info>> highestMap = null;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        this.foodMap = new HashMap<>();
        this.highestMap = new HashMap<>();

        for (int i = 0; i < ratings.length; i++) {
            Info info = new Info(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i], info);

            if (highestMap.containsKey(cuisines[i])) {
                highestMap.get(cuisines[i]).add(info);
            } else {
                PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
                    @Override
                    public int compare(Info o1, Info o2) {
                        int res = o1.rating - o2.rating;
                        if(res == 0) return o1.food.compareTo(o2.food);
                        return res;
                    }
                });
                pq.add(info);
                highestMap.put(cuisines[i], pq);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Info prev = foodMap.get(food);
        Info curr = new Info(food, prev.cuisine, newRating);
        foodMap.put(food,curr);
        highestMap.get(prev.cuisine).add(curr);
        prev.food = "";
    }

    public String highestRated(String cuisine) {
        while(highestMap.get(cuisine).peek().food.equals("")) highestMap.get(cuisine).remove();
        return highestMap.get(cuisine).peek().food;
    }
}
