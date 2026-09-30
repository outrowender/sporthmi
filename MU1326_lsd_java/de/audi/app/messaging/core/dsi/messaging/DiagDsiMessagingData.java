/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingCompatibility;
import java.util.Random;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.Template;

public class DiagDsiMessagingData {
    private static final String BODY = "Hallo Willi, habe herausgefunden: Wenn dein Abstand vom Park & Ride-Parkplatz an der U-Bahnstation \"Konstabler Wache\" < 750m und > 150m ist, gibt's Probleme mit dem GPS-Empfang. Hallo Willi, habe herausgefunden: Wenn dein Abstand vom Park & Ride-Parkplatz an der U-Bahnstation \"Konstabler Wache\" < 750m und > 150m ist, gibt's Probleme mit dem GPS-Empfang. Hallo Willi, habe herausgefunden: Wenn dein Abstand vom Park & Ride-Parkplatz an der U-Bahnstation \"Konstabler Wache\" < 750m und > 150m ist, gibt's Probleme mit dem GPS-Empfang. ";
    static final AttachmentInformation TEXT_FILE_ATTACHMENT;
    static final AttachmentInformation VCARD_ATTACHMENT;
    private static final AttachmentInformation[] ATTACHMENTS;
    static final MessageDetails MESSAGE_DETAILS_SMS;
    static final MessageDetails MESSAGE_DETAILS_SMS_PART1;
    static final MessageDetails MESSAGE_DETAILS_SMS_PART2;
    static final MessageDetails MESSAGE_DETAILS_SMS_PART3;
    public static final MessageDetails[] CONCAT_SMS;
    public static final MessageDetails MESSAGE_DETAILS_EMAIL;
    public static final FolderEntry ROOT_FOLDER;
    private static final FolderEntry[] FOLDER_ENTRIES;
    private static final MessageListEntry[] MSG_LIST_ENTRIES;
    public static final ListEntry[] LIST_ENTRIES;
    public static final MessagingAccount[] MSG_ACCOUNTS;
    public static Template[] templates;
    public static final ExtractedItem[] EXTRACTED_ITEMS;

