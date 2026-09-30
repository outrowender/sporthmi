/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.stat;

public interface DataInterface {
    public static final String DATA_CAR_CONSUMPTION = "car.consumption";
    public static final String DATA_CAR_CURRENTCITY = "car.currentCity";
    public static final String DATA_CAR_CURRENTSTREET = "car.currentStreet";
    public static final String DATA_CAR_DAY = "car.day";
    public static final String DATA_CAR_DESTLAT = "car.destLat";
    public static final String DATA_CAR_DESTLON = "car.destLon";
    public static final String DATA_CAR_HEADING = "car.heading";
    public static final String DATA_CAR_HEIGHT = "car.height";
    public static final String DATA_CAR_LAN = "car.lan";
    public static final String DATA_CAR_LAT = "car.lat";
    public static final String DATA_CAR_LON = "car.lon";
    public static final String DATA_CAR_OEM = "car.oem";
    public static final String DATA_CAR_REV = "car.rev";
    public static final String DATA_CAR_REVOLUSIONS = "car.revolution";
    public static final String DATA_CAR_TOTALMILAGE = "car.totalMilage";
    public static final String DATA_CAR_UNITDIST = "car.unitDist";
    public static final String DATA_CAR_UNITFUEL = "car.unitFuel";
    public static final String DATA_CAR_UNITPRESS = "car.unitPress";
    public static final String DATA_CAR_UNITTEMP = "car.unitTemp";
    public static final String DATA_CAR_VELOCITY = "car.velocity";
    public static final String DATA_CAR_VIN = "car.vin";
    public static final String DATA_CAR_XRES = "car.xres";
    public static final String DATA_CAR_YRES = "car.yres";
    public static final String DATA_CONNECTIVITY_DATASTATE = "connectivity.dataState";
    public static final String DATA_CONNECTIVITY_ERRORSTATE = "connectivity.errorState";
    public static final String DATA_VERSION = "version";
    public static final String FUNCTION_CONNECTIVITY_CONNECT = "connectivity.connect";
    public static final String FUNCTION_CONNECTIVITY_DISCONNECT = "connectivity.disconnect";
    public static final String FUNCTION_FOCUS_REQUEST = "focus.request";
    public static final String FUNCTION_FOCUS_HIDE = "focus.hide";
    public static final String FUNCTION_INSTANCE_SET = "instance.set";
    public static final String FUNCTION_INSTANCE_GETNAME = "instance.getname";

    public Object getData(String var1);

    public void executeFunctionalLink(String var1);

    public Object executeFunction(String var1, Object[] var2);
}

