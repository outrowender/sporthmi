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

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "EMPTY";
    }

    @Override
    public void abort(boolean bl) {
    }

    @Override
    public void start() {
    }

    @Override
    public String toString() {
        return "";
    }
}

