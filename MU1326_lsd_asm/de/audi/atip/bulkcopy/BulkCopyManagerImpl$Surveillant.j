.version 50 0 
.class super [218] 
.super [220] 
.implements [222] 
.implements [224] 
.field private static final [225] [226] 
.field private final [227] [228] 
.field private final [229] [230] 
.field private final [231] [232] 

.method public [234] : [235] 
    .attribute [233] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [46] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [47] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [48] 
L19:    aload_2 
L20:    invokeinterface [49] 0 
L25:    astore 4 
L27:    aconst_null 
L28:    aload 4 
L30:    if_acmpne L47 
L33:    aload_0 
L34:    getfield [26] 
L37:    sipush 10000 
L40:    ldc [2] 
L42:    invokevirtual [27] 
L45:    pop 
L46:    return 
        .catch [3] from L47 to L59 using L62 
L47:    aload_1 
L48:    aload_0 
L49:    invokevirtual [28] 
L52:    pop 
L53:    aload_1 
L54:    aload_0 
L55:    iconst_4 
L56:    invokevirtual [29] 
L59:    goto L80 
L62:    astore 5 
L64:    aload_0 
L65:    getfield [26] 
L68:    sipush 10000 
L71:    ldc [4] 
L73:    aload 5 
L75:    invokevirtual [30] 
L78:    pop 
L79:    return 
L80:    aload 4 
L82:    aload_0 
L83:    invokevirtual [31] 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [236] : [237] 
    .attribute [233] .code stack 1 locals 0 
L0:     iconst_m1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [233] .code stack 2 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_3 
L3:     monitorenter 
        .catch [0] from L4 to L10 using L13 
L4:     aload_0 
L5:     invokespecial [42] 
L8:     aload_3 
L9:     monitorexit 
L10:    goto L20 
        .catch [0] from L13 to L17 using L13 
L13:    astore 4 
L15:    aload_3 
L16:    monitorexit 
L17:    aload 4 
L19:    athrow 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [240] : [241] 
    .attribute [233] .code stack 7 locals 11 
L0:     invokestatic [5] 
L3:     astore_1 
L4:     aload_0 
L5:     getfield [25] 
L8:     invokeinterface [50] 0 
L13:    lstore_2 
L14:    aload_1 
L15:    new [51] 
L18:    dup 
L19:    invokespecial [43] 
L22:    aload_1 
L23:    invokevirtual [32] 
L26:    invokevirtual [33] 
L29:    ldc [7] 
L31:    invokevirtual [33] 
L34:    invokevirtual [34] 
L37:    invokevirtual [35] 
L40:    aconst_null 
L41:    aload_0 
L42:    getfield [26] 
L45:    if_acmpeq L61 
L48:    aload_0 
L49:    getfield [26] 
L52:    ldc [8] 
L54:    ldc [9] 
L56:    lload_2 
L57:    invokevirtual [36] 
L60:    pop 
L61:    aload_0 
L62:    dup 
L63:    astore 4 
L65:    monitorenter 
        .catch [12] from L66 to L124 using L127 
        .catch [0] from L66 to L136 using L139 
L66:    aload_0 
L67:    getfield [25] 
L70:    invokeinterface [50] 0 
L75:    lload_2 
L76:    lsub 
L77:    lstore 5 
L79:    ldc_w [1] 
L82:    lload 5 
L84:    lsub 
L85:    lstore 7 
L87:    aconst_null 
L88:    aload_0 
L89:    getfield [26] 
L92:    if_acmpeq L111 
L95:    aload_0 
L96:    getfield [26] 
L99:    ldc [10] 
L101:   ldc [11] 
L103:   lload 7 
L105:   lload 5 
L107:   invokevirtual [37] 
L110:   pop 
L111:   lload 7 
L113:   lconst_0 
L114:   lcmp 
L115:   ifle L124 
L118:   aload_0 
L119:   lload 7 
L121:   invokespecial [44] 
L124:   goto L133 
L127:   astore 5 
L129:   invokestatic [13] 
L132:   pop 
L133:   aload 4 
L135:   monitorexit 
L136:   goto L147 
        .catch [0] from L139 to L144 using L139 
L139:   astore 9 
L141:   aload 4 
L143:   monitorexit 
L144:   aload 9 
L146:   athrow 
L147:   aload_0 
L148:   getfield [24] 
L151:   invokevirtual [38] 
L154:   ifeq L260 
L157:   aload_0 
L158:   getfield [24] 
L161:   invokevirtual [39] 
L164:   ifne L260 
L167:   aconst_null 
L168:   aload_0 
L169:   getfield [26] 
L172:   if_acmpeq L187 
L175:   aload_0 
L176:   getfield [26] 
L179:   ldc [10] 
L181:   ldc [14] 
L183:   invokevirtual [27] 
L186:   pop 
L187:   aload_0 
L188:   getfield [24] 
L191:   iconst_0 
L192:   invokevirtual [40] 
L195:   aload_0 
L196:   dup 
L197:   astore 4 
L199:   monitorenter 
        .catch [12] from L200 to L204 using L207 
        .catch [0] from L200 to L216 using L219 
