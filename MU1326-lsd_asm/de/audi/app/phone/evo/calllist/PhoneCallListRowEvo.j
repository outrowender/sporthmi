.version 50 0 
.class public super [224] 
.super [226] 
.field static final [227] [228] 
.field static final [229] [230] 
.field static final [231] [232] 
.field private static final [233] [234] 
.field private static final [235] [236] 
.field private static final [237] [238] 
.field private static final [239] [240] 
.field private static final [241] [242] 
.field private static final [243] [244] 
.field private static final [245] [246] 
.field private static final [247] [248] 
.field private static final [249] [250] 
.field private static final [251] [252] 
.field static final [253] [254] 
.field private volatile [255] [256] 

.method private static [258] : [259] 
    .attribute [257] .code stack 2 locals 2 
L0:     aload_0 
L1:     instanceof [2] 
L4:     istore_2 
L5:     aload_0 
L6:     invokevirtual [28] 
L9:     tableswitch 1 
            L69 
            L69 
            L132 
            L48 
            L90 
            L111 
            default : L132 

L48:    iload_2 
L49:    ifeq L57 
L52:    ldc [3] 
L54:    goto L59 
L57:    ldc [4] 
L59:    iconst_0 
L60:    newarray int 
L62:    invokestatic [5] 
L65:    astore_1 
L66:    goto L140 
L69:    iload_2 
L70:    ifeq L78 
L73:    ldc [6] 
L75:    goto L80 
L78:    ldc [7] 
L80:    iconst_0 
L81:    newarray int 
L83:    invokestatic [5] 
L86:    astore_1 
L87:    goto L140 
L90:    iload_2 
L91:    ifeq L99 
L94:    ldc [8] 
L96:    goto L101 
L99:    ldc [9] 
L101:   iconst_0 
L102:   newarray int 
L104:   invokestatic [5] 
L107:   astore_1 
L108:   goto L140 
L111:   iload_2 
L112:   ifeq L120 
L115:   ldc [10] 
L117:   goto L122 
L120:   ldc [11] 
L122:   iconst_0 
L123:   newarray int 
L125:   invokestatic [5] 
L128:   astore_1 
L129:   goto L140 
L132:   iconst_0 
L133:   iconst_0 
L134:   newarray int 
L136:   invokestatic [5] 
L139:   astore_1 
L140:   aload_1 
L141:   areturn 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method private static [260] : [261] 
    .attribute [257] .code stack 4 locals 3 
L0:     iconst_m1 
L1:     istore_1 
L2:     aload_0 
L3:     invokevirtual [28] 
L6:     iconst_4 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    istore_2 
L16:    aload_0 
L17:    invokevirtual [29] 
L20:    lconst_0 
L21:    lcmp 
L22:    ifgt L42 
L25:    aload_0 
L26:    invokevirtual [30] 
L29:    ifnull L46 
L32:    aload_0 
L33:    invokevirtual [30] 
L36:    invokevirtual [31] 
L39:    ifle L46 
L42:    iconst_1 
L43:    goto L47 
L46:    iconst_0 
L47:    istore_3 
L48:    iload_2 
L49:    ifeq L66 
L52:    iload_3 
L53:    ifeq L61 
L56:    iconst_0 
L57:    istore_1 
L58:    goto L124 
L61:    iconst_1 
L62:    istore_1 
L63:    goto L124 
L66:    aload_0 
L67:    invokevirtual [28] 
L70:    iconst_5 
L71:    if_icmpne L88 
L74:    iload_3 
L75:    ifeq L83 
L78:    iconst_4 
L79:    istore_1 
L80:    goto L124 
L83:    iconst_5 
L84:    istore_1 
L85:    goto L124 
L88:    aload_0 
L89:    invokevirtual [28] 
L92:    bipush 6 
L94:    if_icmpne L113 
L97:    iload_3 
L98:    ifeq L107 
L101:   bipush 6 
L103:   istore_1 
L104:   goto L124 
L107:   bipush 7 
L109:   istore_1 
L110:   goto L124 
L113:   iload_3 
L114:   ifeq L122 
L117:   iconst_2 
L118:   istore_1 
L119:   goto L124 
L122:   iconst_3 
L123:   istore_1 
L124:   iload_1 
L125:   invokestatic [12] 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [257] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     bipush 14 
L6:     invokespecial [42] 
L9:     aload_0 
L10:    iconst_2 
L11:    putfield [48] 
L14:    aload_0 
L15:    aload_1 
L16:    aload_2 
L17:    invokespecial [43] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private static [264] : [265] 
    .attribute [257] .code stack 2 locals 2 
