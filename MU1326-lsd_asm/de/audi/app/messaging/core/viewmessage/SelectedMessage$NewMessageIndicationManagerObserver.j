.version 50 0 
.class super [158] 
.super [160] 
.implements [162] 
.field private final synthetic [163] [164] 

.method private [166] : [167] 
    .attribute [165] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [34] 
L5:     aload_0 
L6:     invokespecial [31] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [165] .code stack 7 locals 4 
L0:     iload_1 
L1:     ifne L139 
L4:     aload_0 
L5:     getfield [20] 
L8:     invokevirtual [21] 
L11:    ifnull L139 
L14:    aload_0 
L15:    getfield [20] 
L18:    invokevirtual [21] 
L21:    invokevirtual [22] 
L24:    istore_2 
L25:    aload_0 
L26:    getfield [20] 
L29:    invokestatic [2] 
L32:    invokevirtual [23] 
L35:    iload_2 
L36:    invokevirtual [24] 
L39:    astore_3 
L40:    aload_0 
L41:    getfield [20] 
L44:    invokevirtual [21] 
L47:    invokevirtual [25] 
L50:    astore 4 
L52:    aload_0 
L53:    getfield [20] 
L56:    invokestatic [3] 
L59:    invokevirtual [26] 
L62:    ifeq L85 
L65:    aload_0 
L66:    getfield [20] 
L69:    invokestatic [4] 
L72:    ldc [5] 
L74:    ldc [6] 
L76:    aload 4 
L78:    aload_3 
L79:    invokestatic [7] 
L82:    invokevirtual [27] 
L85:    aload_3 
L86:    aload 4 
L88:    invokeinterface [35] 0 
L93:    ifeq L139 
L96:    aload_0 
L97:    getfield [20] 
L100:   invokevirtual [28] 
L103:   ifeq L139 
L106:   new [36] 
L109:   dup 
L110:   aload_0 
L111:   invokespecial [32] 
L114:   astore 5 
L116:   new [37] 
L119:   dup 
L120:   aload_0 
L121:   getfield [20] 
L124:   invokestatic [10] 
L127:   iload_2 
L128:   aload 4 
L130:   iconst_0 
L131:   aload 5 
L133:   invokespecial [33] 
L136:   invokevirtual [29] 
L139:   return 
L140:   
    .end code 
.end method 

.method synthetic [170] : [171] 
    .attribute [165] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [172] : [173] 
    .attribute [165] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [38] [39] 
.const [3] = Method [40] [41] 
.const [4] = Method [42] [43] 
.const [5] = Int -2137614336 
.const [6] = String [44] 
.const [7] = Method [45] [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = Method [49] [50] 
.const [11] = Class [51] 
.const [12] = Class [52] 
.const [13] = Class [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Field [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Method [86] [87] 
.const [34] = Field [88] [89] 
.const [35] = InterfaceMethod [90] [91] 
.const [36] = Class [92] 
.const [37] = Class [93] 
.const [38] = Class [94] 
.const [39] = NameAndType [95] [96] 
.const [40] = Class [97] 
.const [41] = NameAndType [98] [99] 
.const [42] = Class [100] 
.const [43] = NameAndType [101] [102] 
.const [44] = Utf8 '[SelectedMessage#indicateIndicationStateChanged]: selectedMessageId = %1; newMessageIds = %2' 
.const [45] = Class [103] 
.const [46] = NameAndType [104] [105] 
.const [47] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver$1 
.const [48] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [49] = Class [106] 
.const [50] = NameAndType [107] [108] 
.const [51] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [54] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [55] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [56] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [57] = Utf8 de/audi/atip/log/LogChannel 
.const [58] = Utf8 de/audi/app/messaging/core/util/Collections 
.const [59] = Utf8 java/util/Set 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Class [151] 
.const [89] = NameAndType [152] [153] 
.const [90] = Class [154] 
.const [91] = NameAndType [155] [156] 
.const [92] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver$1 
.const [93] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [94] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [95] = Utf8 access$700 
.const [96] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;)Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [97] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [98] = Utf8 access$800 
.const [99] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;)Lde/audi/atip/log/LogChannel; 
.const [100] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [101] = Utf8 access$900 
.const [102] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;)Lde/audi/atip/log/LogChannel; 
.const [103] = Utf8 de/audi/app/messaging/core/util/Collections 
.const [104] = Utf8 toString 
.const [105] = Utf8 (Ljava/util/Collection;)Ljava/lang/String; 
.const [106] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [107] = Utf8 access$1200 
.const [108] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;)Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [109] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver 
.const [110] = Utf8 this$0 
.const [111] = Utf8 Lde/audi/app/messaging/core/viewmessage/SelectedMessage; 
.const [112] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [113] = Utf8 getMessageDetails 
.const [114] = Utf8 ()Lorg/dsi/ifc/messaging/MessageDetails; 
.const [115] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [116] = Utf8 getMessagingAccountID 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [119] = Utf8 getNewMessageIndicationManager 
.const [120] = Utf8 ()Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [121] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [122] = Utf8 getNewMessageIDs 
.const [123] = Utf8 (I)Ljava/util/Set; 
.const [124] = Utf8 org/dsi/ifc/messaging/MessageDetails 
.const [125] = Utf8 getMessageID 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/audi/atip/log/LogChannel 
.const [128] = Utf8 isDebug 
.const [129] = Utf8 ()Z 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 log 
.const [132] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [133] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage 
.const [134] = Utf8 isInDetailView 
.const [135] = Utf8 ()Z 
.const [136] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [137] = Utf8 schedule 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;)V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver$1 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver;)V 
.const [148] = Utf8 de/audi/app/messaging/core/viewmessage/GetMessageContentsCommand 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;ILjava/lang/String;ILde/audi/app/messaging/core/viewmessage/GetMessageContentsCommand$ResultHandler;)V 
.const [151] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver 
.const [152] = Utf8 this$0 
.const [153] = Utf8 Lde/audi/app/messaging/core/viewmessage/SelectedMessage; 
.const [154] = Utf8 java/util/Set 
.const [155] = Utf8 contains 
.const [156] = Utf8 (Ljava/lang/Object;)Z 
.const [157] = Utf8 de/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver 
.const [158] = Class [157] 
.const [159] = Utf8 java/lang/Object 
.const [160] = Class [159] 
.const [161] = Utf8 de/audi/app/messaging/core/indication/INewMessageIndicationManagerObserver 
.const [162] = Class [161] 
.const [163] = Utf8 this$0 
.const [164] = Utf8 Lde/audi/app/messaging/core/viewmessage/SelectedMessage; 
.const [165] = Utf8 Code 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;)V 
.const [168] = Utf8 indicateIndicationStateChanged 
.const [169] = Utf8 (I)V 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage;Lde/audi/app/messaging/core/viewmessage/SelectedMessage$1;)V 
.const [172] = Utf8 access$1000 
.const [173] = Utf8 (Lde/audi/app/messaging/core/viewmessage/SelectedMessage$NewMessageIndicationManagerObserver;)Lde/audi/app/messaging/core/viewmessage/SelectedMessage; 
.end class 
