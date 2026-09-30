/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractDSICarAirCondition;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirCondition;

public class CarAirConditionComponent
extends AbstractDSICarAirCondition
implements IDSIObserver {
    private static final String LOG_CHANNEL_NAME = "AppCarSCON.CarAirCondition";
    public static final byte[] CODING = new byte[]{8};
    private static final int[] DSI_ATTRIBUTES = new int[]{24, 30, 82};
    private DSICarAirCondition dsi;
    private ISDISFramework baseService;
    private ASIHMISyncCarClimateAbstractBaseService toSDIS;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirConditionListener;

    public CarAirConditionComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel(LOG_CHANNEL_NAME));
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getClimateASI();
    }

    public void init() {
        this.logger.log(10000000, "register DSICarAirCondition");
        this.baseService.registerDSI((class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = CarAirConditionComponent.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition).getName(), (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = CarAirConditionComponent.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener).getName(), this);
    }

    public void deinit() {
        this.logger.log(10000000, "deregister DSICarAirCondition");
        this.baseService.deRegisterDSI((class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = CarAirConditionComponent.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition).getName());
    }

    public void setDSI(DSIBase dSIBase) {
        this.dsi = (DSICarAirCondition)dSIBase;
        this.dsi.setNotification(DSI_ATTRIBUTES, (DSIListener)this);
    }

    public void updateAirconMaxAC(boolean bl, int n) {
        this.logger.log(1000000, "[CarAirConditionComponent#updateAirconMaxAC] maxAC='%1' , validFlag='%2'", bl, (long)n);
        if (n == 1) {
            try {
                this.toSDIS.updateAirconMaxAC(bl);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[CarAirConditionComponent#updateAirconMaxAC] %1", (Throwable)methodException);
            }
        }
    }

    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.logger.log(1000000, "[CarAirConditionComponent#updateAirconTempZone1] temp='%1' , validFlag='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            IntBaseType intBaseType = new IntBaseType(airconTemp.getTempValue(), airconTemp.getTempUnit(), 0);
            try {
                this.toSDIS.updateAirconTempZone1(intBaseType);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[CarAirConditionComponent#updateAirconTempZone1] %1", (Throwable)methodException);
            }
        }
    }

    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.logger.log(1000000, "[CarAirConditionComponent#updateAirconTempZone2] temp='%1' , validFlag='%2'", (Object)airconTemp, (long)n);
        if (n == 1) {
            IntBaseType intBaseType = new IntBaseType(airconTemp.getTempValue(), airconTemp.getTempUnit(), 0);
            try {
                this.toSDIS.updateAirconTempZone2(intBaseType);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[CarAirConditionComponent#updateAirconTempZone2] %1", (Throwable)methodException);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

