/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealMultisample_t {
    public static final ealMultisample_t MULTISAMPLE_0 = new ealMultisample_t("MULTISAMPLE_0");
    public static final ealMultisample_t MULTISAMPLE_2 = new ealMultisample_t("MULTISAMPLE_2");
    public static final ealMultisample_t MULTISAMPLE_4 = new ealMultisample_t("MULTISAMPLE_4");
    public static final ealMultisample_t MULTISAMPLE_8 = new ealMultisample_t("MULTISAMPLE_8");
    public static final ealMultisample_t MULTISAMPLE_16 = new ealMultisample_t("MULTISAMPLE_16");
    private static ealMultisample_t[] swigValues = new ealMultisample_t[]{MULTISAMPLE_0, MULTISAMPLE_2, MULTISAMPLE_4, MULTISAMPLE_8, MULTISAMPLE_16};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealMultisample_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealMultisample_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealMultisample_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealMultisample_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealMultisample_t == null ? (class$de$esolutions$graphics$eal$ealMultisample_t = ealMultisample_t.class$("de.esolutions.graphics.eal.ealMultisample_t")) : class$de$esolutions$graphics$eal$ealMultisample_t).append(" with value ").append(n).toString());
    }

    private ealMultisample_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealMultisample_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealMultisample_t(String string, ealMultisample_t ealMultisample_t2) {
        this.swigName = string;
        this.swigValue = ealMultisample_t2.swigValue;
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

