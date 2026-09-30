/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractInputSequenceMatchspellerListener
implements MatchSpellerListener,
TiledListModelListener {
    protected NavigationEnv env;
    protected final IPreviewMap previewMap;
    protected final LogChannel logChannel;
    protected TiledListModelApp tiledListModel;
    protected MenuModelApp menuModel;

    public AbstractInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int n, int n2, IPreviewMap iPreviewMap) {
        this.env = navigationEnv;
        navigationEnv.getMatchSpellerModel(n).setSpellerListener(this);
        this.tiledListModel = navigationEnv.getTiledListModel(n2);
        this.tiledListModel.setListener(this);
        this.previewMap = iPreviewMap;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    public AbstractInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int n, int n2) {
        this(navigationEnv, n, n2, null);
    }

    public AbstractInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int[] nArray, int[] nArray2, IPreviewMap iPreviewMap) {
        int n;
        this.previewMap = iPreviewMap;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        for (n = 0; n < nArray.length; ++n) {
            navigationEnv.getMatchSpellerModel(nArray[n]).setSpellerListener(this);
        }
        for (n = 0; n < nArray2.length; ++n) {
            navigationEnv.getTiledListModel(nArray2[n]).setListener(this);
        }
    }

    public AbstractInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int[] nArray, int[] nArray2, int n, IPreviewMap iPreviewMap) {
        int n2;
        this.previewMap = iPreviewMap;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.menuModel = navigationEnv.getMenuModel(n);
        for (n2 = 0; n2 < nArray.length; ++n2) {
            navigationEnv.getMatchSpellerModel(nArray[n2]).setSpellerListener(this);
        }
        for (n2 = 0; n2 < nArray2.length; ++n2) {
            navigationEnv.getTiledListModel(nArray2[n2]).setListener(this);
        }
    }

    public AbstractInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int[] nArray, int[] nArray2) {
        this(navigationEnv, nArray, nArray2, null);
    }

    public AbstractInputSequenceMatchspellerListener(NavigationEnv navigationEnv, int n, int n2, int n3, IPreviewMap iPreviewMap) {
        this.env = navigationEnv;
        navigationEnv.getMatchSpellerModel(n).setSpellerListener(this);
        this.tiledListModel = navigationEnv.getTiledListModel(n2);
        this.tiledListModel.setListener(this);
        this.previewMap = iPreviewMap;
        this.menuModel = navigationEnv.getMenuModel(n3);
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#textChanged(%1, %2, %3)", (Object)(n + ""), (Object)string, (long)c2);
        Util.setModelStatus(this.env.getMatchSpellerModel(n), 0);
        if ("".equals(string)) {
            this.getInputSequence().deleteAllCharacters();
        } else if (c2 == '\b') {
            this.getInputSequence().undoCharacter();
        } else {
            this.getInputSequence().addCharacter(Character.toString(c2), n, false);
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "AbstractInputSequence#requestItems - was called with requestID = %1, startIndex = %2, model = %3", (long)n3, (long)n, (long)n4);
        this.getInputSequence().requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.getInputSequence().unrequestItems(n, n2);
    }

    public abstract IMatchspellerInputSequence getInputSequence();

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#itemReleased() was invoked");
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#itemLongSelected() was invoked");
    }

    public void focusedCharacter(int n, char c2, int n2) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#focusedCharacter() was invoked");
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#keyPressed() was invoked");
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#keyReleased() was invoked");
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#keyTyped() was invoked");
    }

    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "AbstractInputSequenceMatchspellerListener#textChanged() was invoked");
    }
}

