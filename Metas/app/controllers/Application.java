package controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import models.Tarefa;
import models.DAO.GenericDAO;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;


public class Application extends Controller{

    private static Form<Tarefa> tarefaForm = Form.form(Tarefa.class);
    private static final GenericDAO dao = new GenericDAO();

    public static Result index() {
        return redirect(routes.Application.metas());
    }

    @Transactional
    public static Result metas() {
        List<Tarefa> result = dao.findAllByClass(Tarefa.class);
        Collections.sort(result);
        return ok(views.html.index.render(result));
    }

    @Transactional
    public static Result newMeta() {
        Form<Tarefa> filledForm = tarefaForm.bindFromRequest();

        if (filledForm.hasErrors()) {
            List<Tarefa> result = dao.findAllByClass(Tarefa.class);
            return badRequest(views.html.index.render(result));
        } else {
            Tarefa novaMeta = filledForm.get();
            if(novaMeta.getPrioridade() == null || novaMeta.getPrioridade().isEmpty())
            {
                novaMeta.setPrioridade("Baixa");
            }
            Logger.debug("Criando meta: " + filledForm.data().toString() + " como " + novaMeta.getNome());
            dao.persist(novaMeta);
            dao.flush();
            return redirect(routes.Application.metas());
        }
    }

    @Transactional
    public static Result deleteMeta(Long id) {
        dao.removeById(Tarefa.class, id);
        dao.flush();
        return redirect(routes.Application.metas());
    }

    @Transactional
    public static Result changeStatus(Long id) {
        Tarefa tarefa = dao.findByEntityId(Tarefa.class, id);
        tarefa.setDone(true);
        dao.merge(tarefa);
        dao.flush();
        return redirect(routes.Application.metas());
    }

    public static int getNumberOfTasksByWeek(int week) {
        int count = 0;
        List<Tarefa> tarefas = dao.findAllByClass(Tarefa.class);
        for(Tarefa tarefa:tarefas){
            if(tarefa.getSemana() == week){
                count++;
            }
        }
        return count;
    }

    public static int getNumberOfTasksDonesByWeek(int week) {
        int count = 0;
        List<Tarefa> tarefas = dao.findAllByClass(Tarefa.class);
        for(Tarefa tarefa:tarefas){
            if(tarefa.getSemana() == week && tarefa.getDone()){
                count++;
            }
        }
        return count;
    }
}
