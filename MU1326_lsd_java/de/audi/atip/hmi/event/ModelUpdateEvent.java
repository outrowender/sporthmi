/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.esolutions.fw.util.commons.Buffer;

public class ModelUpdateEvent
extends ATIPEvent {
    public static final int MODELUPDATE_FIRST = 10301;
    public static final int MODELUPDATED = 10301;
    public static final int MODELUPDATE_LAST = 10301;
    public static final int BUTTON_MODEL = 1;
    public static final int CHOICE_MODEL = 2;
    public static final int LABEL_MODEL = 3;
    public static final int LIST_MODEL = 4;
    public static final int RANGE_MODEL = 5;
    public static final int SPELLER_MODEL = 6;
    public static final int MATCH_SPELLER_MODEL = 7;
    public static final int TEXTFIELD_MODEL = 8;
    public static final int METRIC_MODEL = 9;
    public static final int SLIDING_LIST_MODEL = 10;
    public static final int DATA_MODEL = 11;
    public static final int DYNAMIC_LIST_MODEL = 12;
    public static final int TOOLTIP_LIST_MODEL = 13;
    public static final int FAST_SCROLLING_MODEL = 14;
    public static final int SPELLER_MODEL_ASIA = 15;
    public static final int RANGE_MODEL_2D = 16;
    public static final int VIRTUAL_BUTTON_MODEL = 17;
    public static final int BROWSER_MODEL = 18;
    public static final int IP_SPELLER_MODEL = 19;
    public static final int FOLDER_LIST_MODEL = 20;
    public static final int MATCH_SPELLER_MODEL_ASIA = 21;
    public static final int RESOURCE_LOCATOR_MODEL = 22;
    public static final int TEXT_EDITOR_MODEL = 23;
    public static final int SYSCONST_MODEL = 24;
    public static final int OPTION_MODEL = 28;
    public static final int SDS_INTEGER_MODEL = 50;
    public static final int SDS_BOOLEAN_MODEL = 51;
    public static final int SDS_STRING_MODEL = 52;
    public static final int SDS_LIST_MODEL = 53;
    public static final int MODEL_GROUP = 100;
    public static final int VALUE_UPDATED = 1;
    public static final int STATUS_CHANGED = 2;
    public static final int NOTIFICATION_CHANGED = 3;
    public static final int LIMITS_CHANGED = 4;
    public static final int DIMENSION_CHANGED = 5;
    public static final int CONTENT_CHANGED = 6;
    public static final int ROW_ADDED = 7;
    public static final int ROW_CHANGED = 8;
    public static final int ROW_REMOVED = 9;
    public static final int CELL_CHANGED = 10;
    public static final int VALID_CHARS_CHANGED = 11;
    public static final int NEW_DATA_AVAILABLE = 12;
    public static final int FORMAT_CHANGED = 13;
    public static final int DEFERRED_CONNECTED = 14;
    public static final int SLIDINGLIST_FILLED_FROM_START = 15;
    public static final int TRANSACTION_FINISHED = 16;
    public static final int VALID_TP_CHARS_CHANGED = 17;
    public static final int HINTS_CHANGED = 18;
    public static final int VALID_CONVERSION_CHARS_CHANGED = 19;
    public static final int READONLY_MODE_CHANGED = 20;
    private int modelId;
    private int modelType;
    private int updateType;
    private int clientData1;
    private int clientData2;
    private ModelUpdateData clientData3;
    private int hints;
    private ModelUpdateEvent[] nestedEvents = null;
    private int terminalID;
    private boolean forceUpdateActivated = false;

    public ModelUpdateEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, n);
    }

    public ModelUpdateEvent(ATIPEventListener[] aTIPEventListenerArray, int n) {
        super(aTIPEventListenerArray, n);
    }

    public ModelUpdateEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3, int n4, int n5, int n6) {
        super(aTIPEventListener, n);
        this.modelId = n3;
        this.updateType = n4;
        this.modelType = n2;
        this.clientData1 = n5;
        this.clientData2 = n6;
    }

    public int getModelId() {
        return this.modelId;
    }

    public void setModelId(int n) {
        this.modelId = n;
    }

    public int getModelType() {
        return this.modelType;
    }

    public void setModelType(int n) {
        this.modelType = n;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int n) {
        this.updateType = n;
    }

    public int getClientData1() {
        return this.clientData1;
    }

    public void setClientData1(int n) {
        this.clientData1 = n;
    }

    public int getClientData2() {
        return this.clientData2;
    }

    public void setClientData2(int n) {
        this.clientData2 = n;
    }

    public void setClientData3(ModelUpdateData modelUpdateData) {
        this.clientData3 = modelUpdateData;
    }

    public ModelUpdateData getClientData3() {
        return this.clientData3;
    }

    public int getHints() {
        return this.hints;
    }

    public void setHints(int n) {
        this.hints = n;
    }

    public void setNestedEvents(ModelUpdateEvent[] modelUpdateEventArray) {
        this.nestedEvents = modelUpdateEventArray;
    }

    public ModelUpdateEvent[] getNestedEvents() {
        return this.nestedEvents;
    }

    String modelType2Text() {
        switch (this.getModelType()) {
            case 18: {
                return "BROWSER_MODEL";
            }
            case 1: {
                return "BUTTON_MODEL";
            }
            case 2: {
                return "CHOICE_MODEL";
            }
            case 14: {
                return "FAST_SCROLLING_MODEL";
            }
            case 3: {
                return "LABEL_MODEL";
            }
            case 4: {
                return "LIST_MODEL";
            }
            case 5: {
                return "RANGE_MODEL";
            }
            case 16: {
                return "RANGE_MODEL_2D";
            }
            case 6: {
                return "SPELLER_MODEL";
            }
            case 7: {
                return "MATCH_SPELLER_MODEL";
            }
            case 19: {
                return "IP_SPELLER_MODEL";
            }
            case 8: {
                return "TEXTFIELD_MODEL";
            }
            case 9: {
                return "METRIC_MODEL";
            }
            case 10: {
                return "SLIDING_LIST_MODEL";
            }
            case 11: {
                return "DATA_MODEL";
            }
            case 12: {
                return "DYNAMIC_LIST_MODEL";
            }
            case 13: {
                return "TOOLTIP_LIST_MODEL";
            }
            case 17: {
                return "VIRTUAL_BUTTON_MODEL";
            }
            case 100: {
                return "MODEL_GROUP";
            }
        }
        return "<UNKNOWN>";
    }

    String updateType2Text() {
        switch (this.getUpdateType()) {
            case 1: {
                return "VALUE_UPDATED";
            }
            case 2: {
                return "STATUS_CHANGED";
            }
            case 3: {
                return "NOTIFICATION_CHANGED";
            }
            case 4: {
                return "LIMITS_CHANGED";
            }
            case 5: {
                return "DIMENSION_CHANGED";
            }
            case 6: {
                return "CONTENT_CHANGED";
            }
            case 7: {
                return "ROW_ADDED";
            }
            case 8: {
                return "ROW_CHANGED";
            }
            case 9: {
                return "ROW_REMOVED";
            }
            case 10: {
                return "CELL_CHANGED";
            }
            case 11: {
                return "VALID_CHARS_CHANGED";
            }
            case 12: {
                return "NEW_DATA_AVAILABLE";
            }
            case 13: {
                return "FORMAT_CHANGED";
            }
            case 14: {
                return "DEFERRED_CONNECTED";
            }
            case 15: {
                return "SLIDINGLIST_FILLED_FROM_START";
            }
            case 16: {
                return "TRANSACTION_FINISHED";
            }
            case 17: {
                return "VALID_TP_CHARS_CHANGED";
            }
            case 18: {
                return "HINTS_CHANGED";
            }
            case 19: {
                return "TRIGGER";
            }
            case 20: {
                return "ROW_CLEARED";
            }
            case 21: {
                return "ALL_ROWS_CLEARED";
            }
            case 22: {
                return "SELECTION_CHANGED";
            }
            case 23: {
                return "ITEM_FOCUSED";
            }
        }
        return "<UNKNOWN>";
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public void setTerminalID(int n) {
        this.terminalID = n;
    }

    public boolean isForceUpdateActivated() {
        return this.forceUpdateActivated;
    }

    public void setForceUpdateActivated(boolean bl) {
        this.forceUpdateActivated = bl;
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        if (this.modelType == 100) {
            buffer.append("ModelUpdateEvent: [").append(this.getPosted()).append("]  modelType = ").append(this.modelType2Text()).append('(').append(this.getModelType()).append(") nestedModelIDs = ");
            ModelUpdateEvent[] modelUpdateEventArray = this.getNestedEvents();
            if (modelUpdateEventArray != null) {
                for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
                    buffer.append(" NestedEvent: ").append(modelUpdateEventArray[i2].getModelId());
                }
            }
        } else {
            buffer.append("ModelUpdateEvent: [").append(this.getPosted()).append("] modelId = ").append(this.getModelId()).append(" modelType = ").append(this.modelType2Text()).append('(').append(this.getModelType()).append(") updateType = ").append(this.updateType2Text()).append('(').append(this.getUpdateType()).append(')');
        }
        return buffer.toString();
    }

    public boolean alwaysPlaceInQueue() {
        switch (this.modelType) {
            case 2: {
                return false;
            }
            case 5: {
                return false;
            }
            case 3: {
                return false;
            }
            case 9: {
                return false;
            }
            case 100: {
                return false;
            }
            case 16: {
                return false;
            }
        }
        return true;
    }

    public boolean isRedundantToAlreadyQueuedEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.modelType == modelUpdateEvent.modelType && (modelUpdateEvent.getTerminalID() == -1 || this.terminalID == modelUpdateEvent.getTerminalID())) {
            if (this.modelType == 100) {
                return this.isRedundantToAlreadyQueuedModelGroupEvent(modelUpdateEvent);
            }
            if (this.updateType == 1 && this.updateType == modelUpdateEvent.updateType && this.modelId == modelUpdateEvent.modelId && this.hints == modelUpdateEvent.hints) {
                switch (this.modelType) {
                    case 2: {
                        return !this.isForceUpdateActivated();
                    }
                    case 5: {
                        return !this.isForceUpdateActivated();
                    }
                    case 3: {
                        return !this.isForceUpdateActivated();
                    }
                    case 9: {
                        return !this.isForceUpdateActivated();
                    }
                    case 16: {
                        return !this.isForceUpdateActivated();
                    }
                }
                return false;
            }
        }
        return false;
    }

    private boolean isRedundantToAlreadyQueuedModelGroupEvent(ModelUpdateEvent modelUpdateEvent) {
        ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
        if (this.nestedEvents.length == modelUpdateEventArray.length) {
            for (int i2 = 0; i2 < this.nestedEvents.length; ++i2) {
                if (this.nestedEvents[i2].isRedundantToAlreadyQueuedEvent(modelUpdateEventArray[i2])) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static interface Event {
        public static final int TRIGGER = 19;
        public static final int ROW_CLEARED = 20;
        public static final int ALL_ROWS_CLEARED = 21;
        public static final int SELECTION_CHANGED = 22;
        public static final int ITEM_FOCUSED = 23;
    }

    public static interface Model {
        public static final int BUTTON_MODEL = 1;
        public static final int CHOICE_MODEL = 2;
        public static final int LABEL_MODEL = 3;
        public static final int LIST_MODEL = 4;
        public static final int RANGE_MODEL = 5;
        public static final int SPELLER_MODEL = 6;
        public static final int MATCH_SPELLER_MODEL = 7;
        public static final int TEXTFIELD_MODEL = 8;
        public static final int METRIC_MODEL = 9;
        public static final int SLIDING_LIST_MODEL = 10;
        public static final int DATA_MODEL = 11;
        public static final int DYNAMIC_LIST_MODEL = 12;
        public static final int TOOLTIP_LIST_MODEL = 13;
        public static final int FAST_SCROLLING_MODEL = 14;
        public static final int SPELLER_MODEL_ASIA = 15;
        public static final int RANGE_MODEL_2D = 16;
        public static final int VIRTUAL_BUTTON_MODEL = 17;
        public static final int BROWSER_MODEL = 18;
        public static final int IP_SPELLER_MODEL = 19;
        public static final int FOLDER_LIST_MODEL = 20;
        public static final int MATCH_SPELLER_MODEL_ASIA = 21;
        public static final int RESOURCE_LOCATOR_MODEL = 22;
        public static final int TEXT_EDITOR_MODEL = 23;
        public static final int SYSCONST_MODEL = 24;
        public static final int BASE_LIST = 25;
        public static final int TILED_LIST = 26;
        public static final int MENU = 27;
        public static final int OPTION = 28;
        public static final int TEXT_EDITOR_MODEL_DC = 29;
        public static final int PROPERTY = 30;
        public static final int SDS_INTEGER_MODEL = 50;
        public static final int SDS_BOOLEAN_MODEL = 51;
        public static final int SDS_STRING_MODEL = 52;
        public static final int SDS_LIST_MODEL = 53;
        public static final int MODEL_GROUP = 100;
    }
}

