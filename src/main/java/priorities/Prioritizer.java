package priorities;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Collections.emptyList;
import static java.util.Collections.reverseOrder;

public class Prioritizer {
    private final PriorityQueue<PriorityItem> queue;

    public Prioritizer(List<PriorityItem> items) {
        int initialSize = (items.isEmpty()) ? 1 : items.size(); //cannot create a queue with size 0.
        this.queue = new PriorityQueue<PriorityItem>(initialSize, reverseOrder());
        this.queue.addAll(items);
    }

    public List<PriorityItem> prioritize() {
        if (queue.isEmpty())
            return emptyList();
        else
            return getAllItemsWithHighestPriority();
    }

    private List<PriorityItem> getAllItemsWithHighestPriority(){
        List<PriorityItem> items = new ArrayList<PriorityItem>();
        PriorityItem firstItem = queue.poll();
        items.add(firstItem);
        while (!queue.isEmpty() && (queue.peek().getPriority() == firstItem.getPriority()))
            items.add(queue.poll());
        return items;
    }
}
