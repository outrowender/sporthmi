.version 50 0 
.class public super [98] 
.super [100] 
.field private final [101] [102] 
.field private final [103] [104] 

.method public [106] : [107] 
    .attribute [105] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [18] 
L6:     aload_0 
L7:     ldc [2] 
L9:     invokevirtual [11] 
L12:    aload_0 
L13:    aload_2 
L14:    putfield [19] 
L17:    aload_0 
L18:    aload_3 
L19:    putfield [20] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [105] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     invokevirtual [15] 
L11:    pop 
L12:    aload_0 
L13:    getfield [12] 
L16:    invokeinterface [21] 0 
L21:    astore_1 
L22:    aload_0 
L23:    getfield [13] 
L26:    aload_1 
L27:    invokevirtual [16] 
L30:    astore_2 
L31:    iconst_0 
L32:    istore_3 
L33:    iload_3 
L34:    aload_1 
L35:    arraylength 
L36:    if_icmpge L66 
L39:    aload_1 
L40:    iload_3 
L41:    aaload 
L42:    ifnull L60 
L45:    aload_0 
L46:    getfield [12] 
L49:    aload_1 
L50:    iload_3 
L51:    aaload 
L52:    aload_2 
L53:    iload_3 
L54:    laload 
L55:    invokeinterface [22] 0 
L60:    iinc 3 1 
L63:    goto L33 
L66:    aload_0 
L67:    getfield [12] 
L70:    aload_2 
L71:    invokeinterface [23] 0 
L76:    aload_0 
L77:    getfield [14] 
L80:    ldc [3] 
L82:    ldc [5] 
L84:    invokevirtual [15] 
L87:    pop 
L88:    aload_0 
L89:    invokevirtual [17] 
L92:    return 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [24] 
.const [3] = Int 14808325 
.const [4] = String [25] 
.const [5] = String [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Method [32] [33] 
.const [12] = Field [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Field [48] [49] 
.const [20] = Field [50] [51] 
.const [21] = InterfaceMethod [52] [53] 
.const [22] = InterfaceMethod [54] [55] 
.const [23] = InterfaceMethod [56] [57] 
.const [24] = Utf8 RemoveFavoriteCmd 
.const [25] = Utf8 '[RemoveFavoriteCmd.execute] command started' 
.const [26] = Utf8 '[RemoveFavoriteCmd.execute] command finished' 
.const [27] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [28] = Utf8 de/audi/tv/app/cmd/AbstractTVCommand 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Utf8 de/audi/tv/app/lists/IServiceListsResource 
.const [31] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
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
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [59] = Utf8 setName 
.const [60] = Utf8 (Ljava/lang/String;)V 
.const [61] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [62] = Utf8 serviceListsResource 
.const [63] = Utf8 Lde/audi/tv/app/lists/IServiceListsResource; 
.const [64] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [65] = Utf8 mapper 
.const [66] = Utf8 Lde/audi/tv/app/lists/StationMapper; 
.const [67] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [68] = Utf8 logger 
.const [69] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 log 
.const [72] = Utf8 (ILjava/lang/String;)Z 
.const [73] = Utf8 de/audi/tv/app/lists/StationMapper 
.const [74] = Utf8 getServicesIDs 
.const [75] = Utf8 ([Lorg/dsi/ifc/tvtuner/ServiceInfo;)[J 
.const [76] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [77] = Utf8 commandFinished 
.const [78] = Utf8 ()V 
.const [79] = Utf8 de/audi/tv/app/cmd/AbstractTVCommand 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Lde/audi/atip/log/LogChannel;I)V 
.const [82] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [83] = Utf8 serviceListsResource 
.const [84] = Utf8 Lde/audi/tv/app/lists/IServiceListsResource; 
.const [85] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [86] = Utf8 mapper 
.const [87] = Utf8 Lde/audi/tv/app/lists/StationMapper; 
.const [88] = Utf8 de/audi/tv/app/lists/IServiceListsResource 
.const [89] = Utf8 getOldFavorites 
.const [90] = Utf8 ()[Lorg/dsi/ifc/tvtuner/ServiceInfo; 
.const [91] = Utf8 de/audi/tv/app/lists/IServiceListsResource 
.const [92] = Utf8 removeFavorite 
.const [93] = Utf8 (Lorg/dsi/ifc/tvtuner/ServiceInfo;J)V 
.const [94] = Utf8 de/audi/tv/app/lists/IServiceListsResource 
.const [95] = Utf8 unmarkFavorites 
.const [96] = Utf8 ([J)V 
.const [97] = Utf8 de/audi/tv/app/cmd/lists/RemoveFavoriteCmd 
.const [98] = Class [97] 
.const [99] = Utf8 de/audi/tv/app/cmd/AbstractTVCommand 
.const [100] = Class [99] 
.const [101] = Utf8 serviceListsResource 
.const [102] = Utf8 Lde/audi/tv/app/lists/IServiceListsResource; 
.const [103] = Utf8 mapper 
.const [104] = Utf8 Lde/audi/tv/app/lists/StationMapper; 
.const [105] = Utf8 Code 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tv/app/lists/IServiceListsResource;Lde/audi/tv/app/lists/StationMapper;)V 
.const [108] = Utf8 execute 
.const [109] = Utf8 ()V 
.end class 
