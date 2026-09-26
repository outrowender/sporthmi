/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class fontAlignment_t {
    public static final fontAlignment_t FONTALIGNMENT_LEFT = new fontAlignment_t("FONTALIGNMENT_LEFT");
    public static final fontAlignment_t FONTALIGNMENT_RIGHT = new fontAlignment_t("FONTALIGNMENT_RIGHT");
    public static final fontAlignment_t FONTALIGNMENT_CENTER = new fontAlignment_t("FONTALIGNMENT_CENTER");
    public static final fontAlignment_t FONTALIGNMENT_JUSTIFIED = new fontAlignment_t("FONTALIGNMENT_JUSTIFIED");
    private static fontAlignment_t[] swigValues = new fontAlignment_t[]{FONTALIGNMENT_LEFT, FONTALIGNMENT_RIGHT, FONTALIGNMENT_CENTER, FONTALIGNMENT_JUSTIFIED};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$fontAlignment_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static fontAlignment_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && fontAlignment_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (fontAlignment_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$fontAlignment_t == null ? (class$de$esolutions$graphics$eal$fontAlignment_t = fontAlignment_t.class$("de.esolutions.graphics.eal.fontAlignment_t")) : class$de$esolutions$graphics$eal$fontAlignment_t).append(" with value ").append(n).toString());
    }

    private fontAlignment_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private fontAlignment_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private fontAlignment_t(String string, fontAlignment_t fontAlignment_t2) {
        this.swigName = string;
        this.swigValue = fontAlignment_t2.swigValue;
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

