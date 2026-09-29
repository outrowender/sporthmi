/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.a2dp;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.a2dp.CommandSetA2DPUserSetting;
import de.audi.app.bluetooth.core.a2dp.IAudio;
import de.audi.app.bluetooth.core.connectivity.reconnect.CommandRequestReconnectSuspend;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class AbstractAudio
extends AbstractBluetoothComponent
implements IAudio,
ChoiceListener {
    private static final int OFF;
    private static final int ON;
    private final int[] attributeNotifications = new int[]{16};
    private final ChoiceModelApp a2dpModel = this.getChoiceModel(0x2262600);
    private volatile boolean active;

    public AbstractAudio(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected final int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    @Override
    public void requestSetA2DPUserSetting(boolean bl) {
        this.requestSetA2DPUserSetting(bl, true);
    }

    @Override
    public void requestSetA2DPUserSetting(boolean bl, boolean bl2) {
        if (this.active != bl) {
            boolean bl3;
            this.log.log(1078071040, "AbstractAudio#requestSetA2DPUserSetting(): Requesting to set a2dp to %1, autoReconnect is %2", bl, bl2);
            this.setModel(bl);
            boolean bl4 = bl3 = !bl2;
            if (bl3) {
                CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, true);
            }
            CommandSetA2DPUserSetting.schedule(this.bluetoothApplication, this.dsiBluetooth, bl);
        } else {
            this.log.log(1078071040, "AbstractAudio#requestSetA2DPUserSetting(): Setting is already %1, doing nothing", bl);
        }
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
        this.log.log(1078071040, "AbstractAudio#updateA2DPUserSetting(): active=%1", bl);
        if (n == 1) {
            this.active = bl;
            this.setModel(bl);
        }
    }

    private void setModel(boolean bl) {
        this.a2dpModel.setValue(bl ? 1 : 0);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "AbstractAudio#itemSelected(): modelID=%1, itemID=%2", (long)n, (long)n2);
        this.requestSetA2DPUserSetting(n2 == 1);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void init() {
        super.init();
        this.a2dpModel.setChoiceListener(this);
    }

    @Override
    public void deinit() {
        this.a2dpModel.resetListener();
        super.deinit();
    }
}

