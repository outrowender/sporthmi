/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListRow;

public interface TooltipListener {
    default public void tooltipDataRequested(int n, int n2, int n3, boolean bl, int n4) {
    }

    default public void tooltipDataRequested(int n, int n2, ListRow listRow, boolean bl, int n3) {
    }

    default public void tooltipVisible(int n, int n2, int n3) {
    }

    default public void tooltipHidden(int n, int n2, int n3) {
    }
}

