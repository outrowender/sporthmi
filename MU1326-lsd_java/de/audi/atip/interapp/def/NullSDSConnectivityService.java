/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.ISdsConnectivityService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullSDSConnectivityService
extends NullService
implements ISdsConnectivityService {
    public NullSDSConnectivityService(LogChannel logChannel) {
        super(logChannel, "SDSConnectivityService");
    }

    @Override
    public void disclaimerAccept() {
        super.log();
    }

    @Override
    public void activateNadModule() {
        super.log();
    }

    @Override
    public void acceptOnce() {
        super.log();
    }

    @Override
    public void acceptAlways() {
        super.log();
    }

    @Override
    public void reject() {
        super.log();
    }

    @Override
    public void activateOnlineConnection() {
        super.log();
    }

    @Override
    public void deactivateOnlineConnection() {
        super.log();
    }

    @Override
    public void activateRoaming() {
        super.log();
    }

    @Override
    public void confirmRoaming() {
        super.log();
    }

    @Override
    public void declineRoaming() {
        super.log();
    }
}

