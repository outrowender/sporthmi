/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.eni.BAPModuleENI;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.LoggingUtils;
import de.audi.atip.interapp.bap.eni.BAPServiceENI;
import de.audi.atip.interapp.bap.eni.BAPServiceENIListener;
import de.audi.atip.interapp.bap.eni.data.Address;
import de.audi.atip.interapp.bap.eni.data.Destination;
import de.audi.atip.interapp.bap.eni.data.License;
import de.audi.atip.interapp.bap.eni.data.Monitorings;
import de.audi.atip.interapp.bap.eni.data.RemoteProcessState;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.SupportedRemoteProcesses;
import de.audi.atip.interapp.bap.eni.data.User;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_Data;
import de.vw.mib.bap.generated.eni.serializer.DestinationsList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_Status;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_Data;
import de.vw.mib.bap.generated.eni.serializer.ServiceList_StatusArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_ChangedArray;
import de.vw.mib.bap.generated.eni.serializer.UserList_Data;
import de.vw.mib.bap.generated.eni.serializer.UserList_StatusArray;
import java.util.Iterator;

public final class BAPDiagnosisConnectorENI
extends AbstractBAPDiagnosisConnectorASG {
    private static final String SERVICE_ID_CARFINDER = "carfinder_v1";
    private static final String SERVICE_ID_REMOTE_HEATING = "rheating_v1";
    private static final String SERVICE_ID_SPEED_ALERT = "speedalert_v1";
    private static final String SERVICE_ID_VALET_ALERT = "valetalert_v1";
    private static final String SERVICE_ID_GEO_ALERT = "geofence_v1";
    private static final String SERVICE_ID_ECALL = "ecall_v1";
    private static final String SERVICE_ID_DWA_PUSH = "dwap";
    private static final String SERVICE_ID_MOBILE_KEY = "mobile_key";

    public BAPDiagnosisConnectorENI(AbstractBAPApplication abstractBAPApplication, AbstractBAPModuleASG abstractBAPModuleASG) {
        super(abstractBAPApplication, abstractBAPModuleASG, "AppBapENI");
    }

    protected void initKeyDescriptions() {
    }

    protected void initCmdDescriptions() {
        this.cmdDescriptionMap.put("cmdGetServiceList", "App -> cGW: Get service list.");
        this.cmdDescriptionMap.put("cmdGetDestinationList", "App -> cGW: Get destination list.");
        this.cmdDescriptionMap.put("cmdGetUserList", "App -> cGW: Get user list");
        this.cmdDescriptionMap.put("cmdSetDestinationListCapacity", "App -> cGW: Set destination capacity. cmdSetDestinationListCapacity(int capacity)");
        this.cmdDescriptionMap.put("cmdDeleteDestination", "App -> cGW: Delete Destination with given posId. cmdDeleteDestination(int posId)");
        this.cmdDescriptionMap.put("cmdRemoteProcessUpdateUserList", "App -> cGW: Start Update User List. cmdRemoteProcessUpdateUserList()");
        this.cmdDescriptionMap.put("cmdRemoteProcessDeleteUserList", "App -> cGW: Start Delete User List. cmdRemoteProcessDeleteUserList()");
        this.cmdDescriptionMap.put("cmdRemoteProcessPairMainUserUsingPairingCode", "App -> cGW: Start Main User Pairing with Pairing Code. cmdRemoteProcessPairMainUserUsingPairingCode(String userLogin | String pairingCode)");
        this.cmdDescriptionMap.put("cmdRemoteProcessPairMainUserUsingVehiclePin", "App -> cGW: Start Main User Pairing with Vehicle PIN. cmdRemoteProcessPairMainUserUsingVehiclePin(String userLogin | String vehiclePin)");
        this.cmdDescriptionMap.put("cmdRemoteProcessConfirmExpirationWarningForService", "App -> cGW: Confirm Expiration Warning for One Service. cmdRemoteProcessConfirmExpirationWarningForService(String serviceId)");
        this.cmdDescriptionMap.put("cmdRemoteProcessConfirmExpirationWarningForServices", "App -> cGW: Confirm Expiration Warning for Several Services (two with this method). cmdRemoteProcessConfirmExpirationWarningForServices(String serviceId1 | String serviceId2)");
        this.cmdDescriptionMap.put("cmdRemoteProcessConfirmExpirationWarningForAllServices", "App -> cGW: Confirm Expiration Warning for All Services. cmdRemoteProcessConfirmExpirationWarningForAllServices()");
        this.cmdDescriptionMap.put("cmdRemoteProcessTerminate", "App -> cGW: Terminate Remote Process. cmdRemoteProcessTerminate(int remoteProcessKind)");
        this.cmdDescriptionMap.put("cmdEnableService", "App -> cGW: Enable the Service Identified by the given BAP PosID and Service ID. cmdEnableService(int posID|String serviceId)");
        this.cmdDescriptionMap.put("cmdDisableService", "App -> cGW: Disable the Service Identified by the given BAP PosID and Service ID. cmdDisableService(int posID|String serviceId)");
        this.cmdDescriptionMap.put("cmdEnablePrivacyMode", "App -> cGW: Enable Privacy Mode. cmdEnablePrivacyMode())");
        this.cmdDescriptionMap.put("cmdDisablePrivacyMode", "App -> cGW: Disable Privacy Mode. cmdDisablePrivacyMode()");
        this.cmdDescriptionMap.put("cmdOnDestinationListChangedArray", "cGW -> App: DestinationList Changed Array. cmdOnDestinationListChangedArray()");
        this.cmdDescriptionMap.put("cmdOnDestinationList", "cGW -> App: Received POI. cmdOnDestinationList(String street | String number | String postalCode | String city)");
        this.cmdDescriptionMap.put("cmdOnRemoteProcessFinished", "cGW -> App: Remote Process Finished. cmdOnRemoteProcessFinished(boolean succeeded)");
        this.cmdDescriptionMap.put("cmdOnSupportedRemoteProcesses", "cGW -> App: Got List of Supported Remote Processes. cmdOnSupportedRemoteProcesses(boolean updateUserListSupported | boolean deleteUserListSupported | boolean pairMainUserUsingPairingCodeSupported | boolean pairMainUserUsingVehiclePinSupported | boolean confirmServiceExpirationWarningSupported | boolean terminateRemoteProcessSupported)");
        this.cmdDescriptionMap.put("cmdOnRemoteProcessState", "cGW -> App: Got State of Remote Process. cmdOnRemoteProcessState(int remoteProcessKind | int state | int exceptionState | int userListRequestInfo)");
        this.cmdDescriptionMap.put("cmdOnUserListChangedArray", "cGW -> App: UserList Changed Array. cmdOnUserListChangedArray()");
        this.cmdDescriptionMap.put("cmdOnUserListOneUser", "cGW -> App: Got Users List (one user). cmdOnUserListOneUser(String login | boolean isMainUser)");
        this.cmdDescriptionMap.put("cmdOnUserListTwoUsers", "cGW -> App: Got Users list (two users). cmdOnUserListTwoUsers(String login1 | boolean isMainUser1 | String login2 | boolean isMainUser2)");
        this.cmdDescriptionMap.put("cmdOnServiceListChangedArray", "cGW -> App: ServiceList Changed Array. cmdOnServiceListChangedArray()");
        this.cmdDescriptionMap.put("cmdOnServiceListOneService", "cGW -> App: Got List of Services (one service). cmdOnServiceListOneService(String serviceId | String serviceName | boolean serviceEnabled | boolean serviceEnabledByUser | boolean serviceHasExpirationWarning | int licenseState)");
        this.cmdDescriptionMap.put("cmdOnServiceListTwoServices", "cGW -> App: Got List of Services (two services). cmdOnServiceListTwoServices(String serviceId1 | String serviceName1 | boolean serviceEnabled1 | boolean serviceEnabledByUser1 | boolean serviceHasExpirationWarning1 | int licenseState1 | String serviceId2 | String serviceName2 | boolean serviceEnabled2 | boolean serviceEnabledByUser2 | boolean serviceHasExpirationWarning2 | int licenseState2)");
        this.cmdDescriptionMap.put("cmdOnMonitorings", "cGW -> App: Got Current State of Monitorings. cmdOnMonitorings(boolean geofenceEnabled | boolean speedAlertEnabled | boolean valetAlertEnabled)");
        this.cmdDescriptionMap.put("cmdReceiveDestinationList", "cGW -> App: Simulate the reception of a Destination List containing one destination. cmdReceiveDestinationList()");
        this.cmdDescriptionMap.put("cmdReceiveUserList", "cGW -> App: Simulate the reception of a User List containing one main user and two secondary user. cmdReceiveUserList()");
        this.cmdDescriptionMap.put("cmdReceiveServiceListSingle", "cGW -> App: Service List containing Carfinder.");
        this.cmdDescriptionMap.put("cmdReceiveServiceListRemoteHeating", "cGW -> App: Service List containing remote heating.");
        this.cmdDescriptionMap.put("cmdReceiveServiceListFull", "cGW -> App: Service List containing all GreyServices.");
        this.cmdDescriptionMap.put("cmdReceiveDWA_PUSH", "cGW -> App: Service List containing DWA PUSH.");
        this.cmdDescriptionMap.put("cmdReceiveServiceListInValidLicense", "cGW -> App: Simulate the reception of a Service List containing one service with Invalid(empty) License. cmdReceiveServiceListInValidLicense()");
        this.cmdDescriptionMap.put("cmdReceiveServiceListAlertServicesSingle", "cGW -> App: one AlertService. cmdReceiveServiceListAlertService()");
        this.cmdDescriptionMap.put("cmdReceiveServiceListWithExpiredLicenceforEcall", "cGW -> App: Simulate the reception of a Service List containing 'ecall_v1' with licence expired. cmdReceiveServiceListWithExpiredLicenceforEcall()");
        this.cmdDescriptionMap.put("cmdReceiveServiceListWithExpWarningforEcall", "cGW -> App: Simulate the reception of a Service List containing 'ecall_v1'. cmdReceiveServiceListWithExpWarningforEcall()");
        this.cmdDescriptionMap.put("cmdReceiveServiceListWithExpWarningforEcallTeaser", "cGW -> App: Simulate the reception of a Service List containing 'ecall_v1' as Teaser. cmdReceiveServiceListWithExpWarningforEcallTeaser()");
        this.cmdDescriptionMap.put("cmdResetECallPersitenceTrail", "cGW -> App: Simulate the reception on an Service List with Valid Licenze Data and Type 'TempOffering'. cmdResetECallPersitenceTrail()");
        this.cmdDescriptionMap.put("cmdResetECallPersitence", "cGW -> App: Simulate the reception on an Service List with Valid Licenze Data . cmdResetECallPersitence()");
        this.cmdDescriptionMap.put("cmdReceivePrivacySetup", "cGW -> App: Simulate the reception of a Privacy Setup. cmdReceivePrivacySetup(boolean privacyModeOn)");
    }

    public String getBAPStackStates() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.application.getModules().iterator();
        while (iterator.hasNext()) {
            AbstractBAPModule abstractBAPModule = (AbstractBAPModule)iterator.next();
            buffer.append(LSGIDs.getDescription(abstractBAPModule.getLSGID()));
            buffer.append(" - ");
            buffer.append(LoggingUtils.getBAPStackStateDescription(abstractBAPModule.getInitializationManager().getBapStackState()));
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public Object getHMIStates() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.application.getModules().iterator();
        while (iterator.hasNext()) {
            AbstractBAPModule abstractBAPModule = (AbstractBAPModule)iterator.next();
            buffer.append(LSGIDs.getDescription(abstractBAPModule.getLSGID()));
            buffer.append(" - ");
            buffer.append(LoggingUtils.getHMIStateDescription(abstractBAPModule.getInitializationManager().getHMIState()));
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public Object getInitStates() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.application.getModules().iterator();
        while (iterator.hasNext()) {
            AbstractBAPModule abstractBAPModule = (AbstractBAPModule)iterator.next();
            buffer.append(LSGIDs.getDescription(abstractBAPModule.getLSGID()));
            buffer.append(" - ");
            buffer.append(LoggingUtils.getInitStateDescription(abstractBAPModule.getInitializationManager().getInitState()));
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public void cmdGetServiceList() {
        this.eni().getServiceList();
    }

    public void cmdGetDestinationList() {
        this.eni().getDestinationList();
    }

    public void cmdGetUserList() {
        this.eni().getUserList();
    }

    public void cmdSetDestinationListCapacity(int n) {
        this.eni().setDestinationListCapacity(n);
    }

    public void cmdDeleteDestination(int n) {
        Destination.Builder builder = Destination.builder();
        builder.setInternalId(n);
        this.eni().deleteDestination(builder.build());
    }

    public void cmdRemoteProcessUpdateUserList() {
        this.eni().remoteProcessUpdateUserList();
    }

    public void cmdRemoteProcessDeleteUserList() {
        this.eni().remoteProcessDeleteUserList();
    }

    public void cmdRemoteProcessPairMainUserUsingPairingCode(String string, String string2) {
        this.eni().remoteProcessPairMainUserUsingPairingCode(string, string2);
    }

    public void cmdRemoteProcessPairMainUserUsingVehiclePin(String string, String string2) {
        this.eni().remoteProcessPairMainUserUsingVehiclePin(string, string2);
    }

    public void cmdRemoteProcessConfirmExpirationWarningForService(String string) {
        License.Builder builder = License.builder();
        builder.setActivationDate("201412011000Z");
        builder.setExpirationDate("201612011000Z");
        builder.setId("");
        builder.setState(2);
        builder.setValidityDuration("000201011000Z");
        Service.Builder builder2 = Service.builder();
        builder2.setLicense(builder.build());
        builder2.setId(string);
        this.eni().remoteProcessConfirmExpirationWarningForService(builder2.build());
    }

    public void cmdRemoteProcessConfirmExpirationWarningForServices(String string, String string2) {
        License.Builder builder = License.builder();
        builder.setActivationDate("201412011000Z");
        builder.setExpirationDate("201612011000Z");
        builder.setId(SERVICE_ID_CARFINDER);
        builder.setState(2);
        builder.setValidityDuration("000201011000Z");
        Service.Builder builder2 = Service.builder();
        builder2.setId(string);
        builder2.setLicense(builder.build());
        Service service = builder2.build();
        builder2.setId(string2);
        builder2.setLicense(builder.build());
        Service service2 = builder2.build();
        Service[] serviceArray = new Service[]{service, service2};
        this.eni().remoteProcessConfirmExpirationWarningForServices(serviceArray);
    }

    public void cmdRemoteProcessConfirmExpirationWarningForAllServices() {
        this.eni().remoteProcessConfirmExpirationWarningForAllServices();
    }

    public void cmdRemoteProcessTerminate() {
        this.eni().remoteProcessTerminate();
    }

    public void cmdEnableService(int n, String string) {
        License.Builder builder = License.builder();
        builder.setActivationDate("201412011000Z");
        builder.setExpirationDate("201612011000Z");
        builder.setId("license id");
        builder.setState(2);
        builder.setValidityDuration("000201011000Z");
        Service.Builder builder2 = Service.builder();
        builder2.setInternalId(n);
        builder2.setId(string);
        builder2.setName("name");
        builder2.setVersion("version");
        builder2.setLicense(builder.build());
        this.eni().enableService(builder2.build());
    }

    public void cmdDisableService(int n, String string) {
        License.Builder builder = License.builder();
        builder.setActivationDate("201412011000Z");
        builder.setExpirationDate("201612011000Z");
        builder.setId("license id");
        builder.setState(2);
        builder.setValidityDuration("000201011000Z");
        Service.Builder builder2 = Service.builder();
        builder2.setInternalId(n);
        builder2.setId(string);
        builder2.setName("name");
        builder2.setVersion("version");
        builder2.setLicense(builder.build());
        this.eni().disableService(builder2.build());
    }

    public void cmdEnablePrivacyMode() {
        this.eni().enablePrivacyMode();
    }

    public void cmdDisablePrivacyMode() {
        this.eni().disablePrivacyMode();
    }

    public void cmdOnDestinationList(String string, String string2, String string3, String string4) {
        Address.Builder builder = Address.builder();
        builder.setStreet(string);
        builder.setNumber(string2);
        builder.setPostalCode(string3);
        builder.setCity(string4);
        Destination.Builder builder2 = Destination.builder();
        builder2.setAddress(builder.build());
        Destination[] destinationArray = new Destination[]{builder2.build()};
        this.eniListener().onDestinationList(destinationArray);
    }

    public void cmdOnDestinationListChangedArray() {
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getBAPFunctionArrayASG(16);
        DestinationsList_ChangedArray destinationsList_ChangedArray = new DestinationsList_ChangedArray();
        this.moduleAsg.getIndicationHandler().processIndicationChangedArray(bAPFunctionArrayASG, destinationsList_ChangedArray);
    }

    public void cmdOnRemoteProcessFinished(boolean bl) {
        this.eniListener().onRemoteProcessFinished(bl);
    }

    public void cmdOnSupportedRemoteProcesses(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        SupportedRemoteProcesses.Builder builder = SupportedRemoteProcesses.builder();
        builder.setUpdateUserListSupported(bl);
        builder.setDeleteUserListSupported(bl2);
        builder.setPairMainUserUsingPairingCodeSupported(bl3);
        builder.setPairMainUserUsingVehiclePinSupported(bl4);
        builder.setConfirmServiceExpirationWarningSupported(bl5);
        builder.setTerminateRemoteProcessSupported(bl6);
        this.eniListener().onSupportedRemoteProcesses(builder.build());
    }

    public void cmdOnRemoteProcessState(int n, int n2, int n3, int n4) {
        RemoteProcessState.Builder builder = RemoteProcessState.builder();
        builder.setRemoteProcessKind(n);
        builder.setState(n2);
        builder.setExceptionState(n3);
        builder.setUserListRequestInfo(n4);
        this.eniListener().onRemoteProcessState(builder.build());
    }

    public void cmdOnErrorNoVerifiedAccount() {
        RemoteProcessState.Builder builder = RemoteProcessState.builder();
        builder.setRemoteProcessKind(4);
        builder.setState(4);
        builder.setExceptionState(10);
        builder.setUserListRequestInfo(3);
        System.out.println(" Pin retry remaining " + builder.build().getPinRetryRemainingCount());
        System.out.println(" RemoteProcessKind " + builder.build().getRemoteProcessKind());
        System.out.println(" State " + builder.build().getState());
        System.out.println(" ExceptionState " + builder.build().getExceptionState());
        System.out.println(" UserListRequestInfo " + builder.build().getUserListRequestInfo());
        this.eniListener().onRemoteProcessState(builder.build());
    }

    public void cmdOnUserListChangedArray() {
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getBAPFunctionArrayASG(21);
        UserList_ChangedArray userList_ChangedArray = new UserList_ChangedArray();
        this.moduleAsg.getIndicationHandler().processIndicationChangedArray(bAPFunctionArrayASG, userList_ChangedArray);
    }

    public void cmdOnUserListOneUser(String string, boolean bl) {
        User[] userArray = new User[]{User.getInstance(string, bl)};
        this.eniListener().onUserList(userArray);
    }

    public void cmdOnUserListTwoUsers(String string, boolean bl, String string2, boolean bl2) {
        User[] userArray = new User[]{User.getInstance(string, bl), User.getInstance(string2, bl2)};
        this.eniListener().onUserList(userArray);
    }

    public void cmdOnServiceListChangedArray() {
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getBAPFunctionArrayASG(22);
        ServiceList_ChangedArray serviceList_ChangedArray = new ServiceList_ChangedArray();
        this.moduleAsg.getIndicationHandler().processIndicationChangedArray(bAPFunctionArrayASG, serviceList_ChangedArray);
    }

    public void cmdOnServiceListOneService(String string, String string2, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, boolean bl5) {
        Service service = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(string, string2, bl, bl2, bl3, n, bl4, bl5);
        Service[] serviceArray = new Service[]{service};
        this.eniListener().onServiceList(serviceArray);
    }

    public void cmdOnServiceListTwoServices(String string, String string2, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, String string3, String string4, boolean bl5, boolean bl6, boolean bl7, int n2, boolean bl8) {
        Service service = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(string, string2, bl, bl2, bl3, n, bl4, true);
        Service service2 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(string3, string4, bl5, bl6, bl7, n2, bl8, true);
        Service[] serviceArray = new Service[]{service, service2};
        this.eniListener().onServiceList(serviceArray);
    }

    public void cmdOnMonitorings(boolean bl, boolean bl2, boolean bl3) {
        Monitorings.Builder builder = Monitorings.builder();
        builder.setGeofenceEnabled(bl);
        builder.setSpeedAlertEnabled(bl2);
        builder.setValetAlertEnabled(bl3);
        this.eniListener().onMonitorings(builder.build());
    }

    public void cmdReceiveDestinationList() {
        DestinationsList_StatusArray destinationsList_StatusArray = BAPDiagnosisConnectorENI.makeBAPDestinationStatusArray();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(16);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, destinationsList_StatusArray);
    }

    public void cmdReceiveUserList() {
        UserList_StatusArray userList_StatusArray = BAPDiagnosisConnectorENI.makeBAPUserStatusArray();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(21);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, userList_StatusArray);
    }

    public void cmdReceiveServiceListFull() {
        Service service = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_MOBILE_KEY, SERVICE_ID_MOBILE_KEY, true, true, false, 2, false, true);
        Service service2 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_CARFINDER, SERVICE_ID_CARFINDER, true, true, false, 2, false, true);
        Service service3 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_REMOTE_HEATING, SERVICE_ID_REMOTE_HEATING, true, true, false, 2, false, true);
        Service service4 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_SPEED_ALERT, SERVICE_ID_SPEED_ALERT, true, true, false, 2, true, false);
        Service service5 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_VALET_ALERT, SERVICE_ID_VALET_ALERT, true, true, false, 2, true, false);
        Service service6 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_GEO_ALERT, SERVICE_ID_GEO_ALERT, true, true, false, 2, true, false);
        Service service7 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_ECALL, SERVICE_ID_ECALL, true, true, false, 2, true, false);
        Service service8 = BAPDiagnosisConnectorENI.serviceFromDiagnosticsUIParameters(SERVICE_ID_DWA_PUSH, SERVICE_ID_DWA_PUSH, true, true, false, 2, false, true);
        Service[] serviceArray = new Service[]{service, service2, service3, service7, service6, service4, service5, service8};
        this.eniListener().onServiceList(serviceArray);
    }

    public void cmdReceiveServiceListSingel() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArray(SERVICE_ID_CARFINDER);
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveServiceListRemoteHeating() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArray(SERVICE_ID_REMOTE_HEATING);
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveDWA_PUSH() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArray(SERVICE_ID_DWA_PUSH);
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveServiceListInValidLicense() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayWithEmpyLicence(SERVICE_ID_CARFINDER);
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveServiceListWithExpWarningforEcall() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayForEcallWithExpirationWarning();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveServiceListWithExpWarningforEcallTeaser() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayForEcallWithExpirationWarningTeaser();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveServiceListWithExpiredLicenceforEcall() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayForEcallLicenseExpired();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceiveServiceListAlertServicesSingle() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayForAlertService(SERVICE_ID_SPEED_ALERT);
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdResetECallPersitenceTrail() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayToResetEcallPersistenceTemporaryOffer();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdResetECallPersitence() {
        ServiceList_StatusArray serviceList_StatusArray = BAPDiagnosisConnectorENI.makeBAPServiceStatusArrayToResetEcallPersistence();
        BAPFunctionArrayASG bAPFunctionArrayASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionArrayASG(22);
        this.moduleAsg.getIndicationHandler().processIndicationStatusArray(bAPFunctionArrayASG, serviceList_StatusArray);
    }

    public void cmdReceivePrivacySetup(boolean bl) {
        BAPFunctionPropertyASG bAPFunctionPropertyASG = this.moduleAsg.getFunctionRegistration().getBAPFunctionPropertyASG(24);
        PrivacySetup_Status privacySetup_Status = new PrivacySetup_Status();
        privacySetup_Status.setup.privacyModeIsActive = bl;
        privacySetup_Status.modificationReason = 6;
        privacySetup_Status.modificationState.canBeModified = true;
        this.moduleAsg.getIndicationHandler().processIndicationStatus(bAPFunctionPropertyASG, privacySetup_Status);
    }

    private static Service serviceFromDiagnosticsUIParameters(String string, String string2, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, boolean bl5) {
        License.Builder builder = License.builder();
        builder.setState(n);
        builder.setActivationDate("201412031000Z");
        builder.setExpirationDate("201612031000Z");
        builder.setId("id");
        Service.Builder builder2 = Service.builder();
        builder2.setLicense(builder.build());
        builder2.setGPSRequired(bl4);
        builder2.setId(string);
        builder2.setName(string2);
        builder2.setEnabled(bl);
        builder2.setEnabledByUser(bl2);
        builder2.setHasExpirationWarning(bl3);
        builder2.setDisablingByDriverAllowed(bl5);
        return builder2.build();
    }

    private static DestinationsList_StatusArray makeBAPDestinationStatusArray() {
        DestinationsList_StatusArray destinationsList_StatusArray = new DestinationsList_StatusArray();
        destinationsList_StatusArray.asg_Id = 0;
        destinationsList_StatusArray.setTransactionId(0);
        destinationsList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        destinationsList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        DestinationsList_Data destinationsList_Data = (DestinationsList_Data)destinationsList_StatusArray.createArrayElement();
        destinationsList_Data.setPos(1);
        destinationsList_Data.addr_Country.setContent("Germany");
        destinationsList_Data.addr_Number.setContent("46");
        destinationsList_Data.addr_PostalCode.setContent("91058");
        destinationsList_Data.addr_State.setContent("Bayern");
        destinationsList_Data.addr_Street.setContent("Am Wolfsmantel");
        destinationsList_Data.addr_Telephone.setContent("+49(0)1111");
        destinationsList_Data.addr_Town.setContent("Tennenlohe");
        destinationsList_Data.name.setContent("Name");
        destinationsList_Data.poi_Extension.setContent("POI Extension");
        destinationsList_Data.poi_Type = 1;
        destinationsList_Data.position_Latitude = 2;
        destinationsList_Data.position_Longitude = 1;
        destinationsList_Data.stopover_Sn = 1;
        destinationsList_Data.tour_Id = 11;
        destinationsList_Data.typeOfDestination = 3;
        bAPArrayData.add(destinationsList_Data);
        destinationsList_StatusArray.setArrayData(bAPArrayData);
        return destinationsList_StatusArray;
    }

    private static UserList_StatusArray makeBAPUserStatusArray() {
        UserList_StatusArray userList_StatusArray = new UserList_StatusArray();
        userList_StatusArray.asg_Id = 0;
        userList_StatusArray.setTransactionId(0);
        userList_StatusArray.setNumberOfElements(3);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 3;
        userList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(3);
        bAPArrayData.add(BAPDiagnosisConnectorENI.makeBAPUserElement(userList_StatusArray, 1, "main user", true));
        bAPArrayData.add(BAPDiagnosisConnectorENI.makeBAPUserElement(userList_StatusArray, 2, "first secondary user", false));
        bAPArrayData.add(BAPDiagnosisConnectorENI.makeBAPUserElement(userList_StatusArray, 3, "second secondary user", false));
        userList_StatusArray.setArrayData(bAPArrayData);
        return userList_StatusArray;
    }

    private static UserList_Data makeBAPUserElement(UserList_StatusArray userList_StatusArray, int n, String string, boolean bl) {
        UserList_Data userList_Data = (UserList_Data)userList_StatusArray.createArrayElement();
        userList_Data.setPos(n);
        userList_Data.userName.setContent(string);
        userList_Data.userType = bl ? 0 : 1;
        return userList_Data;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArray(String string) {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("201612031000Z");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 2;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(string);
        serviceList_Data.serviceName.setContent(string);
        serviceList_Data.serviceState.licenseExpirationWarning = false;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayWithEmpyLicence(String string) {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("");
        serviceList_Data.dateOfExpiry.setContent("");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 2;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(string);
        serviceList_Data.serviceName.setContent("Car Finder");
        serviceList_Data.serviceState.licenseExpirationWarning = false;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayForEcallWithExpirationWarning() {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("201612031000Z");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 2;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(SERVICE_ID_ECALL);
        serviceList_Data.serviceName.setContent("eCall");
        serviceList_Data.serviceState.licenseExpirationWarning = true;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayToResetEcallPersistenceTemporaryOffer() {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("201612031000Z");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 4;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(SERVICE_ID_ECALL);
        serviceList_Data.serviceName.setContent("eCall");
        serviceList_Data.serviceState.licenseExpirationWarning = false;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayToResetEcallPersistence() {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("201612031000Z");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 2;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(SERVICE_ID_ECALL);
        serviceList_Data.serviceName.setContent("eCall");
        serviceList_Data.serviceState.licenseExpirationWarning = false;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayForEcallWithExpirationWarningTeaser() {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("201612031000Z");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 4;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(SERVICE_ID_ECALL);
        serviceList_Data.serviceName.setContent("eCall");
        serviceList_Data.serviceState.licenseExpirationWarning = true;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayForEcallLicenseExpired() {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 3;
        serviceList_Data.periodOfValidity.setContent("");
        serviceList_Data.serviceId.setContent(SERVICE_ID_ECALL);
        serviceList_Data.serviceName.setContent("eCall");
        serviceList_Data.serviceState.licenseExpirationWarning = true;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private static ServiceList_StatusArray makeBAPServiceStatusArrayForAlertService(String string) {
        ServiceList_StatusArray serviceList_StatusArray = new ServiceList_StatusArray();
        serviceList_StatusArray.asg_Id = 0;
        serviceList_StatusArray.setTransactionId(0);
        serviceList_StatusArray.setNumberOfElements(1);
        ArrayHeader arrayHeader = new ArrayHeader();
        arrayHeader.elements = 1;
        serviceList_StatusArray.setArrayHeader(arrayHeader);
        BAPArrayData bAPArrayData = new BAPArrayData(1);
        ServiceList_Data serviceList_Data = (ServiceList_Data)serviceList_StatusArray.createArrayElement();
        serviceList_Data.setPos(1);
        serviceList_Data.dateOfActivation.setContent("201412031000Z");
        serviceList_Data.dateOfExpiry.setContent("201612031000Z");
        serviceList_Data.licenseId.setContent("license id");
        serviceList_Data.licenseState = 2;
        serviceList_Data.periodOfValidity.setContent("000200000000Z");
        serviceList_Data.serviceId.setContent(string);
        serviceList_Data.serviceName.setContent("Speed Alert");
        serviceList_Data.serviceState.licenseExpirationWarning = false;
        serviceList_Data.serviceState.protectedService = false;
        serviceList_Data.serviceState.roamingAllowed = true;
        serviceList_Data.serviceState.serviceEnabled = true;
        serviceList_Data.serviceVersion.setContent("version 1");
        serviceList_Data.userSettings.serviceActivatedAllowedByDriver = true;
        bAPArrayData.add(serviceList_Data);
        serviceList_StatusArray.setArrayData(bAPArrayData);
        return serviceList_StatusArray;
    }

    private BAPServiceENI eni() {
        return ((BAPModuleENI)this.moduleAsg).getAppServiceENI();
    }

    private BAPServiceENIListener eniListener() {
        return ((BAPModuleENI)this.moduleAsg).getAppServiceListenerENI();
    }
}

