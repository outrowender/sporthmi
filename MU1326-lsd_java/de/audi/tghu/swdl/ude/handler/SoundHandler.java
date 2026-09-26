/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.tghu.swdl.ude.handler.AbstractClient;
import de.audi.tghu.swdl.ude.tasks.AbstractIETask;
import java.io.File;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.browser.KeyboardInfo;

public class SoundHandler
extends AbstractClient
implements DSISoundListener {
    private DSISound dsi;

    public SoundHandler(LogChannel logChannel) {
        super(logChannel, new File(WORKING_DIR, "audio"));
        this.dsi = new NullDSISound(logChannel);
    }

    public String toString() {
        return "SoundHandler";
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void addService(Object object) {
        this.lc.log(-2137614336, "[SoundHandler.registerDSI] DSISound:%1", object);
        this.dsi = (DSISound)object;
    }

    @Override
    public void removeService(Object object) {
        this.lc.log(-2137614336, "[SoundHandler.removeService] %1", object);
        this.dsi = new NullDSISound(this.lc);
    }

    @Override
    public void startExport(AbstractIETask abstractIETask) {
        this.lc.log(-2137614336, "[SoundHandler.startExport] -> DSISound.createExportFile(%1, %2)", (Object)this.file, 0L);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.createExportFile(this.file, 0);
    }

    @Override
    public void startImport(AbstractIETask abstractIETask) {
        if (!new File(this.file).exists()) {
            this.lc.log(1078071040, "[SoundHandler.startImport] File not found: %1", (Object)this.file);
            abstractIETask.updateClientResult(this, this.file, false, true);
            return;
        }
        this.lc.log(-2137614336, "[SoundHandler.startImport] -> DSISound.importFile(%1, %2)", (Object)this.file, 0L);
        this.setTask(abstractIETask);
        this.longRunningTaskTimer.restart();
        this.dsi.importFile(this.file, 0);
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
        this.lc.log(-2137614336, "[SoundHandler] <- DSISoundListener.createExportFileResult(%1)", bl);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[SoundHandler.createExportFileResult]", (Throwable)exception);
        }
    }

    @Override
    public void importFileResponse(int n, boolean bl) {
        this.lc.log(-2137614336, "[SoundHandler] <- DSISoundListener.importFileResponse(%1)", bl);
        try {
            this.longRunningTaskTimer.cancel();
            this.getTask().updateClientResult(this, this.file, bl, true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[SoundHandler.importFileResponse]", (Throwable)exception);
        }
    }

    @Override
    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

