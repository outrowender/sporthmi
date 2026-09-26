.version 50 0 
.class public super [242] 
.super [244] 
.field private [245] [246] 
.field private [247] [248] 
.field private [249] [250] 
.field private [251] [252] 
.field private [253] [254] 

.method public [256] : [257] 
    .attribute [255] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [51] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [55] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [56] 
L14:    aload_1 
L15:    ldc [2] 
L17:    ldc [3] 
L19:    invokevirtual [35] 
L22:    pop 
L23:    aload_0 
L24:    aload_2 
L25:    putfield [57] 
L28:    aload_0 
L29:    aload_3 
L30:    putfield [58] 
L33:    aload_0 
L34:    aload 4 
L36:    putfield [59] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [255] .code stack 8 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [36] 
L12:    aload_0 
L13:    getfield [37] 
L16:    invokevirtual [39] 
L19:    aload_0 
L20:    invokevirtual [40] 
L23:    ifnull L105 
L26:    new [60] 
L29:    dup 
L30:    aload_0 
L31:    getfield [37] 
L34:    invokespecial [52] 
L37:    astore_1 
L38:    aload_1 
L39:    ldc [7] 
L41:    invokevirtual [41] 
L44:    pop 
L45:    aload_0 
L46:    aload_1 
L47:    invokevirtual [42] 
L50:    putfield [55] 
L53:    new [61] 
L56:    dup 
L57:    aload_0 
L58:    getfield [33] 
L61:    invokespecial [53] 
L64:    astore_2 
L65:    aload_2 
L66:    invokevirtual [43] 
L69:    ifeq L77 
L72:    aload_2 
L73:    invokevirtual [44] 
L76:    pop 
L77:    aload_0 
L78:    invokevirtual [40] 
L81:    ldc [9] 
L83:    aload_0 
L84:    getfield [36] 
L87:    aload_0 
L88:    getfield [33] 
L91:    ldc_w [1] 
L94:    ldc_w [1] 
L97:    invokeinterface [62] 0 
L102:   goto L118 
L105:   aload_0 
L106:   getfield [34] 
L109:   sipush 10000 
L112:   ldc [10] 
L114:   invokevirtual [35] 
L117:   pop 
L118:   return 
L119:   nop 
L120:   
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [255] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [2] 
L6:     ldc [11] 
L8:     invokevirtual [35] 
L11:    pop 
L12:    iload 4 
L14:    iconst_1 
L15:    if_icmpne L127 
L18:    aload_0 
L19:    getfield [34] 
L22:    ldc [4] 
L24:    ldc [12] 
L26:    aload_2 
L27:    aload_3 
L28:    invokevirtual [39] 
L31:    new [61] 
L34:    dup 
L35:    aload_0 
L36:    getfield [33] 
L39:    invokespecial [53] 
L42:    astore 5 
L44:    new [61] 
L47:    dup 
L48:    aload_0 
L49:    getfield [37] 
L52:    invokespecial [53] 
L55:    astore 6 
L57:    aload 6 
L59:    invokevirtual [43] 
L62:    ifeq L71 
L65:    aload 6 
L67:    invokevirtual [44] 
L70:    pop 
L71:    aload 5 
L73:    invokevirtual [43] 
L76:    ifeq L110 
L79:    aload 5 
L81:    aload 6 
L83:    invokevirtual [45] 
L86:    ifne L110 
L89:    aload_0 
L90:    getfield [34] 
L93:    ldc [13] 
L95:    ldc [14] 
L97:    aload 5 
L99:    invokevirtual [46] 
L102:   aload 6 
L104:   invokevirtual [46] 
L107:   invokevirtual [39] 
L110:   aload_0 
L111:   getfield [38] 
L114:   invokevirtual [47] 
L117:   aload_0 
L118:   getfield [38] 
L121:   invokevirtual [48] 
L124:   goto L145 
L127:   aload_0 
L128:   getfield [34] 
L131:   ldc [13] 
L133:   ldc [15] 
L135:   aload_0 
L136:   iload 4 
L138:   invokespecial [54] 
L141:   invokevirtual [49] 
L144:   pop 
L145:   aload_0 
L146:   invokevirtual [50] 
L149:   invokeinterface [63] 0 
L154:   return 
L155:   nop 
L156:   
    .end code 
