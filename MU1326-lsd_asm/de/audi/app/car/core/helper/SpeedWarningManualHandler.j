.version 50 0 
.class public super [188] 
.super [190] 
.field public final [191] [192] 
.field public final [193] [194] 
.field public final [195] [196] 
.field public final [197] [198] 
.field public final [199] [200] 
.field public final [201] [202] 
.field private volatile [203] [204] 
.field private volatile [205] [206] 
.field private volatile [207] [208] 
.field private [209] [210] 
.field private final [211] [212] 

.method public [214] : [215] 
    .attribute [213] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [28] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [29] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [30] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [31] 
L25:    aload_0 
L26:    iload 5 
L28:    putfield [32] 
L31:    aload_0 
L32:    iload 6 
L34:    putfield [33] 
L37:    aload_0 
L38:    aload 7 
L40:    putfield [34] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [216] : [217] 
    .attribute [213] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [19] 
L7:     ifeq L30 
L10:    aload_0 
L11:    getfield [18] 
L14:    ldc [2] 
L16:    ldc [3] 
L18:    iload_1 
L19:    invokestatic [4] 
L22:    iload_2 
L23:    i2l 
L24:    iload_3 
L25:    i2l 
L26:    invokevirtual [20] 
L29:    pop 
L30:    iload_3 
L31:    aload_0 
L32:    getfield [21] 
L35:    if_icmpeq L48 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [36] 
L43:    aload_0 
L44:    iload_3 
L45:    putfield [35] 
L48:    aload_0 
L49:    iload_2 
L50:    iload_3 
L51:    invokespecial [27] 
L54:    istore_2 
L55:    iload_3 
L56:    ifne L83 
L59:    iload_2 
L60:    aload_0 
L61:    getfield [13] 
L64:    if_icmple L83 
L67:    aload_0 
L68:    aload_0 
L69:    getfield [13] 
L72:    putfield [37] 
L75:    aload_0 
L76:    iconst_1 
L77:    putfield [38] 
L80:    goto L179 
L83:    iload_3 
L84:    ifne L111 
L87:    iload_2 
L88:    aload_0 
L89:    getfield [12] 
L92:    if_icmpgt L111 
L95:    aload_0 
L96:    aload_0 
L97:    getfield [12] 
L100:   putfield [37] 
L103:   aload_0 
L104:   iconst_0 
L105:   putfield [38] 
L108:   goto L179 
L111:   iload_3 
L112:   iconst_1 
L113:   if_icmpne L140 
L116:   iload_2 
L117:   aload_0 
L118:   getfield [16] 
L121:   if_icmple L140 
L124:   aload_0 
L125:   aload_0 
L126:   getfield [16] 
L129:   putfield [37] 
L132:   aload_0 
L133:   iconst_1 
L134:   putfield [38] 
L137:   goto L179 
L140:   iload_3 
L141:   iconst_1 
L142:   if_icmpne L169 
L145:   iload_2 
L146:   aload_0 
L147:   getfield [15] 
L150:   if_icmpgt L169 
L153:   aload_0 
L154:   aload_0 
L155:   getfield [15] 
L158:   putfield [37] 
L161:   aload_0 
L162:   iconst_0 
L163:   putfield [38] 
L166:   goto L179 
L169:   aload_0 
L170:   iload_2 
L171:   putfield [37] 
L174:   aload_0 
L175:   iconst_1 
L176:   putfield [38] 
L179:   aload_0 
L180:   getfield [18] 
L183:   invokevirtual [19] 
L186:   ifeq L218 
L189:   aload_0 
L190:   getfield [18] 
L193:   ldc [2] 
L195:   ldc [5] 
L197:   aload_0 
L198:   getfield [24] 
L201:   invokestatic [4] 
L204:   aload_0 
L205:   getfield [23] 
L208:   i2l 
L209:   aload_0 
L210:   getfield [21] 
L213:   i2l 
L214:   invokevirtual [20] 
L217:   pop 
L218:   return 
L219:   nop 
L220:   
    .end code 
.end method 

.method public [218] : [219] 
    .attribute [213] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifeq L14 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [36] 
L12:    iconst_1 
L13:    areturn 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public interface [220] : [221] 
    .attribute [213] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [222] : [223] 
    .attribute [213] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [224] : [225] 
    .attribute [213] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [213] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lookupswitch 
            0 : L37 
            1 : L32 
            default : L37 

L32:    aload_0 
L33:    getfield [15] 
L36:    areturn 
L37:    aload_0 
L38:    getfield [12] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [228] : [229] 
    .attribute [213] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lookupswitch 
            0 : L37 
            1 : L32 
            default : L37 

L32:    aload_0 
L33:    getfield [16] 
L36:    areturn 
L37:    aload_0 
L38:    getfield [13] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [230] : [231] 
    .attribute [213] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     lookupswitch 
            0 : L37 
            1 : L32 
            default : L37 

L32:    aload_0 
L33:    getfield [17] 
L36:    areturn 
L37:    aload_0 
L38:    getfield [14] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [232] : [233] 
    .attribute [213] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [6] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [25] 
