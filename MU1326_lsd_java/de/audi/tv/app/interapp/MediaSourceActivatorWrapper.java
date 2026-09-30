/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.tv.ITVParentActivationService;

public class MediaSourceActivatorWrapper
implements ITVParentActivationService {
    private IMediaService service;

    public MediaSourceActivatorWrapper(IMediaService iMediaService) {
        this.service = iMediaService;
    }

    public void activateSource(int n) {
        if (n == 0) {
            this.service.activateSource(7, 0);
        } else if (n == 1) {
            this.service.activateSource(8, 0);
        }
    }
}

