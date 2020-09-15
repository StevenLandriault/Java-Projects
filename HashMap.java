import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

    private long			getLoops;
    private long			putLoops;
    private int       tableSize;

    private List< List<Entry<K,V>> > 	table;
    private int			count;

    public HashMap() {
        tableSize = 1000003; // prime number
        table = new ArrayList<List<Entry<K,V>>>(tableSize);
        // initializes table as a list of empty lists
        for (int i = 0; i < tableSize; i++)
            table.add(new LinkedList<Entry<K,V>>());
        count = 0;

        resetGetLoops();
        resetPutLoops();
    }

    public long getGetLoopCount() {
        return getLoops;
    }

    public long getPutLoopCount() {
        return putLoops;
    }

    public void resetGetLoops() {
        getLoops = 0;
    }
    public void resetPutLoops() {
        putLoops = 0;
    }

    public boolean containsKey(K key) {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
        ListIterator<Entry<K,V>> cur = table.get(index).listIterator();
        while(cur.hasNext()){
            Entry<K,V> curEntry = cur.next();
            if(curEntry.key.compareTo(key) == 0){
                return true;
            }
            cur.next();
        }

        return false;
    }

    public V get (K key) throws KeyNotFoundException {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
        ListIterator<Entry<K,V>> cur = table.get(index).listIterator();
        
        while(cur.hasNext()){
            Entry<K,V> curEntry = cur.next();
            if(curEntry.key.compareTo(key) == 0){
                return curEntry.value;
            }
            cur.next();
        }
        throw new KeyNotFoundException();

    }

    public List<Entry<K,V> >	entryList() {
        List <Entry<K,V>> l = new LinkedList<Entry<K,V>>();
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through every index in the table
        //      use a second Iterator to go through each element in a chain at a specific index
        //      and add each element to l
        ListIterator<List<Entry<K,V>>> bigList = table.listIterator();
        while(bigList.hasNext()){
            ListIterator<Entry<K,V>> smallList = bigList.next().listIterator();
            while(smallList.hasNext()){
                Entry<K,V> element = smallList.next();
                if(element != null){
                l.add(element);
                }
        }
        }

        return l;
    }

    public void put (K key, V value){
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode())%tableSize; //index = bucket
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
        //  if key is found, update value.  if key is not found add a new Entry with key,value
        ListIterator<Entry<K,V>> cur = table.get(index).listIterator();
        Entry<K,V> node = new Entry<K,V>(key, value);
        while(cur.hasNext()){
            Entry<K,V> curHead = cur.next();
            if(curHead.key.compareTo(key) == 0){
                curHead.value = value;
                return;
            }
            cur.next();
        }
        cur.add(node);
        count++;

        

    }

    public int size() {
        return count;
    }

    public void clear() {
        table.clear();
        count = 0;
    }

}

