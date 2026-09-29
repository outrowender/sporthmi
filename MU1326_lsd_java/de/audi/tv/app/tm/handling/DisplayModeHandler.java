/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Observables$Combinator3;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.DisplayModeHandler$1;
import de.audi.tv.app.tm.handling.DisplayModeHandler$Properties;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class DisplayModeHandler {
    public static final int DISPLAYMODE_VIDEO;
    public static final int DISPLAYMODE_AUDIO;
    public static final int DISPLAYMODE_DATA;
    private static final Observables$Combinator3 DISPLAYMODE_CHOICE_COMBINATOR;

    public DisplayModeHandler(TVEnv tVEnv) {
        DisplayModeHandler$Properties displayModeHandler$Properties = tVEnv.properties.displayMode;
        tVEnv.properties.settings.visualAudioActive.combineWith(tVEnv.properties.source.currentSource).combineWith(tVEnv.properties.dsiProperties.selectAndSelectedService).using(DISPLAYMODE_CHOICE_COMBINATOR).async(tVEnv.dispatch).subscribe((Consumer)DisplayModeHandler$Properties.access$100(displayModeHandler$Properties));
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(-1515444480);
        displayModeHandler$Properties.currentDisplayMode.subscribe(tVEnv.modelBindings.from(choiceModelApp).intValue());
    }

    private static int getFullscreenType(ServiceInfo serviceInfo, boolean bl) {
        if (serviceInfo == null) {
            return 0;
        }
        switch (serviceInfo.sType) {
            case 3: 
            case 10: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 6: {
                return bl ? 0 : 1;
            }
        }
        return 0;
    }

    static /* synthetic */ int access$000(ServiceInfo serviceInfo, boolean bl) {
        return DisplayModeHandler.getFullscreenType(serviceInfo, bl);
    }

    static {
        DISPLAYMODE_CHOICE_COMBINATOR = new DisplayModeHandler$1();
    }
}

