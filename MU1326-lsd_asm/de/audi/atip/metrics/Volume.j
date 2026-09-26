.version 50 0 
.class public super [205] 
.super [207] 
.field private static final [208] [209] 
.field private static final [210] [211] 
.field private static [212] [213] 
.field public static final [214] [215] 
.field public static final [216] [217] 
.field public static final [218] [219] 
.field private static [220] [221] 

.method public [223] : [224] 
    .attribute [222] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [33] 
L6:     aload_0 
L7:     invokespecial [34] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method private final [225] : [226] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     lookupswitch 
            2 : L32 
            3 : L35 
            default : L38 

L32:    goto L38 
L35:    goto L38 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [227] : [228] 
    .attribute [222] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L15 
L5:     iload_0 
L6:     iconst_2 
L7:     if_icmpeq L15 
L10:    iload_0 
L11:    iconst_3 
L12:    if_icmpne L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [229] : [230] 
    .attribute [222] .code stack 2 locals 0 
L0:     iload_0 
L1:     invokestatic [2] 
L4:     ifne L15 
L7:     new [40] 
L10:    dup 
L11:    invokespecial [35] 
L14:    athrow 
L15:    iload_0 
L16:    putstatic [36] 
L19:    return 
L20:    
    .end code 
.end method 

.method public static [231] : [232] 
    .attribute [222] .code stack 1 locals 0 
L0:     getstatic [4] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [41] 
L5:     aload_0 
L6:     invokespecial [34] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [4] 
L4:     invokevirtual [21] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [222] .code stack 2 locals 0 
L0:     iload_1 
L1:     invokestatic [2] 
L4:     ifne L15 
L7:     new [40] 
L10:    dup 
L11:    invokespecial [35] 
L14:    athrow 
L15:    aload_0 
L16:    iload_1 
L17:    invokevirtual [21] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [239] : [240] 
    .attribute [222] .code stack 1 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            2 : L28 
            3 : L28 
            default : L28 

L28:    aload_0 
L29:    getfield [20] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifeq L16 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [19] 
L12:    invokevirtual [23] 
L15:    areturn 
L16:    aload_0 
L17:    getstatic [4] 
L20:    invokevirtual [23] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [222] .code stack 4 locals 2 
L0:     iload_1 
L1:     invokestatic [2] 
L4:     ifne L15 
L7:     new [40] 
L10:    dup 
L11:    invokespecial [35] 
L14:    athrow 
L15:    new [42] 
L18:    dup 
L19:    invokespecial [37] 
L22:    astore_2 
L23:    iload_1 
L24:    tableswitch 1 
            L81 
            L52 
            L81 
            default : L81 

L52:    aload_0 
L53:    getfield [20] 
L56:    fstore_3 
L57:    aload_0 
L58:    aload_2 
L59:    fload_3 
L60:    bipush 39 
L62:    invokestatic [6] 
L65:    invokespecial [38] 
L68:    aload_2 
L69:    bipush 37 
L71:    invokestatic [6] 
L74:    invokevirtual [24] 
L77:    pop 
L78:    goto L107 
L81:    aload_0 
L82:    getfield [20] 
L85:    fstore_3 
L86:    aload_0 
L87:    aload_2 
L88:    fload_3 
L89:    bipush 40 
L91:    invokestatic [6] 
L94:    invokespecial [38] 
L97:    aload_2 
L98:    bipush 38 
L100:   invokestatic [6] 
L103:   invokevirtual [24] 
L106:   pop 
L107:   aload_0 
L108:   getfield [25] 
L111:   aload_2 
L112:   invokestatic [7] 
L115:   ifne L126 
L118:   aload_0 
L119:   aload_2 
L120:   invokevirtual [26] 
L123:   putfield [43] 
L126:   aload_0 
L127:   getfield [25] 
L130:   areturn 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [222] .code stack 5 locals 0 
L0:     iconst_2 
L1:     anewarray [8] 
L4:     dup 
L5:     iconst_0 
L6:     aload_0 
L7:     iload_1 
L8:     invokevirtual [27] 
L11:    aastore 
L12:    dup 
L13:    iconst_1 
L14:    aload_0 
L15:    iload_1 
L16:    invokevirtual [28] 
L19:    aastore 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected static [247] : [248] 
    .attribute [222] .code stack 1 locals 1 
L0:     iload_0 
L1:     invokestatic [9] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L67 
L9:     iload_0 
L10:    tableswitch 37 
            L40 
            L46 
            L52 
            L58 
            default : L64 

L40:    ldc [10] 
L42:    astore_1 
L43:    goto L67 
L46:    ldc [11] 
L48:    astore_1 
L49:    goto L67 
L52:    ldc [12] 
L54:    astore_1 
L55:    goto L67 
L58:    ldc [13] 
L60:    astore_1 
L61:    goto L67 
L64:    ldc [14] 
L66:    astore_1 
L67:    aload_1 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private [249] : [250] 
    .attribute [222] .code stack 4 locals 5 
