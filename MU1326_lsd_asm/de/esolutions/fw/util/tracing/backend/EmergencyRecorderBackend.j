.version 50 0 
.class public super [245] 
.super [247] 
.field private [248] [249] 
.field private [250] [251] 
.field private [252] [253] 
.field private [254] [255] 

.method public [257] : [258] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokespecial [41] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [256] .code stack 4 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [42] 
L7:     aload_3 
L8:     invokevirtual [27] 
L11:    astore 4 
L13:    aload 4 
L15:    ldc [3] 
L17:    invokeinterface [47] 0 
L22:    astore 5 
L24:    aload_0 
L25:    aload_2 
L26:    aload 5 
L28:    iconst_1 
L29:    invokeinterface [48] 0 
L34:    putfield [49] 
L37:    aload_0 
L38:    aload_2 
L39:    invokeinterface [50] 0 
L44:    putfield [51] 
L47:    aload 4 
L49:    ldc [4] 
L51:    bipush 100 
L53:    invokeinterface [52] 0 
L58:    istore 6 
L60:    aload_0 
L61:    aload 4 
L63:    ldc [5] 
L65:    ldc [6] 
L67:    invokeinterface [53] 0 
L72:    putfield [54] 
L75:    aload_0 
L76:    new [55] 
L79:    dup 
L80:    iload 6 
L82:    invokespecial [43] 
L85:    putfield [56] 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [256] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [56] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [256] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     aload_1 
L5:     iconst_1 
L6:     invokevirtual [32] 
L9:     pop 
L10:    iconst_1 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [256] .code stack 5 locals 7 
L0:     aload_0 
L1:     getfield [31] 
L4:     invokevirtual [33] 
L7:     astore_1 
L8:     aload_1 
L9:     ifnonnull L13 
L12:    return 
L13:    getstatic [8] 
L16:    new [57] 
L19:    dup 
L20:    invokespecial [44] 
L23:    ldc [10] 
L25:    invokevirtual [34] 
L28:    aload_1 
L29:    arraylength 
L30:    invokevirtual [35] 
L33:    ldc [11] 
L35:    invokevirtual [34] 
L38:    invokevirtual [36] 
L41:    invokevirtual [37] 
L44:    aconst_null 
L45:    astore_2 
L46:    new [58] 
L49:    dup 
L50:    new [59] 
L53:    dup 
L54:    aload_0 
L55:    getfield [30] 
L58:    invokespecial [45] 
L61:    ldc [14] 
L63:    invokespecial [46] 
L66:    astore_2 
L67:    iconst_0 
L68:    istore_3 
L69:    iload_3 
L70:    aload_1 
L71:    arraylength 
L72:    if_icmpge L131 
L75:    aload_0 
L76:    getfield [28] 
L79:    aload_1 
L80:    iload_3 
L81:    aaload 
L82:    aload_0 
L83:    getfield [29] 
L86:    invokeinterface [60] 0 
L91:    astore 4 
L93:    iconst_0 
L94:    istore 5 
L96:    iload 5 
L98:    aload 4 
L100:   arraylength 
L101:   if_icmpge L125 
L104:   aload_2 
L105:   aload 4 
L107:   iload 5 
L109:   aaload 
L110:   invokevirtual [38] 
L113:   aload_2 
L114:   ldc [15] 
L116:   invokevirtual [38] 
L119:   iinc 5 1 
L122:   goto L96 
L125:   iinc 3 1 
L128:   goto L69 
L131:   aload_2 
L132:   ifnull L205 
        .catch [16] from L135 to L139 using L142 
        .catch [16] from L46 to L131 using L146 
L135:   aload_2 
L136:   invokevirtual [39] 
L139:   goto L205 
L142:   astore_3 
L143:   goto L205 
L146:   astore_3 
L147:   getstatic [8] 
L150:   new [57] 
L153:   dup 
L154:   invokespecial [44] 
L157:   ldc [17] 
L159:   invokevirtual [34] 
L162:   aload_3 
L163:   invokevirtual [40] 
L166:   invokevirtual [36] 
L169:   invokevirtual [37] 
L172:   aload_2 
L173:   ifnull L205 
        .catch [16] from L176 to L180 using L183 
        .catch [0] from L46 to L131 using L187 
        .catch [0] from L146 to L172 using L187 
L176:   aload_2 
L177:   invokevirtual [39] 
L180:   goto L205 
L183:   astore_3 
L184:   goto L205 
L187:   astore 6 
L189:   aload_2 
L190:   ifnull L202 
        .catch [16] from L193 to L197 using L200 
        .catch [0] from L187 to L189 using L187 
