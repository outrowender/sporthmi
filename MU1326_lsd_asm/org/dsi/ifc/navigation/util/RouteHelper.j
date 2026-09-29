.version 50 0 
.class public super [83] 
.super [85] 

.method public annotation [87] : [88] 
    .attribute [86] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [89] : [90] 
    .attribute [86] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnonnull L11 
L7:     iload_2 
L8:     ifne L31 
L11:    aload_0 
L12:    getfield [13] 
L15:    ifnull L40 
L18:    iload_2 
L19:    iflt L31 
L22:    iload_2 
L23:    aload_0 
L24:    getfield [13] 
L27:    arraylength 
L28:    if_icmple L40 
L31:    new [19] 
L34:    dup 
L35:    iload_2 
L36:    invokespecial [17] 
L39:    athrow 
L40:    aload_0 
L41:    getfield [13] 
L44:    ifnonnull L68 
L47:    iload_2 
L48:    ifne L68 
L51:    aload_0 
L52:    iconst_1 
L53:    anewarray [3] 
L56:    dup 
L57:    iconst_0 
L58:    aload_1 
L59:    aastore 
L60:    putfield [18] 
L63:    aload_0 
L64:    invokestatic [4] 
L67:    return 
L68:    aload_0 
L69:    getfield [13] 
L72:    arraylength 
L73:    iconst_1 
L74:    iadd 
L75:    anewarray [3] 
L78:    astore_3 
L79:    aload_0 
L80:    getfield [13] 
L83:    iconst_0 
L84:    aload_3 
L85:    iconst_0 
L86:    iload_2 
L87:    invokestatic [5] 
L90:    aload_0 
L91:    getfield [13] 
L94:    iload_2 
L95:    aload_3 
L96:    iload_2 
L97:    iconst_1 
L98:    iadd 
L99:    aload_0 
L100:   getfield [13] 
L103:   arraylength 
L104:   iload_2 
L105:   isub 
L106:   invokestatic [5] 
L109:   aload_3 
L110:   iload_2 
L111:   aload_1 
L112:   aastore 
L113:   aload_0 
L114:   aload_3 
L115:   putfield [18] 
L118:   aload_0 
L119:   invokestatic [4] 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method private static [91] : [92] 
    .attribute [86] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [13] 
L11:    arraylength 
L12:    ifne L16 
L15:    return 
L16:    aload_0 
L17:    getfield [13] 
L20:    aload_0 
L21:    getfield [13] 
L24:    arraylength 
L25:    iconst_1 
L26:    isub 
L27:    aaload 
L28:    invokevirtual [14] 
L31:    iconst_2 
L32:    if_icmpne L51 
L35:    aload_0 
L36:    getfield [13] 
L39:    aload_0 
L40:    getfield [13] 
L43:    arraylength 
L44:    iconst_1 
L45:    isub 
L46:    aaload 
L47:    iconst_1 
L48:    invokevirtual [15] 
L51:    return 
L52:    
    .end code 
.end method 

.method public static [93] : [94] 
    .attribute [86] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [13] 
L11:    arraylength 
L12:    iconst_1 
L13:    if_icmpgt L17 
L16:    return 
L17:    aload_0 
L18:    iconst_1 
L19:    anewarray [3] 
L22:    dup 
L23:    iconst_0 
L24:    aload_0 
L25:    getfield [13] 
L28:    aload_0 
L29:    getfield [13] 
L32:    arraylength 
L33:    iconst_1 
L34:    isub 
L35:    aaload 
L36:    aastore 
L37:    putfield [18] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [95] : [96] 
    .attribute [86] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L20 
L7:     iload_1 
L8:     iflt L20 
L11:    iload_1 
L12:    aload_0 
L13:    getfield [13] 
L16:    arraylength 
L17:    if_icmplt L29 
L20:    new [19] 
L23:    dup 
L24:    iload_1 
L25:    invokespecial [17] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [13] 
L33:    arraylength 
L34:    iconst_1 
L35:    isub 
L36:    anewarray [3] 
L39:    astore_2 
L40:    aload_0 
L41:    getfield [13] 
L44:    iconst_0 
L45:    aload_2 
L46:    iconst_0 
L47:    iload_1 
L48:    invokestatic [5] 
L51:    aload_0 
L52:    getfield [13] 
L55:    iload_1 
L56:    iconst_1 
L57:    iadd 
L58:    aload_2 
L59:    iload_1 
L60:    aload_0 
L61:    getfield [13] 
L64:    arraylength 
L65:    iload_1 
L66:    isub 
L67:    iconst_1 
L68:    isub 
L69:    invokestatic [5] 
L72:    aload_0 
L73:    aload_2 
L74:    putfield [18] 
L77:    aload_0 
L78:    invokestatic [4] 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public static [97] : [98] 
    .attribute [86] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L20 
