/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.apps.media.IMediaPlayModeStrategy;
import de.audi.atip.interapp.media.IMediaSDSService;

public class MediaPlayModeEvo
implements IMediaPlayModeStrategy {
    private static final int PLAYMODE_MIX_OFF;
    private static final int PLAYMODE_MIX_ON;

    @Override
    public boolean executePlayMode(int n, IMediaSDSService iMediaSDSService) {
        switch (n) {
            case 1: {
                iMediaSDSService.mix(true);
                break;
            }
            case 0: {
                iMediaSDSService.mix(false);
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}

