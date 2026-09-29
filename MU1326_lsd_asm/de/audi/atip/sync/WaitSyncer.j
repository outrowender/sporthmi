.version 50 0 
.class public super [221] 
.super [223] 
.implements [225] 
.field private final [226] [227] 
.field private final [228] [229] 
.field private final [230] [231] 
.field private final [232] [233] 
.field private final [234] [235] 
.field private [236] [237] 
.field private [238] [239] 
.field private [240] [241] 

.method public [243] : [244] 
    .attribute [242] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     new [45] 
L8:     dup 
L9:     invokespecial [40] 
L12:    putfield [46] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [47] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [48] 
L25:    aload_0 
L26:    lload_3 
L27:    lconst_0 
L28:    lcmp 
L29:    ifgt L36 
L32:    lconst_1 
L33:    goto L37 
L36:    lload_3 
L37:    putfield [49] 
L40:    aload_0 
L41:    aload 5 
L43:    putfield [50] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [242] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [27] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L14 using L17 
L7:     aload_0 
L8:     getfield [32] 
L11:    istore_1 
L12:    aload_2 
L13:    monitorexit 
L14:    goto L22 
        .catch [0] from L17 to L20 using L17 
L17:    astore_3 
L18:    aload_2 
L19:    monitorexit 
L20:    aload_3 
L21:    athrow 
L22:    iload_1 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [242] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [27] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L14 using L17 
L7:     aload_0 
L8:     getfield [33] 
L11:    istore_1 
L12:    aload_2 
L13:    monitorexit 
L14:    goto L22 
        .catch [0] from L17 to L20 using L17 
L17:    astore_3 
L18:    aload_2 
L19:    monitorexit 
L20:    aload_3 
L21:    athrow 
L22:    iload_1 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [242] .code stack 5 locals 7 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [29] 
L12:    invokevirtual [34] 
L15:    pop 
L16:    aload_0 
L17:    getfield [27] 
L20:    dup 
L21:    astore_1 
L22:    monitorenter 
L23:    aload_0 
L24:    getfield [33] 
L27:    ifne L240 
L30:    aload_0 
L31:    iconst_1 
L32:    putfield [52] 
L35:    aload_0 
L36:    invokespecial [41] 
L39:    lstore_2 
L40:    aload_0 
L41:    getfield [32] 
L44:    ifne L74 
L47:    aload_0 
L48:    getfield [35] 
L51:    ifne L74 
        .catch [5] from L54 to L65 using L68 
        .catch [0] from L23 to L258 using L261 
L54:    aload_0 
L55:    getfield [27] 
L58:    aload_0 
L59:    getfield [30] 
L62:    invokespecial [42] 
L65:    goto L74 
L68:    astore 4 
L70:    invokestatic [6] 
L73:    pop 
L74:    aload_0 
L75:    invokespecial [41] 
L78:    lload_2 
L79:    lsub 
L80:    lstore 4 
L82:    new [54] 
L85:    dup 
L86:    invokespecial [43] 
L89:    astore 6 
L91:    aload_0 
L92:    getfield [32] 
L95:    ifeq L125 
L98:    aload 6 
L100:   ldc [8] 
L102:   invokevirtual [36] 
L105:   pop 
L106:   aload 6 
L108:   lload 4 
L110:   invokevirtual [37] 
L113:   pop 
L114:   aload 6 
L116:   ldc [9] 
L118:   invokevirtual [36] 
L121:   pop 
L122:   goto L220 
L125:   aload_0 
L126:   getfield [35] 
L129:   ifeq L159 
L132:   aload 6 
L134:   ldc [10] 
L136:   invokevirtual [36] 
L139:   pop 
L140:   aload 6 
L142:   lload 4 
L144:   invokevirtual [37] 
L147:   pop 
L148:   aload 6 
L150:   ldc [9] 
L152:   invokevirtual [36] 
L155:   pop 
L156:   goto L220 
L159:   lload 4 
L161:   aload_0 
L162:   getfield [30] 
L165:   lcmp 
L166:   iflt L196 
L169:   aload 6 
L171:   ldc [11] 
L173:   invokevirtual [36] 
L176:   pop 
L177:   aload 6 
L179:   lload 4 
L181:   invokevirtual [37] 
L184:   pop 
L185:   aload 6 
L187:   ldc [9] 
L189:   invokevirtual [36] 
L192:   pop 
L193:   goto L220 
L196:   aload 6 
L198:   ldc [12] 
L200:   invokevirtual [36] 
L203:   pop 
L204:   aload 6 
L206:   lload 4 
L208:   invokevirtual [37] 
L211:   pop 
L212:   aload 6 
L214:   ldc [9] 
L216:   invokevirtual [36] 
L219:   pop 
L220:   aload_0 
L221:   getfield [31] 
L224:   ldc [3] 
L226:   ldc [13] 
L228:   aload_0 
L229:   getfield [29] 
L232:   aload 6 
L234:   invokevirtual [38] 
L237:   goto L256 
L240:   aload_0 
L241:   getfield [31] 
L244:   ldc [14] 
L246:   ldc [15] 
L248:   aload_0 
L249:   getfield [29] 
L252:   invokevirtual [34] 
L255:   pop 
L256:   aload_1 
L257:   monitorexit 
L258:   goto L268 
        .catch [0] from L261 to L265 using L261 
