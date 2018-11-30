package com.mvc.controller;

import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ticketPricingServlet extends HttpServlet {
    public ticketPricingServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        Enumeration paramNames = request.getParameterNames();

        String title = String.valueOf(request.getAttribute("title"));
        int seniorTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("seniorTicketNo")));
        int adultTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("adultTicketNo")));
        int minorTicketNo = Integer.parseInt(String.valueOf(request.getAttribute("minorTicketNo")));
        int totalTickets = Integer.parseInt(String.valueOf(request.getAttribute("totalTickets")));


        int seniorTicketPrice = seniorTicketNo * 10;
        int adultTicketPrice = adultTicketNo * 12;
        int minorTicketPrice = minorTicketNo * 8;
        int totalPrice = seniorTicketPrice + adultTicketPrice + minorTicketPrice;


        while(paramNames.hasMoreElements()){
            System.out.println((String)paramNames.nextElement());
            String paramName = (String)paramNames.nextElement();
        }

        //TODO figure out which seats were booked and how to store them


        request.setAttribute("totalPrice", totalPrice);

        RequestDispatcher rd = request.getRequestDispatcher("orderSummary.jsp");
        request.setAttribute("seniorTicketNo", seniorTicketNo);
        request.setAttribute("adultTicketNo", adultTicketNo);
        request.setAttribute("childTicketNo", minorTicketNo);
        request.setAttribute("totalTickets", totalTickets);
        //request.setAttribute("showTime", showTime);
        request.setAttribute("title", title);
        rd.forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }
}
