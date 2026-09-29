/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observables$Combinator;
import de.audi.atip.utils.reactive.observables.Observables$Combinator4;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.DisplayContextHandler$1;
import de.audi.tv.app.tm.handling.DisplayContextHandler$2;
import de.audi.tv.app.tm.handling.DisplayContextHandler$Properties;

public class DisplayContextHandler {
    private static final Observables$Combinator4 TVPICTURE_ALLOWED_COMBINATOR = new DisplayContextHandler$1();
    private static final Observables$Combinator DISPLAY_CONTEXT_COMBINATOR = new DisplayContextHandler$2();

    public DisplayContextHandler(TVEnv tVEnv) {
        DisplayContextHandler$Properties displayContextHandler$Properties = tVEnv.properties.displayContext;
        tVEnv.properties.speedDisclaimer.speedDisclaimerShown.combineWith(tVEnv.properties.childlock.childlockActive).combineWith(tVEnv.properties.displayMode.currentDisplayMode).combineWith(tVEnv.properties.terminalMode.currentTerminalAndScreenMode).using(TVPICTURE_ALLOWED_COMBINATOR).subscribe((Consumer)DisplayContextHandler$Properties.access$000(displayContextHandler$Properties));
        displayContextHandler$Properties.tvPictureIsAllowedToBeShown.combineWith(tVEnv.properties.dmComponent.currentDisplayableId).using(DISPLAY_CONTEXT_COMBINATOR).subscribe((Consumer)DisplayContextHandler$Properties.access$100(displayContextHandler$Properties));
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(-1146345728);
        DisplayContextHandler$Properties.access$100(displayContextHandler$Properties).subscribe(tVEnv.modelBindings.from(choiceModelApp).intValue());
    }
}

