.version 50 0 
.class public super [208] 
.super [210] 
.field private static final [211] [212] 
.field private [213] [214] 
.field private volatile [215] [216] 
.field private [217] [218] 
.field private [219] [220] 

.method public [222] : [223] 
    .attribute [221] .code stack 9 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     new [43] 
L8:     dup 
L9:     aload_2 
L10:    iconst_0 
L11:    iconst_1 
L12:    aload_0 
L13:    aload_1 
L14:    getstatic [3] 
L17:    invokespecial [40] 
L20:    putfield [44] 
L23:    aload_0 
L24:    getfield [26] 
L27:    invokevirtual [27] 
L30:    aload_0 
L31:    aload_3 
L32:    putfield [45] 
L35:    aload_0 
L36:    aload 4 
L38:    putfield [46] 
L41:    aload_0 
L42:    aload_3 
L43:    aload_0 
L44:    getfield [29] 
L47:    invokestatic [4] 
L50:    putfield [47] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [221] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     invokevirtual [31] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [221] .code stack 5 locals 0 
L0:     getstatic [3] 
L3:     ldc [5] 
L5:     ldc [6] 
L7:     iload_1 
L8:     i2l 
L9:     invokevirtual [32] 
L12:    pop 
L13:    aload_0 
L14:    aload_0 
L15:    getfield [28] 
L18:    iload_1 
L19:    aload_0 
L20:    getfield [30] 
L23:    aload_0 
L24:    getfield [29] 
L27:    invokestatic [7] 
L30:    putfield [47] 
L33:    aload_0 
L34:    getfield [26] 
L37:    invokevirtual [33] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [228] : [229] 
    .attribute [221] .code stack 8 locals 4 
L0:     new [48] 
L3:     dup 
L4:     invokespecial [41] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [28] 
L12:    invokestatic [9] 
L15:    iconst_1 
L16:    iadd 
L17:    anewarray [10] 
L20:    astore_2 
L21:    aload_2 
L22:    iconst_0 
L23:    new [49] 
L26:    dup 
L27:    iconst_m1 
L28:    aload_1 
L29:    ldc [11] 
L31:    invokevirtual [34] 
L34:    aload_0 
L35:    getfield [30] 
L38:    ldc [12] 
L40:    fmul 
L41:    invokestatic [13] 
L44:    i2f 
L45:    ldc [14] 
L47:    fdiv 
L48:    invokevirtual [35] 
L51:    ldc [15] 
L53:    invokevirtual [34] 
L56:    invokevirtual [36] 
L59:    iconst_0 
L60:    iconst_0 
L61:    invokespecial [42] 
L64:    aastore 
L65:    iconst_0 
L66:    istore_3 
L67:    iload_3 
L68:    aload_0 
L69:    getfield [28] 
L72:    invokestatic [9] 
L75:    if_icmpge L154 
L78:    aload_1 
L79:    invokevirtual [37] 
L82:    aload_0 
L83:    getfield [28] 
L86:    iload_3 
L87:    invokestatic [16] 
L90:    fstore 4 
L92:    aload_2 
L93:    iload_3 
L94:    iconst_1 
L95:    iadd 
L96:    new [49] 
L99:    dup 
L100:   iload_3 
L101:   aload_1 
L102:   fload 4 
L104:   fconst_0 
L105:   fcmpl 
L106:   ifle L114 
L109:   ldc [17] 
L111:   goto L116 
L114:   ldc [18] 
L116:   invokevirtual [34] 
L119:   fload 4 
L121:   ldc [12] 
L123:   fmul 
L124:   invokestatic [13] 
L127:   i2f 
L128:   ldc [14] 
L130:   fdiv 
L131:   invokevirtual [35] 
L134:   ldc [15] 
L136:   invokevirtual [34] 
L139:   invokevirtual [36] 
L142:   iconst_0 
L143:   iconst_0 
L144:   invokespecial [42] 
L147:   aastore 
L148:   iinc 3 1 
L151:   goto L67 
L154:   aload_2 
L155:   areturn 
L156:   
    .end code 
.end method 

.method static [230] : [231] 
    .attribute [221] .code stack 1 locals 0 
