/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.remotehmi.ui.mib2.Commands;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.VirtualButtonAdapter;
import de.audi.tghu.online.app.remotehmi.util.NavUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class ExternalServiceProviderEvo
extends AbstractExternalServiceProvider {
    private static final int APPLICATION_MEDIA = 2;

    public void init(final LogChannel logChannel, final RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(100000011, new AbstractCommandHandler("app-start-success"){

            public void indicateCommand(int n, Object object) {
                Commands.MiniAppStatusPayload miniAppStatusPayload = (Commands.MiniAppStatusPayload)object;
                String string = miniAppStatusPayload.getContextName();
                String string2 = miniAppStatusPayload.hostingContext;
                logChannel.log(1000000, "ExternalServiceProviderEvo#indicateCommand: Commands.STATE_APP_START_SUCCESS received for app '%1' with hostingContext '%2'", (Object)string, (Object)string2);
            }
        });
        remoteHMIService.addCommandHandler(100000012, new AbstractCommandHandler("app-start-error"){

            public void indicateCommand(int n, Object object) {
                Commands.MiniAppStatusPayload miniAppStatusPayload = (Commands.MiniAppStatusPayload)object;
                String string = miniAppStatusPayload.getContextName();
                String string2 = miniAppStatusPayload.hostingContext;
                ContextManagerComponent contextManagerComponent = remoteHMIService.getContextManagerComponent();
                logChannel.log(1000000, "ExternalServiceProviderEvo#indicateCommand: Commands.STATE_APP_START_ERROR received for app '%1'.", (Object)string);
                if (string2.equals("media") && !contextManagerComponent.isCurrentEntrypointMedia()) {
                    ExternalServiceProviderEvo.this.lastAppState = 1;
                    ExternalServiceProviderEvo.this.lastAppContext = string;
                    return;
                }
                EntryPoint entryPoint = contextManagerComponent.getCurrentEntryPoint();
                String string3 = entryPoint.getNameOfContextToBeStarted();
                if (string3 != null && string3.equals(string)) {
                    contextManagerComponent.setWaitForApplicationValue(2);
                    entryPoint.setNameOfContextToBeStarted(null);
                }
            }
        });
        final VirtualButtonModelApp virtualButtonModelApp = this.remoteHmiService.getModelBankAccess().getVirtualButtonModel(2300969);
        virtualButtonModelApp.setVirtualButtonListener(new VirtualButtonAdapter(){

            public void keyTyped(int n, int n2, int n3) {
                if (n == 2300969) {
                    ContextManagerComponent contextManagerComponent = remoteHMIService.getContextManagerComponent();
                    EntryPoint entryPoint = contextManagerComponent.getCurrentEntryPoint();
                    if (entryPoint != null && entryPoint.getEntryPointId() == 1) {
                        contextManagerComponent.setWaitForApplicationValue(0);
                    } else {
                        virtualButtonModelApp.fireEvent(0);
                    }
                }
            }
        });
    }

    public void startDestinationApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
        if (string == null || string.equals("")) {
            this.logChannel.log(100000, "ExternalServiceProviderEvo#startDestinationApp: applicationContext passed is null or empty so doing nothing");
            return;
        }
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#startDestinationApp: Data passed by Destination is, Latitude: %1 , Longitude: %2, ApplicationContext: %3", (Object)Util.createInteger(navLocation.getLatitude()), (Object)Util.createInteger(navLocation.getLongitude()), (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(2);
        entryPoint.setNameOfContextToBeStarted(string);
        this.handleNaviAppStart(navLocation, string, transitionCallback, 10000003);
    }

    public void startMapApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
        if (string == null || string.equals("")) {
            this.logChannel.log(100000, "ExternalServiceProviderEvo#startMapApp: applicationContext passed is null or empty so doing nothing");
            return;
        }
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#startMapApp: Data passed by Map is, Latitude: %1 , Longitude: %2, ApplicationContext: %3", (Object)Util.createInteger(navLocation.getLatitude()), (Object)Util.createInteger(navLocation.getLongitude()), (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(3);
        entryPoint.setNameOfContextToBeStarted(string);
        this.handleNaviAppStart(navLocation, string, transitionCallback, 0x989688);
    }

    public void startOperatorApp(RemoteHMILocation remoteHMILocation, String string, TransitionCallback transitionCallback) {
        if (string == null || string.equals("")) {
            this.logChannel.log(100000, "ExternalServiceProviderEvo#startOperatorApp: applicationContext passed is null or empty so doing nothing");
            return;
        }
        double d2 = remoteHMILocation.getLatitude();
        double d3 = remoteHMILocation.getLongitude();
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#startOperatorApp: Data passed by Operator is, Latitude: %1 , Longitude: %2, ApplicationContext: %3", (Object)new Double(d2), (Object)new Double(d3), (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(5);
        entryPoint.setNameOfContextToBeStarted(string);
        this.removePreviousInterpreter(entryPoint);
        RemoteHMIAction remoteHMIAction = this.handleOperatorAppStart(remoteHMILocation, string, transitionCallback, 0x989686);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    private void removePreviousInterpreter(EntryPoint entryPoint) {
        RemoteHMIContext remoteHMIContext = entryPoint.getCurrentContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(1000000, "ExternalServiceProviderEvo#removePreviousInterpreter: no previous context exists for entrypoint '%1'", (long)entryPoint.getEntryPointId());
            return;
        }
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(100000013);
        remoteHMIAction.getParameters().putString("appContextName", remoteHMIContext.getContextName());
        this.remoteHmiService.invokeAction(remoteHMIAction);
        entryPoint.setCurrentContext(null);
    }

    public void startMediaApp(final String string, boolean bl) {
        final ContextManagerComponent contextManagerComponent = this.remoteHmiService.getContextManagerComponent();
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHMIService().getChoiceModel(this.remoteHmiService.getActiveAppModelId());
        final boolean bl2 = choiceModelApp.getValue() != 2;
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#startMediaApp: context name = '%1' in background '%2'", (Object)string, (Object)bl2);
        if (!bl2) {
            contextManagerComponent.setWaitForApplicationValue(1);
        }
        this.remoteHmiService.getOnlineMediaComponent().setLastStartedApplication(string);
        LogAppender logAppender = new LogAppender(){

            public void appendTo(Buffer buffer) {
                buffer.append(string);
                if (bl2) {
                    buffer.append(" (startMediaAppInBackground)");
                }
            }

            public int getEstimatedLength() {
                return 32;
            }
        };
        this.remoteHmiService.execute(new AbstractRemoteHMITask("start-media-app-controller", logAppender){

            public void run() {
                RemoteHMIAction remoteHMIAction;
                boolean bl;
                EntryPoint entryPoint = contextManagerComponent.getEntryPointFromMap(4);
                MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
                EntryPoint entryPoint2 = mediaSubEntryPointsContainer.getEntryPointByAppContext(string);
                if (entryPoint2 == null) {
                    ExternalServiceProviderEvo.this.logChannel.log(100000, "ExternalServiceProviderEvo#startMediaApp() entrypoint for given context is null so doing nothing.");
                    return;
                }
                int n = entryPoint2.getEntryPointId();
                if (n <= 10) {
                    ExternalServiceProviderEvo.this.logChannel.log(100000, "ExternalServiceProviderEvo#startMediaApp() entryPoint retrieved for the given context is out of range so doing nothing");
                    return;
                }
                ExternalServiceProviderEvo.this.logChannel.log(10000000, "ExternalServiceProviderEvo#startMediaApp: Entrypoint id for AppContext : %1 is %2 ", (Object)string, (long)n);
                entryPoint2.setNameOfContextToBeStarted(string);
                mediaSubEntryPointsContainer.setCurrentEntryPoint(entryPoint2);
                RemoteHMIContext remoteHMIContext = entryPoint2.getCurrentContext();
                boolean bl22 = bl = remoteHMIContext != null && remoteHMIContext.getContextName().equals(string);
                if (bl) {
                    ExternalServiceProviderEvo.this.logChannel.log(1000000, "ExternalServiceProviderEvo#startMediaApp: Context '%1' is going to be resumed %2", (Object)string, (Object)(bl2 ? "in the background" : ""));
                    remoteHMIAction = ExternalServiceProviderEvo.this.remoteHmiService.getAction(100000010);
                } else {
                    ExternalServiceProviderEvo.this.logChannel.log(1000000, "ExternalServiceProviderEvo#startMediaApp: Context '%1' is going to be started %2", (Object)string, (Object)(bl2 ? "in the background" : ""));
                    remoteHMIAction = ExternalServiceProviderEvo.this.remoteHmiService.getAction(10000004);
                    entryPoint2.setCurrentContext(null);
                }
                remoteHMIAction.getParameters().putString("appContextName", string);
                remoteHMIAction.getParameters().putBoolean("backgroundService", bl2);
                ExternalServiceProviderEvo.this.remoteHmiService.invokeAction(remoteHMIAction);
            }
        });
    }

    public void stopMediaApp(final String string) {
        this.logChannel.log(10000000, "ExternalServiceProviderEvo#stopMediaApp: 1- Stop signal recieved for application having context name '%1'", (Object)string);
        this.remoteHmiService.execute(new AbstractRemoteHMITask("stop-media-app-controller"){

            public void run() {
                EntryPoint entryPoint = ExternalServiceProviderEvo.this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(4);
                MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
                mediaSubEntryPointsContainer.setCurrentEntryPoint(null);
                RemoteHMIAction remoteHMIAction = ExternalServiceProviderEvo.this.remoteHmiService.getAction(100000012);
                remoteHMIAction.getParameters().putString("appContextName", string);
                ExternalServiceProviderEvo.this.remoteHmiService.invokeAction(remoteHMIAction);
                IMediaDrawerContext iMediaDrawerContext = ExternalServiceProviderEvo.this.remoteHmiService.getMediaDrawerContext();
                if (iMediaDrawerContext != null) {
                    iMediaDrawerContext.setDrawerElements(null, null);
                }
            }
        });
    }

    private void handleNaviAppStart(NavLocation navLocation, String string, TransitionCallback transitionCallback, int n) {
        this.removePreviousInterpreterNavi();
        ContextManagerComponent contextManagerComponent = this.remoteHmiService.getContextManagerComponent();
        contextManagerComponent.setLoadingTitleValue(1);
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#handleNaviAppStart: Original Coordinates: (%1 , %2), street: '%3', town: '%4'", (Object)Util.createInteger(navLocation.getLatitude()), (Object)Util.createInteger(navLocation.getLongitude()), (Object)navLocation.getStreet(), (Object)navLocation.getTown());
        RemoteHMILocation remoteHMILocation = NavUtil.getRemoteLocationFromNavLocation(navLocation);
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(n);
        remoteHMIAction.getParameters().putString("appContextName", string);
        remoteHMIAction.getParameters().put("loc", remoteHMILocation);
        this.remoteHmiService.invokeAction(remoteHMIAction);
        transitionCallback.triggerTransition();
    }

    public void removePreviousInterpreterNavi() {
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(2);
        EntryPoint entryPoint2 = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(3);
        this.removePreviousInterpreter(entryPoint);
        this.removePreviousInterpreter(entryPoint2);
    }

    private RemoteHMIAction handleOperatorAppStart(RemoteHMILocation remoteHMILocation, String string, TransitionCallback transitionCallback, int n) {
        ContextManagerComponent contextManagerComponent = this.remoteHmiService.getContextManagerComponent();
        contextManagerComponent.setLoadingTitleValue(1);
        transitionCallback.triggerTransition();
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(n);
        remoteHMIAction.getParameters().putString("appContextName", string);
        remoteHMIAction.getParameters().put("loc", remoteHMILocation);
        return remoteHMIAction;
    }

    public void startPhoneApp(String string, boolean bl) {
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#startPhoneApp: not defined in evo");
    }

    public void stopPhoneApp(String string) {
        this.logChannel.log(1000000, "ExternalServiceProviderEvo#stopPhoneApp: not defined in evo");
    }
}

