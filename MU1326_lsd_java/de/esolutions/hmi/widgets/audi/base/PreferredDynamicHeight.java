/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.PreferredSize;

public interface PreferredDynamicHeight
extends PreferredSize {
    default public int getPreferredHeight(int n) {
    }

    default public boolean isHeightDependentFromWidth() {
    }
}

