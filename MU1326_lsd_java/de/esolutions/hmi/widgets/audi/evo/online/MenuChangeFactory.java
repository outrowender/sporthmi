/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.evo.online.IGridImageLocker;

public interface MenuChangeFactory {
    default public void changeMenu(Object object) {
    }

    default public void setImageLockController(IGridImageLocker iGridImageLocker) {
    }
}

