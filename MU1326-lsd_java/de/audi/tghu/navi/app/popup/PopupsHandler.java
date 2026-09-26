/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.popup;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.popup.IPopupHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PopupsHandler
implements IPopupHandler {
    private List handlers;
    private final LogChannel logger;

    public PopupsHandler(LogChannel logChannel) {
        this.logger = logChannel;
        this.handlers = new ArrayList();
    }

    public void addHandler(IPopupHandler iPopupHandler) {
        this.handlers.add(iPopupHandler);
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.logger.log(-2137614336, "PopupsHandler#popupVisible( %1 ) ", (long)n);
        Iterator iterator = this.handlers.iterator();
        while (iterator.hasNext()) {
            try {
                IPopupHandler iPopupHandler = (IPopupHandler)iterator.next();
                iPopupHandler.popupVisible(n, n2);
            }
            catch (Exception exception) {
                this.logger.log(10000, "PopupsHandler#popupVisible() - exception %1 ", (Object)exception.getMessage());
            }
        }
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.logger.log(-2137614336, "Navigation#popupHidden( %1 ) ", (long)n);
        Iterator iterator = this.handlers.iterator();
        while (iterator.hasNext()) {
            try {
                IPopupHandler iPopupHandler = (IPopupHandler)iterator.next();
                iPopupHandler.popupHidden(n, n2);
            }
            catch (Exception exception) {
                this.logger.log(10000, "PopupsHandler#popupHidden() - exception %1 ", (Object)exception.getMessage());
            }
        }
    }
}

