

import java.<span class="q39pbqr9" id="q39pbqr9_9">net</span>.*;
import java.io.*;

<span class="q39pbqr9" id="q39pbqr9_1">public class</span> A
{
    static String user = "user";
    static String pass = "pass";
    static String param_user = "username";
    static String param_pass = "password";
    static String content = "";
    static String action = "action_url";
    static String urlName = "url_name";
    public static void main(String[] args)
    {
        try
        {
            user = URLEncoder.encode(user, "UTF-8");
            pass = URLEncoder.encode(pass, "UTF-8");
            content = "action=" + action +"&amp;" + param_user +"=" + user + "&amp;" + param_pass + "=" + pass;
            URL url = new URL(urlName);
            HttpURLConnection urlConnection = (HttpURLConnection)(url.openConnection());
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestMethod("POST");
            DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
            dataOutputStream.writeBytes(content);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String responeLine;
            StringBuilder response = new StringBuilder();
            while ((responeLine = bufferedReader.readLine()) != null)
            {
                response.append(responeLine);
            }
            System.out.println(response);
        }catch(Exception ex){ex.printStackTrace();}
    }

