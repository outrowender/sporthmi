/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AbstractAddressInputListenerEvo;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;

public abstract class AbstractAddressInputListenerJP
extends AbstractAddressInputListenerEvo
implements MatchspellerListenerAsia,
TiledListModelListener,
MenuModelListener {
    protected final int matchSpellerModelId;
    protected final int menuModelId;
    protected final int tiledListModelId;
    protected MenuModelApp menuModel;
    protected MatchspellerModelApp matchspellerModel;
    protected TiledListModelApp tiledListModel;
    protected final AbstractAddressInputMatchSpellerSequence inputSequence;
    private boolean isSpellerOpen = false;

    public AbstractAddressInputListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = abstractAddressInputMatchSpellerSequence;
        this.menuModelId = n;
        this.matchSpellerModelId = n2;
        this.tiledListModelId = n3;
    }

    protected abstract void initListeners();

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
        this.logChannel.log(10000000, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        this.inputSequence.nonAlphaNumTPCharsChanged(n, n2, string, this.matchspellerModel);
    }

    public void inputModeTPChanged(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#inputModeTPChanged - modelId=%2, mode=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (!AddressInputUtil.getCurrentLanguageCode(this.env).equals("en_US")) {
            this.inputSequence.touchPadInputModeChanged(n2);
        }
    }

    public void strokesChanged(int n, int n2, String string, char c2) {
        this.logChannel.log(10000000, "%1#strokesChanged - modelId=%2, strokes=%3, lastStroke=%4", (Object)this.CLASS_NAME, (Object)String.valueOf(n), (Object)string, (long)c2);
    }

    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#getValidHanziCharsWindow - modelId=%2, offset=%3, windowSize=%4", (Object)this.CLASS_NAME, (Object)String.valueOf(n), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#unrequestItems - was called with startIndex = %2, model = %3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (long)n3);
        this.inputSequence.unrequestItems(n, n2);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)(n + ""), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2), n, false);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused - item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped - keyTyped was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        long l = this.env.getContainer().getLispValueListCount();
        this.logChannel.log(10000000, "%1#keyTyped - valueListCount = %2 ", (Object)this.CLASS_NAME, l);
        if (l == 1L && null != this.menuModel) {
            if (this.tiledListModel == null) {
                this.logChannel.log(10000000, "%1#keyTyped - tiledListModel is null", (Object)this.CLASS_NAME);
                return;
            }
            if (this.tiledListModel.getRow(0) == null) {
                this.logChannel.log(10000000, "%1#keyTyped - tiledListModel.getRow(0) is null", (Object)this.CLASS_NAME);
                return;
            }
            EvoListRow evoListRow = this.tiledListModel.getRow(0);
            this.menuModel.setFocusedItem(this.tiledListModel.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, evoListRow.getUniqueID());
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 20802);
            this.env.fireModelEvent(this.tiledListModel.getID(), n3);
        }
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused() was called with menuItemID = %2 , model = %3, uniqueListRowID = %4, ", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Long.toString(l));
        if (n == this.matchSpellerModelId) {
            if (this.isSpellerOpen) {
                this.inputSequence.hidePreviewMap(this.previewMap);
            } else {
                this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
            }
        } else if (n == 6) {
            this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
        }
    }

    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#commandPressed(%1, %2, %3)", (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
        if (n == this.matchSpellerModelId) {
            this.isSpellerOpen = false;
            if (n2 == 4712) {
                this.inputSequence.showPreviewMapAroundCCP(this.previewMap);
            } else if (n2 == 4711) {
                this.isSpellerOpen = true;
                this.inputSequence.hidePreviewMap(this.previewMap);
            }
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

