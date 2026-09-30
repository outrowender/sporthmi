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
    private static final String LOGCLASS = "DataBrowserLastSelectionHandler";

    public DataBrowserLastSelectionHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void init() {
        this.logger.hmi().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION", 0, 12, 1);
        this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION");
    }

    public void deinit() {
        this.logger.hmi().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    public void setLastCategorySelection(int n) {
        this.logger.hmi().log(1000000, "[%1.setLastCategorySelection]", (Object)LOGCLASS);
        this.getChoiceModel(200616).setValue(n);
        this.getTerminal().getMediaPersistence().setGlobalIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION", n);
    }

    public int getLastCategorySelection() {
        this.logger.hmi().log(1000000, "[%1.getLastCategorySelection]", (Object)LOGCLASS);
        return this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_BROWSER_LAST_SELECTION");
    }

    public void setSelectedCategory(int n) {
        this.logger.hmi().log(1000000, "[%1.setSelectedCategory] pCategory: '%2'.", (Object)LOGCLASS, (long)n);
        this.getChoiceModel(200628).setValue(n);
        this.getBaseListModel(200597).setSelectedUniqueID(n);
        this.getBaseListModel(200597).fireEvent(this.getTerminal().getTerminalID());
    }
}

