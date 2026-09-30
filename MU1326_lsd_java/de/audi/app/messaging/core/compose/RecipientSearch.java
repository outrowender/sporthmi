/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.addressbook.GetEntryCommand;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.compose.RecipientSearchListRow;
import de.audi.app.messaging.core.compose.RecipientSearchResultFormatter;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.search.MessagingSearch;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchResult;

public final class RecipientSearch
extends AbstractGuiSearchHandler
implements IMessagingComponent {
    private static final SearchFilter RECIPIENT_SEARCH_FILTER_SMS = new SearchFilter(new int[]{5}, null, 7, null);
    private static final SearchFilter RECIPIENT_SEARCH_FILTER_EMAIL = new SearchFilter(new int[]{5}, null, 8, null);
    private static final Map SEARCH_FILTERS_SMS = new HashMap(1, 1.0f);
    private static final Map SEARCH_FILTERS_EMAIL;
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final MessagingComponentCollection subcomponents = new MessagingComponentCollection();
    private volatile AbstractMsgApplication msgApp;
    private final CopyOnWriteArrayList spellerListeners = new CopyOnWriteArrayList();
    private final GetEntryCommand.ResultHandler commandResultHandler = new GetEntryCommand.ResultHandler(){

        public void handleResult(int n, AdbEntry adbEntry) {
            RecipientSearch.this.handleCommandResult(n, adbEntry);
        }
    };
    private volatile SearchResultListRow selectedParentRow = null;

    public RecipientSearch(MessagingBundleContext messagingBundleContext, MessagingSearch messagingSearch) {
        super(new int[]{3}, messagingBundleContext.getFramework().getHmiServiceApp().getBaseListModel(2200267), messagingBundleContext.getFramework().getHmiServiceApp().getSpellerModel(2200266), messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(2200268), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"), messagingSearch);
        this.framework = messagingBundleContext.getFramework();
        this.log = this.framework.getLogChannel("App.Messaging.Main");
    }

    public void addComponent(IMessagingComponent iMessagingComponent) {
        throw new UnsupportedOperationException();
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.msgApp = abstractMsgApplication;
        this.subcomponents.initAll(abstractMsgApplication);
        Integer n = Util.createInteger(3);
        RecipientSearchResultFormatter recipientSearchResultFormatter = new RecipientSearchResultFormatter();
        this.registryFormatter.put(n, recipientSearchResultFormatter);
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
    }

    public void dispose() {
        this.subcomponents.disposeAll();
    }

    public void connect(IServiceRegistry iServiceRegistry) {
    }

    public void disconnect() {
    }

    public SpellerModelApp getSpellerModel() {
        return this.mdlSpellerSearchText;
    }

    public void addSpellerListener(SpellerListener spellerListener) {
        this.log.log(10000000, "[RecipientSearch#addSpellerListener] spellerListener = %1", (Object)spellerListener);
        this.spellerListeners.add(spellerListener);
    }

    public int getListLength() {
        return this.mdlListSearchResults.getLength();
    }

    public void selectListItem(int n, int n2) {
        this.log.log(10000000, "[RecipientSearch#selectListItem] index = %1, terminalId = %2", (long)n, (long)n2);
        EvoListRow evoListRow = this.mdlListSearchResults.getRow(n);
        this.itemSelected(evoListRow, this.mdlListSearchResults.getID(), 0, 0, n2);
        MenuModelApp menuModelApp = this.framework.getHmiServiceApp().getMenuModel(2200314);
        menuModelApp.setFocusedItem(this.mdlListSearchResults.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
    }

    private void handleCommandResult(int n, AdbEntry adbEntry) {
        this.log.log(10000000, "[RecipientSearch#handleCommandResult] success = %1", (long)n);
        EvoListRow[] evoListRowArray = null;
        if (n == 0) {
            evoListRowArray = this.msgApp.getAccountManager().isEmailMode() ? RecipientSearchListRow.ChildRow.createEmailAddressRows(adbEntry) : RecipientSearchListRow.ChildRow.createPhoneNumberRows(adbEntry);
        }
        if (evoListRowArray == null) {
            evoListRowArray = new EvoListRow[]{};
        }
        this.setChildrenNodes(evoListRowArray, this.selectedParentRow);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(100000, "[RecipientSearch#searchResultSelected] listRow = %1; Illegal call.", (Object)searchResultListRow);
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.log.log(1000000, "[RecipientSearch#childNodeSelected] listRow = %1", (Object)evoListRow);
        RecipientSearchListRow.ChildRow childRow = (RecipientSearchListRow.ChildRow)evoListRow;
        MatchedAddress matchedAddress = childRow.getMatchedAddress();
        this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
        this.mdlSpellerSearchText.clear();
        this.textChanged(n2, "", '\u0000', 0);
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.log.log(1000000, "[RecipientSearch#requestChildrenNodes] listRow = %1", (Object)searchResultListRow);
        long l = ((RecipientSearchListRow)searchResultListRow).getEntryId();
        this.selectedParentRow = searchResultListRow;
        GetEntryCommand.schedule(this.msgApp.getMessagingAdbHandler(), l, this.commandResultHandler);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.log.log(1000000, "[RecipientSearch#keyPressed] key = %1", (long)n2);
        super.keyPressed(n, n2, n3);
        Iterator iterator = this.spellerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpellerListener)iterator.next()).keyPressed(n, n2, n3);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[RecipientSearch#keyPressed]");
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        this.log.log(1000000, "[RecipientSearch#keyReleased] key = %1", (long)n2);
        super.keyReleased(n, n2, n3);
        Iterator iterator = this.spellerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpellerListener)iterator.next()).keyReleased(n, n2, n3);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[RecipientSearch#keyReleased]");
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[RecipientSearch#keyTyped] key = %1", (long)n2);
        super.keyTyped(n, n2, n3);
        Iterator iterator = this.spellerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpellerListener)iterator.next()).keyTyped(n, n2, n3);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[RecipientSearch#keyTyped]");
            }
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1000000, "[RecipientSearch#textChanged] text = %1", (Object)string);
        boolean bl = Strings.isNullOrEmpty(string);
        if (bl) {
            this.appSearch.cancelQuery();
            this.initModels();
        } else {
            super.textChanged(n, string, c2, n2);
        }
        Iterator iterator = this.spellerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpellerListener)iterator.next()).textChanged(n, string, c2, n2);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[RecipientSearch#textChanged]");
            }
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
        this.log.log(1000000, "[RecipientSearch#focusedCharacter] focusedCharacter = %1", c2);
        super.focusedCharacter(n, c2, n2);
        Iterator iterator = this.spellerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpellerListener)iterator.next()).focusedCharacter(n, c2, n2);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[RecipientSearch#focusedCharacter]");
            }
        }
    }

    public void commandPressed(int n, int n2, int n3) {
        this.log.log(1000000, "[RecipientSearch#commandPressed] index = %1", (long)n2);
        super.commandPressed(n, n2, n3);
        Iterator iterator = this.spellerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((SpellerListener)iterator.next()).commandPressed(n, n2, n3);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[RecipientSearch#commandPressed]");
            }
        }
    }

    public SearchResultListRow getFormattedRow(SearchResult searchResult) {
        this.log.log(1000000, "[RecipientSearch#getFormattedRow] resultRow = %1", (Object)searchResult);
        return super.getFormattedRow(searchResult);
    }

    public void refreshQuery() {
        boolean bl = this.mdlSpellerSearchText == null || Strings.isNullOrEmpty(this.mdlSpellerSearchText.getText());
        this.log.log(1000000, "[RecipientSearch#refreshQuery] isEmptyQuery = %1", bl);
        if (!bl) {
            super.refreshQuery();
        }
    }

    static {
        SEARCH_FILTERS_SMS.put(Util.createInteger(3), RECIPIENT_SEARCH_FILTER_SMS);
        SEARCH_FILTERS_EMAIL = new HashMap(1, 1.0f);
        SEARCH_FILTERS_EMAIL.put(Util.createInteger(3), RECIPIENT_SEARCH_FILTER_EMAIL);
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void searchableViewTransition(int n, int n2, int n3) {
            RecipientSearch.this.log.log(10000000, "[RecipientSearch#searchableViewTransition]");
            if (n3 == 0 && n2 == 1) {
                Map map = RecipientSearch.this.msgApp.getAccountManager().isEmailMode() ? SEARCH_FILTERS_EMAIL : SEARCH_FILTERS_SMS;
                ((MessagingSearch)RecipientSearch.this.appSearch).switchConfiguration(RecipientSearch.this, map);
            }
        }
    }
}

