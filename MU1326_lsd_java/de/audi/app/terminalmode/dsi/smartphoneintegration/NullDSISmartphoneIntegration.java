/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;

public class NullDSISmartphoneIntegration
implements DSISmartphoneIntegration {
    private static final String LOGCLASS = "NullDSISmartphoneIntegration";
    private final LogChannel logger;

    public NullDSISmartphoneIntegration(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.setNotification]", (Object)LOGCLASS);
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.setNotification]", (Object)LOGCLASS);
    }

    public void setNotification(DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.setNotification]", (Object)LOGCLASS);
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.clearNotification]", (Object)LOGCLASS);
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.clearNotification]", (Object)LOGCLASS);
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logger.log(1000000, "[%1.clearNotification]", (Object)LOGCLASS);
    }

    public void connectDevice(int n, int n2) {
        this.logger.log(1000000, "[%1.connectDevice]", (Object)LOGCLASS);
    }

    public void disconnectDevice(int n) {
        this.logger.log(1000000, "[%1.disconnectDevice]", (Object)LOGCLASS);
    }

    public void requestFactorySettings() {
        this.logger.log(1000000, "[%1.requestFactorySettings]", (Object)LOGCLASS);
    }

    public void requestFactorySettings(int n) {
        this.logger.log(1000000, "[%1.requestFactorySettings]", (Object)LOGCLASS);
    }

    public void requestAppConnectContextActive(boolean bl) {
        this.logger.log(1000000, "[%1.requestAppConnectContextActive]", (Object)LOGCLASS);
    }
}

