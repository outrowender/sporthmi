/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.addressbook.GetEntryCommand;
import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.compose.RecipientSearch$1;
import de.audi.app.messaging.core.compose.RecipientSearch$CoreActionProxy;
import de.audi.app.messaging.core.compose.RecipientSearchListRow;
import de.audi.app.messaging.core.compose.RecipientSearchListRow$ChildRow;
import de.audi.app.messaging.core.compose.RecipientSearchResultFormatter;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
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
import de.audi.atip.search.AbstractSearch;
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
    private final GetEntryCommand$ResultHandler commandResultHandler = new RecipientSearch$1(this);
    private volatile SearchResultListRow selectedParentRow = null;

    public RecipientSearch(MessagingBundleContext messagingBundleContext, MessagingSearch messagingSearch) {
        super(new int[]{3}, messagingBundleContext.getFramework().getHmiServiceApp().getBaseListModel(-879615744), messagingBundleContext.getFramework().getHmiServiceApp().getSpellerModel(-896392960), messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(-862838528), messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"), messagingSearch);
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
        Integer n = Util.createInteger(3);
        RecipientSearchResultFormatter recipientSearchResultFormatter = new RecipientSearchResultFormatter();
        this.registryFormatter.put(n, recipientSearchResultFormatter);
        abstractMsgApplication.getActionProxyService().addSubscriber(new RecipientSearch$CoreActionProxy(this, null));
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

    public SpellerModelApp getSpellerModel() {
        return this.mdlSpellerSearchText;
    }

    public void addSpellerListener(SpellerListener spellerListener) {
        this.log.log(-2137614336, "[RecipientSearch#addSpellerListener] spellerListener = %1", (Object)spellerListener);
        this.spellerListeners.add(spellerListener);
    }

    public int getListLength() {
        return this.mdlListSearchResults.getLength();
    }

    public void selectListItem(int n, int n2) {
        this.log.log(-2137614336, "[RecipientSearch#selectListItem] index = %1, terminalId = %2", (long)n, (long)n2);
        EvoListRow evoListRow = this.mdlListSearchResults.getRow(n);
        this.itemSelected(evoListRow, this.mdlListSearchResults.getID(), 0, 0, n2);
        MenuModelApp menuModelApp = this.framework.getHmiServiceApp().getMenuModel(-91086592);
        menuModelApp.setFocusedItem(this.mdlListSearchResults.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
    }

    private void handleCommandResult(int n, AdbEntry adbEntry) {
        this.log.log(-2137614336, "[RecipientSearch#handleCommandResult] success = %1", (long)n);
        EvoListRow[] evoListRowArray = null;
        if (n == 0) {
            evoListRowArray = this.msgApp.getAccountManager().isEmailMode() ? RecipientSearchListRow$ChildRow.createEmailAddressRows(adbEntry) : RecipientSearchListRow$ChildRow.createPhoneNumberRows(adbEntry);
        }
        if (evoListRowArray == null) {
            evoListRowArray = new EvoListRow[]{};
        }
        this.setChildrenNodes(evoListRowArray, this.selectedParentRow);
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(-1601830656, "[RecipientSearch#searchResultSelected] listRow = %1; Illegal call.", (Object)searchResultListRow);
    }

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.log.log(1078071040, "[RecipientSearch#childNodeSelected] listRow = %1", (Object)evoListRow);
        RecipientSearchListRow$ChildRow recipientSearchListRow$ChildRow = (RecipientSearchListRow$ChildRow)evoListRow;
        MatchedAddress matchedAddress = recipientSearchListRow$ChildRow.getMatchedAddress();
        this.msgApp.getNewMessage().getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
        this.mdlSpellerSearchText.clear();
        this.textChanged(n2, "", '\u0000', 0);
    }

    @Override
    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.log.log(1078071040, "[RecipientSearch#requestChildrenNodes] listRow = %1", (Object)searchResultListRow);
        long l = ((RecipientSearchListRow)searchResultListRow).getEntryId();
        this.selectedParentRow = searchResultListRow;
        GetEntryCommand.schedule(this.msgApp.getMessagingAdbHandler(), l, this.commandResultHandler);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.log.log(1078071040, "[RecipientSearch#keyPressed] key = %1", (long)n2);
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

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.log.log(1078071040, "[RecipientSearch#keyReleased] key = %1", (long)n2);
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

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[RecipientSearch#keyTyped] key = %1", (long)n2);
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

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(1078071040, "[RecipientSearch#textChanged] text = %1", (Object)string);
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

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
        this.log.log(1078071040, "[RecipientSearch#focusedCharacter] focusedCharacter = %1", c2);
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

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.log.log(1078071040, "[RecipientSearch#commandPressed] index = %1", (long)n2);
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

    @Override
    public SearchResultListRow getFormattedRow(SearchResult searchResult) {
        this.log.log(1078071040, "[RecipientSearch#getFormattedRow] resultRow = %1", (Object)searchResult);
        return super.getFormattedRow(searchResult);
    }

    @Override
    public void refreshQuery() {
        boolean bl = this.mdlSpellerSearchText == null || Strings.isNullOrEmpty(this.mdlSpellerSearchText.getText());
        this.log.log(1078071040, "[RecipientSearch#refreshQuery] isEmptyQuery = %1", bl);
        if (!bl) {
            super.refreshQuery();
        }
    }

    static /* synthetic */ void access$000(RecipientSearch recipientSearch, int n, AdbEntry adbEntry) {
        recipientSearch.handleCommandResult(n, adbEntry);
    }

    static /* synthetic */ LogChannel access$200(RecipientSearch recipientSearch) {
        return recipientSearch.log;
    }

    static /* synthetic */ AbstractMsgApplication access$300(RecipientSearch recipientSearch) {
        return recipientSearch.msgApp;
    }

    static /* synthetic */ Map access$400() {
        return SEARCH_FILTERS_EMAIL;
    }

    static /* synthetic */ Map access$500() {
        return SEARCH_FILTERS_SMS;
    }

    static /* synthetic */ AbstractSearch access$600(RecipientSearch recipientSearch) {
        return recipientSearch.appSearch;
    }

    static {
        SEARCH_FILTERS_SMS.put(Util.createInteger(3), RECIPIENT_SEARCH_FILTER_SMS);
        SEARCH_FILTERS_EMAIL = new HashMap(1, 1.0f);
        SEARCH_FILTERS_EMAIL.put(Util.createInteger(3), RECIPIENT_SEARCH_FILTER_EMAIL);
    }
}

