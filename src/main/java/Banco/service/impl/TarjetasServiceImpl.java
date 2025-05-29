package Banco.service.impl;

import Banco.modelo.dto.TarjetasDTO;
import Banco.modelo.entity.TarjetasEntity;
import Banco.repository.TarjetaRepository;
import Banco.service.TarjetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetasServiceImpl implements TarjetasService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public List<TarjetasEntity> obtenerTodos() {
        return tarjetaRepository.findAll();
    }

    @Override
    public TarjetasEntity obtenerPorId(Long id) {
        return tarjetaRepository.findById(id).get();
    }

    @Override
    public TarjetasEntity crear(TarjetasDTO dto) {
        TarjetasEntity tarjeta = new TarjetasEntity();
        return tarjeta;
    }

    @Override
    public TarjetasEntity actualizar(Long id, TarjetasDTO dto) {
        TarjetasEntity tarjeta = obtenerPorId(id);
        return tarjeta;
    }

    @Override
    public void eliminar(Long id) {

    }
}