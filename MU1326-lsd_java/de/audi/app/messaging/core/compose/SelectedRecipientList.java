/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.ISelectedRecipientListObserver;
import de.audi.app.messaging.core.compose.SelectedRecipientList$MyBaseListModelListener;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.recipients.RecipientListRow;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.messaging.MatchedAddress;

public final class SelectedRecipientList
extends AbstractMessagingComponent {
    public static final int RECIPIENT_INDEX_NONE;
    private static volatile long nextRowId;
    private final BaseListModelApp listModel;
    private final List recipientsTo = new LinkedList();
    private final List recipientsCc = new LinkedList();
    private final List recipientsBcc = new LinkedList();
    private final CopyOnWriteArrayList observers = new CopyOnWriteArrayList();

    public SelectedRecipientList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getBaseListModel(-913170176);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(new SelectedRecipientList$MyBaseListModelListener(this, null));
    }

    public void addObserver(ISelectedRecipientListObserver iSelectedRecipientListObserver) {
        this.log.log(-2137614336, "[SelectedRecipientList#addObserver] observer = %1", (Object)iSelectedRecipientListObserver);
        this.observers.add(iSelectedRecipientListObserver);
    }

    public BaseListModelApp getListModel() {
        return this.listModel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear(int n) {
        this.log.log(-2137614336, "[SelectedRecipientList#clear]");
        boolean bl = n == 0;
        boolean bl2 = n == 1;
        boolean bl3 = n == 2;
        boolean bl4 = n == 3;
        SelectedRecipientList selectedRecipientList = this;
        synchronized (selectedRecipientList) {
            if (bl || bl2) {
                this.recipientsTo.clear();
            }
            if (bl || bl3) {
                this.recipientsCc.clear();
            }
            if (bl || bl4) {
                this.recipientsBcc.clear();
            }
        }
        this.refresh();
        this.emitIndicateRecipientsCleared();
    }

    public int getLength() {
        return this.listModel.getLength();
    }

    public boolean isEmpty() {
        return this.getLength() <= 0;
    }

    public RecipientListRow getRow(int n) {
        return (RecipientListRow)this.listModel.getRow(n);
    }

    public synchronized List getRecipientsTo() {
        return SelectedRecipientList.toMatchedAddressList(this.recipientsTo);
    }

    public synchronized List getRecipientsCc() {
        return SelectedRecipientList.toMatchedAddressList(this.recipientsCc);
    }

    public synchronized List getRecipientsBcc() {
        return SelectedRecipientList.toMatchedAddressList(this.recipientsBcc);
    }

    public MatchedAddress getPrimaryRecipient() {
        MatchedAddress matchedAddress = null;
        List list = null;
        if (!this.recipientsTo.isEmpty()) {
            list = this.getRecipientsTo();
        } else if (!this.recipientsCc.isEmpty()) {
            list = this.getRecipientsCc();
        } else if (!this.recipientsBcc.isEmpty()) {
            list = this.getRecipientsBcc();
        }
        if (list != null && !list.isEmpty()) {
            matchedAddress = (MatchedAddress)list.get(0);
        }
        return matchedAddress;
    }

    public void addRecipientsTo(MatchedAddress[] matchedAddressArray) {
        this.log.log(-2137614336, "[SelectedRecipientList#addRecipientsTo] recipients.length = %1", (long)matchedAddressArray.length);
        this.addRecipients(matchedAddressArray, 1);
    }

    public void addRecipientsCc(MatchedAddress[] matchedAddressArray) {
        this.log.log(-2137614336, "[SelectedRecipientList#addRecipientsCc] recipients.length = %1", (long)matchedAddressArray.length);
        this.addRecipients(matchedAddressArray, 2);
    }

    public void addRecipientsBcc(MatchedAddress[] matchedAddressArray) {
        this.log.log(-2137614336, "[SelectedRecipientList#addRecipientsBcc] recipients.length = %1", (long)matchedAddressArray.length);
        this.addRecipients(matchedAddressArray, 3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRecipientsTo(MatchedAddress[] matchedAddressArray) {
        this.log.log(-2137614336, "[SelectedRecipientList#setRecipientsTo] recipients.length = %1", (long)matchedAddressArray.length);
        SelectedRecipientList selectedRecipientList = this;
        synchronized (selectedRecipientList) {
            this.recipientsTo.clear();
        }
        this.addRecipientsTo(matchedAddressArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addRecipients(MatchedAddress[] matchedAddressArray, int n) {
        RecipientListRow[] recipientListRowArray = new RecipientListRow[matchedAddressArray.length];
        SelectedRecipientList selectedRecipientList = this;
        synchronized (selectedRecipientList) {
            int n2;
            List list = n == 1 ? this.recipientsTo : (n == 2 ? this.recipientsCc : this.recipientsBcc);
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (n2 = 0; n2 < list.size(); ++n2) {
                long l = ((RecipientListRow)list.get(n2)).getMatchedAddress().getAdbEntryID();
                String string = ((RecipientListRow)list.get(n2)).getMatchedAddress().getAddress();
                linkedList.add(Util.createLong(l));
                linkedList2.add(string);
            }
            for (n2 = 0; n2 < matchedAddressArray.length; ++n2) {
                RecipientListRow recipientListRow;
                if (!linkedList.contains(Util.createLong(matchedAddressArray[n2].getAdbEntryID()))) {
                    recipientListRow = new RecipientListRow(matchedAddressArray[n2], n, nextRowId++);
                    list.add(recipientListRow);
                    recipientListRowArray[n2] = recipientListRow;
                    continue;
                }
                if (!linkedList2.contains(matchedAddressArray[n2].getAddress())) {
                    recipientListRow = new RecipientListRow(matchedAddressArray[n2], n, nextRowId++);
                    list.add(recipientListRow);
                    recipientListRowArray[n2] = recipientListRow;
                    continue;
                }
                this.log.log(1078071040, new StringBuffer().append("[SelectedRecipientList#addRecipients] id=%1, address=").append(matchedAddressArray[n2].getAddress()).append(" already available into the recipients").toString(), matchedAddressArray[n2].getAdbEntryID());
            }
        }
        this.refresh();
        this.emitIndicateRecipientsAdded(recipientListRowArray);
    }

    private static List toMatchedAddressList(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add(((RecipientListRow)iterator.next()).getMatchedAddress());
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeRecipient(RecipientListRow recipientListRow) {
        this.log.log(-2137614336, "[SelectedRecipientList#removeRecipient] recipientListRow = %1", (Object)recipientListRow);
        int n = recipientListRow.getRecipientType();
        long l = recipientListRow.getUniqueID();
        SelectedRecipientList selectedRecipientList = this;
        synchronized (selectedRecipientList) {
            List list = n == 1 ? this.recipientsTo : (n == 2 ? this.recipientsCc : this.recipientsBcc);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (l != ((RecipientListRow)iterator.next()).getUniqueID()) continue;
                iterator.remove();
                break;
            }
        }
        int n2 = this.listModel.getIndexForUniqueID(recipientListRow.getUniqueID());
        this.listModel.remove(recipientListRow);
        this.emitIndicateRecipientsRemoved(new RecipientListRow[]{recipientListRow});
        this.msgApp.getNewMessage().recipientCountChanged(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refresh() {
        String string;
        this.log.log(-2137614336, "[SelectedRecipientList#refresh]");
        int n = this.getLength();
        this.listModel.removeAll();
        SelectedRecipientList selectedRecipientList = this;
        synchronized (selectedRecipientList) {
            Iterator iterator = this.recipientsTo.iterator();
            while (iterator.hasNext()) {
                this.listModel.append((RecipientListRow)iterator.next());
            }
            iterator = this.recipientsCc.iterator();
            while (iterator.hasNext()) {
                this.listModel.append((RecipientListRow)iterator.next());
            }
            iterator = this.recipientsBcc.iterator();
            while (iterator.hasNext()) {
                this.listModel.append((RecipientListRow)iterator.next());
            }
            string = SelectedRecipientList.toText(this.recipientsTo);
        }
        int n2 = this.getLength();
        this.framework.getHMIService().getTextfieldModel(-1735253760).setText1(string);
        if (n != n2) {
            int n3 = n2 == 0 ? 1 : 0;
            this.framework.getHMIService().getTextfieldModel(-1735253760).setStatus(n3);
            this.msgApp.getNewMessage().recipientCountChanged(-1);
        }
    }

    private static String toText(List list) {
        Buffer buffer = new Buffer(32);
        Iterator iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            MatchedAddress matchedAddress = ((RecipientListRow)iterator.next()).getMatchedAddress();
            String string = matchedAddress.getName();
            if (!Strings.isNullOrEmpty(string)) {
                buffer.append(string);
            } else {
                buffer.append(matchedAddress.getAddress());
            }
            if (n < list.size() - 1) {
                buffer.append("; ");
            }
            ++n;
        }
        return buffer.toString();
    }

    private void emitIndicateRecipientsCleared() {
        this.log.log(-2137614336, "[SelectedRecipientList#emitIndicateRecipientsCleared]");
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISelectedRecipientListObserver)iterator.next()).indicateRecipientsCleared();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SelectedRecipientList#emitIndicateRecipientsCleared]");
            }
        }
    }

    private void emitIndicateRecipientsAdded(RecipientListRow[] recipientListRowArray) {
        this.log.log(-2137614336, "[SelectedRecipientList#emitIndicateRecipientsAdded]");
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISelectedRecipientListObserver)iterator.next()).indicateRecipientsAdded(recipientListRowArray);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SelectedRecipientList#emitIndicateRecipientsAdded]");
            }
        }
    }

    private void emitIndicateRecipientsRemoved(RecipientListRow[] recipientListRowArray) {
        this.log.log(-2137614336, "[SelectedRecipientList#emitIndicateRecipientsRemoved]");
        Iterator iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            try {
                ((ISelectedRecipientListObserver)iterator.next()).indicateRecipientsRemoved(recipientListRowArray);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[SelectedRecipientList#emitIndicateRecipientsRemoved]");
            }
        }
    }

    static /* synthetic */ LogChannel access$100(SelectedRecipientList selectedRecipientList) {
        return selectedRecipientList.log;
    }

    static {
        nextRowId = 0L;
    }
}

