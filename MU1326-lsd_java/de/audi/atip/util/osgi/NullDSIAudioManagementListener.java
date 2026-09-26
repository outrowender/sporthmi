/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.audio.DSIAudioManagementListener;

public class NullDSIAudioManagementListener
extends NullService
implements DSIAudioManagementListener {
    public NullDSIAudioManagementListener(LogChannel logChannel) {
        super(logChannel, "DSIAudioManagementListener");
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log();
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.log();
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void updateActiveConnection(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void startConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void updateAMAvailable(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void responseVolumelock(int n, int n2, boolean bl) {
        this.log();
    }
}

