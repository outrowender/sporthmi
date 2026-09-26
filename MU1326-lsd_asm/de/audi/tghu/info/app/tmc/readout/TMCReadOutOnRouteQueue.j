.version 50 0 
.class public super [201] 
.super [203] 
.field protected [204] [205] 

.method public [207] : [208] 
    .attribute [206] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [49] 
L6:     aload_0 
L7:     new [51] 
L10:    dup 
L11:    aload_0 
L12:    invokespecial [50] 
L15:    putfield [52] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [209] : [210] 
    .attribute [206] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokevirtual [34] 
L7:     ifeq L22 
L10:    aload_0 
L11:    getfield [33] 
L14:    ldc [3] 
L16:    ldc [4] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    aload_0 
L23:    getfield [36] 
L26:    ldc2_w [55] 
L29:    lcmp 
L30:    ifeq L66 
L33:    aload_0 
L34:    getfield [33] 
L37:    invokevirtual [34] 
L40:    ifeq L55 
L43:    aload_0 
L44:    getfield [33] 
L47:    ldc [3] 
L49:    ldc [5] 
L51:    invokevirtual [35] 
L54:    pop 
L55:    aload_0 
L56:    getfield [37] 
L59:    aload_0 
L60:    getfield [32] 
L63:    invokestatic [6] 
L66:    aload_0 
L67:    getfield [33] 
L70:    invokevirtual [34] 
L73:    ifeq L88 
L76:    aload_0 
L77:    getfield [33] 
L80:    ldc [3] 
L82:    ldc [7] 
L84:    invokevirtual [35] 
L87:    pop 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method protected [211] : [212] 
    .attribute [206] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    invokevirtual [38] 
L14:    pop 
L15:    iload_1 
L16:    lookupswitch 
            1 : L64 
            3 : L44 
            default : L84 

L44:    aload_0 
L45:    getfield [33] 
L48:    ldc [8] 
L50:    ldc [10] 
L52:    invokevirtual [35] 
L55:    pop 
L56:    aload_2 
L57:    iconst_1 
L58:    invokevirtual [39] 
L61:    goto L84 
L64:    aload_0 
L65:    getfield [33] 
L68:    ldc [8] 
L70:    ldc [11] 
L72:    invokevirtual [35] 
L75:    pop 
L76:    aload_2 
L77:    iconst_m1 
L78:    invokevirtual [39] 
L81:    goto L84 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method protected synchronized [213] : [214] 
    .attribute [206] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [37] 
