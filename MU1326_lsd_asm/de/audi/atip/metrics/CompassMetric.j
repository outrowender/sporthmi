.version 50 0 
.class public super [240] 
.super [242] 
.field private static final [243] [244] 
.field private static final [245] [246] 
.field private static final [247] [248] 
.field private static final [249] [250] 
.field private static final [251] [252] 
.field private static final [253] [254] 
.field private static final [255] [256] 
.field private static final [257] [258] 
.field private static final [259] [260] 
.field private static final [261] [262] 
.field private static final [263] [264] 
.field private static final [265] [266] 
.field private static final [267] [268] 
.field private static final [269] [270] 
.field private static final [271] [272] 
.field private static final [273] [274] 
.field private static final [275] [276] 
.field private static final [277] [278] 
.field private static [279] [280] 
.field public static final [281] [282] 
.field public static final [283] [284] 
.field public static final [285] [286] 
.field public static final [287] [288] 
.field public static final [289] [290] 
.field public static final [291] [292] 
.field public static final [293] [294] 
.field public static final [295] [296] 
.field public static final [297] [298] 
.field public static final [299] [300] 
.field public static final [301] [302] 
.field public static final [303] [304] 
.field public static final [305] [306] 
.field public static final [307] [308] 
.field public static final [309] [310] 
.field public static final [311] [312] 
.field public static final [313] [314] 
.field public static final [315] [316] 
.field public static final [317] [318] 
.field private [319] [320] 

.method public [322] : [323] 
    .attribute [321] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iconst_1 
L3:     invokespecial [54] 
L6:     aload_0 
L7:     fload_1 
L8:     invokevirtual [38] 
L11:    aload_0 
L12:    iload_2 
L13:    invokevirtual [39] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [324] : [325] 
    .attribute [321] .code stack 4 locals 0 
L0:     iconst_1 
L1:     iload_1 
L2:     if_icmpgt L19 
L5:     iload_1 
L6:     bipush 16 
L8:     if_icmpgt L19 
L11:    aload_0 
L12:    iload_1 
L13:    putfield [60] 
L16:    goto L51 
L19:    new [61] 
L22:    dup 
L23:    new [62] 
L26:    dup 
L27:    invokespecial [55] 
L30:    ldc [4] 
L32:    invokevirtual [41] 
L35:    iload_1 
L36:    invokevirtual [42] 
L39:    ldc [5] 
L41:    invokevirtual [41] 
L44:    invokevirtual [43] 
L47:    invokespecial [56] 
L50:    athrow 
L51:    return 
L52:    
    .end code 
.end method 

.method public [326] : [327] 
    .attribute [321] .code stack 4 locals 0 
L0:     fconst_0 
L1:     fload_1 
L2:     fcmpg 
L3:     ifgt L21 
L6:     fload_1 
L7:     ldc [6] 
L9:     fcmpg 
L10:    ifgt L21 
L13:    aload_0 
L14:    fload_1 
L15:    putfield [63] 
L18:    goto L53 
L21:    new [61] 
L24:    dup 
L25:    new [62] 
L28:    dup 
L29:    invokespecial [55] 
L32:    ldc [7] 
L34:    invokevirtual [41] 
L37:    fload_1 
L38:    invokevirtual [45] 
L41:    ldc [5] 
L43:    invokevirtual [41] 
L46:    invokevirtual [43] 
L49:    invokespecial [56] 
L52:    athrow 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public interface [328] : [329] 
    .attribute [321] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [330] : [331] 
    .attribute [321] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [332] : [333] 
    .attribute [321] .code stack 4 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L20 
            default : L25 

L20:    aload_0 
L21:    getfield [44] 
L24:    areturn 
L25:    new [61] 
L28:    dup 
L29:    new [62] 
L32:    dup 
L33:    invokespecial [55] 
L36:    ldc [8] 
L38:    invokevirtual [41] 
L41:    iload_1 
L42:    invokevirtual [42] 
L45:    ldc [9] 
L47:    invokevirtual [41] 
L50:    invokevirtual [43] 
L53:    invokespecial [56] 
L56:    athrow 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [321] .code stack 2 locals 1 
L0:     new [64] 
L3:     dup 
L4:     invokespecial [57] 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [44] 
L13:    invokestatic [11] 
L16:    invokevirtual [46] 
L19:    pop 
L20:    aload_1 
L21:    aload_0 
L22:    invokevirtual [47] 
L25:    invokevirtual [48] 
L28:    pop 
L29:    aload_1 
L30:    invokevirtual [49] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [336] : [337] 
    .attribute [321] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [50] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [338] : [339] 
    .attribute [321] .code stack 3 locals 1 
