/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.audi.atip.log.LogChannel;

public final class DataRemoteServices {
    private volatile MobileKeySetup currentMobileKeySetup;
    private LogChannel logCh;

    public DataRemoteServices(LogChannel logChannel) {
        this.logCh = logChannel;
    }

    public synchronized MobileKeySetup getCurrentMobileKeySetup() {
        if (this.currentMobileKeySetup == null) {
            this.logCh.log(1000000, "MobileKeySetup currently not valid! Return default values!");
            MobileKeySetup.Builder builder = new MobileKeySetup.Builder();
            this.setCurrentMobileKeySetup(builder.build());
        }
        return this.currentMobileKeySetup;
    }

    public synchronized void setCurrentMobileKeySetup(MobileKeySetup mobileKeySetup) {
        this.currentMobileKeySetup = mobileKeySetup;
    }

    public synchronized void clear() {
        this.currentMobileKeySetup = null;
    }
}