.end method 

.method private [262] : [263] 
    .attribute [255] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [2] 
L6:     ldc [16] 
L8:     invokevirtual [35] 
L11:    pop 
L12:    aconst_null 
L13:    astore_2 
L14:    iload_1 
L15:    tableswitch 2 
            L68 
            L74 
            L80 
            L86 
            L92 
            L98 
            L104 
            L110 
            L116 
            L122 
            default : L128 

L68:    ldc [17] 
L70:    astore_2 
L71:    goto L131 
L74:    ldc [18] 
L76:    astore_2 
L77:    goto L131 
L80:    ldc [19] 
L82:    astore_2 
L83:    goto L131 
L86:    ldc [20] 
L88:    astore_2 
L89:    goto L131 
L92:    ldc [21] 
L94:    astore_2 
L95:    goto L131 
L98:    ldc [22] 
L100:   astore_2 
L101:   goto L131 
L104:   ldc [23] 
L106:   astore_2 
L107:   goto L131 
L110:   ldc [24] 
L112:   astore_2 
L113:   goto L131 
L116:   ldc [25] 
L118:   astore_2 
L119:   goto L131 
L122:   ldc [26] 
L124:   astore_2 
L125:   goto L131 
L128:   ldc [26] 
L130:   astore_2 
L131:   aload_2 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [66] 
.const [4] = Int -2137614336 
.const [5] = String [67] 
.const [6] = Class [68] 
.const [7] = String [69] 
.const [8] = Class [70] 
.const [9] = String [71] 
.const [10] = String [72] 
.const [11] = String [73] 
.const [12] = String [74] 
.const [13] = Int -1601830656 
.const [14] = String [75] 
.const [15] = String [76] 
.const [16] = String [77] 
.const [17] = String [78] 
.const [18] = String [79] 
.const [19] = String [80] 
.const [20] = String [81] 
.const [21] = String [82] 
.const [22] = String [83] 
.const [23] = String [84] 
.const [24] = String [85] 
.const [25] = String [86] 
.const [26] = String [87] 
.const [27] = Class [88] 
.const [28] = Class [89] 
.const [29] = Class [90] 
.const [30] = Class [91] 
.const [31] = Class [92] 
.const [32] = Class [93] 
.const [33] = Field [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = Method [116] [117] 
.const [45] = Method [118] [119] 
.const [46] = Method [120] [121] 
.const [47] = Method [122] [123] 
.const [48] = Method [124] [125] 
.const [49] = Method [126] [127] 
.const [50] = Method [128] [129] 
.const [51] = Method [130] [131] 
.const [52] = Method [132] [133] 
.const [53] = Method [134] [135] 
.const [54] = Method [136] [137] 
.const [55] = Field [138] [139] 
.const [56] = Field [140] [141] 
.const [57] = Field [142] [143] 
.const [58] = Field [144] [145] 
.const [59] = Field [146] [147] 
.const [60] = Class [148] 
.const [61] = Class [149] 
.const [62] = InterfaceMethod [150] [151] 
.const [63] = InterfaceMethod [152] [153] 
.const [64] = Int 541982720 
.const [65] = Int 547424000 
.const [66] = Utf8 'DownloadLogoItemCommand#DownloadLogoItemCommand()' 
.const [67] = Utf8 'DownloadLogoItemCommand#execute(): downloading %1 to %2' 
.const [68] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [69] = Utf8 _TMP 
.const [70] = Utf8 java/io/File 
.const [71] = Utf8 local_filedownloader 
.const [72] = Utf8 'DownloadLogoItemCommand#execute(): no DSI' 
.const [73] = Utf8 'DownloadLogoItemCommand#downloadResponse()' 
.const [74] = Utf8 'DownloadLogoItemCommand#downloadResponse() File downloaded successfully from %1 to %2.' 
.const [75] = Utf8 'DownloadLogoItemCommand#downloadResponse() Could not rename file %1 to %2' 
.const [76] = Utf8 'DownloadLogoItemCommand#downloadResponse() File downloaded failed due to :%1.' 
.const [77] = Utf8 'DownloadLogoItemCommand#errorCodeFileDownloadToText()' 
.const [78] = Utf8 'No service, can occure at startup' 
.const [79] = Utf8 'Server error' 
.const [80] = Utf8 'The resource point to a non file resource' 
.const [81] = Utf8 'The resource is not writeable' 
.const [82] = Utf8 'Timeout occure' 
.const [83] = Utf8 'IO Error' 
.const [84] = Utf8 'URL corrupt' 
.const [85] = Utf8 'Request canceled' 
.const [86] = Utf8 'Could not create the file' 
.const [87] = Utf8 'Generic error' 
.const [88] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [89] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [92] = Utf8 de/audi/atip/onlinelogo/OnlineLogoItem 
.const [93] = Utf8 de/audi/tghu/command/ICommandList 
.const [94] = Class [154] 
.const [95] = NameAndType [155] [156] 
.const [96] = Class [157] 
.const [97] = NameAndType [158] [159] 
.const [98] = Class [160] 
.const [99] = NameAndType [161] [162] 
.const [100] = Class [163] 
.const [101] = NameAndType [164] [165] 
.const [102] = Class [166] 
.const [103] = NameAndType [167] [168] 
.const [104] = Class [169] 
.const [105] = NameAndType [170] [171] 
.const [106] = Class [172] 
.const [107] = NameAndType [173] [174] 
.const [108] = Class [175] 
.const [109] = NameAndType [176] [177] 
.const [110] = Class [178] 
.const [111] = NameAndType [179] [180] 
.const [112] = Class [181] 
.const [113] = NameAndType [182] [183] 
.const [114] = Class [184] 
.const [115] = NameAndType [185] [186] 
.const [116] = Class [187] 
.const [117] = NameAndType [188] [189] 
.const [118] = Class [190] 
.const [119] = NameAndType [191] [192] 
.const [120] = Class [193] 
.const [121] = NameAndType [194] [195] 
.const [122] = Class [196] 
.const [123] = NameAndType [197] [198] 
.const [124] = Class [199] 
.const [125] = NameAndType [200] [201] 
.const [126] = Class [202] 
.const [127] = NameAndType [203] [204] 
.const [128] = Class [205] 
.const [129] = NameAndType [206] [207] 
.const [130] = Class [208] 
.const [131] = NameAndType [209] [210] 
.const [132] = Class [211] 
.const [133] = NameAndType [212] [213] 
.const [134] = Class [214] 
.const [135] = NameAndType [215] [216] 
.const [136] = Class [217] 
.const [137] = NameAndType [218] [219] 
.const [138] = Class [220] 
.const [139] = NameAndType [221] [222] 
.const [140] = Class [223] 
.const [141] = NameAndType [224] [225] 
.const [142] = Class [226] 
.const [143] = NameAndType [227] [228] 
.const [144] = Class [229] 
.const [145] = NameAndType [230] [231] 
.const [146] = Class [232] 
.const [147] = NameAndType [233] [234] 
.const [148] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [149] = Utf8 java/io/File 
.const [150] = Class [235] 
.const [151] = NameAndType [236] [237] 
.const [152] = Class [238] 
.const [153] = NameAndType [239] [240] 
.const [154] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [155] = Utf8 tempFileLocation 
.const [156] = Utf8 Ljava/lang/String; 
.const [157] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [158] = Utf8 logger 
.const [159] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;)Z 
.const [163] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [164] = Utf8 aRemoteLocationURL 
.const [165] = Utf8 Ljava/lang/String; 
.const [166] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [167] = Utf8 aLocalFileLocation 
.const [168] = Utf8 Ljava/lang/String; 
.const [169] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [170] = Utf8 logoItem 
.const [171] = Utf8 Lde/audi/atip/onlinelogo/OnlineLogoItem; 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [175] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [176] = Utf8 getDSI 
.const [177] = Utf8 ()Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [178] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [179] = Utf8 append 
.const [180] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [181] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [182] = Utf8 toString 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 java/io/File 
.const [185] = Utf8 exists 
.const [186] = Utf8 ()Z 
.const [187] = Utf8 java/io/File 
.const [188] = Utf8 delete 
.const [189] = Utf8 ()Z 
.const [190] = Utf8 java/io/File 
.const [191] = Utf8 renameTo 
.const [192] = Utf8 (Ljava/io/File;)Z 
.const [193] = Utf8 java/io/File 
.const [194] = Utf8 toString 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/audi/atip/onlinelogo/OnlineLogoItem 
.const [197] = Utf8 updateFinished 
.const [198] = Utf8 ()V 
.const [199] = Utf8 de/audi/atip/onlinelogo/OnlineLogoItem 
.const [200] = Utf8 computeAndSetChecksum 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/audi/atip/log/LogChannel 
.const [203] = Utf8 log 
.const [204] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [205] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [206] = Utf8 getCommandList 
.const [207] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [208] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [209] = Utf8 <init> 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [212] = Utf8 <init> 
.const [213] = Utf8 (Ljava/lang/String;)V 
.const [214] = Utf8 java/io/File 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (Ljava/lang/String;)V 
.const [217] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [218] = Utf8 errorCodeFileDownloadToText 
.const [219] = Utf8 (I)Ljava/lang/String; 
.const [220] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [221] = Utf8 tempFileLocation 
.const [222] = Utf8 Ljava/lang/String; 
.const [223] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [224] = Utf8 logger 
.const [225] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [226] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [227] = Utf8 aRemoteLocationURL 
.const [228] = Utf8 Ljava/lang/String; 
.const [229] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [230] = Utf8 aLocalFileLocation 
.const [231] = Utf8 Ljava/lang/String; 
.const [232] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [233] = Utf8 logoItem 
.const [234] = Utf8 Lde/audi/atip/onlinelogo/OnlineLogoItem; 
.const [235] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [236] = Utf8 download 
.const [237] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V 
.const [238] = Utf8 de/audi/tghu/command/ICommandList 
.const [239] = Utf8 commandFinished 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/audi/tghu/online/app/osr/command/DownloadLogoItemCommand 
.const [242] = Class [241] 
.const [243] = Utf8 de/audi/tghu/online/app/osr/command/AbstractOSRCommand 
.const [244] = Class [243] 
.const [245] = Utf8 aRemoteLocationURL 
.const [246] = Utf8 Ljava/lang/String; 
.const [247] = Utf8 aLocalFileLocation 
.const [248] = Utf8 Ljava/lang/String; 
.const [249] = Utf8 logoItem 
.const [250] = Utf8 Lde/audi/atip/onlinelogo/OnlineLogoItem; 
.const [251] = Utf8 logger 
.const [252] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [253] = Utf8 tempFileLocation 
.const [254] = Utf8 Ljava/lang/String; 
.const [255] = Utf8 Code 
.const [256] = Utf8 <init> 
.const [257] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Ljava/lang/String;Lde/audi/atip/onlinelogo/OnlineLogoItem;)V 
.const [258] = Utf8 execute 
.const [259] = Utf8 ()V 
.const [260] = Utf8 downloadResponse 
.const [261] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V 
.const [262] = Utf8 errorCodeFileDownloadToText 
.const [263] = Utf8 (I)Ljava/lang/String; 
.end class 
