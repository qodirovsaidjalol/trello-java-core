package uz.qodirov.services;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.GenericDto;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;

import java.util.List;

public interface GenericService<D extends GenericDto, C extends GenericCriteria> {

    ResponseEntity<Data<List<D>>> list(C criteria);

}