L200:   aload_0 
L201:   invokespecial [45] 
L204:   goto L213 
L207:   astore 5 
L209:   invokestatic [13] 
L212:   pop 
L213:   aload 4 
L215:   monitorexit 
L216:   goto L227 
        .catch [0] from L219 to L224 using L219 
L219:   astore 10 
L221:   aload 4 
L223:   monitorexit 
L224:   aload 10 
L226:   athrow 
L227:   aload_0 
L228:   getfield [24] 
L231:   invokevirtual [38] 
L234:   ifeq L247 
L237:   aload_0 
L238:   getfield [24] 
L241:   invokevirtual [39] 
L244:   ifeq L195 
L247:   aload_0 
L248:   getfield [25] 
L251:   invokeinterface [50] 0 
L256:   lstore_2 
L257:   goto L61 
L260:   aconst_null 
L261:   aload_0 
L262:   getfield [26] 
L265:   if_acmpeq L280 
L268:   aload_0 
L269:   getfield [26] 
L272:   ldc [10] 
L274:   ldc [15] 
L276:   invokevirtual [27] 
L279:   pop 
L280:   aload_0 
L281:   getfield [25] 
L284:   invokeinterface [50] 0 
L289:   lload_2 
L290:   lsub 
L291:   lstore 4 
L293:   lload 4 
L295:   ldc_w [1] 
L298:   lcmp 
L299:   iflt L392 
L302:   aconst_null 
L303:   aload_0 
L304:   getfield [26] 
L307:   if_acmpeq L322 
L310:   aload_0 
L311:   getfield [26] 
L314:   ldc [10] 
L316:   ldc [16] 
L318:   invokevirtual [27] 
L321:   pop 
L322:   aload_0 
L323:   getfield [24] 
L326:   iconst_1 
L327:   invokevirtual [40] 
L330:   aload_0 
L331:   dup 
L332:   astore 6 
L334:   monitorenter 
        .catch [12] from L335 to L339 using L342 
        .catch [0] from L335 to L351 using L354 
L335:   aload_0 
L336:   invokespecial [45] 
L339:   goto L348 
L342:   astore 7 
L344:   invokestatic [13] 
L347:   pop 
L348:   aload 6 
L350:   monitorexit 
L351:   goto L362 
        .catch [0] from L354 to L359 using L354 
