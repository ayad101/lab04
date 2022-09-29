/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ayad
 */
package NoteServlet;

import javabeans.Note;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getQueryString();
        if (query != null && query.contains("edit")) {
            //view form
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);

        } else {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");

            // read the file
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String title = br.readLine();
            String contents = br.readLine();

            Note note = new Note(title, contents);

            request.setAttribute("note", note);

            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        print.println(title);
        print.println(contents);
        print.close();

        response.sendRedirect("note");

    }

}
