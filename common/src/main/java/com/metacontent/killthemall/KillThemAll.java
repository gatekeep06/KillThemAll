package com.metacontent.killthemall;

import com.metacontent.killthemall.config.KTAConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KillThemAll {
	public static final String ID = "killthemall";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);
	public static final String CONFIG_PATH = "config/" + ID + ".json";
	public static final KTAConfig CONFIG = KTAConfig.init();

	public static void init() {
		
	}
}
