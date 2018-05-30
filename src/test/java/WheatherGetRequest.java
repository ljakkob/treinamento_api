import com.jayway.restassured.response.Response;
import net.minidev.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.http.ContentType.JSON;

public class WheatherGetRequest {


    //simple get request for getting wheather request
    @Test
    public void Test_01() {

        Response resp = when().
                get("http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22");

        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.statusCode(), 200);

    }

    //how to use parameters with rest assured
    @Test
    public void Test_02() {

        Response resp = given().
                param("q", "London").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");

        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.statusCode(), 200);

        if (resp.getStatusCode() == 200) {
            System.out.println("API is working fine");
        }

        else{
             System.out.println("API is not working fine");
            }
        }


    //Asset our testcase in Rest assured API

    @Test
    public void Test_03() {

                given().
                param("q", "London").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather").
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void Test_04() {

        Response resp = given().
                param("q", "London").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");

                    System.out.println(resp.asString());

    }

    @Test
    public void Test_05(){

        Response resp = given().
                param("id","2172797").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().get("http://samples.openweathermap.org/data/2.5/weather");

                Assert.assertEquals(resp.getStatusCode(),200);
                System.out.println(resp.asString());


    }

    @Test
    public void Test_06(){

                Response resp = given().
                param("id","2172797").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().get("http://samples.openweathermap.org/data/2.5/weather");

                Assert.assertEquals(resp.getStatusCode(),200);
                System.out.println(resp.asString());
    }

    @Test
    public void Test_07(){

        Response resp = given().
                param("id","2172797").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().get("http://samples.openweathermap.org/data/2.5/weather");

        Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println(resp.asString());
    }
    @Test
    public void Test_08(){

        Response resp = given().
                param("id","2172797").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().get("http://samples.openweathermap.org/data/2.5/weather");

        Assert.assertEquals(resp.getStatusCode(),200);
        System.out.println(resp.asString());
    }

    @Test
    public void Test_09() throws IOException {
        String jsonObject = new String();
        String cpf = new String();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://geradorapp.com/api/v1/cpf/generate?token=ea5445d8bd5e4cdd246a0886bb504eb6")
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "0bfecc82-9357-4f8c-b651-8aaa33157967")
                .build();

                //System.out.println(request.toString());

                //okhttp3.Response resp = client.newCall(request).execute();
                okhttp3.Response response = client.newCall(request).execute();

                //jsonObject = x
                //cpf = response.body(data.number).string();
                //System.out.println(cpf);

                Assert.assertEquals(response.code(),200);
                //sSystem.out.println(response.body().string());

        }

    @Test
    public void Test_10() {
        String weatherReport =  given().
                                param("id", "2172797").
                                param("appid", "b6907d289e10d714a6e88b30761fae22").
                                when().
                                get("http://samples.openweathermap.org/data/2.5/weather").
                                then().
                                contentType(JSON).
                                extract().
                                path("weather[0].description");

                                System.out.println("weather report "+ weatherReport);
        }

    @Test
    public void geraCpf() {
        String cpfGenerator =  given().
                header("Cache-Control", "no-cache").
                when().
                get("http://geradorapp.com/api/v1/cpf/generate?token=ea5445d8bd5e4cdd246a0886bb504eb6").
                then().
                contentType(JSON).
                extract().
                path("data.number");
                System.out.println("CPF: "+ cpfGenerator);

    }

    @Test
    public void geraToken() {

                 JSONObject requestGuardian = new JSONObject();
                 requestGuardian.put("login", "jerffeson.goncalves@wexinc.com.br");
                 requestGuardian.put("password", "wex.123");
                 Response respToken = given().
                 body(requestGuardian.toJSONString()).
                 when().
                 contentType(JSON).
                 post("http://10.1.72.25:8890/guardian/api/login");

                 System.out.println("Token: "+ respToken.jsonPath().get("token"));
    }
                //testando GIT
    }

