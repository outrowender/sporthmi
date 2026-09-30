/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.esolutions.fw.util.commons.Buffer;

public class MMICombiDisplayStatus
implements Cloneable {
    public static final int FOCUS_COMBI = 1;
    public static final int FOCUS_HMI = 2;
    public static final int VIEW_SIZE_NO_CHANGE = 0;
    public static final int VIEW_SIZE_SMALL = 1;
    public static final int VIEW_SIZE_LARGE = 2;
    public static final boolean KOMBI_INTERNAL_REASON_FOR_LARGE_VIEW_SIZE_ACTIVE = true;
    public static final int VIEW_SIZE_LOGICAL_POPUP = 3;
    public static final int MAIN_CONTEXT_NONE = 0;
    public static final int MAIN_CONTEXT_NAVIGATION = 16;
    public static final int MAIN_CONTEXT_NAVIGATION_MAP = 20;
    public static final int MAIN_CONTEXT_NAVIGATION_DEST = 22;
    public static final int MAIN_CONTEXT_AUDIO = 32;
    public static final int MAIN_CONTEXT_AUDIO_TUNER = 36;
    public static final int MAIN_CONTEXT_AUDIO_MEDIA = 39;
    public static final int MAIN_CONTEXT_PHONE = 48;
    public static final int MAIN_CONTEXT_BCALL = 62;
    public static final int MAIN_CONTEXT_CCALL = 63;
    public static final int MAIN_CONTEXT_GREEN_ENGINEERING_MENU = 74;
    public static final int MAIN_CONTEXT_SWDL = 75;
    public static final int MAIN_CONTEXT_TONE = 80;
    public static final int MAIN_CONTEXT_SETUP = 81;
    public static final int MAIN_CONTEXT_APPS = 96;
    public static final int MAIN_CONTEXT_CONNECT = 112;
    public static final int MAIN_CONTEXT_OFFICE = 113;
    public static final int MAIN_CONTEXT_CONNECTIVITY_MANAGER = 114;
    public static final int MAIN_CONTEXT_VICS = 115;
    public static final int MAIN_CONTEXT_TPEG = 116;
    public static final int MAIN_CONTEXT_SMARTPHONE_CARPLAY = 117;
    public static final int MAIN_CONTEXT_SMARTPHONE_GOOGLE_PLAY = 118;
    public static final int MAIN_CONTEXT_CAR = 128;
    public static final int MAIN_CONTEXT_CAR_360_VIEWER = 129;
    public static final int MAIN_CONTEXT_CAR_FAVOURITES = 130;
    public static final int MAIN_CONTEXT_CAR_DRIVER_ASSISTANCE = 131;
    public static final int MAIN_CONTEXT_CAR_SETTINGS = 132;
    public static final int MAIN_CONTEXT_CAR_CLIMATE = 133;
    public static final int MAIN_CONTEXT_AUXILIARY_HEATING = 134;
    public static final int MAIN_CONTEXT_SERVICE_CONTROL = 135;
    public static final int MAIN_CONTEXT_DRIVE_SELECT = 136;
    public static final int MAIN_CONTEXT_LOADING = 137;
    public static final int MAIN_CONTEXT_RVC = 138;
    public static final int MAIN_CONTEXT_BOARDBOOK = 139;
    public static final int MAIN_CONTEXT_ETC = 140;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_1 = 161;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_2 = 162;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_3 = 163;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_4 = 164;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_5 = 165;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_6 = 166;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_7 = 167;
    public static final int MAIN_CONTEXT_COMBI_MESSAGE_8 = 168;
    public static final int MAIN_CONTEXT_DESIGN_SKIN_CHANGE = 174;
    public static final int MAIN_CONTEXT_MAIN_MENU = 175;
    public static final int MAIN_CONTEXT_BC = 176;
    public static final int MAIN_CONTEXT_BC_CONSUMPTION = 177;
    public static final int MAIN_CONTEXT_BC_OVERVIEW = 179;
    public static final int MAIN_CONTEXT_FAS = 181;
    public static final int MAIN_CONTEXT_LAPTIMER_RACE_MODE = 182;
    public static final int MAIN_CONTEXT_ADDITIONAL_SPORT_INFO = 183;
    public static final int MAIN_CONTEXT_NIGHT_VISION = 184;
    public static final int MAIN_CONTEXT_SLEEP_SCREEN = 185;
    public static final int MAIN_CONTEXT_TRAFFIC_SIGN_DISPLAY = 186;
    public static final int MAIN_CONTEXT_WELCOME = 192;
    public static final int MAIN_CONTEXT_GOODBYE = 193;
    public static final int MAIN_CONTEXT_COMBI_DEVELOPMENT_1 = 237;
    public static final int MAIN_CONTEXT_COMBI_DEVELOPMENT_2 = 239;
    public static final int MAIN_CONTEXT_COMBI_WARNING_1 = 240;
    public static final int MAIN_CONTEXT_COMBI_WARNING_2 = 241;
    public static final int MAIN_CONTEXT_COMBI_WARNING_3 = 242;
    public static final int MAIN_CONTEXT_COMBI_WARNING_4 = 243;
    public static final int MAIN_CONTEXT_COMBI_WARNING_5 = 244;
    public static final int MAIN_CONTEXT_COMBI_WARNING_6 = 245;
    public static final int MAIN_CONTEXT_COMBI_WARNING_7 = 246;
    public static final int MAIN_CONTEXT_COMBI_WARNING_8 = 247;
    public static final int MAIN_CONTEXT_COMBI_WARNING_9 = 248;
    public static final int MAIN_CONTEXT_COMBI_HISTORY = 254;
    public static final int MAIN_CONTEXT_MMI_OFF = 255;
    public static final int POPUP_CONTEXT_NONE = 0;
    public static final int POPUP_CONTEXT_COMBI = 1;
    private int focus;
    private int mainContext;
    private int popupContext;
    private int viewSize;
    private int viewSizeUserRequest;
    private boolean kombiReasonForLargeViewSizeActive;
    private boolean leftDrawerOpen;
    private boolean rightDrawerOpen;
    private boolean secondStatusLineVisible;
    private boolean partialPopupVisible;

    public MMICombiDisplayStatus() {
        this(1, 176, 0, 1, 1, false, false, false, false, false);
    }

    public MMICombiDisplayStatus(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this(n, n2, n3, n4, n4, false, bl, bl2, bl3, bl4);
    }

    public MMICombiDisplayStatus(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.focus = n;
        this.mainContext = n2;
        this.popupContext = n3;
        this.viewSize = n4;
        this.viewSizeUserRequest = n5;
        this.kombiReasonForLargeViewSizeActive = bl;
        this.leftDrawerOpen = bl2;
        this.rightDrawerOpen = bl3;
        this.partialPopupVisible = bl4;
        this.secondStatusLineVisible = bl5;
    }

    public void setFocus(int n) {
        this.focus = n;
    }

    public int getFocus() {
        return this.focus;
    }

    public void setMainContext(int n) {
        this.mainContext = n;
    }

    public int getMainContext() {
        return this.mainContext;
    }

    public void setViewSize(int n) {
        this.viewSize = n;
    }

    public int getViewSize() {
        return this.viewSize;
    }

    public void setViewSizeUserRequest(int n) {
        this.viewSizeUserRequest = n;
    }

    public int getViewSizeUserRequest() {
        return this.viewSizeUserRequest;
    }

    public void setLeftDrawerOpen(boolean bl) {
        this.leftDrawerOpen = bl;
    }

    public boolean isLeftDrawerOpen() {
        return this.leftDrawerOpen;
    }

    public void setRightDrawerOpen(boolean bl) {
        this.rightDrawerOpen = bl;
    }

    public boolean isRightDrawerOpen() {
        return this.rightDrawerOpen;
    }

    public void setPartialPopupVisible(boolean bl) {
        this.partialPopupVisible = bl;
    }

    public boolean isPartialPopupVisible() {
        return this.partialPopupVisible;
    }

    public void setSecondStatusLineVisible(boolean bl) {
        this.secondStatusLineVisible = bl;
    }

    public boolean isSecondStatusLineVisible() {
        return this.secondStatusLineVisible;
    }

    public void setPopupContext(int n) {
        this.popupContext = n;
    }

    public int getPopupContext() {
        return this.popupContext;
    }

    public static String getViewSizeDescription(int n) {
        switch (n) {
            case 1: {
                return "SMALL";
            }
            case 2: {
                return "LARGE";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INVALID (");
        stringBuffer.append(n);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String getFocusDescription(int n) {
        switch (n) {
            case 2: {
                return "FOCUS_HMI";
            }
            case 1: {
                return "FOCUS_COMBI";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INVALID (");
        stringBuffer.append(n);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String getContextDescription(int n) {
        switch (n) {
            case 0: {
                return "CONTEXT_NONE";
            }
            case 16: {
                return "CONTEXT_NAVIGATION";
            }
            case 20: {
                return "CONTEXT_NAVIGATION_MAP";
            }
            case 22: {
                return "CONTEXT_NAVIGATION_DEST";
            }
            case 32: {
                return "CONTEXT_AUDIO_GENERAL";
            }
            case 36: {
                return "CONTEXT_TUNER";
            }
            case 39: {
                return "CONTEXT_MEDIA";
            }
            case 48: {
                return "CONTEXT_PHONE";
            }
            case 62: {
                return "CONTEXT_BCALL";
            }
            case 63: {
                return "CONTEXT_CCALL";
            }
            case 74: {
                return "CONTEXT_GEM";
            }
            case 75: {
                return "CONTEXT_SWDL";
            }
            case 80: {
                return "CONTEXT_TONE";
            }
            case 81: {
                return "CONTEXT_SETUP";
            }
            case 96: {
                return "CONTEXT_APPS";
            }
            case 112: {
                return "CONTEXT_CONNECT";
            }
            case 113: {
                return "CONTEXT_OFFICE";
            }
            case 114: {
                return "CONTEXT_CONNECTIVITY_MANAGER";
            }
            case 115: {
                return "CONTEXT_VICS";
            }
            case 116: {
                return "CONTEXT_TPEG";
            }
            case 117: {
                return "CONTEXT_SMARTPHONE_CARPLAY";
            }
            case 118: {
                return "CONTEXT_SMARTPHONE_GOOGLE_PLAY";
            }
            case 128: {
                return "CONTEXT_CAR";
            }
            case 129: {
                return "CONTEXT_CAR_360_VIEWER";
            }
            case 130: {
                return "CONTEXT_CAR_FAVORITEN";
            }
            case 131: {
                return "CONTEXT_CAR_DRIVER_ASSISTANCE";
            }
            case 132: {
                return "CONTEXT_CAR_SETTINGS";
            }
            case 133: {
                return "CONTEXT_CAR_CLIMATE";
            }
            case 134: {
                return "CONTEXT_AUXILIARY_HEATING";
            }
            case 135: {
                return "CONTEXT_SERVICE_CONTROL";
            }
            case 136: {
                return "DRIVE_SELECT";
            }
            case 137: {
                return "CONTEXT_LOADING";
            }
            case 138: {
                return "RVC";
            }
            case 139: {
                return "BOARDBOOK";
            }
            case 140: {
                return "CONTEXT_ETC";
            }
            case 161: {
                return "CONTEXT_COMBI_MESSAGE_1";
            }
            case 162: {
                return "CONTEXT_COMBI_MESSAGE_2";
            }
            case 163: {
                return "CONTEXT_COMBI_MESSAGE_3";
            }
            case 164: {
                return "CONTEXT_COMBI_MESSAGE_4";
            }
            case 165: {
                return "CONTEXT_COMBI_MESSAGE_5";
            }
            case 166: {
                return "CONTEXT_COMBI_MESSAGE_6";
            }
            case 167: {
                return "CONTEXT_COMBI_MESSAGE_7";
            }
            case 168: {
                return "CONTEXT_COMBI_MESSAGE_8";
            }
            case 174: {
                return "CONTEXT_DESIGN_SKIN_CHANGE";
            }
            case 175: {
                return "CONTEXT_COMBI_MAIN_MENU";
            }
            case 176: {
                return "CONTEXT_BC";
            }
            case 177: {
                return "CONTEXT_BC_CONSUMPTION";
            }
            case 179: {
                return "CONTEXT_BC_OVERVIEW";
            }
            case 181: {
                return "FAS";
            }
            case 182: {
                return "CONTEXT_LAPTIMER_RACE_MODE";
            }
            case 183: {
                return "CONTEXT_ADDITIONAL_SPORT_INFO";
            }
            case 184: {
                return "CONTEXT_NIGHT_VISION";
            }
            case 185: {
                return "CONTEXT_SLEEP_SCREEN";
            }
            case 186: {
                return "CONTEXT_TRAFFIC_SIGN_DISPLAY";
            }
            case 192: {
                return "CONTEXT_WELCOME";
            }
            case 193: {
                return "CONTEXT_GOODBYE";
            }
            case 237: {
                return "CONTEXT_COMBI_DEVELOPMENT_1";
            }
            case 239: {
                return "CONTEXT_COMBI_DEVELOPMENT_2";
            }
            case 240: {
                return "CONTEXT_COMBI_WARNING_1";
            }
            case 241: {
                return "CONTEXT_COMBI_WARNING_2";
            }
            case 242: {
                return "CONTEXT_COMBI_WARNING_3";
            }
            case 243: {
                return "CONTEXT_COMBI_WARNING_4";
            }
            case 244: {
                return "CONTEXT_COMBI_WARNING_5";
            }
            case 245: {
                return "CONTEXT_COMBI_WARNING_6";
            }
            case 246: {
                return "CONTEXT_COMBI_WARNING_7";
            }
            case 247: {
                return "CONTEXT_COMBI_WARNING_8";
            }
            case 248: {
                return "CONTEXT_COMBI_WARNING_9";
            }
            case 254: {
                return "CONTEXT_COMBI_HISTORY";
            }
            case 255: {
                return "CONTEXT_MMI_OFF";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UNKNOWN CONTEXT (");
        stringBuffer.append(n);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String getPopupContextDescription(int n) {
        switch (n) {
            case 0: {
                return "NONE";
            }
            case 1: {
                return "COMBI";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UNKNOWN POPUP_CONTEXT (");
        stringBuffer.append(n);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("MMICombiDisplayStatus {");
        buffer.append("\nfocus=").append(MMICombiDisplayStatus.getFocusDescription(this.focus));
        buffer.append("\nmainContext=").append(MMICombiDisplayStatus.getContextDescription(this.mainContext));
        buffer.append("\npopupContext=").append(MMICombiDisplayStatus.getPopupContextDescription(this.popupContext));
        buffer.append("\nviewSize=").append(MMICombiDisplayStatus.getViewSizeDescription(this.viewSize));
        buffer.append("\nviewSizeUserRequest=").append(MMICombiDisplayStatus.getViewSizeDescription(this.viewSizeUserRequest));
        buffer.append("\nleftDrawerOpen=").append(this.leftDrawerOpen);
        buffer.append("\nrightDrawerOpen=").append(this.rightDrawerOpen);
        buffer.append("\npartialPopupVisible=").append(this.partialPopupVisible);
        buffer.append("\nsecondStatusLineVisible=").append(this.secondStatusLineVisible);
        buffer.append('}');
        return buffer.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return new MMICombiDisplayStatus(this.focus, this.mainContext, this.popupContext, this.viewSize, this.viewSizeUserRequest, this.kombiReasonForLargeViewSizeActive, this.leftDrawerOpen, this.rightDrawerOpen, this.partialPopupVisible, this.secondStatusLineVisible);
    }

    public boolean equals(Object object) {
        if (object instanceof MMICombiDisplayStatus) {
            MMICombiDisplayStatus mMICombiDisplayStatus = (MMICombiDisplayStatus)object;
            return this.focus == mMICombiDisplayStatus.getFocus() && this.mainContext == mMICombiDisplayStatus.getMainContext() && this.popupContext == mMICombiDisplayStatus.getPopupContext() && (this.viewSize == mMICombiDisplayStatus.getViewSize() || mMICombiDisplayStatus.getViewSize() == 0) && this.viewSizeUserRequest == mMICombiDisplayStatus.getViewSizeUserRequest() && this.kombiReasonForLargeViewSizeActive == mMICombiDisplayStatus.isKombiReasonForLargeViewSizeActive() && this.leftDrawerOpen == mMICombiDisplayStatus.isLeftDrawerOpen() && this.rightDrawerOpen == mMICombiDisplayStatus.isRightDrawerOpen() && this.partialPopupVisible == mMICombiDisplayStatus.isPartialPopupVisible() && this.secondStatusLineVisible == mMICombiDisplayStatus.isSecondStatusLineVisible();
        }
        return false;
    }

    public int hashCode() {
        int n = 11;
        int n2 = 29;
        n = n * n2 + this.focus;
        n = n * n2 + this.mainContext;
        n = n * n2 + this.popupContext;
        n = n * n2 + this.viewSize;
        n = n * n2 + this.viewSizeUserRequest;
        n = n * n2 + (this.kombiReasonForLargeViewSizeActive ? 0 : 1);
        n = n * n2 + (this.leftDrawerOpen ? 0 : 1);
        n = n * n2 + (this.rightDrawerOpen ? 0 : 1);
        n = n * n2 + (this.partialPopupVisible ? 0 : 1);
        n = n * n2 + (this.secondStatusLineVisible ? 0 : 1);
        return n;
    }

    public boolean isKombiReasonForLargeViewSizeActive() {
        return this.kombiReasonForLargeViewSizeActive;
    }
}

