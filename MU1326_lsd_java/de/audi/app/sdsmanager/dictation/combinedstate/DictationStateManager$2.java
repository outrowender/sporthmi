/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager;

class DictationStateManager$2
implements Runnable {
    private final /* synthetic */ DictationStateManager this$0;

    DictationStateManager$2(DictationStateManager dictationStateManager) {
        this.this$0 = dictationStateManager;
    }

    @Override
    public void run() {
        DictationStateManager.access$300(this.this$0).log(1078071040, "[DictationStateManager#indicateEndOfSpeech]");
        DictationStateManager.access$200(this.this$0, false);
    }
}

