/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.content.media.data.search.IDataMediaSearch;
import de.audi.app.media.content.media.data.search.MediaSearchUtils;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.IDataBrowserList;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;
import de.audi.app.media.evo.content.data.search.AbstractSearchHandlerEvo;
import de.audi.app.media.evo.content.data.search.MediaSearchResultFormatter;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;

public class LocalSearchHandler
extends AbstractSearchHandlerEvo
implements IDataBrowserListChangeListener,
ISourceSlotListener {
    private static final String LOGCLASS;
    private final MediaSearchResultFormatter searchResultFormatter = new MediaSearchResultFormatter(this.lc, 0, 1);
    private final IDataBrowserList dataBrowserList;
    private final ChoiceModelApp searchResultSelectedModel;
    private volatile boolean syncComplete = false;
    private volatile ISourceSlot activeSlot = null;

    public LocalSearchHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, ChoiceModelApp choiceModelApp2, ResourceLocatorModelApp resourceLocatorModelApp, AbstractSearch abstractSearch, IDataBrowserList iDataBrowserList, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4) {
        super(logChannel, baseListModelApp, spellerModelApp, choiceModelApp, choiceModelApp2, new int[]{19}, abstractSearch, choiceModelApp3);
        this.dataBrowserList = iDataBrowserList;
        this.searchResultSelectedModel = choiceModelApp4;
    }

    @Override
    public void init() {
        super.init();
        this.lc.log(1078071040, "[%1.init]", (Object)"LocalSearchHandler");
        this.registryFormatter.put(new Integer(19), this.searchResultFormatter);
        this.dataBrowserList.addBrowseListChangeListener(this);
        this.setSearchResultSelected(0);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"LocalSearchHandler");
        this.dataBrowserList.removeBrowseListChangeListener(this);
        this.setSearchResultSelected(0);
        this.activeSlot = null;
    }

    public void activate(ISourceSlot iSourceSlot) {
        super.activate();
        this.activeSlot = iSourceSlot;
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"LocalSearchHandler");
        this.setSearchResultSelected(1);
        this.appSearch.addToHistory(searchResultListRow.getSearchResult());
        MediaListEntry mediaListEntry = new MediaListEntry(MediaUtils.removeEntryIdFlags(searchResultListRow.getSearchResult().getDataId()), MediaSearchUtils.getContentType(searchResultListRow.getSearchResult().getEntryType()), "");
        this.dataBrowserList.selectEntry(mediaListEntry);
        this.mdlListSearchResults.fireEvent(n);
    }

    @Override
    public void refreshQuery() {
        this.lc.log(1078071040, "[%1.refreshQuery]", (Object)"LocalSearchHandler");
        if (0 == this.searchResultSelectedModel.getValue()) {
            super.refreshQuery();
        }
    }

    @Override
    protected void setSourceDataAvailability(boolean bl) {
        super.setSourceDataAvailability(this.syncComplete);
    }

    @Override
    public void browseListTypeChanged(int n) {
        this.lc.log(1078071040, "[%1.browseListTypeChanged]", (Object)"LocalSearchHandler");
        switch (n) {
            case 2: {
                this.searchResultFormatter.setFormatterType(0);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            case 3: {
                this.searchResultFormatter.setFormatterType(2);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_ALBUM);
                break;
            }
            case 4: {
                this.searchResultFormatter.setFormatterType(1);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_ARTIST);
                break;
            }
            case 5: {
                this.searchResultFormatter.setFormatterType(3);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_GENRE);
                break;
            }
            case 7: {
                this.searchResultFormatter.setFormatterType(4);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            case 6: {
                this.searchResultFormatter.setFormatterType(5);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            case 1: {
                this.searchResultFormatter.setFormatterType(6);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            case 8: {
                this.searchResultFormatter.setFormatterType(7);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            case 9: {
                this.searchResultFormatter.setFormatterType(8);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            case 10: {
                this.searchResultFormatter.setFormatterType(9);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
                break;
            }
            default: {
                this.searchResultFormatter.setFormatterType(0);
                this.getMediaSearch().setDefaultSearchFilter(IDataMediaSearch.WORDTYPELIST_NAME);
            }
        }
    }

    @Override
    public void browseListLayoutChanged(int n) {
        this.lc.log(1078071040, "[%1.browseListLayoutChanged] %2", (Object)"LocalSearchHandler", (long)n);
        switch (n) {
            case 0: 
            case 1: {
                this.searchResultFormatter.setLayout(1);
                break;
            }
            case 2: {
                this.searchResultFormatter.setLayout(2);
                break;
            }
            case 3: {
                this.searchResultFormatter.setLayout(3);
                break;
            }
            default: {
                this.searchResultFormatter.setLayout(3);
            }
        }
    }

    @Override
    protected void searchEntered() {
        this.lc.log(1078071040, "[%1.searchEntered] reset model", (Object)"LocalSearchHandler");
        this.setSearchResultSelected(0);
    }

    @Override
    public void browseListCategorySelected(int n) {
    }

    private void setSearchResultSelected(int n) {
        this.lc.log(1078071040, "[%1.setSearchResultSelected] value=%2", (Object)"LocalSearchHandler", (long)n);
        this.searchResultSelectedModel.setValue(n);
    }

    @Override
    protected String getLogClass() {
        return "LocalSearchHandler";
    }

    @Override
    public void lastBrowseListCategoryChanged(int n) {
    }

    @Override
    public void slotsChanged(ISource iSource) {
        ISourceSlot iSourceSlot = iSource.getSlot(this.activeSlot.getIndex());
        if (iSourceSlot.isLoaded()) {
            this.syncComplete = iSourceSlot.getFlags().isMetaDataSyncComplete();
            this.lc.log(1078071040, "[%1.slotsChanged] activeSlot refreshed value=%2", (Object)"LocalSearchHandler", (Object)this.syncComplete);
            super.setSourceDataAvailability(this.syncComplete);
        } else {
            this.syncComplete = false;
        }
    }
}

