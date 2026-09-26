.version 50 0 
.class public super [129] 
.super [131] 

.method public annotation [133] : [134] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 5 locals 3 
L0:     aload_0 
L1:     ldc [2] 
L3:     iload_2 
L4:     ldc [3] 
L6:     invokespecial [28] 
L9:     iload_2 
L10:    ifgt L25 
L13:    iconst_4 
L14:    istore 5 
L16:    aload_3 
L17:    iconst_0 
L18:    iconst_4 
L19:    invokevirtual [22] 
L22:    goto L210 
L25:    iload_2 
L26:    bipush 95 
L28:    if_icmpge L49 
L31:    iconst_4 
L32:    istore 5 
L34:    aload_3 
L35:    aload_0 
L36:    iload_2 
L37:    bipush 10 
L39:    invokevirtual [23] 
L42:    iconst_4 
L43:    invokevirtual [22] 
L46:    goto L210 
L49:    iload_2 
L50:    sipush 350 
L53:    if_icmpge L74 
L56:    iconst_4 
L57:    istore 5 
L59:    aload_3 
L60:    aload_0 
L61:    iload_2 
L62:    bipush 50 
L64:    invokevirtual [23] 
L67:    iconst_4 
L68:    invokevirtual [22] 
L71:    goto L210 
L74:    iload_2 
L75:    i2d 
L76:    ldc2_w [32] 
L79:    dcmpg 
L80:    ifge L101 
L83:    iconst_4 
L84:    istore 5 
L86:    aload_3 
L87:    aload_0 
L88:    iload_2 
L89:    bipush 100 
L91:    invokevirtual [23] 
L94:    iconst_4 
L95:    invokevirtual [22] 
L98:    goto L210 
L101:   iload_2 
L102:   i2d 
L103:   ldc2_w [34] 
L106:   dcmpg 
L107:   ifge L170 
L110:   iconst_2 
L111:   istore 5 
L113:   aload_0 
L114:   fload_1 
L115:   invokespecial [29] 
L118:   ldc [4] 
L120:   fmul 
L121:   invokestatic [5] 
L124:   istore 6 
L126:   iload 6 
L128:   i2d 
L129:   ldc2_w [36] 
L132:   ddiv 
L133:   ldc2_w [38] 
L136:   dadd 
L137:   invokestatic [6] 
L140:   ldc2_w [36] 
L143:   dmul 
L144:   d2i 
L145:   istore 6 
L147:   aload_3 
L148:   iload 6 
L150:   bipush 100 
L152:   idiv 
L153:   bipush 7 
L155:   iload 6 
L157:   bipush 100 
L159:   irem 
L160:   bipush 10 
L162:   idiv 
L163:   iconst_1 
L164:   invokevirtual [24] 
L167:   goto L210 
L170:   iconst_2 
L171:   istore 5 
L173:   aload_0 
L174:   fload_1 
L175:   invokespecial [29] 
L178:   ldc [7] 
L180:   fmul 
L181:   invokestatic [5] 
L184:   istore 6 
L186:   iload 6 
L188:   i2d 
L189:   ldc2_w [36] 
L192:   ddiv 
L193:   ldc2_w [38] 
L196:   dadd 
L197:   invokestatic [6] 
L200:   d2i 
L201:   istore 6 
L203:   aload_3 
L204:   iload 6 
L206:   iconst_1 
L207:   invokevirtual [22] 
L210:   iload 5 
L212:   areturn 
L213:   nop 
L214:   nop 
L215:   nop 
L216:   
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [132] .code stack 5 locals 2 
L0:     aload_0 
L1:     ldc [8] 
L3:     iload_1 
L4:     ldc [9] 
L6:     invokespecial [28] 
L9:     iload_1 
L10:    ifgt L24 
L13:    iconst_5 
L14:    istore_3 
L15:    aload_2 
L16:    iconst_0 
L17:    iconst_5 
L18:    invokevirtual [22] 
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
L37:    invokevirtual [23] 
L40:    iconst_5 
L41:    invokevirtual [22] 
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
L61:    invokevirtual [23] 
L64:    iconst_5 
L65:    invokevirtual [22] 
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
L85:    invokevirtual [23] 
L88:    iconst_5 
L89:    invokevirtual [22] 
L92:    goto L182 
L95:    iload_1 
L96:    sipush 9950 
L99:    if_icmpge L149 
L102:   iconst_1 
L103:   istore_3 
L104:   iload_1 
L105:   i2d 
L106:   ldc2_w [40] 
L109:   ddiv 
L110:   ldc2_w [38] 
L113:   dadd 
L114:   invokestatic [6] 
L117:   ldc2_w [40] 
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
L143:   invokevirtual [24] 
L146:   goto L182 
L149:   iconst_1 
L150:   istore_3 
L151:   iload_1 
L152:   i2d 
L153:   ldc2_w [42] 
L156:   ddiv 
L157:   ldc2_w [38] 
L160:   dadd 
L161:   invokestatic [6] 
L164:   ldc2_w [42] 
L167:   dmul 
L168:   d2i 
L169:   istore 4 
L171:   aload_2 
L172:   iload 4 
L174:   sipush 1000 
L177:   idiv 
L178:   iconst_0 
L179:   invokevirtual [22] 
L182:   iload_3 
L183:   areturn 
L184:   
    .end code 