L354:   astore 11 
L356:   aload 6 
L358:   monitorexit 
L359:   aload 11 
L361:   athrow 
L362:   aload_0 
L363:   getfield [24] 
L366:   invokevirtual [38] 
L369:   ifeq L330 
L372:   aload_0 
L373:   getfield [24] 
L376:   invokevirtual [39] 
L379:   ifne L330 
L382:   aload_0 
L383:   getfield [25] 
L386:   invokeinterface [50] 0 
L391:   lstore_2 
L392:   goto L61 
L395:   nop 
L396:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [53] 
.const [3] = Class [54] 
.const [4] = String [55] 
.const [5] = Method [56] [57] 
.const [6] = Class [58] 
.const [7] = String [59] 
.const [8] = Int 1078071040 
.const [9] = String [60] 
.const [10] = Int -2137614336 
.const [11] = String [61] 
.const [12] = Class [62] 
.const [13] = Method [63] [64] 
.const [14] = String [65] 
.const [15] = String [66] 
.const [16] = String [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Class [74] 
.const [24] = Field [75] [76] 
.const [25] = Field [77] [78] 
.const [26] = Field [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Method [111] [112] 
.const [43] = Method [113] [114] 
.const [44] = Method [115] [116] 
.const [45] = Method [117] [118] 
.const [46] = Field [119] [120] 
.const [47] = Field [121] [122] 
.const [48] = Field [123] [124] 
.const [49] = InterfaceMethod [125] [126] 
.const [50] = InterfaceMethod [127] [128] 
.const [51] = Class [129] 
.const [52] = Int -1059847936 
.const [53] = Utf8 "[BulkCopyManagerImpl.Surveillant] No ThreadPool exists! Can't start Surveillant-Client!" 
.const [54] = Utf8 de/audi/atip/bulkcopy/BulkCopyException 
.const [55] = Utf8 '[BulkCopyManagerImpl.Surveillant] Error during registration of Surveillant-Client' 
.const [56] = Class [130] 
.const [57] = NameAndType [131] [132] 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'BulkCopyManager.Surveillant' 
.const [60] = Utf8 '[BulkCopyManager.Surveillant.run] start: %1' 
.const [61] = Utf8 '[BulkCopyManager.Surveillant.run] wait: %1, gone: %2' 
.const [62] = Utf8 java/lang/InterruptedException 
.const [63] = Class [133] 
.const [64] = NameAndType [134] [135] 
.const [65] = Utf8 '[BulkCopyManager.Surveillant.run] all waiting clients registered' 
.const [66] = Utf8 '[BulkCopyManager.Surveillant.run] not all waiting clients registered' 
.const [67] = Utf8 '[BulkCopyManager.Surveillant.run] TIMED OUT -> DO NOT WAIT ANYMORE!' 
.const [68] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [71] = Utf8 de/audi/atip/log/LogChannel 
.const [72] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [73] = Utf8 de/esolutions/fw/util/commons/threading/ThreadPool 
.const [74] = Utf8 java/lang/Thread 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
.const [95] = Class [166] 
.const [96] = NameAndType [167] [168] 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Class [202] 
.const [120] = NameAndType [203] [204] 
.const [121] = Class [205] 
.const [122] = NameAndType [206] [207] 
.const [123] = Class [208] 
.const [124] = NameAndType [209] [210] 
.const [125] = Class [211] 
.const [126] = NameAndType [212] [213] 
.const [127] = Class [214] 
.const [128] = NameAndType [215] [216] 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 java/lang/Thread 
.const [131] = Utf8 currentThread 
.const [132] = Utf8 ()Ljava/lang/Thread; 
.const [133] = Utf8 java/lang/Thread 
.const [134] = Utf8 interrupted 
.const [135] = Utf8 ()Z 
.const [136] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [137] = Utf8 m_parent 
.const [138] = Utf8 Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [139] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [140] = Utf8 m_framework 
.const [141] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [142] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [143] = Utf8 m_log 
.const [144] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [145] = Utf8 de/audi/atip/log/LogChannel 
.const [146] = Utf8 log 
.const [147] = Utf8 (ILjava/lang/String;)Z 
.const [148] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [149] = Utf8 registerClient 
.const [150] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;)Z 
.const [151] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [152] = Utf8 setClientState 
.const [153] = Utf8 (Lde/audi/atip/bulkcopy/IBulkCopyClient;I)V 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [157] = Utf8 de/esolutions/fw/util/commons/threading/ThreadPool 
.const [158] = Utf8 execute 
.const [159] = Utf8 (Ljava/lang/Runnable;)V 
.const [160] = Utf8 java/lang/Thread 
.const [161] = Utf8 getName 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 java/lang/StringBuffer 
.const [164] = Utf8 append 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [166] = Utf8 java/lang/StringBuffer 
.const [167] = Utf8 toString 
.const [168] = Utf8 ()Ljava/lang/String; 
.const [169] = Utf8 java/lang/Thread 
.const [170] = Utf8 setName 
.const [171] = Utf8 (Ljava/lang/String;)V 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;J)Z 
.const [175] = Utf8 de/audi/atip/log/LogChannel 
.const [176] = Utf8 log 
.const [177] = Utf8 (ILjava/lang/String;JJ)Z 
.const [178] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [179] = Utf8 areAllWaitingClientsRegistered 
.const [180] = Utf8 ()Z 
.const [181] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [182] = Utf8 isAnyClientInRegisteredState 
.const [183] = Utf8 ()Z 
.const [184] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl 
.const [185] = Utf8 setIgnoreWaitingClients 
.const [186] = Utf8 (Z)V 
.const [187] = Utf8 java/lang/Object 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 java/lang/Object 
.const [191] = Utf8 notifyAll 
.const [192] = Utf8 ()V 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 <init> 
.const [195] = Utf8 ()V 
.const [196] = Utf8 java/lang/Object 
.const [197] = Utf8 wait 
.const [198] = Utf8 (J)V 
.const [199] = Utf8 java/lang/Object 
.const [200] = Utf8 wait 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [203] = Utf8 m_parent 
.const [204] = Utf8 Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [205] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [206] = Utf8 m_framework 
.const [207] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [208] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [209] = Utf8 m_log 
.const [210] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [211] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [212] = Utf8 getUtilThreadPool 
.const [213] = Utf8 ()Lde/esolutions/fw/util/commons/threading/ThreadPool; 
.const [214] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [215] = Utf8 getMonotonicTime 
.const [216] = Utf8 ()J 
.const [217] = Utf8 de/audi/atip/bulkcopy/BulkCopyManagerImpl$Surveillant 
.const [218] = Class [217] 
.const [219] = Utf8 java/lang/Object 
.const [220] = Class [219] 
.const [221] = Utf8 de/audi/atip/bulkcopy/IBulkCopyClient 
.const [222] = Class [221] 
.const [223] = Utf8 java/lang/Runnable 
.const [224] = Class [223] 
.const [225] = Utf8 TIMEOUT 
.const [226] = Utf8 J 
.const [227] = Utf8 m_parent 
.const [228] = Utf8 Lde/audi/atip/bulkcopy/BulkCopyManagerImpl; 
.const [229] = Utf8 m_framework 
.const [230] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [231] = Utf8 m_log 
.const [232] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [233] = Utf8 Code 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lde/audi/atip/bulkcopy/BulkCopyManagerImpl;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/atip/log/LogChannel;)V 
.const [236] = Utf8 getClientType 
.const [237] = Utf8 ()I 
.const [238] = Utf8 onChangeStateBulkCopy 
.const [239] = Utf8 (II)V 
.const [240] = Utf8 run 
.const [241] = Utf8 ()V 
.end class 
