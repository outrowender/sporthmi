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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void fadeToConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void releaseConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void getActiveConnection(int n) {
        this.log();
    }

    @Override
    public void getActiveEntertainmentConnection(int n) {
        this.log();
    }

    @Override
    public void requestConnection(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void setVolumelock(int n, int n2, boolean bl) {
        this.log();
    }

    @Override
    public void getVolumelock(int n, int n2) {
        this.log();
    }
}

