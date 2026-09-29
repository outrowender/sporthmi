/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.swdl.AbstractSwdlDiagnosisGateway
 *  de.mib.swdiagnosis.swdl.SwdlDiagnosisGatewayEvo
 */
package de.audi.app.swdl;

import de.audi.app.swdl.CustDownloadActionProxyEvo;
import de.audi.app.swdl.SwdlActionProxyEvo;
import de.audi.app.swdl.SwdlJoinedDownloadStateEvo;
import de.audi.app.swdl.SwdlTextFactoryEvo;
import de.audi.app.swdl.evo.hmiswitcher.manager.PopupManagerEvo;
import de.audi.app.swdl.evo.hmiswitcher.manager.customer.CustomerProgressManagerEvo;
import de.audi.app.swdl.evo.hmiswitcher.manager.engineering.EngineeringDeviceInfoManagerEvo;
import de.audi.app.swdl.evo.hmiswitcher.manager.engineering.EngineeringProgressManagerEvo;
import de.audi.app.swdl.evo.hmiswitcher.manager.engineering.EngineeringSelectionManagerEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.swdl.app.AbstractSWDLActivator;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.uota.UOTAControllerEvo;
import de.audi.tghu.swdl.app.customer.uota.UotANavListenerImpl;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;
import de.audi.tghu.swdl.app.hmiswitcher.HMIContainer;
import de.audi.tghu.swdl.app.hmiswitcher.HMISwitcher;
import de.audi.tghu.swdl.app.hmiswitcher.manager.NullLoggingManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerSelectionManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.EngineeringLoggingManager;
import de.mib.swdiagnosis.swdl.AbstractSwdlDiagnosisGateway;
import de.mib.swdiagnosis.swdl.SwdlDiagnosisGatewayEvo;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class SwdlActivator
extends AbstractSWDLActivator
implements ServiceTrackerCustomizer {
    static /* synthetic */ Class class$de$audi$atip$interapp$navuota$UotaNavListener;
    static /* synthetic */ Class class$de$audi$atip$base$ComponentStateListener;
    static /* synthetic */ Class class$de$audi$atip$statemachine$ActionProxy;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.swdlEnv = new SwdlEnv(this.getFramework(), new SwdlTextFactoryEvo());
        this.abstractSwdlJoinedDownloadState = new SwdlJoinedDownloadStateEvo(this.swdlEnv);
        UOTAControllerEvo uOTAControllerEvo = new UOTAControllerEvo(this.swdlEnv);
        Hashtable hashtable = new Hashtable(1);
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$navuota$UotaNavListener == null ? (class$de$audi$atip$interapp$navuota$UotaNavListener = SwdlActivator.class$("de.audi.atip.interapp.navuota.UotaNavListener")) : class$de$audi$atip$interapp$navuota$UotaNavListener).getName());
        UotANavListenerImpl uotANavListenerImpl = new UotANavListenerImpl(uOTAControllerEvo, this.swdlEnv.getLogUota());
        this.registerService((class$de$audi$atip$interapp$navuota$UotaNavListener == null ? (class$de$audi$atip$interapp$navuota$UotaNavListener = SwdlActivator.class$("de.audi.atip.interapp.navuota.UotaNavListener")) : class$de$audi$atip$interapp$navuota$UotaNavListener).getName(), (Object)uotANavListenerImpl, (Dictionary)hashtable);
        this.swdlDSIManager = new SwdlDSIManager(this.swdlEnv, this.abstractSwdlJoinedDownloadState, uOTAControllerEvo);
        this.abstractPopupManager = new PopupManagerEvo(this.swdlEnv, this.abstractSwdlJoinedDownloadState, this.swdlDSIManager.getProgressDSIHandler());
        this.abstractCustDownloadActionProxy = new CustDownloadActionProxyEvo(this.swdlEnv, this.swdlDSIManager);
        this.registerService((class$de$audi$atip$base$ComponentStateListener == null ? (class$de$audi$atip$base$ComponentStateListener = SwdlActivator.class$("de.audi.atip.base.ComponentStateListener")) : class$de$audi$atip$base$ComponentStateListener).getName(), (Object)this.abstractCustDownloadActionProxy.getDriverResetHandler(), null);
        this.initHmiSwitcher();
        this.initDownloadState();
        this.swdlDSIManager.initDSIHandlers();
        this.swdlActionProxy = new SwdlActionProxyEvo(this.swdlEnv, this.hmiSwitcher, this.abstractSwdlJoinedDownloadState, this.abstractPopupManager, this.swdlDSIManager.getDeviceInfoDSIHandler(), this.swdlDSIManager.getProgressDSIHandler(), this.swdlEnv.getTextFactory());
        this.initServiceConnections();
    }

    private void initDownloadState() {
        ChoiceModelApp choiceModelApp;
        this.hmiSwitcher.switchToEngineeringHmi();
        this.swdlEnv.getSwdlModels().getDeviceStatusEnteredChoice().setStatus(0);
        if (!this.swdlEnv.isEngineeringDownloadActive() && !this.swdlEnv.isRebootToDownload() && null != (choiceModelApp = this.swdlEnv.getSwdlModels().getStartDownloadDisabled())) {
            choiceModelApp.setValue(1);
        }
    }

    private void initHmiSwitcher() {
        EngineeringDeviceInfoManagerEvo engineeringDeviceInfoManagerEvo = new EngineeringDeviceInfoManagerEvo(this.swdlEnv, this.abstractPopupManager, this.swdlDSIManager.getDeviceInfoDSIHandler(), this.swdlDSIManager.getSelectionDSIHandler());
        EngineeringSelectionManagerEvo engineeringSelectionManagerEvo = new EngineeringSelectionManagerEvo(this.swdlEnv, this.abstractSwdlJoinedDownloadState, this.abstractPopupManager, engineeringDeviceInfoManagerEvo, this.swdlDSIManager.getSelectionDSIHandler(), this.swdlDSIManager.getDeviceInfoDSIHandler(), this.swdlDSIManager.getProgressDSIHandler());
        EngineeringProgressManagerEvo engineeringProgressManagerEvo = new EngineeringProgressManagerEvo(this.swdlEnv, this.abstractSwdlJoinedDownloadState, this.abstractPopupManager, engineeringDeviceInfoManagerEvo, engineeringSelectionManagerEvo, this.swdlDSIManager.getProgressDSIHandler(), this.swdlDSIManager.getDeviceInfoDSIHandler(), this.swdlDSIManager.getSelectionDSIHandler());
        EngineeringLoggingManager engineeringLoggingManager = new EngineeringLoggingManager(this.swdlEnv, this.abstractPopupManager, engineeringDeviceInfoManagerEvo, this.swdlDSIManager.getLoggingDSIHandler());
        HMIContainer hMIContainer = new HMIContainer(0, engineeringSelectionManagerEvo, engineeringDeviceInfoManagerEvo, engineeringProgressManagerEvo, engineeringLoggingManager);
        HMIContainer hMIContainer2 = null;
        if (!this.swdlEnv.isEngineeringDownloadActive() && !this.swdlEnv.isRebootToDownload()) {
            CustomerDeviceInfoManager customerDeviceInfoManager = new CustomerDeviceInfoManager(this.swdlEnv, this.abstractPopupManager, this.swdlDSIManager.getDeviceInfoDSIHandler());
            CustomerProgressManagerEvo customerProgressManagerEvo = new CustomerProgressManagerEvo(this.abstractCustDownloadActionProxy, this.swdlEnv, this.abstractPopupManager, customerDeviceInfoManager, this.swdlDSIManager.getProgressDSIHandler());
            CustomerSelectionManager customerSelectionManager = new CustomerSelectionManager(this.swdlEnv, this.abstractPopupManager, customerDeviceInfoManager, customerProgressManagerEvo, this.swdlDSIManager.getDeviceInfoDSIHandler(), this.swdlDSIManager.getSelectionDSIHandler(), this.abstractCustDownloadActionProxy.getDriverResetHandler());
            customerDeviceInfoManager.setCustomerSelectionManager(customerSelectionManager);
            customerDeviceInfoManager.setCustomerProgressManager(customerProgressManagerEvo);
            hMIContainer2 = new HMIContainer(1, customerSelectionManager, customerDeviceInfoManager, customerProgressManagerEvo, new NullLoggingManager());
        }
        this.hmiSwitcher = new HMISwitcher(this.swdlEnv, this.abstractSwdlJoinedDownloadState, this.swdlDSIManager, hMIContainer, hMIContainer2);
        this.swdlEnv.setHMISwitcher(this.hmiSwitcher);
    }

    private void initServiceConnections() {
        this.registerBaseServices();
        this.registerActionProxies();
        this.initTracker();
        this.swdlEnv.startDSIServices();
    }

    private void registerActionProxies() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(15));
        this.registerService(new String[]{(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = SwdlActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName()}, (Object)this.swdlActionProxy, (Dictionary)hashtable);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("moduleID", new Integer(22));
        this.registerService(new String[]{(class$de$audi$atip$statemachine$ActionProxy == null ? (class$de$audi$atip$statemachine$ActionProxy = SwdlActivator.class$("de.audi.atip.statemachine.ActionProxy")) : class$de$audi$atip$statemachine$ActionProxy).getName()}, (Object)this.abstractCustDownloadActionProxy, (Dictionary)hashtable2);
    }

    @Override
    protected AbstractSwdlDiagnosisGateway getDiagnosisGateway() {
        if (null == this.swdlDiagnosisGateway) {
            this.swdlDiagnosisGateway = new SwdlDiagnosisGatewayEvo(this.swdlEnv, this.abstractSwdlJoinedDownloadState, this.abstractPopupManager, this.swdlDSIManager, this.abstractPopupManager.getId());
        }
        return this.swdlDiagnosisGateway;
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

