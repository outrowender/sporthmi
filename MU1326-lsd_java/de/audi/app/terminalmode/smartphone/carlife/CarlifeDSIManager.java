/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INightDayModeHandler;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.smartphone.AbstractDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager$1;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager$2;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIManager$3;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeHMISetModeHandler;
import de.audi.app.terminalmode.smartphone.carlife.DSIMHIConstantsMapper;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.ServiceConfiguration;

public class CarlifeDSIManager
extends AbstractDSISmartphoneManager {
    private static final String LOGCLASS;
    private final DSICarlife dsiCarlife;
    private final ITerminalModeConfiguration configuration;
    private final INightDayModeHandler nightModeHandler;
    private volatile TMState currentState;
    private final DSIMHIConstantsMapper mapper;
    private final CarlifeHMISetModeHandler handler;
    private final IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;

    public CarlifeDSIManager(IContext iContext, DSICarlife dSICarlife, INightDayModeHandler iNightDayModeHandler, DSIMHIConstantsMapper dSIMHIConstantsMapper, CarlifeHMISetModeHandler carlifeHMISetModeHandler, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        super(iContext, SmartphoneManager$SmartphoneType.CARLIFE);
        this.dsiCarlife = dSICarlife;
        this.configuration = iContext.getConfiguration();
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
        this.nightModeHandler = iNightDayModeHandler;
        this.mapper = dSIMHIConstantsMapper;
        this.handler = carlifeHMISetModeHandler;
    }

    @Override
    public void startService(TMState tMState) {
        this.logger.log(-2137614336, "[%1.startService]", (Object)"CarlifeDSIManager");
        ServiceConfiguration serviceConfiguration = new ServiceConfiguration(this.mapper.createAppStates(tMState), this.mapper.createResources(tMState), this.configuration.getScreenResolutionX(), this.configuration.getScreenResolutionY(), this.configuration.getScreenOffsetX(), this.configuration.getScreenOffsetY(), this.configuration.getScreenName(), this.configuration.isRightHandDrive(), this.configuration.hasTouchscreen(), this.configuration.getScreenResolutionX(), this.configuration.getScreenResolutionY(), this.configuration.hasTouchpad(), this.configuration.getTouchPadResolutionX(), this.configuration.getTouchPadResolutionY(), this.nightModeHandler.getRequestedNightMode(), this.configuration.getPhysicalDisplayHeight(), this.configuration.getPhysicalDisplayWidth());
        this.dsiCarlife.startService(serviceConfiguration);
        this.currentState = tMState;
    }

    @Override
    public void responseUpdateMode(TMState tMState, long l) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.responseUpdateMode]", (Object)"CarlifeDSIManager");
        }
    }

    @Override
    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.requestModeChange]", (Object)"CarlifeDSIManager");
        }
        this.handler.requestModeChange(tMState, string, iDSISmartphoneManager$RequestModeChangeCallback);
    }

    @Override
    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
    }

    @Override
    public void requestNightMode(boolean bl) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.requestNightMode] %2", (Object)"CarlifeDSIManager", (Object)new Boolean(bl));
        }
        this.dsiCarlife.requestNightMode(bl);
    }

    @Override
    public IDSISmartphoneManager$ISmartphoneProperties getSmartphoneProperties() {
        return this.smartphoneProperties;
    }

    private void toggleButtonEvent(int n) {
        this.dsiCarlife.postButtonEvent(n, 0);
        this.dsiCarlife.postButtonEvent(n, 1);
    }

    @Override
    public ISpeechRequestHandler getSpeechRequestHandler() {
        return new CarlifeDSIManager$1(this);
    }

    @Override
    public IPhoneCallController getPhoneCallController() {
        return new CarlifeDSIManager$2(this);
    }

    @Override
    public void skip(boolean bl, int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            this.toggleButtonEvent(bl ? 13 : 14);
        }
    }

    @Override
    public void seek(boolean bl, boolean bl2) {
        if (bl2) {
            this.dsiCarlife.postButtonEvent(bl ? 15 : 16, 0);
        } else {
            this.dsiCarlife.postButtonEvent(bl ? 15 : 16, 1);
        }
    }

    @Override
    public void resume() {
        this.toggleButtonEvent(18);
    }

    @Override
    public void pause(boolean bl) {
        this.toggleButtonEvent(19);
    }

    @Override
    protected IDSIAppState createAppState(int n, int n2, int n3) {
        return new CarlifeDSIManager$3(this);
    }

    static /* synthetic */ void access$000(CarlifeDSIManager carlifeDSIManager, int n) {
        carlifeDSIManager.toggleButtonEvent(n);
    }
}

