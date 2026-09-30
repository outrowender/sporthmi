/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.AbstractADBOrganizerSearch;
import de.audi.app.messaging.core.addressbook.GetEntryCommand;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.addressbook.MessagingEntryDetailsListRowBuilder;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;

public abstract class AbstractOrganizerSearch
extends AbstractADBOrganizerSearch
implements IMessagingComponent {
    protected volatile AbstractMsgApplication msgApp;
    protected final MessagingAdbHandler appAdr;
    protected final TiledListModelApp searchList;
    protected final MenuModelApp menu;
    private final GetEntryCommand.ResultHandler resultHandler = new GetEntryCommand.ResultHandler(){

        public void handleResult(int n, AdbEntry adbEntry) {
            AbstractOrganizerSearch.this.handleGetEntryResult(adbEntry);
        }
    };
    private volatile ADBSearchListRow parentRow;

    public AbstractOrganizerSearch(MessagingBundleContext messagingBundleContext, MessagingAdbHandler messagingAdbHandler) {
        super(messagingBundleContext.getFramework().getHmiServiceApp().getTiledListModel(2200500), messagingBundleContext.getFramework().getHmiServiceApp().getMatchSpellerModel(2200364), null, messagingBundleContext.getFramework().getHmiServiceApp().getBaseListModel(2200427), messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(2200268), messagingAdbHandler, messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"));
        this.appAdr = messagingAdbHandler;
        this.menu = messagingBundleContext.getFramework().getHmiServiceApp().getMenuModel(2200314);
        this.searchList = messagingBundleContext.getFramework().getHmiServiceApp().getTiledListModel(2200500);
    }

    public void addComponent(IMessagingComponent iMessagingComponent) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.msgApp = abstractMsgApplication;
    }

    public void dispose() {
    }

    public void connect(IServiceRegistry iServiceRegistry) {
    }

    public void disconnect() {
    }

    public abstract EvoListRow[] createSearchListRows(DataSet[] var1);

    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2, int n3) {
        this.log.log(1000000, "AbstractOrganizerSearch#entrySelected(): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
        this.parentRow = aDBSearchListRow;
        GetEntryCommand.schedule(this.appAdr, aDBSearchListRow.getEntryId(), this.resultHandler);
    }

    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        MessagingEntryDetailsListRowBuilder messagingEntryDetailsListRowBuilder = new MessagingEntryDetailsListRowBuilder();
        this.log.log(1000000, "AbstractOrganizerSearch#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
        ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray = null;
        switch (this.appAdr.getAdbMode()) {
            case 0: {
                aDBEntryDetailsListRowArray = MessagingEntryDetailsListRowBuilder.getTelDetailsRows(adbEntry, messagingEntryDetailsListRowBuilder);
                break;
            }
            case 2: {
                aDBEntryDetailsListRowArray = MessagingEntryDetailsListRowBuilder.getEmailDetailsRows(adbEntry, messagingEntryDetailsListRowBuilder);
                break;
            }
            default: {
                this.log.log(10000, "SetListDetailsCommand#handleGetEntryResult(): unknown adbMode: %1", (long)this.appAdr.getAdbMode());
                return false;
            }
        }
        this.setSearchResultDetails(aDBEntryDetailsListRowArray, this.parentRow);
        return true;
    }
}

