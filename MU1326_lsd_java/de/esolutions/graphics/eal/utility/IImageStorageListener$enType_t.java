/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.eal.utility.IImageStorageListener;

public final class IImageStorageListener$enType_t {
    public static final IImageStorageListener$enType_t TYPE_FINISHED = new IImageStorageListener$enType_t("TYPE_FINISHED");
    public static final IImageStorageListener$enType_t TYPE_ERROR = new IImageStorageListener$enType_t("TYPE_ERROR");
    private static IImageStorageListener$enType_t[] swigValues = new IImageStorageListener$enType_t[]{TYPE_FINISHED, TYPE_ERROR};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static IImageStorageListener$enType_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && IImageStorageListener$enType_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (IImageStorageListener$enType_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(IImageStorageListener.class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t == null ? (IImageStorageListener.class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t = IImageStorageListener.class$("de.esolutions.graphics.eal.utility.IImageStorageListener$enType_t")) : IImageStorageListener.class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t).append(" with value ").append(n).toString());
    }

    private IImageStorageListener$enType_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private IImageStorageListener$enType_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private IImageStorageListener$enType_t(String string, IImageStorageListener$enType_t iImageStorageListener$enType_t) {
        this.swigName = string;
        this.swigValue = iImageStorageListener$enType_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

