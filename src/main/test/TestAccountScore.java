import org.testng.Assert;
import org.testng.annotations.Test;
import radomskaya.account.AccountScore;
import radomskaya.entity.Student;

public class TestAccountScore {
    AccountScore accountScore = new AccountScore();
    Student student = new Student(1, "Ivan", "Ivanov", "Ivanovich", "IEF", "572303", "7", "7");

    @Test
    public void testScore() {
        Assert.assertEquals(7, accountScore.count(student), 0);
    }
}
