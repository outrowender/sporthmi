/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.AbstractWlanComponent;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.client.CommandNetworkSearch;
import de.audi.app.wlan.core.client.FoundNetworkList;
import de.audi.app.wlan.core.client.IInquiry;
import de.audi.app.wlan.core.mode.CommandSetRole;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.networking.DiscoveredNetwork;

public class AbstractInquiry
extends AbstractWlanComponent
implements IInquiry,
ButtonListener,
BaseListModelListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{19};
    private final ButtonModelApp startButton = this.getButtonModel(-920312320);
    private final ButtonModelApp stopButton = this.getButtonModel(-937089536);
    private final BaseListModelApp listModel = this.getBaseListModel(2133206528);
    private final ChoiceModelApp inquiryState = this.getChoiceModel(-500881920);
    private final FoundNetworkList foundNetworks;

    public AbstractInquiry(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
        this.foundNetworks = new FoundNetworkList(iWlanApplication.getLogChannel(), this.listModel, iWlanApplication.getTrustedNetworkList());
    }

    @Override
    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
        if (n == 1 && discoveredNetwork != null) {
            this.foundNetworks.add(discoveredNetwork);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.startButton.getID()) {
            this.log.log(1078071040, "AbstractInquiry#keyTyped(): Searching for WLANs");
            this.startInquiry(n3);
        } else if (n == this.stopButton.getID()) {
            this.log.log(1078071040, "AbstractInquiry#keyTyped(): Aborting WLAN inquiry");
            this.abort();
        }
    }

    @Override
    public void startInquiry(int n) {
        this.wlanApplication.getMode().switchWlanState(true);
        this.foundNetworks.clear();
        this.inquiryState.setValue(1);
        this.listModel.setStatus(1);
        this.startButton.fireEvent(n);
        CommandSetRole.schedule(this.wlanApplication, this.dsiWlan, null, 4);
        CommandNetworkSearch.schedule(this.wlanApplication, this.dsiWlan, this.inquiryState);
    }

    @Override
    public void abortInquiry() {
        this.abort();
        this.resetSearchState();
    }

    private void abort() {
        CommandList commandList = this.wlanApplication.getCommandListManager().getActiveCommandList();
        if (commandList != null) {
            Command command = commandList.getActiveCommand();
            if (command instanceof CommandNetworkSearch) {
                this.inquiryState.setValue(2);
                ((CommandNetworkSearch)command).abortSearch();
            } else {
                this.log.log(1078071040, "AbstractInquiry#abortInquiry(): no active network search command found!");
            }
        }
    }

    private void resetSearchState() {
        this.listModel.setStatus(0);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == this.listModel.getID()) {
            DiscoveredNetwork discoveredNetwork = this.foundNetworks.getNetwork(n2);
            if (discoveredNetwork == null) {
                this.log.log(-1601830656, "AbstractInquiry#itemSelected(): Network not found in network list!");
                return;
            }
            this.log.log(1078071040, "AbstractInquiry#itemSelected(): %1, %2", (Object)discoveredNetwork.getNetworkName(), (Object)discoveredNetwork.getBssidAddress());
            this.abort();
            this.wlanApplication.getConnection().connectNetwork(discoveredNetwork);
            this.listModel.fireEvent(n4);
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void init() {
        super.init();
        this.foundNetworks.init();
        this.startButton.setButtonListener(this);
        this.stopButton.setButtonListener(this);
        this.listModel.setListener(this);
        this.resetSearchState();
    }

    @Override
    public void deinit() {
        this.startButton.resetListener();
        this.stopButton.resetListener();
        this.listModel.resetListener();
        this.foundNetworks.deinit();
        super.deinit();
    }
}

