.version 50 0 
.class public super [151] 
.super [153] 
.field private static final [154] [155] 
.field private static final [156] [157] 
.field private static final [158] [159] 
.field private static final [160] [161] 
.field private static final [162] [163] 
.field private static final [164] [165] 
.field private static final [166] [167] 
.field private static final [168] [169] 
.field private static final [170] [171] 
.field private static final [172] [173] 
.field private static final [174] [175] 
.field private final [176] [177] 
.field private volatile [178] [179] 
.field private volatile [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield [38] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [39] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [40] 
L19:    aload_1 
L20:    ldc [2] 
L22:    invokevirtual [28] 
L25:    iconst_0 
L26:    invokeinterface [41] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [182] .code stack 6 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [38] 
L5:     iload_1 
L6:     tableswitch 1 
            L112 
            L123 
            L134 
            L145 
            L203 
            L227 
            L227 
            L227 
            L227 
            L227 
            L227 
            L227 
            L227 
            L227 
            L227 
            L227 
            L156 
            L134 
            L191 
            L227 
            L167 
            L215 
            L179 
            default : L227 

L112:   iconst_1 
L113:   istore_2 
L114:   aload_0 
L115:   ldc [3] 
L117:   putfield [39] 
L120:   goto L253 
L123:   iconst_2 
L124:   istore_2 
L125:   aload_0 
L126:   ldc [4] 
L128:   putfield [39] 
L131:   goto L253 
L134:   iconst_3 
L135:   istore_2 
L136:   aload_0 
L137:   ldc [5] 
L139:   putfield [39] 
L142:   goto L253 
L145:   iconst_5 
L146:   istore_2 
L147:   aload_0 
L148:   ldc [6] 
L150:   putfield [39] 
L153:   goto L253 
L156:   iconst_4 
L157:   istore_2 
L158:   aload_0 
L159:   ldc [7] 
L161:   putfield [39] 
L164:   goto L253 
L167:   bipush 6 
L169:   istore_2 
L170:   aload_0 
L171:   ldc [8] 
L173:   putfield [39] 
L176:   goto L253 
L179:   bipush 7 
L181:   istore_2 
L182:   aload_0 
L183:   ldc [9] 
L185:   putfield [39] 
L188:   goto L253 
L191:   bipush 8 
L193:   istore_2 
L194:   aload_0 
L195:   ldc [10] 
L197:   putfield [39] 
L200:   goto L253 
L203:   bipush 9 
L205:   istore_2 
L206:   aload_0 
L207:   ldc [11] 
L209:   putfield [39] 
L212:   goto L253 
L215:   bipush 10 
L217:   istore_2 
L218:   aload_0 
L219:   ldc [12] 
L221:   putfield [39] 
L224:   goto L253 
L227:   aload_0 
L228:   getfield [27] 
L231:   getfield [29] 
L234:   sipush 1000 
L237:   ldc [13] 
L239:   iload_1 
L240:   i2l 
L241:   invokevirtual [30] 
L244:   pop 
L245:   iconst_0 
L246:   istore_2 
L247:   aload_0 
L248:   ldc [14] 
L250:   putfield [39] 
L253:   aload_0 
L254:   getfield [27] 
L257:   getfield [29] 
L260:   ldc [15] 
L262:   ldc [16] 
L264:   aload_0 
L265:   getfield [26] 
L268:   iload_1 
L269:   i2l 
L270:   invokevirtual [31] 
L273:   pop 
L274:   aload_0 
L275:   getfield [27] 
L278:   ldc [2] 
L280:   invokevirtual [28] 
L283:   iload_2 
L284:   invokeinterface [41] 0 
L289:   return 
L290:   nop 
L291:   nop 
L292:   
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     tableswitch 1 
            L32 
            L32 
            L32 
            default : L34 

L32:    iconst_1 
L33:    areturn 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [182] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     lookupswitch 
            19 : L32 
            23 : L32 
            default : L34 

L32:    iconst_1 
L33:    areturn 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [182] .code stack 2 locals 0 
L0:     new [42] 
L3:     dup 
L4:     invokespecial [37] 
L7:     ldc [18] 
L9:     invokevirtual [32] 
L12:    aload_0 
L13:    getfield [26] 
L16:    invokevirtual [32] 
L19:    ldc [19] 
L21:    invokevirtual [32] 
L24:    aload_0 
L25:    getfield [25] 
L28:    invokevirtual [33] 
L31:    bipush 41 
L33:    invokevirtual [34] 
L36:    invokevirtual [35] 
L39:    areturn 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1665273600 
.const [3] = String [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = String [48] 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = String [52] 
.const [13] = String [53] 
.const [14] = String [54] 
.const [15] = Int 1078071040 
.const [16] = String [55] 
.const [17] = Class [56] 
.const [18] = String [57] 
.const [19] = String [58] 
.const [20] = Class [59] 
.const [21] = Class [60] 
.const [22] = Class [61] 
.const [23] = Class [62] 
.const [24] = Class [63] 
.const [25] = Field [64] [65] 
.const [26] = Field [66] [67] 
.const [27] = Field [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Field [72] [73] 
.const [30] = Method [74] [75] 
.const [31] = Method [76] [77] 
.const [32] = Method [78] [79] 
.const [33] = Method [80] [81] 
.const [34] = Method [82] [83] 
.const [35] = Method [84] [85] 
.const [36] = Method [86] [87] 
.const [37] = Method [88] [89] 
.const [38] = Field [90] [91] 
.const [39] = Field [92] [93] 
.const [40] = Field [94] [95] 
.const [41] = InterfaceMethod [96] [97] 
.const [42] = Class [98] 
.const [43] = Utf8 'Basic Sound (0x120)' 
.const [44] = Utf8 'Basic Plus Sound (0x121)' 
.const [45] = Utf8 'Standard Sound (0x122, 0x161)' 
.const [46] = Utf8 'Premium Sound (B&O, 0x140)' 
.const [47] = Utf8 'Premium Sound (BOSE, 0x160)' 
.const [48] = Utf8 'Advanced Sound' 
.const [49] = Utf8 'Advanced Burmester Porsche' 
.const [50] = Utf8 'Premium BOSE Porsche' 
.const [51] = Utf8 'Premium Alpine Bentley' 
.const [52] = Utf8 'Advanced B&O Bentley' 
.const [53] = Utf8 '[AmplifierVariant.updateAmplifier] Unknown amplifier type %1!' 
.const [54] = Utf8 Default-Screen 
.const [55] = Utf8 '[AmplifierVariant.updateAmplifier] amplifier:%2 -> %1' 
.const [56] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [57] = Utf8 "AmplifierVariant: '" 
.const [58] = Utf8 "' (" 
.const [59] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [60] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [61] = Utf8 de/audi/tone/app/ToneEnv 
.const [62] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Class [99] 
.const [65] = NameAndType [100] [101] 
.const [66] = Class [102] 
.const [67] = NameAndType [103] [104] 
.const [68] = Class [105] 
.const [69] = NameAndType [106] [107] 
.const [70] = Class [108] 
.const [71] = NameAndType [109] [110] 
.const [72] = Class [111] 
.const [73] = NameAndType [112] [113] 
.const [74] = Class [114] 
.const [75] = NameAndType [115] [116] 
.const [76] = Class [117] 
.const [77] = NameAndType [118] [119] 
.const [78] = Class [120] 
.const [79] = NameAndType [121] [122] 
.const [80] = Class [123] 
.const [81] = NameAndType [124] [125] 
.const [82] = Class [126] 
.const [83] = NameAndType [127] [128] 
.const [84] = Class [129] 
.const [85] = NameAndType [130] [131] 
.const [86] = Class [132] 
.const [87] = NameAndType [133] [134] 
.const [88] = Class [135] 
.const [89] = NameAndType [136] [137] 
.const [90] = Class [138] 
.const [91] = NameAndType [139] [140] 
.const [92] = Class [141] 
.const [93] = NameAndType [142] [143] 
.const [94] = Class [144] 
.const [95] = NameAndType [145] [146] 
.const [96] = Class [147] 
.const [97] = NameAndType [148] [149] 
.const [98] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [99] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [100] = Utf8 amplifierTypeDSI 
.const [101] = Utf8 I 
.const [102] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [103] = Utf8 amplifierDescription 
.const [104] = Utf8 Ljava/lang/String; 
.const [105] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [106] = Utf8 env 
.const [107] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [108] = Utf8 de/audi/tone/app/ToneEnv 
.const [109] = Utf8 getChoiceModel 
.const [110] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [111] = Utf8 de/audi/tone/app/ToneEnv 
.const [112] = Utf8 lcHMI 
.const [113] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 log 
.const [116] = Utf8 (ILjava/lang/String;J)Z 
.const [117] = Utf8 de/audi/atip/log/LogChannel 
.const [118] = Utf8 log 
.const [119] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [120] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [121] = Utf8 append 
.const [122] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [123] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [124] = Utf8 append 
.const [125] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [126] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [127] = Utf8 append 
.const [128] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [129] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [130] = Utf8 toString 
.const [131] = Utf8 ()Ljava/lang/String; 
.const [132] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [139] = Utf8 amplifierTypeDSI 
.const [140] = Utf8 I 
.const [141] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [142] = Utf8 amplifierDescription 
.const [143] = Utf8 Ljava/lang/String; 
.const [144] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [145] = Utf8 env 
.const [146] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [147] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [148] = Utf8 setValue 
.const [149] = Utf8 (I)V 
.const [150] = Utf8 de/audi/tone/app/AmplifierVariant 
.const [151] = Class [150] 
.const [152] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [153] = Class [152] 
.const [154] = Utf8 FALLBACK_DEFAULT 
.const [155] = Utf8 I 
.const [156] = Utf8 BASIC_SOUND 
.const [157] = Utf8 I 
.const [158] = Utf8 BASIC_PLUS_SOUND 
.const [159] = Utf8 I 
.const [160] = Utf8 STANDARD_SOUND 
.const [161] = Utf8 I 
.const [162] = Utf8 PREMIUM_SOUND_BOSE 
.const [163] = Utf8 I 
.const [164] = Utf8 PREMIUM_SOUND_BO 
.const [165] = Utf8 I 
.const [166] = Utf8 ADVANCED_SOUND 
.const [167] = Utf8 I 
.const [168] = Utf8 ADVANCED_BURMESTER_PORSCHE 
.const [169] = Utf8 I 
.const [170] = Utf8 PREMIUM_BOSE_PORSCHE 
.const [171] = Utf8 I 
.const [172] = Utf8 PREMIUM_ALPINE_BENTLEY 
.const [173] = Utf8 I 
.const [174] = Utf8 ADVANCED_B_O_BENTLEY 
.const [175] = Utf8 I 
.const [176] = Utf8 env 
.const [177] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [178] = Utf8 amplifierTypeDSI 
.const [179] = Utf8 I 
.const [180] = Utf8 amplifierDescription 
.const [181] = Utf8 Ljava/lang/String; 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/audi/tone/app/ToneEnv;)V 
.const [185] = Utf8 updateAmplifier 
.const [186] = Utf8 (I)V 
.const [187] = Utf8 isStandardOrBasicSound 
.const [188] = Utf8 ()Z 
.const [189] = Utf8 isAmplifierPorscheSurround 
.const [190] = Utf8 ()Z 
.const [191] = Utf8 toString 
.const [192] = Utf8 ()Ljava/lang/String; 
.end class 
