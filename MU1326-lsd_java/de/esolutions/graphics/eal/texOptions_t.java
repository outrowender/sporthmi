/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public final class texOptions_t {
    public static final texOptions_t TEX_OPTIONS_MASK_MEMORY = new texOptions_t("TEX_OPTIONS_MASK_MEMORY", ealswigJNI.eal_TEX_OPTIONS_MASK_MEMORY_get());
    public static final texOptions_t TEX_OPTIONS_MASK_FILTER = new texOptions_t("TEX_OPTIONS_MASK_FILTER", ealswigJNI.eal_TEX_OPTIONS_MASK_FILTER_get());
    public static final texOptions_t TEX_OPTIONS_MASK_WRAP = new texOptions_t("TEX_OPTIONS_MASK_WRAP", ealswigJNI.eal_TEX_OPTIONS_MASK_WRAP_get());
    public static final texOptions_t TEX_OPTIONS_MASK_COMPRESSION = new texOptions_t("TEX_OPTIONS_MASK_COMPRESSION", ealswigJNI.eal_TEX_OPTIONS_MASK_COMPRESSION_get());
    public static final texOptions_t TEX_OPTIONS_MASK_FORMAT = new texOptions_t("TEX_OPTIONS_MASK_FORMAT", ealswigJNI.eal_TEX_OPTIONS_MASK_FORMAT_get());
    public static final texOptions_t TEX_OPTIONS_MASK_EXT = new texOptions_t("TEX_OPTIONS_MASK_EXT", ealswigJNI.eal_TEX_OPTIONS_MASK_EXT_get());
    public static final texOptions_t TEX_OPTIONS_MEMORY_GPU = new texOptions_t("TEX_OPTIONS_MEMORY_GPU", ealswigJNI.eal_TEX_OPTIONS_MEMORY_GPU_get());
    public static final texOptions_t TEX_OPTIONS_MEMORY_RAM = new texOptions_t("TEX_OPTIONS_MEMORY_RAM", ealswigJNI.eal_TEX_OPTIONS_MEMORY_RAM_get());
    public static final texOptions_t TEX_OPTIONS_FILTER_POINT = new texOptions_t("TEX_OPTIONS_FILTER_POINT", ealswigJNI.eal_TEX_OPTIONS_FILTER_POINT_get());
    public static final texOptions_t TEX_OPTIONS_FILTER_BILINEAR = new texOptions_t("TEX_OPTIONS_FILTER_BILINEAR", ealswigJNI.eal_TEX_OPTIONS_FILTER_BILINEAR_get());
    public static final texOptions_t TEX_OPTIONS_FILTER_TRILINAR = new texOptions_t("TEX_OPTIONS_FILTER_TRILINAR", ealswigJNI.eal_TEX_OPTIONS_FILTER_TRILINAR_get());
    public static final texOptions_t TEX_OPTIONS_FILTER_MIMAP = new texOptions_t("TEX_OPTIONS_FILTER_MIMAP", ealswigJNI.eal_TEX_OPTIONS_FILTER_MIMAP_get());
    public static final texOptions_t TEX_OPTIONS_WRAP_REPEAT = new texOptions_t("TEX_OPTIONS_WRAP_REPEAT", ealswigJNI.eal_TEX_OPTIONS_WRAP_REPEAT_get());
    public static final texOptions_t TEX_OPTIONS_WRAP_CLAMP = new texOptions_t("TEX_OPTIONS_WRAP_CLAMP", ealswigJNI.eal_TEX_OPTIONS_WRAP_CLAMP_get());
    public static final texOptions_t TEX_OPTIONS_COMPRESSION_NONE = new texOptions_t("TEX_OPTIONS_COMPRESSION_NONE", ealswigJNI.eal_TEX_OPTIONS_COMPRESSION_NONE_get());
    public static final texOptions_t TEX_OPTIONS_COMPRESSION_ETC = new texOptions_t("TEX_OPTIONS_COMPRESSION_ETC", ealswigJNI.eal_TEX_OPTIONS_COMPRESSION_ETC_get());
    public static final texOptions_t TEX_OPTIONS_COMPRESSION_DXT3_RGBA = new texOptions_t("TEX_OPTIONS_COMPRESSION_DXT3_RGBA", ealswigJNI.eal_TEX_OPTIONS_COMPRESSION_DXT3_RGBA_get());
    public static final texOptions_t TEX_OPTIONS_COMPRESSION_DXT5_RGBA = new texOptions_t("TEX_OPTIONS_COMPRESSION_DXT5_RGBA", ealswigJNI.eal_TEX_OPTIONS_COMPRESSION_DXT5_RGBA_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_RGBA_8888 = new texOptions_t("TEX_OPTIONS_FORMAT_RGBA_8888", ealswigJNI.eal_TEX_OPTIONS_FORMAT_RGBA_8888_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_RGB_888 = new texOptions_t("TEX_OPTIONS_FORMAT_RGB_888", ealswigJNI.eal_TEX_OPTIONS_FORMAT_RGB_888_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_RGB_565 = new texOptions_t("TEX_OPTIONS_FORMAT_RGB_565", ealswigJNI.eal_TEX_OPTIONS_FORMAT_RGB_565_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_L_8 = new texOptions_t("TEX_OPTIONS_FORMAT_L_8", ealswigJNI.eal_TEX_OPTIONS_FORMAT_L_8_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_A_8 = new texOptions_t("TEX_OPTIONS_FORMAT_A_8", ealswigJNI.eal_TEX_OPTIONS_FORMAT_A_8_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_LA_88 = new texOptions_t("TEX_OPTIONS_FORMAT_LA_88", ealswigJNI.eal_TEX_OPTIONS_FORMAT_LA_88_get());
    public static final texOptions_t TEX_OPTIONS_FORMAT_INVALID = new texOptions_t("TEX_OPTIONS_FORMAT_INVALID", ealswigJNI.eal_TEX_OPTIONS_FORMAT_INVALID_get());
    public static final texOptions_t TEX_OPTIONS_EXT_CLEAR_BLACK = new texOptions_t("TEX_OPTIONS_EXT_CLEAR_BLACK", ealswigJNI.eal_TEX_OPTIONS_EXT_CLEAR_BLACK_get());
    public static final texOptions_t TEX_OPTIONS_EXT_NO_ATLAS = new texOptions_t("TEX_OPTIONS_EXT_NO_ATLAS", ealswigJNI.eal_TEX_OPTIONS_EXT_NO_ATLAS_get());
    public static final texOptions_t TEX_OPTIONS_EXT_EXTERNAL_OES = new texOptions_t("TEX_OPTIONS_EXT_EXTERNAL_OES", ealswigJNI.eal_TEX_OPTIONS_EXT_EXTERNAL_OES_get());
    public static final texOptions_t TEX_OPTION_INVALID = new texOptions_t("TEX_OPTION_INVALID", ealswigJNI.eal_TEX_OPTION_INVALID_get());
    private static texOptions_t[] swigValues = new texOptions_t[]{TEX_OPTIONS_MASK_MEMORY, TEX_OPTIONS_MASK_FILTER, TEX_OPTIONS_MASK_WRAP, TEX_OPTIONS_MASK_COMPRESSION, TEX_OPTIONS_MASK_FORMAT, TEX_OPTIONS_MASK_EXT, TEX_OPTIONS_MEMORY_GPU, TEX_OPTIONS_MEMORY_RAM, TEX_OPTIONS_FILTER_POINT, TEX_OPTIONS_FILTER_BILINEAR, TEX_OPTIONS_FILTER_TRILINAR, TEX_OPTIONS_FILTER_MIMAP, TEX_OPTIONS_WRAP_REPEAT, TEX_OPTIONS_WRAP_CLAMP, TEX_OPTIONS_COMPRESSION_NONE, TEX_OPTIONS_COMPRESSION_ETC, TEX_OPTIONS_COMPRESSION_DXT3_RGBA, TEX_OPTIONS_COMPRESSION_DXT5_RGBA, TEX_OPTIONS_FORMAT_RGBA_8888, TEX_OPTIONS_FORMAT_RGB_888, TEX_OPTIONS_FORMAT_RGB_565, TEX_OPTIONS_FORMAT_L_8, TEX_OPTIONS_FORMAT_A_8, TEX_OPTIONS_FORMAT_LA_88, TEX_OPTIONS_FORMAT_INVALID, TEX_OPTIONS_EXT_CLEAR_BLACK, TEX_OPTIONS_EXT_NO_ATLAS, TEX_OPTIONS_EXT_EXTERNAL_OES, TEX_OPTION_INVALID};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$texOptions_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static texOptions_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && texOptions_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (texOptions_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$texOptions_t == null ? (class$de$esolutions$graphics$eal$texOptions_t = texOptions_t.class$("de.esolutions.graphics.eal.texOptions_t")) : class$de$esolutions$graphics$eal$texOptions_t).append(" with value ").append(n).toString());
    }

    private texOptions_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private texOptions_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private texOptions_t(String string, texOptions_t texOptions_t2) {
        this.swigName = string;
        this.swigValue = texOptions_t2.swigValue;
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

