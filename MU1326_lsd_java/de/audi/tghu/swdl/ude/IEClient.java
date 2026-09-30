/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;

public interface IEClient {
    public static final int DEFAULT_USER = 0;
    public static final int IE_CLIENT_ADDRESSBOOK = 0;
    public static final int IE_CLIENT_SOUND = 1;
    public static final int IE_CLIENT_NAVI_HB = 2;
    public static final int IE_CLIENT_NAVI_HMI = 3;
    public static final int IE_CLIENT_NAVI_ASIA = 4;
    public static final int IE_CLIENT_BROWSER = 5;
    public static final int IE_CLIENT_BROWSER_BOOKMARK = 6;
    public static final File WORKING_DIR = new File("/net/mmx/mnt/ota/UDE_5TdJe94x");
    public static final int EXCHANGE_DIR_LENGTH = WORKING_DIR.getAbsolutePath().length() + 1;
    public static final String NAME_BASE = "ude";
    public static final String NAME_ZIP = "ude.zip";
    public static final String NAME_ENC = "ude_aes.enc";
    public static final String NAME_DEC = "ude_aes.dec";
    public static final File FILE_ZIP = new File(WORKING_DIR, "ude.zip");
    public static final File FILE_ZIP_ENC = new File(WORKING_DIR, "ude_aes.enc");
    public static final File FILE_ZIP_DEC = new File(WORKING_DIR, "ude_aes.dec");

    public int getID();

    public File getFile();

    public void addService(Object var1);

    public void removeService(Object var1);

    public void startImport(AbstractIETask var1);

    public void startExport(AbstractIETask var1);
}

