/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.AbstractCombiElement;
import de.audi.atip.hmi.combi.CombiCursorBarElement;
import de.audi.atip.hmi.combi.CombiIntegerElement;
import de.audi.atip.hmi.combi.CombiRGIElement;
import de.audi.atip.hmi.combi.CombiTextElement;
import de.audi.atip.hmi.combi.ddp2.CombiElementBankDDP2;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiElementBank {
    private static CombiElementBank combiElementBank;
    private CombiElementBankDDP2 combiElementBankDDP2;
    private CombiTextElement receptionBarElement;
    private boolean receptionBarElementAvailable;

    private CombiElementBank() {
        this.initialize();
    }

    private void initialize() {
        this.combiElementBankDDP2 = CombiElementBankDDP2.getInstance();
        this.receptionBarElement = new CombiTextElement();
        this.receptionBarElementAvailable = false;
    }

    public static synchronized CombiElementBank getInstance() {
        if (combiElementBank == null) {
            combiElementBank = new CombiElementBank();
        }
        return combiElementBank;
    }

    public int size() {
        return this.combiElementBankDDP2.size();
    }

    public AbstractCombiElement getCombiElementAt(int n) {
        switch (n) {
            case 5: {
                return this.combiElementBankDDP2.getCombiElementAt(5, 0);
            }
            case 7: {
                return this.combiElementBankDDP2.getCombiElementAt(4, 0);
            }
            case 6: {
                return this.combiElementBankDDP2.getCombiElementAt(3, 0);
            }
            case 8: {
                return this.combiElementBankDDP2.getFlag(1);
            }
            case 12: {
                return this.receptionBarElement;
            }
            case 18: {
                return this.combiElementBankDDP2.getIntegerElementAt(20, 1);
            }
            case 17: {
                return this.combiElementBankDDP2.getCombiElementAt(19, 0);
            }
        }
        return null;
    }

    public AbstractCombiElement getCombiElementAt(int n, int n2) {
        if (n2 != -1) {
            switch (n) {
                case 19: {
                    return this.combiElementBankDDP2.getCombiElementAt(21, n2);
                }
            }
            return this.getCombiElementAt(n);
        }
        return null;
    }

    public CombiTextElement getTextElementAt(int n) {
        switch (n) {
            case 12: {
                return this.receptionBarElement;
            }
            case 5: {
                return this.combiElementBankDDP2.getTextElementAt(5, 0, false);
            }
            case 6: {
                return this.combiElementBankDDP2.getTextElementAt(3, 0, false);
            }
            case 7: {
                return this.combiElementBankDDP2.getTextElementAt(4, 0, false);
            }
            case 8: {
                return this.combiElementBankDDP2.getFlag(1);
            }
        }
        System.err.println("CombiElementBank.getTextElementAt - Invalid logical ID: " + n);
        return null;
    }

    public CombiTextElement getTextElementAt(int n, int n2, boolean bl) {
        if (n2 != -1) {
            switch (n) {
                case 0: 
                case 13: {
                    return this.combiElementBankDDP2.getTextElementAt(6, n2, bl);
                }
                case 1: {
                    return this.combiElementBankDDP2.getTextElementAt(7, n2, bl);
                }
                case 2: {
                    return this.combiElementBankDDP2.getTextElementAt(8, n2, bl);
                }
                case 3: {
                    return this.combiElementBankDDP2.getTextElementAt(9, n2, bl);
                }
                case 4: {
                    return this.combiElementBankDDP2.getTextElementAt(10, n2, bl);
                }
                case 9: 
                case 10: 
                case 11: 
                case 12: {
                    switch (n2) {
                        case 4: 
                        case 5: 
                        case 6: 
                        case 16: {
                            return this.combiElementBankDDP2.getTextElementAt(1, 0, bl);
                        }
                    }
                    return this.combiElementBankDDP2.getTextElementAt(0, 0, bl);
                }
            }
            return this.getTextElementAt(n);
        }
        return new CombiTextElement();
    }

    public CombiRGIElement getRGIElement() {
        return this.combiElementBankDDP2.getRGIElement();
    }

    public CombiIntegerElement getIntegerElementAt(int n) {
        switch (n) {
            case 18: {
                return this.combiElementBankDDP2.getIntegerElementAt(20, 1);
            }
        }
        return null;
    }

    public CombiCursorBarElement getCursorBarElement(int n) {
        return this.combiElementBankDDP2.getCursorBarElement(n);
    }

    public boolean isReceptionBarElementAvailable() {
        return this.receptionBarElementAvailable;
    }

    public void setReceptionBarElementAvailable(boolean bl) {
        this.receptionBarElementAvailable = bl;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("STATUS:\nreceptionBarElement: ").append(this.receptionBarElement.text).append("\t dirty: ").append(this.receptionBarElement.dirty).append("\nreceptionBarElementAvailable: ").append(this.receptionBarElementAvailable).append("\n\n");
        return buffer.toString();
    }
}

