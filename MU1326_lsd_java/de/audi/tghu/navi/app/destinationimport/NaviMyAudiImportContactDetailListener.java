/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import org.dsi.ifc.global.NavLocation;

public class NaviMyAudiImportContactDetailListener
implements ListListener {
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final NaviMyAudiImportImpl myAudiImporter;
    private ListModelApp businessAddressList;
    private ListModelApp privateAddressList;
    private ListModelApp phoneNumberList;
    private final IPreviewMap previewMap;
    private final ICommandListFactory commandListFactory;
    private static final int PHONENUMBER_COLUMN = 1;

    public NaviMyAudiImportContactDetailListener(NavigationEnv navigationEnv, NaviMyAudiImportImpl naviMyAudiImportImpl, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.myAudiImporter = naviMyAudiImportImpl;
        this.previewMap = iPreviewMap;
        this.commandListFactory = iCommandListFactory;
        this.initListeners();
    }

    private void initListeners() {
        this.businessAddressList = this.env.getListModel(401805);
        this.businessAddressList.setListListener(this);
        this.privateAddressList = this.env.getListModel(401806);
        this.privateAddressList.setListListener(this);
        this.phoneNumberList = this.env.getListModel(401809);
        this.phoneNumberList.setListListener(this);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "NaviMyAudiImportContactDetailListener#itemFocused - modelID=%1, row=%2", (long)n, (long)n2);
        if (n == this.businessAddressList.getID() && n2 >= 0) {
            this.focusPreviewMap(this.myAudiImporter.getCurrentSelectedBusinessDestination());
        } else if (n == this.privateAddressList.getID() && n2 >= 0) {
            this.focusPreviewMap(this.myAudiImporter.getCurrentSelectedPrivateDestination());
        } else {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new HidePreviewMapCommand(this.previewMap));
            commandList.execute("NaviMyAudiImportContactDetailListener#hidePreviewMap");
        }
    }

    private void focusPreviewMap(byte[] byArray) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StreamToLocationCommand(byArray));
        commandList.add(new NavCommand("get navLocation and focus preview map"){

            public void execute() {
                NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
                if (navLocation != null) {
                    NaviMyAudiImportContactDetailListener.this.previewMap.setPreviewLocation(navLocation, 3, null, null);
                } else {
                    NaviMyAudiImportContactDetailListener.this.previewMap.hidePreviewMap();
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviMyAudiImportContactDetailListener#focusPreviewMap");
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "NaviMyAudiImportContactDetailListener#itemSelected - modelID=%1, row=%2", (long)n, (long)n2);
        if (n == this.phoneNumberList.getID()) {
            String string = this.phoneNumberList.getRow(n2).getText(1);
            this.logChannel.log(10000000, "NaviMyAudiImportContactDetailListener#itemSelected - calling number=%1", (Object)string);
            this.myAudiImporter.callEntry(string);
        } else if (n == this.businessAddressList.getID()) {
            this.logChannel.log(10000000, "NaviMyAudiImportContactDetailListener#itemSelected - starting action to business address");
            this.myAudiImporter.startActionToDestination(this.myAudiImporter.getCurrentSelectedBusinessDestination());
        } else if (n == this.privateAddressList.getID()) {
            this.logChannel.log(10000000, "NaviMyAudiImportContactDetailListener#itemSelected - starting action to private address");
            this.myAudiImporter.startActionToDestination(this.myAudiImporter.getCurrentSelectedPrivateDestination());
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
    }
}

