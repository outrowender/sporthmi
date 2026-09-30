/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.cc.ComponentConditionManager;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.DragAndDropListener;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.IDragAndDropHandler;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ModelDiagnosis;
import de.audi.atip.hmi.modelaccess.ModelInternals;
import de.esolutions.fw.util.commons.Buffer;

public class BufferedAbstractModel
implements HMIModel,
ModelDiagnosis,
ModelInternals {
    protected final AbstractModel mainAbstractModel;
    protected final AbstractModel tmpAbstractModel;
    private volatile boolean runningTransaction;
    private int terminalID = -1;

    protected BufferedAbstractModel(AbstractModel abstractModel, AbstractModel abstractModel2) {
        if (abstractModel == null || abstractModel2 == null) {
            throw new IllegalArgumentException("At least one of given models is null!");
        }
        if (abstractModel.getID() != abstractModel2.getID()) {
            throw new IllegalArgumentException("Models have different IDs ( " + abstractModel.getID() + " vs. " + abstractModel2.getID() + " )!");
        }
        this.mainAbstractModel = abstractModel;
        this.tmpAbstractModel = abstractModel2;
    }

    public void setModelGroup(ModelGroup modelGroup) {
        this.mainAbstractModel.setModelGroup(modelGroup);
    }

    public boolean connected() {
        return this.mainAbstractModel.connected();
    }

    public void addCondition(int n, ComponentConditionManager componentConditionManager) {
        this.mainAbstractModel.addCondition(n, componentConditionManager);
    }

    public void removeCondition(int n) {
        this.mainAbstractModel.removeCondition(n);
    }

    public String dumpContent() {
        Buffer buffer = new Buffer();
        buffer.append("\nMainModel: ");
        buffer.append(this.mainAbstractModel.dumpContent());
        buffer.append("\nTmpModel: ");
        buffer.append(this.tmpAbstractModel.dumpContent());
        return buffer.toString();
    }

    public void resetListener() {
        this.mainAbstractModel.resetListener();
        this.tmpAbstractModel.resetListener();
    }

    public int getHints() {
        return this.mainAbstractModel.getHints();
    }

    public String getName() {
        String string = this.getClass().getName();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public boolean isEmpty() {
        return this.mainAbstractModel.isEmpty();
    }

    public void deferredConnected() {
        this.mainAbstractModel.deferredConnected();
    }

    public int getStatus() {
        return this.mainAbstractModel.getStatus();
    }

    public void addReference() {
        this.mainAbstractModel.addReference();
    }

    public void removeReference() {
        this.mainAbstractModel.removeReference();
    }

    public int getChangeState() {
        return this.mainAbstractModel.getChangeState();
    }

    public int getID() {
        return this.mainAbstractModel.getID();
    }

    public int getModelType() {
        return this.mainAbstractModel.getModelType();
    }

    public void beginTransaction() throws IllegalStateException {
        if (this.runningTransaction) {
            throw new IllegalStateException("A transaction is already running!");
        }
        this.runningTransaction = true;
        this.tmpAbstractModel.copy(this.mainAbstractModel);
    }

    public void endTransaction() {
        if (this.runningTransaction) {
            this.mainAbstractModel.copy(this.tmpAbstractModel);
            this.runningTransaction = false;
        }
    }

    public void abortTransaction() {
        this.runningTransaction = false;
    }

    public boolean isTransactionRunning() {
        return this.runningTransaction;
    }

    public void addHint(int n) {
        this.mainAbstractModel.addHint(n);
    }

    public void removeHint(int n) {
        this.mainAbstractModel.removeHint(n);
    }

    public void resetHints() {
        this.mainAbstractModel.resetHints();
    }

    public void publishHints() {
        this.mainAbstractModel.publishHints();
    }

    public boolean fireEvent(int n) {
        return this.getActiveModel().fireEvent(n);
    }

    public boolean fireEvent(int n, AdditionalScreenData additionalScreenData) {
        return this.getActiveModel().fireEvent(n, additionalScreenData);
    }

    public void setStatus(int n) {
        this.getActiveModel().setStatus(n);
    }

    public AbstractModel getActiveModel() {
        if (this.runningTransaction) {
            return this.tmpAbstractModel;
        }
        return this.mainAbstractModel;
    }

    public AbstractModel getInactiveModel() {
        if (this.runningTransaction) {
            return this.mainAbstractModel;
        }
        return this.tmpAbstractModel;
    }

    public int getEventID() {
        return this.mainAbstractModel.getEventID();
    }

    protected AbstractModel getMainModel() {
        return this.mainAbstractModel;
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public void setTerminalID(int n) {
        this.terminalID = n;
        this.mainAbstractModel.setTerminalID(n);
        this.tmpAbstractModel.setTerminalID(n);
    }

    public int startDrag(int n, long l, int n2) {
        return this.mainAbstractModel.startDrag(n, l, n2);
    }

    public void stopDrag(int n, long l, long l2) {
        this.mainAbstractModel.stopDrag(n, l, l2);
    }

    public void drop(int n, long l, long l2, int n2, int n3) {
        this.mainAbstractModel.drop(n, l, l2, n2, n3);
    }

    public void setDragAndDropHandler(IDragAndDropHandler iDragAndDropHandler) {
        this.mainAbstractModel.setDragAndDropHandler(iDragAndDropHandler);
    }

    public void setDragAndDropListener(DragAndDropListener dragAndDropListener) {
        this.mainAbstractModel.setDragAndDropListener(dragAndDropListener);
    }

    public void trigger(ModelTrigger modelTrigger, int n) {
        this.mainAbstractModel.trigger(modelTrigger, n);
    }
}

