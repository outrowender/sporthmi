.version 50 0 
.class public super [293] 
.super [295] 
.field public final [296] [297] 
.field public final [298] [299] 
.field public final [300] [301] 
.field public final [302] [303] 
.field public final [304] [305] 
.field public final [306] [307] 
.field public final [308] [309] 
.field public final [310] [311] 
.field public final [312] [313] 
.field public final [314] [315] 
.field public [316] [317] 
.field public final [318] [319] 
.field public final [320] [321] 
.field private static final [322] [323] 
.field private static final [324] [325] 
.field private static final [326] [327] 
.field private static final [328] [329] 
.field private static final [330] [331] 

.method public [333] : [334] 
    .attribute [332] .code stack 2 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [21] 
L5:     invokespecial [44] 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [22] 
L13:    putfield [48] 
L16:    aload_0 
L17:    aload_1 
L18:    invokevirtual [24] 
L21:    putfield [49] 
L24:    aload_0 
L25:    aload_1 
L26:    invokevirtual [26] 
L29:    putfield [50] 
L32:    aload_0 
L33:    aload_1 
L34:    invokevirtual [28] 
L37:    putfield [51] 
L40:    aload_0 
L41:    aload_0 
L42:    invokespecial [45] 
L45:    putfield [52] 
L48:    aload_0 
L49:    aload_1 
L50:    invokevirtual [29] 
L53:    putfield [53] 
L56:    aload_0 
L57:    aload_1 
L58:    invokevirtual [31] 
L61:    putfield [54] 
L64:    aload_0 
L65:    aload_1 
L66:    invokevirtual [32] 
L69:    putfield [55] 
L72:    aload_0 
L73:    aload_1 
L74:    invokevirtual [34] 
L77:    putfield [56] 
L80:    aload_0 
L81:    aload_1 
L82:    invokevirtual [36] 
L85:    putfield [57] 
L88:    aload_1 
L89:    invokevirtual [38] 
L92:    astore_2 
L93:    aload_2 
L94:    ifnull L121 
L97:    aload_0 
L98:    aload_2 
L99:    invokeinterface [58] 0 
L104:   putfield [59] 
L107:   aload_0 
L108:   aload_2 
L109:   invokespecial [46] 
L112:   invokevirtual [39] 
L115:   putfield [60] 
L118:   goto L131 
L121:   aload_0 
L122:   aconst_null 
L123:   putfield [59] 
L126:   aload_0 
L127:   aconst_null 
L128:   putfield [60] 
L131:   aload_1 
L132:   invokevirtual [40] 
L135:   astore_3 
L136:   aload_3 
L137:   instanceof [2] 
L140:   ifeq L163 
L143:   aload_3 
L144:   checkcast [2] 
L147:   astore 4 
L149:   aload_0 
L150:   aload 4 
L152:   invokeinterface [61] 0 
L157:   putfield [62] 
L160:   goto L168 
L163:   aload_0 
L164:   iconst_m1 
L165:   putfield [62] 
L168:   return 
L169:   nop 
L170:   nop 
L171:   nop 
L172:   
    .end code 
.end method 

.method protected [335] : [336] 
    .attribute [332] .code stack 2 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_1 
L7:     invokevirtual [42] 
L10:    astore_2 
L11:    aload_2 
L12:    ldc [3] 
L14:    invokevirtual [43] 
L17:    ifeq L27 
L20:    aload_0 
L21:    getfield [27] 
L24:    ifeq L185 
L27:    aload_2 
L28:    ldc [4] 
L30:    invokevirtual [43] 
L33:    ifeq L43 
L36:    aload_0 
L37:    getfield [27] 
L40:    ifeq L185 
L43:    aload_2 
L44:    ldc [5] 
L46:    invokevirtual [43] 
L49:    ifeq L59 
L52:    aload_0 
L53:    getfield [27] 
L56:    ifeq L185 
L59:    aload_2 
L60:    ldc [6] 
L62:    invokevirtual [43] 
L65:    ifeq L76 
L68:    aload_0 
L69:    getfield [30] 
L72:    iconst_1 
L73:    if_icmpeq L185 
L76:    aload_2 
L77:    ldc [7] 
L79:    invokevirtual [43] 
L82:    ifeq L93 
L85:    aload_0 
L86:    getfield [41] 
L89:    iconst_m1 
L90:    if_icmpeq L185 
L93:    aload_2 
L94:    ldc [8] 
L96:    invokevirtual [43] 
L99:    ifeq L110 
L102:   aload_0 
L103:   getfield [25] 
L106:   iconst_m1 
L107:   if_icmpeq L185 
L110:   aload_2 
L111:   ldc [9] 
L113:   invokevirtual [43] 
L116:   ifeq L127 
L119:   aload_0 
L120:   getfield [37] 
L123:   iconst_m1 
L124:   if_icmpeq L185 
L127:   aload_2 
L128:   ldc [10] 
L130:   invokevirtual [43] 
L133:   ifeq L144 
L136:   aload_0 
L137:   getfield [30] 
L140:   iconst_1 
L141:   if_icmpeq L185 
L144:   aload_2 
L145:   ldc [10] 
L147:   invokevirtual [43] 
L150:   ifne L185 
L153:   aload_2 
L154:   ldc [11] 
L156:   invokevirtual [43] 
L159:   ifeq L169 
L162:   aload_0 
L163:   getfield [33] 
L166:   ifeq L185 
L169:   aload_2 
L170:   ldc [12] 
L172:   invokevirtual [43] 
L175:   ifeq L187 
L178:   aload_0 
L179:   getfield [35] 
L182:   ifne L187 
L185:   aconst_null 
L186:   areturn 
L187:   aload_0 
L188:   aload_1 
L189:   invokespecial [47] 
L192:   areturn 
L193:   nop 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 

