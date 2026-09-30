/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.phone.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.atip.log.LogChannel;

public class PhoneSiriActivateCommand
extends AbstractSystemCallCommand {
    private final MobileSpeechRecognitionHandler mobileSRHandler;

    public PhoneSiriActivateCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler) {
        super(logChannel, string, sDSHandlerService);
        this.mobileSRHandler = mobileSpeechRecognitionHandler;
    }

    public void execute() {
        boolean bl = this.mobileSRHandler.isMobileSpeechRecognitionActive();
        this.logger.log(10000000, "PhoneSiriActivateCommand#execute: mobileSRActive=%1", bl);
        if (bl || !this.mobileSRHandler.requestStartSpeechRecognition()) {
            this.logger.log(10000000, "PhoneSiriActivateCommand#execute: External speech recognition not started, sending ERROR!");
            super.sendResult(30001);
        }
        this.sdsHandlerService.switchEntertainment(false);
    }

    public void responseStartSpeechRecognition(int n) {
        String string;
        switch (n) {
            case 1: {
                string = "ABORTED";
                break;
            }
            case 5: {
                string = "ALREADY ACTIVE";
                break;
            }
            case 4: {
                string = "NOT AVAILABLE";
                break;
            }
            case 3: {
                string = "NOT STARTED";
                break;
            }
            case 2: {
                string = "UNSPECIFIED";
                break;
            }
            case 0: {
                string = "OK";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        this.logger.log(10000000, "PhoneSiriActivateCommand#responseStartSpeechRecognition: result=%2, mobile speech recognition is %1!", (Object)string, (long)n);
        super.sendResult(n == 0 ? 30000 : 30001);
    }
}