L13:    pop 
L14:    iload_1 
L15:    istore_3 
L16:    iload_2 
L17:    iconst_1 
L18:    if_icmpne L61 
L21:    iload_1 
L22:    aload_0 
L23:    getfield [17] 
L26:    irem 
L27:    istore 4 
L29:    iload 4 
L31:    ifeq L58 
L34:    iload 4 
L36:    iconst_2 
L37:    if_icmpgt L48 
L40:    iload_1 
L41:    iload 4 
L43:    isub 
L44:    istore_3 
L45:    goto L58 
L48:    iload_1 
L49:    aload_0 
L50:    getfield [17] 
L53:    iload 4 
L55:    isub 
L56:    iadd 
L57:    istore_3 
L58:    goto L102 
L61:    iload_2 
L62:    ifne L102 
L65:    iload_1 
L66:    aload_0 
L67:    getfield [14] 
L70:    irem 
L71:    istore 4 
L73:    iload 4 
L75:    ifeq L102 
L78:    iload 4 
L80:    iconst_4 
L81:    if_icmpgt L92 
L84:    iload_1 
L85:    iload 4 
L87:    isub 
L88:    istore_3 
L89:    goto L102 
L92:    iload_1 
L93:    aload_0 
L94:    getfield [14] 
L97:    iload 4 
L99:    isub 
L100:   iadd 
L101:   istore_3 
L102:   aload_0 
L103:   getfield [18] 
L106:   ldc [2] 
L108:   ldc [7] 
L110:   iload_3 
L111:   i2l 
L112:   invokevirtual [25] 
L115:   pop 
L116:   iload_3 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [39] 
.const [4] = Method [40] [41] 
.const [5] = String [42] 
.const [6] = String [43] 
.const [7] = String [44] 
.const [8] = Class [45] 
.const [9] = Class [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Field [49] [50] 
.const [13] = Field [51] [52] 
.const [14] = Field [53] [54] 
.const [15] = Field [55] [56] 
.const [16] = Field [57] [58] 
.const [17] = Field [59] [60] 
.const [18] = Field [61] [62] 
.const [19] = Method [63] [64] 
.const [20] = Method [65] [66] 
.const [21] = Field [67] [68] 
.const [22] = Field [69] [70] 
.const [23] = Field [71] [72] 
.const [24] = Field [73] [74] 
.const [25] = Method [75] [76] 
.const [26] = Method [77] [78] 
.const [27] = Method [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Field [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = Field [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Field [95] [96] 
.const [36] = Field [97] [98] 
.const [37] = Field [99] [100] 
.const [38] = Field [101] [102] 
.const [39] = Utf8 "[SpeedWarningHandler#setCurrentValues] received values: state='%1', speedWarningValue='%2', speedWarningUnit='%3'" 
.const [40] = Class [103] 
.const [41] = NameAndType [104] [105] 
.const [42] = Utf8 "[SpeedWarningHandler#setCurrentValues] calculated values: state='%1', speedWarningValue='%2', speedWarningUnit='%3'" 
.const [43] = Utf8 'roundSpeedWarningValue BEFORE rounding (%1)' 
.const [44] = Utf8 'roundSpeedWarningValue AFTER rounding (%1)' 
.const [45] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 java/lang/Boolean 
.const [49] = Class [106] 
.const [50] = NameAndType [107] [108] 
.const [51] = Class [109] 
.const [52] = NameAndType [110] [111] 
.const [53] = Class [112] 
.const [54] = NameAndType [113] [114] 
.const [55] = Class [115] 
.const [56] = NameAndType [116] [117] 
.const [57] = Class [118] 
.const [58] = NameAndType [119] [120] 
.const [59] = Class [121] 
.const [60] = NameAndType [122] [123] 
.const [61] = Class [124] 
.const [62] = NameAndType [125] [126] 
.const [63] = Class [127] 
.const [64] = NameAndType [128] [129] 
.const [65] = Class [130] 
.const [66] = NameAndType [131] [132] 
.const [67] = Class [133] 
.const [68] = NameAndType [134] [135] 
.const [69] = Class [136] 
.const [70] = NameAndType [137] [138] 
.const [71] = Class [139] 
.const [72] = NameAndType [140] [141] 
.const [73] = Class [142] 
.const [74] = NameAndType [143] [144] 
.const [75] = Class [145] 
.const [76] = NameAndType [146] [147] 
.const [77] = Class [148] 
.const [78] = NameAndType [149] [150] 
.const [79] = Class [151] 
.const [80] = NameAndType [152] [153] 
.const [81] = Class [154] 
.const [82] = NameAndType [155] [156] 
.const [83] = Class [157] 
.const [84] = NameAndType [158] [159] 
.const [85] = Class [160] 
.const [86] = NameAndType [161] [162] 
.const [87] = Class [163] 
.const [88] = NameAndType [164] [165] 
.const [89] = Class [166] 
.const [90] = NameAndType [167] [168] 
.const [91] = Class [169] 
.const [92] = NameAndType [170] [171] 
.const [93] = Class [172] 
.const [94] = NameAndType [173] [174] 
.const [95] = Class [175] 
.const [96] = NameAndType [176] [177] 
.const [97] = Class [178] 
.const [98] = NameAndType [179] [180] 
.const [99] = Class [181] 
.const [100] = NameAndType [182] [183] 
.const [101] = Class [184] 
.const [102] = NameAndType [185] [186] 
.const [103] = Utf8 java/lang/Boolean 
.const [104] = Utf8 toString 
.const [105] = Utf8 (Z)Ljava/lang/String; 
.const [106] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [107] = Utf8 offKMH 
.const [108] = Utf8 I 
.const [109] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [110] = Utf8 maxKMH 
.const [111] = Utf8 I 
.const [112] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [113] = Utf8 stepKMH 
.const [114] = Utf8 I 
.const [115] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [116] = Utf8 offMPH 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [119] = Utf8 maxMPH 
.const [120] = Utf8 I 
.const [121] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [122] = Utf8 stepMPH 
.const [123] = Utf8 I 
.const [124] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [125] = Utf8 logChannel 
.const [126] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 isInfo 
.const [129] = Utf8 ()Z 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 log 
.const [132] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [133] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [134] = Utf8 currentSpeedWarningUnit 
.const [135] = Utf8 I 
.const [136] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [137] = Utf8 unitChanged 
.const [138] = Utf8 Z 
.const [139] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [140] = Utf8 currentSpeedWarningValue 
.const [141] = Utf8 I 
.const [142] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [143] = Utf8 currentState 
.const [144] = Utf8 Z 
.const [145] = Utf8 de/audi/atip/log/LogChannel 
.const [146] = Utf8 log 
.const [147] = Utf8 (ILjava/lang/String;J)Z 
.const [148] = Utf8 java/lang/Object 
.const [149] = Utf8 <init> 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [152] = Utf8 roundSpeedWarningValue 
.const [153] = Utf8 (II)I 
.const [154] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [155] = Utf8 offKMH 
.const [156] = Utf8 I 
.const [157] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [158] = Utf8 maxKMH 
.const [159] = Utf8 I 
.const [160] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [161] = Utf8 stepKMH 
.const [162] = Utf8 I 
.const [163] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [164] = Utf8 offMPH 
.const [165] = Utf8 I 
.const [166] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [167] = Utf8 maxMPH 
.const [168] = Utf8 I 
.const [169] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [170] = Utf8 stepMPH 
.const [171] = Utf8 I 
.const [172] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [173] = Utf8 logChannel 
.const [174] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [175] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [176] = Utf8 currentSpeedWarningUnit 
.const [177] = Utf8 I 
.const [178] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [179] = Utf8 unitChanged 
.const [180] = Utf8 Z 
.const [181] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [182] = Utf8 currentSpeedWarningValue 
.const [183] = Utf8 I 
.const [184] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [185] = Utf8 currentState 
.const [186] = Utf8 Z 
.const [187] = Utf8 de/audi/app/car/core/helper/SpeedWarningManualHandler 
.const [188] = Class [187] 
.const [189] = Utf8 java/lang/Object 
.const [190] = Class [189] 
.const [191] = Utf8 offKMH 
.const [192] = Utf8 I 
.const [193] = Utf8 maxKMH 
.const [194] = Utf8 I 
.const [195] = Utf8 stepKMH 
.const [196] = Utf8 I 
.const [197] = Utf8 offMPH 
.const [198] = Utf8 I 
.const [199] = Utf8 maxMPH 
.const [200] = Utf8 I 
.const [201] = Utf8 stepMPH 
.const [202] = Utf8 I 
.const [203] = Utf8 currentState 
.const [204] = Utf8 Z 
.const [205] = Utf8 currentSpeedWarningValue 
.const [206] = Utf8 I 
.const [207] = Utf8 currentSpeedWarningUnit 
.const [208] = Utf8 I 
.const [209] = Utf8 unitChanged 
.const [210] = Utf8 Z 
.const [211] = Utf8 logChannel 
.const [212] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [213] = Utf8 Code 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (IIIIIILde/audi/atip/log/LogChannel;)V 
.const [216] = Utf8 setCurrentValues 
.const [217] = Utf8 (ZII)V 
.const [218] = Utf8 unitHasChanged 
.const [219] = Utf8 ()Z 
.const [220] = Utf8 getState 
.const [221] = Utf8 ()Z 
.const [222] = Utf8 getSpeedWarningValue 
.const [223] = Utf8 ()I 
.const [224] = Utf8 getSpeedWarningUnit 
.const [225] = Utf8 ()I 
.const [226] = Utf8 getOffValue 
.const [227] = Utf8 ()I 
.const [228] = Utf8 getMaxValue 
.const [229] = Utf8 ()I 
.const [230] = Utf8 getStepValue 
.const [231] = Utf8 ()I 
.const [232] = Utf8 roundSpeedWarningValue 
.const [233] = Utf8 (II)I 
.end class 
