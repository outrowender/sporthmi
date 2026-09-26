/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.reconnect;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.reconnect.CommandRequestReconnectSuspend;
import de.audi.app.bluetooth.core.connectivity.reconnect.IReconnect;
import org.dsi.ifc.bluetooth.ReconnectInfo;

public class AbstractReconnectInfo
extends AbstractBluetoothComponent
implements IReconnect {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{10};
    private boolean isPhoneReconnecting = false;

    public AbstractReconnectInfo(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    private void setReconnectName(String string) {
        this.getLabelModel(472262144).setText(string);
    }

    @Override
    public void setAutomaticReconnect(boolean bl) {
        this.log.log(-2137614336, "AbstractReconnectInfo#setAutomaticReconnect %1", bl);
        CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, !bl);
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        if (n != 1 || reconnectInfo == null) {
            return;
        }
        this.log.log(1078071040, "AbstractReconnectInfo#updateReconnectIndicator(): %1", (Object)reconnectInfo);
        this.setReconnecting(reconnectInfo);
        if (this.isPhoneReconnecting) {
            for (int i2 = 0; i2 < reconnectInfo.serviceTypeList.length; ++i2) {
                if (reconnectInfo.serviceTypeList[i2] != 4 && reconnectInfo.serviceTypeList[i2] != 2) continue;
                this.setReconnectName(reconnectInfo.deviceNameList[i2]);
                break;
            }
        }
    }

    private void setReconnecting(ReconnectInfo reconnectInfo) {
        this.isPhoneReconnecting = (reconnectInfo.reconnectIndicator & 6) > 0;
    }
}

