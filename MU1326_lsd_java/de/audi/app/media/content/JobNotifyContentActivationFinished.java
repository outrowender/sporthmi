/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.ISourceSlot;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;

public class JobNotifyContentActivationFinished
implements Runnable {
    private static final String LOGCLASS = "JobNotifyContentActivationFinished";
    final List listeners;
    private final IMediaLogger logger;
    final IContent content;
    private final ISourceSlot activeSlot;

    public JobNotifyContentActivationFinished(IMediaLogger iMediaLogger, List list, IContent iContent) {
        this.logger = iMediaLogger;
        this.listeners = list;
        this.content = iContent;
        this.activeSlot = iContent.getActiveSlot();
    }

    public void run() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IContentListener)iterator.next()).contentActivationFinished(this.content);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.run]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(LOGCLASS).append(": '").append(LogUtil.getContentTypeStr(this.content.getContentType())).append("','").append(this.activeSlot).append("'");
        return buffer.toString();
    }
}