L0:     bipush 100 
L2:     istore 4 
L4:     fload_2 
L5:     f2i 
L6:     istore 5 
L8:     fload_2 
L9:     iload 4 
L11:    i2f 
L12:    fmul 
L13:    f2d 
L14:    ldc2_w [44] 
L17:    dadd 
L18:    d2i 
L19:    iload 5 
L21:    iload 4 
L23:    imul 
L24:    isub 
L25:    istore 6 
L27:    iload 5 
L29:    iload 6 
L31:    iload 4 
L33:    idiv 
L34:    iadd 
L35:    istore 5 
L37:    iload 6 
L39:    iload 4 
L41:    irem 
L42:    istore 6 
L44:    iload 6 
L46:    bipush 10 
L48:    idiv 
L49:    istore 7 
L51:    iload 6 
L53:    iload 7 
L55:    bipush 10 
L57:    imul 
L58:    isub 
L59:    istore 8 
L61:    aload_1 
L62:    iload 5 
L64:    invokevirtual [29] 
L67:    pop 
L68:    iload 8 
L70:    ifeq L92 
L73:    aload_1 
L74:    aload_3 
L75:    invokevirtual [24] 
L78:    iload 7 
L80:    invokevirtual [29] 
L83:    iload 8 
L85:    invokevirtual [29] 
L88:    pop 
L89:    goto L108 
L92:    iload 7 
L94:    ifeq L108 
L97:    aload_1 
L98:    aload_3 
L99:    invokevirtual [24] 
L102:   iload 7 
L104:   invokevirtual [29] 
L107:   pop 
L108:   return 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [222] .code stack 2 locals 1 
L0:     iload_1 
L1:     invokestatic [2] 
L4:     ifne L15 
L7:     new [40] 
L10:    dup 
L11:    invokespecial [35] 
L14:    athrow 
L15:    aconst_null 
L16:    astore_2 
L17:    iload_1 
L18:    tableswitch 1 
            L53 
            L44 
            L53 
            default : L53 

L44:    bipush 37 
L46:    invokestatic [6] 
L49:    astore_2 
L50:    goto L59 
L53:    bipush 38 
L55:    invokestatic [6] 
L58:    astore_2 
L59:    aconst_null 
L60:    aload_2 
L61:    if_acmpeq L71 
L64:    aload_2 
L65:    invokevirtual [30] 
L68:    goto L73 
L71:    ldc [14] 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [22] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [19] 
L12:    goto L18 
L15:    getstatic [4] 
L18:    invokevirtual [28] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [22] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [19] 
L12:    goto L18 
L15:    getstatic [4] 
L18:    invokevirtual [27] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [222] .code stack 4 locals 2 
L0:     iload_1 
L1:     invokestatic [2] 
L4:     ifne L15 
L7:     new [40] 
L10:    dup 
L11:    invokespecial [35] 
L14:    athrow 
L15:    new [42] 
L18:    dup 
L19:    invokespecial [37] 
L22:    astore_2 
L23:    aconst_null 
L24:    astore_3 
L25:    iload_1 
L26:    tableswitch 1 
            L61 
            L52 
            L61 
            default : L61 

L52:    bipush 39 
L54:    invokestatic [6] 
L57:    astore_3 
L58:    goto L67 
L61:    bipush 40 
L63:    invokestatic [6] 
L66:    astore_3 
L67:    aload_0 
L68:    aload_2 
L69:    aload_0 
L70:    getfield [20] 
L73:    aload_3 
L74:    invokespecial [38] 
L77:    aload_0 
L78:    invokevirtual [31] 
L81:    ifeq L94 
L84:    aload_2 
L85:    invokevirtual [26] 
L88:    invokevirtual [30] 
L91:    goto L98 
L94:    aload_0 
L95:    invokevirtual [32] 
L98:    areturn 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [222] .code stack 1 locals 0 
L0:     getstatic [15] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [261] : [262] 
    .attribute [222] .code stack 1 locals 0 
