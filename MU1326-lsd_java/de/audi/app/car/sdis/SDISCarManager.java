/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.app.car.sdis.CarMainASIProvider;
import de.audi.app.car.sdis.base.SDISBase;
import de.audi.app.car.sdis.comp.CarAirConditionComponent;
import de.audi.app.car.sdis.comp.CarComfortComponent;
import de.audi.app.car.sdis.comp.CarDrivingCharacteristicsComponent;
import de.audi.app.car.sdis.comp.CarKombiComponent;
import de.audi.app.car.sdis.comp.CarVehicleStateComponent;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import org.osgi.framework.BundleContext;

public class SDISCarManager {
    private final IFrameworkAccess framework;
    private final SDISBase sdisFramework;
    private final CarFuncAdap codingAdapter;
    private CarVehicleStateComponent carVehicleStateComponent;
    private CarDrivingCharacteristicsComponent carDrivingCharacteristicsComponent;
    private CarComfortComponent carComfortComponent;
    private CarKombiComponent carKombiComponent;
    private CarAirConditionComponent carAirConditionComponent;

    public SDISCarManager(LogChannel logChannel, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, CarMainASIProvider carMainASIProvider) {
        this.framework = iFrameworkAccess;
        this.codingAdapter = this.framework.getSysConstManager().getCarFuncAdaptation();
        this.sdisFramework = new SDISBase("App.CarSDIS.Base", bundleContext, this.framework, carMainASIProvider, this.codingAdapter);
    }

    public void init() {
        this.carVehicleStateComponent = new CarVehicleStateComponent(this.sdisFramework);
        this.carVehicleStateComponent.init();
        this.carDrivingCharacteristicsComponent = new CarDrivingCharacteristicsComponent(this.sdisFramework);
        this.carDrivingCharacteristicsComponent.init();
        this.carComfortComponent = new CarComfortComponent(this.sdisFramework);
        this.carComfortComponent.init();
        this.carKombiComponent = new CarKombiComponent(this.sdisFramework);
        this.carKombiComponent.init();
        this.carAirConditionComponent = new CarAirConditionComponent(this.sdisFramework);
        this.carAirConditionComponent.init();
    }

    public void deinit() {
        if (this.carVehicleStateComponent != null) {
            this.carVehicleStateComponent.deinit();
        }
        if (this.carDrivingCharacteristicsComponent != null) {
            this.carDrivingCharacteristicsComponent.deinit();
        }
        if (this.carComfortComponent != null) {
            this.carComfortComponent.deinit();
        }
        if (this.carKombiComponent != null) {
            this.carKombiComponent.deinit();
        }
        if (this.carAirConditionComponent != null) {
            this.carAirConditionComponent.deinit();
        }
    }

    public boolean isAvailable(byte[] byArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            bl = bl || this.getCodingAdapter().isMenuDisplayActivated(byArray[i2]);
        }
        return bl;
    }

    public SDISBase getSDISBase() {
        return this.sdisFramework;
    }

    public CarFuncAdap getCodingAdapter() {
        return this.sdisFramework.getCarAdaption();
    }

    public CarVehicleStateComponent getCarVehicleStateComponent() {
        return this.carVehicleStateComponent;
    }

    public CarKombiComponent getCarKombiComponent() {
        return this.carKombiComponent;
    }

    public CarDrivingCharacteristicsComponent getCarDrivingCharacteristicsComponent() {
        return this.carDrivingCharacteristicsComponent;
    }

    public CarComfortComponent getCarComfortComponent() {
        return this.carComfortComponent;
    }

    public CarAirConditionComponent getCarAirConditionComponent() {
        return this.carAirConditionComponent;
    }
}

