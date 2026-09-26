/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

public interface LayoutManager {
    default public void layout(AbstractWidget abstractWidget) {
    }

    default public int[] calculateSize(AbstractWidget abstractWidget, int n) {
    }

    default public void flushCache() {
    }
}

