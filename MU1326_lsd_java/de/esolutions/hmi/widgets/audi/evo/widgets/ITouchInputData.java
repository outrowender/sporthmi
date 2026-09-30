/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;

public interface ITouchInputData
extends IInputTextInfoProvider {
    public void setPasswordMode(boolean var1);

    public void clear(boolean var1);

    public int getCursorPos();

    public void setKbdType(int var1);

    public void setCaseBalanced(boolean var1);

    public void setUpperCaseOnly(boolean var1);

    public String doCaseBalancingForSuggestion(String var1);

    public void moveCursor(int var1);

    public char insertString(String var1, String[] var2, boolean var3);

    public void hideCharacters();

    public boolean delete(boolean var1);

    public String buildModelString();

    public void insertAutoCompletion(String var1);

    public void registerDataChangeListener(ITouchInputDataChangeHandler var1);

    public void unregisterDataChangeListener(ITouchInputDataChangeHandler var1);

    public void setMaximumTextLength(int var1);

    public int getMaximumTextLength();

    public void setMinimumTextLength(int var1);

    public int getMinimumTextLength();
}

