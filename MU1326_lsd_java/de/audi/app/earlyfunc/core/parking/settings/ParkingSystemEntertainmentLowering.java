/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.settings;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.interapp.audio.ToneServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public class ParkingSystemEntertainmentLowering
implements TimerListener,
ToneServiceListener {
    private final Timer pdcSoundReproductionTimer;
    private static final long PDC_SOUND_REPRODUCTION_TIME = 400L;
    private final PDCSoundReproduction soundReproduction = new PDCSoundReproduction();
    private final LogChannel logChannel;
    private DSICarParkingSystem parkingDSI;
    private CarServiceProvider audioServiceProvider;
    private final Object mutex = new Object();
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneServiceListener;

    public ParkingSystemEntertainmentLowering(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.pdcSoundReproductionTimer = new Timer("PDCSoundReproductionTimer", 400L, false, this);
    }

    public void init(DSICarParkingSystem dSICarParkingSystem, ICarApplication iCarApplication) {
        this.parkingDSI = dSICarParkingSystem;
        this.initServiceProvider(iCarApplication);
    }

    public void deinit() {
        this.parkingDSI = null;
        this.deinitServiceProvider();
    }

    private void initServiceProvider(ICarApplication iCarApplication) {
        this.audioServiceProvider = new CarServiceProvider((class$de$audi$atip$interapp$audio$ToneServiceListener == null ? (class$de$audi$atip$interapp$audio$ToneServiceListener = ParkingSystemEntertainmentLowering.class$("de.audi.atip.interapp.audio.ToneServiceListener")) : class$de$audi$atip$interapp$audio$ToneServiceListener).getName(), this, null, iCarApplication.getBundleContext(), this.getLogChannel());
        this.audioServiceProvider.startService();
    }

    private void deinitServiceProvider() {
        this.audioServiceProvider.stopService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateViewOptions(ParkingSystemViewOptions parkingSystemViewOptions) {
        Object object = this.mutex;
        synchronized (object) {
            this.soundReproduction.front = parkingSystemViewOptions.getPdcSoundFront().state != 0;
            this.soundReproduction.rear = parkingSystemViewOptions.getPdcSoundRear().state != 0;
            this.soundReproduction.left = parkingSystemViewOptions.getPdcSoundLeft().state != 0;
            this.soundReproduction.right = parkingSystemViewOptions.getPdcSoundRight().state != 0;
        }
    }

    private PDCSoundReproduction getSoundReproduction() {
        return this.soundReproduction;
    }

    private Timer getPdcSoundReproductionTimer() {
        return this.pdcSoundReproductionTimer;
    }

    private DSICarParkingSystem getParkingDSI() {
        if (this.parkingDSI == null) {
            this.getLogChannel().log(10000, "[ParkingSystemEntertainmentLowering#getParkingDSI] dsi == null");
        }
        return this.parkingDSI;
    }

    private LogChannel getLogChannel() {
        return this.logChannel;
    }

    public void updateApsEntertainmentLoweringComboboxState(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[ParkingSystemEntertainmentLowering#updateApsEntertainmentLoweringComboboxState] comboboxState='%1'", (long)n);
        }
        if (n == 1) {
            this.openComboBox();
        } else if (n == 0) {
            this.closeComboBox();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void openComboBox() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.getParkingDSI() != null && !this.getPdcSoundReproductionTimer().isRunning()) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "[ParkingSystemEntertainmentLowering#openComboBox] dsi.setPDCSoundReproduction(%1); restart timer: timer='%2'", (Object)this.getSoundReproduction(), (Object)this.getPdcSoundReproductionTimer());
                }
                this.getParkingDSI().setPDCSoundReproduction(this.getSoundReproduction());
                this.getPdcSoundReproductionTimer().restart();
            }
        }
    }

    private void closeComboBox() {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[ParkingSystemEntertainmentLowering#closeComboBox] cancel timer: timer='%1'", (Object)this.getPdcSoundReproductionTimer());
        }
        this.pdcSoundReproductionTimer.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[ParkingSystemEntertainmentLowering#fireTimer] dsi.setPDCSoundReproduction(%1): timer=%2", (Object)this.getSoundReproduction(), (Object)timer);
            }
            if (this.getParkingDSI() != null) {
                this.getParkingDSI().setPDCSoundReproduction(this.getSoundReproduction());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelTimer(Timer timer) {
        if (this.getParkingDSI() != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[ParkingSystemEntertainmentLowering#cancelTimer] dsi.setPDCSoundReproduction() to false: timer=%1", (Object)timer);
            }
            Object object = this.mutex;
            synchronized (object) {
                this.getParkingDSI().setPDCSoundReproduction(new PDCSoundReproduction());
            }
        }
    }

    public void updateNavEntertainmentLoweringComboboxState(int n) {
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

