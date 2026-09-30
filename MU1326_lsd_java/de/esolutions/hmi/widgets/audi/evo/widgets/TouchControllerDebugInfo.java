/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;

public final class TouchControllerDebugInfo {
    public static final int DEBUGINFO_REPLACE_ALL = 0;
    public static final int DEBUGINFO_REPLACE_BEFORE = 1;
    public static final int DEBUGINFO_REPLACE_AFTER = 2;
    private static final boolean SHOW_SPELLER_DEBUG_INFO_ON_SCREEN = System.getProperty("showSpellerInfos") != null;
    private static final String[] debugInfo = new String[3];

    private TouchControllerDebugInfo() {
    }

    public static void showLockDebugInfo(HMITerminal hMITerminal, AbstractWidget abstractWidget, boolean bl) {
        if (!TouchControllerDebugInfo.shouldShowDebugInfo(hMITerminal, abstractWidget)) {
            return;
        }
        TouchControllerDebugInfo.showDebugInfoOnScreen(abstractWidget, 1, bl ? "Input LOCKED" : "Input UNLOCKED", hMITerminal, 1);
    }

    public static void showInputModeDebugInfo(HMITerminal hMITerminal, AbstractWidget abstractWidget, int n) {
        if (!TouchControllerDebugInfo.shouldShowDebugInfo(hMITerminal, abstractWidget)) {
            return;
        }
        String string = "Unknown";
        switch (n) {
            case 0: {
                string = "m_speller";
                break;
            }
            case 1: {
                string = "m_handwritting";
                break;
            }
        }
        TouchControllerDebugInfo.showDebugInfoOnScreen(abstractWidget, 1, new Buffer("IN_M: ").append(string).toString(), hMITerminal, 2);
    }

    public static void showTouchModeDebugInfo(HMITerminal hMITerminal, AbstractWidget abstractWidget, int n) {
        if (!TouchControllerDebugInfo.shouldShowDebugInfo(hMITerminal, abstractWidget)) {
            return;
        }
        String string = "Unknown";
        switch (n) {
            case 16: {
                string = "MS_GENERAL";
                break;
            }
            case 17: {
                string = "MS_NAV_DEST_COUNTRY";
                break;
            }
            case 18: {
                string = "MS_NAV_DEST_CITY";
                break;
            }
            case 19: {
                string = "MS_NAV_DEST_STREET";
                break;
            }
            case 20: {
                string = "MS_NAV_DEST_HOUSENUMBER";
                break;
            }
            case 21: {
                string = "MS_PHONE_STANDARD";
                break;
            }
            case 22: {
                string = "MS_JP_MAPCODE";
                break;
            }
            case 23: {
                string = "MS_JP_PHONE_SEARCH";
                break;
            }
            case 32: {
                string = "FT_GENERAL";
                break;
            }
            case 33: {
                string = "FT_SSID";
                break;
            }
            case 48: {
                string = "SEARCH_GENERAL";
                break;
            }
            case 49: {
                string = "SEARCH_FAVORITES";
                break;
            }
            case 50: {
                string = "SEARCH_ADRESSBOOK";
                break;
            }
            case 51: {
                string = "SEARCH_NAVI";
                break;
            }
            case 55: {
                string = "SEARCH_PHONE CALL LIST";
                break;
            }
            case 52: {
                string = "SEARCH_PHONE";
                break;
            }
            case 53: {
                string = "SEARCH_SMS_EMAIL";
                break;
            }
            case 54: {
                string = "SEARCH_GOOGLE_ONLINE";
                break;
            }
            case 64: {
                string = "PIN_INPUT";
                break;
            }
            case 80: {
                string = "PW_IN_GENERAL";
                break;
            }
            case 81: {
                string = "PW_IN_WLAN_APN";
                break;
            }
            case 82: {
                string = "PW_IN_WLAN_CLIENT";
                break;
            }
            case 96: {
                string = "MSG_MULTILINE";
                break;
            }
            case 97: {
                string = "MSG_EMAIL_RECIPIENT";
                break;
            }
            case 98: {
                string = "MSG_SMS_RECIPIENT";
                break;
            }
            case 113: {
                string = "DTMF_INPUT";
                break;
            }
            case 114: {
                string = "PHONE_NUMBER_INPUT";
                break;
            }
        }
        TouchControllerDebugInfo.showDebugInfoOnScreen(abstractWidget, 0, new Buffer("TP_M: ").append(string).toString(), hMITerminal, 1);
    }

