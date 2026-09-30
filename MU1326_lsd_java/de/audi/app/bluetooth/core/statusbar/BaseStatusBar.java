/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.statusbar;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.power.PowerEventListener;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceRegistration;

public class BaseStatusBar
extends AbstractBluetoothComponent
implements PowerEventListener {
    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int VISIBLE = 2;
    private static final int CONNECTED = 3;
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{1, 3, 6};
    private ServiceRegistration serviceRegistration;
    private final ChoiceModelApp icon = this.getChoiceModel(3940);
    private boolean on;
    private boolean visible;
    private boolean connected;
    private boolean isClampSOn;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public BaseStatusBar(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    public void init() {
        super.init();
        this.serviceRegistration = this.bundleContext.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = BaseStatusBar.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this, null);
    }

    public void deinit() {
        super.deinit();
        this.serviceRegistration.unregister();
        this.serviceRegistration = null;
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void updateAccessibleMode(int n, boolean bl, int n2) {
        if ((n2 & 1) == 0) {
            return;
        }
        this.visible = bl;
        this.updateModel();
    }

    public void updateBTState(int n, int n2) {
        if ((n2 & 1) == 0) {
            return;
        }
        this.on = n == 0;
        this.updateModel();
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if ((n & 1) == 0 || trustedDeviceArray == null) {
            return;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
            if (trustedDeviceArray[i2].getActiveServiceTypes() <= 0) continue;
            bl = true;
            break;
        }
        this.connected = bl;
        this.updateModel();
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.isClampSOn = bl;
        this.updateModel();
    }

    private void updateModel() {
        int n = this.isClampSOn && this.on ? (this.connected ? 3 : (this.visible ? 2 : 1)) : 0;
        this.log.log(1000000, "BaseStatusBar#updateModel(): %1", (long)n);
        this.icon.setValue(n);
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

