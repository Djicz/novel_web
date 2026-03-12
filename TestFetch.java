public class TestFetch {
    public static void main(String[] args) throws Exception {
        try {
            java.net.URL url = new java.net.URL("http://localhost:8080/");
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
            String inputLine;
            int counter = 0;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("chat-messages") || inputLine.contains("chat-widget")
                        || inputLine.contains("topReaders") || inputLine.contains("Bảng Xếp Hạng")
                        || inputLine.contains("form")) {
                    System.out.println("LINE: " + inputLine);
                }
                counter++;
            }
            in.close();
            System.out.println("TOTAL LINES: " + counter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
