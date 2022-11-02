package lk.ijse.dep9.api.util;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep9.db.ConnectionPool;

import java.io.IOException;

@WebServlet(name = "TempServlet", value = "/release")
public class TempServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool pool = (ConnectionPool) getServletContext().getAttribute("pool");
        pool.releaseAllConnection();
    }


}
