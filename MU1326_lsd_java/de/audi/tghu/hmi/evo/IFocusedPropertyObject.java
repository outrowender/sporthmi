/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;

public interface IFocusedPropertyObject {
    default public int getCategory() {
    }

    default public int[] getProperties() {
    }

    default public void setModelID(int n) {
    }

    default public int getModelID() {
    }

    default public void setWidgetID(int n) {
    }

    default public int getRow() {
    }

    default public int getWidgetID() {
    }

    default public IRightDrawerActionReceiver getActionReceiverWidget() {
    }

    default public void setActionReceiverWidget(IRightDrawerActionReceiver iRightDrawerActionReceiver) {
    }
}

