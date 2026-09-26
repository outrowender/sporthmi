.version 50 0 
.class final super [174] 
.super [176] 
.implements [178] 
.field private final [179] [180] 
.field private final [181] [182] 
.field private volatile [183] [184] 

.method public [186] : [187] 
    .attribute [185] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     new [35] 
L8:     dup 
L9:     invokespecial [34] 
L12:    putfield [36] 
L15:    aload_0 
L16:    getstatic [3] 
L19:    putfield [37] 
L22:    aload_0 
L23:    aload_1 
L24:    putfield [38] 
L27:    return 
L28:    
    .end code 
.end method 

.method [188] : [189] 
    .attribute [185] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_1 
L9:     invokevirtual [26] 
L12:    pop 
L13:    aload_0 
L14:    getfield [23] 
L17:    aload_1 
L18:    invokevirtual [27] 
L21:    pop 
        .catch [6] from L22 to L32 using L35 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [24] 
L27:    invokeinterface [39] 0 
L32:    goto L46 
L35:    astore_2 
L36:    aload_0 
L37:    getfield [25] 
L40:    aload_2 
L41:    ldc [7] 
L43:    invokestatic [8] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method [190] : [191] 
    .attribute [185] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [4] 
L6:     ldc [9] 
L8:     aload_1 
L9:     invokevirtual [26] 
L12:    pop 
L13:    aload_0 
L14:    getfield [23] 
L17:    aload_1 
L18:    invokevirtual [28] 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [192] : [193] 
    .attribute [185] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [4] 
L6:     ldc [10] 
L8:     aload_1 
L9:     invokevirtual [26] 
L12:    pop 
L13:    aload_0 
L14:    getfield [24] 
L17:    aload_1 
L18:    invokevirtual [29] 
L21:    ifne L78 
L24:    aload_0 
L25:    aload_1 
L26:    putfield [37] 
L29:    aload_0 
L30:    getfield [23] 
L33:    invokevirtual [30] 
L36:    astore_2 
L37:    aload_2 
L38:    invokeinterface [40] 0 
L43:    ifeq L78 
        .catch [6] from L46 to L61 using L64 
L46:    aload_2 
L47:    invokeinterface [41] 0 
L52:    checkcast [11] 
L55:    aload_1 
L56:    invokeinterface [39] 0 
L61:    goto L37 
L64:    astore_3 
L65:    aload_0 
L66:    getfield [25] 
L69:    aload_3 
L70:    ldc [12] 
L72:    invokestatic [8] 
L75:    goto L37 
L78:    return 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [185] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [4] 
L6:     ldc [13] 
L8:     iload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    aload_0 
L14:    getfield [23] 
L17:    invokevirtual [30] 
L20:    astore_2 
L21:    aload_2 
L22:    invokeinterface [40] 0 
L27:    ifeq L62 
        .catch [6] from L30 to L45 using L48 
L30:    aload_2 
L31:    invokeinterface [41] 0 
L36:    checkcast [11] 
L39:    iload_1 
L40:    invokeinterface [42] 0 
L45:    goto L21 
L48:    astore_3 
L49:    aload_0 
L50:    getfield [25] 
L53:    aload_3 
L54:    ldc [14] 
L56:    invokestatic [8] 
L59:    goto L21 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [185] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [4] 
L6:     ldc [15] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [32] 
L13:    pop 
L14:    aload_0 
L15:    getfield [23] 
L18:    invokevirtual [30] 
L21:    astore_2 
L22:    aload_2 
L23:    invokeinterface [40] 0 
L28:    ifeq L63 
        .catch [6] from L31 to L46 using L49 
