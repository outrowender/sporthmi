/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearchListRow;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearchResultFormatter;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.folderbrowsing.IFolderContentSearchObserver;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
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
    private volatile IEntryPropertyFactory entryPropertyFactory = new IEntryPropertyFactory.NullFactory();
    private final MessagingComponentCollection subcomponents = new MessagingComponentCollection();
    private volatile AbstractMsgApplication msgApp;
    private final Collection folderContentSearchObservers = new LinkedList();

    public FolderContentSearch(MessagingBundleContext messagingBundleContext, MessagingSearch messagingSearch) {
        super(new int[]{8}, messagingBundleContext.getFramework().getHmiServiceApp().getBaseListModel(2200307), messagingBundleContext.getFramework().getHmiServiceApp().getSpellerModel(2200492), messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(2200306), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"), messagingSearch);
        this.framework = messagingBundleContext.getFramework();
        this.log = this.framework.getLogChannel("App.Messaging.Main");
    }

    public void addComponent(IMessagingComponent iMessagingComponent) {
        throw new UnsupportedOperationException();
    }

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
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200308));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200309));
        abstractMsgApplication.getFolderNavigator().addObserver(new FolderNavigatorObserver());
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
    }

    public void dispose() {
        this.subcomponents.disposeAll();
    }

    public void connect(IServiceRegistry iServiceRegistry) {
    }

    public void disconnect() {
    }

    public void addObserver(IFolderContentSearchObserver iFolderContentSearchObserver) {
        this.log.log(10000000, "[FolderContentSearch#addObserver] observer = %1", (Object)iFolderContentSearchObserver);
        this.folderContentSearchObservers.add(iFolderContentSearchObserver);
    }

    public void setEntryPropertyFactory(IEntryPropertyFactory iEntryPropertyFactory) {
        this.log.log(10000000, "[FolderContentSearch#setEntryPropertyFactory] entryPropertyFactory = %1", (Object)iEntryPropertyFactory);
        this.entryPropertyFactory = iEntryPropertyFactory;
        this.configureSearchResultFormatting();
    }

    public int getListLength() {
        return this.mdlListSearchResults.getLength();
    }

    public void selectListItem(int n, int n2) {
        this.log.log(10000000, "[RecipientSearch#selectListItem] index = %1, terminalId = %2", (long)n, (long)n2);
        EvoListRow evoListRow = this.mdlListSearchResults.getRow(n);
        this.itemSelected(evoListRow, this.mdlListSearchResults.getID(), 0, 0, n2);
        MenuModelApp menuModelApp = this.framework.getHmiServiceApp().getMenuModel(2200136);
        menuModelApp.setFocusedItem(this.mdlListSearchResults.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
    }

    private void configureSearchResultFormatting() {
        Integer n = Util.createInteger(8);
        FolderContentSearchResultFormatter folderContentSearchResultFormatter = new FolderContentSearchResultFormatter(this.msgApp, this.entryPropertyFactory, this.msgApp.getTextLookup());
        this.registryFormatter.put(n, folderContentSearchResultFormatter);
    }

    private void setFocusedItem(FolderContentSearchListRow folderContentSearchListRow) {
        ListEntry listEntry;
        this.log.log(10000000, "[FolderContentSearch#setFocusedItem] row = %1", (Object)folderContentSearchListRow);
        if (folderContentSearchListRow != null && ListEntries.isMessage(listEntry = folderContentSearchListRow.getListEntry())) {
            this.msgApp.getMessageOptionsManager().setFocusedMessageListEntry(listEntry.getMessageListEntry());
        }
    }

    public void clear() {
        this.log.log(10000000, "[FolderContentSearch#clear]");
        this.clearModels();
        this.mdlSpellerSearchText.clear();
        this.textChanged(this.mdlSpellerSearchText.getID(), "", '\u0000', 0);
    }

    private void emitSearchResultSelected(SearchResultListRow searchResultListRow) {
        this.log.log(10000000, "[FolderContentSearch#emitSearchResultSelected]");
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

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(1000000, "[FolderContentSearch#itemFocused] row = %1", (Object)evoListRow);
        this.setFocusedItem((FolderContentSearchListRow)evoListRow);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        ListEntry listEntry = ((FolderContentSearchListRow)searchResultListRow).getListEntry();
        this.log.log(1000000, "[FolderContentSearch#searchResultSelected] listEntry = %1", (Object)listEntry);
        this.setFocusedItem((FolderContentSearchListRow)searchResultListRow);
        this.msgApp.getSelectedMessage().requestSetMessage(listEntry.getMessageListEntry(), 0, null);
        this.mdlListSearchResults.fireEvent(n);
        this.emitSearchResultSelected(searchResultListRow);
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[FolderContentSearch#keyTyped]");
        super.keyTyped(n, n2, n3);
        if (this.getListLength() == 1) {
            this.log.log(10000000, "[FolderContentSearch#keyTyped] Autoselecting the only search result.");
            this.selectListItem(0, n3);
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1000000, "[FolderContentSearch#textChanged] text = %1", (Object)string);
        boolean bl = Strings.isNullOrEmpty(string);
        if (!bl) {
            super.textChanged(n, string, c2, n2);
        } else {
            this.appSearch.cancelQuery();
            this.clearModels();
        }
        int n3 = bl ? 0 : 1;
        this.framework.getHmiServiceApp().getChoiceModel(2200309).setValue(n3);
    }

    public SearchResultListRow getFormattedRow(SearchResult searchResult) {
        this.log.log(1000000, "[FolderContentSearch#getFormattedRow] resultRow = %1", (Object)searchResult);
        return super.getFormattedRow(searchResult);
    }

    public void refreshQuery() {
        boolean bl = this.mdlSpellerSearchText == null || Strings.isNullOrEmpty(this.mdlSpellerSearchText.getText());
        this.log.log(1000000, "[FolderContentSearch#refreshQuery] isEmptyQuery = %1", bl);
        if (!bl) {
            super.refreshQuery();
        }
    }

    static {
        SEARCH_FILTERS.put(Util.createInteger(8), FOLDER_CONTENT_SEARCH_FILTER);
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void searchableViewTransition(int n, int n2, int n3) {
            FolderContentSearch.this.log.log(10000000, "[FolderContentSearch#searchableViewTransition]");
            if (n3 == 0 && n2 == 0) {
                ((MessagingSearch)FolderContentSearch.this.appSearch).switchConfiguration(FolderContentSearch.this, SEARCH_FILTERS);
            }
        }
    }

    private final class FolderNavigatorObserver
    extends IFolderNavigatorObserver.EmptyImplementation {
        private FolderNavigatorObserver() {
        }

        public void updateCurrentFolder(Folder folder) {
            FolderContentSearch.this.log.log(10000000, "[FolderContentSearch#updateCurrentFolder] currentFolder = %1", (Object)folder);
            int n = folder.getLevel() > 0 ? 1 : 0;
            FolderContentSearch.this.framework.getHmiServiceApp().getChoiceModel(2200308).setValue(n);
            FolderContentSearch.this.clear();
        }
    }
}