L193:   aload_2 
L194:   invokevirtual [39] 
L197:   goto L202 
L200:   astore 7 
L202:   aload 6 
L204:   athrow 
L205:   return 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [61] 
.const [3] = String [62] 
.const [4] = String [63] 
.const [5] = String [64] 
.const [6] = String [65] 
.const [7] = Class [66] 
.const [8] = Field [67] [68] 
.const [9] = Class [69] 
.const [10] = String [70] 
.const [11] = String [71] 
.const [12] = Class [72] 
.const [13] = Class [73] 
.const [14] = String [74] 
.const [15] = String [75] 
.const [16] = Class [76] 
.const [17] = String [77] 
.const [18] = Class [78] 
.const [19] = Class [79] 
.const [20] = Class [80] 
.const [21] = Class [81] 
.const [22] = Class [82] 
.const [23] = Class [83] 
.const [24] = Class [84] 
.const [25] = Class [85] 
.const [26] = Class [86] 
.const [27] = Method [87] [88] 
.const [28] = Field [89] [90] 
.const [29] = Field [91] [92] 
.const [30] = Field [93] [94] 
.const [31] = Field [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Method [113] [114] 
.const [41] = Method [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Method [123] [124] 
.const [46] = Method [125] [126] 
.const [47] = InterfaceMethod [127] [128] 
.const [48] = InterfaceMethod [129] [130] 
.const [49] = Field [131] [132] 
.const [50] = InterfaceMethod [133] [134] 
.const [51] = Field [135] [136] 
.const [52] = InterfaceMethod [137] [138] 
.const [53] = InterfaceMethod [139] [140] 
.const [54] = Field [141] [142] 
.const [55] = Class [143] 
.const [56] = Field [144] [145] 
.const [57] = Class [146] 
.const [58] = Class [147] 
.const [59] = Class [148] 
.const [60] = InterfaceMethod [149] [150] 
.const [61] = Utf8 EmergencyRecorder 
.const [62] = Utf8 formatter 
.const [63] = Utf8 numMessages 
.const [64] = Utf8 path 
.const [65] = Utf8 'er.log' 
.const [66] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [67] = Class [151] 
.const [68] = NameAndType [152] [153] 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 'Dumping ' 
.const [71] = Utf8 ' messages' 
.const [72] = Utf8 java/io/OutputStreamWriter 
.const [73] = Utf8 java/io/FileOutputStream 
.const [74] = Utf8 UTF-8 
.const [75] = Utf8 '\n' 
.const [76] = Utf8 java/io/IOException 
.const [77] = Utf8 'ERROR writing ER log: ' 
.const [78] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [79] = Utf8 de/esolutions/fw/util/tracing/backend/AbstractTraceBackend 
.const [80] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [81] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [82] = Utf8 de/esolutions/fw/util/tracing/backend/ITraceBackendListener 
.const [83] = Utf8 java/lang/System 
.const [84] = Utf8 java/io/PrintStream 
.const [85] = Utf8 de/esolutions/fw/util/tracing/format/ITraceMessageFormatter 
.const [86] = Utf8 java/io/Writer 
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
.const [129] = Class [217] 
.const [130] = NameAndType [218] [219] 
.const [131] = Class [220] 
.const [132] = NameAndType [221] [222] 
.const [133] = Class [223] 
.const [134] = NameAndType [224] [225] 
.const [135] = Class [226] 
.const [136] = NameAndType [227] [228] 
.const [137] = Class [229] 
.const [138] = NameAndType [230] [231] 
.const [139] = Class [232] 
.const [140] = NameAndType [233] [234] 
.const [141] = Class [235] 
.const [142] = NameAndType [236] [237] 
.const [143] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [144] = Class [238] 
.const [145] = NameAndType [239] [240] 
.const [146] = Utf8 java/lang/StringBuffer 
.const [147] = Utf8 java/io/OutputStreamWriter 
.const [148] = Utf8 java/io/FileOutputStream 
.const [149] = Class [241] 
.const [150] = NameAndType [242] [243] 
.const [151] = Utf8 java/lang/System 
.const [152] = Utf8 out 
.const [153] = Utf8 Ljava/io/PrintStream; 
.const [154] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [155] = Utf8 getQuery 
.const [156] = Utf8 ()Lde/esolutions/fw/util/config/query/IConfigQuery; 
.const [157] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [158] = Utf8 formatter 
.const [159] = Utf8 Lde/esolutions/fw/util/tracing/format/ITraceMessageFormatter; 
.const [160] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [161] = Utf8 resolver 
.const [162] = Utf8 Lde/esolutions/fw/util/tracing/format/ITraceEntityResolver; 
.const [163] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [164] = Utf8 filePath 
.const [165] = Utf8 Ljava/lang/String; 
.const [166] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [167] = Utf8 buffer 
.const [168] = Utf8 Lde/esolutions/fw/util/tracing/message/TraceMessageBuffer; 
.const [169] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [170] = Utf8 put 
.const [171] = Utf8 (Lde/esolutions/fw/util/tracing/message/ITraceMessage;Z)Z 
.const [172] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [173] = Utf8 getAll 
.const [174] = Utf8 ()[Lde/esolutions/fw/util/tracing/message/ITraceMessage; 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 append 
.const [177] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 append 
.const [180] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [181] = Utf8 java/lang/StringBuffer 
.const [182] = Utf8 toString 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 java/io/PrintStream 
.const [185] = Utf8 println 
.const [186] = Utf8 (Ljava/lang/String;)V 
.const [187] = Utf8 java/io/Writer 
.const [188] = Utf8 write 
.const [189] = Utf8 (Ljava/lang/String;)V 
.const [190] = Utf8 java/io/Writer 
.const [191] = Utf8 close 
.const [192] = Utf8 ()V 
.const [193] = Utf8 java/lang/StringBuffer 
.const [194] = Utf8 append 
.const [195] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [196] = Utf8 de/esolutions/fw/util/tracing/backend/AbstractTraceBackend 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (Ljava/lang/String;)V 
.const [199] = Utf8 de/esolutions/fw/util/tracing/backend/AbstractTraceBackend 
.const [200] = Utf8 init 
.const [201] = Utf8 (SLde/esolutions/fw/util/tracing/backend/ITraceBackendListener;Lde/esolutions/fw/util/tracing/config/TraceConfigBackend;)V 
.const [202] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (I)V 
.const [205] = Utf8 java/lang/StringBuffer 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 java/io/FileOutputStream 
.const [209] = Utf8 <init> 
.const [210] = Utf8 (Ljava/lang/String;)V 
.const [211] = Utf8 java/io/OutputStreamWriter 
.const [212] = Utf8 <init> 
.const [213] = Utf8 (Ljava/io/OutputStream;Ljava/lang/String;)V 
.const [214] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [215] = Utf8 getStringValue 
.const [216] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [217] = Utf8 de/esolutions/fw/util/tracing/backend/ITraceBackendListener 
.const [218] = Utf8 createFormatter 
.const [219] = Utf8 (Ljava/lang/String;Z)Lde/esolutions/fw/util/tracing/format/ITraceMessageFormatter; 
.const [220] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [221] = Utf8 formatter 
.const [222] = Utf8 Lde/esolutions/fw/util/tracing/format/ITraceMessageFormatter; 
.const [223] = Utf8 de/esolutions/fw/util/tracing/backend/ITraceBackendListener 
.const [224] = Utf8 getEntityResolver 
.const [225] = Utf8 ()Lde/esolutions/fw/util/tracing/format/ITraceEntityResolver; 
.const [226] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [227] = Utf8 resolver 
.const [228] = Utf8 Lde/esolutions/fw/util/tracing/format/ITraceEntityResolver; 
.const [229] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [230] = Utf8 getIntegerValue 
.const [231] = Utf8 (Ljava/lang/String;I)I 
.const [232] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [233] = Utf8 getStringValue 
.const [234] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [235] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [236] = Utf8 filePath 
.const [237] = Utf8 Ljava/lang/String; 
.const [238] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [239] = Utf8 buffer 
.const [240] = Utf8 Lde/esolutions/fw/util/tracing/message/TraceMessageBuffer; 
.const [241] = Utf8 de/esolutions/fw/util/tracing/format/ITraceMessageFormatter 
.const [242] = Utf8 formatMessage 
.const [243] = Utf8 (Lde/esolutions/fw/util/tracing/message/ITraceMessage;Lde/esolutions/fw/util/tracing/format/ITraceEntityResolver;)[Ljava/lang/String; 
.const [244] = Utf8 de/esolutions/fw/util/tracing/backend/EmergencyRecorderBackend 
.const [245] = Class [244] 
.const [246] = Utf8 de/esolutions/fw/util/tracing/backend/AbstractTraceBackend 
.const [247] = Class [246] 
.const [248] = Utf8 buffer 
.const [249] = Utf8 Lde/esolutions/fw/util/tracing/message/TraceMessageBuffer; 
.const [250] = Utf8 filePath 
.const [251] = Utf8 Ljava/lang/String; 
.const [252] = Utf8 formatter 
.const [253] = Utf8 Lde/esolutions/fw/util/tracing/format/ITraceMessageFormatter; 
.const [254] = Utf8 resolver 
.const [255] = Utf8 Lde/esolutions/fw/util/tracing/format/ITraceEntityResolver; 
.const [256] = Utf8 Code 
.const [257] = Utf8 <init> 
.const [258] = Utf8 ()V 
.const [259] = Utf8 init 
.const [260] = Utf8 (SLde/esolutions/fw/util/tracing/backend/ITraceBackendListener;Lde/esolutions/fw/util/tracing/config/TraceConfigBackend;)V 
.const [261] = Utf8 exit 
.const [262] = Utf8 ()V 
.const [263] = Utf8 log 
.const [264] = Utf8 (Lde/esolutions/fw/util/tracing/message/ITraceMessage;)Z 
.const [265] = Utf8 handleBreak 
.const [266] = Utf8 ()V 
.end class 