L7:     iload_1 
L8:     iflt L20 
L11:    iload_1 
L12:    aload_0 
L13:    getfield [13] 
L16:    arraylength 
L17:    if_icmplt L29 
L20:    new [19] 
L23:    dup 
L24:    iload_1 
L25:    invokespecial [17] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [13] 
L33:    iload_1 
L34:    aaload 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public static [99] : [100] 
    .attribute [86] .code stack 3 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     invokestatic [6] 
L5:     astore_3 
L6:     aload_0 
L7:     iload_1 
L8:     invokestatic [7] 
L11:    aload_0 
L12:    aload_3 
L13:    iload_2 
L14:    invokestatic [8] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [101] : [102] 
    .attribute [86] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L20 
L7:     iload_2 
L8:     iflt L20 
L11:    iload_2 
L12:    aload_0 
L13:    getfield [13] 
L16:    arraylength 
L17:    if_icmplt L29 
L20:    new [19] 
L23:    dup 
L24:    iload_2 
L25:    invokespecial [17] 
L28:    athrow 
L29:    aload_0 
L30:    getfield [13] 
L33:    iload_2 
L34:    aload_1 
L35:    aastore 
L36:    aload_0 
L37:    invokestatic [4] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Method [22] [23] 
.const [5] = Method [24] [25] 
.const [6] = Method [26] [27] 
.const [7] = Method [28] [29] 
.const [8] = Method [30] [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Field [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Field [46] [47] 
.const [19] = Class [48] 
.const [20] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [21] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [22] = Class [49] 
.const [23] = NameAndType [50] [51] 
.const [24] = Class [52] 
.const [25] = NameAndType [53] [54] 
.const [26] = Class [55] 
.const [27] = NameAndType [56] [57] 
.const [28] = Class [58] 
.const [29] = NameAndType [59] [60] 
.const [30] = Class [61] 
.const [31] = NameAndType [62] [63] 
.const [32] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 org/dsi/ifc/navigation/Route 
.const [35] = Utf8 java/lang/System 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [49] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [50] = Utf8 correctDestinationType 
.const [51] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [52] = Utf8 java/lang/System 
.const [53] = Utf8 arraycopy 
.const [54] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [55] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [56] = Utf8 getDestinationAtPosition 
.const [57] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)Lorg/dsi/ifc/navigation/RouteDestination; 
.const [58] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [59] = Utf8 deleteDestinationAtPosition 
.const [60] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)V 
.const [61] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [62] = Utf8 addDestinationAtPosition 
.const [63] = Utf8 (Lorg/dsi/ifc/navigation/Route;Lorg/dsi/ifc/navigation/RouteDestination;I)V 
.const [64] = Utf8 org/dsi/ifc/navigation/Route 
.const [65] = Utf8 routelist 
.const [66] = Utf8 [Lorg/dsi/ifc/navigation/RouteDestination; 
.const [67] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [68] = Utf8 getDestinationType 
.const [69] = Utf8 ()I 
.const [70] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [71] = Utf8 setDestinationType 
.const [72] = Utf8 (I)V 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 java/lang/ArrayIndexOutOfBoundsException 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (I)V 
.const [79] = Utf8 org/dsi/ifc/navigation/Route 
.const [80] = Utf8 routelist 
.const [81] = Utf8 [Lorg/dsi/ifc/navigation/RouteDestination; 
.const [82] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 Code 
.const [87] = Utf8 <init> 
.const [88] = Utf8 ()V 
.const [89] = Utf8 addDestinationAtPosition 
.const [90] = Utf8 (Lorg/dsi/ifc/navigation/Route;Lorg/dsi/ifc/navigation/RouteDestination;I)V 
.const [91] = Utf8 correctDestinationType 
.const [92] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [93] = Utf8 deleteAllStopovers 
.const [94] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [95] = Utf8 deleteDestinationAtPosition 
.const [96] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)V 
.const [97] = Utf8 getDestinationAtPosition 
.const [98] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)Lorg/dsi/ifc/navigation/RouteDestination; 
.const [99] = Utf8 moveDestination 
.const [100] = Utf8 (Lorg/dsi/ifc/navigation/Route;II)V 
.const [101] = Utf8 replaceDestinationAtPosition 
.const [102] = Utf8 (Lorg/dsi/ifc/navigation/Route;Lorg/dsi/ifc/navigation/RouteDestination;I)V 
.end class 
