/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceActivationExtension;
import de.audi.app.media.source.ISourceSlot;

public class SourceActivationEvoExtension
extends AbstractMediaTerminalComponent
implements ISourceActivationExtension {
    private static final String LOGCLASS;

    public SourceActivationEvoExtension(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    @Override
    public boolean slotsChanged(ISource[] iSourceArray, ISourceSlot iSourceSlot) {
        this.logger.main().log(1078071040, "[%1.slotsChanged] '%2'", (Object)"SourceActivationEvoExtension", (Object)iSourceSlot);
        for (int i2 = 0; i2 < iSourceArray.length; ++i2) {
            ISourceSlot iSourceSlot2;
            ISource iSource = iSourceArray[i2];
            if (iSource.getType() != iSourceSlot.getSource().getType() || (iSourceSlot2 = iSource.getActivatableSlot(iSourceSlot)).getIndex() == iSourceSlot.getIndex()) continue;
            this.logger.main().log(1078071040, "[%1.slotsChanged] change slot", (Object)"SourceActivationEvoExtension");
            ActivationContext activationContext = new ActivationContext(iSourceSlot2);
            this.getTerminal().getSourceController().activateSource(activationContext);
            return true;
        }
        return false;
    }
}

