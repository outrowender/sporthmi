/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.mapcode;

import de.audi.app.navi.evo.mapcode.MapCodeRightDrawerListener;
import de.audi.app.navi.evo.mapcode.MapcodeInputManager;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.mapcode.CoreMapCodeInputManager;
import de.audi.tghu.navi.app.di.mapcode.IMapcodeService;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.util.Util;

public class MapcodeServiceEvo
implements IMapcodeService {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final ICommandListFactory commandListFactory;
    private CoreMapCodeInputManager inputManager = null;
    private final SpellerStack spellerStack;
    private final IPreviewMap previewMap;
    private final LogChannel logChannel;
    private final ILocationDisambiguatorSequence locationDisambiguatonSequence;
    private final ILocationDisambiguatorPopupHandler locationDisambiguatonPopupHandler;
    private final MapInterface mapInterface;
    private final Monitor mapCodeCommandListMonitor;

    public MapcodeServiceEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, MapInterface mapInterface, ILocationDisambiguatorSequence iLocationDisambiguatorSequence, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.previewMap = mapInterface.getPreviewMap();
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.mapInterface = mapInterface;
        this.locationDisambiguatonSequence = iLocationDisambiguatorSequence;
        this.locationDisambiguatonPopupHandler = iLocationDisambiguatorPopupHandler;
        this.mapCodeCommandListMonitor = new Monitor(this.logChannel);
        this.initMapcodeInput();
        if (!this.isInputManagerReady() && this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "***** %1 WASN'T ABLE TO CREATE THE INPUT MANAGER. MAPCODE INPUT WILL NOT BE WORKING *****", (Object)this.CLASS_NAME);
        }
    }

    private void initMapcodeInput() {
        if (Util.isHURegionJP()) {
            this.inputManager = new MapcodeInputManager(this.env, this.commandListFactory, this.spellerStack, this.previewMap, this.locationDisambiguatonSequence, this.locationDisambiguatonPopupHandler);
            new MapCodeRightDrawerListener(this.env, this.mapInterface, this.locationDisambiguatonSequence, this.locationDisambiguatonPopupHandler);
        } else if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "**** %1#initMapcodeInput - region is NOT AVAILABLE ****", (Object)this.CLASS_NAME);
        }
    }

    private boolean isInputManagerReady() {
        return this.inputManager != null;
    }

    @Override
    public void enterMapcodeScreen() {
        if (!this.mapCodeCommandListMonitor.isActive()) {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapcodeScreen - starting command list").toString());
            CommandList commandList = this.inputManager.getMapcodeScreenListener().getStartCommandList();
            commandList.addMonitor(this.mapCodeCommandListMonitor);
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#enterMapcodeScreen").toString());
        } else {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterMapcodeScreen - the command list to start map code is still running - ignoring further calls.").toString());
        }
    }
}

