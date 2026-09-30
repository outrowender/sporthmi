/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.mapcode;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.mapcode.MapcodeMatchSpellerModelAccess;
import de.audi.app.navi.evo.mapcode.MapcodeScreenListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.mapcode.CoreMapCodeInputManager;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.li.SpellerStack;

public class MapcodeInputManager
extends CoreMapCodeInputManager {
    public MapcodeInputManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        super(navigationEnv, iCommandListFactory, spellerStack, iPreviewMap, iLocationDisambiguatorSequence, iLocationDisambiguatorPopupHandler);
        this.initMapcodeScreenListener();
    }

    protected void initMapcodeScreenListener() {
        MapcodeMatchSpellerModelAccess mapcodeMatchSpellerModelAccess = new MapcodeMatchSpellerModelAccess(this.env, this.logChannel, DIScreensEvo.getDiJpMapcodeScreenSpellerModel(), DIScreensEvo.getDiJpMapcodeScreenButtonModel());
        MapcodeInputSequence mapcodeInputSequence = new MapcodeInputSequence(this.env, this.logChannel, this.commandListFactory, mapcodeMatchSpellerModelAccess, this.previewMap, this.spellerStack, this.locationDisambiguatorSequence);
        this.mapcodeScreenListener = new MapcodeScreenListener(this.env, this.logChannel, this.previewMap, mapcodeInputSequence, this.locationDisambiguatonPopupHandler, this.locationDisambiguatorSequence);
    }
}

