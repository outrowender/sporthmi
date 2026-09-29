.version 50 0 
.class public final super [129] 
.super [131] 

.method public annotation [133] : [134] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [135] : [136] 
    .attribute [132] .code stack 2 locals 0 
L0:     iload_0 
L1:     bipush -6 
L3:     if_icmpeq L53 
L6:     iload_0 
L7:     bipush -7 
L9:     if_icmpeq L53 
L12:    iload_0 
L13:    bipush -3 
L15:    if_icmpeq L53 
L18:    iload_0 
L19:    bipush -8 
L21:    if_icmpeq L53 
L24:    iload_0 
L25:    bipush -4 
L27:    if_icmpeq L53 
L30:    iload_0 
L31:    bipush -2 
L33:    if_icmpeq L53 
L36:    iload_0 
L37:    iconst_m1 
L38:    if_icmpeq L53 
L41:    iload_0 
L42:    bipush -9 
L44:    if_icmpeq L53 
L47:    iload_0 
L48:    bipush -5 
L50:    if_icmpne L57 
L53:    iconst_1 
L54:    goto L58 
L57:    iconst_0 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [137] : [138] 
    .attribute [132] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_3 
L2:     if_icmpeq L16 
L5:     iload_0 
L6:     iconst_5 
L7:     if_icmpeq L16 
L10:    iload_0 
L11:    bipush 6 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [139] : [140] 
    .attribute [132] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_4 
L2:     if_icmpeq L26 
L5:     iload_0 
L6:     iconst_5 
L7:     if_icmpeq L26 
L10:    iload_0 
L11:    iconst_3 
L12:    if_icmpeq L26 
L15:    iload_0 
L16:    bipush 6 
L18:    if_icmpeq L26 
L21:    iload_0 
L22:    iconst_2 
L23:    if_icmpne L30 
L26:    iconst_1 
L27:    goto L31 
L30:    iconst_0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public static [141] : [142] 
    .attribute [132] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     istore_2 
L5:     iload_2 
L6:     invokestatic [3] 
L9:     ifne L39 
L12:    new [29] 
L15:    dup 
L16:    new [30] 
L19:    dup 
L20:    invokespecial [27] 
L23:    ldc [6] 
L25:    invokevirtual [16] 
L28:    aload_0 
L29:    invokevirtual [17] 
L32:    invokevirtual [18] 
L35:    invokespecial [28] 
L38:    athrow 
L39:    iload_1 
L40:    invokestatic [7] 
L43:    ifeq L52 
L46:    iload_1 
L47:    bipush -2 
L49:    if_icmpne L79 
L52:    new [29] 
L55:    dup 
L56:    new [30] 
L59:    dup 
L60:    invokespecial [27] 
L63:    ldc [8] 
L65:    invokevirtual [16] 
L68:    iload_1 
L69:    invokevirtual [19] 
L72:    invokevirtual [18] 
L75:    invokespecial [28] 
L78:    athrow 
L79:    iload_2 
L80:    iload_1 
L81:    invokestatic [9] 
L84:    if_icmpne L91 
L87:    iconst_1 
L88:    goto L92 
L91:    iconst_0 
L92:    areturn 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [132] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iload_0 
L3:     tableswitch -9 
            L72 
            L62 
            L57 
            L52 
            L77 
            L67 
            L62 
            L83 
            L72 
            default : L83 

L52:    iconst_2 
L53:    istore_1 
L54:    goto L93 
L57:    iconst_3 
L58:    istore_1 
L59:    goto L93 
L62:    iconst_4 
L63:    istore_1 
L64:    goto L93 
L67:    iconst_5 
L68:    istore_1 
L69:    goto L93 
L72:    iconst_1 
L73:    istore_1 
L74:    goto L93 
L77:    bipush 6 
L79:    istore_1 
L80:    goto L93 
L83:    new [29] 
L86:    dup 
L87:    ldc [10] 
L89:    invokespecial [28] 
L92:    athrow 
L93:    iload_1 
L94:    areturn 
L95:    nop 
L96:    
    .end code 
.end method 

.method public static [145] : [146] 
    .attribute [132] .code stack 4 locals 2 
L0:     bipush 7 
L2:     istore_1 
L3:     aload_0 
L4:     invokevirtual [20] 
L7:     istore_2 
L8:     iload_2 
L9:     tableswitch 1 
            L62 
            L67 
            L57 
            L72 
            L78 
            L84 
            L52 
            default : L84 

L52:    iconst_2 
L53:    istore_1 
L54:    goto L111 
L57:    iconst_3 
L58:    istore_1 
L59:    goto L111 
L62:    iconst_4 
L63:    istore_1 
L64:    goto L111 
L67:    iconst_5 
L68:    istore_1 
L69:    goto L111 
L72:    bipush 6 
L74:    istore_1 
L75:    goto L111 
L78:    bipush 7 
L80:    istore_1 
L81:    goto L111 
L84:    new [29] 
L87:    dup 
L88:    new [30] 
L91:    dup 
L92:    invokespecial [27] 
L95:    ldc [11] 
L97:    invokevirtual [16] 
L100:   iload_2 
L101:   invokevirtual [19] 
L104:   invokevirtual [18] 
L107:   invokespecial [28] 
L110:   athrow 
L111:   iload_1 
L112:   areturn 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public static [147] : [148] 
    .attribute [132] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     ifnonnull L15 
