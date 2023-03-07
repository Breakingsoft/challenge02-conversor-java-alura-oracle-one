// Importa las librerias de la API
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Api {
    private double divisa_value;
    private String converter_de;
    private String converter_a;

    public void CallApi(MainConverter converter) {

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"
                            + this.converter_de + "/" + this.converter_a + ".json"))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonObject = new JSONObject(httpResponse.body());
            setDivisa_value(jsonObject.getDouble(this.converter_a));

        } catch (Exception e) {
            System.out.println("Error al llamar a la API: " + e.getMessage());
            ShowMessage errorWindow = new ShowMessage(converter,"Error", "Error de conexion. Intente nuevamente.");
            errorWindow.setVisible(true);
        }
    }
    public double setDivisa_value(double divisa_value) {
        this.divisa_value = divisa_value;
        return divisa_value;
    }

    public double getDivisa_value() {
        return divisa_value;
    }

    public String getConverter_de() {
        return converter_de;
    }

    public void setConverter_de(String converter_de) {
        this.converter_de = converter_de;
    }

    public String getConverter_a() {
        return converter_a;
    }

    public void setConverter_a(String converter_a) {
        this.converter_a = converter_a;
    }
}