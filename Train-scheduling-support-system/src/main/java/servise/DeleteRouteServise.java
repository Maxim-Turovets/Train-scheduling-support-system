package servise;

import model.dao.daointerfaces.DAoRoute;
import model.dao.imp.RouteTableInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class DeleteRouteServise {
    private HttpServletRequest request;
    private String strIndex;
    private  int result;

    public DeleteRouteServise(HttpServletRequest request) {
        this.request = request;
        strIndex = request.getParameter("delete");
        result = Integer.parseInt(strIndex);
    }

    public  void deleteRoute()
    {
        DAoRoute dAoRoute = new RouteTableInfo();
        dAoRoute.deleteRoute(result);
    }





}
