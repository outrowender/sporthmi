/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;
import de.audi.tv.app.tm.handling.TerminalModeMisc$1;
import de.audi.tv.app.util.generics.Tuple;

public class TerminalModeMisc {
    public static void connectMiscModelsAndProperties(TVEnv tVEnv) {
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(-592697600);
        tVEnv.properties.terminalMode.currentTerminalAndScreenMode.map(TerminalAndScreenModeTuple.EXTRACT_TERMINALMODE_FUNCTION).subscribe(tVEnv.modelBindings.from(choiceModelApp).intValue());
        tVEnv.properties.audioFocus.muHasTvAudioFocus.combineWith(tVEnv.properties.audioFocus.sdisHasTvAudioFocus).using(Tuple.combine()).distinctUntilChanged().subscribe((Consumer)new TerminalModeMisc$1(tVEnv));
    }
}

