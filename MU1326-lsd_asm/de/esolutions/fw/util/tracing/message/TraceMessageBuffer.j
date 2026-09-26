.version 50 0 
.class public super [177] 
.super [179] 
.field private [180] [181] 
.field private [182] [183] 
.field private [184] [185] 
.field private [186] [187] 

.method public [189] : [190] 
    .attribute [188] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     new [26] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [23] 
L13:    putfield [27] 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [28] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [191] : [192] 
    .attribute [188] .code stack 5 locals 2 
L0:     iload_2 
L1:     ifne L25 
L4:     aload_0 
L5:     getfield [7] 
L8:     invokevirtual [9] 
L11:    ifeq L25 
        .catch [3] from L14 to L18 using L21 
L14:    aload_0 
L15:    invokespecial [24] 
L18:    goto L4 
L21:    astore_3 
L22:    goto L4 
L25:    aload_1 
L26:    aload_0 
L27:    dup 
L28:    getfield [8] 
L31:    dup_x1 
L32:    iconst_1 
L33:    iadd 
L34:    putfield [28] 
L37:    invokeinterface [29] 0 
L42:    aload_0 
L43:    getfield [7] 
L46:    invokevirtual [10] 
L49:    astore_3 
L50:    aload_3 
L51:    ifnull L79 
L54:    aload_3 
L55:    checkcast [4] 
L58:    astore 4 
L60:    aload_0 
L61:    dup 
L62:    getfield [11] 
L65:    aload 4 
L67:    invokeinterface [31] 0 
L72:    isub 
L73:    putfield [30] 
L76:    goto L89 
L79:    aload_0 
L80:    dup 
L81:    getfield [12] 
L84:    iconst_1 
L85:    iadd 
L86:    putfield [32] 
L89:    aload_0 
L90:    dup 
L91:    getfield [11] 
L94:    aload_1 
L95:    invokeinterface [31] 0 
L100:   iadd 
L101:   putfield [30] 
L104:   aload_0 
L105:   getfield [7] 
L108:   aload_1 
L109:   invokevirtual [13] 
L112:   areturn 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public synchronized [193] : [194] 
    .attribute [188] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [8] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [28] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [195] : [196] 
    .attribute [188] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [8] 
L5:     iload_1 
L6:     iadd 
L7:     putfield [28] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [197] : [198] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iconst_1 
L5:     isub 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [199] : [200] 
    .attribute [188] .code stack 5 locals 8 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [14] 
L7:     istore_3 
L8:     iload_3 
L9:     ifne L14 
L12:    aconst_null 
L13:    areturn 
L14:    iload_3 
L15:    istore 4 
L17:    iconst_0 
L18:    istore 5 
L20:    aload_0 
L21:    getfield [7] 
L24:    invokevirtual [15] 
L27:    checkcast [4] 
L30:    astore 6 
L32:    aload 6 
L34:    ifnonnull L39 
L37:    aconst_null 
L38:    areturn 
L39:    aload 6 
L41:    invokeinterface [33] 0 
L46:    istore 7 
L48:    iload 7 
L50:    iload_1 
L51:    if_icmpge L100 
L54:    iinc 5 1 
L57:    iinc 4 -1 
L60:    iload 4 
L62:    ifne L67 
L65:    aconst_null 
L66:    areturn 
L67:    aload_0 
L68:    getfield [7] 
L71:    iload 5 
L73:    invokevirtual [16] 
L76:    checkcast [4] 
L79:    astore 6 
L81:    aload 6 
L83:    ifnonnull L88 
L86:    aconst_null 
L87:    areturn 
L88:    aload 6 
L90:    invokeinterface [33] 0 
L95:    istore 7 
L97:    goto L48 
L100:   iload 7 
L102:   istore 8 
L104:   iload 5 
L106:   istore 9 
L108:   iload 9 
L110:   iload_3 
L111:   if_icmpge L177 
L114:   aload_0 
L115:   getfield [7] 
L118:   iload 9 
L120:   invokevirtual [16] 
L123:   checkcast [4] 
L126:   astore 10 
L128:   aload 10 
L130:   ifnull L168 
L133:   aload 10 
L135:   invokeinterface [34] 0 
L140:   iload_2 
L141:   if_icmpgt L156 
L144:   aload 10 
L146:   invokeinterface [33] 0 
L151:   iload 8 
L153:   if_icmpeq L168 
L156:   iload 4 
L158:   iload_3 
L159:   iload 9 
L161:   isub 
L162:   isub 
L163:   istore 4 
L165:   goto L177 
L168:   iinc 8 1 
L171:   iinc 9 1 
L174:   goto L108 
L177:   iload 4 
L179:   ifne L184 
L182:   aconst_null 
L183:   areturn 
L184:   iload 4 
L186:   anewarray [4] 
L189:   astore 9 
L191:   iconst_0 
L192:   istore 10 
L194:   iload 10 
L196:   iload 4 
L198:   if_icmpge L227 
L201:   aload 9 
L203:   iload 10 
L205:   aload_0 
L206:   getfield [7] 
L209:   iload 10 
L211:   iload 5 
L213:   iadd 
L214:   invokevirtual [16] 
L217:   checkcast [4] 
L220:   aastore 
L221:   iinc 10 1 
L224:   goto L194 
L227:   aload 9 
L229:   areturn 
L230:   nop 
L231:   nop 
L232:   
    .end code 
