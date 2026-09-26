/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.hmi.model.list.EvoListRow;

public abstract class AbstractEntertainmentToggleItem
extends EvoListRow {
    public static final int TYPE_TUNER;
    public static final int TYPE_MEDIA;
    public static final int TYPE_ONLINE;
    public static final int TYPE_SDIS;

    public AbstractEntertainmentToggleItem(long l, int n) {
        super(l, n);
    }

    public AbstractEntertainmentToggleItem(AbstractEntertainmentToggleItem abstractEntertainmentToggleItem) {
        super(abstractEntertainmentToggleItem);
    }

    public abstract void activate() {
    }

    public abstract int getType() {
    }

    @Override
    public abstract EvoListRow copy() {
    }
}

