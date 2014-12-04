import org.junit.*;

import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import models.DAO.GenericDAO;

import javax.persistence.EntityManager;


public class IntegrationTest{

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void shouldStartPage() {
        /*running(testServer(9000, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:9000");
                assertThat(browser.pageSource()).contains("Minhas metas");
            }
        });*/
    }
}
