
    
//     public class RestTemplateExample {

//         public static void main(String[] args) throws IOException {

//             List<Map<String, Object>> listofMaps = resttemplatewithproxy();
//         }
    
//     public static List<Map<String, Object>> resttemplatewithproxy() {

//     List<Map<String, Object>> listofMaps = new ArrayList<>();
//     Map<String, Object> mapdata = new HashMap<>();

//     String msg = "Dear User, Your verification code to set/reset password is:0000 --NICSI";

//     RestTemplate restTemplate = restTemplate();

//     String URL = "https://hydgw.sms.gov.in/failsafe/MLink";

//     HttpHeaders headers = new HttpHeaders();
//     headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//     MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//     params.add("username", "eproc.auth");
//     params.add("pin", "H78eq$*Y");
//     params.add("message", msg);
//     params.add("mnumber", "919894317839");
//     params.add("signature", "TENDER");
//     params.add("dlt_entity_id", "110100001364");
//     params.add("dlt_template_id", "1107160922163147685");

//     HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);

//     ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL,
//     requestEntity, String.class);

//     // String responseBody = responseEntity.getBody();
//     // int statusCode = responseEntity.getStatusCodeValue();

//     mapdata.put("Result", responseEntity.getBody());
//     listofMaps.add(mapdata);
//     return listofMaps;

//     }

//     public static RestTemplate restTemplate() throws Exception {

//     String proxyHost = "10.246.129.250";
//     int proxyPort = 3128;

//     SSLContext sslContext = SSLContext.getInstance("SSL");
//     sslContext.init(null, new TrustManager[] { new X509TrustManager() {
//     public X509Certificate[] getAcceptedIssuers() {
//     return null;
//     }

//     public void checkClientTrusted(X509Certificate[] certs, String authType) {
//     }

//     public void checkServerTrusted(X509Certificate[] certs, String authType) {
//     }
//     } }, new java.security.SecureRandom());

//     Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost,proxyPort));

//     HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//     factory.setSslContext(sslContext);
//     factory.setProxy(proxy);

//     return new RestTemplate(factory);
//     }
// }
