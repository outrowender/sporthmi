/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.sds.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.AbstractSysSMM;
import de.audi.tghu.sds.sm.SDComponentFactory;
import de.audi.tghu.sds.sm.SDSSMM;
import de.audi.tghu.sds.sm.SDSSMMActions;
import de.audi.tghu.sds.sm.SDSStateComponents;
import de.audi.tghu.sds.sm.SDTextFactory;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator
extends AbstractSMMActivator {
    private ServiceRegistration svRegI18N;
    private ServiceRegistration svRegPromptTextService;
    private SDTextFactory sdTextFactory;
    private SDComponentFactory sdComponentFactory;
    private LogChannel logChan;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$hmi$SDPromptTextAccess;

    public void init() {
        this.smmList = new SDSSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[6] = new SDSSMM(this.framework, 6, "speech");
            this.logChan = ((AbstractSysSMM)this.smmList[6]).getLogChannel();
            this.reqActionProxies = SDSSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
        }
    }

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        if (this.framework.isFrontMU()) {
            this.sdTextFactory = new SDTextFactory(this.framework.getHMIService(), this.logChan, this.framework, this);
            this.sdTextFactory.setLanguage(this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI"));
            this.sdComponentFactory = new SDComponentFactory(this.logChan);
            this.sdComponentFactory.setSDTextFactory(this.sdTextFactory);
            this.sdComponentFactory.setHMIService(this.framework.getHMIService());
            SDSStateComponents.getInstance().setLogChannel(this.logChan);
            SDSStateComponents.getInstance().setComponentFactory(this.sdComponentFactory);
            Hashtable hashtable = new Hashtable(2);
            hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_TTS");
            this.svRegI18N = bundleContext.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = Activator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.sdTextFactory, (Dictionary)hashtable);
        }
    }

    public void stop(BundleContext bundleContext) {
        if (this.framework.isFrontMU()) {
            if (this.svRegI18N != null) {
                this.svRegI18N.unregister();
            }
            this.unregisterSDPromptTextAccess();
        }
        super.stop(bundleContext);
    }

    public void registerSDPromptTextAccess() {
        this.svRegPromptTextService = this.bundleContext.registerService((class$de$audi$atip$hmi$SDPromptTextAccess == null ? (class$de$audi$atip$hmi$SDPromptTextAccess = Activator.class$("de.audi.atip.hmi.SDPromptTextAccess")) : class$de$audi$atip$hmi$SDPromptTextAccess).getName(), (Object)this.sdTextFactory, (Dictionary)new Hashtable());
    }

    public void unregisterSDPromptTextAccess() {
        if (this.svRegPromptTextService != null) {
            this.svRegPromptTextService.unregister();
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

