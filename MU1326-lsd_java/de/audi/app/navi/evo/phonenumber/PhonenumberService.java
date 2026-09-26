/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.IPhonenumberService;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputManager;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;

public class PhonenumberService
implements IPhonenumberService {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final NavigationEnv env;
    private final ICommandListFactory commandListFactory;
    private PhonenumberInputManager inputManager = null;
    private final SpellerStack spellerStack;
    private final IPreviewMap previewMap;
    private final LogChannel logChannel;
    private final IStartGuidanceToDestinationSequence startRouteGuidanceSequence;
    private final HomeAddressHandler homeAddressHandler;
    private final Monitor phoneNumberCommandListMonitor;

    public PhonenumberService(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
        this.startRouteGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.homeAddressHandler = homeAddressHandler;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.phoneNumberCommandListMonitor = new Monitor(this.logChannel);
        this.initPhonenumberInput();
        if (!this.isInputManagerReady() && this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "***** %1 WASN'T ABLE TO CREATE THE INPUT MANAGER. PHONENUMBER INPUT WILL NOT BE WORKING *****", (Object)this.CLASS_NAME);
        }
    }

    private void initPhonenumberInput() {
        if (Util.isHURegionJP() || Util.isHURegionKR()) {
            this.inputManager = new PhonenumberInputManager(this.env, this.logChannel, this.commandListFactory, this.spellerStack, this.previewMap, this.startRouteGuidanceSequence, this.homeAddressHandler);
        } else if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "**** %1#initPhonenumberInput - region is NOT AVAILABLE ****", (Object)this.CLASS_NAME);
        }
    }

    private boolean isInputManagerReady() {
        return this.inputManager != null;
    }

    @Override
    public void enterPhonenumberScreen() {
        if (!this.phoneNumberCommandListMonitor.isActive()) {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterPhonenumberScreen - starting command list").toString());
            CommandList commandList = this.inputManager.getPhonenumberScreenListener().getStartCommandList();
            commandList.addMonitor(this.phoneNumberCommandListMonitor);
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#enterPhonenumberScreen").toString());
        } else {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterPhonenumberScreen - command list already running, ignoring further calls.").toString());
        }
    }
}

