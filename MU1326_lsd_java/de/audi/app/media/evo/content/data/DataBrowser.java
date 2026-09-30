/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IDataBrowserLastSelectionHandler;
import de.audi.app.media.dsi.media.IMediaDSIBrowserController;
import de.audi.app.media.evo.content.IImplicitRepeatHandler;
import de.audi.app.media.evo.content.data.DataBrowserCategoryList;
import de.audi.app.media.evo.content.data.DataBrowserList;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.search.DataTruffleSearchController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.esolutions.fw.util.commons.Buffer;

public class DataBrowser
extends AbstractMediaBrowser {
    private static final String LOGCLASS = "DataBrowser";
    private final DataBrowserList dataBrowserList;
    private final DataTruffleSearchController searchController;
    private final DataBrowserCategoryList categoryList;

    public DataBrowser(IMediaTerminal iMediaTerminal, IContent iContent, DataPlayer dataPlayer, IMediaDSIBrowserController iMediaDSIBrowserController, IFavoritesController iFavoritesController, IImplicitRepeatHandler iImplicitRepeatHandler, IDataBrowserLastSelectionHandler iDataBrowserLastSelectionHandler) {
        super(iMediaTerminal.getLogger().main(), iMediaTerminal.getLogger().dsi(), iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), 0, iMediaTerminal.getSourceController());
        this.dataBrowserList = new DataBrowserList(iMediaTerminal, dataPlayer, iImplicitRepeatHandler, iDataBrowserLastSelectionHandler);
        this.searchController = !iMediaTerminal.getFramework().isEvoStd() ? new DataTruffleSearchController(iMediaTerminal, this.dataBrowserList, iFavoritesController.getFavoriteBrowserList()) : null;
        this.categoryList = new DataBrowserCategoryList(iMediaTerminal, this.dataBrowserList, iFavoritesController, iDataBrowserLastSelectionHandler, dataPlayer);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.dataBrowserList.init();
        if (this.searchController != null) {
            this.searchController.init();
        }
        this.categoryList.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
        this.categoryList.deinit();
        this.dataBrowserList.deinit();
        if (this.searchController != null) {
            this.searchController.deinit();
        }
    }

    public void activate(ISourceSlot iSourceSlot) {
        MediaCapabilities mediaCapabilities = iSourceSlot.getCapabilities();
        if (mediaCapabilities.isListHandling()) {
            this.logger.log(1000000, "[%1.activate] Browser list supported.", (Object)LOGCLASS);
            super.activate(iSourceSlot);
            if (mediaCapabilities.isContentBrowsing() && this.searchController != null && mediaCapabilities.isSearch()) {
                this.logger.log(1000000, "[%1.activate] Search supported.", (Object)LOGCLASS);
                this.searchController.activate(iSourceSlot);
            } else {
                this.logger.log(1000000, "[%1.activate] No search supported.", (Object)LOGCLASS);
            }
            this.categoryList.activate(iSourceSlot);
            return;
        }
        this.logger.log(1000000, "[%1.activate] No browse list supported.", (Object)LOGCLASS);
    }

    public void setRestoreLastSelectionPossible(boolean bl) {
        this.dataBrowserList.setRestoreLastSelectionPossible(bl);
    }

    public void update(byte by, ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.update]", (Object)LOGCLASS);
        MediaCapabilities mediaCapabilities = iSourceSlot.getCapabilities();
        if (1 == by || 2 == by) {
            this.logger.log(1000000, "[%1.update] Browser list supported.", (Object)LOGCLASS);
            super.activate(iSourceSlot);
            if (mediaCapabilities.isContentBrowsing() && this.searchController != null && mediaCapabilities.isSearch()) {
                this.logger.log(1000000, "[%1.update] Search supported.", (Object)LOGCLASS);
                this.searchController.activate(iSourceSlot);
            } else {
                this.logger.log(1000000, "[%1.update] No search supported.", (Object)LOGCLASS);
            }
            this.categoryList.activate(iSourceSlot);
            return;
        }
        if (3 == by) {
            if (this.searchController != null && mediaCapabilities.isSearch()) {
                this.logger.log(1000000, "[%1.update] Search supported.", (Object)LOGCLASS);
                this.searchController.activate(iSourceSlot);
            } else {
                this.logger.log(1000000, "[%1.update] No search supported.", (Object)LOGCLASS);
            }
            this.categoryList.activate(iSourceSlot);
            return;
        }
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        super.deactivate();
    }

    protected void browserActivated(IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.browserActivated]", (Object)LOGCLASS);
        this.dataBrowserList.activate(iBrowseListContext);
    }

    protected void browserDeactivated(ISourceSlot iSourceSlot, boolean bl) {
        this.logger.log(1000000, "[%1.browserDeactivated]", (Object)LOGCLASS);
        if (this.searchController != null) {
            this.searchController.deactivate();
        }
        this.dataBrowserList.deactivate();
        if (!bl) {
            this.categoryList.deactivate();
        }
    }

    protected void diagResetBrowser() {
        super.diagResetBrowser();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

