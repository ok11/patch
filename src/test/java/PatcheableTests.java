import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.test.Patch;
import org.test.PatchException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class PatcheableTests {

    private TestJsonModel model;

    @Before
    public void setUp() {
        model = new TestJsonModel("pinoccio", new TestJsonModel.Profile(20, "pinoccio@mail"));
    }

    @Test
    public void testAddFreeAttribute() {
        Patch p = new Patch(new Patch.AddOp("gender", "male"));
        p.apply(model);
        assertThat(model, is(not(null)));
        assertThat(model.getName(), is("pinoccio"));
        assertThat(model.getAttributes().get("gender"), is("male"));
    }

    @Test
    public void testRemoveFreeAttribute() {
        model.addAttribute("gender", "male");
        Patch p = new Patch(new Patch.RemoveOp("gender"));
        p.apply(model);
        assertThat(model.getAttributes().get("gender"), is(nullValue()));
    }

    @Test(expected = PatchException.class)
    public void testRemoveMandatoryAttribute() {
        Patch p = new Patch(new Patch.RemoveOp("profile"));
        p.apply(model);
    }

    @Test
    public void testReplaceMandatoryValue() {
        Patch p = new Patch(new Patch.ReplaceOp("name", "buratino"));
        p.apply(model);
        assertThat(model.getName(), is("buratino"));
    }

    @Test
    public void testIntact() {
        Patch p = new Patch(new Patch.ReplaceOp("name", "buratino"));
        p.apply(model);
        assertThat(model.getProfile().getAge(), is(20));
    }
}
