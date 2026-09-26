/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch$CoreActionProxy;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearch$FolderNavigatorObserver;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearchListRow;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearchResultFormatter;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory$NullFactory;
import de.audi.app.messaging.core.folderbrowsing.IFolderContentSearchObserver;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.search.MessagingSearch;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchResult;

public class FolderContentSearch
extends AbstractGuiSearchHandler
implements IMessagingComponent {
    private static final SearchFilter FOLDER_CONTENT_SEARCH_FILTER = new SearchFilter(new int[]{5, 15, 16, 2}, null, 0, null);
    private static final Map SEARCH_FILTERS = new HashMap(1, 1.0f);
    private final IFrameworkAccess framework;
    protected final LogChannel log;
    private volatile IEntryPropertyFactory entryPropertyFactory = new IEntryPropertyFactory$NullFactory();
    private final MessagingComponentCollection subcomponents = new MessagingComponentCollection();
    private volatile AbstractMsgApplication msgApp;
    private final Collection folderContentSearchObservers = new LinkedList();

    public FolderContentSearch(MessagingBundleContext messagingBundleContext, MessagingSearch messagingSearch) {
        super(new int[]{8}, messagingBundleContext.getFramework().getHmiServiceApp().getBaseListModel(-208527104), messagingBundleContext.getFramework().getHmiServiceApp().getSpellerModel(-1399643904), messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(-225304320), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"), messagingSearch);
        this.framework = messagingBundleContext.getFramework();
        this.log = this.framework.getLogChannel("App.Messaging.Main");
    }

    @Override
    public void addComponent(IMessagingComponent iMessagingComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.msgApp = abstractMsgApplication;
        this.subcomponents.initAll(abstractMsgApplication);
        this.appSearch.setSearchFilter(8, FOLDER_CONTENT_SEARCH_FILTER);
        this.configureSearchResultFormatting();
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        EntryList entryList = abstractMsgApplication.getEntryList();
        entryList.registerForModelGroup(this.mdlListSearchResults);
        entryList.registerForModelGroup(this.mdlSpellerSearchText);
        entryList.registerForModelGroup(this.mdlChoiceSearchIsActive);
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(-191749888));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(-174972672));
        abstractMsgApplication.getFolderNavigator().addObserver(new FolderContentSearch$FolderNavigatorObserver(this, null));
        abstractMsgApplication.getActionProxyService().addSubscriber(new FolderContentSearch$CoreActionProxy(this, null));
    }

    @Override
    public void dispose() {
        this.subcomponents.disposeAll();
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
    }

    @Override
    public void disconnect() {
    }

    public void addObserver(IFolderContentSearchObserver iFolderContentSearchObserver) {
        this.log.log(-2137614336, "[FolderContentSearch#addObserver] observer = %1", (Object)iFolderContentSearchObserver);
        this.folderContentSearchObservers.add(iFolderContentSearchObserver);
    }

    public void setEntryPropertyFactory(IEntryPropertyFactory iEntryPropertyFactory) {
        this.log.log(-2137614336, "[FolderContentSearch#setEntryPropertyFactory] entryPropertyFactory = %1", (Object)iEntryPropertyFactory);
        this.entryPropertyFactory = iEntryPropertyFactory;
        this.configureSearchResultFormatting();
    }

    public int getListLength() {
        return this.mdlListSearchResults.getLength();
    }

    public void selectListItem(int n, int n2) {
        this.log.log(-2137614336, "[RecipientSearch#selectListItem] index = %1, terminalId = %2", (long)n, (long)n2);
        EvoListRow evoListRow = this.mdlListSearchResults.getRow(n);
        this.itemSelected(evoListRow, this.mdlListSearchResults.getID(), 0, 0, n2);
        MenuModelApp menuModelApp = this.framework.getHmiServiceApp().getMenuModel(1217536256);
        menuModelApp.setFocusedItem(this.mdlListSearchResults.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
    }

    private void configureSearchResultFormatting() {
        Integer n = Util.createInteger(8);
        FolderContentSearchResultFormatter folderContentSearchResultFormatter = new FolderContentSearchResultFormatter(this.msgApp, this.entryPropertyFactory, this.msgApp.getTextLookup());
        this.registryFormatter.put(n, folderContentSearchResultFormatter);
    }

    private void setFocusedItem(FolderContentSearchListRow folderContentSearchListRow) {
        ListEntry listEntry;
        this.log.log(-2137614336, "[FolderContentSearch#setFocusedItem] row = %1", (Object)folderContentSearchListRow);
        if (folderContentSearchListRow != null && ListEntries.isMessage(listEntry = folderContentSearchListRow.getListEntry())) {
            this.msgApp.getMessageOptionsManager().setFocusedMessageListEntry(listEntry.getMessageListEntry());
        }
    }

    public void clear() {
        this.log.log(-2137614336, "[FolderContentSearch#clear]");
        this.clearModels();
        this.mdlSpellerSearchText.clear();
        this.textChanged(this.mdlSpellerSearchText.getID(), "", '\u0000', 0);
    }

    private void emitSearchResultSelected(SearchResultListRow searchResultListRow) {
        this.log.log(-2137614336, "[FolderContentSearch#emitSearchResultSelected]");
        Iterator iterator = this.folderContentSearchObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IFolderContentSearchObserver)iterator.next()).searchResultSelected(searchResultListRow);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[FolderContentSearch#emitSearchResultSelected]");
            }
        }
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(1078071040, "[FolderContentSearch#itemFocused] row = %1", (Object)evoListRow);
        this.setFocusedItem((FolderContentSearchListRow)evoListRow);
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        ListEntry listEntry = ((FolderContentSearchListRow)searchResultListRow).getListEntry();
        this.log.log(1078071040, "[FolderContentSearch#searchResultSelected] listEntry = %1", (Object)listEntry);
        this.setFocusedItem((FolderContentSearchListRow)searchResultListRow);
        this.msgApp.getSelectedMessage().requestSetMessage(listEntry.getMessageListEntry(), 0, null);
        this.mdlListSearchResults.fireEvent(n);
        this.emitSearchResultSelected(searchResultListRow);
    }

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[FolderContentSearch#keyTyped]");
        super.keyTyped(n, n2, n3);
        if (this.getListLength() == 1) {
            this.log.log(-2137614336, "[FolderContentSearch#keyTyped] Autoselecting the only search result.");
            this.selectListItem(0, n3);
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1078071040, "[FolderContentSearch#textChanged] text = %1", (Object)string);
        boolean bl = Strings.isNullOrEmpty(string);
        if (!bl) {
            super.textChanged(n, string, c2, n2);
        } else {
            this.appSearch.cancelQuery();
            this.clearModels();
        }
        int n3 = bl ? 0 : 1;
        this.framework.getHmiServiceApp().getChoiceModel(-174972672).setValue(n3);
    }

    @Override
    public SearchResultListRow getFormattedRow(SearchResult searchResult) {
        this.log.log(1078071040, "[FolderContentSearch#getFormattedRow] resultRow = %1", (Object)searchResult);
        return super.getFormattedRow(searchResult);
    }

    @Override
    public void refreshQuery() {
        boolean bl = this.mdlSpellerSearchText == null || Strings.isNullOrEmpty(this.mdlSpellerSearchText.getText());
        this.log.log(1078071040, "[FolderContentSearch#refreshQuery] isEmptyQuery = %1", bl);
        if (!bl) {
            super.refreshQuery();
        }
    }

    static /* synthetic */ IFrameworkAccess access$200(FolderContentSearch folderContentSearch) {
        return folderContentSearch.framework;
    }

    static /* synthetic */ Map access$300() {
        return SEARCH_FILTERS;
    }

    static /* synthetic */ AbstractSearch access$400(FolderContentSearch folderContentSearch) {
        return folderContentSearch.appSearch;
    }

    static {
        SEARCH_FILTERS.put(Util.createInteger(8), FOLDER_CONTENT_SEARCH_FILTER);
    }
}

