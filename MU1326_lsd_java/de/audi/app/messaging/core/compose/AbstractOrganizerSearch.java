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
import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.addressbook.MessagingAdbHandler;
import de.audi.app.messaging.core.addressbook.MessagingEntryDetailsListRowBuilder;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.compose.AbstractOrganizerSearch$1;
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
    private final GetEntryCommand$ResultHandler resultHandler = new AbstractOrganizerSearch$1(this);
    private volatile ADBSearchListRow parentRow;

    public AbstractOrganizerSearch(MessagingBundleContext messagingBundleContext, MessagingAdbHandler messagingAdbHandler) {
        super(messagingBundleContext.getFramework().getHmiServiceApp().getTiledListModel(-1265426176), messagingBundleContext.getFramework().getHmiServiceApp().getMatchSpellerModel(747839744), null, messagingBundleContext.getFramework().getHmiServiceApp().getBaseListModel(1804804352), messagingBundleContext.getFramework().getHmiServiceApp().getChoiceModel(-862838528), messagingAdbHandler, messagingBundleContext.getFramework().getLogChannel("App.Messaging.Search"));
        this.appAdr = messagingAdbHandler;
        this.menu = messagingBundleContext.getFramework().getHmiServiceApp().getMenuModel(-91086592);
        this.searchList = messagingBundleContext.getFramework().getHmiServiceApp().getTiledListModel(-1265426176);
    }

    @Override
    public void addComponent(IMessagingComponent iMessagingComponent) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.msgApp = abstractMsgApplication;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
    }

    @Override
    public void disconnect() {
    }

    @Override
    public abstract EvoListRow[] createSearchListRows(DataSet[] dataSetArray) {
    }

    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2, int n3) {
        this.log.log(1078071040, "AbstractOrganizerSearch#entrySelected(): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
        this.parentRow = aDBSearchListRow;
        GetEntryCommand.schedule(this.appAdr, aDBSearchListRow.getEntryId(), this.resultHandler);
    }

    protected boolean handleGetEntryResult(AdbEntry adbEntry) {
        MessagingEntryDetailsListRowBuilder messagingEntryDetailsListRowBuilder = new MessagingEntryDetailsListRowBuilder();
        this.log.log(1078071040, "AbstractOrganizerSearch#handleGetEntryResult(): entry: %1", (Object)ADBDbgUtils.dbgShort(adbEntry));
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

