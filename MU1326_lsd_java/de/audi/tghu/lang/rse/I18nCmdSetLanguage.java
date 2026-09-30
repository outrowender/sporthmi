/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.lang.rse;

import de.audi.atip.base.FwServices;
import de.audi.atip.rse.AbstractRSEConnection;
import de.audi.tghu.lang.rse.AbstractI18nCmd;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class I18nCmdSetLanguage
extends AbstractI18nCmd {
    int languageIndex;

    public I18nCmdSetLanguage(FwServices fwServices) {
        super(fwServices, 4609);
    }

    public I18nCmdSetLanguage(FwServices fwServices, int n) {
        super(fwServices, 4609);
        this.languageIndex = n;
    }

    public void decode(DataInputStream dataInputStream) {
        log.log(10000000, "I18nCmdSetLanguage#decode: Encoding id %1", (long)this.id);
        try {
            this.languageIndex = dataInputStream.readInt();
        }
        catch (IOException iOException) {
            log.log(10000, "I18nCmdSetLanguage#decode: ", (Throwable)iOException);
        }
        log.log(10000000, "I18nCmdSetLanguage#encode: Decoding complete");
    }

    public void encode(DataOutputStream dataOutputStream) {
        log.log(10000000, "I18nCmdSetLanguage#encode: Encoding id %1", (long)this.id);
        try {
            this.encodeHeader(dataOutputStream);
            dataOutputStream.writeInt(this.languageIndex);
            dataOutputStream.flush();
        }
        catch (IOException iOException) {
            log.log(10000, "I18nCmdSetLanguage#encode: ", (Throwable)iOException);
        }
        log.log(10000000, "I18nCmdSetLanguage#encode: Encoding complete");
    }

    public void execute(AbstractRSEConnection abstractRSEConnection) {
        log.log(10000000, "I18nCmdSetLanguage#execute()");
        if (!this.getFwServices().getFramework().isFrontMU()) {
            // empty if block
        }
    }
}

