/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.via;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.DynamicListModelListener;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LispSetInputSimpleCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaApp;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaModelListener$1;
import de.audi.tghu.navi.app.map.MapInterface;
import org.dsi.ifc.navigation.LIValueListElement;

public class ViaModelListener
implements DynamicListModelListener,
ButtonListener,
ListListener {
    private final NavigationEnv env;
    private ViaApp viaApp;
    private LogChannel logHmi;
    private ListModelApp viaCountryList;
    private final MapInterface mapInterface;
    private final ICommandListFactory commandListFactory;

    public ViaModelListener(NavigationEnv navigationEnv, IconHandler iconHandler, ICommandListFactory iCommandListFactory, MapInterface mapInterface) {
        this.env = navigationEnv;
        this.viaApp = new ViaApp(navigationEnv, iconHandler, iCommandListFactory);
        this.logHmi = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.mapInterface = mapInterface;
        if (navigationEnv.getFramework().isFrontMU()) {
            this.initTerminalDependentModels(0);
        } else {
            this.initTerminalDependentModels(3);
            this.initTerminalDependentModels(4);
        }
    }

    private void initTerminalDependentModels(int n) {
        this.env.getButtonModel(n, 1914439168).setButtonListener(this);
        this.env.getButtonModel(n, 1771008).setButtonListener(this);
        this.env.getButtonModel(n, -518388224).setButtonListener(this);
        this.viaCountryList = this.env.getListModel(n, -920844800);
        this.viaCountryList.setListListener(this);
        this.viaCountryList.setMaxColumns(2);
        this.env.getDynamicListModel(n, -954399232).setListListener(this);
        this.env.getDynamicListModel(n, -954399232).jumpToStartOfListSupported(true);
        this.env.getDynamicListModel(n, -954399232).setMaxColumns(6);
    }

    public void windowChanged(int n) {
        this.logHmi.log(-2137614336, "ViaModelListener#windowChanged( %1 )", (long)n);
        this.updateList();
    }

    private void updateList() {
        this.logHmi.log(-2137614336, "ViaModelListener#updateList()");
        this.viaApp.updateList();
    }

    private CommandList prepareViaCountryList() {
        this.env.getLogChannel().log(-2137614336, "ViaModelListener#prepareViaCountryList()");
        return null;
    }

    private CommandList prepareCountrySelection(LIValueListElement lIValueListElement) {
        this.env.getLogChannel().log(-2137614336, "ViaModelListener#prepareCountrySelection( %1 )", (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList(0);
        commandList.add(new LispSetInputSimpleCommand(lIValueListElement));
        commandList.add(new ViaModelListener$1(this, "StartViaPointsQuery"));
        return commandList;
    }

    private void startViaCountriesQuery() {
        this.viaApp.resetAll();
        CommandList commandList = this.prepareViaCountryList();
        if (commandList != null) {
            commandList.execute("ViaModelListener#startViaCountriesQuery");
        }
    }

    private void startViaPointsQuery() {
        this.updateList();
    }

    @Override
    public void scrollingActive(int n, boolean bl, int n2) {
    }

    @Override
    public void rebuildListFromStart(int n, int n2) {
        this.logHmi.log(-2137614336, "ViaModelListener#rebuildListFromStart()");
        switch (n) {
            case 400839: {
                this.logHmi.log(-2137614336, "ViaModelListener#rebuildListFromStart() - requesting initial window");
                this.viaApp.requestInitialWindow(n2);
                break;
            }
            default: {
                this.logHmi.log(10000, "ViaModelListener#rebuildListFromStart() - unhandled model!");
            }
        }
    }

    @Override
    public void rebuildListFromEnd(int n, int n2) {
        this.logHmi.log(10000, "ViaModelListener#rebuildListFromEnd() - not implemented!");
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        LIValueListElement lIValueListElement = null;
        CommandList commandList = null;
        switch (n) {
            case 400841: {
                lIValueListElement = (LIValueListElement)((ObjectListCell)this.viaCountryList.getCell(n2, 1)).getValue();
                commandList = this.prepareCountrySelection(lIValueListElement);
                commandList.execute("ViaModelListener#itemSelected");
                this.env.fireModelEvent(n, n4);
                break;
            }
            default: {
                this.logHmi.log(10000, "ViaModelListener#itemSelected() - unhandled model: %1 ", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, ListRow listRow, int n2) {
        this.logHmi.log(-2137614336, "ViaModelListener#itemSelected( %1 )", (long)n);
        if (listRow == null) {
            this.logHmi.log(10000, "ViaModelListener#itemSelected() - selected row is null!");
            return;
        }
        switch (n) {
            case 400839: {
                this.logHmi.log(-2137614336, "ViaModelListener#itemSelected() - selected row: %1 ", (Object)listRow);
                this.viaApp.itemSelected(n, listRow, n2);
                break;
            }
            default: {
                this.logHmi.log(10000, "ViaModelListener#itemSelected() - unhandled model: %1 ", (long)n);
            }
        }
    }

    @Override
    public void itemFocused(int n, ListRow listRow, int n2, int n3) {
        if (listRow == null) {
            this.logHmi.log(10000, "ViaModelListener#itemFocused() - focused row is null! model ID: [%1], cursor position: %2", (long)n, (long)n2);
            return;
        }
        switch (n) {
            case 400839: {
                this.logHmi.log(-2137614336, "ViaModelListener#itemFocused() - item is focused in overview list, row: [%1], model ID: %2, cursor position: %3 ", (Object)listRow, (long)n, (long)n2);
                this.viaApp.itemFocused(listRow, n2, n3);
                break;
            }
            default: {
                this.logHmi.log(10000, "ViaModelListener#itemFocused() - unhandled model, ID: %1 ", (long)n);
            }
        }
    }

    @Override
    public void itemReleased(int n, ListRow listRow, int n2) {
    }

    @Override
    public void runningOutOfData(int n, ListRow listRow, int n2, int n3) {
        this.logHmi.log(-2137614336, "ViaModelListener#runningOutOfData( %1, %2 )", (long)n, (long)n2);
        switch (n) {
            case 400839: {
                this.logHmi.log(-2137614336, "ViaModelListener#runningOutOfData() - requesting new window for overview list");
                this.viaApp.requestWindow(listRow, n3);
                break;
            }
            default: {
                this.logHmi.log(10000, "ViaModelListener#runningOutOfData() - unhandled model, ID: %1 ", (long)n);
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logHmi.log(-2137614336, "ViaModelListener#keyPressed( %1 )", (long)n);
        switch (n) {
            case 400498: {
                this.logHmi.log(-2137614336, "ViaModelListener#keyPressed() - enter via list");
                this.mapInterface.cancelRouteCalculationTimer();
                if (this.env.getFramework().isEvoHigh()) {
                    this.env.fireModelEvent(n, n3);
                    this.mapInterface.enterRubberband(true);
                } else {
                    this.startViaCountriesQuery();
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400097: 
            case 400128: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            default: {
                this.logHmi.log(10000, "ViaModelListener#keyPressed() - unhandled model, ID: %1 ", (long)n);
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ void access$000(ViaModelListener viaModelListener) {
        viaModelListener.startViaPointsQuery();
    }
}

