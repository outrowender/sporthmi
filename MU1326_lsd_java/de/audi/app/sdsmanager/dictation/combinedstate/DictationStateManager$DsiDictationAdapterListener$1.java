/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$DsiDictationAdapterListener;

class DictationStateManager$DsiDictationAdapterListener$1
implements Runnable {
    private final /* synthetic */ int val$activationState;
    private final /* synthetic */ DictationStateManager$DsiDictationAdapterListener this$1;

    DictationStateManager$DsiDictationAdapterListener$1(DictationStateManager$DsiDictationAdapterListener dictationStateManager$DsiDictationAdapterListener, int n) {
        this.this$1 = dictationStateManager$DsiDictationAdapterListener;
        this.val$activationState = n;
    }

    @Override
    public void run() {
        DictationStateManager.access$500(DictationStateManager$DsiDictationAdapterListener.access$400(this.this$1)).log(-2137614336, "[DictationStateManager#updateActivationState] activationState = %1", (long)this.val$activationState);
        DictationStateManager.access$600(DictationStateManager$DsiDictationAdapterListener.access$400(this.this$1), this.val$activationState);
    }
}

