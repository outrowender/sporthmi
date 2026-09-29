/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.core.kombi.AbstractDisplayConfigurationComponent;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCTransmittableElements;

public class AbstractDisplayConfigurationComponent$DisplayConfigurationArrayHandler {
    public static final int FULL_RANGE_UPDATE_START_ELEMENT;
    public static final int FULL_RANGE_UPDATE_NUM_OF_ELEMENTS;
    private int currentTransactionID = 0;
    private int totalNumberOfElements = 0;
    private int numOfTransmittedElements = 0;
    private volatile DCElementContentSelectionListRA1[] currentArray = new DCElementContentSelectionListRA1[0];
    private final /* synthetic */ AbstractDisplayConfigurationComponent this$0;

    protected AbstractDisplayConfigurationComponent$DisplayConfigurationArrayHandler(AbstractDisplayConfigurationComponent abstractDisplayConfigurationComponent) {
        this.this$0 = abstractDisplayConfigurationComponent;
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
        this.currentArray = new DCElementContentSelectionListRA1[this.totalNumberOfElements];
    }

    public DCElementContentSelectionListRA1[] getCurrentArray() {
        return this.currentArray;
    }

    public void sendSetGetArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (SetGetArray) setDCElementContentSelectionListRA1 | header='%1', data='%2'", (Object)dCElementContentSelectionListUpdateInfo, (Object)this.arrayDataToString(dCElementContentSelectionListRA1Array));
        this.this$0.getDSI().setDCElementContentSelectionListRA1(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
    }

