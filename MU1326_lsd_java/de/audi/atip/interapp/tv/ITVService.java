/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import de.audi.atip.interapp.media.IMediaDrawerContext;

public interface ITVService {
    public static final int SOURCE_TYPE_TV = 0;
    public static final int SOURCE_TYPE_AV = 1;

    public void activate(int var1, IMediaDrawerContext var2);

    public void deactivate();
}

