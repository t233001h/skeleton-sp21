package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends MyArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T max(){
        return max(comparator);
    }

    public T max(Comparator<T> comparator){
        if(isEmpty())
            return null;

        T max = get(0);
        for(int i = 1; i < size(); i++){
            if(comparator.compare(max, get(i)) < 0){
                max = get(i);
            }
        }
        return max;
    }
}