.version 50 0 
.class public final super [228] 
.super [230] 
.field private static final [231] [232] 
.field private static final [233] [234] 
.field private static final [235] [236] 
.field private static final [237] [238] 
.field private static final [239] [240] 
.field private static final [241] [242] 
.field private static final [243] [244] 
.field private static final [245] [246] 
.field private static final [247] [248] 
.field private static final [249] [250] 

.method public [252] : [253] 
    .attribute [251] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [46] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [251] .code stack 5 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [47] 
L5:     aload_0 
L6:     getfield [29] 
L9:     invokeinterface [50] 0 
L14:    astore_2 
L15:    aload_1 
L16:    invokevirtual [30] 
L19:    astore_3 
L20:    aload_3 
L21:    aload_2 
L22:    ldc [3] 
L24:    invokeinterface [51] 0 
L29:    invokevirtual [31] 
L32:    aload_3 
L33:    aload_2 
L34:    ldc [4] 
L36:    invokeinterface [52] 0 
L41:    invokevirtual [31] 
L44:    aload_3 
L45:    aload_2 
L46:    ldc [5] 
L48:    invokeinterface [52] 0 
L53:    invokevirtual [31] 
L56:    aload_3 
L57:    aload_2 
L58:    ldc [6] 
L60:    invokeinterface [52] 0 
L65:    invokevirtual [31] 
L68:    aload_1 
L69:    invokevirtual [32] 
L72:    new [53] 
L75:    dup 
L76:    aload_0 
L77:    aconst_null 
L78:    invokespecial [48] 
L81:    invokevirtual [33] 
L84:    aload_1 
L85:    invokevirtual [34] 
L88:    new [54] 
L91:    dup 
L92:    aload_0 
L93:    aconst_null 
L94:    invokespecial [49] 
L97:    invokevirtual [35] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method private [256] : [257] 
    .attribute [251] .code stack 3 locals 11 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [9] 
L6:     ldc [10] 
L8:     invokevirtual [36] 
L11:    pop 
L12:    aload_0 
L13:    getfield [37] 
L16:    invokevirtual [32] 
L19:    invokevirtual [38] 
L22:    astore_1 
L23:    iconst_0 
L24:    istore_2 
L25:    aconst_null 
L26:    astore_3 
L27:    ldc [11] 
L29:    astore 4 
L31:    iconst_0 
L32:    istore 5 
L34:    aload_1 
L35:    invokevirtual [39] 
L38:    istore 6 
L40:    aload_0 
L41:    getfield [37] 
L44:    invokevirtual [40] 
L47:    invokevirtual [41] 
L50:    astore 7 
L52:    aload 7 
L54:    ifnull L98 
L57:    aload_0 
L58:    getfield [37] 
L61:    invokevirtual [34] 
L64:    astore 8 
L66:    aload 8 
L68:    aload 7 
L70:    invokevirtual [42] 
L73:    istore_2 
L74:    aload 8 
L76:    aload 7 
L78:    invokevirtual [43] 
L81:    astore_3 
L82:    aload 7 
L84:    aload_3 
L85:    invokestatic [12] 
L88:    astore 4 
L90:    iload_2 
L91:    aload 4 
L93:    invokestatic [13] 
L96:    istore 5 
L98:    aload_0 
L99:    getfield [29] 
L102:   invokeinterface [50] 0 
L107:   astore 8 
L109:   aload 8 
L111:   ldc [3] 
L113:   invokeinterface [51] 0 
L118:   aload 4 
L120:   invokeinterface [55] 0 
L125:   aload 8 
L127:   ldc [4] 
L129:   invokeinterface [52] 0 
L134:   iload 5 
L136:   invokeinterface [56] 0 
L141:   iload 5 
L143:   iload 6 
L145:   invokestatic [14] 
L148:   istore 9 
L150:   aload 8 
L152:   ldc [5] 
L154:   invokeinterface [52] 0 
L159:   iload 9 
L161:   invokeinterface [56] 0 
L166:   aload_0 
L167:   getfield [37] 
L170:   invokevirtual [32] 
L173:   invokevirtual [44] 
L176:   istore 10 
L178:   iload 5 
L180:   iload 10 
L182:   invokestatic [14] 
L185:   istore 11 
L187:   aload 8 
L189:   ldc [6] 
L191:   invokeinterface [52] 0 
L196:   iload 11 
L198:   invokeinterface [56] 0 
L203:   return 
L204:   
    .end code 
.end method 

.method private static [258] : [259] 
    .attribute [251] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_1 
L3:     tableswitch 1 
            L66 
            L44 
            L49 
            L54 
            L60 
            L91 
            L97 
            default : L103 

