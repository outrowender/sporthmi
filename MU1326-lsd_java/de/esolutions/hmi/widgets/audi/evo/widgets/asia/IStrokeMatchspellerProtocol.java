/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeConversionsAvailableListener;

public interface IStrokeMatchspellerProtocol
extends IStrokeConversionsAvailableListener {
    default public void strokesChanged(String string, char c2) {
    }

    default public String getStrokes() {
    }

    default public void requestValidHanziCharsWindow(int n, int n2) {
    }

    default public int getTotalAmountOfHanziCharacters() {
    }

    default public void setStrokeConversionsAvailableListener(IStrokeConversionsAvailableListener iStrokeConversionsAvailableListener) {
    }

    default public String getValidHanziCharsWindowResult() {
    }

    default public void notifyModelTextValueChanged() {
    }
}

