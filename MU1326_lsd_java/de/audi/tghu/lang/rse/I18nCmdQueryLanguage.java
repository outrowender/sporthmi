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

public class I18nCmdQueryLanguage
extends AbstractI18nCmd {
    public I18nCmdQueryLanguage(FwServices fwServices) {
        super(fwServices, 4610);
    }

    public void decode(DataInputStream dataInputStream) {
        log.log(10000000, "I18nCmdQueryLanguage#decode: Decoding id %1", (long)this.id);
        log.log(10000000, "I18nCmdQueryLanguage#decode: Decoding complete");
    }

    public void encode(DataOutputStream dataOutputStream) {
        log.log(10000000, "I18nCmdQueryLanguage#encode: Encoding id %1", (long)this.id);
        try {
            this.encodeHeader(dataOutputStream);
            dataOutputStream.flush();
        }
        catch (IOException iOException) {
            log.log(10000, "I18nCmdQueryLanguage#encode: ", (Throwable)iOException);
        }
        log.log(10000000, "I18nCmdQueryLanguage#encode: Encoding complete");
    }

    public void execute(AbstractRSEConnection abstractRSEConnection) {
        log.log(10000000, "I18nCmdQueryLanguage#execute()");
        if (this.getFwServices().getFramework().isFrontMU()) {
            // empty if block
        }
    }
}

