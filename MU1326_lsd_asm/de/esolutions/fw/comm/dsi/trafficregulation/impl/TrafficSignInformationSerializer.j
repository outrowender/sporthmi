.version 50 0 
.class public super [281] 
.super [283] 

.method public annotation [285] : [286] 
    .attribute [284] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [287] : [288] 
    .attribute [284] .code stack 2 locals 18 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [31] 0 
L17:    iload_2 
L18:    ifne L255 
L21:    aload_1 
L22:    invokevirtual [12] 
L25:    istore_3 
L26:    aload_0 
L27:    iload_3 
L28:    invokeinterface [32] 0 
L33:    aload_1 
L34:    invokevirtual [13] 
L37:    istore 4 
L39:    aload_0 
L40:    iload 4 
L42:    invokeinterface [32] 0 
L47:    aload_1 
L48:    invokevirtual [14] 
L51:    istore 5 
L53:    aload_0 
L54:    iload 5 
L56:    invokeinterface [32] 0 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    istore 6 
L67:    aload_0 
L68:    iload 6 
L70:    invokeinterface [32] 0 
L75:    aload_1 
L76:    invokevirtual [16] 
L79:    istore 7 
L81:    aload_0 
L82:    iload 7 
L84:    invokeinterface [32] 0 
L89:    aload_1 
L90:    invokevirtual [17] 
L93:    istore 8 
L95:    aload_0 
L96:    iload 8 
L98:    invokeinterface [32] 0 
L103:   aload_1 
L104:   invokevirtual [18] 
L107:   istore 9 
L109:   aload_0 
L110:   iload 9 
L112:   invokeinterface [32] 0 
L117:   aload_1 
L118:   invokevirtual [19] 
L121:   istore 10 
L123:   aload_0 
L124:   iload 10 
L126:   invokeinterface [32] 0 
L131:   aload_1 
L132:   invokevirtual [20] 
L135:   istore 11 
L137:   aload_0 
L138:   iload 11 
L140:   invokeinterface [32] 0 
L145:   aload_1 
L146:   invokevirtual [21] 
L149:   istore 12 
L151:   aload_0 
L152:   iload 12 
L154:   invokeinterface [32] 0 
L159:   aload_1 
L160:   invokevirtual [22] 
L163:   istore 13 
L165:   aload_0 
L166:   iload 13 
L168:   invokeinterface [32] 0 
L173:   aload_1 
L174:   invokevirtual [23] 
L177:   istore 14 
L179:   aload_0 
L180:   iload 14 
L182:   invokeinterface [32] 0 
L187:   aload_1 
L188:   invokevirtual [24] 
L191:   istore 15 
L193:   aload_0 
L194:   iload 15 
L196:   invokeinterface [32] 0 
L201:   aload_1 
L202:   invokevirtual [25] 
L205:   astore 16 
L207:   aload_0 
L208:   aload 16 
L210:   invokestatic [2] 
L213:   aload_1 
L214:   invokevirtual [26] 
L217:   istore 17 
L219:   aload_0 
L220:   iload 17 
L222:   invokeinterface [32] 0 
L227:   aload_1 
L228:   invokevirtual [27] 
L231:   istore 18 
L233:   aload_0 
L234:   iload 18 
L236:   invokeinterface [32] 0 
L241:   aload_1 
L242:   invokevirtual [28] 
L245:   istore 19 
L247:   aload_0 
L248:   iload 19 
L250:   invokeinterface [32] 0 
L255:   return 
L256:   
    .end code 
.end method 

.method public static [289] : [290] 
    .attribute [284] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [31] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [32] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [3] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [291] : [292] 
    .attribute [284] .code stack 2 locals 19 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [33] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L255 