.method public interface [337] : [338] 
    .attribute [332] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [63] 
.const [3] = String [64] 
.const [4] = String [65] 
.const [5] = String [66] 
.const [6] = String [67] 
.const [7] = String [68] 
.const [8] = String [69] 
.const [9] = String [70] 
.const [10] = String [71] 
.const [11] = String [72] 
.const [12] = String [73] 
.const [13] = Class [74] 
.const [14] = Class [75] 
.const [15] = Class [76] 
.const [16] = Class [77] 
.const [17] = Class [78] 
.const [18] = Class [79] 
.const [19] = Class [80] 
.const [20] = Class [81] 
.const [21] = Method [82] [83] 
.const [22] = Method [84] [85] 
.const [23] = Field [86] [87] 
.const [24] = Method [88] [89] 
.const [25] = Field [90] [91] 
.const [26] = Method [92] [93] 
.const [27] = Field [94] [95] 
.const [28] = Method [96] [97] 
.const [29] = Method [98] [99] 
.const [30] = Field [100] [101] 
.const [31] = Method [102] [103] 
.const [32] = Method [104] [105] 
.const [33] = Field [106] [107] 
.const [34] = Method [108] [109] 
.const [35] = Field [110] [111] 
.const [36] = Method [112] [113] 
.const [37] = Field [114] [115] 
.const [38] = Method [116] [117] 
.const [39] = Method [118] [119] 
.const [40] = Method [120] [121] 
.const [41] = Field [122] [123] 
.const [42] = Method [124] [125] 
.const [43] = Method [126] [127] 
.const [44] = Method [128] [129] 
.const [45] = Method [130] [131] 
.const [46] = Method [132] [133] 
.const [47] = Method [134] [135] 
.const [48] = Field [136] [137] 
.const [49] = Field [138] [139] 
.const [50] = Field [140] [141] 
.const [51] = Field [142] [143] 
.const [52] = Field [144] [145] 
.const [53] = Field [146] [147] 
.const [54] = Field [148] [149] 
.const [55] = Field [150] [151] 
.const [56] = Field [152] [153] 
.const [57] = Field [154] [155] 
.const [58] = InterfaceMethod [156] [157] 
.const [59] = Field [158] [159] 
.const [60] = Field [160] [161] 
.const [61] = InterfaceMethod [162] [163] 
.const [62] = Field [164] [165] 
.const [63] = Utf8 de/esolutions/fw/comm/agent/client/IClientHandler 
.const [64] = Utf8 errorCode 
.const [65] = Utf8 errorString 
.const [66] = Utf8 errorTimeStamp 
.const [67] = Utf8 stateString 
.const [68] = Utf8 peerAgentID 
.const [69] = Utf8 stubID 
.const [70] = Utf8 replyStubID 
.const [71] = Utf8 state 
.const [72] = Utf8 callsTotal 
.const [73] = Utf8 callsError 
.const [74] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [75] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [76] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [77] = Utf8 de/esolutions/fw/comm/core/IService 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 java/lang/Class 
.const [80] = Utf8 java/lang/reflect/Field 
.const [81] = Utf8 java/lang/String 
.const [82] = Class [166] 
.const [83] = NameAndType [167] [168] 
.const [84] = Class [169] 
.const [85] = NameAndType [170] [171] 
.const [86] = Class [172] 
.const [87] = NameAndType [173] [174] 
.const [88] = Class [175] 
.const [89] = NameAndType [176] [177] 
.const [90] = Class [178] 
.const [91] = NameAndType [179] [180] 
.const [92] = Class [181] 
.const [93] = NameAndType [182] [183] 
.const [94] = Class [184] 
.const [95] = NameAndType [185] [186] 
.const [96] = Class [187] 
.const [97] = NameAndType [188] [189] 
.const [98] = Class [190] 
.const [99] = NameAndType [191] [192] 
.const [100] = Class [193] 
.const [101] = NameAndType [194] [195] 
.const [102] = Class [196] 
.const [103] = NameAndType [197] [198] 
.const [104] = Class [199] 
.const [105] = NameAndType [200] [201] 
.const [106] = Class [202] 
.const [107] = NameAndType [203] [204] 
.const [108] = Class [205] 
.const [109] = NameAndType [206] [207] 
.const [110] = Class [208] 
.const [111] = NameAndType [209] [210] 
.const [112] = Class [211] 
.const [113] = NameAndType [212] [213] 
.const [114] = Class [214] 
.const [115] = NameAndType [215] [216] 
.const [116] = Class [217] 
.const [117] = NameAndType [218] [219] 
.const [118] = Class [220] 
.const [119] = NameAndType [221] [222] 
.const [120] = Class [223] 
.const [121] = NameAndType [224] [225] 
.const [122] = Class [226] 
.const [123] = NameAndType [227] [228] 
.const [124] = Class [229] 
.const [125] = NameAndType [230] [231] 
.const [126] = Class [232] 
.const [127] = NameAndType [233] [234] 
.const [128] = Class [235] 
.const [129] = NameAndType [236] [237] 
.const [130] = Class [238] 
.const [131] = NameAndType [239] [240] 
.const [132] = Class [241] 
.const [133] = NameAndType [242] [243] 
.const [134] = Class [244] 
.const [135] = NameAndType [245] [246] 
.const [136] = Class [247] 
.const [137] = NameAndType [248] [249] 
.const [138] = Class [250] 
.const [139] = NameAndType [251] [252] 
.const [140] = Class [253] 
.const [141] = NameAndType [254] [255] 
.const [142] = Class [256] 
.const [143] = NameAndType [257] [258] 
.const [144] = Class [259] 
.const [145] = NameAndType [260] [261] 
.const [146] = Class [262] 
.const [147] = NameAndType [263] [264] 
.const [148] = Class [265] 
.const [149] = NameAndType [266] [267] 
.const [150] = Class [268] 
.const [151] = NameAndType [269] [270] 
.const [152] = Class [271] 
.const [153] = NameAndType [272] [273] 
.const [154] = Class [274] 
.const [155] = NameAndType [275] [276] 
.const [156] = Class [277] 
.const [157] = NameAndType [278] [279] 
.const [158] = Class [280] 
.const [159] = NameAndType [281] [282] 
.const [160] = Class [283] 
.const [161] = NameAndType [284] [285] 
.const [162] = Class [286] 
.const [163] = NameAndType [287] [288] 
.const [164] = Class [289] 
.const [165] = NameAndType [290] [291] 
.const [166] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [167] = Utf8 getProxyID 
.const [168] = Utf8 ()S 
.const [169] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [170] = Utf8 getInstanceID 
.const [171] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [172] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [173] = Utf8 svcID 
.const [174] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [175] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [176] = Utf8 getStubID 
.const [177] = Utf8 ()S 
.const [178] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [179] = Utf8 stubID 
.const [180] = Utf8 S 
.const [181] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [182] = Utf8 getErrorCode 
.const [183] = Utf8 ()I 
.const [184] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [185] = Utf8 errorCode 
.const [186] = Utf8 I 
.const [187] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [188] = Utf8 getErrorString 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [191] = Utf8 getState 
.const [192] = Utf8 ()I 
.const [193] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [194] = Utf8 state 
.const [195] = Utf8 I 
.const [196] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [197] = Utf8 getStateString 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [200] = Utf8 getTotalCalls 
.const [201] = Utf8 ()I 
.const [202] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [203] = Utf8 callsTotal 
.const [204] = Utf8 I 
.const [205] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [206] = Utf8 getErrorCalls 
.const [207] = Utf8 ()I 
.const [208] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [209] = Utf8 callsError 
.const [210] = Utf8 I 
.const [211] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [212] = Utf8 getReplyStubID 
.const [213] = Utf8 ()S 
.const [214] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [215] = Utf8 replyStubID 
.const [216] = Utf8 S 
.const [217] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [218] = Utf8 getReplyService 
.const [219] = Utf8 ()Lde/esolutions/fw/comm/core/IReplyService; 
.const [220] = Utf8 java/lang/Class 
.const [221] = Utf8 getName 
.const [222] = Utf8 ()Ljava/lang/String; 
.const [223] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [224] = Utf8 getBackend 
.const [225] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyBackend; 
.const [226] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [227] = Utf8 peerAgentID 
.const [228] = Utf8 S 
.const [229] = Utf8 java/lang/reflect/Field 
.const [230] = Utf8 getName 
.const [231] = Utf8 ()Ljava/lang/String; 
.const [232] = Utf8 java/lang/String 
.const [233] = Utf8 equals 
.const [234] = Utf8 (Ljava/lang/Object;)Z 
.const [235] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (I)V 
.const [238] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [239] = Utf8 getTimeStampString 
.const [240] = Utf8 ()Ljava/lang/String; 
.const [241] = Utf8 java/lang/Object 
.const [242] = Utf8 getClass 
.const [243] = Utf8 ()Ljava/lang/Class; 
.const [244] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [245] = Utf8 fieldValueToObject 
.const [246] = Utf8 (Ljava/lang/reflect/Field;)Ljava/lang/Object; 
.const [247] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [248] = Utf8 svcID 
.const [249] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [250] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [251] = Utf8 stubID 
.const [252] = Utf8 S 
.const [253] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [254] = Utf8 errorCode 
.const [255] = Utf8 I 
.const [256] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [257] = Utf8 errorString 
.const [258] = Utf8 Ljava/lang/String; 
.const [259] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [260] = Utf8 errorTimeStamp 
.const [261] = Utf8 Ljava/lang/String; 
.const [262] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [263] = Utf8 state 
.const [264] = Utf8 I 
.const [265] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [266] = Utf8 stateString 
.const [267] = Utf8 Ljava/lang/String; 
.const [268] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [269] = Utf8 callsTotal 
.const [270] = Utf8 I 
.const [271] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [272] = Utf8 callsError 
.const [273] = Utf8 I 
.const [274] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [275] = Utf8 replyStubID 
.const [276] = Utf8 S 
.const [277] = Utf8 de/esolutions/fw/comm/core/IService 
.const [278] = Utf8 getInstanceID 
.const [279] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [280] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [281] = Utf8 replySvcID 
.const [282] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [283] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [284] = Utf8 replySvcClass 
.const [285] = Utf8 Ljava/lang/String; 
.const [286] = Utf8 de/esolutions/fw/comm/agent/client/IClientHandler 
.const [287] = Utf8 getPeerAgentID 
.const [288] = Utf8 ()S 
.const [289] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [290] = Utf8 peerAgentID 
.const [291] = Utf8 S 
.const [292] = Utf8 de/esolutions/fw/comm/agent/diag/info/ProxyInfo 
.const [293] = Class [292] 
.const [294] = Utf8 de/esolutions/fw/comm/agent/diag/AbstractInfoBase 
.const [295] = Class [294] 
.const [296] = Utf8 svcID 
.const [297] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [298] = Utf8 stubID 
.const [299] = Utf8 S 
.const [300] = Utf8 errorCode 
.const [301] = Utf8 I 
.const [302] = Utf8 errorString 
.const [303] = Utf8 Ljava/lang/String; 
.const [304] = Utf8 state 
.const [305] = Utf8 I 
.const [306] = Utf8 stateString 
.const [307] = Utf8 Ljava/lang/String; 
.const [308] = Utf8 replyStubID 
.const [309] = Utf8 S 
.const [310] = Utf8 replySvcID 
.const [311] = Utf8 Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [312] = Utf8 replySvcClass 
.const [313] = Utf8 Ljava/lang/String; 
.const [314] = Utf8 peerAgentID 
.const [315] = Utf8 S 
.const [316] = Utf8 errorTimeStamp 
.const [317] = Utf8 Ljava/lang/String; 
.const [318] = Utf8 callsTotal 
.const [319] = Utf8 I 
.const [320] = Utf8 callsError 
.const [321] = Utf8 I 
.const [322] = Utf8 DEFAULT_ERROR_CODE 
.const [323] = Utf8 I 
.const [324] = Utf8 DEFAULT_STATE 
.const [325] = Utf8 I 
.const [326] = Utf8 DEFAULT_PEER_AGENT_ID 
.const [327] = Utf8 I 
.const [328] = Utf8 DEFAULT_STUB_ID 
.const [329] = Utf8 I 
.const [330] = Utf8 DEFAULT_REPLY_STUB_ID 
.const [331] = Utf8 I 
.const [332] = Utf8 Code 
.const [333] = Utf8 <init> 
.const [334] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;)V 
.const [335] = Utf8 fieldValueToObject 
.const [336] = Utf8 (Ljava/lang/reflect/Field;)Ljava/lang/Object; 
.const [337] = Utf8 getServiceInstanceID 
.const [338] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.end class 
