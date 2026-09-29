/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public final class imageOptions_t {
    public static final imageOptions_t IMAGE_OPTIONS_MASK_FORMAT = new imageOptions_t("IMAGE_OPTIONS_MASK_FORMAT", ealswigJNI.eal_IMAGE_OPTIONS_MASK_FORMAT_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_RGBA_8888 = new imageOptions_t("IMAGE_OPTIONS_FORMAT_RGBA_8888", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_RGBA_8888_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_RGB_888 = new imageOptions_t("IMAGE_OPTIONS_FORMAT_RGB_888", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_RGB_888_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_RGB_565 = new imageOptions_t("IMAGE_OPTIONS_FORMAT_RGB_565", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_RGB_565_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_L_8 = new imageOptions_t("IMAGE_OPTIONS_FORMAT_L_8", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_L_8_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_A_8 = new imageOptions_t("IMAGE_OPTIONS_FORMAT_A_8", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_A_8_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_LA_88 = new imageOptions_t("IMAGE_OPTIONS_FORMAT_LA_88", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_LA_88_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_AUTO = new imageOptions_t("IMAGE_OPTIONS_FORMAT_AUTO", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_AUTO_get());
    public static final imageOptions_t IMAGE_OPTIONS_FORMAT_INVALID = new imageOptions_t("IMAGE_OPTIONS_FORMAT_INVALID", ealswigJNI.eal_IMAGE_OPTIONS_FORMAT_INVALID_get());
    private static imageOptions_t[] swigValues = new imageOptions_t[]{IMAGE_OPTIONS_MASK_FORMAT, IMAGE_OPTIONS_FORMAT_RGBA_8888, IMAGE_OPTIONS_FORMAT_RGB_888, IMAGE_OPTIONS_FORMAT_RGB_565, IMAGE_OPTIONS_FORMAT_L_8, IMAGE_OPTIONS_FORMAT_A_8, IMAGE_OPTIONS_FORMAT_LA_88, IMAGE_OPTIONS_FORMAT_AUTO, IMAGE_OPTIONS_FORMAT_INVALID};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$imageOptions_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static imageOptions_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && imageOptions_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (imageOptions_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$imageOptions_t == null ? (class$de$esolutions$graphics$eal$imageOptions_t = imageOptions_t.class$("de.esolutions.graphics.eal.imageOptions_t")) : class$de$esolutions$graphics$eal$imageOptions_t).append(" with value ").append(n).toString());
    }

    private imageOptions_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private imageOptions_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private imageOptions_t(String string, imageOptions_t imageOptions_t2) {
        this.swigName = string;
        this.swigValue = imageOptions_t2.swigValue;
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

