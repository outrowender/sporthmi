/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.dsi2asi;

import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.CarViewOption;

public class CarZeroEmissionAsiHandler {
    public static final String LOGCHANNEL_NAME;
    protected final ISDISFramework sdisBase;
    protected final ASIHMISyncCarZeroEmissionAbstractBaseService asiService;
    protected final LogChannel logChannel;

    public CarZeroEmissionAsiHandler(ISDISFramework iSDISFramework) {
        this.sdisBase = iSDISFramework;
        this.asiService = iSDISFramework.getASIDataUpdater().getZeroEmissionASI();
        this.logChannel = iSDISFramework.getLogChannel("App.CarSDIS.Base");
    }

    public void updateVisibilityState(CarViewOption carViewOption) {
        this.logChannel.log(1078071040, "[CarZeroEmissionAsiHandler#updateVisibilityState] Interface for ASI not available.");
        try {
            int n = this.sdisBase.updateVisibility(carViewOption, (short)24);
            this.logChannel.log(1078071040, "[CarZeroEmissionAsiHandler#updateVisibilityState] state='%1'", (long)n);
            this.asiService.updateZEVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[CarZeroEmissionAsiHandler#updateVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateZECurrentBarGraph(ZeroEmissionEntry zeroEmissionEntry) {
        try {
            this.asiService.updateCurrentZeroEmissionValue(zeroEmissionEntry);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[CarZeroEmissionAsiHandler#updateZECurrentBarGraph] %1", (Throwable)methodException);
        }
    }

    public void updateZEHistoryBarGraph(ZeroEmissionEntry[] zeroEmissionEntryArray) {
        try {
            this.asiService.updateZeroEmissionValues(zeroEmissionEntryArray);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[CarZeroEmissionAsiHandler#updateZEHistoryBarGraph] %1", (Throwable)methodException);
        }
    }
}

