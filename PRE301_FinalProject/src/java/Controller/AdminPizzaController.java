/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author minht
 */
@WebServlet(name = "AdminPizzaController", urlPatterns = {"/admin/pizza"})
public class AdminPizzaController extends HttpServlet {

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
            String action = request.getParameter("action");
            DAO dao = new DAO();
            HttpSession session = request.getSession();
            if (action.equalsIgnoreCase("add")) {
                String pizzaName = request.getParameter("pizzaName");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                String image = request.getParameter("image");
                dao.addPizza(pizzaName, description, price, image);
            } else if (action.equalsIgnoreCase("update")) {
                String id = request.getParameter("id");
                String pizzaName = request.getParameter("pizzaName");
                String description = request.getParameter("description");
                double price = Double.parseDouble(request.getParameter("price"));
                String image = request.getParameter("image");
                out.print(id);
                dao.updatePizza(id, pizzaName, description, price, image);
            } else if (action.equalsIgnoreCase("delete")) {
                String id = request.getParameter("id");
                dao.deletePizza(id);
            }

         session.setAttribute("list", "null");
           response.sendRedirect("../adminPage.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
