/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.search;

import de.audi.app.bluetooth.core.connectivity.search.AbstractFoundDeviceList;
import de.audi.app.bluetooth.core.connectivity.search.AbstractInquiry;
import de.audi.app.bluetooth.core.connectivity.search.IDiscoveredServiceHandler;
import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.bluetooth.evo.connectivity.search.FoundDeviceList;
import de.audi.app.bluetooth.evo.connectivity.search.IEvoInquiry;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class Inquiry
extends AbstractInquiry
implements IEvoInquiry,
IDiscoveredServiceHandler {
    private final IEvoBluetoothApplication bluetoothApplication;
    private final FoundDeviceList foundDevices;
    private final ButtonModelApp startPhoneInquiryButton;
    private final ButtonModelApp startMediaInquiryButton;
    private final ButtonModelApp startPbapInquiryButton;
    private final ButtonModelApp startAssociatedPhoneInquiryButton;
    private int servicesToBeConnected;
    private boolean connectAsPrimary;

    public Inquiry(IEvoBluetoothApplication iEvoBluetoothApplication) {
        super(iEvoBluetoothApplication);
        this.bluetoothApplication = iEvoBluetoothApplication;
        this.foundDevices = new FoundDeviceList(iEvoBluetoothApplication.getLogChannel(), this.listModel, iEvoBluetoothApplication.getTrustedDeviceList());
        this.startPhoneInquiryButton = this.getButtonModel(338044416);
        this.startMediaInquiryButton = this.getButtonModel(2066097664);
        this.startPbapInquiryButton = this.getButtonModel(-1725553152);
        this.startAssociatedPhoneInquiryButton = this.getButtonModel(-232380928);
    }

    @Override
    protected AbstractFoundDeviceList getList() {
        return this.foundDevices;
    }

    @Override
    protected void itemSelected(String string) {
        this.bluetoothApplication.getBondingState().updateBondingState(1);
        this.getServices(string, this);
    }

    @Override
    public void abortInquiry(int n) {
        this.abortInquiry();
        this.resetSearchState();
    }

    @Override
    public void prepareServiceSpecificInquiry(int n, boolean bl) {
        this.log.log(1078071040, "Inquiry#prepareServiceSpecificInquiry(): %2 (primary=%1)", bl, (long)n);
        this.servicesToBeConnected = n;
        this.connectAsPrimary = bl;
        this.bluetoothApplication.getEvoTrustedDeviceList().showTrustedDevices(n, bl);
    }

    @Override
    public void updateDiscoveredServices(String string, String string2, int n, int n2) {
        int n3 = this.servicesToBeConnected & n;
        this.log.log(1078071040, "Inquiry#updateDiscoveredServices(): servicesToBeConnected=%1, supportedServices=%2, possibleServices=%3", (long)this.servicesToBeConnected, (long)n, (long)n3);
        if (n3 != 0) {
            int n4 = n3;
            this.log.log(-2137614336, "Inquiry#updateDiscoveredServices(): Connecting service: %1", (long)n4);
            this.bluetoothApplication.getConnection().connectService(string, n4, string2, this.connectAsPrimary);
        } else {
            this.log.log(-1601830656, "Inquiry#updateDiscoveredServices(): Could not find a service to connect to!");
            this.bluetoothApplication.getBondingState().updateBondingResult(4);
            this.bluetoothApplication.getBondingState().updateBondingState(0);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.startPhoneInquiryButton.getID()) {
            this.log.log(1078071040, "Inquiry#keyTyped(): Phone Bluetooth inquiry starting");
            this.prepareServiceSpecificInquiry(this.bluetoothApplication.getSupportedBtProfiles().getConnectableServices(0, true), true);
            this.startPhoneInquiryButton.fireEvent(n3);
        } else if (n == this.startMediaInquiryButton.getID()) {
            this.log.log(1078071040, "Inquiry#keyTyped(): Media Bluetooth inquiry starting");
            this.prepareServiceSpecificInquiry(this.bluetoothApplication.getSupportedBtProfiles().getConnectableServices(3, true), true);
            this.startMediaInquiryButton.fireEvent(n3);
        } else if (n == this.startPbapInquiryButton.getID()) {
            this.log.log(1078071040, "Inquiry#keyTyped(): PBAP Bluetooth inquiry starting");
            this.prepareServiceSpecificInquiry(32, true);
            this.startPbapInquiryButton.fireEvent(n3);
        } else if (n == this.startAssociatedPhoneInquiryButton.getID()) {
            this.log.log(1078071040, "Inquiry#keyTyped(): Associated phone Bluetooth inquiry starting");
            this.prepareServiceSpecificInquiry(this.bluetoothApplication.getSupportedBtProfiles().getConnectableServices(0, false), false);
            this.startAssociatedPhoneInquiryButton.fireEvent(n3);
        } else {
            super.keyTyped(n, n2, n3);
        }
    }

    @Override
    public void init() {
        super.init();
        this.startPhoneInquiryButton.setButtonListener(this);
        this.startMediaInquiryButton.setButtonListener(this);
        this.startPbapInquiryButton.setButtonListener(this);
        this.startAssociatedPhoneInquiryButton.setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.startPhoneInquiryButton.resetListener();
        this.startMediaInquiryButton.resetListener();
        this.startPbapInquiryButton.resetListener();
        this.startAssociatedPhoneInquiryButton.resetListener();
        super.deinit();
    }
}

