package ua.kpi.transport.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.kpi.transport.db.dao.factory.DAOFactory;
import ua.kpi.transport.db.entities.StationBean;

/**
 *
 * @author harker777
 */
public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<StationBean> stations = DAOFactory.getDAOFactory("MYSQl").getStationDAO().findAll();
        Collections.sort(stations, StationBean.getLattitudeComparator());
        request.setAttribute("list", stations);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/stations.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Main Servlet to handle all execution process";
    }
}
