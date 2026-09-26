/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.DataModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationPanelController
extends AbstractWidgetController
implements ISpellerListener {
    private AbstractWidgetController functionalKeysWidget = null;
    private AbstractWidgetController systemKeysWidget = null;
    private IRenderer renderer;
    private List panelKeys = new ArrayList();
    private List panelKeysHandler = new ArrayList();
    private SpellerController speller = null;
    private int cursorPosition = -1;
    private boolean hasOkButton = false;
    private boolean spellerOpen = false;
    private static final int KEY_SPELLER_ID;
    private int tunerMode = -1;
    private int[] positions = new int[4];
    private int alignment = 1;
    protected static final int LEFT_ALIGNEMNT;
    protected static final int RIGHT_ALIGNTMENT;
    private int indexCursorImages = 0;
    private int indexBackgroundImages = 1;
    private int indexAlignmentImages = 4;
    private int indexFunctionalKeysImages = 6;
    private int indexSystemKeysImages = 12;
    private int indexFunctionalKeysOverlayImages = 21;
    private int indexSpellerBackgroundImages = 25;
    private int iconGap = 12;
    private int keyId = -1;
    private int iconSize = 30;
    private int renderedKeys = 0;
    public static final int KEY_LEFT_ALIGNEMENT;
    public static final int KEY_RIGHT_ALIGNEMENT;
    private static final int KEY_ID_OK_ENTER;
    private AbstractWidgetController buttonHandlerWidget = null;
    public static final int ROLE_FUNCTIONAL_KEY;
    public static final int ROLE_PANEL_KEY;
    public static final int ROLE_KEY_HANDLER;
    public static final int ROLE_SPELLER;

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof ModelStubController) {
            if (this.buttonHandlerWidget == null) {
                this.buttonHandlerWidget = (ModelStubController)abstractWidget;
                logOperationalPanel.log(-2137614336, "OperationalPanelController#add ButtonHandlerWidget to OpaertionPanel: %1", (Object)this.buttonHandlerWidget);
                return;
            }
            if (this.functionalKeysWidget == null) {
                this.functionalKeysWidget = (ModelStubController)abstractWidget;
                logOperationalPanel.log(-2137614336, "OperationalPanelController#add FunctionaKeysWidget to OperationPanel: %1", (Object)this.functionalKeysWidget);
                return;
            }
            if (this.systemKeysWidget == null) {
                this.systemKeysWidget = (ModelStubController)abstractWidget;
                logOperationalPanel.log(-2137614336, "OperationalPanelController#add SystemKeyWidget to OperationPanel: %1", (Object)this.systemKeysWidget);
                return;
            }
        }
        if (abstractWidget instanceof SpellerController) {
            this.speller = (SpellerController)abstractWidget;
            this.speller.registerSpellerListener(this);
            logOperationalPanel.log(-2137614336, "OperationalPanelController#add add Speller to OperationPanel: %1", (Object)this.speller);
        }
        super.add(abstractWidget);
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof ModelStubController) {
            if (n == 0) {
                this.functionalKeysWidget = (ModelStubController)abstractWidget;
                logOperationalPanel.log(-2137614336, "OperationalPanelController#add FunctionaKeysWidget to OperationPanel: %1", (Object)this.functionalKeysWidget);
            } else if (n == 1) {
                this.systemKeysWidget = (ModelStubController)abstractWidget;
                logOperationalPanel.log(-2137614336, "OperationalPanelController#add SystemKeyWidget to OperationPanel: %1", (Object)this.systemKeysWidget);
            } else if (n == 2) {
                this.buttonHandlerWidget = (ModelStubController)abstractWidget;
                logOperationalPanel.log(-2137614336, "OperationalPanelController#add ButtonHandlerWidget to OpaertionPanel: %1", (Object)this.buttonHandlerWidget);
            }
        }
        if (n == 3 && abstractWidget instanceof SpellerController) {
            this.speller = (SpellerController)abstractWidget;
            logOperationalPanel.log(-2137614336, "OperationalPanelController#add add Speller to OperationPanel: %1", (Object)this.speller);
        }
        super.add(abstractWidget);
    }

    private void updateValue() {
        if (this.model instanceof ChoiceModelGUI) {
            if (((ChoiceModelGUI)this.model).getStatus() == 1) {
                this.tunerMode = ((ChoiceModelGUI)this.model).getValue();
            }
        } else {
            logOperationalPanel.log(10000, "OperationalPanelController#updateValue no Model configurad for OpaertionPanel");
        }
    }

    private void initalizeKeyPanel() {
        Integer n;
        int n2;
        if (this.functionalKeysWidget == null || this.systemKeysWidget == null) {
            logOperationalPanel.log(10000, "OperationalPanelController#initalizeKeyPanel FunctionalKeys or SystemKeys are null");
            return;
        }
        this.panelKeys.clear();
        int[] nArray = this.mapKeysToList(this.functionalKeysWidget);
        int[] nArray2 = this.mapKeysToList(this.systemKeysWidget);
        if (nArray == null || nArray2 == null) {
            logOperationalPanel.log(10000, "OperationalPanelController#initalizeKeyPanel FunctionalKeys or SystemKeys have no content");
            return;
        }
        this.panelKeys.add(new Integer(-1));
        for (n2 = 0; n2 < nArray.length; ++n2) {
            n = new Integer(nArray[n2]);
            this.panelKeys.add(n);
        }
        for (n2 = 0; n2 < nArray2.length; ++n2) {
            n = new Integer(nArray2[n2]);
            if (nArray2[n2] == 6) {
                this.hasOkButton = true;
                continue;
            }
            this.panelKeys.add(n);
        }
        this.panelKeys.add(new Integer(-2));
        if (!this.panelKeys.isEmpty()) {
            this.cursorPosition = 1 - this.alignment;
        }
        if (logOperationalPanel.isDebug()) {
            for (n2 = 0; n2 < this.panelKeys.size(); ++n2) {
                logOperationalPanel.log(-2137614336, "OperationalPanelController#initalizeKeyPanel key added: %1", this.panelKeys.get(n2));
            }
        }
    }

    private int[] mapKeysToList(AbstractWidgetController abstractWidgetController) {
        Object object;
        Object object2 = abstractWidgetController.getModel();
        if (object2 instanceof DataModel && (object = ((DataModel)object2).get()) instanceof SimpleIntObjectMap) {
            SimpleIntObjectMap simpleIntObjectMap = (SimpleIntObjectMap)object;
            if (this.tunerMode > -1) {
                Object object3 = simpleIntObjectMap.get(this.tunerMode);
                return (int[])Collections.singletonList(object3).get(0);
            }
        }
        return null;
    }

    private void initializeKeyEventMap() {
        this.panelKeysHandler.clear();
        this.panelKeysHandler.addAll(this.panelKeys);
        if (this.panelKeysHandler.contains(new Integer(20))) {
            for (int i2 = 1; i2 < 10; ++i2) {
                this.panelKeysHandler.remove(new Integer(20 + i2));
            }
        }
    }

    public List getPanelKeysHandler() {
        return this.panelKeysHandler;
    }

    private void initalizeSpeller() {
        this.speller.setBounds(0, 0, 450, 42);
        this.speller.setSpellerMode(14);
        this.speller.setForceOKButton(this.hasOkButton);
        this.speller.setSpellerBandLanguage(new TouchCharSetAndTTSHandler(this.terminal));
        this.doSpellerAlignment();
        this.speller.setVisible(false);
        this.speller.setCompositesDirty(true);
    }

    @Override
    protected void initializeWidget() {
        this.updateValue();
        this.initalizeKeyPanel();
        this.initializeKeyEventMap();
        this.doAlignment(this.alignment);
        if (this.hasSpeller()) {
            this.initalizeSpeller();
        }
        super.initializeWidget();
    }

    private boolean hasSpeller() {
        return this.speller != null;
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (this.spellerOpen) {
            super.keyTurned(wheelButtonEvent);
            return;
        }
        if (this.cursorPosition == -1) {
            logOperationalPanel.log(-2137614336, "OperationalPanelController#keyTurned cursorPosition not initalized");
            return;
        }
        int n = wheelButtonEvent.getDirection();
        int n2 = this.cursorPosition;
        if (AbstractWidget.isArabia()) {
            n = (n + 1) % 2;
        }
        switch (n) {
            case 1: {
                this.cursorPosition = Math.max(this.alignment == 0 ? 1 : 0, this.cursorPosition - 1);
                break;
            }
            case 0: {
                this.cursorPosition = Math.min(this.alignment == 1 ? this.renderedKeys - 1 : this.renderedKeys, this.cursorPosition + 1);
                break;
            }
            default: {
                logOperationalPanel.log(-1601830656, "OperationPanelController#keyTurned unknown direction: %1", (long)n);
            }
        }
        if (n2 != this.cursorPosition) {
            this.setCompositesDirty(true);
            wheelButtonEvent.consume();
            logOperationalPanel.log(-2137614336, "OperationalPanelController#keyTurned set cursorPosition to %1", (long)this.cursorPosition);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.isVisible()) {
            return;
        }
        if (this.spellerOpen) {
            this.speller.setActive(true);
            if (keyEvent.getKeyCode() == 15) {
                this.closeSpeller();
            }
            if (keyEvent.getKeyCode() == 17) {
                super.keyPressed(keyEvent);
            }
            return;
        }
        if (keyEvent.getKeyCode() != 17 || keyEvent.getKeyCode() == 15) {
            return;
        }
        if (this.spellerOpen) {
            super.keyPressed(keyEvent);
        }
        if (this.cursorPosition != -1 && this.panelKeysHandler.size() > this.cursorPosition) {
            Object object = this.panelKeysHandler.get(this.cursorPosition);
            if (object == null) {
                return;
            }
            this.keyId = (Integer)object;
            if (this.keyId == -1) {
                this.doAlignment(0);
                keyEvent.consume(true);
                return;
            }
            if (this.keyId == -2) {
                this.doAlignment(1);
                keyEvent.consume(true);
                return;
            }
            if (this.keyId == 20) {
                if (!this.spellerOpen) {
                    this.openSpeller();
                }
                keyEvent.consume(true);
                return;
            }
            ((ChoiceModelGUI)this.buttonHandlerWidget.getModel()).keyPressed(this.keyId, this.getTerminal().getTerminalID());
            logOperationalPanel.log(-2137614336, "OperationalPanelController#keyPressed Send Keypressed to key: %1", (long)this.keyId);
        }
    }

    private void doAlignment(int n) {
        this.alignment = n;
        int n2 = this.panelKeysHandler.size() - 1;
        int n3 = n2 * this.iconSize + (n2 - 1) * this.iconGap + 20;
        switch (n) {
            case 0: {
                this.setX(this.positions[0]);
                this.setY(this.positions[1]);
                this.cursorPosition = this.panelKeysHandler.size() - 1;
                break;
            }
            case 1: {
                this.setX(this.positions[2] - n3);
                this.setY(this.positions[3]);
                this.cursorPosition = 0;
                break;
            }
            default: {
                logOperationalPanel.log(-1601830656, "OperationalPanelController#doAlignment unkown alignment: %1", (long)n);
            }
        }
        this.doSpellerAlignment();
    }

    private void doSpellerAlignment() {
        int n = 12;
        int n2 = 22;
        if (this.speller == null) {
            return;
        }
        if (this.alignment == 1) {
            int n3 = this.panelKeysHandler.size() - 1;
            int n4 = n3 * this.iconSize + (n3 - 1) * this.iconGap + 20;
            n = n4 - this.speller.getWidth();
        }
        this.speller.setX(this.getX() + n);
        this.speller.setY(this.getY() + n2);
    }

    private void openSpeller() {
        logOperationalPanel.log(-2137614336, "OperationalPanelController#openSpeller");
        this.speller.setVisible(this.isVisible());
        this.spellerOpen = this.speller.isVisible();
        this.speller.setCompositesDirty(true);
        this.speller.setActive(false);
        this.setCompositesDirty(true);
    }

    private void closeSpeller() {
        logOperationalPanel.log(-2137614336, "OperationalPanelController#closeSpeller");
        this.spellerOpen = false;
        this.speller.setVisible(false);
        this.speller.setCompositesDirty(true);
        this.setCompositesDirty(true);
        this.triggerRepaint();
    }

    public boolean isSpellerOpen() {
        return this.spellerOpen;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 17 || this.spellerOpen) {
            super.keyReleased(keyEvent);
            return;
        }
        if (this.keyId == -1) {
            return;
        }
        if (this.cursorPosition != -1 && this.panelKeysHandler.size() > this.cursorPosition && this.keyId > 0 && this.keyId != 20) {
            ((ChoiceModelGUI)this.buttonHandlerWidget.getModel()).keyReleased(this.keyId, this.getTerminal().getTerminalID());
            logOperationalPanel.log(-2137614336, "OperationalPanelController#keyReleased Send KeyReleased to key: %1", (long)this.keyId);
            this.keyId = -1;
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateValue();
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
    }

    @Override
    public void disconnecting() {
        this.alignment = 1;
        this.spellerOpen = false;
        this.cursorPosition = 0;
        super.disconnecting();
    }

    @Override
    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
    }

    @Override
    public void setVisible(boolean bl) {
        if (!bl) {
            this.closeSpeller();
        }
        super.setVisible(bl);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public void setSpellerOpen(boolean bl) {
        this.spellerOpen = bl;
    }

    public boolean getSpellerOpen() {
        return this.spellerOpen;
    }

    public int getCursorposition() {
        return this.cursorPosition;
    }

    public List getPanelKeys() {
        return this.panelKeys;
    }

    public int getTunerMode() {
        return this.tunerMode;
    }

    public int getIndexCursorImages() {
        return this.indexCursorImages;
    }

    public void setIndexCursorImages(int n) {
        this.indexCursorImages = n;
    }

    public int getIndexBackgroundImages() {
        return this.indexBackgroundImages;
    }

    public void setIndexBackgroundImages(int n) {
        this.indexBackgroundImages = n;
    }

    public int getIndexFunctionalKeysImages() {
        return this.indexFunctionalKeysImages;
    }

    public void setIndexFunctionalKeysImages(int n) {
        this.indexFunctionalKeysImages = n;
    }

    public int getIndexSystemKeysImages() {
        return this.indexSystemKeysImages;
    }

    public void setIndexSystemKeysImages(int n) {
        this.indexSystemKeysImages = n;
    }

    public int getIconGap() {
        return this.iconGap;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public int getIndexFunctionalKeysOverlayImages() {
        return this.indexFunctionalKeysOverlayImages;
    }

    public void setIndexFunctionalKeysOverlayImages(int n) {
        this.indexFunctionalKeysOverlayImages = n;
    }

    public void setRenderedKeys(int n) {
        this.renderedKeys = n;
    }

    public void setPositions(int[] nArray) {
        this.positions = nArray;
    }

    public int[] getPositions() {
        return this.positions;
    }

    public int getIndexAlignmentImages() {
        return this.indexAlignmentImages;
    }

    public void setIndexAlignmentImages(int n) {
        this.indexAlignmentImages = n;
    }

    public void setAlignment(int n) {
        this.alignment = n;
    }

    public int getAlignment() {
        return this.alignment;
    }

    @Override
    public void buttonPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType, SpellerButtonArgument spellerButtonArgument) {
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.CLOSE) {
            this.closeSpeller();
        }
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.OK) {
            logOperationalPanel.log(-2137614336, "OperationalPanelController#keyPressed Send Keypressed to key: %1", (Object)SpellerController$SpellerButtonType.OK);
            ((ChoiceModelGUI)this.buttonHandlerWidget.getModel()).keyPressed(6, this.getTerminal().getTerminalID());
            ((ChoiceModelGUI)this.buttonHandlerWidget.getModel()).keyReleased(6, this.getTerminal().getTerminalID());
        }
    }

    @Override
    public void buttonLongPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
    }

    @Override
    public void buttonReleased(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
    }

    @Override
    public void characterPressed(String string, boolean bl, boolean bl2) {
        if (!this.speller.isActive()) {
            return;
        }
        try {
            int n = Integer.valueOf(string);
            n = n == 0 ? 29 : n + 19;
            logOperationalPanel.log(-2137614336, "OperationalPanelController#keyPressed Send Keypressed to key: %1", (long)n);
            ((ChoiceModelGUI)this.buttonHandlerWidget.getModel()).keyPressed(n, this.getTerminal().getTerminalID());
            ((ChoiceModelGUI)this.buttonHandlerWidget.getModel()).keyReleased(n, this.getTerminal().getTerminalID());
        }
        catch (NumberFormatException numberFormatException) {
            logOperationalPanel.log(10000, "OperationalPanelController#keyPressed Send wrong character: %1", (Object)string);
        }
    }

    @Override
    public void focusedCharacterChanged(String string) {
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
    }

    public int getIndexSpellerBackgroundImages() {
        return this.indexSpellerBackgroundImages;
    }

    public void setIndexSpellerBackgroundImages(int n) {
        this.indexSpellerBackgroundImages = n;
    }

    public SpellerController getSpeller() {
        return this.speller;
    }

    public void setSpeller(SpellerController spellerController) {
        this.speller = spellerController;
    }

    @Override
    public void focusChanged(SpellerController$ISpellerItem spellerController$ISpellerItem, int n) {
    }
}

