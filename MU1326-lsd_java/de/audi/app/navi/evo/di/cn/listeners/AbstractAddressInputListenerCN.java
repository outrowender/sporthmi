/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

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

public abstract class AbstractAddressInputListenerCN
extends AbstractAddressInputListenerEvo
implements MatchspellerListenerAsia,
MenuModelListener,
TiledListModelListener {
    protected final int matchSpellerModelId;
    protected final int menuModelId;
    protected final int tiledListModelId;
    protected MenuModelApp menuModel;
    protected MatchspellerModelApp matchspellerModel;
    protected TiledListModelApp tiledListModel;
    protected final AbstractAddressInputMatchSpellerSequence inputSequence;
    protected boolean isSpellerOpen = false;

    public AbstractAddressInputListenerCN(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = abstractAddressInputMatchSpellerSequence;
        this.matchSpellerModelId = n2;
        this.menuModelId = n;
        this.tiledListModelId = n3;
    }

    @Override
    protected abstract void initListeners() {
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
        this.logChannel.log(-2137614336, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        this.inputSequence.nonAlphaNumTPCharsChanged(n, n2, string, this.matchspellerModel);
    }

    @Override
    public void inputModeTPChanged(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#inputModeTPChanged - modelId=%2, mode=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (!AddressInputUtil.getCurrentLanguageCode(this.env).equals("en_US")) {
            this.inputSequence.touchPadInputModeChanged(n2);
        }
    }

    @Override
    public void strokesChanged(int n, int n2, String string, char c2) {
        this.logChannel.log(-2137614336, "%1#strokesChanged(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)String.valueOf(n), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if (c2 == '\b') {
            this.inputSequence.undoStroke();
        } else {
            this.inputSequence.addStroke(String.valueOf(c2));
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "%1#textChanged(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)new StringBuffer().append(n).append("").toString(), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2), n, false);
        }
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#requestItems - was called with requestID=%2, startIndex=%3, model=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#requestValidHanziCharsWindow - modelId=%2, offset=%3, windowSize=%4", (Object)this.CLASS_NAME, (Object)String.valueOf(n), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
        this.inputSequence.requestValidHanziCharsWindow(n, n3, n4);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped - called with model=%2, index=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        long l = this.env.getContainer().getLispValueListCount();
        this.logChannel.log(-2137614336, "%1#keyTyped - valueListCount = %2 ", (Object)this.CLASS_NAME, l);
        if (l == 1L && null != this.menuModel) {
            if (this.tiledListModel == null) {
                this.logChannel.log(-2137614336, "%1#keyTyped - tiledListModel is null", (Object)this.CLASS_NAME);
                return;
            }
            if (this.tiledListModel.getRow(0) == null) {
                this.logChannel.log(-2137614336, "%1#keyTyped - tiledListModel.getRow(0) is null", (Object)this.CLASS_NAME);
                return;
            }
            EvoListRow evoListRow = this.tiledListModel.getRow(0);
            this.menuModel.setFocusedItem(this.tiledListModel.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, evoListRow.getUniqueID());
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 10402);
            this.env.fireModelEvent(n, n3);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused() was called with menuItemID = %2 , model = %3, uniqueListRowID = %4, ", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Long.toString(l));
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

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#commandPressed(%1, %2, %3)").toString(), (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
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

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }
}

