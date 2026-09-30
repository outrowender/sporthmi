/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationParameters;
import de.esolutions.hmi.widgets.audi.evo.IAnimationTypesEvo;
import de.esolutions.hmi.widgets.audi.evo.high.IAnimationParametersMIB2;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class AnimationParametersMIB2Std
extends AbstractAnimationParameters
implements IAnimationTypesEvo,
IAnimationParametersMIB2 {
    public static final String DEFAULT_ANIMTATION_CONFIG_FILE = "/fs/sda0/AnimationConfigEvoStd";
    private static final String CONFIG_FILE = System.getProperty("AnimationConfigFile", "/fs/sda0/AnimationConfigEvoStd");
    public static final int MINIMUM_DELAY = 20;
    public static final int MINIMUM_TIMER_INTERVALL = 1;
    protected float[][] animationParameters;
    protected Map fixedAnimationValuesFadeIn;
    protected Map fixedAnimationValuesFadeOut;
    protected Map nestedParameters = new HashMap(109);
    protected Map fastParameters = new HashMap(109);
    private static AnimationParametersMIB2Std singleton;

    public static synchronized AnimationParametersMIB2Std getAnimationParametersMIB2Std() {
        if (singleton == null) {
            singleton = new AnimationParametersMIB2Std();
        }
        return singleton;
    }

    private AnimationParametersMIB2Std() {
        super(IWidgetLogChannel.logAnimation);
        this.initializeFixedAnimationValues();
        this.initializeAnimationParameters();
    }

    protected void initializeFixedAnimationValues() {
        this.initializeFixedAnimationValuesFadeIn();
        this.initializeFixedAnimationValuesFadeOut();
    }

    private void initializeFixedAnimationValuesFadeOut() {
        this.fixedAnimationValuesFadeOut = new HashMap(109);
        float[] fArray = new float[]{0.25f, 0.5f, 0.75f, 1.0f};
        this.fixedAnimationValuesFadeOut.put(new Integer(22), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(26), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(25), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(24), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(27), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(28), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(88), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(55), fArray);
        this.fixedAnimationValuesFadeOut.put(new Integer(54), fArray);
        float[] fArray2 = new float[]{0.05f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 0.95f, 1.0f};
        this.fixedAnimationValuesFadeOut.put(new Integer(57), fArray2);
        float[] fArray3 = new float[]{0.1f, 0.3f, 0.6f, 0.8f, 1.0f};
        this.fixedAnimationValuesFadeOut.put(new Integer(53), fArray3);
        this.fixedAnimationValuesFadeOut.put(new Integer(52), fArray3);
    }

    private void initializeFixedAnimationValuesFadeIn() {
        this.fixedAnimationValuesFadeIn = new HashMap(109);
        float[] fArray = new float[]{0.25f, 0.5f, 0.75f, 1.0f};
        this.fixedAnimationValuesFadeIn.put(new Integer(25), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(24), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(27), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(28), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(55), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(54), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(26), fArray);
        this.fixedAnimationValuesFadeIn.put(new Integer(22), fArray);
        float[] fArray2 = new float[]{0.15f, 0.3f, 0.45f, 0.6f, 0.8f, 0.95f, 1.0f};
        this.fixedAnimationValuesFadeIn.put(new Integer(88), fArray2);
        float[] fArray3 = new float[]{0.0f, 0.0f, 0.0f, 0.05f, 0.07f, 0.1f, 0.15f, 0.2f, 0.25f, 0.3f, 0.35f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 0.95f, 1.0f};
        this.fixedAnimationValuesFadeIn.put(new Integer(57), fArray3);
        float[] fArray4 = new float[]{0.1f, 0.3f, 0.6f, 0.9f, 1.0f};
        this.fixedAnimationValuesFadeIn.put(new Integer(53), fArray4);
        this.fixedAnimationValuesFadeIn.put(new Integer(52), fArray4);
    }

    protected void initializeAnimationParameters() {
        int n = 0;
        int n2 = 1;
        int n3 = 2;
        int n4 = 3;
        int n5 = 4;
        int n6 = 5;
        this.animationParameters = new float[109][6];
        this.animationParameters[24][0] = 1.8f;
        this.animationParameters[24][n2] = 0.1f;
        this.animationParameters[24][n3] = 2.2f;
        this.animationParameters[24][n4] = 50.0f;
        this.animationParameters[24][n5] = 300.0f;
        this.animationParameters[24][n6] = 1.0f;
        this.animationParameters[25][n] = 1.5f;
        this.animationParameters[25][n2] = 0.1f;
        this.animationParameters[25][n3] = 1.7f;
        this.animationParameters[25][n4] = 50.0f;
        this.animationParameters[25][n5] = 300.0f;
        this.animationParameters[25][n6] = 1.0f;
        this.animationParameters[51][n] = 3.0f;
        this.animationParameters[51][n2] = 30.0f;
        this.animationParameters[51][n3] = 5.0f;
        this.animationParameters[51][n4] = 300.0f;
        this.animationParameters[51][n5] = 400.0f;
        this.animationParameters[51][n6] = 1.0f;
        this.animationParameters[57][n] = 3.0f;
        this.animationParameters[57][n2] = 30.0f;
        this.animationParameters[57][n3] = 5.0f;
        this.animationParameters[57][n4] = 500.0f;
        this.animationParameters[57][n5] = 600.0f;
        this.animationParameters[57][n6] = 1.0f;
        this.animationParameters[56][n] = 3.0f;
        this.animationParameters[56][n2] = 100.0f;
        this.animationParameters[56][n3] = 5.0f;
        this.animationParameters[56][n4] = 400.0f;
        this.animationParameters[56][n5] = 500.0f;
        this.animationParameters[56][n6] = 1.0f;
        this.animationParameters[61][n] = 3.0f;
        this.animationParameters[61][n2] = 100.0f;
        this.animationParameters[61][n3] = 5.0f;
        this.animationParameters[61][n4] = 400.0f;
        this.animationParameters[61][n5] = 500.0f;
        this.animationParameters[61][n6] = 1.0f;
        this.animationParameters[62][n] = 3.0f;
        this.animationParameters[62][n2] = 100.0f;
        this.animationParameters[62][n3] = 5.0f;
        this.animationParameters[62][n4] = 400.0f;
        this.animationParameters[62][n5] = 500.0f;
        this.animationParameters[62][n6] = 1.0f;
        this.animationParameters[22][n] = 3.0f;
        this.animationParameters[22][n2] = 0.2f;
        this.animationParameters[22][n3] = 3.0f;
        this.animationParameters[22][n4] = 50.0f;
        this.animationParameters[22][n5] = 250.0f;
        this.animationParameters[22][n6] = 1.0f;
        this.animationParameters[26][n] = 3.0f;
        this.animationParameters[26][n2] = 0.2f;
        this.animationParameters[26][n3] = 3.0f;
        this.animationParameters[26][n4] = 50.0f;
        this.animationParameters[26][n5] = 250.0f;
        this.animationParameters[26][n6] = 1.0f;
        this.animationParameters[28][n] = 3.0f;
        this.animationParameters[28][n2] = 0.2f;
        this.animationParameters[28][n3] = 3.0f;
        this.animationParameters[28][n4] = 50.0f;
        this.animationParameters[28][n5] = 250.0f;
        this.animationParameters[28][n6] = 1.0f;
        this.animationParameters[27][n] = 3.0f;
        this.animationParameters[27][n2] = 0.2f;
        this.animationParameters[27][n3] = 3.0f;
        this.animationParameters[27][n4] = 50.0f;
        this.animationParameters[27][n5] = 300.0f;
        this.animationParameters[27][n6] = 1.0f;
        this.animationParameters[23][n] = 2.0f;
        this.animationParameters[23][n2] = 5.0f;
        this.animationParameters[23][n3] = 2.0f;
        this.animationParameters[23][n4] = 50.0f;
        this.animationParameters[23][n5] = 150.0f;
        this.animationParameters[23][n6] = 1.0f;
        this.animationParameters[72][n] = 2.0f;
        this.animationParameters[72][n2] = 0.03f;
        this.animationParameters[72][n3] = 3.0f;
        this.animationParameters[72][n4] = 250.0f;
        this.animationParameters[72][n5] = 350.0f;
        this.animationParameters[72][n6] = 1.0f;
        this.animationParameters[71][n] = 3.0f;
        this.animationParameters[71][n2] = 5.0f;
        this.animationParameters[71][n3] = 10.0f;
        this.animationParameters[71][n4] = 400.0f;
        this.animationParameters[71][n5] = 500.0f;
        this.animationParameters[71][n6] = 1.0f;
        this.animationParameters[98][n] = 3.0f;
        this.animationParameters[98][n2] = 50.0f;
        this.animationParameters[98][n3] = 5.0f;
        this.animationParameters[98][n4] = 250.0f;
        this.animationParameters[98][n5] = 350.0f;
        this.animationParameters[98][n6] = 1.0f;
        this.animationParameters[73][n] = 3.0f;
        this.animationParameters[73][n2] = 5.0f;
        this.animationParameters[73][n3] = 10.0f;
        this.animationParameters[73][n4] = 250.0f;
        this.animationParameters[73][n5] = 350.0f;
        this.animationParameters[73][n6] = 1.0f;
        this.animationParameters[89][n] = 3.0f;
        this.animationParameters[89][n2] = 5.0f;
        this.animationParameters[89][n3] = 10.0f;
        this.animationParameters[89][n4] = 350.0f;
        this.animationParameters[89][n5] = 400.0f;
        this.animationParameters[89][n6] = 1.0f;
        this.animationParameters[52][n] = 3.0f;
        this.animationParameters[52][n2] = 0.1f;
        this.animationParameters[52][n3] = 5.0f;
        this.animationParameters[52][n4] = 250.0f;
        this.animationParameters[52][n5] = 400.0f;
        this.animationParameters[52][n6] = 1.0f;
        this.animationParameters[53][n] = 3.0f;
        this.animationParameters[53][n2] = 0.1f;
        this.animationParameters[53][n3] = 5.0f;
        this.animationParameters[53][n4] = 250.0f;
        this.animationParameters[53][n5] = 300.0f;
        this.animationParameters[53][n6] = 1.0f;
        this.animationParameters[80][n] = 1.0f;
        this.animationParameters[80][n2] = 50.0f;
        this.animationParameters[80][n3] = 10.0f;
        this.animationParameters[80][n4] = 700.0f;
        this.animationParameters[80][n5] = 800.0f;
        this.animationParameters[80][n6] = 1.0f;
        this.animationParameters[81][n] = 3.0f;
        this.animationParameters[81][n2] = 5.0f;
        this.animationParameters[81][n3] = 10.0f;
        this.animationParameters[81][n4] = 400.0f;
        this.animationParameters[81][n5] = 500.0f;
        this.animationParameters[81][n6] = 1.0f;
        this.animationParameters[97][n] = 5.0f;
        this.animationParameters[97][n2] = 4.0f;
        this.animationParameters[97][n3] = 20.0f;
        this.animationParameters[97][n4] = 600.0f;
        this.animationParameters[97][n5] = 700.0f;
        this.animationParameters[97][n6] = 1.0f;
        this.animationParameters[100][n] = 3.0f;
        this.animationParameters[100][n2] = 5.0f;
        this.animationParameters[100][n3] = 5.0f;
        this.animationParameters[100][n4] = 250.0f;
        this.animationParameters[100][n5] = 350.0f;
        this.animationParameters[100][n6] = 1.0f;
        this.animationParameters[101][n] = 3.0f;
        this.animationParameters[101][n2] = 5.0f;
        this.animationParameters[101][n3] = 5.0f;
        this.animationParameters[101][n4] = 500.0f;
        this.animationParameters[101][n5] = 700.0f;
        this.animationParameters[101][n6] = 1.0f;
        this.animationParameters[83][n] = 1.0f;
        this.animationParameters[83][n2] = 10.0f;
        this.animationParameters[83][n3] = 10.0f;
        this.animationParameters[83][n4] = 100.0f;
        this.animationParameters[83][n5] = 200.0f;
        this.animationParameters[83][n6] = 1.0f;
        this.animationParameters[82][n] = 3.0f;
        this.animationParameters[82][n2] = 5.0f;
        this.animationParameters[82][n3] = 10.0f;
        this.animationParameters[82][n4] = 400.0f;
        this.animationParameters[82][n5] = 500.0f;
        this.animationParameters[82][n6] = 1.0f;
        this.animationParameters[90][n] = 2.0f;
        this.animationParameters[90][n2] = 10.0f;
        this.animationParameters[90][n3] = 10.0f;
        this.animationParameters[90][n4] = 1000.0f;
        this.animationParameters[90][n5] = 1100.0f;
        this.animationParameters[90][n6] = 1.0f;
        this.animationParameters[91][n] = 2.0f;
        this.animationParameters[91][n2] = 10.0f;
        this.animationParameters[91][n3] = 10.0f;
        this.animationParameters[91][n4] = 4000.0f;
        this.animationParameters[91][n5] = 4000.0f;
        this.animationParameters[91][n6] = 1.0f;
        this.animationParameters[92][n] = 2.0f;
        this.animationParameters[92][n2] = 10.0f;
        this.animationParameters[92][n3] = 10.0f;
        this.animationParameters[92][n4] = 200.0f;
        this.animationParameters[92][n5] = 300.0f;
        this.animationParameters[92][n6] = 1.0f;
        this.animationParameters[93][n] = 2.0f;
        this.animationParameters[93][n2] = 10.0f;
        this.animationParameters[93][n3] = 10.0f;
        this.animationParameters[93][n4] = 50.0f;
        this.animationParameters[93][n5] = 150.0f;
        this.animationParameters[93][n6] = 1.0f;
        this.animationParameters[94][n] = 2.0f;
        this.animationParameters[94][n2] = 10.0f;
        this.animationParameters[94][n3] = 10.0f;
        this.animationParameters[94][n4] = 150.0f;
        this.animationParameters[94][n5] = 250.0f;
        this.animationParameters[94][n6] = 1.0f;
        this.animationParameters[95][n] = 2.0f;
        this.animationParameters[95][n2] = 10.0f;
        this.animationParameters[95][n3] = 10.0f;
        this.animationParameters[95][n4] = 400.0f;
        this.animationParameters[95][n5] = 500.0f;
        this.animationParameters[95][n6] = 1.0f;
        this.animationParameters[54][n] = 3.0f;
        this.animationParameters[54][n2] = 0.1f;
        this.animationParameters[54][n3] = 10.0f;
        this.animationParameters[54][n4] = 200.0f;
        this.animationParameters[54][n5] = 300.0f;
        this.animationParameters[54][n6] = 1.0f;
        this.animationParameters[55][n] = 3.0f;
        this.animationParameters[55][n2] = 0.1f;
        this.animationParameters[55][n3] = 10.0f;
        this.animationParameters[55][n4] = 200.0f;
        this.animationParameters[55][n5] = 300.0f;
        this.animationParameters[55][n6] = 1.0f;
        this.animationParameters[59][n] = 3.0f;
        this.animationParameters[59][n2] = 5.0f;
        this.animationParameters[59][n3] = 5.0f;
        this.animationParameters[59][n4] = 200.0f;
        this.animationParameters[59][n5] = 300.0f;
        this.animationParameters[59][n6] = 1.0f;
        this.animationParameters[58][n] = 3.0f;
        this.animationParameters[58][n2] = 0.1f;
        this.animationParameters[58][n3] = 5.0f;
        this.animationParameters[58][n4] = 200.0f;
        this.animationParameters[58][n5] = 300.0f;
        this.animationParameters[58][n6] = 1.0f;
        this.animationParameters[74][n] = 3.0f;
        this.animationParameters[74][n2] = 5.0f;
        this.animationParameters[74][n3] = 10.0f;
        this.animationParameters[74][n4] = 400.0f;
        this.animationParameters[74][n5] = 500.0f;
        this.animationParameters[74][n6] = 1.0f;
        this.animationParameters[75][n] = 3.0f;
        this.animationParameters[75][n2] = 5.0f;
        this.animationParameters[75][n3] = 10.0f;
        this.animationParameters[75][n4] = 400.0f;
        this.animationParameters[75][n5] = 500.0f;
        this.animationParameters[75][n6] = 1.0f;
        this.animationParameters[76][n] = 3.0f;
        this.animationParameters[76][n2] = 5.0f;
        this.animationParameters[76][n3] = 10.0f;
        this.animationParameters[76][n4] = 400.0f;
        this.animationParameters[76][n5] = 500.0f;
        this.animationParameters[76][n6] = 1.0f;
        this.animationParameters[77][n] = 3.0f;
        this.animationParameters[77][n2] = 5.0f;
        this.animationParameters[77][n3] = 10.0f;
        this.animationParameters[77][n4] = 400.0f;
        this.animationParameters[77][n5] = 500.0f;
        this.animationParameters[77][n6] = 1.0f;
        this.animationParameters[103][n] = 0.1f;
        this.animationParameters[103][n2] = 5.0f;
        this.animationParameters[103][n3] = 10.0f;
        this.animationParameters[103][n4] = 850.0f;
        this.animationParameters[103][n5] = 900.0f;
        this.animationParameters[103][n6] = 0.0f;
        this.animationParameters[78][n] = 1.0f;
        this.animationParameters[78][n2] = 3.0f;
        this.animationParameters[78][n3] = 20.0f;
        this.animationParameters[78][n4] = 200.0f;
        this.animationParameters[78][n5] = 300.0f;
        this.animationParameters[78][n6] = 1.0f;
        this.animationParameters[79][n] = 3.0f;
        this.animationParameters[79][n2] = 1.0f;
        this.animationParameters[79][n3] = 5.0f;
        this.animationParameters[79][n4] = 200.0f;
        this.animationParameters[79][n5] = 300.0f;
        this.animationParameters[79][n6] = 1.0f;
        this.animationParameters[106][n] = 3.0f;
        this.animationParameters[106][n2] = 1.0f;
        this.animationParameters[106][n3] = 5.0f;
        this.animationParameters[106][n4] = 200.0f;
        this.animationParameters[106][n5] = 300.0f;
        this.animationParameters[106][n6] = 1.0f;
        this.animationParameters[84][n] = 3.0f;
        this.animationParameters[84][n2] = 5.0f;
        this.animationParameters[84][n3] = 10.0f;
        this.animationParameters[84][n4] = 400.0f;
        this.animationParameters[84][n5] = 500.0f;
        this.animationParameters[84][n6] = 1.0f;
        this.animationParameters[85][n] = 3.0f;
        this.animationParameters[85][n2] = 5.0f;
        this.animationParameters[85][n3] = 10.0f;
        this.animationParameters[85][n4] = 400.0f;
        this.animationParameters[85][n5] = 500.0f;
        this.animationParameters[85][n6] = 1.0f;
        this.animationParameters[86][n] = 3.0f;
        this.animationParameters[86][n2] = 5.0f;
        this.animationParameters[86][n3] = 10.0f;
        this.animationParameters[86][n4] = 400.0f;
        this.animationParameters[86][n5] = 500.0f;
        this.animationParameters[86][n6] = 1.0f;
        this.animationParameters[87][n] = 3.0f;
        this.animationParameters[87][n2] = 5.0f;
        this.animationParameters[87][n3] = 10.0f;
        this.animationParameters[87][n4] = 400.0f;
        this.animationParameters[87][n5] = 500.0f;
        this.animationParameters[87][n6] = 1.0f;
        this.animationParameters[88][n] = 3.0f;
        this.animationParameters[88][n2] = 0.5f;
        this.animationParameters[88][n3] = 10.0f;
        this.animationParameters[88][n4] = 300.0f;
        this.animationParameters[88][n5] = 400.0f;
        this.animationParameters[88][n6] = 1.0f;
        this.animationParameters[96][n] = 3.0f;
        this.animationParameters[96][n2] = 5.0f;
        this.animationParameters[96][n3] = 10.0f;
        this.animationParameters[96][n4] = 400.0f;
        this.animationParameters[96][n5] = 500.0f;
        this.animationParameters[96][n6] = 1.0f;
        this.animationParameters[99][n] = 3.0f;
        this.animationParameters[99][n2] = 50.0f;
        this.animationParameters[99][n3] = 40.0f;
        this.animationParameters[99][n4] = 2000.0f;
        this.animationParameters[99][n5] = 2500.0f;
        this.animationParameters[99][n6] = 1.0f;
        this.animationParameters[102][n] = 3.0f;
        this.animationParameters[102][n2] = 125.0f;
        this.animationParameters[102][n3] = 100.0f;
        this.animationParameters[102][n4] = 14000.0f;
        this.animationParameters[102][n5] = 16000.0f;
        this.animationParameters[102][n6] = 1.0f;
        this.animationParameters[104][n] = 3.0f;
        this.animationParameters[104][n2] = 100.0f;
        this.animationParameters[104][n3] = 20.0f;
        this.animationParameters[104][n4] = 1000.0f;
        this.animationParameters[104][n5] = 1200.0f;
        this.animationParameters[104][n6] = 1.0f;
        this.animationParameters[31][n] = 1.0f;
        this.animationParameters[31][n2] = 10.0f;
        this.animationParameters[31][n3] = 10.0f;
        this.animationParameters[31][n4] = 300.0f;
        this.animationParameters[31][n5] = 400.0f;
        this.animationParameters[31][n6] = 1.0f;
        this.animationParameters[105][n] = 3.0f;
        this.animationParameters[105][n2] = 5.0f;
        this.animationParameters[105][n3] = 10.0f;
        this.animationParameters[105][n4] = 400.0f;
        this.animationParameters[105][n5] = 500.0f;
        this.animationParameters[105][n6] = 1.0f;
        AnimationParametersMIB2Std.initializeNestedParameters();
        AnimationParametersMIB2Std.initializeFastParameters();
    }

    private static void initializeNestedParameters() {
    }

    private static void initializeFastParameters() {
    }

    public void setAnimationParameters(int n, float[] fArray, float[] fArray2, float[] fArray3) {
        if (n < 0 || n >= 109) {
            this.logAnimation.log(10000000, "AnimationMIBStandard#setAnimationParameters wrong animationType, %1", (long)n);
        } else {
            if (fArray == null || fArray.length != 6) {
                this.logAnimation.log(10000000, "AnimationMIBStandard#setAnimationParameters incorrect parameters");
            } else {
                this.animationParameters[n] = fArray;
            }
            if (fArray2 != null) {
                this.fixedAnimationValuesFadeIn.put(new Integer(n), fArray2);
            }
            if (fArray3 != null) {
                this.fixedAnimationValuesFadeOut.put(new Integer(n), fArray3);
            }
        }
    }

    public float[] getAnimationParameters(int n, int n2, boolean bl) {
        float[] fArray = null;
        if (bl) {
            if (this.fastParameters != null) {
                fArray = (float[])this.fastParameters.get(new Integer(n));
            }
            if (fArray == null) {
                this.logAnimation.log(10000000, "AnimationMIBStandard#getAnimationParameters for type: %1 are no fast values defined", (long)n);
                fArray = this.animationParameters[n];
            }
        } else if (n2 != -1) {
            float[][] fArray2;
            if (this.nestedParameters != null && (fArray2 = (float[][])this.nestedParameters.get(new Integer(n))) != null && n2 < fArray2.length) {
                fArray = fArray2[n2];
            }
            if (fArray == null) {
                this.logAnimation.log(10000000, "AnimationMIBStandard#getAnimationParameters for type: %1 are no subvalues for nestedIndex %2 defined.", (long)n, (long)n2);
                fArray = this.animationParameters[n];
            }
        } else {
            fArray = this.animationParameters[n];
        }
        return fArray;
    }

    public float[] getFixedAnimationValues(int n, int n2, boolean bl, boolean bl2) {
        if (bl) {
            return null;
        }
        if (n2 != -1) {
            return null;
        }
        Integer n3 = new Integer(n);
        if (bl2) {
            if (this.fixedAnimationValuesFadeIn != null && this.fixedAnimationValuesFadeIn.get(n3) != null) {
                return (float[])this.fixedAnimationValuesFadeIn.get(n3);
            }
        } else if (this.fixedAnimationValuesFadeOut != null && this.fixedAnimationValuesFadeOut.get(n3) != null) {
            return (float[])this.fixedAnimationValuesFadeOut.get(n3);
        }
        return null;
    }

    protected String getConfigFileName() {
        return CONFIG_FILE;
    }

    protected void readAnimationParameters(String string) {
        String string2 = ":";
        int n = -1;
        float[] fArray = null;
        float[] fArray2 = null;
        float[] fArray3 = null;
        try {
            String string3;
            StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
            if (stringTokenizer.hasMoreTokens() && this.logAnimation.isDebug()) {
                this.logAnimation.log(10000000, "AnimationParametersMIB2Std#readAnimationParametersFromFile reading parameters for animation: %1", (Object)stringTokenizer.nextToken());
            }
            if (stringTokenizer.hasMoreTokens()) {
                String string4 = stringTokenizer.nextToken();
                try {
                    n = Integer.parseInt(string4);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (stringTokenizer.hasMoreTokens()) {
                String string5 = stringTokenizer.nextToken();
                fArray = this.extractParameters(string5);
            }
            if (stringTokenizer.hasMoreTokens()) {
                string3 = stringTokenizer.nextToken();
                fArray2 = this.extractParameters(string3);
            }
            if (stringTokenizer.hasMoreTokens()) {
                string3 = stringTokenizer.nextToken();
                fArray3 = this.extractParameters(string3);
            }
            this.setAnimationParameters(n, fArray, fArray2, fArray3);
            this.logAnimation.log(10000000, "AnimationParametersMIB2Std#readAnimationParametersFromFile animationParameters read successfully!");
        }
        catch (Exception exception) {
            this.logAnimation.log(10000, "AnimationParametersMIB2Std#readAnimationParametersFromFile couldn't read parameters");
        }
    }

    private float[] extractParameters(String string) {
        try {
            String string2 = ",";
            StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
            int n = stringTokenizer.countTokens();
            if (n > 0) {
                float[] fArray = new float[stringTokenizer.countTokens()];
                for (int i2 = 0; i2 < n; ++i2) {
                    fArray[i2] = Float.parseFloat(stringTokenizer.nextToken());
                }
                return fArray;
            }
            return null;
        }
        catch (Exception exception) {
            this.logAnimation.log(10000, "AnimationParamtersEvoHigh#extractParameters couldn't read parameters: %1", (Object)string);
            return null;
        }
    }
}

