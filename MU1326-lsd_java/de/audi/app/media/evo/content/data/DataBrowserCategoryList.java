/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.IDataBrowserLastSelectionHandler;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserCategoryList$1;
import de.audi.app.media.evo.content.data.DataBrowserCategoryList$2;
import de.audi.app.media.evo.content.data.DataBrowserCategoryListRow;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.IDataBrowserList;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;
import de.audi.app.media.evo.content.data.favorites.FavoritesList;
import de.audi.app.media.evo.content.data.favorites.IFavoritesController;
import de.audi.app.media.evo.content.data.favorites.IMediaFavoriteListListener;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.selection.DataSelectionByCategoryJob;
import de.audi.app.media.selection.DataSelectionContainer;
import de.audi.app.media.selection.IDataSelectionContext;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Map;

public class DataBrowserCategoryList
extends AbstractMediaTerminalComponent
implements BaseListModelListener,
IActionProxyListener,
IDataBrowserListChangeListener,
IMediaFavoriteListListener,
ISelectionListener {
    private static final String LOGCLASS;
    private static final int NO_SELECTION;
    private final BaseListModelApp categoryListModel = this.getBaseListModel(-1794178304);
    private final IDataBrowserList browserList;
    private final IFavoritesController favoritesController;
    private volatile boolean favoritesAvailable;
    private final IDataBrowserLastSelectionHandler lastSelectionHandler;
    private boolean hasArtistPath = false;
    private final IPlayer player;

    public DataBrowserCategoryList(IMediaTerminal iMediaTerminal, IDataBrowserList iDataBrowserList, IFavoritesController iFavoritesController, IDataBrowserLastSelectionHandler iDataBrowserLastSelectionHandler, IPlayer iPlayer) {
        super(iMediaTerminal);
        this.browserList = iDataBrowserList;
        this.favoritesAvailable = false;
        this.favoritesController = iFavoritesController;
        this.lastSelectionHandler = iDataBrowserLastSelectionHandler;
        this.player = iPlayer;
    }

    public void init() {
        this.logger.hmi().log(1078071040, "[%1.init]", (Object)"DataBrowserCategoryList");
        this.browserList.addBrowseListChangeListener(this);
        this.favoritesController.addFavoriteListListener(this);
    }

    public void deinit() {
        this.logger.hmi().log(1078071040, "[%1.deinit]", (Object)"DataBrowserCategoryList");
        this.browserList.removeBrowseListChangeListener(this);
        this.categoryListModel.removeAll();
        this.favoritesController.removeFavoriteListListener(this);
    }

    public void activate(ISourceSlot iSourceSlot) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"DataBrowserCategoryList");
        this.categoryListModel.setListener(this);
        this.getTerminal().addActionProxyListener(new int[]{32}, (IActionProxyListener)this);
        this.setCategoryList(iSourceSlot);
    }

    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"DataBrowserCategoryList");
        this.categoryListModel.setListener(null);
        this.getTerminal().removeActionProxyListener(this);
        this.setCategoryList(null);
        this.favoritesAvailable = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCategoryList(ISourceSlot iSourceSlot) {
        Object object;
        this.logger.hmi().log(1078071040, "[%1.setCategoryList] '%2'", (Object)"DataBrowserCategoryList", (Object)iSourceSlot);
        this.hasArtistPath = false;
        ArrayList arrayList = new ArrayList();
        if (iSourceSlot != null) {
            object = iSourceSlot.getCapabilities();
            if (iSourceSlot.getMediaType() == 24) {
                if (((MediaCapabilities)object).isListHandling()) {
                    arrayList.add(DataBrowserCategoryListRow.create(4));
                    arrayList.add(DataBrowserCategoryListRow.create(3));
                    arrayList.add(DataBrowserCategoryListRow.create(5));
                    arrayList.add(DataBrowserCategoryListRow.create(2));
                    arrayList.add(DataBrowserCategoryListRow.create(6));
                    arrayList.add(DataBrowserCategoryListRow.create(10));
                    arrayList.add(DataBrowserCategoryListRow.create(8));
                    arrayList.add(DataBrowserCategoryListRow.create(9));
                    if (this.getTerminal().getConfiguration().isIAP2Supported()) {
                        this.logger.hmi().log(1078071040, "[%1.setCategoryList] iTunes radio is 'ENABLED'.", (Object)"DataBrowserCategoryList", (Object)iSourceSlot);
                        arrayList.add(DataBrowserCategoryListRow.create(12));
                    } else {
                        this.logger.hmi().log(1078071040, "[%1.setCategoryList] iTunes radio is 'DISABLED'.", (Object)"DataBrowserCategoryList", (Object)iSourceSlot);
                    }
                    this.hasArtistPath = true;
                    if (((MediaCapabilities)object).isVideo()) {
                        arrayList.add(DataBrowserCategoryListRow.create(7));
                    }
                }
            } else {
                if (((MediaCapabilities)object).isContentBrowsing()) {
                    if (this.favoritesAvailable) {
                        arrayList.add(DataBrowserCategoryListRow.create(11));
                    }
                    arrayList.add(DataBrowserCategoryListRow.create(4));
                    arrayList.add(DataBrowserCategoryListRow.create(3));
                    arrayList.add(DataBrowserCategoryListRow.create(5));
                    arrayList.add(DataBrowserCategoryListRow.create(2));
                    this.hasArtistPath = true;
                }
                if (((MediaCapabilities)object).isRawBrowsing()) {
                    arrayList.add(DataBrowserCategoryListRow.create(1));
                }
                if (((MediaCapabilities)object).isContentBrowsing()) {
                    arrayList.add(DataBrowserCategoryListRow.create(6));
                    if (((MediaCapabilities)object).isVideo()) {
                        arrayList.add(DataBrowserCategoryListRow.create(7));
                    }
                }
            }
        }
        if (arrayList.isEmpty() && this.categoryListModel.getLength() == 0) {
            return;
        }
        object = this.categoryListModel.getCopy();
        try {
            object.removeAll();
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                DataBrowserCategoryListRow dataBrowserCategoryListRow = (DataBrowserCategoryListRow)arrayList.get(i2);
                object.append(dataBrowserCategoryListRow);
            }
            object.setSelectedIndex(-1);
        }
        finally {
            this.categoryListModel.update((BaseListModelApp)object);
        }
        if (object.getLength() == 1) {
            this.logger.hmi().log(1078071040, "[%1.setCategoryList] only one entry in list", (Object)"DataBrowserCategoryList");
            this.categoryListModel.setSelectedIndex(0);
            this.setActiveCategory((int)this.categoryListModel.getRow(0).getUniqueID());
        } else {
            this.setActiveCategory(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addCategoryBefore(int n, int n2) {
        if (this.categoryListModel.getLength() == 0) {
            return;
        }
        BaseListModelApp baseListModelApp = this.categoryListModel.getCopy();
        SelectedItem selectedItem = baseListModelApp.getSelected();
        try {
            baseListModelApp.insertBefore((long)n2, DataBrowserCategoryListRow.create(11));
            if (selectedItem != null) {
                baseListModelApp.setSelectedUniqueID(selectedItem.getUniqueID());
            } else {
                baseListModelApp.setSelectedUniqueID(-1L);
            }
        }
        finally {
            this.categoryListModel.update(baseListModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeCategory(int n) {
        if (this.categoryListModel.getLength() == 0) {
            return;
        }
        BaseListModelApp baseListModelApp = this.categoryListModel.getCopy();
        SelectedItem selectedItem = baseListModelApp.getSelected();
        try {
            int n2 = baseListModelApp.getIndexForUniqueID(n);
            EvoListRow evoListRow = baseListModelApp.getRow(n2);
            baseListModelApp.remove(evoListRow);
            if (selectedItem != null) {
                if (selectedItem.getUniqueID() == (long)n) {
                    int n3 = this.hasArtistPath ? 4 : 1;
                    this.setActiveCategory(n3);
                    this.lastSelectionHandler.setLastCategorySelection(n3);
                    return;
                }
                baseListModelApp.setSelectedUniqueID(selectedItem.getUniqueID());
            }
        }
        finally {
            this.categoryListModel.update(baseListModelApp);
            this.categoryListModel.trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    private void setActiveCategory(int n) {
        this.logger.hmi().log(1078071040, "[%1.setActiveCategory] '%2'", (Object)"DataBrowserCategoryList", (Object)DataBrowserListLocator.categoryID2Str(n));
        this.getChoiceModel(-1274084608).setValue(n);
    }

    private void setSelectedCategory(int n) {
        this.logger.hmi().log(1078071040, "[%1.setSelectedCategory] '%2'", (Object)"DataBrowserCategoryList", (Object)DataBrowserListLocator.categoryID2Str(n));
        if (n != 0) {
            if (this.categoryListModel.setSelectedUniqueID(n)) {
                this.setActiveCategory(n);
            } else if (this.categoryListModel.getLength() == 1) {
                this.logger.hmi().log(1078071040, "[%1.setSelectedCategory] only one entry in list", (Object)"DataBrowserCategoryList");
                this.categoryListModel.setSelectedIndex(0);
                this.setActiveCategory((int)this.categoryListModel.getRow(0).getUniqueID());
            } else {
                this.setActiveCategory(0);
            }
        } else {
            this.categoryListModel.setSelectedIndex(-1);
        }
    }

    @Override
    public void browseListCategorySelected(int n) {
        this.logger.hmi().log(1078071040, "[%1.browseListCategoryChanged] ", (Object)"DataBrowserCategoryList");
        this.setSelectedCategory(n);
    }

    @Override
    public void lastBrowseListCategoryChanged(int n) {
        this.logger.hmi().log(1078071040, "[%1.lastBrowseListCategoryChanged] ", (Object)"DataBrowserCategoryList");
        this.setSelectedCategory(n);
    }

    @Override
    public void browseListTypeChanged(int n) {
    }

    @Override
    public void browseListLayoutChanged(int n) {
    }

    @Override
    public void listChanged(FavoritesList favoritesList) {
        super.getTerminal().getDispatcher().execute(new DataBrowserCategoryList$1(this, "[DataBrowserCategoryList.listChanged]", favoritesList));
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.logger.hmi().log(1078071040, "[%1.actionProxyCallPerformed] AP_METHOD_DATA_SET_SELECTED_LIST", (Object)"DataBrowserCategoryList");
        int n2 = (Integer)map.get("LISTTYPE");
        if (n2 == 0) {
            this.setSelectedCategory(this.getChoiceModel(-1475411200).getValue());
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (!(evoListRow instanceof DataBrowserCategoryListRow)) {
            this.logger.hmi().log(10000, "[%1.itemSelected] row != DataBrowserCategoryListRow", (Object)"DataBrowserCategoryList");
            this.getModel(n).fireEvent(n4);
            return;
        }
        if (((DataBrowserCategoryListRow)evoListRow).getCategoryID() == 2 && this.player.supportsPlaybackModeToggle()) {
            this.logger.hmi().log(1078071040, "[%1.itemSelected] CATEGORY_TITLES -> Select all tracks.", (Object)"DataBrowserCategoryList");
            this.selectAllTracks();
        }
        super.getTerminal().getDispatcher().execute(new DataBrowserCategoryList$2(this, "[DataBrowserCategoryList.itemSelected]", evoListRow, n4));
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private void selectAllTracks() {
        this.logger.hmi().log(1078071040, "[%1.selectAllTracks]", (Object)"DataBrowserCategoryList");
        MediaListEntry mediaListEntry = new MediaListEntry(0L, 1, "");
        DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(this.getTerminal().getSourceController().getSelectedSlot(), mediaListEntry, 2, new MediaListEntry[0]);
        SelectionBrowser selectionBrowser = this.getTerminal().getSelectionBrowser();
        selectionBrowser.addSelectionListener(this);
        DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.logger.main(), selectionBrowser, dataSelectionContainer, this.player);
        dataSelectionByCategoryJob.useSelectionRangeIndex = false;
        selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
    }

    @Override
    public void notifySelectionChanged(IDataSelectionContext iDataSelectionContext, boolean bl) {
        this.logger.hmi().log(bl ? 1078071040 : -1601830656, "[%1.notifySelectionChanged] Select all tracks: '%2'.", (Object)"DataBrowserCategoryList", (Object)(bl ? "SUCCESS" : "FAILED"));
        this.getTerminal().getSelectionBrowser().removeSelectionListener(this);
        if (bl) {
            this.logger.hmi().log(1078071040, "[%1.notifySelectionChanged] setSelectedCategory: 'CATEGORY_TITLES'.", (Object)"DataBrowserCategoryList");
            this.setSelectedCategory(2);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("DataBrowserCategoryList").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ IMediaLogger access$000(DataBrowserCategoryList dataBrowserCategoryList) {
        return dataBrowserCategoryList.logger;
    }

    static /* synthetic */ boolean access$100(DataBrowserCategoryList dataBrowserCategoryList) {
        return dataBrowserCategoryList.favoritesAvailable;
    }

    static /* synthetic */ boolean access$102(DataBrowserCategoryList dataBrowserCategoryList, boolean bl) {
        dataBrowserCategoryList.favoritesAvailable = bl;
        return dataBrowserCategoryList.favoritesAvailable;
    }

    static /* synthetic */ void access$200(DataBrowserCategoryList dataBrowserCategoryList, int n) {
        dataBrowserCategoryList.removeCategory(n);
    }

    static /* synthetic */ void access$300(DataBrowserCategoryList dataBrowserCategoryList, int n, int n2) {
        dataBrowserCategoryList.addCategoryBefore(n, n2);
    }

    static /* synthetic */ IMediaLogger access$400(DataBrowserCategoryList dataBrowserCategoryList) {
        return dataBrowserCategoryList.logger;
    }

    static /* synthetic */ void access$500(DataBrowserCategoryList dataBrowserCategoryList, int n) {
        dataBrowserCategoryList.setSelectedCategory(n);
    }

    static /* synthetic */ BaseListModelApp access$600(DataBrowserCategoryList dataBrowserCategoryList) {
        return dataBrowserCategoryList.categoryListModel;
    }
}

