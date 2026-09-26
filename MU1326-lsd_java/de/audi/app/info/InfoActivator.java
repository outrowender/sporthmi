/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info;

import de.audi.app.info.InfoActionProxyImplEvo;
import de.audi.app.info.InfoApp;
import de.audi.app.info.InfoSMEventConstantsImplEvo;
import de.audi.app.info.InfoTextConstantsImplEvo;
import de.audi.app.info.readout.InfoTMCReadOut;
import de.audi.app.info.tmc.InfoRowBuilder;
import de.audi.atip.log.LogChannel;
import de.audi.atip.variant.IIDMapper;
import de.audi.tghu.info.app.AbstractInfoActivator;
import de.audi.tghu.info.app.IInfoSMEventConstants;
import de.audi.tghu.info.app.IInfoTextConstants;
import de.audi.tghu.info.app.InfoAPImpl;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.InfoHMIApplication;
import de.audi.tghu.info.app.InfoSdsService;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.InfoStorageManager;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class InfoActivator
extends AbstractInfoActivator {
    private final IInfoTextConstants textConstantsMapper = new InfoTextConstantsImplEvo();
    private final IInfoSMEventConstants smEventConstants = new InfoSMEventConstantsImplEvo();
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        InfoEnv infoEnv = new InfoEnv(this.framework, this.textConstantsMapper, this.smEventConstants);
        this.lc = this.framework.getLogChannel("App.Info.OSGI");
        this.appTmcReadOut = new InfoTMCReadOut(this.framework.getLogChannel("App.TMC.Main.ReadOut"), this.framework.getLogChannel("App.TMC.DSI.ReadOut"), infoEnv);
        this.tmcApp = new InfoApp(infoEnv, this.appTmcReadOut);
        this.infoHMIApplication = new InfoHMIApplication(this.tmcApp, this.appTmcReadOut, this.framework.getLogChannel("App.TMC.Main"), infoEnv);
        this.appTmcReadOut.setTmcApp(this.tmcApp);
        this.appTmcReadOut.setHmiApplication(this.infoHMIApplication);
        this.appTmcReadOut.setListRowBuilder(new InfoRowBuilder(this.tmcApp, infoEnv));
        this.infoAp = this.createActionProxy(infoEnv, this.tmcApp, this.framework.getLogChannel("App.Info.AP"));
        this.sdsService = new InfoSdsService(this.tmcApp, this.framework.getLogChannel("App.Info.SDS"));
        this.storageManager = new InfoStorageManager(infoEnv, this.framework.getStorageMgr(), this.framework.getLogChannel("App.Info.Storage"));
        this.registerServices();
        this.initTracker();
        this.framework.startDSIService((class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = InfoActivator.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = InfoActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0);
        this.tmcApp.setStorageManager(this.storageManager);
        this.infoHMIApplication.setXUrgentPopupId(547424000);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        this.tmcApp = null;
        this.appTmcReadOut = null;
        this.sdsService = null;
        this.infoAp = null;
    }

    @Override
    public IIDMapper getTextConstantsMapper() {
        return this.textConstantsMapper;
    }

    @Override
    public IIDMapper getSMEventConstantsMapper() {
        return this.smEventConstants;
    }

    @Override
    protected InfoAPImpl createActionProxy(InfoEnv infoEnv, AppTMC appTMC, LogChannel logChannel) {
        return new InfoActionProxyImplEvo(infoEnv, appTMC, this.framework.getLogChannel("App.Info.AP"));
    }

    @Override
    protected void registerActionProxy(Hashtable hashtable, InfoAPImpl infoAPImpl) {
        hashtable.put("moduleID", new Integer(5));
        this.registerService((class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = InfoActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName(), (Object)infoAPImpl, (Dictionary)hashtable);
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

