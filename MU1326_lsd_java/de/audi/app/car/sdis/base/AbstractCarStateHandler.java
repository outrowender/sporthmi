/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.app.car.sdis.base.ICoding;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.base.IVisibility;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.sysapp.IStandStillListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;

public class AbstractCarStateHandler
implements PowerEventListener,
SpeedThresholdListener,
IStandStillListener {
    protected final LogChannel logger;
    private Object mutex = new Object();
    private CarFuncAdap codingAdapter;
    protected boolean registeredClamp15 = false;
    protected boolean registeredVthr = false;
    protected boolean registeredStandstill = false;
    protected volatile boolean isClamp15On = false;
    protected volatile boolean isUnderVThr = true;
    protected volatile boolean isStandstill = true;
    private ISDISFramework baseService;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public AbstractCarStateHandler(LogChannel logChannel, ISDISFramework iSDISFramework) {
        this.logger = logChannel;
        this.baseService = iSDISFramework;
        this.codingAdapter = this.baseService.getCarAdaption();
    }

    public void registerCarStates(byte[] byArray) {
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            short s = byArray[i2];
            byte by = this.codingAdapter.getByteCoding(s);
            this.logger.log(1000000, "[registerCarStates] coding of %1(%2): %3", (Object)ICoding.CODING_INDEX_TEXT[s], (long)s, (long)by);
            if (!this.isActivated(s)) {
                this.logger.log(1000000, "[registerCarStates] not coded[%2|%1]", (Object)ICoding.CODING_INDEX_TEXT[s], (long)s);
                return;
            }
            if (!this.registeredClamp15 && this.isClamp15Sensitive(s)) {
                this.logger.log(1000000, "[registerCarStates] ignition [%2|%1]", (Object)ICoding.CODING_INDEX_TEXT[s], (long)s);
                this.baseService.registerService((class$de$audi$atip$power$PowerEventListener == null ? AbstractCarStateHandler.class$("de.audi.atip.power.PowerEventListener") : class$de$audi$atip$power$PowerEventListener).getName(), this);
                this.registeredClamp15 = true;
            }
            if (!this.registeredVthr && this.isVThresholdSensitive(s)) {
                this.logger.log(1000000, "[registerCarStates] threshold sensitive [%2|%1]", (Object)ICoding.CODING_INDEX_TEXT[s], (long)s);
                this.baseService.getHMIFramework().getSysApp().registerSpeedThresholdListener(this, 1);
                this.registeredVthr = true;
            }
            if (this.registeredStandstill || !this.isStandstillSensitive(s)) continue;
            this.logger.log(1000000, "[registerCarStates] standstill sensitive [%2|%1]", (Object)ICoding.CODING_INDEX_TEXT[s], (long)s);
            this.baseService.getHMIFramework().getSysApp().registerStandStillListener(this);
            this.isStandstill = true;
        }
    }

    public void deregisterCarStates() {
        if (this.registeredClamp15) {
            this.baseService.deRegisterService((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = AbstractCarStateHandler.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName());
            this.registeredClamp15 = false;
        }
        if (this.registeredVthr) {
            this.baseService.getHMIFramework().getSysApp().unregisterSpeedThresholdListener(this);
            this.registeredVthr = false;
        }
        if (this.registeredStandstill) {
            this.baseService.getHMIFramework().getSysApp().unregisterStandStillListener(this);
            this.isStandstill = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void exceedsUpperThreshold(int n) {
        if (n == 1) {
            Object object = this.mutex;
            synchronized (object) {
                this.isUnderVThr = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void belowLowerThreshold(int n) {
        if (n == 1) {
            Object object = this.mutex;
            synchronized (object) {
                this.isUnderVThr = true;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object = this.mutex;
        synchronized (object) {
            this.isClamp15On = bl2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateStandStill(boolean bl) {
        this.logger.log(1000000, "[AbstractCarStateHandler#updateStandStill] standstill: %1", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.isStandstill = bl;
        }
    }

    public int updateMenuEntryVisibility(short s, int n) {
        int n2 = n;
        if (n == 1) {
            return n2;
        }
        if (this.isActivated(s) && n == 0) {
            n2 = 1;
            return 1;
        }
        if (this.isClamp15Sensitive(s)) {
            this.logger.log(1000000, "[AbstractCarStateHandler#updateMenuEntryVisibility] isClamp15Sensitive %1 [%2]", this.isClamp15On, (Object)ICoding.CODING_INDEX_TEXT[s]);
            if (this.isClamp15On) {
                if (n == 4) {
                    n2 = 2;
                }
                if (this.isVThresholdSensitive(s)) {
                    this.logger.log(1000000, "[AbstractCarStateHandler#updateMenuEntryVisibility] isVThresholdSensitive: %1 [%2]", this.isUnderVThr, (Object)ICoding.CODING_INDEX_TEXT[s]);
                    if (!this.isUnderVThr) {
                        n2 = 5;
                    } else if (n == 5) {
                        n2 = 2;
                    }
                }
                if (this.isStandstillSensitive(s) && !this.isStandstill) {
                    this.logger.log(1000000, "[AbstractCarStateHandler#updateMenuEntryVisibility] isStandstillSensitive: %1 [%2]", this.isStandstill, (Object)ICoding.CODING_INDEX_TEXT[s]);
                    if (!this.isStandstill) {
                        n2 = 6;
                    } else if (n == 6) {
                        n2 = 2;
                    }
                }
            } else {
                n2 = 4;
            }
        }
        this.logger.log(1000000, "[AbstractCarStateHandler#updateMenuEntryVisibility] %3: incoming_Visibility=%1 outgoing_Visibility=%2", (Object)IVisibility.TEXT_TO_STATE[n], (Object)IVisibility.TEXT_TO_STATE[n2], (Object)ICoding.CODING_INDEX_TEXT[s]);
        return n2;
    }

    public boolean isActivated(short s) {
        return this.codingAdapter.isMenuDisplayActivated(s);
    }

    public boolean isClamp15Sensitive(short s) {
        return this.codingAdapter.isMenuDisplayActivated(s) && !this.codingAdapter.isMenuDisClamp15OffActivated(s);
    }

    protected boolean isVThresholdSensitive(short s) {
        return this.codingAdapter.isMenuDisplayActivated(s) && !this.codingAdapter.isMenuDisStandstillActivated(s) && !this.codingAdapter.isMenuDisOverThresholdHighActivated(s);
    }

    protected boolean isStandstillSensitive(short s) {
        return this.codingAdapter.isMenuDisplayActivated(s) && this.codingAdapter.isMenuDisStandstillActivated(s);
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
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

