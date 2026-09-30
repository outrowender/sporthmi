/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.base;

public interface DSIListener {
    public static final int RT_NONE = 0;
    public static final int ATTRVALIDFLAG_UNKNOWN = 0;
    public static final int ATTRVALIDFLAG_VALID = 1;
    public static final int ATTRVALIDFLAG_INVALID = 2;

    public void asyncException(int var1, String var2, int var3);
}