.end method 

.method public synchronized [201] : [202] 
    .attribute [188] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [14] 
L7:     istore_1 
L8:     iload_1 
L9:     ifne L14 
L12:    aconst_null 
L13:    areturn 
L14:    iload_1 
L15:    anewarray [4] 
L18:    astore_2 
L19:    iconst_0 
L20:    istore_3 
L21:    aload_0 
L22:    getfield [7] 
L25:    invokevirtual [17] 
L28:    ifne L50 
L31:    aload_2 
L32:    iload_3 
L33:    iinc 3 1 
L36:    aload_0 
L37:    getfield [7] 
L40:    invokevirtual [18] 
L43:    checkcast [4] 
L46:    aastore 
L47:    goto L21 
L50:    aload_0 
L51:    iconst_0 
L52:    putfield [32] 
L55:    aload_0 
L56:    iconst_0 
L57:    putfield [30] 
L60:    aload_2 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public synchronized [203] : [204] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [19] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [32] 
L12:    aload_0 
L13:    iconst_0 
L14:    putfield [30] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [205] : [206] 
    .attribute [188] .code stack 3 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [7] 
L6:     invokevirtual [17] 
L9:     ifeq L15 
L12:    goto L82 
L15:    aload_0 
L16:    getfield [7] 
L19:    invokevirtual [15] 
L22:    checkcast [4] 
L25:    astore_3 
L26:    aload_3 
L27:    ifnull L43 
L30:    aload_3 
L31:    invokeinterface [33] 0 
L36:    iload_1 
L37:    if_icmplt L43 
L40:    goto L82 
L43:    aload_0 
L44:    dup 
L45:    getfield [12] 
L48:    iconst_1 
L49:    isub 
L50:    putfield [32] 
L53:    aload_0 
L54:    dup 
L55:    getfield [11] 
L58:    aload_3 
L59:    invokeinterface [31] 0 
L64:    isub 
L65:    putfield [30] 
L68:    aload_0 
L69:    getfield [7] 
L72:    invokevirtual [18] 
L75:    pop 
L76:    iinc 2 1 
L79:    goto L2 
L82:    iload_2 
L83:    ifle L90 
L86:    aload_0 
L87:    invokespecial [25] 
L90:    iload_2 
L91:    areturn 
L92:    
    .end code 
.end method 

.method public synchronized [207] : [208] 
    .attribute [188] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [14] 
L7:     ifle L68 
L10:    aload_0 
L11:    getfield [7] 
L14:    invokevirtual [14] 
L17:    iload_1 
L18:    if_icmple L68 
L21:    aload_0 
L22:    getfield [7] 
L25:    invokevirtual [15] 
L28:    checkcast [4] 
L31:    astore_2 
L32:    aload_0 
L33:    dup 
L34:    getfield [12] 
L37:    iconst_1 
L38:    isub 
L39:    putfield [32] 
L42:    aload_0 
L43:    dup 
L44:    getfield [11] 
L47:    aload_2 
L48:    invokeinterface [31] 0 
L53:    isub 
L54:    putfield [30] 
L57:    aload_0 
L58:    getfield [7] 
L61:    invokevirtual [18] 
L64:    pop 
L65:    goto L0 
L68:    aload_0 
L69:    getfield [7] 
L72:    iload_1 
L73:    invokevirtual [20] 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public synchronized [209] : [210] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [17] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [211] : [212] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [14] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [213] : [214] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [21] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public synchronized [215] : [216] 
    .attribute [188] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     aload_0 