    static {
        int n;
        TEXT_FILE_ATTACHMENT = new AttachmentInformation(4711, "sometext.txt", "text/plain", 938, 5822, new ResourceLocator("/foo/bar/"));
        VCARD_ATTACHMENT = new AttachmentInformation(4712, "somebody.vcf", "text/x-vcard", 438, 6933, new ResourceLocator("/foo/bar/"));
        ATTACHMENTS = new AttachmentInformation[]{TEXT_FILE_ATTACHMENT, VCARD_ATTACHMENT};
        MESSAGE_DETAILS_SMS = new MessageDetails(0, "0", 1, new MatchedAddress("1234", "Wilhelm Conrad R\u00f6ntgen", 0L, null), new MatchedAddress[0], new MatchedAddress[0], new MatchedAddress[0], "", System.currentTimeMillis(), 4, "1234", BODY, new AttachmentInformation[]{VCARD_ATTACHMENT}, 2, new int[]{BODY.length()}, 1);
        MESSAGE_DETAILS_SMS_PART1 = new MessageDetails(0, "1337", 1, new MatchedAddress("1234", "Sender Mit Schlechtem Empfang", 0L, null), new MatchedAddress[0], new MatchedAddress[0], new MatchedAddress[0], "", System.currentTimeMillis(), 4, "1234", "Der mittlere Teil ist nun da!!", new AttachmentInformation[0], 2, new int[]{-1, 30, -1}, 1);
        MESSAGE_DETAILS_SMS_PART2 = new MessageDetails(0, "1337", 1, new MatchedAddress("1234", "Sender Mit Schlechtem Empfang", 0L, null), new MatchedAddress[0], new MatchedAddress[0], new MatchedAddress[0], "", System.currentTimeMillis(), 4, "1234", "Der mittlere Teil ist nun da!!Der letzte Teil ist dabei!!!!!", new AttachmentInformation[0], 2, new int[]{-1, 60}, 1);
        MESSAGE_DETAILS_SMS_PART3 = new MessageDetails(0, "1337", 1, new MatchedAddress("1234", "Sender Mit Schlechtem Empfang", 0L, null), new MatchedAddress[0], new MatchedAddress[0], new MatchedAddress[0], "", System.currentTimeMillis(), 4, "1234", "Der erste Teil nun auch da!!!!Der mittlere Teil ist nun da!!Der letzte Teil ist dabei!!!!!", new AttachmentInformation[0], 2, new int[]{90}, 1);
        CONCAT_SMS = new MessageDetails[]{MESSAGE_DETAILS_SMS_PART1, MESSAGE_DETAILS_SMS_PART2, MESSAGE_DETAILS_SMS_PART3};
        MESSAGE_DETAILS_EMAIL = new MessageDetails(1, "1", 2, new MatchedAddress("wilhelm.conrad.roentgen@googlemail.com", "Wilhelm Conrad R\u00f6ntgen", 0L, null), new MatchedAddress[]{new MatchedAddress("max.planck@yahoo.de", "Max Planck", 0L, null)}, new MatchedAddress[]{new MatchedAddress("heinrich.hertz@t-online.de", "Heinrich Hertz", 0L, null)}, new MatchedAddress[]{new MatchedAddress("heisenberg@web.de", "Werner Heisenberg", 0L, null)}, "Neues Untersuchungsergebnis", System.currentTimeMillis(), 4, "wilhelm.conrad.roentgen@googlemail.com", BODY, ATTACHMENTS, 2, new int[]{BODY.length()}, 1);
        ROOT_FOLDER = new FolderEntry(0, -1, 5, "ROOT", 0);
        FOLDER_ENTRIES = new FolderEntry[]{new FolderEntry(1, ROOT_FOLDER.getFolderID(), 7, "DELETED", 0), new FolderEntry(2, ROOT_FOLDER.getFolderID(), 3, "DRAFTS", 0), new FolderEntry(3, ROOT_FOLDER.getFolderID(), 1, "INBOX", 3), new FolderEntry(4, ROOT_FOLDER.getFolderID(), 2, "OUTBOX", 0), new FolderEntry(5, ROOT_FOLDER.getFolderID(), 4, "SENT", 0), new FolderEntry(6, ROOT_FOLDER.getFolderID(), 6, "TEMPLATES", 0), new FolderEntry(7, ROOT_FOLDER.getFolderID(), 5, "A user-defined folder", 0), new FolderEntry(8, ROOT_FOLDER.getFolderID(), 5, "Another user-defined folder", 0)};
        MSG_LIST_ENTRIES = new MessageListEntry[42];
        long l = System.currentTimeMillis();
        Random random = new Random(l);
        for (int i2 = 0; i2 < MSG_LIST_ENTRIES.length; ++i2) {
            int n2 = i2 % 10 == 0 ? 3 : (i2 % 2 == 0 ? 1 : 2);
            long l2 = 0L;
            int n3 = i2 % 7 + 1;
            long l3 = random.nextLong();
            long l4 = l3 == Long.MIN_VALUE ? 0L : Math.abs(l3);
            String string = l4 % 2L == 0L ? "Matched Name" : "";
            String string2 = n2 == 1 ? "Matched Number" : "Matched Email";
            MatchedAddress matchedAddress = new MatchedAddress(string2, string, 0L, null);
            l2 = i2 % 2 == 0 ? l - l4 % 63072000000L : l - l4 % 86400000L;
            DiagDsiMessagingData.MSG_LIST_ENTRIES[i2] = new MessageListEntry(matchedAddress, Integer.toString(i2), 0, string2, null, l2, n3, "Subject " + i2, 0, 2, n2, 1);
        }
        DiagDsiMessagingData.MSG_LIST_ENTRIES[0].type = 4;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[1].type = 2;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[1].messageStatus = 4;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[1].priority = 3;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[2].type = 1;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[2].messageStatus = 4;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[2].attachmentSize = 4711;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[3].type = 2;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[3].messageStatus = 4;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[3].attachmentSize = 4711;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[4].matchedAddress = new MatchedAddress();
        DiagDsiMessagingData.MSG_LIST_ENTRIES[5].subject = "";
        DiagDsiMessagingData.MSG_LIST_ENTRIES[6].dateTime = 0L;
        DiagDsiMessagingData.MSG_LIST_ENTRIES[7].dateTime = System.currentTimeMillis();
        DiagDsiMessagingData.MSG_LIST_ENTRIES[8].matchedAddress = new MatchedAddress(DiagDsiMessagingData.MSG_LIST_ENTRIES[8].matchedAddress.getAddress(), "Archibald-Barrington Coopersmith MacStrawberry", 0L, null);
        DiagDsiMessagingData.MSG_LIST_ENTRIES[9].subject = "The garden strawberry is a widely grown hybrid species of the genus Fragaria (collectively known as the strawberries).";
        DiagDsiMessagingData.MSG_LIST_ENTRIES[10] = new MessageListEntry(new MatchedAddress("1234", "Sender Mit Schlechtem Empfang", 0L, null), Integer.toString(1337), 0, "Concatenated SMS", null, System.currentTimeMillis(), 3, "", 0, 2, 1, 1);
        LIST_ENTRIES = new ListEntry[FOLDER_ENTRIES.length + MSG_LIST_ENTRIES.length];
        for (n = 0; n < FOLDER_ENTRIES.length; ++n) {
            DiagDsiMessagingData.LIST_ENTRIES[n] = new ListEntry(n, 1, FOLDER_ENTRIES[n], null);
        }
        for (n = 0; n < MSG_LIST_ENTRIES.length; ++n) {
            DiagDsiMessagingData.LIST_ENTRIES[DiagDsiMessagingData.FOLDER_ENTRIES.length + n] = new ListEntry(FOLDER_ENTRIES.length + n, 2, null, MSG_LIST_ENTRIES[n]);
        }
        MSG_ACCOUNTS = new MessagingAccount[]{DsiMessagingCompatibility.createMessagingAccount(0, "Account 0", 1, 1, false, 63, 0, "AA:BB:CC:DD", "", "89492086126009129266"), DsiMessagingCompatibility.createMessagingAccount(1, "Account 0", 4, 1, false, 63, 0, "AA:BB:CC:DD", "", "89492086126009129266"), DsiMessagingCompatibility.createMessagingAccount(2, "Account 0", 3, 1, false, 63, 0, "AA:BB:CC:DD", "Bluetooth Device 1", "89492086126009129266"), DsiMessagingCompatibility.createMessagingAccount(3, "Account 0", 2, 1, false, 63, 0, "AA:BB:CC:DD", "Bluetooth Device 2", "89492086126009129266"), DsiMessagingCompatibility.createMessagingAccount(4, "Account 1", 2, 0, true, 63, 0, "AA:BB:CC:DD", "Bluetooth Device 1", "89492086126009129266"), DsiMessagingCompatibility.createMessagingAccount(5, "Account 2", 2, 0, true, 63, 0, "AA:BB:CC:DD", "Bluetooth Device 2", "89492086126009129266")};
        templates = new Template[]{new Template(0, "FYI.", false), new Template(1, "Bin gerade losgefahren. Bis dann.", false), new Template(2, "Ich stehe im Stau. Komme sp\u00e4ter.", false), new Template(3, "Ich bin gleich da.", false), new Template(4, "Ich bin gerade noch unterwegs. Ich melde mich sp\u00e4ter wieder.", false), new Template(5, "Die Kurse fallen! Sofort verkaufen!", false), new Template(6, "Die Kurse steigen! Sofort kaufen!", false), new Template(7, "Bin gut angekommen, das Wetter ist sch\u00f6n und ich guter Dinge.", false), new Template(8, "Bin angekommen, das Wetter ist lausig und ich w\u00fcnschte jetzt schon, ich w\u00e4re gar nicht erst gefahren.", false), new Template(9, "AUTO-REPLY: Vielen Dank f\u00fcr ihre Mail. Leider bin ich im Moment im Urlaub und bis auf weiteres nicht erreichbar.", false)};
        EXTRACTED_ITEMS = new ExtractedItem[]{new ExtractedItem(1, "0815 47 11", 0, 10), new ExtractedItem(1, "0815 47 12", 20, 10), new ExtractedItem(1, "0815 47 13", 40, 10), new ExtractedItem(1, "0815 47 14", 60, 10), new ExtractedItem(2, "heisenberg@web.de", 80, 17), new ExtractedItem(2, "max.planck@yahoo.de", 100, 19), new ExtractedItem(3, "http://www.imdb.com/", 100, 20)};
    }
}

