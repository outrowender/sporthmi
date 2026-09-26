/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class ealObjectType_t {
    public static final ealObjectType_t EAL_OBJECT_TYPE_IMAGE = new ealObjectType_t("EAL_OBJECT_TYPE_IMAGE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_TEXTURE = new ealObjectType_t("EAL_OBJECT_TYPE_TEXTURE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_PROPERTY_TYPE = new ealObjectType_t("EAL_OBJECT_TYPE_PROPERTY_TYPE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_MATERIAL_TYPE = new ealObjectType_t("EAL_OBJECT_TYPE_MATERIAL_TYPE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_MATERIAL = new ealObjectType_t("EAL_OBJECT_TYPE_MATERIAL");
    public static final ealObjectType_t EAL_OBJECT_TYPE_OBJECT_NODE = new ealObjectType_t("EAL_OBJECT_TYPE_OBJECT_NODE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_MESH = new ealObjectType_t("EAL_OBJECT_TYPE_MESH");
    public static final ealObjectType_t EAL_OBJECT_TYPE_SHADER_SOURCE = new ealObjectType_t("EAL_OBJECT_TYPE_SHADER_SOURCE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_COMPOSER = new ealObjectType_t("EAL_OBJECT_TYPE_COMPOSER");
    public static final ealObjectType_t EAL_OBJECT_TYPE_OBJECT_SOURCE = new ealObjectType_t("EAL_OBJECT_TYPE_OBJECT_SOURCE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_ANIMATION = new ealObjectType_t("EAL_OBJECT_TYPE_ANIMATION");
    public static final ealObjectType_t EAL_OBJECT_TYPE_ANIMATION_CLIP = new ealObjectType_t("EAL_OBJECT_TYPE_ANIMATION_CLIP");
    public static final ealObjectType_t EAL_OBJECT_TYPE_TIMELINE_SEQUENCE = new ealObjectType_t("EAL_OBJECT_TYPE_TIMELINE_SEQUENCE");
    public static final ealObjectType_t EAL_OBJECT_TYPE_SCREEN = new ealObjectType_t("EAL_OBJECT_TYPE_SCREEN");
    private static ealObjectType_t[] swigValues = new ealObjectType_t[]{EAL_OBJECT_TYPE_IMAGE, EAL_OBJECT_TYPE_TEXTURE, EAL_OBJECT_TYPE_PROPERTY_TYPE, EAL_OBJECT_TYPE_MATERIAL_TYPE, EAL_OBJECT_TYPE_MATERIAL, EAL_OBJECT_TYPE_OBJECT_NODE, EAL_OBJECT_TYPE_MESH, EAL_OBJECT_TYPE_SHADER_SOURCE, EAL_OBJECT_TYPE_COMPOSER, EAL_OBJECT_TYPE_OBJECT_SOURCE, EAL_OBJECT_TYPE_ANIMATION, EAL_OBJECT_TYPE_ANIMATION_CLIP, EAL_OBJECT_TYPE_TIMELINE_SEQUENCE, EAL_OBJECT_TYPE_SCREEN};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$ealObjectType_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ealObjectType_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ealObjectType_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ealObjectType_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$ealObjectType_t == null ? (class$de$esolutions$graphics$eal$ealObjectType_t = ealObjectType_t.class$("de.esolutions.graphics.eal.ealObjectType_t")) : class$de$esolutions$graphics$eal$ealObjectType_t).append(" with value ").append(n).toString());
    }

    private ealObjectType_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ealObjectType_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ealObjectType_t(String string, ealObjectType_t ealObjectType_t2) {
        this.swigName = string;
        this.swigValue = ealObjectType_t2.swigValue;
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