L4:     invokeinterface [53] 0 
L9:     istore_1 
L10:    iconst_0 
L11:    istore_2 
L12:    iload_2 
L13:    iload_1 
L14:    if_icmpge L225 
L17:    aload_0 
L18:    getfield [37] 
L21:    iload_2 
L22:    invokeinterface [54] 0 
L27:    checkcast [12] 
L30:    astore_3 
L31:    aload_0 
L32:    getfield [33] 
L35:    ldc [8] 
L37:    ldc [13] 
L39:    aload_3 
L40:    invokevirtual [40] 
L43:    invokevirtual [41] 
L46:    pop 
L47:    aload_0 
L48:    getfield [36] 
L51:    aload_3 
L52:    invokevirtual [42] 
L55:    lsub 
L56:    lconst_0 
L57:    lcmp 
L58:    ifgt L126 
L61:    aload_0 
L62:    getfield [33] 
L65:    ldc [8] 
L67:    ldc [14] 
L69:    invokevirtual [35] 
L72:    pop 
L73:    aload_3 
L74:    invokevirtual [43] 
L77:    iconst_3 
L78:    if_icmpeq L107 
L81:    aload_0 
L82:    getfield [33] 
L85:    ldc [8] 
L87:    ldc [15] 
L89:    invokevirtual [35] 
L92:    pop 
L93:    aload_0 
L94:    getfield [44] 
L97:    aload_3 
L98:    aload_0 
L99:    getfield [36] 
L102:   invokevirtual [45] 
L105:   aload_3 
L106:   areturn 
L107:   aload_0 
L108:   getfield [33] 
L111:   ldc [8] 
L113:   ldc [16] 
L115:   aload_3 
L116:   invokevirtual [40] 
L119:   invokevirtual [41] 
L122:   pop 
L123:   goto L219 
L126:   aload_0 
L127:   getfield [36] 
L130:   aload_3 
L131:   invokevirtual [46] 
L134:   lsub 
L135:   lconst_0 
L136:   lcmp 
L137:   ifgt L205 
L140:   aload_0 
L141:   getfield [33] 
L144:   ldc [8] 
L146:   ldc [17] 
L148:   invokevirtual [35] 
L151:   pop 
L152:   aload_3 
L153:   invokevirtual [43] 
L156:   iconst_1 
L157:   if_icmpeq L186 
L160:   aload_0 
L161:   getfield [33] 
L164:   ldc [8] 
L166:   ldc [18] 
L168:   invokevirtual [35] 
L171:   pop 
L172:   aload_0 
L173:   getfield [44] 
L176:   aload_3 
L177:   aload_0 
L178:   getfield [36] 
L181:   invokevirtual [47] 
L184:   aload_3 
L185:   areturn 
L186:   aload_0 
L187:   getfield [33] 
L190:   ldc [8] 
L192:   ldc [19] 
L194:   aload_3 
L195:   invokevirtual [40] 
L198:   invokevirtual [41] 
L201:   pop 
L202:   goto L219 
L205:   aload_0 
L206:   getfield [33] 
L209:   ldc [8] 
L211:   ldc [20] 
L213:   invokevirtual [35] 
L216:   pop 
L217:   aconst_null 
L218:   areturn 
L219:   iinc 2 1 
L222:   goto L12 
L225:   aconst_null 
L226:   areturn 
L227:   nop 
L228:   
    .end code 
.end method 

.method protected [215] : [216] 
    .attribute [206] .code stack 7 locals 0 
L0:     aload_1 
L1:     invokevirtual [43] 
L4:     lookupswitch 
            -1 : L32 
            1 : L112 
            default : L136 

