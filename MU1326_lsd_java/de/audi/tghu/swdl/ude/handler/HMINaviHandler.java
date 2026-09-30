/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEClient;
import de.audi.tghu.swdl.ude.IEStorage;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class HMINaviHandler
implements IEClient {
    private static final File IE_FILE_NAVI_HMI = new File(WORKING_DIR, "navigation_hmi");
    private final LogChannel lc;
    private final IEStorage storage;

    public HMINaviHandler(IEStorage iEStorage, LogChannel logChannel) {
        this.lc = logChannel;
        this.storage = iEStorage;
    }

    public int getID() {
        return 3;
    }

    public String toString() {
        return "HMINaviHandler";
    }

    public void addService(Object object) {
    }

    public void removeService(Object object) {
    }

    public File getFile() {
        return IE_FILE_NAVI_HMI;
    }

    public void startExport(AbstractIETask abstractIETask) {
        this.lc.log(10000000, "[HMINaviHandler.startExport]");
        boolean bl = this.exportToFile(IE_FILE_NAVI_HMI);
        abstractIETask.updateClientResult(this, IE_FILE_NAVI_HMI.getAbsolutePath(), bl, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean exportToFile(File file) {
        boolean bl;
        this.lc.log(10000000, "[HMINaviHandler.exportToFile] %1", (Object)file.getAbsolutePath());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bl = this.exportData(fileOutputStream);
                fileOutputStream.flush();
            }
            finally {
                try {
                    fileOutputStream.close();
                }
                catch (IOException iOException) {
                    this.lc.log(10000, "[HMINaviHandler.exportToFile] failed to close file", (Throwable)iOException);
                }
            }
        }
        catch (IOException iOException) {
            this.lc.log(10000, "[HMINaviHandler.exportToFile] failed to export to file", (Throwable)iOException);
            return false;
        }
        return bl;
    }

    public boolean exportData(OutputStream outputStream) {
        this.lc.log(10000000, "[HMINaviHandler.exportData]");
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try {
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 840, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 850, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 860, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 870, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 880, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 890, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 900, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 940, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 991, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 992, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 993, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 994, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 995, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 996, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 997, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 998, new byte[0], ""));
            HMINaviHandler.writeByteArray(dataOutputStream, this.storage.load(1004, 941, new byte[0], ""));
            dataOutputStream.flush();
        }
        catch (IOException iOException) {
            this.lc.log(10000, "[HMINaviHandler.exportData] failed to export data", (Throwable)iOException);
            return false;
        }
        return true;
    }

    private static void writeByteArray(DataOutputStream dataOutputStream, byte[] byArray) throws IOException {
        dataOutputStream.writeInt(byArray.length);
        dataOutputStream.write(byArray);
    }

    public void startImport(AbstractIETask abstractIETask) {
        this.lc.log(10000000, "[HMINaviHandler.startImport]");
        boolean bl = this.importFromFile(IE_FILE_NAVI_HMI);
        abstractIETask.updateClientResult(this, IE_FILE_NAVI_HMI.getAbsolutePath(), bl, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean importFromFile(File file) {
        boolean bl;
        this.lc.log(10000000, "[HMINaviHandler.importFromFile] %1", (Object)file.getAbsolutePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                bl = this.importData(fileInputStream);
            }
            finally {
                try {
                    fileInputStream.close();
                }
                catch (IOException iOException) {
                    this.lc.log(10000, "[HMINaviHandler.importFromFile] failed to close file", (Throwable)iOException);
                }
            }
        }
        catch (IOException iOException) {
            this.lc.log(10000, "[HMINaviHandler.importFromFile] failed to import from file", (Throwable)iOException);
            return false;
        }
        return bl;
    }

    public boolean importData(InputStream inputStream) {
        this.lc.log(10000000, "[HMINaviHandler.importData]");
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            this.storage.save(1004, 840, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 850, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 860, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 870, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 880, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 890, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 900, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 940, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 991, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 992, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 993, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 994, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 995, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 996, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 997, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 998, HMINaviHandler.readByteArray(dataInputStream), "");
            this.storage.save(1004, 941, HMINaviHandler.readByteArray(dataInputStream), "");
        }
        catch (IOException iOException) {
            this.lc.log(10000, "[HMINaviHandler.importData] failed to import data", (Throwable)iOException);
            return false;
        }
        return true;
    }

    private static byte[] readByteArray(DataInputStream dataInputStream) throws IOException {
        int n = dataInputStream.readInt();
        byte[] byArray = new byte[n];
        dataInputStream.readFully(byArray);
        return byArray;
    }
}

