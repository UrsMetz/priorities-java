import org.junit.Test;
import priorities.PriorityItem;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PrioritizerTest {
    @Test
    public void emptyListOfItemShouldYieldEmptyResult() {
        assertThat(prioritize(Collections.<PriorityItem>emptyList()), is(empty()));
    }

    @Test
    public void listOfOneItemShouldYieldThatItem() {
        PriorityItem item = new PriorityItem("bla", 1);
        assertThat(prioritize(asList(item)), contains(item));
    }

    private List<PriorityItem> prioritize(List<PriorityItem> items) {
        return items;
    }
}
