/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.exception.ValueConverterStrategyException;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector;
import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent$AirconNozzleArrayHandler;
import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;
import de.audi.app.car.core.aircondition.nozzle.IAirconNozzleState;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class AbstractAirconNozzleComponent$AirconR1CenterNozzleController {
    private final Object mutex = new Object();
    private final AbstractAirconNozzleComponent$AirconNozzleArrayHandler arrayHandler = new AbstractAirconNozzleComponent$AirconNozzleArrayHandler(this.this$0, 1);
    private final Map nozzleMap = new HashMap();
    private final AirconNozzleCtrl nozzleR1CenterCtrlLeft;
    private final AirconNozzleCtrl nozzleR1CenterCtrlRight;
    private volatile int currentPositionCtrlResponsibility = -1;
    private final /* synthetic */ AbstractAirconNozzleComponent this$0;

    public AbstractAirconNozzleComponent$AirconR1CenterNozzleController(AbstractAirconNozzleComponent abstractAirconNozzleComponent) {
        this.this$0 = abstractAirconNozzleComponent;
        this.nozzleR1CenterCtrlLeft = new AirconNozzleCtrl(1, "NozzleR1CenterLeft", 1, 1, 2, 2, abstractAirconNozzleComponent.getLogChannel());
        this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(0, true);
        this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(1, true);
        this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(2, true);
        this.nozzleR1CenterCtrlLeft.setSyncPredictedDisplay(3, false);
        this.nozzleMap.put(new Integer(1), this.nozzleR1CenterCtrlLeft);
        this.nozzleR1CenterCtrlRight = new AirconNozzleCtrl(2, "NozzleR1CenterRight", 1, 2, 3, 2, abstractAirconNozzleComponent.getLogChannel());
        this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(0, true);
        this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(1, true);
        this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(2, true);
        this.nozzleR1CenterCtrlRight.setSyncPredictedDisplay(3, false);
        this.nozzleMap.put(new Integer(2), this.nozzleR1CenterCtrlRight);
    }

    public void initModels() {
        AbstractAirconNozzleComponent.access$900(this.this$0, 623839488).setChoiceListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$1000(this.this$0, 657393920).setLimits(0, 100, 1);
        AbstractAirconNozzleComponent.access$1100(this.this$0, 657393920).setRangeListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$1200(this.this$0, 741411072).setButtonListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$1300(this.this$0, 137431296).setButtonListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$1400(this.this$0, 422643968).setLimitsXY(-100, 100, -100, 100, 1, 1);
        AbstractAirconNozzleComponent.access$1500(this.this$0, 422643968).setRangeListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$1600(this.this$0, 858851584).setChoiceListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        this.nozzleR1CenterCtrlLeft.setModels(AbstractAirconNozzleComponent.access$1700(this.this$0, 657393920), AbstractAirconNozzleComponent.access$1800(this.this$0, 422643968), AbstractAirconNozzleComponent.access$1900(this.this$0, 858851584));
        AbstractAirconNozzleComponent.access$2000(this.this$0, 573638912).setLimits(0, 100, 1);
        AbstractAirconNozzleComponent.access$2100(this.this$0, 573638912).setRangeListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$2200(this.this$0, 774965504).setButtonListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$2300(this.this$0, 389089536).setButtonListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$2400(this.this$0, 53545216).setLimitsXY(-100, 100, -100, 100, 1, 1);
        AbstractAirconNozzleComponent.access$2500(this.this$0, 53545216).setRangeListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        AbstractAirconNozzleComponent.access$2600(this.this$0, 19990784).setChoiceListener(AbstractAirconNozzleComponent.access$800(this.this$0));
        this.nozzleR1CenterCtrlRight.setModels(AbstractAirconNozzleComponent.access$2700(this.this$0, 573638912), AbstractAirconNozzleComponent.access$2800(this.this$0, 53545216), AbstractAirconNozzleComponent.access$2900(this.this$0, 19990784));
    }

    public void deinitModels() {
        AbstractAirconNozzleComponent.access$3000(this.this$0, 623839488).resetListener();
        AbstractAirconNozzleComponent.access$3100(this.this$0, 858851584).resetListener();
        AbstractAirconNozzleComponent.access$3200(this.this$0, 657393920).resetListener();
        AbstractAirconNozzleComponent.access$3300(this.this$0, 741411072).resetListener();
        AbstractAirconNozzleComponent.access$3400(this.this$0, 137431296).resetListener();
        AbstractAirconNozzleComponent.access$3500(this.this$0, 422643968).resetListener();
        this.nozzleR1CenterCtrlLeft.setModels(null, null, null);
        AbstractAirconNozzleComponent.access$3600(this.this$0, 19990784).resetListener();
        AbstractAirconNozzleComponent.access$3700(this.this$0, 573638912).resetListener();
        AbstractAirconNozzleComponent.access$3800(this.this$0, 774965504).resetListener();
        AbstractAirconNozzleComponent.access$3900(this.this$0, 389089536).resetListener();
        AbstractAirconNozzleComponent.access$4000(this.this$0, 53545216).resetListener();
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
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#openAndRestoreSettings] called.");
            }
            if (null != this.this$0.getDSI()) {
                this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setAirconNozzleControlRow1(OPEN)");
                this.this$0.getDSI().setAirconNozzleControlRow1(2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#close] called.");
            }
            if (null != this.this$0.getDSI()) {
                this.this$0.getLogChannel(1).log(1078071040, "[HMI|--->>|DSI] setAirconNozzleControlRow1(CLOSE)");
                this.this$0.getDSI().setAirconNozzleControlRow1(1);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean requestPositionCtrl(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#requestPositionCtrl] uniqueNozzleID='%1',", (long)n);
            }
            if (-1 == this.currentPositionCtrlResponsibility) {
                this.currentPositionCtrlResponsibility = n;
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#requestPositionCtrl] Nozzle %1 is now in control.", (long)this.currentPositionCtrlResponsibility);
                this.updatePositionCtrlResponsibility();
                return true;
            }
            this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#requestPositionCtrl] Request rejected. Nozzle %1 is in control.", (long)this.currentPositionCtrlResponsibility);
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
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#releasePositionCtrl] Nozzle %1 - Control released.", (long)n);
                this.updatePositionCtrlResponsibility();
            } else {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#releasePositionCtrl] Nozzle %1 is not in control.", (long)n);
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
            if (!this.this$0.airconR1CenterNozzleOnOffState) {
                this.openAndRestoreSettings();
            }
            if (null != (airconNozzleCtrl = this.getNozzleCtrlByID(n))) {
                int n4;
                try {
                    n2 = bl ? airconNozzleCtrl.convertHorizontalPositionHMI2DSI(n2) : n2;
                    n3 = bl ? airconNozzleCtrl.convertVerticalPositionHMI2DSI(n3) : n3;
                }
                catch (ValueConverterStrategyException valueConverterStrategyException) {
                    this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setPosition] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                    return;
                }
                if (this.this$0.getLogChannel().isInfo()) {
                    this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#setPosition] uniqueNozzleID='%1', horizontal='%2', vertical='%3'", (long)n, (long)n2, (long)n3);
                }
                int n5 = airconNozzleCtrl.getCurrentHorizontalPosition();
                int n6 = airconNozzleCtrl.getCurrentVerticalPosition();
                airconNozzleCtrl.setPosition(n2, n3, true, true);
                try {
                    n4 = airconNozzleCtrl.convertStyleDSI2HMI(airconNozzleCtrl.getCurrentStyle());
                }
                catch (ValueConverterStrategyException valueConverterStrategyException) {
                    this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setPosition] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
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
                } else if (-1 == this.currentPositionCtrlResponsibility || this.isUpdateRequired(n5, n2, AbstractAirconNozzleComponent.access$4100()) || this.isUpdateRequired(n6, n3, AbstractAirconNozzleComponent.access$4200())) {
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
            if (!this.this$0.airconR1CenterNozzleOnOffState) {
                this.openAndRestoreSettings();
            }
            if (null != (airconNozzleCtrl = this.getNozzleCtrlByID(n))) {
                try {
                    n2 = bl ? airconNozzleCtrl.convertAirflowHMI2DSI(n2) : n2;
                }
                catch (ValueConverterStrategyException valueConverterStrategyException) {
                    this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setAirflow] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                }
                if (this.this$0.getLogChannel().isInfo()) {
                    this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#setAirflow] uniqueNozzleID='%1', airflow='%2'", (long)n, (long)n2);
                }
                int n3 = airconNozzleCtrl.getAirflow();
                airconNozzleCtrl.setAirflow(n2, true);
                boolean bl2 = this.isUpdateRequired(n3, n2, AbstractAirconNozzleComponent.access$4300());
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
            if (!this.this$0.airconR1CenterNozzleOnOffState) {
                this.openAndRestoreSettings();
            }
            if (null != (airconNozzleCtrl = this.getNozzleCtrlByID(n))) {
                try {
                    n3 = airconNozzleCtrl.convertStyleDSI2HMI(airconNozzleCtrl.getCurrentStyle());
                }
                catch (ValueConverterStrategyException valueConverterStrategyException) {
                    this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setStyle] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
                    return;
                }
                if (this.this$0.getLogChannel().isInfo()) {
                    this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#setStyle] uniqueNozzleID='%1' currentStyle='%1', requestedStyle='%2'", (long)n, (long)n3, (long)n2);
                }
            } else {
                this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setStyle] Invalid uniqueNozzleID: %1. Could not set Style: %2", (long)n, (long)n2);
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
                    this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#setStyle] ValueConverterStrategyException occurred. Reason: '%1'", (long)valueConverterStrategyException.getReason());
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
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#updateTotalNumberOfElements] called.");
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
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#responseAirconNozzleList] called.");
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
            if (this.this$0.getLogChannel().isInfo()) {
                this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#updateAirconNozzleListUpdateInfo] called.");
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
            this.this$0.getLogChannel().log(-1601830656, "[AirconR1CenterNozzleController#decodeStatusArray] Data mismatch: header.numOfElements='%1', data.length='%2'", (long)carArrayListUpdateInfo.numOfElements, (long)airconNozzleListRecordArray.length);
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
                    this.this$0.getLogChannel().log(-1601830656, "[AirconR1CenterNozzleController#decodeStatusArray] Could not identify nozzle.");
                }
            }
            if (1 < airconNozzleListRecordArray.length) {
                for (int i2 = 0; i2 < airconNozzleListRecordArray.length; ++i2) {
                    AirconNozzleListRecord airconNozzleListRecord = airconNozzleListRecordArray[i2];
                    airconNozzleCtrl = 1 == carArrayListUpdateInfo.getRecordContent() ? this.getNozzleCtrlByLocation(airconNozzleListRecord.horizontalPosition, airconNozzleListRecord.verticalPosition) : this.getNozzleCtrlByPositionID(n);
                    if (null != airconNozzleCtrl) {
                        this.decodeRecordAndUpdateData(carArrayListUpdateInfo, airconNozzleListRecord, airconNozzleCtrl);
                    } else {
                        this.this$0.getLogChannel().log(-1601830656, "[AirconR1CenterNozzleController#decodeStatusArray] Could not identify nozzle.");
                    }
                    ++n;
                }
            }
        } else {
            this.this$0.getLogChannel().log(-1601830656, "[AirconR1CenterNozzleController#decodeStatusArray] Invalid data. Update ignored.");
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
            this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#decodeRecordAndUpdateData] Updated %1", (Object)buffer.toString());
        } else {
            this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#decodeRecordAndUpdateData] Invalid parameter: header='%1', record='%2', ctrl='%3'", (Object)(null == carArrayListUpdateInfo ? "null" : carArrayListUpdateInfo.toString()), (Object)(null == airconNozzleListRecord ? "null" : airconNozzleListRecord.toString()), (Object)(null == airconNozzleCtrl ? "null" : airconNozzleCtrl.getName()));
        }
    }

    private boolean isUpdateRequired(int n, int n2, AbstractAirconNozzleComponent$AbstractSectorDefinition abstractAirconNozzleComponent$AbstractSectorDefinition) {
        if (null != abstractAirconNozzleComponent$AbstractSectorDefinition) {
            AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector abstractAirconNozzleComponent$AbstractSectorDefinition$Sector = abstractAirconNozzleComponent$AbstractSectorDefinition.getSector(n);
            AbstractAirconNozzleComponent$AbstractSectorDefinition$Sector abstractAirconNozzleComponent$AbstractSectorDefinition$Sector2 = abstractAirconNozzleComponent$AbstractSectorDefinition.getSector(n2);
            if (null == abstractAirconNozzleComponent$AbstractSectorDefinition$Sector && null != abstractAirconNozzleComponent$AbstractSectorDefinition$Sector2) {
                return true;
            }
            if (null != abstractAirconNozzleComponent$AbstractSectorDefinition$Sector && null != abstractAirconNozzleComponent$AbstractSectorDefinition$Sector2) {
                return abstractAirconNozzleComponent$AbstractSectorDefinition$Sector.getUniqueID() != abstractAirconNozzleComponent$AbstractSectorDefinition$Sector2.getUniqueID();
            }
            return false;
        }
        return false;
    }
}

