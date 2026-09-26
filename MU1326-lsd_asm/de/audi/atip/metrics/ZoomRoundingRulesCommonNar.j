.version 50 0 
.class public super [141] 
.super [143] 

.method public annotation [145] : [146] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 5 locals 2 
L0:     aload_0 
L1:     ldc [2] 
L3:     iload_1 
L4:     ldc [3] 
L6:     invokespecial [32] 
L9:     iload_1 
L10:    ifgt L24 
L13:    iconst_5 
L14:    istore_3 
L15:    aload_2 
L16:    iconst_0 
L17:    iconst_5 
L18:    invokevirtual [26] 
L21:    goto L182 
L24:    iload_1 
L25:    bipush 95 
L27:    if_icmpge L47 
L30:    iconst_5 
L31:    istore_3 
L32:    aload_2 
L33:    aload_0 
L34:    iload_1 
L35:    bipush 10 
L37:    invokevirtual [27] 
L40:    iconst_5 
L41:    invokevirtual [26] 
L44:    goto L182 
L47:    iload_1 
L48:    sipush 400 
L51:    if_icmpge L71 
L54:    iconst_5 
L55:    istore_3 
L56:    aload_2 
L57:    aload_0 
L58:    iload_1 
L59:    bipush 50 
L61:    invokevirtual [27] 
L64:    iconst_5 
L65:    invokevirtual [26] 
L68:    goto L182 
L71:    iload_1 
L72:    sipush 950 
L75:    if_icmpge L95 
L78:    iconst_5 
L79:    istore_3 
L80:    aload_2 
L81:    aload_0 
L82:    iload_1 
L83:    bipush 100 
L85:    invokevirtual [27] 
L88:    iconst_5 
L89:    invokevirtual [26] 
L92:    goto L182 
L95:    iload_1 
L96:    sipush 9950 
L99:    if_icmpge L149 
L102:   iconst_1 
L103:   istore_3 
L104:   iload_1 
L105:   i2d 
L106:   ldc2_w [38] 
L109:   ddiv 
L110:   ldc2_w [40] 
L113:   dadd 
L114:   invokestatic [4] 
L117:   ldc2_w [38] 
L120:   dmul 
L121:   d2i 
L122:   istore 4 
L124:   aload_2 
L125:   iload 4 
L127:   sipush 1000 
L130:   idiv 
L131:   bipush 6 
L133:   iload 4 
L135:   sipush 1000 
L138:   irem 
L139:   bipush 100 
L141:   idiv 
L142:   iconst_0 
L143:   invokevirtual [28] 
L146:   goto L182 
L149:   iconst_1 
L150:   istore_3 
L151:   iload_1 
L152:   i2d 
L153:   ldc2_w [42] 
L156:   ddiv 
L157:   ldc2_w [40] 
L160:   dadd 
L161:   invokestatic [4] 
L164:   ldc2_w [42] 
L167:   dmul 
L168:   d2i 
L169:   istore 4 
L171:   aload_2 
L172:   iload 4 
L174:   sipush 1000 
L177:   idiv 
L178:   iconst_0 
L179:   invokevirtual [26] 
L182:   iload_3 
L183:   areturn 
L184:   
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 4 locals 3 
L0:     aload_0 
L1:     ldc [5] 
L3:     iload_2 
L4:     ldc [6] 
L6:     invokespecial [32] 
L9:     aload_0 
L10:    fload_1 
L11:    invokespecial [33] 
L14:    fstore 4 
L16:    iload_2 
L17:    ifgt L32 
L20:    iconst_3 
L21:    istore 5 
L23:    aload_3 
L24:    iconst_0 
L25:    iconst_3 
L26:    invokevirtual [26] 
L29:    goto L137 
L32:    fload 4 
L34:    ldc [7] 
L36:    fcmpg 
L37:    ifge L60 
L40:    iconst_3 
L41:    istore 5 
L43:    aload_3 
L44:    aload_0 
L45:    iload_2 
L46:    iconst_3 
L47:    imul 
L48:    bipush 100 
L50:    invokevirtual [27] 
L53:    iconst_3 
L54:    invokevirtual [26] 
L57:    goto L137 
L60:    fload 4 
L62:    ldc [8] 
L64:    fcmpg 
L65:    ifge L80 
L68:    aload_0 
L69:    fload 4 
L71:    aload_3 
L72:    invokespecial [34] 
L75:    istore 5 
L77:    goto L137 
L80:    fload 4 
L82:    ldc [9] 
L84:    fcmpg 
L85:    ifge L100 
L88:    aload_0 
L89:    fload 4 
L91:    aload_3 
L92:    invokespecial [35] 
L95:    istore 5 
L97:    goto L137 
L100:   iconst_2 
L101:   istore 5 
L103:   fload 4 
L105:   ldc [10] 
L107:   fmul 
L108:   invokestatic [11] 
L111:   istore 6 
L113:   iload 6 
L115:   i2d 
L116:   ldc2_w [44] 
L119:   ddiv 
L120:   ldc2_w [40] 
L123:   dadd 
L124:   invokestatic [4] 
L127:   d2i 
L128:   istore 6 
L130:   aload_3 
L131:   iload 6 
L133:   iconst_1 
L134:   invokevirtual [26] 
L137:   iload 5 
L139:   areturn 
L140:   
    .end code 
