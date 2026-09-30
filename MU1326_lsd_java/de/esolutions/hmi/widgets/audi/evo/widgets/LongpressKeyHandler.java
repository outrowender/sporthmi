/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.model.OptionModel;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IDrawerConditionEngine;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.ILongpressKeyHandler;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerMain;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.List;

public class LongpressKeyHandler
implements ILongpressKeyHandler,
IWidgetLogChannel {
    private IDrawerFocusManagerEvo drawerFocusManager = null;

    public LongpressKeyHandler(IDrawerFocusManagerEvo iDrawerFocusManagerEvo) {
        this.drawerFocusManager = iDrawerFocusManagerEvo;
    }

    public void handleLongpressStarted(Object object) {
        if (object != null) {
            OptionModel optionModel = null;
            AbstractWidgetController abstractWidgetController = this.getLongpressElement(15);
            if (abstractWidgetController != null && abstractWidgetController.getModel() instanceof OptionModel) {
                optionModel = (OptionModel)abstractWidgetController.getModel();
                menuLogCh.log(10000000, "LongpressKeyHandler#triggerLongpress: longpress triggered");
            }
            if (optionModel != null) {
                HMITerminalEvo hMITerminalEvo = (HMITerminalEvo)((AbstractWidget)object).getTerminal();
                int n = hMITerminalEvo.getTerminalID();
                IDrawerConditionEngine iDrawerConditionEngine = hMITerminalEvo.getDrawerConditionEngine();
                if (iDrawerConditionEngine != null) {
                    int n2 = iDrawerConditionEngine.getTargetModelID();
                    int n3 = iDrawerConditionEngine.getTargetRow();
                    int n4 = iDrawerConditionEngine.getTargetWidgetID();
                    optionModel.keyPressed(n2, n3, n4, n);
                    optionModel.keyTyped(n2, n3, n4, n);
                    menuLogCh.log(10000000, "LongpressKeyHandler#triggerLongpress: action performed successful");
                    this.notifySdsService(abstractWidgetController);
                } else {
                    menuLogCh.log(10000, "LongpressKeyHandler#triggerLongpress: drawerConditionEngine is null.");
                }
            } else {
                menuLogCh.log(10000000, "LongpressKeyHandler#triggerLongpress: longpress can not be performed! Could not find item with role ROLE_LONGPRESS");
            }
        }
    }

    private void notifySdsService(AbstractWidgetController abstractWidgetController) {
        if (AbstractWidget.sdsService == null) {
            menuLogCh.log(10000000, "LongpressKeyHandler#callSdsService: SDS Service is null");
            return;
        }
        if (!AbstractWidget.sdsService.isSDSActive()) {
            return;
        }
        boolean bl = this.hasSdsSilentAbortAction(abstractWidgetController);
        menuLogCh.log(10000000, "LongpressKeyHandler#callSdsService: abort SDS (silent: %1) for selected item: %2", bl, (Object)abstractWidgetController);
        AbstractWidget.sdsService.abortSDSSession(bl, (byte)3);
    }

    private boolean hasSdsSilentAbortAction(AbstractWidgetController abstractWidgetController) {
        if (!(abstractWidgetController instanceof IMenuItemSingle)) {
            return false;
        }
        int n = ((IMenuItemSingle)((Object)abstractWidgetController)).getSdsItemSelectedAction();
        return n == 1;
    }

    private AbstractWidgetController getLongpressElement(int n) {
        DrawerMain drawerMain;
        this.drawerFocusManager.updateOptionDrawerContent();
        Object object = this.drawerFocusManager.getOptionDrawer();
        if (object instanceof DrawerController && (drawerMain = ((DrawerController)object).getDrawerMain()) instanceof ContainerController) {
            Object object2;
            List list = ((ContainerController)drawerMain).getChildren();
            MenuController menuController = null;
            Object object3 = list.iterator();
            while (object3.hasNext()) {
                object2 = object3.next();
                if (!(object2 instanceof MenuController)) continue;
                menuController = (MenuController)object2;
                break;
            }
            if (menuController == null) {
                return null;
            }
            object3 = menuController.getChildrenOfRole(n);
            if (null == object3) {
                return null;
            }
            object2 = object3.iterator();
            while (object2.hasNext()) {
                Object object4 = object2.next();
                if (!(object4 instanceof AbstractWidgetController) || !((AbstractWidget)object4).hasState(5)) continue;
                return (AbstractWidgetController)object4;
            }
        }
        return null;
    }
}

