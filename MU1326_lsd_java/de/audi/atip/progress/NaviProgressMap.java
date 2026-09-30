/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

import de.audi.atip.progress.AbstractProgressMap;

public class NaviProgressMap
extends AbstractProgressMap {
    public static final int TASK_NAV_APP_STARTED = 0;
    public static final int TASK_NAV_DSI_REGISTERED = 1;
    public static final int TASK_NAV_FULLY_OP = 2;
    public static final int TASK_NAV_ATTR_READY = 3;
    public static final int TASK_NAV_ROUTEHANDLING_DONE = 4;
    public static final int TASK_MAP_READY = 5;
    public static final int TASK_MAP_ATTR_READY = 6;
    public static final int TASK_MAP_FIRST_DRAW = 7;
    public static final int TASK_NAV_INIT_DONE = 8;
    private static final String[] NAV_PROGRESS_TASK_NAMES = new String[]{"TASK_NAV_APP_STARTED", "TASK_NAV_DSI_REGISTERED", "TASK_NAV_FULLY_OP", "TASK_NAV_ATTR_READY", "TASK_NAV_ROUTEHANDLING_DONE", "TASK_MAP_READY", "TASK_MAP_ATTR_READY", "TASK_MAP_FIRST_DRAW", "TASK_NAV_INIT_DONE"};

    public NaviProgressMap() {
        super(NAV_PROGRESS_TASK_NAMES);
    }

    public static String taskName(int n) {
        if (0 <= n && n < NAV_PROGRESS_TASK_NAMES.length) {
            return NAV_PROGRESS_TASK_NAMES[n];
        }
        return "UNKNOWN_TASK";
    }
}

