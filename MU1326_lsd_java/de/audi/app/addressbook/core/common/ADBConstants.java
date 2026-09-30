/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.atip.interapp.addressbook.ADBCommonConstants;

public class ADBConstants
implements ADBCommonConstants {
    public static final String ADB_MAIN_LOG_CHANNEL = "App.AddressBook.Main";
    public static final String ADB_CMDLIST_LOG_CHANNEL = "App.AddressBook.Main.CmdList";
    public static final String ADB_SEARCH_LOG_CHANNEL = "App.AddressBook.Main.Search";
    public static final String ADB_VCARD_EXCHANGE_LOG_CHANNEL = "App.AddressBook.VCardExchange";
    public static final String ADB_VCARD_EXCHANGE_CMDLIST_LOG_CHANNEL = "App.AddressBook.VCardExchangeCmdList";
    public static final String ADB_COMBI_LOG_CHANNEL = "App.AddressBook.Combi";
    public static final String ADB_COMBI_CMDLIST_LOG_CHANNEL = "App.AddressBook.CombiCmdList";
    public static final int ADB_DOWNLOAD_OVERFLOW = 0;
    public static final int ADB_DOWNLOAD_OK = 1;
    public static final int ADB_DOWNLOAD_OK_NO_CHANGES = 2;
    public static final int ADB_DOWNLOAD_UNFINISHED = 3;
    public static final int PHONETYPES_ALL_CATS_PATTERN = 8184;
    public static final int PHONETYPES_ALL_TYPES_PATTERN = 6;
    public static final int ADB_INIT_LIST_DSI_AVAILABLE = 1;
    public static final int ADB_INIT_PROFILE_INFO_AVAILABLE = 4;
    public static final int ADB_INIT_INIT_DSI_AVAILABLE = 8;
    public static final int ADB_INIT_STATE_INIT = 16;
    public static final int ADB_INIT_STATE_READY = 32;
    public static final int ADB_INIT_EDIT_DSI_AVAILABLE = 64;
    public static final int ADB_INIT_SETUP_DSI_AVAILABLE = 128;
    public static final int ADB_INIT_VCARD_EXCHANGE_DSI_AVAILABLE = 256;
    public static final int ADB_INIT_STARTUP_COMPLETE = 253;
    public static final int ADB_PHONE_INIT_STARTUP_COMPLETE = 229;
    public static final int ADB_NAVI_INIT_STARTUP_COMPLETE = 229;
    public static final int ADB_MSG_INIT_STARTUP_COMPLETE = 229;
    public static final int ADB_COMBI_INIT_STARTUP_COMPLETE = 229;
    public static final int ADB_VCARD_INIT_STARTUP_COMPLETE = 485;
    public static final int MAX_TEXT_FIELD_LENGTH = 64;
    public static final int MAX_LENGTH_NAME_FAMILY = 40;
    public static final int MAX_LENGTH_NAME_FAMILY_PHONETIC = 40;
    public static final int MAX_LENGTH_NAME_GIVEN = 40;
    public static final int MAX_LENGTH_NAME_GIVEN_PHONETIC = 40;
    public static final int MAX_LENGTH_PHONE_NUMBER = 40;
    public static final int MAX_LENGTH_EMAIL = 64;
    public static final int MAX_LENGTH_COUNTRY = 30;
    public static final int MAX_LENGTH_REGION = 30;
    public static final int MAX_LENGTH_ZIPCODE = 10;
    public static final int MAX_LENGTH_LOCALITY = 40;
    public static final int MAX_LENGTH_STREET = 40;
    public static final int MODULE_ID = 7;
    public static final int ADB_MODE_TEL = 0;
    public static final int ADB_MODE_NAV = 1;
    public static final int ADB_MODE_MAIL = 2;
    public static final int DEFAULT_VIEW_WINDOW_SIZE = 20;
    public static final int DEFAULT_SPELLER_LIST_SIZE = 1;
    public static final int MAX_PHONE_NUMBERS = 5;
    public static final int MAX_EMAILS = 3;
    public static final int MAX_TOP_DEST_ENTRIES = 20;
    public static final int SPELLER_HANDLE_NO_SPELLER_HANDLE = -1;
    public static final String VCARD_IMPORT_FILE_EXTENSION = "vcf";
    public static final char VCARD_GEO_POS_SEPARATOR_CHAR = ';';
    public static final int ADR_LEFT = 0;
    public static final int ADR_ENTERED = 1;
    public static final int ADR_SEARCH_ENTERED = 2;
    public static final int BUSINESS = 0;
    public static final int PRIVATE = 1;
}

