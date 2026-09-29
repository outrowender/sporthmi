/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.init;

import de.audi.atip.log.LogChannel;
import de.audi.audio.intra.DefaultAudioListener;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;

public class DSISoundNotifications
extends DefaultAudioListener {
    private static final int[] ATTRS = new int[]{26, 24, 36, 14, 35};
    private final LogChannel lc;
    private final DSISoundListener dsiSoundListener;
    private volatile DSISound dsiSound;
    private volatile boolean amAvailable;

    public DSISoundNotifications(LogChannel logChannel, DSISoundListener dSISoundListener) {
        this.lc = logChannel;
        this.dsiSoundListener = dSISoundListener;
    }

    void addDSI(DSISound dSISound) {
        this.dsiSound = dSISound;
        this.setNotifications();
    }

    void removeDSI() {
        this.dsiSound = null;
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.amAvailable = bl;
        this.setNotifications();
    }

    private void setNotifications() {
        if (this.dsiSound != null && this.amAvailable) {
            this.lc.log(1078071040, "[ATIPAudioManager.setNotifications] %2 %1", (Object)this.dsiSound, (Object)ATTRS);
            this.dsiSound.setNotification(ATTRS, (DSIListener)this.dsiSoundListener);
        }
    }
}

