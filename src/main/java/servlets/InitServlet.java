package servlets;

import questLogic.QuestNode;
import questLogic.QuestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlets.servlets.InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestNode currentQuestNode = QuestUtil.getCurrentQuestNode();

        HttpSession session = req.getSession();

        session.setAttribute("story", currentQuestNode.getSTORY());
        session.setAttribute("question", currentQuestNode.getQUESTION());
        session.setAttribute("nameButton1", currentQuestNode.getBUTTON(1).getNAME());
        session.setAttribute("nameButton2", currentQuestNode.getBUTTON(2).getNAME());

        session.setAttribute("win", false);
        session.setAttribute("lose", false);

        session.setAttribute("countGames", RestartServlet.getCountGames());

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}