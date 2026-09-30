/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.remoteservices;

import de.audi.app.bap.app.AbstractAppConnectorASG;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.app.bap.remoteservices.BAPModuleRemoteServices;
import de.audi.atip.interapp.bap.remoteservices.BAPServiceRemoteServices;
import de.audi.atip.interapp.bap.remoteservices.data.MobileKeySetup;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_SetGet;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANAuthData_StartResult;
import de.vw.mib.bap.generated.remoteservices.serializer.VTANDecryption_StartResult;

public class AppConnectorRemoteServices
extends AbstractAppConnectorASG
implements BAPServiceRemoteServices {
    private final BAPModuleRemoteServices remoteServicesModule;
    private static final int ASG_ID_HEADUNIT = 1;
    private static final String EMPTY_STRING = "";

    public AppConnectorRemoteServices(BAPModuleRemoteServices bAPModuleRemoteServices, IFunctionRegistrationASG iFunctionRegistrationASG) {
        super(bAPModuleRemoteServices.getLogChannel(), iFunctionRegistrationASG);
        this.remoteServicesModule = bAPModuleRemoteServices;
    }

    public void disableMobileDeviceKey() {
        this.logChannel.log(1000000, "[AppConnectorRemoteServices#disableMobileDeviceKey] called");
        MobDevKeySetup_SetGet mobDevKeySetup_SetGet = new MobDevKeySetup_SetGet();
        mobDevKeySetup_SetGet.setup.mobileDeviceKeyEnabled = false;
        this.remoteServicesModule.getBAPFunctionPropertyASG(23).setGetREQ(mobDevKeySetup_SetGet);
    }

    public void enableMobileDeviceKey() {
        this.logChannel.log(1000000, "[AppConnectorRemoteServices#enableMobileDeviceKey] called");
        MobDevKeySetup_SetGet mobDevKeySetup_SetGet = new MobDevKeySetup_SetGet();
        mobDevKeySetup_SetGet.setup.mobileDeviceKeyEnabled = true;
        this.remoteServicesModule.getBAPFunctionPropertyASG(23).setGetREQ(mobDevKeySetup_SetGet);
    }

    public void startVTANAuthData() {
        this.logChannel.log(1000000, "[AppConnectorRemoteServices#startVTANAuthData] called");
        VTANAuthData_StartResult vTANAuthData_StartResult = new VTANAuthData_StartResult();
        vTANAuthData_StartResult.asg_Id = 1;
        vTANAuthData_StartResult.challenge.setContent(EMPTY_STRING);
        this.getMethod(24).startResultREQ(vTANAuthData_StartResult);
    }

    public void startVTANDecryption(String string) {
        this.logChannel.log(1000000, "[AppConnectorRemoteServices#startVTANDecryption] vTANDataEncrypted=%1", (Object)string);
        VTANDecryption_StartResult vTANDecryption_StartResult = new VTANDecryption_StartResult();
        vTANDecryption_StartResult.asg_Id = 1;
        vTANDecryption_StartResult.vtandataEncrypted.setRawContent();
        vTANDecryption_StartResult.vtandataEncrypted.setContent(string);
        this.getMethod(25).startResultREQ(vTANDecryption_StartResult);
    }

    public void triggerMobDevKeySetupUpdate() {
        this.logChannel.log(1000000, "[AppConnectorRemoteServices#triggerMobDevKeySetupUpdate] called");
        MobileKeySetup mobileKeySetup = this.remoteServicesModule.getDataRemoteServices().getCurrentMobileKeySetup();
        this.remoteServicesModule.getAppServiceListenerRemoteServices().onMobDevKeySetup(mobileKeySetup);
    }
}