L0:     iconst_m1 
L1:     istore_2 
L2:     aload_0 
L3:     ifnull L141 
L6:     aload_0 
L7:     invokevirtual [33] 
L10:    ifeq L26 
L13:    aload_0 
L14:    invokevirtual [34] 
L17:    iconst_4 
L18:    if_icmpne L26 
L21:    iconst_5 
L22:    istore_2 
L23:    goto L141 
L26:    aload_0 
L27:    invokevirtual [35] 
L30:    astore_3 
L31:    aload_3 
L32:    ifnull L42 
L35:    aload_3 
L36:    invokevirtual [31] 
L39:    ifne L47 
L42:    iconst_4 
L43:    istore_2 
L44:    goto L141 
L47:    aload_1 
L48:    ifnull L74 
L51:    aload_1 
L52:    aload_3 
L53:    invokeinterface [49] 0 
L58:    ifeq L74 
L61:    aload_0 
L62:    invokevirtual [34] 
L65:    iconst_3 
L66:    if_icmpne L74 
L69:    iconst_3 
L70:    istore_2 
L71:    goto L141 
L74:    aload_1 
L75:    aload_3 
L76:    invokeinterface [50] 0 
L81:    ifeq L89 
L84:    iconst_0 
L85:    istore_2 
L86:    goto L141 
L89:    aload_1 
L90:    ifnull L116 
L93:    aload_1 
L94:    aload_3 
L95:    invokeinterface [51] 0 
L100:   ifeq L116 
L103:   aload_0 
L104:   invokevirtual [34] 
L107:   iconst_5 
L108:   if_icmpne L116 
L111:   iconst_1 
L112:   istore_2 
L113:   goto L141 
L116:   aload_1 
L117:   ifnull L141 
L120:   aload_1 
L121:   aload_3 
L122:   invokeinterface [52] 0 
L127:   ifeq L141 
L130:   aload_0 
L131:   invokevirtual [34] 
L134:   bipush 6 
L136:   if_icmpne L141 
L139:   iconst_2 
L140:   istore_2 
L141:   iload_2 
L142:   areturn 
L143:   nop 
L144:   
    .end code 
.end method 

.method private [266] : [267] 
    .attribute [257] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [28] 
L4:     tableswitch 1 
            L52 
            L52 
            L76 
            L44 
            L60 
            L68 
            default : L76 

