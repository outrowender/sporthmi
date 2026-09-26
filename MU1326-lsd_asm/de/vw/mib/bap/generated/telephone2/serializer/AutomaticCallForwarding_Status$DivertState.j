.version 50 0 
.class public final super [225] 
.super [227] 
.implements [229] 
.field private static final [230] [231] 
.field public [232] [233] 
.field public [234] [235] 
.field public [236] [237] 
.field public [238] [239] 
.field public [240] [241] 
.field public [242] [243] 
.field public [244] [245] 
.field public [246] [247] 
.field private static final [248] [249] 

.method public [251] : [252] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     invokespecial [40] 
L8:     aload_0 
L9:     invokespecial [41] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [28] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [255] : [256] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [44] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [45] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [46] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [47] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [48] 
L25:    aload_0 
L26:    iconst_0 
L27:    putfield [49] 
L30:    aload_0 
L31:    iconst_0 
L32:    putfield [50] 
L35:    aload_0 
L36:    iconst_0 
L37:    putfield [51] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [250] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [29] 
L9:     aload_2 
L10:    getfield [29] 
L13:    if_icmpne L97 
L16:    aload_0 
L17:    getfield [30] 
L20:    aload_2 
L21:    getfield [30] 
L24:    if_icmpne L97 
L27:    aload_0 
L28:    getfield [31] 
L31:    aload_2 
L32:    getfield [31] 
L35:    if_icmpne L97 
L38:    aload_0 
L39:    getfield [32] 
L42:    aload_2 
L43:    getfield [32] 
L46:    if_icmpne L97 
L49:    aload_0 
L50:    getfield [33] 
L53:    aload_2 
L54:    getfield [33] 
L57:    if_icmpne L97 
L60:    aload_0 
L61:    getfield [34] 
L64:    aload_2 
L65:    getfield [34] 
L68:    if_icmpne L97 
L71:    aload_0 
L72:    getfield [35] 
L75:    aload_2 
L76:    getfield [35] 
L79:    if_icmpne L97 
L82:    aload_0 
L83:    getfield [36] 
L86:    aload_2 
L87:    getfield [36] 
L90:    if_icmpne L97 
L93:    iconst_1 
L94:    goto L98 
L97:    iconst_0 
L98:    areturn 
L99:    nop 
L100:   
    .end code 
.end method 

.method private enum [261] : [262] 
    .attribute [250] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [250] .code stack 2 locals 1 
