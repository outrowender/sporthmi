/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

public interface LayoutManager {
    public void layout(AbstractWidget var1);

    public int[] calculateSize(AbstractWidget var1, int var2);

    public void flushCache();
}

