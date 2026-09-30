/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface AdrActionProxy
extends ActionProxy {
    public void adrEnteredViaSpeech(int var1, int var2);

    public void adrState(int var1, int var2);

    public void adrImportListHKReturn(int var1);

    public void adrEnterPreviewMapScreen(int var1, int var2, int var3);

    public void adrExitPreviewMapScreen(int var1);
}

