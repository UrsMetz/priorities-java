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
        assertThat(new Prioritizer(Collections.<PriorityItem>emptyList()).prioritize(), is(empty()));
    }

    @Test
    public void listOfOneItemShouldYieldThatItem() {
        PriorityItem item = new PriorityItem(NAME_IGNORED, 1);
        assertThat(new Prioritizer(asList(item)).prioritize(), contains(item));
    }

    @Test
    public void listOfTwoItemsWithDifferentPrioritiesShouldYieldTheHigherPrioritized() {
        PriorityItem lowerPrioritized = new PriorityItem("first item", 1);
        PriorityItem higherPrioritized = new PriorityItem("second item", 2);

        assertThat(new Prioritizer(asList(lowerPrioritized, higherPrioritized)).prioritize(), contains(higherPrioritized));
    }

    @Test
    public void listOfTwoItemsWithSamePriorityShouldYieldBothItems() {
        PriorityItem item1 = new PriorityItem("first item", 1);
        PriorityItem item2 = new PriorityItem("second item", 1);

        assertThat(new Prioritizer(asList(item1, item2)).prioritize(), containsInAnyOrder(item1, item2));
    }

    @Test
    public void secondCallShouldGiveSecondHighestPrioritizedItem() {
        PriorityItem item1 = new PriorityItem("first item", 2);
        PriorityItem item2 = new PriorityItem("second item", 1);

        Prioritizer underTest = new Prioritizer(asList(item1, item2));
        underTest.prioritize();

        assertThat(underTest.prioritize(), contains(item2));
    }

    @Test
    public void shouldReturnEmptyListWhenAllPrioritiesHaveBennDealtWith() throws Exception {
        PriorityItem firstItem = new PriorityItem("first item", 2);
        PriorityItem secondItem = new PriorityItem("second item", 1);

        Prioritizer underTest = new Prioritizer(asList(firstItem, secondItem));
        underTest.prioritize();
        underTest.prioritize();

        assertThat(underTest.prioritize(), is(empty()));
        assertThat(underTest.prioritize(), is(empty()));
    }
}
