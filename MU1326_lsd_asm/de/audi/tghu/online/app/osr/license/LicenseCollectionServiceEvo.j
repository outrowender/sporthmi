.version 50 0 
.class public super [242] 
.super [244] 

.method public [246] : [247] 
    .attribute [245] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iload 5 
L6:     invokespecial [52] 
L9:     aload_0 
L10:    new [57] 
L13:    dup 
L14:    aload_2 
L15:    aload_1 
L16:    aload_3 
L17:    aload_0 
L18:    aload 4 
L20:    invokespecial [53] 
L23:    putfield [58] 
L26:    aload_1 
L27:    ldc [3] 
L29:    ldc [4] 
L31:    invokevirtual [33] 
L34:    pop 
L35:    aload_0 
L36:    new [59] 
L39:    dup 
L40:    aload_1 
L41:    aload_0 
L42:    aload_3 
L43:    invokespecial [54] 
L46:    putfield [60] 
L49:    aload_0 
L50:    getfield [34] 
L53:    aload_0 
L54:    getfield [32] 
L57:    invokevirtual [35] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected enum [248] : [249] 
    .attribute [245] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [250] : [251] 
    .attribute [245] .code stack 4 locals 4 
L0:     iconst_5 
L1:     istore_3 
L2:     iconst_3 
L3:     istore 4 
L5:     invokestatic [6] 
L8:     lstore 5 
L10:    aload_2 
L11:    invokevirtual [36] 
L14:    tableswitch 1 
            L56 
            L174 
            L166 
            L103 
            L198 
            L182 
            L190 
            default : L245 

L56:    aload_2 
L57:    getfield [37] 
L60:    invokevirtual [38] 
L63:    lload 5 
L65:    lsub 
L66:    lconst_0 
L67:    lcmp 
L68:    iflt L84 
L71:    aload_0 
L72:    getfield [39] 
L75:    ldc [7] 
L77:    ldc [8] 
L79:    aload_1 
L80:    invokevirtual [40] 
L83:    pop 
L84:    aload_0 
L85:    getfield [39] 
L88:    ldc [7] 
L90:    ldc [9] 
L92:    aload_1 
L93:    invokevirtual [40] 
L96:    pop 
L97:    iconst_0 
L98:    istore 4 
L100:   goto L248 
L103:   aload_0 
L104:   getfield [39] 
L107:   ldc [7] 
L109:   ldc [10] 
L111:   aload_1 
L112:   invokevirtual [40] 
L115:   pop 
L116:   aload_0 
L117:   getfield [41] 
L120:   ifnull L158 
L123:   aload_0 
L124:   getfield [41] 
L127:   invokevirtual [42] 
L130:   ifne L158 
L133:   aload_2 
L134:   invokevirtual [43] 
L137:   ifeq L148 
L140:   aload_2 
L141:   invokevirtual [43] 
L144:   iconst_2 
L145:   if_icmpne L153 
L148:   iconst_0 
L149:   istore_3 
L150:   goto L160 
L153:   iconst_1 
L154:   istore_3 
L155:   goto L160 
L158:   iconst_0 
L159:   istore_3 
L160:   iconst_1 
L161:   istore 4 
L163:   goto L248 
L166:   iconst_2 
L167:   istore_3 
L168:   iconst_1 
L169:   istore 4 
L171:   goto L248 
L174:   iconst_3 
L175:   istore_3 
L176:   iconst_1 
L177:   istore 4 
L179:   goto L248 
L182:   iconst_5 
L183:   istore_3 
L184:   iconst_1 
L185:   istore 4 
L187:   goto L248 
L190:   iconst_4 
L191:   istore_3 
L192:   iconst_1 
L193:   istore 4 
L195:   goto L248 
L198:   aload_2 
L199:   getfield [37] 
L202:   invokevirtual [38] 
L205:   lload 5 
L207:   lsub 
L208:   lconst_0 
L209:   lcmp 
L210:   iflt L226 
L213:   aload_0 
L214:   getfield [39] 
L217:   ldc [7] 
L219:   ldc [11] 
L221:   aload_1 
L222:   invokevirtual [40] 
L225:   pop 
L226:   aload_0 
L227:   getfield [39] 
L230:   ldc [7] 
L232:   ldc [12] 
L234:   aload_1 
L235:   invokevirtual [40] 
L238:   pop 
L239:   iconst_0 
L240:   istore 4 
L242:   goto L248 
L245:   iconst_3 
L246:   istore 4 
L248:   aload_0 
L249:   getfield [32] 
L252:   iload_3 
L253:   invokevirtual [44] 
L256:   aload_0 
L257:   getfield [32] 
L260:   iload 4 
L262:   invokevirtual [45] 
L265:   return 
L266:   nop 
L267:   nop 
L268:   
    .end code 
