/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.info.app.InfoEnv;

public class InfoStorageManager
implements MsgListener {
    private static final int TMC_ANNOUNCEMENT_DEFAULT_VALUE = 0;
    private static final int TEL_ANNOUNCEMENT_DEFAULT_VALUE = 0;
    private static final int AUTO_REDIRECT_DEFAULT_VALUE = 1;
    private IStorageAccess storage;
    private LogChannel logCh;
    private int telAnnouncementCache;
    private int autoRedirectCache;
    private int tmcAnnouncementCache;
    private final InfoEnv env;

    public InfoStorageManager(InfoEnv infoEnv, IStorageAccess iStorageAccess, LogChannel logChannel) {
        this.env = infoEnv;
        this.logCh = logChannel;
        this.storage = iStorageAccess;
        this.restoreAutoRedirectValue();
        this.restoreTelAnnouncementValue();
        this.restoreTmcAnnouncementValue();
    }

    public void processMsg(int n) {
        if (n == 24) {
            this.logCh.log(10000000, "[InfoStorageManager#processMessage] Restore factory settings. ");
            this.env.getChoiceModel(500161).setValue(1);
            this.env.getChoiceModel(500171).setValue(0);
            this.env.getChoiceModel(500170).setValue(0);
        }
    }

    private void restoreAutoRedirectValue() {
        int n = 1;
        n = this.storage.getInt(1005, 10, 1);
        this.logCh.log(10000000, "[InfoStorageManager#restoreAutoRedirectValue] Called, value: %1 ", (long)n);
        if (0 > n && n > 1) {
            this.logCh.log(100000, "[InfoStorageManager#restoreAutoRedirectValue] Invalid value: %1, using default %2 ", (long)n, 1L);
            n = 1;
        }
        this.autoRedirectCache = n;
        this.env.getChoiceModel(500161).setValue(n);
    }

    private void restoreTelAnnouncementValue() {
        int n = 0;
        n = this.storage.getInt(1005, 20, 0);
        this.logCh.log(10000000, "[InfoStorageManager#restoreTelAnnouncementValue] Called, value: %1 ", (long)n);
        if (0 > n && n > 1) {
            this.logCh.log(100000, "[InfoStorageManager#restoreTelAnnouncementValue] Invalid value: %1, using default %2 ", (long)n, 0L);
            n = 0;
        }
        this.telAnnouncementCache = n;
        this.env.getChoiceModel(500171).setValue(n);
    }

    private void restoreTmcAnnouncementValue() {
        int n = 0;
        n = this.storage.getInt(1005, 30, 0);
        this.logCh.log(10000000, "[InfoStorageManager#restoreTmcAnnouncementValue] Called, value: %1 ", (long)n);
        if (0 > n && n > 2) {
            this.logCh.log(100000, "[InfoStorageManager#restoreTmcAnnouncementValue] Invalid value: %1, using default %2 ", (long)n, 0L);
            n = 0;
        }
        this.tmcAnnouncementCache = n;
        this.env.getChoiceModel(500170).setValue(n);
    }

    void saveAutoRedirectValue(int n) {
        if (this.autoRedirectCache == n) {
            this.logCh.log(10000000, "[InfoStorageManager#saveAutoRedirectValue] Do nothing, cached value is equal to new value. ");
            return;
        }
        this.logCh.log(10000000, "[InfoStorageManager#saveAutoRedirectValue] Called, value: %1 ", (long)n);
        this.storage.setInt(1005, 10, n);
        this.autoRedirectCache = n;
    }

    void saveTelAnnouncementValue(int n) {
        if (this.telAnnouncementCache == n) {
            this.logCh.log(10000000, "[InfoStorageManager#saveTelAnnouncementValue] Do nothing, cached value is equal to new value. ");
            return;
        }
        this.logCh.log(10000000, "[InfoStorageManager#saveTelAnnouncementValue] Called, value: %1 ", (long)n);
        this.storage.setInt(1005, 20, n);
        this.telAnnouncementCache = n;
    }

    void saveTmcAnnouncementValue(int n) {
        if (this.tmcAnnouncementCache == n) {
            this.logCh.log(10000000, "[InfoStorageManager#saveTmcAnnouncementValue] Do nothing, cached value is equal to new value. ");
            return;
        }
        this.logCh.log(10000000, "[InfoStorageManager#saveTmcAnnouncementValue] Called, value: %1 ", (long)n);
        this.storage.setInt(1005, 30, n);
        this.tmcAnnouncementCache = n;
    }
}

