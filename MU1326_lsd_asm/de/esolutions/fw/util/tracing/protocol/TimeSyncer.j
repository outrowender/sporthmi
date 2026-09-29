.version 50 0 
.class public super [224] 
.super [226] 
.field private [227] [228] 
.field private [229] [230] 
.field private [231] [232] 
.field private [233] [234] 
.field private [235] [236] 
.field private [237] [238] 
.field private [239] [240] 
.field private [241] [242] 
.field private static final [243] [244] 

.method public [246] : [247] 
    .attribute [245] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [39] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [40] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [245] .code stack 7 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [41] 
L5:     aload_0 
L6:     aload_0 
L7:     getfield [26] 
L10:    iconst_1 
L11:    iadd 
L12:    newarray long 
L14:    putfield [42] 
L17:    aload_0 
L18:    aload_0 
L19:    getfield [26] 
L22:    iconst_1 
L23:    iadd 
L24:    newarray long 
L26:    putfield [43] 
L29:    aload_0 
L30:    invokestatic [2] 
L33:    putfield [44] 
L36:    aload_0 
L37:    getfield [24] 
L40:    aload_0 
L41:    getfield [29] 
L44:    aload_0 
L45:    getfield [26] 
L48:    iconst_0 
L49:    invokeinterface [45] 0 
L54:    getstatic [3] 
L57:    ldc [4] 
L59:    ldc [5] 
L61:    new [46] 
L64:    dup 
L65:    aload_0 
L66:    getfield [29] 
L69:    invokespecial [36] 
L72:    invokestatic [7] 
L75:    return 
L76:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [245] .code stack 10 locals 8 
L0:     aload_1 
L1:     invokevirtual [30] 
L4:     istore_2 
L5:     aload_1 
L6:     invokevirtual [31] 
L9:     istore_3 
L10:    iload_2 
L11:    lookupswitch 
            0 : L36 
            1 : L79 
            default : L240 

L36:    invokestatic [2] 
L39:    lstore 4 
L41:    aload_0 
L42:    getfield [24] 
L45:    lload 4 
L47:    aload_1 
L48:    invokevirtual [31] 
L51:    iconst_1 
L52:    invokeinterface [45] 0 
L57:    getstatic [3] 
L60:    ldc [4] 
L62:    ldc [8] 
L64:    new [46] 
L67:    dup 
L68:    lload 4 
L70:    invokespecial [36] 
L73:    invokestatic [7] 
L76:    goto L250 
L79:    invokestatic [2] 
L82:    lstore 4 
L84:    lload 4 
L86:    aload_0 
L87:    getfield [29] 
L90:    ladd 
L91:    ldc_w [1] 
L94:    ldiv 
L95:    lstore 6 
L97:    aload_1 
L98:    invokevirtual [32] 
L101:   lstore 8 
L103:   aload_0 
L104:   lload 6 
L106:   lload 8 
L108:   lsub 
L109:   putfield [47] 
L112:   aload_0 
L113:   lload 6 
L115:   aload_0 
L116:   getfield [29] 
L119:   lsub 
L120:   putfield [48] 
L123:   aload_0 
L124:   iconst_1 
L125:   putfield [40] 
L128:   aload_0 
L129:   getfield [27] 
L132:   iload_3 
L133:   aload_0 
L134:   getfield [33] 
L137:   lastore 
L138:   aload_0 
L139:   getfield [28] 
L142:   iload_3 
L143:   aload_0 
L144:   getfield [34] 
L147:   lastore 
L148:   getstatic [3] 
L151:   ldc [4] 
L153:   ldc [9] 
L155:   new [46] 
L158:   dup 
L159:   lload 6 
L161:   invokespecial [36] 
L164:   new [46] 
L167:   dup 
L168:   lload 8 
L170:   invokespecial [36] 
L173:   new [46] 
L176:   dup 
L177:   aload_0 
L178:   getfield [33] 
L181:   invokespecial [36] 
L184:   new [46] 
L187:   dup 
L188:   aload_0 
L189:   getfield [34] 
L192:   invokespecial [36] 
L195:   invokestatic [10] 
L198:   iload_3 
L199:   ifle L231 
L202:   iload_3 
L203:   iconst_1 
L204:   isub 
L205:   i2b 
L206:   istore_3 
L207:   aload_0 
L208:   lload 4 
L210:   putfield [44] 
L213:   aload_0 
L214:   getfield [24] 
L217:   aload_0 
L218:   getfield [29] 
L221:   iload_3 
L222:   iconst_0 
L223:   invokeinterface [45] 0 
L228:   goto L237 
L231:   aload_0 
L232:   invokespecial [37] 
L235:   iconst_1 
L236:   areturn 
L237:   goto L250 
L240:   new [49] 
L243:   dup 
L244:   ldc [12] 
L246:   invokespecial [38] 
L249:   athrow 
L250:   iconst_0 
L251:   areturn 
L252:   
    .end code 
