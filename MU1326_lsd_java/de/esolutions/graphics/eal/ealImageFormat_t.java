/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealImageFormat_t {
    public static final ealImageFormat_t EAL_IMAGEFORMAT_JPEG = new ealImageFormat_t("EAL_IMAGEFORMAT_JPEG");
    public static final ealImageFormat_t EAL_IMAGEFORMAT_PNG = new ealImageFormat_t("EAL_IMAGEFORMAT_PNG");
    public static final ealImageFormat_t EAL_IMAGEFORMAT_TIFF = new ealImageFormat_t("EAL_IMAGEFORMAT_TIFF");
    public static final ealImageFormat_t EAL_IMAGEFORMAT_RAW = new ealImageFormat_t("EAL_IMAGEFORMAT_RAW");
    private static ealImageFormat_t[] swigValues = new ealImageFormat_t[]{EAL_IMAGEFORMAT_JPEG, EAL_IMAGEFORMAT_PNG, EAL_IMAGEFORMAT_TIFF, EAL_IMAGEFORMAT_RAW};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealImageFormat_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealImageFormat_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealImageFormat_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealImageFormat_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealImageFormat_t == null ? (class$de$esolutions$graphics$eal$ealImageFormat_t = ealImageFormat_t.class$("de.esolutions.graphics.eal.ealImageFormat_t")) : class$de$esolutions$graphics$eal$ealImageFormat_t).append(" with value ").append(n).toString());
    }

    private ealImageFormat_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealImageFormat_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealImageFormat_t(String string, ealImageFormat_t ealImageFormat_t2) {
        this.swigName = string;
        this.swigValue = ealImageFormat_t2.swigValue;
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

