/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListRow;

public interface TooltipListener {
    public void tooltipDataRequested(int var1, int var2, int var3, boolean var4, int var5);

    public void tooltipDataRequested(int var1, int var2, ListRow var3, boolean var4, int var5);

    public void tooltipVisible(int var1, int var2, int var3);

    public void tooltipHidden(int var1, int var2, int var3);
}

