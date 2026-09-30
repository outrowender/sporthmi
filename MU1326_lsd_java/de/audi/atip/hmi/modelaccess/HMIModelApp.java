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
    public static final int STATUS_WAITING = 0;
    public static final int STATUS_OK = 1;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_VALUE_NOT_APPLICABLE = 3;

    public void setStatus(int var1);

    public void addHint(int var1);

    public void removeHint(int var1);

    public void resetHints();

    public void publishHints();

    public void abortTransaction() throws IllegalStateException;

    public void beginTransaction() throws IllegalStateException;

    public void endTransaction() throws IllegalStateException;

    public boolean isTransactionRunning();

    public boolean fireEvent(int var1);

    public boolean fireEvent(int var1, AdditionalScreenData var2);

    public void resetListener();

    public void setDragAndDropHandler(IDragAndDropHandler var1);

    public void setDragAndDropListener(DragAndDropListener var1);

    public void trigger(ModelTrigger var1, int var2);

    public void setModelGroup(ModelGroup var1);
}

