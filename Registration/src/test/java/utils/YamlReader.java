package utils;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


@SuppressWarnings("unchecked")
public class YamlReader {
	
	static String yamlFilePath;
	
	public static void setYamlFilePath(String ymlFilePath) {
		yamlFilePath = ymlFilePath;
	}

	public static String getYamlValue(String token) {

		return getValue(yamlFilePath, token);
	}

	private static String getValue(String yamlPath, String token) {
		Reader doc = null;
		try {
			doc = new FileReader(yamlPath);
		} catch (FileNotFoundException e) {
			return null;
		}
		Yaml yaml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		try {
			return getMapValue(object, token);
		} catch (Exception e) {
			return null;
		}

	}

	private static String getMapValue(Map<String, Object> object, String token) {
		// TODO: check for proper yaml token string based on presence of '.'
		String[] st = token.split("\\.");
		return parseMap(object, token).get(st[st.length - 1]).toString();
	}

	private static Map<String, Object> parseMap(Map<String, Object> object, String token) {
		if (token.contains(".")) {
			String[] st = token.split("\\.");
			object = parseMap((Map<String, Object>) object.get(st[0]), token.replace(st[0] + ".", ""));
		}
		return object;
	}



}
