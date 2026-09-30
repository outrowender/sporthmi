/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class Application
extends Enum<Application> {
    public static final int COUNT = 3;
    public static final Application SPEECH = new Application(0, "SPEECH");
    public static final Application NAVI = new Application(1, "NAVI");
    public static final Application PHONE = new Application(2, "PHONE");
    private static final Application[] internalList = new Application[]{SPEECH, NAVI, PHONE};

    protected Application(int n, String string) {
        super(n, string);
    }

    public static Application[] values() {
        return (Application[])internalList.clone();
    }
}

