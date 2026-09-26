/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.audi.atip.log.LogChannel;

class SDISOnOffLineHandler {
    private int tvUserCounter = 0;
    private int stubCounter = 0;
    private final LogChannel log;

    SDISOnOffLineHandler(LogChannel logChannel) {
        this.log = logChannel;
    }

    synchronized void registerStub() {
        ++this.stubCounter;
    }

    synchronized boolean unregisterStub() {
        --this.stubCounter;
        if (this.stubCounter < 0) {
            this.stubCounter = 0;
            this.log.log(10000, "[SDISOnOffLineHandler.unregisterStub] tried to unregister a SDIS stub when stub counter was 0!");
        }
        if (this.stubCounter < this.tvUserCounter) {
            this.tvUserCounter = this.stubCounter;
            this.log.log(-2137614336, "[SDISOnOffLineHandler.unregisterStub] stub counter was lower then user counter. Assuming SDIS crash!");
        }
        return this.stubCounter == 0;
    }

    synchronized void logonToTV() {
        ++this.tvUserCounter;
        if (this.tvUserCounter > this.stubCounter) {
            this.tvUserCounter = this.stubCounter;
            this.log.log(10000, "[SDISOnOffLineHandler.logonToTV] tried to register a TV user more then SDIS stubs are available. User counter set to registered stub count!");
        }
    }

    synchronized boolean logoffFromTV() {
        --this.tvUserCounter;
        if (this.tvUserCounter < 0) {
            this.tvUserCounter = 0;
            this.log.log(10000, "[SDISOnOffLineHandler.logoffFromTV] tried to unregister a TV user when user counter was 0!");
        }
        return this.tvUserCounter == 0;
    }
}

