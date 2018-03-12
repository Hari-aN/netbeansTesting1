
import java.sql.*;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBModel;

/**
 * Servlet implementation class imagetestServlet
 */
@WebServlet("/imagetestServlet")
public class NewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Blob image = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        DBModel db = new DBModel();
        ServletOutputStream out = response.getOutputStream();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = db.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select photo from contacts where contact_id = 1");
            if (rs.next()) {
                image = rs.getBlob(1);
            } else {
                response.setContentType("text/html");

                out.println("<font color='red'>image not found for given id</font>");

                return;
            }
            response.setContentType("image/gif");
            InputStream in = image.getBinaryStream();
            int length = (int) image.length();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();

        } catch (Exception e) {
            response.setContentType("text/html");
            out.println("<html><head><title>Unable To Display image</title></head>");
            out.println("<body><h4><font color='red'>Image Display Error=" + e.getMessage()
                    + "</font></h4></body></html>");
            return;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