L31:    aload_2 
L32:    invokeinterface [41] 0 
L37:    checkcast [11] 
L40:    iload_1 
L41:    invokeinterface [43] 0 
L46:    goto L22 
L49:    astore_3 
L50:    aload_0 
L51:    getfield [25] 
L54:    aload_3 
L55:    ldc [16] 
L57:    invokestatic [8] 
L60:    goto L22 
L63:    return 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = Field [45] [46] 
.const [4] = Int -2137614336 
.const [5] = String [47] 
.const [6] = Class [48] 
.const [7] = String [49] 
.const [8] = Method [50] [51] 
.const [9] = String [52] 
.const [10] = String [53] 
.const [11] = Class [54] 
.const [12] = String [55] 
.const [13] = String [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = String [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Class [65] 
.const [23] = Field [66] [67] 
.const [24] = Field [68] [69] 
.const [25] = Field [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Method [84] [85] 
.const [33] = Method [86] [87] 
.const [34] = Method [88] [89] 
.const [35] = Class [90] 
.const [36] = Field [91] [92] 
.const [37] = Field [93] [94] 
.const [38] = Field [95] [96] 
.const [39] = InterfaceMethod [97] [98] 
.const [40] = InterfaceMethod [99] [100] 
.const [41] = InterfaceMethod [101] [102] 
.const [42] = InterfaceMethod [103] [104] 
.const [43] = InterfaceMethod [105] [106] 
.const [44] = Utf8 de/audi/app/messaging/core/concurrent/CopyOnWriteArrayList 
.const [45] = Class [107] 
.const [46] = NameAndType [108] [109] 
.const [47] = Utf8 '[FolderNavigatorObserverProxy#addObserver] observer = %1' 
.const [48] = Utf8 java/lang/Exception 
.const [49] = Utf8 '[FolderNavigatorObserverProxy#addObserver]' 
.const [50] = Class [110] 
.const [51] = NameAndType [111] [112] 
.const [52] = Utf8 '[FolderNavigatorObserverProxy#removeObserver] observer = %1' 
.const [53] = Utf8 '[FolderNavigatorObserverProxy#updateCurrentFolder] currentFolder = %1' 
.const [54] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver 
.const [55] = Utf8 '[FolderNavigatorObserverProxy#updateCurrentFolder]' 
.const [56] = Utf8 '[FolderNavigatorObserverProxy#indicateFolderChange] inProgress = %1' 
.const [57] = Utf8 '[FolderNavigatorObserverProxy#indicateFolderChange]' 
.const [58] = Utf8 '[FolderNavigatorObserverProxy#indicateFolderChangeFailed] hmiFolderType = %1' 
.const [59] = Utf8 '[FolderNavigatorObserverProxy#indicateFolderChangeFailed]' 
.const [60] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/app/messaging/core/util/Logs 
.const [65] = Utf8 java/util/Iterator 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Class [125] 
.const [75] = NameAndType [126] [127] 
.const [76] = Class [128] 
.const [77] = NameAndType [129] [130] 
.const [78] = Class [131] 
.const [79] = NameAndType [132] [133] 
.const [80] = Class [134] 
.const [81] = NameAndType [135] [136] 
.const [82] = Class [137] 
.const [83] = NameAndType [138] [139] 
.const [84] = Class [140] 
.const [85] = NameAndType [141] [142] 
.const [86] = Class [143] 
.const [87] = NameAndType [144] [145] 
.const [88] = Class [146] 
.const [89] = NameAndType [147] [148] 
.const [90] = Utf8 de/audi/app/messaging/core/concurrent/CopyOnWriteArrayList 
.const [91] = Class [149] 
.const [92] = NameAndType [150] [151] 
.const [93] = Class [152] 
.const [94] = NameAndType [153] [154] 
.const [95] = Class [155] 
.const [96] = NameAndType [156] [157] 
.const [97] = Class [158] 
.const [98] = NameAndType [159] [160] 
.const [99] = Class [161] 
.const [100] = NameAndType [162] [163] 
.const [101] = Class [164] 
.const [102] = NameAndType [165] [166] 
.const [103] = Class [167] 
.const [104] = NameAndType [168] [169] 
.const [105] = Class [170] 
.const [106] = NameAndType [171] [172] 
.const [107] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [108] = Utf8 FOLDER_NONE 
.const [109] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [110] = Utf8 de/audi/app/messaging/core/util/Logs 
.const [111] = Utf8 logException 
.const [112] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/Throwable;Ljava/lang/String;)V 
.const [113] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [114] = Utf8 observers 
.const [115] = Utf8 Lde/audi/app/messaging/core/concurrent/CopyOnWriteArrayList; 
.const [116] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [117] = Utf8 currentFolder 
.const [118] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [119] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [120] = Utf8 log 
.const [121] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [122] = Utf8 de/audi/atip/log/LogChannel 
.const [123] = Utf8 log 
.const [124] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [125] = Utf8 de/audi/app/messaging/core/concurrent/CopyOnWriteArrayList 
.const [126] = Utf8 add 
.const [127] = Utf8 (Ljava/lang/Object;)Z 
.const [128] = Utf8 de/audi/app/messaging/core/concurrent/CopyOnWriteArrayList 
.const [129] = Utf8 remove 
.const [130] = Utf8 (Ljava/lang/Object;)Z 
.const [131] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folder 
.const [132] = Utf8 equals 
.const [133] = Utf8 (Ljava/lang/Object;)Z 
.const [134] = Utf8 de/audi/app/messaging/core/concurrent/CopyOnWriteArrayList 
.const [135] = Utf8 iterator 
.const [136] = Utf8 ()Ljava/util/Iterator; 
.const [137] = Utf8 de/audi/atip/log/LogChannel 
.const [138] = Utf8 log 
.const [139] = Utf8 (ILjava/lang/String;Z)Z 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;J)Z 
.const [143] = Utf8 java/lang/Object 
.const [144] = Utf8 <init> 
.const [145] = Utf8 ()V 
.const [146] = Utf8 de/audi/app/messaging/core/concurrent/CopyOnWriteArrayList 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [150] = Utf8 observers 
.const [151] = Utf8 Lde/audi/app/messaging/core/concurrent/CopyOnWriteArrayList; 
.const [152] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [153] = Utf8 currentFolder 
.const [154] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [155] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [156] = Utf8 log 
.const [157] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [158] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver 
.const [159] = Utf8 updateCurrentFolder 
.const [160] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/Folder;)V 
.const [161] = Utf8 java/util/Iterator 
.const [162] = Utf8 hasNext 
.const [163] = Utf8 ()Z 
.const [164] = Utf8 java/util/Iterator 
.const [165] = Utf8 next 
.const [166] = Utf8 ()Ljava/lang/Object; 
.const [167] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver 
.const [168] = Utf8 indicateFolderChange 
.const [169] = Utf8 (Z)V 
.const [170] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver 
.const [171] = Utf8 indicateFolderChangeFailed 
.const [172] = Utf8 (I)V 
.const [173] = Utf8 de/audi/app/messaging/core/folderbrowsing/FolderNavigatorObserverProxy 
.const [174] = Class [173] 
.const [175] = Utf8 java/lang/Object 
.const [176] = Class [175] 
.const [177] = Utf8 de/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver 
.const [178] = Class [177] 
.const [179] = Utf8 log 
.const [180] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [181] = Utf8 observers 
.const [182] = Utf8 Lde/audi/app/messaging/core/concurrent/CopyOnWriteArrayList; 
.const [183] = Utf8 currentFolder 
.const [184] = Utf8 Lde/audi/app/messaging/core/folderbrowsing/Folder; 
.const [185] = Utf8 Code 
.const [186] = Utf8 <init> 
.const [187] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [188] = Utf8 addObserver 
.const [189] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver;)V 
.const [190] = Utf8 removeObserver 
.const [191] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/IFolderNavigatorObserver;)V 
.const [192] = Utf8 updateCurrentFolder 
.const [193] = Utf8 (Lde/audi/app/messaging/core/folderbrowsing/Folder;)V 
.const [194] = Utf8 indicateFolderChange 
.const [195] = Utf8 (Z)V 
.const [196] = Utf8 indicateFolderChangeFailed 
.const [197] = Utf8 (I)V 
.end class 