.end method 

.method public interface [252] : [253] 
    .attribute [245] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [254] : [255] 
    .attribute [245] .code stack 8 locals 14 
L0:     aload_0 
L1:     getfield [28] 
L4:     arraylength 
L5:     istore_1 
L6:     iload_1 
L7:     newarray long 
L9:     astore_2 
L10:    aload_0 
L11:    getfield [28] 
L14:    iconst_0 
L15:    aload_2 
L16:    iconst_0 
L17:    iload_1 
L18:    invokestatic [13] 
L21:    aload_2 
L22:    invokestatic [14] 
L25:    iload_1 
L26:    iconst_2 
L27:    idiv 
L28:    istore_3 
L29:    iload_1 
L30:    iconst_2 
L31:    irem 
L32:    ifne L53 
L35:    aload_2 
L36:    iload_3 
L37:    laload 
L38:    aload_2 
L39:    iload_3 
L40:    iconst_1 
L41:    iadd 
L42:    laload 
L43:    ladd 
L44:    ldc_w [1] 
L47:    ldiv 
L48:    lstore 4 
L50:    goto L58 
L53:    aload_2 
L54:    iload_3 
L55:    laload 
L56:    lstore 4 
L58:    lconst_0 
L59:    lstore 6 
L61:    iconst_0 
L62:    istore 8 
L64:    iload 8 
L66:    iload_1 
L67:    if_icmpge L88 
L70:    lload 6 
L72:    aload_0 
L73:    getfield [28] 
L76:    iload 8 
L78:    laload 
L79:    ladd 
L80:    lstore 6 
L82:    iinc 8 1 
L85:    goto L64 
L88:    iload_1 
L89:    ifle L99 
L92:    lload 6 
L94:    iload_1 
L95:    i2l 
L96:    ldiv 
L97:    lstore 6 
L99:    lconst_0 
L100:   lstore 8 
L102:   iconst_0 
L103:   istore 10 
L105:   iload 10 
L107:   iload_1 
L108:   if_icmpge L153 
L111:   aload_0 
L112:   getfield [28] 
L115:   iload 10 
L117:   laload 
L118:   lload 6 
L120:   lsub 
L121:   lstore 11 
L123:   aload_0 
L124:   getfield [28] 
L127:   iload 10 
L129:   lload 11 
L131:   lload 11 
L133:   lmul 
L134:   lastore 
L135:   lload 8 
L137:   aload_0 
L138:   getfield [28] 
L141:   iload 10 
L143:   laload 
L144:   ladd 
L145:   lstore 8 
L147:   iinc 10 1 
L150:   goto L105 
L153:   iload_1 
L154:   ifle L164 
L157:   lload 8 
L159:   iload_1 
L160:   i2l 
L161:   ldiv 
L162:   lstore 8 
L164:   lconst_0 
L165:   lstore 10 
L167:   lconst_0 
L168:   lstore 12 
L170:   iconst_0 
L171:   istore 14 
L173:   iload 14 
L175:   iload_1 
L176:   if_icmpge L216 
L179:   aload_0 
L180:   getfield [28] 
L183:   iload 14 
L185:   laload 
L186:   lload 8 
L188:   lcmp 
L189:   ifgt L210 
L192:   lload 10 
L194:   aload_0 
L195:   getfield [27] 
L198:   iload 14 
L200:   laload 
L201:   ladd 
L202:   lstore 10 
L204:   lload 12 
L206:   lconst_1 
L207:   ladd 
L208:   lstore 12 
L210:   iinc 14 1 
L213:   goto L173 
L216:   lload 12 
L218:   lconst_0 
L219:   lcmp 
L220:   ifle L230 
L223:   lload 10 
L225:   lload 12 
L227:   ldiv 
L228:   lstore 10 
L230:   aload_0 
L231:   lload 4 
L233:   putfield [48] 
L236:   aload_0 
L237:   lload 10 
L239:   putfield [47] 
L242:   getstatic [3] 
L245:   ldc [4] 
L247:   ldc [15] 
L249:   new [46] 
L252:   dup 
L253:   aload_0 
L254:   getfield [34] 
L257:   invokespecial [36] 
L260:   new [46] 
L263:   dup 
L264:   aload_0 
L265:   getfield [33] 
L268:   invokespecial [36] 
L271:   invokestatic [16] 
L274:   return 
L275:   nop 
L276:   
    .end code 
.end method 

.method public interface [256] : [257] 
    .attribute [245] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [258] : [259] 
    .attribute [245] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [51] [52] 
