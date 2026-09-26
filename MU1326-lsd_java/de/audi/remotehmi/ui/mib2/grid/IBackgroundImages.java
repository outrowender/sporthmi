/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IBackgroundImages$ImageContent;

public interface IBackgroundImages {
    default public ImageContent getTop() {
    }

    default public ImageContent getCenter() {
    }

    default public ImageContent getBottom() {
    }

    default public boolean isStretchTopBottomVertically() {
    }

    default public boolean isTopGenerateRow() {
    }

    default public boolean isBottomGenerateRow() {
    }
}

