/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.cc.ComponentConditionManager;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModelBank;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.DragAndDropListener;
import de.audi.atip.hmi.model.FallbackDragAndDropHandler;
import de.audi.atip.hmi.model.FallbackDragAndDropListener;
import de.audi.atip.hmi.model.FallbackListener;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.IDragAndDropHandler;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.modelaccess.ModelInternals;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.ModelStatistics;
import de.esolutions.fw.util.commons.Buffer;
import java.io.PrintStream;

public abstract class AbstractModel
implements HMIModel,
ModelInternals {
    public static final byte NO_EVENT_ID;
    private static final LogChannel[] LOG_CHANNELS;
    public static ModelStatistics statistics;
    protected final LogChannel lc;
    protected static final FallbackListener DUMMY_LISTENER;
    protected final int id;
    protected final Object mutex = this;
    protected final int eventID;
    private volatile int references;
    private volatile int changeState;
    protected volatile IDragAndDropHandler handler = FallbackDragAndDropHandler.INSTANCE;
    protected volatile DragAndDropListener dndListener = FallbackDragAndDropListener.INSTANCE;
    private int status = 1;
    private int hints;
    private ModelGroup modelGroup;
    private int terminalID = -1;
    private int variant = 0;
    private volatile ComponentConditionManager conditionsObserver;
    private int linkedConditionsCount = 0;

    protected AbstractModel(int n, int n2) {
        this.eventID = n2;
        this.id = n;
        int n3 = n / -1601830656;
        this.lc = LOG_CHANNELS[n3];
    }

    protected AbstractModel(int n) {
        this(n, 0);
    }

    @Override
    public abstract void resetListener() {
    }

    public String toString() {
        return new Buffer(100).append(super.toString()).append("_ID:").append(this.id).append("_HT:").append(this.terminalID).toString();
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append("\n");
        buffer.append(super.toString()).append('\n');
        buffer.append("ModelID: ").append(this.id).append('\n');
        buffer.append("terminal: ").append(this.terminalID).append('\n');
        buffer.append("status: ").append(this.status).append('\n');
        buffer.append("hints: ").append(Integer.toBinaryString(this.hints)).append(" (binary)");
        return buffer.toString();
    }

    protected final void logException(String string, Exception exception) {
        this.logException(string, null, exception);
    }

    protected final void logException(String string, Buffer buffer, Exception exception) {
        Buffer buffer2 = new Buffer();
        buffer2.append('{').append(this.id).append("} [").append(this.getName()).append('.').append(string).append(']');
        String string2 = buffer != null ? buffer.toString() : "";
        this.lc.log(10000, "%1 %2", (Object)buffer2, (Object)string2);
        this.lc.log(10000, "%1", (Object)buffer2, (Throwable)exception);
        this.lc.log(10000, "%1 %2", (Object)buffer2, (Object)this.dumpContent());
    }

    protected void copy(AbstractModel abstractModel) {
        this.status = abstractModel.status;
        this.variant = abstractModel.variant;
        this.setChangeState(abstractModel.getChangeState());
    }

    protected void setChangeState(int n) {
        this.changeState = n;
    }

    protected void stateChanged() {
        ++this.changeState;
    }

    public int getEventID() {
        return this.eventID;
    }

    protected void fireModelUpdateEvent(int n) {
        this.fireModelUpdateEvent(n, 0, 0, null);
    }

    protected void fireModelUpdateEvent(int n, int n2) {
        this.fireModelUpdateEvent(n, n2, 0, null);
    }

    protected void fireModelUpdateEvent(ModelUpdateData modelUpdateData) {
        this.fireModelUpdateEvent(modelUpdateData.getUpdateType(), 0, 0, modelUpdateData);
    }

    protected void fireModelUpdateEvent(ModelUpdateData modelUpdateData, int n) {
        this.fireModelUpdateEvent(modelUpdateData.getUpdateType(), n, 0, modelUpdateData);
    }

    protected void fireModelUpdateEvent(int n, int n2, int n3) {
        this.fireModelUpdateEvent(n, n2, n3, null);
    }

    protected void fireModelUpdateEvent(int n, int n2, int n3, ModelUpdateData modelUpdateData) {
        if (this.connected()) {
            HMIService hMIService = AbstractModelBank.getHMIservice();
            if (hMIService == null) {
                return;
            }
            ModelUpdateEvent modelUpdateEvent = hMIService.getModelUpdateEvent(this.terminalID);
            modelUpdateEvent.setModelId(this.getID());
            modelUpdateEvent.setModelType(this.getModelType());
            modelUpdateEvent.setUpdateType(n);
            modelUpdateEvent.setHints(this.hints);
            modelUpdateEvent.setClientData1(n2);
            modelUpdateEvent.setClientData2(n3);
            modelUpdateEvent.setClientData3(modelUpdateData);
            this.postEvent(hMIService, modelUpdateEvent);
        } else {
            this.updateConditionsObserver();
        }
    }

    private void updateConditionsObserver() {
        this.lc.log(14808325, "(%3) [AbstractModel.updateConditionsObserver] connected:%1 conditionsObserver:%2", (Object)this.connected(), (Object)this.conditionsObserver, (long)this.id);
        if (this.conditionsObserver != null) {
            if (-1 == this.terminalID) {
                this.conditionsObserver.modelStateChanged(this.id, 0);
            } else {
                this.conditionsObserver.modelStateChanged(this.id, this.terminalID);
            }
        }
    }

    protected void postEvent(HMIService hMIService, ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (statistics != null) {
            if (n == 2) {
                statistics.countStateChanged(this.getID());
            } else if (n == 1) {
                statistics.countValueChanged(this.getID());
            }
        }
        if (this.isForceUpdateEnabled()) {
            modelUpdateEvent.setForceUpdateActivated(true);
        }
        this.updateConditionsObserver();
        if (this.modelGroup == null) {
            AbstractModelBank.getEventLogChannel().log(-2137614336, "model (m%1) posts update event (u%2) ", (long)this.id, (long)n);
            hMIService.postModelUpdateEvent(modelUpdateEvent);
        } else {
            try {
                this.modelGroup.addEvent(modelUpdateEvent);
            }
            catch (NullPointerException nullPointerException) {
                AbstractModelBank.getEventLogChannel().log(10000, "ModelGroup is null! Model (m%1) posts update event (u%2) ", (long)this.id, (long)n);
                hMIService.postModelUpdateEvent(modelUpdateEvent);
            }
        }
    }

    @Override
    public boolean connected() {
        return this.references > 0;
    }

    @Override
    public void setModelGroup(ModelGroup modelGroup) {
        this.modelGroup = modelGroup;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addCondition(int n, ComponentConditionManager componentConditionManager) {
        this.lc.log(14808325, "(%1) [AbstractModel.addCondition] ccID:%2", (long)this.id, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.conditionsObserver = componentConditionManager;
            ++this.linkedConditionsCount;
        }
        if (this.linkedConditionsCount == 1) {
            this.updateConditionsObserver();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeCondition(int n) {
        this.lc.log(14808325, "(%1) [AbstractModel.removeCondition] %2", (long)this.id, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            --this.linkedConditionsCount;
            if (this.linkedConditionsCount == 0) {
                this.conditionsObserver = null;
            }
        }
        if (this.conditionsObserver == null) {
            this.lc.log(14808325, "(%1) [AbstractModel.removeCondition] set observer to null", (long)this.id);
        }
    }

    protected final boolean isInUseByConditions() {
        return this.conditionsObserver != null;
    }

    @Override
    public void deferredConnected() {
        this.fireModelUpdateEvent(14);
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public int getHints() {
        return this.hints;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        String string = super.getClass().getName();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    @Override
    public void addReference() {
        ++this.references;
    }

    @Override
    public void removeReference() {
        --this.references;
        if (this.references < 0) {
            this.references = 0;
        }
    }

    @Override
    public int getChangeState() {
        return this.changeState;
    }

    @Override
    public void setStatus(int n) {
        this.status = n;
        this.fireModelUpdateEvent(2, n);
    }

    @Override
    public void addHint(int n) {
        this.hints |= n;
    }

    @Override
    public void removeHint(int n) {
        this.hints &= ~n;
    }

    @Override
    public void resetHints() {
        this.hints = 0;
    }

    @Override
    public void publishHints() {
        this.fireModelUpdateEvent(18, this.hints);
    }

    @Override
    public void beginTransaction() {
        throw new IllegalStateException();
    }

    @Override
    public void abortTransaction() {
        throw new IllegalStateException();
    }

    @Override
    public void endTransaction() {
        throw new IllegalStateException();
    }

    @Override
    public boolean isTransactionRunning() {
        return false;
    }

    @Override
    public boolean fireEvent(int n) {
        return this.fireEvent(n, null);
    }

    @Override
    public boolean fireEvent(int n, AdditionalScreenData additionalScreenData) {
        HMIService hMIService = AbstractModelBank.getHMIservice();
        if (hMIService != null) {
            AbstractModelBank.getEventLogChannel().log(-2137614336, "[%1] [AbstractModel.fireEvent] main:%2", (long)this.id, (long)n);
            hMIService.fireSMEventFromModelId(n, this.id, additionalScreenData);
            return true;
        }
        return false;
    }

    public static void reset() {
        if (statistics != null) {
            statistics.reset();
        }
    }

    public static void dump(PrintStream printStream) {
        if (statistics != null) {
            statistics.dump(printStream);
        }
    }

    protected void handleListenerException(Exception exception) {
        this.lc.log(10000, "(%2) %1: Calling listener failed!", (Object)this.getName(), (long)this.id);
        this.lc.log(10000, "ERROR: ", (Throwable)exception);
        if (statistics != null) {
            statistics.addModelException(this.id, exception);
        }
    }

    @Override
    public int getTerminalID() {
        return this.terminalID;
    }

    public void setTerminalID(int n) {
        this.terminalID = n;
    }

    public boolean isForceUpdateEnabled() {
        return false;
    }

    @Override
    public void setDragAndDropHandler(IDragAndDropHandler iDragAndDropHandler) {
        this.handler = iDragAndDropHandler != null ? iDragAndDropHandler : FallbackDragAndDropHandler.INSTANCE;
        this.handler.addListener(this.dndListener);
    }

    @Override
    public void setDragAndDropListener(DragAndDropListener dragAndDropListener) {
        this.dndListener = dragAndDropListener;
        this.handler.addListener(dragAndDropListener);
    }

    @Override
    public void trigger(ModelTrigger modelTrigger, int n) {
        this.lc.log(-2137614336, "%1.trigger] ModelTrigger: %2  ClientData: %3", (Object)new Buffer().append('{').append(this.id).append("} [").append(this.getName()).toString(), (Object)modelTrigger, (long)n);
        if (this.connected()) {
            this.fireModelUpdateEvent(modelTrigger, n);
        }
    }

    @Override
    public int startDrag(int n, long l, int n2) {
        return this.handler.startDrag(n, l, n2);
    }

    @Override
    public void stopDrag(int n, long l, long l2) {
        this.handler.stopDrag(n, l, this.id, l2);
    }

    @Override
    public void drop(int n, long l, long l2, int n2, int n3) {
        this.handler.drop(n, l, this.id, l2, n2, n3);
    }

    static {
        LOG_CHANNELS = new LogChannel[]{AbstractModelBank.getLogChannel("Fw.Models.System"), AbstractModelBank.getLogChannel("Fw.Models.Radio"), AbstractModelBank.getLogChannel("Fw.Models.Media"), AbstractModelBank.getLogChannel("Fw.Models.Phone"), AbstractModelBank.getLogChannel("Fw.Models.Navi"), AbstractModelBank.getLogChannel("Fw.Models.Info"), AbstractModelBank.getLogChannel("Fw.Models.Car"), AbstractModelBank.getLogChannel("Fw.Models.Addressbook"), AbstractModelBank.getLogChannel("Fw.Models.NavAsia"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Tone"), AbstractModelBank.getLogChannel("Fw.Models.Settings"), AbstractModelBank.getLogChannel("Fw.Models.PicNav"), AbstractModelBank.getLogChannel("Fw.Models.Eng"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Swdl"), AbstractModelBank.getLogChannel("Fw.Models.Bluetooth"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.EarlyApps"), AbstractModelBank.getLogChannel("Fw.Models.Messaging"), AbstractModelBank.getLogChannel("Fw.Models.Online"), AbstractModelBank.getLogChannel("Fw.Models.TestSupport"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Home"), AbstractModelBank.getLogChannel("Fw.Models.Misc"), AbstractModelBank.getLogChannel("Fw.Models.Terminalmode"), AbstractModelBank.getLogChannel("Fw.Models.Ecall"), AbstractModelBank.getLogChannel("Fw.Models.WirelessCharging"), AbstractModelBank.getLogChannel("Fw.Models.Climate")};
        statistics = null;
        DUMMY_LISTENER = new FallbackListener();
    }
}

