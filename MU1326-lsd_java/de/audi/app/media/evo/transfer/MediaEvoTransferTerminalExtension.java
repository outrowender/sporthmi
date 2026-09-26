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
    private static final String LOGCLASS;
    private volatile TransferLogger logger;
    private AbstractTransferHMIHandler transferHMIHandler;

    @Override
    public void initExtension(IMediaTerminal iMediaTerminal) {
        this.logger = new TransferLogger(iMediaTerminal.getFramework());
        this.logger.main().log(1078071040, "[%1.initExtension]", (Object)"MediaEvoTransferTerminalExtension");
        if (iMediaTerminal.getConfiguration().isImportEnabled() || iMediaTerminal.getConfiguration().isRippingEnabled()) {
            this.transferHMIHandler = new EvoTransferController(iMediaTerminal);
            this.transferHMIHandler.init();
        } else {
            this.logger.main().log(1078071040, "[%1.initExtension] Import disabled.", (Object)"MediaEvoTransferTerminalExtension");
            this.transferHMIHandler = null;
        }
    }

    @Override
    public void deinitExtension() {
        this.logger.main().log(1078071040, "[%1.deinitExtension]", (Object)"MediaEvoTransferTerminalExtension");
        if (this.transferHMIHandler != null) {
            this.transferHMIHandler.deinit();
        }
    }

    @Override
    public IContentProvider getContentProvider() {
        return null;
    }
}

