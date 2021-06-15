package ar.edu.unlam.tallerweb1.converter;

import ar.edu.unlam.tallerweb1.interfaces.RepositorioTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StringAServicioConvertidor implements Converter<String, List<Servicio>> {

    private final RepositorioTurno repositorioTurno;

    @Autowired
    public StringAServicioConvertidor(RepositorioTurno repositorioTurno) {
        this.repositorioTurno = repositorioTurno;
    }

    @Override
    public List<Servicio> convert(String datos) {
        String[] idsServicios = datos.split(",");
        List<Servicio> servicios = new ArrayList<>();

        for (String idsServicio : idsServicios) {
            Optional<Servicio> itemBuscado = repositorioTurno.findServicioById(idsServicio);
            itemBuscado.ifPresent(servicios::add);
        }

        return servicios;
    }
}
