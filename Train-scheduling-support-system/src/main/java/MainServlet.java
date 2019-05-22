import model.dao.imp.BaseGetInfo;


import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/hello")
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {




        String station = request.getParameter("p1");

        BaseGetInfo baseGetInfo = new BaseGetInfo();
        int index = (baseGetInfo.getIndexStation(station));

        ArrayList<Integer> s = baseGetInfo.getPossibleWay(baseGetInfo.getIndexStation(station));
        System.out.println(baseGetInfo.getPossibleWay(baseGetInfo.getIndexStation(station)));



    }
}
