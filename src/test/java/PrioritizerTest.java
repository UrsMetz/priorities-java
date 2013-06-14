import org.junit.Test;
import priorities.PriorityItem;

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
        PriorityItem lowerPrioritized = new PriorityItem(NAME_IGNORED, 1);
        PriorityItem higherPrioritized = new PriorityItem(NAME_IGNORED, 2);

        assertThat(prioritize(asList(lowerPrioritized, higherPrioritized)), contains(higherPrioritized));
    }

    private List<PriorityItem> prioritize(List<PriorityItem> items) {
        if (items.isEmpty())
            return emptyList();
        return lastElementAsList(items);
    }

    private List<PriorityItem> lastElementAsList(List<PriorityItem> items) {
        return asList(items.get(items.size() - 1));
    }
}
