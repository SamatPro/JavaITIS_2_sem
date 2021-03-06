package ru.kpfu.itis.servlets;

import ru.kpfu.itis.forms.UserForm;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class RegistrationServlet extends HttpServlet {

    private UsersService usersService;

//    private final String URL = "jdbc:postgresql://localhost:5435/postgres";
//    private final String USERNAME = "postgres";
//    private final String PASSWORD = "postgres";

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
//        config.getInitParameter("");
    }

//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
//            usersService = new UsersServicesImpl(usersRepository);
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("Unavailable");
//            throw new UnavailableException("Сайт недоступен!!!");
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserForm userForm = new UserForm();
        userForm.setLogin(request.getParameter("login"));
        userForm.setPassword(request.getParameter("password"));
        userForm.setFirstName(request.getParameter("firstName"));
        userForm.setLastName(request.getParameter("lastName"));

        usersService.register(userForm);

        response.sendRedirect("/signIn");
    }
}
