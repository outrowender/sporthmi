/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.dsi2asi;

import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.global.CarViewOption;

public class CarVehicleStateAsiHandler {
    private ASIHMISyncCarServiceAbstractBaseService asiUpdater;
    private LogChannel logChannel;
    private ISDISFramework sdisBase;
    private boolean deactivated = true;

    public CarVehicleStateAsiHandler(ISDISFramework iSDISFramework) {
        this.sdisBase = iSDISFramework;
        this.asiUpdater = iSDISFramework.getASIDataUpdater().getServiceASI();
        this.logChannel = iSDISFramework.getLogChannel("App.CarSDIS.Base");
    }

    protected void updateKeyDataVisibilityState(CarViewOption carViewOption) {
        if (this.deactivated) {
            return;
        }
        try {
            int n = this.sdisBase.updateVisibility(carViewOption, (short)32);
            this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateKeyDataVisibilityState] %1 -> %2", (Object)carViewOption, (long)n);
            this.asiUpdater.updateKeyDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateOilLevelDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    protected void updateKeyData(KeyData keyData) {
        if (this.deactivated) {
            return;
        }
        int[] nArray = new int[]{keyData.getActualValue(), keyData.getActiveKey(), keyData.getTargetValue()};
        try {
            this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateKeyData] Send update to devices %1", (Object)nArray);
            this.asiUpdater.updateKeyData(nArray);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[updateKeyData] %1", (Throwable)methodException);
        }
    }

    protected void updateOilLevelDataVisibilityState(CarViewOption carViewOption) {
        try {
            int n = this.sdisBase.updateVisibility(carViewOption, (short)18);
            this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateOilLevelDataVisibilityState]  Send update to devices %1 -> %2", (Object)carViewOption, (long)n);
            this.asiUpdater.updateOilLevelDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateOilLevelDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    protected void updateOilLevelData(OilLevelData oilLevelData) {
        if (oilLevelData != null) {
            IntBaseType intBaseType = oilLevelData.getRefillVolume() != null ? new IntBaseType(oilLevelData.getRefillVolume().getValue(), oilLevelData.getRefillVolume().getUnit(), -1) : new IntBaseType();
            de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData oilLevelData2 = new de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData(oilLevelData.getLevel(), intBaseType, oilLevelData.getWarnings(), oilLevelData.isOilsystem(), oilLevelData.isBargraph());
            try {
                this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateOilLevelData] Send update to devices %1", (Object)oilLevelData2);
                this.asiUpdater.updateOilLevelData(oilLevelData2);
            }
            catch (MethodException methodException) {
                this.logChannel.log(10000, "[SDISCarStatusDistributor#updateOilLevelData] %1", (Throwable)methodException);
            }
        }
    }

    protected void updateVinData(String string) {
        if (this.deactivated) {
            return;
        }
        try {
            this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateVinData] Send update to devices %1", (Object)string);
            this.asiUpdater.updateVinData(string);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateVinData] %1", (Throwable)methodException);
        }
    }

    protected void updateVinDataVisibilityState(CarViewOption carViewOption) {
        if (this.deactivated) {
            return;
        }
        try {
            int n = this.sdisBase.updateVisibility(carViewOption, (short)19);
            this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateVinDataVisibilityState] %1 -> %2", (Object)carViewOption, (long)n);
            this.asiUpdater.updateVinDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateVinDataVisibilityState] %1", (Throwable)methodException);
        }
    }
}

