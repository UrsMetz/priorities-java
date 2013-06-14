import org.junit.Test;
import priorities.PriorityItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PrioritizerTest {

    private static final String NAME_IGNORED = "name";

    @Test
    public void emptyListOfItemShouldYieldEmptyResult() {
        assertThat(prioritize(Collections.<PriorityItem>emptyList()), is(empty()));
    }

    @Test
    public void listOfOneItemShouldYieldThatItem() {
        PriorityItem item = new PriorityItem(NAME_IGNORED, 1);
        assertThat(prioritize(asList(item)), contains(item));
    }

    @Test
    public void listOfTwoItemsWithDifferentPrioritiesShouldYieldTheHigherPrioritized() {
        PriorityItem lowerPrioritized = new PriorityItem(NAME_IGNORED + "1", 1);
        PriorityItem higherPrioritized = new PriorityItem(NAME_IGNORED + "2", 2);

        assertThat(prioritize(asList(lowerPrioritized, higherPrioritized)), contains(higherPrioritized));
    }

    @Test
    public void listOfTwoItemsWithSamePriorityShouldYieldBothItems() throws Exception {
        PriorityItem item1 = new PriorityItem("first item", 1);
        PriorityItem item2 = new PriorityItem("second item" + "2", 1);

        assertThat(prioritize(asList(item1, item2)), containsInAnyOrder(item1, item2));
    }

    private List<PriorityItem> prioritize(List<PriorityItem> items) {
        if (items.isEmpty())
            return emptyList();
        final int maxPriority = findMaxPriority(items);

        return findAllWithPriority(items, maxPriority);
    }

    private List<PriorityItem> findAllWithPriority(List<PriorityItem> items, int priority) {
        List<PriorityItem> allWithGivenPriority = new ArrayList<PriorityItem>();
        for (PriorityItem item : items) {
            if (item.getPriority() == priority) {
                allWithGivenPriority.add(item);
            }
        }
        return allWithGivenPriority;
    }

    private int findMaxPriority(List<PriorityItem> items) {
        int maxPriority = Integer.MIN_VALUE;
        for (PriorityItem item : items) {
            if (item.getPriority() > maxPriority) {
                maxPriority = item.getPriority();
            }
        }
        return maxPriority;
    }

}
