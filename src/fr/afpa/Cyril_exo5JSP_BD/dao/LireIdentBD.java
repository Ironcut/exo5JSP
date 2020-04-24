package fr.afpa.Cyril_exo5JSP_BD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import fr.afpa.exo5JSP_BD.beans.Utilisateur;

public class LireIdentBD {
	PreparedStatement pstmt;
	ResultSet res;
	Utilisateur u;

	public LireIdentBD() {
		u = null;
		pstmt = null;
		res = null;
	}

	public Utilisateur LireBD(String nom, String motDePasse) throws SQLException {

		Connection con = null ;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le driver");
		}
		try {
			String url = "jdbc:mysql://mysql-crud.alwaysdata.net:3306/crud_exo";
			con = DriverManager.getConnection(url, "crud", "boubis13");
		} catch (Exception e) {
			System.out.println("La connexion a échoué");

		}
		try {
			pstmt = con.prepareStatement("SELECT nom FROM users WHERE nom = ?");
			pstmt.setString(1, nom);
			res = pstmt.executeQuery();
			res.next();
			res.getString(1);
			if (res.getString(1).equals(nom)) {
			}

		} catch (SQLException sqlE) {
			JOptionPane.showMessageDialog(null, "Utilisateur non reconnu: " + nom);
			System.out.println("Utilisateur non reconnu: " + nom);
			return u;
		}

		try {
			pstmt = con.prepareStatement("SELECT id, nom, prenom, motdepasse FROM users WHERE motDePasse = ?");

			pstmt.setString(1, motDePasse);
			res = pstmt.executeQuery();
			while (res.next()) {

				if (res.getString(4).equals(motDePasse)) {
					u = new Utilisateur();
					u.setId(res.getString(1));
					u.setNom(res.getString(2));
					u.setPrenom(res.getString(3));
					u.setMp(res.getString(4));
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return u;
	}
}
