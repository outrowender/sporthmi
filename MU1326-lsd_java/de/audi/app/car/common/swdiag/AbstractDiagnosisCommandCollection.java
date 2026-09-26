/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.IDiagnosisCommand;
import de.audi.app.car.common.swdiag.IDiagnosisCommandCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDiagnosisCommandCollection
implements IDiagnosisCommandCollection {
    private Map commands = new HashMap(3);

    protected void addCommand(IDiagnosisCommand iDiagnosisCommand) {
        this.commands.put(iDiagnosisCommand.getCommandString(), iDiagnosisCommand);
    }

    @Override
    public Collection getDiagnosisCommands() {
        return this.commands.values();
    }
}

