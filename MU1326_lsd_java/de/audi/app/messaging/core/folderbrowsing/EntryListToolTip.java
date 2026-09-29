/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.folderbrowsing.EntryListToolTip$EntryListObserver;
import de.audi.app.messaging.core.folderbrowsing.EntryListToolTipRow;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Times;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.TooltipModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageListEntry;

public final class EntryListToolTip
extends AbstractMessagingComponent {
    private final TooltipModelApp tooltipModel;

    public EntryListToolTip(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.tooltipModel = this.framework.getHmiServiceApp().getTooltipModel(1888624896);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.tooltipModel.setMaxColumns(5);
        this.tooltipModel.setMaxRows(3);
        abstractMsgApplication.getEntryList().addObserver(new EntryListToolTip$EntryListObserver(this, null));
    }

    private void setTooltip(EntryListRow entryListRow) {
        try {
            ListEntry listEntry = entryListRow.getListEntry();
            if (this.log.isDebug()) {
                this.log.log(-2137614336, "[EntryListToolTip#setTooltip] entryListRow.getListEntry = %1", (Object)String.valueOf(listEntry));
            }
            this.tooltipModel.clear();
            if (ListEntries.isMessage(listEntry)) {
                MessageListEntry messageListEntry = listEntry.getMessageListEntry();
                int n = 0;
                EntryListToolTipRow entryListToolTipRow = null;
                EntryListToolTipRow entryListToolTipRow2 = null;
                EntryListToolTipRow entryListToolTipRow3 = null;
                entryListToolTipRow = this.createEntryListToolTipRow(entryListRow, 0);
                if (Times.isTimeStampValid(messageListEntry.getDateTime())) {
                    entryListToolTipRow2 = this.createEntryListToolTipRow(entryListRow, 1);
                }
                if (messageListEntry.getType() == 2) {
                    entryListToolTipRow3 = this.createEntryListToolTipRow(entryListRow, 2);
                }
                if (entryListToolTipRow != null) {
                    ++n;
                }
                if (entryListToolTipRow2 != null) {
                    ++n;
                }
                if (entryListToolTipRow3 != null) {
                    ++n;
                }
                ListRow[] listRowArray = new ListRow[n];
                int n2 = 0;
                if (entryListToolTipRow != null) {
                    listRowArray[n2++] = entryListToolTipRow;
                }
                if (entryListToolTipRow2 != null) {
                    listRowArray[n2++] = entryListToolTipRow2;
                }
                if (entryListToolTipRow3 != null) {
                    listRowArray[n2++] = entryListToolTipRow3;
                }
                this.tooltipModel.setData(listRowArray);
            }
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EntryListToolTip#setTooltip]");
        }
    }

    private EntryListToolTipRow createEntryListToolTipRow(EntryListRow entryListRow, int n) {
        EntryListToolTipRow entryListToolTipRow = null;
        try {
            entryListToolTipRow = new EntryListToolTipRow(entryListRow, n, this.msgApp.getTextLookup());
        }
        catch (Exception exception) {
            this.log.log(10000, "[EntryListToolTip#createEntryListToolTipRow] Error creating EntryListToolTipRow, recordset = %1: %2", (long)n, (Throwable)exception);
        }
        return entryListToolTipRow;
    }

    static /* synthetic */ LogChannel access$100(EntryListToolTip entryListToolTip) {
        return entryListToolTip.log;
    }

    static /* synthetic */ void access$200(EntryListToolTip entryListToolTip, EntryListRow entryListRow) {
        entryListToolTip.setTooltip(entryListRow);
    }
}

