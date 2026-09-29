/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ExternalServiceProviderEvo$1;
import de.audi.app.online.evo.ExternalServiceProviderEvo$2;
import de.audi.app.online.evo.ExternalServiceProviderEvo$3;
import de.audi.app.online.evo.ExternalServiceProviderEvo$4;
import de.audi.app.online.evo.ExternalServiceProviderEvo$5;
import de.audi.app.online.evo.ExternalServiceProviderEvo$6;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.RemoteHMILocation;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.util.NavUtil;
import org.dsi.ifc.global.NavLocation;

public class ExternalServiceProviderEvo
extends AbstractExternalServiceProvider {
    private static final int APPLICATION_MEDIA;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(199357701, new ExternalServiceProviderEvo$1(this, "app-start-success", logChannel));
        remoteHMIService.addCommandHandler(216134917, new ExternalServiceProviderEvo$2(this, "app-start-error", remoteHMIService, logChannel));
        VirtualButtonModelApp virtualButtonModelApp = this.remoteHmiService.getModelBankAccess().getVirtualButtonModel(689709824);
        virtualButtonModelApp.setVirtualButtonListener(new ExternalServiceProviderEvo$3(this, remoteHMIService, virtualButtonModelApp));
    }

    @Override
    public void startDestinationApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
        if (string == null || string.equals("")) {
            this.logChannel.log(-1601830656, "ExternalServiceProviderEvo#startDestinationApp: applicationContext passed is null or empty so doing nothing");
            return;
        }
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#startDestinationApp: Data passed by Destination is, Latitude: %1 , Longitude: %2, ApplicationContext: %3", (Object)Util.createInteger(navLocation.getLatitude()), (Object)Util.createInteger(navLocation.getLongitude()), (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(2);
        entryPoint.setNameOfContextToBeStarted(string);
        this.handleNaviAppStart(navLocation, string, transitionCallback, -2087282688);
    }

    @Override
    public void startMapApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
        if (string == null || string.equals("")) {
            this.logChannel.log(-1601830656, "ExternalServiceProviderEvo#startMapApp: applicationContext passed is null or empty so doing nothing");
            return;
        }
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#startMapApp: Data passed by Map is, Latitude: %1 , Longitude: %2, ApplicationContext: %3", (Object)Util.createInteger(navLocation.getLatitude()), (Object)Util.createInteger(navLocation.getLongitude()), (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(3);
        entryPoint.setNameOfContextToBeStarted(string);
        this.handleNaviAppStart(navLocation, string, transitionCallback, -2003396608);
    }

    @Override
    public void startOperatorApp(RemoteHMILocation remoteHMILocation, String string, TransitionCallback transitionCallback) {
        if (string == null || string.equals("")) {
            this.logChannel.log(-1601830656, "ExternalServiceProviderEvo#startOperatorApp: applicationContext passed is null or empty so doing nothing");
            return;
        }
        double d2 = remoteHMILocation.getLatitude();
        double d3 = remoteHMILocation.getLongitude();
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#startOperatorApp: Data passed by Operator is, Latitude: %1 , Longitude: %2, ApplicationContext: %3", (Object)new Double(d2), (Object)new Double(d3), (Object)string);
        EntryPoint entryPoint = this.remoteHmiService.getContextManagerComponent().getEntryPointFromMap(5);
        entryPoint.setNameOfContextToBeStarted(string);
        this.removePreviousInterpreter(entryPoint);
        RemoteHMIAction remoteHMIAction = this.handleOperatorAppStart(remoteHMILocation, string, transitionCallback, -2036951040);
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    private void removePreviousInterpreter(EntryPoint entryPoint) {
        RemoteHMIContext remoteHMIContext = entryPoint.getCurrentContext();
        if (remoteHMIContext == null) {
            this.logChannel.log(1078071040, "ExternalServiceProviderEvo#removePreviousInterpreter: no previous context exists for entrypoint '%1'", (long)entryPoint.getEntryPointId());
            return;
        }
        RemoteHMIAction remoteHMIAction = this.remoteHmiService.getAction(232912133);
        remoteHMIAction.getParameters().putString("appContextName", remoteHMIContext.getContextName());
        this.remoteHmiService.invokeAction(remoteHMIAction);
        entryPoint.setCurrentContext(null);
    }

    @Override
    public void startMediaApp(String string, boolean bl) {
        ContextManagerComponent contextManagerComponent = this.remoteHmiService.getContextManagerComponent();
        ChoiceModelApp choiceModelApp = this.getFrameworkAccess().getHMIService().getChoiceModel(this.remoteHmiService.getActiveAppModelId());
        boolean bl2 = choiceModelApp.getValue() != 2;
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#startMediaApp: context name = '%1' in background '%2'", (Object)string, (Object)bl2);
        if (!bl2) {
            contextManagerComponent.setWaitForApplicationValue(1);
        }
        this.remoteHmiService.getOnlineMediaComponent().setLastStartedApplication(string);
        ExternalServiceProviderEvo$4 externalServiceProviderEvo$4 = new ExternalServiceProviderEvo$4(this, string, bl2);
        this.remoteHmiService.execute(new ExternalServiceProviderEvo$5(this, "start-media-app-controller", externalServiceProviderEvo$4, contextManagerComponent, string, bl2));
    }

    @Override
    public void stopMediaApp(String string) {
        this.logChannel.log(-2137614336, "ExternalServiceProviderEvo#stopMediaApp: 1- Stop signal recieved for application having context name '%1'", (Object)string);
        this.remoteHmiService.execute(new ExternalServiceProviderEvo$6(this, "stop-media-app-controller", string));
    }

    private void handleNaviAppStart(NavLocation navLocation, String string, TransitionCallback transitionCallback, int n) {
        this.removePreviousInterpreterNavi();
        ContextManagerComponent contextManagerComponent = this.remoteHmiService.getContextManagerComponent();
        contextManagerComponent.setLoadingTitleValue(1);
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#handleNaviAppStart: Original Coordinates: (%1 , %2), street: '%3', town: '%4'", (Object)Util.createInteger(navLocation.getLatitude()), (Object)Util.createInteger(navLocation.getLongitude()), (Object)navLocation.getStreet(), (Object)navLocation.getTown());
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

    @Override
    public void startPhoneApp(String string, boolean bl) {
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#startPhoneApp: not defined in evo");
    }

    @Override
    public void stopPhoneApp(String string) {
        this.logChannel.log(1078071040, "ExternalServiceProviderEvo#stopPhoneApp: not defined in evo");
    }

    static /* synthetic */ int access$002(ExternalServiceProviderEvo externalServiceProviderEvo, int n) {
        externalServiceProviderEvo.lastAppState = n;
        return externalServiceProviderEvo.lastAppState;
    }

    static /* synthetic */ String access$102(ExternalServiceProviderEvo externalServiceProviderEvo, String string) {
        externalServiceProviderEvo.lastAppContext = string;
        return externalServiceProviderEvo.lastAppContext;
    }

    static /* synthetic */ LogChannel access$200(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.logChannel;
    }

    static /* synthetic */ LogChannel access$300(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.logChannel;
    }

    static /* synthetic */ LogChannel access$400(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.logChannel;
    }

    static /* synthetic */ LogChannel access$500(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.logChannel;
    }

    static /* synthetic */ RemoteHMIService access$600(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }

    static /* synthetic */ LogChannel access$700(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.logChannel;
    }

    static /* synthetic */ RemoteHMIService access$800(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }

    static /* synthetic */ RemoteHMIService access$900(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }

    static /* synthetic */ RemoteHMIService access$1000(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }

    static /* synthetic */ RemoteHMIService access$1100(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }

    static /* synthetic */ RemoteHMIService access$1200(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }

    static /* synthetic */ RemoteHMIService access$1300(ExternalServiceProviderEvo externalServiceProviderEvo) {
        return externalServiceProviderEvo.remoteHmiService;
    }
}

