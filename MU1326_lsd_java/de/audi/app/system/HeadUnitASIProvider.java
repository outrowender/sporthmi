/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.SystemSDISEnv;
import de.audi.atip.agent.IASICall;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.sdis.ISDISHeadUnitService;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.IDSIClient;
import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitService;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public class HeadUnitASIProvider
extends ASIHMISyncHeadUnitAbstractBaseService
implements ISDISHeadUnitService,
IASIProvider,
I18NTarget,
DSICarTimeUnitsLanguageListener,
IDSIClient {
    private final SystemSDISEnv env;
    private final ASIHMISyncHeadUnitService headUnitService;
    private final List stubs;
    private Language currentLanguage = null;
    private org.dsi.ifc.cartimeunitslanguage.ClockDate currentDate = null;
    private ClockTime currentTime = null;
    private long lastTimeUpdate = 0L;

    public HeadUnitASIProvider(SystemSDISEnv systemSDISEnv, int n) {
        this.env = systemSDISEnv;
        this.headUnitService = new ASIHMISyncHeadUnitService(n, this);
        this.stubs = new ArrayList();
        this.initAttributes();
        CarConfiguration carConfiguration = this.createASICarConfiguration(systemSDISEnv.getSysConst(4168), systemSDISEnv.getSysConst(466), systemSDISEnv.getSysConst(469), systemSDISEnv.getSysConst(467), systemSDISEnv.getSysConst(468));
        this.updateCarConfiguration(carConfiguration, 1);
        this.updateRegion(systemSDISEnv.getSysConst(442), 1);
        int[] nArray = new int[]{systemSDISEnv.getSysConst(464)};
        this.updateExtCarConfiguration(nArray, 1);
    }

    private final SystemSDISEnv getEnv() {
        return this.env;
    }

    private final LogChannel getLog() {
        return this.getEnv().getLog();
    }

    private final void initAttributes() {
        try {
            this.updateASIVersion("1.2.00");
            this.updateReplyIDs(new short[]{3, 7, 8, 9, 11, 12, 17, 18, 15, 14, 10, 13, 16, 19, 20});
            this.updateRequestIDs(new short[]{0, 1, 2, 4, 5, 6});
        }
        catch (MethodException methodException) {
            this.getLog().log(1000000, "[HeadUnitASIProvider.iniAttributes] unexpected MethodException", (Throwable)methodException);
        }
    }

    public final IService getService() {
        return this.headUnitService;
    }

    public final void attachStub(IStub iStub) {
        this.getLog().log(1000000, "[HeadUnitASIProvider.attachStub] '%1'", (Object)iStub);
        this.stubs.add(iStub);
        this.updateConnectionCount();
    }

    public final void detachStub(IStub iStub) {
        this.getLog().log(1000000, "[HeadUnitASIProvider.detachStub] '%1'", (Object)iStub);
        this.stubs.remove(iStub);
        this.updateConnectionCount();
    }

    private final synchronized List getStubs() {
        return new ArrayList(this.stubs);
    }

    private final void broadcast(IASICall iASICall) {
        Iterator iterator = this.getStubs().iterator();
        while (iterator.hasNext()) {
            try {
                iASICall.call(((IStub)iterator.next()).getReplyProxyFrontend());
            }
            catch (Exception exception) {
                this.getLog().log(100000, "[HeadUnitASIProvider.broadcast] call '%1'failed!", (Object)iASICall, (Throwable)exception);
            }
        }
    }

    private final void updateConnectionCount() {
        boolean bl = this.getStubs().size() > 0;
        this.getEnv().getChoiceModel(3913).setValue(bl ? 1 : 0);
        this.getEnv().setSdisConnected(bl);
    }

    public void setLanguage(Language language) {
        this.getLog().log(1000000, "[HeadUnitASIProvider.setLanguage] (%1)", (Object)language);
        try {
            this.currentLanguage = language;
            this.updateLanguage1(language.getSDISLanguage());
            this.updateLanguage2(language.getSDISLocale().toString());
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.setLanguage] (%1) failed!", (Object)language, (Throwable)methodException);
        }
    }

    public void resetLanguage() {
        this.getLog().log(1000000, "[HeadUnitASIProvider.resetLanguage] language reset was triggered.");
        if (this.currentLanguage != null) {
            this.broadcast(new IASICall(){

                public void call(IProxyFrontend iProxyFrontend) throws MethodException {
                    ((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend).resetLanguage(HeadUnitASIProvider.this.currentLanguage.getSDISLanguage(), HeadUnitASIProvider.this.currentLanguage.getSDISLocale().toString());
                }
            });
        } else {
            this.getLog().log(100000, "[HeadUnitASIProvider.resetLanguage] language reset failed, language unknown.");
        }
    }

    protected de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime getClockTime() {
        if (this.isTimeInitialized()) {
            this.getLog().log(100000, "[HeadUnitASIProvider.getClockTime] update time to %1", (Object)this.currentTime);
            return this.createASITime(this.currentTime);
        }
        return null;
    }

    protected ClockDate getClockDate() {
        if (this.isTimeInitialized()) {
            this.getLog().log(100000, "[HeadUnitASIProvider.getClockDate] update date to %1", (Object)this.currentDate);
            return this.createASIDate(this.currentDate);
        }
        return null;
    }

    private boolean isTimeInitialized() {
        return this.currentTime != null && this.currentDate != null;
    }

    private de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime createASITime(ClockTime clockTime) {
        return new de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime(clockTime.hours, clockTime.minutes, clockTime.seconds, clockTime.timeZone, clockTime.summerTime);
    }

    private boolean timeChanged(ClockTime clockTime) {
        if (this.currentTime == null) {
            return true;
        }
        if (this.currentTime.timeZone != clockTime.timeZone || this.currentTime.summerTime != clockTime.summerTime) {
            return true;
        }
        long l = (long)(clockTime.hours * 3600 + clockTime.minutes * 60 + clockTime.seconds - (this.currentTime.hours * 3600 + this.currentTime.minutes * 60 + this.currentTime.seconds)) * 1000L;
        long l2 = this.getEnv().getMonotonicTime() - this.lastTimeUpdate;
        long l3 = l - l2;
        return l3 < -999L || l3 > 999L;
    }

    private void updateKombiTime(ClockTime clockTime) {
        if (this.timeChanged(clockTime)) {
            try {
                this.updateClockTime(this.createASITime(clockTime));
                this.getLog().log(100000, "[HeadUnitASIProvider.getClockTime] updated time to %1", (Object)this.currentTime);
            }
            catch (MethodException methodException) {
                this.getLog().log(100000, "[HeadUnitASIProvider.updateKombiTime] updating time failed!", (Throwable)methodException);
            }
        }
        this.currentTime = clockTime;
        this.lastTimeUpdate = this.getEnv().getMonotonicTime();
    }

    private ClockDate createASIDate(org.dsi.ifc.cartimeunitslanguage.ClockDate clockDate) {
        return new ClockDate(clockDate.year, clockDate.month, clockDate.day);
    }

    private CarConfiguration createASICarConfiguration(int n, int n2, int n3, int n4, int n5) {
        return new CarConfiguration(1, (byte)n, (byte)n2, (byte)n3, (byte)n4, (byte)n5);
    }

    private boolean dateChanged(org.dsi.ifc.cartimeunitslanguage.ClockDate clockDate) {
        return this.currentDate == null || clockDate.day != this.currentDate.day || clockDate.month != this.currentDate.month || clockDate.year != this.currentDate.year;
    }

    private void updateKombiDate(org.dsi.ifc.cartimeunitslanguage.ClockDate clockDate) {
        if (this.dateChanged(clockDate)) {
            try {
                this.updateClockDate(this.createASIDate(clockDate));
                this.getLog().log(100000, "[HeadUnitASIProvider.getClockDate] updated date to %1", (Object)this.currentDate);
            }
            catch (MethodException methodException) {
                this.getLog().log(100000, "[HeadUnitASIProvider.updateKombiDate] updating date failed!", (Throwable)methodException);
            }
        }
        this.currentDate = clockDate;
    }

    public void setDSI(DSIBase dSIBase) {
        if (dSIBase == null) {
            this.currentTime = null;
            this.currentDate = null;
        }
    }

    public int[] getAutoNotifications() {
        return new int[]{2, 3, 12, 13, 14, 15, 16};
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
    }

    public void updateMenuLanguage(int n, int n2) {
    }

    public void updateTemperatureUnit(int n, int n2) {
        try {
            this.updateTemperatureUnit(n, n2 == 1);
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.updateTemperatureUnit] updating temperature unit failed!", (Throwable)methodException);
        }
    }

    public void updateDistanceUnit(int n, int n2) {
        try {
            this.updateDistanceUnit(n, n2 == 1);
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.updateDistanceUnit] updating distance unit failed!", (Throwable)methodException);
        }
    }

    public void updateSpeedUnit(int n, int n2) {
        try {
            this.updateSpeedUnit(n, n2 == 1);
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.updateSpeedUnit] updating speed unit failed!", (Throwable)methodException);
        }
    }

    public void updatePressureUnit(int n, int n2) {
        try {
            this.updatePressureUnit(n, n2 == 1);
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.updateDistanceUnit] updating pressure unit failed!", (Throwable)methodException);
        }
    }

    public void updateVolumeUnit(int n, int n2) {
    }

    public void updateConsumptionPetrolUnit(int n, int n2) {
    }

    public void updateConsumptionGasUnit(int n, int n2) {
    }

    public void updateConsumptionElectricUnit(int n, int n2) {
    }

    public void updateClockFormat(int n, int n2) {
    }

    public void updateDateFormat(int n, int n2) {
    }

    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
    }

    public void updateClockDate(org.dsi.ifc.cartimeunitslanguage.ClockDate clockDate, int n) {
        if (1 == n && clockDate != null) {
            this.updateKombiDate(clockDate);
        }
    }

    public void updateClockTime(ClockTime clockTime, int n) {
        if (1 == n && clockTime != null) {
            this.updateKombiTime(clockTime);
        }
    }

    public void updateClockSource(int n, int n2) {
    }

    public void updateClockDayLightSaving(boolean bl, int n) {
    }

    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
    }

    public void updateClockTimeZoneOffset(float f2, int n) {
    }

    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
    }

    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
    }

    public void acknowledgeUmSetFactoryDefault(boolean bl) {
    }

    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
    }

    public void updateSkin(int n, int n2) {
    }

    private void updateCarConfiguration(CarConfiguration carConfiguration, int n) {
        if (1 == n && carConfiguration != null) {
            try {
                this.updateCarConfiguration(carConfiguration);
            }
            catch (MethodException methodException) {
                this.getLog().log(100000, "[HeadUnitASIProvider.updateCarConfiguration] updating car configuration failed!", (Throwable)methodException);
            }
        }
    }

    private void updateRegion(int n, int n2) {
        try {
            this.updateRegion(n, n2 == 1);
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.updateRegion] updating region failed!", (Throwable)methodException);
        }
    }

    private void updateExtCarConfiguration(int[] nArray, int n) {
        try {
            this.updateExtCarConfiguration(nArray, n == 1);
        }
        catch (MethodException methodException) {
            this.getLog().log(100000, "[HeadUnitASIProvider.updateExtCarConfiguration] updating external car configuration failed!", (Throwable)methodException);
        }
    }

    public void updateWeightUnit(int n, int n2) {
    }
}

