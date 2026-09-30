/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIManager;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractTpegPOIManager
implements ITpegPOIManager {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final ICommandListFactory commandListFactory;
    protected final SpellerStack spellerStack;
    protected final IPreviewMap previewMap;

    public AbstractTpegPOIManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
    }

    public void destTpegPOIHKReturn(int n, int n2) {
        this.logChannel.log(10000000, "%1#destTpegPOIHKReturn(%2, %3)", (Object)this.CLASS_NAME, (long)n, (long)n2);
        SpellerStack.StackElement stackElement = null;
        if (n2 == 0) {
            stackElement = this.spellerStack.pop();
        }
        if (stackElement != null) {
            this.logChannel.log(10000000, "%1#destTpegPOIHKReturn: Element popped from SpellerStack: %2", (Object)this.CLASS_NAME, (Object)stackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(stackElement));
            commandList.add(new NavCommand(this.CLASS_NAME + "#destTpegPOIHKReturn#preparePreviewMap"){

                public void execute() {
                    AbstractTpegPOIManager.this.previewMap.setPreviewAreaAroundCCP(5);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(this.CLASS_NAME + "#destTpegPOIHKReturn");
        }
    }
}

