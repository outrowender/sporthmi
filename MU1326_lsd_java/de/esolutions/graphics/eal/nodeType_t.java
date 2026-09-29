/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

public final class nodeType_t {
    public static final nodeType_t NODETYPE_NONE = new nodeType_t("NODETYPE_NONE");
    public static final nodeType_t NODETYPE_NODE2D = new nodeType_t("NODETYPE_NODE2D");
    public static final nodeType_t NODETYPE_NODE3D = new nodeType_t("NODETYPE_NODE3D");
    public static final nodeType_t NODETYPE_TEMPLATE_2D = new nodeType_t("NODETYPE_TEMPLATE_2D");
    public static final nodeType_t NODETYPE_TEMPLATE_3D = new nodeType_t("NODETYPE_TEMPLATE_3D");
    private static nodeType_t[] swigValues = new nodeType_t[]{NODETYPE_NONE, NODETYPE_NODE2D, NODETYPE_NODE3D, NODETYPE_TEMPLATE_2D, NODETYPE_TEMPLATE_3D};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$nodeType_t;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static nodeType_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && nodeType_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (nodeType_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(class$de$esolutions$graphics$eal$nodeType_t == null ? (class$de$esolutions$graphics$eal$nodeType_t = nodeType_t.class$("de.esolutions.graphics.eal.nodeType_t")) : class$de$esolutions$graphics$eal$nodeType_t).append(" with value ").append(n).toString());
    }

    private nodeType_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private nodeType_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private nodeType_t(String string, nodeType_t nodeType_t2) {
        this.swigName = string;
        this.swigValue = nodeType_t2.swigValue;
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

