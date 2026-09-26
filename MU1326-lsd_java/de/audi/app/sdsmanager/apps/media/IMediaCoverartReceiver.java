/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.atip.interapp.media.MediaCoverartEntry;

public interface IMediaCoverartReceiver {
    default public void receiveCoverarts(byte by, MediaCoverartEntry[] mediaCoverartEntryArray) {
    }
}