    public static void showFocusStateDebugInfo(HMITerminal hMITerminal, AbstractWidget abstractWidget, SpellerBandState spellerBandState, TouchControllerFocusState touchControllerFocusState) {
        if (!TouchControllerDebugInfo.shouldShowDebugInfo(hMITerminal, abstractWidget)) {
            return;
        }
        String string = null;
        if (spellerBandState != null) {
            string = spellerBandState.getAbbreviationName();
        }
        TouchControllerDebugInfo.showDebugInfoOnScreen(abstractWidget, 2, new Buffer("Focus: ").append(touchControllerFocusState.toString().substring(0, touchControllerFocusState.toString().length() - 6)).append(" | ").append(string).toString(), hMITerminal, 0);
    }

    public static void showSpellerModelDebugInfo(HMITerminal hMITerminal, AbstractWidget abstractWidget, int n) {
        String string;
        if (!TouchControllerDebugInfo.shouldShowDebugInfo(hMITerminal, abstractWidget)) {
            return;
        }
        switch (n) {
            case 0: {
                string = "FREETEXT";
                break;
            }
            case 1: {
                string = "PHONE_NUMBER";
                break;
            }
            case 2: {
                string = "PIN";
                break;
            }
            case 3: {
                string = "DMTF";
                break;
            }
            case 4: {
                string = "MULTILINE";
                break;
            }
            case 5: {
                string = "ADDRESSING";
                break;
            }
            case 6: {
                string = "WLAN";
                break;
            }
            case 7: {
                string = "TUNER_TV";
                break;
            }
            case 8: {
                string = "MATCH_PHONE";
                break;
            }
            case 9: {
                string = "MATCH_HOUSENUMBER";
                break;
            }
            case 10: {
                string = "CONNECT";
                break;
            }
            case 11: {
                string = "MATCHSPELLER";
                break;
            }
            case 12: {
                string = "ASIA_PASSWORD";
                break;
            }
            case 13: {
                string = "JP_MAPCODE";
                break;
            }
            case 14: {
                string = "TV_OPERATIONAL";
                break;
            }
            case 15: {
                string = "ONLINE";
                break;
            }
            default: {
                string = "Unknown";
            }
        }
        TouchControllerDebugInfo.showDebugInfoOnScreen(abstractWidget, 0, new Buffer("SP_M:").append(string).toString(), hMITerminal, 2);
    }

    public static void clear(HMITerminal hMITerminal) {
        for (int i2 = 0; i2 < debugInfo.length; ++i2) {
            TouchControllerDebugInfo.debugInfo[i2] = "";
        }
        if (SHOW_SPELLER_DEBUG_INFO_ON_SCREEN && hMITerminal != null) {
            hMITerminal.getStatistics().showStatistics(21, debugInfo, false);
        }
    }

    private static boolean shouldShowDebugInfo(HMITerminal hMITerminal, AbstractWidget abstractWidget) {
        return SHOW_SPELLER_DEBUG_INFO_ON_SCREEN && hMITerminal != null && abstractWidget.isVisibleInHierarchy();
    }

    private static void showDebugInfoOnScreen(AbstractWidget abstractWidget, int n, String string, HMITerminal hMITerminal, int n2) {
        int n3 = n;
        if (n3 < 0 || n3 >= debugInfo.length) {
            n3 = 0;
        }
        switch (n2) {
            case 1: 
            case 2: {
                String string2 = debugInfo[n3];
                if (StringUtilities.isNullOrEmpty(string2)) {
                    TouchControllerDebugInfo.debugInfo[n3] = new String("|");
                    string2 = debugInfo[n3];
                }
                int n4 = debugInfo[n3].indexOf("|");
                Buffer buffer = new Buffer();
                if (n2 == 1) {
                    buffer.append(string).append(" ").append(string2.substring(n4));
                } else {
                    buffer.append(string2.substring(0, n4 + 1)).append(" ").append(string);
                }
                TouchControllerDebugInfo.debugInfo[n3] = buffer.toString();
                break;
            }
            default: {
                TouchControllerDebugInfo.debugInfo[n3] = string;
            }
        }
        hMITerminal.getStatistics().showStatistics(21, debugInfo, false);
    }
}

