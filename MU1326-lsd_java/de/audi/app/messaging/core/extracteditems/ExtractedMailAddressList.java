/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.extracteditems.ExtractedItemListRow;
import de.audi.app.messaging.core.extracteditems.ExtractedItems;
import de.audi.app.messaging.core.extracteditems.ExtractedMailAddressList$MyBaseListModelListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.MatchedAddress;

public final class ExtractedMailAddressList
extends AbstractMessagingComponent {
    private static volatile long nextRowId = 0L;
    private static final int ITEM_OFFSET_NA;
    private static final int ITEM_LENGTH_NA;
    private final BaseListModelApp listModel;
    private volatile ExtractedItem primaryContactAddress = null;
    private volatile ExtractedItem[] extractedItems = new ExtractedItem[0];

    public ExtractedMailAddressList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(-762175232);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new ExtractedMailAddressList$MyBaseListModelListener(this, null));
    }

    public void clear() {
        this.log.log(-2137614336, "[ExtractedMailAddressList#clear]");
        this.primaryContactAddress = null;
        this.extractedItems = new ExtractedItem[0];
        this.listModel.removeAll();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void setPrimaryContactAddress(String string) {
        this.log.log(-2137614336, "[ExtractedMailAddressList#setPrimaryContactAddress] primaryContactAddress = %1", (Object)string);
        this.primaryContactAddress = Strings.isNullOrEmpty(string) ? null : new ExtractedItem(2, string, -1, -1);
        this.refresh();
    }

    public void setExtractedItems(ExtractedItem[] extractedItemArray) {
        this.log.log(-2137614336, "[ExtractedMailAddressList#setExtractedItems] extractedItems.length = %1", (Object)Arrays.getLengthAsString(extractedItemArray));
        this.extractedItems = extractedItemArray != null ? extractedItemArray : new ExtractedItem[]{};
        this.refresh();
    }

    private void refresh() {
        ExtractedItem extractedItem;
        this.log.log(-2137614336, "[ExtractedMailAddressList#refresh]");
        ArrayList arrayList = new ArrayList(this.extractedItems.length);
        if (this.primaryContactAddress != null) {
            ExtractedItems.addIfUniqueValue(this.primaryContactAddress, arrayList, true);
        }
        for (int i2 = 0; i2 < this.extractedItems.length; ++i2) {
            extractedItem = this.extractedItems[i2];
            if (extractedItem.getType() != 2) continue;
            ExtractedItems.addIfUniqueValue(extractedItem, arrayList, true);
        }
        if (this.extractedItems.length > arrayList.size()) {
            this.log.log(1078071040, "[ExtractedMailAddressList#refresh] Ignored items that feature non-unique values.");
        }
        this.listModel.removeAll();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            extractedItem = (ExtractedItem)iterator.next();
            ExtractedItemListRow extractedItemListRow = new ExtractedItemListRow(extractedItem, nextRowId++);
            this.listModel.append(extractedItemListRow);
        }
    }

    private void prefillNewMessageFromRow(EvoListRow evoListRow) {
        ExtractedItemListRow extractedItemListRow = (ExtractedItemListRow)evoListRow;
        NewMessage newMessage = this.msgApp.getNewMessage();
        MatchedAddress matchedAddress = new MatchedAddress(extractedItemListRow.getItemValue(), "", 0L, null);
        newMessage.clear();
        newMessage.getSelectedRecipientList().addRecipientsTo(new MatchedAddress[]{matchedAddress});
    }

    static /* synthetic */ LogChannel access$100(ExtractedMailAddressList extractedMailAddressList) {
        return extractedMailAddressList.log;
    }

    static /* synthetic */ AbstractMsgApplication access$200(ExtractedMailAddressList extractedMailAddressList) {
        return extractedMailAddressList.msgApp;
    }

    static /* synthetic */ void access$300(ExtractedMailAddressList extractedMailAddressList, EvoListRow evoListRow) {
        extractedMailAddressList.prefillNewMessageFromRow(evoListRow);
    }

    static /* synthetic */ IFrameworkAccess access$400(ExtractedMailAddressList extractedMailAddressList) {
        return extractedMailAddressList.framework;
    }

    static /* synthetic */ LogChannel access$500(ExtractedMailAddressList extractedMailAddressList) {
        return extractedMailAddressList.log;
    }
}

