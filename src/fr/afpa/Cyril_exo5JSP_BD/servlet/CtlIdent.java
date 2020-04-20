package fr.afpa.Cyril_exo5JSP_BD.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.Cyril_exo5JSP_BD.dao.LireIdentBD;
import fr.afpa.exo5JSP_BD.beans.Utilisateur;

@WebServlet("/CtlIdent")
public class CtlIdent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;

	public CtlIdent() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LireIdentBD l = new LireIdentBD();
			Utilisateur u = l.LireBD(request.getParameter("utilisateur"), request.getParameter("mp"));

			if (u != null) {
				request.setAttribute("id", u.getId());
				request.setAttribute("prenom", u.getNom());
				request.setAttribute("nom", u.getPrenom());
				request.setAttribute("mp", u.getMp());
				rd = getServletContext().getRequestDispatcher("/JSPUserOk.jsp");
				rd.forward(request, response);
			} else {
				rd = getServletContext().getRequestDispatcher("/JSPUserNOk.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
