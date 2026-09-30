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
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
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
        commandList.add(new NavCommand(this.CLASS_NAME + " - Model onUpdateLocation"){

            public void execute() {
                TpegPOIDetailSequence.this.modelAccess.onUpdateLocation(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(this.CLASS_NAME + " - Setting preview map"){

            public void execute() {
                TpegPOIDetailSequence.this.previewMap.setPreviewPOIsOnboard(new NavLocation[]{this.dsiResponseContainer.getLiCurrentLD()}, 5, null, null);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void startWithNavLocation(final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new TpegPoiRequestExtendedInfoCommand(navLocation));
        commandList.add(new NavCommand(this.CLASS_NAME + " - Model onUpdateLocation"){

            public void execute() {
                TpegPOIDetailSequence.this.modelAccess.onUpdateLocation(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(this.CLASS_NAME + "#startWithNavLocation");
    }
}

