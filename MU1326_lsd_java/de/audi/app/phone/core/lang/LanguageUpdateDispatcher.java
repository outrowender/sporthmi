/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.lang;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.lang.ILanguageUpdateDispatcher;
import de.audi.app.phone.core.lang.ILanguageUpdateListener;
import de.audi.app.phone.core.lang.LanguageUpdateDispatcher$1;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class LanguageUpdateDispatcher
implements ILanguageUpdateDispatcher,
I18NTarget {
    private final LogChannel logChannel;
    private final PhoneServiceProvider i18nServiceProvider;
    private final ArrayList listeners;
    private final TelEventQueue telEventQueue;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public LanguageUpdateDispatcher(ITelApplication iTelApplication, BundleContext bundleContext, LogChannel logChannel, TelEventQueue telEventQueue) {
        this.logChannel = logChannel;
        this.listeners = new ArrayList(5);
        this.i18nServiceProvider = new PhoneServiceProvider((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = LanguageUpdateDispatcher.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), this, null, bundleContext, logChannel);
        this.telEventQueue = telEventQueue;
    }

    @Override
    public void init() {
        this.logChannel.log(-2137614336, "[LanguageUpdateDispatcher#init] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.i18nServiceProvider.setProperties(hashtable);
        this.i18nServiceProvider.startService();
    }

    @Override
    public void deinit() {
        this.logChannel.log(-2137614336, "[LanguageUpdateDispatcher#deinit] called");
        this.i18nServiceProvider.stopService();
        this.listeners.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addLanguageUpdateListener(ILanguageUpdateListener iLanguageUpdateListener) {
        this.logChannel.log(-2137614336, "[LanguageUpdateDispatcher#addLanguageUpdateListener] adding '%1'", (Object)iLanguageUpdateListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iLanguageUpdateListener)) {
                this.logChannel.log(-2137614336, "[LanguageUpdateDispatcher#addLanguageUpdateListener] listener already added");
                return;
            }
            this.listeners.add(iLanguageUpdateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeLanguageUpdateListener(ILanguageUpdateListener iLanguageUpdateListener) {
        this.logChannel.log(-2137614336, "[LanguageUpdateDispatcher#removeLanguageUpdateListener] removing '%1'", (Object)iLanguageUpdateListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (!this.listeners.contains(iLanguageUpdateListener)) {
                this.logChannel.log(-1601830656, "[LanguageUpdateDispatcher#removeLanguageUpdateListener] listener is not in the list");
                return;
            }
            this.listeners.remove(iLanguageUpdateListener);
        }
    }

    @Override
    public void setLanguage(Language language) {
        this.telEventQueue.enqueue(new LanguageUpdateDispatcher$1(this, language.getLanguageName(), language));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(LanguageUpdateDispatcher languageUpdateDispatcher) {
        return languageUpdateDispatcher.logChannel;
    }

    static /* synthetic */ ArrayList access$100(LanguageUpdateDispatcher languageUpdateDispatcher) {
        return languageUpdateDispatcher.listeners;
    }
}

