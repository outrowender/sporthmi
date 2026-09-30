/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSIAdbSetup;
import de.audi.tghu.swdl.ude.handler.AbstractClient;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbSetupListener;

public class AddressbookHandler
extends AbstractClient
implements DSIAdbSetupListener {
    private DSIAdbSetup dsi;

    public AddressbookHandler(LogChannel logChannel) {
        super(logChannel, new File(WORKING_DIR, "addressbook"));
        this.dsi = new NullDSIAdbSetup(logChannel);
    }

    public String toString() {
        return "AddressbookHandler";
    }

    public int getID() {
        return 0;
    }

    public void addService(Object object) {
        this.lc.log(10000000, "[NaviHandler.registerDSI] DSIAdbSetup:%1", object);
        this.dsi = (DSIAdbSetup)object;
    }

    public void removeService(Object object) {
        this.lc.log(10000000, "[NaviHandler.removeDSI] DSIAdbSetup:%1", object);
        this.dsi = new NullDSIAdbSetup(this.lc);
    }

    public void startExport(AbstractIETask abstractIETask) {
        this.lc.log(10000000, "[Addressbookhandler.startExport] -> DSIAdbSetup.createBackupFile( %1 )", (Object)this.file);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.createBackupFile(this.file);
    }

    public void startImport(AbstractIETask abstractIETask) {
        if (!new File(this.file).exists()) {
            this.lc.log(1000000, "[Addressbookhandler.startImport] File not found: %1", (Object)this.file);
            abstractIETask.updateClientResult(this, this.file, false, true);
            return;
        }
        this.lc.log(10000000, "[Addressbookhandler.startImport] -> DSIAdbSetup.importBackupFile( %1 )", (Object)this.file);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.importBackupFile(this.file);
    }

    public void createBackupFileResult(int n, String string) {
        boolean bl = n == 0;
        this.lc.log(10000000, "[AddressbookHandler.createBackupFileResult] fullPath:%1 success:%2", (Object)string, (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[AddressbookHandler.createBackupFileResult]", (Throwable)exception);
        }
    }

    public void importBackupFileResult(int n, String string) {
        boolean bl = n == 0;
        this.lc.log(10000000, "[AddressbookHandler.importBackupFileResult] fullPath:%1 success:%2", (Object)string, (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[AddressbookHandler.importBackupFileResult]", (Throwable)exception);
        }
    }

    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

