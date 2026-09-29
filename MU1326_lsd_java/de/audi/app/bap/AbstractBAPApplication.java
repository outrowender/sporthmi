/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.PowerState;
import de.audi.app.bap.dsi.IDSIServiceStateListener;
import de.audi.app.bap.dsi.bap.DSIBAPController;
import de.audi.app.bap.dsi.bap.DSIBAPListenerImpl;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.request.BAPRequestHandlerImpl;
import de.audi.app.bap.fw.request.IBAPRequestHandler;
import de.audi.app.bap.utils.IBAPLogger;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.bap.DSIBAPListener;

public abstract class AbstractBAPApplication
implements PowerEventListener,
IDSIServiceStateListener {
    private final IBAPLogger logger;
    protected final LogChannel logChannel;
    protected final IFrameworkAccess frameworkAccess;
    private final Map modules;
    private volatile IBAPRequestHandler requestHandler;
    private volatile DSIBAPListener dsiBAPListener;
    private volatile IDSIBAPController dsiBAPController;
    private final PowerState pwState;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAP;

    protected AbstractBAPApplication(IFrameworkAccess iFrameworkAccess, IBAPLogger iBAPLogger) {
        this.frameworkAccess = iFrameworkAccess;
        this.logger = iBAPLogger;
        this.logChannel = iBAPLogger.getMainLog();
        this.modules = new HashMap();
        this.requestHandler = new BAPRequestHandlerImpl(this);
        this.dsiBAPController = new DSIBAPController(iBAPLogger.getDSILog());
        this.dsiBAPListener = new DSIBAPListenerImpl(this);
        this.pwState = new PowerState();
    }

    public abstract String getName() {
    }

    public IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    public IBAPLogger getLogger() {
        return this.logger;
    }

    public void setRequestHandler(IBAPRequestHandler iBAPRequestHandler) {
        this.requestHandler = iBAPRequestHandler;
    }

    public IBAPRequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public IDSIBAPController getDSIBAPController() {
        return this.dsiBAPController;
    }

    public DSIBAPListener getDSIBAPListener() {
        return this.dsiBAPListener;
    }

    public Collection getModules() {
        return this.modules.values();
    }

    public AbstractBAPModule getModule(int n) {
        return (AbstractBAPModule)this.modules.get(new Integer(n));
    }

    public void registerModule(AbstractBAPModule abstractBAPModule) {
        this.logChannel.log(-2137614336, "[AbstractBAPApplication#registerModule] registering module %1", (Object)LSGIDs.getDescription(abstractBAPModule.getLSGID()));
        this.modules.put(new Integer(abstractBAPModule.getLSGID()), abstractBAPModule);
    }

    protected void activate(AbstractActivator abstractActivator) {
        abstractActivator.registerService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractBAPApplication.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), (Object)this, null);
        this.activateModules(abstractActivator);
    }

    private void activateModules(AbstractActivator abstractActivator) {
        Iterator iterator = this.modules.values().iterator();
        while (iterator.hasNext()) {
            ((AbstractBAPModule)iterator.next()).activate(abstractActivator);
        }
    }

    protected void deactivate() {
        this.deactivateModules();
        this.dereferenceApplicationComponents();
    }

    private void deactivateModules() {
        Iterator iterator = this.modules.values().iterator();
        while (iterator.hasNext()) {
            ((AbstractBAPModule)iterator.next()).deactivate();
        }
    }

    protected void dereferenceApplicationComponents() {
        Iterator iterator = this.modules.values().iterator();
        while (iterator.hasNext()) {
            ((AbstractBAPModule)iterator.next()).destroy();
        }
        this.modules.clear();
        this.requestHandler.destroy();
        this.requestHandler = null;
        this.dsiBAPController = null;
        this.dsiBAPListener = null;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logChannel.log(-2137614336, "[AbstractBAPApplication#notifyPowerListenerOnEnterState] pwrevt=%1, terminalID=%2", (long)n, (long)n2);
        if (n2 != 0) {
            return;
        }
        if (this.pwState.getPowerState() != n) {
            this.pwState.setPowerState(n);
            Iterator iterator = this.modules.values().iterator();
            while (iterator.hasNext()) {
                ((AbstractBAPModule)iterator.next()).notifyPowerStateChanged();
            }
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
        this.logChannel.log(-2137614336, "[AbstractBAPApplication#notifyPowerListenerOnExitState] pwrevt=%1, terminalID=%2", (long)n, (long)n2);
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
        this.logChannel.log(-2137614336, "[AbstractBAPApplication#notifyPowerTriggerAction] trigger=%1, terminalID=%2", (long)n, (long)n2);
        this.pwState.setPowerStateTrigger(n);
        if (n == 7 && n2 == 0) {
            Iterator iterator = this.modules.values().iterator();
            while (iterator.hasNext()) {
                ((AbstractBAPModule)iterator.next()).notifyPowerTriggerAction();
            }
        }
    }

    public IPowerState getPowerState() {
        return this.pwState;
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    @Override
    public void notifyDSIAvailable(Class clazz, boolean bl) {
        if (clazz.equals(class$org$dsi$ifc$bap$DSIBAP == null ? (class$org$dsi$ifc$bap$DSIBAP = AbstractBAPApplication.class$("org.dsi.ifc.bap.DSIBAP")) : class$org$dsi$ifc$bap$DSIBAP) && bl) {
            Iterator iterator = this.modules.keySet().iterator();
            while (iterator.hasNext()) {
                Integer n = (Integer)iterator.next();
                this.dsiBAPController.getBAPState(n);
                ((AbstractBAPModule)this.modules.get(n)).getInitializationManager().notifyDSIAvailable(clazz, bl);
            }
        }
    }

    public void processBAPStateStatus(int n, int n2) {
        AbstractBAPModule abstractBAPModule = (AbstractBAPModule)this.modules.get(new Integer(n));
        if (abstractBAPModule != null) {
            abstractBAPModule.getInitializationManager().notifyBAPStackStateChanged(n2);
        } else {
            this.logChannel.log(-2137614336, "[AbstractBAPApplication#processBAPStateStatus] no module found for lsgID: %1", (long)n);
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

