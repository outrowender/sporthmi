/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.preferredstations;

import de.audi.app.navi.evo.addressinput.poi.preferredstations.EvoPreferredStationsHMIListener;
import de.audi.tghu.navi.app.command.NavCommand;

class EvoPreferredStationsHMIListener$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ EvoPreferredStationsHMIListener this$0;

    EvoPreferredStationsHMIListener$1(EvoPreferredStationsHMIListener evoPreferredStationsHMIListener, int n, int n2) {
        this.this$0 = evoPreferredStationsHMIListener;
        this.val$model = n;
        this.val$terminal = n2;
    }

    @Override
    public void execute() {
        this.env.fireModelEvent(this.val$model, this.val$terminal);
        this.getCommandList().commandFinished();
    }
}

