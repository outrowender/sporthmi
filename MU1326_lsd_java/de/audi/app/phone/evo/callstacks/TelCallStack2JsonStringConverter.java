/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callstacks;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TelCallStack2JsonStringConverter {
    private static final String CL_ENTRY_ID = "clEntryID";
    private static final String CL_NUMBER = "clNumber";
    private static final String CL_NAME = "clName";
    private static final String CL_ENTRY_ORIGIN = "clEntryOrigin";
    private static final String CL_ENTRY_TYPE = "clEntryType";
    private static final String CL_YEAR = "clYear";
    private static final String CL_MONTH = "clMonth";
    private static final String CL_DAY = "clDay";
    private static final String CL_HOUR = "clHour";
    private static final String CL_MINUTE = "clMinute";
    private static final String CL_SECOND = "clSecond";
    private static final String CL_RL = "adbPictureID";
    private static final String CL_RL_ID = "resourceLocatorID";
    private static final String CL_RL_URL = "resourceLocatorURL";
    private static final String CL_ADB_ID = "adbEntryID";
    private static final String CL_ADB_PHONE_INDEX = "adbPhoneDataIndex";
    private static final String CL_ADB_PHONE_DATA_COUNT = "adbPhoneDataCount";
    private static final String CL_NEW_MISSED_CALL_ATTEMPTS = "newMissedCallAttempts";
    private static final String CL_ADB_NUMBER_TYPE = "adbNumberType";

    public static String serialize(CallStackEntry callStackEntry) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CL_ENTRY_ID, new Integer(callStackEntry.getClEntryID()));
        jSONObject.put(CL_NUMBER, callStackEntry.getClNumber());
        jSONObject.put(CL_NAME, callStackEntry.getClName());
        jSONObject.put(CL_ENTRY_ORIGIN, new Integer(callStackEntry.getClEntryOrigin()));
        jSONObject.put(CL_ENTRY_TYPE, new Integer(callStackEntry.getClEntryType()));
        jSONObject.put(CL_YEAR, new Integer(callStackEntry.getClYear()));
        jSONObject.put(CL_MONTH, new Integer(callStackEntry.getClMonth()));
        jSONObject.put(CL_DAY, new Integer(callStackEntry.getClDay()));
        jSONObject.put(CL_HOUR, new Integer(callStackEntry.getClHour()));
        jSONObject.put(CL_MINUTE, new Integer(callStackEntry.getClMinute()));
        jSONObject.put(CL_SECOND, new Integer(callStackEntry.getClSecond()));
        jSONObject.put(CL_ADB_ID, new Long(callStackEntry.getAdbEntryID()));
        jSONObject.put(CL_ADB_PHONE_INDEX, new Integer(callStackEntry.getAdbPhoneDataIndex()));
        jSONObject.put(CL_ADB_PHONE_DATA_COUNT, new Integer(callStackEntry.getAdbPhoneDataCount()));
        jSONObject.put(CL_NEW_MISSED_CALL_ATTEMPTS, new Integer(callStackEntry.getNewMissedCallAttempts()));
        jSONObject.put(CL_ADB_NUMBER_TYPE, new Integer(callStackEntry.getAdbNumberType()));
        if (callStackEntry.getAdbPictureID() != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CL_RL_ID, new Integer(callStackEntry.getAdbPictureID().getId()));
            jSONObject2.put(CL_RL_URL, callStackEntry.getAdbPictureID().getUrl());
            jSONObject.put(CL_RL, jSONObject2);
        }
        return jSONObject.toJSONString();
    }

    public static CallStackEntry deserialize(String string) {
        JSONParser jSONParser = new JSONParser();
        JSONObject jSONObject = null;
        try {
            jSONObject = (JSONObject)jSONParser.parse(string);
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        if (jSONObject != null) {
            CallStackEntry callStackEntry = new CallStackEntry();
            callStackEntry.clEntryID = TelCallStack2JsonStringConverter.getInt(CL_ENTRY_ID, jSONObject);
            callStackEntry.clNumber = TelCallStack2JsonStringConverter.getString(CL_NUMBER, jSONObject);
            callStackEntry.clName = TelCallStack2JsonStringConverter.getString(CL_NAME, jSONObject);
            callStackEntry.clEntryOrigin = TelCallStack2JsonStringConverter.getInt(CL_ENTRY_ORIGIN, jSONObject);
            callStackEntry.clEntryType = TelCallStack2JsonStringConverter.getInt(CL_ENTRY_TYPE, jSONObject);
            callStackEntry.clYear = (short)TelCallStack2JsonStringConverter.getInt(CL_YEAR, jSONObject);
            callStackEntry.clMonth = (short)TelCallStack2JsonStringConverter.getInt(CL_MONTH, jSONObject);
            callStackEntry.clDay = (short)TelCallStack2JsonStringConverter.getInt(CL_DAY, jSONObject);
            callStackEntry.clHour = (short)TelCallStack2JsonStringConverter.getInt(CL_HOUR, jSONObject);
            callStackEntry.clMinute = (short)TelCallStack2JsonStringConverter.getInt(CL_MINUTE, jSONObject);
            callStackEntry.clSecond = (short)TelCallStack2JsonStringConverter.getInt(CL_SECOND, jSONObject);
            callStackEntry.adbEntryID = TelCallStack2JsonStringConverter.getLong(CL_ADB_ID, jSONObject);
            callStackEntry.adbPhoneDataIndex = TelCallStack2JsonStringConverter.getInt(CL_ADB_PHONE_INDEX, jSONObject);
            callStackEntry.adbPhoneDataCount = TelCallStack2JsonStringConverter.getInt(CL_ADB_PHONE_DATA_COUNT, jSONObject);
            callStackEntry.newMissedCallAttempts = TelCallStack2JsonStringConverter.getInt(CL_NEW_MISSED_CALL_ATTEMPTS, jSONObject);
            callStackEntry.adbNumberType = TelCallStack2JsonStringConverter.getInt(CL_ADB_NUMBER_TYPE, jSONObject);
            JSONObject jSONObject2 = (JSONObject)jSONObject.get(CL_RL);
            if (jSONObject2 != null) {
                int n = TelCallStack2JsonStringConverter.getInt(CL_RL_ID, jSONObject2);
                String string2 = TelCallStack2JsonStringConverter.getString(CL_RL_URL, jSONObject2);
                callStackEntry.adbPictureID = new ResourceLocator(n, string2);
            }
            return callStackEntry;
        }
        return null;
    }

    private static int getInt(String string, JSONObject jSONObject) {
        return ((Long)jSONObject.get(string)).intValue();
    }

    private static long getLong(String string, JSONObject jSONObject) {
        return (Long)jSONObject.get(string);
    }

    private static String getString(String string, JSONObject jSONObject) {
        return (String)jSONObject.get(string);
    }
}

