/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

public class PopinAction {
    private static final int UPDATE_CONTENT = 0;
    private static final int REQUEST_POPIN = 1;
    private static final int NOTIFY_HIDDEN = 2;
    private final int actionID;
    private final String methodName;
    public static final PopinAction POPIN_ACTION_UPDATE = new PopinAction(0, "updateContent");
    public static final PopinAction POPIN_ACTION_REQUEST = new PopinAction(1, "requestPopin");
    public static final PopinAction POPIN_ACTION_NOTIFY_HIDDEN = new PopinAction(2, "processHiddenNotification");

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
}

