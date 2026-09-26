/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.tghu.redengineering.app.LogAdapter$1;
import java.util.ArrayList;
import java.util.List;

class LogAdapter$LogChannelCategory {
    private final List channels = new ArrayList(256);

    private LogAdapter$LogChannelCategory() {
    }

    public void addChannel(String string) {
        this.channels.add(string);
    }

    public String[] getLogChannels() {
        return (String[])this.channels.toArray(new String[0]);
    }

    /* synthetic */ LogAdapter$LogChannelCategory(LogAdapter$1 logAdapter$1) {
        this();
    }
}

