package hps.client.gui;

public enum Colours {
    BLACK(0x000000),
    BLUE(0x0000AA),
    GREEN(0x00AA00),
    CYAN(0x00AAAA),
    RED(0xAA0000),
    PURPLE(0xAA00AA),
    ORANGE(0xFFAA00),
    LIGHTGRAY(0xAAAAAA),
    GRAY(0x555555),
    LIGHTBLUE(0x5555FF),
    LIME(0x55FF55),
    TURQUOISE(0x55FFFF),
    PINK(0xFF5555),
    MAGNETA(0xFF55FF),
    YELLOW(0xFFFF55),
    WHITE(0xFFFFFF);
    
    private int rgb;
    
    private Colours(int rgb) {
        this.rgb = rgb;
    }
    
    @Override
    public String toString() {
        return "\u00a7" + Integer.toHexString(ordinal());
    }
    
    public int toRGB() {
        return rgb;
    }
}
