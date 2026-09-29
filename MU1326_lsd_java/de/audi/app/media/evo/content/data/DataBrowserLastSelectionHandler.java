/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IDataBrowserLastSelectionHandler;

public class DataBrowserLastSelectionHandler
extends AbstractMediaTerminalComponent
implements IDataBrowserLastSelectionHandler {
    private static final String LOGCLASS;

    public DataBrowserLastSelectionHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1078071040, "[%1.init]", (Object)"DataBrowserLastSelectionHandler");
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION", 0, 12, 1);
        this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION");
    }

    public void deinit() {
        this.logger.hmi().log(1078071040, "[%1.deinit]", (Object)"DataBrowserLastSelectionHandler");
    }

    @Override
    public void setLastCategorySelection(int n) {
        this.logger.hmi().log(1078071040, "[%1.setLastCategorySelection]", (Object)"DataBrowserLastSelectionHandler");
        this.getChoiceModel(-1475411200).setValue(n);
        this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION", n);
    }

    @Override
    public int getLastCategorySelection() {
        this.logger.hmi().log(1078071040, "[%1.getLastCategorySelection]", (Object)"DataBrowserLastSelectionHandler");
        return this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION");
    }

    @Override
    public void setSelectedCategory(int n) {
        this.logger.hmi().log(1078071040, "[%1.setSelectedCategory] pCategory: '%2'.", (Object)"DataBrowserLastSelectionHandler", (long)n);
        this.getChoiceModel(-1274084608).setValue(n);
        this.getBaseListModel(-1794178304).setSelectedUniqueID(n);
        this.getBaseListModel(-1794178304).fireEvent(this.getTerminal().getTerminalID());
    }
}

