package questLogic;

public class QuestNode {
    private final int ID;
    private final String MESSAGE_LOSE;
    private final String STORY;
    private final String QUESTION;

    private final Button BUTTON1;
    private final Button BUTTON2;

    public QuestNode(int ID, String MESSAGE_LOSE, String STORY, String QUESTION, Button BUTTON1, Button BUTTON2) {
        this.ID = ID;
        this.MESSAGE_LOSE = MESSAGE_LOSE;
        this.STORY = STORY;
        this.QUESTION = QUESTION;
        this.BUTTON1 = BUTTON1;
        this.BUTTON2 = BUTTON2;
    }

    public int getID() {
        return ID;
    }

    public String getMESSAGE_LOSE() {
        return MESSAGE_LOSE;
    }

    public String getSTORY() {
        return STORY;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public Button getBUTTON(int buttonNumber) {
        if (buttonNumber == 1)
            return BUTTON1;
        else if (buttonNumber == 2)
            return BUTTON2;

        throw new RuntimeException("Incorrect button number");
    }
}
