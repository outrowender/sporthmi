/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealMouseState_t {
    public static final ealMouseState_t MOUSEEVENT_STATE_DOWN = new ealMouseState_t("MOUSEEVENT_STATE_DOWN");
    public static final ealMouseState_t MOUSEEVENT_STATE_MOVE = new ealMouseState_t("MOUSEEVENT_STATE_MOVE");
    public static final ealMouseState_t MOUSEEVENT_STATE_DRAG = new ealMouseState_t("MOUSEEVENT_STATE_DRAG");
    public static final ealMouseState_t MOUSEEVENT_STATE_UP = new ealMouseState_t("MOUSEEVENT_STATE_UP");
    private static ealMouseState_t[] swigValues = new ealMouseState_t[]{MOUSEEVENT_STATE_DOWN, MOUSEEVENT_STATE_MOVE, MOUSEEVENT_STATE_DRAG, MOUSEEVENT_STATE_UP};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealMouseState_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealMouseState_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealMouseState_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealMouseState_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealMouseState_t == null ? (class$de$esolutions$graphics$eal$ealMouseState_t = ealMouseState_t.class$("de.esolutions.graphics.eal.ealMouseState_t")) : class$de$esolutions$graphics$eal$ealMouseState_t).append(" with value ").append(n).toString());
    }

    private ealMouseState_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealMouseState_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealMouseState_t(String string, ealMouseState_t ealMouseState_t2) {
        this.swigName = string;
        this.swigValue = ealMouseState_t2.swigValue;
        swigNext = this.swigValue + 1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

