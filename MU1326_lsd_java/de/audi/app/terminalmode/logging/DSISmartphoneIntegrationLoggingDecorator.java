/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.DSIBaseLoggingDecorator;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;

public class DSISmartphoneIntegrationLoggingDecorator
extends DSIBaseLoggingDecorator
implements DSISmartphoneIntegration {
    private final DSISmartphoneIntegration wrappee;

    public DSISmartphoneIntegrationLoggingDecorator(DSISmartphoneIntegration dSISmartphoneIntegration, LogChannel logChannel, int n) {
        super(dSISmartphoneIntegration, logChannel, n, "DSISmartphoneIntegration");
        this.wrappee = dSISmartphoneIntegration;
    }

    public void connectDevice(int n, int n2) {
        this.lc.log(this.level, "-> [DSISmartphoneIntegration.connectDevice] deviceID %1, connectionMethod %2", (long)n, (long)n2);
        this.wrappee.connectDevice(n, n2);
    }

    public void disconnectDevice(int n) {
        this.lc.log(this.level, "-> [DSISmartphoneIntegration.disconnectDevice] deviceID %1", (long)n);
        this.wrappee.disconnectDevice(n);
    }

    public void requestFactorySettings(int n) {
        this.lc.log(this.level, "-> [DSISmartphoneIntegration.requestFactorySettings] resetMode %1", (long)n);
        this.wrappee.requestFactorySettings(n);
    }

    public void requestAppConnectContextActive(boolean bl) {
        this.lc.log(this.level, "-> [DSISmartphoneIntegration.requestAppConnectContextActive] active %1", bl);
        this.wrappee.requestAppConnectContextActive(bl);
    }
}

