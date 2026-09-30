/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.command.AbstractCommand;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationDefaultListener;
import org.dsi.ifc.online.DSIOnlineDictationListener;
import org.dsi.ifc.online.DictationValueSentence;

public abstract class AbstractDsiOnlineDictationCommand
extends AbstractCommand
implements DSIOnlineDictationListener {
    protected final DsiOnlineDictationAccess dsiOnlineDictationAccess;
    private final DsiOnlineDictationDefaultListener dsiOnlineDictationDefaultListener;

    protected AbstractDsiOnlineDictationCommand(DictationComponentManager dictationComponentManager) {
        super(dictationComponentManager);
        this.dsiOnlineDictationAccess = dictationComponentManager.getDsiOnlineDictationAccess();
        this.dsiOnlineDictationDefaultListener = dictationComponentManager.getDsiOnlineDictationPrimaryListener().getDsiOnlineDictationDefaultListener();
    }

    public void dictationResult(int n) {
        this.dsiOnlineDictationDefaultListener.dictationResult(n);
    }

    public void finishDictationResponse(int n) {
        this.dsiOnlineDictationDefaultListener.finishDictationResponse(n);
    }

    public void dictationValueList(DictationValueSentence dictationValueSentence) {
        this.dsiOnlineDictationDefaultListener.dictationValueList(dictationValueSentence);
    }

    public static final int mapDsiErrorCode(int n) {
        int n2;
        switch (n) {
            case 24: {
                n2 = 24;
                break;
            }
            case 23: {
                n2 = 23;
                break;
            }
            case 22: {
                n2 = 22;
                break;
            }
            case 21: {
                n2 = 21;
                break;
            }
            case 72: {
                n2 = 72;
                break;
            }
            case 42: {
                n2 = 42;
                break;
            }
            case 43: {
                n2 = 43;
                break;
            }
            case 64: {
                n2 = 64;
                break;
            }
            case 73: {
                n2 = 73;
                break;
            }
            case 45: {
                n2 = 45;
                break;
            }
            case 47: {
                n2 = 47;
                break;
            }
            case 44: {
                n2 = 44;
                break;
            }
            case 52: {
                n2 = 52;
                break;
            }
            case 53: {
                n2 = 53;
                break;
            }
            case 55: {
                n2 = 55;
                break;
            }
            case 54: {
                n2 = 54;
                break;
            }
            case 51: {
                n2 = 51;
                break;
            }
            case 56: {
                n2 = 56;
                break;
            }
            case 31: {
                n2 = 31;
                break;
            }
            case 41: {
                n2 = 41;
                break;
            }
            case 46: {
                n2 = 46;
                break;
            }
            case 71: {
                n2 = 71;
                break;
            }
            case 48: {
                n2 = 48;
                break;
            }
            case 61: {
                n2 = 61;
                break;
            }
            case 63: {
                n2 = 63;
                break;
            }
            case 62: {
                n2 = 62;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }
}

