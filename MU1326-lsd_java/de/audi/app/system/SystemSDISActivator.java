/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.SDISSystemDiag
 */
package de.audi.app.system;

import de.audi.app.system.HeadUnitASIProvider;
import de.audi.app.system.InstanceASIProvider;
import de.audi.app.system.MasterControlASIProvider;
import de.audi.app.system.SystemSDISActivator$1;
import de.audi.app.system.SystemSDISEnv;
import de.audi.atip.activator.AbstractActivator;
import de.audi.mib.jdsi.DSIActivator;
import de.mib.swdiagnosis.SDISSystemDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SystemSDISActivator
extends AbstractActivator {
    private SystemSDISEnv env = null;
    private MasterControlASIProvider masterControlASIProvider = null;
    private HeadUnitASIProvider headUnitASIProvider = null;
    private InstanceASIProvider instanceASIProvider = null;
    private SDISSystemDiag sdisSystemDiag = null;
    private ServiceTracker tracker = null;
    private DSIActivator carTimeActivator = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVStateListener;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISHeadUnitService;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDISConnectionStateListener;

    private final SystemSDISEnv getEnv() {
        return this.env;
    }

    private final boolean isClassAvailable(String string) {
        boolean bl = true;
        try {
            Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.env.getLog().log(-1601830656, "isClassAvailable() - class '%1' not found!", (Object)string);
            bl = false;
        }
        return bl;
    }

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.env = new SystemSDISEnv(this.getFramework());
        if (!this.getEnv().isSDISEnabled()) {
            return;
        }
        if (this.isClassAvailable("de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceAbstractBaseService")) {
            this.instanceASIProvider = new InstanceASIProvider(this.getFramework(), this.getEnv(), 0);
            this.instanceASIProvider.start();
            this.registerService((class$de$audi$atip$interapp$tv$ITVStateListener == null ? (class$de$audi$atip$interapp$tv$ITVStateListener = SystemSDISActivator.class$("de.audi.atip.interapp.tv.ITVStateListener")) : class$de$audi$atip$interapp$tv$ITVStateListener).getName(), (Object)this.instanceASIProvider.getInstanceDataContainer(), null);
            this.registerService(new String[]{(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = SystemSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName()}, (Object)this.instanceASIProvider, null);
        }
        this.masterControlASIProvider = new MasterControlASIProvider(this.getEnv(), 0);
        this.registerService(new String[]{(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = SystemSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SystemSDISActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = SystemSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService).getName()}, (Object)this.masterControlASIProvider, null);
        this.headUnitASIProvider = new HeadUnitASIProvider(this.getEnv(), 0);
        Hashtable hashtable = new Hashtable();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        hashtable.put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        this.registerService(new String[]{(class$de$audi$atip$interapp$sdis$ISDISHeadUnitService == null ? (class$de$audi$atip$interapp$sdis$ISDISHeadUnitService = SystemSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISHeadUnitService")) : class$de$audi$atip$interapp$sdis$ISDISHeadUnitService).getName(), (class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = SystemSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = SystemSDISActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (Object)this.headUnitASIProvider, (Dictionary)hashtable);
        this.carTimeActivator = new DSIActivator(this.getFramework(), (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = SystemSDISActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = SystemSDISActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener).getName(), new Integer(0), this.headUnitASIProvider, this.headUnitASIProvider);
        this.carTimeActivator.start(bundleContext);
        this.tracker = new ServiceTracker(this.bundleContext, new String[]{(class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = SystemSDISActivator.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), (class$de$audi$atip$interapp$sdis$ISDISBlockingListener == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingListener = SystemSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingListener")) : class$de$audi$atip$interapp$sdis$ISDISBlockingListener).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = SystemSDISActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$SDISConnectionStateListener == null ? (class$de$audi$atip$interapp$SDISConnectionStateListener = SystemSDISActivator.class$("de.audi.atip.interapp.SDISConnectionStateListener")) : class$de$audi$atip$interapp$SDISConnectionStateListener).getName()}, (ServiceTrackerCustomizer)new SystemSDISActivator$1(this));
        this.tracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        if (this.carTimeActivator != null) {
            this.carTimeActivator.stop(bundleContext);
            this.carTimeActivator = null;
        }
        if (this.instanceASIProvider != null) {
            this.instanceASIProvider.stop();
            this.instanceASIProvider = null;
        }
        this.masterControlASIProvider = null;
        this.headUnitASIProvider = null;
        this.sdisSystemDiag = null;
        this.env = null;
        super.stop(bundleContext);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ BundleContext access$000(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.bundleContext;
    }

    static /* synthetic */ MasterControlASIProvider access$100(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.masterControlASIProvider;
    }

    static /* synthetic */ SDISSystemDiag access$202(SystemSDISActivator systemSDISActivator, SDISSystemDiag sDISSystemDiag) {
        systemSDISActivator.sdisSystemDiag = sDISSystemDiag;
        return systemSDISActivator.sdisSystemDiag;
    }

    static /* synthetic */ SystemSDISEnv access$300(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.getEnv();
    }

    static /* synthetic */ HeadUnitASIProvider access$400(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.headUnitASIProvider;
    }

    static /* synthetic */ InstanceASIProvider access$500(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.instanceASIProvider;
    }

    static /* synthetic */ SDISSystemDiag access$200(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.sdisSystemDiag;
    }

    static /* synthetic */ BundleContext access$600(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$700(SystemSDISActivator systemSDISActivator) {
        return systemSDISActivator.bundleContext;
    }
}

