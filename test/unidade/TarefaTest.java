package unidade;

import models.DAO.GenericDAO;
import models.Tarefa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.GlobalSettings;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FakeApplication;
import play.test.Helpers;
import scala.Option;

import javax.persistence.EntityManager;
import java.util.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by DEOGHome on 21/11/2014.
 */
public class TarefaTest {

    public EntityManager em;
    private GenericDAO dao = new GenericDAO();

	@Before
    public void setUp() {
        FakeApplication app = Helpers.fakeApplication(new GlobalSettings());
        Helpers.start(app);
        Option<JPAPlugin> jpaPlugin = app.getWrappedApplication().plugin(JPAPlugin.class);
        em = jpaPlugin.get().em("default");
        JPA.bindForCurrentThread(em);
        em.getTransaction().begin();
    }

    @After
    public void tearDown() {
        em.getTransaction().commit();
        JPA.bindForCurrentThread(null);
        em.close();
    }

    @Test
    public void verificaOrdenacao() {
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        tarefas.add(new Tarefa("meta1", "Baixa", 1));
        tarefas.add(new Tarefa("meta2", "Alta", 1));
        tarefas.add(new Tarefa("meta3", "Alta", 3));
        tarefas.add(new Tarefa("meta4", "Baixa", 2));
        Collections.sort(tarefas);
        assertThat(tarefas.get(0).getNome()).isEqualTo("meta2");
        assertThat(tarefas.get(1).getNome()).isEqualTo("meta1");
        assertThat(tarefas.get(2).getNome()).isEqualTo("meta4");
        assertThat(tarefas.get(3).getNome()).isEqualTo("meta3");
    }

    /*@Test
    public void iniciaCom10Metas() {
        List<Tarefa> tarefas = dao.findAllByClass(Tarefa.class);
        assertThat(tarefas.size()).isEqualTo(10);
    }*/

    @Test
    public void testaPersistencia() {
        Tarefa tarefa = new Tarefa("Tarefa de hoje","Baixa", 6);
        dao.persist(tarefa);
        dao.flush();
        List<Tarefa> metas = dao.findAllByClass(Tarefa.class);
        assertThat(metas.size()).isEqualTo(1);
        assertThat(metas.get(0).getNome()).isEqualTo("Tarefa de hoje");
    }

    @Test
    public void deletaMeta() {
        Tarefa meta = new Tarefa("meta","Baixa", 1);
        dao.persist(meta);
        dao.flush();
        long id = meta.getId();
        dao.removeById(Tarefa.class, id);
        List<Tarefa> tarefas = dao.findAllByClass(Tarefa.class);
        assertThat(tarefas.size()).isEqualTo(0);
    }
}
