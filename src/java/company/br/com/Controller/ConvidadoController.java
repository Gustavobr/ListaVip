package company.br.com.Controller;

import com.mydev.Model.Convidado;
import company.com.Email.EnviadorEmail;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

@ManagedBean(name = "convidadoBean")
@RequestScoped
public class ConvidadoController {

    Convidado convidado = new Convidado();

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public void saveConvidado() throws EntityNotFoundException, EmailException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(convidado);
        em.getTransaction().commit();
        em.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Convidado" + "\n" + convidado.getNome() + "\n" + "cadastrado"));
        System.out.println("Email enviado ao convidado " + convidado.getNome().toUpperCase());
        EnviadorEmail.enviarEmail();

    }

    public List<Convidado> listar() throws EntityNotFoundException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select c from Convidado c");
        List<Convidado> lista = query.getResultList();
        return lista;
    }
}
