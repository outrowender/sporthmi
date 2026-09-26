/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 *  de.audi.atip.utils.generics.GMap
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$ActiveDeviceListener;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$PhoneCallControllerProxy;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$PlayerModificationListenerProxy;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$SpeechRequestHandlerProxy;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.injector.IInjector;

public class DSISmartphoneManagerProxy
implements IDSISmartphoneManager,
ITerminalModeComponent {
    private volatile IDSISmartphoneManager smartphoneManager;
    private volatile ISpeechRequestHandler speechRequestHandler;
    private volatile IPlayerModificationListener playerModificationListener;
    private volatile IPhoneCallController phoneCallController;
    private final DSISmartphoneManagerProxy$ActiveDeviceListener activeDeviceListener;
    private final IDeviceManager deviceManager;
    private final ISpeechRequestHandler speechRequestHandlerProxy;
    private final IPlayerModificationListener playerModificationListenerProxy;
    private final IPhoneCallController phoneCallControllerProxy;
    private final GMap managers;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager;

    public DSISmartphoneManagerProxy(IDeviceManager iDeviceManager, IInjector iInjector) {
        this.deviceManager = iDeviceManager;
        this.activeDeviceListener = new DSISmartphoneManagerProxy$ActiveDeviceListener(this, null);
        this.speechRequestHandlerProxy = new DSISmartphoneManagerProxy$SpeechRequestHandlerProxy(this, null);
        this.playerModificationListenerProxy = new DSISmartphoneManagerProxy$PlayerModificationListenerProxy(this, null);
        this.phoneCallControllerProxy = new DSISmartphoneManagerProxy$PhoneCallControllerProxy(this, null);
        this.managers = Generics.newHashMap();
        this.managers.put((Object)SmartphoneManager$SmartphoneType.CARPLAY, (Object)((IDSISmartphoneManager)iInjector.getInstance(SmartphoneManager$SmartphoneType.CARPLAY, class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager == null ? (class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager = DSISmartphoneManagerProxy.class$("de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager")) : class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager)));
        this.managers.put((Object)SmartphoneManager$SmartphoneType.ANDROIDAUTO2, (Object)((IDSISmartphoneManager)iInjector.getInstance(SmartphoneManager$SmartphoneType.ANDROIDAUTO2, class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager == null ? (class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager = DSISmartphoneManagerProxy.class$("de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager")) : class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager)));
        this.managers.put((Object)SmartphoneManager$SmartphoneType.CARLIFE, (Object)((IDSISmartphoneManager)iInjector.getInstance(SmartphoneManager$SmartphoneType.CARLIFE, class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager == null ? (class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager = DSISmartphoneManagerProxy.class$("de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager")) : class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager)));
    }

    @Override
    public void init() {
        this.deviceManager.addActiveDeviceListener(this.activeDeviceListener);
    }

    @Override
    public void deinit() {
        this.deviceManager.removeActiveDeviceListener(this.activeDeviceListener);
    }

    @Override
    public void startService(TMState tMState) {
        this.smartphoneManager.startService(tMState);
    }

    @Override
    public void responseUpdateMode(TMState tMState, long l) {
        this.smartphoneManager.responseUpdateMode(tMState, l);
    }

    @Override
    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager.RequestModeChangeCallback requestModeChangeCallback) {
        this.smartphoneManager.requestModeChange(tMState, string, requestModeChangeCallback);
    }

    @Override
    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
        this.smartphoneManager.requestConstraintsChange(tMState, resource, bl);
    }

    @Override
    public void requestNightMode(boolean bl) {
        this.smartphoneManager.requestNightMode(bl);
    }

    @Override
    public IDSISmartphoneManager$ISmartphoneProperties getSmartphoneProperties() {
        return this.smartphoneManager.getSmartphoneProperties();
    }

    @Override
    public ISpeechRequestHandler getSpeechRequestHandler() {
        return this.speechRequestHandlerProxy;
    }

    @Override
    public IPlayerModificationListener getPlayerModificationListener() {
        return this.playerModificationListenerProxy;
    }

    @Override
    public SmartphoneManager$SmartphoneType getSmartphoneType() {
        return this.smartphoneManager.getSmartphoneType();
    }

    @Override
    public IPhoneCallController getPhoneCallController() {
        return this.phoneCallControllerProxy;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IDSISmartphoneManager access$402(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, IDSISmartphoneManager iDSISmartphoneManager) {
        dSISmartphoneManagerProxy.smartphoneManager = iDSISmartphoneManager;
        return dSISmartphoneManagerProxy.smartphoneManager;
    }

    static /* synthetic */ GMap access$500(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        return dSISmartphoneManagerProxy.managers;
    }

    static /* synthetic */ ISpeechRequestHandler access$702(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, ISpeechRequestHandler iSpeechRequestHandler) {
        dSISmartphoneManagerProxy.speechRequestHandler = iSpeechRequestHandler;
        return dSISmartphoneManagerProxy.speechRequestHandler;
    }

    static /* synthetic */ IDSISmartphoneManager access$400(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        return dSISmartphoneManagerProxy.smartphoneManager;
    }

    static /* synthetic */ IPlayerModificationListener access$802(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, IPlayerModificationListener iPlayerModificationListener) {
        dSISmartphoneManagerProxy.playerModificationListener = iPlayerModificationListener;
        return dSISmartphoneManagerProxy.playerModificationListener;
    }

    static /* synthetic */ IPhoneCallController access$902(DSISmartphoneManagerProxy dSISmartphoneManagerProxy, IPhoneCallController iPhoneCallController) {
        dSISmartphoneManagerProxy.phoneCallController = iPhoneCallController;
        return dSISmartphoneManagerProxy.phoneCallController;
    }

    static /* synthetic */ ISpeechRequestHandler access$700(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        return dSISmartphoneManagerProxy.speechRequestHandler;
    }

    static /* synthetic */ IPlayerModificationListener access$800(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        return dSISmartphoneManagerProxy.playerModificationListener;
    }

    static /* synthetic */ IPhoneCallController access$900(DSISmartphoneManagerProxy dSISmartphoneManagerProxy) {
        return dSISmartphoneManagerProxy.phoneCallController;
    }
}

