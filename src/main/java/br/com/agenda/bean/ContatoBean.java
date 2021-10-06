package br.com.agenda.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.agenda.DAO.ContatoDAO;
import br.com.agenda.domain.Contato;

@ManagedBean(name="ContatoMB")
public class ContatoBean {

	private Contato contato = new Contato();
	
	private List<Contato> contatos;
	
	public String salvar() {
		try {
		ContatoDAO.salvar(contato);
		contato = new Contato();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Contato salvo com Sucesso!"));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar contato!"));	
		}
		return null;
	}
	
	public String editar() {
		try {
			ContatoDAO.editar(contato);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Contato editado com Sucesso!"));
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao editar o contato!"));
		}
			return null;
	}
	
	public String excluir() {
		try {
			ContatoDAO.excluir(contato);
			contatos.remove(contato);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Contato excluido com Sucesso!"));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao excluir contato!"));
		}
			return null;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		if(contatos == null) {
		contatos = ContatoDAO.listar();
		}
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
