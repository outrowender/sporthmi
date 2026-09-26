/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;

public interface ISmartphoneIntegrationDSIController {
    default public void connectDevice(int n, SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType) {
    }

    default public void disconnectDevice(int n) {
    }

    default public void requestFactorySettings() {
    }
}