L261:   astore 7 
L263:   aload_1 
L264:   monitorexit 
L265:   aload 7 
L267:   athrow 
L268:   return 
L269:   nop 
L270:   nop 
L271:   nop 
L272:   
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [242] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [3] 
L6:     ldc [16] 
L8:     aload_0 
L9:     getfield [29] 
L12:    invokevirtual [34] 
L15:    pop 
L16:    aload_0 
L17:    getfield [27] 
L20:    dup 
L21:    astore_1 
L22:    monitorenter 
        .catch [0] from L23 to L49 using L52 
L23:    aload_0 
L24:    iconst_1 
L25:    putfield [51] 
L28:    aload_0 
L29:    getfield [33] 
L32:    ifeq L47 
L35:    aload_0 
L36:    getfield [27] 
L39:    invokespecial [44] 
L42:    aload_0 
L43:    iconst_0 
L44:    putfield [52] 
L47:    aload_1 
L48:    monitorexit 
L49:    goto L57 
        .catch [0] from L52 to L55 using L52 
L52:    astore_2 
L53:    aload_1 
L54:    monitorexit 
L55:    aload_2 
L56:    athrow 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [242] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [31] 
L4:     ldc [3] 
L6:     ldc [17] 
L8:     aload_0 
L9:     getfield [29] 
L12:    invokevirtual [34] 
L15:    pop 
L16:    aload_0 
L17:    getfield [27] 
L20:    dup 
L21:    astore_1 
L22:    monitorenter 
        .catch [0] from L23 to L49 using L52 
L23:    aload_0 
L24:    iconst_1 
L25:    putfield [53] 
L28:    aload_0 
L29:    getfield [33] 
L32:    ifeq L47 
L35:    aload_0 
L36:    getfield [27] 
L39:    invokespecial [44] 
L42:    aload_0 
L43:    iconst_0 
L44:    putfield [52] 
L47:    aload_1 
L48:    monitorexit 
L49:    goto L57 
        .catch [0] from L52 to L55 using L52 
L52:    astore_2 
L53:    aload_1 
L54:    monitorexit 
L55:    aload_2 
L56:    athrow 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [255] : [256] 
    .attribute [242] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokeinterface [55] 0 
L9:     freturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [242] .code stack 3 locals 3 
L0:     new [54] 
L3:     dup 
L4:     invokespecial [43] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [27] 
L12:    dup 
L13:    astore_2 
L14:    monitorenter 
        .catch [0] from L15 to L80 using L83 
L15:    aload_1 
L16:    ldc [18] 
L18:    invokevirtual [36] 
L21:    aload_0 
L22:    getfield [29] 
L25:    invokevirtual [36] 
L28:    pop 
L29:    aload_1 
L30:    ldc [19] 
L32:    invokevirtual [36] 
L35:    aload_0 
L36:    getfield [30] 
L39:    invokevirtual [37] 
L42:    pop 
L43:    aload_0 
L44:    getfield [33] 
L47:    ifeq L57 
L50:    aload_1 
L51:    ldc [20] 
L53:    invokevirtual [36] 
L56:    pop 
L57:    aload_0 
L58:    getfield [32] 
L61:    ifeq L71 
L64:    aload_1 
L65:    ldc [21] 
L67:    invokevirtual [36] 
L70:    pop 
L71:    aload_1 
L72:    ldc [22] 
L74:    invokevirtual [36] 
L77:    pop 
L78:    aload_2 
L79:    monitorexit 
L80:    goto L88 
        .catch [0] from L83 to L86 using L83 
