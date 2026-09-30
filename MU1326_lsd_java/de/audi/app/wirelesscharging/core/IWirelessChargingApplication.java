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
    public static final String LOGCHANNEL_MAIN = "App.WirelessCharging.Main";
    public static final String LOGCHANNEL_AUDIO = "App.WirelessCharging.Audio";
    public static final String LOGCHANNEL_AUDIO_CL = "App.WirelessCharging.Audio.CL";
    public static final int WirelessCharging_MODULE_ID = 47;
    public static final String MODULE_NAME = "AppWirelessCharging";

    public void init();

    public void deinit();

    public IFrameworkAccess getFrameworkAccess();

    public void logStartupEvent(String var1);

    public BundleContext getBundleContext();

    public void addDiagnosisComponent(IWirelessChargingDiagComponent var1);

    public boolean isWLCInfoPopupEnabled();

    public IMessageDispatcher getMessageDispatcher();

    public void resetFactorySettings();
}