L0:     new [64] 
L3:     dup 
L4:     invokespecial [57] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [12] 
L11:    invokevirtual [48] 
L14:    pop 
L15:    aload_1 
L16:    ldc [13] 
L18:    invokevirtual [48] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    aload_0 
L25:    getfield [40] 
L28:    invokespecial [58] 
L31:    invokevirtual [48] 
L34:    pop 
L35:    aload_1 
L36:    invokevirtual [49] 
L39:    areturn 
L40:    
    .end code 
.end method 

.method public [340] : [341] 
    .attribute [321] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [47] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [342] : [343] 
    .attribute [321] .code stack 2 locals 1 
L0:     new [64] 
L3:     dup 
L4:     invokespecial [57] 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [44] 
L13:    invokestatic [11] 
L16:    invokevirtual [46] 
L19:    pop 
L20:    aload_0 
L21:    invokevirtual [51] 
L24:    ifeq L34 
L27:    aload_1 
L28:    invokevirtual [49] 
L31:    goto L38 
L34:    aload_0 
L35:    invokevirtual [52] 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [344] : [345] 
    .attribute [321] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [53] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [346] : [347] 
    .attribute [321] .code stack 1 locals 1 
L0:     iconst_m1 
L1:     istore_2 
L2:     iload_1 
L3:     tableswitch 1 
            L80 
            L86 
            L92 
            L98 
            L104 
            L110 
            L116 
            L122 
            L128 
            L134 
            L140 
            L146 
            L152 
            L158 
            L164 
            L170 
            default : L173 

L80:    bipush 47 
L82:    istore_2 
L83:    goto L173 
L86:    bipush 70 
L88:    istore_2 
L89:    goto L173 
L92:    bipush 71 
L94:    istore_2 
L95:    goto L173 
L98:    bipush 72 
L100:   istore_2 
L101:   goto L173 
L104:   bipush 49 
L106:   istore_2 
L107:   goto L173 
L110:   bipush 73 
L112:   istore_2 
L113:   goto L173 
L116:   bipush 74 
L118:   istore_2 
L119:   goto L173 
L122:   bipush 75 
L124:   istore_2 
L125:   goto L173 
L128:   bipush 46 
L130:   istore_2 
L131:   goto L173 
L134:   bipush 76 
L136:   istore_2 
L137:   goto L173 
L140:   bipush 77 
L142:   istore_2 
L143:   goto L173 
L146:   bipush 78 
L148:   istore_2 
L149:   goto L173 
L152:   bipush 48 
L154:   istore_2 
L155:   goto L173 
L158:   bipush 79 
L160:   istore_2 
L161:   goto L173 
L164:   bipush 80 
L166:   istore_2 
L167:   goto L173 
L170:   bipush 81 
L172:   istore_2 
L173:   iload_2 
L174:   invokestatic [14] 
L177:   areturn 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method protected static [348] : [349] 
    .attribute [321] .code stack 1 locals 1 
L0:     iload_0 
L1:     invokestatic [15] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L219 
L9:     iload_0 
L10:    tableswitch 46 
            L192 
            L168 
            L204 
            L180 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L216 
            L171 
            L174 
            L177 
            L183 
            L186 
            L189 
            L195 
            L198 
            L201 
            L207 
            L210 
            L213 
            default : L216 

L168:   ldc [16] 
L170:   areturn 
L171:   ldc [17] 
L173:   areturn 
L174:   ldc [18] 
L176:   areturn 
L177:   ldc [19] 
L179:   areturn 
L180:   ldc [20] 
L182:   areturn 
L183:   ldc [21] 
L185:   areturn 
L186:   ldc [22] 
L188:   areturn 
L189:   ldc [23] 
L191:   areturn 
L192:   ldc [24] 
L194:   areturn 
L195:   ldc [25] 
L197:   areturn 
L198:   ldc [26] 
L200:   areturn 
L201:   ldc [27] 
L203:   areturn 
L204:   ldc [28] 
L206:   areturn 
L207:   ldc [29] 
L209:   areturn 
L210:   ldc [30] 
L212:   areturn 
L213:   ldc [31] 
L215:   areturn 
L216:   ldc [32] 
L218:   areturn 
L219:   aload_1 
L220:   areturn 
L221:   nop 
L222:   nop 
L223:   nop 
L224:   
    .end code 
.end method 

.method public [350] : [351] 
    .attribute [321] .code stack 1 locals 0 
L0:     getstatic [33] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [352] : [353] 
    .attribute [321] .code stack 1 locals 0 
