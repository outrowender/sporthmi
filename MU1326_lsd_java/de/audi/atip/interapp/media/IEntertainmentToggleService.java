/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.media.AbstractEntertainmentToggleItem;

public interface IEntertainmentToggleService {
    public void setItem(AbstractEntertainmentToggleItem var1);

    public void removeItem(int var1);

    public void setActiveType(int var1);
}

