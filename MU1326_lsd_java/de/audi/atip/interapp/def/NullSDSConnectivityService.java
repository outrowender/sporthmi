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

    public void disclaimerAccept() {
        super.log();
    }

    public void activateNadModule() {
        super.log();
    }

    public void acceptOnce() {
        super.log();
    }

    public void acceptAlways() {
        super.log();
    }

    public void reject() {
        super.log();
    }

    public void activateOnlineConnection() {
        super.log();
    }

    public void deactivateOnlineConnection() {
        super.log();
    }

    public void activateRoaming() {
        super.log();
    }

    public void confirmRoaming() {
        super.log();
    }

    public void declineRoaming() {
        super.log();
    }
}

