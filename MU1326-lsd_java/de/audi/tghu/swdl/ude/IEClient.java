/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;

public interface IEClient {
    public static final int DEFAULT_USER;
    public static final int IE_CLIENT_ADDRESSBOOK;
    public static final int IE_CLIENT_SOUND;
    public static final int IE_CLIENT_NAVI_HB;
    public static final int IE_CLIENT_NAVI_HMI;
    public static final int IE_CLIENT_NAVI_ASIA;
    public static final int IE_CLIENT_BROWSER;
    public static final int IE_CLIENT_BROWSER_BOOKMARK;
    public static final File WORKING_DIR;
    public static final int EXCHANGE_DIR_LENGTH;
    public static final String NAME_BASE;
    public static final String NAME_ZIP;
    public static final String NAME_ENC;
    public static final String NAME_DEC;
    public static final File FILE_ZIP;
    public static final File FILE_ZIP_ENC;
    public static final File FILE_ZIP_DEC;

    default public int getID() {
    }

    default public File getFile() {
    }

    default public void addService(Object object) {
    }

    default public void removeService(Object object) {
    }

    default public void startImport(AbstractIETask abstractIETask) {
    }

    default public void startExport(AbstractIETask abstractIETask) {
    }

    static {
        WORKING_DIR = new File("/net/mmx/mnt/ota/UDE_5TdJe94x");
        EXCHANGE_DIR_LENGTH = WORKING_DIR.getAbsolutePath().length() + 1;
        FILE_ZIP = new File(WORKING_DIR, "ude.zip");
        FILE_ZIP_ENC = new File(WORKING_DIR, "ude_aes.enc");
        FILE_ZIP_DEC = new File(WORKING_DIR, "ude_aes.dec");
    }
}

