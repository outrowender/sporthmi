/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.onlinemedia.IPlaytimeStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeRadioStrategy;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeSingleTrackStrategy;
import de.audi.tghu.online.app.remotehmi.util.UtilOnline;

public class PlaytimeStragegyFactory {
    public static RemoteHMIService service;

    public static IPlaytimeStrategy createRadioPlaytimeStrategy(LogChannel logChannel) {
        if (logChannel == null) {
            UtilOnline.validateArgumentNotNull(logChannel, "log");
        }
        return new PlaytimeRadioStrategy(logChannel, service);
    }

    public static IPlaytimeStrategy createSingleTrackPlaytimeStrategy(LogChannel logChannel) {
        if (logChannel == null) {
            UtilOnline.validateArgumentNotNull(logChannel, "log");
        }
        if (service == null) {
            logChannel.log(10000, "PlaytimeStragegyFactory#createSingleTrackPlaytimeStrategy() no rhmiService added!");
            return null;
        }
        return new PlaytimeSingleTrackStrategy(logChannel, service);
    }
}