L6:     getfield [12] 
L9:     iastore 
L10:    dup 
L11:    iconst_1 
L12:    aload_0 
L13:    getfield [11] 
L16:    iastore 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = Class [37] 
.const [5] = Class [38] 
.const [6] = Class [39] 
.const [7] = Field [40] [41] 
.const [8] = Field [42] [43] 
.const [9] = Method [44] [45] 
.const [10] = Method [46] [47] 
.const [11] = Field [48] [49] 
.const [12] = Field [50] [51] 
.const [13] = Method [52] [53] 
.const [14] = Method [54] [55] 
.const [15] = Method [56] [57] 
.const [16] = Method [58] [59] 
.const [17] = Method [60] [61] 
.const [18] = Method [62] [63] 
.const [19] = Method [64] [65] 
.const [20] = Method [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Class [78] 
.const [27] = Field [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = InterfaceMethod [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = InterfaceMethod [87] [88] 
.const [32] = Field [89] [90] 
.const [33] = InterfaceMethod [91] [92] 
.const [34] = InterfaceMethod [93] [94] 
.const [35] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [36] = Utf8 java/lang/InterruptedException 
.const [37] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [38] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [39] = Utf8 java/lang/Object 
.const [40] = Class [95] 
.const [41] = NameAndType [96] [97] 
.const [42] = Class [98] 
.const [43] = NameAndType [99] [100] 
.const [44] = Class [101] 
.const [45] = NameAndType [102] [103] 
.const [46] = Class [104] 
.const [47] = NameAndType [105] [106] 
.const [48] = Class [107] 
.const [49] = NameAndType [108] [109] 
.const [50] = Class [110] 
.const [51] = NameAndType [111] [112] 
.const [52] = Class [113] 
.const [53] = NameAndType [114] [115] 
.const [54] = Class [116] 
.const [55] = NameAndType [117] [118] 
.const [56] = Class [119] 
.const [57] = NameAndType [120] [121] 
.const [58] = Class [122] 
.const [59] = NameAndType [123] [124] 
.const [60] = Class [125] 
.const [61] = NameAndType [126] [127] 
.const [62] = Class [128] 
.const [63] = NameAndType [129] [130] 
.const [64] = Class [131] 
.const [65] = NameAndType [132] [133] 
.const [66] = Class [134] 
.const [67] = NameAndType [135] [136] 
.const [68] = Class [137] 
.const [69] = NameAndType [138] [139] 
.const [70] = Class [140] 
.const [71] = NameAndType [141] [142] 
.const [72] = Class [143] 
.const [73] = NameAndType [144] [145] 
.const [74] = Class [146] 
.const [75] = NameAndType [147] [148] 
.const [76] = Class [149] 
.const [77] = NameAndType [150] [151] 
.const [78] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [79] = Class [152] 
.const [80] = NameAndType [153] [154] 
.const [81] = Class [155] 
.const [82] = NameAndType [156] [157] 
.const [83] = Class [158] 
.const [84] = NameAndType [159] [160] 
.const [85] = Class [161] 
.const [86] = NameAndType [162] [163] 
.const [87] = Class [164] 
.const [88] = NameAndType [165] [166] 
.const [89] = Class [167] 
.const [90] = NameAndType [168] [169] 
.const [91] = Class [170] 
.const [92] = NameAndType [171] [172] 
.const [93] = Class [173] 
.const [94] = NameAndType [174] [175] 
.const [95] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [96] = Utf8 buffer 
.const [97] = Utf8 Lde/esolutions/fw/util/tracing/message/RingBuffer; 
.const [98] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [99] = Utf8 seqNum 
.const [100] = Utf8 I 
.const [101] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [102] = Utf8 isFull 
.const [103] = Utf8 ()Z 
.const [104] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [105] = Utf8 peekNext 
.const [106] = Utf8 ()Ljava/lang/Object; 
.const [107] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [108] = Utf8 numBytes 
.const [109] = Utf8 I 
.const [110] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [111] = Utf8 numEntries 
.const [112] = Utf8 I 
.const [113] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [114] = Utf8 put 
.const [115] = Utf8 (Ljava/lang/Object;)Z 
.const [116] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [117] = Utf8 size 
.const [118] = Utf8 ()I 
.const [119] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [120] = Utf8 peekOldest 
.const [121] = Utf8 ()Ljava/lang/Object; 
.const [122] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [123] = Utf8 peekAt 
.const [124] = Utf8 (I)Ljava/lang/Object; 
.const [125] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [126] = Utf8 isEmpty 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [129] = Utf8 getOldest 
.const [130] = Utf8 ()Ljava/lang/Object; 
.const [131] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [132] = Utf8 dropAll 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [135] = Utf8 resize 
.const [136] = Utf8 (I)Z 
.const [137] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [138] = Utf8 capacity 
.const [139] = Utf8 ()I 
.const [140] = Utf8 java/lang/Object 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 de/esolutions/fw/util/tracing/message/RingBuffer 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (I)V 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 wait 
.const [148] = Utf8 ()V 
.const [149] = Utf8 java/lang/Object 
.const [150] = Utf8 notifyAll 
.const [151] = Utf8 ()V 
.const [152] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [153] = Utf8 buffer 
.const [154] = Utf8 Lde/esolutions/fw/util/tracing/message/RingBuffer; 
.const [155] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [156] = Utf8 seqNum 
.const [157] = Utf8 I 
.const [158] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [159] = Utf8 setSeqNum 
.const [160] = Utf8 (I)V 
.const [161] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [162] = Utf8 numBytes 
.const [163] = Utf8 I 
.const [164] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [165] = Utf8 getMessageSize 
.const [166] = Utf8 ()I 
.const [167] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [168] = Utf8 numEntries 
.const [169] = Utf8 I 
.const [170] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [171] = Utf8 getSeqNum 
.const [172] = Utf8 ()I 
.const [173] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [174] = Utf8 getEpoch 
.const [175] = Utf8 ()I 
.const [176] = Utf8 de/esolutions/fw/util/tracing/message/TraceMessageBuffer 
.const [177] = Class [176] 
.const [178] = Utf8 java/lang/Object 
.const [179] = Class [178] 
.const [180] = Utf8 buffer 
.const [181] = Utf8 Lde/esolutions/fw/util/tracing/message/RingBuffer; 
.const [182] = Utf8 seqNum 
.const [183] = Utf8 I 
.const [184] = Utf8 numEntries 
.const [185] = Utf8 I 
.const [186] = Utf8 numBytes 
.const [187] = Utf8 I 
.const [188] = Utf8 Code 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (I)V 
.const [191] = Utf8 put 
.const [192] = Utf8 (Lde/esolutions/fw/util/tracing/message/ITraceMessage;Z)Z 
.const [193] = Utf8 skipEntry 
.const [194] = Utf8 ()V 
.const [195] = Utf8 skipEntries 
.const [196] = Utf8 (I)V 
.const [197] = Utf8 getCurrentSequenceNumber 
.const [198] = Utf8 ()I 
.const [199] = Utf8 getMessageRange 
.const [200] = Utf8 (II)[Lde/esolutions/fw/util/tracing/message/ITraceMessage; 
.const [201] = Utf8 getAll 
.const [202] = Utf8 ()[Lde/esolutions/fw/util/tracing/message/ITraceMessage; 
.const [203] = Utf8 dropAll 
.const [204] = Utf8 ()V 
.const [205] = Utf8 dropUpToSeqNum 
.const [206] = Utf8 (I)I 
.const [207] = Utf8 resize 
.const [208] = Utf8 (I)Z 
.const [209] = Utf8 isEmpty 
.const [210] = Utf8 ()Z 
.const [211] = Utf8 size 
.const [212] = Utf8 ()I 
.const [213] = Utf8 capacity 
.const [214] = Utf8 ()I 
.const [215] = Utf8 getNumEntriesAndBytes 
.const [216] = Utf8 ()[I 
.end class 
