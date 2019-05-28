import model.dao.imp.BaseGetInfo;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/hello")
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

     //   ArrayList<String> stationList = new ArrayList<>();
        String station1 = request.getParameter("p1");
//        String station2 = request.getParameter("p2");

        if((ArrayList<String>) request.getSession().getAttribute("startStation")==null)
        {
            ArrayList<String> localLiat =new ArrayList<>();
            localLiat.add(station1);
            request.getSession().setAttribute("startStation", localLiat);
        }
        else{
            ArrayList<String> localLiat = (ArrayList<String>) request.getSession().getAttribute("startStation");
            localLiat.add(station1);
            request.getSession().setAttribute("startStation", localLiat);
        }

        BaseGetInfo baseGetInfo = new BaseGetInfo();
        int index1 = (baseGetInfo.getIndexStation(station1));
       // int index2 = (baseGetInfo.getIndexStation(station2));


       request.setAttribute("indexPossibleStation",baseGetInfo.getPossibleWay(index1));
       request.setAttribute("namePossibleStation",baseGetInfo.getArrayNameStation(baseGetInfo.getPossibleWay(index1)));

//        ArrayList<Integer> s = baseGetInfo.getPossibleWay(baseGetInfo.getIndexStation(station));
     //   System.out.println(baseGetInfo.getPossibleWay(baseGetInfo.getIndexStation(station)));

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ArrayList<String> stationList = new ArrayList<>();
        request.getSession().setAttribute("startStation",stationList);





    }
}
