/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.app;

import de.audi.app.car.common.app.AbstractCarApplication;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.evo.aircondition.AirConditionSeatComponentEvo;
import de.audi.app.car.evo.aircondition.AirconComponentEvo;
import de.audi.app.car.evo.aircondition.AirconInterappComponentEvo;
import de.audi.app.car.evo.ap.CarEvoActionProxyImpl;
import de.audi.app.car.evo.auxheater.AuxheaterComponentEvo;
import de.audi.app.car.evo.bcme.AddInfoTADComponentEvo;
import de.audi.app.car.evo.bcme.AirSuspensionIndicatorComponentEvo;
import de.audi.app.car.evo.bcme.ConsumerDisplayComponentEvo;
import de.audi.app.car.evo.bcme.TADComponentEvo;
import de.audi.app.car.evo.boardbook.CarBoardbookComponentEvo;
import de.audi.app.car.evo.charisma.CharismaComponentEvo;
import de.audi.app.car.evo.comfort.ComfortInterappControlComponentEVO;
import de.audi.app.car.evo.comfort.DoorLockingComponentEvo;
import de.audi.app.car.evo.comfort.EasyEntryComponentEvo;
import de.audi.app.car.evo.comfort.PreSenseRgsComponentEvo;
import de.audi.app.car.evo.comfort.RDKComponentEvo;
import de.audi.app.car.evo.comfort.UGDOComponentEvo;
import de.audi.app.car.evo.comfort.WiperComponentEvo;
import de.audi.app.car.evo.driveassist.ACCComponentEvo;
import de.audi.app.car.evo.driveassist.ACCDistanceWarningComponentEvo;
import de.audi.app.car.evo.driveassist.LDWComponentEvo;
import de.audi.app.car.evo.driveassist.MKEComponentEvo;
import de.audi.app.car.evo.driveassist.NVComponentEvo;
import de.audi.app.car.evo.driveassist.PreSenseAwvComponentEvo;
import de.audi.app.car.evo.driveassist.SWAComponentEvo;
import de.audi.app.car.evo.driveassist.SpeedWarningCameraComponentEvo;
import de.audi.app.car.evo.driveassist.TSDComponentEvo;
import de.audi.app.car.evo.eco.PEAComponentEvo;
import de.audi.app.car.evo.hybrid.AudiEnergyAssistComponentEvo;
import de.audi.app.car.evo.hybrid.AuxACComponentCarEvo;
import de.audi.app.car.evo.hybrid.ChargeComponentCarEvo;
import de.audi.app.car.evo.hybrid.ExtendedAuxACComponentCarEvo;
import de.audi.app.car.evo.hybrid.HybridEnergyMonitorComponentEvo;
import de.audi.app.car.evo.hybrid.HybridStatisticsComponentEvo;
import de.audi.app.car.evo.hybrid.PEAHybridSubComponent;
import de.audi.app.car.evo.joker.JokerKeyComponentEvo;
import de.audi.app.car.evo.kombi.HUDComponentEvo;
import de.audi.app.car.evo.kombi.SDSComponentEvo;
import de.audi.app.car.evo.kombi.SIAComponentEvo;
import de.audi.app.car.evo.kombi.SpeedWarningManualComponentEvo;
import de.audi.app.car.evo.light.ExtLightComponentEvo;
import de.audi.app.car.evo.light.IntLightComponentEvo;
import de.audi.app.car.evo.mer.CarEvoMenuEntryStructure;
import de.audi.app.car.evo.other.ContextComponentEvo;
import de.audi.app.car.evo.parking.ParkingSettingsCarEvo;
import de.audi.app.car.evo.seat.SeatComponentEvo;
import de.audi.app.car.evo.service.AdBlueComponentEvo;
import de.audi.app.car.evo.service.DrivingSchoolComponentEvo;
import de.audi.app.car.evo.service.KeyDataComponentEvo;
import de.audi.app.car.evo.service.OilLevelComponentEvo;
import de.audi.app.car.evo.service.VinComponentEvo;
import de.audi.app.car.evo.sport.SportComponentEvo;
import de.audi.app.car.evo.sport.SportKombiComponentEvo;
import de.audi.app.car.evo.testsupport.TestSupportComponentEvo;
import de.audi.app.car.evo.truffle.CarTruffleSearchComponentEvo;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import org.osgi.framework.BundleContext;

