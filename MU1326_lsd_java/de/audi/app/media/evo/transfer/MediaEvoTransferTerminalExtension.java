/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.audi.app.media.transfer.AbstractTransferHMIHandler;
import de.audi.app.media.transfer.TransferLogger;

public class MediaEvoTransferTerminalExtension
implements IMediaTerminalExtension {
    private static final String LOGCLASS = "MediaEvoTransferTerminalExtension";
    private volatile TransferLogger logger;
    private AbstractTransferHMIHandler transferHMIHandler;

    public void initExtension(IMediaTerminal iMediaTerminal) {
        this.logger = new TransferLogger(iMediaTerminal.getFramework());
        this.logger.main().log(1000000, "[%1.initExtension]", (Object)LOGCLASS);
        if (iMediaTerminal.getConfiguration().isImportEnabled() || iMediaTerminal.getConfiguration().isRippingEnabled()) {
            this.transferHMIHandler = new EvoTransferController(iMediaTerminal);
            this.transferHMIHandler.init();
        } else {
            this.logger.main().log(1000000, "[%1.initExtension] Import disabled.", (Object)LOGCLASS);
            this.transferHMIHandler = null;
        }
    }

    public void deinitExtension() {
        this.logger.main().log(1000000, "[%1.deinitExtension]", (Object)LOGCLASS);
        if (this.transferHMIHandler != null) {
            this.transferHMIHandler.deinit();
        }
    }

    public IContentProvider getContentProvider() {
        return null;
    }
}

