/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.base.DSIListener;

public class NullDSIAudioManagement
extends NullService
implements DSIAudioManagement {
    public NullDSIAudioManagement(LogChannel logChannel) {
        super(logChannel, 1000, "DSIAudioManagement");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void fadeToConnection(int n, int n2) {
        this.log();
    }

    public void releaseConnection(int n, int n2) {
        this.log();
    }

    public void getActiveConnection(int n) {
        this.log();
    }

    public void getActiveEntertainmentConnection(int n) {
        this.log();
    }

    public void requestConnection(int n, int n2, int n3) {
        this.log();
    }

    public void setVolumelock(int n, int n2, boolean bl) {
        this.log();
    }

    public void getVolumelock(int n, int n2) {
        this.log();
    }
}

