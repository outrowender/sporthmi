/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.lang;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.lang.ILanguageUpdateDispatcher;
import de.audi.app.car.common.lang.ILanguageUpdateListener;
import de.audi.app.car.common.service.CarServiceProvider;
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
    private final CarServiceProvider i18nServiceProvider;
    private final ArrayList listeners;
    private final ICarApplication application;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public LanguageUpdateDispatcher(ICarApplication iCarApplication, BundleContext bundleContext, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.application = iCarApplication;
        this.listeners = new ArrayList(5);
        this.i18nServiceProvider = new CarServiceProvider((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = LanguageUpdateDispatcher.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), this, null, bundleContext, logChannel);
    }

    @Override
    public void init() {
        this.logChannel.log(1078071040, "[LanguageUpdateDispatcher#init] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", this.application.getApplicationName());
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.i18nServiceProvider.setProperties(hashtable);
        this.i18nServiceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logChannel.log(1078071040, "[LanguageUpdateDispatcher#deinit] called");
        this.i18nServiceProvider.stopService();
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addLanguageUpdateListener(ILanguageUpdateListener iLanguageUpdateListener) {
        this.logChannel.log(1078071040, "[LanguageUpdateDispatcher#addLanguageUpdateListener] adding '%1'", (Object)iLanguageUpdateListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iLanguageUpdateListener)) {
                this.logChannel.log(1078071040, "[LanguageUpdateDispatcher#addLanguageUpdateListener] listener already added");
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
        this.logChannel.log(1078071040, "[LanguageUpdateDispatcher#removeLanguageUpdateListener] removing '%1'", (Object)iLanguageUpdateListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (!this.listeners.contains(iLanguageUpdateListener)) {
                this.logChannel.log(-1601830656, "[LanguageUpdateDispatcher#removeLanguageUpdateListener] listener is not in the list");
                return;
            }
            this.listeners.remove(iLanguageUpdateListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setLanguage(Language language) {
        ArrayList arrayList;
        this.logChannel.log(1078071040, "[LanguageUpdateDispatcher#setLanguage] language='%1'", (Object)language);
        Object object = this.listeners;
        synchronized (object) {
            arrayList = (ArrayList)this.listeners.clone();
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            ((ILanguageUpdateListener)object.next()).setLanguage(language);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

