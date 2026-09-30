/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.app.car.core.bcme.AbstractConsumerDisplayComponent;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.careco.BCmEConfiguration;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmEViewOptions;

public class ConsumerListHandler {
    private final AbstractConsumerDisplayComponent consumerComponent;
    private final BaseListModelApp consumerListModel;
    private final ChoiceModelApp[] tempConsumerChoiceModels;
    private final LogChannel logChannel;
    private static final int CONSUMER_LIST_ASG_ID = 1;
    private static final int INIT_CONSUMER_LIST_START_ELEMENT = 0;
    private static final int INIT_CONSUMER_LIST_ARRAYCONTENT = 1;
    private static final int MAX_COLUMNS = 1;
    private static final int COLUMN_INDEX_CONSUMER_IDENTIFIER = 0;
    private static final int RANGE_GAIN_VALID = 10;
    private static final int RANGE_GAIN_MIN = 0;
    private static final int RANGE_GAIN_MAX = 35535;
    private int consumerListRecordContent = 2;
    private int maxNrTransmittableConsumers;
    private int totalNrOfConsumers = 0;
    private boolean consumerListRequestBlocked = true;
    private BCmEListUpdateInfo lastSentListUpdateInfo;
    private int uniqueIDCounter = 0;
    private BCmEConsumerListRangeRA0[] consumerList;

