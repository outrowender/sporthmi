.version 50 0 
.class public super [95] 
.super [97] 

.method public annotation [99] : [100] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [101] : [102] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L17 
L4:     aload_0 
L5:     invokevirtual [14] 
L8:     arraylength 
L9:     iconst_1 
L10:    if_icmpne L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [103] : [104] 
    .attribute [98] .code stack 6 locals 1 
L0:     aload_0 
L1:     aconst_null 
L2:     invokestatic [2] 
L5:     astore_2 
L6:     aload_2 
L7:     new [21] 
L10:    dup 
L11:    aload_1 
L12:    aload_2 
L13:    invokevirtual [14] 
L16:    iconst_0 
L17:    aaload 
L18:    invokevirtual [15] 
L21:    iconst_2 
L22:    invokespecial [20] 
L25:    iconst_0 
L26:    invokestatic [4] 
L29:    aload_2 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [105] : [106] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L75 
L4:     aload_0 
L5:     invokevirtual [14] 
L8:     ifnull L75 
L11:    aload_0 
L12:    invokevirtual [14] 
L15:    arraylength 
L16:    iconst_2 
L17:    if_icmpne L64 
L20:    aload_0 
L21:    invokevirtual [14] 
L24:    iconst_0 
L25:    aaload 
L26:    ifnull L64 
L29:    aload_0 
L30:    invokevirtual [14] 
L33:    iconst_1 
L34:    aaload 
L35:    ifnull L64 
L38:    aload_0 
L39:    invokevirtual [14] 
L42:    iconst_0 
L43:    aaload 
L44:    invokevirtual [16] 
L47:    iconst_2 
L48:    if_icmpne L64 
L51:    aload_0 
L52:    invokevirtual [14] 
L55:    iconst_1 
L56:    aaload 
L57:    invokevirtual [16] 
L60:    iconst_1 
L61:    if_icmpeq L71 
L64:    aload_0 
L65:    invokestatic [5] 
L68:    ifeq L75 
L71:    iconst_1 
L72:    goto L76 
L75:    iconst_0 
L76:    areturn 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private static [107] : [108] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L90 
L4:     aload_0 
L5:     invokevirtual [14] 
L8:     ifnull L90 
L11:    aload_0 
L12:    invokevirtual [14] 
L15:    arraylength 
L16:    iconst_3 
L17:    if_icmpne L90 
L20:    aload_0 
L21:    invokevirtual [14] 
L24:    iconst_0 
L25:    aaload 
L26:    ifnull L90 
L29:    aload_0 
L30:    invokevirtual [14] 
L33:    iconst_1 
L34:    aaload 
L35:    ifnull L90 
L38:    aload_0 
L39:    invokevirtual [14] 
L42:    iconst_2 
L43:    aaload 
L44:    ifnull L90 
L47:    aload_0 
L48:    invokevirtual [14] 
L51:    iconst_0 
L52:    aaload 
L53:    invokevirtual [16] 
L56:    iconst_1 
L57:    if_icmpne L90 
L60:    aload_0 
L61:    invokevirtual [14] 
L64:    iconst_1 
L65:    aaload 
L66:    invokevirtual [16] 
L69:    iconst_2 
L70:    if_icmpne L90 
L73:    aload_0 
L74:    invokevirtual [14] 
L77:    iconst_2 
L78:    aaload 
L79:    invokevirtual [16] 
L82:    iconst_1 
L83:    if_icmpne L90 
L86:    iconst_1 
L87:    goto L91 
L90:    iconst_0 
L91:    areturn 
L92:    
    .end code 
.end method 

.method public static [109] : [110] 
    .attribute [98] .code stack 2 locals 0 
L0:     iload_1 
L1:     iflt L36 
L4:     iload_1 
L5:     aload_0 
L6:     invokevirtual [14] 
L9:     arraylength 
L10:    if_icmpge L36 
L13:    aload_0 
L14:    ifnull L34 
L17:    aload_0 
L18:    invokevirtual [14] 
L21:    iload_1 
L22:    aaload 
L23:    invokevirtual [16] 
L26:    iconst_2 
L27:    if_icmpne L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    iconst_0 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [111] : [112] 
    .attribute [98] .code stack 5 locals 3 