L44:    aload_0 
L45:    iconst_0 
L46:    invokespecial [44] 
L49:    goto L98 
L52:    aload_0 
L53:    iconst_0 
L54:    invokespecial [44] 
L57:    goto L98 
L60:    aload_0 
L61:    iconst_2 
L62:    invokespecial [44] 
L65:    goto L98 
L68:    aload_0 
L69:    iconst_1 
L70:    invokespecial [44] 
L73:    goto L98 
L76:    aload_0 
L77:    iconst_2 
L78:    invokespecial [44] 
L81:    aload_0 
L82:    getfield [36] 
L85:    ldc [13] 
L87:    ldc [14] 
L89:    aload_0 
L90:    invokespecial [45] 
L93:    i2l 
L94:    invokevirtual [37] 
L97:    pop 
L98:    aload_0 
L99:    iconst_4 
L100:   aload_0 
L101:   invokespecial [45] 
L104:   invokestatic [12] 
L107:   invokevirtual [38] 
L110:   aload_1 
L111:   aload_2 
L112:   invokestatic [15] 
L115:   istore_3 
L116:   aload_0 
L117:   bipush 8 
L119:   iload_3 
L120:   iconst_m1 
L121:   if_icmpne L128 
L124:   iconst_0 
L125:   goto L129 
L128:   iconst_1 
L129:   invokestatic [12] 
L132:   invokevirtual [38] 
L135:   aload_0 
L136:   bipush 9 
L138:   iload_3 
L139:   invokestatic [12] 
L142:   invokevirtual [38] 
L145:   aload_0 
L146:   bipush 7 
L148:   aload_1 
L149:   invokestatic [16] 
L152:   invokevirtual [38] 
L155:   aload_0 
L156:   bipush 12 
L158:   aload_1 
L159:   invokestatic [17] 
L162:   invokevirtual [38] 
L165:   aload_0 
L166:   bipush 13 
L168:   aload_2 
L169:   invokeinterface [53] 0 
L174:   ifne L181 
L177:   iconst_1 
L178:   goto L182 
L181:   iconst_0 
L182:   invokestatic [12] 
L185:   invokevirtual [38] 
L188:   return 
L189:   nop 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method final interface [268] : [269] 
    .attribute [257] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [270] : [271] 
    .attribute [257] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [48] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [272] : [273] 
    .attribute [257] .code stack 3 locals 1 
