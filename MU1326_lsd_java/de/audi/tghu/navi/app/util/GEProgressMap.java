/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.progress.AbstractProgressMap;

public class GEProgressMap
extends AbstractProgressMap {
    public static final int TASK_GE_DSI_REGISTERED = 0;
    public static final int TASK_GE_OPERABLE = 1;
    public static final int TASK_GE_ACTIVE_RENDERER = 2;
    public static final int TASK_GE_RENDERER_RECOMMENDED = 3;
    private static final String[] GE_TASK_NAMES = new String[]{"TASK_GE_DSI_REGISTERED", "TASK_GE_OPERABLE", "TASK_GE_ACTIVE_RENDERER", "TASK_GE_RENDERER_RECOMMENDED"};

    public GEProgressMap() {
        super(GE_TASK_NAMES);
    }

    public static String taskName(int n) {
        if (0 <= n && n < GE_TASK_NAMES.length) {
            return GE_TASK_NAMES[n];
        }
        return "UNKNOWN_TASK";
    }
}

