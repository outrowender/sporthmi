/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;
import de.audi.tv.app.util.generics.Tuple;

public class TerminalModeMisc {
    public static void connectMiscModelsAndProperties(final TVEnv tVEnv) {
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600156);
        tVEnv.properties.terminalMode.currentTerminalAndScreenMode.map(TerminalAndScreenModeTuple.EXTRACT_TERMINALMODE_FUNCTION).subscribe(tVEnv.modelBindings.from(choiceModelApp).intValue());
        tVEnv.properties.audioFocus.muHasTvAudioFocus.combineWith(tVEnv.properties.audioFocus.sdisHasTvAudioFocus).using(Tuple.combine()).distinctUntilChanged().subscribe(new Consumer<Tuple<Boolean, Boolean>>(){

            @Override
            public void accept(Tuple<Boolean, Boolean> tuple) {
                if (!((Boolean)tuple.a).booleanValue() && !((Boolean)tuple.b).booleanValue()) {
                    tVEnv.lcMain.log(10000000, "[TerminalModeMisc] Reset tm because lost of all audio focusses.");
                    tVEnv.properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Tuple)object);
            }
        });
    }
}

