package unitTests;
import people.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitTestCustCount {
    @Test
    public void testCustCount() {
        for (int i=0; i<100; i++)
            new Customer("test",39,"Female",180,70,85, Customer.Goal.looseWeight,1);
        assertThrows(RuntimeException.class, () -> new Customer("test",39,"Female",180,70,85, Customer.Goal.looseWeight,1));
    }
    @Test
    public void testTrainerCount() {
        for (int i=0; i<100; i++)
            new Trainer("test",39,"Female",180,70,85, "looseWeight",1);
        assertThrows(RuntimeException.class, () -> new Trainer("test",39,"Female",180,70,85, "looseWeight",1));
    }
}