L0:     aload_0 
L1:     ifnull L63 
L4:     aload_0 
L5:     invokevirtual [14] 
L8:     ifnull L63 
L11:    iconst_0 
L12:    istore_1 
L13:    iload_1 
L14:    aload_0 
L15:    invokevirtual [14] 
L18:    arraylength 
L19:    if_icmpge L63 
L22:    aload_0 
L23:    iload_1 
L24:    invokestatic [6] 
L27:    ifeq L57 
L30:    aload_0 
L31:    iload_1 
L32:    invokestatic [7] 
L35:    aload_0 
L36:    invokevirtual [17] 
L39:    lstore_2 
L40:    lload_2 
L41:    iload_1 
L42:    i2l 
L43:    lcmp 
L44:    ifle L54 
L47:    aload_0 
L48:    lload_2 
L49:    lconst_1 
L50:    lsub 
L51:    invokevirtual [18] 
L54:    goto L13 
L57:    iinc 1 1 
L60:    goto L13 
L63:    return 
L64:    
    .end code 
.end method 

.method public static [113] : [114] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_0 
L1:     aconst_null 
L2:     invokestatic [2] 
L5:     astore_1 
L6:     aload_1 
L7:     invokestatic [8] 
L10:    aload_1 
L11:    areturn 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Class [24] 
.const [4] = Method [25] [26] 
.const [5] = Method [27] [28] 
.const [6] = Method [29] [30] 
.const [7] = Method [31] [32] 
.const [8] = Method [33] [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Class [54] 
.const [22] = Class [55] 
.const [23] = NameAndType [56] [57] 
.const [24] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [25] = Class [58] 
.const [26] = NameAndType [59] [60] 
.const [27] = Class [61] 
.const [28] = NameAndType [62] [63] 
.const [29] = Class [64] 
.const [30] = NameAndType [65] [66] 
.const [31] = Class [67] 
.const [32] = NameAndType [68] [69] 
.const [33] = Class [70] 
.const [34] = NameAndType [71] [72] 
.const [35] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 org/dsi/ifc/navigation/Route 
.const [38] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [39] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [55] = Utf8 de/audi/tghu/navi/app/util/RouteUtil 
.const [56] = Utf8 cloneRoute 
.const [57] = Utf8 (Lorg/dsi/ifc/navigation/Route;[Lorg/dsi/ifc/navigation/RouteOptions;)Lorg/dsi/ifc/navigation/Route; 
.const [58] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [59] = Utf8 addDestinationAtPosition 
.const [60] = Utf8 (Lorg/dsi/ifc/navigation/Route;Lorg/dsi/ifc/navigation/RouteDestination;I)V 
.const [61] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [62] = Utf8 isViaRouteAfterPassedStopover 
.const [63] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [65] = Utf8 isViaPoint 
.const [66] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)Z 
.const [67] = Utf8 org/dsi/ifc/navigation/util/RouteHelper 
.const [68] = Utf8 deleteDestinationAtPosition 
.const [69] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)V 
.const [70] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [71] = Utf8 removeViaFromRoute 
.const [72] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [73] = Utf8 org/dsi/ifc/navigation/Route 
.const [74] = Utf8 getRoutelist 
.const [75] = Utf8 ()[Lorg/dsi/ifc/navigation/RouteDestination; 
.const [76] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [77] = Utf8 getRouteOptions 
.const [78] = Utf8 ()[Lorg/dsi/ifc/navigation/RouteOptions; 
.const [79] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [80] = Utf8 getDestinationType 
.const [81] = Utf8 ()I 
.const [82] = Utf8 org/dsi/ifc/navigation/Route 
.const [83] = Utf8 getIndexOfCurrentDestination 
.const [84] = Utf8 ()J 
.const [85] = Utf8 org/dsi/ifc/navigation/Route 
.const [86] = Utf8 setIndexOfCurrentDestination 
.const [87] = Utf8 (J)V 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 org/dsi/ifc/navigation/RouteDestination 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lorg/dsi/ifc/global/NavLocation;[Lorg/dsi/ifc/navigation/RouteOptions;I)V 
.const [94] = Utf8 de/audi/tghu/navi/app/hierarchiclist/via/ViaRouteUtil 
.const [95] = Class [94] 
.const [96] = Utf8 java/lang/Object 
.const [97] = Class [96] 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 isRoutePreparedForVia 
.const [102] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Z 
.const [103] = Utf8 constructViaRoute 
.const [104] = Utf8 (Lorg/dsi/ifc/navigation/Route;Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/navigation/Route; 
.const [105] = Utf8 isViaRoute 
.const [106] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Z 
.const [107] = Utf8 isViaRouteAfterPassedStopover 
.const [108] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Z 
.const [109] = Utf8 isViaPoint 
.const [110] = Utf8 (Lorg/dsi/ifc/navigation/Route;I)Z 
.const [111] = Utf8 removeViaFromRoute 
.const [112] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [113] = Utf8 filterViaFromRoute 
.const [114] = Utf8 (Lorg/dsi/ifc/navigation/Route;)Lorg/dsi/ifc/navigation/Route; 
.end class 
