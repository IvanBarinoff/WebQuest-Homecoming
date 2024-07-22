import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();

        int buttonNumber = Integer.parseInt(req.getParameter("button"));

        try {
            if (QuestUtil.nextWin(buttonNumber)) {
                currentSession.setAttribute("win", true);
                resp.sendRedirect("/index.jsp");
                return;
            }
            if (QuestUtil.nextLose(buttonNumber)) {
                currentSession.setAttribute("lose", true);
                currentSession.setAttribute("messageLose", QuestUtil.getCurrentQuestNode().getMESSAGE_LOSE());
                resp.sendRedirect("/index.jsp");
                return;
            }
        } catch (RuntimeException e) {
            resp.sendRedirect("/index.jsp");
            return;
        }

        QuestNode nextQuestNode = QuestUtil.nextQuestNode(buttonNumber);

        currentSession.setAttribute("story", nextQuestNode.getSTORY());
        currentSession.setAttribute("question", nextQuestNode.getQUESTION());
        currentSession.setAttribute("nameButton1", nextQuestNode.getBUTTON(1).getNAME());
        currentSession.setAttribute("nameButton2", nextQuestNode.getBUTTON(2).getNAME());

        resp.sendRedirect("/index.jsp");
    }
}
