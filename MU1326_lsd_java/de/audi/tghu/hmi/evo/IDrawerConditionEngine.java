/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.ComponentConditionEvent;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;

public interface IDrawerConditionEngine {
    default public void spellerActive(boolean bl) {
    }

    default public void activateDrawer(IDrawerControllerEvo iDrawerControllerEvo, long[] lArray) {
    }

    default public void processCCEvent(ComponentConditionEvent componentConditionEvent) {
    }

    default public void setFocusedProperty(IFocusedPropertyObject iFocusedPropertyObject) {
    }

    default public int getTargetModelID() {
    }

    default public int getTargetRow() {
    }

    default public int getTargetWidgetID() {
    }

    default public long[] getActiveContexts() {
    }

    default public IRightDrawerActionReceiver getTargetActionReceiver() {
    }

    default public Object getInternalState() {
    }
}

