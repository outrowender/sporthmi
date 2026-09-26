.version 50 0 
.class public super [83] 
.super [85] 
.implements [87] 
.field private final [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     new [16] 
L8:     dup 
L9:     iconst_5 
L10:    invokespecial [14] 
L13:    putfield [17] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [90] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     dup 
L5:     astore 4 
L7:     monitorenter 
        .catch [0] from L8 to L22 using L25 
L8:     aload_0 
L9:     getfield [7] 
L12:    invokevirtual [8] 
L15:    checkcast [2] 
L18:    astore_3 
L19:    aload 4 
L21:    monitorexit 
L22:    goto L33 
        .catch [0] from L25 to L30 using L25 
L25:    astore 5 
L27:    aload 4 
L29:    monitorexit 
L30:    aload 5 
L32:    athrow 
L33:    new [18] 
L36:    dup 
L37:    iload_2 
L38:    invokespecial [15] 
L41:    astore 4 
L43:    aload_3 
L44:    aload 4 
L46:    invokevirtual [9] 
L49:    ifeq L68 
L52:    aload_3 
L53:    aload 4 
L55:    invokevirtual [10] 
L58:    checkcast [4] 
L61:    iload_1 
L62:    iload_2 
L63:    invokeinterface [19] 0 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [90] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L42 using L45 
L7:     new [18] 
L10:    dup 
L11:    iload_2 
L12:    invokespecial [15] 
L15:    astore 4 
L17:    aload_0 
L18:    getfield [7] 
L21:    aload 4 
L23:    invokevirtual [9] 
L26:    ifne L40 
L29:    aload_0 
L30:    getfield [7] 
L33:    aload 4 
L35:    aload_1 
L36:    invokevirtual [11] 
L39:    pop 
L40:    aload_3 
L41:    monitorexit 
L42:    goto L52 
        .catch [0] from L45 to L49 using L45 
L45:    astore 5 
L47:    aload_3 
L48:    monitorexit 
L49:    aload 5 
L51:    athrow 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [90] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [7] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L38 using L41 
L7:     new [18] 
L10:    dup 
L11:    iload_1 
L12:    invokespecial [15] 
L15:    astore_3 
L16:    aload_0 
L17:    getfield [7] 
L20:    aload_3 
L21:    invokevirtual [9] 
L24:    ifeq L36 
L27:    aload_0 
L28:    getfield [7] 
L31:    aload_3 
L32:    invokevirtual [12] 
L35:    pop 
L36:    aload_2 
L37:    monitorexit 
L38:    goto L48 
        .catch [0] from L41 to L45 using L41 
L41:    astore 4 
L43:    aload_2 
L44:    monitorexit 
L45:    aload 4 
L47:    athrow 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Field [25] [26] 
.const [8] = Method [27] [28] 
.const [9] = Method [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Class [43] 
.const [17] = Field [44] [45] 
.const [18] = Class [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = Utf8 java/util/HashMap 
.const [21] = Utf8 java/lang/Integer 
.const [22] = Utf8 de/audi/atip/interapp/audio/IAnnouncementStateListener 
.const [23] = Utf8 de/audi/tone/app/announcement/AnnouncementStateDispatcher 
.const [24] = Utf8 java/lang/Object 
.const [25] = Class [49] 
.const [26] = NameAndType [50] [51] 
.const [27] = Class [52] 
.const [28] = NameAndType [53] [54] 
.const [29] = Class [55] 
.const [30] = NameAndType [56] [57] 
.const [31] = Class [58] 
.const [32] = NameAndType [59] [60] 
.const [33] = Class [61] 
.const [34] = NameAndType [62] [63] 
.const [35] = Class [64] 
.const [36] = NameAndType [65] [66] 
.const [37] = Class [67] 
.const [38] = NameAndType [68] [69] 
.const [39] = Class [70] 
.const [40] = NameAndType [71] [72] 
.const [41] = Class [73] 
.const [42] = NameAndType [74] [75] 
.const [43] = Utf8 java/util/HashMap 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Utf8 java/lang/Integer 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Utf8 de/audi/tone/app/announcement/AnnouncementStateDispatcher 
.const [50] = Utf8 listeners 
.const [51] = Utf8 Ljava/util/HashMap; 
.const [52] = Utf8 java/util/HashMap 
.const [53] = Utf8 clone 
.const [54] = Utf8 ()Ljava/lang/Object; 
.const [55] = Utf8 java/util/HashMap 
.const [56] = Utf8 containsKey 
.const [57] = Utf8 (Ljava/lang/Object;)Z 
.const [58] = Utf8 java/util/HashMap 
.const [59] = Utf8 get 
.const [60] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [61] = Utf8 java/util/HashMap 
.const [62] = Utf8 put 
.const [63] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [64] = Utf8 java/util/HashMap 
.const [65] = Utf8 remove 
.const [66] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 java/util/HashMap 
.const [71] = Utf8 <init> 
.const [72] = Utf8 (I)V 
.const [73] = Utf8 java/lang/Integer 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (I)V 
.const [76] = Utf8 de/audi/tone/app/announcement/AnnouncementStateDispatcher 
.const [77] = Utf8 listeners 
.const [78] = Utf8 Ljava/util/HashMap; 
.const [79] = Utf8 de/audi/atip/interapp/audio/IAnnouncementStateListener 
.const [80] = Utf8 updateAnnouncementState 
.const [81] = Utf8 (II)V 
.const [82] = Utf8 de/audi/tone/app/announcement/AnnouncementStateDispatcher 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 de/audi/atip/interapp/audio/IAnnouncementStateListener 
.const [87] = Class [86] 
.const [88] = Utf8 listeners 
.const [89] = Utf8 Ljava/util/HashMap; 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 updateAnnouncementState 
.const [94] = Utf8 (II)V 
.const [95] = Utf8 addAnnouncementStateListener 
.const [96] = Utf8 (Lde/audi/atip/interapp/audio/IAnnouncementStateListener;I)V 
.const [97] = Utf8 removeAnnouncementStateListener 
.const [98] = Utf8 (I)V 
.end class 
