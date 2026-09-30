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
    private static final String LOGCLASS = "MediaCombiBAPTerminalExtension";
    private volatile CombiBAPController bapController;

    public void initExtension(IMediaTerminal iMediaTerminal) {
        iMediaTerminal.getLogger().main().log(1000000, "[%1.initExtension]", (Object)LOGCLASS);
        this.bapController = new CombiBAPController(iMediaTerminal);
        this.bapController.init();
    }

    public void deinitExtension() {
        this.bapController.deinit();
    }

    public IContentProvider getContentProvider() {
        return null;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

