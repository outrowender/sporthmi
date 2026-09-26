/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.combi.bap.CombiBAPController;
import de.audi.app.media.extension.IContentProvider;
import de.audi.app.media.extension.IMediaTerminalExtension;
import de.esolutions.fw.util.commons.Buffer;

public class MediaCombiBAPTerminalExtension
implements IMediaTerminalExtension {
    private static final String LOGCLASS;
    private volatile CombiBAPController bapController;

    @Override
    public void initExtension(IMediaTerminal iMediaTerminal) {
        iMediaTerminal.getLogger().main().log(1078071040, "[%1.initExtension]", (Object)"MediaCombiBAPTerminalExtension");
        this.bapController = new CombiBAPController(iMediaTerminal);
        this.bapController.init();
    }

    @Override
    public void deinitExtension() {
        this.bapController.deinit();
    }

    @Override
    public IContentProvider getContentProvider() {
        return null;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("MediaCombiBAPTerminalExtension").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

