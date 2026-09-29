/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ContextManagerComponentEvo;
import de.audi.app.online.evo.DistributedServiceComponentEvo;
import de.audi.app.online.evo.OnlineBaseActionProxy;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$1;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$2;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$3;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$4;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$5;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$6;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$7;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$8;
import de.audi.app.online.evo.OnlineEvoActionProxyImpl$9;
import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.trafficlight.TrafficLightOnlineHandler;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.NaviComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IStandardController;

public class OnlineEvoActionProxyImpl
extends OnlineBaseActionProxy {
    private final RemoteHMIService remoteHmi;
    private final OnlineDestinationController myAudiHandler;
    private final ContextManagerComponent contextManagerComponent;
    private AbstractOperatorCallMain operatorCallhandler;
    private IStandardController standardController;
    private TrafficLightOnlineHandler trafficLightOnlineHandler;
    private boolean closedViaOptionDrawerCalled = false;

    public OnlineEvoActionProxyImpl(LogChannel logChannel, RemoteHMIService remoteHMIService, OnlineDestinationController onlineDestinationController, AbstractOperatorCallMain abstractOperatorCallMain, TrafficLightOnlineHandler trafficLightOnlineHandler, IStandardController iStandardController) {
        super(logChannel, remoteHMIService.getModelBankAccess());
        this.remoteHmi = remoteHMIService;
        this.myAudiHandler = onlineDestinationController;
        this.operatorCallhandler = abstractOperatorCallMain;
        this.contextManagerComponent = remoteHMIService.getContextManagerComponent();
        this.trafficLightOnlineHandler = trafficLightOnlineHandler;
        this.standardController = iStandardController;
    }

    @Override
    public void remoteHmiEnterInMap(int n) {
        if (this.remoteHmi != null) {
            if (!this.remoteHmi.isSDSRunning()) {
                this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiEnterInMap: SDS not running, calling remoteHmiEnter");
                this.remoteHmiEnter(n, 0);
            } else {
                this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiEnterInMap: not calling remotehmiEnter since SDS is running");
            }
        }
    }

    @Override
    public void remoteHmiEnter(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiEnter: called");
        this.contextManagerComponent.setWaitForApplicationValue(1);
        this.remoteHmi.setEntered(true);
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$1(this, "remotehmi-enter"));
    }

    @Override
    public void rhmiAuthenticationFinished(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#rhmiAuthenticationFinished");
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService == null) {
            this.log.log(1078071040, "OnlineEvoActionProxyImpl#rhmiAuthenticationFinished no Service");
            return;
        }
        portalAuthenticationService.indicateAuthenticationDialogFinsihed();
    }

    @Override
    public void authenticationLogoutFinished(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#authenticationLogoutFinished");
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService == null) {
            this.log.log(1078071040, "OnlineEvoActionProxyImpl#authenticationLogoutFinished no Service");
            return;
        }
        portalAuthenticationService.indicateLogoutDialogFinsihed();
    }

    @Override
    public void startOperatorCall(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#startOperatorCall %1", (long)n2);
        if (this.operatorCallhandler == null) {
            return;
        }
        this.operatorCallhandler.log(1078071040, "OnlineEvoActionProxyImpl#startOperatorCall %1", n2);
        this.operatorCallhandler.enterService(n2);
    }

    @Override
    public void leaveCallcenterCall(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#leaveCallcenterCall %1", (long)n2);
        if (this.operatorCallhandler == null) {
            return;
        }
        this.operatorCallhandler.log(1078071040, "OnlineEvoActionProxyImpl#leaveCallcenterCall %1", n2);
        this.operatorCallhandler.leaveService(n2);
    }

    @Override
    public void remoteHmiSetEntryPoint(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiSetEntryPoint: entrypoint %1", (Object)Integer.toString(n2));
        ((ContextManagerComponentEvo)this.contextManagerComponent).setLeftDrawerAvailability(n2);
        if (n2 == 4) {
            this.remoteHmi.setConnectivityContext(1);
        }
        this.remoteHmi.setEntryPointId(n2);
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$2(this, "set-entry-point", n2));
    }

    @Override
    public void remoteHmiExit(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiExit: Called");
        this.remoteHmi.setEntered(false);
        this.remoteHmi.setConnectivityContext(0);
        EntryPoint entryPoint = this.contextManagerComponent.getCurrentEntryPoint();
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(this.modelBankAccess.getCurrentViewChoiceId());
        if (entryPoint != null && entryPoint.getEntryPointId() == 1 && choiceModelApp.getStatus() == 3000) {
            this.contextManagerComponent.setIgnoreScreenConnect(true);
        }
        ((RemoteHMIServiceEvo)this.remoteHmi).getRightDrawerHandler().reinitRightDrawer();
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$3(this, "remotehmi-exit"));
        if (this.closedViaOptionDrawerCalled) {
            this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiExit: as closedViaOptionDrawerCalled was called before so adjusting view");
            ((RemoteHMIServiceEvo)this.remoteHmi).getRightDrawerHandler().resetPreviouslySelectedDrawerEntry();
            this.remoteHmi.execute(new OnlineEvoActionProxyImpl$4(this, "remotehmi-closed-via-option-drawer-settings"));
        }
    }

    @Override
    public void remoteHmiHkReturn(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiHkReturn: Called");
    }

    @Override
    public void remoteHmiHkReturnFromSelectionDrawer(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiHkReturnFromSelectionDrawer: Called");
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$5(this, "fire-return-in-scxml-statemachine"));
    }

    @Override
    public void remoteHmiBrowserLeft(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiBrowserLeft");
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$6(this, "browser-left", n));
    }

    @Override
    public void destOnlineStartDestinationImport(int n) {
        if (this.myAudiHandler == null) {
            this.log.log(-1601830656, "OnlineEvoActionProxyImpl#destOnlineStartDestinationImport() no OnlineDestinationHandler (null)");
            return;
        }
        this.myAudiHandler.startDestinationImport();
    }

    @Override
    public void remoteHmiLogOff(int n) {
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService != null) {
            portalAuthenticationService.logoutCurrentUser();
        }
    }

    @Override
    public void remoteHMIAuthenticationInit(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHMIAuthenticationInit: called");
        ((RemoteHMIServiceEvo)this.remoteHmi).getRightDrawerHandler().removeXmlEntries();
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService != null) {
            portalAuthenticationService.init();
        }
    }

    @Override
    public void remoteHMIStartKnownLogin(int n) {
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService != null) {
            portalAuthenticationService.loginUserWithSavedCredentials();
        }
    }

    @Override
    public void remoteHMICallWifiPlayer(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHMICallWifiPlayer: called");
        IMediaService iMediaService = this.remoteHmi.getOnlineMediaComponent().getMediaService();
        if (iMediaService == null) {
            this.log.log(-1601830656, "OnlineEvoActionProxyImpl#remoteHMICallWifiPlayer: IMediaService is null");
            return;
        }
        iMediaService.activateSource(12, 0);
    }

    @Override
    public void remoteHMICallMediaApp(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHMICallMediaApp()");
        IMediaService iMediaService = this.remoteHmi.getOnlineMediaComponent().getMediaService();
        String string = ((DistributedServiceComponentEvo)this.remoteHmi.getDistributedServiceComponent()).getAppContext();
        int n2 = this.remoteHmi.getOnlineMediaComponent().getSlotId(string);
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHMICallMediaApp() Starting application >%1< with slot id %2", (Object)string, (long)n2);
        iMediaService.activateSource(13, n2);
    }

    @Override
    public void remoteHmiClosedViaOptionDrawer(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiClosedViaOptionDrawer: called");
        this.closedViaOptionDrawerCalled = true;
    }

    @Override
    public void remoteHMINavDestFormExit(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHMINavDestFormExit: Called.");
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$7(this, "nav-dest-form-exit"));
    }

    @Override
    public void remoteHmiMapExit(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiMapExit: Called.");
        this.remoteHmi.execute(new OnlineEvoActionProxyImpl$8(this, "map-exit"));
    }

    @Override
    public void licenseCheckEntered(int n, String string, String string2) {
        LicenseCollectionService licenseCollectionService;
        if (this.remoteHmi != null && (licenseCollectionService = this.remoteHmi.getLicenseCollectionService()) != null) {
            this.log.log(1078071040, "OnlineEvoActionProxyImpl#licenseCheckEntered: Called for serviceID %1 and applicationName %2.", (Object)string, (Object)string2);
            licenseCollectionService.setLicenseCheckEntered(string, string2);
        }
    }

    @Override
    public void remoteHmiLayoutConstants(int n, int n2, int n3, int n4) {
        if (this.remoteHmi != null) {
            this.remoteHmi.execute(new OnlineEvoActionProxyImpl$9(this, "layout-constants", n2, n3, n4));
        }
    }

    @Override
    public void myAudiAuthContext(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#myAudiAuthContext terminalID: %1, authContext: %2", (long)n, (long)n2);
        this.modelBankAccess.getChoiceModel(1729897216).setValue(n2);
    }

    @Override
    public void myAudiAuthScreenType(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#myAudiAuthScreenType terminalID: %1, screenType: %2", (long)n, (long)n2);
        this.modelBankAccess.getChoiceModel(270344960).setValue(n2);
    }

    @Override
    public void remoteHmiHkReturnFromInclude(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiHkReturnFromInclude: came back from INCLUDE_STATE of id '%1'", (long)n2);
        this.modelBankAccess.getChoiceModel(354296576).setValue(0);
        if (n2 == 1) {
            this.remoteHmi.getContextManagerComponent().setTransitionToInclude(true);
        }
    }

    @Override
    public void remoteHmiEnterInclude(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiEnterInclude: going to INCLUDE_STATE of id '%1'", (long)n2);
        this.modelBankAccess.getChoiceModel(354296576).setValue(1);
        if (n2 == 2) {
            this.remoteHmi.getContextManagerComponent().setTransitionToInclude(true);
        }
    }

    @Override
    public void remoteHmiMarkForTopLevel(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiMarkForTopLevel: requesting mark for top level for %1", (long)n2);
        HMIService hMIService = this.remoteHmi.getFrameworkAccess().getHMIService();
        if (hMIService != null) {
            ChoiceModelApp choiceModelApp = hMIService.getChoiceModel(-316923136);
            choiceModelApp.setValue(n2);
        }
    }

    @Override
    public void remoteHmiListEnter(int n) {
        this.configureMapForPreviews(true);
    }

    @Override
    public void remoteHmiListExit(int n) {
        this.configureMapForPreviews(false);
    }

    private void configureMapForPreviews(boolean bl) {
        NaviComponent naviComponent = this.remoteHmi.getNaviComponent();
        if (naviComponent == null) {
            return;
        }
        IPreviewMap iPreviewMap = naviComponent.getPreviewMap();
        if (iPreviewMap == null) {
            return;
        }
        try {
            if (bl) {
                iPreviewMap.previewMapScreenEntering(0, 0, 0, 0);
            } else {
                iPreviewMap.previewMapScreenExited();
            }
        }
        catch (Exception exception) {
            this.log.log(-1601830656, "OnlineEvoActionProxyImpl#configureMapForPreviews: %1: %2", (Object)(bl ? "enter" : "exit"), (Throwable)exception);
        }
    }

    @Override
    public void remoteHmiOverrideNextAnimation(int n, int n2) {
        this.remoteHmi.overrideAnimation(n2);
    }

    @Override
    public void operatorCallChecksSuccessful(int n, int n2) {
        this.operatorCallhandler.checksSuccessful(n2);
    }

    @Override
    public void operatorCallCenterLeft(int n) {
        this.operatorCallhandler.operatorCallCenterLeft();
    }

    @Override
    public void operatorEndMsgLeft(int n) {
        this.operatorCallhandler.operatorEndMsgLeft();
    }

    @Override
    public void operatorUpdateDetailInfo(int n) {
        this.operatorCallhandler.operatorUpdateDetailInfo();
    }

    @Override
    public void connGatewayLeft(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#conngatewayleft: ConnectedGateWay left!");
        this.standardController.clearAuthentication();
    }

    @Override
    public void remoteHmiToggleInclude(int n) {
        ChoiceModelApp choiceModelApp;
        int n2 = (choiceModelApp = this.modelBankAccess.getChoiceModel(-1256381696)).getValue();
        choiceModelApp.setValue(n2 == 1 ? 0 : 1);
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiToggleInclude: toggled to %1", (long)n2);
    }

    @Override
    public void operatorCallCallActiveShown(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#operatorCallCallActiveShown called");
        this.operatorCallhandler.operatorCallCallActiveShown(n2);
    }

    @Override
    public void remotehmiGoogleEarthEntered(int n) {
        NaviComponent naviComponent = this.remoteHmi.getNaviComponent();
        if (naviComponent == null) {
            this.log.log(10000, "OnlineEvoActionProxyImpl#remotehmiGoogleEarthEntered: NaviComponent NULL! -> returning");
            return;
        }
        MapService mapService = naviComponent.getMapService();
        if (mapService == null) {
            this.log.log(10000, "OnlineEvoActionProxyImpl#remotehmiGoogleEarthEntered: MapService NULL! -> returning!");
            return;
        }
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remotehmiGoogleEarthEntered: setting representation to GoogleEarth");
        mapService.setMapRepresentation(1);
    }

    @Override
    public void remotehmiOnlineTrafficEntered(int n) {
        NaviComponent naviComponent = this.remoteHmi.getNaviComponent();
        if (naviComponent == null) {
            this.log.log(10000, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: NaviComponent NULL! -> returning");
            return;
        }
        NaviService naviService = naviComponent.getNaviService();
        if (naviService == null) {
            this.log.log(10000, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: NaviService NULL! -> returning!");
            return;
        }
        MapService mapService = naviComponent.getMapService();
        if (mapService == null) {
            this.log.log(10000, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: MapService NULL! -> returning!");
            return;
        }
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: setting SpeedAndFlow");
        mapService.setTrafficSettings(true, true, true, 1);
        if (this.remoteHmi.getFrameworkAccess().getSysConst(4485) == 1) {
            this.log.log(1078071040, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: setting representation to traffic");
            mapService.setMapRepresentation(2);
        }
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: enabling online traffic");
        naviService.setOnlineTraffic(true);
    }

    @Override
    public void remoteHmiPrepare(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#remoteHmiPrepare: called");
        this.contextManagerComponent.replaceExitView();
    }

    @Override
    public void operatorCallResultListEntered(int n, int n2) {
        this.operatorCallhandler.resultListEntered(n2);
    }

    @Override
    public void operatorCallResultListLeft(int n, int n2) {
        this.operatorCallhandler.resultListLeft(n2);
    }

    @Override
    public void licenseOverviewEntered(int n) {
        LicenseCollectionService licenseCollectionService;
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#licenseOverviewEntered: ActionProxyCalled!");
        if (this.remoteHmi != null) {
            this.log.log(-2137614336, "OnlineEvoActionProxyImpl#licenseOverviewEntered: HIGH Path");
            licenseCollectionService = this.remoteHmi.getLicenseCollectionService();
        } else {
            this.log.log(-2137614336, "OnlineEvoActionProxyImpl#licenseOverviewEntered: STD Path.");
            licenseCollectionService = this.standardController.getLicenseCollectionService();
        }
        if (licenseCollectionService != null) {
            this.log.log(-2137614336, "OnlineEvoActionProxyImpl#licenseOverviewEntered: Called.");
            licenseCollectionService.setLicenseOverviewEntered();
            licenseCollectionService.refreshLicensesDependingOnServiceList();
        } else {
            this.log.log(-1601830656, "OnlineEvoActionProxyImpl#licenseOverviewEntered: having no licenseCollectionService");
        }
    }

    @Override
    public void licenseOverviewExited(int n) {
        LicenseCollectionService licenseCollectionService = this.remoteHmi != null ? this.remoteHmi.getLicenseCollectionService() : this.standardController.getLicenseCollectionService();
        if (licenseCollectionService != null) {
            this.log.log(-2137614336, "OnlineEvoActionProxyImpl#licenseOverviewExited: Called.");
            licenseCollectionService.setLicenseOverviewExited();
        } else {
            this.log.log(-1601830656, "OnlineEvoActionProxyImpl#licenseOverviewExited: having no licenseCollectionService");
        }
    }

    @Override
    public void trafficLightEntered(int n) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#trafficLightEntered: Called.");
        this.trafficLightOnlineHandler.triggerSDSConfiguration();
    }

    @Override
    public void changePrivacySettingsScreenMode(int n, int n2) {
        this.log.log(1078071040, "OnlineEvoActionProxyImpl#privacySettingsScreenModeChanged: Called.");
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(1444881152);
        choiceModelApp.setValue(n2);
    }

    static /* synthetic */ RemoteHMIService access$000(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl) {
        return onlineEvoActionProxyImpl.remoteHmi;
    }

    static /* synthetic */ ContextManagerComponent access$100(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl) {
        return onlineEvoActionProxyImpl.contextManagerComponent;
    }

    static /* synthetic */ boolean access$202(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, boolean bl) {
        onlineEvoActionProxyImpl.closedViaOptionDrawerCalled = bl;
        return onlineEvoActionProxyImpl.closedViaOptionDrawerCalled;
    }
}

