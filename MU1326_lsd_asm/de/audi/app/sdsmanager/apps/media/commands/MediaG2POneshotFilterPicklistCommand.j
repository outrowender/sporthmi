.version 50 0 
.class public super [129] 
.super [131] 
.field private final [132] [133] 
.field private static final [134] [135] 
.field private static final [136] [137] 
.field private static final [138] [139] 
.field private final [140] [141] 
.field private [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [27] 
L7:     aload_0 
L8:     iconst_3 
L9:     anewarray [2] 
L12:    dup 
L13:    iconst_0 
L14:    iconst_2 
L15:    newarray int 
L17:    dup 
L18:    iconst_0 
L19:    iconst_0 
L20:    iastore 
L21:    dup 
L22:    iconst_1 
L23:    iconst_5 
L24:    iastore 
L25:    aastore 
L26:    dup 
L27:    iconst_1 
L28:    iconst_2 
L29:    newarray int 
L31:    dup 
L32:    iconst_0 
L33:    iconst_1 
L34:    iastore 
L35:    dup 
L36:    iconst_1 
L37:    bipush 7 
L39:    iastore 
L40:    aastore 
L41:    dup 
L42:    iconst_2 
L43:    iconst_2 
L44:    newarray int 
L46:    dup 
L47:    iconst_0 
L48:    iconst_2 
L49:    iastore 
L50:    dup 
L51:    iconst_1 
L52:    bipush 6 
L54:    iastore 
L55:    aastore 
L56:    putfield [28] 
L59:    aload_0 
L60:    aload 4 
L62:    iconst_0 
L63:    invokestatic [3] 
L66:    putfield [29] 
L69:    aload_0 
L70:    aload 5 
L72:    invokeinterface [30] 0 
L77:    putfield [31] 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     invokevirtual [21] 
L12:    aload_0 
L13:    getfield [18] 
L16:    i2l 
L17:    invokevirtual [22] 
L20:    pop 
L21:    aload_0 
L22:    getfield [18] 
L25:    iflt L36 
L28:    aload_0 
L29:    getfield [18] 
L32:    iconst_2 
L33:    if_icmple L60 
L36:    aload_0 
L37:    getfield [20] 
L40:    ldc [4] 
L42:    ldc [6] 
L44:    aload_0 
L45:    invokevirtual [21] 
L48:    invokevirtual [23] 
L51:    pop 
L52:    aload_0 
L53:    sipush 20001 
L56:    invokevirtual [24] 
L59:    return 
L60:    aload_0 
L61:    getfield [19] 
L64:    ifnonnull L91 
L67:    aload_0 
L68:    getfield [20] 
L71:    ldc [4] 
L73:    ldc [7] 
L75:    aload_0 
L76:    invokevirtual [21] 
L79:    invokevirtual [23] 
L82:    pop 
L83:    aload_0 
L84:    sipush 20001 
L87:    invokevirtual [24] 
L90:    return 
L91:    aload_0 
L92:    getfield [19] 
L95:    aload_0 
L96:    getfield [18] 
L99:    aload_0 
L100:   getfield [17] 
L103:   invokestatic [8] 
L106:   invokevirtual [25] 
L109:   istore_1 
L110:   aload_0 
L111:   iload_1 
L112:   invokevirtual [26] 
L115:   return 
L116:   
    .end code 
.end method 

.method protected [149] : [150] 
    .attribute [144] .code stack 6 locals 0 
L0:     iload_1 
L1:     iconst_m1 
L2:     if_icmpne L33 
L5:     aload_0 
L6:     getfield [20] 
L9:     ldc [9] 
L11:    ldc [10] 
L13:    aload_0 
L14:    invokevirtual [21] 
L17:    iload_1 
L18:    i2l 
L19:    invokevirtual [22] 
L22:    pop 
L23:    aload_0 
L24:    sipush 20001 
L27:    invokevirtual [24] 
L30:    goto L40 
L33:    aload_0 
L34:    sipush 20000 
L37:    invokevirtual [24] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Method [33] [34] 
.const [4] = Int -2137614336 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = String [37] 
.const [8] = Method [38] [39] 
.const [9] = Int -1601830656 
.const [10] = String [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Field [69] [70] 
.const [29] = Field [71] [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = Field [75] [76] 
.const [32] = Utf8 [I 
.const [33] = Class [77] 
.const [34] = NameAndType [78] [79] 
.const [35] = Utf8 '%1#execute: slot=%2' 
.const [36] = Utf8 '%1#execute' 
.const [37] = Utf8 '%1#execute oneshot handler is null!' 
.const [38] = Class [80] 
.const [39] = NameAndType [81] [82] 
.const [40] = Utf8 '%1#execute: Filtered picklist length error %2, sending ERROR!' 
.const [41] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [42] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [43] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [44] = Utf8 de/audi/app/sdsmanager/apps/media/MediaSDSHandler 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 de/audi/app/sdsmanager/oneshot/OneshotHandler 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [78] = Utf8 retrieveInteger 
.const [79] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [80] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [81] = Utf8 translate 
.const [82] = Utf8 (I[[I)I 
.const [83] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [84] = Utf8 mediaG2PSlotToListMode 
.const [85] = Utf8 [[I 
.const [86] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [87] = Utf8 slot 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [90] = Utf8 oneshotHandler 
.const [91] = Utf8 Lde/audi/app/sdsmanager/oneshot/OneshotHandler; 
.const [92] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [93] = Utf8 logger 
.const [94] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [96] = Utf8 getName 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [104] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [105] = Utf8 sendResult 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 de/audi/app/sdsmanager/oneshot/OneshotHandler 
.const [108] = Utf8 filterPicklist 
.const [109] = Utf8 (I)B 
.const [110] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [111] = Utf8 handleAnswer 
.const [112] = Utf8 (I)V 
.const [113] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [116] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [117] = Utf8 mediaG2PSlotToListMode 
.const [118] = Utf8 [[I 
.const [119] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [120] = Utf8 slot 
.const [121] = Utf8 I 
.const [122] = Utf8 de/audi/app/sdsmanager/apps/media/MediaSDSHandler 
.const [123] = Utf8 getOneshotHandler 
.const [124] = Utf8 ()Lde/audi/app/sdsmanager/oneshot/OneshotHandler; 
.const [125] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [126] = Utf8 oneshotHandler 
.const [127] = Utf8 Lde/audi/app/sdsmanager/oneshot/OneshotHandler; 
.const [128] = Utf8 de/audi/app/sdsmanager/apps/media/commands/MediaG2POneshotFilterPicklistCommand 
.const [129] = Class [128] 
.const [130] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [131] = Class [130] 
.const [132] = Utf8 slot 
.const [133] = Utf8 I 
.const [134] = Utf8 MEDIA_G2P_ARTIST_SLOT 
.const [135] = Utf8 I 
.const [136] = Utf8 MEDIA_G2P_ALBUM_SLOT 
.const [137] = Utf8 I 
.const [138] = Utf8 MEDIA_G2P_TITLE_SLOT 
.const [139] = Utf8 I 
.const [140] = Utf8 mediaG2PSlotToListMode 
.const [141] = Utf8 [[I 
.const [142] = Utf8 oneshotHandler 
.const [143] = Utf8 Lde/audi/app/sdsmanager/oneshot/OneshotHandler; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/app/sdsmanager/apps/media/MediaSDSHandler;)V 
.const [147] = Utf8 execute 
.const [148] = Utf8 ()V 
.const [149] = Utf8 handleAnswer 
.const [150] = Utf8 (I)V 
.end class 
