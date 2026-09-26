/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiDetailScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailScreenInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailScreenInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailScreenInputSequence$3;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;

public class PoiDetailScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiDetailScreenModelAccess modelAccess;
    private final IPreviewMap previewMapInterface;

    public PoiDetailScreenInputSequence(IPoiDetailScreenModelAccess iPoiDetailScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPreviewMap iPreviewMap, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(18), iPoiManager);
        this.modelAccess = iPoiDetailScreenModelAccess;
        this.previewMapInterface = iPreviewMap;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiDetailScreenInputSequence$1(this, "SelectListItem with Element from CommandListContext"));
        commandList.add(new PoiDetailScreenInputSequence$2(this, "Model onUpdateLocation"));
        commandList.add(new PoiDetailScreenInputSequence$3(this, new StringBuffer().append(this.CLASS_NAME).append(" - Setting preview map").toString()));
        return commandList;
    }

    public CommandList getStartGuidanceCommandList() {
        return this.commandListFactory.createCommandList();
    }

    static /* synthetic */ IPoiDetailScreenModelAccess access$000(PoiDetailScreenInputSequence poiDetailScreenInputSequence) {
        return poiDetailScreenInputSequence.modelAccess;
    }

    static /* synthetic */ IPreviewMap access$100(PoiDetailScreenInputSequence poiDetailScreenInputSequence) {
        return poiDetailScreenInputSequence.previewMapInterface;
    }
}

