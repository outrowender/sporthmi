/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Date;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class Utilities {
    private static final char LINE_BREAK_DELIMITER = '\n';
    private static final char HEADER_DELIMITER = '\u000b';
    private static final char SEPARATOR_DELIMITER = '\u001f';
    public static final char LEFTTORIGHT_DELIMITER = '\u200e';
    public static final char RIGHTTOLEFT_DELIMITER = '\u200f';
    private static final String REPLACE_LINE_BREAK = "\n";
    private static final String REPLACE_HEADER = "\n";
    private static IFrameworkAccess framework;
    private static DateMetric timeMetric;
    private static DateMetric dateMetric;
    private static boolean singlePiMode;
    private static int region;
    private static Coding coding;

    public static void init(IFrameworkAccess iFrameworkAccess, Coding coding) {
        framework = iFrameworkAccess;
        Utilities.coding = coding;
        singlePiMode = coding.isPiActivated();
        region = framework.getSysConst(442);
    }

    public static IFrameworkAccess getFramework() {
        return framework;
    }

    public static IHMIServiceApp getHMIServiceApp() {
        return framework.getHmiServiceApp();
    }

    public static HMIService getHMIService() {
        return framework.getHMIService();
    }

    public static IStorageAccess getStorageManager() {
        return framework.getStorageMgr();
    }

    public static String kHzToMHz(long l) {
        Buffer buffer = new Buffer();
        long l2 = l / 1000L;
        long l3 = l % 1000L / 100L;
        buffer.append(l2);
        buffer.append('.');
        buffer.append(l3);
        return buffer.toString();
    }

    public static String getFormatedStationNumber(short s) {
        Buffer buffer = new Buffer();
        if (s > 99) {
            buffer.append(s);
        } else if (s > 9) {
            buffer.append('0');
            buffer.append(s);
        } else {
            buffer.append("00");
            buffer.append(s);
        }
        return buffer.toString();
    }

    public static String getFormatedDummyCounter(int n) {
        Buffer buffer = new Buffer();
        if (n > 9) {
            buffer.append(n);
        } else {
            buffer.append('0');
            buffer.append(n);
        }
        return buffer.toString();
    }

    public static boolean isSDARSPresent() {
        return framework.getSysConst(477) == 1;
    }

    public static boolean isDABPresent() {
        return framework.getSysConst(476) == 1;
    }

    public static boolean isDABEPGPresent() {
        return Utilities.isDABPresent() && Utilities.isHigh();
    }

    public static boolean isNARBuild() {
        return region == 1;
    }

    public static boolean isNARBandCoded() {
        return Utilities.getFmBandsetting() == 2 && Utilities.getAmBandsetting() == 2;
    }

    public static boolean isGraceNoteLocal() {
        return framework.getSysConst(4108) == 1;
    }

    public static boolean isGraceNoteOnline() {
        return framework.getSysConst(4042) == 1;
    }

    public static boolean isShowFreqUnit() {
        return !Utilities.isNARBuild();
    }

    public static boolean isPGen1OrBentley() {
        return framework.isPorsche() || framework.isBentley();
    }

    public static boolean isBentley() {
        return framework.isBentley();
    }

    public static boolean isJapan() {
        return (Utilities.getFmBandsetting() == 8 || Utilities.getFmBandsetting() == 3) && Utilities.getAmBandsetting() == 3;
    }

    public static boolean isPCSim() {
        return framework.isSimulator();
    }

    public static boolean isHigh() {
        return framework.isEvoHigh() || framework.isPorscheHigh() || framework.isBentley();
    }

    public static boolean isStd() {
        return framework.isEvoStd() || framework.isPorscheStd();
    }

    public static boolean isEvoHigh() {
        return framework.isEvoHigh();
    }

    public static boolean isEvoHighMMIKombi() {
        return framework.isEvoHighMMIKombi();
    }

    public static int getBandIdByWaveband(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: {
                return 4;
            }
            case 1: {
                return 1;
            }
        }
        return 8;
    }

    public static int getWavebandByBand(int n) {
        int n2;
        switch (n) {
            case 4: 
            case 10: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    public static AMFMStation[] getTIStations() {
        return new AMFMStation[]{new AMFMStation("", 1620L, -1, 0, 3, false, false), new AMFMStation("", 1629L, -1, 0, 3, false, false)};
    }

    public static boolean isEmpty(String string) {
        if (string == null) {
            return true;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static int getRadioTextDisplayTime() {
        return Integer.getInteger("RadioTextDisplayTime", framework.getSysApp().getSpeedThresholdUPDL().getRadioTextDisplayTime());
    }

    public static int getSlideshowDisplayDuration1() {
        return Integer.getInteger("SlideshowDisplayDuration1", framework.getSysApp().getSpeedThresholdUPDL().getSlideshowDisplayDuration1());
    }

    public static int getSlideshowDisplayDuration2() {
        return Integer.getInteger("SlideshowDisplayDuration2", framework.getSysApp().getSpeedThresholdUPDL().getSlideshowDisplayDuration2());
    }

    public static byte getAmBandsetting() {
        return coding.getAmBandsetting();
    }

    public static byte getFmBandsetting() {
        return coding.getFmBandsetting();
    }

    public static byte getDAB1Bandsetting() {
        return coding.getDab1Bandsetting();
    }

    public static byte getDAB2Bandsetting() {
        return coding.getDab2Bandsetting();
    }

    public static boolean isDABBand3AndLBandCoded() {
        byte by = coding.getDab1Bandsetting();
        byte by2 = coding.getDab2Bandsetting();
        return (by == 2 || by == 1) && by2 == 1;
    }

    public static final boolean isAfAutoResetActivated() {
        return coding.getAfMode() == 1 && Utilities.isSinglePiMode();
    }

    public static final boolean isFmPty31AlarmOn() {
        return coding.isFmPty31AlarmOn();
    }

    public static final boolean isDabAlarmAnnouncementActivated() {
        return coding.isDabAlarmAnnouncementActivated();
    }

    public static final byte getBwsProfile() {
        return coding.getBwsProfile();
    }

    public static final boolean isRadioTextPlusActivated() {
        return coding.isRadioTextPlusActivated();
    }

    public static final boolean isHdDefaultOn() {
        return coding.isHdActivated();
    }

    public static String getFormatedTime(long l) {
        timeMetric.setDate(l);
        return timeMetric.format();
    }

    public static String getFormatedDate(long l) {
        dateMetric.setDate(l);
        return dateMetric.format();
    }

    public static boolean isSinglePiMode() {
        return singlePiMode;
    }

    public static boolean isPiIgnore() {
        return !singlePiMode;
    }

    public static boolean isTASupported() {
        return singlePiMode;
    }

    public static boolean isTaggingSupported() {
        return framework.getSysConst(5572) == 1;
    }

    public static int getDABPty(byte[] byArray) {
        if (byArray == null || byArray.length == 0) {
            return 0;
        }
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (byArray[i2] == 0) continue;
            return byArray[i2];
        }
        return 0;
    }

    public static String replaceDelimiter(String string, char c2, String string2) {
        char[] cArray = string.toCharArray();
        Buffer buffer = new Buffer();
        int n = 0;
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (cArray[i2] != c2) continue;
            buffer.append(new String(cArray, n, i2 - n));
            buffer.append(string2);
            n = i2 + 1;
        }
        buffer.append(new String(cArray, n, cArray.length - n));
        return buffer.toString();
    }

    public static String getShortName(String string) {
        if (string != null) {
            return string.substring(0, Math.min(8, string.length()));
        }
        return "";
    }

    public static String[] getFontNames() {
        ArrayList arrayList = new ArrayList();
        String string = System.getProperty("STANDARD_FONT_PLAIN");
        if (string != null) {
            arrayList.add(string);
        }
        if ((string = System.getProperty("STANDARD_FONT_BASE")) != null) {
            arrayList.add(string);
        }
        if ((string = System.getProperty("STANDARD_FONT_ARABIC")) != null) {
            arrayList.add(string);
        }
        if ((string = System.getProperty("STANDARD_FONT_PLAIN2")) != null) {
            arrayList.add(string);
        }
        if ((string = System.getProperty("STANDARD_FONT_PLAIN3")) != null) {
            arrayList.add(string);
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean isEURDW() {
        throw new UnsupportedOperationException("Call #isEURDW() not supported any more!");
    }

    public static EnsembleInfo copy(EnsembleInfo ensembleInfo) {
        return new EnsembleInfo(ensembleInfo.ensID, ensembleInfo.ensECC, ensembleInfo.shortName, ensembleInfo.fullName, ensembleInfo.frequencyLabel, ensembleInfo.frequencyValue, ensembleInfo.tp, ensembleInfo.potentiallyReceivable);
    }

    public static ComponentInfo copy(ComponentInfo componentInfo) {
        return new ComponentInfo(componentInfo.ensID, componentInfo.ensECC, componentInfo.sID, componentInfo.sCIDI, componentInfo.shortName, componentInfo.fullName, componentInfo.primaryService, componentInfo.radiotext);
    }

    public static ServiceInfo copy(ServiceInfo serviceInfo) {
        return new ServiceInfo(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID, serviceInfo.shortName, serviceInfo.fullName, Utilities.copy(serviceInfo.ptyCodes), serviceInfo.tp, serviceInfo.radiotext);
    }

    private static byte[] copy(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        byte[] byArray2 = new byte[byArray.length];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, byArray.length);
        return byArray2;
    }

    public static String radioTextReplace(String string) {
        String string2 = Utilities.replaceDelimiter(string, '\u000b', "\n");
        string2 = Utilities.replaceDelimiter(string2, '\n', "\n");
        string2 = Utilities.replaceDelimiter(string2, '\u001f', "");
        return string2;
    }

    public static int indexOf(int n, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    public static int[] combineArrays(int[] nArray, int[] nArray2) {
        int[] nArray3 = new int[nArray.length + nArray2.length];
        System.arraycopy((Object)nArray, 0, (Object)nArray3, 0, nArray.length);
        System.arraycopy((Object)nArray2, 0, (Object)nArray3, nArray.length, nArray2.length);
        return nArray3;
    }

    public static int convertPi(int n) {
        int n2 = (n & 0xF000) >> 12;
        if (n2 == 1) {
            n2 = 13;
        } else if (n2 <= 13) {
            --n2;
        }
        int n3 = n2 << 12;
        n3 |= (n & 0xFF) << 4;
        return n3 |= (n & 0xF00) >> 8;
    }

    public static int getDashCode(String string, String string2) {
        int n = 0;
        if (string.length() > 0) {
            ++n;
        }
        if (string2.length() > 0) {
            ++n;
        }
        return n;
    }

    public static RadioHMIResourceLocator getPreferredImage(int n, RadioHMIResourceLocator radioHMIResourceLocator, RadioHMIResourceLocator radioHMIResourceLocator2, RadioHMIResourceLocator radioHMIResourceLocator3) {
        RadioHMIResourceLocator radioHMIResourceLocator4 = ISimpleTuner.EMPTY_RADIO_RL;
        switch (n) {
            case 0: {
                if (radioHMIResourceLocator3 == null || !radioHMIResourceLocator3.containsResourceURI()) break;
                radioHMIResourceLocator4 = radioHMIResourceLocator3;
                break;
            }
            case 1: {
                if (radioHMIResourceLocator2 != null && radioHMIResourceLocator2.containsResourceURI()) {
                    radioHMIResourceLocator4 = radioHMIResourceLocator2;
                    break;
                }
                if (radioHMIResourceLocator3 == null || !radioHMIResourceLocator3.containsResourceURI()) break;
                radioHMIResourceLocator4 = radioHMIResourceLocator3;
                break;
            }
            case 2: {
                if (radioHMIResourceLocator != null && radioHMIResourceLocator.containsResourceURI()) {
                    radioHMIResourceLocator4 = radioHMIResourceLocator;
                    break;
                }
                if (Utilities.isBentley() && radioHMIResourceLocator2 != null && radioHMIResourceLocator2.containsResourceURI()) {
                    radioHMIResourceLocator4 = radioHMIResourceLocator2;
                    break;
                }
                if (radioHMIResourceLocator3 == null || !radioHMIResourceLocator3.containsResourceURI()) break;
                radioHMIResourceLocator4 = radioHMIResourceLocator3;
                break;
            }
            default: {
                radioHMIResourceLocator4 = ISimpleTuner.EMPTY_RADIO_RL;
            }
        }
        return radioHMIResourceLocator4;
    }

    public static HMIResourceLocator getPreferredImage(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        if (resourceLocator != null && !Utilities.isEmpty(resourceLocator.url) && n != 0) {
            return new HMIResourceLocator(resourceLocator.id, resourceLocator.url);
        }
        if (resourceLocator2 != null && !Utilities.isEmpty(resourceLocator2.url)) {
            return new HMIResourceLocator(resourceLocator2.id, resourceLocator2.url);
        }
        return ISimpleTuner.EMPTY_RL;
    }

    public static int countBits(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < 32; ++i2) {
            if ((n & 1 << i2) == 0) continue;
            ++n2;
        }
        return n2;
    }

    public static AMFMStation getNextSubChannel(AMFMStation aMFMStation) {
        AMFMStation aMFMStation2 = new AMFMStation(aMFMStation);
        int n = aMFMStation2.serviceId;
        for (int i2 = 0; i2 < 8; ++i2) {
            int n2 = n = (n <<= 1) > 128 ? 1 : n;
            if ((n & aMFMStation2.getHdStructure()) <= 0) continue;
            aMFMStation2.serviceId = n;
            break;
        }
        return aMFMStation2;
    }

    public static int getConnectionByBand(int n, int n2) {
        switch (n) {
            case 4: {
                return n2 == 0 ? 13 : 301;
            }
            case 1: {
                return n2 == 0 ? 12 : 300;
            }
            case 5: 
            case 11: {
                return n2 == 0 ? 26 : 302;
            }
            case 7: {
                return n2 == 0 ? 28 : 304;
            }
            case 10: {
                return n2 == 0 ? 15 : 303;
            }
        }
        throw new IllegalArgumentException("Wrong band " + n);
    }

    public static HMIResourceLocator getFirstNotEmpty(HMIResourceLocator hMIResourceLocator, HMIResourceLocator hMIResourceLocator2) {
        if (hMIResourceLocator.containsResourceURI()) {
            return hMIResourceLocator;
        }
        return hMIResourceLocator2;
    }

    public static int getImgConfig() {
        int n = 0;
        if (Utilities.isDABPresent()) {
            n = Utilities.isEvoHigh() ? 5 : 4;
        }
        if (Utilities.isSDARSPresent()) {
            n |= 1;
        }
        if (Utilities.isNARBuild()) {
            n |= 1;
            n |= 2;
        }
        return n;
    }

    public static int adjustPresetPosForNar(int n) {
        if (Utilities.isNARBuild() && n >= 1 && n <= 8) {
            return n + 50;
        }
        return n;
    }

    public static String getFirstNotEmpty(String string, String string2) {
        if (!Utilities.isEmpty(string)) {
            return string;
        }
        if (!Utilities.isEmpty(string2)) {
            return string2;
        }
        return "";
    }

    public static int getCcByPi(int n) {
        if (n != -1) {
            n &= 0xF000;
            n >>= 12;
        }
        return n;
    }

    public static String toString(Object[] objectArray) {
        if (objectArray == null) {
            return "null";
        }
        if (objectArray.length == 0) {
            return "[]";
        }
        int n = objectArray.length - 1;
        Buffer buffer = new Buffer(objectArray.length * 16);
        buffer.append('[');
        int n2 = 0;
        while (true) {
            buffer.append('\"');
            buffer.append(String.valueOf(objectArray[n2]));
            if (n2 == n) break;
            buffer.append("\", ");
            ++n2;
        }
        buffer.append("\"]");
        return buffer.toString();
    }

    public static String toString(int[] nArray) {
        if (nArray == null) {
            return "null";
        }
        if (nArray.length == 0) {
            return "[]";
        }
        int n = nArray.length - 1;
        Buffer buffer = new Buffer(nArray.length * 6);
        buffer.append('[');
        int n2 = 0;
        while (true) {
            buffer.append(nArray[n2]);
            if (n2 == n) break;
            buffer.append(", ");
            ++n2;
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static String toString(RadioStationDataResponse radioStationDataResponse) {
        Buffer buffer = new Buffer(100);
        buffer.append("StDataResp(");
        if (radioStationDataResponse != null) {
            buffer.append("#").append(radioStationDataResponse.totalItemCount).append('[');
            for (int i2 = 0; i2 < radioStationDataResponse.radioStationData.length; ++i2) {
                RadioStationData radioStationData = radioStationDataResponse.radioStationData[i2];
                buffer.append(Utilities.toSting(radioStationData));
                if (i2 + 1 >= radioStationDataResponse.radioStationData.length) continue;
                buffer.append('|');
            }
            buffer.append(']');
        } else {
            buffer.append("<null>");
        }
        buffer.append(')');
        return buffer.toString();
    }

    public static String toString(RadioStationLogoResponse radioStationLogoResponse) {
        Buffer buffer = new Buffer(100);
        buffer.append("LogoResp(");
        if (radioStationLogoResponse != null) {
            Object object;
            int n;
            buffer.append("#").append(radioStationLogoResponse.totalItemCount).append('[');
            for (n = 0; n < radioStationLogoResponse.resourceLocators.length; ++n) {
                object = radioStationLogoResponse.resourceLocators[n];
                if (object != null) {
                    buffer.append("path=").append(((ResourceLocator)object).url).append(',');
                    buffer.append("id=").append(((ResourceLocator)object).id).append('|');
                } else {
                    buffer.append("null|");
                }
                if (n + 1 >= radioStationLogoResponse.resourceLocators.length) continue;
                buffer.append('|');
            }
            buffer.append(']');
            for (n = 0; n < radioStationLogoResponse.radioStationData.length; ++n) {
                object = radioStationLogoResponse.radioStationData[n];
                buffer.append(Utilities.toSting((RadioStationData)object));
                if (n + 1 >= radioStationLogoResponse.radioStationData.length) continue;
                buffer.append('|');
            }
            buffer.append(']');
        } else {
            buffer.append("<null>");
        }
        buffer.append(')');
        return buffer.toString();
    }

    private static String toSting(RadioStationData radioStationData) {
        Buffer buffer = new Buffer(100);
        buffer.append("RadioStData(");
        if (radioStationData != null) {
            buffer.append("id=").append(radioStationData.stationId).append(',');
            buffer.append("country=").append(radioStationData.country).append(',');
            buffer.append("ecc=").append(radioStationData.extendedCountryCode).append(',');
            buffer.append("piSid=").append(radioStationData.piSid).append(',');
            buffer.append("ensId=").append(radioStationData.ensembleId).append(',');
            buffer.append("scidi=").append(radioStationData.scidi).append(',');
            buffer.append("lName=").append(radioStationData.longName).append(',');
            buffer.append("sName=").append(radioStationData.shortName).append(',');
            buffer.append("f=").append(radioStationData.frequency).append(',');
            buffer.append("type=").append(radioStationData.stationType).append(',');
            buffer.append("logo=").append(radioStationData.logoId);
        } else {
            buffer.append("<null>");
        }
        buffer.append(')');
        return buffer.toString();
    }

    public static Object toString(RadioStationLogoRequest radioStationLogoRequest) {
        Buffer buffer = new Buffer(100);
        buffer.append("LogoRequest(");
        if (radioStationLogoRequest != null) {
            buffer.append(Utilities.toString(radioStationLogoRequest.radioStationDataRequest));
            buffer.append("prios:").append(Utilities.toString(radioStationLogoRequest.priorities));
        } else {
            buffer.append("<null>");
        }
        buffer.append(')');
        return buffer.toString();
    }

    public static Object toString(RadioStationDataRequest radioStationDataRequest) {
        Buffer buffer = new Buffer(100);
        buffer.append("DataRequest(");
        if (radioStationDataRequest != null) {
            buffer.append("max#=").append(radioStationDataRequest.maxItemCount).append(',');
            if (radioStationDataRequest.useStationId) {
                buffer.append("stId=").append(radioStationDataRequest.stationId).append(',');
            }
            if (radioStationDataRequest.useCountry) {
                buffer.append("country=").append(radioStationDataRequest.country).append(',');
            }
            if (radioStationDataRequest.useExtendedCountryCode) {
                buffer.append("ecc=").append(radioStationDataRequest.extendedCountryCode).append(',');
            }
            if (radioStationDataRequest.usePiSid) {
                buffer.append("piSid=").append(radioStationDataRequest.piSid).append(',');
            }
            if (radioStationDataRequest.useEnsembleId) {
                buffer.append("ensId=").append(radioStationDataRequest.ensembleId).append(',');
            }
            if (radioStationDataRequest.useScidi) {
                buffer.append("scidi=").append(radioStationDataRequest.scidi).append(',');
            }
            buffer.append("sName=").append(radioStationDataRequest.shortName).append(',');
            if (radioStationDataRequest.useFrequency) {
                buffer.append("f=").append(radioStationDataRequest.frequency).append(',');
            }
            buffer.append("type=").append(radioStationDataRequest.stationType).append(',');
            if (radioStationDataRequest.useLogoId) {
                buffer.append("logoId0").append(radioStationDataRequest.logoId);
            }
        } else {
            buffer.append("<null>");
        }
        buffer.append(')');
        return buffer.toString();
    }

    public static int getDatabaseRegion() {
        int n = framework.getSysConst(4577);
        n = n == 69 ? 1 : n;
        return n;
    }

    public static boolean checkIfAtLeastOneBooleanIsTrue(boolean[] blArray) {
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            if (!blArray[i2]) continue;
            return true;
        }
        return false;
    }

    public static boolean isArabicLanguage(TunerModels tunerModels) {
        return tunerModels.getChoiceModel(100705).getValue() == 1;
    }

    static {
        timeMetric = new DateMetric(new Date(42L), 1);
        dateMetric = new DateMetric(new Date(42L), 0);
        singlePiMode = true;
    }
}

