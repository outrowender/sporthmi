/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TpegKRActionProxy
extends ActionProxy {
    public void tpegInfoMenuEntered(int var1);

    public void tpegEnterPreviewMapScreen(int var1);

    public void tpegExitPreviewMapScreen(int var1);

    public void tpegEnterRRD(int var1);

    public void tpegExitRRD(int var1);
}

