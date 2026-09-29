/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.addressinput.IRestorable;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;

public class LIGetStateCommand
extends NavCommand {
    public static final Object SPELLERSTATE = new Object();
    private final SpellerStack spellerStack;
    private final LIValueListElement element;
    private final int categoryUid;
    private final SpellerContext sc;
    private final IAdditionalStateInfo[] infos;
    private final IRestorable restorable;

    public LIGetStateCommand(SpellerStack spellerStack, SpellerContext spellerContext) {
        this(spellerStack, null, -1, new IAdditionalStateInfo[0], spellerContext, null);
    }

    public LIGetStateCommand(SpellerStack spellerStack, IAdditionalStateInfo[] iAdditionalStateInfoArray, SpellerContext spellerContext) {
        this(spellerStack, null, -1, iAdditionalStateInfoArray, spellerContext, null);
    }

    public LIGetStateCommand(SpellerStack spellerStack, LIValueListElement lIValueListElement) {
        this(spellerStack, lIValueListElement, -1, new IAdditionalStateInfo[0], null, null);
    }

    public LIGetStateCommand(SpellerStack spellerStack, LIValueListElement lIValueListElement, IRestorable iRestorable) {
        this(spellerStack, lIValueListElement, -1, new IAdditionalStateInfo[0], null, iRestorable);
    }

    public LIGetStateCommand(SpellerStack spellerStack, LIValueListElement lIValueListElement, int n, IAdditionalStateInfo[] iAdditionalStateInfoArray) {
        this(spellerStack, lIValueListElement, n, iAdditionalStateInfoArray, null, null);
    }

    public LIGetStateCommand(SpellerStack spellerStack, LIValueListElement lIValueListElement, int n, IAdditionalStateInfo[] iAdditionalStateInfoArray, SpellerContext spellerContext, IRestorable iRestorable) {
        this.spellerStack = spellerStack;
        this.element = lIValueListElement;
        this.categoryUid = n;
        this.infos = iAdditionalStateInfoArray;
        this.sc = spellerContext;
        this.restorable = iRestorable;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LIGetStateCommand#execute() - calling liGetState() ");
        this.getDSINavigation().liGetState();
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        this.logger.log(-2137614336, "LIGetStateCommand#liGetStateResult()");
        SpellerStack$StackElement spellerStack$StackElement = new SpellerStack$StackElement(lISpellerData, this.element, this.categoryUid, this.infos, this.sc, this.restorable);
        this.spellerStack.push(spellerStack$StackElement);
        this.logger.log(-2137614336, "LIGetStateCommand#liGetStateResult  Stored( %1 )", (Object)LocationFormatter.formatLocationShort(this.dsiResponseContainer.getLiCurrentLD()));
        this.getCommandList().commandFinished();
    }
}

