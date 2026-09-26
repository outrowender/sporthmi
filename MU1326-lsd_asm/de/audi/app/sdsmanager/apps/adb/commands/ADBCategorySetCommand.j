.version 50 0 
.class public super [141] 
.super [143] 
.field private final [144] [145] 
.field private final [146] [147] 
.field private final [148] [149] 

.method public [151] : [152] 
    .attribute [150] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [30] 
L7:     aload_0 
L8:     aload 4 
L10:    iconst_0 
L11:    invokestatic [2] 
L14:    putfield [32] 
L17:    aload_0 
L18:    aload 4 
L20:    iconst_1 
L21:    invokestatic [2] 
L24:    putfield [33] 
L27:    aload_0 
L28:    aload 5 
L30:    putfield [34] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [150] .code stack 8 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [25] 
L12:    aload_0 
L13:    getfield [22] 
L16:    i2l 
L17:    aload_0 
L18:    getfield [21] 
L21:    i2l 
L22:    invokevirtual [26] 
L25:    pop 
L26:    aload_0 
L27:    getfield [22] 
L30:    invokestatic [5] 
L33:    aload_0 
L34:    getfield [21] 
L37:    invokestatic [6] 
L40:    aload_0 
L41:    invokespecial [31] 
L44:    istore_1 
L45:    aload_0 
L46:    getfield [24] 
L49:    ldc [3] 
L51:    ldc [7] 
L53:    aload_0 
L54:    invokevirtual [25] 
L57:    iload_1 
L58:    i2l 
L59:    invokevirtual [27] 
L62:    pop 
L63:    aload_0 
L64:    getfield [23] 
L67:    iload_1 
L68:    invokeinterface [35] 0 
L73:    aload_0 
L74:    sipush 3000 
L77:    invokevirtual [28] 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private [155] : [156] 
    .attribute [150] .code stack 4 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [22] 
