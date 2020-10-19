package resttemp.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import resttemp.entity.User;

import java.util.List;

public class RestCllent {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://91.241.64.178:7081/api/users";

        ResponseEntity<User []> response = restTemplate.getForEntity(fooResourceUrl, User[].class);
        String setCookie = response.getHeaders().toString().substring(13,56);
        System.out.println(response.getHeaders());
        System.out.println(setCookie);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", setCookie);

        HttpEntity<User> request1 = new HttpEntity<>(new User(3L, "James","Brown", (byte) 35), headers);
        ResponseEntity<String> responseTwo =
                restTemplate.exchange(fooResourceUrl, HttpMethod.POST, request1, String.class);
        System.out.println(responseTwo);

        //jsakdjf


        User updatedInstance = new User(3L, "Thomas","Shelby", (byte) 35);
        HttpEntity<User> request2 = new HttpEntity<>(updatedInstance,headers);
        ResponseEntity<String> responseThree = restTemplate.exchange(fooResourceUrl, HttpMethod.PUT, request2, String.class);
        System.out.println(responseThree);


        HttpEntity request3 = new HttpEntity<>(headers);
        String entityUrl = fooResourceUrl + "/3";
        ResponseEntity<String> responseFour = restTemplate.exchange(entityUrl, HttpMethod.DELETE, request3, String.class);
        System.out.println(responseFour);


        





    }

}
