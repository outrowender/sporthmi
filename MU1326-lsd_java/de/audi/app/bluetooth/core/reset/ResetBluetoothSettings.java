/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.reset;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.reset.CommandRestoreFactorySettings;
import de.audi.atip.msg.MsgListener;
import org.osgi.framework.ServiceRegistration;

public class ResetBluetoothSettings
extends AbstractBluetoothComponent
implements MsgListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private ServiceRegistration registration;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public ResetBluetoothSettings(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void processMsg(int n) {
        if (n == 20) {
            this.log.log(1078071040, "[ResetBluetoothSettings#processMsg] Called, restore factory settings.");
            this.restoreFactorySettings();
        }
    }

    private void restoreFactorySettings() {
        try {
            CommandRestoreFactorySettings.schedule(this.bluetoothApplication, this.dsiBluetooth);
        }
        catch (Exception exception) {
            this.log.log(10000, "Exception: %1", (Throwable)exception);
        }
    }

    @Override
    public void init() {
        super.init();
        this.registration = this.bluetoothApplication.getBundleContext().registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = ResetBluetoothSettings.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.registration.unregister();
        this.registration = null;
        super.deinit();
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

