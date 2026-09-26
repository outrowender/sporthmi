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
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegPOIManager$1;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIManager;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractTpegPOIManager
implements ITpegPOIManager {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
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

    @Override
    public void destTpegPOIHKReturn(int n, int n2) {
        this.logChannel.log(-2137614336, "%1#destTpegPOIHKReturn(%2, %3)", (Object)this.CLASS_NAME, (long)n, (long)n2);
        SpellerStack$StackElement spellerStack$StackElement = null;
        if (n2 == 0) {
            spellerStack$StackElement = this.spellerStack.pop();
        }
        if (spellerStack$StackElement != null) {
            this.logChannel.log(-2137614336, "%1#destTpegPOIHKReturn: Element popped from SpellerStack: %2", (Object)this.CLASS_NAME, (Object)spellerStack$StackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
            commandList.add(new AbstractTpegPOIManager$1(this, new StringBuffer().append(this.CLASS_NAME).append("#destTpegPOIHKReturn#preparePreviewMap").toString()));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#destTpegPOIHKReturn").toString());
        }
    }
}

