package uz.qodirov.services.column;

import uz.qodirov.criterias.ColumnCriteria;
import uz.qodirov.dtos.column.ColumnCreateDto;
import uz.qodirov.dtos.column.ColumnDto;
import uz.qodirov.dtos.column.ColumnUpdateDto;
import uz.qodirov.repository.column.ColumnRepository;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;
import uz.qodirov.services.AbstractService;
import uz.qodirov.services.GenericCrudService;
import uz.qodirov.services.GenericService;

import java.util.List;


public class ColumnService extends AbstractService<ColumnRepository>
implements GenericCrudService<ColumnDto, ColumnCreateDto, ColumnUpdateDto,Long>, GenericService<ColumnDto, ColumnCriteria> {


    public ColumnService(ColumnRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(ColumnCreateDto dto) {
        return new ResponseEntity<>(new Data<>(repository.create(dto)));
    }

    @Override
    public ResponseEntity<Data<ColumnDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<ColumnDto>>> list(ColumnCriteria criteria) {
        return null;
    }
}
