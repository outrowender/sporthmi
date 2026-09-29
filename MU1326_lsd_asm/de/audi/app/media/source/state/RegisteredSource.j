.version 50 0 
.class public super [138] 
.super [140] 
.implements [142] 
.field private final [143] [144] 
.field private final [145] [146] 
.field private final [147] [148] 
.field private static final [149] [150] 

.method public [152] : [153] 
    .attribute [151] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [25] 
L9:     aload_0 
L10:    new [26] 
L13:    dup 
L14:    invokespecial [23] 
L17:    putfield [27] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [28] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [154] : [155] 
    .attribute [151] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [29] 
L7:     dup 
L8:     invokespecial [24] 
L11:    athrow 
L12:    aload_0 
L13:    getfield [15] 
L16:    aload_1 
L17:    invokevirtual [17] 
L20:    pop 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     aload_1 
L5:     invokevirtual [18] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public final [160] : [161] 
    .attribute [151] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [19] 
L7:     astore_1 
L8:     aload_1 
L9:     invokeinterface [30] 0 
L14:    ifeq L57 
        .catch [5] from L17 to L35 using L38 
L17:    aload_1 
L18:    invokeinterface [31] 0 
L23:    checkcast [4] 
L26:    aload_0 
L27:    invokevirtual [20] 
L30:    invokeinterface [32] 0 
L35:    goto L8 
L38:    astore_2 
L39:    aload_0 
L40:    getfield [16] 
L43:    ldc [6] 
L45:    ldc [7] 
L47:    ldc [8] 
L49:    aload_2 
L50:    invokevirtual [21] 
L53:    pop 
L54:    goto L8 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [151] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokeinterface [33] 0 
L9:     aload_1 
L10:    checkcast [9] 
L13:    getfield [14] 
L16:    invokeinterface [33] 0 
L21:    isub 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = Int -1601830656 
.const [7] = String [38] 
.const [8] = String [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Field [45] [46] 
.const [15] = Field [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Class [69] 
.const [27] = Field [70] [71] 
.const [28] = Field [72] [73] 
.const [29] = Class [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = InterfaceMethod [79] [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Utf8 de/audi/app/media/util/CopyOnWriteArrayList 
.const [35] = Utf8 java/lang/IllegalArgumentException 
.const [36] = Utf8 de/audi/app/media/source/ISourceSlotListener 
.const [37] = Utf8 java/lang/Exception 
.const [38] = Utf8 '[%1.notifySlotChanged] Exception occured: %2' 
.const [39] = Utf8 RegisteredSource 
.const [40] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 java/util/Iterator 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/app/media/source/ISource 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Utf8 de/audi/app/media/util/CopyOnWriteArrayList 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Utf8 java/lang/IllegalArgumentException 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Class [131] 
.const [80] = NameAndType [132] [133] 
.const [81] = Class [134] 
.const [82] = NameAndType [135] [136] 
.const [83] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [84] = Utf8 source 
.const [85] = Utf8 Lde/audi/app/media/source/ISource; 
.const [86] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [87] = Utf8 registeredSourceSlotListeners 
.const [88] = Utf8 Lde/audi/app/media/util/CopyOnWriteArrayList; 
.const [89] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [90] = Utf8 logger 
.const [91] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 de/audi/app/media/util/CopyOnWriteArrayList 
.const [93] = Utf8 addIfAbsent 
.const [94] = Utf8 (Ljava/lang/Object;)Z 
.const [95] = Utf8 de/audi/app/media/util/CopyOnWriteArrayList 
.const [96] = Utf8 remove 
.const [97] = Utf8 (Ljava/lang/Object;)Z 
.const [98] = Utf8 de/audi/app/media/util/CopyOnWriteArrayList 
.const [99] = Utf8 iterator 
.const [100] = Utf8 ()Ljava/util/Iterator; 
.const [101] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [102] = Utf8 getSource 
.const [103] = Utf8 ()Lde/audi/app/media/source/ISource; 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [107] = Utf8 java/lang/Object 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/app/media/util/CopyOnWriteArrayList 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/lang/IllegalArgumentException 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [117] = Utf8 source 
.const [118] = Utf8 Lde/audi/app/media/source/ISource; 
.const [119] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [120] = Utf8 registeredSourceSlotListeners 
.const [121] = Utf8 Lde/audi/app/media/util/CopyOnWriteArrayList; 
.const [122] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [123] = Utf8 logger 
.const [124] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 java/util/Iterator 
.const [126] = Utf8 hasNext 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 java/util/Iterator 
.const [129] = Utf8 next 
.const [130] = Utf8 ()Ljava/lang/Object; 
.const [131] = Utf8 de/audi/app/media/source/ISourceSlotListener 
.const [132] = Utf8 slotsChanged 
.const [133] = Utf8 (Lde/audi/app/media/source/ISource;)V 
.const [134] = Utf8 de/audi/app/media/source/ISource 
.const [135] = Utf8 getType 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/audi/app/media/source/state/RegisteredSource 
.const [138] = Class [137] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [139] 
.const [141] = Utf8 java/lang/Comparable 
.const [142] = Class [141] 
.const [143] = Utf8 source 
.const [144] = Utf8 Lde/audi/app/media/source/ISource; 
.const [145] = Utf8 registeredSourceSlotListeners 
.const [146] = Utf8 Lde/audi/app/media/util/CopyOnWriteArrayList; 
.const [147] = Utf8 logger 
.const [148] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [149] = Utf8 LOGCLASS 
.const [150] = Utf8 Ljava/lang/String; 
.const [151] = Utf8 Code 
.const [152] = Utf8 <init> 
.const [153] = Utf8 (Lde/audi/app/media/source/ISource;Lde/audi/atip/log/LogChannel;)V 
.const [154] = Utf8 getSource 
.const [155] = Utf8 ()Lde/audi/app/media/source/ISource; 
.const [156] = Utf8 addSourceSlotListener 
.const [157] = Utf8 (Lde/audi/app/media/source/ISourceSlotListener;)V 
.const [158] = Utf8 removeSlotListener 
.const [159] = Utf8 (Lde/audi/app/media/source/ISourceSlotListener;)V 
.const [160] = Utf8 notifySlotChanged 
.const [161] = Utf8 ()V 
.const [162] = Utf8 compareTo 
.const [163] = Utf8 (Ljava/lang/Object;)I 
.end class 
