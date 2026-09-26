/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang;

import de.audi.app.settings.timeunitslang.LanguageUIHandler;
import de.audi.atip.i18n.Language;

class LanguageUIHandler$1
implements Runnable {
    private final /* synthetic */ Language val$newLanguage;
    private final /* synthetic */ LanguageUIHandler this$0;

    LanguageUIHandler$1(LanguageUIHandler languageUIHandler, Language language) {
        this.this$0 = languageUIHandler;
        this.val$newLanguage = language;
    }

    @Override
    public void run() {
        this.this$0.executeLanguageChange(this.val$newLanguage);
    }
}

