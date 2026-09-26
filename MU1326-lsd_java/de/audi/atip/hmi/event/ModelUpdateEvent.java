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
    public static final int MODELUPDATE_FIRST;
    public static final int MODELUPDATED;
    public static final int MODELUPDATE_LAST;
    public static final int BUTTON_MODEL;
    public static final int CHOICE_MODEL;
    public static final int LABEL_MODEL;
    public static final int LIST_MODEL;
    public static final int RANGE_MODEL;
    public static final int SPELLER_MODEL;
    public static final int MATCH_SPELLER_MODEL;
    public static final int TEXTFIELD_MODEL;
    public static final int METRIC_MODEL;
    public static final int SLIDING_LIST_MODEL;
    public static final int DATA_MODEL;
    public static final int DYNAMIC_LIST_MODEL;
    public static final int TOOLTIP_LIST_MODEL;
    public static final int FAST_SCROLLING_MODEL;
    public static final int SPELLER_MODEL_ASIA;
    public static final int RANGE_MODEL_2D;
    public static final int VIRTUAL_BUTTON_MODEL;
    public static final int BROWSER_MODEL;
    public static final int IP_SPELLER_MODEL;
    public static final int FOLDER_LIST_MODEL;
    public static final int MATCH_SPELLER_MODEL_ASIA;
    public static final int RESOURCE_LOCATOR_MODEL;
    public static final int TEXT_EDITOR_MODEL;
    public static final int SYSCONST_MODEL;
    public static final int OPTION_MODEL;
    public static final int SDS_INTEGER_MODEL;
    public static final int SDS_BOOLEAN_MODEL;
    public static final int SDS_STRING_MODEL;
    public static final int SDS_LIST_MODEL;
    public static final int MODEL_GROUP;
    public static final int VALUE_UPDATED;
    public static final int STATUS_CHANGED;
    public static final int NOTIFICATION_CHANGED;
    public static final int LIMITS_CHANGED;
    public static final int DIMENSION_CHANGED;
    public static final int CONTENT_CHANGED;
    public static final int ROW_ADDED;
    public static final int ROW_CHANGED;
    public static final int ROW_REMOVED;
    public static final int CELL_CHANGED;
    public static final int VALID_CHARS_CHANGED;
    public static final int NEW_DATA_AVAILABLE;
    public static final int FORMAT_CHANGED;
    public static final int DEFERRED_CONNECTED;
    public static final int SLIDINGLIST_FILLED_FROM_START;
    public static final int TRANSACTION_FINISHED;
    public static final int VALID_TP_CHARS_CHANGED;
    public static final int HINTS_CHANGED;
    public static final int VALID_CONVERSION_CHARS_CHANGED;
    public static final int READONLY_MODE_CHANGED;
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
}

