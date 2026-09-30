/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeConversionsAvailableListener;

public interface IStrokeMatchspellerProtocol
extends IStrokeConversionsAvailableListener {
    public void strokesChanged(String var1, char var2);

    public String getStrokes();

    public void requestValidHanziCharsWindow(int var1, int var2);

    public int getTotalAmountOfHanziCharacters();

    public void setStrokeConversionsAvailableListener(IStrokeConversionsAvailableListener var1);

    public String getValidHanziCharsWindowResult();

    public void notifyModelTextValueChanged();
}

