package Medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Jing Hu
 * @date Nov. 23 2023
 */
//public class LRUCache extends LinkedHashMap<Integer,Integer> {
//  private int capacity;
//
//  public LRUCache(int capacity) {
//    super(capacity,0.75f,true);
//    this.capacity = capacity;
//  }
//
//  public int get(int key) {
//    return super.getOrDefault(key,-1);
//  }
//
//  public void put(int key, int value) {
//    super.put(key,value);
//  }
//
//  @Override
//  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//    return size() > capacity;
//  }
//}

class LRUCache {
  class DLNode {

    int key;
    int value;
    DLNode prev;
    DLNode next;

    public DLNode() {
    }

    public DLNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity, size;
  private DLNode head, tail;
  private HashMap<Integer, DLNode> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.head = new DLNode();
    this.tail = new DLNode();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    DLNode temp = map.get(key);
    if (temp == null) return -1;
    moveToHead(temp);
    return temp.value;
  }

  public void put(int key, int value) {
    DLNode temp = map.get(key);
    if (temp == null) {
      temp = new DLNode(key, value);
      map.put(key, temp);
      addToHead(temp);
      ++size;
      if (size > capacity) {
        DLNode node = removeTail();
        map.remove(node.key);
        --size;
      }
    } else {
      temp.value = value;
      moveToHead(temp);
    }
  }

  private void moveToHead(DLNode temp) {
    removeNode(temp);
    addToHead(temp);
  }

  private DLNode removeTail() {
    DLNode temp = tail.prev;
    removeNode(temp);
    return temp;
  }

  private void removeNode(DLNode temp) {
    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;
  }

  private void addToHead(DLNode temp) {
    temp.next = head.next;
    temp.prev = head;
    head.next.prev = temp;
    head.next = temp;
  }
}

