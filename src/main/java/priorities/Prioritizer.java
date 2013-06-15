package priorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.emptyList;

public class Prioritizer {
    private final List<PriorityItem> items;

    public Prioritizer(List<PriorityItem> items) {
        this.items = wrapInListOneCanRemoveItemsFrom(items);
    }

    private ArrayList<PriorityItem> wrapInListOneCanRemoveItemsFrom(List<PriorityItem> items) {
        return new ArrayList<PriorityItem>(items);
    }

    public List<PriorityItem> proritize() {
        if (items.isEmpty())
            return emptyList();
        final int maxPriority = findMaxPriorityInItems();

        List<PriorityItem> allWithPriority = findAllItemsWithPriority(maxPriority);
        items.removeAll(allWithPriority);
        return allWithPriority;
    }

    private int findMaxPriorityInItems() {
        return Collections.max(items, compareByPriority()).getPriority();
    }

    private List<PriorityItem> findAllItemsWithPriority(int priority) {
        List<PriorityItem> allWithGivenPriority = new ArrayList<PriorityItem>();
        for (PriorityItem item : items) {
            if (item.getPriority() == priority) {
                allWithGivenPriority.add(item);
            }
        }
        return allWithGivenPriority;
    }

    private Comparator<PriorityItem> compareByPriority() {
        return new Comparator<PriorityItem>() {
            @Override
            public int compare(PriorityItem o1, PriorityItem o2) {
                return o1.getPriority() - o2.getPriority();
            }
        };
    }
}
