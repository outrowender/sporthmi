/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealBlendmode_t {
    public static final ealBlendmode_t EAL_BLENDMODE_OPAQUE = new ealBlendmode_t("EAL_BLENDMODE_OPAQUE");
    public static final ealBlendmode_t EAL_BLENDMODE_ALPHA = new ealBlendmode_t("EAL_BLENDMODE_ALPHA");
    public static final ealBlendmode_t EAL_BLENDMODE_ADDITIVE = new ealBlendmode_t("EAL_BLENDMODE_ADDITIVE");
    public static final ealBlendmode_t EAL_BLENDMODE_PREMULTIPLIED_ALPHA = new ealBlendmode_t("EAL_BLENDMODE_PREMULTIPLIED_ALPHA");
    public static final ealBlendmode_t EAL_BLENDMODE_MIXED_ALPHA = new ealBlendmode_t("EAL_BLENDMODE_MIXED_ALPHA");
    private static ealBlendmode_t[] swigValues = new ealBlendmode_t[]{EAL_BLENDMODE_OPAQUE, EAL_BLENDMODE_ALPHA, EAL_BLENDMODE_ADDITIVE, EAL_BLENDMODE_PREMULTIPLIED_ALPHA, EAL_BLENDMODE_MIXED_ALPHA};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealBlendmode_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealBlendmode_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealBlendmode_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealBlendmode_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealBlendmode_t == null ? (class$de$esolutions$graphics$eal$ealBlendmode_t = ealBlendmode_t.class$("de.esolutions.graphics.eal.ealBlendmode_t")) : class$de$esolutions$graphics$eal$ealBlendmode_t).append(" with value ").append(n).toString());
    }

    private ealBlendmode_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealBlendmode_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealBlendmode_t(String string, ealBlendmode_t ealBlendmode_t2) {
        this.swigName = string;
        this.swigValue = ealBlendmode_t2.swigValue;
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

