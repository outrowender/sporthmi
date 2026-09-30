/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public interface IGridImageLocker {
    public void addLockImage(IconController var1);

    public void clearMenuImages();

    public int getCurrentLockingState();
}

