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
    private static final String CL_ENTRY_ID;
    private static final String CL_NUMBER;
    private static final String CL_NAME;
    private static final String CL_ENTRY_ORIGIN;
    private static final String CL_ENTRY_TYPE;
    private static final String CL_YEAR;
    private static final String CL_MONTH;
    private static final String CL_DAY;
    private static final String CL_HOUR;
    private static final String CL_MINUTE;
    private static final String CL_SECOND;
    private static final String CL_RL;
    private static final String CL_RL_ID;
    private static final String CL_RL_URL;
    private static final String CL_ADB_ID;
    private static final String CL_ADB_PHONE_INDEX;
    private static final String CL_ADB_PHONE_DATA_COUNT;
    private static final String CL_NEW_MISSED_CALL_ATTEMPTS;
    private static final String CL_ADB_NUMBER_TYPE;

    public static String serialize(CallStackEntry callStackEntry) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clEntryID", new Integer(callStackEntry.getClEntryID()));
        jSONObject.put("clNumber", callStackEntry.getClNumber());
        jSONObject.put("clName", callStackEntry.getClName());
        jSONObject.put("clEntryOrigin", new Integer(callStackEntry.getClEntryOrigin()));
        jSONObject.put("clEntryType", new Integer(callStackEntry.getClEntryType()));
        jSONObject.put("clYear", new Integer(callStackEntry.getClYear()));
        jSONObject.put("clMonth", new Integer(callStackEntry.getClMonth()));
        jSONObject.put("clDay", new Integer(callStackEntry.getClDay()));
        jSONObject.put("clHour", new Integer(callStackEntry.getClHour()));
        jSONObject.put("clMinute", new Integer(callStackEntry.getClMinute()));
        jSONObject.put("clSecond", new Integer(callStackEntry.getClSecond()));
        jSONObject.put("adbEntryID", new Long(callStackEntry.getAdbEntryID()));
        jSONObject.put("adbPhoneDataIndex", new Integer(callStackEntry.getAdbPhoneDataIndex()));
        jSONObject.put("adbPhoneDataCount", new Integer(callStackEntry.getAdbPhoneDataCount()));
        jSONObject.put("newMissedCallAttempts", new Integer(callStackEntry.getNewMissedCallAttempts()));
        jSONObject.put("adbNumberType", new Integer(callStackEntry.getAdbNumberType()));
        if (callStackEntry.getAdbPictureID() != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resourceLocatorID", new Integer(callStackEntry.getAdbPictureID().getId()));
            jSONObject2.put("resourceLocatorURL", callStackEntry.getAdbPictureID().getUrl());
            jSONObject.put("adbPictureID", jSONObject2);
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
            callStackEntry.clEntryID = TelCallStack2JsonStringConverter.getInt("clEntryID", jSONObject);
            callStackEntry.clNumber = TelCallStack2JsonStringConverter.getString("clNumber", jSONObject);
            callStackEntry.clName = TelCallStack2JsonStringConverter.getString("clName", jSONObject);
            callStackEntry.clEntryOrigin = TelCallStack2JsonStringConverter.getInt("clEntryOrigin", jSONObject);
            callStackEntry.clEntryType = TelCallStack2JsonStringConverter.getInt("clEntryType", jSONObject);
            callStackEntry.clYear = (short)TelCallStack2JsonStringConverter.getInt("clYear", jSONObject);
            callStackEntry.clMonth = (short)TelCallStack2JsonStringConverter.getInt("clMonth", jSONObject);
            callStackEntry.clDay = (short)TelCallStack2JsonStringConverter.getInt("clDay", jSONObject);
            callStackEntry.clHour = (short)TelCallStack2JsonStringConverter.getInt("clHour", jSONObject);
            callStackEntry.clMinute = (short)TelCallStack2JsonStringConverter.getInt("clMinute", jSONObject);
            callStackEntry.clSecond = (short)TelCallStack2JsonStringConverter.getInt("clSecond", jSONObject);
            callStackEntry.adbEntryID = TelCallStack2JsonStringConverter.getLong("adbEntryID", jSONObject);
            callStackEntry.adbPhoneDataIndex = TelCallStack2JsonStringConverter.getInt("adbPhoneDataIndex", jSONObject);
            callStackEntry.adbPhoneDataCount = TelCallStack2JsonStringConverter.getInt("adbPhoneDataCount", jSONObject);
            callStackEntry.newMissedCallAttempts = TelCallStack2JsonStringConverter.getInt("newMissedCallAttempts", jSONObject);
            callStackEntry.adbNumberType = TelCallStack2JsonStringConverter.getInt("adbNumberType", jSONObject);
            JSONObject jSONObject2 = (JSONObject)jSONObject.get("adbPictureID");
            if (jSONObject2 != null) {
                int n = TelCallStack2JsonStringConverter.getInt("resourceLocatorID", jSONObject2);
                String string2 = TelCallStack2JsonStringConverter.getString("resourceLocatorURL", jSONObject2);
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

