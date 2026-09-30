/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;

abstract class AbstractDataBuffer {
    AbstractDataBuffer() {
    }

    public static AbstractDataBuffer createDataBuffer(HMIModel hMIModel) {
        if (hMIModel == null) {
            return null;
        }
        int n = hMIModel.getModelType();
        switch (n) {
            case 1: {
                return new ButtonDataBuffer((ButtonModelGUI)((Object)hMIModel));
            }
            case 2: {
                return new ChoiceDataBuffer((ChoiceModelGUI)((Object)hMIModel));
            }
            case 3: {
                return new LabelDataBuffer((LabelModelGUI)((Object)hMIModel));
            }
            case 7: {
                return new MatchSpellerDataBuffer((MatchspellerModelGUI)((Object)hMIModel));
            }
            case 5: {
                return new RangeDataBuffer((RangeModelGUI)((Object)hMIModel));
            }
            case 6: {
                return new SpellerDataBuffer((SpellerModelGUI)((Object)hMIModel));
            }
            case 8: {
                return new TextfieldDataBuffer((TextfieldModelGUI)((Object)hMIModel));
            }
        }
        return new DefaultDataBuffer();
    }

    public abstract boolean valueChanged(HMIModel var1);

    private static class LabelDataBuffer
    extends AbstractDataBuffer {
        private String text;

        public LabelDataBuffer(LabelModelGUI labelModelGUI) {
            this.text = labelModelGUI.getText();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            LabelModelGUI labelModelGUI = (LabelModelGUI)((Object)hMIModel);
            boolean bl = !this.text.equals(labelModelGUI.getText());
            this.text = labelModelGUI.getText();
            return bl;
        }
    }

    private static class RangeDataBuffer
    extends AbstractDataBuffer {
        private int value;

        public RangeDataBuffer(RangeModelGUI rangeModelGUI) {
            this.value = rangeModelGUI.getValue();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            RangeModelGUI rangeModelGUI = (RangeModelGUI)((Object)hMIModel);
            boolean bl = this.value != rangeModelGUI.getValue();
            this.value = rangeModelGUI.getValue();
            return bl;
        }
    }

    private static class ButtonDataBuffer
    extends AbstractDataBuffer {
        private boolean pressed;

        public ButtonDataBuffer(ButtonModelGUI buttonModelGUI) {
            this.pressed = buttonModelGUI.getPressed();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            ButtonModelGUI buttonModelGUI = (ButtonModelGUI)((Object)hMIModel);
            boolean bl = this.pressed != buttonModelGUI.getPressed();
            this.pressed = buttonModelGUI.getPressed();
            return bl;
        }
    }

    private static class ChoiceDataBuffer
    extends AbstractDataBuffer {
        private int value;

        public ChoiceDataBuffer(ChoiceModelGUI choiceModelGUI) {
            this.value = choiceModelGUI.getValue();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)((Object)hMIModel);
            boolean bl = this.value != choiceModelGUI.getValue();
            this.value = choiceModelGUI.getValue();
            return bl;
        }
    }

    private static class DefaultDataBuffer
    extends AbstractDataBuffer {
        private DefaultDataBuffer() {
        }

        public boolean valueChanged(HMIModel hMIModel) {
            return true;
        }
    }

    private static class SpellerDataBuffer
    extends AbstractDataBuffer {
        private String text;

        public SpellerDataBuffer(SpellerModelGUI spellerModelGUI) {
            this.text = spellerModelGUI.getText();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            SpellerModelGUI spellerModelGUI = (SpellerModelGUI)((Object)hMIModel);
            boolean bl = !this.text.equals(spellerModelGUI.getText());
            this.text = spellerModelGUI.getText();
            return bl;
        }
    }

    private static class TextfieldDataBuffer
    extends AbstractDataBuffer {
        private String text1;
        private String text2;

        public TextfieldDataBuffer(TextfieldModelGUI textfieldModelGUI) {
            this.text1 = textfieldModelGUI.getText1();
            this.text2 = textfieldModelGUI.getText2();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            TextfieldModelGUI textfieldModelGUI = (TextfieldModelGUI)((Object)hMIModel);
            boolean bl = !this.text1.equals(textfieldModelGUI.getText1()) || !this.text2.equals(textfieldModelGUI.getText2());
            this.text1 = textfieldModelGUI.getText1();
            this.text2 = textfieldModelGUI.getText2();
            return bl;
        }
    }

    private static class MatchSpellerDataBuffer
    extends AbstractDataBuffer {
        private String text;

        public MatchSpellerDataBuffer(MatchspellerModelGUI matchspellerModelGUI) {
            this.text = matchspellerModelGUI.getText();
        }

        public boolean valueChanged(HMIModel hMIModel) {
            MatchspellerModelGUI matchspellerModelGUI = (MatchspellerModelGUI)((Object)hMIModel);
            boolean bl = !this.text.equals(matchspellerModelGUI.getText());
            this.text = matchspellerModelGUI.getText();
            return bl;
        }
    }
}

