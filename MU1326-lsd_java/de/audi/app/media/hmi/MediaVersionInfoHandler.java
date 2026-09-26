/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.hmi;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIBaseController;
import de.audi.app.media.dsi.media.IMediaVersionListener;

public class MediaVersionInfoHandler
extends AbstractMediaTerminalComponent
implements IMediaVersionListener {
    private static final String LOGCLASS;
    private final IMediaDSIBaseController dsiController;

    public MediaVersionInfoHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.dsiController = iMediaTerminal.getDSIBaseController();
    }

    public void init() {
        this.logger.hmi().log(1078071040, "[%1.init]", (Object)"MediaVersionInfoHandler");
        this.dsiController.addMediaVersionListener(this);
    }

    public void deinit() {
        this.logger.hmi().log(1078071040, "[%1.deinit]", (Object)"MediaVersionInfoHandler");
        this.dsiController.removeMediaVersionListener(this);
    }

    @Override
    public void updateMediaApplicationVersion(String string) {
        if (null == string) {
            return;
        }
        this.logger.hmi().log(1078071040, "[%1.updateMediaApplicationVersion] '%2'", (Object)"MediaVersionInfoHandler", (Object)string);
        this.getLabelModel(3851).setText(string);
    }

    @Override
    public void updateMetadataDBVersion(String string) {
        if (null == string) {
            return;
        }
        this.logger.hmi().log(1078071040, "[%1.updateMetadataDBVersion] '%2'", (Object)"MediaVersionInfoHandler", (Object)string);
        this.getLabelModel(3850).setText(string);
    }

    @Override
    public void updateCustomerUpdate(int n) {
        this.logger.hmi().log(1078071040, "[%1.updateCustomerUpdate] '%2'", (Object)"MediaVersionInfoHandler", (long)n);
        this.getChoiceModel(4074).setValue(n);
    }
}

