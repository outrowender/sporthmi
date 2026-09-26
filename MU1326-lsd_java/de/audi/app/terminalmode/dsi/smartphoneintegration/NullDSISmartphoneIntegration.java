/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;

public class NullDSISmartphoneIntegration
implements DSISmartphoneIntegration {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullDSISmartphoneIntegration(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.setNotification]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.setNotification]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.setNotification]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.clearNotification]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.clearNotification]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logger.log(1078071040, "[%1.clearNotification]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void connectDevice(int n, int n2) {
        this.logger.log(1078071040, "[%1.connectDevice]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void disconnectDevice(int n) {
        this.logger.log(1078071040, "[%1.disconnectDevice]", (Object)"NullDSISmartphoneIntegration");
    }

    public void requestFactorySettings() {
        this.logger.log(1078071040, "[%1.requestFactorySettings]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void requestFactorySettings(int n) {
        this.logger.log(1078071040, "[%1.requestFactorySettings]", (Object)"NullDSISmartphoneIntegration");
    }

    @Override
    public void requestAppConnectContextActive(boolean bl) {
        this.logger.log(1078071040, "[%1.requestAppConnectContextActive]", (Object)"NullDSISmartphoneIntegration");
    }
}