L44:    iconst_4 
L45:    istore_2 
L46:    goto L105 
L49:    iconst_5 
L50:    istore_2 
L51:    goto L105 
L54:    bipush 6 
L56:    istore_2 
L57:    goto L105 
L60:    bipush 7 
L62:    istore_2 
L63:    goto L105 
L66:    iload_0 
L67:    iconst_2 
L68:    if_icmpne L76 
L71:    iconst_3 
L72:    istore_2 
L73:    goto L105 
L76:    iload_0 
L77:    iconst_1 
L78:    if_icmpne L86 
L81:    iconst_2 
L82:    istore_2 
L83:    goto L105 
L86:    iconst_1 
L87:    istore_2 
L88:    goto L105 
L91:    bipush 8 
L93:    istore_2 
L94:    goto L105 
L97:    bipush 9 
L99:    istore_2 
L100:   goto L105 
L103:   iconst_0 
L104:   istore_2 
L105:   iload_2 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 

.method static synthetic [260] : [261] 
    .attribute [251] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [262] : [263] 
    .attribute [251] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [45] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [264] : [265] 
    .attribute [251] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [57] 
.const [3] = Int -2087509760 
.const [4] = Int -2037178112 
.const [5] = Int -2053955328 
.const [6] = Int -2070732544 
.const [7] = Class [58] 
.const [8] = Class [59] 
.const [9] = Int -2137614336 
.const [10] = String [60] 
.const [11] = String [61] 
.const [12] = Method [62] [63] 
.const [13] = Method [64] [65] 
.const [14] = Method [66] [67] 
.const [15] = Class [68] 
.const [16] = Class [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Class [77] 
.const [25] = Class [78] 
.const [26] = Class [79] 
.const [27] = Class [80] 
.const [28] = Field [81] [82] 
.const [29] = Field [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Method [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Method [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Field [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Method [105] [106] 
.const [41] = Method [107] [108] 
.const [42] = Method [109] [110] 
.const [43] = Method [111] [112] 
.const [44] = Method [113] [114] 
.const [45] = Method [115] [116] 
.const [46] = Method [117] [118] 
.const [47] = Method [119] [120] 
.const [48] = Method [121] [122] 
.const [49] = Method [123] [124] 
.const [50] = InterfaceMethod [125] [126] 
.const [51] = InterfaceMethod [127] [128] 
.const [52] = InterfaceMethod [129] [130] 
.const [53] = Class [131] 
.const [54] = Class [132] 
.const [55] = InterfaceMethod [133] [134] 
.const [56] = InterfaceMethod [135] [136] 
.const [57] = Utf8 'App.Messaging.Main' 
.const [58] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$FolderNavigatorObserver 
.const [59] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$SetupManagerObserver 
.const [60] = Utf8 '[FolderPathDisplay#setCurrentPathModels]' 
.const [61] = Utf8 '' 
.const [62] = Class [137] 
.const [63] = NameAndType [138] [139] 
.const [64] = Class [140] 
.const [65] = NameAndType [141] [142] 
.const [66] = Class [143] 
.const [67] = NameAndType [144] [145] 
.const [68] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [69] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [70] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [71] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [72] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [73] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [74] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [75] = Utf8 de/audi/app/messaging/core/setup/SetupManager 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [78] = Utf8 de/audi/app/messaging/core/accounts/AccountManager 
.const [79] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [80] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [81] = Class [146] 
.const [82] = NameAndType [147] [148] 
.const [83] = Class [149] 
.const [84] = NameAndType [150] [151] 
.const [85] = Class [152] 
.const [86] = NameAndType [153] [154] 
.const [87] = Class [155] 
.const [88] = NameAndType [156] [157] 
.const [89] = Class [158] 
.const [90] = NameAndType [159] [160] 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Class [167] 
.const [96] = NameAndType [168] [169] 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Class [173] 
.const [100] = NameAndType [174] [175] 
.const [101] = Class [176] 
.const [102] = NameAndType [177] [178] 
.const [103] = Class [179] 
.const [104] = NameAndType [180] [181] 
.const [105] = Class [182] 
.const [106] = NameAndType [183] [184] 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Class [212] 
.const [126] = NameAndType [213] [214] 
.const [127] = Class [215] 
.const [128] = NameAndType [216] [217] 
.const [129] = Class [218] 
.const [130] = NameAndType [219] [220] 
.const [131] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$FolderNavigatorObserver 
.const [132] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$SetupManagerObserver 
.const [133] = Class [221] 
.const [134] = NameAndType [222] [223] 
.const [135] = Class [224] 
.const [136] = NameAndType [225] [226] 
.const [137] = Utf8 de/audi/app/messaging/core/accounts/AccountManager 
.const [138] = Utf8 getDynamicAccountName 
.const [139] = Utf8 (Lorg/dsi/ifc/messaging/MessagingAccount;Ljava/lang/String;)Ljava/lang/String; 
.const [140] = Utf8 de/audi/app/messaging/core/accounts/AccountManager 
.const [141] = Utf8 getAccountTextType 
.const [142] = Utf8 (ZLjava/lang/String;)I 
.const [143] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [144] = Utf8 getFolderTextIdx 
.const [145] = Utf8 (II)I 
.const [146] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [147] = Utf8 log 
.const [148] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [149] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [150] = Utf8 framework 
.const [151] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [152] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [153] = Utf8 getEntryList 
.const [154] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/EntryList; 
.const [155] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [156] = Utf8 registerForModelGroup 
.const [157] = Utf8 (Lde/audi/atip/hmi/modelaccess/HMIModelApp;)V 
.const [158] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [159] = Utf8 getFolderNavigator 
.const [160] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/FolderNavigator; 
.const [161] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [162] = Utf8 addObserver 
.const [163] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver;)V 
.const [164] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [165] = Utf8 getSetupManager 
.const [166] = Utf8 ()Lde/audi/app/messaging/core/setup/SetupManager; 
.const [167] = Utf8 de/audi/app/messaging/core/setup/SetupManager 
.const [168] = Utf8 addObserver 
.const [169] = Utf8 (Lde/audi/app/messaging/core/setup/ISetupManagerObserver;)V 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;)Z 
.const [173] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [174] = Utf8 msgApp 
.const [175] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [176] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [177] = Utf8 getCurrentFolder 
.const [178] = Utf8 ()Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [179] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [180] = Utf8 getHmiFolderType 
.const [181] = Utf8 ()I 
.const [182] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [183] = Utf8 getAccountManager 
.const [184] = Utf8 ()Lde/audi/app/messaging/core/accounts/AccountManager; 
.const [185] = Utf8 de/audi/app/messaging/core/accounts/AccountManager 
.const [186] = Utf8 getSelectedAccount 
.const [187] = Utf8 ()Lorg/dsi/ifc/messaging/MessagingAccount; 
.const [188] = Utf8 de/audi/app/messaging/core/setup/SetupManager 
.const [189] = Utf8 isBasedOnBtConnection 
.const [190] = Utf8 (Lorg/dsi/ifc/messaging/MessagingAccount;)Z 
.const [191] = Utf8 de/audi/app/messaging/core/setup/SetupManager 
.const [192] = Utf8 getBtDeviceName 
.const [193] = Utf8 (Lorg/dsi/ifc/messaging/MessagingAccount;)Ljava/lang/String; 
.const [194] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigator 
.const [195] = Utf8 getParentFolderType 
.const [196] = Utf8 ()I 
.const [197] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [198] = Utf8 setCurrentPathModels 
.const [199] = Utf8 ()V 
.const [200] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [203] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [204] = Utf8 init 
.const [205] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [206] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$FolderNavigatorObserver 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay;Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$1;)V 
.const [209] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$SetupManagerObserver 
.const [210] = Utf8 <init> 
.const [211] = Utf8 (Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay;Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay$1;)V 
.const [212] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [213] = Utf8 getHmiServiceApp 
.const [214] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [215] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [216] = Utf8 getLabelModel 
.const [217] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [218] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [219] = Utf8 getChoiceModel 
.const [220] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [221] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [222] = Utf8 setText 
.const [223] = Utf8 (Ljava/lang/String;)V 
.const [224] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [225] = Utf8 setValue 
.const [226] = Utf8 (I)V 
.const [227] = Utf8 de/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay 
.const [228] = Class [227] 
.const [229] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [230] = Class [229] 
.const [231] = Utf8 FOLDER_TEXT_IDX_NONE 
.const [232] = Utf8 I 
.const [233] = Utf8 FOLDER_TEXT_IDX_ROOT_MOBILE_DYNAMIC 
.const [234] = Utf8 I 
.const [235] = Utf8 FOLDER_TEXT_IDX_ROOT_MOBILE_STATIC 
.const [236] = Utf8 I 
.const [237] = Utf8 FOLDER_TEXT_IDX_ROOT_SIM 
.const [238] = Utf8 I 
.const [239] = Utf8 FOLDER_TEXT_IDX_DELETED 
.const [240] = Utf8 I 
.const [241] = Utf8 FOLDER_TEXT_IDX_DRAFT 
.const [242] = Utf8 I 
.const [243] = Utf8 FOLDER_TEXT_IDX_INBOX 
.const [244] = Utf8 I 
.const [245] = Utf8 FOLDER_TEXT_IDX_OUTBOX 
.const [246] = Utf8 I 
.const [247] = Utf8 FOLDER_TEXT_IDX_SENT 
.const [248] = Utf8 I 
.const [249] = Utf8 FOLDER_TEXT_IDX_USER 
.const [250] = Utf8 I 
.const [251] = Utf8 Code 
.const [252] = Utf8 <init> 
.const [253] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [254] = Utf8 init 
.const [255] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [256] = Utf8 setCurrentPathModels 
.const [257] = Utf8 ()V 
.const [258] = Utf8 getFolderTextIdx 
.const [259] = Utf8 (II)I 
.const [260] = Utf8 access$200 
.const [261] = Utf8 (Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay;)Lde/audi/atip/log/LogChannel; 
.const [262] = Utf8 access$300 
.const [263] = Utf8 (Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay;)V 
.const [264] = Utf8 access$400 
.const [265] = Utf8 (Lde/audi/app/messaging/evo/folderbrowsing/FolderPathDisplay;)Lde/audi/atip/log/LogChannel; 
.end class 
