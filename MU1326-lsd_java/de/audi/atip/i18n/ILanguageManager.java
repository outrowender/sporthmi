/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.i18n;

import de.audi.atip.i18n.ILanguageUIHandler;
import de.audi.atip.i18n.Language;

public interface ILanguageManager {
    default public Language getCurrentLanguage(String string) {
    }

    default public Language[] getAvailableLanguages(String string) {
    }

    default public void updateAvailableLanguages(String string, String[] stringArray) {
    }

    default public void init(boolean bl) {
    }

    default public void responseSetLanguage(String string, boolean bl) {
    }

    default public boolean isLeftToRightOrientation() {
    }

    default public void setLanguageUIHandler(ILanguageUIHandler iLanguageUIHandler) {
    }

    default public void checkAndSetNewLanguage(Language language) {
    }
}