L32:    aload_0 
L33:    getfield [36] 
L36:    aload_1 
L37:    invokevirtual [42] 
L40:    lcmp 
L41:    ifge L88 
L44:    aload_0 
L45:    getfield [33] 
L48:    ldc [8] 
L50:    ldc [21] 
L52:    aload_0 
L53:    getfield [36] 
L56:    aload_1 
L57:    invokevirtual [42] 
L60:    invokevirtual [48] 
L63:    pop 
L64:    aload_0 
L65:    getfield [33] 
L68:    ldc [8] 
L70:    ldc [22] 
L72:    aload_1 
L73:    invokevirtual [40] 
L76:    invokevirtual [41] 
L79:    pop 
L80:    aload_1 
L81:    iconst_3 
L82:    invokevirtual [39] 
L85:    goto L152 
L88:    aload_0 
L89:    getfield [33] 
L92:    ldc [8] 
L94:    ldc [23] 
L96:    aload_1 
L97:    invokevirtual [40] 
L100:   invokevirtual [41] 
L103:   pop 
L104:   aload_1 
L105:   iconst_1 
L106:   invokevirtual [39] 
L109:   goto L152 
L112:   aload_1 
L113:   iconst_3 
L114:   invokevirtual [39] 
L117:   aload_0 
L118:   getfield [33] 
L121:   ldc [8] 
L123:   ldc [24] 
L125:   aload_1 
L126:   invokevirtual [40] 
L129:   invokevirtual [41] 
L132:   pop 
L133:   goto L152 
L136:   aload_0 
L137:   getfield [33] 
L140:   ldc [8] 
L142:   ldc [25] 
L144:   aload_1 
L145:   invokevirtual [40] 
L148:   invokevirtual [41] 
L151:   pop 
L152:   return 
L153:   nop 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = Int 14808325 
.const [4] = String [58] 
.const [5] = String [59] 
.const [6] = Method [60] [61] 
.const [7] = String [62] 
.const [8] = Int -2137614336 
.const [9] = String [63] 
.const [10] = String [64] 
.const [11] = String [65] 
.const [12] = Class [66] 
.const [13] = String [67] 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = String [70] 
.const [17] = String [71] 
.const [18] = String [72] 
.const [19] = String [73] 
.const [20] = String [74] 
.const [21] = String [75] 
.const [22] = String [76] 
.const [23] = String [77] 
.const [24] = String [78] 
.const [25] = String [79] 
.const [26] = Class [80] 
.const [27] = Class [81] 
.const [28] = Class [82] 
.const [29] = Class [83] 
.const [30] = Class [84] 
.const [31] = Class [85] 
.const [32] = Field [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Field [94] [95] 
.const [37] = Field [96] [97] 
.const [38] = Method [98] [99] 
.const [39] = Method [100] [101] 
.const [40] = Method [102] [103] 
.const [41] = Method [104] [105] 
.const [42] = Method [106] [107] 
.const [43] = Method [108] [109] 
.const [44] = Field [110] [111] 
.const [45] = Method [112] [113] 
.const [46] = Method [114] [115] 
.const [47] = Method [116] [117] 
.const [48] = Method [118] [119] 
.const [49] = Method [120] [121] 
.const [50] = Method [122] [123] 
.const [51] = Class [124] 
.const [52] = Field [125] [126] 
.const [53] = InterfaceMethod [127] [128] 
.const [54] = InterfaceMethod [129] [130] 
.const [55] = Long -1L 
.const [57] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [58] = Utf8 '[TMCReadOutOnRouteQueue#sortMessageQueue] Called. ' 
.const [59] = Utf8 '[TMCReadOutOnRouteQueue#sortMessageQueue] Sorting read out queue. ' 
.const [60] = Class [131] 
.const [61] = NameAndType [132] [133] 
.const [62] = Utf8 '[TMCReadOutOnRouteQueue#sortMessageQueue] Finished. ' 
.const [63] = Utf8 '[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Called, readout state: %2, newMsg: %1' 
.const [64] = Utf8 '[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Set readout state of new msg to READ_OUT_ONCE.' 
.const [65] = Utf8 '[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Set readout state of new msg to READ_OUT_NEVER.' 
.const [66] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [67] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Checking message %1. ' 
.const [68] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Vehicle reached second attention point' 
.const [69] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Message is not readout completely, return msg.' 
.const [70] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Ignore message %1, because it was read out completely! ' 
.const [71] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Vehicle reached first attention point' 
.const [72] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Message is not readout ONCE, return msg.' 
.const [73] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Ignore message %1, because it was already read out once! ' 
.const [74] = Utf8 '[TMCReadOutOnRouteQueue#provideMsgForReadOut] Return null, because no message is in range! ' 
.const [75] = Utf8 '[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Distance to target: %1, distance to attention point 2: %2' 
.const [76] = Utf8 '[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 from NEVER to COMPLETELY.' 
.const [77] = Utf8 '[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 from NEVER to ONCE.' 
.const [78] = Utf8 '[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 to from ONCE to COMPLETELY.' 
.const [79] = Utf8 '[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Message %1 is already in state COMPLETELY, should not happen.' 
.const [80] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [81] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCAbstractReadOutQueue 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 java/util/Collections 
.const [84] = Utf8 java/util/List 
.const [85] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutStringHelper 
.const [86] = Class [134] 
.const [87] = NameAndType [135] [136] 
.const [88] = Class [137] 
.const [89] = NameAndType [138] [139] 
.const [90] = Class [140] 
.const [91] = NameAndType [141] [142] 
.const [92] = Class [143] 
.const [93] = NameAndType [144] [145] 
.const [94] = Class [146] 
.const [95] = NameAndType [147] [148] 
.const [96] = Class [149] 
.const [97] = NameAndType [150] [151] 
.const [98] = Class [152] 
.const [99] = NameAndType [153] [154] 
.const [100] = Class [155] 
.const [101] = NameAndType [156] [157] 
.const [102] = Class [158] 
.const [103] = NameAndType [159] [160] 
.const [104] = Class [161] 
.const [105] = NameAndType [162] [163] 
.const [106] = Class [164] 
.const [107] = NameAndType [165] [166] 
.const [108] = Class [167] 
.const [109] = NameAndType [168] [169] 
.const [110] = Class [170] 
.const [111] = NameAndType [171] [172] 
.const [112] = Class [173] 
.const [113] = NameAndType [174] [175] 
.const [114] = Class [176] 
.const [115] = NameAndType [177] [178] 
.const [116] = Class [179] 
.const [117] = NameAndType [180] [181] 
.const [118] = Class [182] 
.const [119] = NameAndType [183] [184] 
.const [120] = Class [185] 
.const [121] = NameAndType [186] [187] 
.const [122] = Class [188] 
.const [123] = NameAndType [189] [190] 
.const [124] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [125] = Class [191] 
.const [126] = NameAndType [192] [193] 
.const [127] = Class [194] 
.const [128] = NameAndType [195] [196] 
.const [129] = Class [197] 
.const [130] = NameAndType [198] [199] 
.const [131] = Utf8 java/util/Collections 
.const [132] = Utf8 sort 
.const [133] = Utf8 (Ljava/util/List;Ljava/util/Comparator;)V 
.const [134] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [135] = Utf8 comparator 
.const [136] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator; 
.const [137] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [138] = Utf8 logCh 
.const [139] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 isDebug2 
.const [142] = Utf8 ()Z 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 log 
.const [145] = Utf8 (ILjava/lang/String;)Z 
.const [146] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [147] = Utf8 distanceToTarget 
.const [148] = Utf8 J 
.const [149] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [150] = Utf8 messageQueue 
.const [151] = Utf8 Ljava/util/List; 
.const [152] = Utf8 de/audi/atip/log/LogChannel 
.const [153] = Utf8 log 
.const [154] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [155] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [156] = Utf8 setReadOutState 
.const [157] = Utf8 (I)V 
.const [158] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [159] = Utf8 getMessageID 
.const [160] = Utf8 ()J 
.const [161] = Utf8 de/audi/atip/log/LogChannel 
.const [162] = Utf8 log 
.const [163] = Utf8 (ILjava/lang/String;J)Z 
.const [164] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [165] = Utf8 getDistanceToAttentionPoint2 
.const [166] = Utf8 ()J 
.const [167] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [168] = Utf8 getReadOutState 
.const [169] = Utf8 ()I 
.const [170] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [171] = Utf8 readOutStringHelper 
.const [172] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutStringHelper; 
.const [173] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutStringHelper 
.const [174] = Utf8 createStringForOnRouteMsgSecondAttentionPoint 
.const [175] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl;J)V 
.const [176] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [177] = Utf8 getDistanceToAttentionPoint1 
.const [178] = Utf8 ()J 
.const [179] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutStringHelper 
.const [180] = Utf8 createStringForOnRouteMsgFirstAttentionPoint 
.const [181] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl;J)V 
.const [182] = Utf8 de/audi/atip/log/LogChannel 
.const [183] = Utf8 log 
.const [184] = Utf8 (ILjava/lang/String;JJ)Z 
.const [185] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCAbstractReadOutQueue 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/info/app/InfoEnv;)V 
.const [188] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue;)V 
.const [191] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [192] = Utf8 comparator 
.const [193] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator; 
.const [194] = Utf8 java/util/List 
.const [195] = Utf8 size 
.const [196] = Utf8 ()I 
.const [197] = Utf8 java/util/List 
.const [198] = Utf8 get 
.const [199] = Utf8 (I)Ljava/lang/Object; 
.const [200] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [201] = Class [200] 
.const [202] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCAbstractReadOutQueue 
.const [203] = Class [202] 
.const [204] = Utf8 comparator 
.const [205] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator; 
.const [206] = Utf8 Code 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/info/app/InfoEnv;)V 
.const [209] = Utf8 sortMessageQueue 
.const [210] = Utf8 ()V 
.const [211] = Utf8 messageVersionChangedAfterUpdate 
.const [212] = Utf8 (ILde/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl;)V 
.const [213] = Utf8 provideMsgForReadOut 
.const [214] = Utf8 ()Lde/audi/tghu/info/app/tmc/readout/TMCReadOutMessage; 
.const [215] = Utf8 changeReadOutStateAfterSpeaking 
.const [216] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl;)V 
.end class 
