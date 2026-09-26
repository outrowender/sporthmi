/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.source.LastModeManager;
import de.audi.app.media.source.NoSourceActivationExtension;
import de.audi.app.media.source.SourceControllerHMIHandler;
import de.audi.app.media.source.SourceListProvider;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;

public class SourceControllerParameterFactory {
    public SourceListProvider createSourceListProvider(LogChannel logChannel) {
        return new SourceListProvider(logChannel);
    }

    public LastModeManager createLastModeManager(IMediaTerminal iMediaTerminal) {
        return new LastModeManager(iMediaTerminal);
    }

    public SourceControllerHMIHandler createSourceControllerHMIHandler(IMediaTerminal iMediaTerminal) {
        return new SourceControllerHMIHandler(iMediaTerminal);
    }

    public ArrayList createArrayList(int n) {
        return new ArrayList(n);
    }

    public NoSourceActivationExtension createNoSourceActivationExtension() {
        return new NoSourceActivationExtension();
    }
}

