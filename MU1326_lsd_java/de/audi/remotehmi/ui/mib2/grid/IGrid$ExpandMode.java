/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.util.EnumHelper;
import de.audi.remotehmi.util.EnumParser;
import java.util.List;

public final class IGrid$ExpandMode {
    private static final EnumHelper enumHelper = new EnumHelper();
    public static final IGrid$ExpandMode GROW = new IGrid$ExpandMode("grow", false, true);
    public static final IGrid$ExpandMode SHRINK = new IGrid$ExpandMode("shrink", true, false);
    public static final IGrid$ExpandMode DYNAMIC = new IGrid$ExpandMode("dynamic", true, true);
    public static final IGrid$ExpandMode FIXED = new IGrid$ExpandMode("fixed", false, false);
    private final String name;
    private final boolean isShrinkable;
    private final boolean isGrowable;

    private IGrid$ExpandMode(String string, boolean bl, boolean bl2) {
        this.name = string;
        this.isShrinkable = bl;
        this.isGrowable = bl2;
        enumHelper.addInstance(string, this);
    }

    public static final List values() {
        return enumHelper.values();
    }

    public static final IGrid$ExpandMode valueOf(String string) {
        return (IGrid$ExpandMode)enumHelper.valueOf(string);
    }

    public String toString() {
        return this.name;
    }

    public static final EnumParser getParser() {
        return enumHelper.getParser();
    }

    public boolean isShrinkable() {
        return this.isShrinkable;
    }

    public boolean isGrowable() {
        return this.isGrowable;
    }

    public static IGrid$ExpandMode fromWeights(int n, int n2) {
        if (n == -1 && n2 == -1) {
            return null;
        }
        if (n > 0) {
            return n2 > 0 ? DYNAMIC : SHRINK;
        }
        if (n2 > 0) {
            return GROW;
        }
        return FIXED;
    }
}

