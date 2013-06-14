import org.junit.Test;
import priorities.PriorityItem;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class PrioritizerTest {
    @Test
    public void emptyListOfItemShouldYieldEmptyResult() {
        assertThat(prioritize(emptyList()), is(empty()));
    }

    private List<PriorityItem> prioritize(List items) {
        return emptyList();  //To change body of created methods use File | Settings | File Templates.
    }
}
