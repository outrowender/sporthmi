/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.smartphone.AbstractDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeHMISetModeHandler;
import de.audi.app.terminalmode.smartphone.carlife.DSIMHIConstantsMapper;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.ServiceConfiguration;

public class CarlifeDSIManager
extends AbstractDSISmartphoneManager {
    private static final String LOGCLASS = "CarlifeDSIManager";
    private final DSICarlife dsiCarlife;
    private final ITerminalModeConfiguration configuration;
    private final INightDayModeHandler nightModeHandler;
    private volatile TMState currentState;
    private final DSIMHIConstantsMapper mapper;
    private final CarlifeHMISetModeHandler handler;
    private final IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;

    public CarlifeDSIManager(IContext iContext, DSICarlife dSICarlife, INightDayModeHandler iNightDayModeHandler, DSIMHIConstantsMapper dSIMHIConstantsMapper, CarlifeHMISetModeHandler carlifeHMISetModeHandler, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        super(iContext, SmartphoneManager.SmartphoneType.CARLIFE);
        this.dsiCarlife = dSICarlife;
        this.configuration = iContext.getConfiguration();
        this.smartphoneProperties = iSmartphoneProperties;
        this.nightModeHandler = iNightDayModeHandler;
        this.mapper = dSIMHIConstantsMapper;
        this.handler = carlifeHMISetModeHandler;
    }

    public void startService(TMState tMState) {
        this.logger.log(10000000, "[%1.startService]", (Object)LOGCLASS);
        ServiceConfiguration serviceConfiguration = new ServiceConfiguration(this.mapper.createAppStates(tMState), this.mapper.createResources(tMState), this.configuration.getScreenResolutionX(), this.configuration.getScreenResolutionY(), this.configuration.getScreenOffsetX(), this.configuration.getScreenOffsetY(), this.configuration.getScreenName(), this.configuration.isRightHandDrive(), this.configuration.hasTouchscreen(), this.configuration.getScreenResolutionX(), this.configuration.getScreenResolutionY(), this.configuration.hasTouchpad(), this.configuration.getTouchPadResolutionX(), this.configuration.getTouchPadResolutionY(), this.nightModeHandler.getRequestedNightMode(), this.configuration.getPhysicalDisplayHeight(), this.configuration.getPhysicalDisplayWidth());
        this.dsiCarlife.startService(serviceConfiguration);
        this.currentState = tMState;
    }

    public void responseUpdateMode(TMState tMState, long l) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "[%1.responseUpdateMode]", (Object)LOGCLASS);
        }
    }

    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager.RequestModeChangeCallback requestModeChangeCallback) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "[%1.requestModeChange]", (Object)LOGCLASS);
        }
        this.handler.requestModeChange(tMState, string, requestModeChangeCallback);
    }

    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
    }

    public void requestNightMode(boolean bl) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "[%1.requestNightMode] %2", (Object)LOGCLASS, (Object)new Boolean(bl));
        }
        this.dsiCarlife.requestNightMode(bl);
    }

    public IDSISmartphoneManager.ISmartphoneProperties getSmartphoneProperties() {
        return this.smartphoneProperties;
    }

    private void toggleButtonEvent(int n) {
        this.dsiCarlife.postButtonEvent(n, 0);
        this.dsiCarlife.postButtonEvent(n, 1);
    }

    public ISpeechRequestHandler getSpeechRequestHandler() {
        return new ISpeechRequestHandler(){

            public void startSpeechSession() {
                CarlifeDSIManager.this.toggleButtonEvent(20);
            }

            public void pttReleasedAfterLongPress() {
            }

            public void prewarm() {
            }

            public void cancelPrewarm() {
            }

            public void abortActiveSpeechSession() {
                CarlifeDSIManager.this.toggleButtonEvent(21);
            }
        };
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

    public void skip(boolean bl, int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            this.toggleButtonEvent(bl ? 13 : 14);
        }
    }

    public void seek(boolean bl, boolean bl2) {
        if (bl2) {
            this.dsiCarlife.postButtonEvent(bl ? 15 : 16, 0);
        } else {
            this.dsiCarlife.postButtonEvent(bl ? 15 : 16, 1);
        }
    }

    public void resume() {
        this.toggleButtonEvent(18);
    }

    public void pause(boolean bl) {
        this.toggleButtonEvent(19);
    }

    protected IDSIAppState createAppState(int n, int n2, int n3) {
        return new IDSIAppState(){

            public int getSpeechMode() {
                return 0;
            }

            public int getOwner() {
                return 0;
            }

            public int getAppStateId() {
                return 0;
            }

            public int getDSISpeechMode() {
                return 0;
            }

            public int getDSIOwner() {
                return 0;
            }

            public int getDSIAppStateId() {
                return 0;
            }
        };
    }
}

