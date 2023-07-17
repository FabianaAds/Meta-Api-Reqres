package entity;

public class ClientHttp {

    public String urlAPICreateUser() {
        String baseURL = "https://reqres.in/api/users";
        return baseURL;
    }

    public String urlAPIListSingleUser() {

        String baseURL = "https://reqres.in/api/users/2";
        return baseURL;


    }
    public String urlListUsers(){
        String baseURL = "https://reqres.in/api/users?page=2";
        return  baseURL;
    }

    public String urlUpDateUser(){

        String baseURL = "https://reqres.in/api/users/2";
        return baseURL;
    }
}
