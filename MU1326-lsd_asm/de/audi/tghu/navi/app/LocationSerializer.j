.version 50 0 
.class public super [162] 
.super [164] 
.field private static final [165] [166] 
.field private static final [167] [168] 
.field private [169] [170] 
.field private final [171] [172] 
.field private static final [173] [174] 

.method public [176] : [177] 
    .attribute [175] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aload_2 
L6:     putfield [39] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [25] 
L14:    putfield [40] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [178] : [179] 
    .attribute [175] .code stack 6 locals 6 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [26] 
L8:     ldc [2] 
L10:    ldc [3] 
L12:    invokevirtual [27] 
L15:    pop 
L16:    aconst_null 
L17:    areturn 
L18:    new [41] 
L21:    dup 
L22:    invokespecial [34] 
L25:    astore_2 
L26:    aload_0 
L27:    getfield [24] 
L30:    invokeinterface [42] 0 
L35:    astore_3 
L36:    aload_3 
L37:    new [43] 
L40:    dup 
L41:    aload_0 
L42:    ldc [6] 
L44:    aload_1 
L45:    invokespecial [35] 
L48:    invokevirtual [28] 
L51:    pop 
L52:    new [44] 
L55:    dup 
L56:    aload_0 
L57:    aload_2 
L58:    invokespecial [36] 
L61:    astore 4 
L63:    aload_3 
L64:    aload 4 
L66:    invokevirtual [28] 
L69:    pop 
L70:    aload_2 
L71:    dup 
L72:    astore 5 
L74:    monitorenter 
L75:    aload_3 
L76:    ldc [8] 
L78:    invokevirtual [29] 
        .catch [9] from L81 to L88 using L91 
        .catch [0] from L75 to L101 using L104 
L81:    aload_2 
L82:    ldc_w [1] 
L85:    invokespecial [37] 
L88:    goto L98 
L91:    astore 6 
L93:    aload 6 
L95:    invokevirtual [30] 
L98:    aload 5 
L100:   monitorexit 
L101:   goto L112 
        .catch [0] from L104 to L109 using L104 
L104:   astore 7 
L106:   aload 5 
L108:   monitorexit 
L109:   aload 7 
L111:   athrow 
L112:   aload_0 
L113:   getfield [26] 
L116:   ldc [10] 
L118:   ldc [11] 
L120:   aload 4 
L122:   invokevirtual [31] 
L125:   invokevirtual [32] 
L128:   pop 
L129:   aload 4 
L131:   invokevirtual [31] 
L134:   areturn 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [175] .code stack 6 locals 6 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [26] 
L8:     ldc [2] 
L10:    ldc [12] 
L12:    invokevirtual [27] 
L15:    pop 
L16:    aconst_null 
L17:    areturn 
L18:    new [41] 
L21:    dup 
L22:    invokespecial [34] 
L25:    astore_2 
L26:    aload_0 
L27:    getfield [24] 
L30:    invokeinterface [42] 0 
L35:    astore_3 
L36:    aload_3 
L37:    new [45] 
L40:    dup 
L41:    aload_0 
L42:    ldc [14] 
L44:    aload_1 
L45:    invokespecial [38] 
L48:    invokevirtual [28] 
L51:    pop 
L52:    new [44] 
L55:    dup 
L56:    aload_0 
L57:    aload_2 
L58:    invokespecial [36] 
L61:    astore 4 
L63:    aload_3 
L64:    aload 4 
L66:    invokevirtual [28] 
L69:    pop 
L70:    aload_2 
L71:    dup 
L72:    astore 5 
L74:    monitorenter 
L75:    aload_3 
L76:    ldc [15] 
L78:    invokevirtual [29] 
        .catch [9] from L81 to L88 using L91 
        .catch [0] from L75 to L101 using L104 
L81:    aload_2 
L82:    ldc_w [1] 
L85:    invokespecial [37] 
L88:    goto L98 
L91:    astore 6 
L93:    aload 6 
L95:    invokevirtual [30] 
L98:    aload 5 
L100:   monitorexit 
L101:   goto L112 
        .catch [0] from L104 to L109 using L104 
