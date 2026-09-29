.version 50 0 
.class public super [83] 
.super [85] 
.field private final [86] [87] 

.method public [89] : [90] 
    .attribute [88] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     new [11] 
L8:     dup 
L9:     invokespecial [10] 
L12:    putfield [12] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [88] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L33 using L36 
L7:     aload_0 
L8:     getfield [8] 
L11:    aload_1 
L12:    invokeinterface [13] 0 
L17:    ifne L31 
L20:    aload_0 
L21:    getfield [8] 
L24:    aload_1 
L25:    invokeinterface [14] 0 
L30:    pop 
L31:    aload_2 
L32:    monitorexit 
L33:    goto L41 
        .catch [0] from L36 to L39 using L36 
L36:    astore_3 
L37:    aload_2 
L38:    monitorexit 
L39:    aload_3 
L40:    athrow 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [88] .code stack 2 locals 3 
L0:     new [11] 
L3:     dup 
L4:     invokespecial [10] 
L7:     astore_2 
L8:     aload_0 
L9:     getfield [8] 
L12:    dup 
L13:    astore_3 
L14:    monitorenter 
        .catch [0] from L15 to L28 using L31 
L15:    aload_2 
L16:    aload_0 
L17:    getfield [8] 
L20:    invokeinterface [15] 0 
L25:    pop 
L26:    aload_3 
L27:    monitorexit 
L28:    goto L38 
        .catch [0] from L31 to L35 using L31 
L31:    astore 4 
L33:    aload_3 
L34:    monitorexit 
L35:    aload 4 
L37:    athrow 
L38:    aload_2 
L39:    invokeinterface [16] 0 
L44:    astore_3 
L45:    aload_3 
L46:    invokeinterface [17] 0 
L51:    ifeq L76 
L54:    aload_3 
L55:    invokeinterface [18] 0 
L60:    checkcast [3] 
L63:    astore 4 
L65:    aload 4 
L67:    aload_1 
L68:    invokeinterface [19] 0 
L73:    goto L45 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Field [26] [27] 
.const [9] = Method [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Class [32] 
.const [12] = Field [33] [34] 
.const [13] = InterfaceMethod [35] [36] 
.const [14] = InterfaceMethod [37] [38] 
.const [15] = InterfaceMethod [39] [40] 
.const [16] = InterfaceMethod [41] [42] 
.const [17] = InterfaceMethod [43] [44] 
.const [18] = InterfaceMethod [45] [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = Utf8 java/util/LinkedList 
.const [21] = Utf8 de/audi/tuner/util/change/ChangeListener 
.const [22] = Utf8 de/audi/tuner/util/change/ChangeHandler 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 java/util/List 
.const [25] = Utf8 java/util/Iterator 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Class [52] 
.const [29] = NameAndType [53] [54] 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Utf8 java/util/LinkedList 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Utf8 de/audi/tuner/util/change/ChangeHandler 
.const [50] = Utf8 listeners 
.const [51] = Utf8 Ljava/util/List; 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 java/util/LinkedList 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/audi/tuner/util/change/ChangeHandler 
.const [59] = Utf8 listeners 
.const [60] = Utf8 Ljava/util/List; 
.const [61] = Utf8 java/util/List 
.const [62] = Utf8 contains 
.const [63] = Utf8 (Ljava/lang/Object;)Z 
.const [64] = Utf8 java/util/List 
.const [65] = Utf8 add 
.const [66] = Utf8 (Ljava/lang/Object;)Z 
.const [67] = Utf8 java/util/List 
.const [68] = Utf8 addAll 
.const [69] = Utf8 (Ljava/util/Collection;)Z 
.const [70] = Utf8 java/util/List 
.const [71] = Utf8 iterator 
.const [72] = Utf8 ()Ljava/util/Iterator; 
.const [73] = Utf8 java/util/Iterator 
.const [74] = Utf8 hasNext 
.const [75] = Utf8 ()Z 
.const [76] = Utf8 java/util/Iterator 
.const [77] = Utf8 next 
.const [78] = Utf8 ()Ljava/lang/Object; 
.const [79] = Utf8 de/audi/tuner/util/change/ChangeListener 
.const [80] = Utf8 stateChanged 
.const [81] = Utf8 (Lde/audi/tuner/util/change/ChangeEvent;)V 
.const [82] = Utf8 de/audi/tuner/util/change/ChangeHandler 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 listeners 
.const [87] = Utf8 Ljava/util/List; 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 addChangeListener 
.const [92] = Utf8 (Lde/audi/tuner/util/change/ChangeListener;)V 
.const [93] = Utf8 signalChange 
.const [94] = Utf8 (Lde/audi/tuner/util/change/ChangeEvent;)V 
.end class 
