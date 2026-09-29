.version 50 0 
.class public final super [345] 
.super [347] 
.field public static final [348] [349] 
.field public static final [350] [351] 
.field public static final [352] [353] 
.field public static final [354] [355] 
.field public static final [356] [357] 
.field public static final [358] [359] 
.field public static final [360] [361] 
.field public static final [362] [363] 
.field public static final [364] [365] 
.field private static [366] [367] 
.field private static [368] [369] 
.field private final [370] [371] 
.field private final [372] [373] 
.field static synthetic [374] [375] 

.method public final interface [377] : [378] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [46] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [379] : [380] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [47] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [381] : [382] 
    .attribute [376] .code stack 5 locals 1 
L0:     iload_0 
L1:     getstatic [5] 
L4:     arraylength 
L5:     if_icmpge L30 
L8:     iload_0 
L9:     iflt L30 
L12:    getstatic [5] 
L15:    iload_0 
L16:    aaload 
L17:    getfield [46] 
L20:    iload_0 
L21:    if_icmpne L30 
L24:    getstatic [5] 
L27:    iload_0 
L28:    aaload 
L29:    areturn 
L30:    iconst_0 
L31:    istore_1 
L32:    iload_1 
L33:    getstatic [5] 
L36:    arraylength 
L37:    if_icmpge L64 
L40:    getstatic [5] 
L43:    iload_1 
L44:    aaload 
L45:    getfield [46] 
L48:    iload_0 
L49:    if_icmpne L58 
L52:    getstatic [5] 
L55:    iload_1 
L56:    aaload 
L57:    areturn 
L58:    iinc 1 1 
L61:    goto L32 
L64:    new [72] 
L67:    dup 
L68:    new [73] 
L71:    dup 
L72:    invokespecial [54] 
L75:    ldc [8] 
L77:    invokevirtual [48] 
L80:    getstatic [9] 
L83:    ifnonnull L98 
L86:    ldc [10] 
L88:    invokestatic [11] 
L91:    dup 
L92:    putstatic [55] 
L95:    goto L101 
L98:    getstatic [9] 
L101:   invokevirtual [49] 
L104:   ldc [12] 
L106:   invokevirtual [48] 
L109:   iload_0 
L110:   invokevirtual [50] 
L113:   invokevirtual [51] 
L116:   invokespecial [56] 
L119:   athrow 
L120:   
    .end code 
.end method 

.method private [383] : [384] 
    .attribute [376] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [71] 
L9:     aload_0 
L10:    getstatic [13] 
L13:    dup 
L14:    iconst_1 
L15:    iadd 
L16:    putstatic [58] 
L19:    putfield [70] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [385] : [386] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [71] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [70] 
L14:    iload_2 
L15:    iconst_1 
L16:    iadd 
L17:    putstatic [58] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [387] : [388] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [71] 
L9:     aload_0 
L10:    aload_2 
L11:    getfield [46] 
L14:    putfield [70] 
L17:    aload_0 
L18:    getfield [46] 
L21:    iconst_1 
L22:    iadd 
L23:    putstatic [58] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [389] : [390] 
    .attribute [376] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [69] 
L9:     dup 
L10:    invokespecial [52] 
L13:    aload_1 
L14:    invokevirtual [45] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [391] : [392] 
    .attribute [376] .code stack 4 locals 0 
