package hps.common.util;

import hps.common.lib.ModInfo;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TranslationHelper {

	/**
	 * Base Prefix
	 */
	public static final String BASE_KEY = "strings." + ModInfo.MODID + ":";

	public static final String DEFAULT_WAND = BASE_KEY + "default_wand";

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
