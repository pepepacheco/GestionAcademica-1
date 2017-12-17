/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.controller;

import com.iesvdc.acceso.dao.DAOException;
import com.iesvdc.acceso.dao.ProfesorDAO;
import com.iesvdc.acceso.dao.ProfesorDAOImpl;
import com.iesvdc.acceso.pojo.Profesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juangu <jgutierrez at iesvirgendelcarmen.coms>
 */
@WebServlet({"/ProfesorRead"})
public class LeerProfesor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LeerProfesor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LeerProfesor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

            // al=new Alumno("Juan", "Sin Miedo");
            pr_dao = new ProfesorDAOImpl();

            try {
                List<Profesor> li_al = pr_dao.findAll();
                out.println("<ol>");
                for (Profesor profesor : li_al) {
                    out.println("<li>");
                    out.println(profesor.getApellido() + " " + profesor.getNombre());
                    out.println("<a href=\"ActualizarProfesor?id=" + profesor.getId()
                            + "&nombre=" + profesor.getNombre() + "&apellido="
                            + profesor.getApellido() + "\">" + "actualizar</a>");
                    out.println("<a href=\"BorrarProfesor?id=" + profesor.getId() + "\">" + "borrar</a>");
                    out.println("</li>");
                }
                out.println("</ol>");
            } catch (DAOException ex) {
                Logger.getLogger(ex.getLocalizedMessage());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
