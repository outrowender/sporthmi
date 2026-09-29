/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.speechrec.VDECapabilities;

public class NaviInputModeCheckCommand
extends AbstractSystemCallCommand {
    private static final byte VDE_CAPABILITIES_FULLWORD_AND_SPELLING;
    private static final byte VDE_CAPABILITIES_FULLWORD;
    private static final byte VDE_CAPABILITIES_SPELLING;
    private static final byte VDE_CAPABILITIES_NONE;
    private static final byte VDE_CAPABILITIES_FULLWORD_AND_SPELLING_NO_ONESHOT;
    private static final byte VDE_CAPABILITIES_FULLWORD_NO_ONESHOT;
    protected NaviService service;
    private final SpeechRecognitionHandler srHandler;
    protected NaviSDSHandler naviHandler;

    public NaviInputModeCheckCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NaviService naviService, SpeechRecognitionHandler speechRecognitionHandler, NaviSDSHandler naviSDSHandler) {
        super(logChannel, string, sDSHandlerService);
        this.service = naviService;
        this.srHandler = speechRecognitionHandler;
        this.naviHandler = naviSDSHandler;
    }

    @Override
    public void execute() {
        String string = this.getCountryCode();
        if (SDSUtils.isEmpty(string)) {
            this.logger.log(-1601830656, "[%1#execute] countryCode=%2 -> sending NAVI_BUSY!", (Object)this.getName(), (Object)string);
            this.sendResult(1385955328);
            return;
        }
        this.logger.log(-2137614336, "[%1#execute] countryCode=%2, requesting VDE capabilities!", (Object)this.getName(), (Object)string);
        this.srHandler.requestVDECapabilities(string);
    }

    protected String getCountryCode() {
        if (this.naviHandler.getAIFCountry()) {
            return this.service.getAIFCountryCode();
        }
        return this.service.getCurrentCountryCode();
    }

    public void sdsInputModeCheckResult(byte by, VDECapabilities vDECapabilities, String string) {
        this.logger.log(-2137614336, "[%1#sdsInputModeCheckResult] result=%3, capabilities=%2", (Object)this.getName(), (Object)vDECapabilities, (long)by);
        if (vDECapabilities == null) {
            this.logger.log(-1601830656, "[%1#sdsInputModeCheckResult] Empty capabilities, sending ERROR!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        byte by2 = vDECapabilities.isFullWord() ? (vDECapabilities.isSpelling() ? (byte)0 : 1) : (vDECapabilities.isSpelling() ? (byte)2 : 3);
        byte by3 = this.adjustVDECapablities(vDECapabilities.getGrammarLanguage(), string, by2);
        this.logger.log(-2137614336, "[%1#sdsInputModeCheckResult] vdeCaps=%2, vdeCapsSDSLangAdjusted=%3!", (Object)this.getName(), (long)by2, (long)by3);
        SDSModelAccess.setNavVDECapabilities(by3);
        int n = by == 0 ? 3000 : 3001;
        this.logger.log(-2137614336, "[%1#sdsInputModeCheckResult] sdsRes=%2!", (Object)this.getName(), (long)n);
        this.sendResult(n);
    }

    private byte adjustVDECapablities(String[] stringArray, String string, byte n) {
        if (stringArray == null) {
            this.logger.log(-1601830656, "[%1#adjustVDECapablities] Empty vdeCountryLanguages!", (Object)this.getName());
            return (byte)n;
        }
        if (string == null) {
            this.logger.log(-1601830656, "[%1#adjustVDECapablities] Empty sdsLanguage!", (Object)this.getName());
            return (byte)n;
        }
        boolean bl = false;
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equals(stringArray[i2])) continue;
            bl = true;
            break;
        }
        return (byte)(bl ? n : (n == 0 ? 4 : (n == 1 ? 5 : n)));
    }
}

