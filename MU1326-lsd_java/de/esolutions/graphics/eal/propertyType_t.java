/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class propertyType_t {
    public static final propertyType_t PROPERTYTYPE_INT = new propertyType_t("PROPERTYTYPE_INT");
    public static final propertyType_t PROPERTYTYPE_FLOAT = new propertyType_t("PROPERTYTYPE_FLOAT");
    public static final propertyType_t PROPERTYTYPE_BOOL = new propertyType_t("PROPERTYTYPE_BOOL");
    public static final propertyType_t PROPERTYTYPE_COLOR = new propertyType_t("PROPERTYTYPE_COLOR");
    public static final propertyType_t PROPERTYTYPE_VECTOR2 = new propertyType_t("PROPERTYTYPE_VECTOR2");
    public static final propertyType_t PROPERTYTYPE_VECTOR3 = new propertyType_t("PROPERTYTYPE_VECTOR3");
    public static final propertyType_t PROPERTYTYPE_VECTOR4 = new propertyType_t("PROPERTYTYPE_VECTOR4");
    public static final propertyType_t PROPERTYTYPE_MATRIX2X2 = new propertyType_t("PROPERTYTYPE_MATRIX2X2");
    public static final propertyType_t PROPERTYTYPE_MATRIX3X3 = new propertyType_t("PROPERTYTYPE_MATRIX3X3");
    public static final propertyType_t PROPERTYTYPE_MATRIX4X4 = new propertyType_t("PROPERTYTYPE_MATRIX4X4");
    public static final propertyType_t PROPERTYTYPE_STRING = new propertyType_t("PROPERTYTYPE_STRING");
    public static final propertyType_t PROPERTYTYPE_POINTER = new propertyType_t("PROPERTYTYPE_POINTER");
    public static final propertyType_t PROPERTYTYPE_TEXTURE = new propertyType_t("PROPERTYTYPE_TEXTURE");
    public static final propertyType_t PROPERTYTYPE_STRUCT = new propertyType_t("PROPERTYTYPE_STRUCT");
    public static final propertyType_t PROPERTYTYPE_ARRAY = new propertyType_t("PROPERTYTYPE_ARRAY");
    public static final propertyType_t PROPERTYTYPE_UNKNOWN = new propertyType_t("PROPERTYTYPE_UNKNOWN");
    private static propertyType_t[] swigValues = new propertyType_t[]{PROPERTYTYPE_INT, PROPERTYTYPE_FLOAT, PROPERTYTYPE_BOOL, PROPERTYTYPE_COLOR, PROPERTYTYPE_VECTOR2, PROPERTYTYPE_VECTOR3, PROPERTYTYPE_VECTOR4, PROPERTYTYPE_MATRIX2X2, PROPERTYTYPE_MATRIX3X3, PROPERTYTYPE_MATRIX4X4, PROPERTYTYPE_STRING, PROPERTYTYPE_POINTER, PROPERTYTYPE_TEXTURE, PROPERTYTYPE_STRUCT, PROPERTYTYPE_ARRAY, PROPERTYTYPE_UNKNOWN};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$propertyType_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static propertyType_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && propertyType_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (propertyType_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$propertyType_t == null ? (class$de$esolutions$graphics$eal$propertyType_t = propertyType_t.class$("de.esolutions.graphics.eal.propertyType_t")) : class$de$esolutions$graphics$eal$propertyType_t).append(" with value ").append(n).toString());
    }

    private propertyType_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private propertyType_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private propertyType_t(String string, propertyType_t propertyType_t2) {
        this.swigName = string;
        this.swigValue = propertyType_t2.swigValue;
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

