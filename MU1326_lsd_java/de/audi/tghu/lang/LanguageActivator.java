/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.LanguageManagerDiag
 */
package de.audi.tghu.lang;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.i18n.I18NTarget;
import de.audi.tghu.lang.LanguageManager;
import de.mib.swdiagnosis.LanguageManagerDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class LanguageActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ServiceRegistration sregDiagApp;
    private ServiceTracker tracker;
    private LanguageManager langMngr;
    static /* synthetic */ Class class$de$audi$atip$diag$IDiagnosisApp;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public LanguageActivator() {
        super("LangChange");
    }

    public LanguageManager getService() {
        return this.langMngr;
    }

    protected void startInternal(BundleContext bundleContext) {
        this.langMngr = new LanguageManager(this.framework);
        this.sregDiagApp = bundleContext.registerService(new String[]{(class$de$audi$atip$diag$IDiagnosisApp == null ? (class$de$audi$atip$diag$IDiagnosisApp = LanguageActivator.class$("de.audi.atip.diag.IDiagnosisApp")) : class$de$audi$atip$diag$IDiagnosisApp).getName(), (class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = LanguageActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName()}, (Object)this.langMngr, null);
        bundleContext.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = LanguageActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.langMngr, null);
        this.tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = LanguageActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = LanguageActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void stop(BundleContext bundleContext) {
        if (this.sregDiagApp != null) {
            this.sregDiagApp.unregister();
            this.sregDiagApp = null;
        }
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        this.langMngr = null;
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof I18NTarget) {
            String string = (String)serviceReference.getProperty("LANG_COMPONENT_TYPE");
            String string2 = (String)serviceReference.getProperty("NOTIFY_BY_REGISTRATION_STRATEGY");
            this.langMngr.addI18NTarget((I18NTarget)object, string, string2);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new LanguageManagerDiag(this.framework));
        } else {
            return null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (!(object instanceof I18NTarget)) {
            return;
        }
        this.langMngr.removeI18NTarget((I18NTarget)object);
        this.bundleContext.ungetService(serviceReference);
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