L83:    astore_3 
L84:    aload_2 
L85:    monitorexit 
L86:    aload_3 
L87:    athrow 
L88:    aload_1 
L89:    invokevirtual [39] 
L92:    areturn 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = Int 1078071040 
.const [4] = String [57] 
.const [5] = Class [58] 
.const [6] = Method [59] [60] 
.const [7] = Class [61] 
.const [8] = String [62] 
.const [9] = String [63] 
.const [10] = String [64] 
.const [11] = String [65] 
.const [12] = String [66] 
.const [13] = String [67] 
.const [14] = Int -2137614336 
.const [15] = String [68] 
.const [16] = String [69] 
.const [17] = String [70] 
.const [18] = String [71] 
.const [19] = String [72] 
.const [20] = String [73] 
.const [21] = String [74] 
.const [22] = String [75] 
.const [23] = Class [76] 
.const [24] = Class [77] 
.const [25] = Class [78] 
.const [26] = Class [79] 
.const [27] = Field [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Field [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Field [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Field [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Field [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Method [114] [115] 
.const [45] = Class [116] 
.const [46] = Field [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = Field [121] [122] 
.const [49] = Field [123] [124] 
.const [50] = Field [125] [126] 
.const [51] = Field [127] [128] 
.const [52] = Field [129] [130] 
.const [53] = Field [131] [132] 
.const [54] = Class [133] 
.const [55] = InterfaceMethod [134] [135] 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 'WaitSyncer[%1]: waitForTrigger()' 
.const [58] = Utf8 java/lang/InterruptedException 
.const [59] = Class [136] 
.const [60] = NameAndType [137] [138] 
.const [61] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [62] = Utf8 'triggered after ' 
.const [63] = Utf8 ' ms' 
.const [64] = Utf8 'canceled after ' 
.const [65] = Utf8 'timed out after ' 
.const [66] = Utf8 'unexpected finish after ' 
.const [67] = Utf8 'WaitSyncer[%1]#waitForTrigger: %2' 
.const [68] = Utf8 'WaitSyncer[%1]#waitForTrigger: already waiting --> NOP!' 
.const [69] = Utf8 'WaitSyncer[%1]: trigger()' 
.const [70] = Utf8 'WaitSyncer[%1]: cancel()' 
.const [71] = Utf8 'WaitSyncer(name=' 
.const [72] = Utf8 ',timeout=' 
.const [73] = Utf8 ',waiting' 
.const [74] = Utf8 ',triggered' 
.const [75] = Utf8 ')' 
.const [76] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Utf8 java/lang/Thread 
.const [79] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Class [151] 
.const [89] = NameAndType [152] [153] 
.const [90] = Class [154] 
.const [91] = NameAndType [155] [156] 
.const [92] = Class [157] 
.const [93] = NameAndType [158] [159] 
.const [94] = Class [160] 
.const [95] = NameAndType [161] [162] 
.const [96] = Class [163] 
.const [97] = NameAndType [164] [165] 
.const [98] = Class [166] 
.const [99] = NameAndType [167] [168] 
.const [100] = Class [169] 
.const [101] = NameAndType [170] [171] 
.const [102] = Class [172] 
.const [103] = NameAndType [173] [174] 
.const [104] = Class [175] 
.const [105] = NameAndType [176] [177] 
.const [106] = Class [178] 
.const [107] = NameAndType [179] [180] 
.const [108] = Class [181] 
.const [109] = NameAndType [182] [183] 
.const [110] = Class [184] 
.const [111] = NameAndType [185] [186] 
.const [112] = Class [187] 
.const [113] = NameAndType [188] [189] 
.const [114] = Class [190] 
.const [115] = NameAndType [191] [192] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [193] 
.const [118] = NameAndType [194] [195] 
.const [119] = Class [196] 
.const [120] = NameAndType [197] [198] 
.const [121] = Class [199] 
.const [122] = NameAndType [200] [201] 
.const [123] = Class [202] 
.const [124] = NameAndType [203] [204] 
.const [125] = Class [205] 
.const [126] = NameAndType [206] [207] 
.const [127] = Class [208] 
.const [128] = NameAndType [209] [210] 
.const [129] = Class [211] 
.const [130] = NameAndType [212] [213] 
.const [131] = Class [214] 
.const [132] = NameAndType [215] [216] 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Class [217] 
.const [135] = NameAndType [218] [219] 
.const [136] = Utf8 java/lang/Thread 
.const [137] = Utf8 interrupted 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [140] = Utf8 monitor 
.const [141] = Utf8 Ljava/lang/Object; 
.const [142] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [143] = Utf8 frameworkAccess 
.const [144] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [145] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [146] = Utf8 name 
.const [147] = Utf8 Ljava/lang/String; 
.const [148] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [149] = Utf8 timeout 
.const [150] = Utf8 J 
.const [151] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [152] = Utf8 log 
.const [153] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [154] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [155] = Utf8 triggered 
.const [156] = Utf8 Z 
.const [157] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [158] = Utf8 waiting 
.const [159] = Utf8 Z 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [163] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [164] = Utf8 canceled 
.const [165] = Utf8 Z 
.const [166] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [169] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [170] = Utf8 append 
.const [171] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [175] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [176] = Utf8 toString 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 java/lang/Object 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [182] = Utf8 getMonotonicTime 
.const [183] = Utf8 ()J 
.const [184] = Utf8 java/lang/Object 
.const [185] = Utf8 wait 
.const [186] = Utf8 (J)V 
.const [187] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 java/lang/Object 
.const [191] = Utf8 notifyAll 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [194] = Utf8 monitor 
.const [195] = Utf8 Ljava/lang/Object; 
.const [196] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [197] = Utf8 frameworkAccess 
.const [198] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [199] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [200] = Utf8 name 
.const [201] = Utf8 Ljava/lang/String; 
.const [202] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [203] = Utf8 timeout 
.const [204] = Utf8 J 
.const [205] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [206] = Utf8 log 
.const [207] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [208] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [209] = Utf8 triggered 
.const [210] = Utf8 Z 
.const [211] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [212] = Utf8 waiting 
.const [213] = Utf8 Z 
.const [214] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [215] = Utf8 canceled 
.const [216] = Utf8 Z 
.const [217] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [218] = Utf8 getMonotonicTime 
.const [219] = Utf8 ()J 
.const [220] = Utf8 de/audi/atip/sync/WaitSyncer 
.const [221] = Class [220] 
.const [222] = Utf8 java/lang/Object 
.const [223] = Class [222] 
.const [224] = Utf8 de/audi/atip/sync/IWaitSyncer 
.const [225] = Class [224] 
.const [226] = Utf8 frameworkAccess 
.const [227] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [228] = Utf8 name 
.const [229] = Utf8 Ljava/lang/String; 
.const [230] = Utf8 timeout 
.const [231] = Utf8 J 
.const [232] = Utf8 log 
.const [233] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [234] = Utf8 monitor 
.const [235] = Utf8 Ljava/lang/Object; 
.const [236] = Utf8 waiting 
.const [237] = Utf8 Z 
.const [238] = Utf8 triggered 
.const [239] = Utf8 Z 
.const [240] = Utf8 canceled 
.const [241] = Utf8 Z 
.const [242] = Utf8 Code 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Ljava/lang/String;JLde/audi/atip/log/LogChannel;)V 
.const [245] = Utf8 isTriggered 
.const [246] = Utf8 ()Z 
.const [247] = Utf8 isWaiting 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 waitForTrigger 
.const [250] = Utf8 ()V 
.const [251] = Utf8 trigger 
.const [252] = Utf8 ()V 
.const [253] = Utf8 cancel 
.const [254] = Utf8 ()V 
.const [255] = Utf8 getMonotonicTime 
.const [256] = Utf8 ()J 
.const [257] = Utf8 toString 
.const [258] = Utf8 ()Ljava/lang/String; 
.end class 
