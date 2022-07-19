package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 扁平化嵌套列表迭代器 implements Iterator<Integer> {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    Iterator<Integer> iter;

    public 扁平化嵌套列表迭代器(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            traverse(nestedInteger, res);
        }
        this.iter = res.iterator();
    }

    private void traverse(NestedInteger nestedInteger, List<Integer> res) {
        if (nestedInteger.isInteger()) {
            res.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger integer : nestedInteger.getList()) {
                traverse(integer, res);
            }
        }
    }


    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}
