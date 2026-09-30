/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.app.connectivity.manager.TerminalModeProxy;
import de.audi.app.connectivity.manager.contents.CoMaRow;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.log.LogChannel;

class CoMaDrawer
implements IApplicationComponent,
OptionModelListener {
    private final LogChannel log;
    private final IEvoConnectivity connectivity;
    private final TerminalModeProxy smartphoneProxy;
    private final BaseListModelApp comaList;
    private final OptionModelApp blueDelete;
    private final OptionModelApp blueShowProfiles;
    private final OptionModelApp blueSetPrioReconnect;
    private final OptionModelApp wlanDelete;
    private final OptionModelApp smartphoneDelete;

    CoMaDrawer(LogChannel logChannel, IEvoConnectivity iEvoConnectivity, IHMIServiceApp iHMIServiceApp, TerminalModeProxy terminalModeProxy) {
        this.log = logChannel;
        this.connectivity = iEvoConnectivity;
        this.smartphoneProxy = terminalModeProxy;
        this.comaList = iHMIServiceApp.getBaseListModel(2500435);
        this.blueDelete = iHMIServiceApp.getOptionModel(2500110);
        this.blueShowProfiles = iHMIServiceApp.getOptionModel(2500179);
        this.blueSetPrioReconnect = iHMIServiceApp.getOptionModel(2500323);
        this.wlanDelete = iHMIServiceApp.getOptionModel(2500091);
        this.smartphoneDelete = iHMIServiceApp.getOptionModel(2500340);
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        CoMaRow coMaRow = (CoMaRow)this.comaList.getRow(n3);
        if (n == this.blueDelete.getID()) {
            this.log.log(1000000, "CoMaDrawer#keyTyped(): Removing %1 %2 from trusted device list", (Object)coMaRow.getName(), (Object)coMaRow.getDeviceIdentifier());
            this.connectivity.getBluetooth().getTrustedDeviceList().removeAuthentication(coMaRow.getDeviceIdentifier());
            this.blueDelete.fireEvent(n5);
        } else if (n == this.blueShowProfiles.getID()) {
            this.log.log(1000000, "CoMaDrawer#keyTyped(): Showing profiles of %1 %2 for category %3", (Object)coMaRow.getName(), (Object)coMaRow.getDeviceIdentifier(), (long)coMaRow.getCategory());
            this.connectivity.getBluetooth().getDeviceProfileList().setPhoneRole(coMaRow.getCategory() != 5);
            this.connectivity.getBluetooth().getDeviceProfileList().showProfiles(coMaRow.getDeviceIdentifier());
            this.blueShowProfiles.fireEvent(n5);
        } else if (n == this.blueSetPrioReconnect.getID()) {
            this.log.log(1000000, "CoMaDrawer#keyTyped(): Set/delete prio reconnect: %1 %2", (Object)coMaRow.getName(), (Object)coMaRow.getDeviceIdentifier());
            this.connectivity.getBluetooth().getPrioReconnect().setPrioReconnect(coMaRow.getDeviceIdentifier());
            this.blueSetPrioReconnect.fireEvent(n5);
        } else if (n == this.wlanDelete.getID()) {
            this.log.log(1000000, "CoMaDrawer#keyTyped(): Removing %1 %2 from trusted network list", (Object)coMaRow.getName(), (Object)coMaRow.getDeviceIdentifier());
            String string = coMaRow.getDeviceIdentifier();
            this.connectivity.getWlan().getTrustedNetworkList().deleteTrustedNetwork(string);
            this.wlanDelete.fireEvent(n5);
        } else if (n == this.smartphoneDelete.getID()) {
            this.log.log(1000000, "CoMaDrawer#keyTyped(): Removing %1 %2 from list of smartphones", (Object)coMaRow.getName(), (Object)coMaRow.getDeviceIdentifier());
            String string = coMaRow.getDeviceIdentifier();
            this.smartphoneProxy.deleteSmartphone(string);
            this.smartphoneDelete.fireEvent(n5);
        }
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    public void init() {
        this.blueDelete.setListener(this, 2500435);
        this.blueShowProfiles.setListener(this, 2500435);
        this.blueSetPrioReconnect.setListener(this, 2500435);
        this.wlanDelete.setListener(this, 2500435);
        this.smartphoneDelete.setListener(this, 2500435);
    }

    public void deinit() {
        this.blueDelete.resetListener();
        this.blueShowProfiles.resetListener();
        this.blueSetPrioReconnect.resetListener();
        this.wlanDelete.resetListener();
        this.smartphoneDelete.resetListener();
    }
}

