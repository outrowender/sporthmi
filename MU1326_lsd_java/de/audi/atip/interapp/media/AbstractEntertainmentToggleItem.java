/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.hmi.model.list.EvoListRow;

public abstract class AbstractEntertainmentToggleItem
extends EvoListRow {
    public static final int TYPE_TUNER = 0;
    public static final int TYPE_MEDIA = 1;
    public static final int TYPE_ONLINE = 2;
    public static final int TYPE_SDIS = 3;

    public AbstractEntertainmentToggleItem(long l, int n) {
        super(l, n);
    }

    public AbstractEntertainmentToggleItem(AbstractEntertainmentToggleItem abstractEntertainmentToggleItem) {
        super(abstractEntertainmentToggleItem);
    }

    public abstract void activate();

    public abstract int getType();

    public abstract EvoListRow copy();
}

