.version 50 0 
.class public super [151] 
.super [153] 

.method public annotation [155] : [156] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [154] .code stack 5 locals 4 
L0:     aload_0 
L1:     ldc [2] 
L3:     iload_1 
L4:     ldc [3] 
L6:     invokespecial [31] 
L9:     iload_1 
L10:    ifgt L21 
L13:    aload_2 
L14:    iconst_0 
L15:    iconst_5 
L16:    invokevirtual [20] 
L19:    iconst_5 
L20:    areturn 
L21:    iload_1 
L22:    bipush 100 
L24:    if_icmpge L43 
L27:    aload_0 
L28:    iload_1 
L29:    bipush 10 
L31:    invokevirtual [21] 
L34:    istore_3 
L35:    aload_2 
L36:    iload_3 
L37:    iconst_5 
L38:    invokevirtual [20] 
L41:    iconst_5 
L42:    areturn 
L43:    iload_1 
L44:    sipush 975 
L47:    if_icmpge L66 
L50:    aload_0 
L51:    iload_1 
L52:    bipush 50 
L54:    invokevirtual [21] 
L57:    istore_3 
L58:    aload_2 
L59:    iload_3 
L60:    iconst_5 
L61:    invokevirtual [20] 
L64:    iconst_5 
L65:    areturn 
L66:    iload_1 
L67:    sipush 9950 
L70:    if_icmpge L133 
L73:    iload_1 
L74:    i2d 
L75:    ldc2_w [37] 
L78:    ddiv 
L79:    ldc2_w [39] 
L82:    dadd 
L83:    invokestatic [4] 
L86:    ldc2_w [37] 
L89:    dmul 
L90:    d2i 
L91:    istore_3 
L92:    aload_0 
L93:    iload_3 
L94:    bipush 100 
L96:    invokevirtual [22] 
L99:    istore 4 
L101:   iload 4 
L103:   sipush 1000 
L106:   idiv 
L107:   istore 5 
L109:   iload 4 
L111:   sipush 1000 
L114:   irem 
L115:   bipush 100 
L117:   idiv 
L118:   istore 6 
L120:   aload_2 
L121:   iload 5 
L123:   bipush 6 
L125:   iload 6 
L127:   iconst_0 
L128:   invokevirtual [23] 
L131:   iconst_1 
L132:   areturn 
L133:   iload_1 
L134:   i2d 
L135:   ldc2_w [41] 
L138:   ddiv 
L139:   ldc2_w [39] 
L142:   dadd 
L143:   invokestatic [4] 
L146:   ldc2_w [41] 
L149:   dmul 
L150:   d2i 
L151:   istore_3 
L152:   aload_0 
L153:   iload_3 
L154:   sipush 1000 
L157:   invokevirtual [22] 
L160:   istore 4 
L162:   aload_2 
L163:   iload 4 
L165:   sipush 1000 
L168:   idiv 
L169:   iconst_0 
L170:   invokevirtual [20] 
L173:   iconst_1 
L174:   areturn 
L175:   nop 
L176:   
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [154] .code stack 4 locals 1 
L0:     aload_0 
L1:     ldc [5] 
L3:     iload_2 
L4:     ldc [6] 
L6:     invokespecial [31] 
L9:     iload_2 
L10:    iconst_3 
L11:    imul 
L12:    istore 4 
L14:    iload_2 
L15:    ifgt L26 
L18:    aload_3 
L19:    iconst_0 
L20:    iconst_3 
L21:    invokevirtual [20] 
L24:    iconst_3 
L25:    areturn 
L26:    iload 4 
L28:    sipush 1000 
L31:    if_icmpge L49 
L34:    aload_3 
L35:    aload_0 
L36:    iload 4 
L38:    bipush 50 
L40:    invokevirtual [22] 
L43:    iconst_3 
L44:    invokevirtual [20] 
L47:    iconst_3 
L48:    areturn 
L49:    iload 4 
L51:    sipush 1584 
L54:    if_icmpge L72 
L57:    aload_3 
L58:    aload_0 
L59:    iload 4 
L61:    bipush 100 
L63:    invokevirtual [22] 
L66:    iconst_3 
L67:    invokevirtual [20] 
L70:    iconst_3 
L71:    areturn 
L72:    iload 4 
L74:    ldc [7] 
L76:    if_icmpge L86 
L79:    aload_0 
L80:    iload_2 
L81:    aload_3 
L82:    invokespecial [32] 
L85:    areturn 
L86:    aload_0 
L87:    iload_2 
L88:    aload_3 
L89:    invokevirtual [24] 
L92:    areturn 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private [161] : [162] 
    .attribute [154] .code stack 5 locals 3 
