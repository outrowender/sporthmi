/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;

public interface IAddressInputAsiaSpecificSequence {
    default public void addStroke(String string) {
    }

    default public void undoStroke() {
    }

    default public void touchPadInputModeChanged(int n) {
    }

    default public void requestValidHanziCharsWindow(int n, int n2, int n3) {
    }

    default public void nonAlphaNumTPCharsChanged(int n, int n2, String string, MatchspellerModelApp matchspellerModelApp) {
    }
}

