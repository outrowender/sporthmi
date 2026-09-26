/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerLogging;

class SwdlDSIHandlerLogging$UnusualEvent {
    private String description;
    private String template;
    private final /* synthetic */ SwdlDSIHandlerLogging this$0;

    public SwdlDSIHandlerLogging$UnusualEvent(SwdlDSIHandlerLogging swdlDSIHandlerLogging, String string, String string2) {
        this.this$0 = swdlDSIHandlerLogging;
        this.description = string;
        this.template = string2;
    }

    static /* synthetic */ String access$000(SwdlDSIHandlerLogging$UnusualEvent swdlDSIHandlerLogging$UnusualEvent) {
        return swdlDSIHandlerLogging$UnusualEvent.description;
    }

    static /* synthetic */ String access$100(SwdlDSIHandlerLogging$UnusualEvent swdlDSIHandlerLogging$UnusualEvent) {
        return swdlDSIHandlerLogging$UnusualEvent.template;
    }
}

