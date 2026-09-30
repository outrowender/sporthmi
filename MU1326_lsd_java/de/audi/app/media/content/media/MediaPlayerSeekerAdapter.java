/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.content.media.ISeeker;

public class MediaPlayerSeekerAdapter
implements ISeeker {
    private final AbstractMediaPlayer mediaPlayer;

    MediaPlayerSeekerAdapter(AbstractMediaPlayer abstractMediaPlayer) {
        this.mediaPlayer = abstractMediaPlayer;
    }

    public boolean seek(boolean bl, int n) {
        return this.mediaPlayer.getDSIPlayer().dsiSeek(bl, n);
    }

    public int getMaxSeekSpeed() {
        return 64;
    }

    public boolean isFixedSpeedSeeker() {
        int n = this.mediaPlayer.getTerminal().getFramework().getSysConst(4283);
        boolean bl = n == 8;
        int n2 = this.mediaPlayer.getActiveSlot().getSource().getType();
        boolean bl2 = n2 == 0 || n2 == 2;
        return bl2 && bl;
    }
}

