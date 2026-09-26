.version 50 0 
.class public final super [195] 
.super [197] 
.field public static final [198] [199] 
.field public static final [200] [201] 
.field public static final [202] [203] 
.field public static final [204] [205] 
.field private static [206] [207] 
.field private static [208] [209] 
.field private final [210] [211] 
.field private final [212] [213] 

.method public final interface [215] : [216] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [217] : [218] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [219] : [220] 
    .attribute [214] .code stack 5 locals 1 
L0:     iload_0 
L1:     getstatic [2] 
L4:     arraylength 
L5:     if_icmpge L30 
L8:     iload_0 
L9:     iflt L30 
L12:    getstatic [2] 
L15:    iload_0 
L16:    aaload 
L17:    getfield [22] 
L20:    iload_0 
L21:    if_icmpne L30 
L24:    getstatic [2] 
L27:    iload_0 
L28:    aaload 
L29:    areturn 
L30:    iconst_0 
L31:    istore_1 
L32:    iload_1 
L33:    getstatic [2] 
L36:    arraylength 
L37:    if_icmpge L64 
L40:    getstatic [2] 
L43:    iload_1 
L44:    aaload 
L45:    getfield [22] 
L48:    iload_0 
L49:    if_icmpne L58 
L52:    getstatic [2] 
L55:    iload_1 
L56:    aaload 
L57:    areturn 
L58:    iinc 1 1 
L61:    goto L32 
L64:    new [41] 
L67:    dup 
L68:    new [42] 
L71:    dup 
L72:    invokespecial [29] 
L75:    ldc [5] 
L77:    invokevirtual [24] 
L80:    getstatic [6] 
L83:    ifnonnull L98 
L86:    ldc [7] 
L88:    invokestatic [8] 
L91:    dup 
L92:    putstatic [30] 
L95:    goto L101 
L98:    getstatic [6] 
L101:   invokevirtual [25] 
L104:   ldc [9] 
L106:   invokevirtual [24] 
L109:   iload_0 
L110:   invokevirtual [26] 
L113:   invokevirtual [27] 
L116:   invokespecial [31] 
L119:   athrow 
L120:   
    .end code 
.end method 

.method private [221] : [222] 
    .attribute [214] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [40] 
L9:     aload_0 
L10:    getstatic [10] 
L13:    dup 
L14:    iconst_1 
L15:    iadd 
L16:    putstatic [33] 
L19:    putfield [39] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [223] : [224] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [40] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [39] 
L14:    iload_2 
L15:    iconst_1 
L16:    iadd 
L17:    putstatic [33] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [225] : [226] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [40] 
L9:     aload_0 
L10:    aload_2 
L11:    getfield [22] 
L14:    putfield [39] 
L17:    aload_0 
L18:    getfield [22] 
L21:    iconst_1 
L22:    iadd 
L23:    putstatic [33] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static [227] : [228] 
    .attribute [214] .code stack 4 locals 0 
