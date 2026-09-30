/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.log.LogChannel;

public interface TextEditorModelDDGUI {
    public void notifyTextChanged(int var1);

    public void notifyMaxTextLengthChanged();

    public void notifyAlternativeSelected(int var1);

    public LogChannel getModelLogChannel();
}

