package org.vaadin.example;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello anonymous user";
        } else {
            return "Hello " + name;
        }
    }

    public ArrayList<CaracterSW> getCaracterSWList(String type) throws URISyntaxException, IOException, InterruptedException {

        API api = new API();
        String resultadoAPI = api.getCharacterSWList(type);
        Gson gson = new Gson();
        ListaCaracteresSW lista = gson.fromJson(resultadoAPI, ListaCaracteresSW.class);
        return lista.getResults();
    }

    public String getSWAPI(String type, int id) throws URISyntaxException, IOException, InterruptedException {
        API api = new API();
        return api.getCharacterSW(type, id);
    }
}
