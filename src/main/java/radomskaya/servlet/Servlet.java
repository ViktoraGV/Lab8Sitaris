package radomskaya.servlet;

import radomskaya.entity.Student;
import radomskaya.parser.Parser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Student> studentList = Parser.getInstance().parseXmlFileWithDOM();
        PrintWriter pw = response.getWriter();
        pw.println("<p align=\"center\">");
        pw.println("Information about students");
        pw.println("</span>");
        pw.println("<table border=1 align=\"center\">");
        try {
            pw.println("<tr>" +
                    "<th>id</th>" +
                    "<th>Surname</th>" +
                    "<th>Name</th>" +
                    "<th>Middle_name</th>" +
                    "<th>Faculty</th>" +
                    "<th>Group</th>" +
                    "<th>MarkMath</th>" +
                    "<th>MarkRussian</th>" +
                    "</tr>");
            for (Student student : studentList) {
                pw.println("<tr>");
                pw.println("<td>" + student.getId() + "</td>");
                pw.println("<td>" + student.getSurname() + "</td>");
                pw.println("<td>" + student.getName() + "</td>");
                pw.println("<td>" + student.getMiddleName() + "</td>");
                pw.println("<td>" + student.getFaculty() + "</td>");
                pw.println("<td>" + student.getGroup() + "</td>");
                pw.println("<td>" + student.getMarkMath() + "</td>");
                pw.println("<td>" + student.getMarkRussian() + "</td>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("</table>");
    }
}
