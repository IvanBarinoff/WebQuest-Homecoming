package questLogic;

public class Button {
    private final String NAME;
    private final int LINK_ID;
    private final boolean LINK_LOSE;
    private final boolean LINK_WIN;

    public Button(String name, int linkId) {
        NAME = name;
        LINK_ID = linkId;
        LINK_LOSE = false;
        LINK_WIN = false;
    }

    public Button(String name, boolean linkLose) {
        NAME = name;
        LINK_ID = -1;
        LINK_LOSE = linkLose;
        LINK_WIN = !linkLose;
    }

    public String getNAME() {
        return NAME;
    }

    public int getLINK_ID() {
        return LINK_ID;
    }

    public boolean isLINK_LOSE() {
        return LINK_LOSE;
    }

    public boolean isLINK_WIN() {
        return LINK_WIN;
    }
}
