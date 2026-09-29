/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiDetailScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.tpegpoi.commands.TpegPoiRequestExtendedInfoCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIBaseSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence$1;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence$2;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence$3;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIDetailSequence
extends TpegPOIBaseSequence {
    protected final IPoiDetailScreenModelAccess modelAccess;
    protected final IPreviewMap previewMap;

    public TpegPOIDetailSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IPreviewMap iPreviewMap, IPoiDetailScreenModelAccess iPoiDetailScreenModelAccess) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.previewMap = iPreviewMap;
        this.modelAccess = iPoiDetailScreenModelAccess;
    }

    public CommandList getStartCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(110)));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new TpegPoiRequestExtendedInfoCommand());
        commandList.add(new TpegPOIDetailSequence$1(this, new StringBuffer().append(this.CLASS_NAME).append(" - Model onUpdateLocation").toString()));
        commandList.add(new TpegPOIDetailSequence$2(this, new StringBuffer().append(this.CLASS_NAME).append(" - Setting preview map").toString()));
        return commandList;
    }

    public void startWithNavLocation(NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new TpegPoiRequestExtendedInfoCommand(navLocation));
        commandList.add(new TpegPOIDetailSequence$3(this, new StringBuffer().append(this.CLASS_NAME).append(" - Model onUpdateLocation").toString(), navLocation));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startWithNavLocation").toString());
    }
}

