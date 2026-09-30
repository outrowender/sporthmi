/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyDispatcher;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.atip.storage.IStorageAccess;
import java.util.Map;

public class MediaStorage
implements IActionProxyListener {
    private static final String LOGCLASS = "MediaStorage";
    public static final int SK_IMPORT_ACTIVE = 2;
    public static final int SK_CONTENT_DVD_VIDEO_FORMAT = 170;
    public static final int SK_CONTENT_DVD_VIDEO_PM_LEVEL = 29;
    public static final int SK_CONTENT_DVD_VIDEO_PM_PASSWORD = 19;
    public static final int SK_CONTENT_DATA_VIDEO_FORMAT = 90;
    public static final int SK_CONTENT_DATA_VIDEO_NORM = 100;
    public static final int SK_PLAYER_REPEAT_SCOPE = 110;
    public static final int SK_PLAYER_MIX_MODE = 120;
    public static final int SK_CONTENT_VIDEOSTREAM_VIDEO_NORM = 160;
    public static final int SK_CONTENT_VIDEOSTREAM_VIDEO_FORMAT = 150;
    public static final int SK_SOURCE_LAST_ACTIVE_SLOT = 200;
    public static final int SK_SOURCE_LAST_ACTIVE_SOURCE = 210;
    public static final int SK_CONTENT_SLEEP_SCREEN_ENABLED = 220;
    public static final int SK_DISPLAY_SETTING_TV = 30;
    public static final int SK_DISPLAY_SETTING_AV1 = 40;
    public static final int SK_DISPLAY_SETTING_AV2 = 50;
    public static final int SK_DISPLAY_SETTING_DVD_VIDEO = 60;
    public static final int SK_DISPLAY_SETTING_FILE_VIDEO = 70;
    public static final int SK_DISPLAY_SETTING_AUX_VIDEOSTREAM = 80;
    public static final int SK_IMPORT_ENCODING_QUALITY = 240;
    public static final String DEFAULT_PML_PASSWORD = "1234";
    public static final int DEFAULT_PML_LEVEL = 0;
    private final IStorageAccess storageMgr;
    private final IMediaLogger logger;

    public MediaStorage(IMediaLogger iMediaLogger, IStorageAccess iStorageAccess, IActionProxyDispatcher iActionProxyDispatcher) {
        this.logger = iMediaLogger;
        this.storageMgr = iStorageAccess;
        iActionProxyDispatcher.addActionProxyListener(1005, 0, this);
        iActionProxyDispatcher.addActionProxyListener(1004, 0, this);
    }

    public IStorageAccess getStorageManager() {
        return this.storageMgr;
    }

    public void persist(int n, int n2) {
        this.logger.main().log(1000000, "[MediaStorage.persist] terminal=global, key='%1', value='%2'", (long)n, (long)n2);
        this.storageMgr.setInt(1002, n, n2);
    }

    public void persistByteArray(int n, byte[] byArray) {
        this.logger.main().log(10000000, "[%1.persistByteArray] '%2'", (Object)LOGCLASS, (long)n);
        this.storageMgr.setByteArray(1002, n, byArray);
    }

    public void persist(IMediaTerminal iMediaTerminal, int n, int n2) {
        this.logger.main().log(1000000, "[MediaStorage.persist]  key='%1', value='%2'", (long)n, (long)n2);
        this.storageMgr.setInt(1002, n, n2);
    }

    public void persistBool(int n, boolean bl) {
        this.logger.main().log(1000000, "[MediaStorage.persistBool] key='%1', value='%2'", (Object)String.valueOf(n), (Object)String.valueOf(bl));
        this.storageMgr.setBoolean(1002, n, bl);
    }

    public void persistString(int n, String string) {
        this.logger.main().log(1000000, "[MediaStorage.persistString] terminal=global,key='%2',value='%1'", (Object)string, (long)n);
        this.storageMgr.setString(1002, n, string);
    }

    public void persistString(IMediaTerminal iMediaTerminal, int n, String string) {
        this.logger.main().log(1000000, "[MediaStorage.persistString] terminal='%2',key='%3',value='%1'", (Object)string, (long)iMediaTerminal.getTerminalID(), (long)n);
        this.storageMgr.setString(1002, n, string);
    }

    public int load(int n, int n2, int n3, int n4) {
        int n5 = this.storageMgr.getInt(1002, n, n2);
        this.logger.main().log(1000000, "[MediaStorage.load] terminal=global,key='%1',value='%2'", (long)n, (long)n5);
        if (n5 < n3 || n5 > n4) {
            this.logger.main().log(100000, "[MediaStorage.load] Key '%1' out of valid range [%2,%3] -> %4.", (Object)new Integer(n), (Object)new Integer(n3), (Object)new Integer(n4), (Object)new Integer(n2));
            return n2;
        }
        return n5;
    }

    public byte[] loadByteArray(int n) {
        byte[] byArray = this.storageMgr.getByteArray(1002, n, new byte[0]);
        this.logger.main().log(10000000, "[%1.loadByteArray] '%2' ('%3' loaded)", (Object)LOGCLASS, (long)n, (long)byArray.length);
        return byArray;
    }

    public int load(IMediaTerminal iMediaTerminal, int n, int n2, int n3, int n4) {
        int n5 = this.storageMgr.getInt(1002, n, n2);
        this.logger.main().log(1000000, "[MediaStorage.load] terminal='%1',key='%2',value='%3'", (long)iMediaTerminal.getTerminalID(), (long)n, (long)n5);
        if (n5 < n3 || n5 > n4) {
            this.logger.main().log(100000, "[MediaStorage.load] Key '%1' out of valid range [%2,%3] -> %4.", (Object)new Integer(n), (Object)new Integer(n3), (Object)new Integer(n4), (Object)new Integer(n2));
            return n2;
        }
        return n5;
    }

    public String loadString(int n, String string) {
        this.logger.main().log(1000000, "[MediaStorage.loadString] terminal=global,key='%2',default='%1'", (Object)string, (long)n);
        return this.storageMgr.getString(1002, n, string);
    }

    public String loadString(IMediaTerminal iMediaTerminal, int n, String string) {
        this.logger.main().log(1000000, "[MediaStorage.loadString] terminal='%2',key='%3',default='%1'", (Object)string, (long)iMediaTerminal.getTerminalID(), (long)n);
        return this.storageMgr.getString(1002, n, string);
    }

    public boolean loadBool(IMediaTerminal iMediaTerminal, int n, boolean bl) {
        this.logger.main().log(1000000, "[MediaStorage.loadBool] terminal='%1',key='%2',default='%3'", (long)iMediaTerminal.getTerminalID(), (long)n, bl);
        return this.storageMgr.getBoolean(1002, n, bl);
    }

    public int getRegionCodeChangesLeft() {
        byte[] byArray = new byte[]{0, 0, 3, 0};
        byte[] byArray2 = this.storageMgr.getByteArray(0, -1073479674, byArray);
        int n = this.parseByteArrayChangesLeft(byArray2);
        this.logger.main().log(1000000, "[MediaStorage.getRegionCodeChangesLeft] '%1'", (long)n);
        return n;
    }

    private int parseByteArrayChangesLeft(byte[] byArray) {
        this.logger.main().log(1000000, "[%1.parseByteArrayChangesLeft]", (Object)LOGCLASS);
        byte by = byArray[2];
        return by;
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1005: {
                this.logger.main().log(1000000, "[MediaStorage.actionProxyCallPerformed] AP_METHOD_SETTINGS_ENTERED");
                this.storageMgr.enterSetupScreen();
                break;
            }
            case 1004: {
                this.logger.main().log(1000000, "[MediaStorage.actionProxyCallPerformed] AP_METHOD_SETTINGS_LEAVED");
                this.storageMgr.exitSetupScreen();
                break;
            }
        }
    }
}

