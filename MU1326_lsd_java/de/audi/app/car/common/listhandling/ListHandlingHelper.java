/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.listhandling;

import de.audi.app.car.common.listhandling.BatteryControlPowerProviderRAx;
import de.audi.app.car.common.listhandling.BatteryControlProfileRAx;
import de.audi.app.car.common.listhandling.SyncedBCProfileRAxArray;
import de.audi.atip.log.LogChannel;
import java.lang.reflect.Field;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;

public class ListHandlingHelper {
    private static LogChannel logChannel = null;

    public static synchronized void init(LogChannel logChannel) {
        if (ListHandlingHelper.logChannel == null) {
            ListHandlingHelper.logChannel = logChannel;
        }
    }

    public static synchronized Object copyFromBatteryControlProfileRAx(BatteryControlProfileRAx batteryControlProfileRAx, int n) {
        Object object = null;
        switch (n) {
            case 0: {
                object = new BatteryControlProfileRA0();
                break;
            }
            case 1: {
                object = new BatteryControlProfileRA1();
                break;
            }
            case 2: {
                object = new BatteryControlProfileRA2();
                break;
            }
            case 3: {
                object = new BatteryControlProfileRA3();
                break;
            }
            case 4: {
                object = new BatteryControlProfileRA4();
                break;
            }
            case 5: {
                object = new BatteryControlProfileRA5();
                break;
            }
            case 6: {
                object = new BatteryControlProfileRA6();
                break;
            }
            case 7: {
                object = new BatteryControlProfileRA7();
                break;
            }
        }
        logChannel.log(1078071040, "copyFromBatteryControlProfileRAx with params source=%1, recordAddress=%2 calls cloneTo()", (Object)batteryControlProfileRAx, (long)n);
        return ListHandlingHelper.cloneTo(batteryControlProfileRAx, object);
    }

    public static synchronized Object cloneTo(Object object, Object object2) {
        Class clazz = object2.getClass();
        Class clazz2 = object.getClass();
        Field[] fieldArray = clazz2.getDeclaredFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            String string = fieldArray[i2].getName();
            try {
                Object object3 = clazz2.getField(fieldArray[i2].getName()).get(object);
                logChannel.log(1078071040, "set target field '%1' to value %2", (Object)string, object3);
                clazz.getField(string).set(object2, object3);
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
                continue;
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
                continue;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                noSuchFieldException.printStackTrace();
            }
        }
        return object2;
    }

    public static synchronized BatteryControlProfileRAx copyToBatteryControlProfileRAx(Object object, BatteryControlProfileRAx batteryControlProfileRAx) {
        logChannel.log(1078071040, "copyToBatteryControlProfileRAx with params source=%1 calls cloneTo()", object);
        if (batteryControlProfileRAx == null) {
            batteryControlProfileRAx = new BatteryControlProfileRAx();
        }
        return (BatteryControlProfileRAx)ListHandlingHelper.cloneTo(object, batteryControlProfileRAx);
    }

    public static synchronized BatteryControlProfileRAx[] mergeBatteryControlProfileArray(Object[] objectArray, SyncedBCProfileRAxArray syncedBCProfileRAxArray) {
        BatteryControlProfileRAx[] batteryControlProfileRAxArray = new BatteryControlProfileRAx[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            int n = -1;
            if (objectArray[i2] instanceof BatteryControlProfileRA5) {
                n = ((BatteryControlProfileRA5)objectArray[i2]).getPos();
            } else if (objectArray[i2] instanceof BatteryControlProfileRA6) {
                n = ((BatteryControlProfileRA6)objectArray[i2]).getPos();
            } else {
                Object object = ListHandlingHelper.getField("pos", objectArray[i2]);
                if (object != null) {
                    n = (Integer)object;
                } else {
                    logChannel.log(10000, "Something is REALLY, REALLY WRONG. sourceArray[%1]=%2 has no field 'pos' ", (Object)String.valueOf(i2), objectArray[i2]);
                }
            }
            if (ListHandlingHelper.isIllegalIndex(n, syncedBCProfileRAxArray)) {
                logChannel.log(10000, "profListArray[%1] has no index 'pos'", (Object)String.valueOf(i2));
                return null;
            }
            batteryControlProfileRAxArray[i2] = ListHandlingHelper.copyToBatteryControlProfileRAx(objectArray[i2], syncedBCProfileRAxArray.get(n));
        }
        return batteryControlProfileRAxArray;
    }

    private static boolean isIllegalIndex(int n, SyncedBCProfileRAxArray syncedBCProfileRAxArray) {
        return n >= syncedBCProfileRAxArray.length() || n < 0;
    }

    public static synchronized BatteryControlPowerProviderRAx[] copyToBatteryControlPowerProviderArray(Object[] objectArray, int n) {
        logChannel.log(1078071040, "copyToBatteryControlPowerProviderArray: sourceArray=%1, sourceRecordAddress=%2", (long)n);
        BatteryControlPowerProviderRAx[] batteryControlPowerProviderRAxArray = new BatteryControlPowerProviderRAx[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            batteryControlPowerProviderRAxArray[i2] = ListHandlingHelper.copyToBatteryControlPowerProviderRAx(objectArray[i2], n);
        }
        return batteryControlPowerProviderRAxArray;
    }

    public static synchronized BatteryControlPowerProviderRAx copyToBatteryControlPowerProviderRAx(Object object, int n) {
        BatteryControlPowerProviderRAx batteryControlPowerProviderRAx = new BatteryControlPowerProviderRAx();
        logChannel.log(1078071040, "copyToBatteryControlPowerProviderRAx with params source=%1, recordAddress=%2 calls cloneTo()", object, (long)n);
        return (BatteryControlPowerProviderRAx)ListHandlingHelper.cloneTo(object, batteryControlPowerProviderRAx);
    }

    private static Object getField(String string, Object object) {
        Class clazz = object.getClass();
        Object object2 = null;
        try {
            object2 = clazz.getField(string).get(object);
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return object2;
    }
}

