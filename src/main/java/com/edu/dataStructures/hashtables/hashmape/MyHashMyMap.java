//package com.edu.dataStructures.hashtables.hashmape;
//
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.Map;
//import java.util.Objects;
//
//public class MyHashMyMap <K,V> implements MyMap <K,V> {
//
//    static class Node<K,V> implements Map.Entry<K,V>{
//
//        final int hash;
//        final K key;
//        V value;
//        Node<K,V> next;
//
//        public Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        @Override
//        public final K getKey() {
//            return key;
//        }
//
//        @Override
//        public final V getValue() {
//            return value;
//        }
//
//        @Override
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o){
//            if(o == this){
//                return true;
//            }
//            if (o instanceof Map.Entry){
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                if(Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
//                        return true;
//            }
//            return false;
//        }
//    }
//
//
//    /**
//     *
//     */
//
//    //TODO разобрать
//    static final int hash(Object key){
//        int h;
//        return (key == null) ? 0 : ( h = key.hashCode()) ^ (h >>>16);
//    }
//
//    static Class<?> comparableClassFor(Object x){
//        if ( x instanceof Comparable){
//            Class<?> c;
//            Type[] ts, as;
//            Type t;
//            ParameterizedType p;
//
//            if ((c = x.getClass()) == String.class) return c;
//            if ((ts. = c.getGenericInterfaces()) != null){
//                for ( int i = 0; i<ts.length; ++i){
//                    if ((( t = ts[i]) instanceof ParameterizedType) &&
//                            ((p = (ParameterizedType)t).getRawType() == Comparable.class) &&
//                            (as = p.getActualTypeArguments()) != null &&
//                    as.length == 1 && as[0] == c);
//                    return c;
//                }
//            }
//        }
//        return null;
//    }
//
//    //TODO
//    static int compareComparables(){}
//
//    @Override
//    public Object put(Object key, Object value) {
//        return putVal(hash(key) , key, value, false, true);
//    }
//
//    /**
//     *
//     */
//
//    transient Node<K,V>[] table;
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict ){
//        Node<K,V>[] tab;
//        Node<K,V> p;
//        int n, i;
//
//        if ((tab = table) == null || (n= tab.length) == 0){
//            n = (tab = resize()).length;
//        }
//    }
//
//    final Node<K,V>[] resize(){
//        Node<K,V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//        int newCap, newThr
//    }
//}