L6:     aload_1 
L7:     ifnonnull L15 
L10:    iconst_1 
L11:    istore_2 
L12:    goto L87 
L15:    aload_0 
L16:    ifnull L87 
L19:    aload_1 
L20:    ifnull L87 
L23:    aload_0 
L24:    invokevirtual [21] 
L27:    aload_1 
L28:    invokevirtual [21] 
L31:    if_icmpne L85 
L34:    aload_0 
L35:    invokevirtual [22] 
L38:    aload_1 
L39:    invokevirtual [22] 
L42:    invokevirtual [23] 
L45:    ifeq L85 
L48:    aload_0 
L49:    invokevirtual [20] 
L52:    aload_1 
L53:    invokevirtual [20] 
L56:    if_icmpne L85 
L59:    aload_0 
L60:    invokevirtual [24] 
L63:    aload_1 
L64:    invokevirtual [24] 
L67:    if_icmpne L85 
L70:    aload_0 
L71:    invokevirtual [25] 
L74:    aload_1 
L75:    invokevirtual [25] 
L78:    if_icmpne L85 
L81:    iconst_1 
L82:    goto L86 
L85:    iconst_0 
L86:    istore_2 
L87:    iload_2 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [31] [32] 
.const [3] = Method [33] [34] 
.const [4] = Class [35] 
.const [5] = Class [36] 
.const [6] = String [37] 
.const [7] = Method [38] [39] 
.const [8] = String [40] 
.const [9] = Method [41] [42] 
.const [10] = String [43] 
.const [11] = String [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Class [75] 
.const [30] = Class [76] 
.const [31] = Class [77] 
.const [32] = NameAndType [78] [79] 
.const [33] = Class [80] 
.const [34] = NameAndType [81] [82] 
.const [35] = Utf8 java/lang/IllegalArgumentException 
.const [36] = Utf8 java/lang/StringBuffer 
.const [37] = Utf8 'Not a standard folder: standardFolderEntry = ' 
.const [38] = Class [83] 
.const [39] = NameAndType [84] [85] 
.const [40] = Utf8 'Illegal folder ID: predefinedFolderId = ' 
.const [41] = Class [86] 
.const [42] = NameAndType [87] [88] 
.const [43] = Utf8 'Illegal folder ID: %1' 
.const [44] = Utf8 'Unknown folderEntry.getFolderType() = ' 
.const [45] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [48] = Utf8 java/lang/String 
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
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Utf8 java/lang/IllegalArgumentException 
.const [76] = Utf8 java/lang/StringBuffer 
.const [77] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [78] = Utf8 mapToHmiFolderType 
.const [79] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;)I 
.const [80] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [81] = Utf8 isStandardFolder 
.const [82] = Utf8 (I)Z 
.const [83] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [84] = Utf8 isPredefinedFolderId 
.const [85] = Utf8 (I)Z 
.const [86] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [87] = Utf8 mapToHmiFolderType 
.const [88] = Utf8 (I)I 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 append 
.const [91] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 toString 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 append 
.const [100] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [101] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [102] = Utf8 getFolderType 
.const [103] = Utf8 ()I 
.const [104] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [105] = Utf8 getFolderID 
.const [106] = Utf8 ()I 
.const [107] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [108] = Utf8 getFolderName 
.const [109] = Utf8 ()Ljava/lang/String; 
.const [110] = Utf8 java/lang/String 
.const [111] = Utf8 equals 
.const [112] = Utf8 (Ljava/lang/Object;)Z 
.const [113] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [114] = Utf8 getParentFolderID 
.const [115] = Utf8 ()I 
.const [116] = Utf8 org/dsi/ifc/messaging/FolderEntry 
.const [117] = Utf8 getUnreadMessageCount 
.const [118] = Utf8 ()I 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 java/lang/IllegalArgumentException 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Ljava/lang/String;)V 
.const [128] = Utf8 de/audi/app/messaging/core/folderbrowsing/Folders 
.const [129] = Class [128] 
.const [130] = Utf8 java/lang/Object 
.const [131] = Class [130] 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 isPredefinedFolderId 
.const [136] = Utf8 (I)Z 
.const [137] = Utf8 isOutboundFolder 
.const [138] = Utf8 (I)Z 
.const [139] = Utf8 isStandardFolder 
.const [140] = Utf8 (I)Z 
.const [141] = Utf8 isFolderTypeEqual 
.const [142] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;I)Z 
.const [143] = Utf8 mapToHmiFolderType 
.const [144] = Utf8 (I)I 
.const [145] = Utf8 mapToHmiFolderType 
.const [146] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;)I 
.const [147] = Utf8 equals 
.const [148] = Utf8 (Lorg/dsi/ifc/messaging/FolderEntry;Lorg/dsi/ifc/messaging/FolderEntry;)Z 
.end class 
