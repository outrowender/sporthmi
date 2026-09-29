/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sdis;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.setup.IRouteCriteriaManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class NaviSDISStartGuidanceHandler
implements ButtonListener {
    protected static final int POPUP_A2LS_NAVI_ACCEPT_BUTTON;
    protected static final int POPUP_A2LS_NAVI_DECLINE_BUTTON;
    protected static final int POPUP_A2LS_NAVI_SETTINGS_BUTTON;
    protected static final int POPUP_A2LS_NAVI_LINE_ONE_LABEL;
    protected static final int POPUP_A2LS_NAVI_LINE_TWO_LABEL;
    protected static final int POPUP_A2LS_NAVI_LINE_THREE_LABEL;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    protected NavLocation[] destinations;
    protected NavCommand replyCommand;
    protected final ICommandListFactory commandListFactory;
    protected NavCommand replyDeclinedCommand;
    protected final Object lock;

    public NaviSDISStartGuidanceHandler(LogChannel logChannel, NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IRouteCriteriaManager iRouteCriteriaManager, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.commandListFactory = iCommandListFactory;
        this.lock = new Object();
        this.initListener();
    }

    private void initListener() {
        this.env.getButtonModel(4183).setButtonListener(this);
        this.env.getButtonModel(4223).setButtonListener(this);
        this.env.getButtonModel(4224).setButtonListener(this);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "NaviSDISStartGuidanceHandler#keyTyped(%1, %2)", (long)n, (long)n2);
        if (n == 4183) {
            this.startGuidance();
        } else if (n == 4223) {
            this.decline();
        } else if (n == 4224) {
            this.decline();
        }
        this.destinations = null;
        this.replyCommand = null;
        this.env.fireModelEvent(n, n3);
        this.hideGuidanceRequestPopUp();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void decline() {
        Object object = this.lock;
        synchronized (object) {
            if (this.replyDeclinedCommand == null) {
                return;
            }
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(this.replyDeclinedCommand);
            commandList.execute("NaviSDISStartGuidanceHandler#decline");
            this.replyDeclinedCommand = null;
            this.replyCommand = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void startGuidance() {
        Object object = this.lock;
        synchronized (object) {
            if (this.replyCommand == null) {
                return;
            }
            this.env.getSdisLogChannel().log(-2137614336, "NaviTabletService#startGuidanceToDestinations Destinations: %1", (Object)this.destinations);
            CommandList commandList = this.startGuidanceToDestinationSequence.getStartSequence(this.destinations[0], false);
            commandList.add(this.replyCommand);
            commandList.execute("NaviSDISStartGuidanceHandler#keyTyped#executeStartGuidance");
            this.replyDeclinedCommand = null;
            this.replyCommand = null;
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void prepareStartGuidance(NavLocation[] navLocationArray, NavCommand navCommand, NavCommand navCommand2) {
        Object object = this.lock;
        synchronized (object) {
            this.replyDeclinedCommand = navCommand2;
            this.logChannel.log(-2137614336, "NaviSDISStartGuidanceHandler#prepareStartGuidance() destinationCount = %2 firstDestinationFormatted: %1", (Object)LocationFormatter.formatLocationShort(navLocationArray[0]), (long)navLocationArray.length);
            ChoiceModelApp choiceModelApp = this.env.getChoiceModel(415895552);
            if (choiceModelApp == null) {
                this.logChannel.log(-1601830656, "NaviSDISStartGuidanceHandler#prepareStartGuidance() sdis settings model is null");
                this.decline();
                return;
            }
            int n = choiceModelApp.getValue();
            this.logChannel.log(-2137614336, "NaviSDISStartGuidanceHandler#prepareStartGuidance() current RequestMode =  %1", (long)n);
            switch (n) {
                case 1: {
                    this.logChannel.log(-2137614336, "NaviSDISStartGuidanceHandler#prepareStartGuidance() - Mode is set to ALLOW start routeguidance and trigger choicemodel to show popup if needed");
                    this.destinations = navLocationArray;
                    this.replyCommand = navCommand;
                    this.startGuidance();
                    ChoiceModelApp choiceModelApp2 = this.env.getChoiceModel(4146);
                    choiceModelApp2.setValue(choiceModelApp2.getValue() + 1);
                    break;
                }
                case 2: {
                    this.logChannel.log(-2137614336, "NaviSDISStartGuidanceHandler#prepareStartGuidance() - Mode is set to DECLINE --> Send decline() answer to SDIS");
                    this.decline();
                    break;
                }
                case 0: {
                    this.logChannel.log(-2137614336, "NaviSDISStartGuidanceHandler#prepareStartGuidance() - Mode is set to ask for permission --> Show popup");
                    this.destinations = navLocationArray;
                    this.replyCommand = navCommand;
                    this.showGuidanceRequestPopUp();
                    break;
                }
                default: {
                    this.logChannel.log(1078071040, "NaviSDISStartGuidanceHandler#prepareStartGuidance no match found for value = %1", (long)n);
                }
            }
        }
    }

    protected void showGuidanceRequestPopUp() {
        this.env.getChoiceModel(237110784).setValue(0);
        this.env.getChoiceModel(237110784).setValue(1);
    }

    protected void hideGuidanceRequestPopUp() {
        this.env.getChoiceModel(237110784).setValue(0);
    }
}

