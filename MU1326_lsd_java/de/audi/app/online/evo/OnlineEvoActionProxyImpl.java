/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ContextManagerComponentEvo;
import de.audi.app.online.evo.DistributedServiceComponentEvo;
import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.OnlineBaseActionProxy;
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
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
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

    public void remoteHmiEnterInMap(int n) {
        if (this.remoteHmi != null) {
            if (!this.remoteHmi.isSDSRunning()) {
                this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiEnterInMap: SDS not running, calling remoteHmiEnter");
                this.remoteHmiEnter(n, 0);
            } else {
                this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiEnterInMap: not calling remotehmiEnter since SDS is running");
            }
        }
    }

    public void remoteHmiEnter(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiEnter: called");
        this.contextManagerComponent.setWaitForApplicationValue(1);
        this.remoteHmi.setEntered(true);
        this.remoteHmi.execute(new AbstractRemoteHMITask("remotehmi-enter"){

            public void run() {
                OnlineEvoActionProxyImpl.this.remoteHmi.onEnter();
            }
        });
    }

    public void rhmiAuthenticationFinished(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#rhmiAuthenticationFinished");
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService == null) {
            this.log.log(1000000, "OnlineEvoActionProxyImpl#rhmiAuthenticationFinished no Service");
            return;
        }
        portalAuthenticationService.indicateAuthenticationDialogFinsihed();
    }

    public void authenticationLogoutFinished(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#authenticationLogoutFinished");
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService == null) {
            this.log.log(1000000, "OnlineEvoActionProxyImpl#authenticationLogoutFinished no Service");
            return;
        }
        portalAuthenticationService.indicateLogoutDialogFinsihed();
    }

    public void startOperatorCall(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#startOperatorCall %1", (long)n2);
        if (this.operatorCallhandler == null) {
            return;
        }
        this.operatorCallhandler.log(1000000, "OnlineEvoActionProxyImpl#startOperatorCall %1", n2);
        this.operatorCallhandler.enterService(n2);
    }

    public void leaveCallcenterCall(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#leaveCallcenterCall %1", (long)n2);
        if (this.operatorCallhandler == null) {
            return;
        }
        this.operatorCallhandler.log(1000000, "OnlineEvoActionProxyImpl#leaveCallcenterCall %1", n2);
        this.operatorCallhandler.leaveService(n2);
    }

    public void remoteHmiSetEntryPoint(int n, final int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiSetEntryPoint: entrypoint %1", (Object)Integer.toString(n2));
        ((ContextManagerComponentEvo)this.contextManagerComponent).setLeftDrawerAvailability(n2);
        if (n2 == 4) {
            this.remoteHmi.setConnectivityContext(1);
        }
        this.remoteHmi.setEntryPointId(n2);
        this.remoteHmi.execute(new AbstractRemoteHMITask("set-entry-point"){

            public void run() {
                OnlineEvoActionProxyImpl.this.contextManagerComponent.setEntryPoint(n2);
            }
        });
    }

    public void remoteHmiExit(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiExit: Called");
        this.remoteHmi.setEntered(false);
        this.remoteHmi.setConnectivityContext(0);
        EntryPoint entryPoint = this.contextManagerComponent.getCurrentEntryPoint();
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(this.modelBankAccess.getCurrentViewChoiceId());
        if (entryPoint != null && entryPoint.getEntryPointId() == 1 && choiceModelApp.getStatus() == 3000) {
            this.contextManagerComponent.setIgnoreScreenConnect(true);
        }
        ((RemoteHMIServiceEvo)this.remoteHmi).getRightDrawerHandler().reinitRightDrawer();
        this.remoteHmi.execute(new AbstractRemoteHMITask("remotehmi-exit"){

            public void run() {
                OnlineEvoActionProxyImpl.this.remoteHmi.onExit();
            }
        });
        if (this.closedViaOptionDrawerCalled) {
            this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiExit: as closedViaOptionDrawerCalled was called before so adjusting view");
            ((RemoteHMIServiceEvo)this.remoteHmi).getRightDrawerHandler().resetPreviouslySelectedDrawerEntry();
            this.remoteHmi.execute(new AbstractRemoteHMITask("remotehmi-closed-via-option-drawer-settings"){

                public void run() {
                    OnlineEvoActionProxyImpl.this.closedViaOptionDrawerCalled = false;
                    OnlineEvoActionProxyImpl.this.contextManagerComponent.replaceExitView();
                    ChoiceModelApp choiceModelApp = OnlineEvoActionProxyImpl.this.modelBankAccess.getChoiceModel(2300989);
                    choiceModelApp.setValue(0);
                }
            });
        }
    }

    public void remoteHmiHkReturn(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiHkReturn: Called");
    }

    public void remoteHmiHkReturnFromSelectionDrawer(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiHkReturnFromSelectionDrawer: Called");
        this.remoteHmi.execute(new AbstractRemoteHMITask("fire-return-in-scxml-statemachine"){

            public void run() {
                RemoteHMIAction remoteHMIAction = OnlineEvoActionProxyImpl.this.remoteHmi.getAction(104);
                OnlineEvoActionProxyImpl.this.remoteHmi.invokeAction(remoteHMIAction);
            }
        });
    }

    public void remoteHmiBrowserLeft(final int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiBrowserLeft");
        this.remoteHmi.execute(new AbstractRemoteHMITask("browser-left"){

            public void run() {
                OnlineEvoActionProxyImpl.this.remoteHmi.getBrowserController().remoteHmiBrowserLeft(n);
            }
        });
    }

    public void destOnlineStartDestinationImport(int n) {
        if (this.myAudiHandler == null) {
            this.log.log(100000, "OnlineEvoActionProxyImpl#destOnlineStartDestinationImport() no OnlineDestinationHandler (null)");
            return;
        }
        this.myAudiHandler.startDestinationImport();
    }

    public void remoteHmiLogOff(int n) {
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService != null) {
            portalAuthenticationService.logoutCurrentUser();
        }
    }

    public void remoteHMIAuthenticationInit(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHMIAuthenticationInit: called");
        ((RemoteHMIServiceEvo)this.remoteHmi).getRightDrawerHandler().removeXmlEntries();
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService != null) {
            portalAuthenticationService.init();
        }
    }

    public void remoteHMIStartKnownLogin(int n) {
        PortalAuthenticationService portalAuthenticationService = this.remoteHmi.getAuthenticationService();
        if (portalAuthenticationService != null) {
            portalAuthenticationService.loginUserWithSavedCredentials();
        }
    }

    public void remoteHMICallWifiPlayer(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHMICallWifiPlayer: called");
        IMediaService iMediaService = this.remoteHmi.getOnlineMediaComponent().getMediaService();
        if (iMediaService == null) {
            this.log.log(100000, "OnlineEvoActionProxyImpl#remoteHMICallWifiPlayer: IMediaService is null");
            return;
        }
        iMediaService.activateSource(12, 0);
    }

    public void remoteHMICallMediaApp(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHMICallMediaApp()");
        IMediaService iMediaService = this.remoteHmi.getOnlineMediaComponent().getMediaService();
        String string = ((DistributedServiceComponentEvo)this.remoteHmi.getDistributedServiceComponent()).getAppContext();
        int n2 = this.remoteHmi.getOnlineMediaComponent().getSlotId(string);
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHMICallMediaApp() Starting application >%1< with slot id %2", (Object)string, (long)n2);
        iMediaService.activateSource(13, n2);
    }

    public void remoteHmiClosedViaOptionDrawer(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiClosedViaOptionDrawer: called");
        this.closedViaOptionDrawerCalled = true;
    }

    public void remoteHMINavDestFormExit(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHMINavDestFormExit: Called.");
        this.remoteHmi.execute(new AbstractRemoteHMITask("nav-dest-form-exit"){

            public void run() {
                OnlineEvoActionProxyImpl.this.remoteHmi.invokeAction(OnlineEvoActionProxyImpl.this.remoteHmi.getAction(104));
            }
        });
    }

    public void remoteHmiMapExit(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiMapExit: Called.");
        this.remoteHmi.execute(new AbstractRemoteHMITask("map-exit"){

            public void run() {
                OnlineEvoActionProxyImpl.this.remoteHmi.invokeAction(OnlineEvoActionProxyImpl.this.remoteHmi.getAction(104));
            }
        });
    }

    public void licenseCheckEntered(int n, String string, String string2) {
        LicenseCollectionService licenseCollectionService;
        if (this.remoteHmi != null && (licenseCollectionService = this.remoteHmi.getLicenseCollectionService()) != null) {
            this.log.log(1000000, "OnlineEvoActionProxyImpl#licenseCheckEntered: Called for serviceID %1 and applicationName %2.", (Object)string, (Object)string2);
            licenseCollectionService.setLicenseCheckEntered(string, string2);
        }
    }

    public void remoteHmiLayoutConstants(int n, final int n2, final int n3, final int n4) {
        if (this.remoteHmi != null) {
            this.remoteHmi.execute(new AbstractRemoteHMITask("layout-constants"){

                public void run() {
                    AbstractHMIViewListener abstractHMIViewListener = OnlineEvoActionProxyImpl.this.remoteHmi.getViewListener(13000);
                    if (abstractHMIViewListener instanceof HMIViewGridListener) {
                        ((HMIViewGridListener)abstractHMIViewListener).updateLayoutConstants(n2, n3, n4);
                    }
                }
            });
        }
    }

    public void myAudiAuthContext(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#myAudiAuthContext terminalID: %1, authContext: %2", (long)n, (long)n2);
        this.modelBankAccess.getChoiceModel(2301031).setValue(n2);
    }

    public void myAudiAuthScreenType(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#myAudiAuthScreenType terminalID: %1, screenType: %2", (long)n, (long)n2);
        this.modelBankAccess.getChoiceModel(2301200).setValue(n2);
    }

    public void remoteHmiHkReturnFromInclude(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiHkReturnFromInclude: came back from INCLUDE_STATE of id '%1'", (long)n2);
        this.modelBankAccess.getChoiceModel(2301461).setValue(0);
        if (n2 == 1) {
            this.remoteHmi.getContextManagerComponent().setTransitionToInclude(true);
        }
    }

    public void remoteHmiEnterInclude(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiEnterInclude: going to INCLUDE_STATE of id '%1'", (long)n2);
        this.modelBankAccess.getChoiceModel(2301461).setValue(1);
        if (n2 == 2) {
            this.remoteHmi.getContextManagerComponent().setTransitionToInclude(true);
        }
    }

    public void remoteHmiMarkForTopLevel(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiMarkForTopLevel: requesting mark for top level for %1", (long)n2);
        HMIService hMIService = this.remoteHmi.getFrameworkAccess().getHMIService();
        if (hMIService != null) {
            ChoiceModelApp choiceModelApp = hMIService.getChoiceModel(2301165);
            choiceModelApp.setValue(n2);
        }
    }

    public void remoteHmiListEnter(int n) {
        this.configureMapForPreviews(true);
    }

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
            this.log.log(100000, "OnlineEvoActionProxyImpl#configureMapForPreviews: %1: %2", (Object)(bl ? "enter" : "exit"), (Throwable)exception);
        }
    }

    public void remoteHmiOverrideNextAnimation(int n, int n2) {
        this.remoteHmi.overrideAnimation(n2);
    }

    public void operatorCallChecksSuccessful(int n, int n2) {
        this.operatorCallhandler.checksSuccessful(n2);
    }

    public void operatorCallCenterLeft(int n) {
        this.operatorCallhandler.operatorCallCenterLeft();
    }

    public void operatorEndMsgLeft(int n) {
        this.operatorCallhandler.operatorEndMsgLeft();
    }

    public void operatorUpdateDetailInfo(int n) {
        this.operatorCallhandler.operatorUpdateDetailInfo();
    }

    public void connGatewayLeft(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#conngatewayleft: ConnectedGateWay left!");
        this.standardController.clearAuthentication();
    }

    public void remoteHmiToggleInclude(int n) {
        ChoiceModelApp choiceModelApp;
        int n2 = (choiceModelApp = this.modelBankAccess.getChoiceModel(2301365)).getValue();
        choiceModelApp.setValue(n2 == 1 ? 0 : 1);
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiToggleInclude: toggled to %1", (long)n2);
    }

    public void operatorCallCallActiveShown(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#operatorCallCallActiveShown called");
        this.operatorCallhandler.operatorCallCallActiveShown(n2);
    }

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
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remotehmiGoogleEarthEntered: setting representation to GoogleEarth");
        mapService.setMapRepresentation(1);
    }

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
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: setting SpeedAndFlow");
        mapService.setTrafficSettings(true, true, true, 1);
        if (this.remoteHmi.getFrameworkAccess().getSysConst(4485) == 1) {
            this.log.log(1000000, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: setting representation to traffic");
            mapService.setMapRepresentation(2);
        }
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remotehmiOnlineTrafficEntered: enabling online traffic");
        naviService.setOnlineTraffic(true);
    }

    public void remoteHmiPrepare(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#remoteHmiPrepare: called");
        this.contextManagerComponent.replaceExitView();
    }

    public void operatorCallResultListEntered(int n, int n2) {
        this.operatorCallhandler.resultListEntered(n2);
    }

    public void operatorCallResultListLeft(int n, int n2) {
        this.operatorCallhandler.resultListLeft(n2);
    }

    public void licenseOverviewEntered(int n) {
        LicenseCollectionService licenseCollectionService;
        this.log.log(1000000, "OnlineEvoActionProxyImpl#licenseOverviewEntered: ActionProxyCalled!");
        if (this.remoteHmi != null) {
            this.log.log(10000000, "OnlineEvoActionProxyImpl#licenseOverviewEntered: HIGH Path");
            licenseCollectionService = this.remoteHmi.getLicenseCollectionService();
        } else {
            this.log.log(10000000, "OnlineEvoActionProxyImpl#licenseOverviewEntered: STD Path.");
            licenseCollectionService = this.standardController.getLicenseCollectionService();
        }
        if (licenseCollectionService != null) {
            this.log.log(10000000, "OnlineEvoActionProxyImpl#licenseOverviewEntered: Called.");
            licenseCollectionService.setLicenseOverviewEntered();
            licenseCollectionService.refreshLicensesDependingOnServiceList();
        } else {
            this.log.log(100000, "OnlineEvoActionProxyImpl#licenseOverviewEntered: having no licenseCollectionService");
        }
    }

    public void licenseOverviewExited(int n) {
        LicenseCollectionService licenseCollectionService = this.remoteHmi != null ? this.remoteHmi.getLicenseCollectionService() : this.standardController.getLicenseCollectionService();
        if (licenseCollectionService != null) {
            this.log.log(10000000, "OnlineEvoActionProxyImpl#licenseOverviewExited: Called.");
            licenseCollectionService.setLicenseOverviewExited();
        } else {
            this.log.log(100000, "OnlineEvoActionProxyImpl#licenseOverviewExited: having no licenseCollectionService");
        }
    }

    public void trafficLightEntered(int n) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#trafficLightEntered: Called.");
        this.trafficLightOnlineHandler.triggerSDSConfiguration();
    }

    public void changePrivacySettingsScreenMode(int n, int n2) {
        this.log.log(1000000, "OnlineEvoActionProxyImpl#privacySettingsScreenModeChanged: Called.");
        ChoiceModelApp choiceModelApp = this.modelBankAccess.getChoiceModel(2301782);
        choiceModelApp.setValue(n2);
    }
}

