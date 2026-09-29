/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.stat;

public interface DataInterface {
    public static final String DATA_CAR_CONSUMPTION;
    public static final String DATA_CAR_CURRENTCITY;
    public static final String DATA_CAR_CURRENTSTREET;
    public static final String DATA_CAR_DAY;
    public static final String DATA_CAR_DESTLAT;
    public static final String DATA_CAR_DESTLON;
    public static final String DATA_CAR_HEADING;
    public static final String DATA_CAR_HEIGHT;
    public static final String DATA_CAR_LAN;
    public static final String DATA_CAR_LAT;
    public static final String DATA_CAR_LON;
    public static final String DATA_CAR_OEM;
    public static final String DATA_CAR_REV;
    public static final String DATA_CAR_REVOLUSIONS;
    public static final String DATA_CAR_TOTALMILAGE;
    public static final String DATA_CAR_UNITDIST;
    public static final String DATA_CAR_UNITFUEL;
    public static final String DATA_CAR_UNITPRESS;
    public static final String DATA_CAR_UNITTEMP;
    public static final String DATA_CAR_VELOCITY;
    public static final String DATA_CAR_VIN;
    public static final String DATA_CAR_XRES;
    public static final String DATA_CAR_YRES;
    public static final String DATA_CONNECTIVITY_DATASTATE;
    public static final String DATA_CONNECTIVITY_ERRORSTATE;
    public static final String DATA_VERSION;
    public static final String FUNCTION_CONNECTIVITY_CONNECT;
    public static final String FUNCTION_CONNECTIVITY_DISCONNECT;
    public static final String FUNCTION_FOCUS_REQUEST;
    public static final String FUNCTION_FOCUS_HIDE;
    public static final String FUNCTION_INSTANCE_SET;
    public static final String FUNCTION_INSTANCE_GETNAME;

    default public Object getData(String string) {
    }

    default public void executeFunctionalLink(String string) {
    }

    default public Object executeFunction(String string, Object[] objectArray) {
    }
}

