/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.i18n;

import de.audi.atip.i18n.ILanguageUIHandler;
import de.audi.atip.i18n.Language;

public interface ILanguageManager {
    public Language getCurrentLanguage(String var1);

    public Language[] getAvailableLanguages(String var1);

    public void updateAvailableLanguages(String var1, String[] var2);

    public void init(boolean var1);

    public void responseSetLanguage(String var1, boolean var2);

    public boolean isLeftToRightOrientation();

    public void setLanguageUIHandler(ILanguageUIHandler var1);

    public void checkAndSetNewLanguage(Language var1);
}

