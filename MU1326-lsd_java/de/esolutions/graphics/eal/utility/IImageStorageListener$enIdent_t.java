/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.eal.utility.IImageStorageListener;
import de.esolutions.graphics.ealswigJNI;

public final class IImageStorageListener$enIdent_t {
    public static final IImageStorageListener$enIdent_t IDENT_NONE = new IImageStorageListener$enIdent_t("IDENT_NONE", ealswigJNI.eal_utility_IImageStorageListener_IDENT_NONE_get());
    private static IImageStorageListener$enIdent_t[] swigValues = new IImageStorageListener$enIdent_t[]{IDENT_NONE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static IImageStorageListener$enIdent_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && IImageStorageListener$enIdent_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (IImageStorageListener$enIdent_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(IImageStorageListener.class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t == null ? (IImageStorageListener.class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t = IImageStorageListener.class$("de.esolutions.graphics.eal.utility.IImageStorageListener$enIdent_t")) : IImageStorageListener.class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t).append(" with value ").append(n).toString());
    }

    private IImageStorageListener$enIdent_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private IImageStorageListener$enIdent_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private IImageStorageListener$enIdent_t(String string, IImageStorageListener$enIdent_t iImageStorageListener$enIdent_t) {
        this.swigName = string;
        this.swigValue = iImageStorageListener$enIdent_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

