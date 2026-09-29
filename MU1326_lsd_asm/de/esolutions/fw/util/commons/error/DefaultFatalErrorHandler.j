.version 50 0 
.class public final super [240] 
.super [242] 
.implements [244] 
.field private final [245] [246] 
.field private final [247] [248] 
.field private final [249] [250] 
.field private [251] [252] 

.method public [254] : [255] 
    .attribute [253] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [52] 
L9:     aload_0 
L10:    new [53] 
L13:    dup 
L14:    invokespecial [49] 
L17:    putfield [54] 
L20:    aload_0 
L21:    invokestatic [3] 
L24:    putfield [55] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [253] .code stack 2 locals 1 
L0:     new [56] 
L3:     dup 
L4:     invokespecial [50] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [32] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [29] 
L20:    invokevirtual [33] 
L23:    pop 
L24:    aload_1 
L25:    ldc [6] 
L27:    invokevirtual [32] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [30] 
L36:    invokevirtual [34] 
L39:    invokevirtual [33] 
L42:    pop 
L43:    aload_1 
L44:    ldc [7] 
L46:    invokevirtual [32] 
L49:    pop 
L50:    aload_1 
L51:    invokevirtual [35] 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public final [258] : [259] 
    .attribute [253] .code stack 4 locals 6 
