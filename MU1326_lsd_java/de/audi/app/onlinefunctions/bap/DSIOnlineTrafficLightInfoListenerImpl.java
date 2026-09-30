/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.onlinefunctions.bap;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.onlinefunctions.bap.TrafficLightInfo;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Info_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Speed_Status;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Time_Status;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener;

public final class DSIOnlineTrafficLightInfoListenerImpl
implements DSIOnlineTrafficLightInfoListener {
    private final AbstractBAPApplication bapApplication;
    private final LogChannel dsiLogChannel;

    public DSIOnlineTrafficLightInfoListenerImpl(AbstractBAPApplication abstractBAPApplication) {
        this.bapApplication = abstractBAPApplication;
        this.dsiLogChannel = abstractBAPApplication.getLogger().getDSILog();
    }

    public void asyncException(int n, String string, int n2) {
        this.dsiLogChannel.log(10000, "[DSIOnlineTrafficLightInfoListenerImpl#asyncException] %2 %1", (Object)string, (long)n);
    }

    public void updateTrafficLightInfo(int n, int n2, int[] nArray, int n3, int n4, int n5) {
        TrafficLightInfo trafficLightInfo = TrafficLightInfo.builder().setTrafficLight(n).setMainDirection(n2).setSideStreetDirections(nArray).setLevel(n3).setLayout(n4).build();
        this.dsiLogChannel.log(1000000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightInfo] trafficLightInfo: %1", (long)n);
        if (n5 != 1) {
            this.dsiLogChannel.log(1000000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightInfo] not valid");
            return;
        }
        TrafficLightOnline_Info_Status trafficLightOnline_Info_Status = new TrafficLightOnline_Info_Status();
        trafficLightOnline_Info_Status.trafficLight = trafficLightInfo.getTrafficLight();
        trafficLightOnline_Info_Status.mainDirection = trafficLightInfo.getMainDirection();
        trafficLightInfo.setSideStreetsDirections(trafficLightOnline_Info_Status.sidestreets);
        trafficLightOnline_Info_Status.trafficLightLayout = trafficLightInfo.getLayout();
        if (!trafficLightInfo.isTrafficLightWarningsValid()) {
            this.dsiLogChannel.log(100000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightInfo] level value not in range %1 ", (long)n3);
        } else {
            trafficLightInfo.setTrafficLightWarnings(trafficLightOnline_Info_Status.trafficLightWarnings);
        }
        ((AbstractBAPModuleFSG)this.bapApplication.getModule(42)).getBAPFunctionPropertyFSG(16).sendStatusIfChanged(trafficLightOnline_Info_Status);
    }

    public void updateTrafficLightSpeed(CarBCSpeed carBCSpeed, int n) {
        this.dsiLogChannel.log(1000000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightSpeed] CarBCSpeed: %1 validFlag: %2", (Object)carBCSpeed, (long)n);
        if (n == 1) {
            TrafficLightOnline_Speed_Status trafficLightOnline_Speed_Status = new TrafficLightOnline_Speed_Status();
            trafficLightOnline_Speed_Status.recommendedSpeed = Math.round(carBCSpeed.getSpeedValue());
            trafficLightOnline_Speed_Status.unit = carBCSpeed.getSpeedUnit();
            trafficLightOnline_Speed_Status.validityInformation.recommendedSpeedIsValid = carBCSpeed.speedValueState == 1;
            ((AbstractBAPModuleFSG)this.bapApplication.getModule(42)).getBAPFunctionPropertyFSG(17).sendStatusIfChanged(trafficLightOnline_Speed_Status);
        } else {
            this.dsiLogChannel.log(100000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightSpeed] not valid");
        }
    }

    public void updateTrafficLightTime(int n, int n2, int n3) {
        this.dsiLogChannel.log(1000000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightTime] timeToGreen: %1 validity: %2 validFlag: %3", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            TrafficLightOnline_Time_Status trafficLightOnline_Time_Status = new TrafficLightOnline_Time_Status();
            trafficLightOnline_Time_Status.timeToGreen = n;
            trafficLightOnline_Time_Status.validityInformation.timeToGreenIsValid = n2 == 1;
            ((AbstractBAPModuleFSG)this.bapApplication.getModule(42)).getBAPFunctionPropertyFSG(18).sendStatusIfChanged(trafficLightOnline_Time_Status);
        } else {
            this.dsiLogChannel.log(1000000, "[DSIOnlineTrafficLightInfoListenerImpl#updateTrafficLightTime] not valid");
        }
    }
}

