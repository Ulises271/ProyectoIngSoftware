package Banco.service.impl;

import Banco.modelo.entity.CuentaEntity;
import Banco.repository.CuentaRepository;
import Banco.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository repository;

    public CuentaServiceImpl(CuentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CuentaEntity> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public CuentaEntity obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    @Override
    public CuentaEntity crear(CuentaEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CuentaEntity actualizar(Long id, CuentaEntity entity) {
        CuentaEntity existente = obtenerPorId(id);
        // Actualiza campos específicos si es necesario
        return repository.save(entity);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CuentaEntity> obtenerPorIdCliente(Long id) {
        // Si el método no es necesario, puedes lanzar una excepción por ahora
        throw new UnsupportedOperationException("Método no implementado aún");
    }


}
