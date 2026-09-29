/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TpegKRActionProxy
extends ActionProxy {
    default public void tpegInfoMenuEntered(int n) {
    }

    default public void tpegEnterPreviewMapScreen(int n) {
    }

    default public void tpegExitPreviewMapScreen(int n) {
    }

    default public void tpegEnterRRD(int n) {
    }

    default public void tpegExitRRD(int n) {
    }
}

