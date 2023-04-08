public class MyOrderedList<Type extends  Comparable<Type>> {
    protected MyArrayList<Type> list;
    public long comparisons;

    public MyOrderedList(MyArrayList<Type> list, long comparisons) {
        this.list = list;
        this.comparisons = comparisons;
    }

    public void add(Type item){
        Type temp = null;
        list.insert(item, list.size);
        for (int i = list.size; i > 0; i--){
            if (list.get(i-1).compareTo(list.get(i)) > 0){
                temp = list.get(i-1);
                list.set(i-1, list.get(i));
                list.set(i, temp);
            }
        }
    }

    public Type remove(Type item){
        for (int i = 0; i < list.size(); i++){
            if (list.contains(item)){
                return remove(item);
            }
        }
        return null;
    }

    public boolean binarySearch(Type item){
        
    }

}
