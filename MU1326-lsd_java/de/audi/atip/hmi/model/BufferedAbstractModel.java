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
            throw new IllegalArgumentException(new StringBuffer().append("Models have different IDs ( ").append(abstractModel.getID()).append(" vs. ").append(abstractModel2.getID()).append(" )!").toString());
        }
        this.mainAbstractModel = abstractModel;
        this.tmpAbstractModel = abstractModel2;
    }

    @Override
    public void setModelGroup(ModelGroup modelGroup) {
        this.mainAbstractModel.setModelGroup(modelGroup);
    }

    @Override
    public boolean connected() {
        return this.mainAbstractModel.connected();
    }

    @Override
    public void addCondition(int n, ComponentConditionManager componentConditionManager) {
        this.mainAbstractModel.addCondition(n, componentConditionManager);
    }

    @Override
    public void removeCondition(int n) {
        this.mainAbstractModel.removeCondition(n);
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer();
        buffer.append("\nMainModel: ");
        buffer.append(this.mainAbstractModel.dumpContent());
        buffer.append("\nTmpModel: ");
        buffer.append(this.tmpAbstractModel.dumpContent());
        return buffer.toString();
    }

    @Override
    public void resetListener() {
        this.mainAbstractModel.resetListener();
        this.tmpAbstractModel.resetListener();
    }

    @Override
    public int getHints() {
        return this.mainAbstractModel.getHints();
    }

    @Override
    public String getName() {
        String string = super.getClass().getName();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    @Override
    public boolean isEmpty() {
        return this.mainAbstractModel.isEmpty();
    }

    @Override
    public void deferredConnected() {
        this.mainAbstractModel.deferredConnected();
    }

    @Override
    public int getStatus() {
        return this.mainAbstractModel.getStatus();
    }

    @Override
    public void addReference() {
        this.mainAbstractModel.addReference();
    }

    @Override
    public void removeReference() {
        this.mainAbstractModel.removeReference();
    }

    @Override
    public int getChangeState() {
        return this.mainAbstractModel.getChangeState();
    }

    @Override
    public int getID() {
        return this.mainAbstractModel.getID();
    }

    @Override
    public int getModelType() {
        return this.mainAbstractModel.getModelType();
    }

    @Override
    public void beginTransaction() {
        if (this.runningTransaction) {
            throw new IllegalStateException("A transaction is already running!");
        }
        this.runningTransaction = true;
        this.tmpAbstractModel.copy(this.mainAbstractModel);
    }

    @Override
    public void endTransaction() {
        if (this.runningTransaction) {
            this.mainAbstractModel.copy(this.tmpAbstractModel);
            this.runningTransaction = false;
        }
    }

    @Override
    public void abortTransaction() {
        this.runningTransaction = false;
    }

    @Override
    public boolean isTransactionRunning() {
        return this.runningTransaction;
    }

    @Override
    public void addHint(int n) {
        this.mainAbstractModel.addHint(n);
    }

    @Override
    public void removeHint(int n) {
        this.mainAbstractModel.removeHint(n);
    }

    @Override
    public void resetHints() {
        this.mainAbstractModel.resetHints();
    }

    @Override
    public void publishHints() {
        this.mainAbstractModel.publishHints();
    }

    @Override
    public boolean fireEvent(int n) {
        return this.getActiveModel().fireEvent(n);
    }

    @Override
    public boolean fireEvent(int n, AdditionalScreenData additionalScreenData) {
        return this.getActiveModel().fireEvent(n, additionalScreenData);
    }

    @Override
    public void setStatus(int n) {
        this.getActiveModel().setStatus(n);
    }

    @Override
    public AbstractModel getActiveModel() {
        if (this.runningTransaction) {
            return this.tmpAbstractModel;
        }
        return this.mainAbstractModel;
    }

    @Override
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

    @Override
    public int getTerminalID() {
        return this.terminalID;
    }

    public void setTerminalID(int n) {
        this.terminalID = n;
        this.mainAbstractModel.setTerminalID(n);
        this.tmpAbstractModel.setTerminalID(n);
    }

    @Override
    public int startDrag(int n, long l, int n2) {
        return this.mainAbstractModel.startDrag(n, l, n2);
    }

    @Override
    public void stopDrag(int n, long l, long l2) {
        this.mainAbstractModel.stopDrag(n, l, l2);
    }

    @Override
    public void drop(int n, long l, long l2, int n2, int n3) {
        this.mainAbstractModel.drop(n, l, l2, n2, n3);
    }

    @Override
    public void setDragAndDropHandler(IDragAndDropHandler iDragAndDropHandler) {
        this.mainAbstractModel.setDragAndDropHandler(iDragAndDropHandler);
    }

    @Override
    public void setDragAndDropListener(DragAndDropListener dragAndDropListener) {
        this.mainAbstractModel.setDragAndDropListener(dragAndDropListener);
    }

    @Override
    public void trigger(ModelTrigger modelTrigger, int n) {
        this.mainAbstractModel.trigger(modelTrigger, n);
    }
}

