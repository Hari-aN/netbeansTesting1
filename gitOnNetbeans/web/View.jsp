<%@page import = "java.sql.*"%>
<%@page import = "java.io.*"%>
<%
    Connection connection = null;
    //login is the name of the database
    String connectionURL = "jdbc:mysql://localhost:3306/harian";
     
    ResultSet rs = null;
     
    PreparedStatement psmnt = null;
     
    InputStream sImage;
    try
    {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    connection = DriverManager.getConnection(connectionURL, "root", "root");
    //Student is the table name
    psmnt = connection.prepareStatement("SELECT photo FROM contacts");
    //In id "6" i have the image.
    //psmnt.setString(1, "6");
    rs = psmnt.executeQuery();
    if(rs.next())
    {
    byte[] bytearray = new byte[1048576];
    int size=0;
    sImage = rs.getBinaryStream(1);
    response.reset();
    response.setContentType("image/jpeg");
    while((size=sImage.read(bytearray))!= -1 )
    {
    response.getOutputStream().write(bytearray,0,size);
    }
    response.flushBuffer();
    sImage.close();
    rs.close();
     
    }
    }
    catch(Exception ex)
    {
    out.println(ex);
    }
     
     
    psmnt.close();
    connection.close();
%>