L6:     iconst_1 
L7:     if_icmpne L33 
L10:    aload_0 
L11:    getfield [24] 
L14:    ldc [8] 
L16:    ldc [9] 
L18:    aload_0 
L19:    invokevirtual [25] 
L22:    invokevirtual [29] 
L25:    pop 
L26:    iload_1 
L27:    iconst_4 
L28:    ior 
L29:    istore_1 
L30:    goto L80 
L33:    aload_0 
L34:    getfield [22] 
L37:    iconst_2 
L38:    if_icmpne L64 
L41:    aload_0 
L42:    getfield [24] 
L45:    ldc [8] 
L47:    ldc [10] 
L49:    aload_0 
L50:    invokevirtual [25] 
L53:    invokevirtual [29] 
L56:    pop 
L57:    iload_1 
L58:    iconst_2 
L59:    ior 
L60:    istore_1 
L61:    goto L80 
L64:    aload_0 
L65:    getfield [24] 
L68:    ldc [8] 
L70:    ldc [11] 
L72:    aload_0 
L73:    invokevirtual [25] 
L76:    invokevirtual [29] 
L79:    pop 
L80:    aload_0 
L81:    getfield [21] 
L84:    iconst_1 
L85:    if_icmpne L112 
L88:    aload_0 
L89:    getfield [24] 
L92:    ldc [8] 
L94:    ldc [12] 
L96:    aload_0 
L97:    invokevirtual [25] 
L100:   invokevirtual [29] 
L103:   pop 
L104:   iload_1 
L105:   bipush 8 
L107:   ior 
L108:   istore_1 
L109:   goto L160 
L112:   aload_0 
L113:   getfield [21] 
L116:   iconst_2 
L117:   if_icmpne L144 
L120:   aload_0 
L121:   getfield [24] 
L124:   ldc [8] 
L126:   ldc [13] 
L128:   aload_0 
L129:   invokevirtual [25] 
L132:   invokevirtual [29] 
L135:   pop 
L136:   iload_1 
L137:   bipush 64 
L139:   ior 
L140:   istore_1 
L141:   goto L160 
L144:   aload_0 
L145:   getfield [24] 
L148:   ldc [3] 
L150:   ldc [14] 
L152:   aload_0 
L153:   invokevirtual [25] 
L156:   invokevirtual [29] 
L159:   pop 
L160:   iload_1 
L161:   areturn 
L162:   nop 
L163:   nop 
L164:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Int -2137614336 
.const [4] = String [38] 
.const [5] = Method [39] [40] 
.const [6] = Method [41] [42] 
.const [7] = String [43] 
.const [8] = Int -1601830656 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = String [46] 
.const [12] = String [47] 
.const [13] = String [48] 
.const [14] = String [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Class [54] 
.const [20] = Class [55] 
.const [21] = Field [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = Method [72] [73] 
.const [30] = Method [74] [75] 
.const [31] = Method [76] [77] 
.const [32] = Field [78] [79] 
.const [33] = Field [80] [81] 
.const [34] = Field [82] [83] 
.const [35] = InterfaceMethod [84] [85] 
.const [36] = Class [86] 
.const [37] = NameAndType [87] [88] 
.const [38] = Utf8 '%1#execute: locationCategory=%2, phoneCategory=%3!' 
.const [39] = Class [89] 
.const [40] = NameAndType [90] [91] 
.const [41] = Class [92] 
.const [42] = NameAndType [93] [94] 
.const [43] = Utf8 '%1#execute: phoneNumberTypes=%2!' 
.const [44] = Utf8 '%1#getAdbPhoneType: Location category is private!' 
.const [45] = Utf8 '%1#getAdbPhoneType: Location category is mobile!' 
.const [46] = Utf8 '%1#getAdbPhoneType: No location category specified!' 
.const [47] = Utf8 '%1#getAdbPhoneType: Phone category is fix!' 
.const [48] = Utf8 '%1#getAdbPhoneType: Phone category is mobile!' 
.const [49] = Utf8 '%1#getAdbPhoneType: No phone category specified!' 
.const [50] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [51] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [52] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [55] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Class [122] 
.const [75] = NameAndType [123] [124] 
.const [76] = Class [125] 
.const [77] = NameAndType [126] [127] 
.const [78] = Class [128] 
.const [79] = NameAndType [129] [130] 
.const [80] = Class [131] 
.const [81] = NameAndType [132] [133] 
.const [82] = Class [134] 
.const [83] = NameAndType [135] [136] 
.const [84] = Class [137] 
.const [85] = NameAndType [138] [139] 
.const [86] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [87] = Utf8 retrieveInteger 
.const [88] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [89] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [90] = Utf8 setADBCategoryLocationModel 
.const [91] = Utf8 (I)V 
.const [92] = Utf8 de/audi/app/sdsmanager/SDSModelAccess 
.const [93] = Utf8 setADBCategoryPhoneModel 
.const [94] = Utf8 (I)V 
.const [95] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [96] = Utf8 phoneCategory 
.const [97] = Utf8 I 
.const [98] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [99] = Utf8 locationCategory 
.const [100] = Utf8 I 
.const [101] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [102] = Utf8 adbHandler 
.const [103] = Utf8 Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [104] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [105] = Utf8 logger 
.const [106] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [107] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [108] = Utf8 getName 
.const [109] = Utf8 ()Ljava/lang/String; 
.const [110] = Utf8 de/audi/atip/log/LogChannel 
.const [111] = Utf8 log 
.const [112] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 log 
.const [115] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [116] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [117] = Utf8 sendResult 
.const [118] = Utf8 (I)V 
.const [119] = Utf8 de/audi/atip/log/LogChannel 
.const [120] = Utf8 log 
.const [121] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [122] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [125] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [126] = Utf8 getAdbPhoneType 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [129] = Utf8 phoneCategory 
.const [130] = Utf8 I 
.const [131] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [132] = Utf8 locationCategory 
.const [133] = Utf8 I 
.const [134] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [135] = Utf8 adbHandler 
.const [136] = Utf8 Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [137] = Utf8 de/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler 
.const [138] = Utf8 setPhoneNumberTypes 
.const [139] = Utf8 (I)V 
.const [140] = Utf8 de/audi/app/sdsmanager/apps/adb/commands/ADBCategorySetCommand 
.const [141] = Class [140] 
.const [142] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [143] = Class [142] 
.const [144] = Utf8 locationCategory 
.const [145] = Utf8 I 
.const [146] = Utf8 phoneCategory 
.const [147] = Utf8 I 
.const [148] = Utf8 adbHandler 
.const [149] = Utf8 Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler; 
.const [150] = Utf8 Code 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/app/sdsmanager/apps/adb/AddressBookSDSHandler;)V 
.const [153] = Utf8 execute 
.const [154] = Utf8 ()V 
.const [155] = Utf8 getAdbPhoneType 
.const [156] = Utf8 ()I 
.end class 