L13:    new [34] 
L16:    dup 
L17:    invokespecial [30] 
L20:    astore_1 
L21:    aload_0 
L22:    invokeinterface [35] 0 
L27:    istore_3 
L28:    aload_1 
L29:    iload_3 
L30:    putfield [36] 
L33:    aload_0 
L34:    invokeinterface [35] 0 
L39:    istore 4 
L41:    aload_1 
L42:    iload 4 
L44:    putfield [37] 
L47:    aload_0 
L48:    invokeinterface [35] 0 
L53:    istore 5 
L55:    aload_1 
L56:    iload 5 
L58:    putfield [38] 
L61:    aload_0 
L62:    invokeinterface [35] 0 
L67:    istore 6 
L69:    aload_1 
L70:    iload 6 
L72:    putfield [39] 
L75:    aload_0 
L76:    invokeinterface [35] 0 
L81:    istore 7 
L83:    aload_1 
L84:    iload 7 
L86:    putfield [40] 
L89:    aload_0 
L90:    invokeinterface [35] 0 
L95:    istore 8 
L97:    aload_1 
L98:    iload 8 
L100:   putfield [41] 
L103:   aload_0 
L104:   invokeinterface [35] 0 
L109:   istore 9 
L111:   aload_1 
L112:   iload 9 
L114:   putfield [42] 
L117:   aload_0 
L118:   invokeinterface [35] 0 
L123:   istore 10 
L125:   aload_1 
L126:   iload 10 
L128:   putfield [43] 
L131:   aload_0 
L132:   invokeinterface [35] 0 
L137:   istore 11 
L139:   aload_1 
L140:   iload 11 
L142:   putfield [44] 
L145:   aload_0 
L146:   invokeinterface [35] 0 
L151:   istore 12 
L153:   aload_1 
L154:   iload 12 
L156:   putfield [45] 
L159:   aload_0 
L160:   invokeinterface [35] 0 
L165:   istore 13 
L167:   aload_1 
L168:   iload 13 
L170:   putfield [46] 
L173:   aload_0 
L174:   invokeinterface [35] 0 
L179:   istore 14 
L181:   aload_1 
L182:   iload 14 
L184:   putfield [47] 
L187:   aload_0 
L188:   invokeinterface [35] 0 
L193:   istore 15 
L195:   aload_1 
L196:   iload 15 
L198:   putfield [48] 
L201:   aload_0 
L202:   invokestatic [5] 
L205:   astore 16 
L207:   aload_1 
L208:   aload 16 
L210:   putfield [49] 
L213:   aload_0 
L214:   invokeinterface [35] 0 
L219:   istore 17 
L221:   aload_1 
L222:   iload 17 
L224:   putfield [50] 
L227:   aload_0 
L228:   invokeinterface [35] 0 
L233:   istore 18 
L235:   aload_1 
L236:   iload 18 
L238:   putfield [51] 
L241:   aload_0 
L242:   invokeinterface [35] 0 
L247:   istore 19 
L249:   aload_1 
L250:   iload 19 
L252:   putfield [52] 
L255:   aload_1 
L256:   areturn 
L257:   nop 
L258:   nop 
L259:   nop 
L260:   
    .end code 
.end method 

.method public static [293] : [294] 
    .attribute [284] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [33] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [35] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [4] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [6] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [53] [54] 
