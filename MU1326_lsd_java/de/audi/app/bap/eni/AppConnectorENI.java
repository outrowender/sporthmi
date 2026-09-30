/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.app.AbstractAppConnectorASG;
import de.audi.app.bap.eni.BAPModuleENI;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.app.bap.fw.arrays.ArrayHeaderConfigurator;
import de.audi.app.bap.fw.arrays.ArrayUtilsASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.atip.interapp.bap.eni.BAPServiceENI;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.vw.mib.bap.generated.eni.serializer.DestinationList_ASGcapacity_SetGet;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_Data;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_SetGetArray;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_SetGet;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_Data;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_GetArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_SetGetArray;
import de.vw.mib.bap.generated.eni.serializer.TriggerRemoteProcess_StartResult;
import de.vw.mib.bap.generated.eni.serializer.UserList_GetArray;

public final class AppConnectorENI
extends AbstractAppConnectorASG
implements BAPServiceENI {
    static final int DESTINATION_LIST_MAX_ELEMENTS_TO_REQUEST = 1;
    static final int USER_LIST_MAX_ELEMENTS_TO_REQUEST = 3;
    static final int SERVICE_LIST_MAX_ELEMENTS_TO_REQUEST = 1;
    static final boolean DESTINATION_LIST_INDEX_BIT_SIZE = true;
    static final boolean USER_LIST_INDEX_BIT_SIZE = false;
    static final boolean SERVICE_LIST_INDEX_BIT_SIZE = false;
    static final int SERVICE_LIST_RECORD_ADDRESS_ALL = 1;
    static final int SERVICE_LIST_RECORD_ADDRESS_USER_SETTINGS = 2;
    static final int DESTINATION_LIST_RECORD_ADDRESS_NAME = 1;
    private static final int ALL_SERVICES = 0;
    private static final int SELECTED_SERVICES = 1;
    private static final int PRIVACY_MODE_DEACTIVATE_ALL_SERVICES = 0;
    private static final int PRIVACY_MODE_ACTIVATE_ALL_SERVICES = 1;
    private static final int DEFAULT_PARAM1 = 0;
    private final BAPModuleENI eniModule;

    public AppConnectorENI(BAPModuleENI bAPModuleENI, IFunctionRegistrationASG iFunctionRegistrationASG) {
        super(bAPModuleENI.getLogChannel(), iFunctionRegistrationASG);
        this.eniModule = bAPModuleENI;
        this.getArray(16).setNoResponseFromFSGHandler(new BAPFunctionArrayASG.NoResponseFromFSGHandler(){

            public void noResponseFromFSG() {
                AppConnectorENI.this.logChannel.log(100000, "[AppConnectorENI#noResponseFromFSG] Clearing destination list.");
                AppConnectorENI.this.eniModule.getBapArrayDataENI().getDestinationList().clear();
            }
        });
        this.getArray(21).setNoResponseFromFSGHandler(new BAPFunctionArrayASG.NoResponseFromFSGHandler(){

            public void noResponseFromFSG() {
                AppConnectorENI.this.logChannel.log(100000, "[AppConnectorENI#noResponseFromFSG] Clearing user list.");
                AppConnectorENI.this.eniModule.getBapArrayDataENI().getUserList().clear();
            }
        });
        this.getArray(22).setNoResponseFromFSGHandler(new BAPFunctionArrayASG.NoResponseFromFSGHandler(){

            public void noResponseFromFSG() {
                AppConnectorENI.this.logChannel.log(100000, "[AppConnectorENI#noResponseFromFSG] Clearing service list.");
                AppConnectorENI.this.eniModule.getBapArrayDataENI().getServiceList().clear();
            }
        });
    }

    public void getDestinationList() {
        this.logChannel.log(10000000, "[AppConnectorENI#getDestinationList]");
        this.eniModule.getBapArrayDataENI().getDestinationList().clear();
        ArrayUtilsASG.requestArrayElements(this.getArray(16), 1, 0, true, new DestinationsList_GetArray());
    }

    public void setDestinationListCapacity(int n) {
        this.logChannel.log(10000000, "[AppConnectorENI#setDestinationListCapacity] capacity: %1", (long)n);
        DestinationList_ASGcapacity_SetGet destinationList_ASGcapacity_SetGet = new DestinationList_ASGcapacity_SetGet();
        destinationList_ASGcapacity_SetGet.asgcapacity = n;
        this.getProperty(17).setGetREQ(destinationList_ASGcapacity_SetGet);
    }

    public void deleteDestination(Destination destination) {
        this.logChannel.log(10000000, "[AppConnectorENI#deleteDestination] destination: %1", (Object)destination);
        BAPFunctionArrayASG bAPFunctionArrayASG = this.getArray(16);
        DestinationsList_SetGetArray destinationsList_SetGetArray = new DestinationsList_SetGetArray();
        ArrayHeaderConfigurator.forThis(destinationsList_SetGetArray.getArrayHeader()).makeSetGetRequest(destination.getInternalId(), 1, true, false);
        DestinationsList_Data destinationsList_Data = (DestinationsList_Data)destinationsList_SetGetArray.createArrayElement();
        destinationsList_Data.setPos(destination.getInternalId());
        destinationsList_Data.name.setEmptyString();
        destinationsList_SetGetArray.getArrayData().add(destinationsList_Data);
        bAPFunctionArrayASG.setGetArrayREQ(destinationsList_SetGetArray);
    }

    public void remoteProcessUpdateUserList() {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessUpdateUserList]");
        this.triggerRemoteProcess(1, 0, "", "");
    }

    public void remoteProcessDeleteUserList() {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessDeleteUserList]");
        this.triggerRemoteProcess(2, 0, "", "");
    }

    public void remoteProcessPairMainUserUsingPairingCode(String string, String string2) {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessPairMainUserUsingPairingCode] userLogin: %1 pairingCode: %2", (Object)string, (Object)string2);
        this.triggerRemoteProcess(3, 0, string, string2);
    }

    public void remoteProcessPrivacyMode(boolean bl) {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessPrivacyMode] %1", bl);
        this.triggerRemoteProcess(18, bl ? 0 : 1, "", "");
    }

    public void remoteProcessSubmitChangesToBackend() {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessSubmitChangesToBackend]");
        this.triggerRemoteProcess(25, 0, "", "");
    }

    public void remoteProcessPairMainUserUsingVehiclePin(String string, String string2) {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessPairMainUserUsingVehiclePin] userLogin: %1 vehiclePin: %2", (Object)string, (Object)string2);
        this.triggerRemoteProcess(4, 0, string, string2);
    }

    public void remoteProcessConfirmExpirationWarningForService(Service service) {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessConfirmExpirationWarningForService] service: %1", (Object)service);
        this.triggerRemoteProcess(5, 1, service.getId(), "");
    }

    public void remoteProcessConfirmExpirationWarningForServices(Service[] serviceArray) {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessConfirmExpirationWarningForServices] services: %1", (Object)serviceArray);
        String string = AppConnectorENI.buildServiceIdsString(serviceArray);
        this.triggerRemoteProcess(5, 1, string, "");
    }

    public void remoteProcessConfirmExpirationWarningForAllServices() {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessConfirmExpirationWarningForAllServices]");
        this.triggerRemoteProcess(5, 0, "", "");
    }

    public void remoteProcessTerminate() {
        this.logChannel.log(10000000, "[AppConnectorENI#remoteProcessTerminate]");
        this.triggerRemoteProcess(6, 0, "", "");
    }

    public void remoteProcessGetMobileDeviceKeyCount() {
        this.logChannel.log(1000000, "[AppConnectorENI#remoteProcessGetMobileDeviceKeyCount]");
        this.triggerRemoteProcess(7, 0, "", "");
    }

    public void remoteProcessGetVtan(String string) {
        this.logChannel.log(1000000, "[AppConnectorENI#remoteProcessGetVtan]");
        TriggerRemoteProcess_StartResult triggerRemoteProcess_StartResult = new TriggerRemoteProcess_StartResult();
        triggerRemoteProcess_StartResult.commandType = 8;
        triggerRemoteProcess_StartResult.param1 = 0;
        triggerRemoteProcess_StartResult.param2.setRawContent();
        triggerRemoteProcess_StartResult.param2.setContent(string);
        triggerRemoteProcess_StartResult.param3.setContent("");
        this.getMethod(18).startResultREQ(triggerRemoteProcess_StartResult);
    }

    public void getUserList() {
        this.logChannel.log(10000000, "[AppConnectorENI#getUserList]");
        if (this.eniModule.getBapArrayDataENI().getUserList().isUpToDate()) {
            this.eniModule.getAppServiceListenerENI().onUserList(this.eniModule.getBapArrayDataENI().users());
        } else {
            ArrayUtilsASG.requestArrayElements(this.getArray(21), 3, 0, false, new UserList_GetArray());
        }
    }

    public void getServiceList() {
        this.logChannel.log(10000000, "[AppConnectorENI#getServiceList]");
        if (this.eniModule.getBapArrayDataENI().getServiceList().isUpToDate()) {
            this.eniModule.getAppServiceListenerENI().onServiceList(this.eniModule.getBapArrayDataENI().services());
        } else {
            ArrayUtilsASG.requestArrayElements(this.getArray(22), 1, 1, false, new ServiceList_GetArray());
        }
    }

    public void enableService(Service service) {
        this.logChannel.log(10000000, "[AppConnectorENI#enableService] service: %1", (Object)service);
        this.setServiceEnabled(service, true);
    }

    public void disableService(Service service) {
        this.logChannel.log(10000000, "[AppConnectorENI#disableService] service: %1", (Object)service);
        this.setServiceEnabled(service, false);
    }

    public void getMonitorings() {
        this.logChannel.log(10000000, "[AppConnectorENI#getMonitorings]");
        this.getProperty(23).getREQ();
    }

    public void enablePrivacyMode() {
        this.logChannel.log(10000000, "[AppConnectorENI#enablePrivacyMode]");
        this.setPrivacyMode(true);
    }

    public void disablePrivacyMode() {
        this.logChannel.log(10000000, "[AppConnectorENI#disablePrivacyMode]");
        this.setPrivacyMode(false);
    }

    public boolean getPrivacyModeSupported() {
        this.logChannel.log(1000000, "[AppConnectorENI#getPrivacyModeSupported]");
        return this.eniModule.getFunctionList().isFunctionSupported(24);
    }

    private void triggerRemoteProcess(int n, int n2, String string, String string2) {
        TriggerRemoteProcess_StartResult triggerRemoteProcess_StartResult = new TriggerRemoteProcess_StartResult();
        triggerRemoteProcess_StartResult.commandType = n;
        triggerRemoteProcess_StartResult.param1 = n2;
        triggerRemoteProcess_StartResult.param2.setContent(string);
        triggerRemoteProcess_StartResult.param3.setContent(string2);
        this.getMethod(18).startResultREQ(triggerRemoteProcess_StartResult);
    }

    private void setServiceEnabled(Service service, boolean bl) {
        BAPFunctionArrayASG bAPFunctionArrayASG = this.getArray(22);
        ServiceList_SetGetArray serviceList_SetGetArray = new ServiceList_SetGetArray();
        ArrayHeaderConfigurator.forThis(serviceList_SetGetArray.getArrayHeader()).makeSetGetRequest(service.getInternalId(), 2, false, true);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_SetGetArray.createArrayElement();
        serviceList_Data.serviceId.setContent(service.getId());
        serviceList_Data.userSettings.serviceAllowedByVehicle = service.isServiceAllowedByVehicle();
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = bl;
        serviceList_Data.setPos(service.getInternalId());
        serviceList_SetGetArray.getArrayData().add(serviceList_Data);
        bAPFunctionArrayASG.setGetArrayREQ(serviceList_SetGetArray);
    }

    private void setPrivacyMode(boolean bl) {
        PrivacySetup_SetGet privacySetup_SetGet = new PrivacySetup_SetGet();
        privacySetup_SetGet.setup.privacyModeIsActive = bl;
        this.getProperty(24).setGetREQ(privacySetup_SetGet);
    }

    private static String buildServiceIdsString(Service[] serviceArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < serviceArray.length; ++i2) {
            stringBuffer.append(serviceArray[i2].getId());
            if (i2 >= serviceArray.length - 1) continue;
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}

