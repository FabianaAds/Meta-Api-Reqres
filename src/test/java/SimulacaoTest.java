import entity.ClientHttp;
import entity.Pessoa;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static io.restassured.RestAssured.given;


public class SimulacaoTest {

    ClientHttp baseUrl = new ClientHttp();
    private Validator validator;

    @BeforeEach
    public void ValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    Pessoa pessoa = new Pessoa("Joao", "Arquiteto");

    // SIMULAÇÕES
    @Test
    @DisplayName("POST: Valida status code de uma simulação com dados requeridos.")
    public void validaSimulacaoAoCriarUmNovoUsuario() {


        given().contentType(ContentType.JSON).body(pessoa).when().post(baseUrl.urlAPICreateUser()).then().log().all().statusCode(201);
    }


    @Test
    @DisplayName("POST: Valida campos obrigatórios.")
    public void validaSimulacaoComCamposObrigatorios() {

        Set<ConstraintViolation<Pessoa>> violation = validator.validate(pessoa);
        given().contentType(ContentType.JSON).body(violation).when().post(baseUrl.urlAPICreateUser()).then().log().all().statusCode(201);

    }

    @Test
    @DisplayName("GET: Valida usuário")
    public void validaUsuario() {

        Set<ConstraintViolation<Pessoa>> violation = validator.validate(pessoa);
        given().contentType(ContentType.JSON).body(violation).when().get(baseUrl.urlAPIListSingleUser()).then().log().all().statusCode(200);


    }

    @Test
    @DisplayName("GET: Valida Lista de usuários")
    public void validaListadeUsuarios() {

        Set<ConstraintViolation<Pessoa>> violation = validator.validate(pessoa);
        given().contentType(ContentType.JSON).body(violation).when().get(baseUrl.urlListUsers()).then().log().all().statusCode(200);


    }

    @Test
    @DisplayName("PATCH: Valida UpDate de Usuário")
    public void validaUpDatedeUsuário() {

        Set<ConstraintViolation<Pessoa>> violation = validator.validate(pessoa);
        given().contentType(ContentType.JSON).body(violation).when().patch(baseUrl.urlUpDateUser()).then().log().all().statusCode(200);
    }
}