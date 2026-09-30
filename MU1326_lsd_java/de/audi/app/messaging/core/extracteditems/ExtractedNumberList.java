/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.extracteditems.ExtractedItemListRow;
import de.audi.app.messaging.core.extracteditems.ExtractedItems;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.PhoneServices;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.messaging.ExtractedItem;

public final class ExtractedNumberList
extends AbstractMessagingComponent {
    private static volatile long nextRowId = 0L;
    private static final int ITEM_OFFSET_NA = -1;
    private static final int ITEM_LENGTH_NA = -1;
    private static final int ACTION_DIAL = 0;
    private static final int ACTION_PREPARE = 1;
    private static final int ACTION_DIAL_PORSCHE = 1;
    private static final int ACTION_PREPARE_PORSCHE = 0;
    private final BaseListModelApp listModel;
    private volatile ExtractedItem primaryContactNumber = null;
    private volatile ExtractedItem[] extractedItems = new ExtractedItem[0];

    public ExtractedNumberList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(2200272);
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new MyBaseListModelListener());
        this.framework.getHmiServiceApp().getButtonModel(2200178).setButtonListener(new MyButtonListener());
    }

    public void clear() {
        this.log.log(10000000, "[ExtractedNumberList#clear]");
        this.primaryContactNumber = null;
        this.extractedItems = new ExtractedItem[0];
        this.listModel.removeAll();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public void setPrimaryContactNumber(String string) {
        this.log.log(10000000, "[ExtractedNumberList#setPrimaryContactNumber] primaryContactNumber = %1", (Object)string);
        this.primaryContactNumber = Strings.isNullOrEmpty(string) || !Strings.isValidNumber(string) ? null : new ExtractedItem(1, string, -1, -1);
        this.refresh();
    }

    public void setExtractedItems(ExtractedItem[] extractedItemArray) {
        this.log.log(10000000, "[ExtractedNumberList#setExtractedItems] extractedItems.length = %1", (Object)Arrays.getLengthAsString(extractedItemArray));
        this.extractedItems = extractedItemArray != null ? extractedItemArray : new ExtractedItem[]{};
        this.refresh();
    }

    private void refresh() {
        ExtractedItem extractedItem;
        this.log.log(10000000, "[ExtractedNumberList#refresh]");
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
            this.log.log(1000000, "[ExtractedNumberList#refresh] Ignored items that feature non-unique values.");
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
        this.log.log(10000000, "[ExtractedNumberList#callNumber] row = %1", (Object)extractedItemListRow);
        PhoneServices.callUnmatchedNumber(extractedItemListRow.getItemValue(), this.log, this.msgApp);
    }

    private void prepareNumber(ExtractedItemListRow extractedItemListRow) {
        this.log.log(10000000, "[ExtractedNumberList#prepareNumber] row = %1", (Object)extractedItemListRow);
        PhoneServices.prepareUnmatchedNumber(extractedItemListRow.getItemValue(), this.log, this.msgApp);
    }

    private void extractedNumbersButton(int n, int n2) {
        this.log.log(1000000, "[ExtractedNumberList#extractedNumbersButton]");
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200178) {
                ExtractedNumberList.this.extractedNumbersButton(n, n3);
            } else {
                ExtractedNumberList.this.log.log(10000, "[ExtractedNumberList#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private class MyBaseListModelListener
    extends DefaultBaseListModelListener {
        private MyBaseListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ExtractedNumberList.this.log.log(1000000, "[ExtractedNumberList#itemSelected] row = %1, col = %2", (Object)evoListRow, (long)n3);
            if (ExtractedNumberList.this.framework.getSysConst(4168) == 7 || ExtractedNumberList.this.framework.getSysConst(4168) == 5) {
                this.proceedActionForPorsche(evoListRow, n3);
            } else {
                this.proceedActionForAudi(evoListRow, n3);
            }
        }

        private void proceedActionForPorsche(EvoListRow evoListRow, int n) {
            if (n == 1) {
                ExtractedNumberList.this.callNumber((ExtractedItemListRow)evoListRow);
            } else if (n == 0) {
                ExtractedNumberList.this.prepareNumber((ExtractedItemListRow)evoListRow);
            }
        }

        private void proceedActionForAudi(EvoListRow evoListRow, int n) {
            if (n == 0) {
                ExtractedNumberList.this.callNumber((ExtractedItemListRow)evoListRow);
            } else if (n == 1) {
                ExtractedNumberList.this.prepareNumber((ExtractedItemListRow)evoListRow);
            }
        }
    }
}

