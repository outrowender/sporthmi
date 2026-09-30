/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.extracteditems.ExtractedItemListRow;
import de.audi.app.messaging.core.extracteditems.ExtractedItems;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.MatchedAddress;

public final class ExtractedMailAddressList
extends AbstractMessagingComponent {
    private static volatile long nextRowId = 0L;
    private static final int ITEM_OFFSET_NA = -1;
    private static final int ITEM_LENGTH_NA = -1;
    private final BaseListModelApp listModel;
    private volatile ExtractedItem primaryContactAddress = null;
    private volatile ExtractedItem[] extractedItems = new ExtractedItem[0];

    public ExtractedMailAddressList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(2200274);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new MyBaseListModelListener());
    }

    public void clear() {
        this.log.log(10000000, "[ExtractedMailAddressList#clear]");
        this.primaryContactAddress = null;
        this.extractedItems = new ExtractedItem[0];
        this.listModel.removeAll();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void setPrimaryContactAddress(String string) {
        this.log.log(10000000, "[ExtractedMailAddressList#setPrimaryContactAddress] primaryContactAddress = %1", (Object)string);
        this.primaryContactAddress = Strings.isNullOrEmpty(string) ? null : new ExtractedItem(2, string, -1, -1);
        this.refresh();
    }

    public void setExtractedItems(ExtractedItem[] extractedItemArray) {
        this.log.log(10000000, "[ExtractedMailAddressList#setExtractedItems] extractedItems.length = %1", (Object)Arrays.getLengthAsString(extractedItemArray));
        this.extractedItems = extractedItemArray != null ? extractedItemArray : new ExtractedItem[]{};
        this.refresh();
    }

    private void refresh() {
        ExtractedItem extractedItem;
        this.log.log(10000000, "[ExtractedMailAddressList#refresh]");
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
            this.log.log(1000000, "[ExtractedMailAddressList#refresh] Ignored items that feature non-unique values.");
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

    private class MyBaseListModelListener
    extends DefaultBaseListModelListener {
        private MyBaseListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ExtractedMailAddressList.this.log.log(1000000, "[ExtractedMailAddressList#itemSelected] row = %1", (Object)evoListRow);
            boolean bl = Accounts.supportsSend(ExtractedMailAddressList.this.msgApp.getAccountManager().getSelectedAccount());
            if (bl) {
                ExtractedMailAddressList.this.prefillNewMessageFromRow(evoListRow);
                ExtractedMailAddressList.this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
            } else {
                ExtractedMailAddressList.this.log.log(1000000, "[ExtractedMailAddressList#itemSelected] Current account does not support sending messages.");
            }
        }
    }
}