L0:     ldc [34] 
L2:     putstatic [59] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [65] 
.const [3] = Class [66] 
.const [4] = String [67] 
.const [5] = String [68] 
.const [6] = Int 46147 
.const [7] = String [69] 
.const [8] = String [70] 
.const [9] = String [71] 
.const [10] = Class [72] 
.const [11] = Method [73] [74] 
.const [12] = String [75] 
.const [13] = String [76] 
.const [14] = Method [77] [78] 
.const [15] = Method [79] [80] 
.const [16] = String [81] 
.const [17] = String [82] 
.const [18] = String [83] 
.const [19] = String [84] 
.const [20] = String [85] 
.const [21] = String [86] 
.const [22] = String [87] 
.const [23] = String [88] 
.const [24] = String [89] 
.const [25] = String [90] 
.const [26] = String [91] 
.const [27] = String [92] 
.const [28] = String [93] 
.const [29] = String [94] 
.const [30] = String [95] 
.const [31] = String [96] 
.const [32] = String [97] 
.const [33] = Field [98] [99] 
.const [34] = String [100] 
.const [35] = Class [101] 
.const [36] = Class [102] 
.const [37] = Class [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Field [116] [117] 
.const [45] = Method [118] [119] 
.const [46] = Method [120] [121] 
.const [47] = Method [122] [123] 
.const [48] = Method [124] [125] 
.const [49] = Method [126] [127] 
.const [50] = Method [128] [129] 
.const [51] = Method [130] [131] 
.const [52] = Method [132] [133] 
.const [53] = Method [134] [135] 
.const [54] = Method [136] [137] 
.const [55] = Method [138] [139] 
.const [56] = Method [140] [141] 
.const [57] = Method [142] [143] 
.const [58] = Method [144] [145] 
.const [59] = Field [146] [147] 
.const [60] = Field [148] [149] 
.const [61] = Class [150] 
.const [62] = Class [151] 
.const [63] = Field [152] [153] 
.const [64] = Class [154] 
.const [65] = Utf8 java/lang/IllegalArgumentException 
.const [66] = Utf8 java/lang/StringBuffer 
.const [67] = Utf8 'The given orientation (' 
.const [68] = Utf8 ') cannot be used to create a CompassMetric instance.' 
.const [69] = Utf8 'The given angle (' 
.const [70] = Utf8 'The given unit (' 
.const [71] = Utf8 ') cannot be used for the CompassMetric.' 
.const [72] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [73] = Class [155] 
.const [74] = NameAndType [156] [157] 
.const [75] = Utf8 '\xb0' 
.const [76] = Utf8 ' ' 
.const [77] = Class [158] 
.const [78] = NameAndType [159] [160] 
.const [79] = Class [161] 
.const [80] = NameAndType [162] [163] 
.const [81] = Utf8 N 
.const [82] = Utf8 NNO 
.const [83] = Utf8 NO 
.const [84] = Utf8 ONO 
.const [85] = Utf8 O 
.const [86] = Utf8 OSO 
.const [87] = Utf8 SO 
.const [88] = Utf8 SSO 
.const [89] = Utf8 S 
.const [90] = Utf8 SSW 
.const [91] = Utf8 SW 
.const [92] = Utf8 WSW 
.const [93] = Utf8 W 
.const [94] = Utf8 WNW 
.const [95] = Utf8 NW 
.const [96] = Utf8 NNW 
.const [97] = Utf8 '' 
.const [98] = Class [164] 
.const [99] = NameAndType [165] [166] 
.const [100] = Utf8 '---' 
.const [101] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [102] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [103] = Utf8 java/lang/Math 
.const [104] = Class [167] 
.const [105] = NameAndType [168] [169] 
.const [106] = Class [170] 
.const [107] = NameAndType [171] [172] 
.const [108] = Class [173] 
.const [109] = NameAndType [174] [175] 
.const [110] = Class [176] 
.const [111] = NameAndType [177] [178] 
.const [112] = Class [179] 
.const [113] = NameAndType [180] [181] 
.const [114] = Class [182] 
.const [115] = NameAndType [183] [184] 
.const [116] = Class [185] 
.const [117] = NameAndType [186] [187] 
.const [118] = Class [188] 
.const [119] = NameAndType [189] [190] 
.const [120] = Class [191] 
.const [121] = NameAndType [192] [193] 
.const [122] = Class [194] 
.const [123] = NameAndType [195] [196] 
.const [124] = Class [197] 
.const [125] = NameAndType [198] [199] 
.const [126] = Class [200] 
.const [127] = NameAndType [201] [202] 
.const [128] = Class [203] 
.const [129] = NameAndType [204] [205] 
.const [130] = Class [206] 
.const [131] = NameAndType [207] [208] 
.const [132] = Class [209] 
.const [133] = NameAndType [210] [211] 
.const [134] = Class [212] 
.const [135] = NameAndType [213] [214] 
.const [136] = Class [215] 
.const [137] = NameAndType [216] [217] 
.const [138] = Class [218] 
.const [139] = NameAndType [219] [220] 
.const [140] = Class [221] 
.const [141] = NameAndType [222] [223] 
.const [142] = Class [224] 
.const [143] = NameAndType [225] [226] 
.const [144] = Class [227] 
.const [145] = NameAndType [228] [229] 
.const [146] = Class [230] 
.const [147] = NameAndType [231] [232] 
.const [148] = Class [233] 
.const [149] = NameAndType [234] [235] 
.const [150] = Utf8 java/lang/IllegalArgumentException 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Class [236] 
.const [153] = NameAndType [237] [238] 
.const [154] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [155] = Utf8 java/lang/Math 
.const [156] = Utf8 round 
.const [157] = Utf8 (F)I 
.const [158] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [159] = Utf8 getText 
.const [160] = Utf8 (I)Ljava/lang/String; 
.const [161] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [162] = Utf8 getText 
.const [163] = Utf8 (I)Ljava/lang/String; 
.const [164] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [165] = Utf8 TEXT_INVALID 
.const [166] = Utf8 Ljava/lang/String; 
.const [167] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [168] = Utf8 setValue 
.const [169] = Utf8 (F)V 
.const [170] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [171] = Utf8 setOrientation 
.const [172] = Utf8 (I)V 
.const [173] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [174] = Utf8 orientation 
.const [175] = Utf8 I 
.const [176] = Utf8 java/lang/StringBuffer 
.const [177] = Utf8 append 
.const [178] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [179] = Utf8 java/lang/StringBuffer 
.const [180] = Utf8 append 
.const [181] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [182] = Utf8 java/lang/StringBuffer 
.const [183] = Utf8 toString 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [186] = Utf8 value 
.const [187] = Utf8 F 
.const [188] = Utf8 java/lang/StringBuffer 
.const [189] = Utf8 append 
.const [190] = Utf8 (F)Ljava/lang/StringBuffer; 
.const [191] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [192] = Utf8 append 
.const [193] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [194] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [195] = Utf8 getFormattedMetricUnit 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [198] = Utf8 append 
.const [199] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [200] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [201] = Utf8 toString 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [204] = Utf8 format 
.const [205] = Utf8 ()Ljava/lang/String; 
.const [206] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [207] = Utf8 isMetricvalid 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [210] = Utf8 getInvalidText 
.const [211] = Utf8 ()Ljava/lang/String; 
.const [212] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [213] = Utf8 getFormattedValue 
.const [214] = Utf8 ()Ljava/lang/String; 
.const [215] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (FI)V 
.const [218] = Utf8 java/lang/StringBuffer 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 java/lang/IllegalArgumentException 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (Ljava/lang/String;)V 
.const [224] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [225] = Utf8 <init> 
.const [226] = Utf8 ()V 
.const [227] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [228] = Utf8 getOrientationText 
.const [229] = Utf8 (I)Ljava/lang/String; 
.const [230] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [231] = Utf8 TEXT_INVALID 
.const [232] = Utf8 Ljava/lang/String; 
.const [233] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [234] = Utf8 orientation 
.const [235] = Utf8 I 
.const [236] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [237] = Utf8 value 
.const [238] = Utf8 F 
.const [239] = Utf8 de/audi/atip/metrics/CompassMetric 
.const [240] = Class [239] 
.const [241] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [242] = Class [241] 
.const [243] = Utf8 TEXT_SPACE 
.const [244] = Utf8 Ljava/lang/String; 
.const [245] = Utf8 TEXT_DEGREE 
.const [246] = Utf8 Ljava/lang/String; 
.const [247] = Utf8 TEXT_N 
.const [248] = Utf8 Ljava/lang/String; 
.const [249] = Utf8 TEXT_NNO 
.const [250] = Utf8 Ljava/lang/String; 
.const [251] = Utf8 TEXT_NO 
.const [252] = Utf8 Ljava/lang/String; 
.const [253] = Utf8 TEXT_ONO 
.const [254] = Utf8 Ljava/lang/String; 
.const [255] = Utf8 TEXT_O 
.const [256] = Utf8 Ljava/lang/String; 
.const [257] = Utf8 TEXT_OSO 
.const [258] = Utf8 Ljava/lang/String; 
.const [259] = Utf8 TEXT_SO 
.const [260] = Utf8 Ljava/lang/String; 
.const [261] = Utf8 TEXT_SSO 
.const [262] = Utf8 Ljava/lang/String; 
.const [263] = Utf8 TEXT_S 
.const [264] = Utf8 Ljava/lang/String; 
.const [265] = Utf8 TEXT_SSW 
.const [266] = Utf8 Ljava/lang/String; 
.const [267] = Utf8 TEXT_SW 
.const [268] = Utf8 Ljava/lang/String; 
.const [269] = Utf8 TEXT_WSW 
.const [270] = Utf8 Ljava/lang/String; 
.const [271] = Utf8 TEXT_W 
.const [272] = Utf8 Ljava/lang/String; 
.const [273] = Utf8 TEXT_WNW 
.const [274] = Utf8 Ljava/lang/String; 
.const [275] = Utf8 TEXT_NW 
.const [276] = Utf8 Ljava/lang/String; 
.const [277] = Utf8 TEXT_NNW 
.const [278] = Utf8 Ljava/lang/String; 
.const [279] = Utf8 TEXT_INVALID 
.const [280] = Utf8 Ljava/lang/String; 
.const [281] = Utf8 ORIENTATION_N 
.const [282] = Utf8 I 
.const [283] = Utf8 ORIENTATION_NNO 
.const [284] = Utf8 I 
.const [285] = Utf8 ORIENTATION_NO 
.const [286] = Utf8 I 
.const [287] = Utf8 ORIENTATION_ONO 
.const [288] = Utf8 I 
.const [289] = Utf8 ORIENTATION_O 
.const [290] = Utf8 I 
.const [291] = Utf8 ORIENTATION_OSO 
.const [292] = Utf8 I 
.const [293] = Utf8 ORIENTATION_SO 
.const [294] = Utf8 I 
.const [295] = Utf8 ORIENTATION_SSO 
.const [296] = Utf8 I 
.const [297] = Utf8 ORIENTATION_S 
.const [298] = Utf8 I 
.const [299] = Utf8 ORIENTATION_SSW 
.const [300] = Utf8 I 
.const [301] = Utf8 ORIENTATION_SW 
.const [302] = Utf8 I 
.const [303] = Utf8 ORIENTATION_WSW 
.const [304] = Utf8 I 
.const [305] = Utf8 ORIENTATION_W 
.const [306] = Utf8 I 
.const [307] = Utf8 ORIENTATION_WNW 
.const [308] = Utf8 I 
.const [309] = Utf8 ORIENTATION_NW 
.const [310] = Utf8 I 
.const [311] = Utf8 ORIENTATION_NNW 
.const [312] = Utf8 I 
.const [313] = Utf8 MODE_ORIENTATIONS_8 
.const [314] = Utf8 I 
.const [315] = Utf8 MODE_ORIENTATIONS_16 
.const [316] = Utf8 I 
.const [317] = Utf8 UNIT_DEGREE 
.const [318] = Utf8 I 
.const [319] = Utf8 orientation 
.const [320] = Utf8 I 
.const [321] = Utf8 Code 
.const [322] = Utf8 <init> 
.const [323] = Utf8 (FI)V 
.const [324] = Utf8 setOrientation 
.const [325] = Utf8 (I)V 
.const [326] = Utf8 setValue 
.const [327] = Utf8 (F)V 
.const [328] = Utf8 getOrientation 
.const [329] = Utf8 ()I 
.const [330] = Utf8 getValue 
.const [331] = Utf8 ()F 
.const [332] = Utf8 getValue 
.const [333] = Utf8 (I)F 
.const [334] = Utf8 format 
.const [335] = Utf8 ()Ljava/lang/String; 
.const [336] = Utf8 format 
.const [337] = Utf8 (I)Ljava/lang/String; 
.const [338] = Utf8 getFormattedMetricUnit 
.const [339] = Utf8 ()Ljava/lang/String; 
.const [340] = Utf8 getFormattedUnit 
.const [341] = Utf8 (I)Ljava/lang/String; 
.const [342] = Utf8 getFormattedValue 
.const [343] = Utf8 ()Ljava/lang/String; 
.const [344] = Utf8 getFormattedValue 
.const [345] = Utf8 (I)Ljava/lang/String; 
.const [346] = Utf8 getOrientationText 
.const [347] = Utf8 (I)Ljava/lang/String; 
.const [348] = Utf8 getText 
.const [349] = Utf8 (I)Ljava/lang/String; 
.const [350] = Utf8 getInvalidText 
.const [351] = Utf8 ()Ljava/lang/String; 
.const [352] = Utf8 <clinit> 
.const [353] = Utf8 ()V 
.end class 
