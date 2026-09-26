/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$DsiDictationAdapterListener;

class DictationStateManager$DsiDictationAdapterListener$2
implements Runnable {
    private final /* synthetic */ boolean val$dsiAvailable;
    private final /* synthetic */ DictationStateManager$DsiDictationAdapterListener this$1;

    DictationStateManager$DsiDictationAdapterListener$2(DictationStateManager$DsiDictationAdapterListener dictationStateManager$DsiDictationAdapterListener, boolean bl) {
        this.this$1 = dictationStateManager$DsiDictationAdapterListener;
        this.val$dsiAvailable = bl;
    }

    @Override
    public void run() {
        DictationStateManager.access$800(DictationStateManager$DsiDictationAdapterListener.access$400(this.this$1)).log(-2137614336, "[DictationStateManager#updateDsiAvailability] dsiAvailable = %1", this.val$dsiAvailable);
        DictationStateManager.access$900(DictationStateManager$DsiDictationAdapterListener.access$400(this.this$1), this.val$dsiAvailable);
    }
}

