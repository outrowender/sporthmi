.version 50 0 
.class public super abstract [249] 
.super [251] 
.implements [253] 
.field protected volatile [254] [255] 
.field protected final [256] [257] 
.field protected final [258] [259] 
.field protected final [260] [261] 
.field private final [262] [263] 
.field private volatile [264] [265] 

.method public [267] : [268] 
    .attribute [266] .code stack 9 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [30] 
L5:     invokeinterface [44] 0 
L10:    ldc [2] 
L12:    invokeinterface [45] 0 
L17:    aload_1 
L18:    invokevirtual [30] 
L21:    invokeinterface [44] 0 
L26:    ldc [3] 
L28:    invokeinterface [46] 0 
L33:    aconst_null 
L34:    aload_1 
L35:    invokevirtual [30] 
L38:    invokeinterface [44] 0 
L43:    ldc [4] 
L45:    invokeinterface [47] 0 
L50:    aload_1 
L51:    invokevirtual [30] 
L54:    invokeinterface [44] 0 
L59:    ldc [5] 
L61:    invokeinterface [48] 0 
L66:    aload_2 
L67:    aload_1 
L68:    invokevirtual [30] 
L71:    ldc [6] 
L73:    invokeinterface [49] 0 
L78:    invokespecial [40] 
L81:    aload_0 
L82:    new [50] 
L85:    dup 
L86:    aload_0 
L87:    invokespecial [41] 
L90:    putfield [51] 
L93:    aload_0 
L94:    aload_2 
L95:    putfield [52] 
L98:    aload_0 
L99:    aload_1 
L100:   invokevirtual [30] 
L103:   invokeinterface [44] 0 
L108:   ldc [8] 
L110:   invokeinterface [53] 0 
L115:   putfield [54] 
L118:   aload_0 
L119:   aload_1 
L120:   invokevirtual [30] 
L123:   invokeinterface [44] 0 
L128:   ldc [2] 
L130:   invokeinterface [45] 0 
L135:   putfield [55] 
L138:   return 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [266] .code stack 3 locals 0 
L0:     new [56] 
L3:     dup 
L4:     ldc [10] 
L6:     invokespecial [42] 
L9:     athrow 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [266] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [57] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [273] : [274] 
    .attribute [266] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [275] : [276] 
    .attribute [266] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [277] : [278] 
    .attribute [266] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public abstract [279] : [280] 
    .attribute [266] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [266] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     aload_2 
L9:     invokeinterface [58] 0 
L14:    aload_2 
L15:    invokeinterface [59] 0 
L20:    invokevirtual [34] 
L23:    pop 
L24:    aload_0 
L25:    aload_2 
L26:    putfield [60] 
L29:    aload_0 
L30:    getfield [32] 
L33:    aload_2 
L34:    invokeinterface [59] 0 
L39:    aload_0 
L40:    getfield [31] 
L43:    invokestatic [13] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method protected [283] : [284] 
    .attribute [266] .code stack 5 locals 2 
L0:     new [61] 
L3:     dup 
L4:     invokespecial [43] 
L7:     astore_2 
L8:     aload_0 
L9:     getfield [33] 
L12:    ldc [11] 
L14:    ldc [15] 
L16:    aload_1 
L17:    invokestatic [16] 
L20:    invokevirtual [36] 
L23:    pop 
L24:    aconst_null 
L25:    astore_3 
L26:    aload_0 
L27:    getfield [32] 
L30:    invokevirtual [37] 
L33:    lookupswitch 
            0 : L60 
            2 : L69 
            default : L78 

