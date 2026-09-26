/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.INode;

public final class INode$blendMode_t {
    public static final INode$blendMode_t BLENDMODE_OPAQUE = new INode$blendMode_t("BLENDMODE_OPAQUE");
    public static final INode$blendMode_t BLENDMODE_ALPHA = new INode$blendMode_t("BLENDMODE_ALPHA");
    public static final INode$blendMode_t BLENDMODE_ADDITIVE = new INode$blendMode_t("BLENDMODE_ADDITIVE");
    private static INode$blendMode_t[] swigValues = new INode$blendMode_t[]{BLENDMODE_OPAQUE, BLENDMODE_ALPHA, BLENDMODE_ADDITIVE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static INode$blendMode_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && INode$blendMode_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (INode$blendMode_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(INode.class$de$esolutions$graphics$eal$api$INode$blendMode_t == null ? (INode.class$de$esolutions$graphics$eal$api$INode$blendMode_t = INode.class$("de.esolutions.graphics.eal.api.INode$blendMode_t")) : INode.class$de$esolutions$graphics$eal$api$INode$blendMode_t).append(" with value ").append(n).toString());
    }

    private INode$blendMode_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private INode$blendMode_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private INode$blendMode_t(String string, INode$blendMode_t iNode$blendMode_t) {
        this.swigName = string;
        this.swigValue = iNode$blendMode_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

