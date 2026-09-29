/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$1;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$DsiDictationAdapterListener$1;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$DsiDictationAdapterListener$2;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;

class DictationStateManager$DsiDictationAdapterListener
extends DsiDictationAdapterEmptyListener {
    private final /* synthetic */ DictationStateManager this$0;

    private DictationStateManager$DsiDictationAdapterListener(DictationStateManager dictationStateManager) {
        this.this$0 = dictationStateManager;
    }

    @Override
    public void updateActivationState(int n) {
        DictationStateManager.access$700(this.this$0).execute(new DictationStateManager$DsiDictationAdapterListener$1(this, n));
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
        DictationStateManager.access$700(this.this$0).execute(new DictationStateManager$DsiDictationAdapterListener$2(this, bl));
    }

    /* synthetic */ DictationStateManager$DsiDictationAdapterListener(DictationStateManager dictationStateManager, DictationStateManager$1 dictationStateManager$1) {
        this(dictationStateManager);
    }

    static /* synthetic */ DictationStateManager access$400(DictationStateManager$DsiDictationAdapterListener dictationStateManager$DsiDictationAdapterListener) {
        return dictationStateManager$DsiDictationAdapterListener.this$0;
    }
}

