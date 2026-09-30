/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;

public class LW {
    private static HMIModelApp model = null;
    private static LogChannel logger = null;
    private static boolean autoClear = true;

    public static void setLogWidget(HMIModelApp hMIModelApp) {
        model = hMIModelApp;
    }

    public static void setLogChannel(LogChannel logChannel) {
        logger = logChannel;
    }

    public static void setAutoClear(boolean bl) {
        autoClear = bl;
    }

    public static void log(String string) {
        if (model != null && model instanceof LabelModelApp) {
            LabelModelApp labelModelApp = (LabelModelApp)model;
            if (autoClear) {
                labelModelApp.setText(string);
            } else {
                String string2 = labelModelApp.getText() != null ? labelModelApp.getText() + "\n" : string;
                labelModelApp.setText(string2);
            }
            return;
        }
        if (logger != null) {
            logger.log(10000000, "LW#log() - %1", (Object)string);
        }
    }

    public static void clear() {
        if (model != null && model instanceof LabelModelApp) {
            ((LabelModelApp)model).setText("");
            return;
        }
    }
}