L0:     ldc [16] 
L2:     putstatic [39] 
L5:     iconst_1 
L6:     putstatic [36] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [46] [47] 
.const [3] = Class [48] 
.const [4] = Field [49] [50] 
.const [5] = Class [51] 
.const [6] = Method [52] [53] 
.const [7] = Method [54] [55] 
.const [8] = Class [56] 
.const [9] = Method [57] [58] 
.const [10] = String [59] 
.const [11] = String [60] 
.const [12] = String [61] 
.const [13] = String [62] 
.const [14] = String [63] 
.const [15] = Field [64] [65] 
.const [16] = String [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Field [69] [70] 
.const [20] = Field [71] [72] 
.const [21] = Method [73] [74] 
.const [22] = Field [75] [76] 
.const [23] = Method [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Field [103] [104] 
.const [37] = Method [105] [106] 
.const [38] = Method [107] [108] 
.const [39] = Field [109] [110] 
.const [40] = Class [111] 
.const [41] = Field [112] [113] 
.const [42] = Class [114] 
.const [43] = Field [115] [116] 
.const [44] = Double +0x10000000000000p-53 
.const [46] = Class [117] 
.const [47] = NameAndType [118] [119] 
.const [48] = Utf8 java/lang/IllegalArgumentException 
.const [49] = Class [120] 
.const [50] = NameAndType [121] [122] 
.const [51] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [52] = Class [123] 
.const [53] = NameAndType [124] [125] 
.const [54] = Class [126] 
.const [55] = NameAndType [127] [128] 
.const [56] = Utf8 java/lang/String 
.const [57] = Class [129] 
.const [58] = NameAndType [130] [131] 
.const [59] = Utf8 ' qt' 
.const [60] = Utf8 ' l' 
.const [61] = Utf8 '.' 
.const [62] = Utf8 ',' 
.const [63] = Utf8 '' 
.const [64] = Class [132] 
.const [65] = NameAndType [133] [134] 
.const [66] = Utf8 '---' 
.const [67] = Utf8 de/audi/atip/metrics/Volume 
.const [68] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [69] = Class [135] 
.const [70] = NameAndType [136] [137] 
.const [71] = Class [138] 
.const [72] = NameAndType [139] [140] 
.const [73] = Class [141] 
.const [74] = NameAndType [142] [143] 
.const [75] = Class [144] 
.const [76] = NameAndType [145] [146] 
.const [77] = Class [147] 
.const [78] = NameAndType [148] [149] 
.const [79] = Class [150] 
.const [80] = NameAndType [151] [152] 
.const [81] = Class [153] 
.const [82] = NameAndType [154] [155] 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Class [159] 
.const [86] = NameAndType [160] [161] 
.const [87] = Class [162] 
.const [88] = NameAndType [163] [164] 
.const [89] = Class [165] 
.const [90] = NameAndType [166] [167] 
.const [91] = Class [168] 
.const [92] = NameAndType [169] [170] 
.const [93] = Class [171] 
.const [94] = NameAndType [172] [173] 
.const [95] = Class [174] 
.const [96] = NameAndType [175] [176] 
.const [97] = Class [177] 
.const [98] = NameAndType [178] [179] 
.const [99] = Class [180] 
.const [100] = NameAndType [181] [182] 
.const [101] = Class [183] 
.const [102] = NameAndType [184] [185] 
.const [103] = Class [186] 
.const [104] = NameAndType [187] [188] 
.const [105] = Class [189] 
.const [106] = NameAndType [190] [191] 
.const [107] = Class [192] 
.const [108] = NameAndType [193] [194] 
.const [109] = Class [195] 
.const [110] = NameAndType [196] [197] 
.const [111] = Utf8 java/lang/IllegalArgumentException 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [115] = Class [201] 
.const [116] = NameAndType [202] [203] 
.const [117] = Utf8 de/audi/atip/metrics/Volume 
.const [118] = Utf8 unitIsValid 
.const [119] = Utf8 (I)Z 
.const [120] = Utf8 de/audi/atip/metrics/Volume 
.const [121] = Utf8 systemUnit 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/atip/metrics/Volume 
.const [124] = Utf8 getText 
.const [125] = Utf8 (I)Ljava/lang/String; 
.const [126] = Utf8 de/audi/atip/metrics/Volume 
.const [127] = Utf8 contentEquals 
.const [128] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/Buffer;)Z 
.const [129] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [130] = Utf8 getText 
.const [131] = Utf8 (I)Ljava/lang/String; 
.const [132] = Utf8 de/audi/atip/metrics/Volume 
.const [133] = Utf8 TEXT_INVALID 
.const [134] = Utf8 Ljava/lang/String; 
.const [135] = Utf8 de/audi/atip/metrics/Volume 
.const [136] = Utf8 unit 
.const [137] = Utf8 I 
.const [138] = Utf8 de/audi/atip/metrics/Volume 
.const [139] = Utf8 value 
.const [140] = Utf8 F 
.const [141] = Utf8 de/audi/atip/metrics/Volume 
.const [142] = Utf8 getValueInUnit 
.const [143] = Utf8 (I)F 
.const [144] = Utf8 de/audi/atip/metrics/Volume 
.const [145] = Utf8 useInstanceUnit 
.const [146] = Utf8 Z 
.const [147] = Utf8 de/audi/atip/metrics/Volume 
.const [148] = Utf8 format 
.const [149] = Utf8 (I)Ljava/lang/String; 
.const [150] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [151] = Utf8 append 
.const [152] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [153] = Utf8 de/audi/atip/metrics/Volume 
.const [154] = Utf8 lastFormat 
.const [155] = Utf8 Ljava/lang/String; 
.const [156] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [157] = Utf8 toString 
.const [158] = Utf8 ()Ljava/lang/String; 
.const [159] = Utf8 de/audi/atip/metrics/Volume 
.const [160] = Utf8 getFormattedValue 
.const [161] = Utf8 (I)Ljava/lang/String; 
.const [162] = Utf8 de/audi/atip/metrics/Volume 
.const [163] = Utf8 getFormattedUnit 
.const [164] = Utf8 (I)Ljava/lang/String; 
.const [165] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [166] = Utf8 append 
.const [167] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [168] = Utf8 java/lang/String 
.const [169] = Utf8 trim 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 de/audi/atip/metrics/Volume 
.const [172] = Utf8 isMetricvalid 
.const [173] = Utf8 ()Z 
.const [174] = Utf8 de/audi/atip/metrics/Volume 
.const [175] = Utf8 getInvalidText 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [178] = Utf8 <init> 
.const [179] = Utf8 (FI)V 
.const [180] = Utf8 de/audi/atip/metrics/Volume 
.const [181] = Utf8 importValue 
.const [182] = Utf8 ()V 
.const [183] = Utf8 java/lang/IllegalArgumentException 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/atip/metrics/Volume 
.const [187] = Utf8 systemUnit 
.const [188] = Utf8 I 
.const [189] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [190] = Utf8 <init> 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/atip/metrics/Volume 
.const [193] = Utf8 formatValue 
.const [194] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;FLjava/lang/String;)V 
.const [195] = Utf8 de/audi/atip/metrics/Volume 
.const [196] = Utf8 TEXT_INVALID 
.const [197] = Utf8 Ljava/lang/String; 
.const [198] = Utf8 de/audi/atip/metrics/Volume 
.const [199] = Utf8 value 
.const [200] = Utf8 F 
.const [201] = Utf8 de/audi/atip/metrics/Volume 
.const [202] = Utf8 lastFormat 
.const [203] = Utf8 Ljava/lang/String; 
.const [204] = Utf8 de/audi/atip/metrics/Volume 
.const [205] = Class [204] 
.const [206] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [207] = Class [206] 
.const [208] = Utf8 TEXT_VOLUME_QUARTS 
.const [209] = Utf8 Ljava/lang/String; 
.const [210] = Utf8 TEXT_VOLUME_LITER 
.const [211] = Utf8 Ljava/lang/String; 
.const [212] = Utf8 TEXT_INVALID 
.const [213] = Utf8 Ljava/lang/String; 
.const [214] = Utf8 LITER 
.const [215] = Utf8 I 
.const [216] = Utf8 GAL_US 
.const [217] = Utf8 I 
.const [218] = Utf8 GAL_UK 
.const [219] = Utf8 I 
.const [220] = Utf8 systemUnit 
.const [221] = Utf8 I 
.const [222] = Utf8 Code 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (FI)V 
.const [225] = Utf8 importValue 
.const [226] = Utf8 ()V 
.const [227] = Utf8 unitIsValid 
.const [228] = Utf8 (I)Z 
.const [229] = Utf8 setSystemUnit 
.const [230] = Utf8 (I)V 
.const [231] = Utf8 getSystemUnit 
.const [232] = Utf8 ()I 
.const [233] = Utf8 setValue 
.const [234] = Utf8 (F)V 
.const [235] = Utf8 getValue 
.const [236] = Utf8 ()F 
.const [237] = Utf8 getValue 
.const [238] = Utf8 (I)F 
.const [239] = Utf8 getValueInUnit 
.const [240] = Utf8 (I)F 
.const [241] = Utf8 format 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 format 
.const [244] = Utf8 (I)Ljava/lang/String; 
.const [245] = Utf8 getStringValueAndUnit 
.const [246] = Utf8 (I)[Ljava/lang/String; 
.const [247] = Utf8 getText 
.const [248] = Utf8 (I)Ljava/lang/String; 
.const [249] = Utf8 formatValue 
.const [250] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;FLjava/lang/String;)V 
.const [251] = Utf8 getFormattedUnit 
.const [252] = Utf8 (I)Ljava/lang/String; 
.const [253] = Utf8 getFormattedMetricUnit 
.const [254] = Utf8 ()Ljava/lang/String; 
.const [255] = Utf8 getFormattedValue 
.const [256] = Utf8 ()Ljava/lang/String; 
.const [257] = Utf8 getFormattedValue 
.const [258] = Utf8 (I)Ljava/lang/String; 
.const [259] = Utf8 getInvalidText 
.const [260] = Utf8 ()Ljava/lang/String; 
.const [261] = Utf8 <clinit> 
.const [262] = Utf8 ()V 
.end class 
