/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.language;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.language.LanguageManager;
import de.audi.app.sdsmanager.dictation.language.LanguageManager$1;

class LanguageManager$DsiDictationAdapterListener
extends DsiDictationAdapterEmptyListener {
    private final /* synthetic */ LanguageManager this$0;

    private LanguageManager$DsiDictationAdapterListener(LanguageManager languageManager) {
        this.this$0 = languageManager;
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
        LanguageManager.access$100(this.this$0).log(-2137614336, "[LanguageManager$DsiDictationAdapterListener#updateDsiAvailability] dsiAvailable = %1", bl);
        LanguageManager.access$202(this.this$0, bl);
        if (bl) {
            LanguageManager.access$300(this.this$0);
        }
    }

    /* synthetic */ LanguageManager$DsiDictationAdapterListener(LanguageManager languageManager, LanguageManager$1 languageManager$1) {
        this(languageManager);
    }
}

