import java.util.ArrayList;
import java.util.List;
import models.DAO.GenericDAO;
import models.Tarefa;
import org.junit.*;
import java.util.Collections;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.*;
import javax.persistence.EntityManager;
import static org.fest.assertions.Assertions.*;
import scala.Option;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void renderTemplate() {
        // Content html = views.html.index.render("WeekGoals");
        //assertThat(contentType(html)).isEqualTo("text/html");
        // assertThat(contentAsString(html)).contains("WeekGoals");
    }
}
