/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.extracteditems.ExtractedItemListRow;
import de.audi.app.messaging.core.extracteditems.ExtractedItems;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList$MyBaseListModelListener;
import de.audi.app.messaging.core.extracteditems.ExtractedNumberList$MyButtonListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.PhoneServices;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.messaging.ExtractedItem;

public final class ExtractedNumberList
extends AbstractMessagingComponent {
    private static volatile long nextRowId = 0L;
    private static final int ITEM_OFFSET_NA;
    private static final int ITEM_LENGTH_NA;
    private static final int ACTION_DIAL;
    private static final int ACTION_PREPARE;
    private static final int ACTION_DIAL_PORSCHE;
    private static final int ACTION_PREPARE_PORSCHE;
    private final BaseListModelApp listModel;
    private volatile ExtractedItem primaryContactNumber = null;
    private volatile ExtractedItem[] extractedItems = new ExtractedItem[0];

    public ExtractedNumberList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(-795729664);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new ExtractedNumberList$MyBaseListModelListener(this, null));
        this.framework.getHmiServiceApp().getButtonModel(1922179328).setButtonListener(new ExtractedNumberList$MyButtonListener(this, null));
    }

    public void clear() {
        this.log.log(-2137614336, "[ExtractedNumberList#clear]");
        this.primaryContactNumber = null;
        this.extractedItems = new ExtractedItem[0];
        this.listModel.removeAll();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void setPrimaryContactNumber(String string) {
        this.log.log(-2137614336, "[ExtractedNumberList#setPrimaryContactNumber] primaryContactNumber = %1", (Object)string);
        this.primaryContactNumber = Strings.isNullOrEmpty(string) || !Strings.isValidNumber(string) ? null : new ExtractedItem(1, string, -1, -1);
        this.refresh();
    }

    public void setExtractedItems(ExtractedItem[] extractedItemArray) {
        this.log.log(-2137614336, "[ExtractedNumberList#setExtractedItems] extractedItems.length = %1", (Object)Arrays.getLengthAsString(extractedItemArray));
        this.extractedItems = extractedItemArray != null ? extractedItemArray : new ExtractedItem[]{};
        this.refresh();
    }

    private void refresh() {
        ExtractedItem extractedItem;
        this.log.log(-2137614336, "[ExtractedNumberList#refresh]");
        ArrayList arrayList = new ArrayList(this.extractedItems.length);
        if (this.primaryContactNumber != null) {
            ExtractedItems.addIfUniqueValue(this.primaryContactNumber, arrayList, true);
        }
        for (int i2 = 0; i2 < this.extractedItems.length; ++i2) {
            extractedItem = this.extractedItems[i2];
            if (extractedItem.getType() != 1) continue;
            ExtractedItems.addIfUniqueValue(extractedItem, arrayList, true);
        }
        if (this.extractedItems.length > arrayList.size()) {
            this.log.log(1078071040, "[ExtractedNumberList#refresh] Ignored items that feature non-unique values.");
        }
        this.listModel.removeAll();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            extractedItem = (ExtractedItem)iterator.next();
            ExtractedItemListRow extractedItemListRow = new ExtractedItemListRow(extractedItem, nextRowId++);
            this.listModel.append(extractedItemListRow);
        }
    }

    private void callNumber(ExtractedItemListRow extractedItemListRow) {
        this.log.log(-2137614336, "[ExtractedNumberList#callNumber] row = %1", (Object)extractedItemListRow);
        PhoneServices.callUnmatchedNumber(extractedItemListRow.getItemValue(), this.log, this.msgApp);
    }

    private void prepareNumber(ExtractedItemListRow extractedItemListRow) {
        this.log.log(-2137614336, "[ExtractedNumberList#prepareNumber] row = %1", (Object)extractedItemListRow);
        PhoneServices.prepareUnmatchedNumber(extractedItemListRow.getItemValue(), this.log, this.msgApp);
    }

    private void extractedNumbersButton(int n, int n2) {
        this.log.log(1078071040, "[ExtractedNumberList#extractedNumbersButton]");
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ LogChannel access$200(ExtractedNumberList extractedNumberList) {
        return extractedNumberList.log;
    }

    static /* synthetic */ IFrameworkAccess access$300(ExtractedNumberList extractedNumberList) {
        return extractedNumberList.framework;
    }

    static /* synthetic */ IFrameworkAccess access$400(ExtractedNumberList extractedNumberList) {
        return extractedNumberList.framework;
    }

    static /* synthetic */ void access$500(ExtractedNumberList extractedNumberList, ExtractedItemListRow extractedItemListRow) {
        extractedNumberList.callNumber(extractedItemListRow);
    }

    static /* synthetic */ void access$600(ExtractedNumberList extractedNumberList, ExtractedItemListRow extractedItemListRow) {
        extractedNumberList.prepareNumber(extractedItemListRow);
    }

    static /* synthetic */ void access$700(ExtractedNumberList extractedNumberList, int n, int n2) {
        extractedNumberList.extractedNumbersButton(n, n2);
    }

    static /* synthetic */ LogChannel access$800(ExtractedNumberList extractedNumberList) {
        return extractedNumberList.log;
    }
}

