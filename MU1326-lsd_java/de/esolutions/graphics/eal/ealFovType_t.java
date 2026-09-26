/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealFovType_t {
    public static final ealFovType_t EAL_FOV_TYPE_HORIZONTAL = new ealFovType_t("EAL_FOV_TYPE_HORIZONTAL");
    public static final ealFovType_t EAL_FOV_TYPE_VERTICAL = new ealFovType_t("EAL_FOV_TYPE_VERTICAL");
    public static final ealFovType_t EAL_FOV_TYPE_INVALID = new ealFovType_t("EAL_FOV_TYPE_INVALID");
    private static ealFovType_t[] swigValues = new ealFovType_t[]{EAL_FOV_TYPE_HORIZONTAL, EAL_FOV_TYPE_VERTICAL, EAL_FOV_TYPE_INVALID};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealFovType_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealFovType_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealFovType_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealFovType_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealFovType_t == null ? (class$de$esolutions$graphics$eal$ealFovType_t = ealFovType_t.class$("de.esolutions.graphics.eal.ealFovType_t")) : class$de$esolutions$graphics$eal$ealFovType_t).append(" with value ").append(n).toString());
    }

    private ealFovType_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealFovType_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealFovType_t(String string, ealFovType_t ealFovType_t2) {
        this.swigName = string;
        this.swigValue = ealFovType_t2.swigValue;
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

