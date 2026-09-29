/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

public final class Application
extends Enum {
    public static final int COUNT;
    public static final Application SPEECH;
    public static final Application NAVI;
    public static final Application PHONE;
    private static final Application[] internalList;

    protected Application(int n, String string) {
        super(n, string);
    }

    public static Application[] values() {
        return (Application[])internalList.clone();
    }

    static {
        SPEECH = new Application(0, "SPEECH");
        NAVI = new Application(1, "NAVI");
        PHONE = new Application(2, "PHONE");
        internalList = new Application[]{SPEECH, NAVI, PHONE};
    }
}

