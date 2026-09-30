/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;

public class AdvancedChoiceListener
extends DefaultChoiceListener {
    private List listeners = new ArrayList();
    private LogChannel logger;

    public AdvancedChoiceListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public void addChoiceListener(ChoiceListener choiceListener) {
        if (!this.listeners.contains(choiceListener)) {
            this.getLogger().log(100000000, "%1#addChoiceListener( %2 )", (Object)this, (Object)choiceListener);
            this.listeners.add(choiceListener);
        }
    }

    public void removeChoiceListener(ChoiceListener choiceListener) {
        if (this.listeners.contains(choiceListener)) {
            this.listeners.remove(choiceListener);
        }
    }

    public void clear() {
        this.listeners.clear();
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            try {
                this.getLogger().log(100000000, "AdvancedChoiceListener[%1/%2]#itemSelected( %3 )", (long)i2, (long)this.listeners.size(), (long)n);
                ((ChoiceListener)this.listeners.get(i2)).itemSelected(n, n2, n3, n4);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            try {
                ((ChoiceListener)this.listeners.get(i2)).itemFocused(n, n2, n3, n4);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            try {
                ((ChoiceListener)this.listeners.get(i2)).keyPressed(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            try {
                ((ChoiceListener)this.listeners.get(i2)).keyReleased(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            try {
                ((ChoiceListener)this.listeners.get(i2)).keyTyped(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            try {
                ((ChoiceListener)this.listeners.get(i2)).keyLongTyped(n, n2, n3);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

