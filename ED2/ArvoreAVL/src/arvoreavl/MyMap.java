package arvoreavl;

import java.util.Set;

public interface MyMap<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    V get(K key);

    void put(K key, V value);

    V remove(K key);

    void clear();

    Set<K> keySet();
}
