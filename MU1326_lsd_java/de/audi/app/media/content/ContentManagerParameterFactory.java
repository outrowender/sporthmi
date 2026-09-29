/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.NowPlayingScreenController;

public class ContentManagerParameterFactory {
    public NowPlayingScreenController createNowPlayingScreenController(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        return new NowPlayingScreenController(iFrameworkAccess, logChannel);
    }

    public CopyOnWriteArrayList createCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList();
    }
}

