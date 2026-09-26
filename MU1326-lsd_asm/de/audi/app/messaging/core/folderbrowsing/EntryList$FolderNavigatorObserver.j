.version 50 0 
.class final super [134] 
.super [136] 
.field private final synthetic [137] [138] 

.method private [140] : [141] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     aload_0 
L6:     invokespecial [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [139] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokestatic [2] 
L7:     invokevirtual [20] 
L10:    dup 
L11:    astore_2 
L12:    monitorenter 
        .catch [0] from L13 to L83 using L86 
L13:    aload_0 
L14:    getfield [19] 
L17:    invokestatic [3] 
L20:    ldc [4] 
L22:    ldc [5] 
L24:    iload_1 
L25:    invokevirtual [21] 
L28:    pop 
L29:    aload_0 
L30:    getfield [19] 
L33:    iconst_1 
L34:    putfield [29] 
L37:    iload_1 
L38:    ifeq L60 
L41:    aload_0 
L42:    getfield [19] 
L45:    iconst_0 
L46:    invokestatic [6] 
L49:    aload_0 
L50:    getfield [19] 
L53:    iconst_0 
L54:    invokevirtual [22] 
L57:    goto L81 
L60:    aload_0 
L61:    getfield [19] 
L64:    invokestatic [7] 
L67:    invokevirtual [23] 
L70:    ifne L81 
L73:    aload_0 
L74:    getfield [19] 
L77:    iconst_3 
L78:    invokestatic [6] 
L81:    aload_2 
L82:    monitorexit 
L83:    goto L91 
        .catch [0] from L86 to L89 using L86 
L86:    astore_3 
L87:    aload_2 
L88:    monitorexit 
L89:    aload_3 
L90:    athrow 
L91:    return 
L92:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [139] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokestatic [8] 
L7:     invokevirtual [20] 
L10:    dup 
L11:    astore_2 
L12:    monitorenter 
        .catch [0] from L13 to L72 using L75 
L13:    aload_0 
L14:    getfield [19] 
L17:    invokestatic [9] 
L20:    ldc [4] 
L22:    ldc [10] 
L24:    aload_1 
L25:    invokevirtual [24] 
L28:    pop 
L29:    aload_0 
L30:    getfield [19] 
L33:    aload_1 
L34:    invokestatic [11] 
L37:    pop 
L38:    aload_1 
L39:    invokevirtual [23] 
L42:    istore_3 
L43:    aload_0 
L44:    getfield [19] 
L47:    iload_3 
L48:    ifne L55 
L51:    iconst_1 
L52:    goto L56 
L55:    iconst_0 
L56:    invokevirtual [25] 
L59:    iload_3 
L60:    ifne L70 
L63:    aload_0 
L64:    getfield [19] 
L67:    invokestatic [12] 
L70:    aload_2 
L71:    monitorexit 
L72:    goto L82 
        .catch [0] from L75 to L79 using L75 
L75:    astore 4 
L77:    aload_2 
L78:    monitorexit 
L79:    aload 4 
L81:    athrow 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method synthetic [146] : [147] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [26] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [30] [31] 
.const [3] = Method [32] [33] 
.const [4] = Int -2137614336 
.const [5] = String [34] 
.const [6] = Method [35] [36] 
.const [7] = Method [37] [38] 
.const [8] = Method [39] [40] 
.const [9] = Method [41] [42] 
.const [10] = String [43] 
.const [11] = Method [44] [45] 
.const [12] = Method [46] [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Field [74] [75] 
.const [30] = Class [76] 
.const [31] = NameAndType [77] [78] 
.const [32] = Class [79] 
.const [33] = NameAndType [80] [81] 
.const [34] = Utf8 '[EntryList#indicateFolderChange] inProgress = %1' 
.const [35] = Class [82] 
.const [36] = NameAndType [83] [84] 
.const [37] = Class [85] 
.const [38] = NameAndType [86] [87] 
.const [39] = Class [88] 
.const [40] = NameAndType [89] [90] 
.const [41] = Class [91] 
.const [42] = NameAndType [92] [93] 
.const [43] = Utf8 '[EntryList#updateCurrentFolder] currentFolder = %1' 
.const [44] = Class [94] 
.const [45] = NameAndType [95] [96] 
.const [46] = Class [97] 
.const [47] = NameAndType [98] [99] 
.const [48] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList$FolderNavigatorObserver 
.const [49] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver$EmptyImplementation 
.const [50] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [51] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
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
.const [76] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [77] = Utf8 access$3100 
.const [78] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)Lde/audi/app/messaging/core/osgi/MessagingBundleContext; 
.const [79] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [80] = Utf8 access$3200 
.const [81] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)Lde/audi/atip/log/LogChannel; 
.const [82] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [83] = Utf8 access$1000 
.const [84] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;I)V 
.const [85] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [86] = Utf8 access$3300 
.const [87] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [88] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [89] = Utf8 access$3400 
.const [90] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)Lde/audi/app/messaging/core/osgi/MessagingBundleContext; 
.const [91] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [92] = Utf8 access$3500 
.const [93] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [95] = Utf8 access$3302 
.const [96] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;Lde/audi/app/messaging/core/folderbrowsing/Folder;)Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [97] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [98] = Utf8 access$3600 
.const [99] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)V 
.const [100] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList$FolderNavigatorObserver 
.const [101] = Utf8 this$0 
.const [102] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/EntryList; 
.const [103] = Utf8 de/audi/app/messaging/core/osgi/MessagingBundleContext 
.const [104] = Utf8 getMessagingHmiLock 
.const [105] = Utf8 ()Ljava/lang/Object; 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;Z)Z 
.const [109] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [110] = Utf8 setAwaitFolderChange 
.const [111] = Utf8 (Z)V 
.const [112] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [113] = Utf8 isValid 
.const [114] = Utf8 ()Z 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [118] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [119] = Utf8 setIgnoreUpdates 
.const [120] = Utf8 (Z)V 
.const [121] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList$FolderNavigatorObserver 
.const [122] = Utf8 <init> 
.const [123] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)V 
.const [124] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver$EmptyImplementation 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList$FolderNavigatorObserver 
.const [128] = Utf8 this$0 
.const [129] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/EntryList; 
.const [130] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList 
.const [131] = Utf8 isFolderChangeInProgress 
.const [132] = Utf8 Z 
.const [133] = Utf8 de/audi/app/messaging/core/folderbrowsing/EntryList$FolderNavigatorObserver 
.const [134] = Class [133] 
.const [135] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver$EmptyImplementation 
.const [136] = Class [135] 
.const [137] = Utf8 this$0 
.const [138] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/EntryList; 
.const [139] = Utf8 Code 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;)V 
.const [142] = Utf8 indicateFolderChange 
.const [143] = Utf8 (Z)V 
.const [144] = Utf8 updateCurrentFolder 
.const [145] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/Folder;)V 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/EntryList;Lde/audi/app/messaging/core/folderbrowsing/EntryList$1;)V 
.end class 
