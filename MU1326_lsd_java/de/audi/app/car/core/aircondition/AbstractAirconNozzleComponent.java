/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.adapter.AbstractDSICarAirConditionAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;
import de.audi.app.car.core.aircondition.nozzle.IAirconNozzle;
import de.audi.app.car.core.aircondition.nozzle.IAirconNozzleState;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.RangeListener2D;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.global.CarArrayListTransmittableElements;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public abstract class AbstractAirconNozzleComponent
extends AbstractDSICarAirConditionAdapter
implements IAirconNozzle {
    public static final short CODING_ID = 8;
    public static final String LOGCHANNEL_NAME = "App.Car.AirCondition";
    private static final AbstractSectorDefinition SECTOR_DEFINITION_POSITION_X = new AbstractSectorDefinition(){

        public AbstractSectorDefinition.Sector[] getSectorDefinition() {
            return new AbstractSectorDefinition.Sector[]{new AbstractSectorDefinition.Sector(0, -100, -100, -83), new AbstractSectorDefinition.Sector(1, -66, -82, -50), new AbstractSectorDefinition.Sector(2, -33, -49, -17), new AbstractSectorDefinition.Sector(3, 0, -16, 16), new AbstractSectorDefinition.Sector(4, 33, 17, 49), new AbstractSectorDefinition.Sector(5, 66, 50, 82), new AbstractSectorDefinition.Sector(6, 100, 83, 100)};
        }
    };
    private static final AbstractSectorDefinition SECTOR_DEFINITION_POSITION_Y = new AbstractSectorDefinition(){

        public AbstractSectorDefinition.Sector[] getSectorDefinition() {
            return new AbstractSectorDefinition.Sector[]{new AbstractSectorDefinition.Sector(0, -100, -100, -76), new AbstractSectorDefinition.Sector(1, -50, -75, -26), new AbstractSectorDefinition.Sector(3, 0, -25, 25), new AbstractSectorDefinition.Sector(5, 50, 26, 75), new AbstractSectorDefinition.Sector(6, 100, 76, 100)};
        }
    };
    private static final AbstractSectorDefinition SECTOR_DEFINITION_AIRFLOW = new AbstractSectorDefinition(){

        public AbstractSectorDefinition.Sector[] getSectorDefinition() {
            return new AbstractSectorDefinition.Sector[]{new AbstractSectorDefinition.Sector(0, 0, 0, 12), new AbstractSectorDefinition.Sector(1, 25, 13, 37), new AbstractSectorDefinition.Sector(2, 50, 38, 62), new AbstractSectorDefinition.Sector(3, 75, 63, 87), new AbstractSectorDefinition.Sector(4, 100, 88, 100)};
        }
    };
    protected static final int INVALID = -1;
    protected static final int DISABLED = 0;
    protected static final int ENABLED = 1;
    protected final AirconR1CenterNozzleController airconR1CenterNozzleController;
    protected volatile AirconMasterViewOptions currentViewOptionsMaster;
    protected volatile AirconRowViewOptions currentViewOptionsRow1;
    protected volatile boolean systemOnOff;
    protected volatile boolean airconR1CenterNozzleOnOffState = false;
    protected boolean isNozzleOnOffStateInverted = false;
    private final AirconR1CenterNozzleListener airconR1CenterNozzleListener;

    public AbstractAirconNozzleComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.setLogChannelDSI(true);
        this.setLogChannelMSC(true);
        this.airconR1CenterNozzleListener = new AirconR1CenterNozzleListener();
        this.airconR1CenterNozzleController = new AirconR1CenterNozzleController();
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
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#itemSelectedCenterNozzleStyleCtrl] row='%1', on='%2'", (Object)new Integer(n), (Object)(bl ? "true" : "false"));
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
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#itemSelectedCenterNozzleStyleCtrl] uniqueNozzleID='%1', style='%2'", (long)n, (long)n2);
        }
        this.airconR1CenterNozzleController.setStyle(n, n2);
    }

    private void keyPressedCenterNozzleSetPositionCtrl(int n) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#keyPressedCenterNozzleSetPositionCtrl] uniqueNozzleID='%1'", (long)n);
        }
        this.airconR1CenterNozzleController.requestPositionCtrl(n);
    }

    private void keyReleasedCenterNozzleSetPositionCtrl(int n) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#keyReleasedCenterNozzleSetPositionCtrl] uniqueNozzleID='%1'", (long)n);
        }
        this.airconR1CenterNozzleController.releasePositionCtrl(n);
    }

    private void decrementCenterNozzleAirflow(int n, int n2) {
        AirconNozzleCtrl airconNozzleCtrl;
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#decrementCenterNozzleAirflow] uniqueNozzleID='%1', steps='%2'", (long)n, (long)n2);
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
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#incrementCenterNozzleAirflow] uniqueNozzleID='%1', steps='%2'", (long)n, (long)n2);
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
            this.getLogChannel().log(10000000, "[AbstractAirconNozzleComponent#setValueHitCenterNozzlePosition] uniqueNozzleID='%1', stepsX='%2', stepsY='%3'", (long)n, (long)n2, (long)n3);
        }
        if (null != (airconNozzleCtrl = this.airconR1CenterNozzleController.getNozzleCtrlByID(n))) {
            int n4 = AbstractAirconNozzleComponent.clip(n3, -100, 100);
            int n5 = AbstractAirconNozzleComponent.clip(n2, -100, 100);
            this.airconR1CenterNozzleController.setPosition(n, n4, n5, true);
        }
    }

    public String getName() {
        return "AirCondition Nozzle Control";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{92, 93}, new int[]{152, 107, 96, 99})};
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append("Master: ");
        buffer.append(null == this.currentViewOptionsMaster ? "No master view options received yet" : this.currentViewOptionsMaster.toString());
        buffer.append("\n");
        buffer.append("Row 1: ");
        buffer.append(null == this.currentViewOptionsRow1 ? "No row (1) view options received yet" : this.currentViewOptionsRow1.toString());
        return buffer.toString();
    }

    protected void initModels() {
        this.airconR1CenterNozzleController.initModels();
    }

    protected void deinitModels() {
        this.airconR1CenterNozzleController.deinitModels();
    }

    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconNozzleComponent#updateAirconViewOptionsMaster] airconMasterViewOptions='%1', valid='%2'", (Object)(null != airconMasterViewOptions ? this.formatViewOptionsLog(airconMasterViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconMasterViewOptions) {
            this.currentViewOptionsMaster = airconMasterViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptionsMaster);
            this.primaryAttributeReceived(0, 92);
        }
    }

    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAirconNozzleComponent#updateAirconViewOptionsRow1] airconRowViewOptions='%1', valid='%2'", (Object)(null != airconRowViewOptions ? this.formatViewOptionsLog(airconRowViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != airconRowViewOptions) {
            this.currentViewOptionsRow1 = airconRowViewOptions;
            this.updateMenuEntryVisibility(1, this.currentViewOptionsRow1);
            this.primaryAttributeReceived(0, 93);
        }
    }

    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] acknowledgeAirconNozzleControlRow1 | open='%1', close='%2'", bl, bl2);
        }
        if (bl != bl2) {
            if (bl) {
                this.airconR1CenterNozzleOnOffState = true;
                this.getChoiceModel(601893).setValue(this.isNozzleOnOffStateInverted ? 0 : 1);
            }
            if (bl2) {
                this.airconR1CenterNozzleOnOffState = false;
                this.getChoiceModel(601893).setValue(this.isNozzleOnOffStateInverted ? 1 : 0);
            }
        }
    }

    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] responseAirconNozzleListRow1 | header='%1'", (Object)(null == carArrayListUpdateInfo ? "null" : carArrayListUpdateInfo.toString()));
        }
        if (null != carArrayListUpdateInfo && 0 < airconNozzleListRecordArray.length) {
            this.airconR1CenterNozzleController.responseAirconNozzleList(carArrayListUpdateInfo, airconNozzleListRecordArray);
        }
    }

    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateAirconSystemOnOffRow1 | systemOnOff='%1', valid='%2'", bl, (long)n);
        if (1 == n) {
            this.systemOnOff = bl;
            this.notifySystemOnOff(1, bl);
        }
    }

    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if (1 == n) {
            if (this.getLogChannel(1).isInfo()) {
                this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateAirconNozzleListUpdateInfoRow1 | listUpdateInfo='%1', pos='%2', validFlag='%3'", (Object)carArrayListUpdateInfo, (Object)nArray, (long)n);
            }
            this.airconR1CenterNozzleController.updateAirconNozzleListUpdateInfo(carArrayListUpdateInfo, nArray);
        }
    }

    public void updateAirconNozzleListTotalNumberOfElementsRow1(int n, int n2) {
        if (this.getLogChannel(1).isInfo()) {
            this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateAirconNozzleListTotalNumberOfElementsRow1 | numberOfElements='%1', validFlag='%2'", (long)n, (long)n2);
        }
        if (1 == n2) {
            this.airconR1CenterNozzleController.updateTotalNumberOfElements(n);
        }
    }

    public void updateAirconNozzleStatusRow1(boolean bl, int n) {
        if (1 == n) {
            if (this.getLogChannel(1).isInfo()) {
                this.getLogChannel(1).log(1000000, "[HMI|<<---|DSI] updateAirconNozzleStatusRow1 | state='%1', validFlag='%2'", bl, (long)n);
            }
            this.airconR1CenterNozzleOnOffState = bl;
            boolean bl2 = this.isNozzleOnOffStateInverted ? !bl : bl;
            this.getChoiceModel(601893).setValue(bl2 ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(AirconMasterViewOptions var1);

    protected abstract void updateMenuEntryVisibility(int var1, AirconRowViewOptions var2);

    protected abstract void notifySystemOnOff(int var1, boolean var2);

    public static abstract class AbstractSectorDefinition {
        public abstract Sector[] getSectorDefinition();

        public Sector getSector(int n) {
            Sector[] sectorArray = this.getSectorDefinition();
            Sector sector = null;
            for (int i2 = 0; i2 < sectorArray.length; ++i2) {
                if (n < sectorArray[i2].getLowerBorder() || n > sectorArray[i2].getUpperBoarder()) continue;
                sector = new Sector(sectorArray[i2].getUniqueID(), sectorArray[i2].getRepresentative(), sectorArray[i2].getLowerBorder(), sectorArray[i2].getUpperBoarder());
                break;
            }
            return sector;
        }

        public class Sector {
            public static final int INVALID_SECTOR = -1;
            private static final int LOWER_BORDER_INDEX = 0;
            private static final int UPPER_BORDER_INDEX = 1;
            private final int uniqueID;
            private final int representative;
            private final int[] range;

            public Sector(int n, int n2, int n3, int n4) {
                this.uniqueID = n;
                this.representative = n2;
                this.range = new int[]{n3, n4};
            }

            public int getUniqueID() {
                return this.uniqueID;
            }

            public int getRepresentative() {
                return this.representative;
            }

            public int getLowerBorder() {
                return this.range[0];
            }

            public int getUpperBoarder() {
                return this.range[1];
            }
        }
    }

    protected class AirconNozzleArrayHandler {
        public static final int FULL_RANGE_UPDATE_START_ELEMENT = 0;
        public static final int FULL_RANGE_UPDATE_NUM_OF_ELEMENTS = -1;
        private final int dsiRow;
        private int currentTransactionID = 0;
        private int totalNumberOfElements = 0;
        private int numOfTransmittedElements = 0;
        private volatile AirconNozzleListRecord[] currentArray = new AirconNozzleListRecord[0];

        public AirconNozzleArrayHandler(int n) {
            this.dsiRow = n;
        }

        public int getNewTransactionID() {
            this.currentTransactionID = this.getNextTransactionID(this.currentTransactionID);
            return this.currentTransactionID;
        }

        public int getNextTransactionID(int n) {
            return 0 >= n || 15 <= n ? 1 : n + 1;
        }

        public int getTotalNumberOfElements() {
            return this.totalNumberOfElements;
        }

        public void setTotalNumberOfElements(int n) {
            this.totalNumberOfElements = 0 < n ? n : 0;
            this.currentArray = new AirconNozzleListRecord[this.totalNumberOfElements];
        }

        public void sendSetGetArray(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
            if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconNozzleArrayHandler#sendSetGetArray] row='%1'", (Object)new Integer(this.dsiRow));
            }
            switch (this.dsiRow) {
                case 1: {
                    AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (SetGetArray) setAirconNozzleListRow | row='%1', header='%2', data='%3'", (Object)new Integer(1), (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
                    AbstractAirconNozzleComponent.this.getDSI().setAirconNozzleListRow(1, carArrayListUpdateInfo, airconNozzleListRecordArray);
                    break;
                }
                case 2: {
                    AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (SetGetArray) setAirconNozzleListRow | row='%1', header='%2', data='%3'", (Object)new Integer(2), (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
                    AbstractAirconNozzleComponent.this.getDSI().setAirconNozzleListRow(2, carArrayListUpdateInfo, airconNozzleListRecordArray);
                    break;
                }
                case 4: {
                    AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (SetGetArray) setAirconNozzleListRow | row='%1', header='%2', data='%3'", (Object)new Integer(4), (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
                    AbstractAirconNozzleComponent.this.getDSI().setAirconNozzleListRow(4, carArrayListUpdateInfo, airconNozzleListRecordArray);
                    break;
                }
                default: {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconNozzleArrayHandler#sendSetGetArray] Unsupported row: 1%. Request ignored.", (long)this.dsiRow);
                    return;
                }
            }
        }

        public void sendGetArray(CarArrayListUpdateInfo carArrayListUpdateInfo) {
            if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconNozzleArrayHandler#sendGetArray] row='%1'", (Object)new Integer(this.dsiRow));
            }
            switch (this.dsiRow) {
                case 1: {
                    AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (GetArray) requestAirconNozzleListRow | row='%1', header='%2'", (Object)new Integer(1), (Object)carArrayListUpdateInfo);
                    AbstractAirconNozzleComponent.this.getDSI().requestAirconNozzleListRow(1, carArrayListUpdateInfo);
                    break;
                }
                case 2: {
                    AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (GetArray) requestAirconNozzleListRow | row='%1', header='%2'", (Object)new Integer(2), (Object)carArrayListUpdateInfo);
                    AbstractAirconNozzleComponent.this.getDSI().requestAirconNozzleListRow(2, carArrayListUpdateInfo);
                    break;
                }
                case 4: {
                    AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|--->>|DSI] (GetArray) requestAirconNozzleListRow | row='%1', header='%2'", (Object)new Integer(4), (Object)carArrayListUpdateInfo);
                    AbstractAirconNozzleComponent.this.getDSI().requestAirconNozzleListRow(4, carArrayListUpdateInfo);
                    break;
                }
                default: {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconNozzleArrayHandler#sendGetArray] Unsupported row: 1%. Request ignored.", (long)this.dsiRow);
                    return;
                }
            }
        }

        public void receivedStatusArray(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
            AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|<<---|DSI] (StatusArray) responseAirconNozzleList | header='%1', data'%2'", (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
            if (null != carArrayListUpdateInfo) {
                if (this.isValidASGID(carArrayListUpdateInfo.asgID)) {
                    this.decodeStatusArray(carArrayListUpdateInfo, airconNozzleListRecordArray);
                } else {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconNozzleArrayHandler#receivedStatusArray] ASG_ID='%1'. Response ignored.", (long)carArrayListUpdateInfo.asgID);
                }
            }
        }

        public void receivedChangedArray(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray) {
            AbstractAirconNozzleComponent.this.getLogChannel(2).log(1000000, "[HMI|<<---|DSI] (ChangedArray) updateAirconNozzleListUpdateInfoRow1 | header='%1', listOfPos=''", (Object)carArrayListUpdateInfo, (Object)nArray);
            if (null != carArrayListUpdateInfo) {
                if (this.isValidASGID(carArrayListUpdateInfo.asgID)) {
                    this.decodeChangedArray(carArrayListUpdateInfo, nArray);
                } else {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconNozzleArrayHandler#receivedChangedArray] ASG_ID='%1'. Update ignored.", (long)carArrayListUpdateInfo.asgID);
                }
            }
        }

        public AirconNozzleListCapabilities getCapabilitiesByRecordAddress(int n) {
            AirconNozzleListCapabilities airconNozzleListCapabilities = new AirconNozzleListCapabilities();
            switch (n) {
                case 0: {
                    return airconNozzleListCapabilities;
                }
                case 1: {
                    airconNozzleListCapabilities.horizontalPosition = true;
                    airconNozzleListCapabilities.verticalPosition = true;
                    airconNozzleListCapabilities.airflow = true;
                    airconNozzleListCapabilities.style = true;
                    airconNozzleListCapabilities.intervalHorizontal = true;
                    airconNozzleListCapabilities.intervalVertical = true;
                    return airconNozzleListCapabilities;
                }
                case 2: {
                    airconNozzleListCapabilities.horizontalPosition = true;
                    airconNozzleListCapabilities.verticalPosition = true;
                    airconNozzleListCapabilities.airflow = true;
                    airconNozzleListCapabilities.style = true;
                    return airconNozzleListCapabilities;
                }
                case 3: {
                    airconNozzleListCapabilities.horizontalPosition = true;
                    airconNozzleListCapabilities.verticalPosition = true;
                    return airconNozzleListCapabilities;
                }
                case 4: {
                    airconNozzleListCapabilities.horizontalPosition = true;
                    return airconNozzleListCapabilities;
                }
                case 5: {
                    airconNozzleListCapabilities.verticalPosition = true;
                    return airconNozzleListCapabilities;
                }
                case 6: {
                    airconNozzleListCapabilities.airflow = true;
                    return airconNozzleListCapabilities;
                }
                case 7: {
                    airconNozzleListCapabilities.style = true;
                    return airconNozzleListCapabilities;
                }
                case 8: {
                    airconNozzleListCapabilities.intervalHorizontal = true;
                    return airconNozzleListCapabilities;
                }
                case 9: {
                    airconNozzleListCapabilities.intervalVertical = true;
                    return airconNozzleListCapabilities;
                }
                case 10: {
                    airconNozzleListCapabilities.horizontalPosition = true;
                    airconNozzleListCapabilities.verticalPosition = true;
                    airconNozzleListCapabilities.airflow = true;
                    return airconNozzleListCapabilities;
                }
                case 11: {
                    return airconNozzleListCapabilities;
                }
                case 12: {
                    return airconNozzleListCapabilities;
                }
                case 13: {
                    return airconNozzleListCapabilities;
                }
                case 14: {
                    return airconNozzleListCapabilities;
                }
                case 15: {
                    return airconNozzleListCapabilities;
                }
            }
            return airconNozzleListCapabilities;
        }

        public boolean isValidASGID(int n) {
            return 9 == n || 0 == n || 1 == n;
        }

        public boolean isValidData(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
            if (null != carArrayListUpdateInfo && null != airconNozzleListRecordArray && carArrayListUpdateInfo.numOfElements == airconNozzleListRecordArray.length) {
                switch (carArrayListUpdateInfo.recordContent) {
                    case 2: {
                        return true;
                    }
                }
                return true;
            }
            return false;
        }

        private boolean isForwardRequestRequired(int n) {
            return 0 <= n && 0 < this.getTotalNumberOfElements() - this.numOfTransmittedElements;
        }

        private void decodeStatusArray(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
            int n;
            if (carArrayListUpdateInfo.numOfElements != airconNozzleListRecordArray.length) {
                AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconR1CenterNozzleController#decodeStatusArray] Data mismatch: header.numOfElements='%1', data.length='%2'", (long)carArrayListUpdateInfo.numOfElements, (long)airconNozzleListRecordArray.length);
            }
            int n2 = -1;
            for (n = 0; n < airconNozzleListRecordArray.length; ++n) {
                AirconNozzleListRecord airconNozzleListRecord = airconNozzleListRecordArray[n];
                if (null != airconNozzleListRecord) {
                    ++this.numOfTransmittedElements;
                    n2 = airconNozzleListRecord.getPos();
                    continue;
                }
                AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconR1CenterNozzleController#decodeStatusArray] data element 'null'.");
            }
            if (this.isForwardRequestRequired(n2)) {
                int n3;
                n = this.getTotalNumberOfElements() - (n2 + 1);
                if (0 < n && 0 < (n3 = this.getMaxTransmittableElements(carArrayListUpdateInfo.getRecordContent()))) {
                    CarArrayListUpdateInfo carArrayListUpdateInfo2 = new CarArrayListUpdateInfo();
                    carArrayListUpdateInfo2.asgID = 1;
                    carArrayListUpdateInfo2.transactionID = this.getNewTransactionID();
                    carArrayListUpdateInfo2.recordContent = 2;
                    carArrayListUpdateInfo2.arrayContent = 3;
                    carArrayListUpdateInfo2.startElement = n2;
                    carArrayListUpdateInfo2.numOfElements = n <= n3 ? n : n3;
                    this.sendGetArray(carArrayListUpdateInfo2);
                }
            } else {
                this.numOfTransmittedElements = 0;
            }
        }

        private void decodeChangedArray(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray) {
            if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#decodeChangedArray] dsiRow='%1', header='%2'", (Object)new Integer(this.dsiRow), (Object)(carArrayListUpdateInfo == null ? "null" : carArrayListUpdateInfo.toString()));
            }
            if ((1 == this.dsiRow || 2 == this.dsiRow || 4 == this.dsiRow) && null != carArrayListUpdateInfo && null != AbstractAirconNozzleComponent.this.currentViewOptionsRow1 && null != AbstractAirconNozzleComponent.this.currentViewOptionsRow1.getConfiguration()) {
                if (0 == carArrayListUpdateInfo.recordContent && 0 == carArrayListUpdateInfo.getStartElement() && -1 == carArrayListUpdateInfo.getNumOfElements()) {
                    int n = this.getMaxTransmittableElements(carArrayListUpdateInfo.getRecordContent());
                    if (0 < n) {
                        CarArrayListUpdateInfo carArrayListUpdateInfo2 = new CarArrayListUpdateInfo();
                        carArrayListUpdateInfo2.asgID = 1;
                        carArrayListUpdateInfo2.transactionID = this.getNewTransactionID();
                        carArrayListUpdateInfo2.recordContent = 2;
                        carArrayListUpdateInfo2.arrayContent = 1;
                        carArrayListUpdateInfo2.startElement = 0;
                        carArrayListUpdateInfo2.numOfElements = n;
                        this.sendGetArray(carArrayListUpdateInfo2);
                    }
                } else if (1 == carArrayListUpdateInfo.getArrayContent() || 3 == carArrayListUpdateInfo.getArrayContent()) {
                    int n = this.getMaxTransmittableElements(carArrayListUpdateInfo.getRecordContent());
                    if (0 < n) {
                        CarArrayListUpdateInfo carArrayListUpdateInfo3 = new CarArrayListUpdateInfo();
                        carArrayListUpdateInfo3.asgID = 1;
                        carArrayListUpdateInfo3.transactionID = this.getNewTransactionID();
                        carArrayListUpdateInfo3.recordContent = carArrayListUpdateInfo.getRecordContent();
                        carArrayListUpdateInfo3.arrayContent = carArrayListUpdateInfo.getArrayContent();
                        carArrayListUpdateInfo3.startElement = carArrayListUpdateInfo.getStartElement();
                        carArrayListUpdateInfo3.numOfElements = carArrayListUpdateInfo.getNumOfElements() <= n ? carArrayListUpdateInfo.getNumOfElements() : n;
                        this.sendGetArray(carArrayListUpdateInfo3);
                    }
                } else {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#decodeChangedArray] ChangedArray not supported.");
                }
            }
        }

        private int getMaxTransmittableElements(int n) {
            int n2;
            AirconRowViewOptions airconRowViewOptions = AbstractAirconNozzleComponent.this.getCurrentViewOptions(this.dsiRow);
            if (null != airconRowViewOptions && null != airconRowViewOptions.getConfiguration()) {
                CarArrayListTransmittableElements carArrayListTransmittableElements = airconRowViewOptions.getConfiguration().getNozzleListTransmittableElements();
                switch (n) {
                    case 0: {
                        n2 = carArrayListTransmittableElements.getRa0();
                        break;
                    }
                    case 1: {
                        n2 = carArrayListTransmittableElements.getRa1();
                        break;
                    }
                    case 2: {
                        n2 = carArrayListTransmittableElements.getRa2();
                        break;
                    }
                    case 3: {
                        n2 = carArrayListTransmittableElements.getRa3();
                        break;
                    }
                    case 4: {
                        n2 = carArrayListTransmittableElements.getRa4();
                        break;
                    }
                    case 5: {
                        n2 = carArrayListTransmittableElements.getRa5();
                        break;
                    }
                    case 6: {
                        n2 = carArrayListTransmittableElements.getRa6();
                        break;
                    }
                    case 7: {
                        n2 = carArrayListTransmittableElements.getRa7();
                        break;
                    }
                    case 8: {
                        n2 = carArrayListTransmittableElements.getRa8();
                        break;
                    }
                    case 9: {
                        n2 = carArrayListTransmittableElements.getRa9();
                        break;
                    }
                    case 10: {
                        n2 = carArrayListTransmittableElements.getRaA();
                        break;
                    }
                    case 11: {
                        n2 = carArrayListTransmittableElements.getRaB();
                        break;
                    }
                    case 12: {
                        n2 = carArrayListTransmittableElements.getRaC();
                        break;
                    }
                    case 13: {
                        n2 = carArrayListTransmittableElements.getRaD();
                        break;
                    }
                    case 14: {
                        n2 = carArrayListTransmittableElements.getRaE();
                        break;
                    }
                    case 15: {
                        n2 = carArrayListTransmittableElements.getRaF();
                        break;
                    }
                    default: {
                        n2 = 0;
                        break;
                    }
                }
            } else {
                n2 = 0;
            }
            return n2;
        }

        private String arrayDataToString(AirconNozzleListRecord[] airconNozzleListRecordArray) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < airconNozzleListRecordArray.length; ++i2) {
                buffer.append("[").append(i2).append("] ").append(airconNozzleListRecordArray[i2].toString());
            }
            return buffer.toString();
        }
    }

    private class AirconR1CenterNozzleListener
    implements ChoiceListener,
    RangeListener,
    RangeListener2D {
        private AirconR1CenterNozzleListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            boolean bl = n2 == 1;
            switch (n) {
                case 601893: {
                    AbstractAirconNozzleComponent.this.itemSelectedCenterNozzleOnOffCtrl(1, AbstractAirconNozzleComponent.this.isNozzleOnOffStateInverted ? !bl : bl);
                    break;
                }
                case 602419: {
                    AbstractAirconNozzleComponent.this.itemSelectedCenterNozzleStyleCtrl(1, n2);
                    break;
                }
                case 602369: {
                    AbstractAirconNozzleComponent.this.itemSelectedCenterNozzleStyleCtrl(2, n2);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void itemFocused(int n, int n2, int n3, int n4) {
        }

        public void keyPressed(int n, int n2, int n3) {
            switch (n) {
                case 602393: {
                    AbstractAirconNozzleComponent.this.keyPressedCenterNozzleSetPositionCtrl(1);
                    break;
                }
                case 602371: {
                    AbstractAirconNozzleComponent.this.keyPressedCenterNozzleSetPositionCtrl(2);
                    break;
                }
                case 602412: {
                    AbstractAirconNozzleComponent.this.decrementCenterNozzleAirflow(1, 100);
                    break;
                }
                case 602376: {
                    AbstractAirconNozzleComponent.this.incrementCenterNozzleAirflow(1, 100);
                    break;
                }
                case 602414: {
                    AbstractAirconNozzleComponent.this.decrementCenterNozzleAirflow(2, 100);
                    break;
                }
                case 602391: {
                    AbstractAirconNozzleComponent.this.incrementCenterNozzleAirflow(2, 100);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            switch (n) {
                case 602393: {
                    AirconNozzleCtrl airconNozzleCtrl = AbstractAirconNozzleComponent.this.airconR1CenterNozzleController.getNozzleCtrlByID(1);
                    if (null != airconNozzleCtrl) {
                        airconNozzleCtrl.setPosition(airconNozzleCtrl.getCurrentHorizontalPosition(), airconNozzleCtrl.getCurrentVerticalPosition(), true, true);
                    }
                    AbstractAirconNozzleComponent.this.keyReleasedCenterNozzleSetPositionCtrl(1);
                    break;
                }
                case 602371: {
                    AirconNozzleCtrl airconNozzleCtrl = AbstractAirconNozzleComponent.this.airconR1CenterNozzleController.getNozzleCtrlByID(2);
                    if (null != airconNozzleCtrl) {
                        airconNozzleCtrl.setPosition(airconNozzleCtrl.getCurrentHorizontalPosition(), airconNozzleCtrl.getCurrentVerticalPosition(), true, true);
                    }
                    AbstractAirconNozzleComponent.this.keyReleasedCenterNozzleSetPositionCtrl(2);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void keyTyped(int n, int n2, int n3) {
        }

        public void keyLongTyped(int n, int n2, int n3) {
        }

        public void decrement(int n, int n2, int n3) {
            switch (n) {
                case 601895: {
                    AbstractAirconNozzleComponent.this.decrementCenterNozzleAirflow(1, n2);
                    break;
                }
                case 602402: {
                    AbstractAirconNozzleComponent.this.decrementCenterNozzleAirflow(2, n2);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void increment(int n, int n2, int n3) {
            switch (n) {
                case 601895: {
                    AbstractAirconNozzleComponent.this.incrementCenterNozzleAirflow(1, n2);
                    break;
                }
                case 602402: {
                    AbstractAirconNozzleComponent.this.incrementCenterNozzleAirflow(2, n2);
                    break;
                }
                default: {
                    return;
                }
            }
        }

        public void setValueHit(int n, int n2, int n3, int n4) {
            switch (n) {
                case 602393: {
                    AbstractAirconNozzleComponent.this.setValueHitCenterNozzlePosition(1, n2, n3);
                    break;
                }
                case 602371: {
                    AbstractAirconNozzleComponent.this.setValueHitCenterNozzlePosition(2, n2, n3);
                    break;
                }
                default: {
                    return;
                }
            }
        }
    }

    protected class AirconR1CenterNozzleController {
        private final Object mutex = new Object();
        private final AirconNozzleArrayHandler arrayHandler = new AirconNozzleArrayHandler(1);
        private final Map nozzleMap = new HashMap();
        private final AirconNozzleCtrl nozzleR1CenterCtrlLeft;
        private final AirconNozzleCtrl nozzleR1CenterCtrlRight;
        private volatile int currentPositionCtrlResponsibility = -1;

        public AirconR1CenterNozzleController() {
            this.nozzleR1CenterCtrlLeft = new AirconNozzleCtrl(1, "NozzleR1CenterLeft", 1, 1, 2, 2, AbstractAirconNozzleComponent.this.getLogChannel());
            this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(0, true);
            this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(1, true);
            this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(2, true);
            this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(3, false);
            this.nozzleMap.put(new Integer(1), this.nozzleR1CenterCtrlLeft);
            this.nozzleR1CenterCtrlRight = new AirconNozzleCtrl(2, "NozzleR1CenterRight", 1, 2, 3, 2, AbstractAirconNozzleComponent.this.getLogChannel());
            this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(0, true);
            this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(1, true);
            this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(2, true);
            this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(3, false);
            this.nozzleMap.put(new Integer(2), this.nozzleR1CenterCtrlRight);
        }

        public void initModels() {
            AbstractAirconNozzleComponent.this.getChoiceModel(601893).setChoiceListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getRangeModel(601895).setLimits(0, 100, 1);
            AbstractAirconNozzleComponent.this.getRangeModel(601895).setRangeListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getButtonModel(602412).setButtonListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getButtonModel(602376).setButtonListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getRange2DModel(602393).setLimitsXY(-100, 100, -100, 100, 1, 1);
            AbstractAirconNozzleComponent.this.getRange2DModel(602393).setRangeListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getChoiceModel(602419).setChoiceListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            this.nozzleR1CenterCtrlLeft.setModels(AbstractAirconNozzleComponent.this.getRangeModel(601895), AbstractAirconNozzleComponent.this.getRange2DModel(602393), AbstractAirconNozzleComponent.this.getChoiceModel(602419));
            AbstractAirconNozzleComponent.this.getRangeModel(602402).setLimits(0, 100, 1);
            AbstractAirconNozzleComponent.this.getRangeModel(602402).setRangeListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getButtonModel(602414).setButtonListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getButtonModel(602391).setButtonListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getRange2DModel(602371).setLimitsXY(-100, 100, -100, 100, 1, 1);
            AbstractAirconNozzleComponent.this.getRange2DModel(602371).setRangeListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            AbstractAirconNozzleComponent.this.getChoiceModel(602369).setChoiceListener(AbstractAirconNozzleComponent.this.airconR1CenterNozzleListener);
            this.nozzleR1CenterCtrlRight.setModels(AbstractAirconNozzleComponent.this.getRangeModel(602402), AbstractAirconNozzleComponent.this.getRange2DModel(602371), AbstractAirconNozzleComponent.this.getChoiceModel(602369));
        }

        public void deinitModels() {
            AbstractAirconNozzleComponent.this.getChoiceModel(601893).resetListener();
            AbstractAirconNozzleComponent.this.getChoiceModel(602419).resetListener();
            AbstractAirconNozzleComponent.this.getRangeModel(601895).resetListener();
            AbstractAirconNozzleComponent.this.getButtonModel(602412).resetListener();
            AbstractAirconNozzleComponent.this.getButtonModel(602376).resetListener();
            AbstractAirconNozzleComponent.this.getRange2DModel(602393).resetListener();
            this.nozzleR1CenterCtrlLeft.setModels(null, null, null);
            AbstractAirconNozzleComponent.this.getChoiceModel(602369).resetListener();
            AbstractAirconNozzleComponent.this.getRangeModel(602402).resetListener();
            AbstractAirconNozzleComponent.this.getButtonModel(602414).resetListener();
            AbstractAirconNozzleComponent.this.getButtonModel(602391).resetListener();
            AbstractAirconNozzleComponent.this.getRange2DModel(602371).resetListener();
            this.nozzleR1CenterCtrlRight.setModels(null, null, null);
        }

        public final IAirconNozzleState getNozzleState(int n) {
            return this.getNozzleCtrlByID(n);
        }

        public final AirconNozzleCtrl getNozzleCtrlByID(int n) {
            return (AirconNozzleCtrl)this.nozzleMap.get(new Integer(n));
        }

        public final AirconNozzleCtrl getNozzleCtrlByLocation(int n, int n2) {
            Iterator iterator = this.nozzleMap.values().iterator();
            while (iterator.hasNext()) {
                AirconNozzleCtrl airconNozzleCtrl = (AirconNozzleCtrl)iterator.next();
                if (null == airconNozzleCtrl || n != airconNozzleCtrl.getHorizontalLocation() || n2 != airconNozzleCtrl.getVerticalLocation()) continue;
                return airconNozzleCtrl;
            }
            return null;
        }

        public final AirconNozzleCtrl getNozzleCtrlByPositionID(int n) {
            Iterator iterator = this.nozzleMap.values().iterator();
            while (iterator.hasNext()) {
                AirconNozzleCtrl airconNozzleCtrl = (AirconNozzleCtrl)iterator.next();
                if (null == airconNozzleCtrl || n != airconNozzleCtrl.getPos()) continue;
                return airconNozzleCtrl;
            }
            return null;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void openAndRestoreSettings() {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#openAndRestoreSettings] called.");
                }
                if (null != AbstractAirconNozzleComponent.this.getDSI()) {
                    AbstractAirconNozzleComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setAirconNozzleControlRow1(OPEN)");
                    AbstractAirconNozzleComponent.this.getDSI().setAirconNozzleControlRow1(2);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void close() {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#close] called.");
                }
                if (null != AbstractAirconNozzleComponent.this.getDSI()) {
                    AbstractAirconNozzleComponent.this.getLogChannel(1).log(1000000, "[HMI|--->>|DSI] setAirconNozzleControlRow1(CLOSE)");
                    AbstractAirconNozzleComponent.this.getDSI().setAirconNozzleControlRow1(1);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean requestPositionCtrl(int n) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#requestPositionCtrl] uniqueNozzleID='%1',", (long)n);
                }
                if (-1 == this.currentPositionCtrlResponsibility) {
                    this.currentPositionCtrlResponsibility = n;
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#requestPositionCtrl] Nozzle %1 is now in control.", (long)this.currentPositionCtrlResponsibility);
                    this.updatePositionCtrlResponsibility();
                    return true;
                }
                AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#requestPositionCtrl] Request rejected. Nozzle %1 is in control.", (long)this.currentPositionCtrlResponsibility);
                return false;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean releasePositionCtrl(int n) {
            Object object = this.mutex;
            synchronized (object) {
                if (n == this.currentPositionCtrlResponsibility) {
                    this.currentPositionCtrlResponsibility = -1;
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#releasePositionCtrl] Nozzle %1 - Control released.", (long)n);
                    this.updatePositionCtrlResponsibility();
                } else {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#releasePositionCtrl] Nozzle %1 is not in control.", (long)n);
                }
                return true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void setPosition(int n, int n2, int n3, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                AirconNozzleCtrl airconNozzleCtrl;
                if (!AbstractAirconNozzleComponent.this.airconR1CenterNozzleOnOffState) {
                    this.openAndRestoreSettings();
                }
                if (null != (airconNozzleCtrl = this.getNozzleCtrlByID(n))) {
                    int n4;
                    try {
                        n2 = bl ? airconNozzleCtrl.convertHorizontalPositionHMI2DSI(n2) : n2;
                        n3 = bl ? airconNozzleCtrl.convertVerticalPositionHMI2DSI(n3) : n3;
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setPosition] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                        return;
                    }
                    if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#setPosition] uniqueNozzleID='%1', horizontal='%2', vertical='%3'", (long)n, (long)n2, (long)n3);
                    }
                    int n5 = airconNozzleCtrl.getCurrentHorizontalPosition();
                    int n6 = airconNozzleCtrl.getCurrentVerticalPosition();
                    airconNozzleCtrl.setPosition(n2, n3, true, true);
                    try {
                        n4 = airconNozzleCtrl.convertStyleDSI2HMI(airconNozzleCtrl.getCurrentStyle());
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setPosition] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                        return;
                    }
                    if (0 != n4) {
                        CarArrayListUpdateInfo carArrayListUpdateInfo = new CarArrayListUpdateInfo();
                        carArrayListUpdateInfo.asgID = 1;
                        carArrayListUpdateInfo.transactionID = this.arrayHandler.getNewTransactionID();
                        carArrayListUpdateInfo.recordContent = 2;
                        carArrayListUpdateInfo.arrayContent = 1;
                        carArrayListUpdateInfo.startElement = airconNozzleCtrl.getPos();
                        carArrayListUpdateInfo.numOfElements = 1;
                        AirconNozzleListRecord airconNozzleListRecord = this.buildRecord(n, new Integer(n2), new Integer(n3), new Integer(127), new AirconNozzleListStyles(false, false, false, true));
                        this.arrayHandler.sendSetGetArray(carArrayListUpdateInfo, new AirconNozzleListRecord[]{airconNozzleListRecord});
                    } else if (-1 == this.currentPositionCtrlResponsibility || this.isUpdateRequired(n5, n2, SECTOR_DEFINITION_POSITION_X) || this.isUpdateRequired(n6, n3, SECTOR_DEFINITION_POSITION_Y)) {
                        CarArrayListUpdateInfo carArrayListUpdateInfo = new CarArrayListUpdateInfo();
                        carArrayListUpdateInfo.asgID = 1;
                        carArrayListUpdateInfo.transactionID = this.arrayHandler.getNewTransactionID();
                        carArrayListUpdateInfo.recordContent = 3;
                        carArrayListUpdateInfo.arrayContent = 1;
                        carArrayListUpdateInfo.startElement = airconNozzleCtrl.getPos();
                        carArrayListUpdateInfo.numOfElements = 1;
                        AirconNozzleListRecord airconNozzleListRecord = this.buildRecord(n, new Integer(n2), new Integer(n3));
                        this.arrayHandler.sendSetGetArray(carArrayListUpdateInfo, new AirconNozzleListRecord[]{airconNozzleListRecord});
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void setAirflow(int n, int n2, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                AirconNozzleCtrl airconNozzleCtrl;
                if (!AbstractAirconNozzleComponent.this.airconR1CenterNozzleOnOffState) {
                    this.openAndRestoreSettings();
                }
                if (null != (airconNozzleCtrl = this.getNozzleCtrlByID(n))) {
                    try {
                        n2 = bl ? airconNozzleCtrl.convertAirflowHMI2DSI(n2) : n2;
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setAirflow] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                    }
                    if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#setAirflow] uniqueNozzleID='%1', airflow='%2'", (long)n, (long)n2);
                    }
                    int n3 = airconNozzleCtrl.getAirflow();
                    airconNozzleCtrl.setAirflow(n2, true);
                    boolean bl2 = this.isUpdateRequired(n3, n2, SECTOR_DEFINITION_AIRFLOW);
                    bl2 = true;
                    if (bl2) {
                        CarArrayListUpdateInfo carArrayListUpdateInfo = new CarArrayListUpdateInfo();
                        carArrayListUpdateInfo.asgID = 1;
                        carArrayListUpdateInfo.transactionID = this.arrayHandler.getNewTransactionID();
                        carArrayListUpdateInfo.recordContent = 6;
                        carArrayListUpdateInfo.arrayContent = 1;
                        carArrayListUpdateInfo.startElement = airconNozzleCtrl.getPos();
                        carArrayListUpdateInfo.numOfElements = 1;
                        AirconNozzleListRecord airconNozzleListRecord = this.buildRecord(n, new Integer(n2));
                        if (null != airconNozzleListRecord) {
                            this.arrayHandler.sendSetGetArray(carArrayListUpdateInfo, new AirconNozzleListRecord[]{airconNozzleListRecord});
                        }
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void setStyle(int n, int n2) {
            Object object = this.mutex;
            synchronized (object) {
                AirconNozzleListRecord airconNozzleListRecord;
                int n3;
                AirconNozzleCtrl airconNozzleCtrl;
                if (!AbstractAirconNozzleComponent.this.airconR1CenterNozzleOnOffState) {
                    this.openAndRestoreSettings();
                }
                if (null != (airconNozzleCtrl = this.getNozzleCtrlByID(n))) {
                    try {
                        n3 = airconNozzleCtrl.convertStyleDSI2HMI(airconNozzleCtrl.getCurrentStyle());
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setStyle] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                        return;
                    }
                    if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#setStyle] uniqueNozzleID='%1' currentStyle='%1', requestedStyle='%2'", (long)n, (long)n3, (long)n2);
                    }
                } else {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setStyle] Invalid uniqueNozzleID: %1. Could not set Style: %2", (long)n, (long)n2);
                    return;
                }
                CarArrayListUpdateInfo carArrayListUpdateInfo = new CarArrayListUpdateInfo();
                carArrayListUpdateInfo.asgID = 1;
                carArrayListUpdateInfo.transactionID = this.arrayHandler.getNewTransactionID();
                carArrayListUpdateInfo.recordContent = 2;
                carArrayListUpdateInfo.arrayContent = 1;
                carArrayListUpdateInfo.startElement = airconNozzleCtrl.getPos();
                carArrayListUpdateInfo.numOfElements = 1;
                if (n3 != n2) {
                    try {
                        airconNozzleListRecord = this.buildRecord(airconNozzleCtrl.getUniqueID(), new Integer(127), new Integer(127), new Integer(127), airconNozzleCtrl.convertStyleHMI2DSI(n2));
                    }
                    catch (ValueConverterStrategyException valueConverterStrategyException) {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setStyle] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                        return;
                    }
                } else {
                    airconNozzleListRecord = this.buildRecord(airconNozzleCtrl.getUniqueID(), new Integer(127), new Integer(127), new Integer(127), new AirconNozzleListStyles());
                }
                this.arrayHandler.sendSetGetArray(carArrayListUpdateInfo, new AirconNozzleListRecord[]{airconNozzleListRecord});
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateTotalNumberOfElements(int n) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#updateTotalNumberOfElements] called.");
                }
                this.arrayHandler.setTotalNumberOfElements(n);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void responseAirconNozzleList(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#responseAirconNozzleList] called.");
                }
                this.arrayHandler.receivedStatusArray(carArrayListUpdateInfo, airconNozzleListRecordArray);
                this.decodeStatusArray(carArrayListUpdateInfo, airconNozzleListRecordArray);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateAirconNozzleListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray) {
            Object object = this.mutex;
            synchronized (object) {
                if (AbstractAirconNozzleComponent.this.getLogChannel().isInfo()) {
                    AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#updateAirconNozzleListUpdateInfo] called.");
                }
                this.arrayHandler.receivedChangedArray(carArrayListUpdateInfo, nArray);
            }
        }

        private void updatePositionCtrlResponsibility() {
            Iterator iterator = this.nozzleMap.values().iterator();
            while (iterator.hasNext()) {
                AirconNozzleCtrl airconNozzleCtrl = (AirconNozzleCtrl)iterator.next();
                if (null == airconNozzleCtrl) continue;
                boolean bl = -1 != this.currentPositionCtrlResponsibility && airconNozzleCtrl.getUniqueID() != this.currentPositionCtrlResponsibility;
                airconNozzleCtrl.setCtrlOverwrite(2, bl);
                airconNozzleCtrl.setCtrlOverwrite(1, bl);
            }
        }

        private AirconNozzleListRecord buildRecord(int n, Integer n2, Integer n3) {
            return this.buildRecord(n, n2, n3, null, null, null, null);
        }

        private AirconNozzleListRecord buildRecord(int n, Integer n2) {
            return this.buildRecord(n, null, null, n2, null, null, null);
        }

        private AirconNozzleListRecord buildRecord(int n, Integer n2, Integer n3, Integer n4, AirconNozzleListStyles airconNozzleListStyles) {
            return this.buildRecord(n, n2, n3, n4, airconNozzleListStyles, null, null);
        }

        private AirconNozzleListRecord buildRecord(int n, Integer n2, Integer n3, Integer n4, AirconNozzleListStyles airconNozzleListStyles, Integer n5, Integer n6) {
            AirconNozzleCtrl airconNozzleCtrl = this.getNozzleCtrlByID(n);
            AirconNozzleListRecord airconNozzleListRecord = null;
            if (null != airconNozzleCtrl) {
                airconNozzleListRecord = new AirconNozzleListRecord();
                airconNozzleListRecord.pos = airconNozzleCtrl.getPos();
                airconNozzleListRecord.horizontalPosition = airconNozzleCtrl.getHorizontalLocation();
                airconNozzleListRecord.verticalPosition = airconNozzleCtrl.getVerticalLocation();
                airconNozzleListRecord.capabilities = new AirconNozzleListCapabilities();
                if (null != n2) {
                    airconNozzleListRecord.capabilities.horizontalPosition = true;
                    airconNozzleListRecord.horizontal = n2;
                }
                if (null != n3) {
                    airconNozzleListRecord.capabilities.verticalPosition = true;
                    airconNozzleListRecord.vertical = n3;
                }
                if (null != n4) {
                    airconNozzleListRecord.capabilities.airflow = true;
                    airconNozzleListRecord.airflow = n4;
                }
                if (null != airconNozzleListStyles) {
                    airconNozzleListRecord.capabilities.style = true;
                    airconNozzleListRecord.style = airconNozzleListStyles;
                }
                if (null != n5) {
                    airconNozzleListRecord.capabilities.intervalHorizontal = true;
                    airconNozzleListRecord.intervalHorizontal = n5;
                }
                if (null != n6) {
                    airconNozzleListRecord.capabilities.intervalVertical = true;
                    airconNozzleListRecord.intervalVertical = n6;
                }
            }
            return airconNozzleListRecord;
        }

        private void decodeStatusArray(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
            if (carArrayListUpdateInfo.numOfElements != airconNozzleListRecordArray.length) {
                AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconR1CenterNozzleController#decodeStatusArray] Data mismatch: header.numOfElements='%1', data.length='%2'", (long)carArrayListUpdateInfo.numOfElements, (long)airconNozzleListRecordArray.length);
            }
            if (this.arrayHandler.isValidData(carArrayListUpdateInfo, airconNozzleListRecordArray)) {
                AirconNozzleCtrl airconNozzleCtrl;
                int n = carArrayListUpdateInfo.getStartElement();
                if (1 == airconNozzleListRecordArray.length) {
                    AirconNozzleListRecord airconNozzleListRecord = airconNozzleListRecordArray[0];
                    airconNozzleCtrl = this.getNozzleCtrlByPositionID(n);
                    if (null != airconNozzleCtrl) {
                        this.decodeRecordAndUpdateData(carArrayListUpdateInfo, airconNozzleListRecord, airconNozzleCtrl);
                    } else {
                        AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconR1CenterNozzleController#decodeStatusArray] Could not identify nozzle.");
                    }
                }
                if (1 < airconNozzleListRecordArray.length) {
                    for (int i2 = 0; i2 < airconNozzleListRecordArray.length; ++i2) {
                        AirconNozzleListRecord airconNozzleListRecord = airconNozzleListRecordArray[i2];
                        airconNozzleCtrl = 1 == carArrayListUpdateInfo.getRecordContent() ? this.getNozzleCtrlByLocation(airconNozzleListRecord.horizontalPosition, airconNozzleListRecord.verticalPosition) : this.getNozzleCtrlByPositionID(n);
                        if (null != airconNozzleCtrl) {
                            this.decodeRecordAndUpdateData(carArrayListUpdateInfo, airconNozzleListRecord, airconNozzleCtrl);
                        } else {
                            AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconR1CenterNozzleController#decodeStatusArray] Could not identify nozzle.");
                        }
                        ++n;
                    }
                }
            } else {
                AbstractAirconNozzleComponent.this.getLogChannel().log(100000, "[AirconR1CenterNozzleController#decodeStatusArray] Invalid data. Update ignored.");
            }
        }

        private void decodeRecordAndUpdateData(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord airconNozzleListRecord, AirconNozzleCtrl airconNozzleCtrl) {
            if (null != carArrayListUpdateInfo && null != airconNozzleListRecord && null != airconNozzleCtrl) {
                boolean bl;
                Buffer buffer = new Buffer();
                buffer.append("nozzle '").append(airconNozzleCtrl.getName()).append("': ");
                if ((airconNozzleListRecord.getCapabilities().isAirflow() || this.arrayHandler.getCapabilitiesByRecordAddress(carArrayListUpdateInfo.getRecordContent()).isAirflow()) && 127 != airconNozzleListRecord.airflow) {
                    buffer.append("Airflow='").append(airconNozzleListRecord.airflow).append("' ");
                    airconNozzleCtrl.setAirflow(airconNozzleListRecord.airflow, false);
                }
                boolean bl2 = (airconNozzleListRecord.getCapabilities().isHorizontalPosition() || this.arrayHandler.getCapabilitiesByRecordAddress(carArrayListUpdateInfo.getRecordContent()).isHorizontalPosition()) && 127 != airconNozzleListRecord.horizontal;
                boolean bl3 = bl = (airconNozzleListRecord.getCapabilities().isVerticalPosition() || this.arrayHandler.getCapabilitiesByRecordAddress(carArrayListUpdateInfo.getRecordContent()).isVerticalPosition()) && 127 != airconNozzleListRecord.vertical;
                if (bl2 && bl) {
                    buffer.append("Horizontal='").append(airconNozzleListRecord.horizontal).append("' ");
                    buffer.append("Vertical='").append(airconNozzleListRecord.vertical).append("' ");
                    airconNozzleCtrl.setPosition(airconNozzleListRecord.horizontal, airconNozzleListRecord.vertical, false);
                } else {
                    if (bl2) {
                        buffer.append("Horizontal='").append(airconNozzleListRecord.horizontal).append("' ");
                        airconNozzleCtrl.setHorizontalPosition(airconNozzleListRecord.horizontal, false);
                    }
                    if (bl) {
                        buffer.append("Vertical='").append(airconNozzleListRecord.vertical).append("' ");
                        airconNozzleCtrl.setVerticalPosition(airconNozzleListRecord.vertical, false);
                    }
                }
                if (airconNozzleListRecord.getCapabilities().isStyle() || this.arrayHandler.getCapabilitiesByRecordAddress(carArrayListUpdateInfo.getRecordContent()).isStyle()) {
                    buffer.append("Style='").append(airconNozzleListRecord.style).append("' ");
                    airconNozzleCtrl.setStyle(airconNozzleListRecord.style, false);
                }
                AbstractAirconNozzleComponent.this.getLogChannel().log(1000000, "[AirconR1CenterNozzleController#decodeRecordAndUpdateData] Updated %1", (Object)buffer.toString());
            } else {
                AbstractAirconNozzleComponent.this.getLogChannel().log(10000, "[AirconR1CenterNozzleController#decodeRecordAndUpdateData] Invalid parameter: header='%1', record='%2', ctrl='%3'", (Object)(null == carArrayListUpdateInfo ? "null" : carArrayListUpdateInfo.toString()), (Object)(null == airconNozzleListRecord ? "null" : airconNozzleListRecord.toString()), (Object)(null == airconNozzleCtrl ? "null" : airconNozzleCtrl.getName()));
            }
        }

        private boolean isUpdateRequired(int n, int n2, AbstractSectorDefinition abstractSectorDefinition) {
            if (null != abstractSectorDefinition) {
                AbstractSectorDefinition.Sector sector = abstractSectorDefinition.getSector(n);
                AbstractSectorDefinition.Sector sector2 = abstractSectorDefinition.getSector(n2);
                if (null == sector && null != sector2) {
                    return true;
                }
                if (null != sector && null != sector2) {
                    return sector.getUniqueID() != sector2.getUniqueID();
                }
                return false;
            }
            return false;
        }
    }
}

