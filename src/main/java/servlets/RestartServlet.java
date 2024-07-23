package servlets;

import questLogic.QuestUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.RestartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {

    private static int countGames = 1;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        QuestUtil.restart();

        ++countGames;

        resp.sendRedirect("/start");
    }

    public static int getCountGames() {
        return countGames;
    }
}
