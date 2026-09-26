/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.reset;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.reset.CommandFactoryReset;
import de.audi.atip.msg.MsgListener;
import org.osgi.framework.ServiceRegistration;

public class ResetWlanSettings
extends AbstractWlanComponent
implements MsgListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private ServiceRegistration registration;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public ResetWlanSettings(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void processMsg(int n) {
        if (n == 20) {
            this.log.log(1078071040, "[ResetWlanSettings#processMsg] Called, restore factory settings.");
            this.restoreFactorySettings();
        }
    }

    private void restoreFactorySettings() {
        try {
            CommandFactoryReset.schedule(this.wlanApplication, this.dsiWlan);
        }
        catch (Exception exception) {
            this.log.log(10000, "Exception: %1", (Throwable)exception);
        }
    }

    @Override
    public void init() {
        super.init();
        this.registration = this.wlanApplication.getBundleContext().registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ResetWlanSettings.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.registration.unregister();
        this.registration = null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

