/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.i18n;

import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.i18n.Language;

public interface ILanguageUIHandler {
    public void updateFlag();

    public void updateListSelection();

    public void setWaiting();

    public void langChangeFinished();

    public void executeLanguageChange(Language var1);

    public void initModels();

    public void setLanguageManager(ILanguageManager var1);
}