L60:    aload_1 
L61:    aload_2 
L62:    invokestatic [17] 
L65:    astore_3 
L66:    goto L101 
L69:    aload_1 
L70:    aload_2 
L71:    invokestatic [18] 
L74:    astore_3 
L75:    goto L101 
L78:    aload_0 
L79:    getfield [33] 
L82:    sipush 10000 
L85:    ldc [19] 
L87:    aload_0 
L88:    getfield [32] 
L91:    invokevirtual [37] 
L94:    i2l 
L95:    invokevirtual [38] 
L98:    pop 
L99:    iconst_0 
L100:   areturn 
L101:   aload_0 
L102:   aload_3 
L103:   aload_0 
L104:   getfield [35] 
L107:   invokevirtual [39] 
L110:   iconst_1 
L111:   areturn 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1265426176 
.const [3] = Int 747839744 
.const [4] = Int 1804804352 
.const [5] = Int -862838528 
.const [6] = String [62] 
.const [7] = Class [63] 
.const [8] = Int -91086592 
.const [9] = Class [64] 
.const [10] = String [65] 
.const [11] = Int 1078071040 
.const [12] = String [66] 
.const [13] = Method [67] [68] 
.const [14] = Class [69] 
.const [15] = String [70] 
.const [16] = Method [71] [72] 
.const [17] = Method [73] [74] 
.const [18] = Method [75] [76] 
.const [19] = String [77] 
.const [20] = Class [78] 
.const [21] = Class [79] 
.const [22] = Class [80] 
.const [23] = Class [81] 
.const [24] = Class [82] 
.const [25] = Class [83] 
.const [26] = Class [84] 
.const [27] = Class [85] 
.const [28] = Class [86] 
.const [29] = Class [87] 
.const [30] = Method [88] [89] 
.const [31] = Field [90] [91] 
.const [32] = Field [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Field [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Method [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Method [112] [113] 
.const [43] = Method [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = Class [128] 
.const [51] = Field [129] [130] 
.const [52] = Field [131] [132] 
.const [53] = InterfaceMethod [133] [134] 
.const [54] = Field [135] [136] 
.const [55] = Field [137] [138] 
.const [56] = Class [139] 
.const [57] = Field [140] [141] 
.const [58] = InterfaceMethod [142] [143] 
.const [59] = InterfaceMethod [144] [145] 
.const [60] = Field [146] [147] 
.const [61] = Class [148] 
.const [62] = Utf8 'App.Messaging.Search' 
.const [63] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch$1 
.const [64] = Utf8 java/lang/UnsupportedOperationException 
.const [65] = Utf8 'Not implemented.' 
.const [66] = Utf8 'AbstractOrganizerSearch#entrySelected(): "%1", entryId: %2' 
.const [67] = Class [149] 
.const [68] = NameAndType [150] [151] 
.const [69] = Utf8 de/audi/app/messaging/core/addressbook/MessagingEntryDetailsListRowBuilder 
.const [70] = Utf8 'AbstractOrganizerSearch#handleGetEntryResult(): entry: %1' 
.const [71] = Class [152] 
.const [72] = NameAndType [153] [154] 
.const [73] = Class [155] 
.const [74] = NameAndType [156] [157] 
.const [75] = Class [158] 
.const [76] = NameAndType [159] [160] 
.const [77] = Utf8 'SetListDetailsCommand#handleGetEntryResult(): unknown adbMode: %1' 
.const [78] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [79] = Utf8 de/audi/app/addressbook/core/common/search/organizer/AbstractADBOrganizerSearch 
.const [80] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [81] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [82] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [83] = Utf8 de/audi/app/addressbook/core/common/search/ADBSearchListRow 
.const [84] = Utf8 de/audi/atip/log/LogChannel 
.const [85] = Utf8 de/audi/app/messaging/core/addressbook/GetEntryCommand 
.const [86] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [87] = Utf8 de/audi/app/messaging/core/addressbook/MessagingAdbHandler 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Class [194] 
.const [111] = NameAndType [195] [196] 
.const [112] = Class [197] 
.const [113] = NameAndType [198] [199] 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Class [203] 
.const [117] = NameAndType [204] [205] 
.const [118] = Class [206] 
.const [119] = NameAndType [207] [208] 
.const [120] = Class [209] 
.const [121] = NameAndType [210] [211] 
.const [122] = Class [212] 
.const [123] = NameAndType [213] [214] 
.const [124] = Class [215] 
.const [125] = NameAndType [216] [217] 
.const [126] = Class [218] 
.const [127] = NameAndType [219] [220] 
.const [128] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch$1 
.const [129] = Class [221] 
.const [130] = NameAndType [222] [223] 
.const [131] = Class [224] 
.const [132] = NameAndType [225] [226] 
.const [133] = Class [227] 
.const [134] = NameAndType [228] [229] 
.const [135] = Class [230] 
.const [136] = NameAndType [231] [232] 
.const [137] = Class [233] 
.const [138] = NameAndType [234] [235] 
.const [139] = Utf8 java/lang/UnsupportedOperationException 
.const [140] = Class [236] 
.const [141] = NameAndType [237] [238] 
.const [142] = Class [239] 
.const [143] = NameAndType [240] [241] 
.const [144] = Class [242] 
.const [145] = NameAndType [243] [244] 
.const [146] = Class [245] 
.const [147] = NameAndType [246] [247] 
.const [148] = Utf8 de/audi/app/messaging/core/addressbook/MessagingEntryDetailsListRowBuilder 
.const [149] = Utf8 de/audi/app/messaging/core/addressbook/GetEntryCommand 
.const [150] = Utf8 schedule 
.const [151] = Utf8 (Lde/audi/app/messaging/core/addressbook/MessagingAdbHandler;JLde/audi/app/messaging/core/addressbook/GetEntryCommand$ResultHandler;)V 
.const [152] = Utf8 de/audi/app/addressbook/core/common/ADBDbgUtils 
.const [153] = Utf8 dbgShort 
.const [154] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;)Ljava/lang/String; 
.const [155] = Utf8 de/audi/app/messaging/core/addressbook/MessagingEntryDetailsListRowBuilder 
.const [156] = Utf8 getTelDetailsRows 
.const [157] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;Lde/audi/app/addressbook/core/common/AbstractADBEntryDetailsListRowBuilder;)[Lde/audi/app/addressbook/core/common/ADBEntryDetailsListRow; 
.const [158] = Utf8 de/audi/app/messaging/core/addressbook/MessagingEntryDetailsListRowBuilder 
.const [159] = Utf8 getEmailDetailsRows 
.const [160] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;Lde/audi/app/addressbook/core/common/AbstractADBEntryDetailsListRowBuilder;)[Lde/audi/app/addressbook/core/common/ADBEntryDetailsListRow; 
.const [161] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [162] = Utf8 getFramework 
.const [163] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [164] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [165] = Utf8 resultHandler 
.const [166] = Utf8 Lde/audi/app/messaging/core/addressbook/GetEntryCommand$ResultHandler; 
.const [167] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [168] = Utf8 appAdr 
.const [169] = Utf8 Lde/audi/app/messaging/core/addressbook/MessagingAdbHandler; 
.const [170] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [171] = Utf8 log 
.const [172] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [173] = Utf8 de/audi/atip/log/LogChannel 
.const [174] = Utf8 log 
.const [175] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [176] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [177] = Utf8 parentRow 
.const [178] = Utf8 Lde/audi/app/addressbook/core/common/search/ADBSearchListRow; 
.const [179] = Utf8 de/audi/atip/log/LogChannel 
.const [180] = Utf8 log 
.const [181] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [182] = Utf8 de/audi/app/messaging/core/addressbook/MessagingAdbHandler 
.const [183] = Utf8 getAdbMode 
.const [184] = Utf8 ()I 
.const [185] = Utf8 de/audi/atip/log/LogChannel 
.const [186] = Utf8 log 
.const [187] = Utf8 (ILjava/lang/String;J)Z 
.const [188] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [189] = Utf8 setSearchResultDetails 
.const [190] = Utf8 ([Lde/audi/app/addressbook/core/common/ADBEntryDetailsListRow;Lde/audi/app/addressbook/core/common/search/ADBSearchListRow;)V 
.const [191] = Utf8 de/audi/app/addressbook/core/common/search/organizer/AbstractADBOrganizerSearch 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (Lde/audi/atip/hmi/model/list/TiledListModelApp;Lde/audi/atip/hmi/modelaccess/MatchspellerModelApp;Lde/audi/atip/hmi/modelaccess/ResourceLocatorModelApp;Lde/audi/atip/hmi/model/list/BaseListModelApp;Lde/audi/atip/hmi/modelaccess/HMIModelApp;Lde/audi/app/addressbook/core/common/ADBApplication;Lde/audi/atip/log/LogChannel;)V 
.const [194] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch$1 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Lde/audi/app/messaging/core/compose/AbstractOrganizerSearch;)V 
.const [197] = Utf8 java/lang/UnsupportedOperationException 
.const [198] = Utf8 <init> 
.const [199] = Utf8 (Ljava/lang/String;)V 
.const [200] = Utf8 de/audi/app/messaging/core/addressbook/MessagingEntryDetailsListRowBuilder 
.const [201] = Utf8 <init> 
.const [202] = Utf8 ()V 
.const [203] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [204] = Utf8 getHmiServiceApp 
.const [205] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [206] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [207] = Utf8 getTiledListModel 
.const [208] = Utf8 (I)Lde/audi/atip/hmi/model/list/TiledListModelApp; 
.const [209] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [210] = Utf8 getMatchSpellerModel 
.const [211] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/MatchspellerModelApp; 
.const [212] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [213] = Utf8 getBaseListModel 
.const [214] = Utf8 (I)Lde/audi/atip/hmi/model/list/BaseListModelApp; 
.const [215] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [216] = Utf8 getChoiceModel 
.const [217] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [218] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [219] = Utf8 getLogChannel 
.const [220] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [221] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [222] = Utf8 resultHandler 
.const [223] = Utf8 Lde/audi/app/messaging/core/addressbook/GetEntryCommand$ResultHandler; 
.const [224] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [225] = Utf8 appAdr 
.const [226] = Utf8 Lde/audi/app/messaging/core/addressbook/MessagingAdbHandler; 
.const [227] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [228] = Utf8 getMenuModel 
.const [229] = Utf8 (I)Lde/audi/atip/hmi/model/menu/MenuModelApp; 
.const [230] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [231] = Utf8 menu 
.const [232] = Utf8 Lde/audi/atip/hmi/model/menu/MenuModelApp; 
.const [233] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [234] = Utf8 searchList 
.const [235] = Utf8 Lde/audi/atip/hmi/model/list/TiledListModelApp; 
.const [236] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [237] = Utf8 msgApp 
.const [238] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [239] = Utf8 de/audi/app/addressbook/core/common/search/ADBSearchListRow 
.const [240] = Utf8 getCombinedName 
.const [241] = Utf8 ()Ljava/lang/String; 
.const [242] = Utf8 de/audi/app/addressbook/core/common/search/ADBSearchListRow 
.const [243] = Utf8 getEntryId 
.const [244] = Utf8 ()J 
.const [245] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [246] = Utf8 parentRow 
.const [247] = Utf8 Lde/audi/app/addressbook/core/common/search/ADBSearchListRow; 
.const [248] = Utf8 de/audi/app/messaging/core/compose/AbstractOrganizerSearch 
.const [249] = Class [248] 
.const [250] = Utf8 de/audi/app/addressbook/core/common/search/organizer/AbstractADBOrganizerSearch 
.const [251] = Class [250] 
.const [252] = Utf8 de/audi/app/messaging/core/component/IMessagingComponent 
.const [253] = Class [252] 
.const [254] = Utf8 msgApp 
.const [255] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [256] = Utf8 appAdr 
.const [257] = Utf8 Lde/audi/app/messaging/core/addressbook/MessagingAdbHandler; 
.const [258] = Utf8 searchList 
.const [259] = Utf8 Lde/audi/atip/hmi/model/list/TiledListModelApp; 
.const [260] = Utf8 menu 
.const [261] = Utf8 Lde/audi/atip/hmi/model/menu/MenuModelApp; 
.const [262] = Utf8 resultHandler 
.const [263] = Utf8 Lde/audi/app/messaging/core/addressbook/GetEntryCommand$ResultHandler; 
.const [264] = Utf8 parentRow 
.const [265] = Utf8 Lde/audi/app/addressbook/core/common/search/ADBSearchListRow; 
.const [266] = Utf8 Code 
.const [267] = Utf8 <init> 
.const [268] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Lde/audi/app/messaging/core/addressbook/MessagingAdbHandler;)V 
.const [269] = Utf8 addComponent 
.const [270] = Utf8 (Lde/audi/app/messaging/core/component/IMessagingComponent;)V 
.const [271] = Utf8 init 
.const [272] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [273] = Utf8 dispose 
.const [274] = Utf8 ()V 
.const [275] = Utf8 connect 
.const [276] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [277] = Utf8 disconnect 
.const [278] = Utf8 ()V 
.const [279] = Utf8 createSearchListRows 
.const [280] = Utf8 ([Lorg/dsi/ifc/organizer/DataSet;)[Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [281] = Utf8 entrySelected 
.const [282] = Utf8 (Lde/audi/app/addressbook/core/common/search/ADBSearch;Lde/audi/app/addressbook/core/common/search/ADBSearchListRow;III)V 
.const [283] = Utf8 handleGetEntryResult 
.const [284] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;)Z 
.end class 
