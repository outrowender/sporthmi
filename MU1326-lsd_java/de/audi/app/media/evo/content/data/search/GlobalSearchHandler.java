/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataBrowserListElement;
import de.audi.app.media.evo.content.data.DataBrowserListLocator;
import de.audi.app.media.evo.content.data.IDataBrowserList;
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

public class GlobalSearchHandler
extends AbstractSearchHandlerEvo {
    private static final String LOGCLASS;
    private final AbstractMediaSearchResultFormatter globalSearchResultFormatter;
    private final IDataBrowserList dataBrowserList;
    private final ChoiceModelApp entryTypeOfSelectedSearchResultModel;
    private final IMediaTerminal mediaTerminal;

    public GlobalSearchHandler(LogChannel logChannel, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, ChoiceModelApp choiceModelApp2, ResourceLocatorModelApp resourceLocatorModelApp, AbstractSearch abstractSearch, IDataBrowserList iDataBrowserList, ChoiceModelApp choiceModelApp3, ChoiceModelApp choiceModelApp4, IMediaTerminal iMediaTerminal) {
        super(logChannel, baseListModelApp, spellerModelApp, choiceModelApp, choiceModelApp2, new int[]{12, 13, 11, 20, 21, 22}, abstractSearch, choiceModelApp3);
        this.globalSearchResultFormatter = new MediaGlobalSearchResultFormatter(logChannel);
        this.dataBrowserList = iDataBrowserList;
        this.entryTypeOfSelectedSearchResultModel = choiceModelApp4;
        this.mediaTerminal = iMediaTerminal;
    }

    @Override
    public void init() {
        this.lc.log(1078071040, "[%1.init]", (Object)"GlobalSearchHandler");
        super.init();
        this.registryFormatter.put(new Integer(11), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(13), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(12), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(20), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(21), this.globalSearchResultFormatter);
        this.registryFormatter.put(new Integer(22), this.globalSearchResultFormatter);
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"GlobalSearchHandler");
        SearchResult searchResult = searchResultListRow.getSearchResult();
        this.appSearch.addToHistory(new SearchResult(searchResult.getQueryId(), 11, searchResult.getListPosition(), searchResult.getEntryType(), searchResult.getEntryFlags(), searchResult.getPoiType(), searchResult.getIconID(), searchResult.getPosition(), searchResult.getDistanceMeters(), searchResult.getDataId(), searchResult.getTokens(), searchResult.getSuggestion(), searchResult.getCountry(), searchResult.getApplicationData()));
        this.setEntryTypeOfSelectedSearchResult(searchResultListRow.getSearchResult().getEntryType());
        switch (searchResultListRow.getSearchResult().getEntryType()) {
            case 5: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(4, 1).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 13)));
                break;
            }
            case 6: {
                this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"GlobalSearchHandler");
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(3, 1).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 14)));
                break;
            }
            case 7: {
                this.lc.log(1078071040, "[%1.searchResultSelected]", (Object)"GlobalSearchHandler");
                ISourceSlot iSourceSlot = this.mediaTerminal.getSourceController().getSelectedSlot();
                if (this.mediaTerminal.getConfiguration().isIAP2Supported() && iSourceSlot.getMediaType() == 24) {
                    long l = searchResult.getDataId();
                    this.lc.log(1078071040, "[%1.searchResultSelected] iPod with iAP2 -> play the track. entryId='%2'", (Object)"GlobalSearchHandler", l);
                    MediaListEntry mediaListEntry = new MediaListEntry(l, 1, "");
                    DataSelectionContainer dataSelectionContainer = new DataSelectionContainer(iSourceSlot, mediaListEntry, 2, new MediaListEntry[0]);
                    SelectionBrowser selectionBrowser = this.mediaTerminal.getSelectionBrowser();
                    DataSelectionByCategoryJob dataSelectionByCategoryJob = new DataSelectionByCategoryJob(this.lc, selectionBrowser, dataSelectionContainer, this.dataBrowserList.getPlayer());
                    dataSelectionByCategoryJob.useSelectionRangeIndex = true;
                    selectionBrowser.enqueueSelectionJob(dataSelectionByCategoryJob);
                    break;
                }
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(2, 1).add(DataBrowserListElement.createFocusListElement(searchResult.getDataId(), 1)));
                break;
            }
            case 11: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(7, 1).add(DataBrowserListElement.createFocusListElement(searchResult.getDataId(), 2)));
                break;
            }
            case 9: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(5, 1).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 16)));
                break;
            }
            case 10: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(6, 1).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 5)));
                break;
            }
            case 13: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(10, 1).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 17)));
                break;
            }
            case 14: {
                this.dataBrowserList.selectBrowseListPath(new DataBrowserListLocator(8, 1).add(DataBrowserListElement.createDirectoryElement(searchResult.getDataId(), 11)));
                break;
            }
        }
        this.mdlListSearchResults.fireEvent(n);
    }

    private void setEntryTypeOfSelectedSearchResult(int n) {
        this.lc.log(1078071040, "[%1.setEntryTypeOfSelectedSearchResult] entryType='%2'", (Object)"GlobalSearchHandler", (long)n);
        this.entryTypeOfSelectedSearchResultModel.setValue(n);
    }

    @Override
    protected String getLogClass() {
        return "GlobalSearchHandler";
    }
}

