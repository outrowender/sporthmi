/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.search;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
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

public abstract class AbstractInquiryPorsche
extends AbstractBluetoothComponent
implements IInquiry,
ButtonListener,
BaseListModelListener {
    private final int[] attributeNotifications = new int[]{4};
    protected final ButtonModelApp startButton = this.getButtonModel(2500115);
    private final ButtonModelApp stopButton = this.getButtonModel(0x262612);
    protected final BaseListModelApp listModel = this.getBaseListModel(2500222);
    protected final ChoiceModelApp inquiryState = this.getChoiceModel(2500117);
    private final LabelModelApp nameLabel = this.getLabelModel(2500100);

    public AbstractInquiryPorsche(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected final int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public final void startInquiry(int n) {
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

    protected abstract AbstractFoundDeviceList getList();

    public void abortInquiry() {
        CommandList commandList = this.bluetoothApplication.getCommandListManager().getActiveCommandList();
        if (commandList != null) {
            Command command = commandList.getActiveCommand();
            if (command instanceof CommandInquiry) {
                if (this.inquiryState.getValue() == 2) {
                    this.log.log(100000, "AbstractInquiry#abortInquiry(): inquiryState is already in STATE_ABORTING!");
                } else {
                    this.inquiryState.setValue(2);
                    ((CommandInquiry)command).abortInquiry();
                }
            } else {
                this.log.log(100000, "AbstractInquiry#abortInquiry(): no active inquiry command found!");
            }
        }
    }

    public final void getServices(String string, IDiscoveredServiceHandler iDiscoveredServiceHandler) {
        this.bluetoothApplication.getSecurity().serviceDiscoveryActive(true);
        this.bluetoothApplication.getMediaBluetoothStateProvider().serviceDiscoveryStarted();
        CommandGetServices.schedule(this.bluetoothApplication, this.dsiBluetooth, string, iDiscoveredServiceHandler);
    }

    public final void resetSearchState() {
        this.log.log(10000000, "AbstractInquiry#resetSearchState(): Called.");
        this.listModel.setStatus(0);
    }

    public void inquiryEnded(int n) {
        this.notifyInquiryEnded(n);
    }

    protected void notifyInquiryEnded(int n) {
        this.bluetoothApplication.getSecurity().inquiryActive(false);
        this.bluetoothApplication.getMediaBluetoothStateProvider().inquiryStopped();
        this.inquiryState.setValue(0);
    }

    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        if (n == 1 && discoveredDevice != null) {
            this.getList().add(discoveredDevice);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.startButton.getID()) {
            this.log.log(1000000, "AbstractInquiry#keyTyped(): Starting inquiry");
            this.startInquiry(n3);
        } else if (n == this.stopButton.getID()) {
            this.log.log(1000000, "AbstractInquiry#keyTyped(): Aborting inquiry");
            this.abortInquiry();
            this.stopButton.fireEvent(n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == this.listModel.getID()) {
            DiscoveredDevice discoveredDevice = this.getList().getDevice(evoListRow);
            if (discoveredDevice == null) {
                this.log.log(10000, "AbstractInquiry#itemSelected(): Device not found in device list!");
                return;
            }
            String string = discoveredDevice.getDeviceAddress();
            this.log.log(1000000, "AbstractInquiry#itemSelected(): %1, %2", (Object)discoveredDevice.getDeviceName(), (Object)string);
            this.bluetoothApplication.getBondingState().updateDeviceName(discoveredDevice.getDeviceName());
            this.bluetoothApplication.getBondingState().updateDeviceAddress(string);
            this.nameLabel.setText(discoveredDevice.getDeviceName());
            this.itemSelected(string);
            this.listModel.fireEvent(n4);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    protected abstract void itemSelected(String var1);

    public void init() {
        super.init();
        this.getList().init();
        this.startButton.setButtonListener(this);
        this.stopButton.setButtonListener(this);
        this.listModel.setListener(this);
        this.resetSearchState();
    }

    public void deinit() {
        this.startButton.resetListener();
        this.stopButton.resetListener();
        this.listModel.resetListener();
        this.getList().deinit();
        super.deinit();
    }
}

