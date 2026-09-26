/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public interface IGridImageLocker {
    default public void addLockImage(IconController iconController) {
    }

    default public void clearMenuImages() {
    }

    default public int getCurrentLockingState() {
    }
}

