/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconNozzleComponent;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.global.CarArrayListTransmittableElements;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class AbstractAirconNozzleComponent$AirconNozzleArrayHandler {
    public static final int FULL_RANGE_UPDATE_START_ELEMENT;
    public static final int FULL_RANGE_UPDATE_NUM_OF_ELEMENTS;
    private final int dsiRow;
    private int currentTransactionID = 0;
    private int totalNumberOfElements = 0;
    private int numOfTransmittedElements = 0;
    private volatile AirconNozzleListRecord[] currentArray = new AirconNozzleListRecord[0];
    private final /* synthetic */ AbstractAirconNozzleComponent this$0;

    public AbstractAirconNozzleComponent$AirconNozzleArrayHandler(AbstractAirconNozzleComponent abstractAirconNozzleComponent, int n) {
        this.this$0 = abstractAirconNozzleComponent;
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
        if (this.this$0.getLogChannel().isInfo()) {
            this.this$0.getLogChannel().log(1078071040, "[AirconNozzleArrayHandler#sendSetGetArray] row='%1'", (Object)new Integer(this.dsiRow));
        }
        switch (this.dsiRow) {
            case 1: {
                this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (SetGetArray) setAirconNozzleListRow | row='%1', header='%2', data='%3'", (Object)new Integer(1), (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
                this.this$0.getDSI().setAirconNozzleListRow(1, carArrayListUpdateInfo, airconNozzleListRecordArray);
                break;
            }
            case 2: {
                this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (SetGetArray) setAirconNozzleListRow | row='%1', header='%2', data='%3'", (Object)new Integer(2), (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
                this.this$0.getDSI().setAirconNozzleListRow(2, carArrayListUpdateInfo, airconNozzleListRecordArray);
                break;
            }
            case 4: {
                this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (SetGetArray) setAirconNozzleListRow | row='%1', header='%2', data='%3'", (Object)new Integer(4), (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
                this.this$0.getDSI().setAirconNozzleListRow(4, carArrayListUpdateInfo, airconNozzleListRecordArray);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AirconNozzleArrayHandler#sendSetGetArray] Unsupported row: 1%. Request ignored.", (long)this.dsiRow);
                return;
            }
        }
    }

    public void sendGetArray(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        if (this.this$0.getLogChannel().isInfo()) {
            this.this$0.getLogChannel().log(1078071040, "[AirconNozzleArrayHandler#sendGetArray] row='%1'", (Object)new Integer(this.dsiRow));
        }
        switch (this.dsiRow) {
            case 1: {
                this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (GetArray) requestAirconNozzleListRow | row='%1', header='%2'", (Object)new Integer(1), (Object)carArrayListUpdateInfo);
                this.this$0.getDSI().requestAirconNozzleListRow(1, carArrayListUpdateInfo);
                break;
            }
            case 2: {
                this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (GetArray) requestAirconNozzleListRow | row='%1', header='%2'", (Object)new Integer(2), (Object)carArrayListUpdateInfo);
                this.this$0.getDSI().requestAirconNozzleListRow(2, carArrayListUpdateInfo);
                break;
            }
            case 4: {
                this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (GetArray) requestAirconNozzleListRow | row='%1', header='%2'", (Object)new Integer(4), (Object)carArrayListUpdateInfo);
                this.this$0.getDSI().requestAirconNozzleListRow(4, carArrayListUpdateInfo);
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-1601830656, "[AirconNozzleArrayHandler#sendGetArray] Unsupported row: 1%. Request ignored.", (long)this.dsiRow);
                return;
            }
        }
    }

    public void receivedStatusArray(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        this.this$0.getLogChannel(2).log(1078071040, "[HMI|<<---|DSI] (StatusArray) responseAirconNozzleList | header='%1', data'%2'", (Object)carArrayListUpdateInfo, (Object)this.arrayDataToString(airconNozzleListRecordArray));
        if (null != carArrayListUpdateInfo) {
            if (this.isValidASGID(carArrayListUpdateInfo.asgID)) {
                this.decodeStatusArray(carArrayListUpdateInfo, airconNozzleListRecordArray);
            } else {
                this.this$0.getLogChannel().log(1078071040, "[AirconNozzleArrayHandler#receivedStatusArray] ASG_ID='%1'. Response ignored.", (long)carArrayListUpdateInfo.asgID);
            }
        }
    }

    public void receivedChangedArray(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray) {
        this.this$0.getLogChannel(2).log(1078071040, "[HMI|<<---|DSI] (ChangedArray) updateAirconNozzleListUpdateInfoRow1 | header='%1', listOfPos=''", (Object)carArrayListUpdateInfo, (Object)nArray);
        if (null != carArrayListUpdateInfo) {
            if (this.isValidASGID(carArrayListUpdateInfo.asgID)) {
                this.decodeChangedArray(carArrayListUpdateInfo, nArray);
            } else {
                this.this$0.getLogChannel().log(1078071040, "[AirconNozzleArrayHandler#receivedChangedArray] ASG_ID='%1'. Update ignored.", (long)carArrayListUpdateInfo.asgID);
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
            this.this$0.getLogChannel().log(-1601830656, "[AirconR1CenterNozzleController#decodeStatusArray] Data mismatch: header.numOfElements='%1', data.length='%2'", (long)carArrayListUpdateInfo.numOfElements, (long)airconNozzleListRecordArray.length);
        }
        int n2 = -1;
        for (n = 0; n < airconNozzleListRecordArray.length; ++n) {
            AirconNozzleListRecord airconNozzleListRecord = airconNozzleListRecordArray[n];
            if (null != airconNozzleListRecord) {
                ++this.numOfTransmittedElements;
                n2 = airconNozzleListRecord.getPos();
                continue;
            }
            this.this$0.getLogChannel().log(-1601830656, "[AirconR1CenterNozzleController#decodeStatusArray] data element 'null'.");
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
        if (this.this$0.getLogChannel().isInfo()) {
            this.this$0.getLogChannel().log(1078071040, "[AirconR1CenterNozzleController#decodeChangedArray] dsiRow='%1', header='%2'", (Object)new Integer(this.dsiRow), (Object)(carArrayListUpdateInfo == null ? "null" : carArrayListUpdateInfo.toString()));
        }
        if ((1 == this.dsiRow || 2 == this.dsiRow || 4 == this.dsiRow) && null != carArrayListUpdateInfo && null != this.this$0.currentViewOptionsRow1 && null != this.this$0.currentViewOptionsRow1.getConfiguration()) {
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
                this.this$0.getLogChannel().log(10000, "[AirconR1CenterNozzleController#decodeChangedArray] ChangedArray not supported.");
            }
        }
    }

    private int getMaxTransmittableElements(int n) {
        int n2;
        AirconRowViewOptions airconRowViewOptions = AbstractAirconNozzleComponent.access$000(this.this$0, this.dsiRow);
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