.const [3] = Method [55] [56] 
.const [4] = Class [57] 
.const [5] = Method [58] [59] 
.const [6] = Method [60] [61] 
.const [7] = Class [62] 
.const [8] = Class [63] 
.const [9] = Class [64] 
.const [10] = Class [65] 
.const [11] = Class [66] 
.const [12] = Method [67] [68] 
.const [13] = Method [69] [70] 
.const [14] = Method [71] [72] 
.const [15] = Method [73] [74] 
.const [16] = Method [75] [76] 
.const [17] = Method [77] [78] 
.const [18] = Method [79] [80] 
.const [19] = Method [81] [82] 
.const [20] = Method [83] [84] 
.const [21] = Method [85] [86] 
.const [22] = Method [87] [88] 
.const [23] = Method [89] [90] 
.const [24] = Method [91] [92] 
.const [25] = Method [93] [94] 
.const [26] = Method [95] [96] 
.const [27] = Method [97] [98] 
.const [28] = Method [99] [100] 
.const [29] = Method [101] [102] 
.const [30] = Method [103] [104] 
.const [31] = InterfaceMethod [105] [106] 
.const [32] = InterfaceMethod [107] [108] 
.const [33] = InterfaceMethod [109] [110] 
.const [34] = Class [111] 
.const [35] = InterfaceMethod [112] [113] 
.const [36] = Field [114] [115] 
.const [37] = Field [116] [117] 
.const [38] = Field [118] [119] 
.const [39] = Field [120] [121] 
.const [40] = Field [122] [123] 
.const [41] = Field [124] [125] 
.const [42] = Field [126] [127] 
.const [43] = Field [128] [129] 
.const [44] = Field [130] [131] 
.const [45] = Field [132] [133] 
.const [46] = Field [134] [135] 
.const [47] = Field [136] [137] 
.const [48] = Field [138] [139] 
.const [49] = Field [140] [141] 
.const [50] = Field [142] [143] 
.const [51] = Field [144] [145] 
.const [52] = Field [146] [147] 
.const [53] = Class [148] 
.const [54] = NameAndType [149] [150] 
.const [55] = Class [151] 
.const [56] = NameAndType [152] [153] 
.const [57] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [58] = Class [154] 
.const [59] = NameAndType [155] [156] 
.const [60] = Class [157] 
.const [61] = NameAndType [158] [159] 
.const [62] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationSerializer 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [65] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/SpeedLimitInfoSerializer 
.const [66] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [67] = Class [160] 
.const [68] = NameAndType [161] [162] 
.const [69] = Class [163] 
.const [70] = NameAndType [164] [165] 
.const [71] = Class [166] 
.const [72] = NameAndType [167] [168] 
.const [73] = Class [169] 
.const [74] = NameAndType [170] [171] 
.const [75] = Class [172] 
.const [76] = NameAndType [173] [174] 
.const [77] = Class [175] 
.const [78] = NameAndType [176] [177] 
.const [79] = Class [178] 
.const [80] = NameAndType [179] [180] 
.const [81] = Class [181] 
.const [82] = NameAndType [182] [183] 
.const [83] = Class [184] 
.const [84] = NameAndType [185] [186] 
.const [85] = Class [187] 
.const [86] = NameAndType [188] [189] 
.const [87] = Class [190] 
.const [88] = NameAndType [191] [192] 
.const [89] = Class [193] 
.const [90] = NameAndType [194] [195] 
.const [91] = Class [196] 
.const [92] = NameAndType [197] [198] 
.const [93] = Class [199] 
.const [94] = NameAndType [200] [201] 
.const [95] = Class [202] 
.const [96] = NameAndType [203] [204] 
.const [97] = Class [205] 
.const [98] = NameAndType [206] [207] 
.const [99] = Class [208] 
.const [100] = NameAndType [209] [210] 
.const [101] = Class [211] 
.const [102] = NameAndType [212] [213] 
.const [103] = Class [214] 
.const [104] = NameAndType [215] [216] 
.const [105] = Class [217] 
.const [106] = NameAndType [218] [219] 
.const [107] = Class [220] 
.const [108] = NameAndType [221] [222] 
.const [109] = Class [223] 
.const [110] = NameAndType [224] [225] 
.const [111] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [112] = Class [226] 
.const [113] = NameAndType [227] [228] 
.const [114] = Class [229] 
.const [115] = NameAndType [230] [231] 
.const [116] = Class [232] 
.const [117] = NameAndType [233] [234] 
.const [118] = Class [235] 
.const [119] = NameAndType [236] [237] 
.const [120] = Class [238] 
.const [121] = NameAndType [239] [240] 
.const [122] = Class [241] 
.const [123] = NameAndType [242] [243] 
.const [124] = Class [244] 
.const [125] = NameAndType [245] [246] 
.const [126] = Class [247] 
.const [127] = NameAndType [248] [249] 
.const [128] = Class [250] 
.const [129] = NameAndType [251] [252] 
.const [130] = Class [253] 
.const [131] = NameAndType [254] [255] 
.const [132] = Class [256] 
.const [133] = NameAndType [257] [258] 
.const [134] = Class [259] 
.const [135] = NameAndType [260] [261] 
.const [136] = Class [262] 
.const [137] = NameAndType [263] [264] 
.const [138] = Class [265] 
.const [139] = NameAndType [266] [267] 
.const [140] = Class [268] 
.const [141] = NameAndType [269] [270] 
.const [142] = Class [271] 
.const [143] = NameAndType [272] [273] 
.const [144] = Class [274] 
.const [145] = NameAndType [275] [276] 
.const [146] = Class [277] 
.const [147] = NameAndType [278] [279] 
.const [148] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/SpeedLimitInfoSerializer 
.const [149] = Utf8 putOptionalSpeedLimitInfo 
.const [150] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/trafficregulation/SpeedLimitInfo;)V 
.const [151] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationSerializer 
.const [152] = Utf8 putOptionalTrafficSignInformation 
.const [153] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)V 
.const [154] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/SpeedLimitInfoSerializer 
.const [155] = Utf8 getOptionalSpeedLimitInfo 
.const [156] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/trafficregulation/SpeedLimitInfo; 
.const [157] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationSerializer 
.const [158] = Utf8 getOptionalTrafficSignInformation 
.const [159] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.const [160] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [161] = Utf8 getHighestPrioritySign 
.const [162] = Utf8 ()I 
.const [163] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [164] = Utf8 getSecondHighestPrioritySign 
.const [165] = Utf8 ()I 
.const [166] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [167] = Utf8 getInformationText 
.const [168] = Utf8 ()I 
.const [169] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [170] = Utf8 getTrafficSignOne 
.const [171] = Utf8 ()I 
.const [172] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [173] = Utf8 getTrafficSignTwo 
.const [174] = Utf8 ()I 
.const [175] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [176] = Utf8 getTrafficSignThree 
.const [177] = Utf8 ()I 
.const [178] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [179] = Utf8 getWarningSignOne 
.const [180] = Utf8 ()I 
.const [181] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [182] = Utf8 getWarningSignTwo 
.const [183] = Utf8 ()I 
.const [184] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [185] = Utf8 getWarningSignThree 
.const [186] = Utf8 ()I 
.const [187] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [188] = Utf8 getAdditionalSignOne 
.const [189] = Utf8 ()I 
.const [190] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [191] = Utf8 getAdditionalSignTwo 
.const [192] = Utf8 ()I 
.const [193] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [194] = Utf8 getAdditionalSignThree 
.const [195] = Utf8 ()I 
.const [196] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [197] = Utf8 getVariant 
.const [198] = Utf8 ()I 
.const [199] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [200] = Utf8 getHighestPrioritySpeedLimit 
.const [201] = Utf8 ()Lorg/dsi/ifc/trafficregulation/SpeedLimitInfo; 
.const [202] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [203] = Utf8 getTrafficSignOneSource 
.const [204] = Utf8 ()I 
.const [205] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [206] = Utf8 getTrafficSignTwoSource 
.const [207] = Utf8 ()I 
.const [208] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [209] = Utf8 getTrafficSignThreeSource 
.const [210] = Utf8 ()I 
.const [211] = Utf8 java/lang/Object 
.const [212] = Utf8 <init> 
.const [213] = Utf8 ()V 
.const [214] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [215] = Utf8 <init> 
.const [216] = Utf8 ()V 
.const [217] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [218] = Utf8 putBool 
.const [219] = Utf8 (Z)V 
.const [220] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [221] = Utf8 putInt32 
.const [222] = Utf8 (I)V 
.const [223] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [224] = Utf8 getBool 
.const [225] = Utf8 ()Z 
.const [226] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [227] = Utf8 getInt32 
.const [228] = Utf8 ()I 
.const [229] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [230] = Utf8 highestPrioritySign 
.const [231] = Utf8 I 
.const [232] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [233] = Utf8 secondHighestPrioritySign 
.const [234] = Utf8 I 
.const [235] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [236] = Utf8 informationText 
.const [237] = Utf8 I 
.const [238] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [239] = Utf8 trafficSignOne 
.const [240] = Utf8 I 
.const [241] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [242] = Utf8 trafficSignTwo 
.const [243] = Utf8 I 
.const [244] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [245] = Utf8 trafficSignThree 
.const [246] = Utf8 I 
.const [247] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [248] = Utf8 warningSignOne 
.const [249] = Utf8 I 
.const [250] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [251] = Utf8 warningSignTwo 
.const [252] = Utf8 I 
.const [253] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [254] = Utf8 warningSignThree 
.const [255] = Utf8 I 
.const [256] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [257] = Utf8 additionalSignOne 
.const [258] = Utf8 I 
.const [259] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [260] = Utf8 additionalSignTwo 
.const [261] = Utf8 I 
.const [262] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [263] = Utf8 additionalSignThree 
.const [264] = Utf8 I 
.const [265] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [266] = Utf8 variant 
.const [267] = Utf8 I 
.const [268] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [269] = Utf8 highestPrioritySpeedLimit 
.const [270] = Utf8 Lorg/dsi/ifc/trafficregulation/SpeedLimitInfo; 
.const [271] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [272] = Utf8 trafficSignOneSource 
.const [273] = Utf8 I 
.const [274] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [275] = Utf8 trafficSignTwoSource 
.const [276] = Utf8 I 
.const [277] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [278] = Utf8 trafficSignThreeSource 
.const [279] = Utf8 I 
.const [280] = Utf8 de/esolutions/fw/comm/dsi/trafficregulation/impl/TrafficSignInformationSerializer 
.const [281] = Class [280] 
.const [282] = Utf8 java/lang/Object 
.const [283] = Class [282] 
.const [284] = Utf8 Code 
.const [285] = Utf8 <init> 
.const [286] = Utf8 ()V 
.const [287] = Utf8 putOptionalTrafficSignInformation 
.const [288] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)V 
.const [289] = Utf8 putOptionalTrafficSignInformationVarArray 
.const [290] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)V 
.const [291] = Utf8 getOptionalTrafficSignInformation 
.const [292] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.const [293] = Utf8 getOptionalTrafficSignInformationVarArray 
.const [294] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.end class 
