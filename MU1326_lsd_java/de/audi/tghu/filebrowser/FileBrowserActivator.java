/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.filebrowser.FileBrowserDiag
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.filebrowser.FileBrowserManager;
import de.mib.swdiagnosis.filebrowser.FileBrowserDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class FileBrowserActivator
extends AbstractActivator
implements BundleActivator,
ServiceTrackerCustomizer {
    private LogChannel log;
    private ServiceTracker serviceTracker;
    private ServiceReference sRefDSIFileBrowser;
    private ServiceRegistration sRefManager;
    DSIFileBrowser dsiFileBrowser;
    FileBrowserManager manager;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$DSIFileBrowser;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$DSIFileBrowserListener;
    static /* synthetic */ Class class$de$audi$tghu$filebrowser$IFileBrowserManager;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.framework.getLogChannel("Fw.FileBrowser");
        this.manager = new FileBrowserManager(this.framework);
        this.registerDSIListeners();
        this.serviceTracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$filebrowser$DSIFileBrowser == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowser = FileBrowserActivator.class$("org.dsi.ifc.filebrowser.DSIFileBrowser")) : class$org$dsi$ifc$filebrowser$DSIFileBrowser).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = FileBrowserActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$filebrowser$DSIFileBrowser == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowser = FileBrowserActivator.class$("org.dsi.ifc.filebrowser.DSIFileBrowser")) : class$org$dsi$ifc$filebrowser$DSIFileBrowser).getName(), 0);
    }

    private void registerDSIListeners() {
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = FileBrowserActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.manager, (class$org$dsi$ifc$filebrowser$DSIFileBrowserListener == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowserListener = FileBrowserActivator.class$("org.dsi.ifc.filebrowser.DSIFileBrowserListener")) : class$org$dsi$ifc$filebrowser$DSIFileBrowserListener).getName(), 0);
    }

    private void initFileBrowser(DSIFileBrowser dSIFileBrowser) {
        this.shutDownFileBrowser();
        this.manager.start(dSIFileBrowser);
        Hashtable hashtable = new Hashtable();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.sRefManager = this.bundleContext.registerService(new String[]{(class$de$audi$tghu$filebrowser$IFileBrowserManager == null ? (class$de$audi$tghu$filebrowser$IFileBrowserManager = FileBrowserActivator.class$("de.audi.tghu.filebrowser.IFileBrowserManager")) : class$de$audi$tghu$filebrowser$IFileBrowserManager).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = FileBrowserActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (Object)this.manager, (Dictionary)hashtable);
    }

    private void shutDownFileBrowser() {
        if (this.sRefManager != null) {
            this.sRefManager.unregister();
            this.sRefManager = null;
        }
        this.manager.stop();
    }

    public void stop(BundleContext bundleContext) {
        this.serviceTracker = this.closeTracker(this.serviceTracker);
        if (this.sRefDSIFileBrowser != null) {
            this.bundleContext.ungetService(this.sRefDSIFileBrowser);
            this.sRefDSIFileBrowser = null;
        }
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof DSIFileBrowser) {
            this.sRefDSIFileBrowser = serviceReference;
            this.dsiFileBrowser = (DSIFileBrowser)object;
            this.initFileBrowser(this.dsiFileBrowser);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new FileBrowserDiag(this.framework, this.manager));
        } else {
            this.log.log(10000, "tracked unwanted service=%1", object);
            return null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object == this.dsiFileBrowser) {
            this.manager.stop();
            this.bundleContext.ungetService(serviceReference);
            this.sRefDSIFileBrowser = null;
            this.dsiFileBrowser = null;
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

