/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.reconnect.CommandRequestReconnectSuspend;
import de.audi.app.bluetooth.core.connectivity.search.AbstractFoundDeviceList;
import de.audi.app.bluetooth.core.connectivity.search.CommandGetServices;
import de.audi.app.bluetooth.core.connectivity.search.CommandInquiry;
import de.audi.app.bluetooth.core.connectivity.search.IDiscoveredServiceHandler;
import de.audi.app.bluetooth.core.connectivity.search.IInquiry;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

public abstract class AbstractInquiry
extends AbstractBluetoothComponent
implements IInquiry,
ButtonListener,
BaseListModelListener {
    private final int[] attributeNotifications = new int[]{4};
    protected final ButtonModelApp startButton = this.getButtonModel(321267200);
    private final ButtonModelApp stopButton = this.getButtonModel(304489984);
    protected final BaseListModelApp listModel = this.getBaseListModel(2116429312);
    private final ChoiceModelApp inquiryState = this.getChoiceModel(354821632);
    private final LabelModelApp nameLabel = this.getLabelModel(69608960);

    public AbstractInquiry(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected final int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    @Override
    public final void startInquiry(int n) {
        CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, true);
        this.bluetoothApplication.getAccessibility().activateBluetooth();
        this.getList().clear();
        this.bluetoothApplication.getSecurity().inquiryActive(true);
        this.bluetoothApplication.getMediaBluetoothStateProvider().inquiryStarted();
        this.inquiryState.setValue(1);
        this.startButton.fireEvent(n);
        this.scheduleCommandInquiry();
        this.listModel.setStatus(1);
    }

    protected void scheduleCommandInquiry() {
        CommandInquiry.schedule(this.bluetoothApplication, this.dsiBluetooth);
    }

    protected abstract AbstractFoundDeviceList getList() {
    }

    @Override
    public final void abortInquiry() {
        CommandList commandList = this.bluetoothApplication.getCommandListManager().getActiveCommandList();
        if (commandList != null) {
            Command command = commandList.getActiveCommand();
            if (command instanceof CommandInquiry) {
                this.inquiryState.setValue(2);
                ((CommandInquiry)command).abortInquiry();
            } else {
                this.log.log(-1601830656, "AbstractInquiry#abortInquiry(): no active inquiry command found!");
            }
        }
    }

    @Override
    public final void getServices(String string, IDiscoveredServiceHandler iDiscoveredServiceHandler) {
        this.bluetoothApplication.getSecurity().serviceDiscoveryActive(true);
        this.bluetoothApplication.getMediaBluetoothStateProvider().serviceDiscoveryStarted();
        CommandGetServices.schedule(this.bluetoothApplication, this.dsiBluetooth, string, iDiscoveredServiceHandler);
    }

    @Override
    public final void resetSearchState() {
        this.log.log(-2137614336, "AbstractInquiry#resetSearchState(): Called.");
        this.listModel.setStatus(0);
    }

    @Override
    public void inquiryEnded(int n) {
        this.bluetoothApplication.getSecurity().inquiryActive(false);
        this.bluetoothApplication.getMediaBluetoothStateProvider().inquiryStopped();
        this.inquiryState.setValue(0);
        CommandRequestReconnectSuspend.schedule(this.bluetoothApplication, this.dsiBluetooth, false);
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        if (n == 1 && discoveredDevice != null) {
            this.getList().add(discoveredDevice);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.startButton.getID()) {
            this.log.log(1078071040, "AbstractInquiry#keyTyped(): Starting inquiry");
            this.startInquiry(n3);
        } else if (n == this.stopButton.getID()) {
            this.log.log(1078071040, "AbstractInquiry#keyTyped(): Aborting inquiry");
            this.abortInquiry();
            this.stopButton.fireEvent(n3);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == this.listModel.getID()) {
            DiscoveredDevice discoveredDevice = this.getList().getDevice(evoListRow);
            if (discoveredDevice == null) {
                this.log.log(10000, "AbstractInquiry#itemSelected(): Device not found in device list!");
                return;
            }
            String string = discoveredDevice.getDeviceAddress();
            this.log.log(1078071040, "AbstractInquiry#itemSelected(): %1, %2", (Object)discoveredDevice.getDeviceName(), (Object)string);
            this.bluetoothApplication.getBondingState().updateDeviceName(discoveredDevice.getDeviceName());
            this.bluetoothApplication.getBondingState().updateDeviceAddress(string);
            this.nameLabel.setText(discoveredDevice.getDeviceName());
            this.itemSelected(string);
            this.listModel.fireEvent(n4);
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    protected abstract void itemSelected(String string) {
    }

    @Override
    public void init() {
        super.init();
        this.getList().init();
        this.startButton.setButtonListener(this);
        this.stopButton.setButtonListener(this);
        this.listModel.setListener(this);
        this.resetSearchState();
    }

    @Override
    public void deinit() {
        this.startButton.resetListener();
        this.stopButton.resetListener();
        this.listModel.resetListener();
        this.getList().deinit();
        super.deinit();
    }
}

