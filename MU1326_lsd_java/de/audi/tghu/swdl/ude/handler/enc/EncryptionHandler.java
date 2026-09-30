/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler.enc;

import de.audi.atip.util.osgi.NullDSISWaP;
import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.handler.AbstractDSIListener;
import java.io.File;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.swap.DSISWaP;
import org.dsi.ifc.swap.DSISWaPListener;

public class EncryptionHandler
extends AbstractDSIListener
implements DSISWaPListener {
    private static final String ALGORITHM = "AES";
    private final byte[] AES_BASE_KEY = new byte[]{35, 20, 125, 39, 127, 105, -22, 59, 21, 81, 127, -39, 91, 50, 12, -89, -99, -61, 19, -80, 87, -7, 54, 22, -89, -98, 13, -57, -46, -53, 43, 42};
    private final IEApp ieApp;
    private DSISWaP dsi;

    public EncryptionHandler(IEApp iEApp) {
        super(iEApp.getLogChannel());
        this.ieApp = iEApp;
    }

    public String toString() {
        return "EncryptionHandler";
    }

    public void registerDSI(DSISWaP dSISWaP) {
        this.lc.log(10000000, "[EncryptionHandler.registerDSI] DSISWaP:%1", (Object)dSISWaP);
        this.dsi = dSISWaP;
    }

    public void removeDSI(DSISWaP dSISWaP) {
        this.lc.log(10000000, "[EncryptionHandler.removeDSI] DSISWaP:%1", (Object)dSISWaP);
        this.dsi = new NullDSISWaP(this.lc);
    }

    protected void longRunningTaskAborted() {
        this.lc.log(10000, "[EncryptionHandler.longRunningTaskAborted]");
        this.ieApp.encryptionFinished(false);
    }

    public void encrypt(File file) {
        if (this.dsi == null) {
            this.lc.log(10000, "[EncryptionHandler.encrypt] Missing DSISWaP!");
            this.ieApp.encryptionFinished(false);
            return;
        }
        String string = file.getAbsolutePath();
        this.lc.log(10000000, "[EncryptionHandler.encrypt] file:%1", (Object)file);
        this.lc.log(10000000, "[EncryptionHandler.encrypt] -> DSISWaP.encryptFile(%1, %2, %3)", (Object)ALGORITHM, (Object)string, (Object)this.AES_BASE_KEY);
        this.longRunningTaskTimer.restart();
        this.dsi.encryptFile(ALGORITHM, string, this.AES_BASE_KEY);
    }

    public void decrypt(File file) {
        if (this.dsi == null) {
            this.lc.log(10000, "[EncryptionHandler.decrypt] Missing DSISWaP!");
            this.ieApp.encryptionFinished(false);
            return;
        }
        String string = file.getAbsolutePath();
        this.lc.log(10000000, "[EncryptionHandler.decrypt] file:%1", (Object)file);
        this.lc.log(10000000, "[EncryptionHandler.decrypt] -> DSISwdlSelection.decryptFile(%1, %2, %3)", (Object)ALGORITHM, (Object)string, (Object)this.AES_BASE_KEY);
        this.longRunningTaskTimer.restart();
        this.dsi.decryptFile(ALGORITHM, string, this.AES_BASE_KEY);
    }

    public void decryptFile(String string, int n) {
        this.lc.log(10000000, "[EncryptionHandler] <- DSISWaPListener.decryptFile(%1, %2)", (Object)string, (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            boolean bl = n == 1;
            this.ieApp.decryptionFinished(bl);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[EncryptionHandler.decryptFile]", (Throwable)exception);
        }
    }

    public void encryptFile(String string, int n) {
        this.lc.log(10000000, "[EncryptionHandler] <- DSISWaPListener.encryptFile(%1, %2)", (Object)string, (long)n);
        try {
            this.longRunningTaskTimer.cancel();
            this.ieApp.encryptionFinished(n == 1);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[EncryptionHandler.encryptFile]", (Throwable)exception);
        }
    }

    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
    }

    public void updateMapIntegrationState(int n, int n2) {
    }

    public void updateMapIntegrationProgress(int n, int n2) {
    }

    public void etcTriggerNavigationRestartResult(int n, int n2) {
    }

    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
    }

    public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