L0:     new [43] 
L3:     dup 
L4:     ldc [12] 
L6:     invokespecial [34] 
L9:     putstatic [35] 
L12:    new [43] 
L15:    dup 
L16:    ldc [14] 
L18:    invokespecial [34] 
L21:    putstatic [36] 
L24:    new [43] 
L27:    dup 
L28:    ldc [16] 
L30:    invokespecial [34] 
L33:    putstatic [37] 
L36:    new [43] 
L39:    dup 
L40:    ldc [18] 
L42:    invokespecial [34] 
L45:    putstatic [38] 
L48:    iconst_4 
L49:    anewarray [11] 
L52:    dup 
L53:    iconst_0 
L54:    getstatic [13] 
L57:    aastore 
L58:    dup 
L59:    iconst_1 
L60:    getstatic [15] 
L63:    aastore 
L64:    dup 
L65:    iconst_2 
L66:    getstatic [17] 
L69:    aastore 
L70:    dup 
L71:    iconst_3 
L72:    getstatic [19] 
L75:    aastore 
L76:    putstatic [28] 
L79:    iconst_0 
L80:    putstatic [33] 
L83:    return 
L84:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [44] [45] 
.const [3] = Class [46] 
.const [4] = Class [47] 
.const [5] = String [48] 
.const [6] = Field [49] [50] 
.const [7] = String [51] 
.const [8] = Method [52] [53] 
.const [9] = String [54] 
.const [10] = Field [55] [56] 
.const [11] = Class [57] 
.const [12] = String [58] 
.const [13] = Field [59] [60] 
.const [14] = String [61] 
.const [15] = Field [62] [63] 
.const [16] = String [64] 
.const [17] = Field [65] [66] 
.const [18] = String [67] 
.const [19] = Field [68] [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Field [72] [73] 
.const [23] = Field [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Field [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Field [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Field [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Class [110] 
.const [42] = Class [111] 
.const [43] = Class [112] 
.const [44] = Class [113] 
.const [45] = NameAndType [114] [115] 
.const [46] = Utf8 java/lang/IllegalArgumentException 
.const [47] = Utf8 java/lang/StringBuffer 
.const [48] = Utf8 'No enum ' 
.const [49] = Class [116] 
.const [50] = NameAndType [117] [118] 
.const [51] = Utf8 'de.esolutions.graphics.eal.api.ITextLayout$kerning_t' 
.const [52] = Class [119] 
.const [53] = NameAndType [120] [121] 
.const [54] = Utf8 ' with value ' 
.const [55] = Class [122] 
.const [56] = NameAndType [123] [124] 
.const [57] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [58] = Utf8 KERNING_OFF 
.const [59] = Class [125] 
.const [60] = NameAndType [126] [127] 
.const [61] = Utf8 KERNING_AUTO 
.const [62] = Class [128] 
.const [63] = NameAndType [129] [130] 
.const [64] = Utf8 KERNING_GPOS 
.const [65] = Class [131] 
.const [66] = NameAndType [132] [133] 
.const [67] = Utf8 KERNING_FULL 
.const [68] = Class [134] 
.const [69] = NameAndType [135] [136] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [72] = Class [137] 
.const [73] = NameAndType [138] [139] 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Utf8 java/lang/IllegalArgumentException 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [113] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [114] = Utf8 swigValues 
.const [115] = Utf8 [Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [116] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [117] = Utf8 class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t 
.const [118] = Utf8 Ljava/lang/Class; 
.const [119] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [120] = Utf8 class$ 
.const [121] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [122] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [123] = Utf8 swigNext 
.const [124] = Utf8 I 
.const [125] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [126] = Utf8 KERNING_OFF 
.const [127] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [128] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [129] = Utf8 KERNING_AUTO 
.const [130] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [131] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [132] = Utf8 KERNING_GPOS 
.const [133] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [134] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [135] = Utf8 KERNING_FULL 
.const [136] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [137] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [138] = Utf8 swigValue 
.const [139] = Utf8 I 
.const [140] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [141] = Utf8 swigName 
.const [142] = Utf8 Ljava/lang/String; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 append 
.const [145] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 append 
.const [148] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 append 
.const [151] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [156] = Utf8 swigValues 
.const [157] = Utf8 [Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/esolutions/graphics/eal/api/ITextLayout 
.const [162] = Utf8 class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t 
.const [163] = Utf8 Ljava/lang/Class; 
.const [164] = Utf8 java/lang/IllegalArgumentException 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Ljava/lang/String;)V 
.const [167] = Utf8 java/lang/Object 
.const [168] = Utf8 <init> 
.const [169] = Utf8 ()V 
.const [170] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [171] = Utf8 swigNext 
.const [172] = Utf8 I 
.const [173] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [174] = Utf8 <init> 
.const [175] = Utf8 (Ljava/lang/String;)V 
.const [176] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [177] = Utf8 KERNING_OFF 
.const [178] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [179] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [180] = Utf8 KERNING_AUTO 
.const [181] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [182] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [183] = Utf8 KERNING_GPOS 
.const [184] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [185] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [186] = Utf8 KERNING_FULL 
.const [187] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [188] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [189] = Utf8 swigValue 
.const [190] = Utf8 I 
.const [191] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [192] = Utf8 swigName 
.const [193] = Utf8 Ljava/lang/String; 
.const [194] = Utf8 de/esolutions/graphics/eal/api/ITextLayout$kerning_t 
.const [195] = Class [194] 
.const [196] = Utf8 java/lang/Object 
.const [197] = Class [196] 
.const [198] = Utf8 KERNING_OFF 
.const [199] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [200] = Utf8 KERNING_AUTO 
.const [201] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [202] = Utf8 KERNING_GPOS 
.const [203] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [204] = Utf8 KERNING_FULL 
.const [205] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [206] = Utf8 swigValues 
.const [207] = Utf8 [Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [208] = Utf8 swigNext 
.const [209] = Utf8 I 
.const [210] = Utf8 swigValue 
.const [211] = Utf8 I 
.const [212] = Utf8 swigName 
.const [213] = Utf8 Ljava/lang/String; 
.const [214] = Utf8 Code 
.const [215] = Utf8 swigValue 
.const [216] = Utf8 ()I 
.const [217] = Utf8 toString 
.const [218] = Utf8 ()Ljava/lang/String; 
.const [219] = Utf8 swigToEnum 
.const [220] = Utf8 (I)Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t; 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Ljava/lang/String;)V 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Ljava/lang/String;I)V 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Ljava/lang/String;Lde/esolutions/graphics/eal/api/ITextLayout$kerning_t;)V 
.const [227] = Utf8 <clinit> 
.const [228] = Utf8 ()V 
.end class 