L0:     new [54] 
L3:     dup 
L4:     aload_0 
L5:     invokespecial [46] 
L8:     invokespecial [47] 
L11:    astore_1 
L12:    aload_1 
L13:    ldc [19] 
L15:    invokevirtual [39] 
L18:    pop 
L19:    aload_1 
L20:    aload_0 
L21:    invokespecial [45] 
L24:    invokevirtual [40] 
L27:    pop 
L28:    aload_1 
L29:    invokevirtual [41] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [55] 
.const [3] = Int -1870334089 
.const [4] = Int -2092804066 
.const [5] = Method [56] [57] 
.const [6] = Int 305144287 
.const [7] = Int 1274181782 
.const [8] = Int -1896195209 
.const [9] = Int -180290914 
.const [10] = Int 1686777316 
.const [11] = Int 674348036 
.const [12] = Method [58] [59] 
.const [13] = Int -1601830656 
.const [14] = String [60] 
.const [15] = Method [61] [62] 
.const [16] = Method [63] [64] 
.const [17] = Method [65] [66] 
.const [18] = Class [67] 
.const [19] = String [68] 
.const [20] = Class [69] 
.const [21] = Class [70] 
.const [22] = Class [71] 
.const [23] = Class [72] 
.const [24] = Class [73] 
.const [25] = Class [74] 
.const [26] = Class [75] 
.const [27] = Class [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Method [89] [90] 
.const [35] = Method [91] [92] 
.const [36] = Field [93] [94] 
.const [37] = Method [95] [96] 
.const [38] = Method [97] [98] 
.const [39] = Method [99] [100] 
.const [40] = Method [101] [102] 
.const [41] = Method [103] [104] 
.const [42] = Method [105] [106] 
.const [43] = Method [107] [108] 
.const [44] = Method [109] [110] 
.const [45] = Method [111] [112] 
.const [46] = Method [113] [114] 
.const [47] = Method [115] [116] 
.const [48] = Field [117] [118] 
.const [49] = InterfaceMethod [119] [120] 
.const [50] = InterfaceMethod [121] [122] 
.const [51] = InterfaceMethod [123] [124] 
.const [52] = InterfaceMethod [125] [126] 
.const [53] = InterfaceMethod [127] [128] 
.const [54] = Class [129] 
.const [55] = Utf8 de/audi/app/phone/core/calllist/ConferenceCall 
.const [56] = Class [130] 
.const [57] = NameAndType [131] [132] 
.const [58] = Class [133] 
.const [59] = NameAndType [134] [135] 
.const [60] = Utf8 '[PhoneCallListRow#PhoneCallListRow] no call state handling for call state %1' 
.const [61] = Class [136] 
.const [62] = NameAndType [137] [138] 
.const [63] = Class [139] 
.const [64] = NameAndType [140] [141] 
.const [65] = Class [142] 
.const [66] = NameAndType [143] [144] 
.const [67] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [68] = Utf8 ', action=' 
.const [69] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [70] = Utf8 de/audi/app/phone/core/calllist/PhoneCallListRowBase 
.const [71] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [72] = Utf8 de/audi/atip/hmi/model/PropertyListCell 
.const [73] = Utf8 java/lang/String 
.const [74] = Utf8 de/audi/atip/hmi/model/IntegerListCell 
.const [75] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Class [175] 
.const [98] = NameAndType [176] [177] 
.const [99] = Class [178] 
.const [100] = NameAndType [179] [180] 
.const [101] = Class [181] 
.const [102] = NameAndType [182] [183] 
.const [103] = Class [184] 
.const [104] = NameAndType [185] [186] 
.const [105] = Class [187] 
.const [106] = NameAndType [188] [189] 
.const [107] = Class [190] 
.const [108] = NameAndType [191] [192] 
.const [109] = Class [193] 
.const [110] = NameAndType [194] [195] 
.const [111] = Class [196] 
.const [112] = NameAndType [197] [198] 
.const [113] = Class [199] 
.const [114] = NameAndType [200] [201] 
.const [115] = Class [202] 
.const [116] = NameAndType [203] [204] 
.const [117] = Class [205] 
.const [118] = NameAndType [206] [207] 
.const [119] = Class [208] 
.const [120] = NameAndType [209] [210] 
.const [121] = Class [211] 
.const [122] = NameAndType [212] [213] 
.const [123] = Class [214] 
.const [124] = NameAndType [215] [216] 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Class [220] 
.const [128] = NameAndType [221] [222] 
.const [129] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [130] = Utf8 de/audi/atip/hmi/model/PropertyListCell 
.const [131] = Utf8 create 
.const [132] = Utf8 (I[I)Lde/audi/atip/hmi/model/PropertyListCell; 
.const [133] = Utf8 de/audi/atip/hmi/model/IntegerListCell 
.const [134] = Utf8 create 
.const [135] = Utf8 (I)Lde/audi/atip/hmi/model/IntegerListCell; 
.const [136] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [137] = Utf8 getCallType 
.const [138] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [139] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [140] = Utf8 getProperties 
.const [141] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;)Lde/audi/atip/hmi/model/PropertyListCell; 
.const [142] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [143] = Utf8 getCallStateLayout 
.const [144] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;)Lde/audi/atip/hmi/model/IntegerListCell; 
.const [145] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [146] = Utf8 getTelCallState 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [149] = Utf8 getTelRemEntryId 
.const [150] = Utf8 ()J 
.const [151] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [152] = Utf8 getTelRemName 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 java/lang/String 
.const [155] = Utf8 length 
.const [156] = Utf8 ()I 
.const [157] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [158] = Utf8 action 
.const [159] = Utf8 I 
.const [160] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [161] = Utf8 isConferenceCall 
.const [162] = Utf8 ()Z 
.const [163] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [164] = Utf8 getTelCallType 
.const [165] = Utf8 ()I 
.const [166] = Utf8 de/audi/app/phone/core/calllist/AbstractPhoneCall 
.const [167] = Utf8 getTelRemNumber 
.const [168] = Utf8 ()Ljava/lang/String; 
.const [169] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [170] = Utf8 log 
.const [171] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;J)Z 
.const [175] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [176] = Utf8 setCell 
.const [177] = Utf8 (ILde/audi/atip/hmi/model/ListCell;)V 
.const [178] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [179] = Utf8 append 
.const [180] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [181] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [182] = Utf8 append 
.const [183] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [184] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 de/audi/app/phone/core/calllist/PhoneCallListRowBase 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;Lde/audi/atip/log/LogChannel;I)V 
.const [190] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [191] = Utf8 setEvoCells 
.const [192] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [193] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [194] = Utf8 setAction 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [197] = Utf8 getAction 
.const [198] = Utf8 ()I 
.const [199] = Utf8 de/audi/app/phone/core/calllist/PhoneCallListRowBase 
.const [200] = Utf8 toString 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Ljava/lang/String;)V 
.const [205] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [206] = Utf8 action 
.const [207] = Utf8 I 
.const [208] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [209] = Utf8 isEmergencyNumber 
.const [210] = Utf8 (Ljava/lang/String;)Z 
.const [211] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [212] = Utf8 isMailboxNumber 
.const [213] = Utf8 (Ljava/lang/String;)Z 
.const [214] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [215] = Utf8 isInfoNumber 
.const [216] = Utf8 (Ljava/lang/String;)Z 
.const [217] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [218] = Utf8 isBreakdownNumber 
.const [219] = Utf8 (Ljava/lang/String;)Z 
.const [220] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [221] = Utf8 getmICMuteState 
.const [222] = Utf8 ()I 
.const [223] = Utf8 de/audi/app/phone/evo/calllist/PhoneCallListRowEvo 
.const [224] = Class [223] 
.const [225] = Utf8 de/audi/app/phone/core/calllist/PhoneCallListRowBase 
.const [226] = Class [225] 
.const [227] = Utf8 ACTION_HANGUP 
.const [228] = Utf8 I 
.const [229] = Utf8 ACTION_SWAP 
.const [230] = Utf8 I 
.const [231] = Utf8 ACTION_NONE 
.const [232] = Utf8 I 
.const [233] = Utf8 RECORDSET_USE_NAME_COLUMN 
.const [234] = Utf8 I 
.const [235] = Utf8 RECORDSET_USE_CALLTYPE_COLUMN 
.const [236] = Utf8 I 
.const [237] = Utf8 RECORDSET_ACTIVE_ADBMATCH 
.const [238] = Utf8 I 
.const [239] = Utf8 RECORDSET_ACTIVE_NO_ADBMATCH 
.const [240] = Utf8 I 
.const [241] = Utf8 RECORDSET_NONACTIVE_ADBMATCH 
.const [242] = Utf8 I 
.const [243] = Utf8 RECORDSET_NONACTIVE_NO_ADBMATCH 
.const [244] = Utf8 I 
.const [245] = Utf8 RECORDSET_ADBMATCH_DISCONNECTING 
.const [246] = Utf8 I 
.const [247] = Utf8 RECORDSET_NO_ADBMATCH_DISCONNECTING 
.const [248] = Utf8 I 
.const [249] = Utf8 RECORDSET_ADBMATCH_HELD 
.const [250] = Utf8 I 
.const [251] = Utf8 RECORDSET_NO_ADBMATCH_HELD 
.const [252] = Utf8 I 
.const [253] = Utf8 MAX_ROWS 
.const [254] = Utf8 I 
.const [255] = Utf8 action 
.const [256] = Utf8 I 
.const [257] = Utf8 Code 
.const [258] = Utf8 getProperties 
.const [259] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;)Lde/audi/atip/hmi/model/PropertyListCell; 
.const [260] = Utf8 getCallStateLayout 
.const [261] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;)Lde/audi/atip/hmi/model/IntegerListCell; 
.const [262] = Utf8 <init> 
.const [263] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;Lde/audi/atip/log/LogChannel;)V 
.const [264] = Utf8 getCallType 
.const [265] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [266] = Utf8 setEvoCells 
.const [267] = Utf8 (Lde/audi/app/phone/core/calllist/AbstractPhoneCall;Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [268] = Utf8 getAction 
.const [269] = Utf8 ()I 
.const [270] = Utf8 setAction 
.const [271] = Utf8 (I)V 
.const [272] = Utf8 toString 
.const [273] = Utf8 ()Ljava/lang/String; 
.end class 