L0:     invokestatic [19] 
L3:     putstatic [39] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = Field [51] [52] 
.const [4] = Method [53] [54] 
.const [5] = Int 1078071040 
.const [6] = String [55] 
.const [7] = Method [56] [57] 
.const [8] = Class [58] 
.const [9] = Method [59] [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = Int 31300 
.const [13] = Method [63] [64] 
.const [14] = Int 8257 
.const [15] = String [65] 
.const [16] = Method [66] [67] 
.const [17] = String [68] 
.const [18] = String [69] 
.const [19] = Method [70] [71] 
.const [20] = Class [72] 
.const [21] = Class [73] 
.const [22] = Class [74] 
.const [23] = Class [75] 
.const [24] = Class [76] 
.const [25] = Class [77] 
.const [26] = Field [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Field [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Field [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Class [112] 
.const [44] = Field [113] [114] 
.const [45] = Field [115] [116] 
.const [46] = Field [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = Class [121] 
.const [49] = Class [122] 
.const [50] = Utf8 de/audi/atip/testsupport/handler/TestSupportHandler 
.const [51] = Class [123] 
.const [52] = NameAndType [124] [125] 
.const [53] = Class [126] 
.const [54] = NameAndType [127] [128] 
.const [55] = Utf8 'SDSTestValueHandlerNotification#commandEntrySelected: entryID=%1' 
.const [56] = Class [129] 
.const [57] = NameAndType [130] [131] 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Class [132] 
.const [60] = NameAndType [133] [134] 
.const [61] = Utf8 de/audi/atip/testsupport/TestSupportDataReceiverEntry 
.const [62] = Utf8 'Value: ' 
.const [63] = Class [135] 
.const [64] = NameAndType [136] [137] 
.const [65] = Utf8 '%' 
.const [66] = Class [138] 
.const [67] = NameAndType [139] [140] 
.const [68] = Utf8 '+' 
.const [69] = Utf8 '' 
.const [70] = Class [141] 
.const [71] = NameAndType [142] [143] 
.const [72] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [73] = Utf8 de/audi/app/sdsmanager/testsupport/DefaultTestSupportHandlerNotification 
.const [74] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 java/lang/Math 
.const [77] = Utf8 de/audi/app/sdsmanager/common/Logger 
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
.const [96] = Class [171] 
.const [97] = NameAndType [172] [173] 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Class [192] 
.const [111] = NameAndType [193] [194] 
.const [112] = Utf8 de/audi/atip/testsupport/handler/TestSupportHandler 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [122] = Utf8 de/audi/atip/testsupport/TestSupportDataReceiverEntry 
.const [123] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [124] = Utf8 LC 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [127] = Utf8 getPersistValue 
.const [128] = Utf8 (Ljava/lang/Integer;Lde/audi/app/sdsmanager/apps/SDSAdapter;)F 
.const [129] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [130] = Utf8 addValue 
.const [131] = Utf8 (Ljava/lang/Integer;IFLde/audi/app/sdsmanager/apps/SDSAdapter;)F 
.const [132] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [133] = Utf8 getAdditionValueLength 
.const [134] = Utf8 (Ljava/lang/Integer;)I 
.const [135] = Utf8 java/lang/Math 
.const [136] = Utf8 round 
.const [137] = Utf8 (F)I 
.const [138] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [139] = Utf8 getAdditionValue 
.const [140] = Utf8 (Ljava/lang/Integer;I)F 
.const [141] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [142] = Utf8 getMainLog 
.const [143] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [144] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [145] = Utf8 testSupportHandler 
.const [146] = Utf8 Lde/audi/atip/testsupport/handler/TestSupportHandler; 
.const [147] = Utf8 de/audi/atip/testsupport/handler/TestSupportHandler 
.const [148] = Utf8 init 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [151] = Utf8 valueType 
.const [152] = Utf8 Ljava/lang/Integer; 
.const [153] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [154] = Utf8 sdsAdapter 
.const [155] = Utf8 Lde/audi/app/sdsmanager/apps/SDSAdapter; 
.const [156] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [157] = Utf8 value 
.const [158] = Utf8 F 
.const [159] = Utf8 de/audi/atip/testsupport/handler/TestSupportHandler 
.const [160] = Utf8 deinit 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;J)Z 
.const [165] = Utf8 de/audi/atip/testsupport/handler/TestSupportHandler 
.const [166] = Utf8 updateCommandList 
.const [167] = Utf8 ()V 
.const [168] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [169] = Utf8 append 
.const [170] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [171] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [172] = Utf8 append 
.const [173] = Utf8 (F)Lde/esolutions/fw/util/commons/Buffer; 
.const [174] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [175] = Utf8 toString 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [178] = Utf8 clear 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/audi/app/sdsmanager/testsupport/DefaultTestSupportHandlerNotification 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [184] = Utf8 LC 
.const [185] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [186] = Utf8 de/audi/atip/testsupport/handler/TestSupportHandler 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (Ljava/lang/String;ZZLde/audi/atip/testsupport/handler/ITestSupportHandlerNotification;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [189] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [190] = Utf8 <init> 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/atip/testsupport/TestSupportDataReceiverEntry 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (ILjava/lang/String;ZZ)V 
.const [195] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [196] = Utf8 testSupportHandler 
.const [197] = Utf8 Lde/audi/atip/testsupport/handler/TestSupportHandler; 
.const [198] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [199] = Utf8 valueType 
.const [200] = Utf8 Ljava/lang/Integer; 
.const [201] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [202] = Utf8 sdsAdapter 
.const [203] = Utf8 Lde/audi/app/sdsmanager/apps/SDSAdapter; 
.const [204] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [205] = Utf8 value 
.const [206] = Utf8 F 
.const [207] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEntryGapHandlerNotification 
.const [208] = Class [207] 
.const [209] = Utf8 de/audi/app/sdsmanager/testsupport/DefaultTestSupportHandlerNotification 
.const [210] = Class [209] 
.const [211] = Utf8 LC 
.const [212] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [213] = Utf8 testSupportHandler 
.const [214] = Utf8 Lde/audi/atip/testsupport/handler/TestSupportHandler; 
.const [215] = Utf8 value 
.const [216] = Utf8 F 
.const [217] = Utf8 valueType 
.const [218] = Utf8 Ljava/lang/Integer; 
.const [219] = Utf8 sdsAdapter 
.const [220] = Utf8 Lde/audi/app/sdsmanager/apps/SDSAdapter; 
.const [221] = Utf8 Code 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Ljava/lang/Integer;Lde/audi/app/sdsmanager/apps/SDSAdapter;)V 
.const [224] = Utf8 deinit 
.const [225] = Utf8 ()V 
.const [226] = Utf8 commandEntrySelected 
.const [227] = Utf8 (I)V 
.const [228] = Utf8 getCommandEntries 
.const [229] = Utf8 ()[Lde/audi/atip/testsupport/TestSupportDataReceiverEntry; 
.const [230] = Utf8 <clinit> 
.const [231] = Utf8 ()V 
.end class 