L0:     new [74] 
L3:     dup 
L4:     ldc [15] 
L6:     invokestatic [16] 
L9:     invokespecial [59] 
L12:    putstatic [60] 
L15:    new [74] 
L18:    dup 
L19:    ldc [18] 
L21:    invokestatic [19] 
L24:    invokespecial [59] 
L27:    putstatic [61] 
L30:    new [74] 
L33:    dup 
L34:    ldc [21] 
L36:    invokestatic [22] 
L39:    invokespecial [59] 
L42:    putstatic [62] 
L45:    new [74] 
L48:    dup 
L49:    ldc [24] 
L51:    invokestatic [25] 
L54:    invokespecial [59] 
L57:    putstatic [63] 
L60:    new [74] 
L63:    dup 
L64:    ldc [27] 
L66:    invokestatic [28] 
L69:    invokespecial [59] 
L72:    putstatic [64] 
L75:    new [74] 
L78:    dup 
L79:    ldc [30] 
L81:    invokestatic [31] 
L84:    invokespecial [59] 
L87:    putstatic [65] 
L90:    new [74] 
L93:    dup 
L94:    ldc [33] 
L96:    invokestatic [34] 
L99:    invokespecial [59] 
L102:   putstatic [66] 
L105:   new [74] 
L108:   dup 
L109:   ldc [36] 
L111:   invokestatic [37] 
L114:   invokespecial [59] 
L117:   putstatic [67] 
L120:   new [74] 
L123:   dup 
L124:   ldc [39] 
L126:   invokestatic [40] 
L129:   invokespecial [59] 
L132:   putstatic [68] 
L135:   bipush 9 
L137:   anewarray [14] 
L140:   dup 
L141:   iconst_0 
L142:   getstatic [17] 
L145:   aastore 
L146:   dup 
L147:   iconst_1 
L148:   getstatic [20] 
L151:   aastore 
L152:   dup 
L153:   iconst_2 
L154:   getstatic [23] 
L157:   aastore 
L158:   dup 
L159:   iconst_3 
L160:   getstatic [26] 
L163:   aastore 
L164:   dup 
L165:   iconst_4 
L166:   getstatic [29] 
L169:   aastore 
L170:   dup 
L171:   iconst_5 
L172:   getstatic [32] 
L175:   aastore 
L176:   dup 
L177:   bipush 6 
L179:   getstatic [35] 
L182:   aastore 
L183:   dup 
L184:   bipush 7 
L186:   getstatic [38] 
L189:   aastore 
L190:   dup 
L191:   bipush 8 
L193:   getstatic [41] 
L196:   aastore 
L197:   putstatic [53] 
L200:   iconst_0 
L201:   putstatic [58] 
L204:   return 
L205:   nop 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [75] [76] 
.const [3] = Class [77] 
.const [4] = Class [78] 
.const [5] = Field [79] [80] 
.const [6] = Class [81] 
.const [7] = Class [82] 
.const [8] = String [83] 
.const [9] = Field [84] [85] 
.const [10] = String [86] 
.const [11] = Method [87] [88] 
.const [12] = String [89] 
.const [13] = Field [90] [91] 
.const [14] = Class [92] 
.const [15] = String [93] 
.const [16] = Method [94] [95] 
.const [17] = Field [96] [97] 
.const [18] = String [98] 
.const [19] = Method [99] [100] 
.const [20] = Field [101] [102] 
.const [21] = String [103] 
.const [22] = Method [104] [105] 
.const [23] = Field [106] [107] 
.const [24] = String [108] 
.const [25] = Method [109] [110] 
.const [26] = Field [111] [112] 
.const [27] = String [113] 
.const [28] = Method [114] [115] 
.const [29] = Field [116] [117] 
.const [30] = String [118] 
.const [31] = Method [119] [120] 
.const [32] = Field [121] [122] 
.const [33] = String [123] 
.const [34] = Method [124] [125] 
.const [35] = Field [126] [127] 
.const [36] = String [128] 
.const [37] = Method [129] [130] 
.const [38] = Field [131] [132] 
.const [39] = String [133] 
.const [40] = Method [134] [135] 
.const [41] = Field [136] [137] 
.const [42] = Class [138] 
.const [43] = Class [139] 
.const [44] = Class [140] 
.const [45] = Method [141] [142] 
.const [46] = Field [143] [144] 
.const [47] = Field [145] [146] 
.const [48] = Method [147] [148] 
.const [49] = Method [149] [150] 
.const [50] = Method [151] [152] 
.const [51] = Method [153] [154] 
.const [52] = Method [155] [156] 
.const [53] = Field [157] [158] 
.const [54] = Method [159] [160] 
.const [55] = Field [161] [162] 
.const [56] = Method [163] [164] 
.const [57] = Method [165] [166] 
.const [58] = Field [167] [168] 
.const [59] = Method [169] [170] 
.const [60] = Field [171] [172] 
.const [61] = Field [173] [174] 
.const [62] = Field [175] [176] 
.const [63] = Field [177] [178] 
.const [64] = Field [179] [180] 
.const [65] = Field [181] [182] 
.const [66] = Field [183] [184] 
.const [67] = Field [185] [186] 
.const [68] = Field [187] [188] 
.const [69] = Class [189] 
.const [70] = Field [190] [191] 
.const [71] = Field [192] [193] 
.const [72] = Class [194] 
.const [73] = Class [195] 
.const [74] = Class [196] 
.const [75] = Class [197] 
.const [76] = NameAndType [198] [199] 
.const [77] = Utf8 java/lang/ClassNotFoundException 
.const [78] = Utf8 java/lang/NoClassDefFoundError 
.const [79] = Class [200] 
.const [80] = NameAndType [201] [202] 
.const [81] = Utf8 java/lang/IllegalArgumentException 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 'No enum ' 
.const [84] = Class [203] 
.const [85] = NameAndType [204] [205] 
.const [86] = Utf8 'de.esolutions.graphics.eal.imageOptions_t' 
.const [87] = Class [206] 
.const [88] = NameAndType [207] [208] 
.const [89] = Utf8 ' with value ' 
.const [90] = Class [209] 
.const [91] = NameAndType [210] [211] 
.const [92] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [93] = Utf8 IMAGE_OPTIONS_MASK_FORMAT 
.const [94] = Class [212] 
.const [95] = NameAndType [213] [214] 
.const [96] = Class [215] 
.const [97] = NameAndType [216] [217] 
.const [98] = Utf8 IMAGE_OPTIONS_FORMAT_RGBA_8888 
.const [99] = Class [218] 
.const [100] = NameAndType [219] [220] 
.const [101] = Class [221] 
.const [102] = NameAndType [222] [223] 
.const [103] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_888 
.const [104] = Class [224] 
.const [105] = NameAndType [225] [226] 
.const [106] = Class [227] 
.const [107] = NameAndType [228] [229] 
.const [108] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_565 
.const [109] = Class [230] 
.const [110] = NameAndType [231] [232] 
.const [111] = Class [233] 
.const [112] = NameAndType [234] [235] 
.const [113] = Utf8 IMAGE_OPTIONS_FORMAT_L_8 
.const [114] = Class [236] 
.const [115] = NameAndType [237] [238] 
.const [116] = Class [239] 
.const [117] = NameAndType [240] [241] 
.const [118] = Utf8 IMAGE_OPTIONS_FORMAT_A_8 
.const [119] = Class [242] 
.const [120] = NameAndType [243] [244] 
.const [121] = Class [245] 
.const [122] = NameAndType [246] [247] 
.const [123] = Utf8 IMAGE_OPTIONS_FORMAT_LA_88 
.const [124] = Class [248] 
.const [125] = NameAndType [249] [250] 
.const [126] = Class [251] 
.const [127] = NameAndType [252] [253] 
.const [128] = Utf8 IMAGE_OPTIONS_FORMAT_AUTO 
.const [129] = Class [254] 
.const [130] = NameAndType [255] [256] 
.const [131] = Class [257] 
.const [132] = NameAndType [258] [259] 
.const [133] = Utf8 IMAGE_OPTIONS_FORMAT_INVALID 
.const [134] = Class [260] 
.const [135] = NameAndType [261] [262] 
.const [136] = Class [263] 
.const [137] = NameAndType [264] [265] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Utf8 java/lang/Class 
.const [140] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [141] = Class [266] 
.const [142] = NameAndType [267] [268] 
.const [143] = Class [269] 
.const [144] = NameAndType [270] [271] 
.const [145] = Class [272] 
.const [146] = NameAndType [273] [274] 
.const [147] = Class [275] 
.const [148] = NameAndType [276] [277] 
.const [149] = Class [278] 
.const [150] = NameAndType [279] [280] 
.const [151] = Class [281] 
.const [152] = NameAndType [282] [283] 
.const [153] = Class [284] 
.const [154] = NameAndType [285] [286] 
.const [155] = Class [287] 
.const [156] = NameAndType [288] [289] 
.const [157] = Class [290] 
.const [158] = NameAndType [291] [292] 
.const [159] = Class [293] 
.const [160] = NameAndType [294] [295] 
.const [161] = Class [296] 
.const [162] = NameAndType [297] [298] 
.const [163] = Class [299] 
.const [164] = NameAndType [300] [301] 
.const [165] = Class [302] 
.const [166] = NameAndType [303] [304] 
.const [167] = Class [305] 
.const [168] = NameAndType [306] [307] 
.const [169] = Class [308] 
.const [170] = NameAndType [309] [310] 
.const [171] = Class [311] 
.const [172] = NameAndType [312] [313] 
.const [173] = Class [314] 
.const [174] = NameAndType [315] [316] 
.const [175] = Class [317] 
.const [176] = NameAndType [318] [319] 
.const [177] = Class [320] 
.const [178] = NameAndType [321] [322] 
.const [179] = Class [323] 
.const [180] = NameAndType [324] [325] 
.const [181] = Class [326] 
.const [182] = NameAndType [327] [328] 
.const [183] = Class [329] 
.const [184] = NameAndType [330] [331] 
.const [185] = Class [332] 
.const [186] = NameAndType [333] [334] 
.const [187] = Class [335] 
.const [188] = NameAndType [336] [337] 
.const [189] = Utf8 java/lang/NoClassDefFoundError 
.const [190] = Class [338] 
.const [191] = NameAndType [339] [340] 
.const [192] = Class [341] 
.const [193] = NameAndType [342] [343] 
.const [194] = Utf8 java/lang/IllegalArgumentException 
.const [195] = Utf8 java/lang/StringBuffer 
.const [196] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [197] = Utf8 java/lang/Class 
.const [198] = Utf8 forName 
.const [199] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [200] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [201] = Utf8 swigValues 
.const [202] = Utf8 [Lde/esolutions/graphics/eal/imageOptions_t; 
.const [203] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [204] = Utf8 class$de$esolutions$graphics$eal$imageOptions_t 
.const [205] = Utf8 Ljava/lang/Class; 
.const [206] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [207] = Utf8 class$ 
.const [208] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [209] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [210] = Utf8 swigNext 
.const [211] = Utf8 I 
.const [212] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [213] = Utf8 eal_IMAGE_OPTIONS_MASK_FORMAT_get 
.const [214] = Utf8 ()I 
.const [215] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [216] = Utf8 IMAGE_OPTIONS_MASK_FORMAT 
.const [217] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [218] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [219] = Utf8 eal_IMAGE_OPTIONS_FORMAT_RGBA_8888_get 
.const [220] = Utf8 ()I 
.const [221] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [222] = Utf8 IMAGE_OPTIONS_FORMAT_RGBA_8888 
.const [223] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [224] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [225] = Utf8 eal_IMAGE_OPTIONS_FORMAT_RGB_888_get 
.const [226] = Utf8 ()I 
.const [227] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [228] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_888 
.const [229] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [230] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [231] = Utf8 eal_IMAGE_OPTIONS_FORMAT_RGB_565_get 
.const [232] = Utf8 ()I 
.const [233] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [234] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_565 
.const [235] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [236] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [237] = Utf8 eal_IMAGE_OPTIONS_FORMAT_L_8_get 
.const [238] = Utf8 ()I 
.const [239] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [240] = Utf8 IMAGE_OPTIONS_FORMAT_L_8 
.const [241] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [242] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [243] = Utf8 eal_IMAGE_OPTIONS_FORMAT_A_8_get 
.const [244] = Utf8 ()I 
.const [245] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [246] = Utf8 IMAGE_OPTIONS_FORMAT_A_8 
.const [247] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [248] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [249] = Utf8 eal_IMAGE_OPTIONS_FORMAT_LA_88_get 
.const [250] = Utf8 ()I 
.const [251] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [252] = Utf8 IMAGE_OPTIONS_FORMAT_LA_88 
.const [253] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [254] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [255] = Utf8 eal_IMAGE_OPTIONS_FORMAT_AUTO_get 
.const [256] = Utf8 ()I 
.const [257] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [258] = Utf8 IMAGE_OPTIONS_FORMAT_AUTO 
.const [259] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [260] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [261] = Utf8 eal_IMAGE_OPTIONS_FORMAT_INVALID_get 
.const [262] = Utf8 ()I 
.const [263] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [264] = Utf8 IMAGE_OPTIONS_FORMAT_INVALID 
.const [265] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [266] = Utf8 java/lang/NoClassDefFoundError 
.const [267] = Utf8 initCause 
.const [268] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [269] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [270] = Utf8 swigValue 
.const [271] = Utf8 I 
.const [272] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [273] = Utf8 swigName 
.const [274] = Utf8 Ljava/lang/String; 
.const [275] = Utf8 java/lang/StringBuffer 
.const [276] = Utf8 append 
.const [277] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [278] = Utf8 java/lang/StringBuffer 
.const [279] = Utf8 append 
.const [280] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [281] = Utf8 java/lang/StringBuffer 
.const [282] = Utf8 append 
.const [283] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [284] = Utf8 java/lang/StringBuffer 
.const [285] = Utf8 toString 
.const [286] = Utf8 ()Ljava/lang/String; 
.const [287] = Utf8 java/lang/NoClassDefFoundError 
.const [288] = Utf8 <init> 
.const [289] = Utf8 ()V 
.const [290] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [291] = Utf8 swigValues 
.const [292] = Utf8 [Lde/esolutions/graphics/eal/imageOptions_t; 
.const [293] = Utf8 java/lang/StringBuffer 
.const [294] = Utf8 <init> 
.const [295] = Utf8 ()V 
.const [296] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [297] = Utf8 class$de$esolutions$graphics$eal$imageOptions_t 
.const [298] = Utf8 Ljava/lang/Class; 
.const [299] = Utf8 java/lang/IllegalArgumentException 
.const [300] = Utf8 <init> 
.const [301] = Utf8 (Ljava/lang/String;)V 
.const [302] = Utf8 java/lang/Object 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ()V 
.const [305] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [306] = Utf8 swigNext 
.const [307] = Utf8 I 
.const [308] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (Ljava/lang/String;I)V 
.const [311] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [312] = Utf8 IMAGE_OPTIONS_MASK_FORMAT 
.const [313] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [314] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [315] = Utf8 IMAGE_OPTIONS_FORMAT_RGBA_8888 
.const [316] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [317] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [318] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_888 
.const [319] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [320] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [321] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_565 
.const [322] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [323] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [324] = Utf8 IMAGE_OPTIONS_FORMAT_L_8 
.const [325] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [326] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [327] = Utf8 IMAGE_OPTIONS_FORMAT_A_8 
.const [328] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [329] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [330] = Utf8 IMAGE_OPTIONS_FORMAT_LA_88 
.const [331] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [332] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [333] = Utf8 IMAGE_OPTIONS_FORMAT_AUTO 
.const [334] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [335] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [336] = Utf8 IMAGE_OPTIONS_FORMAT_INVALID 
.const [337] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [338] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [339] = Utf8 swigValue 
.const [340] = Utf8 I 
.const [341] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [342] = Utf8 swigName 
.const [343] = Utf8 Ljava/lang/String; 
.const [344] = Utf8 de/esolutions/graphics/eal/imageOptions_t 
.const [345] = Class [344] 
.const [346] = Utf8 java/lang/Object 
.const [347] = Class [346] 
.const [348] = Utf8 IMAGE_OPTIONS_MASK_FORMAT 
.const [349] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [350] = Utf8 IMAGE_OPTIONS_FORMAT_RGBA_8888 
.const [351] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [352] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_888 
.const [353] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [354] = Utf8 IMAGE_OPTIONS_FORMAT_RGB_565 
.const [355] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [356] = Utf8 IMAGE_OPTIONS_FORMAT_L_8 
.const [357] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [358] = Utf8 IMAGE_OPTIONS_FORMAT_A_8 
.const [359] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [360] = Utf8 IMAGE_OPTIONS_FORMAT_LA_88 
.const [361] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [362] = Utf8 IMAGE_OPTIONS_FORMAT_AUTO 
.const [363] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [364] = Utf8 IMAGE_OPTIONS_FORMAT_INVALID 
.const [365] = Utf8 Lde/esolutions/graphics/eal/imageOptions_t; 
.const [366] = Utf8 swigValues 
.const [367] = Utf8 [Lde/esolutions/graphics/eal/imageOptions_t; 
.const [368] = Utf8 swigNext 
.const [369] = Utf8 I 
.const [370] = Utf8 swigValue 
.const [371] = Utf8 I 
.const [372] = Utf8 swigName 
.const [373] = Utf8 Ljava/lang/String; 
.const [374] = Utf8 class$de$esolutions$graphics$eal$imageOptions_t 
.const [375] = Utf8 Ljava/lang/Class; 
.const [376] = Utf8 Code 
.const [377] = Utf8 swigValue 
.const [378] = Utf8 ()I 
.const [379] = Utf8 toString 
.const [380] = Utf8 ()Ljava/lang/String; 
.const [381] = Utf8 swigToEnum 
.const [382] = Utf8 (I)Lde/esolutions/graphics/eal/imageOptions_t; 
.const [383] = Utf8 <init> 
.const [384] = Utf8 (Ljava/lang/String;)V 
.const [385] = Utf8 <init> 
.const [386] = Utf8 (Ljava/lang/String;I)V 
.const [387] = Utf8 <init> 
.const [388] = Utf8 (Ljava/lang/String;Lde/esolutions/graphics/eal/imageOptions_t;)V 
.const [389] = Utf8 class$ 
.const [390] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [391] = Utf8 <clinit> 
.const [392] = Utf8 ()V 
.end class 
