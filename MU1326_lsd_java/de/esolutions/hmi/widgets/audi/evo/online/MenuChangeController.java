/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.interapp.online.ModelDescription;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.ScreenArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.online.Dimensions;
import de.esolutions.hmi.widgets.audi.evo.online.IGridImageLocker;
import de.esolutions.hmi.widgets.audi.evo.online.MenuChangeFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MenuDecoratorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SharedTextureController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.Iterator;
import java.util.List;

public class MenuChangeController
extends AbstractWidgetController {
    private MenuChangeFactory menuChangeFactory;
    private final LogChannel logger = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI.Grid");
    private MenuController mainMenu;
    private MenuController headerMenu;
    private ScrollbarController mainScrollbar1;
    private ScrollbarController mainScrollbar2;
    private GlassplateController glassPlate;
    private FocusCursorController focusCursorController;
    private IconController imageDecorator;
    private SharedTextureController mapDecorator;
    private IGridImageLocker imagelocker;
    private int[] mainMenuInitialDimensions = null;
    private int[] mainScrollbar1InitialDimensions = null;
    private int[] mainScrollbar2InitialDimensions = null;
    private int[] imageDecoratorInitialDimensions = null;
    private int[] mapDecoratorInitialDimensions = null;
    private boolean isInitialized;

    public IRenderer getRenderer() {
        return null;
    }

    public MenuController getMainMenu() {
        return this.mainMenu;
    }

    public MenuController getHeaderMenu() {
        return this.headerMenu;
    }

    public ScrollbarController getMainScrollbar1() {
        return this.mainScrollbar1;
    }

    public ScrollbarController getMainScrollbar2() {
        return this.mainScrollbar2;
    }

    public GlassplateController getGlassPlate() {
        return this.glassPlate;
    }

    public IconController getImageDecorator() {
        return this.imageDecorator;
    }

    public SharedTextureController getMapDecorator() {
        return this.mapDecorator;
    }

    public int[] getMainMenuInitialDimensions() {
        return this.mainMenuInitialDimensions;
    }

    public int[] getMainScrollbar1InitialDimensions() {
        return this.mainScrollbar1InitialDimensions;
    }

    public int[] getMainScrollbar2InitialDimensions() {
        return this.mainScrollbar2InitialDimensions;
    }

    public int[] getImageDecoratorInitialDimensions() {
        return this.imageDecoratorInitialDimensions;
    }

    public int[] getMapDecoratorInitialDimensions() {
        return this.mapDecoratorInitialDimensions;
    }

    public void setMenuChangeFactory(MenuChangeFactory menuChangeFactory) {
        this.menuChangeFactory = menuChangeFactory;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        this.logger.log(10000000, "MenuChangeController#processModelUpdateEvent: updateType=%1 (other types than 16=TRANSACTION_FINISHED and 1=VALUE_UPDATED will be ignored)", (long)n);
        if (n == 16 || n == 1) {
            this.updateMenu();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.logger.log(10000000, "MenuChangeController#connected: called.");
        this.updateMenu();
    }

    private void updateMenu() {
        this.logger.log(10000000, "MenuChangeController#updateMenu: called.");
        try {
            if (!this.isInitialized) {
                this.initializeMenuData();
            }
            if (this.menuChangeFactory == null) {
                this.logger.log(100000, "MenuChangeController#updateMenu: Cannot draw new screen. menuChangeFactory is null!");
                return;
            }
            Object object = this.getModelData(this.model);
            if (object == null) {
                this.logger.log(100000, "MenuChangeController#updateMenu: Cannot draw new screen. No gridList inside model!");
                return;
            }
            this.menuChangeFactory.changeMenu(object);
        }
        catch (Throwable throwable) {
            this.logger.log(10000, "MenuChangeController#updateMenu: Cannot draw new screen. Old screen is still shown, but user input may not be processed!", throwable);
        }
    }

    private void initializeMenuData() {
        Object object;
        AbstractWidget abstractWidget = this.getParent();
        if (!(abstractWidget instanceof ContainerController)) {
            throw new IllegalStateException("MenuChangeController#initializeMenuData: menuChangeController must have a ContainerController as parent assigned in GUIDE, but parent=" + abstractWidget);
        }
        ContainerController containerController = (ContainerController)abstractWidget;
        Object object2 = containerController.getChildren().iterator();
        while (object2.hasNext()) {
            object = (AbstractWidget)object2.next();
            if (object instanceof MenuController) {
                if (this.mainMenu == null) {
                    this.mainMenu = (MenuController)object;
                    continue;
                }
                if (this.headerMenu == null) {
                    this.headerMenu = this.mainMenu;
                    this.mainMenu = (MenuController)object;
                }
            } else if (object instanceof GlassplateController) {
                if (this.glassPlate == null) {
                    this.glassPlate = (GlassplateController)object;
                }
            } else if (object instanceof IconController) {
                if (((AbstractWidget)object).getModelID() == 2300763) {
                    this.imageDecorator = (IconController)object;
                }
            } else if (object instanceof IGridImageLocker) {
                this.imagelocker = (IGridImageLocker)object;
                this.menuChangeFactory.setImageLockController(this.imagelocker);
            }
            if (this.mainMenu == null || this.headerMenu == null || this.glassPlate == null || this.imageDecorator == null || this.imagelocker == null) continue;
            break;
        }
        if (this.mainMenu == null) {
            object2 = "MenuChangeController#initializeMenuData: menuChangeController cannot find a menu sibling, which would be the target of changes. Please correct widget structure in GUIDE!";
            throw new IllegalStateException((String)object2);
        }
        object2 = this.mainMenu.getChildren().iterator();
        while (object2.hasNext()) {
            object = (AbstractWidget)object2.next();
            if (object instanceof ScrollbarController) {
                if (this.mainScrollbar1 == null) {
                    this.mainScrollbar1 = (ScrollbarController)object;
                    continue;
                }
                if (this.mainScrollbar2 == null) {
                    this.mainScrollbar2 = (ScrollbarController)object;
                }
            }
            if (this.mainScrollbar1 == null || this.mainScrollbar2 == null) continue;
            break;
        }
        if (this.mainScrollbar1 == null) {
            object2 = "MenuChangeController#initializeMenuData: menuChangeController cannot find a scrollbar as a child of the main menu. Please correct widget structure in GUIDE!";
            throw new IllegalStateException((String)object2);
        }
        this.focusCursorController = (FocusCursorController)this.mainMenu.getChildOfRole(1);
        abstractWidget = containerController.getParent();
        if (abstractWidget instanceof AbstractScreenWidget) {
            object2 = (AbstractScreenWidget)abstractWidget;
            this.mapDecorator = this.getMapDecorator((AbstractScreenWidget)object2);
        }
        this.mainMenuInitialDimensions = Dimensions.getAll(this.mainMenu);
        this.logger.log(1000000, "MenuChangeController#initializeMenuData: mainMenuInitialDimensions=%1", (Object)this.mainMenuInitialDimensions);
        this.mainScrollbar1InitialDimensions = Dimensions.getAll(this.mainScrollbar1);
        if (this.mainScrollbar2 != null) {
            this.mainScrollbar2InitialDimensions = Dimensions.getAll(this.mainScrollbar2);
        }
        this.logger.log(1000000, "MenuChangeController#initializeMenuData: mainScrollbar1InitialDimensions=%1", (Object)this.mainScrollbar1InitialDimensions);
        this.logger.log(1000000, "MenuChangeController#initializeMenuData: mainScrollbar2InitialDimensions=%1", (Object)this.mainScrollbar2InitialDimensions);
        if (this.imageDecorator != null) {
            this.imageDecoratorInitialDimensions = Dimensions.getAll(this.imageDecorator);
            this.logger.log(1000000, "MenuChangeController#initializeMenuData: imageDecoratorInitialDimensions=%1", (Object)this.imageDecoratorInitialDimensions);
        }
        if (this.mapDecorator != null) {
            this.mapDecoratorInitialDimensions = Dimensions.getAll(this.mapDecorator);
            this.logger.log(1000000, "MenuChangeController#initializeMenuData: mapDecoratorInitialDimensions=%1", (Object)this.mapDecoratorInitialDimensions);
        }
        if (this.headerMenu != null) {
            this.headerMenu.setActive(false);
        }
        if ((object = this.mainMenu.getModel()) instanceof MenuModel) {
            object2 = (MenuModel)object;
        } else {
            object2 = new MenuModel(0);
            this.mainMenu.setModel((HMIModelGUI)object2);
        }
        this.isInitialized = true;
    }

    private SharedTextureController getMapDecorator(AbstractScreenWidget abstractScreenWidget) {
        List list = abstractScreenWidget.getScreenAreas(7);
        if (list == null) {
            return null;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ContainerController containerController;
            AbstractWidget abstractWidget;
            ScreenArea screenArea = (ScreenArea)iterator.next();
            if (!(screenArea instanceof ContainerController) || !((abstractWidget = (containerController = (ContainerController)screenArea).getMenuDecorator()) instanceof MenuDecoratorController)) continue;
            MenuDecoratorController menuDecoratorController = (MenuDecoratorController)abstractWidget;
            Iterator iterator2 = menuDecoratorController.getChildren().iterator();
            while (iterator2.hasNext()) {
                AbstractWidget abstractWidget2 = (AbstractWidget)iterator2.next();
                if (!(abstractWidget2 instanceof SharedTextureController)) continue;
                return (SharedTextureController)abstractWidget2;
            }
        }
        return null;
    }

    private Object getModelData(Object object) {
        if (!(object instanceof ListModelGUI)) {
            String string = "MenuChangeController#getModelData: Cannot draw new screen. Model must be instance of ListModelGUI, but model=" + object;
            throw new IllegalArgumentException(string);
        }
        ListModelGUI listModelGUI = (ListModelGUI)object;
        String string = ModelDescription.getList(listModelGUI.getID());
        int n = listModelGUI.getLength();
        if (n != 1) {
            String string2 = "MenuChangeController#getModelData: Cannot draw new screen. Model " + string + " must have exact 1 row with data container," + " but rows=" + n;
            throw new IllegalArgumentException(string2);
        }
        ListCell listCell = listModelGUI.getCell(0, 0);
        if (!(listCell instanceof ObjectListCell)) {
            String string3 = "MenuChangeController#getModelData: Cannot draw new screen. Container of model " + string + "does not contain an ObjectListCell," + " but cell=" + listCell;
            throw new IllegalArgumentException(string3);
        }
        ObjectListCell objectListCell = (ObjectListCell)listCell;
        return objectListCell.getValue();
    }

    public FocusCursorController getFocusCursorController() {
        return this.focusCursorController;
    }
}

