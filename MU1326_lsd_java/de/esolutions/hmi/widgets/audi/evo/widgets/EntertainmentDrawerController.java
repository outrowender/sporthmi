/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;

public class EntertainmentDrawerController
extends DrawerController {
    public EntertainmentDrawerController(int n) {
        super(n);
    }

    public int getDisplayDrawerState() {
        return this.getOpenCloseController().getDisplayDrawerState();
    }

    public void setDisplayDrawerState(int n, boolean bl, boolean bl2) {
        this.getOpenCloseController().setDisplayDrawerState(n, bl, bl2);
    }

    public EntertainmentDrawerOpenCloseController getOpenCloseController() {
        return (EntertainmentDrawerOpenCloseController)this.getChild(0);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        EntertainmentDrawerContentController entertainmentDrawerContentController = this.getOpenCloseController().getContent();
        super.processModelUpdateEvent(modelUpdateEvent);
        if (entertainmentDrawerContentController instanceof EntertainmentDrawerContentController) {
            if (((AbstractWidgetController)entertainmentDrawerContentController).isConnected()) {
                ((DrawerController)entertainmentDrawerContentController).processModelUpdateEvent(modelUpdateEvent);
            } else {
                logEntertainmentDrawer.log(100000, "EntertainmentDrawerController#processModelUpdateEvent: content is not connected. Content: %1, EntertainmentDrawer: %2, screen: %3", (Object)entertainmentDrawerContentController, (Object)this, (long)this.getScreenId());
            }
        } else {
            logEntertainmentDrawer.log(10000000, "EntertainmentDrawerController#processModelUpdateEvent: content is not a DrawerController: %1", (Object)entertainmentDrawerContentController);
        }
    }

    public int getCurrentAudioSource() {
        return this.getOpenCloseController().getAudioSourceFromModel();
    }
}

