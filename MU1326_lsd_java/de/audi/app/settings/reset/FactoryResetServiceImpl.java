/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.reset;

import de.audi.app.settings.reset.FactoryResetHandler;
import de.audi.atip.interapp.FactResetService;
import de.esolutions.fw.util.commons.Buffer;

public class FactoryResetServiceImpl
implements FactResetService {
    private volatile boolean blockPhoneReset;
    private volatile boolean blockBluetoothReset;
    private FactoryResetHandler factoryResetHandler;
    private volatile boolean audiConnectResetBlocked = true;

    public FactoryResetServiceImpl(FactoryResetHandler factoryResetHandler) {
        this.factoryResetHandler = factoryResetHandler;
    }

    protected synchronized boolean isPhoneResetBlocked() {
        return this.blockPhoneReset;
    }

    protected synchronized boolean isBluetoothResetBlocked() {
        return this.blockBluetoothReset;
    }

    boolean isAudiConnectBlocked() {
        return this.audiConnectResetBlocked;
    }

    public synchronized void setPhoneStateBlockReset(boolean bl, boolean bl2) {
        if (bl != this.blockPhoneReset || this.blockBluetoothReset != bl2) {
            this.blockPhoneReset = bl;
            this.blockBluetoothReset = bl2;
            this.factoryResetHandler.updateEntryList();
        }
    }

    public void setAudiConnectResetBlocked(boolean bl) {
        if (this.audiConnectResetBlocked != bl) {
            this.audiConnectResetBlocked = bl;
            this.factoryResetHandler.updateEntryList();
        }
    }

    public void dump(Buffer buffer) {
        buffer.append("FactoryResetService:");
        buffer.append("\n\t").append("blockPhoneReset: ").append(this.blockPhoneReset);
        buffer.append("\n\t").append("blockBluetoothReset: ").append(this.blockBluetoothReset);
        buffer.append("\n\t").append("audiConnectResetBlocked: ").append(this.audiConnectResetBlocked);
    }
}

