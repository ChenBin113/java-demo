package junit;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testEat() {
        String message = Person.eat("water");
        Assert.assertEquals("water", message);
    }
}
