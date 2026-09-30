/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.ISpeller;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.search.ISearchListener;
import de.audi.tghu.online.app.remotehmi.search.ITruffleSearchHandler;
import de.audi.tghu.online.app.remotehmi.util.MapUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public abstract class AbstractSpellerHandler
implements SpellerListener,
ISearchListener {
    public static final int STATE_INVISIBLE = 0;
    public static final int STATE_VISIBLE = 1;
    protected RemoteHMIService service;
    protected int type;
    protected ITruffleSearchHandler truffleSearchHandler;
    protected LogChannel logChannel;
    protected Map spellerValues = new HashMap();
    protected SpellerModelApp spellerModel;
    protected ChoiceModelApp spellerBarVisibilityChoice;

    public AbstractSpellerHandler(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.logChannel = logChannel;
        this.service = remoteHMIService;
    }

    public abstract void setTruffleComponent(ITruffleSearchHandler var1);

    public void updateViewProperties(ISpeller iSpeller, boolean bl) {
        this.type = iSpeller.getType();
        this.setSpellerBarVisible(bl);
        iSpeller.setSpellerListener(this);
        boolean bl2 = !iSpeller.isOkButtonDisabled();
        this.spellerModel.setCommandAvailable(7, bl2);
    }

    public final void textChanged(final int n, final String string, final char c2, final int n2) {
        this.logChannel.log(1000000, "AbstractSpellerHandler#textChanged: type %1, text changed %2", (Object)MapUtilities.getDescriptionOfFirstValue(ISpeller.typeOptions, this.type), (Object)string);
        this.service.execute(new AbstractRemoteHMITask("speller-text-changed", LogAppender.Factory.fromString(string)){

            public void run() {
                AbstractSpellerHandler.this.processTextChanged(n, string, c2, n2);
            }
        });
    }

    protected abstract void processTextChanged(int var1, String var2, char var3, int var4);

    protected abstract void triggerSpellerAction(RemoteHMIAction var1, int var2, String var3);

    protected void invokeAction(RemoteHMIAction remoteHMIAction, String string, int n, String string2) {
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putInt("selectedNumber", n);
        hMIProperties.putString("selectedId", string2);
        hMIProperties.putString("textInput", string);
        this.service.invokeAction(remoteHMIAction);
    }

    public void setSpellerBarVisible(boolean bl) {
        this.spellerBarVisibilityChoice.setValue(bl ? 1 : 0);
    }

    public void commandPressed(int n, int n2, int n3) {
        String string = "AbstractSpellerHandler#commandPressed: commandPressed model=%1, index=%2 (4711 =opened, 4712=closed).";
        this.logChannel.log(1000000, string, (long)n, (long)n2);
        if (n2 == 4711) {
            this.spellerBandVisibilityCallback(true);
        } else if (n2 == 4712) {
            this.spellerBandVisibilityCallback(false);
        }
    }

    protected abstract void spellerBandVisibilityCallback(boolean var1);

    public void focusedCharacter(int n, char c2, int n2) {
        this.logChannel.log(1000000, "AbstractSpellerHandler#focusedCharacter: focusedCharacter");
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AbstractSpellerHandler#keyPressed: keyPressed");
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(1000000, "AbstractSpellerHandler#keyReleased: keyReleased");
    }

    public void keyTyped(final int n, int n2, int n3) {
        this.logChannel.log(1000000, "AbstractSpellerHandler#keyTyped: keyTyped");
        this.service.execute(new AbstractRemoteHMITask("speller-key-typed", LogAppender.Factory.fromInt(n2)){

            public void run() {
                AbstractSpellerHandler.this.triggerSpellerAction(AbstractSpellerHandler.this.service.getAction(1000900), n, (String)AbstractSpellerHandler.this.spellerValues.get(new Integer(n)));
            }
        });
    }

    protected void clearSpeller() {
        this.spellerModel.clear();
    }

    public void triggerApplySearchFilter(final int n, final Token[] tokenArray) {
        this.service.execute(new AbstractRemoteHMITask("speller-apply-search-filter", LogAppender.Factory.fromInt(n)){

            public void run() {
                AbstractSpellerHandler.this.applySearchFilter(n, tokenArray);
            }
        });
    }

    protected abstract void applySearchFilter(int var1, Token[] var2);

    protected ArrayList createHighlightList(Token[] tokenArray) {
        ArrayList arrayList = new ArrayList(tokenArray.length);
        int n = tokenArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Integer(tokenArray[i2].wordType));
            arrayList2.add(this.convertHighlightToIntArray(tokenArray[i2].highlights));
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private int[] convertHighlightToIntArray(Highlight[] highlightArray) {
        if (highlightArray == null) {
            return new int[0];
        }
        int n = highlightArray.length;
        int[] nArray = new int[n * 2];
        for (int i2 = 0; i2 < n; ++i2) {
            Highlight highlight = highlightArray[i2];
            int n2 = i2 * 2;
            nArray[n2] = highlight.highlightStart;
            nArray[n2 + 1] = highlight.highlightEnd;
        }
        return nArray;
    }

    public void handleSuggestion(final Suggestion suggestion, String string) {
        LogAppender logAppender = suggestion == null ? null : LogAppender.Factory.fromString(suggestion.getSuggestion());
        this.service.execute(new AbstractRemoteHMITask("speller-handle-suggestion", logAppender){

            public void run() {
                if (suggestion == null) {
                    AbstractSpellerHandler.this.logChannel.log(1000000, "AbstractSpellerHandler#requestSuggestion: no suggestion");
                    return;
                }
                String string = new StringBuffer().append(AbstractSpellerHandler.this.spellerModel.getText()).append(suggestion.getSuggestion()).toString();
                AbstractSpellerHandler.this.logChannel.log(10000000, "AbstractGuiSearchHandler#setSlowGuess setting %1 as slow guess", (Object)string);
                AbstractSpellerHandler.this.spellerModel.setSuggestions(string, suggestion.getQuery());
            }
        });
    }
}

