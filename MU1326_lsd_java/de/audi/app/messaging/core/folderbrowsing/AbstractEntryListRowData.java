/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.Folders;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.SearchResults;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.core.util.Times;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.TextLineList;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public abstract class AbstractEntryListRowData {
    private static final int RECORDSET_FOLDER = 0;
    private static final int RECORDSET_FOLDER_UNREAD_COUNT = 1;
    private static final int RECORDSET_MESSAGE = 2;
    private static final int RECORDSET_MESSAGE_TYPE_INFO = 3;
    private static final int ICON_FOLDER = 0;
    private static final int ICON_MSG_UNREAD = 1;
    private static final int ICON_MSG_READ = 2;
    private static final int ICON_MSG_BINARY = 3;
    private static final int ICON_MSG_SENT = 4;
    private static final int ICON_MSG_DRAFT = 6;
    private static final int ICON_MSG_HAS_ATTACHMENTS = 8;
    private static final int ICON_MSG_HIGH_IMPORTANCE = 9;
    private static final int ENTRY_TYPE_FOLDER = 0;
    private static final int ENTRY_TYPE_MSG_UNKNOWN = 1;
    private static final int ENTRY_TYPE_SMS_REGULAR = 2;
    private static final int ENTRY_TYPE_SMS_BINARY = 3;
    private static final int ENTRY_TYPE_EMAIL = 6;
    private final ListEntry listEntry;
    private final IEntryPropertyFactory entryPropertyFactory;
    private final int itemOffset;
    private final long currentTime;
    private final ITextLookup textLookup;
    private int isToggle;

    public AbstractEntryListRowData(ListEntry listEntry, IEntryPropertyFactory iEntryPropertyFactory, int n, long l, ITextLookup iTextLookup) {
        this.listEntry = listEntry;
        this.entryPropertyFactory = iEntryPropertyFactory;
        this.itemOffset = n;
        this.currentTime = l;
        this.textLookup = iTextLookup;
        this.isToggle = 0;
    }

    public abstract void setColumns(EvoListRow var1, AbstractEntryListRowData var2, SearchResult var3);

    public ListEntry getListEntry() {
        return this.listEntry;
    }

    public IEntryPropertyFactory getEntryPropertyFactory() {
        return this.entryPropertyFactory;
    }

    public int getItemOffset() {
        return this.itemOffset;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public ITextLookup getTextLookup() {
        return this.textLookup;
    }

    public abstract int getColumnCount();

    public int isToggle() {
        return this.isToggle;
    }

    public void setToggle(int n) {
        this.isToggle = n;
    }

    protected static boolean hasAttachments(ListEntry listEntry) {
        return ListEntries.isMessage(listEntry) && listEntry.getMessageListEntry().getAttachmentSize() > 0;
    }

    protected int getRecordSet(ListEntry listEntry) {
        int n;
        if (ListEntries.isFolder(listEntry)) {
            n = listEntry.getFolderEntry().getUnreadMessageCount() > 0 ? 1 : 0;
        } else {
            int n2 = listEntry.getMessageListEntry().getType();
            switch (n2) {
                case 1: 
                case 2: 
                case 3: 
                case 5: {
                    n = 2;
                    break;
                }
                default: {
                    n = 3;
                }
            }
        }
        return n;
    }

    protected int getIcon(ListEntry listEntry) {
        int n;
        if (ListEntries.isFolder(listEntry)) {
            n = 0;
        } else {
            boolean bl;
            MessageListEntry messageListEntry = listEntry.getMessageListEntry();
            int n2 = messageListEntry.getType();
            int n3 = messageListEntry.getMessageStatus();
            boolean bl2 = bl = messageListEntry.getPriority() == 3;
            n = n2 == 3 ? 3 : (n3 == 3 ? 2 : (n3 == 4 ? (bl ? 9 : (AbstractEntryListRowData.hasAttachments(listEntry) ? 8 : 1)) : (n3 == 2 ? 6 : (n3 == 6 ? 4 : 1))));
        }
        return n;
    }

    protected int getEntryType(ListEntry listEntry) {
        int n = 0;
        if (ListEntries.isFolder(listEntry)) {
            n = 0;
        } else {
            int n2 = listEntry.getMessageListEntry().getType();
            switch (n2) {
                case 3: {
                    n = 3;
                    break;
                }
                case 2: {
                    n = 6;
                    break;
                }
                case 5: {
                    n = 2;
                    break;
                }
                case 1: {
                    n = 2;
                    break;
                }
                default: {
                    n = 1;
                }
            }
        }
        return n;
    }

    protected String getFolderName(ListEntry listEntry, ITextLookup iTextLookup) {
        String string = "";
        if (ListEntries.isFolder(listEntry)) {
            FolderEntry folderEntry = listEntry.getFolderEntry();
            int n = 0;
            try {
                n = Folders.mapToHmiFolderType(folderEntry);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                n = 0;
            }
            switch (n) {
                case 2: {
                    string = iTextLookup.getFolderDeleted();
                    break;
                }
                case 3: {
                    string = iTextLookup.getFolderDrafts();
                    break;
                }
                case 4: {
                    string = iTextLookup.getFolderInbox();
                    break;
                }
                case 5: {
                    string = iTextLookup.getFolderOutbox();
                    break;
                }
                case 6: {
                    string = iTextLookup.getFolderSent();
                    break;
                }
                default: {
                    string = folderEntry.getFolderName();
                }
            }
        }
        return string;
    }

    protected String getUnreadMessageCount(ListEntry listEntry) {
        String string = "";
        if (ListEntries.isFolder(listEntry)) {
            string = String.valueOf(listEntry.getFolderEntry().getUnreadMessageCount());
        }
        return string;
    }

    protected TextListCellHighlightText getContactInfoHighlighted(SearchResult searchResult, ListEntry listEntry, ITextLookup iTextLookup) {
        Token[] tokenArray = searchResult.getTokens();
        TextLineList textLineList = new TextLineList();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 15);
        Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 16);
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            textLineList.addToken(token);
        } else if (!AbstractSearchResultFormatter.isEmpty(token2)) {
            textLineList.addToken(token2);
        } else {
            textLineList.addText(this.getContactInfo(listEntry, iTextLookup));
        }
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    protected String getContactInfo(ListEntry listEntry, ITextLookup iTextLookup) {
        String string = "";
        if (ListEntries.isMessage(listEntry)) {
            string = MessageContacts.getPrimaryContactInfo(listEntry.getMessageListEntry(), iTextLookup);
        }
        return string;
    }

    protected TextListCellHighlightText getSubjectHighlighted(SearchResult searchResult, ListEntry listEntry, ITextLookup iTextLookup) {
        Token token;
        Token[] tokenArray = searchResult.getTokens();
        TextLineList textLineList = new TextLineList();
        Token token2 = AbstractSearchResultFormatter.getTokenForType(tokenArray, 2);
        try {
            token = SearchResults.trimForSingleLineDisplay(token2);
        }
        catch (Exception exception) {
            token = token2;
        }
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            textLineList.addToken(token);
        } else {
            textLineList.addText(this.getSubject(listEntry, iTextLookup));
        }
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    protected String getSubject(ListEntry listEntry, ITextLookup iTextLookup) {
        String string = "";
        if (ListEntries.isMessage(listEntry)) {
            boolean bl;
            MessageListEntry messageListEntry = listEntry.getMessageListEntry();
            String string2 = Strings.trimForSingleLineDisplay(messageListEntry.getSubject());
            string = !Strings.isNullOrEmpty(string2) ? string2 : ((bl = Messages.isSms(messageListEntry)) ? iTextLookup.getSubjectNoneSms() : iTextLookup.getSubjectNoneEmail());
        }
        return string;
    }

    protected String getTimePrimary(ListEntry listEntry, long l, ITextLookup iTextLookup) {
        String string = "";
        if (ListEntries.isMessage(listEntry)) {
            long l2 = listEntry.getMessageListEntry().getDateTime();
            string = !Times.isTimeStampValid(l2) ? iTextLookup.getDateNone() : (Times.getTimestampCategory(l2, l) == 0 ? iTextLookup.getTimeToday() : Times.formatDate(l2));
        }
        return string;
    }

    protected String getTimeSecondary(ListEntry listEntry, ITextLookup iTextLookup) {
        String string = "";
        if (ListEntries.isMessage(listEntry)) {
            long l = listEntry.getMessageListEntry().getDateTime();
            string = !Times.isTimeStampValid(l) ? iTextLookup.getTimeOfDayNone() : Times.formatTime(l);
        }
        return string;
    }

    public int getIconId() {
        return this.getIcon(this.getListEntry());
    }

    public void toggleRow(EvoListRow evoListRow, boolean bl) {
    }

    public int getCheckBoxValue(EvoListRow evoListRow) {
        return -1;
    }
}

