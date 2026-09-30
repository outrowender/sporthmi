/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.mapcode;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.mapcode.IMapCodeScreenListener;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.li.SpellerStack;

public abstract class CoreMapCodeInputManager {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected final IPreviewMap previewMap;
    protected IMapCodeScreenListener mapcodeScreenListener;
    protected final ILocationDisambiguatorSequence locationDisambiguatorSequence;
    protected final ILocationDisambiguatorPopupHandler locationDisambiguatonPopupHandler;

    public CoreMapCodeInputManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
        this.locationDisambiguatorSequence = iLocationDisambiguatorSequence;
        this.locationDisambiguatonPopupHandler = iLocationDisambiguatorPopupHandler;
    }

    protected abstract void initMapcodeScreenListener();

    public IMapCodeScreenListener getMapcodeScreenListener() {
        return this.mapcodeScreenListener;
    }
}

