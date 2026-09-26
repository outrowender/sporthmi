/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager;

class DictationStateManager$1
implements Runnable {
    private final /* synthetic */ DictationStateManager this$0;

    DictationStateManager$1(DictationStateManager dictationStateManager) {
        this.this$0 = dictationStateManager;
    }

    @Override
    public void run() {
        DictationStateManager.access$100(this.this$0).log(1078071040, "[DictationStateManager#indicateStartOfSpeech]");
        DictationStateManager.access$200(this.this$0, true);
    }
}

