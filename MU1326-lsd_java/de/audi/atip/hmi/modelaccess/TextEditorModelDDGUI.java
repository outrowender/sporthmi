/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.log.LogChannel;

public interface TextEditorModelDDGUI {
    default public void notifyTextChanged(int n) {
    }

    default public void notifyMaxTextLengthChanged() {
    }

    default public void notifyAlternativeSelected(int n) {
    }

    default public LogChannel getModelLogChannel() {
    }
}

