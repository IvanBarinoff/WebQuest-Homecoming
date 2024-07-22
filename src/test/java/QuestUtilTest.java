import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import questLogic.QuestNode;
import questLogic.QuestUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuestUtilTest {

    @ParameterizedTest
    @ValueSource(ints ={-1, 2, 3, 4, 90, -90})
    public void incorrectButtonNumberGetQuestNodeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> QuestUtil.getQuestNode(3));

        assertEquals("QuestNode with this id was not found", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints ={-1, 2, 3, 4, 90, -90})
    public void incorrectButtonNumberNextQuestNodeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> QuestUtil.nextQuestNode(3));

        assertEquals("Incorrect button number", exception.getMessage());
    }

    @Test
    public void restart() {
        QuestNode currentQuestNode = QuestUtil.getCurrentQuestNode();
        QuestUtil.nextQuestNode(1);
        QuestUtil.restart();

        assertEquals(currentQuestNode, QuestUtil.getCurrentQuestNode());
    }

    @Test
    public void getQuestNode() {
        QuestNode currentQuestNode = QuestUtil.getCurrentQuestNode();
        int currentId = currentQuestNode.getID();

        assertEquals(currentQuestNode, QuestUtil.getQuestNode(currentId));
    }
}
