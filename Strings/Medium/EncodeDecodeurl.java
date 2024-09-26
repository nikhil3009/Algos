public class Codec {
    Map<String, String> map = new HashMap<>();
    Random random = new Random();
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getRandomKey();
        while (map.containsKey(key)) {
            key = getRandomKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(key);
    }

    private String getRandomKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}