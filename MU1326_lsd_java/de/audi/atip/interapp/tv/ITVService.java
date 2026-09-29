/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.tv;

import de.audi.atip.interapp.media.IMediaDrawerContext;

public interface ITVService {
    public static final int SOURCE_TYPE_TV;
    public static final int SOURCE_TYPE_AV;

    default public void activate(int n, IMediaDrawerContext iMediaDrawerContext) {
    }

    default public void deactivate() {
    }
}

