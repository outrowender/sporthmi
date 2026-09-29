/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.online.IOperatorCallSDSServiceListener;
import de.audi.tghu.online.app.operatorcall.data.PhoneResult;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;

public class TestHandler {
    public static IOperatorCallSDSService sdsService;
    public static IOperatorCallSDSServiceListener sdsListener;
    private static int poiCount;
    private static int sdsPoiCount;
    public static boolean initialized;
    private static int POI_RETURN_NORMAL;
    private static int POI_RETURN_LIST;
    private static int poiReturnType;
    public static int maxCalls;
    public static String[] poiNames;
    private static int poiIndex;

    public static boolean isTelSimulation() {
        return false;
    }

    public static boolean isNavSimulation() {
        return false;
    }

    public static boolean isDsiSimulation() {
        return false;
    }

    public static boolean isPcSimulation() {
        return false;
    }

    public static boolean isSDSSimulation() {
        return false;
    }

    public static boolean isPersistenceSimulation() {
        return false;
    }

    public static int getFirstReqTelResult() {
        return 0;
    }

    public static int getSecReqTelResult() {
        return 1;
    }

    public static int getPOIResult() {
        return 1;
    }

    public static PhoneResult getPhoneResults() {
        PhoneResult phoneResult = new PhoneResult("12345", new String[]{"+4984583332155"}, 0);
        return phoneResult;
    }

    public static boolean usePhoneTimeout() {
        return false;
    }

    public static boolean usePoiTimeout() {
        return false;
    }

    public static int getTimer() {
        return -527236096;
    }

    public static int getTimerMod() {
        return 10;
    }

    public static boolean getTransmition() {
        return true;
    }

    public static void setSDSHandler(IOperatorCallSDSService iOperatorCallSDSService, IOperatorCallSDSServiceListener iOperatorCallSDSServiceListener) {
        sdsService = iOperatorCallSDSService;
        sdsListener = iOperatorCallSDSServiceListener;
    }

    private static int getIntGeocoordinate(double d2) {
        return (int)Math.round(d2 * 1.1930464E7);
    }