.end method 

.method protected [252] : [253] 
    .attribute [245] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [46] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [46] 
L11:    arraylength 
L12:    ifge L28 
L15:    aload_0 
L16:    getfield [39] 
L19:    ldc [7] 
L21:    ldc [13] 
L23:    invokevirtual [33] 
L26:    pop 
L27:    return 
L28:    aload_0 
L29:    invokespecial [55] 
L32:    iconst_0 
L33:    istore_1 
L34:    iload_1 
L35:    aload_0 
L36:    getfield [46] 
L39:    arraylength 
L40:    if_icmpge L129 
L43:    aload_0 
L44:    getfield [46] 
L47:    iload_1 
L48:    aaload 
L49:    astore_2 
L50:    aload_2 
L51:    invokevirtual [47] 
L54:    invokestatic [14] 
L57:    ifeq L123 
L60:    aload_0 
L61:    aload_2 
L62:    invokevirtual [48] 
L65:    astore_3 
L66:    aload_3 
L67:    ifnonnull L89 
L70:    aload_0 
L71:    getfield [39] 
L74:    ldc [15] 
L76:    ldc [16] 
L78:    aload_2 
L79:    invokevirtual [49] 
L82:    invokevirtual [40] 
L85:    pop 
L86:    goto L123 
L89:    new [61] 
L92:    dup 
L93:    iconst_1 
L94:    invokespecial [56] 
L97:    astore 4 
L99:    aload 4 
L101:   aload_3 
L102:   invokeinterface [62] 0 
L107:   pop 
L108:   aload_0 
L109:   getfield [50] 
L112:   ldc [18] 
L114:   aload 4 
L116:   invokevirtual [51] 
L119:   pop 
L120:   goto L129 
L123:   iinc 1 1 
L126:   goto L34 
L129:   return 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [63] 
.const [3] = Int 14808325 
.const [4] = String [64] 
.const [5] = Class [65] 
.const [6] = Method [66] [67] 
.const [7] = Int -2137614336 
.const [8] = String [68] 
.const [9] = String [69] 
.const [10] = String [70] 
.const [11] = String [71] 
.const [12] = String [72] 
.const [13] = String [73] 
.const [14] = Method [74] [75] 
.const [15] = Int -1601830656 
.const [16] = String [76] 
.const [17] = Class [77] 
.const [18] = String [78] 
.const [19] = Class [79] 
.const [20] = Class [80] 
.const [21] = Class [81] 
.const [22] = Class [82] 
.const [23] = Class [83] 
.const [24] = Class [84] 
.const [25] = Class [85] 
.const [26] = Class [86] 
.const [27] = Class [87] 
.const [28] = Class [88] 
.const [29] = Class [89] 
.const [30] = Class [90] 
.const [31] = Class [91] 
.const [32] = Field [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Field [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Method [116] [117] 
.const [45] = Method [118] [119] 
.const [46] = Field [120] [121] 
.const [47] = Method [122] [123] 
.const [48] = Method [124] [125] 
.const [49] = Method [126] [127] 
.const [50] = Field [128] [129] 
.const [51] = Method [130] [131] 
.const [52] = Method [132] [133] 
.const [53] = Method [134] [135] 
.const [54] = Method [136] [137] 
.const [55] = Method [138] [139] 
.const [56] = Method [140] [141] 
.const [57] = Class [142] 
.const [58] = Field [143] [144] 
.const [59] = Class [145] 
.const [60] = Field [146] [147] 
.const [61] = Class [148] 
.const [62] = InterfaceMethod [149] [150] 
.const [63] = Utf8 de/audi/tghu/online/app/osr/license/LicensingModelManagerEvo 
.const [64] = Utf8 'LicenseCollectionServiceEvo#ctor: Called.' 
.const [65] = Utf8 de/audi/tghu/online/app/osr/license/LicenseHMIListenerEvo 
.const [66] = Class [151] 
.const [67] = NameAndType [152] [153] 
.const [68] = Utf8 'LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license activated for current status for symbolicName %1 ' 
.const [69] = Utf8 'LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license activated for symbolicName %1 ' 
.const [70] = Utf8 'LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: got expired license for symbolicName %1' 
.const [71] = Utf8 'LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license offered for current status for symbolicName %1 ' 
.const [72] = Utf8 'LicenseCollectionService#setLicenseDetailScreenForLicenseInclude: license offered for symbolicName %1 ' 
.const [73] = Utf8 'LicenseCollectionServiceEvo#addCGWLicenses: no CGW services available, skipping.' 
.const [74] = Class [154] 
.const [75] = NameAndType [155] [156] 
.const [76] = Utf8 'LicenseCollectionService#addCGWLicenses: given remoteHMILicense is null! Skipping Entry %1' 
.const [77] = Utf8 java/util/ArrayList 
.const [78] = Utf8 alert_services 
.const [79] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [80] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionService 
.const [81] = Utf8 de/audi/atip/log/LogChannel 
.const [82] = Utf8 de/audi/tghu/online/app/osr/license/LicenseHmiListener 
.const [83] = Utf8 java/lang/System 
.const [84] = Utf8 de/audi/remotehmi/IRemoteHMILicense 
.const [85] = Utf8 org/dsi/ifc/global/DateTime 
.const [86] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [87] = Utf8 de/audi/tghu/online/app/osr/license/LicenseModelManager 
.const [88] = Utf8 de/audi/atip/interapp/bap/eni/data/Service 
.const [89] = Utf8 de/audi/tghu/online/app/standard/OnlineEvoStandardModelHandler 
.const [90] = Utf8 java/util/List 
.const [91] = Utf8 java/util/LinkedHashMap 
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
.const [116] = Class [193] 
.const [117] = NameAndType [194] [195] 
.const [118] = Class [196] 
.const [119] = NameAndType [197] [198] 
.const [120] = Class [199] 
.const [121] = NameAndType [200] [201] 
.const [122] = Class [202] 
.const [123] = NameAndType [203] [204] 
.const [124] = Class [205] 
.const [125] = NameAndType [206] [207] 
.const [126] = Class [208] 
.const [127] = NameAndType [209] [210] 
.const [128] = Class [211] 
.const [129] = NameAndType [212] [213] 
.const [130] = Class [214] 
.const [131] = NameAndType [215] [216] 
.const [132] = Class [217] 
.const [133] = NameAndType [218] [219] 
.const [134] = Class [220] 
.const [135] = NameAndType [221] [222] 
.const [136] = Class [223] 
.const [137] = NameAndType [224] [225] 
.const [138] = Class [226] 
.const [139] = NameAndType [227] [228] 
.const [140] = Class [229] 
.const [141] = NameAndType [230] [231] 
.const [142] = Utf8 de/audi/tghu/online/app/osr/license/LicensingModelManagerEvo 
.const [143] = Class [232] 
.const [144] = NameAndType [233] [234] 
.const [145] = Utf8 de/audi/tghu/online/app/osr/license/LicenseHMIListenerEvo 
.const [146] = Class [235] 
.const [147] = NameAndType [236] [237] 
.const [148] = Utf8 java/util/ArrayList 
.const [149] = Class [238] 
.const [150] = NameAndType [239] [240] 
.const [151] = Utf8 java/lang/System 
.const [152] = Utf8 currentTimeMillis 
.const [153] = Utf8 ()J 
.const [154] = Utf8 de/audi/tghu/online/app/standard/OnlineEvoStandardModelHandler 
.const [155] = Utf8 isAlertService 
.const [156] = Utf8 (Ljava/lang/String;)Z 
.const [157] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [158] = Utf8 modelManager 
.const [159] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseModelManager; 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;)Z 
.const [163] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [164] = Utf8 hmiListener 
.const [165] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseHmiListener; 
.const [166] = Utf8 de/audi/tghu/online/app/osr/license/LicenseHmiListener 
.const [167] = Utf8 setModelManager 
.const [168] = Utf8 (Lde/audi/tghu/online/app/osr/license/LicenseModelManager;)V 
.const [169] = Utf8 de/audi/remotehmi/IRemoteHMILicense 
.const [170] = Utf8 getState 
.const [171] = Utf8 ()I 
.const [172] = Utf8 de/audi/remotehmi/IRemoteHMILicense 
.const [173] = Utf8 expires 
.const [174] = Utf8 Lorg/dsi/ifc/global/DateTime; 
.const [175] = Utf8 org/dsi/ifc/global/DateTime 
.const [176] = Utf8 getTime 
.const [177] = Utf8 ()J 
.const [178] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [179] = Utf8 log 
.const [180] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [181] = Utf8 de/audi/atip/log/LogChannel 
.const [182] = Utf8 log 
.const [183] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [184] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [185] = Utf8 remoteHMIService 
.const [186] = Utf8 Lde/audi/tghu/online/app/remotehmi/RemoteHMIService; 
.const [187] = Utf8 de/audi/tghu/online/app/remotehmi/RemoteHMIService 
.const [188] = Utf8 isTT 
.const [189] = Utf8 ()Z 
.const [190] = Utf8 de/audi/remotehmi/IRemoteHMILicense 
.const [191] = Utf8 getType 
.const [192] = Utf8 ()I 
.const [193] = Utf8 de/audi/tghu/online/app/osr/license/LicenseModelManager 
.const [194] = Utf8 setLicenseExpirationDetail 
.const [195] = Utf8 (I)V 
.const [196] = Utf8 de/audi/tghu/online/app/osr/license/LicenseModelManager 
.const [197] = Utf8 setServiceListDownloaded 
.const [198] = Utf8 (I)V 
.const [199] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [200] = Utf8 services 
.const [201] = Utf8 [Lde/audi/atip/interapp/bap/eni/data/Service; 
.const [202] = Utf8 de/audi/atip/interapp/bap/eni/data/Service 
.const [203] = Utf8 getId 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [206] = Utf8 convertCGWLicensetoRHMILicense 
.const [207] = Utf8 (Lde/audi/atip/interapp/bap/eni/data/Service;)Lde/audi/remotehmi/IRemoteHMILicense; 
.const [208] = Utf8 de/audi/atip/interapp/bap/eni/data/Service 
.const [209] = Utf8 getName 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [212] = Utf8 licensesBySymbolicName 
.const [213] = Utf8 Ljava/util/LinkedHashMap; 
.const [214] = Utf8 java/util/LinkedHashMap 
.const [215] = Utf8 put 
.const [216] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [217] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionService 
.const [218] = Utf8 <init> 
.const [219] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/hmi/HMIService;Lde/audi/tghu/online/app/remotehmi/RemoteHMIService;Z)V 
.const [220] = Utf8 de/audi/tghu/online/app/osr/license/LicensingModelManagerEvo 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Lde/audi/atip/hmi/HMIService;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/online/app/remotehmi/RemoteHMIService;Lde/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo;Lde/audi/remotehmi/textconstants/ITextConstantsConverter;)V 
.const [223] = Utf8 de/audi/tghu/online/app/osr/license/LicenseHMIListenerEvo 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo;Lde/audi/tghu/online/app/remotehmi/RemoteHMIService;)V 
.const [226] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionService 
.const [227] = Utf8 addCGWLicenses 
.const [228] = Utf8 ()V 
.const [229] = Utf8 java/util/ArrayList 
.const [230] = Utf8 <init> 
.const [231] = Utf8 (I)V 
.const [232] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [233] = Utf8 modelManager 
.const [234] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseModelManager; 
.const [235] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [236] = Utf8 hmiListener 
.const [237] = Utf8 Lde/audi/tghu/online/app/osr/license/LicenseHmiListener; 
.const [238] = Utf8 java/util/List 
.const [239] = Utf8 add 
.const [240] = Utf8 (Ljava/lang/Object;)Z 
.const [241] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionServiceEvo 
.const [242] = Class [241] 
.const [243] = Utf8 de/audi/tghu/online/app/osr/license/LicenseCollectionService 
.const [244] = Class [243] 
.const [245] = Utf8 Code 
.const [246] = Utf8 <init> 
.const [247] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/hmi/HMIService;Lde/audi/tghu/online/app/remotehmi/RemoteHMIService;Lde/audi/remotehmi/textconstants/ITextConstantsConverter;Z)V 
.const [248] = Utf8 indicateActiveLicense 
.const [249] = Utf8 (Lorg/dsi/ifc/online/OSRLicense;)V 
.const [250] = Utf8 setLicenseDetailScreenForLicenseInclude 
.const [251] = Utf8 (Ljava/lang/String;Lde/audi/remotehmi/IRemoteHMILicense;)V 
.const [252] = Utf8 addCGWLicenses 
.const [253] = Utf8 ()V 
.end class 
