/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.MatchSpellerListener;

public interface MatchspellerListenerAsia
extends MatchSpellerListener {
    default public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
    }

    default public void inputModeTPChanged(int n, int n2, int n3) {
    }

    default public void strokesChanged(int n, int n2, String string, char c2) {
    }

    default public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
    }
}

