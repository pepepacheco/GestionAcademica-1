/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controller;

import com.iesvdc.acceso.dao.AlumnoDAOImpl;
import com.iesvdc.acceso.dao.DAOException;
import com.iesvdc.acceso.dao.ProfesorDAO;
import com.iesvdc.acceso.dao.ProfesorDAOImpl;
import com.iesvdc.acceso.pojo.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author profesor
 */
public class CrearProfesor extends HttpServlet {

    private Properties props;
    private Integer driver;
    private String host;
    private String puerto;
    private String base_datos;
    private String usuario;
    private String password;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        Profesor pr;
        ProfesorDAO pr_dao;

        // Cargar un fichero de texto desde un Servlet
        /*ServletContext context = getServletContext();
	InputStream resourceContent = context.getResourceAsStream("/WEB-INF/lib/db.prop");
        props = new Properties();
        props.load(resourceContent);
        this.base_datos = props.getProperty("base_datos");
        this.driver     = Integer.parseInt(props.getProperty("driver"));
        this.host       = props.getProperty("host");
        this.password   = props.getProperty("password");
        this.usuario    = props.getProperty("usuario");
        this.puerto     = props.getProperty("puerto");  
         */
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearProfesor</title>");
            out.println("</head>");
            out.println("<body>");

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");

            pr = new Profesor(nombre,apellido);
        
            pr_dao = new ProfesorDAOImpl();

            try {
                pr_dao.create(pr);
                out.println("Profesor creado con éxito");
            } catch (DAOException ex) {
                out.println(ex.getLocalizedMessage());
                Logger.getLogger(CrearProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pintar formulario
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearProfesor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"well\">\n"
                    + "		<form role=\"form\" method=\"post\">\n"
                    + "		  <div class=\"form-group\">\n"
                    + "		    <label for=\"nombre\">Nombre:</label>\n"
                    + "		    <input type=\"nombre\" class=\"form-control\" name=\"nombre\">\n"
                    + "		  </div>	\n"
                    + "		  <div class=\"form-group\">\n"
                    + "		    <label for=\"apellido\">Apellidos:</label>\n"
                    + "		    <input type=\"apellido\" class=\"form-control\" name=\"apellido\">\n"
                    + "		  </div>		  \n"
                    + "		  <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n"
                    + "		</form>\n"
                    + "	</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
