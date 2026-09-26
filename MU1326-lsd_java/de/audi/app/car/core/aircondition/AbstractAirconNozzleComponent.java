/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$1;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$2;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$3;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AirconR1CenterNozzleController;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AirconR1CenterNozzleListener;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;
import de.audi.app.car.core.aircondition.nozzle.IAirconNozzle;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public abstract class AbstractAirconNozzleComponent
extends AbstractDSICarAirConditionAdapter
implements IAirconNozzle {
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    private static final AbstractAirconNozzleComponent$AbstractSectorDefinition SECTOR_DEFINITION_POSITION_X;
    private static final AbstractAirconNozzleComponent$AbstractSectorDefinition SECTOR_DEFINITION_POSITION_Y;
    private static final AbstractAirconNozzleComponent$AbstractSectorDefinition SECTOR_DEFINITION_AIRFLOW;
    protected static final int INVALID;
    protected static final int DISABLED;
    protected static final int ENABLED;
    protected final AbstractAirconNozzleComponent$AirconR1CenterNozzleController airconR1CenterNozzleController;
    protected volatile AirconMasterViewOptions currentViewOptionsMaster;
    protected volatile AirconRowViewOptions currentViewOptionsRow1;
    protected volatile boolean systemOnOff;
    protected volatile boolean airconR1CenterNozzleOnOffState = false;
    protected boolean isNozzleOnOffStateInverted = false;
    private final AbstractAirconNozzleComponent$AirconR1CenterNozzleListener airconR1CenterNozzleListener;

    public AbstractAirconNozzleComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AirCondition");
        this.setLogChannelDSI(true);
        this.setLogChannelMSC(true);
        this.airconR1CenterNozzleListener = new AbstractAirconNozzleComponent$AirconR1CenterNozzleListener(this, null);
        this.airconR1CenterNozzleController = new AbstractAirconNozzleComponent$AirconR1CenterNozzleController(this);
    }

    private AirconRowViewOptions getCurrentViewOptions(int n) {
        AirconRowViewOptions airconRowViewOptions;
        switch (n) {
            case 1: {
                airconRowViewOptions = this.currentViewOptionsRow1;
                break;
            }
            default: {
                airconRowViewOptions = null;
            }
        }
        return airconRowViewOptions;
    }

    private void itemSelectedCenterNozzleOnOffCtrl(int n, boolean bl) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#itemSelectedCenterNozzleStyleCtrl] row='%1', on='%2'", (Object)new Integer(n), (Object)(bl ? "true" : "false"));
        }
        if (1 == n) {
            if (bl) {
                this.airconR1CenterNozzleController.openAndRestoreSettings();
            } else {
                this.airconR1CenterNozzleController.close();
            }
        }
    }

    private void itemSelectedCenterNozzleStyleCtrl(int n, int n2) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#itemSelectedCenterNozzleStyleCtrl] uniqueNozzleID='%1', style='%2'", (long)n, (long)n2);
        }
        this.airconR1CenterNozzleController.setStyle(n, n2);
    }

    private void keyPressedCenterNozzleSetPositionCtrl(int n) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#keyPressedCenterNozzleSetPositionCtrl] uniqueNozzleID='%1'", (long)n);
        }
        this.airconR1CenterNozzleController.requestPositionCtrl(n);
    }

    private void keyReleasedCenterNozzleSetPositionCtrl(int n) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#keyReleasedCenterNozzleSetPositionCtrl] uniqueNozzleID='%1'", (long)n);
        }
        this.airconR1CenterNozzleController.releasePositionCtrl(n);
    }

    private void decrementCenterNozzleAirflow(int n, int n2) {
        AirconNozzleCtrl airconNozzleCtrl;
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#decrementCenterNozzleAirflow] uniqueNozzleID='%1', steps='%2'", (long)n, (long)n2);
        }
        if (null != (airconNozzleCtrl = this.airconR1CenterNozzleController.getNozzleCtrlByID(n))) {
            int n3 = AbstractAirconNozzleComponent.clip(airconNozzleCtrl.getAirflowModel().getValue() - n2, 0, 100);
            this.airconR1CenterNozzleController.setAirflow(n, n3, true);
            airconNozzleCtrl.setAirflow(n3, true, true);
        }
    }

    private void incrementCenterNozzleAirflow(int n, int n2) {
        AirconNozzleCtrl airconNozzleCtrl;
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#incrementCenterNozzleAirflow] uniqueNozzleID='%1', steps='%2'", (long)n, (long)n2);
        }
        if (null != (airconNozzleCtrl = this.airconR1CenterNozzleController.getNozzleCtrlByID(n))) {
            int n3 = AbstractAirconNozzleComponent.clip(airconNozzleCtrl.getAirflowModel().getValue() + n2, 0, 100);
            this.airconR1CenterNozzleController.setAirflow(n, n3, true);
            airconNozzleCtrl.setAirflow(n3, true, true);
        }
    }

    private void setValueHitCenterNozzlePosition(int n, int n2, int n3) {
        AirconNozzleCtrl airconNozzleCtrl;
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "[AbstractAirconNozzleComponent#setValueHitCenterNozzlePosition] uniqueNozzleID='%1', stepsX='%2', stepsY='%3'", (long)n, (long)n2, (long)n3);
        }
        if (null != (airconNozzleCtrl = this.airconR1CenterNozzleController.getNozzleCtrlByID(n))) {
            int n4 = AbstractAirconNozzleComponent.clip(n3, -100, 100);
            int n5 = AbstractAirconNozzleComponent.clip(n2, -100, 100);
            this.airconR1CenterNozzleController.setPosition(n, n4, n5, true);
        }
    }

    @Override
    public String getName() {
        return "AirCondition Nozzle Control";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{152, 107, 96, 99})};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Master: ");
        buffer.append(null == this.currentViewOptionsMaster ? "No master view options received yet" : this.currentViewOptionsMaster.toString());
        buffer.append("\n");
        buffer.append("Row 1: ");
        buffer.append(null == this.currentViewOptionsRow1 ? "No row (1) view options received yet" : this.currentViewOptionsRow1.toString());
        return buffer.toString();
    }

    @Override
    protected void initModels() {
        this.airconR1CenterNozzleController.initModels();
    }

    @Override
    protected void deinitModels() {
        this.airconR1CenterNozzleController.deinitModels();
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconNozzleComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptionsMaster);
            this.primaryAttributeReceived(0, 92);
        }
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAirconNozzleComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow1 = airconRowViewOptions;
            this.updateMenuEntryVisibility(1, this.currentViewOptionsRow1);
            this.primaryAttributeReceived(0, 93);
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] acknowledgeAirconNozzleControlRow1 | open='%1', close='%2'", bl, bl2);
        }
        if (bl != bl2) {
            if (bl) {
                this.airconR1CenterNozzleOnOffState = true;
                this.getChoiceModel(623839488).setValue(this.isNozzleOnOffStateInverted ? 0 : 1);
            }
            if (bl2) {
                this.airconR1CenterNozzleOnOffState = false;
                this.getChoiceModel(623839488).setValue(this.isNozzleOnOffStateInverted ? 1 : 0);
            }
        }
    }

    @Override
    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] responseAirconNozzleListRow1 | header='%1'", (Object)(null == carArrayListUpdateInfo ? "null" : carArrayListUpdateInfo.toString()));
        }
        if (null != carArrayListUpdateInfo && 0 < airconNozzleListRecordArray.length) {
            this.airconR1CenterNozzleController.responseAirconNozzleList(carArrayListUpdateInfo, airconNozzleListRecordArray);
        }
    }

    @Override
    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateAirconSystemOnOffRow1 | systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.systemOnOff = bl;
            this.notifySystemOnOff(1, bl);
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if (1 == n) {
            if (this.getLogChannel(1).isInfo()) {
                this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateAirconNozzleListUpdateInfoRow1 | listUpdateInfo='%1', pos='%2', validFlag='%3'", (Object)carArrayListUpdateInfo, (Object)nArray, (long)n);
            }
            this.airconR1CenterNozzleController.updateAirconNozzleListUpdateInfo(carArrayListUpdateInfo, nArray);
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow1(int n, int n2) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateAirconNozzleListTotalNumberOfElementsRow1 | numberOfElements='%1', validFlag='%2'", (long)n, (long)n2);
        }
        if (1 == n2) {
            this.airconR1CenterNozzleController.updateTotalNumberOfElements(n);
        }
    }

    @Override
    public void updateAirconNozzleStatusRow1(boolean bl, int n) {
        if (1 == n) {
            if (this.getLogChannel(1).isInfo()) {
                this.getLogChannel(1).log(1078071040, "[HMI|<<---|DSI] updateAirconNozzleStatusRow1 | state='%1', validFlag='%2'", bl, (long)n);
            }
            this.airconR1CenterNozzleOnOffState = bl;
            boolean bl2 = this.isNozzleOnOffStateInverted ? !bl : bl;
            this.getChoiceModel(623839488).setValue(bl2 ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
    }

    protected abstract void updateMenuEntryVisibility(int n, AirconRowViewOptions airconRowViewOptions) {
    }

    protected abstract void notifySystemOnOff(int n, boolean bl) {
    }

    static /* synthetic */ AirconRowViewOptions access$000(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getCurrentViewOptions(n);
    }

    static /* synthetic */ void access$100(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n, boolean bl) {
        abstractAirconNozzleComponent.itemSelectedCenterNozzleOnOffCtrl(n, bl);
    }

    static /* synthetic */ void access$200(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n, int n2) {
        abstractAirconNozzleComponent.itemSelectedCenterNozzleStyleCtrl(n, n2);
    }

    static /* synthetic */ void access$300(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        abstractAirconNozzleComponent.keyPressedCenterNozzleSetPositionCtrl(n);
    }

    static /* synthetic */ void access$400(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n, int n2) {
        abstractAirconNozzleComponent.decrementCenterNozzleAirflow(n, n2);
    }

    static /* synthetic */ void access$500(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n, int n2) {
        abstractAirconNozzleComponent.incrementCenterNozzleAirflow(n, n2);
    }

    static /* synthetic */ void access$600(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        abstractAirconNozzleComponent.keyReleasedCenterNozzleSetPositionCtrl(n);
    }

    static /* synthetic */ void access$700(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n, int n2, int n3) {
        abstractAirconNozzleComponent.setValueHitCenterNozzlePosition(n, n2, n3);
    }

    static /* synthetic */ AbstractAirconNozzleComponent$AirconR1CenterNozzleListener access$800(AbstractAirconNozzleComponent abstractAirconNozzleComponent) {
        return abstractAirconNozzleComponent.airconR1CenterNozzleListener;
    }

    static /* synthetic */ ChoiceModelApp access$900(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$1000(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$1100(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ ButtonModelApp access$1200(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$1300(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$1400(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$1500(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$1600(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$1700(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$1800(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$1900(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$2000(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$2100(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ ButtonModelApp access$2200(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$2300(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$2400(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$2500(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$2600(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$2700(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$2800(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$2900(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3000(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3100(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$3200(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ ButtonModelApp access$3300(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$3400(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$3500(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3600(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getChoiceModel(n);
    }

    static /* synthetic */ RangeModelApp access$3700(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRangeModel(n);
    }

    static /* synthetic */ ButtonModelApp access$3800(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$3900(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getButtonModel(n);
    }

    static /* synthetic */ RangeModel2DApp access$4000(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        return abstractAirconNozzleComponent.getRange2DModel(n);
    }

    static /* synthetic */ AbstractAirconNozzleComponent$AbstractSectorDefinition access$4100() {
        return SECTOR_DEFINITION_POSITION_X;
    }

    static /* synthetic */ AbstractAirconNozzleComponent$AbstractSectorDefinition access$4200() {
        return SECTOR_DEFINITION_POSITION_Y;
    }

    static /* synthetic */ AbstractAirconNozzleComponent$AbstractSectorDefinition access$4300() {
        return SECTOR_DEFINITION_AIRFLOW;
    }

    static {
        SECTOR_DEFINITION_POSITION_X = new AbstractAirconNozzleComponent$1();
        SECTOR_DEFINITION_POSITION_Y = new AbstractAirconNozzleComponent$2();
        SECTOR_DEFINITION_AIRFLOW = new AbstractAirconNozzleComponent$3();
    }
}