    public static OperatorCallResult testGetPoiOfIndexForSDS() {
        if (sdsPoiCount == 1) {
            ++sdsPoiCount;
            return new OperatorCallResult("12345", 0, "Beijing Dongdan 3rd Alley Address", new OperatorCallAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
        }
        --sdsPoiCount;
        return new OperatorCallResult("12345", 0, "Beijing Nanheyan Address", new OperatorCallAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
    }

    public static int testGetNumberOfPoisOfHistoryCallForSDS() {
        return sdsPoiCount;
    }

    public static OperatorCallAddressEntry getAddressEntry() {
        OperatorCallAddressEntry operatorCallAddressEntry = new OperatorCallAddressEntry();
        operatorCallAddressEntry.street = "Am Wolfsmantel 46";
        operatorCallAddressEntry.city = "Erlangen";
        operatorCallAddressEntry.country = "Germany";
        operatorCallAddressEntry.phoneNumber = "+4984583332155";
        operatorCallAddressEntry.region = "Erlangen";
        operatorCallAddressEntry.url = "http://www.google.de";
        operatorCallAddressEntry.zip = "91058";
        return operatorCallAddressEntry;
    }

    public static OperatorCallResult[] getPOIsFromPersistence(int n) {
        OperatorCallResult[] operatorCallResultArray;
        if (poiCount == 2) {
            poiCount = 0;
            operatorCallResultArray = new OperatorCallResult[2];
            switch (n) {
                case 1: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 1, "Bank of Tokyo-Mitsubishi", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691803), TestHandler.getIntGeocoordinate(35.687884)));
                    operatorCallResultArray[1] = new OperatorCallResult("12345", 1, "Tokyo Hilton Hotel", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691151), TestHandler.getIntGeocoordinate(35.692018)));
                    break;
                }
                case 2: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 2, "Beijing Nanheyan Address", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
                    operatorCallResultArray[1] = new OperatorCallResult("12345", 2, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                    break;
                }
                default: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 0, "Beijing Nanheyan Address", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
                    operatorCallResultArray[1] = new OperatorCallResult("12345", 0, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                    break;
                }
            }
        } else {
            ++poiCount;
            operatorCallResultArray = new OperatorCallResult[1];
            switch (n) {
                case 1: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 1, "Tokyo Hilton Hotel", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691151), TestHandler.getIntGeocoordinate(35.692018)));
                    break;
                }
                case 2: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 2, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                    break;
                }
                default: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 0, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                }
            }
        }
        return operatorCallResultArray;
    }

    protected static void initializePoiNames() {
        if (!initialized) {
            initialized = true;
            poiNames = new String[maxCalls];
            for (int i2 = 1; i2 <= maxCalls; ++i2) {
                String string = i2 < 10 ? "Test0" : "Test";
                TestHandler.poiNames[i2 - 1] = string = new StringBuffer().append(string).append(i2).toString();
            }
        }
    }

    public static OperatorCallResult[] getPOI(int n) {
        if (poiReturnType == POI_RETURN_NORMAL) {
            return TestHandler.getPOINormal(n);
        }
        return TestHandler.getPOIList(n);
    }

    public static OperatorCallResult[] getPOINormal(int n) {
        OperatorCallResult[] operatorCallResultArray;
        if (poiCount == 0) {
            ++poiCount;
            return null;
        }
        if (poiCount == 2) {
            poiCount = 0;
            operatorCallResultArray = new OperatorCallResult[2];
            switch (n) {
                case 1: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 1, "Bank of Tokyo-Mitsubishi", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691803), TestHandler.getIntGeocoordinate(35.687884)));
                    operatorCallResultArray[1] = new OperatorCallResult("12345", 1, "Tokyo Hilton Hotel", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(137.916596), TestHandler.getIntGeocoordinate(36.197657)));
                    break;
                }
                case 2: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 2, "Beijing Nanheyan Address", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
                    operatorCallResultArray[1] = new OperatorCallResult("12345", 2, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                    break;
                }
                default: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 0, "Beijing Nanheyan Address", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
                    operatorCallResultArray[1] = new OperatorCallResult("12345", 0, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                    break;
                }
            }
        } else {
            ++poiCount;
            operatorCallResultArray = new OperatorCallResult[1];
            switch (n) {
                case 1: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 1, "Tokyo Hilton Hotel", TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691151), TestHandler.getIntGeocoordinate(35.692018)));
                    break;
                }
                case 2: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 2, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                    break;
                }
                default: {
                    operatorCallResultArray[0] = new OperatorCallResult("12345", 0, "Beijing Dongdan 3rd Alley Address", TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
                }
            }
        }
        return operatorCallResultArray;
    }

    public static OperatorCallResult[] getPOIList(int n) {
        TestHandler.initializePoiNames();
        OperatorCallResult[] operatorCallResultArray = new OperatorCallResult[2];
        switch (n) {
            case 1: {
                operatorCallResultArray[0] = new OperatorCallResult("12345", 1, poiNames[TestHandler.getNextPoiIndex()], TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691803), TestHandler.getIntGeocoordinate(35.687884)));
                operatorCallResultArray[1] = new OperatorCallResult("12345", 1, poiNames[TestHandler.getNextPoiIndex()], TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(137.916596), TestHandler.getIntGeocoordinate(36.197657)));
                break;
            }
            case 2: {
                operatorCallResultArray[0] = new OperatorCallResult("12345", 2, poiNames[TestHandler.getNextPoiIndex()], TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
                operatorCallResultArray[1] = new OperatorCallResult("12345", 1, poiNames[TestHandler.getNextPoiIndex()], TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(139.691803), TestHandler.getIntGeocoordinate(35.687884)));
                break;
            }
            default: {
                operatorCallResultArray[0] = new OperatorCallResult("12345", 2, poiNames[TestHandler.getNextPoiIndex()], TestHandler.getAddressEntry(), new NavLocationWgs84(TestHandler.getIntGeocoordinate(116.400501), TestHandler.getIntGeocoordinate(39.908857)));
                operatorCallResultArray[1] = new OperatorCallResult("12345", 1, poiNames[TestHandler.getNextPoiIndex()], TestHandler.getAddressEntry(), new NavLocationWgs84(1455999058, 226517276));
            }
        }
        poiCount = poiCount < poiNames.length - 1 ? ++poiCount : 0;
        return operatorCallResultArray;
    }

    private static int getNextPoiIndex() {
        return ++poiIndex % poiNames.length;
    }

    static {
        poiCount = 0;
        sdsPoiCount = 1;
        initialized = false;
        POI_RETURN_NORMAL = 0;
        poiReturnType = POI_RETURN_LIST = 1;
        maxCalls = 30;
        poiIndex = -1;
    }
}

