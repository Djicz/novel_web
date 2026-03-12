public class TestFetchError {
    public static void main(String[] args) throws Exception {
        try {
            java.net.URL url = new java.net.URL("http://localhost:8080/reader/1202");
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int code = con.getResponseCode();
            System.out.println("Response Code: " + code);

            java.io.InputStream stream = (code >= 400) ? con.getErrorStream() : con.getInputStream();
            if (stream != null) {
                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(stream));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