L0:     new [35] 
L3:     dup 
L4:     iload_1 
L5:     i2f 
L6:     ldc [9] 
L8:     fdiv 
L9:     f2d 
L10:    invokespecial [33] 
L13:    iconst_1 
L14:    iconst_4 
L15:    invokevirtual [25] 
L18:    astore_3 
L19:    aload_3 
L20:    invokevirtual [26] 
L23:    istore 4 
L25:    aload_3 
L26:    invokevirtual [27] 
L29:    ldc2_w [43] 
L32:    dmul 
L33:    iload 4 
L35:    bipush 10 
L37:    imul 
L38:    i2d 
L39:    dsub 
L40:    d2i 
L41:    istore 5 
L43:    aload_2 
L44:    iload 4 
L46:    bipush 7 
L48:    iload 5 
L50:    iconst_1 
L51:    invokevirtual [23] 
L54:    iconst_2 
L55:    areturn 
L56:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [154] .code stack 2 locals 1 
L0:     getstatic [10] 
L3:     ifeq L48 
L6:     new [36] 
L9:     dup 
L10:    invokespecial [34] 
L13:    ldc [12] 
L15:    invokevirtual [28] 
L18:    astore 4 
L20:    aload 4 
L22:    aload_1 
L23:    invokevirtual [28] 
L26:    pop 
L27:    aload 4 
L29:    ldc [13] 
L31:    invokevirtual [28] 
L34:    iload_2 
L35:    invokevirtual [29] 
L38:    aload_3 
L39:    invokevirtual [28] 
L42:    pop 
L43:    aload 4 
L45:    invokestatic [14] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [45] 
.const [3] = String [46] 
.const [4] = Method [47] [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Int 1087242240 
.const [8] = Class [51] 
.const [9] = Int 56388 
.const [10] = Field [52] [53] 
.const [11] = Class [54] 
.const [12] = String [55] 
.const [13] = String [56] 
.const [14] = Method [57] [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Class [94] 
.const [36] = Class [95] 
.const [37] = Double +0x19000000000000p-46 
.const [39] = Double +0x10000000000000p-53 
.const [41] = Double +0x1F400000000000p-43 
.const [43] = Double +0x14000000000000p-49 
.const [45] = Utf8 roundMetric 
.const [46] = Utf8 m 
.const [47] = Class [96] 
.const [48] = NameAndType [97] [98] 
.const [49] = Utf8 roundImperial 
.const [50] = Utf8 ft 
.const [51] = Utf8 java/math/BigDecimal 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [55] = Utf8 'DistanceRoundingRulesPorsche.' 
.const [56] = Utf8 '() distance:' 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [60] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesPorscheEceRow 
.const [61] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [62] = Utf8 java/lang/Math 
.const [63] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Class [108] 
.const [67] = NameAndType [109] [110] 
.const [68] = Class [111] 
.const [69] = NameAndType [112] [113] 
.const [70] = Class [114] 
.const [71] = NameAndType [115] [116] 
.const [72] = Class [117] 
.const [73] = NameAndType [118] [119] 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Class [126] 
.const [79] = NameAndType [127] [128] 
.const [80] = Class [129] 
.const [81] = NameAndType [130] [131] 
.const [82] = Class [132] 
.const [83] = NameAndType [133] [134] 
.const [84] = Class [135] 
.const [85] = NameAndType [136] [137] 
.const [86] = Class [138] 
.const [87] = NameAndType [139] [140] 
.const [88] = Class [141] 
.const [89] = NameAndType [142] [143] 
.const [90] = Class [144] 
.const [91] = NameAndType [145] [146] 
.const [92] = Class [147] 
.const [93] = NameAndType [148] [149] 
.const [94] = Utf8 java/math/BigDecimal 
.const [95] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [96] = Utf8 java/lang/Math 
.const [97] = Utf8 floor 
.const [98] = Utf8 (D)D 
.const [99] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [100] = Utf8 LOGGING_ENABLED 
.const [101] = Utf8 Z 
.const [102] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [103] = Utf8 println 
.const [104] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [105] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [106] = Utf8 setValues 
.const [107] = Utf8 (II)V 
.const [108] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [109] = Utf8 round 
.const [110] = Utf8 (II)I 
.const [111] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [112] = Utf8 roundDistance 
.const [113] = Utf8 (II)I 
.const [114] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [115] = Utf8 setValues 
.const [116] = Utf8 (IIII)V 
.const [117] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [118] = Utf8 roundBy1Mile 
.const [119] = Utf8 (ILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [120] = Utf8 java/math/BigDecimal 
.const [121] = Utf8 setScale 
.const [122] = Utf8 (II)Ljava/math/BigDecimal; 
.const [123] = Utf8 java/math/BigDecimal 
.const [124] = Utf8 intValue 
.const [125] = Utf8 ()I 
.const [126] = Utf8 java/math/BigDecimal 
.const [127] = Utf8 doubleValue 
.const [128] = Utf8 ()D 
.const [129] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [132] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [133] = Utf8 append 
.const [134] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [135] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesPorscheEceRow 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [139] = Utf8 log 
.const [140] = Utf8 (Ljava/lang/String;ILjava/lang/String;)V 
.const [141] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [142] = Utf8 roundBy0_1Mile 
.const [143] = Utf8 (ILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [144] = Utf8 java/math/BigDecimal 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (D)V 
.const [147] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/audi/atip/metrics/DistanceRoundingRulesPorscheNar 
.const [151] = Class [150] 
.const [152] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesPorscheEceRow 
.const [153] = Class [152] 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 roundMetric 
.const [158] = Utf8 (ILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [159] = Utf8 roundImperial 
.const [160] = Utf8 (FILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [161] = Utf8 roundBy0_1Mile 
.const [162] = Utf8 (ILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [163] = Utf8 log 
.const [164] = Utf8 (Ljava/lang/String;ILjava/lang/String;)V 
.end class 
