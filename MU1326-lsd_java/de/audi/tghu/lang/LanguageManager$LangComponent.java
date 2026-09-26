/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.lang;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.tghu.lang.LanguageManager;
import de.audi.tghu.lang.LanguageManager$1;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

final class LanguageManager$LangComponent {
    private int status = 0;
    private Language[] availableLangs = new Language[0];
    private Language currentLang = this.this$0.getDefaultLanguageByRegion();
    private final List i18NTargets = new LinkedList();
    private final List i18NTargetsScreens = new LinkedList();
    private final /* synthetic */ LanguageManager this$0;

    private LanguageManager$LangComponent(LanguageManager languageManager) {
        this.this$0 = languageManager;
    }

    public synchronized void addI18NTarget(I18NTarget i18NTarget, String string) {
        if (i18NTarget instanceof AbstractHMIActivator) {
            if (!this.i18NTargetsScreens.contains(i18NTarget)) {
                this.i18NTargetsScreens.add(i18NTarget);
            }
        } else if (!this.i18NTargets.contains(i18NTarget)) {
            this.i18NTargets.add(i18NTarget);
            if ("UPDATE_AFTER_REGISTRATION".equals(string)) {
                try {
                    i18NTarget.setLanguage(this.currentLang);
                }
                catch (Exception exception) {
                    LanguageManager.access$600(this.this$0).log(10000, "setI18NTargetLanguage, i18NTargetsScreens - Error: %1", (Throwable)exception);
                }
                catch (Error error) {
                    LanguageManager.access$600(this.this$0).log(1000, "setI18NTargetLanguage, i18NTargetsScreens - Critical Error!");
                    error.printStackTrace();
                }
            }
        }
    }

    public synchronized void notifyListeners() {
        ListIterator listIterator = this.i18NTargetsScreens.listIterator();
        while (listIterator.hasNext()) {
            try {
                ((I18NTarget)listIterator.next()).setLanguage(this.currentLang);
            }
            catch (Exception exception) {
                LanguageManager.access$600(this.this$0).log(10000, "setI18NTargetLanguage, i18NTargetsScreens - Error: %1", (Throwable)exception);
            }
            catch (Error error) {
                LanguageManager.access$600(this.this$0).log(1000, "setI18NTargetLanguage, i18NTargetsScreens - Critical Error!");
                error.printStackTrace();
            }
        }
        listIterator = this.i18NTargets.listIterator();
        while (listIterator.hasNext()) {
            try {
                ((I18NTarget)listIterator.next()).setLanguage(this.currentLang);
            }
            catch (Exception exception) {
                LanguageManager.access$600(this.this$0).log(10000, "setI18NTargetLanguage, i18NTargets - Error: %1", (Throwable)exception);
            }
            catch (Error error) {
                LanguageManager.access$600(this.this$0).log(1000, "setI18NTargetLanguage, i18NTargets - Criticial Error!");
                error.printStackTrace();
            }
        }
    }

    public String toString() {
        return AbstractSwDiagnosis.dumpObject(this);
    }

    /* synthetic */ LanguageManager$LangComponent(LanguageManager languageManager, LanguageManager$1 languageManager$1) {
        this(languageManager);
    }

    static /* synthetic */ Language access$102(LanguageManager$LangComponent languageManager$LangComponent, Language language) {
        languageManager$LangComponent.currentLang = language;
        return languageManager$LangComponent.currentLang;
    }

    static /* synthetic */ Language[] access$200(LanguageManager$LangComponent languageManager$LangComponent) {
        return languageManager$LangComponent.availableLangs;
    }

    static /* synthetic */ int access$302(LanguageManager$LangComponent languageManager$LangComponent, int n) {
        languageManager$LangComponent.status = n;
        return languageManager$LangComponent.status;
    }

    static /* synthetic */ List access$400(LanguageManager$LangComponent languageManager$LangComponent) {
        return languageManager$LangComponent.i18NTargets;
    }

    static /* synthetic */ List access$500(LanguageManager$LangComponent languageManager$LangComponent) {
        return languageManager$LangComponent.i18NTargetsScreens;
    }

    static /* synthetic */ int access$300(LanguageManager$LangComponent languageManager$LangComponent) {
        return languageManager$LangComponent.status;
    }

    static /* synthetic */ Language[] access$202(LanguageManager$LangComponent languageManager$LangComponent, Language[] languageArray) {
        languageManager$LangComponent.availableLangs = languageArray;
        return languageArray;
    }

    static /* synthetic */ Language access$100(LanguageManager$LangComponent languageManager$LangComponent) {
        return languageManager$LangComponent.currentLang;
    }
}

