/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.audi.tv.app.tm.KeyPanelHandler$1;

class KeyPanelHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ KeyPanelHandler this$0;

    private KeyPanelHandler$ButtonListener(KeyPanelHandler keyPanelHandler) {
        this.this$0 = keyPanelHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        short s = this.getKeyPanelCode(n);
        KeyPanelHandler.access$400((KeyPanelHandler)this.this$0).lcHMI.log(-2137614336, "[KeyPanelHandler.keyReleased] key:0x%1", (long)s);
        KeyPanelHandler.access$600(this.this$0, s, (short)1);
        KeyPanelHandler.access$600(this.this$0, s, (short)0);
    }

    private short getKeyPanelCode(int n) {
        switch (n) {
            case 2600145: {
                return 1;
            }
            case 2600129: {
                return 2;
            }
            case 2600144: {
                return 3;
            }
            case 2600127: {
                return 4;
            }
            case 2600126: {
                return 5;
            }
            case 2600128: {
                return 6;
            }
            case 2600133: {
                return 12;
            }
            case 2600130: {
                return 13;
            }
            case 2600131: {
                return 14;
            }
            case 2600132: {
                return 15;
            }
            case 2600134: {
                return 29;
            }
            case 2600135: {
                return 20;
            }
            case 2600136: {
                return 21;
            }
            case 2600137: {
                return 22;
            }
            case 2600138: {
                return 23;
            }
            case 2600139: {
                return 24;
            }
            case 2600140: {
                return 25;
            }
            case 2600141: {
                return 26;
            }
            case 2600142: {
                return 27;
            }
            case 2600143: {
                return 28;
            }
            case 2600172: {
                return 36;
            }
            case 2600186: {
                return 38;
            }
        }
        return -1;
    }

    /* synthetic */ KeyPanelHandler$ButtonListener(KeyPanelHandler keyPanelHandler, KeyPanelHandler$1 keyPanelHandler$1) {
        this(keyPanelHandler);
    }
}

