/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.app.car.sdis.CarBCASIProvider;
import de.audi.app.car.sdis.CarClimateASIProvider;
import de.audi.app.car.sdis.CarDrivingASIProvider;
import de.audi.app.car.sdis.CarServiceASIProvider;
import de.audi.app.car.sdis.CarSportChronoASIProvider;
import de.audi.app.car.sdis.CarZeroEmissionASIProvider;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionAbstractBaseService;

public class CarMainASIProvider {
    private ASIHMISyncCarBordComputerAbstractBaseService asiBC;
    private ASIHMISyncCarClimateAbstractBaseService asiClimate;
    private ASIHMISyncCarDrivingAbstractBaseService asiDriving;
    private ASIHMISyncCarServiceAbstractBaseService asiService;
    private ASIHMISyncCarSportChronoAbstractBaseService asiSportChrono;
    private ASIHMISyncCarZeroEmissionAbstractBaseService asiZeroEmission;
    private LogChannel logChannel;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    public CarMainASIProvider(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.asiBC = new CarBCASIProvider(logChannel);
        this.asiClimate = new CarClimateASIProvider(logChannel);
        this.asiDriving = new CarDrivingASIProvider(logChannel);
        this.asiService = new CarServiceASIProvider(logChannel);
        this.asiSportChrono = new CarSportChronoASIProvider(logChannel);
        this.asiZeroEmission = new CarZeroEmissionASIProvider(logChannel);
    }

    public void registerServices(AbstractActivator abstractActivator) {
        abstractActivator.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = CarMainASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiBC, null);
        abstractActivator.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = CarMainASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiClimate, null);
        abstractActivator.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = CarMainASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiDriving, null);
        abstractActivator.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = CarMainASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiService, null);
        abstractActivator.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = CarMainASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiSportChrono, null);
        abstractActivator.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = CarMainASIProvider.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiZeroEmission, null);
        this.logChannel.log(1000000, "[CarMainASIProvider#registerServices] services registered.");
    }

    public ASIHMISyncCarBordComputerAbstractBaseService getBordComputerASI() {
        return this.asiBC;
    }

    public ASIHMISyncCarClimateAbstractBaseService getClimateASI() {
        return this.asiClimate;
    }

    public ASIHMISyncCarDrivingAbstractBaseService getDrivingASI() {
        return this.asiDriving;
    }

    public ASIHMISyncCarServiceAbstractBaseService getServiceASI() {
        return this.asiService;
    }

    public ASIHMISyncCarSportChronoAbstractBaseService getSportChronoASI() {
        return this.asiSportChrono;
    }

    public ASIHMISyncCarZeroEmissionAbstractBaseService getZeroEmissionASI() {
        return this.asiZeroEmission;
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

