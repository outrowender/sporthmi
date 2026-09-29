/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealCullMode_t {
    public static final ealCullMode_t EAL_CULLMODE_FRONT = new ealCullMode_t("EAL_CULLMODE_FRONT");
    public static final ealCullMode_t EAL_CULLMODE_BACK = new ealCullMode_t("EAL_CULLMODE_BACK");
    public static final ealCullMode_t EAL_CULLMODE_NONE = new ealCullMode_t("EAL_CULLMODE_NONE");
    private static ealCullMode_t[] swigValues = new ealCullMode_t[]{EAL_CULLMODE_FRONT, EAL_CULLMODE_BACK, EAL_CULLMODE_NONE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealCullMode_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealCullMode_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealCullMode_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealCullMode_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealCullMode_t == null ? (class$de$esolutions$graphics$eal$ealCullMode_t = ealCullMode_t.class$("de.esolutions.graphics.eal.ealCullMode_t")) : class$de$esolutions$graphics$eal$ealCullMode_t).append(" with value ").append(n).toString());
    }

    private ealCullMode_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealCullMode_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealCullMode_t(String string, ealCullMode_t ealCullMode_t2) {
        this.swigName = string;
        this.swigValue = ealCullMode_t2.swigValue;
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