L104:   astore 7 
L106:   aload 5 
L108:   monitorexit 
L109:   aload 7 
L111:   athrow 
L112:   aload_0 
L113:   getfield [26] 
L116:   ldc [10] 
L118:   ldc [16] 
L120:   aload 4 
L122:   invokevirtual [33] 
L125:   invokevirtual [32] 
L128:   pop 
L129:   aload 4 
L131:   invokevirtual [33] 
L134:   areturn 
L135:   nop 
L136:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1601830656 
.const [3] = String [47] 
.const [4] = Class [48] 
.const [5] = Class [49] 
.const [6] = String [50] 
.const [7] = Class [51] 
.const [8] = String [52] 
.const [9] = Class [53] 
.const [10] = Int -2137614336 
.const [11] = String [54] 
.const [12] = String [55] 
.const [13] = Class [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = String [59] 
.const [17] = Class [60] 
.const [18] = String [61] 
.const [19] = String [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Class [65] 
.const [23] = Class [66] 
.const [24] = Field [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Method [93] [94] 
.const [38] = Method [95] [96] 
.const [39] = Field [97] [98] 
.const [40] = Field [99] [100] 
.const [41] = Class [101] 
.const [42] = InterfaceMethod [102] [103] 
.const [43] = Class [104] 
.const [44] = Class [105] 
.const [45] = Class [106] 
.const [46] = Int 812974080 
.const [47] = Utf8 'LocationSerializer#streamToLocation stream is null' 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 de/audi/tghu/navi/app/LocationSerializer$1 
.const [50] = Utf8 StreamToLocationCommand 
.const [51] = Utf8 de/audi/tghu/navi/app/LocationSerializer$GetNavLocationCommand 
.const [52] = Utf8 StreamToLocationCommandList 
.const [53] = Utf8 java/lang/InterruptedException 
.const [54] = Utf8 'LocationSerializer#streamToLocation - %1' 
.const [55] = Utf8 'LocationSerializer#locationToStream location is null' 
.const [56] = Utf8 de/audi/tghu/navi/app/LocationSerializer$2 
.const [57] = Utf8 LocationToStreamCommand 
.const [58] = Utf8 LocationToStreamCommandList 
.const [59] = Utf8 'LocationSerializer#locationToStream - %1' 
.const [60] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [61] = Utf8 ByteStream 
.const [62] = Utf8 NavLocation 
.const [63] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [66] = Utf8 de/audi/tghu/command/CommandList 
.const [67] = Class [107] 
.const [68] = NameAndType [108] [109] 
.const [69] = Class [110] 
.const [70] = NameAndType [111] [112] 
.const [71] = Class [113] 
.const [72] = NameAndType [114] [115] 
.const [73] = Class [116] 
.const [74] = NameAndType [117] [118] 
.const [75] = Class [119] 
.const [76] = NameAndType [120] [121] 
.const [77] = Class [122] 
.const [78] = NameAndType [123] [124] 
.const [79] = Class [125] 
.const [80] = NameAndType [126] [127] 
.const [81] = Class [128] 
.const [82] = NameAndType [129] [130] 
.const [83] = Class [131] 
.const [84] = NameAndType [132] [133] 
.const [85] = Class [134] 
.const [86] = NameAndType [135] [136] 
.const [87] = Class [137] 
.const [88] = NameAndType [138] [139] 
.const [89] = Class [140] 
.const [90] = NameAndType [141] [142] 
.const [91] = Class [143] 
.const [92] = NameAndType [144] [145] 
.const [93] = Class [146] 
.const [94] = NameAndType [147] [148] 
.const [95] = Class [149] 
.const [96] = NameAndType [150] [151] 
.const [97] = Class [152] 
.const [98] = NameAndType [153] [154] 
.const [99] = Class [155] 
.const [100] = NameAndType [156] [157] 
.const [101] = Utf8 java/lang/Object 
.const [102] = Class [158] 
.const [103] = NameAndType [159] [160] 
.const [104] = Utf8 de/audi/tghu/navi/app/LocationSerializer$1 
.const [105] = Utf8 de/audi/tghu/navi/app/LocationSerializer$GetNavLocationCommand 
.const [106] = Utf8 de/audi/tghu/navi/app/LocationSerializer$2 
.const [107] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [108] = Utf8 commandListFactory 
.const [109] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [110] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [111] = Utf8 getLogChannel 
.const [112] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [114] = Utf8 logChannel 
.const [115] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [116] = Utf8 de/audi/atip/log/LogChannel 
.const [117] = Utf8 log 
.const [118] = Utf8 (ILjava/lang/String;)Z 
.const [119] = Utf8 de/audi/tghu/command/CommandList 
.const [120] = Utf8 add 
.const [121] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [122] = Utf8 de/audi/tghu/command/CommandList 
.const [123] = Utf8 execute 
.const [124] = Utf8 (Ljava/lang/String;)V 
.const [125] = Utf8 java/lang/InterruptedException 
.const [126] = Utf8 printStackTrace 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/audi/tghu/navi/app/LocationSerializer$GetNavLocationCommand 
.const [129] = Utf8 getNavLocationResult 
.const [130] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [131] = Utf8 de/audi/atip/log/LogChannel 
.const [132] = Utf8 log 
.const [133] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [134] = Utf8 de/audi/tghu/navi/app/LocationSerializer$GetNavLocationCommand 
.const [135] = Utf8 getByteLocationResult 
.const [136] = Utf8 ()[B 
.const [137] = Utf8 java/lang/Object 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/tghu/navi/app/LocationSerializer$1 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Lde/audi/tghu/navi/app/LocationSerializer;Ljava/lang/String;[B)V 
.const [143] = Utf8 de/audi/tghu/navi/app/LocationSerializer$GetNavLocationCommand 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (Lde/audi/tghu/navi/app/LocationSerializer;Ljava/lang/Object;)V 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 wait 
.const [148] = Utf8 (J)V 
.const [149] = Utf8 de/audi/tghu/navi/app/LocationSerializer$2 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/tghu/navi/app/LocationSerializer;Ljava/lang/String;Lorg/dsi/ifc/global/NavLocation;)V 
.const [152] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [153] = Utf8 commandListFactory 
.const [154] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [155] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [156] = Utf8 logChannel 
.const [157] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [158] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [159] = Utf8 createCommandList 
.const [160] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [161] = Utf8 de/audi/tghu/navi/app/LocationSerializer 
.const [162] = Class [161] 
.const [163] = Utf8 java/lang/Object 
.const [164] = Class [163] 
.const [165] = Utf8 BYTE_STREAM_KEY 
.const [166] = Utf8 Ljava/lang/String; 
.const [167] = Utf8 NAV_LOCATION_KEY 
.const [168] = Utf8 Ljava/lang/String; 
.const [169] = Utf8 logChannel 
.const [170] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [171] = Utf8 commandListFactory 
.const [172] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [173] = Utf8 TIMEOUT 
.const [174] = Utf8 J 
.const [175] = Utf8 Code 
.const [176] = Utf8 <init> 
.const [177] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/command/ICommandListFactory;)V 
.const [178] = Utf8 streamToLocation 
.const [179] = Utf8 ([B)Lorg/dsi/ifc/global/NavLocation; 
.const [180] = Utf8 locationToStream 
.const [181] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)[B 
.end class 
