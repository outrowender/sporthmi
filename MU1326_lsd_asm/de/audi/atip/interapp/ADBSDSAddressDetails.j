.version 50 0 
.class public super [61] 
.super [63] 
.field public static final [64] [65] 
.field public static final [66] [67] 
.field private [68] [69] 
.field private [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [12] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [13] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [14] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [75] : [76] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [77] : [78] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iconst_2 
L5:     if_icmpeq L23 
L8:     aload_0 
L9:     getfield [8] 
L12:    ifeq L23 
L15:    aload_0 
L16:    getfield [8] 
L19:    iconst_4 
L20:    if_icmpne L25 
L23:    iconst_0 
L24:    areturn 
L25:    iconst_1 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iconst_2 
L5:     if_icmpne L21 
L8:     aload_0 
L9:     getfield [7] 
L12:    getfield [9] 
L15:    iconst_0 
L16:    aaload 
L17:    getfield [10] 
L20:    areturn 
L21:    aload_0 
L22:    getfield [8] 
L25:    iconst_3 
L26:    if_icmpne L42 
L29:    aload_0 
L30:    getfield [7] 
L33:    getfield [9] 
L36:    iconst_1 
L37:    aaload 
L38:    getfield [10] 
L41:    areturn 
L42:    iconst_0 
L43:    newarray byte 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iconst_4 
L5:     if_icmpne L21 
L8:     aload_0 
L9:     getfield [7] 
L12:    getfield [9] 
L15:    iconst_0 
L16:    aaload 
L17:    getfield [11] 
L20:    areturn 
L21:    aload_0 
L22:    getfield [8] 
L25:    iconst_5 
L26:    if_icmpne L42 
L29:    aload_0 
L30:    getfield [7] 
L33:    getfield [9] 
L36:    iconst_1 
L37:    aaload 
L38:    getfield [11] 
L41:    areturn 
L42:    ldc [2] 
L44:    areturn 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Field [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Field [24] [25] 
.const [10] = Field [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Field [32] [33] 
.const [14] = Field [34] [35] 
.const [15] = Utf8 '' 
.const [16] = Utf8 de/audi/atip/interapp/ADBSDSAddressDetails 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 org/dsi/ifc/organizer/AdbEntry 
.const [19] = Utf8 org/dsi/ifc/organizer/AddressData 
.const [20] = Class [36] 
.const [21] = NameAndType [37] [38] 
.const [22] = Class [39] 
.const [23] = NameAndType [40] [41] 
.const [24] = Class [42] 
.const [25] = NameAndType [43] [44] 
.const [26] = Class [45] 
.const [27] = NameAndType [46] [47] 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Utf8 de/audi/atip/interapp/ADBSDSAddressDetails 
.const [37] = Utf8 adbEntry 
.const [38] = Utf8 Lorg/dsi/ifc/organizer/AdbEntry; 
.const [39] = Utf8 de/audi/atip/interapp/ADBSDSAddressDetails 
.const [40] = Utf8 addressType 
.const [41] = Utf8 I 
.const [42] = Utf8 org/dsi/ifc/organizer/AdbEntry 
.const [43] = Utf8 addressData 
.const [44] = Utf8 [Lorg/dsi/ifc/organizer/AddressData; 
.const [45] = Utf8 org/dsi/ifc/organizer/AddressData 
.const [46] = Utf8 navLocation 
.const [47] = Utf8 [B 
.const [48] = Utf8 org/dsi/ifc/organizer/AddressData 
.const [49] = Utf8 geoPosition 
.const [50] = Utf8 Ljava/lang/String; 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 <init> 
.const [53] = Utf8 ()V 
.const [54] = Utf8 de/audi/atip/interapp/ADBSDSAddressDetails 
.const [55] = Utf8 adbEntry 
.const [56] = Utf8 Lorg/dsi/ifc/organizer/AdbEntry; 
.const [57] = Utf8 de/audi/atip/interapp/ADBSDSAddressDetails 
.const [58] = Utf8 addressType 
.const [59] = Utf8 I 
.const [60] = Utf8 de/audi/atip/interapp/ADBSDSAddressDetails 
.const [61] = Class [60] 
.const [62] = Utf8 java/lang/Object 
.const [63] = Class [62] 
.const [64] = Utf8 BUSINESS 
.const [65] = Utf8 I 
.const [66] = Utf8 PRIVATE 
.const [67] = Utf8 I 
.const [68] = Utf8 adbEntry 
.const [69] = Utf8 Lorg/dsi/ifc/organizer/AdbEntry; 
.const [70] = Utf8 addressType 
.const [71] = Utf8 I 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lorg/dsi/ifc/organizer/AdbEntry;I)V 
.const [75] = Utf8 getAdbEntry 
.const [76] = Utf8 ()Lorg/dsi/ifc/organizer/AdbEntry; 
.const [77] = Utf8 getAddressType 
.const [78] = Utf8 ()I 
.const [79] = Utf8 getAddressIndex 
.const [80] = Utf8 ()I 
.const [81] = Utf8 getNavLocation 
.const [82] = Utf8 ()[B 
.const [83] = Utf8 getGeoPos 
.const [84] = Utf8 ()Ljava/lang/String; 
.end class 
