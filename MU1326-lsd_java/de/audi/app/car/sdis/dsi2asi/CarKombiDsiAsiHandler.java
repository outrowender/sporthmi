/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.dsi2asi;

import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.global.CarViewOption;

public class CarKombiDsiAsiHandler {
    private ASIHMISyncCarServiceAbstractBaseService asiUpdater;
    private LogChannel logChannel;
    private ISDISFramework sdisBase;

    public CarKombiDsiAsiHandler(ISDISFramework iSDISFramework) {
        this.sdisBase = iSDISFramework;
        this.asiUpdater = iSDISFramework.getASIDataUpdater().getServiceASI();
        this.logChannel = iSDISFramework.getLogChannel("App.CarSDIS.Base");
    }

    protected void updateSIAOilInspection(SIAOilInspection sIAOilInspection) {
        de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection sIAOilInspection2 = new de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection();
        sIAOilInspection2.distance = sIAOilInspection.getDistance();
        sIAOilInspection2.distanceStatus = sIAOilInspection.getDistanceStatus();
        sIAOilInspection2.distanceUnit = sIAOilInspection.getDistanceUnit();
        sIAOilInspection2.time = sIAOilInspection.getTime();
        sIAOilInspection2.timeStatus = sIAOilInspection.getTimeStatus();
        try {
            this.asiUpdater.updateSIAOilInspection(sIAOilInspection2);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateSIAOilInspection] %1", (Throwable)methodException);
        }
    }

    protected void updateSIAOilInspectionVisibilityState(CarViewOption carViewOption) {
        try {
            int n = this.sdisBase.updateVisibility(carViewOption, (short)13);
            this.logChannel.log(1078071040, "[SDISCarStatusDistributor#updateVinDataVisibilityState] %1 -> %2", (Object)carViewOption, (long)n);
            this.asiUpdater.updateSIAOilInspectionVisibilityState(new int[]{n, n});
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateSIAOilInspectionVisibilityState exception: %1]", (Throwable)methodException);
        }
    }

    protected void updateSIAServiceData(SIAServiceData sIAServiceData) {
        de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData sIAServiceData2 = new de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData();
        sIAServiceData2.distance = sIAServiceData.getDistance();
        sIAServiceData2.distanceUnit = sIAServiceData.getDistanceUnit();
        sIAServiceData2.time = sIAServiceData.getTime();
        sIAServiceData2.timeStatus = sIAServiceData.getTimeStatus();
        try {
            this.asiUpdater.updateSIAServiceData(sIAServiceData2);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateSIAOilInspection] %1", (Throwable)methodException);
        }
    }

    protected void updateSIAServiceDataVisibilityState(int n) {
        try {
            this.asiUpdater.updateSIAServiceDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateSIAServiceDataVisibilityState] %1", (Throwable)methodException);
        }
    }
}