    public void sendGetArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        this.this$0.getLogChannel(2).log(1078071040, "[HMI|--->>|DSI] (GetArray) requestDCElementContentSelectionList | header='%1'", (Object)dCElementContentSelectionListUpdateInfo);
        this.this$0.getDSI().requestDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo);
    }

    public void receivedStatusArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        this.this$0.getLogChannel(2).log(1078071040, "[HMI|<<---|DSI] (StatusArray) responseDCElementContentSelectionList | header='%1', data'%2'", (Object)dCElementContentSelectionListUpdateInfo, (Object)this.arrayDataToString(dCElementContentSelectionListRA1Array));
        if (null != dCElementContentSelectionListUpdateInfo) {
            if (this.isValidASGID(dCElementContentSelectionListUpdateInfo.asgID)) {
                this.decodeStatusArray(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
            } else {
                this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationArrayHandler#receivedStatusArray] ASG_ID='%1'. Response ignored.", (long)dCElementContentSelectionListUpdateInfo.asgID);
            }
        }
    }

    public void receivedChangedArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        this.this$0.getLogChannel(2).log(1078071040, "[HMI|<<---|DSI] (ChangedArray) updateDCElementContentSelectionListUpdateInfo | header='%1', listOfPos=''", (Object)dCElementContentSelectionListUpdateInfo, (Object)nArray);
        if (null != dCElementContentSelectionListUpdateInfo) {
            if (this.isValidASGID(dCElementContentSelectionListUpdateInfo.asgID)) {
                this.decodeChangedArray(dCElementContentSelectionListUpdateInfo, nArray);
            } else {
                this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationArrayHandler#receivedChangedArray] ASG_ID='%1'. Update ignored.", (long)dCElementContentSelectionListUpdateInfo.asgID);
            }
        }
    }

    public boolean isValidASGID(int n) {
        return 0 == n || 1 == n;
    }

    private boolean isForwardRequestRequired(int n) {
        return 0 <= n && 0 < this.getTotalNumberOfElements() - this.numOfTransmittedElements;
    }

    private void decodeStatusArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        int n;
        if (dCElementContentSelectionListUpdateInfo.numOfElements != dCElementContentSelectionListRA1Array.length) {
            this.this$0.getLogChannel().log(-1601830656, "[DisplayConfigurationController#decodeStatusArray] Data mismatch: header.numOfElements='%1', data.length='%2'", (long)dCElementContentSelectionListUpdateInfo.numOfElements, (long)dCElementContentSelectionListRA1Array.length);
        }
        int n2 = -1;
        for (n = 0; n < dCElementContentSelectionListRA1Array.length; ++n) {
            DCElementContentSelectionListRA1 dCElementContentSelectionListRA1 = dCElementContentSelectionListRA1Array[n];
            if (null != dCElementContentSelectionListRA1) {
                this.decodeRecordAndUpdateData(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1);
                ++this.numOfTransmittedElements;
                n2 = dCElementContentSelectionListRA1.getPos();
                continue;
            }
            this.this$0.getLogChannel().log(-1601830656, "[DisplayConfigurationController#decodeStatusArray] data element 'null'.");
        }
        if (this.isForwardRequestRequired(n2)) {
            int n3;
            n = this.getTotalNumberOfElements() - (n2 + 1);
            if (0 < n && 0 < (n3 = this.getMaxTransmittableElements(dCElementContentSelectionListUpdateInfo.getArrayContent()))) {
                DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo2 = new DCElementContentSelectionListUpdateInfo();
                dCElementContentSelectionListUpdateInfo2.asgID = 1;
                dCElementContentSelectionListUpdateInfo2.transactionID = this.getNewTransactionID();
                dCElementContentSelectionListUpdateInfo2.recordContent = dCElementContentSelectionListUpdateInfo.getArrayContent();
                dCElementContentSelectionListUpdateInfo2.arrayContent = 3;
                dCElementContentSelectionListUpdateInfo2.startElement = n2;
                dCElementContentSelectionListUpdateInfo2.numOfElements = n <= n3 ? n : n3;
                this.sendGetArray(dCElementContentSelectionListUpdateInfo2);
            }
        } else {
            this.numOfTransmittedElements = 0;
            this.this$0.notifyDisplayConfigurationChanged();
        }
    }

    private void decodeChangedArray(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        if (this.this$0.getLogChannel().isInfo()) {
            this.this$0.getLogChannel().log(1078071040, "[DisplayConfigurationController#decodeChangedArray] header='%1'", (Object)(dCElementContentSelectionListUpdateInfo == null ? "null" : dCElementContentSelectionListUpdateInfo.toString()));
        }
        if (null != dCElementContentSelectionListUpdateInfo) {
            int n = dCElementContentSelectionListUpdateInfo.getArrayContent();
            if (0 == dCElementContentSelectionListUpdateInfo.getRecordContent() && 0 == dCElementContentSelectionListUpdateInfo.getStartElement() && -1 == dCElementContentSelectionListUpdateInfo.getNumOfElements()) {
                int n2 = this.getMaxTransmittableElements(1);
                if (0 < n2) {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo2 = new DCElementContentSelectionListUpdateInfo();
                    dCElementContentSelectionListUpdateInfo2.asgID = 1;
                    dCElementContentSelectionListUpdateInfo2.transactionID = this.getNewTransactionID();
                    dCElementContentSelectionListUpdateInfo2.recordContent = 1;
                    dCElementContentSelectionListUpdateInfo2.arrayContent = 1;
                    dCElementContentSelectionListUpdateInfo2.startElement = 0;
                    dCElementContentSelectionListUpdateInfo2.numOfElements = n2;
                    this.sendGetArray(dCElementContentSelectionListUpdateInfo2);
                }
            } else if (1 == dCElementContentSelectionListUpdateInfo.getRecordContent() && (1 == n || 3 == n)) {
                int n3 = this.getMaxTransmittableElements(1);
                if (0 < n3) {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo3 = new DCElementContentSelectionListUpdateInfo();
                    dCElementContentSelectionListUpdateInfo3.asgID = 1;
                    dCElementContentSelectionListUpdateInfo3.transactionID = this.getNewTransactionID();
                    dCElementContentSelectionListUpdateInfo3.recordContent = 1;
                    dCElementContentSelectionListUpdateInfo3.arrayContent = dCElementContentSelectionListUpdateInfo.getArrayContent();
                    dCElementContentSelectionListUpdateInfo3.startElement = dCElementContentSelectionListUpdateInfo.getStartElement();
                    dCElementContentSelectionListUpdateInfo3.numOfElements = dCElementContentSelectionListUpdateInfo.getNumOfElements() <= n3 ? dCElementContentSelectionListUpdateInfo.getNumOfElements() : n3;
                    this.sendGetArray(dCElementContentSelectionListUpdateInfo3);
                }
            } else {
                this.this$0.getLogChannel().log(10000, "[DisplayConfigurationController#decodeChangedArray] ChangedArray not supported.");
            }
        } else {
            this.this$0.getLogChannel().log(10000, "[DisplayConfigurationController#decodeChangedArray] Invalid setup or parameter.");
        }
    }

    private void decodeRecordAndUpdateData(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1 dCElementContentSelectionListRA1) {
        if (null != dCElementContentSelectionListUpdateInfo && null != dCElementContentSelectionListRA1) {
            if (1 == dCElementContentSelectionListUpdateInfo.getRecordContent()) {
                int n = dCElementContentSelectionListRA1.getPos();
                if (0 <= n && n < this.currentArray.length) {
                    this.currentArray[n] = dCElementContentSelectionListRA1;
                }
            } else {
                this.this$0.getLogChannel().log(10000, "[DisplayConfigurationController#decodeRecordAndUpdateData] Record address not supported.");
            }
        }
    }

    private int getMaxTransmittableElements(int n) {
        int n2;
        if (null != AbstractDisplayConfigurationComponent.access$000(this.this$0) && null != AbstractDisplayConfigurationComponent.access$000(this.this$0).getConfiguration()) {
            DCTransmittableElements dCTransmittableElements = AbstractDisplayConfigurationComponent.access$000(this.this$0).getConfiguration().getElementContentSelectionListTransmittableElements();
            switch (n) {
                case 0: {
                    n2 = dCTransmittableElements.getRa0();
                    break;
                }
                case 1: {
                    n2 = dCTransmittableElements.getRa1();
                    break;
                }
                case 15: {
                    n2 = dCTransmittableElements.getRaF();
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

    private String arrayDataToString(DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < dCElementContentSelectionListRA1Array.length; ++i2) {
            buffer.append("[").append(i2).append("] ").append(dCElementContentSelectionListRA1Array[i2].toString());
        }
        return buffer.toString();
    }
}

