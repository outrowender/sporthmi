/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.evo.content.data.AbstractDataBrowseListJob;
import de.audi.app.media.evo.content.data.DataBrowserList;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.atip.log.LogChannel;

public class DataBrowserListJobSelectBrowseListPath
extends AbstractDataBrowseListJob {
    private final DataBrowserListLocator path;

    public DataBrowserListJobSelectBrowseListPath(LogChannel logChannel, DataBrowserList dataBrowserList, DataBrowserListLocator dataBrowserListLocator) {
        super(logChannel, dataBrowserList);
        this.path = dataBrowserListLocator;
    }

    @Override
    public String getName() {
        return "SELECT_PATH";
    }

    @Override
    public void start() {
        this.getDataBrowserList().startBrowseListPathSelection(this.path);
    }

    @Override
    public void browsePathSelectionFinished() {
        this.getExecutionContext().jobFinished();
    }
}

