// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.Map;
// import java.util.Properties;

// import org.yaml.snakeyaml.DumperOptions;
// import org.yaml.snakeyaml.Yaml;

// public class PropertiesToYaml {

//     public static void main(String[] args) {

//         Properties properties = loadPropertiesFromFile("test.properties");

//         String yamlContent = convertPropertiesToYaml(properties);

//         saveYamlToFile(yamlContent, "output-file.yaml");
//     }

//     private static Properties loadPropertiesFromFile(String filePath) {
//         Properties properties = new Properties();
//         try (InputStream input = new FileInputStream(filePath)) {
//             properties.load(input);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return properties;
//     }

//     private static String convertPropertiesToYaml(Properties properties) {
//         DumperOptions options = new DumperOptions();
//         options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

//         Yaml yaml = new Yaml(options);

//         return yaml.dump(propertiesToMap(properties));
//     }

//     private static void saveYamlToFile(String yamlContent, String filePath) {
//         try (FileOutputStream output = new FileOutputStream(filePath)) {
//             output.write(yamlContent.getBytes());
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static java.util.Map<String, Object> propertiesToMap(Properties properties) {
//         java.util.Map<String, Object> map = new java.util.HashMap<>();
//         for (String key : properties.stringPropertyNames()) {
//             // Split property key by '.' and convert to nested Map
//             String[] keys = key.split("\\.");
//             java.util.Map<String, Object> nestedMap = map;
//             for (int i = 0; i < keys.length - 1; i++) {
//                 nestedMap = (Map<String, Object>) nestedMap.computeIfAbsent(keys[i], k -> new java.util.HashMap<>());
//             }
//             nestedMap.put(keys[keys.length - 1], properties.getProperty(key));
//         }
//         return map;
//     }

// }
