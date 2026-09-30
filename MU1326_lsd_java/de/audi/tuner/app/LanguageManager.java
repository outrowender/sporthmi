/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerProxyManager;
import java.text.Collator;

public class LanguageManager {
    final I18NTarget i18NListener = new MyI18N();
    private volatile Collator collator = Collator.getInstance();
    private final ChoiceModelApp arabicLanguageActiveChoice;
    private ILanguageChangeListener[] languageChangeListeners = new ILanguageChangeListener[0];
    private Language language = null;
    private final Object mutex = new Object();

    public LanguageManager(TunerBasics tunerBasics) {
        this.arabicLanguageActiveChoice = tunerBasics.getModels().getChoiceModel(100705);
    }

    public Collator getCollator() {
        return this.collator;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addLanguageChangedListener(ILanguageChangeListener iLanguageChangeListener) {
        Language language;
        Object object = this.mutex;
        synchronized (object) {
            ILanguageChangeListener[] iLanguageChangeListenerArray = new ILanguageChangeListener[this.languageChangeListeners.length + 1];
            System.arraycopy((Object)this.languageChangeListeners, 0, (Object)iLanguageChangeListenerArray, 0, this.languageChangeListeners.length);
            iLanguageChangeListenerArray[this.languageChangeListeners.length] = iLanguageChangeListener;
            this.languageChangeListeners = iLanguageChangeListenerArray;
            language = this.language;
        }
        if (language != null) {
            iLanguageChangeListener.languageChanged(language);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onI18NSetLanguage(Language language) {
        ILanguageChangeListener[] iLanguageChangeListenerArray;
        this.collator = Collator.getInstance(language.getLocale());
        this.collator.setStrength(0);
        this.arabicLanguageActiveChoice.setValue(language.getLanguageCode() == "ar_SA" ? 1 : 0);
        TunerProxyManager.getInstance().getAmFmTuner().performLanguageChange();
        TunerProxyManager.getInstance().getDABTuner().performLanguageChange();
        TunerProxyManager.getInstance().getUnifiedTuner().performLanguageChange();
        Object object = this.mutex;
        synchronized (object) {
            this.language = language;
            iLanguageChangeListenerArray = this.languageChangeListeners;
        }
        for (int i2 = 0; i2 < iLanguageChangeListenerArray.length; ++i2) {
            iLanguageChangeListenerArray[i2].languageChanged(language);
        }
    }

    private class MyI18N
    implements I18NTarget {
        private MyI18N() {
        }

        public void setLanguage(Language language) {
            LanguageManager.this.onI18NSetLanguage(language);
        }
    }

    public static interface ILanguageChangeListener {
        public void languageChanged(Language var1);
    }
}

