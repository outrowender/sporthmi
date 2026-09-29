/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.i18n;

import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.i18n.Language;

public interface ILanguageUIHandler {
    default public void updateFlag() {
    }

    default public void updateListSelection() {
    }

    default public void setWaiting() {
    }

    default public void langChangeFinished() {
    }

    default public void executeLanguageChange(Language language) {
    }

    default public void initModels() {
    }

    default public void setLanguageManager(ILanguageManager iLanguageManager) {
    }
}

