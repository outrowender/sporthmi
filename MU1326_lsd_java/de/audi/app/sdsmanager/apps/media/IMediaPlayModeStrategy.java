/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.atip.interapp.media.IMediaSDSService;

public interface IMediaPlayModeStrategy {
    default public boolean executePlayMode(int n, IMediaSDSService iMediaSDSService) {
    }
}

