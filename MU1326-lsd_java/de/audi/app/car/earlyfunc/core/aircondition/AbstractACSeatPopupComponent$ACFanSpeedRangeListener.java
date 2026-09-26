/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.common.sync.IRangeModelSyncListener;
import de.audi.app.car.common.sync.IRangeModelSyncParameterAccess;
import de.audi.app.car.common.sync.RangeModelSynchronizer;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import org.dsi.ifc.caraircondition.AirconAirVolume;

class AbstractACSeatPopupComponent$ACFanSpeedRangeListener
extends DefaultRangeListener
implements IRangeModelSyncListener,
ChoiceListener {
    private final int dsiZone;
    private final int dsiAttribute;
    private final ChoiceModelApp autoChoiceModel;
    private final RangeModelApp rangeModel;
    private RangeModelSynchronizer rangeModelSynchronizer;
    private int airVolumeAuto = 0;
    private int airVolume = 0;
    private static final int FAN_SPEED_MIN;
    private static final int FAN_SPEED_MAX;
    private static final int FAN_SPEED_STEP;
    private final Object mutex = new Object();
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    public AbstractACSeatPopupComponent$ACFanSpeedRangeListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent, int n, int n2, ChoiceModelApp choiceModelApp, RangeModelApp rangeModelApp) {
        this.this$0 = abstractACSeatPopupComponent;
        this.dsiZone = n;
        this.dsiAttribute = n2;
        this.autoChoiceModel = choiceModelApp;
        this.rangeModel = rangeModelApp;
    }

    public void init() {
        this.autoChoiceModel.setChoiceListener(this);
        this.rangeModel.setLimits(0, 10, 1);
        this.rangeModel.setRangeListener(this);
        String string = new StringBuffer().append("fanSpeedSynchronizerZone").append(Integer.toString(this.dsiZone)).toString();
        this.rangeModelSynchronizer = new RangeModelSynchronizer(string, this, 0, this.this$0.getLogChannel());
        this.rangeModelSynchronizer.addWatchedAttribute(this.dsiAttribute, true, this.rangeModel);
    }

    public void deinit() {
        this.autoChoiceModel.resetListener();
        this.rangeModelSynchronizer.clear();
    }

    @Override
    public void setDSIParameter(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        AirconAirVolume airconAirVolume = this.createAirVolume(iRangeModelSyncParameterAccess.getCurrentValue(), this.airVolumeAuto);
        this.sendACSeatSettingToDSI(airconAirVolume);
    }

    @Override
    public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        this.updateRangeModel(iRangeModelSyncParameterAccess);
    }

    @Override
    public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        this.updateRangeModel(iRangeModelSyncParameterAccess);
    }

    private void updateRangeModel(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        if (this.this$0.getLogChannel().isInfo()) {
            AbstractACSeatPopupComponent.access$400(this.this$0, "[ACFanSpeedRangeListener#updateRangeModel]", iRangeModelSyncParameterAccess.getRangeModelID(), iRangeModelSyncParameterAccess.getCurrentValue(), true);
        }
        AbstractACSeatPopupComponent.access$500(this.this$0, iRangeModelSyncParameterAccess.getRangeModelID()).setValue(iRangeModelSyncParameterAccess.getCurrentValue());
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.setAirVolumeAuto(false);
        this.rangeModelSynchronizer.notifyDecrement(this.dsiAttribute, n2);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.setAirVolumeAuto(false);
        this.rangeModelSynchronizer.notifyIncrement(this.dsiAttribute, n2);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.autoChoiceModel.getID()) {
            AbstractACSeatPopupComponent.access$600(this.this$0, "[ACFanSpeedRangeListener#itemSelected]", n, n2, true);
            this.setAirVolumeAuto(n2 == 1);
            this.sendACSeatSettingToDSI(this.createAirVolume());
        } else {
            AbstractACSeatPopupComponent.access$700(this.this$0, "[ACFanSpeedRangeListener#itemSelected]", n, n2, false);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void setAirVolumeAuto(boolean bl) {
        this.airVolumeAuto = bl ? 1 : 0;
    }

    protected void sendACSeatSettingToDSI(AirconAirVolume airconAirVolume) {
        this.this$0.getLogChannel().log(1078071040, "[ACFanSpeedRangeListener#sendACSeatSettingToDSI] dsi.setAirconAirVolume() : zone='%1' , airVolume='%2'", (Object)new Integer(this.dsiZone), (Object)airconAirVolume);
        this.this$0.getDSI().setAirconAirVolume(this.dsiZone, airconAirVolume);
        if ((this.dsiZone == 1 && AbstractACSeatPopupComponent.access$800(this.this$0).isDriverSideLeft() || this.dsiZone == 2 && !AbstractACSeatPopupComponent.access$800(this.this$0).isDriverSideLeft()) && AbstractACSeatPopupComponent.access$900(this.this$0) && airconAirVolume.getAirVolume() == 0) {
            this.this$0.getLogChannel().log(1078071040, "[ACFanSpeedRangeListener#sendACSeatSettingToDSI] dsi.setAirconSystemOnOffRow(ROW1) state=false");
            this.this$0.getDSI().setAirconSystemOnOffRow(1, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private AirconAirVolume createAirVolume() {
        Object object = this.mutex;
        synchronized (object) {
            return this.createAirVolume(this.airVolume, this.airVolumeAuto);
        }
    }

    private AirconAirVolume createAirVolume(int n, int n2) {
        AirconAirVolume airconAirVolume = new AirconAirVolume();
        airconAirVolume.airVolume = n;
        airconAirVolume.airVolumeAuto = n2;
        return airconAirVolume;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAirconAirVolume(AirconAirVolume airconAirVolume) {
        this.autoChoiceModel.setValue(airconAirVolume.getAirVolumeAuto());
        this.rangeModelSynchronizer.notifyUpdateReceived(this.dsiAttribute, airconAirVolume.getAirVolume());
        Object object = this.mutex;
        synchronized (object) {
            this.airVolume = airconAirVolume.getAirVolume();
            this.airVolumeAuto = airconAirVolume.getAirVolumeAuto();
        }
    }
}

