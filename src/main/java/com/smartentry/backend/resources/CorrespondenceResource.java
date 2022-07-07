package com.smartentry.backend.resources;

import com.smartentry.backend.domain.Correspondence;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/correspondences")
public class CorrespondenceResource {

    @GetMapping
    public List<Correspondence> listar() {

        Correspondence corres1 = new Correspondence(1, "CARTA", "07/07/2022", "Retirado");

        Correspondence corres2 = new Correspondence(2, "PACOTE", "07/07/2022", "Aguardando retirada");

        List<Correspondence> lista = new ArrayList<>();
        lista.add(corres1);
        lista.add(corres2);

        return lista;
    }
}
