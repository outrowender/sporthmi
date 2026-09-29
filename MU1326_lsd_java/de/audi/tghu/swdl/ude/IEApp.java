/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.tasks.CleanupTask;
import java.util.List;

public interface IEApp {
    public static final String MOUNT_POINT;
    public static final String PREFIX_USB;
    public static final String PREFIX_SDCARD;
    public static final int MEDIUM_USB;
    public static final int MEDIUM_SD;
    public static final int RUN_IMPORT;
    public static final int RUN_EXPORT;
    public static final int RESULT_IMPORT_SUCCESS;
    public static final int RESULT_EXPORT_SUCCESS;
    public static final int RESULT_IMPORT_FAILURE;
    public static final int RESULT_EXPORT_FAILURE;
    public static final int STATUS_PROGRESS_SCREEN;
    public static final int STATUS_RESULT_SCREEN;

    default public LogChannel getLogChannel() {
    }

    default public void importFinished(boolean bl) {
    }

    default public void exportFinished(boolean bl) {
    }

    default public void zipFinished(boolean bl) {
    }

    default public void unzipFinished(boolean bl) {
    }

    default public void encryptionFinished(boolean bl) {
    }

    default public void decryptionFinished(boolean bl) {
    }

    default public void copyFinished(boolean bl) {
    }

    default public void mountFinished(boolean bl) {
    }

    default public CleanupTask getCleanupTask() {
    }

    default public List getFiles() {
    }
}

