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

    public String getName() {
        return "SELECT_PATH";
    }

    public void start() {
        this.getDataBrowserList().startBrowseListPathSelection(this.path);
    }

    public void browsePathSelectionFinished() {
        this.getExecutionContext().jobFinished();
    }
}

