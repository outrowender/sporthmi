/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.ComponentConditionEvent;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;

public interface IDrawerConditionEngine {
    public void spellerActive(boolean var1);

    public void activateDrawer(IDrawerControllerEvo var1, long[] var2);

    public void processCCEvent(ComponentConditionEvent var1);

    public void setFocusedProperty(IFocusedPropertyObject var1);

    public int getTargetModelID();

    public int getTargetRow();

    public int getTargetWidgetID();

    public long[] getActiveContexts();

    public IRightDrawerActionReceiver getTargetActionReceiver();

    public Object getInternalState();
}

