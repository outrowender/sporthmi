/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealLayerPixelFormat_t {
    public static final ealLayerPixelFormat_t EAL_LAYER_PIXEL_FORMAT_RGB = new ealLayerPixelFormat_t("EAL_LAYER_PIXEL_FORMAT_RGB");
    public static final ealLayerPixelFormat_t EAL_LAYER_PIXEL_FORMAT_RGBA = new ealLayerPixelFormat_t("EAL_LAYER_PIXEL_FORMAT_RGBA");
    private static ealLayerPixelFormat_t[] swigValues = new ealLayerPixelFormat_t[]{EAL_LAYER_PIXEL_FORMAT_RGB, EAL_LAYER_PIXEL_FORMAT_RGBA};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealLayerPixelFormat_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealLayerPixelFormat_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealLayerPixelFormat_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealLayerPixelFormat_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealLayerPixelFormat_t == null ? (class$de$esolutions$graphics$eal$ealLayerPixelFormat_t = ealLayerPixelFormat_t.class$("de.esolutions.graphics.eal.ealLayerPixelFormat_t")) : class$de$esolutions$graphics$eal$ealLayerPixelFormat_t).append(" with value ").append(n).toString());
    }

    private ealLayerPixelFormat_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealLayerPixelFormat_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealLayerPixelFormat_t(String string, ealLayerPixelFormat_t ealLayerPixelFormat_t2) {
        this.swigName = string;
        this.swigValue = ealLayerPixelFormat_t2.swigValue;
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

