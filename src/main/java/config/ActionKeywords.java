package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import executionEngine.DriverScript;

public class ActionKeywords {
	private static final Logger logger = LogManager.getLogger(ActionKeywords.class.getName());

	public void wuXing (String BZ) {
		try {
			switch (BZ) {
			case "jia":
				DriverScript.WX="yang wood";
				break;
			case "yi":
				DriverScript.WX="yin wood";
				break;
			case "bing":
				DriverScript.WX="yang fire";
				break;
			case "ding":
				DriverScript.WX="yin fire";
				break;
			case "wu4":
				DriverScript.WX="yang earth";
				break;
			case "ji":
				DriverScript.WX="yin earth";
				break;
			case "geng":
				DriverScript.WX="yang metal";
				break;
			case "xin":
				DriverScript.WX="yin metal";
				break;
			case "ren":
				DriverScript.WX="yang water";
				break;
			case "gui":
				DriverScript.WX="yin water";
				break;
				
			case "yin":
				DriverScript.WX="yang wood";
				break;
			case "mao":
				DriverScript.WX="yin wood";
				break;
			case "wu":
				DriverScript.WX="yang fire";
				break;
			case "si":
				DriverScript.WX="yin fire";
				break;
			case "chen":
				DriverScript.WX="yang earth";
				break;
			case "wei":
				DriverScript.WX="yin earth";
				break;
			case "xu":
				DriverScript.WX="yang earth";
				break;
			case "chou":
				DriverScript.WX="yin earth";
				break;
			case "shen":
				DriverScript.WX="yang metal";
				break;
			case "you":
				DriverScript.WX="yin metal";
				break;
			case "zi":
				DriverScript.WX="yang water";
				break;
			case "hai":
				DriverScript.WX="yin water";
				break;
				
			default:
				break;
			}
		} catch (Exception e) {
			logger.error(" * ActionKeywords|wuXing. Exception Message - " + e.getMessage());
		}
	}
}