.end method 

.method private [139] : [140] 
    .attribute [132] .code stack 1 locals 0 
L0:     fload_1 
L1:     invokestatic [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [141] : [142] 
    .attribute [132] .code stack 2 locals 1 
L0:     getstatic [11] 
L3:     ifeq L48 
L6:     new [31] 
L9:     dup 
L10:    invokespecial [30] 
L13:    ldc [13] 
L15:    invokevirtual [25] 
L18:    astore 4 
L20:    aload 4 
L22:    aload_1 
L23:    invokevirtual [25] 
L26:    pop 
L27:    aload 4 
L29:    ldc [14] 
L31:    invokevirtual [25] 
L34:    iload_2 
L35:    invokevirtual [26] 
L38:    aload_3 
L39:    invokevirtual [25] 
L42:    pop 
L43:    aload 4 
L45:    invokestatic [15] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [44] 
.const [3] = String [45] 
.const [4] = Int 51266 
.const [5] = Method [46] [47] 
.const [6] = Method [48] [49] 
.const [7] = Int 8257 
.const [8] = String [50] 
.const [9] = String [51] 
.const [10] = Method [52] [53] 
.const [11] = Field [54] [55] 
.const [12] = Class [56] 
.const [13] = String [57] 
.const [14] = String [58] 
.const [15] = Method [59] [60] 
.const [16] = Class [61] 
.const [17] = Class [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Class [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Class [85] 
.const [32] = Double +0x1A200000000000p-42 
.const [34] = Double +0x111A0000000000p-38 
.const [36] = Double +0x14000000000000p-49 
.const [38] = Double +0x10000000000000p-53 
.const [40] = Double +0x19000000000000p-46 
.const [42] = Double +0x1F400000000000p-43 
.const [44] = Utf8 roundImperial 
.const [45] = Utf8 yd 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Utf8 roundMetric 
.const [51] = Utf8 m 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [57] = Utf8 'ZoomRoundingRulesCommon.' 
.const [58] = Utf8 '() distance:' 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommon 
.const [62] = Utf8 de/audi/atip/metrics/RoundingRulesImpl 
.const [63] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [64] = Utf8 java/lang/Math 
.const [65] = Utf8 de/audi/atip/metrics/Distance 
.const [66] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [67] = Class [101] 
.const [68] = NameAndType [102] [103] 
.const [69] = Class [104] 
.const [70] = NameAndType [105] [106] 
.const [71] = Class [107] 
.const [72] = NameAndType [108] [109] 
.const [73] = Class [110] 
.const [74] = NameAndType [111] [112] 
.const [75] = Class [113] 
.const [76] = NameAndType [114] [115] 
.const [77] = Class [116] 
.const [78] = NameAndType [117] [118] 
.const [79] = Class [119] 
.const [80] = NameAndType [120] [121] 
.const [81] = Class [122] 
.const [82] = NameAndType [123] [124] 
.const [83] = Class [125] 
.const [84] = NameAndType [126] [127] 
.const [85] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [86] = Utf8 java/lang/Math 
.const [87] = Utf8 round 
.const [88] = Utf8 (F)I 
.const [89] = Utf8 java/lang/Math 
.const [90] = Utf8 floor 
.const [91] = Utf8 (D)D 
.const [92] = Utf8 de/audi/atip/metrics/Distance 
.const [93] = Utf8 km2miles 
.const [94] = Utf8 (F)F 
.const [95] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [96] = Utf8 LOGGING_ENABLED 
.const [97] = Utf8 Z 
.const [98] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [99] = Utf8 println 
.const [100] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [101] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [102] = Utf8 setValues 
.const [103] = Utf8 (II)V 
.const [104] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommon 
.const [105] = Utf8 roundDistance 
.const [106] = Utf8 (II)I 
.const [107] = Utf8 de/audi/atip/metrics/de/DistanceEntity 
.const [108] = Utf8 setValues 
.const [109] = Utf8 (IIII)V 
.const [110] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [111] = Utf8 append 
.const [112] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [113] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [116] = Utf8 de/audi/atip/metrics/RoundingRulesImpl 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommon 
.const [120] = Utf8 log 
.const [121] = Utf8 (Ljava/lang/String;ILjava/lang/String;)V 
.const [122] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommon 
.const [123] = Utf8 km2miles 
.const [124] = Utf8 (F)F 
.const [125] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/audi/atip/metrics/ZoomRoundingRulesCommon 
.const [129] = Class [128] 
.const [130] = Utf8 de/audi/atip/metrics/RoundingRulesImpl 
.const [131] = Class [130] 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 roundImperial 
.const [136] = Utf8 (FILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [137] = Utf8 roundMetric 
.const [138] = Utf8 (ILde/audi/atip/metrics/de/DistanceEntity;)I 
.const [139] = Utf8 km2miles 
.const [140] = Utf8 (F)F 
.const [141] = Utf8 log 
.const [142] = Utf8 (Ljava/lang/String;ILjava/lang/String;)V 
.end class 
