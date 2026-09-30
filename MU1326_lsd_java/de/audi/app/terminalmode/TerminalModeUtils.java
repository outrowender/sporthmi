/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.keyevents.Key;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.interapp.audio.ATIPAudioRoute;
import de.audi.atip.utils.generics.GCopyOnWriteList;
import de.audi.atip.utils.generics.GIterator;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class TerminalModeUtils {
    public static final String EMPTY_STRING = "";
    public static final int ENABLED = 1;
    public static final int DISABLED = 0;
    public static final int NOTHING_ACTIVE = 0;
    public static final int CARPLAY_ACTIVE = 1;
    public static final int ANDROIDAUTO_ACTIVE = 2;
    public static final int ACTIVE_SMI_ENTERTAINMENT_NONE = 0;
    public static final int ACTIVE_SMI_ENTERTAINMENT_CARPLAY = 1;
    public static final int ACTIVE_SMI_ENTERTAINMENT_ANDRIODAUTO = 2;
    public static final int ACTIVE_SMI_ENTERTAINMENT_CARLIFE = 3;

    public static String logAppStates(IAppState[] iAppStateArray) {
        Buffer buffer = new Buffer(100);
        for (int i2 = 0; i2 < iAppStateArray.length; ++i2) {
            buffer.append(iAppStateArray[i2]);
            buffer.append(" , ");
        }
        return buffer.toString();
    }

    public static String logResources(IResource[] iResourceArray) {
        Buffer buffer = new Buffer(100);
        for (int i2 = 0; i2 < iResourceArray.length; ++i2) {
            buffer.append(iResourceArray[i2]);
            buffer.append(" , ");
        }
        return buffer.toString();
    }

    public static String logKeyState(int n) {
        switch (n) {
            case 1: {
                return "PRESSED";
            }
            case 0: {
                return "RELEASED";
            }
        }
        return "UNKNOWN";
    }

    public static String logConnectionState(int n) {
        switch (n) {
            case 1: {
                return "CONNECTED";
            }
            case 0: {
                return "DISCONNECTED";
            }
            case 4: {
                return "ERROR_DEVICE_LOCKED";
            }
            case 6: {
                return "ERROR_NO_CARPLAY_DEVICE";
            }
            case 7: {
                return "ERROR_NO_ANDROIDAUTO_DEVICE";
            }
            case 5: {
                return "ERROR_NO_MIRRORLICK_DEVICE";
            }
            case 9: {
                return "ERROR_OTHER";
            }
            case 8: {
                return "ERROR_TIMEOUT";
            }
            case 2: {
                return "STARTED";
            }
            case 3: {
                return "STOPPED";
            }
        }
        return "UNKNOWN";
    }

    public static String logConnectionMethod(int n) {
        if (TerminalModeUtils.isBitEquals(n, 32)) {
            return "CARLIFE";
        }
        if (TerminalModeUtils.isBitEquals(n, 2)) {
            return "CARPLAY";
        }
        if (TerminalModeUtils.isBitEquals(n, 4)) {
            return "CARPLAYVERIFIED";
        }
        if (TerminalModeUtils.isBitEquals(n, 16)) {
            return "CARPLAY_WRONG_PORT";
        }
        if (TerminalModeUtils.isBitEquals(n, 8)) {
            return "GAL";
        }
        return "UNKNOWN";
    }

    private static boolean isBitEquals(int n, int n2) {
        return (n & n2) == n2;
    }

    public static String logAudioType(int n) {
        switch (n) {
            case 1: {
                return "ALERT";
            }
            case 2: {
                return "MEDIA";
            }
            case 4: {
                return "SPEECH";
            }
            case 3: {
                return "PHONE";
            }
        }
        return "NONE";
    }

    public static String logMediaRoutes(ATIPAudioRoute[] aTIPAudioRouteArray) {
        Buffer buffer = new Buffer(500);
        for (int i2 = 0; i2 < aTIPAudioRouteArray.length; ++i2) {
            buffer.append('[');
            buffer.append(aTIPAudioRouteArray[i2].toString());
            buffer.append(']');
        }
        return buffer.toString();
    }

    public static boolean isJoystick(Key key) {
        return key.isOneOf(Key.JS_EAST, Key.JS_MIDDLE, Key.JS_NORTH, Key.JS_SOUTH, Key.JS_WEST);
    }

    public static boolean isJoystickMiddleposition(Key key) {
        return key.is(Key.JS_MIDDLE);
    }

    public static boolean compareTMStateAfterDSIUpdate(TMState tMState, TMState tMState2) {
        if (tMState == null) {
            return false;
        }
        if (tMState2 == null) {
            return false;
        }
        if (tMState.equals(tMState2)) {
            return true;
        }
        if (!Arrays.equals(tMState.getResourceOwner(), tMState2.getResourceOwner())) {
            return false;
        }
        if (tMState.getSpeechMode() != tMState2.getSpeechMode()) {
            return false;
        }
        ApplicationOwner[] applicationOwnerArray = tMState.getAppOwner();
        ApplicationOwner[] applicationOwnerArray2 = tMState2.getAppOwner();
        for (int i2 = 0; i2 < applicationOwnerArray2.length; ++i2) {
            if (applicationOwnerArray[i2] == ApplicationOwner.DEVICE && applicationOwnerArray[i2] != applicationOwnerArray2[i2]) {
                return false;
            }
            if (applicationOwnerArray[i2] == ApplicationOwner.NOBODY && applicationOwnerArray[i2] != applicationOwnerArray2[i2]) {
                return false;
            }
            if (applicationOwnerArray[i2] != ApplicationOwner.MAINUNIT || applicationOwnerArray2[i2] != ApplicationOwner.DEVICE) continue;
            return false;
        }
        return true;
    }

    public static boolean equalsResourcesOwner(ResourceOwner[] resourceOwnerArray, ResourceOwner[] resourceOwnerArray2) {
        if (resourceOwnerArray.length != resourceOwnerArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < resourceOwnerArray.length; ++i2) {
            if (resourceOwnerArray[i2] == resourceOwnerArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public static int[] getArrayFromList(GCopyOnWriteList<Integer> gCopyOnWriteList) {
        int[] nArray = new int[gCopyOnWriteList.size()];
        int n = 0;
        GIterator gIterator = gCopyOnWriteList.iterator();
        while (gIterator.hasNext()) {
            Integer n2 = (Integer)gIterator.next();
            if (null == n2) continue;
            nArray[n] = n2;
            ++n;
        }
        return nArray;
    }

    public static int mapActiveSmartphoneTypeToEntertainmentAudioModelType(SmartphoneManager.SmartphoneType smartphoneType) {
        if (smartphoneType.is(SmartphoneManager.SmartphoneType.CARPLAY)) {
            return 1;
        }
        if (smartphoneType.is(SmartphoneManager.SmartphoneType.ANDROIDAUTO2)) {
            return 2;
        }
        if (smartphoneType.is(SmartphoneManager.SmartphoneType.CARLIFE)) {
            return 3;
        }
        throw new IllegalArgumentException("no valid smartphone type");
    }
}

