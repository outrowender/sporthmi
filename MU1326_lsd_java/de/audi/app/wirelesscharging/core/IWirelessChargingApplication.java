/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.IMessageDispatcher;
import de.audi.atip.base.IFrameworkAccess;
import de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent;
import org.osgi.framework.BundleContext;

public interface IWirelessChargingApplication {
    public static final String LOGCHANNEL_MAIN;
    public static final String LOGCHANNEL_AUDIO;
    public static final String LOGCHANNEL_AUDIO_CL;
    public static final int WirelessCharging_MODULE_ID;
    public static final String MODULE_NAME;

    default public void init() {
    }

    default public void deinit() {
    }

    default public IFrameworkAccess getFrameworkAccess() {
    }

    default public void logStartupEvent(String string) {
    }

    default public BundleContext getBundleContext() {
    }

    default public void addDiagnosisComponent(IWirelessChargingDiagComponent iWirelessChargingDiagComponent) {
    }

    default public boolean isWLCInfoPopupEnabled() {
    }

    default public IMessageDispatcher getMessageDispatcher() {
    }

    default public void resetFactorySettings() {
    }
}

