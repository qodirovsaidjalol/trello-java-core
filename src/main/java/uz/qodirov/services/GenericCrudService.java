package uz.qodirov.services;

import uz.qodirov.dtos.GenericBaseDto;
import uz.qodirov.dtos.GenericDto;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;

import java.io.Serializable;

public interface GenericCrudService<
        D extends GenericDto,
        CD extends GenericBaseDto,
        UD extends GenericDto,
        K extends Serializable> {

    ResponseEntity<Data<K>> create(CD dto);

    ResponseEntity<Data<D>> get(K id);

    ResponseEntity<Data<Boolean>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K id);

}
