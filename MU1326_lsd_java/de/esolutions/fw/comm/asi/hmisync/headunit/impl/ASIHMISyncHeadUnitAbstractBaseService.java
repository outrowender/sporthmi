/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;
import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitS;
import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.InvalidAttributeException;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncHeadUnitAbstractBaseService
implements ASIHMISyncHeadUnitS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.headunit.ASIHMISyncHeadUnit");
    private static final int attributesCount = 15;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int Language1;
    private boolean Language1_valid = false;
    private String Language2;
    private boolean Language2_valid = false;
    private int TemperatureUnit;
    private boolean TemperatureUnit_valid = false;
    private int SpeedUnit;
    private boolean SpeedUnit_valid = false;
    private int DistanceUnit;
    private boolean DistanceUnit_valid = false;
    private int PressureUnit;
    private boolean PressureUnit_valid = false;
    private CarConfiguration CarConfiguration;
    private boolean CarConfiguration_valid = false;
    private int Region;
    private boolean Region_valid = false;
    private int[] ExtCarConfiguration;
    private boolean ExtCarConfiguration_valid = false;
    private short SplashScreenCoding;
    private boolean SplashScreenCoding_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static ClockTime copyClockTime(ClockTime clockTime) {
        if (clockTime == null) {
            return null;
        }
        ClockTime clockTime2 = new ClockTime();
        clockTime2.hours = clockTime.hours;
        clockTime2.minutes = clockTime.minutes;
        clockTime2.seconds = clockTime.seconds;
        clockTime2.timeZone = clockTime.timeZone;
        clockTime2.summerTime = clockTime.summerTime;
        return clockTime2;
    }

    public static ClockDate copyClockDate(ClockDate clockDate) {
        if (clockDate == null) {
            return null;
        }
        ClockDate clockDate2 = new ClockDate();
        clockDate2.year = clockDate.year;
        clockDate2.month = clockDate.month;
        clockDate2.day = clockDate.day;
        return clockDate2;
    }

    public static CarConfiguration copyCarConfiguration(CarConfiguration carConfiguration) {
        if (carConfiguration == null) {
            return null;
        }
        CarConfiguration carConfiguration2 = new CarConfiguration();
        carConfiguration2.version = carConfiguration.version;
        carConfiguration2.carBrand = carConfiguration.carBrand;
        carConfiguration2.carClass = carConfiguration.carClass;
        carConfiguration2.carGeneration = carConfiguration.carGeneration;
        carConfiguration2.carDerivate = carConfiguration.carDerivate;
        carConfiguration2.carDerivateSupplement = carConfiguration.carDerivateSupplement;
        return carConfiguration2;
    }

    public ASIHMISyncHeadUnitAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncHeadUnit", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncHeadUnitReply);
        this.sendAttributeUpdate(l, aSIHMISyncHeadUnitReply);
    }

    public synchronized void setNotification(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.baseService.setNotification(aSIHMISyncHeadUnitReply);
        this.sendAttributeUpdate(aSIHMISyncHeadUnitReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncHeadUnitReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncHeadUnitReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncHeadUnitReply);
    }

    public synchronized void clearNotification(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.baseService.clearNotification(aSIHMISyncHeadUnitReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncHeadUnitReply);
    }

    private void sendAttributeUpdate(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        try {
            Object object;
            aSIHMISyncHeadUnitReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncHeadUnitReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncHeadUnitReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            try {
                object = this.getClockTime();
                aSIHMISyncHeadUnitReply.updateClockTime((ClockTime)object, true);
            }
            catch (InvalidAttributeException invalidAttributeException) {
                aSIHMISyncHeadUnitReply.updateClockTime(null, false);
            }
            try {
                object = this.getClockDate();
                aSIHMISyncHeadUnitReply.updateClockDate((ClockDate)object, true);
            }
            catch (InvalidAttributeException invalidAttributeException) {
                aSIHMISyncHeadUnitReply.updateClockDate(null, false);
            }
            aSIHMISyncHeadUnitReply.updateLanguage1(this.Language1, this.Language1_valid);
            aSIHMISyncHeadUnitReply.updateLanguage2(this.Language2, this.Language2_valid);
            aSIHMISyncHeadUnitReply.updateTemperatureUnit(this.TemperatureUnit, this.TemperatureUnit_valid);
            aSIHMISyncHeadUnitReply.updateSpeedUnit(this.SpeedUnit, this.SpeedUnit_valid);
            aSIHMISyncHeadUnitReply.updateDistanceUnit(this.DistanceUnit, this.DistanceUnit_valid);
            aSIHMISyncHeadUnitReply.updatePressureUnit(this.PressureUnit, this.PressureUnit_valid);
            aSIHMISyncHeadUnitReply.updateCarConfiguration(this.CarConfiguration, this.CarConfiguration_valid);
            aSIHMISyncHeadUnitReply.updateRegion(this.Region, this.Region_valid);
            aSIHMISyncHeadUnitReply.updateExtCarConfiguration(this.ExtCarConfiguration, this.ExtCarConfiguration_valid);
            aSIHMISyncHeadUnitReply.updateSplashScreenCoding(this.SplashScreenCoding, this.SplashScreenCoding_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncHeadUnitReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
        try {
            if (l == 7L) {
                aSIHMISyncHeadUnitReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 18L) {
                aSIHMISyncHeadUnitReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 17L) {
                aSIHMISyncHeadUnitReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 9L) {
                try {
                    ClockTime clockTime = this.getClockTime();
                    aSIHMISyncHeadUnitReply.updateClockTime(clockTime, true);
                }
                catch (InvalidAttributeException invalidAttributeException) {
                    aSIHMISyncHeadUnitReply.updateClockTime(null, false);
                }
            } else if (l == 8L) {
                try {
                    ClockDate clockDate = this.getClockDate();
                    aSIHMISyncHeadUnitReply.updateClockDate(clockDate, true);
                }
                catch (InvalidAttributeException invalidAttributeException) {
                    aSIHMISyncHeadUnitReply.updateClockDate(null, false);
                }
            } else if (l == 11L) {
                aSIHMISyncHeadUnitReply.updateLanguage1(this.Language1, this.Language1_valid);
            } else if (l == 12L) {
                aSIHMISyncHeadUnitReply.updateLanguage2(this.Language2, this.Language2_valid);
            } else if (l == 15L) {
                aSIHMISyncHeadUnitReply.updateTemperatureUnit(this.TemperatureUnit, this.TemperatureUnit_valid);
            } else if (l == 14L) {
                aSIHMISyncHeadUnitReply.updateSpeedUnit(this.SpeedUnit, this.SpeedUnit_valid);
            } else if (l == 10L) {
                aSIHMISyncHeadUnitReply.updateDistanceUnit(this.DistanceUnit, this.DistanceUnit_valid);
            } else if (l == 13L) {
                aSIHMISyncHeadUnitReply.updatePressureUnit(this.PressureUnit, this.PressureUnit_valid);
            } else if (l == 16L) {
                aSIHMISyncHeadUnitReply.updateCarConfiguration(this.CarConfiguration, this.CarConfiguration_valid);
            } else if (l == 19L) {
                aSIHMISyncHeadUnitReply.updateRegion(this.Region, this.Region_valid);
            } else if (l == 20L) {
                aSIHMISyncHeadUnitReply.updateExtCarConfiguration(this.ExtCarConfiguration, this.ExtCarConfiguration_valid);
            } else if (l == 21L) {
                aSIHMISyncHeadUnitReply.updateSplashScreenCoding(this.SplashScreenCoding, this.SplashScreenCoding_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) throws MethodException {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) throws MethodException {
        this.ASIVersion = ASIHMISyncHeadUnitAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) throws MethodException {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) throws MethodException {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateClockTime(ClockTime clockTime) throws MethodException {
        this.updateClockTime(clockTime, true);
    }

    public void updateClockTime(ClockTime clockTime, boolean bl) throws MethodException {
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateClockTime(clockTime, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateClockDate(ClockDate clockDate) throws MethodException {
        this.updateClockDate(clockDate, true);
    }

    public void updateClockDate(ClockDate clockDate, boolean bl) throws MethodException {
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateClockDate(clockDate, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateLanguage1(int n) throws MethodException {
        this.updateLanguage1(n, true);
    }

    public void updateLanguage1(int n, boolean bl) throws MethodException {
        this.Language1 = n;
        this.Language1_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateLanguage1(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateLanguage2(String string) throws MethodException {
        this.updateLanguage2(string, true);
    }

    public void updateLanguage2(String string, boolean bl) throws MethodException {
        this.Language2 = ASIHMISyncHeadUnitAbstractBaseService.copyString(string);
        this.Language2_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateLanguage2(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateTemperatureUnit(int n) throws MethodException {
        this.updateTemperatureUnit(n, true);
    }

    public void updateTemperatureUnit(int n, boolean bl) throws MethodException {
        this.TemperatureUnit = n;
        this.TemperatureUnit_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateTemperatureUnit(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSpeedUnit(int n) throws MethodException {
        this.updateSpeedUnit(n, true);
    }

    public void updateSpeedUnit(int n, boolean bl) throws MethodException {
        this.SpeedUnit = n;
        this.SpeedUnit_valid = bl;
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateSpeedUnit(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDistanceUnit(int n) throws MethodException {
        this.updateDistanceUnit(n, true);
    }

    public void updateDistanceUnit(int n, boolean bl) throws MethodException {
        this.DistanceUnit = n;
        this.DistanceUnit_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateDistanceUnit(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePressureUnit(int n) throws MethodException {
        this.updatePressureUnit(n, true);
    }

    public void updatePressureUnit(int n, boolean bl) throws MethodException {
        this.PressureUnit = n;
        this.PressureUnit_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updatePressureUnit(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateCarConfiguration(CarConfiguration carConfiguration) throws MethodException {
        this.updateCarConfiguration(carConfiguration, true);
    }

    public void updateCarConfiguration(CarConfiguration carConfiguration, boolean bl) throws MethodException {
        this.CarConfiguration = ASIHMISyncHeadUnitAbstractBaseService.copyCarConfiguration(carConfiguration);
        this.CarConfiguration_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateCarConfiguration(carConfiguration, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRegion(int n) throws MethodException {
        this.updateRegion(n, true);
    }

    public void updateRegion(int n, boolean bl) throws MethodException {
        this.Region = n;
        this.Region_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateRegion(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateExtCarConfiguration(int[] nArray) throws MethodException {
        this.updateExtCarConfiguration(nArray, true);
    }

    public void updateExtCarConfiguration(int[] nArray, boolean bl) throws MethodException {
        if (nArray != null) {
            this.ExtCarConfiguration = new int[nArray.length];
            System.arraycopy((Object)nArray, 0, (Object)this.ExtCarConfiguration, 0, nArray.length);
        } else {
            this.ExtCarConfiguration = null;
        }
        this.ExtCarConfiguration_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateExtCarConfiguration(nArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSplashScreenCoding(short s) throws MethodException {
        this.updateSplashScreenCoding(s, true);
    }

    public void updateSplashScreenCoding(short s, boolean bl) throws MethodException {
        this.SplashScreenCoding = s;
        this.SplashScreenCoding_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply = (ASIHMISyncHeadUnitReply)iterator.next();
            try {
                aSIHMISyncHeadUnitReply.updateSplashScreenCoding(s, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    protected abstract ClockTime getClockTime() throws InvalidAttributeException;

    protected abstract ClockDate getClockDate() throws InvalidAttributeException;

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(7L), new Integer(0));
            this.map.put(new Long(18L), new Integer(1));
            this.map.put(new Long(17L), new Integer(2));
            this.map.put(new Long(9L), new Integer(3));
            this.map.put(new Long(8L), new Integer(4));
            this.map.put(new Long(11L), new Integer(5));
            this.map.put(new Long(12L), new Integer(6));
            this.map.put(new Long(15L), new Integer(7));
            this.map.put(new Long(14L), new Integer(8));
            this.map.put(new Long(10L), new Integer(9));
            this.map.put(new Long(13L), new Integer(10));
            this.map.put(new Long(16L), new Integer(11));
            this.map.put(new Long(19L), new Integer(12));
            this.map.put(new Long(20L), new Integer(13));
            this.map.put(new Long(21L), new Integer(14));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 15;
        }
    }
}

