/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.ISeeker;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;

public class OnlineContentSeekerAdapter
implements ISeeker {
    private final IMediaDSIPlayerController player;

    OnlineContentSeekerAdapter(IMediaDSIPlayerController iMediaDSIPlayerController) {
        this.player = iMediaDSIPlayerController;
    }

    @Override
    public boolean seek(boolean bl, int n) {
        return this.player.dsiSeek(bl, n);
    }

    @Override
    public int getMaxSeekSpeed() {
        return 32;
    }

    @Override
    public boolean isFixedSpeedSeeker() {
        return false;
    }
}