.end method 

.method private [151] : [152] 
    .attribute [144] .code stack 1 locals 0 
L0:     fload_1 
L1:     invokestatic [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [153] : [154] 
    .attribute [144] .code stack 5 locals 4 
L0:     fload_1 
L1:     ldc [13] 
L3:     fmul 
L4:     invokestatic [11] 
L7:     i2f 
L8:     ldc [13] 
L10:    fdiv 
L11:    fstore_3 
L12:    fload_3 
L13:    f2d 
L14:    invokestatic [4] 
L17:    d2i 
L18:    istore 4 
L20:    fload_3 
L21:    iload 4 
L23:    i2f 
L24:    fsub 
L25:    ldc [14] 
L27:    fmul 
L28:    invokestatic [11] 
L31:    istore 5 
L33:    iload 5 
L35:    ifne L42 
L38:    iconst_m1 
L39:    goto L44 
L42:    bipush 7 
L44:    istore 6 
L46:    aload_2 
L47:    iload 4 
L49:    iload 6 
L51:    iload 5 
L53:    iconst_1 
L54:    invokevirtual [28] 
L57:    iconst_2 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [155] : [156] 
    .attribute [144] .code stack 5 locals 4 
L0:     fload_1 
L1:     fconst_2 
L2:     fmul 
L3:     invokestatic [11] 
L6:     i2f 
L7:     fconst_2 
L8:     fdiv 
L9:     fstore_3 
L10:    fload_3 
L11:    f2d 
L12:    invokestatic [4] 
L15:    d2i 
L16:    istore 4 
L18:    fload_3 
L19:    iload 4 
L21:    i2f 
L22:    fsub 
L23:    ldc [14] 
L25:    fmul 
L26:    invokestatic [11] 
L29:    istore 5 
L31:    iload 5 
L33:    ifne L40 
L36:    iconst_m1 
L37:    goto L42 
L40:    bipush 7 
L42:    istore 6 
L44:    aload_2 
L45:    iload 4 
L47:    iload 6 
L49:    iload 5 
L51:    iconst_1 
L52:    invokevirtual [28] 
L55:    iconst_2 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [157] : [158] 
    .attribute [144] .code stack 2 locals 1 
L0:     getstatic [15] 
L3:     ifeq L48 
L6:     new [37] 
L9:     dup 
L10:    invokespecial [36] 
L13:    ldc [17] 
L15:    invokevirtual [29] 
L18:    astore 4 
L20:    aload 4 
L22:    aload_1 
L23:    invokevirtual [29] 
L26:    pop 
L27:    aload 4 
L29:    ldc [18] 
L31:    invokevirtual [29] 
L34:    iload_2 
L35:    invokevirtual [30] 
L38:    aload_3 
L39:    invokevirtual [29] 
L42:    pop 
L43:    aload 4 
L45:    invokestatic [19] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [46] 
.const [3] = String [47] 
.const [4] = Method [48] [49] 
.const [5] = String [50] 
.const [6] = String [51] 
.const [7] = Int 32830 
.const [8] = Int 859009855 
.const [9] = Int -842253248 
.const [10] = Int 8257 
.const [11] = Method [52] [53] 
.const [12] = Method [54] [55] 
.const [13] = Int 32832 
.const [14] = Int 51266 
.const [15] = Field [56] [57] 
.const [16] = Class [58] 
.const [17] = String [59] 
.const [18] = String [60] 
.const [19] = Method [61] [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Class [65] 
.const [23] = Class [66] 
.const [24] = Class [67] 
.const [25] = Class [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Method [79] [80] 
.const [32] = Method [81] [82] 
.const [33] = Method [83] [84] 
.const [34] = Method [85] [86] 
.const [35] = Method [87] [88] 
.const [36] = Method [89] [90] 
.const [37] = Class [91] 
.const [38] = Double +0x19000000000000p-46 
.const [40] = Double +0x10000000000000p-53 
.const [42] = Double +0x1F400000000000p-43 
.const [44] = Double +0x14000000000000p-49 
.const [46] = Utf8 roundMetric 
.const [47] = Utf8 m 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Utf8 roundImperial 
.const [51] = Utf8 yd 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Utf8 'ZoomRoundingRulesCommonNar.' 
.const [60] = Utf8 '() distance:' 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [64] = Utf8 de/audi/atip/metrics/RoundingRulesImpl 
.const [65] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [66] = Utf8 java/lang/Math 
.const [67] = Utf8 de/audi/atip/metrics/Distance 
.const [68] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [69] = Class [107] 
.const [70] = NameAndType [108] [109] 
.const [71] = Class [110] 
.const [72] = NameAndType [111] [112] 
.const [73] = Class [113] 
.const [74] = NameAndType [114] [115] 
.const [75] = Class [116] 
.const [76] = NameAndType [117] [118] 
.const [77] = Class [119] 
.const [78] = NameAndType [120] [121] 
.const [79] = Class [122] 
.const [80] = NameAndType [123] [124] 
.const [81] = Class [125] 
.const [82] = NameAndType [126] [127] 
.const [83] = Class [128] 
.const [84] = NameAndType [129] [130] 
.const [85] = Class [131] 
.const [86] = NameAndType [132] [133] 
.const [87] = Class [134] 
.const [88] = NameAndType [135] [136] 
.const [89] = Class [137] 
.const [90] = NameAndType [138] [139] 
.const [91] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [92] = Utf8 java/lang/Math 
.const [93] = Utf8 floor 
.const [94] = Utf8 (D)D 
.const [95] = Utf8 java/lang/Math 
.const [96] = Utf8 round 
.const [97] = Utf8 (F)I 
.const [98] = Utf8 de/audi/atip/metrics/Distance 
.const [99] = Utf8 km2miles 
.const [100] = Utf8 (F)F 
.const [101] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [102] = Utf8 LOGGING_ENABLED 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [105] = Utf8 println 
.const [106] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [107] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [108] = Utf8 setValues 
.const [109] = Utf8 (II)V 
.const [110] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [111] = Utf8 roundDistance 
.const [112] = Utf8 (II)I 
.const [113] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [114] = Utf8 setValues 
.const [115] = Utf8 (IIII)V 
.const [116] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [117] = Utf8 append 
.const [118] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [119] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [120] = Utf8 append 
.const [121] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [122] = Utf8 de/audi/atip/metrics/RoundingRulesImpl 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [126] = Utf8 log 
.const [127] = Utf8 (Ljava/lang/String;ILjava/lang/String;)V 
.const [128] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [129] = Utf8 km2miles 
.const [130] = Utf8 (F)F 
.const [131] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [132] = Utf8 roundMilesTo1_4 
.const [133] = Utf8 (FLde/audi/atip/metrics/de/DistanceEntity;)I 
.const [134] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [135] = Utf8 roundMilesTo1_2 
.const [136] = Utf8 (FLde/audi/atip/metrics/de/DistanceEntity;)I 
.const [137] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommonNar 
.const [141] = Class [140] 
.const [142] = Utf8 de/audi/atip/metrics/RoundingRulesImpl 
.const [143] = Class [142] 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 roundMetric 
.const [148] = Utf8 (ILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [149] = Utf8 roundImperial 
.const [150] = Utf8 (FILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [151] = Utf8 km2miles 
.const [152] = Utf8 (F)F 
.const [153] = Utf8 roundMilesTo1_4 
.const [154] = Utf8 (FLde/audi/atip/metrics/de/DistanceEntity;)I 
.const [155] = Utf8 roundMilesTo1_2 
.const [156] = Utf8 (FLde/audi/atip/metrics/de/DistanceEntity;)I 
.const [157] = Utf8 log 
.const [158] = Utf8 (Ljava/lang/String;ILjava/lang/String;)V 
.end class 