    public ConsumerListHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, AbstractConsumerDisplayComponent abstractConsumerDisplayComponent, int n) {
        this.logChannel = logChannel;
        this.consumerListModel = baseListModelApp;
        this.consumerComponent = abstractConsumerDisplayComponent;
        this.consumerListRecordContent = n;
        this.tempConsumerChoiceModels = null;
    }

    public ConsumerListHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, AbstractConsumerDisplayComponent abstractConsumerDisplayComponent, int n, ChoiceModelApp[] choiceModelAppArray) {
        this.logChannel = logChannel;
        this.consumerListModel = baseListModelApp;
        this.consumerComponent = abstractConsumerDisplayComponent;
        this.consumerListRecordContent = n;
        this.tempConsumerChoiceModels = choiceModelAppArray;
        this.resetTempChoiceModels();
    }

    public void updateConsumerListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo) {
        this.getLogChannel().log(10000000, "[ConsumerListHandler#updateConsumerListUpdateInfo] listUpdateInfo='%1' ", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        if (this.isConsumerListRequestBlocked()) {
            this.getLogChannel().log(100000, "[ConsumerListHandler#updateConsumerListUpdateInfo] Consumer list request configuration invalid! No request will be sent!");
        } else {
            this.sendInitConsumerListRequest(bCmEListUpdateInfo);
        }
    }

    public void responseConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        this.getLogChannel().log(10000000, "[ConsumerListHandler#responseConsumerList] listUpdateInfo='%1' ", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        if (this.matchesValidResponseUpdate(bCmEListUpdateInfo)) {
            this.updateConsumerList(bCmEConsumerListArray);
            this.updateConsumerListModel(bCmEListUpdateInfo, this.consumerList);
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#responseConsumerList] listUpdateInfo '%1' is not supported by consumer display (arrayContent/startElement/numElements mismatch)!", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        }
    }

    public void responseConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        this.getLogChannel().log(10000000, "[ConsumerListHandler#responseConsumerList] listUpdateInfo='%1' ", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        if (this.matchesValidResponseUpdate(bCmEListUpdateInfo)) {
            this.updateConsumerList(bCmEConsumerListRangeRA0Array);
            this.updateConsumerListModel(bCmEListUpdateInfo, this.consumerList);
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#responseConsumerList] listUpdateInfo '%1' is not supported by consumer display (arrayContent/startElement/numElements mismatch)!", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        }
    }

    public void responseConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        this.getLogChannel().log(10000000, "[ConsumerListHandler#responseConsumerList] listUpdateInfo='%1' ", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        if (this.matchesValidResponseUpdate(bCmEListUpdateInfo)) {
            this.updateConsumerList(bCmEConsumerListRangeRA2Array);
            this.updateConsumerListModel(bCmEListUpdateInfo, this.consumerList);
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#responseConsumerList] listUpdateInfo '%1' is not supported by consumer display (arrayContent/startElement/numElements mismatch)!", (Object)(bCmEListUpdateInfo != null ? bCmEListUpdateInfo.toString() : "null"));
        }
    }

    private void updateConsumerList(BCmEConsumerList[] bCmEConsumerListArray) {
        if (this.consumerList != null) {
            for (int i2 = 0; i2 < bCmEConsumerListArray.length; ++i2) {
                BCmEConsumerList bCmEConsumerList = bCmEConsumerListArray[i2];
                if (bCmEConsumerList.getListPosition() >= this.consumerList.length) continue;
                BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0 = this.consumerList[bCmEConsumerList.getListPosition()];
                bCmEConsumerListRangeRA0.consumer = bCmEConsumerList.getConsumer();
                bCmEConsumerListRangeRA0.rangeGainSecondary = 10;
            }
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#updateConsumerList(RA0)] Internal Consumer List Null! - NO length received yet");
        }
    }

    private void updateConsumerList(BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        if (this.consumerList != null) {
            for (int i2 = 0; i2 < bCmEConsumerListRangeRA0Array.length; ++i2) {
                BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0 = bCmEConsumerListRangeRA0Array[i2];
                if (bCmEConsumerListRangeRA0.getPos() >= this.consumerList.length) continue;
                BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA02 = this.consumerList[bCmEConsumerListRangeRA0.getPos()];
                bCmEConsumerListRangeRA02.consumer = bCmEConsumerListRangeRA0.getConsumer();
                bCmEConsumerListRangeRA02.pos = bCmEConsumerListRangeRA0.getPos();
                bCmEConsumerListRangeRA02.rangeGainSecondary = bCmEConsumerListRangeRA0.getRangeGainSecondary();
                bCmEConsumerListRangeRA02.rangeUnit = bCmEConsumerListRangeRA0.getRangeUnit();
            }
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#updateConsumerList(RA0)] Internal Consumer List Null! - NO length received yet");
        }
    }

    private void updateConsumerList(BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        if (this.consumerList != null) {
            for (int i2 = 0; i2 < bCmEConsumerListRangeRA2Array.length; ++i2) {
                BCmEConsumerListRangeRA2 bCmEConsumerListRangeRA2 = bCmEConsumerListRangeRA2Array[i2];
                if (bCmEConsumerListRangeRA2.getPos() >= this.consumerList.length) continue;
                BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0 = this.consumerList[bCmEConsumerListRangeRA2.getPos()];
                bCmEConsumerListRangeRA0.consumer = bCmEConsumerListRangeRA2.getConsumer();
                bCmEConsumerListRangeRA0.pos = bCmEConsumerListRangeRA2.getPos();
                bCmEConsumerListRangeRA0.rangeGainSecondary = bCmEConsumerListRangeRA2.getRangeGainSecondary();
                bCmEConsumerListRangeRA0.rangeUnit = bCmEConsumerListRangeRA2.getRangeUnit();
            }
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#updateConsumerList(RA2)] Internal Consumer List Null! - NO length received yet");
        }
    }

    private boolean matchesValidResponseUpdate(BCmEListUpdateInfo bCmEListUpdateInfo) {
        if (this.getLastSentListUpdateInfo() == null || bCmEListUpdateInfo == null) {
            return false;
        }
        return this.getLastSentListUpdateInfo().getStartElement() == bCmEListUpdateInfo.getStartElement() && this.getLastSentListUpdateInfo().getArrayContent() == bCmEListUpdateInfo.getArrayContent() && this.matchesValidRecordContent(this.getLastSentListUpdateInfo().getRecordContent(), bCmEListUpdateInfo.getRecordContent());
    }

    private boolean matchesValidRecordContent(int n, int n2) {
        return n == n2 || n2 == 0;
    }

    private void sendInitConsumerListRequest(BCmEListUpdateInfo bCmEListUpdateInfo) {
        if (this.matchesValidInitUpdateInfo(bCmEListUpdateInfo)) {
            BCmEListUpdateInfo bCmEListUpdateInfo2 = new BCmEListUpdateInfo();
            bCmEListUpdateInfo2.arrayContent = 1;
            bCmEListUpdateInfo2.startElement = 0;
            bCmEListUpdateInfo2.recordContent = this.consumerListRecordContent;
            bCmEListUpdateInfo2.numOfElements = this.getMaxNrTransmittableConsumers();
            bCmEListUpdateInfo2.transactionID = bCmEListUpdateInfo.transactionID + 1;
            bCmEListUpdateInfo2.asgID = 1;
            this.requestConsumerList(bCmEListUpdateInfo2, "updateBCmEListUpdateInfo");
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#sendInitConsumerListRequest] Received invalid initial UpdateInfo (arrayContent/startElement mismatch)! No initial consumer list request will be sent!");
        }
    }

    private void requestConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, String string) {
        this.setLastSentListUpdateInfo(bCmEListUpdateInfo);
        this.getConsumerComponent().requestConsumerList(bCmEListUpdateInfo, string);
    }

    public void prepareBCmEListRequestUpdateInfo(BCmEViewOptions bCmEViewOptions) {
        this.setMaxNrTransmittableConsumers(bCmEViewOptions);
        this.setConsumerListRequestBlocked(this.getMaxNrTransmittableConsumers() <= 0 || this.isConsumerListInvisible(bCmEViewOptions));
        if (this.isConsumerListRequestBlocked()) {
            this.getConsumerListModel().removeAll();
            this.resetUniqueIDCounter();
        }
    }

    private boolean isConsumerListInvisible(BCmEViewOptions bCmEViewOptions) {
        return this.consumerComponent.isConsumerListInvisible(bCmEViewOptions);
    }

    private boolean matchesValidInitUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo) {
        return this.matchesExpectedUpdateInfo(bCmEListUpdateInfo, 1);
    }

    private boolean matchesExpectedUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        return bCmEListUpdateInfo != null && bCmEListUpdateInfo.arrayContent == n;
    }

    private void setMaxNrTransmittableConsumers(BCmEViewOptions bCmEViewOptions) {
        int n = 0;
        BCmEConfiguration bCmEConfiguration = bCmEViewOptions.getConfiguration();
        if (bCmEConfiguration != null && bCmEConfiguration.getConsumerListTransmittableElements() != null) {
            n = bCmEConfiguration.getConsumerListRangeTransmittableElements().getRa0();
        }
        this.setMaxNrTransmittableConsumers(n);
    }

    private void setMaxNrTransmittableConsumers(int n) {
        this.maxNrTransmittableConsumers = n;
    }

    public int getMaxNrTransmittableConsumers() {
        return this.maxNrTransmittableConsumers;
    }

    public int getMaxNrDisplayableConsumers() {
        return this.getConsumerComponent().getMaxNrDisplayableConsumers();
    }

    private int getTotalNrOfConsumers() {
        return this.totalNrOfConsumers;
    }

    public void setTotalNrOfConsumers(int n) {
        block3: {
            block2: {
                this.getLogChannel().log(1000000, "[ConsumerListHandler#setTotalNrOfConsumers] totalNrOfConsumers='%1'", (long)n);
                this.totalNrOfConsumers = n;
                if (this.consumerList != null) break block2;
                this.consumerList = new BCmEConsumerListRangeRA0[n];
                for (int i2 = 0; i2 < this.consumerList.length; ++i2) {
                    this.consumerList[i2] = new BCmEConsumerListRangeRA0();
                }
                break block3;
            }
            if (n == this.consumerList.length) break block3;
            this.consumerList = new BCmEConsumerListRangeRA0[n];
            for (int i3 = 0; i3 < this.consumerList.length; ++i3) {
                this.consumerList[i3] = new BCmEConsumerListRangeRA0();
            }
        }
    }

    private int getNumberOfValidConsumers() {
        int n = 0;
        for (int i2 = 0; i2 < this.consumerList.length; ++i2) {
            if (!this.isConsumerValid(this.consumerList[i2])) continue;
            ++n;
        }
        return n;
    }

    private boolean isConsumerValid(BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0) {
        return bCmEConsumerListRangeRA0.getRangeGainSecondary() > 0 && bCmEConsumerListRangeRA0.getRangeGainSecondary() < 35535;
    }

    protected boolean isConsumerListRequestBlocked() {
        return this.consumerListRequestBlocked;
    }

    private void setConsumerListRequestBlocked(boolean bl) {
        this.consumerListRequestBlocked = bl;
    }

    private void updateConsumerListModel(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        BaseListModelApp baseListModelApp = this.prepareConsumerListModelCopy(bCmEListUpdateInfo);
        if (bCmEConsumerListRangeRA0Array != null && bCmEConsumerListRangeRA0Array.length > 0) {
            int n = this.getConsumerArrayLength(bCmEConsumerListRangeRA0Array, baseListModelApp);
            for (int i2 = 0; i2 < n; ++i2) {
                BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0 = bCmEConsumerListRangeRA0Array[i2];
                if (bCmEConsumerListRangeRA0 != null && this.isConsumerValid(bCmEConsumerListRangeRA0)) {
                    this.lastSentListUpdateInfo.startElement = bCmEConsumerListRangeRA0.getPos();
                    this.appendNewConsumerListEntry(baseListModelApp, this.uniqueIDCounter, bCmEConsumerListRangeRA0.getConsumer());
                    if (this.tempConsumerChoiceModels != null && this.uniqueIDCounter < this.tempConsumerChoiceModels.length) {
                        ConsumerListEntry consumerListEntry = ConsumerListEntry.mapDSIConsumerToListEntry(bCmEConsumerListRangeRA0.getConsumer());
                        this.tempConsumerChoiceModels[this.uniqueIDCounter].setValue(consumerListEntry.getHmiConsumerID());
                    }
                    ++this.uniqueIDCounter;
                    continue;
                }
                this.getLogChannel().log(100000, "[ConsumerListHandler#updateConsumerListModel] data['%1'] is null or with invalid range", (long)i2);
            }
            this.getConsumerListModel().update(baseListModelApp);
            this.sendConsumerListFollowUpRequest(baseListModelApp.getLength());
        } else {
            this.getLogChannel().log(100000, "[ConsumerListHandler#updateConsumerListModel] BCmEConsumerList[] consumerarray is empty --> BaseList is cleared");
        }
    }

    private int getNrOfMissingElements(int n) {
        int n2 = 0;
        if (this.getMaxNrDisplayableConsumers() <= this.getTotalNrOfConsumers()) {
            if (n < this.getMaxNrDisplayableConsumers()) {
                n2 = this.getMaxNrDisplayableConsumers() - n;
            }
        } else if (n < this.getTotalNrOfConsumers()) {
            n2 = this.getTotalNrOfConsumers() - n;
        }
        return n2 >= 0 ? n2 : 0;
    }

    private void sendConsumerListFollowUpRequest(int n) {
        int n2 = this.getNrOfMissingElements(n);
        if (this.getNumberOfValidConsumers() != 0 && n2 > 0 && this.getNumberOfValidConsumers() != this.getMaxNrDisplayableConsumers() - n2) {
            BCmEListUpdateInfo bCmEListUpdateInfo = new BCmEListUpdateInfo();
            bCmEListUpdateInfo.arrayContent = 2;
            bCmEListUpdateInfo.startElement = this.lastSentListUpdateInfo.startElement;
            bCmEListUpdateInfo.recordContent = this.consumerListRecordContent;
            bCmEListUpdateInfo.numOfElements = n2 <= this.getMaxNrTransmittableConsumers() ? n2 : this.getMaxNrTransmittableConsumers();
            bCmEListUpdateInfo.transactionID = this.lastSentListUpdateInfo.transactionID + 1;
            bCmEListUpdateInfo.asgID = 1;
            this.requestConsumerList(bCmEListUpdateInfo, "sendConsumerListFollowUpRequest");
        } else {
            this.setLastSentListUpdateInfo(null);
        }
    }

    private void appendNewConsumerListEntry(BaseListModelApp baseListModelApp, int n, int n2) {
        ConsumerListEntry consumerListEntry = ConsumerListEntry.mapDSIConsumerToListEntry(n2);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractConsumerDisplayComponent#updateConsumerListModel] add BCmE consumer to list: dsiConsumerID='%1' , consumerName='%2' , hmiConsumerIdentifier='%3' , uniqueRowID='%4'", (Object)new Integer(n2), (Object)consumerListEntry.getConsumerName(), (Object)new Integer(consumerListEntry.getHmiConsumerID()), (long)n);
        }
        EvoListRow evoListRow = new EvoListRow(n, 1);
        evoListRow.setInteger(0, consumerListEntry.getHmiConsumerID());
        baseListModelApp.append(evoListRow);
    }

    private int getConsumerArrayLength(Object[] objectArray, BaseListModelApp baseListModelApp) {
        int n = objectArray.length;
        int n2 = this.getMaxNrDisplayableConsumers() - baseListModelApp.getLength();
        if (n > n2) {
            n = n2 > 0 ? n2 : 0;
        }
        return n;
    }

    private BaseListModelApp prepareConsumerListModelCopy(BCmEListUpdateInfo bCmEListUpdateInfo) {
        if (bCmEListUpdateInfo.arrayContent == 1) {
            this.getConsumerListModel().removeAll();
            this.resetTempChoiceModels();
            this.resetUniqueIDCounter();
        }
        return this.getConsumerListModel().getCopy();
    }

    private void resetTempChoiceModels() {
        for (int i2 = 0; i2 < this.tempConsumerChoiceModels.length; ++i2) {
            this.tempConsumerChoiceModels[i2].setValue(-1);
        }
    }

    private AbstractConsumerDisplayComponent getConsumerComponent() {
        return this.consumerComponent;
    }

    private BaseListModelApp getConsumerListModel() {
        return this.consumerListModel;
    }

    private BCmEListUpdateInfo getLastSentListUpdateInfo() {
        return this.lastSentListUpdateInfo;
    }

    private void setLastSentListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo) {
        this.lastSentListUpdateInfo = bCmEListUpdateInfo;
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    private void resetUniqueIDCounter() {
        this.uniqueIDCounter = 0;
    }

    public static class ConsumerListEntry {
        public static final int HMI_CONSUMER_LIST_ENTRY_UNDEFINED = -1;
        public static final int HMI_CONSUMER_LIST_ENTRY_CLIMATECONTROLUNIT = 0;
        public static final int HMI_CONSUMER_LIST_ENTRY_AUXHEATER = 1;
        public static final int HMI_CONSUMER_LIST_ENTRY_REARWINDOWHEATER = 2;
        public static final int HMI_CONSUMER_LIST_ENTRY_SEATHEATINGFRONTLEFT = 3;
        public static final int HMI_CONSUMER_LIST_ENTRY_SEATHEATINGFRONTRIGHT = 4;
        public static final int HMI_CONSUMER_LIST_ENTRY_SEATVENTILATIONFRONTLEFT = 5;
        public static final int HMI_CONSUMER_LIST_ENTRY_SEATVENTILATIONFRONTRIGHT = 6;
        public static final int HMI_CONSUMER_LIST_ENTRY_NECKHEATINGLEFT = 7;
        public static final int HMI_CONSUMER_LIST_ENTRY_NECKHEATINGRIGHT = 8;
        public static final int HMI_CONSUMER_LIST_ENTRY_FOGLIGHTFRONT = 9;
        public static final int HMI_CONSUMER_LIST_ENTRY_FOGLIGHTREAR = 10;
        public static final int HMI_CONSUMER_LIST_ENTRY_FRONTWINDOWHEATING = 11;
        public static final int HMI_CONSUMER_LIST_ENTRY_STEERINGWHEELHEATING = 12;
        public static final int HMI_CONSUMER_LIST_ENTRY_MIRRORHEATING = 13;
        public static final int HMI_CONSUMER_LIST_ENTRY_SEATHEATINGREAR = 14;
        public static final int HMI_CONSUMER_LIST_ENTRY_SEATVENTILATIONREAR = 15;
        public static final int HMI_CONSUMER_LIST_ENTRY_220VPLUGIN = 16;
        public static final int HMI_CONSUMER_LIST_ENTRY_THERMOCUPHOLDER = 17;
        final String consumerName;
        final int hmiConsumerID;

        public ConsumerListEntry(String string, int n) {
            this.consumerName = string;
            this.hmiConsumerID = n;
        }

        public String getConsumerName() {
            return this.consumerName;
        }

        public int getHmiConsumerID() {
            return this.hmiConsumerID;
        }

        public static ConsumerListEntry mapDSIConsumerToListEntry(int n) {
            if (n == 1) {
                return new ConsumerListEntry("Climate Control Unit", 0);
            }
            if (n == 2) {
                return new ConsumerListEntry("Aux Heater", 1);
            }
            if (n == 3) {
                return new ConsumerListEntry("Rear Window Heater", 2);
            }
            if (n == 4) {
                return new ConsumerListEntry("Seat Heating Front Left", 3);
            }
            if (n == 5) {
                return new ConsumerListEntry("Seat Heating Front Right", 4);
            }
            if (n == 6) {
                return new ConsumerListEntry("Seat Ventilation Front Left", 5);
            }
            if (n == 7) {
                return new ConsumerListEntry("Seat Ventilation Front Right", 6);
            }
            if (n == 8) {
                return new ConsumerListEntry("Neck Heating Left", 7);
            }
            if (n == 9) {
                return new ConsumerListEntry("Neck Heating Right", 8);
            }
            if (n == 10) {
                return new ConsumerListEntry("Fog Light Front", 9);
            }
            if (n == 11) {
                return new ConsumerListEntry("Fog Light Rear", 10);
            }
            if (n == 12) {
                return new ConsumerListEntry("Front Window Heating", 11);
            }
            if (n == 13) {
                return new ConsumerListEntry("Steering Wheel Heating", 12);
            }
            if (n == 14) {
                return new ConsumerListEntry("Mirror Heating", 13);
            }
            if (n == 15) {
                return new ConsumerListEntry("Seat Heating Rear", 14);
            }
            if (n == 16) {
                return new ConsumerListEntry("Seat Ventilation Rear", 15);
            }
            if (n == 17) {
                return new ConsumerListEntry("220V Plugin", 16);
            }
            if (n == 18) {
                return new ConsumerListEntry("Thermo Cupholder", 17);
            }
            return new ConsumerListEntry("Undefined Consumer", -1);
        }
    }
}

