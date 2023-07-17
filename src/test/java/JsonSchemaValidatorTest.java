
import entity.ClientHttp;
import entity.Pessoa;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidatorTest {



        static   ClientHttp baseUrl = new ClientHttp();
        Pessoa pessoa = new Pessoa("Fabiana Alves", "Quality Assurance Analyst");
        @Test
        @DisplayName("POST: Valida Schema ao criar um novo usuário")
            void validaSChemaAoCriarNovoUsuario(){
            given().log().all().contentType(ContentType.JSON).body(pessoa).when().post(baseUrl.urlAPICreateUser()).then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema-example.json"));

        }
    }

