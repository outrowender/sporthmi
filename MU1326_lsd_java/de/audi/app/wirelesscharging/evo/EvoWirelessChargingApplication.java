/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.evo;

import de.audi.app.wirelesscharging.core.AbstractWirelessChargingApplication;
import de.audi.app.wirelesscharging.core.DSIWirelessChargingResponseHandler;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.app.wirelesscharging.evo.screen.EvoWirelessChargingPresentationHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public class EvoWirelessChargingApplication
extends AbstractWirelessChargingApplication {
    private static final int WIRELESS_CHARGING_MUDUL_ID;
    private final DSIWirelessChargingResponseHandler wirelessChargingHandler;
    private final ReminderPopupHandler reminderPopupHandler;

    public EvoWirelessChargingApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        super(iFrameworkAccess, "App.WirelessCharging.Main", bundleContext);
        LogChannel logChannel = iFrameworkAccess.getLogChannel("App.WirelessCharging.Main");
        EvoWirelessChargingPresentationHandler evoWirelessChargingPresentationHandler = new EvoWirelessChargingPresentationHandler(iFrameworkAccess.getHmiServiceApp(), logChannel);
        this.reminderPopupHandler = new ReminderPopupHandler(this, evoWirelessChargingPresentationHandler, logChannel, iFrameworkAccess.getPowerMgr());
        this.wirelessChargingHandler = new DSIWirelessChargingResponseHandler(this, evoWirelessChargingPresentationHandler, logChannel);
    }

    @Override
    protected void addComponents() {
        this.addWirelessChargingComponent(this.wirelessChargingHandler);
        this.addWirelessChargingComponent(this.reminderPopupHandler);
    }

    @Override
    public void popupVisible(int n, int n2) {
    }

    @Override
    public void popupHidden(int n, int n2) {
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.wirelessChargingHandler.popupRemoved(n, n2);
    }

    @Override
    public void screenVisible(int n, int n2) {
    }

    @Override
    public void screenHidden(int n, int n2) {
    }

    @Override
    public void screenFadedOut(int n, int n2) {
    }

    @Override
    public void screenConnected(int n, int n2) {
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    @Override
    public int getId() {
        return 34;
    }
}