public class CarEvoApplication
extends AbstractCarApplication {
    private static final String LOG_CHANNEL_NAME;
    private static final String LOG_CHANNEL_MER_NAME;
    private final IMenuEntryStructure menuEntryStructure;
    private final CarEvoActionProxyImpl actionProxyImplementation;

    public CarEvoApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        super(iFrameworkAccess, bundleContext, "App.Car.Main");
        CarFuncAdap carFuncAdap = this.getCarMenuCoding();
        this.menuEntryStructure = new CarEvoMenuEntryStructure(iFrameworkAccess, iFrameworkAccess.getLogChannel("App.Car.MER"), carFuncAdap);
        this.actionProxyImplementation = new CarEvoActionProxyImpl(iFrameworkAccess, bundleContext, this.actionProxyDispatcher);
        boolean bl = this.isComponentAvailable((short)28, carFuncAdap);
        if (this.isComponentAvailable((short)17, carFuncAdap)) {
            this.addCarComponent(new CharismaComponentEvo(this));
        }
        if (this.isComponentAvailable((short)40, carFuncAdap)) {
            this.addCarComponent(new TADComponentEvo(this));
        }
        if (this.isComponentAvailable((short)40, carFuncAdap)) {
            this.addCarComponent(new AddInfoTADComponentEvo(this));
        }
        if (this.isComponentAvailable((short)21, carFuncAdap)) {
            this.addCarComponent(new AirSuspensionIndicatorComponentEvo(this));
        }
        if (this.isComponentAvailable((short)36, carFuncAdap)) {
            this.addCarComponent(new ConsumerDisplayComponentEvo(this));
        }
        if (this.isComponentAvailable((short)46, carFuncAdap)) {
            this.addCarComponent(new AuxACComponentCarEvo(this));
            if (ExtendedAuxACComponentCarEvo.isQ5Coded(iFrameworkAccess)) {
                this.addCarComponent(new ExtendedAuxACComponentCarEvo(this));
            }
        }
        if (this.isComponentAvailable((short)9, carFuncAdap)) {
            this.addCarComponent(new AuxheaterComponentEvo(this));
        }
        if (this.isComponentAvailable((short)8, carFuncAdap)) {
            this.addCarComponent(new AirconComponentEvo(this));
        }
        if (this.isComponentAvailable((short)8, carFuncAdap)) {
            this.addCarComponent(new AirConditionSeatComponentEvo(this));
        }
        if (this.isComponentAvailable((short)8, carFuncAdap)) {
            this.addCarComponent(new AirconInterappComponentEvo(this));
        }
        if (this.isComponentAvailable((short)15, carFuncAdap)) {
            this.addCarComponent(new DoorLockingComponentEvo(this));
        }
        if (this.isComponentAvailable((short)12, carFuncAdap)) {
            this.addCarComponent(new WiperComponentEvo(this));
        }
        if (this.isComponentAvailable((short)11, carFuncAdap)) {
            this.addCarComponent(new RDKComponentEvo(this));
        }
        if (this.isComponentAvailable((short)0, carFuncAdap)) {
            this.addCarComponent(new ACCComponentEvo(this));
        }
        if (bl) {
            this.addCarComponent(new PreSenseRgsComponentEvo(this));
        }
        if (this.isComponentAvailable((short)3, carFuncAdap)) {
            this.addCarComponent(new PreSenseAwvComponentEvo(this));
        }
        if (this.isComponentAvailable((short)4, carFuncAdap)) {
            this.addCarComponent(new LDWComponentEvo(this));
        }
        if (this.isComponentAvailable((short)0, carFuncAdap)) {
            this.addCarComponent(new ACCDistanceWarningComponentEvo(this));
        }
        if (this.isComponentAvailable((short)35, carFuncAdap)) {
            this.addCarComponent(new MKEComponentEvo(this));
        }
        if (this.isComponentAvailable((short)26, carFuncAdap)) {
            this.addCarComponent(new NVComponentEvo(this));
        }
        if (this.isComponentAvailable((short)5, carFuncAdap)) {
            this.addCarComponent(new SWAComponentEvo(this));
        }
        if (this.isComponentAvailable((short)10, carFuncAdap)) {
            this.addCarComponent(new SpeedWarningManualComponentEvo(this));
        }
        if (this.isComponentAvailable((short)30, carFuncAdap)) {
            this.addCarComponent(new SpeedWarningCameraComponentEvo(this));
        }
        if (this.isComponentAvailable((short)30, carFuncAdap)) {
            this.addCarComponent(new TSDComponentEvo(this));
        }
        if (this.isComponentAvailable((short)24, carFuncAdap)) {
            this.addCarComponent(new HybridEnergyMonitorComponentEvo(this));
        }
        if (this.isComponentAvailable(HybridStatisticsComponentEvo.CODING_ID, 0, carFuncAdap)) {
            this.addCarComponent(new HybridStatisticsComponentEvo(this));
        }
        if (this.isComponentAvailable(AudiEnergyAssistComponentEvo.CODING_ID, 0, carFuncAdap)) {
            this.addCarComponent(new AudiEnergyAssistComponentEvo(this));
        }
        if (this.isComponentAvailable((short)41, carFuncAdap)) {
            this.addCarComponent(new ChargeComponentCarEvo(this));
        }
        if (this.isComponentAvailable((short)22, carFuncAdap)) {
            this.addCarComponent(new HUDComponentEvo(this));
        }
        if (this.isComponentAvailable((short)13, carFuncAdap)) {
            this.addCarComponent(new SIAComponentEvo(this));
        }
        if (this.isComponentAvailable((short)6, carFuncAdap)) {
            this.addCarComponent(new ExtLightComponentEvo(this));
        }
        if (this.isComponentAvailable((short)32, carFuncAdap)) {
            this.addCarComponent(new KeyDataComponentEvo(this));
        }
        if (this.isComponentAvailable((short)18, carFuncAdap)) {
            this.addCarComponent(new OilLevelComponentEvo(this));
        }
        if (this.isComponentAvailable((short)19, carFuncAdap)) {
            this.addCarComponent(new VinComponentEvo(this));
        }
        if (this.isComponentAvailable((short)29, carFuncAdap)) {
            this.addCarComponent(new JokerKeyComponentEvo(this));
        }
        if (this.isComponentAvailable((short)25, carFuncAdap)) {
            this.addCarComponent(new UGDOComponentEvo(this));
        }
        if (this.isComponentAvailable((short)2, carFuncAdap)) {
            this.addCarComponent(new ParkingSettingsCarEvo(this));
        }
        if (this.isComponentAvailable((short)1, carFuncAdap)) {
            this.addCarComponent(new IntLightComponentEvo(this));
        }
        if (this.isComponentAvailable((short)12, carFuncAdap)) {
            this.addCarComponent(new EasyEntryComponentEvo((ICarApplication)this, bl));
        }
        if (this.isComponentAvailable(SeatComponentEvo.CODING_ID, 1, carFuncAdap)) {
            this.addCarComponent(new SeatComponentEvo((ICarApplication)this, bl));
        }
        if (this.isComponentAvailable((short)53, carFuncAdap)) {
            this.addCarComponent(new AdBlueComponentEvo(this));
        }
        if (this.isComponentAvailable((short)34, carFuncAdap) && this.isDrivingSchoolActive()) {
            this.addCarComponent(new DrivingSchoolComponentEvo(this));
        }
        if (this.isComponentAvailable((short)55, carFuncAdap)) {
            boolean bl2 = false;
            if (this.isComponentAvailable((short)24, carFuncAdap)) {
                bl2 = true;
            }
            PEAComponentEvo pEAComponentEvo = new PEAComponentEvo((ICarApplication)this, bl2);
            this.addCarComponent(pEAComponentEvo);
            if (bl2) {
                this.addCarComponent(new PEAHybridSubComponent((ICarApplication)this, pEAComponentEvo));
            }
        }
        if (this.isComponentAvailable((short)52, carFuncAdap)) {
            this.addCarComponent(new SportComponentEvo(this));
            this.addCarComponent(new SportKombiComponentEvo(this));
        }
        if (iFrameworkAccess.getSysConstManager().getCarCoding().isLogBookDisplayed()) {
            this.addCarComponent(new CarBoardbookComponentEvo(this));
        }
        this.addCarComponent(new TestSupportComponentEvo(this));
        this.addCarComponent(new SDSComponentEvo(this));
        if (this.getFrameworkAccess().isEvoHigh()) {
            this.addCarComponent(new CarTruffleSearchComponentEvo(this));
        }
        this.addCarComponent(new ContextComponentEvo(this));
        this.addCarComponent(new ComfortInterappControlComponentEVO(this));
    }

    @Override
    public void init() {
        super.init();
        this.actionProxyImplementation.init();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.actionProxyImplementation.deinit();
    }

    @Override
    public IMenuEntryStructure getMenuEntryStructure() {
        return this.menuEntryStructure;
    }

    @Override
    public int getId() {
        return 6;
    }

    @Override
    public String getApplicationName() {
        return "AppCar";
    }

    @Override
    public LogChannel getMerLogChannel() {
        return this.getFrameworkAccess().getLogChannel("App.Car.MER");
    }
}

