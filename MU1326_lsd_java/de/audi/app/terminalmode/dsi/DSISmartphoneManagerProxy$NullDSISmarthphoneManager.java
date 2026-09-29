/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$1;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$NullDSISmarthphoneManager$1;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$NullDSISmarthphoneManager$2;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$NullDSISmarthphoneManager$3;
import de.audi.app.terminalmode.dsi.DSISmartphoneManagerProxy$NullDSISmarthphoneManager$4;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;

final class DSISmartphoneManagerProxy$NullDSISmarthphoneManager
implements IDSISmartphoneManager {
    private DSISmartphoneManagerProxy$NullDSISmarthphoneManager() {
    }

    @Override
    public void startService(TMState tMState) {
    }

    @Override
    public void responseUpdateMode(TMState tMState, long l) {
    }

    @Override
    public void requestNightMode(boolean bl) {
    }

    @Override
    public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
    }

    @Override
    public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
    }

    @Override
    public IDSISmartphoneManager$ISmartphoneProperties getSmartphoneProperties() {
        return new DSISmartphoneManagerProxy$NullDSISmarthphoneManager$1(this);
    }

    @Override
    public ISpeechRequestHandler getSpeechRequestHandler() {
        return new DSISmartphoneManagerProxy$NullDSISmarthphoneManager$2(this);
    }

    @Override
    public IPlayerModificationListener getPlayerModificationListener() {
        return new DSISmartphoneManagerProxy$NullDSISmarthphoneManager$3(this);
    }

    @Override
    public SmartphoneManager$SmartphoneType getSmartphoneType() {
        return SmartphoneManager$SmartphoneType.UNKNOWN;
    }

    @Override
    public IPhoneCallController getPhoneCallController() {
        return new DSISmartphoneManagerProxy$NullDSISmarthphoneManager$4(this);
    }

    /* synthetic */ DSISmartphoneManagerProxy$NullDSISmarthphoneManager(DSISmartphoneManagerProxy$1 dSISmartphoneManagerProxy$1) {
        this();
    }
}

