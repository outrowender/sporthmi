/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.i18n.Language;
import de.audi.tuner.app.LanguageManager$ILanguageChangeListener;
import de.audi.tuner.app.rsdb.LogoDatabase;
import de.audi.tuner.app.rsdb.LogoDatabase$1;

class LogoDatabase$LanguageChangeListener
implements LanguageManager$ILanguageChangeListener {
    private final /* synthetic */ LogoDatabase this$0;

    private LogoDatabase$LanguageChangeListener(LogoDatabase logoDatabase) {
        this.this$0 = logoDatabase;
    }

    @Override
    public void languageChanged(Language language) {
        LogoDatabase.access$200(this.this$0, language.getLanguageCode());
        if (LogoDatabase.access$300(this.this$0)) {
            LogoDatabase.access$400(this.this$0);
        }
    }

    /* synthetic */ LogoDatabase$LanguageChangeListener(LogoDatabase logoDatabase, LogoDatabase$1 logoDatabase$1) {
        this(logoDatabase);
    }
}

