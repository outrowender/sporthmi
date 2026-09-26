/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.LanguageManager$1;

class LanguageManager$MyI18N
implements I18NTarget {
    private final /* synthetic */ LanguageManager this$0;

    private LanguageManager$MyI18N(LanguageManager languageManager) {
        this.this$0 = languageManager;
    }

    @Override
    public void setLanguage(Language language) {
        LanguageManager.access$100(this.this$0, language);
    }

    /* synthetic */ LanguageManager$MyI18N(LanguageManager languageManager, LanguageManager$1 languageManager$1) {
        this(languageManager);
    }
}