L0:     aload_0 
L1:     dup 
L2:     getfield [36] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [57] 
L10:    aload_0 
L11:    getfield [36] 
L14:    iconst_1 
L15:    if_icmpne L259 
L18:    getstatic [8] 
L21:    ldc [9] 
L23:    invokevirtual [37] 
L26:    aload_0 
L27:    getfield [31] 
L30:    invokevirtual [38] 
L33:    lstore_3 
L34:    lload_3 
L35:    ldc_w [1] 
L38:    ldiv 
L39:    l2i 
L40:    istore 5 
L42:    iload 5 
L44:    sipush 256 
L47:    if_icmple L181 
L50:    invokestatic [10] 
L53:    astore 6 
L55:    invokestatic [11] 
L58:    lstore 7 
L60:    getstatic [8] 
L63:    ldc [12] 
L65:    invokevirtual [39] 
L68:    getstatic [8] 
L71:    lload 7 
L73:    invokevirtual [40] 
L76:    getstatic [8] 
L79:    invokevirtual [41] 
L82:    aload 6 
L84:    ifnull L112 
L87:    getstatic [8] 
L90:    ldc [13] 
L92:    invokevirtual [39] 
L95:    getstatic [8] 
L98:    aload 6 
L100:   invokevirtual [42] 
L103:   invokevirtual [39] 
L106:   getstatic [8] 
L109:   invokevirtual [41] 
L112:   aload_1 
L113:   ifnull L147 
L116:   getstatic [8] 
L119:   ldc [14] 
L121:   invokevirtual [39] 
L124:   getstatic [8] 
L127:   aload_1 
L128:   invokespecial [51] 
L131:   invokevirtual [43] 
L134:   invokevirtual [39] 
L137:   getstatic [8] 
L140:   invokevirtual [41] 
L143:   aload_1 
L144:   invokevirtual [44] 
L147:   aload_2 
L148:   ifnull L172 
L151:   getstatic [8] 
L154:   ldc [15] 
L156:   invokevirtual [39] 
L159:   getstatic [8] 
L162:   aload_2 
L163:   invokevirtual [39] 
L166:   getstatic [8] 
L169:   invokevirtual [41] 
L172:   getstatic [8] 
L175:   invokevirtual [45] 
L178:   goto L208 
L181:   getstatic [8] 
L184:   ldc [16] 
L186:   invokevirtual [37] 
L189:   aload_2 
L190:   ifnull L200 
L193:   getstatic [8] 
L196:   aload_2 
L197:   invokevirtual [37] 
L200:   aload_1 
L201:   ifnull L208 
L204:   aload_1 
L205:   invokevirtual [44] 
L208:   aload_0 
L209:   getfield [29] 
L212:   ifeq L248 
L215:   getstatic [8] 
L218:   ldc [17] 
L220:   invokevirtual [37] 
L223:   aload_0 
L224:   getfield [30] 
L227:   invokevirtual [46] 
L230:   istore 6 
L232:   iload 6 
L234:   ifne L245 
L237:   getstatic [8] 
L240:   ldc [18] 
L242:   invokevirtual [37] 
L245:   goto L256 
L248:   getstatic [8] 
L251:   ldc [19] 
L253:   invokevirtual [37] 
L256:   goto L282 
L259:   getstatic [8] 
L262:   ldc [20] 
L264:   invokevirtual [37] 
L267:   aload_0 
L268:   getfield [29] 
L271:   ifeq L282 
L274:   aload_0 
L275:   getfield [30] 
L278:   invokevirtual [47] 
L281:   pop 
L282:   return 
L283:   nop 
L284:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [59] 
.const [3] = Method [60] [61] 
.const [4] = Class [62] 
.const [5] = String [63] 
.const [6] = String [64] 
.const [7] = String [65] 
.const [8] = Field [66] [67] 
.const [9] = String [68] 
.const [10] = Method [69] [70] 
.const [11] = Method [71] [72] 
.const [12] = String [73] 
.const [13] = String [74] 
.const [14] = String [75] 
.const [15] = String [76] 
.const [16] = String [77] 
.const [17] = String [78] 
.const [18] = String [79] 
.const [19] = String [80] 
.const [20] = String [81] 
.const [21] = Class [82] 
.const [22] = Class [83] 
.const [23] = Class [84] 
.const [24] = Class [85] 
.const [25] = Class [86] 
.const [26] = Class [87] 
.const [27] = Class [88] 
.const [28] = Class [89] 
.const [29] = Field [90] [91] 
.const [30] = Field [92] [93] 
.const [31] = Field [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Method [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Method [124] [125] 
.const [47] = Method [126] [127] 
.const [48] = Method [128] [129] 
.const [49] = Method [130] [131] 
.const [50] = Method [132] [133] 
.const [51] = Method [134] [135] 
.const [52] = Field [136] [137] 
.const [53] = Class [138] 
.const [54] = Field [139] [140] 
.const [55] = Field [141] [142] 
.const [56] = Class [143] 
.const [57] = Field [144] [145] 
.const [58] = Int 262144 
.const [59] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [60] = Class [146] 
.const [61] = NameAndType [147] [148] 
.const [62] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [63] = Utf8 '[Default:killOnError=' 
.const [64] = Utf8 ',slayer=' 
.const [65] = Utf8 ']' 
.const [66] = Class [149] 
.const [67] = NameAndType [150] [151] 
.const [68] = Utf8 '==========> Java/FW detected FATAL ERROR <==========' 
.const [69] = Class [152] 
.const [70] = NameAndType [153] [154] 
.const [71] = Class [155] 
.const [72] = NameAndType [156] [157] 
.const [73] = Utf8 'When: ' 
.const [74] = Utf8 'Thread: ' 
.const [75] = Utf8 'Error: ' 
.const [76] = Utf8 'Reason: ' 
.const [77] = Utf8 'LOW MEM: ' 
.const [78] = Utf8 '==========> Java/FW is killing VM <==========' 
.const [79] = Utf8 'ARGH! SLAYER FAILED...' 
.const [80] = Utf8 '==========> Java/FW is NOT killing VM <==========' 
.const [81] = Utf8 '==========> Java/FW detected cont. FATAL ERROR <==========' 
.const [82] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 java/lang/Runtime 
.const [85] = Utf8 java/lang/System 
.const [86] = Utf8 java/io/PrintStream 
.const [87] = Utf8 java/lang/Thread 
.const [88] = Utf8 java/lang/Class 
.const [89] = Utf8 java/lang/Throwable 
.const [90] = Class [158] 
.const [91] = NameAndType [159] [160] 
.const [92] = Class [161] 
.const [93] = NameAndType [162] [163] 
.const [94] = Class [164] 
.const [95] = NameAndType [165] [166] 
.const [96] = Class [167] 
.const [97] = NameAndType [168] [169] 
.const [98] = Class [170] 
.const [99] = NameAndType [171] [172] 
.const [100] = Class [173] 
.const [101] = NameAndType [174] [175] 
.const [102] = Class [176] 
.const [103] = NameAndType [177] [178] 
.const [104] = Class [179] 
.const [105] = NameAndType [180] [181] 
.const [106] = Class [182] 
.const [107] = NameAndType [183] [184] 
.const [108] = Class [185] 
.const [109] = NameAndType [186] [187] 
.const [110] = Class [188] 
.const [111] = NameAndType [189] [190] 
.const [112] = Class [191] 
.const [113] = NameAndType [192] [193] 
.const [114] = Class [194] 
.const [115] = NameAndType [195] [196] 
.const [116] = Class [197] 
.const [117] = NameAndType [198] [199] 
.const [118] = Class [200] 
.const [119] = NameAndType [201] [202] 
.const [120] = Class [203] 
.const [121] = NameAndType [204] [205] 
.const [122] = Class [206] 
.const [123] = NameAndType [207] [208] 
.const [124] = Class [209] 
.const [125] = NameAndType [210] [211] 
.const [126] = Class [212] 
.const [127] = NameAndType [213] [214] 
.const [128] = Class [215] 
.const [129] = NameAndType [216] [217] 
.const [130] = Class [218] 
.const [131] = NameAndType [219] [220] 
.const [132] = Class [221] 
.const [133] = NameAndType [222] [223] 
.const [134] = Class [224] 
.const [135] = NameAndType [225] [226] 
.const [136] = Class [227] 
.const [137] = NameAndType [228] [229] 
.const [138] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [139] = Class [230] 
.const [140] = NameAndType [231] [232] 
.const [141] = Class [233] 
.const [142] = NameAndType [234] [235] 
.const [143] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [144] = Class [236] 
.const [145] = NameAndType [237] [238] 
.const [146] = Utf8 java/lang/Runtime 
.const [147] = Utf8 getRuntime 
.const [148] = Utf8 ()Ljava/lang/Runtime; 
.const [149] = Utf8 java/lang/System 
.const [150] = Utf8 out 
.const [151] = Utf8 Ljava/io/PrintStream; 
.const [152] = Utf8 java/lang/Thread 
.const [153] = Utf8 currentThread 
.const [154] = Utf8 ()Ljava/lang/Thread; 
.const [155] = Utf8 java/lang/System 
.const [156] = Utf8 currentTimeMillis 
.const [157] = Utf8 ()J 
.const [158] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [159] = Utf8 killOnError 
.const [160] = Utf8 Z 
.const [161] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [162] = Utf8 slayer 
.const [163] = Utf8 Lde/esolutions/fw/util/commons/os/Slayer; 
.const [164] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [165] = Utf8 runtime 
.const [166] = Utf8 Ljava/lang/Runtime; 
.const [167] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [168] = Utf8 append 
.const [169] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [170] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [171] = Utf8 append 
.const [172] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [173] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [174] = Utf8 haveKillMethod 
.const [175] = Utf8 ()Z 
.const [176] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [180] = Utf8 count 
.const [181] = Utf8 I 
.const [182] = Utf8 java/io/PrintStream 
.const [183] = Utf8 println 
.const [184] = Utf8 (Ljava/lang/String;)V 
.const [185] = Utf8 java/lang/Runtime 
.const [186] = Utf8 freeMemory 
.const [187] = Utf8 ()J 
.const [188] = Utf8 java/io/PrintStream 
.const [189] = Utf8 print 
.const [190] = Utf8 (Ljava/lang/String;)V 
.const [191] = Utf8 java/io/PrintStream 
.const [192] = Utf8 print 
.const [193] = Utf8 (J)V 
.const [194] = Utf8 java/io/PrintStream 
.const [195] = Utf8 println 
.const [196] = Utf8 ()V 
.const [197] = Utf8 java/lang/Thread 
.const [198] = Utf8 getName 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 java/lang/Class 
.const [201] = Utf8 getName 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 java/lang/Throwable 
.const [204] = Utf8 printStackTrace 
.const [205] = Utf8 ()V 
.const [206] = Utf8 java/io/PrintStream 
.const [207] = Utf8 flush 
.const [208] = Utf8 ()V 
.const [209] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [210] = Utf8 suicide 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [213] = Utf8 silentSuicide 
.const [214] = Utf8 ()Z 
.const [215] = Utf8 java/lang/Object 
.const [216] = Utf8 <init> 
.const [217] = Utf8 ()V 
.const [218] = Utf8 de/esolutions/fw/util/commons/os/Slayer 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [222] = Utf8 <init> 
.const [223] = Utf8 ()V 
.const [224] = Utf8 java/lang/Object 
.const [225] = Utf8 getClass 
.const [226] = Utf8 ()Ljava/lang/Class; 
.const [227] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [228] = Utf8 killOnError 
.const [229] = Utf8 Z 
.const [230] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [231] = Utf8 slayer 
.const [232] = Utf8 Lde/esolutions/fw/util/commons/os/Slayer; 
.const [233] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [234] = Utf8 runtime 
.const [235] = Utf8 Ljava/lang/Runtime; 
.const [236] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [237] = Utf8 count 
.const [238] = Utf8 I 
.const [239] = Utf8 de/esolutions/fw/util/commons/error/DefaultFatalErrorHandler 
.const [240] = Class [239] 
.const [241] = Utf8 java/lang/Object 
.const [242] = Class [241] 
.const [243] = Utf8 de/esolutions/fw/util/commons/error/IFatalErrorHandler 
.const [244] = Class [243] 
.const [245] = Utf8 killOnError 
.const [246] = Utf8 Z 
.const [247] = Utf8 slayer 
.const [248] = Utf8 Lde/esolutions/fw/util/commons/os/Slayer; 
.const [249] = Utf8 runtime 
.const [250] = Utf8 Ljava/lang/Runtime; 
.const [251] = Utf8 count 
.const [252] = Utf8 I 
.const [253] = Utf8 Code 
.const [254] = Utf8 <init> 
.const [255] = Utf8 (Z)V 
.const [256] = Utf8 toString 
.const [257] = Utf8 ()Ljava/lang/String; 
.const [258] = Utf8 handleFatalError 
.const [259] = Utf8 (Ljava/lang/Throwable;Ljava/lang/String;)V 
.end class 
