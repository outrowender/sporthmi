/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.evo.content.data.AbstractDataBrowseListJob;
import de.audi.app.media.evo.content.data.DataBrowserList;
import de.audi.atip.log.LogChannel;

public class DataBrowserListJobDefault
extends AbstractDataBrowseListJob {
    public DataBrowserListJobDefault(LogChannel logChannel, DataBrowserList dataBrowserList) {
        super(logChannel, dataBrowserList);
    }

    public int getType() {
        return 0;
    }

    public String getName() {
        return "EMPTY";
    }

    public void abort(boolean bl) {
    }

    public void start() {
    }

    public String toString() {
        return "";
    }
}

