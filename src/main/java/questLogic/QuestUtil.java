package questLogic;

import java.util.ArrayList;
import java.util.List;

public class QuestUtil {
    private static final List<QuestNode> QUEST_NODES;

    static {
        QUEST_NODES = new ArrayList<>();

        QUEST_NODES.add(new QuestNode(0,
                "Ты отклонил вызов",
                "Ты потерял память.",
                "Принять вызов НЛО?",
                new Button("Принять вызов", 1),
                new Button("Отклонить вызов", true)));
        QUEST_NODES.add(new QuestNode(1,
                "Ты не прошел переговоры.",
                "Ты принял вызов.",
                "Поднимишься на мостик к капитану?",
                new Button("Отказаться подниматься на мостик", true),
                new Button("Подняться на мостик", 2)));
        QUEST_NODES.add(new QuestNode(2,
                "Твою ложь разоблачили",
                "Ты поднялся на мостик.",
                "Ты кто?",
                new Button("Солгать о себе", true),
                new Button("Рассказать правду о себе", false)));
    }

    private static final int ID_OF_MAIN_QUEST_NODE = 0;
    private static QuestNode currentQuestNode = getQuestNode(ID_OF_MAIN_QUEST_NODE);

    public static QuestNode getQuestNode(int id) {
        for(QuestNode questNode : QUEST_NODES) {
            if (questNode.getID() == id) return questNode;
        }

        throw new RuntimeException("QuestNode with this id was not found");
    }

    public static boolean nextWin(int buttonNumber) {
        return currentQuestNode.getBUTTON(buttonNumber).isLINK_WIN();
    }

    public static boolean nextLose(int buttonNumber) {
        return currentQuestNode.getBUTTON(buttonNumber).isLINK_LOSE();
    }

    public static QuestNode nextQuestNode(int buttonNumber) {
        if (nextWin(buttonNumber) || nextLose(buttonNumber))
            throw new RuntimeException("the next quest node is missing");

        currentQuestNode = getQuestNode(currentQuestNode.getBUTTON(buttonNumber).getLINK_ID());

        return currentQuestNode;
    }

    public static QuestNode getCurrentQuestNode() {
        return  currentQuestNode;
    }

    public static void restart() {
        currentQuestNode = getQuestNode(ID_OF_MAIN_QUEST_NODE);
    }
}
