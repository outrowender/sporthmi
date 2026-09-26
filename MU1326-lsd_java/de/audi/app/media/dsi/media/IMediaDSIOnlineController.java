/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;

public interface IMediaDSIOnlineController
extends IDSIController {
    default public void addMediaOnlineListener(IMediaDSIOnlineListener iMediaDSIOnlineListener) {
    }
}

