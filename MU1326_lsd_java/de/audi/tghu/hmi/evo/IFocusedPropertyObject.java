/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;

public interface IFocusedPropertyObject {
    public int getCategory();

    public int[] getProperties();

    public void setModelID(int var1);

    public int getModelID();

    public void setWidgetID(int var1);

    public int getRow();

    public int getWidgetID();

    public IRightDrawerActionReceiver getActionReceiverWidget();

    public void setActionReceiverWidget(IRightDrawerActionReceiver var1);
}

