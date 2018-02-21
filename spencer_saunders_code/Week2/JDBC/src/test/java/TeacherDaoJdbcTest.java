import com.revature.beans.Teacher;
import com.revature.dao.TeacherDao;
import com.revature.dao.TeacherDaoJDBCPg;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TeacherDaoJdbcTest {
    private static TeacherDao dao = new TeacherDaoJDBCPg();

    @Test
    public void getTeacherTest() throws Exception{
        final String firstname = "first name";
        final String lastname = "last name";
        final String favquote = "favorite quote";

        Teacher testTeacher = new Teacher();
        testTeacher.setFirstname(firstname);
        testTeacher.setLastname(lastname);
        testTeacher.setFavoriteQuote(favquote);

        dao.newTeacher(testTeacher);
        assertTrue(testTeacher.getId() != 0);
    }
}
