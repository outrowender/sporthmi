/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.event;

public class Event {
    public final int eventId;
    public final String description;

    public Event(int n, String string) {
        this.eventId = n;
        this.description = string;
    }

    public static interface RC {
        public static final int FoundFirstMatchedRoute = 200;
        public static final int FoundAllMatchedRoutes = 201;
        public static final int CalculationFailed = 202;
        public static final int AutoStartTimerFired = 203;
        public static final int RubberbandPrepared = 204;
        public static final int RubberbandStarting = 205;
        public static final int RubberbandReady = 206;
        public static final int RubberbandCanceled = 207;
        public static final int RubberbandPointChanged = 208;
        public static final int RubberbandPointUpdateTimeout = 209;
        public static final int RubberbandPointWaitingForUpdate = 210;
        public static final int CalculationAborted = 211;
        public static final int RouteGuidanceStarted = 212;
    }

    public static interface Map {
        public static final int EnterMapScreen = 100;
        public static final int ExitMapScreen = 101;
        public static final int EnterContext = 102;
        public static final int ExitContext = 103;
        public static final int ManoeverZoomStateChange = 104;
        public static final int ShowTrafficMiniMap = 105;
        public static final int HideTrafficMiniMap = 106;
        public static final int ManoeverZoomStateChangeKombi = 107;
    }

    public static interface UserAction {
        public static final int HK_Back = 300;
        public static final int HK_DDS = 301;
        public static final int CenterToCCP = 302;
        public static final int SwitchOn3D = 303;
    }
}

