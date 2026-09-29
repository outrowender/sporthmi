/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.AbstractMediaPlayerListener;
import de.audi.atip.log.LogChannel;

public class NullMediaPlayerListener
extends AbstractMediaPlayerListener {
    public NullMediaPlayerListener(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public String getLogClass() {
        return "NullMediaPlayerListener";
    }
}

