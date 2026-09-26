/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

public class PopinAction {
    private static final int UPDATE_CONTENT;
    private static final int REQUEST_POPIN;
    private static final int NOTIFY_HIDDEN;
    private final int actionID;
    private final String methodName;
    public static final PopinAction POPIN_ACTION_UPDATE;
    public static final PopinAction POPIN_ACTION_REQUEST;
    public static final PopinAction POPIN_ACTION_NOTIFY_HIDDEN;

    private PopinAction(int n, String string) {
        this.actionID = n;
        this.methodName = string;
    }

    protected int getActionID() {
        return this.actionID;
    }

    protected String getMethodName() {
        return this.methodName;
    }

    public boolean equalsPopinAction(PopinAction popinAction) {
        return this.actionID == popinAction.getActionID();
    }

    public String toString() {
        return this.methodName;
    }

    static {
        POPIN_ACTION_UPDATE = new PopinAction(0, "updateContent");
        POPIN_ACTION_REQUEST = new PopinAction(1, "requestPopin");
        POPIN_ACTION_NOTIFY_HIDDEN = new PopinAction(2, "processHiddenNotification");
    }
}

