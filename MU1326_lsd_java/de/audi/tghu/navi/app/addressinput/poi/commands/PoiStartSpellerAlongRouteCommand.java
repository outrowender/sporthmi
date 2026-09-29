/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.navigation.LIValueList;

public class PoiStartSpellerAlongRouteCommand
extends NavCommand {
    public static final long CORRIDOR_WIDTH_ECE;
    public static final long CORRIDOR_WIDTH_NAR;
    public static final long CORRIDOR_LENGTH_ECE;
    public static final long CORRIDOR_LENGTH_NAR;
    private final int selectionCriterion;
    private boolean valueListResponded = false;
    private boolean spellerResultResponded = false;
    private final boolean isNAR;

    public PoiStartSpellerAlongRouteCommand(int n, boolean bl) {
        this.isNAR = bl;
        this.selectionCriterion = n;
    }

    @Override
    public void execute() {
        int n = this.isNAR ? 0 : 0;
        int n2 = this.isNAR ? 0 : 0;
        this.logger.log(-2137614336, "PoiStartSpellerAlongRouteCommand#execute() - calling poiStartSpellerAlongRoute( %1, %2, %3 ) ", (Object)Selcrit.asString(this.selectionCriterion), (long)n, (long)n2);
        this.getDSINavigation().poiStartSpellerAlongRoute(this.selectionCriterion, n, n2);
    }

    protected void checkFinished() {
        if (this.valueListResponded && this.spellerResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(-2137614336, "PoiStartSpellerAlongRouteCommand#lispUpdateSpellerResult() ");
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.spellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(-2137614336, "PoiStartSpellerAlongRouteCommand#liValueList() - (# %1) ", l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.valueListResponded = true;
        this.checkFinished();
    }
}

