/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IPhoneKeyHandler;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.Iterator;
import java.util.List;

public class PhoneKeyHandler
implements IPhoneKeyHandler {
    private IDrawerFocusManagerEvo drawerFocusManager = null;

    public PhoneKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        this.drawerFocusManager = iDrawerFocusManagerEvo;
    }

    @Override
    public void handleMFLPhoneKeyPressed() {
        ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)AbstractWidget.hmiService.getModel(3848));
        if (choiceModelGUI == null) {
            IWidgetLogChannel.logChannel.log(10000, "PhoneKeyHandler#handleMFLPhoneKeyPressed callStateChoice is null, key pressed is ignored");
            return;
        }
        if (choiceModelGUI.getValue() != 0) {
            IWidgetLogChannel.logEntertainmentDrawer.log(-2137614336, "PhoneKeyHandler#handleMFLPhoneKeyPressed callStateChoice != 0 - triggerPhoneAppModel");
            this.triggerPhoneAppModel();
        } else {
            AbstractWidget abstractWidget = this.getStartCallEntry();
            if (abstractWidget != null) {
                IWidgetLogChannel.logEntertainmentDrawer.log(-2137614336, "PhoneKeyHandler#handleMFLPhoneKeyPressed trigger startCallEntry");
                abstractWidget.keyPressed(new KeyEvent(null, 0, 17, 0));
            } else {
                IWidgetLogChannel.logEntertainmentDrawer.log(-2137614336, "PhoneKeyHandler#handleMFLPhoneKeyPressed callStateChoice != 0 - triggerPhoneAppModel");
                this.triggerPhoneAppModel();
            }
        }
    }

    private void triggerPhoneAppModel() {
        ButtonModelGUI buttonModelGUI = (ButtonModelGUI)((Object)AbstractWidget.hmiService.getModel(3859));
        if (buttonModelGUI == null) {
            IWidgetLogChannel.logChannel.log(10000, "PhoneKeyHandler#getPhoneAppModel phoneMFLButton is null, key pressed is ignored");
            return;
        }
        buttonModelGUI.keyPressed(17, 0);
        buttonModelGUI.keyTyped(17, 0);
    }

    private AbstractWidget getStartCallEntry() {
        this.drawerFocusManager.updateOptionDrawerContent();
        Object object = this.drawerFocusManager.getOptionDrawer();
        if (object instanceof DrawerController) {
            DrawerMain drawerMain = ((DrawerController)object).getDrawerMain();
            if (drawerMain instanceof ContainerController) {
                Object object2;
                List list = ((ContainerController)drawerMain).getChildren();
                MenuController menuController = null;
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    object2 = iterator.next();
                    if (!(object2 instanceof MenuController)) continue;
                    menuController = (MenuController)object2;
                    break;
                }
                if (menuController == null) {
                    return null;
                }
                object2 = menuController.getChildrenOfRole(12);
                if (object2 != null) {
                    AbstractWidget abstractWidget = null;
                    Iterator iterator2 = object2.iterator();
                    while (iterator2.hasNext()) {
                        AbstractWidget abstractWidget2 = (AbstractWidget)iterator2.next();
                        if (abstractWidget2 == null || !abstractWidget2.hasState(5)) continue;
                        abstractWidget = abstractWidget2;
                        break;
                    }
                    return abstractWidget;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public void handleMFLPhoneKeyReleased() {
    }
}

