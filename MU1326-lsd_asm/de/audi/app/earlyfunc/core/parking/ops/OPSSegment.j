.version 50 0 
.class public super [175] 
.super [177] 
.field private final [178] [179] 
.field private final [180] [181] 
.field private final [182] [183] 
.field private final [184] [185] 
.field public static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 
.field private [192] [193] 

.method public [195] : [196] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [29] 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [30] 
L14:    aload_0 
L15:    iload_2 
L16:    putfield [31] 
L19:    aload_0 
L20:    aload_3 
L21:    putfield [32] 
L24:    aload_0 
L25:    iload 4 
L27:    putfield [33] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public interface [197] : [198] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [199] : [200] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [201] : [202] 
    .attribute [194] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [13] 
L5:     if_icmplt L20 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [14] 
L13:    if_icmpgt L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [203] : [204] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [194] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [23] 
L5:     ifeq L23 
L8:     aload_0 
L9:     invokespecial [24] 
L12:    ifne L21 
L15:    aload_0 
L16:    iload_1 
L17:    iload_3 
L18:    invokespecial [25] 
L21:    iconst_1 
L22:    areturn 
L23:    aload_0 
L24:    getfield [16] 
L27:    iload_2 
L28:    if_icmpne L42 
L31:    aload_0 
L32:    invokespecial [24] 
L35:    ifne L42 
L38:    aload_0 
L39:    invokespecial [26] 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private [207] : [208] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     iconst_0 
L5:     invokeinterface [34] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [209] : [210] 
    .attribute [194] .code stack 2 locals 1 
