/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.combi.bap.app.phone.AbstractAppConnectorPhone;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone2.CombiModulePhone2;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPBluetoothConnections;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceConnectivity;
import de.vw.mib.bap.generated.telephone.serializer.DataConnectionIndication_Status;
import de.vw.mib.bap.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone2.serializer.ConnectionState_Status;
import de.vw.mib.bap.generated.telephone2.serializer.DataConnectionIndication2_Status;

public class AppConnectorConnectivity
extends AbstractAppConnectorPhone
implements CombiBAPServiceConnectivity {
    private boolean connectionStateWLANSupported = false;
    private boolean connectionStateBluetoothSupported = false;

    public AppConnectorConnectivity(CombiModulePhone combiModulePhone) {
        super(combiModulePhone);
    }

    public void updateMobileServiceSupportConnectionIndication(boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateMobileServiceSupportConnectionIndication] dataConnectionIndicationSupported=%1, dataConnectionIndication2Supported=%2", bl, bl2);
        MobileServiceSupport_Status mobileServiceSupport_Status = this.getMobileServiceSupportStatusCopy();
        mobileServiceSupport_Status.fctList.fctDataConnectionIndicationSupported = bl && this.moduleFsg.getFunctionList().isFunctionSupported(44);
        this.sendPropertyStatus(16, mobileServiceSupport_Status);
        CombiModulePhone2 combiModulePhone2 = ((CombiModulePhone)this.moduleFsg).getPhone2Module();
        if (combiModulePhone2 != null) {
            de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status mobileServiceSupport_Status2 = this.getMobileServiceSupport2StatusCopy();
            mobileServiceSupport_Status2.fctList.fctDataConnectionIndication2Supported = bl2 && combiModulePhone2.getFunctionList().isFunctionSupported(21);
            this.sendPhone2PropertyStatus(16, mobileServiceSupport_Status2);
        }
    }

    public void updateMobileServiceSupportWLAN(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateMobileServiceSupportWLAN] connectionStateSupported=%1", bl);
        this.connectionStateWLANSupported = bl;
        this.updateMobileServiceSupportConnectionState();
    }

    public void updateMobileServiceSupportBluetooth(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateMobileServiceSupportBluetooth] connectionStateSupported=%1", bl);
        this.connectionStateBluetoothSupported = bl;
        this.updateMobileServiceSupportConnectionState();
    }

    private void updateMobileServiceSupportConnectionState() {
        de.vw.mib.bap.generated.telephone2.serializer.MobileServiceSupport_Status mobileServiceSupport_Status = this.getMobileServiceSupport2StatusCopy();
        mobileServiceSupport_Status.fctList.fctConnectionStateSupported = this.connectionStateBluetoothSupported || this.connectionStateWLANSupported;
        this.sendPhone2PropertyStatus(16, mobileServiceSupport_Status);
    }

    public void updateDataConnectionActive(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateDataConnectionActive] connectionActive=%1", bl);
        DataConnectionIndication_Status dataConnectionIndication_Status = (DataConnectionIndication_Status)this.moduleFsg.getBAPFunctionPropertyFSG(44).getLastStatus();
        DataConnectionIndication_Status dataConnectionIndication_Status2 = new DataConnectionIndication_Status();
        dataConnectionIndication_Status2.connectionIndication = bl ? 1 : 0;
        dataConnectionIndication_Status2.dataVolumeUplink = dataConnectionIndication_Status.dataVolumeUplink;
        dataConnectionIndication_Status2.dataVolumeDownlink = dataConnectionIndication_Status.dataVolumeDownlink;
        this.sendPropertyStatus(44, dataConnectionIndication_Status2);
    }

    public void updateDataConnectionPacketCount(long l, long l2) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateDataConnectionPacketCount] dataVolumeUplink=%1, dataVolumeDownlink=%2", l, l2);
        DataConnectionIndication_Status dataConnectionIndication_Status = (DataConnectionIndication_Status)this.moduleFsg.getBAPFunctionPropertyFSG(44).getLastStatus();
        DataConnectionIndication_Status dataConnectionIndication_Status2 = new DataConnectionIndication_Status();
        dataConnectionIndication_Status2.connectionIndication = dataConnectionIndication_Status.connectionIndication;
        dataConnectionIndication_Status2.dataVolumeUplink = (int)l;
        dataConnectionIndication_Status2.dataVolumeDownlink = (int)l2;
        this.sendPropertyStatus(44, dataConnectionIndication_Status2);
    }

    public void updateDataConnection2Active(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateDataConnection2Active] connectionActive=%1", bl);
        DataConnectionIndication2_Status dataConnectionIndication2_Status = (DataConnectionIndication2_Status)this.getPhone2Property(21).getLastStatus();
        DataConnectionIndication2_Status dataConnectionIndication2_Status2 = new DataConnectionIndication2_Status();
        dataConnectionIndication2_Status2.connectionIndication = bl ? 1 : 0;
        dataConnectionIndication2_Status2.dataVolumeUplink = dataConnectionIndication2_Status.dataVolumeUplink;
        dataConnectionIndication2_Status2.dataVolumeDownlink = dataConnectionIndication2_Status.dataVolumeDownlink;
        this.sendPhone2PropertyStatus(21, dataConnectionIndication2_Status2);
    }

    public void updateDataConnection2PacketCount(long l, long l2) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateDataConnection2PacketCount] dataVolumeUplink=%1, dataVolumeDownlink=%2", l, l2);
        DataConnectionIndication2_Status dataConnectionIndication2_Status = (DataConnectionIndication2_Status)this.getPhone2Property(21).getLastStatus();
        DataConnectionIndication2_Status dataConnectionIndication2_Status2 = new DataConnectionIndication2_Status();
        dataConnectionIndication2_Status2.connectionIndication = dataConnectionIndication2_Status.connectionIndication;
        dataConnectionIndication2_Status2.dataVolumeUplink = (int)l;
        dataConnectionIndication2_Status2.dataVolumeDownlink = (int)l2;
        this.sendPhone2PropertyStatus(21, dataConnectionIndication2_Status2);
    }

    public void updateConnectionState(int n, int n2, CombiBAPBluetoothConnections combiBAPBluetoothConnections, int n3, int n4, int n5) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateConnectionState] bluetoothState=%2, bluetoothVisibility=%3, bluetoothConnections=%1, ...", (Object)combiBAPBluetoothConnections, (long)n, (long)n2);
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateConnectionState] ..., wLANState=%1, wLANVisibility=%2, wLANConnections=%3", (long)n3, (long)n4, (long)n5);
        ConnectionState_Status connectionState_Status = new ConnectionState_Status();
        connectionState_Status.bluetoothState = n;
        connectionState_Status.bluetoothVisibility = n2;
        connectionState_Status.bluetoothConnections.audioplayerActive = combiBAPBluetoothConnections.isAudioplayerActive();
        connectionState_Status.bluetoothConnections.handsFreeProfileActive = combiBAPBluetoothConnections.isHandsFreeProfileActive();
        connectionState_Status.bluetoothConnections.phonebookAccessProfileActive = combiBAPBluetoothConnections.isPhonebookAccessProfileActive();
        connectionState_Status.bluetoothConnections.simAccessProfileActive = combiBAPBluetoothConnections.isSimAccessProfileActive();
        connectionState_Status.wlanstate = n3;
        connectionState_Status.wlanvisibility = n4;
        connectionState_Status.wlanconnections = n5;
        this.sendPhone2PropertyStatus(24, connectionState_Status);
    }

    public void updateBluetoothConnectionState(int n, int n2, CombiBAPBluetoothConnections combiBAPBluetoothConnections) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateBluetoothConnectionState] bluetoothState=%2, bluetoothVisibility=%3, bluetoothConnections=%1", (Object)combiBAPBluetoothConnections, (long)n, (long)n2);
        ConnectionState_Status connectionState_Status = (ConnectionState_Status)this.getPhone2Property(24).getLastStatus();
        ConnectionState_Status connectionState_Status2 = new ConnectionState_Status();
        connectionState_Status2.bluetoothState = n;
        connectionState_Status2.bluetoothVisibility = n2;
        connectionState_Status2.bluetoothConnections.audioplayerActive = combiBAPBluetoothConnections.isAudioplayerActive();
        connectionState_Status2.bluetoothConnections.handsFreeProfileActive = combiBAPBluetoothConnections.isHandsFreeProfileActive();
        connectionState_Status2.bluetoothConnections.phonebookAccessProfileActive = combiBAPBluetoothConnections.isPhonebookAccessProfileActive();
        connectionState_Status2.bluetoothConnections.simAccessProfileActive = combiBAPBluetoothConnections.isSimAccessProfileActive();
        connectionState_Status2.wlanstate = connectionState_Status.wlanstate;
        connectionState_Status2.wlanvisibility = connectionState_Status.wlanvisibility;
        connectionState_Status2.wlanconnections = connectionState_Status.wlanconnections;
        this.sendPhone2PropertyStatus(24, connectionState_Status2);
    }

    public void updateWLANConnectionState(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[AppConnectorConnectivity#updateWLANConnectionState] wLANState=%1, wLANVisibility=%2, wLANConnections=%3", (long)n, (long)n2, (long)n3);
        ConnectionState_Status connectionState_Status = (ConnectionState_Status)this.getPhone2Property(24).getLastStatus();
        ConnectionState_Status connectionState_Status2 = new ConnectionState_Status();
        connectionState_Status2.bluetoothState = connectionState_Status.bluetoothState;
        connectionState_Status2.bluetoothVisibility = connectionState_Status.bluetoothVisibility;
        connectionState_Status2.bluetoothConnections.audioplayerActive = connectionState_Status.bluetoothConnections.audioplayerActive;
        connectionState_Status2.bluetoothConnections.handsFreeProfileActive = connectionState_Status.bluetoothConnections.handsFreeProfileActive;
        connectionState_Status2.bluetoothConnections.phonebookAccessProfileActive = connectionState_Status.bluetoothConnections.phonebookAccessProfileActive;
        connectionState_Status2.bluetoothConnections.simAccessProfileActive = connectionState_Status.bluetoothConnections.simAccessProfileActive;
        connectionState_Status2.wlanstate = n;
        connectionState_Status2.wlanvisibility = n2;
        connectionState_Status2.wlanconnections = n3;
        this.sendPhone2PropertyStatus(24, connectionState_Status2);
    }
}