.const [3] = Field [53] [54] 
.const [4] = String [55] 
.const [5] = String [56] 
.const [6] = Class [57] 
.const [7] = Method [58] [59] 
.const [8] = String [60] 
.const [9] = String [61] 
.const [10] = Method [62] [63] 
.const [11] = Class [64] 
.const [12] = String [65] 
.const [13] = Method [66] [67] 
.const [14] = Method [68] [69] 
.const [15] = String [70] 
.const [16] = Method [71] [72] 
.const [17] = Class [73] 
.const [18] = Class [74] 
.const [19] = Class [75] 
.const [20] = Class [76] 
.const [21] = Class [77] 
.const [22] = Class [78] 
.const [23] = Class [79] 
.const [24] = Field [80] [81] 
.const [25] = Field [82] [83] 
.const [26] = Field [84] [85] 
.const [27] = Field [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Field [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Field [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = Field [112] [113] 
.const [41] = Field [114] [115] 
.const [42] = Field [116] [117] 
.const [43] = Field [118] [119] 
.const [44] = Field [120] [121] 
.const [45] = InterfaceMethod [122] [123] 
.const [46] = Class [124] 
.const [47] = Field [125] [126] 
.const [48] = Field [127] [128] 
.const [49] = Class [129] 
.const [50] = Int 33554432 
.const [51] = Class [130] 
.const [52] = NameAndType [131] [132] 
.const [53] = Class [133] 
.const [54] = NameAndType [134] [135] 
.const [55] = Utf8 TimeSyncer 
.const [56] = Utf8 'start=%1' 
.const [57] = Utf8 java/lang/Long 
.const [58] = Class [136] 
.const [59] = NameAndType [137] [138] 
.const [60] = Utf8 'ping reply: myTime=%1' 
.const [61] = Utf8 'midTime=%1 otherMidTime=%2 curDelta=%3 curLatency=%4' 
.const [62] = Class [139] 
.const [63] = NameAndType [140] [141] 
.const [64] = Utf8 de/esolutions/fw/util/tracing/protocol/ProtocolException 
.const [65] = Utf8 'Unknown Time Sync ' 
.const [66] = Class [142] 
.const [67] = NameAndType [143] [144] 
.const [68] = Class [145] 
.const [69] = NameAndType [146] [147] 
.const [70] = Utf8 'Updated latency: %1 delta: %2' 
.const [71] = Class [148] 
.const [72] = NameAndType [149] [150] 
.const [73] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 java/lang/System 
.const [76] = Utf8 de/esolutions/fw/util/tracing/protocol/ITimeSyncSender 
.const [77] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [78] = Utf8 de/esolutions/fw/util/tracing/protocol/message/TimeSyncMessage 
.const [79] = Utf8 java/util/Arrays 
.const [80] = Class [151] 
.const [81] = NameAndType [152] [153] 
.const [82] = Class [154] 
.const [83] = NameAndType [155] [156] 
.const [84] = Class [157] 
.const [85] = NameAndType [158] [159] 
.const [86] = Class [160] 
.const [87] = NameAndType [161] [162] 
.const [88] = Class [163] 
.const [89] = NameAndType [164] [165] 
.const [90] = Class [166] 
.const [91] = NameAndType [167] [168] 
.const [92] = Class [169] 
.const [93] = NameAndType [170] [171] 
.const [94] = Class [172] 
.const [95] = NameAndType [173] [174] 
.const [96] = Class [175] 
.const [97] = NameAndType [176] [177] 
.const [98] = Class [178] 
.const [99] = NameAndType [179] [180] 
.const [100] = Class [181] 
.const [101] = NameAndType [182] [183] 
.const [102] = Class [184] 
.const [103] = NameAndType [185] [186] 
.const [104] = Class [187] 
.const [105] = NameAndType [188] [189] 
.const [106] = Class [190] 
.const [107] = NameAndType [191] [192] 
.const [108] = Class [193] 
.const [109] = NameAndType [194] [195] 
.const [110] = Class [196] 
.const [111] = NameAndType [197] [198] 
.const [112] = Class [199] 
.const [113] = NameAndType [200] [201] 
.const [114] = Class [202] 
.const [115] = NameAndType [203] [204] 
.const [116] = Class [205] 
.const [117] = NameAndType [206] [207] 
.const [118] = Class [208] 
.const [119] = NameAndType [209] [210] 
.const [120] = Class [211] 
.const [121] = NameAndType [212] [213] 
.const [122] = Class [214] 
.const [123] = NameAndType [215] [216] 
.const [124] = Utf8 java/lang/Long 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Class [220] 
.const [128] = NameAndType [221] [222] 
.const [129] = Utf8 de/esolutions/fw/util/tracing/protocol/ProtocolException 
.const [130] = Utf8 java/lang/System 
.const [131] = Utf8 currentTimeMillis 
.const [132] = Utf8 ()J 
.const [133] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [134] = Utf8 INFO 
.const [135] = Utf8 I 
.const [136] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [137] = Utf8 msg 
.const [138] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [139] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [140] = Utf8 msg 
.const [141] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [142] = Utf8 java/lang/System 
.const [143] = Utf8 arraycopy 
.const [144] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [145] = Utf8 java/util/Arrays 
.const [146] = Utf8 sort 
.const [147] = Utf8 ([J)V 
.const [148] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [149] = Utf8 msg 
.const [150] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [151] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [152] = Utf8 handler 
.const [153] = Utf8 Lde/esolutions/fw/util/tracing/protocol/ITimeSyncSender; 
.const [154] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [155] = Utf8 syncValid 
.const [156] = Utf8 Z 
.const [157] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [158] = Utf8 serial 
.const [159] = Utf8 B 
.const [160] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [161] = Utf8 deltas 
.const [162] = Utf8 [J 
.const [163] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [164] = Utf8 latencies 
.const [165] = Utf8 [J 
.const [166] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [167] = Utf8 startTime 
.const [168] = Utf8 J 
.const [169] = Utf8 de/esolutions/fw/util/tracing/protocol/message/TimeSyncMessage 
.const [170] = Utf8 getType 
.const [171] = Utf8 ()B 
.const [172] = Utf8 de/esolutions/fw/util/tracing/protocol/message/TimeSyncMessage 
.const [173] = Utf8 getSerial 
.const [174] = Utf8 ()B 
.const [175] = Utf8 de/esolutions/fw/util/tracing/protocol/message/TimeSyncMessage 
.const [176] = Utf8 getTimeStamp 
.const [177] = Utf8 ()J 
.const [178] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [179] = Utf8 curDelta 
.const [180] = Utf8 J 
.const [181] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [182] = Utf8 curLatency 
.const [183] = Utf8 J 
.const [184] = Utf8 java/lang/Object 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 java/lang/Long 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (J)V 
.const [190] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [191] = Utf8 analyseSamples 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/esolutions/fw/util/tracing/protocol/ProtocolException 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (Ljava/lang/String;)V 
.const [196] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [197] = Utf8 handler 
.const [198] = Utf8 Lde/esolutions/fw/util/tracing/protocol/ITimeSyncSender; 
.const [199] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [200] = Utf8 syncValid 
.const [201] = Utf8 Z 
.const [202] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [203] = Utf8 serial 
.const [204] = Utf8 B 
.const [205] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [206] = Utf8 deltas 
.const [207] = Utf8 [J 
.const [208] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [209] = Utf8 latencies 
.const [210] = Utf8 [J 
.const [211] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [212] = Utf8 startTime 
.const [213] = Utf8 J 
.const [214] = Utf8 de/esolutions/fw/util/tracing/protocol/ITimeSyncSender 
.const [215] = Utf8 sendTimeSync 
.const [216] = Utf8 (JBB)V 
.const [217] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [218] = Utf8 curDelta 
.const [219] = Utf8 J 
.const [220] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [221] = Utf8 curLatency 
.const [222] = Utf8 J 
.const [223] = Utf8 de/esolutions/fw/util/tracing/protocol/TimeSyncer 
.const [224] = Class [223] 
.const [225] = Utf8 java/lang/Object 
.const [226] = Class [225] 
.const [227] = Utf8 startTime 
.const [228] = Utf8 J 
.const [229] = Utf8 serial 
.const [230] = Utf8 B 
.const [231] = Utf8 handler 
.const [232] = Utf8 Lde/esolutions/fw/util/tracing/protocol/ITimeSyncSender; 
.const [233] = Utf8 syncValid 
.const [234] = Utf8 Z 
.const [235] = Utf8 deltas 
.const [236] = Utf8 [J 
.const [237] = Utf8 latencies 
.const [238] = Utf8 [J 
.const [239] = Utf8 curDelta 
.const [240] = Utf8 J 
.const [241] = Utf8 curLatency 
.const [242] = Utf8 J 
.const [243] = Utf8 chn 
.const [244] = Utf8 Ljava/lang/String; 
.const [245] = Utf8 Code 
.const [246] = Utf8 <init> 
.const [247] = Utf8 (Lde/esolutions/fw/util/tracing/protocol/ITimeSyncSender;)V 
.const [248] = Utf8 start 
.const [249] = Utf8 (B)V 
.const [250] = Utf8 handleIncomingMessage 
.const [251] = Utf8 (Lde/esolutions/fw/util/tracing/protocol/message/TimeSyncMessage;)Z 
.const [252] = Utf8 isSyncValid 
.const [253] = Utf8 ()Z 
.const [254] = Utf8 analyseSamples 
.const [255] = Utf8 ()V 
.const [256] = Utf8 getDelta 
.const [257] = Utf8 ()J 
.const [258] = Utf8 getLatency 
.const [259] = Utf8 ()J 
.end class 
