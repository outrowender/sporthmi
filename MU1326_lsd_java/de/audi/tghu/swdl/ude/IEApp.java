/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.tasks.CleanupTask;
import java.util.List;

public interface IEApp {
    public static final String MOUNT_POINT = "/fs";
    public static final String PREFIX_USB = "usb";
    public static final String PREFIX_SDCARD = "sd";
    public static final int MEDIUM_USB = 0;
    public static final int MEDIUM_SD = 1;
    public static final int RUN_IMPORT = 0;
    public static final int RUN_EXPORT = 1;
    public static final int RESULT_IMPORT_SUCCESS = 0;
    public static final int RESULT_EXPORT_SUCCESS = 1;
    public static final int RESULT_IMPORT_FAILURE = 2;
    public static final int RESULT_EXPORT_FAILURE = 3;
    public static final int STATUS_PROGRESS_SCREEN = 0;
    public static final int STATUS_RESULT_SCREEN = 1;

    public LogChannel getLogChannel();

    public void importFinished(boolean var1);

    public void exportFinished(boolean var1);

    public void zipFinished(boolean var1);

    public void unzipFinished(boolean var1);

    public void encryptionFinished(boolean var1);

    public void decryptionFinished(boolean var1);

    public void copyFinished(boolean var1);

    public void mountFinished(boolean var1);

    public CleanupTask getCleanupTask();

    public List getFiles();
}

