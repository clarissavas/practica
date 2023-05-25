package informatica.unistmo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import informatica.modelos.calcularArea;
import informatica.modelos.datosTrianguloBean;

@WebServlet(name="areaTrian", urlPatterns={ "/servlets/areaTrian" })
public class areaTrian extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String operation = request.getParameter("operation");
    float base = Float.parseFloat(request.getParameter( "base" ));
    float altura = Float.parseFloat(request.getParameter( "altura" ));
    float result = 0;

    switch(operation)
    {
      case "AREA":
        calcularArea areaC = new calcularArea();
        datosTrianguloBean dt = new datosTrianguloBean();

        dt.setArea(areaC.obtenerAreaTriangulo(base, altura));

        request.setAttribute("Resultado", dt);
        operation = "*";
        break;
    }

    request.getRequestDispatcher("../view/resultado.jsp").forward(request, response);
  }
}