L0:     new [52] 
L3:     dup 
L4:     invokespecial [43] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [37] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [37] 
L21:    pop 
L22:    aload_0 
L23:    getfield [29] 
L26:    ifeq L39 
L29:    aload_1 
L30:    ldc [6] 
L32:    invokevirtual [37] 
L35:    pop 
L36:    goto L46 
L39:    aload_1 
L40:    ldc [7] 
L42:    invokevirtual [37] 
L45:    pop 
L46:    aload_1 
L47:    ldc [8] 
L49:    invokevirtual [37] 
L52:    pop 
L53:    aload_0 
L54:    getfield [30] 
L57:    ifeq L70 
L60:    aload_1 
L61:    ldc [9] 
L63:    invokevirtual [37] 
L66:    pop 
L67:    goto L77 
L70:    aload_1 
L71:    ldc [10] 
L73:    invokevirtual [37] 
L76:    pop 
L77:    aload_1 
L78:    ldc [11] 
L80:    invokevirtual [37] 
L83:    pop 
L84:    aload_0 
L85:    getfield [31] 
L88:    ifeq L101 
L91:    aload_1 
L92:    ldc [12] 
L94:    invokevirtual [37] 
L97:    pop 
L98:    goto L108 
L101:   aload_1 
L102:   ldc [13] 
L104:   invokevirtual [37] 
L107:   pop 
L108:   aload_1 
L109:   ldc [14] 
L111:   invokevirtual [37] 
L114:   pop 
L115:   aload_0 
L116:   getfield [32] 
L119:   ifeq L132 
L122:   aload_1 
L123:   ldc [15] 
L125:   invokevirtual [37] 
L128:   pop 
L129:   goto L139 
L132:   aload_1 
L133:   ldc [13] 
L135:   invokevirtual [37] 
L138:   pop 
L139:   aload_1 
L140:   ldc [16] 
L142:   invokevirtual [37] 
L145:   pop 
L146:   aload_0 
L147:   getfield [33] 
L150:   ifeq L163 
L153:   aload_1 
L154:   ldc [17] 
L156:   invokevirtual [37] 
L159:   pop 
L160:   goto L170 
L163:   aload_1 
L164:   ldc [13] 
L166:   invokevirtual [37] 
L169:   pop 
L170:   aload_1 
L171:   ldc [18] 
L173:   invokevirtual [37] 
L176:   pop 
L177:   aload_0 
L178:   getfield [34] 
L181:   ifeq L194 
L184:   aload_1 
L185:   ldc [19] 
L187:   invokevirtual [37] 
L190:   pop 
L191:   goto L201 
L194:   aload_1 
L195:   ldc [13] 
L197:   invokevirtual [37] 
L200:   pop 
L201:   aload_1 
L202:   ldc [20] 
L204:   invokevirtual [37] 
L207:   pop 
L208:   aload_0 
L209:   getfield [35] 
L212:   ifeq L225 
L215:   aload_1 
L216:   ldc [21] 
L218:   invokevirtual [37] 
L221:   pop 
L222:   goto L232 
L225:   aload_1 
L226:   ldc [22] 
L228:   invokevirtual [37] 
L231:   pop 
L232:   aload_1 
L233:   ldc [23] 
L235:   invokevirtual [37] 
L238:   pop 
L239:   aload_0 
L240:   getfield [36] 
L243:   ifeq L256 
L246:   aload_1 
L247:   ldc [24] 
L249:   invokevirtual [37] 
L252:   pop 
L253:   goto L263 
L256:   aload_1 
L257:   ldc [25] 
L259:   invokevirtual [37] 
L262:   pop 
L263:   aload_1 
L264:   invokevirtual [38] 
L267:   areturn 
L268:   
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [250] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 16 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_1 
L1:     bipush 8 
L3:     invokeinterface [53] 0 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [29] 
L13:    invokeinterface [54] 0 
L18:    aload_1 
L19:    aload_0 
L20:    getfield [30] 
L23:    invokeinterface [54] 0 
L28:    aload_1 
L29:    aload_0 
L30:    getfield [31] 
L33:    invokeinterface [54] 0 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [32] 
L43:    invokeinterface [54] 0 
L48:    aload_1 
L49:    aload_0 
L50:    getfield [33] 
L53:    invokeinterface [54] 0 
L58:    aload_1 
L59:    aload_0 
L60:    getfield [34] 
L63:    invokeinterface [54] 0 
L68:    aload_1 
L69:    aload_0 
L70:    getfield [35] 
L73:    invokeinterface [54] 0 
L78:    aload_1 
L79:    aload_0 
L80:    getfield [36] 
L83:    invokeinterface [54] 0 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_1 
L1:     bipush 8 
L3:     invokeinterface [55] 0 
L8:     aload_0 
L9:     aload_1 
L10:    invokeinterface [56] 0 
L15:    putfield [44] 
L18:    aload_0 
L19:    aload_1 
L20:    invokeinterface [56] 0 
L25:    putfield [45] 
L28:    aload_0 
L29:    aload_1 
L30:    invokeinterface [56] 0 
L35:    putfield [46] 
L38:    aload_0 
L39:    aload_1 
L40:    invokeinterface [56] 0 
L45:    putfield [47] 
L48:    aload_0 
L49:    aload_1 
L50:    invokeinterface [56] 0 
L55:    putfield [48] 
L58:    aload_0 
L59:    aload_1 
L60:    invokeinterface [56] 0 
L65:    putfield [49] 
L68:    aload_0 
L69:    aload_1 
L70:    invokeinterface [56] 0 
L75:    putfield [50] 
L78:    aload_0 
L79:    aload_1 
L80:    invokeinterface [56] 0 
L85:    putfield [51] 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = Class [58] 
.const [4] = String [59] 
.const [5] = String [60] 
.const [6] = String [61] 
.const [7] = String [62] 
.const [8] = String [63] 
.const [9] = String [64] 
.const [10] = String [65] 
.const [11] = String [66] 
.const [12] = String [67] 
.const [13] = String [68] 
.const [14] = String [69] 
.const [15] = String [70] 
.const [16] = String [71] 
.const [17] = String [72] 
.const [18] = String [73] 
.const [19] = String [74] 
.const [20] = String [75] 
.const [21] = String [76] 
.const [22] = String [77] 
.const [23] = String [78] 
.const [24] = String [79] 
.const [25] = String [80] 
.const [26] = Class [81] 
.const [27] = Class [82] 
.const [28] = Method [83] [84] 
.const [29] = Field [85] [86] 
.const [30] = Field [87] [88] 
.const [31] = Field [89] [90] 
.const [32] = Field [91] [92] 
.const [33] = Field [93] [94] 
.const [34] = Field [95] [96] 
.const [35] = Field [97] [98] 
.const [36] = Field [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Method [111] [112] 
.const [43] = Method [113] [114] 
.const [44] = Field [115] [116] 
.const [45] = Field [117] [118] 
.const [46] = Field [119] [120] 
.const [47] = Field [121] [122] 
.const [48] = Field [123] [124] 
.const [49] = Field [125] [126] 
.const [50] = Field [127] [128] 
.const [51] = Field [129] [130] 
.const [52] = Class [131] 
.const [53] = InterfaceMethod [132] [133] 
.const [54] = InterfaceMethod [134] [135] 
.const [55] = InterfaceMethod [136] [137] 
.const [56] = InterfaceMethod [138] [139] 
.const [57] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'DivertState:' 
.const [60] = Utf8 '\n - Bit 7: ' 
.const [61] = Utf8 'true  (fowarding all data calls' 
.const [62] = Utf8 'false  (forwarding all data calls inactive' 
.const [63] = Utf8 '\n - Bit 6: ' 
.const [64] = Utf8 'true  (forwarding all fax calls' 
.const [65] = Utf8 'false  (fowarding all fax calls inactive' 
.const [66] = Utf8 '\n - Bit 5: ' 
.const [67] = Utf8 'true  (forwarding all voice calls (CF unconditional for voice calls)' 
.const [68] = Utf8 'false  (forwarding inactive' 
.const [69] = Utf8 '\n - Bit 4: ' 
.const [70] = Utf8 'true  (forwarding if not available' 
.const [71] = Utf8 '\n - Bit 3: ' 
.const [72] = Utf8 'true  (forwarding if out of reach' 
.const [73] = Utf8 '\n - Bit 2: ' 
.const [74] = Utf8 'true  (forwarding if not answered (CF no reply)' 
.const [75] = Utf8 '\n - Bit 1: ' 
.const [76] = Utf8 'true  (forwarding if busy (CF busy)' 
.const [77] = Utf8 'false  (forwarding if busy inactive' 
.const [78] = Utf8 '\n - Bit 0: ' 
.const [79] = Utf8 'true  (forwarding state valid' 
.const [80] = Utf8 'false  (forwarding state invalid / unknown' 
.const [81] = Utf8 java/lang/Object 
.const [82] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [83] = Class [140] 
.const [84] = NameAndType [141] [142] 
.const [85] = Class [143] 
.const [86] = NameAndType [144] [145] 
.const [87] = Class [146] 
.const [88] = NameAndType [147] [148] 
.const [89] = Class [149] 
.const [90] = NameAndType [150] [151] 
.const [91] = Class [152] 
.const [92] = NameAndType [153] [154] 
.const [93] = Class [155] 
.const [94] = NameAndType [156] [157] 
.const [95] = Class [158] 
.const [96] = NameAndType [159] [160] 
.const [97] = Class [161] 
.const [98] = NameAndType [162] [163] 
.const [99] = Class [164] 
.const [100] = NameAndType [165] [166] 
.const [101] = Class [167] 
.const [102] = NameAndType [168] [169] 
.const [103] = Class [170] 
.const [104] = NameAndType [171] [172] 
.const [105] = Class [173] 
.const [106] = NameAndType [174] [175] 
.const [107] = Class [176] 
.const [108] = NameAndType [177] [178] 
.const [109] = Class [179] 
.const [110] = NameAndType [180] [181] 
.const [111] = Class [182] 
.const [112] = NameAndType [183] [184] 
.const [113] = Class [185] 
.const [114] = NameAndType [186] [187] 
.const [115] = Class [188] 
.const [116] = NameAndType [189] [190] 
.const [117] = Class [191] 
.const [118] = NameAndType [192] [193] 
.const [119] = Class [194] 
.const [120] = NameAndType [195] [196] 
.const [121] = Class [197] 
.const [122] = NameAndType [198] [199] 
.const [123] = Class [200] 
.const [124] = NameAndType [201] [202] 
.const [125] = Class [203] 
.const [126] = NameAndType [204] [205] 
.const [127] = Class [206] 
.const [128] = NameAndType [207] [208] 
.const [129] = Class [209] 
.const [130] = NameAndType [210] [211] 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Class [212] 
.const [133] = NameAndType [213] [214] 
.const [134] = Class [215] 
.const [135] = NameAndType [216] [217] 
.const [136] = Class [218] 
.const [137] = NameAndType [219] [220] 
.const [138] = Class [221] 
.const [139] = NameAndType [222] [223] 
.const [140] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [141] = Utf8 deserialize 
.const [142] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [143] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [144] = Utf8 fowardingAllDataCalls 
.const [145] = Utf8 Z 
.const [146] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [147] = Utf8 forwardingAllFaxCalls 
.const [148] = Utf8 Z 
.const [149] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [150] = Utf8 forwardingAllVoiceCalls 
.const [151] = Utf8 Z 
.const [152] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [153] = Utf8 forwardingIfNotAvailable 
.const [154] = Utf8 Z 
.const [155] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [156] = Utf8 forwardingIfOutOfReach 
.const [157] = Utf8 Z 
.const [158] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [159] = Utf8 forwardingIfNotAnswered 
.const [160] = Utf8 Z 
.const [161] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [162] = Utf8 forwardingIfBusy 
.const [163] = Utf8 Z 
.const [164] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [165] = Utf8 forwardingStateValid 
.const [166] = Utf8 Z 
.const [167] = Utf8 java/lang/StringBuffer 
.const [168] = Utf8 append 
.const [169] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 toString 
.const [172] = Utf8 ()Ljava/lang/String; 
.const [173] = Utf8 java/lang/Object 
.const [174] = Utf8 <init> 
.const [175] = Utf8 ()V 
.const [176] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [177] = Utf8 internalReset 
.const [178] = Utf8 ()V 
.const [179] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [180] = Utf8 customInitialization 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [183] = Utf8 <init> 
.const [184] = Utf8 ()V 
.const [185] = Utf8 java/lang/StringBuffer 
.const [186] = Utf8 <init> 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [189] = Utf8 fowardingAllDataCalls 
.const [190] = Utf8 Z 
.const [191] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [192] = Utf8 forwardingAllFaxCalls 
.const [193] = Utf8 Z 
.const [194] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [195] = Utf8 forwardingAllVoiceCalls 
.const [196] = Utf8 Z 
.const [197] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [198] = Utf8 forwardingIfNotAvailable 
.const [199] = Utf8 Z 
.const [200] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [201] = Utf8 forwardingIfOutOfReach 
.const [202] = Utf8 Z 
.const [203] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [204] = Utf8 forwardingIfNotAnswered 
.const [205] = Utf8 Z 
.const [206] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [207] = Utf8 forwardingIfBusy 
.const [208] = Utf8 Z 
.const [209] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [210] = Utf8 forwardingStateValid 
.const [211] = Utf8 Z 
.const [212] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [213] = Utf8 resetBits 
.const [214] = Utf8 (I)V 
.const [215] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [216] = Utf8 pushBoolean 
.const [217] = Utf8 (Z)V 
.const [218] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [219] = Utf8 discardBits 
.const [220] = Utf8 (I)V 
.const [221] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [222] = Utf8 popFrontBoolean 
.const [223] = Utf8 ()Z 
.const [224] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/AutomaticCallForwarding_Status$DivertState 
.const [225] = Class [224] 
.const [226] = Utf8 java/lang/Object 
.const [227] = Class [226] 
.const [228] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [229] = Class [228] 
.const [230] = Utf8 RESERVED_BIT_8__15_BITSIZE 
.const [231] = Utf8 I 
.const [232] = Utf8 fowardingAllDataCalls 
.const [233] = Utf8 Z 
.const [234] = Utf8 forwardingAllFaxCalls 
.const [235] = Utf8 Z 
.const [236] = Utf8 forwardingAllVoiceCalls 
.const [237] = Utf8 Z 
.const [238] = Utf8 forwardingIfNotAvailable 
.const [239] = Utf8 Z 
.const [240] = Utf8 forwardingIfOutOfReach 
.const [241] = Utf8 Z 
.const [242] = Utf8 forwardingIfNotAnswered 
.const [243] = Utf8 Z 
.const [244] = Utf8 forwardingIfBusy 
.const [245] = Utf8 Z 
.const [246] = Utf8 forwardingStateValid 
.const [247] = Utf8 Z 
.const [248] = Utf8 DIVERT_STATE_BITSIZE 
.const [249] = Utf8 I 
.const [250] = Utf8 Code 
.const [251] = Utf8 <init> 
.const [252] = Utf8 ()V 
.const [253] = Utf8 <init> 
.const [254] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [255] = Utf8 internalReset 
.const [256] = Utf8 ()V 
.const [257] = Utf8 reset 
.const [258] = Utf8 ()V 
.const [259] = Utf8 equalTo 
.const [260] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [261] = Utf8 customInitialization 
.const [262] = Utf8 ()V 
.const [263] = Utf8 toString 
.const [264] = Utf8 ()Ljava/lang/String; 
.const [265] = Utf8 bitSize 
.const [266] = Utf8 ()I 
.const [267] = Utf8 serialize 
.const [268] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [269] = Utf8 deserialize 
.const [270] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.end class 
