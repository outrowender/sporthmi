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
    private static final String LOGCLASS = "MediaVersionInfoHandler";
    private final IMediaDSIBaseController dsiController;

    public MediaVersionInfoHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.dsiController = iMediaTerminal.getDSIBaseController();
    }

    public void init() {
        this.logger.hmi().log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.dsiController.addMediaVersionListener(this);
    }

    public void deinit() {
        this.logger.hmi().log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.dsiController.removeMediaVersionListener(this);
    }

    public void updateMediaApplicationVersion(String string) {
        if (null == string) {
            return;
        }
        this.logger.hmi().log(1000000, "[%1.updateMediaApplicationVersion] '%2'", (Object)LOGCLASS, (Object)string);
        this.getLabelModel(3851).setText(string);
    }

    public void updateMetadataDBVersion(String string) {
        if (null == string) {
            return;
        }
        this.logger.hmi().log(1000000, "[%1.updateMetadataDBVersion] '%2'", (Object)LOGCLASS, (Object)string);
        this.getLabelModel(3850).setText(string);
    }

    public void updateCustomerUpdate(int n) {
        this.logger.hmi().log(1000000, "[%1.updateCustomerUpdate] '%2'", (Object)LOGCLASS, (long)n);
        this.getChoiceModel(4074).setValue(n);
    }
}

