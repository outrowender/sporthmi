/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserListElement;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.IDataBrowserList;
import de.audi.app.media.evo.content.data.IDataBrowserListChangeListener;
import de.audi.app.media.evo.content.data.search.AbstractMediaSearchResultFormatter;
import de.audi.app.media.evo.content.data.search.AbstractSearchHandlerEvo;
import de.audi.app.media.evo.content.data.search.MediaGlobalSearchResultFormatter;
import de.audi.app.media.selection.DataSelectionByCategoryJob;
import de.audi.app.media.selection.DataSelectionContainer;
import de.audi.app.media.selection.SelectionBrowser;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class BrowserGlobalSearchHandler
extends AbstractSearchHandlerEvo
implements IDataBrowserListChangeListener {
    private static final String LOGCLASS = "BrowserGlobalSearchHandler";
    private final IDataBrowserList dataBrowserList;
    private final ChoiceModelApp searchResultSelectedModel;
    private final ChoiceModelApp entryTypeOfSelectedSearchResultModel;
    private final AbstractMediaSearchResultFormatter globalSearchResultFormatter;
    private final IMediaTerminal mediaTerminal;

    public BrowserGlobalSearchHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, ChoiceModelApp choiceModelApp2, ResourceLocatorModelApp resourceLocatorModelApp, AbstractSearch abstractSearch, IDataBrowserList iDataBrowserList, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, ChoiceModelApp choiceModelApp5, IMediaTerminal iMediaTerminal) {
        super(logChannel, baseListModelApp, spellerModelApp, choiceModelApp, choiceModelApp2, new int[]{12, 13, 11, 20, 21, 22}, abstractSearch, choiceModelApp3);
        this.dataBrowserList = iDataBrowserList;
        this.searchResultSelectedModel = choiceModelApp4;
        this.entryTypeOfSelectedSearchResultModel = choiceModelApp5;
        this.globalSearchResultFormatter = new MediaGlobalSearchResultFormatter(logChannel);
        this.mediaTerminal = iMediaTerminal;
    }

    public void init() {
        super.init();
        this.lc.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.registryFormatter.put(new Integer(11), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(13), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(12), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(20), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(21), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(22), this.globalSearchResultFormatter);
        this.dataBrowserList.addBrowseListChangeListener(this);
        this.setSearchResultSelected(0);
    }

    public void deinit() {
        super.deinit();
        this.lc.log(1000000, "[%1.searchResultSelected]", (Object)LOGCLASS);
        this.dataBrowserList.removeBrowseListChangeListener(this);
        this.setSearchResultSelected(0);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(1000000, "[%1.searchResultSelected]", (Object)LOGCLASS);
        SearchResult searchResult = searchResultListRow.getSearchResult();
        this.appSearch.addToHistory(new SearchResult(searchResult.getQueryId(), 11, searchResult.getListPosition(), searchResult.getEntryType(), searchResult.getEntryFlags(), searchResult.getPoiType(), searchResult.getIconID(), searchResult.getPosition(), searchResult.getDistanceMeters(), searchResult.getDataId(), searchResult.getTokens(), searchResult.getSuggestion(), searchResult.getCountry(), searchResult.getApplicationData()));
        this.setEntryTypeOfSelectedSearchResult(searchResultListRow.getSearchResult().getEntryType());
        this.setSearchResultSelected(1);
        switch (searchResultListRow.getSearchResult().getEntryType()) {
            case 5: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(4, 2).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 13)));
                break;
            }
            case 6: {
                this.lc.log(1000000, "[%1.searchResultSelected]", (Object)LOGCLASS);
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(3, 2).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 14)));
                break;
            }
            case 7: {
                this.lc.log(1000000, "[%1.searchResultSelected]", (Object)LOGCLASS);
                ISourceSlot iSourceSlot = this.mediaTerminal.getSourceController().getSelectedSlot();
                if (this.mediaTerminal.getConfiguration().isIAP2Supported() && iSourceSlot.getMediaType() == 24) {
                    long l = searchResult.getDataId();
                    this.lc.log(1000000, "[%1.searchResultSelected] iPod with iAP2 -> play the track. entryId='%2'", (Object)LOGCLASS, l);
                    MediaListEntry mediaListEntry = new MediaListEntry(l, 1, "");
                    DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(iSourceSlot, mediaListEntry, 2, new MediaListEntry[0]);
                    SelectionBrowser selectionBrowser = this.mediaTerminal.getSelectionBrowser();
                    DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.lc, selectionBrowser, dataSelectionContainer, this.dataBrowserList.getPlayer());
                    dataSelectionByCategoryJob.useSelectionRangeIndex = true;
                    selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                    break;
                }
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(2, 2).add(DataBrowserListElement.createFocusListElement(searchResult.getDataId(), 1)));
                break;
            }
            case 11: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(7, 2).add(DataBrowserListElement.createFocusListElement(searchResult.getDataId(), 2)));
                break;
            }
            case 9: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(5, 2).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 16)));
                break;
            }
            case 10: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(6, 2).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 5)));
                break;
            }
            case 13: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(10, 2).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 17)));
                break;
            }
            case 14: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(8, 2).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 11)));
                break;
            }
        }
        this.mdlListSearchResults.fireEvent(n);
    }

    public void refreshQuery() {
        this.lc.log(1000000, "[%1.refreshQuery]", (Object)LOGCLASS);
        if (0 == this.searchResultSelectedModel.getValue()) {
            super.refreshQuery();
        }
    }

    public void browseListTypeChanged(int n) {
    }

    public void browseListLayoutChanged(int n) {
    }

    protected void searchEntered() {
        this.lc.log(1000000, "[%1.searchEntered] reset model", (Object)LOGCLASS);
        this.setSearchResultSelected(0);
    }

    public void browseListCategorySelected(int n) {
    }

    public void lastBrowseListCategoryChanged(int n) {
    }

    private void setSearchResultSelected(int n) {
        this.lc.log(1000000, "[%1.setSearchResultSelected] value=%2", (Object)LOGCLASS, (long)n);
        this.searchResultSelectedModel.setValue(n);
    }

    private void setEntryTypeOfSelectedSearchResult(int n) {
        this.lc.log(1000000, "[%1.setEntryTypeOfSelectedSearchResult] entryType='%2'", (Object)LOGCLASS, (long)n);
        this.entryTypeOfSelectedSearchResultModel.setValue(n);
    }

    protected String getLogClass() {
        return LOGCLASS;
    }
}

