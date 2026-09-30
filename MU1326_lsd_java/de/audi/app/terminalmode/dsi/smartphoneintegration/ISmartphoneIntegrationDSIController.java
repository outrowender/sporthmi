/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.SmartphoneManager;

public interface ISmartphoneIntegrationDSIController {
    public void connectDevice(int var1, SmartphoneManager.SmartphoneType var2);

    public void disconnectDevice(int var1);

    public void requestFactorySettings();
}

