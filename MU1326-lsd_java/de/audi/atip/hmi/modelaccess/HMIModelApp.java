/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.model.DragAndDropListener;
import de.audi.atip.hmi.model.IDragAndDropHandler;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelBase;

public interface HMIModelApp
extends HMIModelBase {
    public static final int STATUS_WAITING;
    public static final int STATUS_OK;
    public static final int STATUS_ERROR;
    public static final int STATUS_VALUE_NOT_APPLICABLE;

    default public void setStatus(int n) {
    }

    default public void addHint(int n) {
    }

    default public void removeHint(int n) {
    }

    default public void resetHints() {
    }

    default public void publishHints() {
    }

    default public void abortTransaction() {
    }

    default public void beginTransaction() {
    }

    default public void endTransaction() {
    }

    default public boolean isTransactionRunning() {
    }

    default public boolean fireEvent(int n) {
    }

    default public boolean fireEvent(int n, AdditionalScreenData additionalScreenData) {
    }

    default public void resetListener() {
    }

    default public void setDragAndDropHandler(IDragAndDropHandler iDragAndDropHandler) {
    }

    default public void setDragAndDropListener(DragAndDropListener dragAndDropListener) {
    }

    default public void trigger(ModelTrigger modelTrigger, int n) {
    }

    default public void setModelGroup(ModelGroup modelGroup) {
    }
}

