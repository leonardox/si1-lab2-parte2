import play.*;

import models.Tarefa;
import models.DAO.GenericDAO;
import play.db.jpa.JPA;

/**
 * Created by X on 02/12/2014.
 */
public class Global extends GlobalSettings{

    private static GenericDAO dao = new GenericDAO();

    @Override
    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
                Tarefa tarefa01 = new Tarefa();
                tarefa01.setNome("Finalizar Lab de SI");
                tarefa01.setPrioridade("Alta");
                tarefa01.setSemana(1);
                tarefa01.setDone(false);
                dao.persist(tarefa01);

                Tarefa tarefa02 = new Tarefa();
                tarefa02.setNome("Finalizar lista de ATAL");
                tarefa02.setPrioridade("Média");
                tarefa02.setSemana(1);
                tarefa02.setDone(false);
                dao.persist(tarefa02);

                Tarefa tarefa03 = new Tarefa();
                tarefa03.setNome("Estudar MODERNA");
                tarefa03.setPrioridade("Baixa");
                tarefa03.setSemana(1);
                tarefa03.setDone(false);
                dao.persist(tarefa03);

                Tarefa tarefa04 = new Tarefa();
                tarefa04.setNome("Estudar pra MÉTODOS");
                tarefa04.setPrioridade("Alta");
                tarefa04.setSemana(2);
                tarefa04.setDone(false);
                dao.persist(tarefa04);

                Tarefa tarefa05 = new Tarefa();
                tarefa05.setNome("Pagar o boleto do jogo.");
                tarefa05.setPrioridade("Baixa");
                tarefa05.setSemana(2);
                tarefa05.setDone(false);
                dao.persist(tarefa05);

                Tarefa tarefa06 = new Tarefa();
                tarefa06.setNome("Estudar pra SI");
                tarefa06.setPrioridade("Média");
                tarefa06.setSemana(3);
                tarefa06.setDone(false);
                dao.persist(tarefa06);

                Tarefa tarefa07 = new Tarefa();
                tarefa07.setNome("Comprar passagem");
                tarefa07.setPrioridade("Alta");
                tarefa07.setSemana(2);
                tarefa07.setDone(false);
                dao.persist(tarefa07);

                Tarefa tarefa08 = new Tarefa();
                tarefa08.setNome("Pagar confraternização");
                tarefa08.setPrioridade("Baixa");
                tarefa08.setSemana(3);
                tarefa08.setDone(false);
                dao.persist(tarefa08);

                Tarefa tarefa09 = new Tarefa();
                tarefa09.setNome("Pagar academia");
                tarefa09.setPrioridade("Média");
                tarefa09.setSemana(3);
                tarefa09.setDone(false);
                dao.persist(tarefa09);

                Tarefa tarefa10 = new Tarefa();
                tarefa10.setNome("Comprar novo celular");
                tarefa10.setPrioridade("Alta");
                tarefa10.setSemana(3);
                tarefa10.setDone(false);
                dao.persist(tarefa10);
                dao.flush();
            }
        });
    }

    public void onStop(Application app) {
        Logger.info("Aplicação desligada...");
    }
}
