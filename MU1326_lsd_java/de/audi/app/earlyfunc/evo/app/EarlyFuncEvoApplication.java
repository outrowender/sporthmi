/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.app;

import de.audi.app.car.common.app.AbstractCarApplication;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.earlyfunc.ap.EarlyFuncEvoActionProxyImpl;
import de.audi.app.earlyfunc.evo.mer.EarlyFuncEvoMenuEntryStructure;
import de.audi.app.earlyfunc.evo.other.MenuStateComponentEvo;
import de.audi.app.earlyfunc.evo.parking.ParkingSettingsEvo;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemARAComponentEvo;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemControllerComponentEvo;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemPLAComponentEvo;
import de.audi.app.earlyfunc.evo.parking.ParkingSystemVPSComponentEvo;
import de.audi.app.earlyfunc.evo.parking.ops.ParkingSystemOPSComponentEvo;
import de.audi.app.earlyfunc.evo.parking.rcta.RCTAComponentEvo;
import de.audi.app.earlyfunc.evo.seat.SeatPopinComponentEvo;
import de.audi.app.earlyfunc.hybrid.AuxACComponentEvo;
import de.audi.app.earlyfunc.hybrid.BatteryControlListHandlingComponentEvo;
import de.audi.app.earlyfunc.hybrid.ChargeComponentEvo;
import de.audi.app.earlyfunc.hybrid.EtronComponentEvo;
import de.audi.app.earlyfunc.hybrid.GoodbyeComponentEvo;
import de.audi.app.earlyfunc.hybrid.TargetRangeComponentEvo;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import org.osgi.framework.BundleContext;

public class EarlyFuncEvoApplication
extends AbstractCarApplication {
    private static final String LOG_CHANNEL_NAME;
    private static final String LOG_CHANNEL_MER_NAME;
    private final IMenuEntryStructure menuStructure;
    private final EarlyFuncEvoActionProxyImpl actionProxyImplementation;

    public EarlyFuncEvoApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        super(iFrameworkAccess, bundleContext, "App.EarlyFunc.Main");
        this.menuStructure = new EarlyFuncEvoMenuEntryStructure(iFrameworkAccess, iFrameworkAccess.getLogChannel("App.EarlyFunc.MER"));
        this.actionProxyImplementation = new EarlyFuncEvoActionProxyImpl(iFrameworkAccess, bundleContext, this.actionProxyDispatcher);
        CarFuncAdap carFuncAdap = this.getCarMenuCoding();
        ParkingSystemControllerComponentEvo parkingSystemControllerComponentEvo = new ParkingSystemControllerComponentEvo(this);
        this.addCarComponent(parkingSystemControllerComponentEvo);
        if (this.isComponentAvailable((short)2, carFuncAdap)) {
            this.addCarComponent(new ParkingSettingsEvo(this));
            this.addCarComponent(new ParkingSystemOPSComponentEvo((ICarApplication)this, parkingSystemControllerComponentEvo));
            this.addCarComponent(new ParkingSystemVPSComponentEvo((ICarApplication)this, parkingSystemControllerComponentEvo));
            this.addCarComponent(new ParkingSystemPLAComponentEvo((ICarApplication)this, parkingSystemControllerComponentEvo));
        } else {
            try {
                this.getFrameworkAccess().getStartupMgr().setRVCActive(false);
            }
            catch (Exception exception) {
                this.getLogChannel().log(10000, "[EarlyFuncEvoApplication] exception during call 'setRVCActive(false)' at StartupManager.", (Throwable)exception);
            }
        }
        if (this.isComponentAvailable((short)5, carFuncAdap)) {
            this.addCarComponent(new RCTAComponentEvo(this));
        }
        if (this.isComponentAvailable((short)44, carFuncAdap)) {
            this.addCarComponent(new ParkingSystemARAComponentEvo((ICarApplication)this, parkingSystemControllerComponentEvo));
        }
        if (this.isComponentAvailable((short)14, carFuncAdap) || this.isComponentAvailable((short)48, carFuncAdap)) {
            this.addCarComponent(new SeatPopinComponentEvo(this));
        }
        if (this.isComponentAvailable(EtronComponentEvo.CODING_ID, 0, carFuncAdap)) {
            this.addCarComponent(new EtronComponentEvo(this));
        }
        if (this.isComponentAvailable((short)41, carFuncAdap)) {
            this.addCarComponent(new GoodbyeComponentEvo(this));
        }
        if (this.isComponentAvailable((short)41, carFuncAdap)) {
            this.addCarComponent(new BatteryControlListHandlingComponentEvo(this));
        }
        if (this.isComponentAvailable((short)41, carFuncAdap)) {
            this.addCarComponent(new TargetRangeComponentEvo(this));
        }
        this.addCarComponent(new MenuStateComponentEvo(this));
        if (this.isComponentAvailable((short)41, carFuncAdap)) {
            this.addCarComponent(new ChargeComponentEvo(this));
        }
        if (this.isComponentAvailable((short)46, carFuncAdap)) {
            this.addCarComponent(new AuxACComponentEvo(this));
        }
    }

    @Override
    public void init() {
        super.init();
        this.actionProxyImplementation.init();
        this.initAuxClimateHeatingCodingModel();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.actionProxyImplementation.deinit();
    }

    @Override
    public IMenuEntryStructure getMenuEntryStructure() {
        return this.menuStructure;
    }

    @Override
    public String getApplicationName() {
        return "AppEarlyFunc";
    }

    @Override
    public int getId() {
        return 21;
    }

    @Override
    public LogChannel getMerLogChannel() {
        return this.getFrameworkAccess().getLogChannel("App.EarlyFunc.MER");
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    private void initAuxClimateHeatingCodingModel() {
        this.getFrameworkAccess().getHmiServiceApp().getChoiceModel(168632320).setValue(this.getClimateSystemVariant());
    }
}

