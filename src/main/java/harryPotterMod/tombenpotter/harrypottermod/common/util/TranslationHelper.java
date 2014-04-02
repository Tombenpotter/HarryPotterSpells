package harryPotterMod.tombenpotter.harrypottermod.common.util;

import harryPotterMod.tombenpotter.harrypottermod.common.HarryPotterMod;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TranslationHelper {
	
	/**
     * Base Prefix
     */
    public static final String BASE_KEY                = "strings." + HarryPotterMod.modid + ":";
	
    public static final String DEFAULT_WAND       = BASE_KEY + "default_wand";
    
	/**
     * Simple Wrapper
     * 
     * @param key
     *            Translation Key
     * @param params
     *            Additional Params
     * @return Translated string
     */
    public static String translate(String key, Object... params) {
        return StatCollector.translateToLocalFormatted(key, params);
    }
}
