/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

import de.audi.atip.progress.AbstractProgressMap;

public class NaviProgressMap
extends AbstractProgressMap {
    public static final int TASK_NAV_APP_STARTED;
    public static final int TASK_NAV_DSI_REGISTERED;
    public static final int TASK_NAV_FULLY_OP;
    public static final int TASK_NAV_ATTR_READY;
    public static final int TASK_NAV_ROUTEHANDLING_DONE;
    public static final int TASK_MAP_READY;
    public static final int TASK_MAP_ATTR_READY;
    public static final int TASK_MAP_FIRST_DRAW;
    public static final int TASK_NAV_INIT_DONE;
    private static final String[] NAV_PROGRESS_TASK_NAMES;

    public NaviProgressMap() {
        super(NAV_PROGRESS_TASK_NAMES);
    }

    public static String taskName(int n) {
        if (0 <= n && n < NAV_PROGRESS_TASK_NAMES.length) {
            return NAV_PROGRESS_TASK_NAMES[n];
        }
        return "UNKNOWN_TASK";
    }

    static {
        NAV_PROGRESS_TASK_NAMES = new String[]{"TASK_NAV_APP_STARTED", "TASK_NAV_DSI_REGISTERED", "TASK_NAV_FULLY_OP", "TASK_NAV_ATTR_READY", "TASK_NAV_ROUTEHANDLING_DONE", "TASK_MAP_READY", "TASK_MAP_ATTR_READY", "TASK_MAP_FIRST_DRAW", "TASK_NAV_INIT_DONE"};
    }
}

