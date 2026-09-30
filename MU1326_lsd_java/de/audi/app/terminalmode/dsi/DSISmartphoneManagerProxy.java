/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.injector.IInjector;
import de.audi.atip.utils.reactive.properties.Property;

public class DSISmartphoneManagerProxy
implements IDSISmartphoneManager,
ITerminalModeComponent {
    private volatile IDSISmartphoneManager smartphoneManager;
    private volatile ISpeechRequestHandler speechRequestHandler;
    private volatile IPlayerModificationListener playerModificationListener;
    private volatile IPhoneCallController phoneCallController;
    private final ActiveDeviceListener activeDeviceListener;
    private final IDeviceManager deviceManager;
    private final ISpeechRequestHandler speechRequestHandlerProxy;
    private final IPlayerModificationListener playerModificationListenerProxy;
    private final IPhoneCallController phoneCallControllerProxy;
    private final GMap<SmartphoneManager.SmartphoneType, IDSISmartphoneManager> managers;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager;
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager;

    public DSISmartphoneManagerProxy(IDeviceManager iDeviceManager, IInjector iInjector) {
        this.deviceManager = iDeviceManager;
        this.activeDeviceListener = new ActiveDeviceListener();
        this.speechRequestHandlerProxy = new SpeechRequestHandlerProxy();
        this.playerModificationListenerProxy = new PlayerModificationListenerProxy();
        this.phoneCallControllerProxy = new PhoneCallControllerProxy();
        this.managers = Generics.newHashMap();
        this.managers.put(SmartphoneManager.SmartphoneType.CARPLAY, (IDSISmartphoneManager)iInjector.getInstance(SmartphoneManager.SmartphoneType.CARPLAY, class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager == null ? (class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager = DSISmartphoneManagerProxy.class$("de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager")) : class$de$audi$app$terminalmode$smartphone$carplay$CarPlayDSIManager));
        this.managers.put(SmartphoneManager.SmartphoneType.ANDROIDAUTO2, (IDSISmartphoneManager)iInjector.getInstance(SmartphoneManager.SmartphoneType.ANDROIDAUTO2, class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager == null ? (class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager = DSISmartphoneManagerProxy.class$("de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager")) : class$de$audi$app$terminalmode$smartphone$androidauto2$AndroidAuto2DSIManager));
        this.managers.put(SmartphoneManager.SmartphoneType.CARLIFE, (IDSISmartphoneManager)iInjector.getInstance(SmartphoneManager.SmartphoneType.CARLIFE, class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager == null ? (class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager = DSISmartphoneManagerProxy.class$("de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager")) : class$de$audi$app$terminalmode$smartphone$carlife$CarlifeDSIManager));
    }

    public void init() {
        this.deviceManager.addActiveDeviceListener(this.activeDeviceListener);
    }

    public void deinit() {
        this.deviceManager.removeActiveDeviceListener(this.activeDeviceListener);
    }

    public void startService(TMState tMState) {
        this.smartphoneManager.startService(tMState);
    }

    public void responseUpdateMode(TMState tMState, long l) {
        this.smartphoneManager.responseUpdateMode(tMState, l);
    }

    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager.RequestModeChangeCallback requestModeChangeCallback) {
        this.smartphoneManager.requestModeChange(tMState, string, requestModeChangeCallback);
    }

    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
        this.smartphoneManager.requestConstraintsChange(tMState, resource, bl);
    }

    public void requestNightMode(boolean bl) {
        this.smartphoneManager.requestNightMode(bl);
    }

    public IDSISmartphoneManager.ISmartphoneProperties getSmartphoneProperties() {
        return this.smartphoneManager.getSmartphoneProperties();
    }

    public ISpeechRequestHandler getSpeechRequestHandler() {
        return this.speechRequestHandlerProxy;
    }

    public IPlayerModificationListener getPlayerModificationListener() {
        return this.playerModificationListenerProxy;
    }

    public SmartphoneManager.SmartphoneType getSmartphoneType() {
        return this.smartphoneManager.getSmartphoneType();
    }

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

    private final class ActiveDeviceListener
    implements IActiveDeviceStateListener {
        private ActiveDeviceListener() {
        }

        public void updateActiveDeviceState(TMDevice tMDevice) {
            if (tMDevice.isSelected()) {
                DSISmartphoneManagerProxy.this.smartphoneManager = (IDSISmartphoneManager)DSISmartphoneManagerProxy.this.managers.get(tMDevice.smartphoneType());
            } else {
                DSISmartphoneManagerProxy.this.smartphoneManager = new NullDSISmarthphoneManager();
            }
            DSISmartphoneManagerProxy.this.speechRequestHandler = DSISmartphoneManagerProxy.this.smartphoneManager.getSpeechRequestHandler();
            DSISmartphoneManagerProxy.this.playerModificationListener = DSISmartphoneManagerProxy.this.smartphoneManager.getPlayerModificationListener();
            DSISmartphoneManagerProxy.this.phoneCallController = DSISmartphoneManagerProxy.this.smartphoneManager.getPhoneCallController();
        }
    }

    private class PhoneCallControllerProxy
    implements IPhoneCallController {
        private PhoneCallControllerProxy() {
        }

        public void hook(boolean bl) {
            DSISmartphoneManagerProxy.this.phoneCallController.hook(bl);
        }

        public void hangup(boolean bl) {
            DSISmartphoneManagerProxy.this.phoneCallController.hangup(bl);
        }

        public void flash(boolean bl) {
            DSISmartphoneManagerProxy.this.phoneCallController.flash(bl);
        }
    }

    private static final class NullDSISmarthphoneManager
    implements IDSISmartphoneManager {
        private NullDSISmarthphoneManager() {
        }

        public void startService(TMState tMState) {
        }

        public void responseUpdateMode(TMState tMState, long l) {
        }

        public void requestNightMode(boolean bl) {
        }

        public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager.RequestModeChangeCallback requestModeChangeCallback) {
        }

        public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
        }

        public IDSISmartphoneManager.ISmartphoneProperties getSmartphoneProperties() {
            return new IDSISmartphoneManager.ISmartphoneProperties(){

                @Override
                public Property<Boolean> getPropertyMUPhonecallActive() {
                    return null;
                }

                @Override
                public Property<Boolean> getPropertyMUHFPPhonecallActive() {
                    return null;
                }

                @Override
                public Property<BTState> getPropertyBluetooth() {
                    return null;
                }

                @Override
                public Property<Boolean> getPropertyMURVCActive() {
                    return null;
                }

                @Override
                public Property<SPIServiceState> getPropertySPIServiceState() {
                    return null;
                }
            };
        }

        public ISpeechRequestHandler getSpeechRequestHandler() {
            return new ISpeechRequestHandler(){

                public void startSpeechSession() {
                }

                public void pttReleasedAfterLongPress() {
                }

                public void prewarm() {
                }

                public void cancelPrewarm() {
                }

                public void abortActiveSpeechSession() {
                }
            };
        }

        public IPlayerModificationListener getPlayerModificationListener() {
            return new IPlayerModificationListener(){

                public void skip(boolean bl, int n) {
                }

                public void seek(boolean bl, boolean bl2) {
                }

                public void resume() {
                }

                public void pause(boolean bl) {
                }
            };
        }

        public SmartphoneManager.SmartphoneType getSmartphoneType() {
            return SmartphoneManager.SmartphoneType.UNKNOWN;
        }

        public IPhoneCallController getPhoneCallController() {
            return new IPhoneCallController(){

                public void hook(boolean bl) {
                }

                public void hangup(boolean bl) {
                }

                public void flash(boolean bl) {
                }
            };
        }
    }

    private class SpeechRequestHandlerProxy
    implements ISpeechRequestHandler {
        private SpeechRequestHandlerProxy() {
        }

        public void prewarm() {
            DSISmartphoneManagerProxy.this.speechRequestHandler.prewarm();
        }

        public void abortActiveSpeechSession() {
            DSISmartphoneManagerProxy.this.speechRequestHandler.abortActiveSpeechSession();
        }

        public void cancelPrewarm() {
            DSISmartphoneManagerProxy.this.speechRequestHandler.cancelPrewarm();
        }

        public void startSpeechSession() {
            DSISmartphoneManagerProxy.this.speechRequestHandler.startSpeechSession();
        }

        public void pttReleasedAfterLongPress() {
            DSISmartphoneManagerProxy.this.speechRequestHandler.pttReleasedAfterLongPress();
        }
    }

    private class PlayerModificationListenerProxy
    implements IPlayerModificationListener {
        private PlayerModificationListenerProxy() {
        }

        public void skip(boolean bl, int n) {
            DSISmartphoneManagerProxy.this.playerModificationListener.skip(bl, n);
        }

        public void seek(boolean bl, boolean bl2) {
            DSISmartphoneManagerProxy.this.playerModificationListener.seek(bl, bl2);
        }

        public void resume() {
            DSISmartphoneManagerProxy.this.playerModificationListener.resume();
        }

        public void pause(boolean bl) {
            DSISmartphoneManagerProxy.this.playerModificationListener.pause(bl);
        }
    }
}

