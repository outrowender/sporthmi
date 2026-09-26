/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sds.evo.SDSMappingEvo;
import de.audi.app.sds.evo.SystemCallActionProxyImplEvo;
import de.audi.app.sds.evo.syscall.SystemCallNamesEvo;
import de.audi.app.sds.evo.testsupport.SLMRulesMapEvo;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.common.SDSStrategyAbstractFactory;
import de.audi.app.sdsmanager.testsupport.SLMRulesMap;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SDSManagerActivator
extends SDSManagerBaseActivator
implements ServiceTrackerCustomizer {
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext, new SDSMappingEvo());
        SDSManagerBaseActivator.setSystemCallNames(new SystemCallNamesEvo());
    }

    @Override
    protected void registerSysCallAP(BundleContext bundleContext) {
        SystemCallActionProxyImplEvo systemCallActionProxyImplEvo = new SystemCallActionProxyImplEvo();
        systemCallActionProxyImplEvo.setSDSListener(this.sdsAdapter);
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(17));
        bundleContext.registerService(new String[]{(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = SDSManagerActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName()}, (Object)systemCallActionProxyImplEvo, (Dictionary)hashtable);
    }

    @Override
    protected SDSStrategyAbstractFactory createSDSStrategyAbstractFactory() {
        return new SDSStrategyAbstractFactory();
    }

    @Override
    protected SLMRulesMap createSLMRulesMap() {
        return new SLMRulesMapEvo();
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

