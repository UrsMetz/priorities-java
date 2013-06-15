package priorities;

import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PrioritizerTest {

    private static final String NAME_IGNORED = "name";

    @Test
    public void emptyListOfItemShouldYieldEmptyResult() {
        assertThat(new Prioritizer(Collections.<PriorityItem>emptyList()).proritize(), is(empty()));
    }

    @Test
    public void listOfOneItemShouldYieldThatItem() {
        PriorityItem item = new PriorityItem(NAME_IGNORED, 1);
        assertThat(new Prioritizer(asList(item)).proritize(), contains(item));
    }

    @Test
    public void listOfTwoItemsWithDifferentPrioritiesShouldYieldTheHigherPrioritized() {
        PriorityItem lowerPrioritized = new PriorityItem("first item", 1);
        PriorityItem higherPrioritized = new PriorityItem("second item", 2);

        assertThat(new Prioritizer(asList(lowerPrioritized, higherPrioritized)).proritize(), contains(higherPrioritized));
    }

    @Test
    public void listOfTwoItemsWithSamePriorityShouldYieldBothItems() {
        PriorityItem item1 = new PriorityItem("first item", 1);
        PriorityItem item2 = new PriorityItem("second item", 1);

        assertThat(new Prioritizer(asList(item1, item2)).proritize(), containsInAnyOrder(item1, item2));
    }

    @Test
    public void secondCallShouldGiveSecondHighestPriorizedItem() {
        PriorityItem item1 = new PriorityItem("first item", 2);
        PriorityItem item2 = new PriorityItem("second item", 1);

        Prioritizer underTest = new Prioritizer(asList(item1, item2));
        underTest.proritize();

        assertThat(underTest.proritize(), contains(item2));
    }
}