L0:     iload_2 
L1:     ifgt L20 
L4:     aload_0 
L5:     getfield [15] 
L8:     aload_0 
L9:     getfield [16] 
L12:    invokeinterface [34] 0 
L17:    goto L44 
L20:    iconst_1 
L21:    istore_3 
L22:    iload_1 
L23:    ifle L34 
L26:    iload_1 
L27:    iload_2 
L28:    iadd 
L29:    iconst_1 
L30:    isub 
L31:    iload_2 
L32:    idiv 
L33:    istore_3 
L34:    aload_0 
L35:    getfield [15] 
L38:    iload_3 
L39:    invokeinterface [34] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [194] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     ifne L9 
L5:     iconst_1 
L6:     goto L10 
L9:     iconst_0 
L10:    invokespecial [27] 
L13:    aload_0 
L14:    invokespecial [24] 
L17:    ifeq L25 
L20:    aload_0 
L21:    invokespecial [26] 
L24:    return 
L25:    aload_0 
L26:    iload_2 
L27:    iload_3 
L28:    invokespecial [25] 
L31:    iload_1 
L32:    iconst_1 
L33:    if_icmpeq L41 
L36:    iload_1 
L37:    iconst_2 
L38:    if_icmpne L54 
L41:    aload_0 
L42:    getfield [15] 
L45:    iconst_0 
L46:    invokeinterface [35] 0 
L51:    goto L69 
L54:    iload_1 
L55:    iconst_3 
L56:    if_icmpne L69 
L59:    aload_0 
L60:    getfield [15] 
L63:    iconst_1 
L64:    invokeinterface [35] 0 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method private interface [213] : [214] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [215] : [216] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [194] .code stack 3 locals 1 
L0:     new [36] 
L3:     dup 
L4:     sipush 500 
L7:     invokespecial [28] 
L10:    astore_1 
L11:    aload_1 
L12:    ldc [3] 
L14:    invokevirtual [17] 
L17:    aload_0 
L18:    getfield [13] 
L21:    invokevirtual [18] 
L24:    ldc [4] 
L26:    invokevirtual [17] 
L29:    aload_0 
L30:    getfield [14] 
L33:    invokevirtual [18] 
L36:    ldc [5] 
L38:    invokevirtual [17] 
L41:    pop 
L42:    aload_0 
L43:    getfield [15] 
L46:    ifnull L73 
L49:    aload_1 
L50:    ldc [6] 
L52:    invokevirtual [17] 
L55:    aload_0 
L56:    getfield [15] 
L59:    invokeinterface [37] 0 
L64:    invokevirtual [18] 
L67:    ldc [5] 
L69:    invokevirtual [17] 
L72:    pop 
L73:    aload_1 
L74:    ldc [7] 
L76:    invokevirtual [17] 
L79:    aload_0 
L80:    getfield [16] 
L83:    invokevirtual [18] 
L86:    ldc [8] 
L88:    invokevirtual [17] 
L91:    aload_0 
L92:    getfield [12] 
L95:    invokevirtual [19] 
L98:    bipush 41 
L100:   invokevirtual [20] 
L103:   pop 
L104:   aload_1 
L105:   invokevirtual [21] 
L108:   areturn 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [38] 
.const [3] = String [39] 
.const [4] = String [40] 
.const [5] = String [41] 
.const [6] = String [42] 
.const [7] = String [43] 
.const [8] = String [44] 
.const [9] = Class [45] 
.const [10] = Class [46] 
.const [11] = Class [47] 
.const [12] = Field [48] [49] 
.const [13] = Field [50] [51] 
.const [14] = Field [52] [53] 
.const [15] = Field [54] [55] 
.const [16] = Field [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = InterfaceMethod [92] [93] 
.const [35] = InterfaceMethod [94] [95] 
.const [36] = Class [96] 
.const [37] = InterfaceMethod [97] [98] 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 'OPSSegment (minDistance=' 
.const [40] = Utf8 ', maxDistance=' 
.const [41] = Utf8 ', ' 
.const [42] = Utf8 'distanceModelID=' 
.const [43] = Utf8 'segmentID=' 
.const [44] = Utf8 ', hiddenStatus=' 
.const [45] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [48] = Class [99] 
.const [49] = NameAndType [100] [101] 
.const [50] = Class [102] 
.const [51] = NameAndType [103] [104] 
.const [52] = Class [105] 
.const [53] = NameAndType [106] [107] 
.const [54] = Class [108] 
.const [55] = NameAndType [109] [110] 
.const [56] = Class [111] 
.const [57] = NameAndType [112] [113] 
.const [58] = Class [114] 
.const [59] = NameAndType [115] [116] 
.const [60] = Class [117] 
.const [61] = NameAndType [118] [119] 
.const [62] = Class [120] 
.const [63] = NameAndType [121] [122] 
.const [64] = Class [123] 
.const [65] = NameAndType [124] [125] 
.const [66] = Class [126] 
.const [67] = NameAndType [127] [128] 
.const [68] = Class [129] 
.const [69] = NameAndType [130] [131] 
.const [70] = Class [132] 
.const [71] = NameAndType [133] [134] 
.const [72] = Class [135] 
.const [73] = NameAndType [136] [137] 
.const [74] = Class [138] 
.const [75] = NameAndType [139] [140] 
.const [76] = Class [141] 
.const [77] = NameAndType [142] [143] 
.const [78] = Class [144] 
.const [79] = NameAndType [145] [146] 
.const [80] = Class [147] 
.const [81] = NameAndType [148] [149] 
.const [82] = Class [150] 
.const [83] = NameAndType [151] [152] 
.const [84] = Class [153] 
.const [85] = NameAndType [154] [155] 
.const [86] = Class [156] 
.const [87] = NameAndType [157] [158] 
.const [88] = Class [159] 
.const [89] = NameAndType [160] [161] 
.const [90] = Class [162] 
.const [91] = NameAndType [163] [164] 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Class [168] 
.const [95] = NameAndType [169] [170] 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Class [171] 
.const [98] = NameAndType [172] [173] 
.const [99] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [100] = Utf8 hiddenStatus 
.const [101] = Utf8 Z 
.const [102] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [103] = Utf8 minDistance 
.const [104] = Utf8 I 
.const [105] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [106] = Utf8 maxDistance 
.const [107] = Utf8 I 
.const [108] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [109] = Utf8 distanceModel 
.const [110] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [111] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [112] = Utf8 segmentID 
.const [113] = Utf8 I 
.const [114] = Utf8 java/lang/StringBuffer 
.const [115] = Utf8 append 
.const [116] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [117] = Utf8 java/lang/StringBuffer 
.const [118] = Utf8 append 
.const [119] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [120] = Utf8 java/lang/StringBuffer 
.const [121] = Utf8 append 
.const [122] = Utf8 (Z)Ljava/lang/StringBuffer; 
.const [123] = Utf8 java/lang/StringBuffer 
.const [124] = Utf8 append 
.const [125] = Utf8 (C)Ljava/lang/StringBuffer; 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 toString 
.const [128] = Utf8 ()Ljava/lang/String; 
.const [129] = Utf8 java/lang/Object 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [133] = Utf8 isDistanceValueInsideRange 
.const [134] = Utf8 (I)Z 
.const [135] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [136] = Utf8 isHiddenStatus 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [139] = Utf8 setDistanceValue 
.const [140] = Utf8 (II)V 
.const [141] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [142] = Utf8 hideSegment 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [145] = Utf8 setHiddenStatus 
.const [146] = Utf8 (Z)V 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (I)V 
.const [150] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [151] = Utf8 hiddenStatus 
.const [152] = Utf8 Z 
.const [153] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [154] = Utf8 minDistance 
.const [155] = Utf8 I 
.const [156] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [157] = Utf8 maxDistance 
.const [158] = Utf8 I 
.const [159] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [160] = Utf8 distanceModel 
.const [161] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [162] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [163] = Utf8 segmentID 
.const [164] = Utf8 I 
.const [165] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [166] = Utf8 setValue 
.const [167] = Utf8 (I)V 
.const [168] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [169] = Utf8 setStatus 
.const [170] = Utf8 (I)V 
.const [171] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [172] = Utf8 getID 
.const [173] = Utf8 ()I 
.const [174] = Utf8 de/audi/app/earlyfunc/core/parking/ops/OPSSegment 
.const [175] = Class [174] 
.const [176] = Utf8 java/lang/Object 
.const [177] = Class [176] 
.const [178] = Utf8 minDistance 
.const [179] = Utf8 I 
.const [180] = Utf8 maxDistance 
.const [181] = Utf8 I 
.const [182] = Utf8 distanceModel 
.const [183] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [184] = Utf8 segmentID 
.const [185] = Utf8 I 
.const [186] = Utf8 HIDDEN_SEGMENT_ID 
.const [187] = Utf8 I 
.const [188] = Utf8 WHITE_HIGHLIGHTING 
.const [189] = Utf8 I 
.const [190] = Utf8 RED_HIGHLIGHTING 
.const [191] = Utf8 I 
.const [192] = Utf8 hiddenStatus 
.const [193] = Utf8 Z 
.const [194] = Utf8 Code 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (IILde/audi/atip/hmi/modelaccess/ChoiceModelApp;I)V 
.const [197] = Utf8 getMinDistance 
.const [198] = Utf8 ()I 
.const [199] = Utf8 getMaxDistance 
.const [200] = Utf8 ()I 
.const [201] = Utf8 isDistanceValueInsideRange 
.const [202] = Utf8 (I)Z 
.const [203] = Utf8 getDistanceModel 
.const [204] = Utf8 ()Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [205] = Utf8 isActive 
.const [206] = Utf8 (III)Z 
.const [207] = Utf8 hideSegment 
.const [208] = Utf8 ()V 
.const [209] = Utf8 setDistanceValue 
.const [210] = Utf8 (II)V 
.const [211] = Utf8 setStatus 
.const [212] = Utf8 (III)V 
.const [213] = Utf8 isHiddenStatus 
.const [214] = Utf8 ()Z 
.const [215] = Utf8 setHiddenStatus 
.const [216] = Utf8 (Z)V 
.const [217] = Utf8 toString 
.const [218] = Utf8 ()Ljava/lang/String; 
.end class 
