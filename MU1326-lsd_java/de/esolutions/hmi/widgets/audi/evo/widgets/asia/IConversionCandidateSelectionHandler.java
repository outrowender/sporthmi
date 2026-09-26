/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.KeyEvent;

public interface IConversionCandidateSelectionHandler {
    default public void acceptConversionCandidateSelection(String string, int n) {
    }

    default public void acceptKeyEventInConversionMatrix(KeyEvent keyEvent) {
    }
}

