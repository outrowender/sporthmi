/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.IRootWindow;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.IAnimationController;
import de.audi.atip.hmi.view.IImageLoader;
import de.audi.atip.hmi.view.IPartialPopupManager;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.IStatistics;
import de.audi.atip.hmi.view.Screen;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.WidgetPersistenceManager;
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry;

public class InitializationContext {
    private boolean reinit;
    private HMITerminalImpl terminal;
    private AbstractScreenFactory screenFactory;
    private int screenID;
    private Screen screen;
    private int compositeID;
    private long[] contextIDs;
    private long optionDrawerID;
    private long selectionDrawerID;
    private int initialCursorPosition = -1;
    private boolean stayOnFocusedElement;

    public InitializationContext(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
    }

    public InitializationContext(HMITerminalImpl hMITerminalImpl, IScreenData iScreenData) {
        this.terminal = hMITerminalImpl;
        this.reinit = iScreenData.isReinit();
        this.screenID = iScreenData.getId();
        this.contextIDs = iScreenData.getContextIDs();
        this.optionDrawerID = iScreenData.getOptionsDrawerID();
        this.selectionDrawerID = iScreenData.getSelectionDrawerID();
        this.initialCursorPosition = iScreenData.getCursorPosition();
        this.stayOnFocusedElement = iScreenData.isStayOnFocusedElement();
    }

    public InitializationContext(InitializationContext initializationContext) {
        this.terminal = initializationContext.terminal;
        this.screenFactory = initializationContext.screenFactory;
        this.contextIDs = initializationContext.contextIDs;
        this.screenID = initializationContext.screenID;
        this.screen = initializationContext.screen;
        this.optionDrawerID = initializationContext.optionDrawerID;
        this.selectionDrawerID = initializationContext.selectionDrawerID;
        this.compositeID = initializationContext.compositeID;
        this.reinit = initializationContext.reinit;
        this.initialCursorPosition = initializationContext.initialCursorPosition;
        this.stayOnFocusedElement = initializationContext.stayOnFocusedElement;
    }

    public boolean isReinit() {
        return this.reinit;
    }

    public void setReinit(boolean bl) {
        this.reinit = bl;
    }

    public HMITerminalImpl getTerminal() {
        return this.terminal;
    }

    public void setTerminal(HMITerminalImpl hMITerminalImpl) {
        this.terminal = hMITerminalImpl;
    }

    public AbstractScreenFactory getScreenFactory() {
        return this.screenFactory;
    }

    public void setScreenFactory(AbstractScreenFactory abstractScreenFactory) {
        this.screenFactory = abstractScreenFactory;
    }

    public int getScreenID() {
        return this.screenID;
    }

    public void setScreenID(int n) {
        this.screenID = n;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setCompositeID(int n) {
        this.compositeID = n;
    }

    public int getCompositeID() {
        return this.compositeID;
    }

    public int getTerminalID() {
        return this.terminal.getTerminalID();
    }

    public IAnimationController getAnimationController() {
        return this.terminal.getIAnimationController();
    }

    public Layout getLayout() {
        return this.terminal.getLayout();
    }

    public IImageLoader getImageLoader() {
        return this.terminal.getImageLoader();
    }

    public IRootWindow getRootWindow() {
        return this.terminal.getRootWindow();
    }

    public StringUtility getStringUtility() {
        return this.terminal.getStringUtility();
    }

    public WidgetPersistenceManager getWidgetPersistenceManager() {
        return this.terminal.getWidgetPersistenceManager();
    }

    public IPartialPopupManager getPartialPopupManager() {
        return this.terminal.getPartialPopupManager();
    }

    public IStatistics getStatistics() {
        return this.terminal.getStatistics();
    }

    public String toString() {
        return "InitializationContext#toString screenID: " + this.screenID;
    }

    public WidgetRegistry getWidgetRegistry() {
        return this.terminal.getWidgetRegistry();
    }

    public long[] getContextIDs() {
        return this.contextIDs;
    }

    public void setContextIDs(long[] lArray) {
        this.contextIDs = lArray;
    }

    public long getOptionDrawerID() {
        return this.optionDrawerID;
    }

    public void setOptionDrawerID(long l) {
        this.optionDrawerID = l;
    }

    public long getSelectionDrawerID() {
        return this.selectionDrawerID;
    }

    public void setSelectionDrawerID(long l) {
        this.selectionDrawerID = l;
    }

    public int getInitialCursorPosition() {
        return this.initialCursorPosition;
    }

    public void setInitialCursorPosition(int n) {
        this.initialCursorPosition = n;
    }

    public boolean isStayOnFocusedElement() {
        return this.stayOnFocusedElement;
    }

    public void setStayOnFocusedElement(boolean bl) {
        this.stayOnFocusedElement = bl;
    }
}

