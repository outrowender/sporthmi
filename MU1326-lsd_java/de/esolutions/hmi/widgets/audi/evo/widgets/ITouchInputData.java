/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;

public interface ITouchInputData
extends IInputTextInfoProvider {
    default public void setPasswordMode(boolean bl) {
    }

    default public void clear(boolean bl) {
    }

    default public int getCursorPos() {
    }

    default public void setKbdType(int n) {
    }

    default public void setCaseBalanced(boolean bl) {
    }

    default public void setUpperCaseOnly(boolean bl) {
    }

    default public String doCaseBalancingForSuggestion(String string) {
    }

    default public void moveCursor(int n) {
    }

    default public char insertString(String string, String[] stringArray, boolean bl) {
    }

    default public void hideCharacters() {
    }

    default public boolean delete(boolean bl) {
    }

    default public String buildModelString() {
    }

    default public void insertAutoCompletion(String string) {
    }

    default public void registerDataChangeListener(ITouchInputDataChangeHandler iTouchInputDataChangeHandler) {
    }

    default public void unregisterDataChangeListener(ITouchInputDataChangeHandler iTouchInputDataChangeHandler) {
    }

    default public void setMaximumTextLength(int n) {
    }

    default public int getMaximumTextLength() {
    }

    default public void setMinimumTextLength(int n) {
    }

    default public int getMinimumTextLength() {
    }
}

