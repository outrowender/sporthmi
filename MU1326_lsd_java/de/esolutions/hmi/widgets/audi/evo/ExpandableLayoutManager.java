/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;

public interface ExpandableLayoutManager
extends LayoutManager {
    public int[] calculateSize(AbstractWidget var1, boolean var2, int var3);

    public void setExpanded(boolean var1);
}

