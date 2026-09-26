/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;

public interface ExpandableLayoutManager
extends LayoutManager {
    default public int[] calculateSize(AbstractWidget abstractWidget, boolean bl, int n) {
    }

    default public void setExpanded(boolean bl) {
    }
}

