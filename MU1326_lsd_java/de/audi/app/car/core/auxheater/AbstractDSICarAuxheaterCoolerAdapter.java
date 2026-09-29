/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener;
import org.dsi.ifc.global.CarBCTemperature;

public abstract class AbstractDSICarAuxheaterCoolerAdapter
extends AbstractCarComponent
implements DSICarAuxHeaterCoolerListener {
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler;

    public AbstractDSICarAuxheaterCoolerAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarAuxHeaterCooler getDSI() {
        return (DSICarAuxHeaterCooler)this.getBaseDSI();
    }

    @Override
    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener = AbstractDSICarAuxheaterCoolerAdapter.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener).getName();
    }

    @Override
    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler = AbstractDSICarAuxheaterCoolerAdapter.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler).getName();
    }

    @Override
    public final boolean isUsingDSI() {
        return true;
    }

    @Override
    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        this.logStub();
    }

    public void updateAuxHeaterCoolerHeaterState(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerState(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerRemainingTime(short s, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerRunningTime(short s, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerDefaultStartMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerEngineHeater(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerActiveTimer(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeAuxHeaterSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerPopup(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerMode2(AuxHeaterCoolerMode auxHeaterCoolerMode, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning2, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerWindowHeating(boolean bl, boolean bl2, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerUnlockClimating(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerTargetTemperature(CarBCTemperature carBCTemperature, int n) {
        this.logStub();
    }

    @Override
    public void updateAuxHeaterCoolerAirQuality(boolean bl, boolean bl2, int n) {
        this.logStub();
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

